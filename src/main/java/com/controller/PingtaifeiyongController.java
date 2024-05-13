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

import com.entity.PingtaifeiyongEntity;
import com.entity.view.PingtaifeiyongView;

import com.service.PingtaifeiyongService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 平台费用
 * 后端接口
 * @author 
 * @email 
 * @date 2021-03-18 17:30:39
 */
@RestController
@RequestMapping("/pingtaifeiyong")
public class PingtaifeiyongController {
    @Autowired
    private PingtaifeiyongService pingtaifeiyongService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,PingtaifeiyongEntity pingtaifeiyong, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("maijiayonghu")) {
			pingtaifeiyong.setMaijiazhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<PingtaifeiyongEntity> ew = new EntityWrapper<PingtaifeiyongEntity>();
    	PageUtils page = pingtaifeiyongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, pingtaifeiyong), params), params));
		request.setAttribute("data", page);
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,PingtaifeiyongEntity pingtaifeiyong, HttpServletRequest request){
        EntityWrapper<PingtaifeiyongEntity> ew = new EntityWrapper<PingtaifeiyongEntity>();
    	PageUtils page = pingtaifeiyongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, pingtaifeiyong), params), params));
		request.setAttribute("data", page);
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( PingtaifeiyongEntity pingtaifeiyong){
       	EntityWrapper<PingtaifeiyongEntity> ew = new EntityWrapper<PingtaifeiyongEntity>();
      	ew.allEq(MPUtil.allEQMapPre( pingtaifeiyong, "pingtaifeiyong")); 
        return R.ok().put("data", pingtaifeiyongService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(PingtaifeiyongEntity pingtaifeiyong){
        EntityWrapper< PingtaifeiyongEntity> ew = new EntityWrapper< PingtaifeiyongEntity>();
 		ew.allEq(MPUtil.allEQMapPre( pingtaifeiyong, "pingtaifeiyong")); 
		PingtaifeiyongView pingtaifeiyongView =  pingtaifeiyongService.selectView(ew);
		return R.ok("查询平台费用成功").put("data", pingtaifeiyongView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        PingtaifeiyongEntity pingtaifeiyong = pingtaifeiyongService.selectById(id);
        return R.ok().put("data", pingtaifeiyong);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        PingtaifeiyongEntity pingtaifeiyong = pingtaifeiyongService.selectById(id);
        return R.ok().put("data", pingtaifeiyong);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody PingtaifeiyongEntity pingtaifeiyong, HttpServletRequest request){
    	pingtaifeiyong.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(pingtaifeiyong);

        pingtaifeiyongService.insert(pingtaifeiyong);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody PingtaifeiyongEntity pingtaifeiyong, HttpServletRequest request){
    	pingtaifeiyong.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(pingtaifeiyong);

        pingtaifeiyongService.insert(pingtaifeiyong);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody PingtaifeiyongEntity pingtaifeiyong, HttpServletRequest request){
        //ValidatorUtils.validateEntity(pingtaifeiyong);
        pingtaifeiyongService.updateById(pingtaifeiyong);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        pingtaifeiyongService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<PingtaifeiyongEntity> wrapper = new EntityWrapper<PingtaifeiyongEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("maijiayonghu")) {
			wrapper.eq("maijiazhanghao", (String)request.getSession().getAttribute("username"));
		}

		int count = pingtaifeiyongService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	


}
