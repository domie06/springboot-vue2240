package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShiguongfangEntity;
import java.util.Map;

/**
 * 施工方 服务类
 * @author 
 * @since 2021-04-28
 */
public interface ShiguongfangService extends IService<ShiguongfangEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}