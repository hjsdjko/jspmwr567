package com.entity.view;

import com.entity.MaimaizhongxinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 买卖中心
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-03-18 17:30:39
 */
@TableName("maimaizhongxin")
public class MaimaizhongxinView  extends MaimaizhongxinEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public MaimaizhongxinView(){
	}
 
 	public MaimaizhongxinView(MaimaizhongxinEntity maimaizhongxinEntity){
 	try {
			BeanUtils.copyProperties(this, maimaizhongxinEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
