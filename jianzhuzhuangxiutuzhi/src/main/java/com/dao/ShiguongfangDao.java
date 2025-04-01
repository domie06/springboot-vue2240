package com.dao;

import com.entity.ShiguongfangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ShiguongfangView;

/**
 * 施工方 Dao 接口
 *
 * @author 
 * @since 2021-04-28
 */
public interface ShiguongfangDao extends BaseMapper<ShiguongfangEntity> {

   List<ShiguongfangView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
