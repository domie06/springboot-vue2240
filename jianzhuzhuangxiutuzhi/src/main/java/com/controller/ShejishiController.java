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

import com.entity.ShejishiEntity;

import com.service.ShejishiService;
import com.entity.view.ShejishiView;

import com.utils.PageUtils;
import com.utils.R;

/**
 * 设计师
 * 后端接口
 * @author
 * @email
 * @date 2021-04-28
*/
@RestController
@Controller
@RequestMapping("/shejishi")
public class ShejishiController {
    private static final Logger logger = LoggerFactory.getLogger(ShejishiController.class);

    @Autowired
    private ShejishiService shejishiService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;



    //级联表service


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
     
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isNotEmpty(role) && "设计师".equals(role)){
            params.put("shejishiId",request.getSession().getAttribute("userId"));
        }
        params.put("orderBy","id");
        PageUtils page = shejishiService.queryPage(params);

        //字典表数据转换
        List<ShejishiView> list =(List<ShejishiView>)page.getList();
        for(ShejishiView c:list){
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
        ShejishiEntity shejishi = shejishiService.selectById(id);
        if(shejishi !=null){
            //entity转view
            ShejishiView view = new ShejishiView();
            BeanUtils.copyProperties( shejishi , view );//把实体数据重构到view中

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
    public R save(@RequestBody ShejishiEntity shejishi, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,shejishi:{}",this.getClass().getName(),shejishi.toString());
        Wrapper<ShejishiEntity> queryWrapper = new EntityWrapper<ShejishiEntity>()
            .eq("username", shejishi.getUsername())
            .eq("password", shejishi.getPassword())
            .eq("shejishi_name", shejishi.getShejishiName())
            .eq("sex_types", shejishi.getSexTypes())
            .eq("shejishi_id_number", shejishi.getShejishiIdNumber())
            .eq("shejishi_phone", shejishi.getShejishiPhone())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShejishiEntity shejishiEntity = shejishiService.selectOne(queryWrapper);
        if(shejishiEntity==null){
            shejishi.setCreateTime(new Date());
            shejishi.setPassword("123456");
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      shejishi.set
        //  }
            shejishiService.insert(shejishi);
            return R.ok();
        }else {
            return R.error(511,"账户或者身份证号或者手机号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ShejishiEntity shejishi, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,shejishi:{}",this.getClass().getName(),shejishi.toString());
        //根据字段查询是否有相同数据
        Wrapper<ShejishiEntity> queryWrapper = new EntityWrapper<ShejishiEntity>()
            .notIn("id",shejishi.getId())
            .andNew()
            .eq("username", shejishi.getUsername())
            .eq("password", shejishi.getPassword())
            .eq("shejishi_name", shejishi.getShejishiName())
            .eq("sex_types", shejishi.getSexTypes())
            .eq("shejishi_id_number", shejishi.getShejishiIdNumber())
            .eq("shejishi_phone", shejishi.getShejishiPhone())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShejishiEntity shejishiEntity = shejishiService.selectOne(queryWrapper);
        if("".equals(shejishi.getShejishiPhoto()) || "null".equals(shejishi.getShejishiPhoto())){
                shejishi.setShejishiPhoto(null);
        }
        if(shejishiEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      shejishi.set
            //  }
            shejishiService.updateById(shejishi);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"账户或者身份证号或者手机号已经被使用");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        shejishiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        ShejishiEntity shejishi = shejishiService.selectOne(new EntityWrapper<ShejishiEntity>().eq("username", username));
        if(shejishi==null || !shejishi.getPassword().equals(password)) {
            return R.error("账号或密码不正确");
        }
        //  // 获取监听器中的字典表
        // ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        // Map<String, Map<Integer, String>> dictionaryMap= (Map<String, Map<Integer, String>>) servletContext.getAttribute("dictionaryMap");
        // Map<Integer, String> role_types = dictionaryMap.get("role_types");
        // role_types.get(yonghu.getRoleTypes());
        String token = tokenService.generateToken(shejishi.getId(),username, "shejishi", "设计师");
        R r = R.ok();
        r.put("token", token);
        r.put("role","设计师");
        r.put("username",shejishi.getShejishiName());
        r.put("tableName","shejishi");
        r.put("userId",shejishi.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody ShejishiEntity shejishi){
    //    	ValidatorUtils.validateEntity(user);
        if(shejishiService.selectOne(new EntityWrapper<ShejishiEntity>().eq("username", shejishi.getUsername()).orNew().eq("shejishi_phone",shejishi.getShejishiPhone()).orNew().eq("shejishi_id_number",shejishi.getShejishiIdNumber())) !=null) {
            return R.error("账户已存在或手机号或身份证号已经被使用");
        }
        shejishiService.insert(shejishi);
        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id){
        ShejishiEntity shejishi = new ShejishiEntity();
        shejishi.setPassword("123456");
        shejishi.setId(id);
        shejishiService.updateById(shejishi);
        return R.ok();
    }

    /**
    * 获取设计师的session设计师信息
    */
    @RequestMapping("/session")
    public R getCurrShejishi(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        ShejishiEntity shejishi = shejishiService.selectById(id);
        return R.ok().put("data", shejishi);
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }



    /**
    * 前端列表
    */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isNotEmpty(role) && "设计师".equals(role)){
            params.put("shejishiId",request.getSession().getAttribute("userId"));
        }
        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = shejishiService.queryPage(params);

        //字典表数据转换
        List<ShejishiView> list =(List<ShejishiView>)page.getList();
        for(ShejishiView c:list){
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
        ShejishiEntity shejishi = shejishiService.selectById(id);
            if(shejishi !=null){
                //entity转view
        ShejishiView view = new ShejishiView();
                BeanUtils.copyProperties( shejishi , view );//把实体数据重构到view中

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
    public R add(@RequestBody ShejishiEntity shejishi, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,shejishi:{}",this.getClass().getName(),shejishi.toString());
        Wrapper<ShejishiEntity> queryWrapper = new EntityWrapper<ShejishiEntity>()
            .eq("username", shejishi.getUsername())
            .eq("password", shejishi.getPassword())
            .eq("shejishi_name", shejishi.getShejishiName())
            .eq("sex_types", shejishi.getSexTypes())
            .eq("shejishi_id_number", shejishi.getShejishiIdNumber())
            .eq("shejishi_phone", shejishi.getShejishiPhone())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
    ShejishiEntity shejishiEntity = shejishiService.selectOne(queryWrapper);
        if(shejishiEntity==null){
            shejishi.setCreateTime(new Date());
        shejishi.setPassword("123456");
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      shejishi.set
        //  }
        shejishiService.insert(shejishi);
            return R.ok();
        }else {
            return R.error(511,"账户或者身份证号或者手机号已经被使用");
        }
    }





}

