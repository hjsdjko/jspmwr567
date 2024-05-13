package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussgoumaizhinanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussgoumaizhinanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussgoumaizhinanView;


/**
 * 购买指南评论表
 *
 * @author 
 * @email 
 * @date 2021-03-18 17:30:39
 */
public interface DiscussgoumaizhinanService extends IService<DiscussgoumaizhinanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussgoumaizhinanVO> selectListVO(Wrapper<DiscussgoumaizhinanEntity> wrapper);
   	
   	DiscussgoumaizhinanVO selectVO(@Param("ew") Wrapper<DiscussgoumaizhinanEntity> wrapper);
   	
   	List<DiscussgoumaizhinanView> selectListView(Wrapper<DiscussgoumaizhinanEntity> wrapper);
   	
   	DiscussgoumaizhinanView selectView(@Param("ew") Wrapper<DiscussgoumaizhinanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussgoumaizhinanEntity> wrapper);
   	
}

