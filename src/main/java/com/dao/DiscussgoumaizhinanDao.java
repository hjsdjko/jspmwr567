package com.dao;

import com.entity.DiscussgoumaizhinanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussgoumaizhinanVO;
import com.entity.view.DiscussgoumaizhinanView;


/**
 * 购买指南评论表
 * 
 * @author 
 * @email 
 * @date 2021-03-18 17:30:39
 */
public interface DiscussgoumaizhinanDao extends BaseMapper<DiscussgoumaizhinanEntity> {
	
	List<DiscussgoumaizhinanVO> selectListVO(@Param("ew") Wrapper<DiscussgoumaizhinanEntity> wrapper);
	
	DiscussgoumaizhinanVO selectVO(@Param("ew") Wrapper<DiscussgoumaizhinanEntity> wrapper);
	
	List<DiscussgoumaizhinanView> selectListView(@Param("ew") Wrapper<DiscussgoumaizhinanEntity> wrapper);

	List<DiscussgoumaizhinanView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussgoumaizhinanEntity> wrapper);
	
	DiscussgoumaizhinanView selectView(@Param("ew") Wrapper<DiscussgoumaizhinanEntity> wrapper);
	
}
