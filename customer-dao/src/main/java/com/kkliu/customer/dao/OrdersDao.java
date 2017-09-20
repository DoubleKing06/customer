/*
 * Copyright (c) 2017 customer.com All rights reserved.
 * 本软件源代码版权归----所有,未经许可不得任意复制与传播.
 */
package com.kkliu.customer.dao;

import java.util.List;

import com.kkliu.customer.dao.base.BaseDao;
import com.kkliu.customer.domain.Orders;

/**
 * OrdersDao 接口
 * @author kkliu
 * @since 2017-09-11
 */
public interface OrdersDao extends BaseDao<Orders,Integer>{
	//自定义扩展
	public List<Orders> userOrderlist(int id);
	
	//通过userid批量修改订单状态
	public int updateOrdersStausByUserid(Integer userid);
	
}