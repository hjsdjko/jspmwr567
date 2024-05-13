package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 平台费用
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2021-03-18 17:30:39
 */
@TableName("pingtaifeiyong")
public class PingtaifeiyongEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public PingtaifeiyongEntity() {
		
	}
	
	public PingtaifeiyongEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 订单号
	 */
					
	private String dingdanhao;
	
	/**
	 * 标题
	 */
					
	private String biaoti;
	
	/**
	 * 价格
	 */
					
	private String jiage;
	
	/**
	 * 卖家账号
	 */
					
	private String maijiazhanghao;
	
	/**
	 * 添加时间
	 */
					
	private String tianjiashijian;
	
	/**
	 * 卖家姓名
	 */
					
	private String maijiaxingming;
	
	/**
	 * 卖家手机
	 */
					
	private String maijiashouji;
	
	/**
	 * 平台费用
	 */
					
	private Integer pingtaifeiyong;
	
	/**
	 * 备注
	 */
					
	private String beizhu;
	
	/**
	 * 是否支付
	 */
					
	private String ispay;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：订单号
	 */
	public void setDingdanhao(String dingdanhao) {
		this.dingdanhao = dingdanhao;
	}
	/**
	 * 获取：订单号
	 */
	public String getDingdanhao() {
		return dingdanhao;
	}
	/**
	 * 设置：标题
	 */
	public void setBiaoti(String biaoti) {
		this.biaoti = biaoti;
	}
	/**
	 * 获取：标题
	 */
	public String getBiaoti() {
		return biaoti;
	}
	/**
	 * 设置：价格
	 */
	public void setJiage(String jiage) {
		this.jiage = jiage;
	}
	/**
	 * 获取：价格
	 */
	public String getJiage() {
		return jiage;
	}
	/**
	 * 设置：卖家账号
	 */
	public void setMaijiazhanghao(String maijiazhanghao) {
		this.maijiazhanghao = maijiazhanghao;
	}
	/**
	 * 获取：卖家账号
	 */
	public String getMaijiazhanghao() {
		return maijiazhanghao;
	}
	/**
	 * 设置：添加时间
	 */
	public void setTianjiashijian(String tianjiashijian) {
		this.tianjiashijian = tianjiashijian;
	}
	/**
	 * 获取：添加时间
	 */
	public String getTianjiashijian() {
		return tianjiashijian;
	}
	/**
	 * 设置：卖家姓名
	 */
	public void setMaijiaxingming(String maijiaxingming) {
		this.maijiaxingming = maijiaxingming;
	}
	/**
	 * 获取：卖家姓名
	 */
	public String getMaijiaxingming() {
		return maijiaxingming;
	}
	/**
	 * 设置：卖家手机
	 */
	public void setMaijiashouji(String maijiashouji) {
		this.maijiashouji = maijiashouji;
	}
	/**
	 * 获取：卖家手机
	 */
	public String getMaijiashouji() {
		return maijiashouji;
	}
	/**
	 * 设置：平台费用
	 */
	public void setPingtaifeiyong(Integer pingtaifeiyong) {
		this.pingtaifeiyong = pingtaifeiyong;
	}
	/**
	 * 获取：平台费用
	 */
	public Integer getPingtaifeiyong() {
		return pingtaifeiyong;
	}
	/**
	 * 设置：备注
	 */
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
	/**
	 * 获取：备注
	 */
	public String getBeizhu() {
		return beizhu;
	}
	/**
	 * 设置：是否支付
	 */
	public void setIspay(String ispay) {
		this.ispay = ispay;
	}
	/**
	 * 获取：是否支付
	 */
	public String getIspay() {
		return ispay;
	}

}
