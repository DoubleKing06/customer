/*
 * Copyright (c) 2017 customer.com All rights reserved.
 * 本软件源代码版权归----所有,未经许可不得任意复制与传播.
 */
package com.kkliu.customer.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.kkliu.customer.domain.Orders;
import com.kkliu.customer.dao.base.BaseDaoImpl;
import com.kkliu.customer.dao.OrdersDao;

/**
 * OrdersDao 实现类
 * @author kkliu
 * @since 2017-09-11
 */
@Repository("ordersDao")
public class OrdersDaoImpl extends BaseDaoImpl<Orders,Integer> implements OrdersDao {
	private final static String NAMESPACE = "com.kkliu.customer.dao.OrdersDao.";
	private static final String UPDATE_ORDERS_STATUS_BY_USERID = "updateOrdersStausByUserid";
	
	//返回本DAO命名空间,并添加statement
	public String getNameSpace(String statement) {
		return NAMESPACE + statement;
	}

	/* (non-Javadoc)
	 * @see com.kkliu.customer.dao.OrdersDao#userOrderlist(int)
	 */
	@Override
	public List<Orders> userOrderlist(int id) {
		// TODO Auto-generated method stub
		return super.userOrderlist(id);
	}

	/* (non-Javadoc)
	 * @see com.kkliu.customer.dao.base.BaseDao#selectUserOrdersCount(java.lang.Object)
	 */
	@Override
	public Integer selectUserOrdersCount(Orders t) {
		// TODO Auto-generated method stub
		return super.selectEntryListCount(t);
	}

	
	public int updateOrdersStausByUserid(Integer userid) {
		
		
		
		// TODO Auto-generated method stub
		return this.update(getNameSpace(UPDATE_ORDERS_STATUS_BY_USERID), userid);
	}



		
}