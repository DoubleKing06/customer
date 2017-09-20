/*
 * Copyright (c) 2017 customer.com All rights reserved.
 * 本软件源代码版权归----所有,未经许可不得任意复制与传播.
 */
package com.kkliu.customer.service;

import java.util.List;

import com.kkliu.customer.domain.Orders;
import com.kkliu.customer.service.base.BaseService;

/**
 * OrdersService接口
 * @author kkliu
 * @since 2017-09-11
 */
public interface OrdersService extends BaseService<Orders,Integer> {
	
	public List<Orders> userOrderlist(int id);
	
	public int addOrder(Orders orders);
	
	public int delOrder(Integer id) throws Exception;
	
	public int updateOrdersStausByUserid(Integer  userid) throws Exception;//通过userid批量修改order状态
	
	public int modfiyOrder(Orders orders) throws Exception;
	
	
	
}