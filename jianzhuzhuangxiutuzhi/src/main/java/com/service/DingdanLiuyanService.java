package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DingdanLiuyanEntity;
import java.util.Map;

/**
 * 订单留言 服务类
 * @author 
 * @since 2021-04-28
 */
public interface DingdanLiuyanService extends IService<DingdanLiuyanEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}