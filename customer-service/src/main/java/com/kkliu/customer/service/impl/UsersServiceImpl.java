/*
 * Copyright (c) 2017 customer.com All rights reserved.
 * 本软件源代码版权归----所有,未经许可不得任意复制与传播.
 */
package com.kkliu.customer.service.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.kkliu.customer.domain.Users;
import com.kkliu.customer.dao.base.BaseDao;
import com.kkliu.customer.dao.UsersDao;
import com.kkliu.customer.service.base.BaseServiceImpl;
import com.kkliu.customer.service.UsersService;

/**
 * UsersService 实现类
 * @author kkliu
 * @since 2017-09-11
 */
@Service("usersService")
public class UsersServiceImpl extends BaseServiceImpl<Users,Integer> implements UsersService {
	
	@Resource private UsersDao usersDao;
	
	public BaseDao<Users,Integer> getDao() {
		return usersDao;
	}
	
	@Transactional(rollbackFor=Exception.class)
	public int insertEntryCreateId(Users users) {
		return super.insertEntryCreateId(users);
	}
}