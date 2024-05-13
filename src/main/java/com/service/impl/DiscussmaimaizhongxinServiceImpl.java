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


import com.dao.DiscussmaimaizhongxinDao;
import com.entity.DiscussmaimaizhongxinEntity;
import com.service.DiscussmaimaizhongxinService;
import com.entity.vo.DiscussmaimaizhongxinVO;
import com.entity.view.DiscussmaimaizhongxinView;

@Service("discussmaimaizhongxinService")
public class DiscussmaimaizhongxinServiceImpl extends ServiceImpl<DiscussmaimaizhongxinDao, DiscussmaimaizhongxinEntity> implements DiscussmaimaizhongxinService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussmaimaizhongxinEntity> page = this.selectPage(
                new Query<DiscussmaimaizhongxinEntity>(params).getPage(),
                new EntityWrapper<DiscussmaimaizhongxinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussmaimaizhongxinEntity> wrapper) {
		  Page<DiscussmaimaizhongxinView> page =new Query<DiscussmaimaizhongxinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussmaimaizhongxinVO> selectListVO(Wrapper<DiscussmaimaizhongxinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussmaimaizhongxinVO selectVO(Wrapper<DiscussmaimaizhongxinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussmaimaizhongxinView> selectListView(Wrapper<DiscussmaimaizhongxinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussmaimaizhongxinView selectView(Wrapper<DiscussmaimaizhongxinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
