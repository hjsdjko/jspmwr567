package com.entity.view;

import com.entity.GoumaizhinanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 购买指南
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-03-18 17:30:39
 */
@TableName("goumaizhinan")
public class GoumaizhinanView  extends GoumaizhinanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public GoumaizhinanView(){
	}
 
 	public GoumaizhinanView(GoumaizhinanEntity goumaizhinanEntity){
 	try {
			BeanUtils.copyProperties(this, goumaizhinanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
