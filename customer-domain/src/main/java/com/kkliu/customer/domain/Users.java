/*
 * Copyright (c) 2017 customer.com All rights reserved.
 * 本软件源代码版权归----所有,未经许可不得任意复制与传播.
 */
package com.kkliu.customer.domain;

import com.kkliu.customer.domain.base.BaseDomain;

/**
 * users
 * @author kkliu
 * @since 2017-09-11
 */
public class Users extends BaseDomain {
	private static final long serialVersionUID = 1L;
	private String username;
	private String telphone;
	private String sex;
	private String birthday;
	private Integer height;
	private Float waist;
	private String job;
	private String model;
	private String address;
	private String content;

	public Users(){
		//默认无参构造方法
	}

	/**
	 * 获取 姓名
	 * @return
	 */
	public String getUsername(){
		return username;
	}
	
	/**
	 * 设置 姓名
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
	 * 获取 性别
	 * @return
	 */
	public String getSex(){
		return sex;
	}
	
	/**
	 * 设置 性别
	 * @param sex
	 */
	public void setSex(String sex){
		this.sex = sex;
	}

	/**
	 * 获取 生日
	 * @return
	 */
	public String getBirthday(){
		return birthday;
	}
	
	/**
	 * 设置 生日
	 * @param birthday
	 */
	public void setBirthday(String birthday){
		this.birthday = birthday;
	}

	/**
	 * 获取 身高
	 * @return
	 */
	public Integer getHeight(){
		return height;
	}
	
	/**
	 * 设置 身高
	 * @param height
	 */
	public void setHeight(Integer height){
		this.height = height;
	}

	/**
	 * 获取 腰围
	 * @return
	 */
	public Float getWaist(){
		return waist;
	}
	
	/**
	 * 设置 腰围
	 * @param waist
	 */
	public void setWaist(Float waist){
		this.waist = waist;
	}

	/**
	 * 获取 职业
	 * @return
	 */
	public String getJob(){
		return job;
	}
	
	/**
	 * 设置 职业
	 * @param job
	 */
	public void setJob(String job){
		this.job = job;
	}

	/**
	 * 获取 型号
	 * @return
	 */
	public String getModel(){
		return model;
	}
	
	/**
	 * 设置 型号
	 * @param model
	 */
	public void setModel(String model){
		this.model = model;
	}

	/**
	 * 获取 住址
	 * @return
	 */
	public String getAddress(){
		return address;
	}
	
	/**
	 * 设置 住址
	 * @param address
	 */
	public void setAddress(String address){
		this.address = address;
	}

	/**
	 * 获取 备注
	 * @return
	 */
	public String getContent(){
		return content;
	}
	
	/**
	 * 设置 备注
	 * @param content
	 */
	public void setContent(String content){
		this.content = content;
	}
	@Override
    public String toString() {
		StringBuffer buf = new StringBuffer("Users=[");
				buf.append("id=").append(getId()).append(", ");
				buf.append("username=").append(getUsername()).append(", ");
				buf.append("telphone=").append(getTelphone()).append(", ");
				buf.append("sex=").append(getSex()).append(", ");
				buf.append("birthday=").append(getBirthday()).append(", ");
				buf.append("height=").append(getHeight()).append(", ");
				buf.append("waist=").append(getWaist()).append(", ");
				buf.append("job=").append(getJob()).append(", ");
				buf.append("model=").append(getModel()).append(", ");
				buf.append("address=").append(getAddress()).append(", ");
				buf.append("content=").append(getContent()).append(", ");
				buf.append("]");
		return buf.toString();
	}
}