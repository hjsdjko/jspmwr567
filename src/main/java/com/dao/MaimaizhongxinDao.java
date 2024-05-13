package com.dao;

import com.entity.MaimaizhongxinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.MaimaizhongxinVO;
import com.entity.view.MaimaizhongxinView;


/**
 * 买卖中心
 * 
 * @author 
 * @email 
 * @date 2021-03-18 17:30:39
 */
public interface MaimaizhongxinDao extends BaseMapper<MaimaizhongxinEntity> {
	
	List<MaimaizhongxinVO> selectListVO(@Param("ew") Wrapper<MaimaizhongxinEntity> wrapper);
	
	MaimaizhongxinVO selectVO(@Param("ew") Wrapper<MaimaizhongxinEntity> wrapper);
	
	List<MaimaizhongxinView> selectListView(@Param("ew") Wrapper<MaimaizhongxinEntity> wrapper);

	List<MaimaizhongxinView> selectListView(Pagination page,@Param("ew") Wrapper<MaimaizhongxinEntity> wrapper);
	
	MaimaizhongxinView selectView(@Param("ew") Wrapper<MaimaizhongxinEntity> wrapper);
	
}
