package com.controller;


import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;

import com.entity.DingdanEntity;
import com.service.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;

import com.utils.StringUtil;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.TuzhiOrderEntity;

import com.entity.view.TuzhiOrderView;
import com.entity.TuzhiEntity;
import com.entity.YonghuEntity;

import com.utils.PageUtils;
import com.utils.R;

/**
 * 图纸订单
 * 后端接口
 * @author
 * @email
 * @date 2021-04-28
*/
@RestController
@Controller
@RequestMapping("/tuzhiOrder")
public class TuzhiOrderController {
    private static final Logger logger = LoggerFactory.getLogger(TuzhiOrderController.class);

    @Autowired
    private TuzhiOrderService tuzhiOrderService;

    @Autowired
    private DingdanService dingdanService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;



    //级联表service
    @Autowired
    private TuzhiService tuzhiService;
    @Autowired
    private YonghuService yonghuService;


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
        PageUtils page = tuzhiOrderService.queryPage(params);

        //字典表数据转换
        List<TuzhiOrderView> list =(List<TuzhiOrderView>)page.getList();
        for(TuzhiOrderView c:list){
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
        TuzhiOrderEntity tuzhiOrder = tuzhiOrderService.selectById(id);
        if(tuzhiOrder !=null){
            //entity转view
            TuzhiOrderView view = new TuzhiOrderView();
            BeanUtils.copyProperties( tuzhiOrder , view );//把实体数据重构到view中

            //级联表
            TuzhiEntity tuzhi = tuzhiService.selectById(tuzhiOrder.getTuzhiId());
            if(tuzhi != null){
                BeanUtils.copyProperties( tuzhi , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setTuzhiId(tuzhi.getId());
            }
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(tuzhiOrder.getYonghuId());
            if(yonghu != null){
                BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setYonghuId(yonghu.getId());
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
    public R save(@RequestBody TuzhiOrderEntity tuzhiOrder, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,tuzhiOrder:{}",this.getClass().getName(),tuzhiOrder.toString());
        tuzhiOrder.setInsertTime(new Date());
        tuzhiOrder.setCreateTime(new Date());
        tuzhiOrderService.insert(tuzhiOrder);
        return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody TuzhiOrderEntity tuzhiOrder, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,tuzhiOrder:{}",this.getClass().getName(),tuzhiOrder.toString());
        tuzhiOrderService.updateById(tuzhiOrder);//根据id更新
        return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        tuzhiOrderService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    /**
    * 删除
    */
    @RequestMapping("/jiedan")
    public R jiedan(Integer ids){
        TuzhiOrderEntity tuzhiOrder = tuzhiOrderService.selectById(ids);
        tuzhiOrder.setOrderTypes(2);
        boolean b = tuzhiOrderService.updateById(tuzhiOrder);
        if(b){
            DingdanEntity dingdan = new DingdanEntity();
            dingdan.setCreateTime(new Date());
            dingdan.setInsertTime(new Date());
            dingdan.setTuzhiId(tuzhiOrder.getTuzhiId());
            dingdan.setTuzhiOrderId(ids);
            dingdan.setYonghuId(tuzhiOrder.getYonghuId());
            boolean insert = dingdanService.insert(dingdan);
            if(insert){
                return R.ok();
            }
        }
        return R.error();
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
        PageUtils page = tuzhiOrderService.queryPage(params);

        //字典表数据转换
        List<TuzhiOrderView> list =(List<TuzhiOrderView>)page.getList();
        for(TuzhiOrderView c:list){
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
        TuzhiOrderEntity tuzhiOrder = tuzhiOrderService.selectById(id);
            if(tuzhiOrder !=null){
                //entity转view
        TuzhiOrderView view = new TuzhiOrderView();
                BeanUtils.copyProperties( tuzhiOrder , view );//把实体数据重构到view中

                //级联表
                    TuzhiEntity tuzhi = tuzhiService.selectById(tuzhiOrder.getTuzhiId());
                if(tuzhi != null){
                    BeanUtils.copyProperties( tuzhi , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setTuzhiId(tuzhi.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(tuzhiOrder.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
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
    public R add(@RequestBody TuzhiOrderEntity tuzhiOrder, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,tuzhiOrder:{}",this.getClass().getName(),tuzhiOrder.toString());
            tuzhiOrder.setCreateTime(new Date());
            tuzhiOrder.setInsertTime(new Date());
            tuzhiOrder.setOrderNumber(String.valueOf(new Date().getTime()));
            tuzhiOrder.setOrderTypes(1);
        Wrapper<TuzhiOrderEntity> queryWrapper = new EntityWrapper<TuzhiOrderEntity>()
                .eq("tuzhi_id", tuzhiOrder.getTuzhiId())
                .eq("yonghu_id", tuzhiOrder.getYonghuId());
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        TuzhiOrderEntity tuzhiOrderEntity = tuzhiOrderService.selectOne(queryWrapper);
        if(tuzhiOrderEntity!=null){
            return R.error("你已经有这个张图纸的订单了");
        }
            tuzhiOrderService.insert(tuzhiOrder);//根据id更新
            return R.ok();
    }





}

