package com.dao;

import com.entity.GoumaizhinanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.GoumaizhinanVO;
import com.entity.view.GoumaizhinanView;


/**
 * 购买指南
 * 
 * @author 
 * @email 
 * @date 2021-03-18 17:30:39
 */
public interface GoumaizhinanDao extends BaseMapper<GoumaizhinanEntity> {
	
	List<GoumaizhinanVO> selectListVO(@Param("ew") Wrapper<GoumaizhinanEntity> wrapper);
	
	GoumaizhinanVO selectVO(@Param("ew") Wrapper<GoumaizhinanEntity> wrapper);
	
	List<GoumaizhinanView> selectListView(@Param("ew") Wrapper<GoumaizhinanEntity> wrapper);

	List<GoumaizhinanView> selectListView(Pagination page,@Param("ew") Wrapper<GoumaizhinanEntity> wrapper);
	
	GoumaizhinanView selectView(@Param("ew") Wrapper<GoumaizhinanEntity> wrapper);
	
}
