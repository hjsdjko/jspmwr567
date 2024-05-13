package com.entity.view;

import com.entity.DiscussgoumaizhinanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 购买指南评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-03-18 17:30:39
 */
@TableName("discussgoumaizhinan")
public class DiscussgoumaizhinanView  extends DiscussgoumaizhinanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussgoumaizhinanView(){
	}
 
 	public DiscussgoumaizhinanView(DiscussgoumaizhinanEntity discussgoumaizhinanEntity){
 	try {
			BeanUtils.copyProperties(this, discussgoumaizhinanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
