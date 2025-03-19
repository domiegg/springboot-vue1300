package com.dao;

import com.entity.JieyongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JieyongView;

/**
 * 资产借用 Dao 接口
 *
 * @author 
 */
public interface JieyongDao extends BaseMapper<JieyongEntity> {

   List<JieyongView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
