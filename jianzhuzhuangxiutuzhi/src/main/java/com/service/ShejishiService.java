package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShejishiEntity;
import java.util.Map;

/**
 * 设计师 服务类
 * @author 
 * @since 2021-04-28
 */
public interface ShejishiService extends IService<ShejishiEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}