package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.MaimaizhongxinEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.MaimaizhongxinVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.MaimaizhongxinView;


/**
 * 买卖中心
 *
 * @author 
 * @email 
 * @date 2021-03-18 17:30:39
 */
public interface MaimaizhongxinService extends IService<MaimaizhongxinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<MaimaizhongxinVO> selectListVO(Wrapper<MaimaizhongxinEntity> wrapper);
   	
   	MaimaizhongxinVO selectVO(@Param("ew") Wrapper<MaimaizhongxinEntity> wrapper);
   	
   	List<MaimaizhongxinView> selectListView(Wrapper<MaimaizhongxinEntity> wrapper);
   	
   	MaimaizhongxinView selectView(@Param("ew") Wrapper<MaimaizhongxinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<MaimaizhongxinEntity> wrapper);
   	
}

