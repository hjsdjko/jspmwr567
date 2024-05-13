package com.dao;

import com.entity.DiscussmaimaizhongxinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussmaimaizhongxinVO;
import com.entity.view.DiscussmaimaizhongxinView;


/**
 * 买卖中心评论表
 * 
 * @author 
 * @email 
 * @date 2021-03-18 17:30:39
 */
public interface DiscussmaimaizhongxinDao extends BaseMapper<DiscussmaimaizhongxinEntity> {
	
	List<DiscussmaimaizhongxinVO> selectListVO(@Param("ew") Wrapper<DiscussmaimaizhongxinEntity> wrapper);
	
	DiscussmaimaizhongxinVO selectVO(@Param("ew") Wrapper<DiscussmaimaizhongxinEntity> wrapper);
	
	List<DiscussmaimaizhongxinView> selectListView(@Param("ew") Wrapper<DiscussmaimaizhongxinEntity> wrapper);

	List<DiscussmaimaizhongxinView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussmaimaizhongxinEntity> wrapper);
	
	DiscussmaimaizhongxinView selectView(@Param("ew") Wrapper<DiscussmaimaizhongxinEntity> wrapper);
	
}
