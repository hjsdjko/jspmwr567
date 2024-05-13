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


import com.dao.MaimaizhongxinDao;
import com.entity.MaimaizhongxinEntity;
import com.service.MaimaizhongxinService;
import com.entity.vo.MaimaizhongxinVO;
import com.entity.view.MaimaizhongxinView;

@Service("maimaizhongxinService")
public class MaimaizhongxinServiceImpl extends ServiceImpl<MaimaizhongxinDao, MaimaizhongxinEntity> implements MaimaizhongxinService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<MaimaizhongxinEntity> page = this.selectPage(
                new Query<MaimaizhongxinEntity>(params).getPage(),
                new EntityWrapper<MaimaizhongxinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<MaimaizhongxinEntity> wrapper) {
		  Page<MaimaizhongxinView> page =new Query<MaimaizhongxinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<MaimaizhongxinVO> selectListVO(Wrapper<MaimaizhongxinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public MaimaizhongxinVO selectVO(Wrapper<MaimaizhongxinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<MaimaizhongxinView> selectListView(Wrapper<MaimaizhongxinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public MaimaizhongxinView selectView(Wrapper<MaimaizhongxinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
