/*
 * Copyright (c) 2017 customer.com All rights reserved.
 * 本软件源代码版权归----所有,未经许可不得任意复制与传播.
 */
package com.kkliu.customer.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.kkliu.customer.domain.Orders;
import com.kkliu.customer.dao.base.BaseDao;
import com.kkliu.customer.dao.OrdersDao;
import com.kkliu.customer.service.base.BaseServiceImpl;
import com.kkliu.customer.service.OrdersService;

/**
 * OrdersService 实现类
 * @author kkliu
 * @since 2017-09-11
 */
@Service("ordersService")
public class OrdersServiceImpl extends BaseServiceImpl<Orders,Integer> implements OrdersService {
	
	@Resource private OrdersDao ordersDao;
	
	public BaseDao<Orders,Integer> getDao() {
		return ordersDao;
	}
	
	
	
	
	@Transactional(rollbackFor=Exception.class)
	public int insertEntryCreateId(Orders orders) {
		return super.insertEntryCreateId(orders);
	}




	/* (non-Javadoc)
	 * @see com.kkliu.customer.service.OrdersService#userOrderlist()
	 */
	@Override
	public List<Orders> userOrderlist(int id) {
		// TODO Auto-generated method stub
		return ordersDao.userOrderlist(id);
	}
}