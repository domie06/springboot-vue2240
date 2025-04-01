package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.TuzhiOrderEntity;
import java.util.Map;

/**
 * 图纸订单 服务类
 * @author 
 * @since 2021-04-28
 */
public interface TuzhiOrderService extends IService<TuzhiOrderEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}