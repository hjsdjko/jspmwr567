package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.GoumaizhinanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.GoumaizhinanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.GoumaizhinanView;


/**
 * 购买指南
 *
 * @author 
 * @email 
 * @date 2021-03-18 17:30:39
 */
public interface GoumaizhinanService extends IService<GoumaizhinanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GoumaizhinanVO> selectListVO(Wrapper<GoumaizhinanEntity> wrapper);
   	
   	GoumaizhinanVO selectVO(@Param("ew") Wrapper<GoumaizhinanEntity> wrapper);
   	
   	List<GoumaizhinanView> selectListView(Wrapper<GoumaizhinanEntity> wrapper);
   	
   	GoumaizhinanView selectView(@Param("ew") Wrapper<GoumaizhinanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<GoumaizhinanEntity> wrapper);
   	
}

