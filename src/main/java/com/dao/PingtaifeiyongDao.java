package com.dao;

import com.entity.PingtaifeiyongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.PingtaifeiyongVO;
import com.entity.view.PingtaifeiyongView;


/**
 * 平台费用
 * 
 * @author 
 * @email 
 * @date 2021-03-18 17:30:39
 */
public interface PingtaifeiyongDao extends BaseMapper<PingtaifeiyongEntity> {
	
	List<PingtaifeiyongVO> selectListVO(@Param("ew") Wrapper<PingtaifeiyongEntity> wrapper);
	
	PingtaifeiyongVO selectVO(@Param("ew") Wrapper<PingtaifeiyongEntity> wrapper);
	
	List<PingtaifeiyongView> selectListView(@Param("ew") Wrapper<PingtaifeiyongEntity> wrapper);

	List<PingtaifeiyongView> selectListView(Pagination page,@Param("ew") Wrapper<PingtaifeiyongEntity> wrapper);
	
	PingtaifeiyongView selectView(@Param("ew") Wrapper<PingtaifeiyongEntity> wrapper);
	
}
