package com.dao;

import com.entity.DingdanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.DingdanView;

/**
 * 已接订单 Dao 接口
 *
 * @author 
 * @since 2021-04-28
 */
public interface DingdanDao extends BaseMapper<DingdanEntity> {

   List<DingdanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
