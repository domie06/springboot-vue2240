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

import com.entity.ShiguongfangEntity;

import com.service.ShiguongfangService;
import com.entity.view.ShiguongfangView;

import com.utils.PageUtils;
import com.utils.R;

/**
 * 施工方
 * 后端接口
 * @author
 * @email
 * @date 2021-04-28
*/
@RestController
@Controller
@RequestMapping("/shiguongfang")
public class ShiguongfangController {
    private static final Logger logger = LoggerFactory.getLogger(ShiguongfangController.class);

    @Autowired
    private ShiguongfangService shiguongfangService;


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
        if(StringUtil.isNotEmpty(role) && "施工方".equals(role)){
            params.put("shigongfangId",request.getSession().getAttribute("userId"));
        }
        params.put("orderBy","id");
        PageUtils page = shiguongfangService.queryPage(params);

        //字典表数据转换
        List<ShiguongfangView> list =(List<ShiguongfangView>)page.getList();
        for(ShiguongfangView c:list){
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
        ShiguongfangEntity shiguongfang = shiguongfangService.selectById(id);
        if(shiguongfang !=null){
            //entity转view
            ShiguongfangView view = new ShiguongfangView();
            BeanUtils.copyProperties( shiguongfang , view );//把实体数据重构到view中

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
    public R save(@RequestBody ShiguongfangEntity shiguongfang, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,shiguongfang:{}",this.getClass().getName(),shiguongfang.toString());
        Wrapper<ShiguongfangEntity> queryWrapper = new EntityWrapper<ShiguongfangEntity>()
            .eq("username", shiguongfang.getUsername())
            .eq("password", shiguongfang.getPassword())
            .eq("shiguongfang_name", shiguongfang.getShiguongfangName())
            .eq("sex_types", shiguongfang.getSexTypes())
            .eq("shiguongfang_id_number", shiguongfang.getShiguongfangIdNumber())
            .eq("shiguongfang_phone", shiguongfang.getShiguongfangPhone())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShiguongfangEntity shiguongfangEntity = shiguongfangService.selectOne(queryWrapper);
        if(shiguongfangEntity==null){
            shiguongfang.setCreateTime(new Date());
            shiguongfang.setPassword("123456");
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      shiguongfang.set
        //  }
            shiguongfangService.insert(shiguongfang);
            return R.ok();
        }else {
            return R.error(511,"账户或者身份证号或者手机号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ShiguongfangEntity shiguongfang, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,shiguongfang:{}",this.getClass().getName(),shiguongfang.toString());
        //根据字段查询是否有相同数据
        Wrapper<ShiguongfangEntity> queryWrapper = new EntityWrapper<ShiguongfangEntity>()
            .notIn("id",shiguongfang.getId())
            .andNew()
            .eq("username", shiguongfang.getUsername())
            .eq("password", shiguongfang.getPassword())
            .eq("shiguongfang_name", shiguongfang.getShiguongfangName())
            .eq("sex_types", shiguongfang.getSexTypes())
            .eq("shiguongfang_id_number", shiguongfang.getShiguongfangIdNumber())
            .eq("shiguongfang_phone", shiguongfang.getShiguongfangPhone())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShiguongfangEntity shiguongfangEntity = shiguongfangService.selectOne(queryWrapper);
        if("".equals(shiguongfang.getShiguongfangPhoto()) || "null".equals(shiguongfang.getShiguongfangPhoto())){
                shiguongfang.setShiguongfangPhoto(null);
        }
        if(shiguongfangEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      shiguongfang.set
            //  }
            shiguongfangService.updateById(shiguongfang);//根据id更新
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
        shiguongfangService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        ShiguongfangEntity shiguongfang = shiguongfangService.selectOne(new EntityWrapper<ShiguongfangEntity>().eq("username", username));
        if(shiguongfang==null || !shiguongfang.getPassword().equals(password)) {
            return R.error("账号或密码不正确");
        }
        //  // 获取监听器中的字典表
        // ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        // Map<String, Map<Integer, String>> dictionaryMap= (Map<String, Map<Integer, String>>) servletContext.getAttribute("dictionaryMap");
        // Map<Integer, String> role_types = dictionaryMap.get("role_types");
        // role_types.get(yonghu.getRoleTypes());
        String token = tokenService.generateToken(shiguongfang.getId(),username, "shiguongfang", "施工方");
        R r = R.ok();
        r.put("token", token);
        r.put("role","施工方");
        r.put("username",shiguongfang.getShiguongfangName());
        r.put("tableName","shiguongfang");
        r.put("userId",shiguongfang.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody ShiguongfangEntity shiguongfang){
    //    	ValidatorUtils.validateEntity(user);
        if(shiguongfangService.selectOne(new EntityWrapper<ShiguongfangEntity>().eq("username", shiguongfang.getUsername()).orNew().eq("shiguongfang_phone",shiguongfang.getShiguongfangPhone()).orNew().eq("shiguongfang_id_number",shiguongfang.getShiguongfangIdNumber())) !=null) {
            return R.error("账户已存在或手机号或身份证号已经被使用");
        }
        shiguongfangService.insert(shiguongfang);
        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id){
        ShiguongfangEntity shiguongfang = new ShiguongfangEntity();
        shiguongfang.setPassword("123456");
        shiguongfang.setId(id);
        shiguongfangService.updateById(shiguongfang);
        return R.ok();
    }

    /**
    * 获取施工方的session施工方信息
    */
    @RequestMapping("/session")
    public R getCurrShiguongfang(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        ShiguongfangEntity shiguongfang = shiguongfangService.selectById(id);
        return R.ok().put("data", shiguongfang);
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
        if(StringUtil.isNotEmpty(role) && "施工方".equals(role)){
            params.put("shigongfangId",request.getSession().getAttribute("userId"));
        }
        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = shiguongfangService.queryPage(params);

        //字典表数据转换
        List<ShiguongfangView> list =(List<ShiguongfangView>)page.getList();
        for(ShiguongfangView c:list){
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
        ShiguongfangEntity shiguongfang = shiguongfangService.selectById(id);
            if(shiguongfang !=null){
                //entity转view
        ShiguongfangView view = new ShiguongfangView();
                BeanUtils.copyProperties( shiguongfang , view );//把实体数据重构到view中

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
    public R add(@RequestBody ShiguongfangEntity shiguongfang, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,shiguongfang:{}",this.getClass().getName(),shiguongfang.toString());
        Wrapper<ShiguongfangEntity> queryWrapper = new EntityWrapper<ShiguongfangEntity>()
            .eq("username", shiguongfang.getUsername())
            .eq("password", shiguongfang.getPassword())
            .eq("shiguongfang_name", shiguongfang.getShiguongfangName())
            .eq("sex_types", shiguongfang.getSexTypes())
            .eq("shiguongfang_id_number", shiguongfang.getShiguongfangIdNumber())
            .eq("shiguongfang_phone", shiguongfang.getShiguongfangPhone())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
    ShiguongfangEntity shiguongfangEntity = shiguongfangService.selectOne(queryWrapper);
        if(shiguongfangEntity==null){
            shiguongfang.setCreateTime(new Date());
        shiguongfang.setPassword("123456");
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      shiguongfang.set
        //  }
        shiguongfangService.insert(shiguongfang);
            return R.ok();
        }else {
            return R.error(511,"账户或者身份证号或者手机号已经被使用");
        }
    }





}

