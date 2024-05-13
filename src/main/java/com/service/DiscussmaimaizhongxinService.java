package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussmaimaizhongxinEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussmaimaizhongxinVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussmaimaizhongxinView;


/**
 * 买卖中心评论表
 *
 * @author 
 * @email 
 * @date 2021-03-18 17:30:39
 */
public interface DiscussmaimaizhongxinService extends IService<DiscussmaimaizhongxinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussmaimaizhongxinVO> selectListVO(Wrapper<DiscussmaimaizhongxinEntity> wrapper);
   	
   	DiscussmaimaizhongxinVO selectVO(@Param("ew") Wrapper<DiscussmaimaizhongxinEntity> wrapper);
   	
   	List<DiscussmaimaizhongxinView> selectListView(Wrapper<DiscussmaimaizhongxinEntity> wrapper);
   	
   	DiscussmaimaizhongxinView selectView(@Param("ew") Wrapper<DiscussmaimaizhongxinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussmaimaizhongxinEntity> wrapper);
   	
}

