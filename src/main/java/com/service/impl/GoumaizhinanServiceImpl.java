package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.GoumaizhinanDao;
import com.entity.GoumaizhinanEntity;
import com.service.GoumaizhinanService;
import com.entity.vo.GoumaizhinanVO;
import com.entity.view.GoumaizhinanView;

@Service("goumaizhinanService")
public class GoumaizhinanServiceImpl extends ServiceImpl<GoumaizhinanDao, GoumaizhinanEntity> implements GoumaizhinanService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GoumaizhinanEntity> page = this.selectPage(
                new Query<GoumaizhinanEntity>(params).getPage(),
                new EntityWrapper<GoumaizhinanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<GoumaizhinanEntity> wrapper) {
		  Page<GoumaizhinanView> page =new Query<GoumaizhinanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<GoumaizhinanVO> selectListVO(Wrapper<GoumaizhinanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public GoumaizhinanVO selectVO(Wrapper<GoumaizhinanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<GoumaizhinanView> selectListView(Wrapper<GoumaizhinanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GoumaizhinanView selectView(Wrapper<GoumaizhinanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
