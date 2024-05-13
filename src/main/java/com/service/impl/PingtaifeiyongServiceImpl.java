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


import com.dao.PingtaifeiyongDao;
import com.entity.PingtaifeiyongEntity;
import com.service.PingtaifeiyongService;
import com.entity.vo.PingtaifeiyongVO;
import com.entity.view.PingtaifeiyongView;

@Service("pingtaifeiyongService")
public class PingtaifeiyongServiceImpl extends ServiceImpl<PingtaifeiyongDao, PingtaifeiyongEntity> implements PingtaifeiyongService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<PingtaifeiyongEntity> page = this.selectPage(
                new Query<PingtaifeiyongEntity>(params).getPage(),
                new EntityWrapper<PingtaifeiyongEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<PingtaifeiyongEntity> wrapper) {
		  Page<PingtaifeiyongView> page =new Query<PingtaifeiyongView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<PingtaifeiyongVO> selectListVO(Wrapper<PingtaifeiyongEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public PingtaifeiyongVO selectVO(Wrapper<PingtaifeiyongEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<PingtaifeiyongView> selectListView(Wrapper<PingtaifeiyongEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public PingtaifeiyongView selectView(Wrapper<PingtaifeiyongEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
