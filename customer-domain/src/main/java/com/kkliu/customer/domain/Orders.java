/*
 * Copyright (c) 2017 customer.com All rights reserved.
 * 本软件源代码版权归----所有,未经许可不得任意复制与传播.
 */
package com.kkliu.customer.domain;

import com.kkliu.customer.domain.base.BaseDomain;

/**
 * orders
 * @author kkliu
 * @since 2017-09-11
 */
public class Orders extends BaseDomain {
	private static final long serialVersionUID = 1L;
	private Integer userid;
	private String username;
	private String telphone;
	private Float orderAmount;
	private String type;
	private String ordertime;

	public Orders(){
		//默认无参构造方法
	}

	/**
	 * 获取 用户编号
	 * @return
	 */
	public Integer getUserid(){
		return userid;
	}
	
	/**
	 * 设置 用户编号
	 * @param userid
	 */
	public void setUserid(Integer userid){
		this.userid = userid;
	}

	/**
	 * 获取 用户名
	 * @return
	 */
	public String getUsername(){
		return username;
	}
	
	/**
	 * 设置 用户名
	 * @param username
	 */
	public void setUsername(String username){
		this.username = username;
	}

	/**
	 * 获取 电话
	 * @return
	 */
	public String getTelphone(){
		return telphone;
	}
	
	/**
	 * 设置 电话
	 * @param telphone
	 */
	public void setTelphone(String telphone){
		this.telphone = telphone;
	}

	/**
	 * 获取 订单金额
	 * @return
	 */
	public Float getOrderAmount(){
		return orderAmount;
	}
	
	/**
	 * 设置 订单金额
	 * @param orderAmount
	 */
	public void setOrderAmount(Float orderAmount){
		this.orderAmount = orderAmount;
	}

	/**
	 * 获取 款式
	 * @return
	 */
	public String getType(){
		return type;
	}
	
	/**
	 * 设置 款式
	 * @param type
	 */
	public void setType(String type){
		this.type = type;
	}

	/**
	 * 获取 订单时间
	 * @return
	 */
	public String getOrdertime(){
		return ordertime;
	}
	
	/**
	 * 设置 订单时间
	 * @param ordertime
	 */
	public void setOrdertime(String ordertime){
		this.ordertime = ordertime;
	}
	@Override
    public String toString() {
		StringBuffer buf = new StringBuffer("Orders=[");
				buf.append("userid=").append(getUserid()).append(", ");
				buf.append("username=").append(getUsername()).append(", ");
				buf.append("telphone=").append(getTelphone()).append(", ");
				buf.append("id=").append(getId()).append(", ");
				buf.append("orderAmount=").append(getOrderAmount()).append(", ");
				buf.append("type=").append(getType()).append(", ");
				buf.append("ordertime=").append(getOrdertime()).append(", ");
				buf.append("]");
		return buf.toString();
	}
}