package com.dao;

import com.entity.TuzhiCollectionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.TuzhiCollectionView;

/**
 * 图纸收藏 Dao 接口
 *
 * @author 
 * @since 2021-04-28
 */
public interface TuzhiCollectionDao extends BaseMapper<TuzhiCollectionEntity> {

   List<TuzhiCollectionView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
