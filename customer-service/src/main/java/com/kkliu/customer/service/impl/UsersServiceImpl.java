/*
 * Copyright (c) 2017 customer.com All rights reserved.
 * 本软件源代码版权归----所有,未经许可不得任意复制与传播.
 */
package com.kkliu.customer.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kkliu.customer.dao.OrdersDao;
import com.kkliu.customer.dao.UsersDao;
import com.kkliu.customer.dao.base.BaseDao;
import com.kkliu.customer.domain.Orders;
import com.kkliu.customer.domain.Users;
import com.kkliu.customer.service.UsersService;
import com.kkliu.customer.service.base.BaseServiceImpl;

/**
 * UsersService 实现类
 * @author kkliu
 * @since 2017-09-11
 */
@Service("usersService")
public class UsersServiceImpl extends BaseServiceImpl<Users,Integer> implements UsersService {
	
	@Resource private UsersDao usersDao;
	@Resource private OrdersDao ordersDao;
	
	public BaseDao<Users,Integer> getDao() {
		return usersDao;
	}
	
	@Transactional(rollbackFor=Exception.class)
	public int insertEntryCreateId(Users users) {
		return super.insertEntryCreateId(users);
	}

	@Override
	public int delUser(Integer id) {
		// TODO Auto-generated method stub
		try{
		Users user =new Users();
		user.setId(id);
		user.setStatus(0);
		int i = usersDao.updateByKey(user);
		if(i>0){
			
			return ordersDao.updateOrdersStausByUserid(id);
		}
		}catch (Exception e){
			return 0;
		}
		return 1;
	}
}