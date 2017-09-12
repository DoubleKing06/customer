/*
 * Copyright (c) 2017 customer.com All rights reserved.
 * 本软件源代码版权归----所有,未经许可不得任意复制与传播.
 */
package com.kkliu.customer.dao.impl;

import org.springframework.stereotype.Repository;
import com.kkliu.customer.domain.Users;
import com.kkliu.customer.dao.base.BaseDaoImpl;
import com.kkliu.customer.dao.UsersDao;

/**
 * UsersDao 实现类
 * @author kkliu
 * @since 2017-09-11
 */
@Repository("usersDao")
public class UsersDaoImpl extends BaseDaoImpl<Users,Integer> implements UsersDao {
	private final static String NAMESPACE = "com.kkliu.customer.dao.UsersDao.";
	
	//返回本DAO命名空间,并添加statement
	public String getNameSpace(String statement) {
		return NAMESPACE + statement;
	}

	/* (non-Javadoc)
	 * @see com.kkliu.customer.dao.base.BaseDao#selectUserOrdersCount(java.lang.Object)
	 */
	@Override
	public Integer selectUserOrdersCount(Users t) {
		// TODO Auto-generated method stub
		return super.selectEntryListCount(t);
	}
		
}