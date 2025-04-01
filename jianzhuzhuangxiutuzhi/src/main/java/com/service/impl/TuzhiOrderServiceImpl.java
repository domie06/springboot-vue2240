package com.service.impl;

import com.utils.StringUtil;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.util.*;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;

import com.dao.TuzhiOrderDao;
import com.entity.TuzhiOrderEntity;
import com.service.TuzhiOrderService;
import com.entity.view.TuzhiOrderView;

/**
 * 图纸订单 服务实现类
 * @author 
 * @since 2021-04-28
 */
@Service("tuzhiOrderService")
@Transactional
public class TuzhiOrderServiceImpl extends ServiceImpl<TuzhiOrderDao, TuzhiOrderEntity> implements TuzhiOrderService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<TuzhiOrderView> page =new Query<TuzhiOrderView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
