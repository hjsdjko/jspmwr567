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


import com.dao.DiscussgoumaizhinanDao;
import com.entity.DiscussgoumaizhinanEntity;
import com.service.DiscussgoumaizhinanService;
import com.entity.vo.DiscussgoumaizhinanVO;
import com.entity.view.DiscussgoumaizhinanView;

@Service("discussgoumaizhinanService")
public class DiscussgoumaizhinanServiceImpl extends ServiceImpl<DiscussgoumaizhinanDao, DiscussgoumaizhinanEntity> implements DiscussgoumaizhinanService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussgoumaizhinanEntity> page = this.selectPage(
                new Query<DiscussgoumaizhinanEntity>(params).getPage(),
                new EntityWrapper<DiscussgoumaizhinanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussgoumaizhinanEntity> wrapper) {
		  Page<DiscussgoumaizhinanView> page =new Query<DiscussgoumaizhinanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussgoumaizhinanVO> selectListVO(Wrapper<DiscussgoumaizhinanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussgoumaizhinanVO selectVO(Wrapper<DiscussgoumaizhinanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussgoumaizhinanView> selectListView(Wrapper<DiscussgoumaizhinanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussgoumaizhinanView selectView(Wrapper<DiscussgoumaizhinanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
