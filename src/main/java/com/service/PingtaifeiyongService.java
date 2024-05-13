package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.PingtaifeiyongEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.PingtaifeiyongVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.PingtaifeiyongView;


/**
 * 平台费用
 *
 * @author 
 * @email 
 * @date 2021-03-18 17:30:39
 */
public interface PingtaifeiyongService extends IService<PingtaifeiyongEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<PingtaifeiyongVO> selectListVO(Wrapper<PingtaifeiyongEntity> wrapper);
   	
   	PingtaifeiyongVO selectVO(@Param("ew") Wrapper<PingtaifeiyongEntity> wrapper);
   	
   	List<PingtaifeiyongView> selectListView(Wrapper<PingtaifeiyongEntity> wrapper);
   	
   	PingtaifeiyongView selectView(@Param("ew") Wrapper<PingtaifeiyongEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<PingtaifeiyongEntity> wrapper);
   	
}

