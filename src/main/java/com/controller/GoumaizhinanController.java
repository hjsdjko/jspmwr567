package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.GoumaizhinanEntity;
import com.entity.view.GoumaizhinanView;

import com.service.GoumaizhinanService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 购买指南
 * 后端接口
 * @author 
 * @email 
 * @date 2021-03-18 17:30:39
 */
@RestController
@RequestMapping("/goumaizhinan")
public class GoumaizhinanController {
    @Autowired
    private GoumaizhinanService goumaizhinanService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,GoumaizhinanEntity goumaizhinan, 
		HttpServletRequest request){

        EntityWrapper<GoumaizhinanEntity> ew = new EntityWrapper<GoumaizhinanEntity>();
    	PageUtils page = goumaizhinanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, goumaizhinan), params), params));
		request.setAttribute("data", page);
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,GoumaizhinanEntity goumaizhinan, HttpServletRequest request){
        EntityWrapper<GoumaizhinanEntity> ew = new EntityWrapper<GoumaizhinanEntity>();
    	PageUtils page = goumaizhinanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, goumaizhinan), params), params));
		request.setAttribute("data", page);
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( GoumaizhinanEntity goumaizhinan){
       	EntityWrapper<GoumaizhinanEntity> ew = new EntityWrapper<GoumaizhinanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( goumaizhinan, "goumaizhinan")); 
        return R.ok().put("data", goumaizhinanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(GoumaizhinanEntity goumaizhinan){
        EntityWrapper< GoumaizhinanEntity> ew = new EntityWrapper< GoumaizhinanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( goumaizhinan, "goumaizhinan")); 
		GoumaizhinanView goumaizhinanView =  goumaizhinanService.selectView(ew);
		return R.ok("查询购买指南成功").put("data", goumaizhinanView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        GoumaizhinanEntity goumaizhinan = goumaizhinanService.selectById(id);
        return R.ok().put("data", goumaizhinan);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        GoumaizhinanEntity goumaizhinan = goumaizhinanService.selectById(id);
        return R.ok().put("data", goumaizhinan);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        GoumaizhinanEntity goumaizhinan = goumaizhinanService.selectById(id);
        if(type.equals("1")) {
        	goumaizhinan.setThumbsupnum(goumaizhinan.getThumbsupnum()+1);
        } else {
        	goumaizhinan.setCrazilynum(goumaizhinan.getCrazilynum()+1);
        }
        goumaizhinanService.updateById(goumaizhinan);
        return R.ok("投票成功");
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GoumaizhinanEntity goumaizhinan, HttpServletRequest request){
    	goumaizhinan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(goumaizhinan);

        goumaizhinanService.insert(goumaizhinan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody GoumaizhinanEntity goumaizhinan, HttpServletRequest request){
    	goumaizhinan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(goumaizhinan);

        goumaizhinanService.insert(goumaizhinan);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody GoumaizhinanEntity goumaizhinan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(goumaizhinan);
        goumaizhinanService.updateById(goumaizhinan);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        goumaizhinanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<GoumaizhinanEntity> wrapper = new EntityWrapper<GoumaizhinanEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = goumaizhinanService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	


}
