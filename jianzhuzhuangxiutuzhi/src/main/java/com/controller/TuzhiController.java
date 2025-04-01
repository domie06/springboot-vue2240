package com.controller;


import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.StringUtil;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.TuzhiEntity;

import com.service.TuzhiService;
import com.entity.view.TuzhiView;
import com.service.ShejishiService;
import com.entity.ShejishiEntity;

import com.utils.PageUtils;
import com.utils.R;

/**
 * 图纸信息
 * 后端接口
 * @author
 * @email
 * @date 2021-04-28
*/
@RestController
@Controller
@RequestMapping("/tuzhi")
public class TuzhiController {
    private static final Logger logger = LoggerFactory.getLogger(TuzhiController.class);

    @Autowired
    private TuzhiService tuzhiService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;



    //级联表service
    @Autowired
    private ShejishiService shejishiService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
     
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isNotEmpty(role) && "用户".equals(role)){
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        }else if(StringUtil.isNotEmpty(role) && "施工方".equals(role)){
            params.put("shigongfangId",request.getSession().getAttribute("userId"));
        }else if(StringUtil.isNotEmpty(role) && "设计师".equals(role)){
            params.put("shejishiId",request.getSession().getAttribute("userId"));
        }
        params.put("orderBy","id");
        PageUtils page = tuzhiService.queryPage(params);

        //字典表数据转换
        List<TuzhiView> list =(List<TuzhiView>)page.getList();
        for(TuzhiView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        TuzhiEntity tuzhi = tuzhiService.selectById(id);
        if(tuzhi !=null){
            //entity转view
            TuzhiView view = new TuzhiView();
            BeanUtils.copyProperties( tuzhi , view );//把实体数据重构到view中

            //级联表
            ShejishiEntity shejishi = shejishiService.selectById(tuzhi.getShejishiId());
            if(shejishi != null){
                BeanUtils.copyProperties( shejishi , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setShejishiId(shejishi.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody TuzhiEntity tuzhi, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,tuzhi:{}",this.getClass().getName(),tuzhi.toString());
        Wrapper<TuzhiEntity> queryWrapper = new EntityWrapper<TuzhiEntity>()
            .eq("tuzhi_name", tuzhi.getTuzhiName())
            .eq("tuzhi_types", tuzhi.getTuzhiTypes())
            .eq("shejishi_id", tuzhi.getShejishiId())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        TuzhiEntity tuzhiEntity = tuzhiService.selectOne(queryWrapper);
        if(tuzhiEntity==null){
            tuzhi.setInsertTime(new Date());
            tuzhi.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      tuzhi.set
        //  }
            tuzhiService.insert(tuzhi);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody TuzhiEntity tuzhi, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,tuzhi:{}",this.getClass().getName(),tuzhi.toString());
        //根据字段查询是否有相同数据
        Wrapper<TuzhiEntity> queryWrapper = new EntityWrapper<TuzhiEntity>()
            .notIn("id",tuzhi.getId())
            .andNew()
            .eq("tuzhi_name", tuzhi.getTuzhiName())
            .eq("tuzhi_types", tuzhi.getTuzhiTypes())
            .eq("shejishi_id", tuzhi.getShejishiId())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        TuzhiEntity tuzhiEntity = tuzhiService.selectOne(queryWrapper);
        if("".equals(tuzhi.getTuzhiPhoto()) || "null".equals(tuzhi.getTuzhiPhoto())){
                tuzhi.setTuzhiPhoto(null);
        }
        if("".equals(tuzhi.getTuzhiFile()) || "null".equals(tuzhi.getTuzhiFile())){
                tuzhi.setTuzhiFile(null);
        }
        if(tuzhiEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      tuzhi.set
            //  }
            tuzhiService.updateById(tuzhi);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        tuzhiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }



    /**
    * 前端列表
    */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isNotEmpty(role) && "用户".equals(role)){
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        }else if(StringUtil.isNotEmpty(role) && "施工方".equals(role)){
            params.put("shigongfangId",request.getSession().getAttribute("userId"));
        }else if(StringUtil.isNotEmpty(role) && "设计师".equals(role)){
            params.put("shejishiId",request.getSession().getAttribute("userId"));
        }
        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = tuzhiService.queryPage(params);

        //字典表数据转换
        List<TuzhiView> list =(List<TuzhiView>)page.getList();
        for(TuzhiView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c);
        }
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        TuzhiEntity tuzhi = tuzhiService.selectById(id);
            if(tuzhi !=null){
                //entity转view
        TuzhiView view = new TuzhiView();
                BeanUtils.copyProperties( tuzhi , view );//把实体数据重构到view中

                //级联表
                    ShejishiEntity shejishi = shejishiService.selectById(tuzhi.getShejishiId());
                if(shejishi != null){
                    BeanUtils.copyProperties( shejishi , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setShejishiId(shejishi.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody TuzhiEntity tuzhi, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,tuzhi:{}",this.getClass().getName(),tuzhi.toString());
        Wrapper<TuzhiEntity> queryWrapper = new EntityWrapper<TuzhiEntity>()
            .eq("tuzhi_name", tuzhi.getTuzhiName())
            .eq("tuzhi_types", tuzhi.getTuzhiTypes())
            .eq("shejishi_id", tuzhi.getShejishiId())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
    TuzhiEntity tuzhiEntity = tuzhiService.selectOne(queryWrapper);
        if(tuzhiEntity==null){
            tuzhi.setInsertTime(new Date());
            tuzhi.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      tuzhi.set
        //  }
        tuzhiService.insert(tuzhi);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }





}

