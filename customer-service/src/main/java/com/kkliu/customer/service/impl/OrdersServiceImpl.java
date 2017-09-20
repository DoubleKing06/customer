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
import com.kkliu.customer.domain.Users;
import com.kkliu.customer.dao.base.BaseDao;
import com.kkliu.customer.dao.OrdersDao;
import com.kkliu.customer.dao.UsersDao;
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
	@Resource private UsersDao usersDao;
	
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



	@Override
	public int addOrder(Orders orders) {
		// TODO Auto-generated method stub
		/**
		 * 插入订单信息
		 */
		ordersDao.insertEntry(orders);
		
		Users usertemp=new Users();
		//取得用户基本信息
		Users user =usersDao.selectEntry(orders.getUserid());
		//取得用户现在的消费总额
		float amountTemp = user.getTotalAmount();
		//把订单金额和用户原始消费总额相加
		amountTemp=amountTemp+orders.getOrderAmount();
		
		usertemp.setTotalAmount(amountTemp);
		usertemp.setId(orders.getUserid());
		
		//usersDao.updateByKey(usertemp);
		return usersDao.updateByKey(usertemp);//更新用户的消费总额
	}




	@Override
	public int delOrder(Integer id) throws Exception {
		try{
			Orders orderTemp=ordersDao.selectEntry(id);
			
			Orders delOrder =new Orders();
			delOrder.setId(id);
			delOrder.setStatus(0);
			
			int i =ordersDao.updateByKey(delOrder);
			
//			int i =ordersDao.deleteByKey(id);
			if(i>0){
				Users user =usersDao.selectEntry(orderTemp.getUserid());
				float amountTemp = user.getTotalAmount();
				System.out.println("======>"+amountTemp);
				//把订单金额和用户原始消费总额相减
				amountTemp=amountTemp-orderTemp.getOrderAmount();
				Users userTemp =new Users();
				userTemp.setTotalAmount(amountTemp);
				userTemp.setId(orderTemp.getUserid());
				return usersDao.updateByKey(userTemp);//更新用户的消费总额
			}else{
				throw new Exception("删除订单失败！"); 
			}
		}catch (Exception e){
			throw new Exception(e.getMessage());
			
		}
		// TODO Auto-generated method stub
	}




	@Override
	public int modfiyOrder(Orders orders) throws Exception {
		// TODO Auto-generated method stub
		try{
			Users user =usersDao.selectEntry(orders.getUserid());
			Orders orderTemp =ordersDao.selectEntry(orders.getId());
			float orderAmount =0f;
			int i = ordersDao.updateByKey(orders);
			if(i>0){
				if(orders.getOrderAmount()>orderTemp.getOrderAmount()){
					float amountTemp = user.getTotalAmount();
					//User表中totalAmount=原数据+(修改后的金额-修改前的金额)
					orderAmount=amountTemp+(orders.getOrderAmount()-orderTemp.getOrderAmount());

				}else if(orders.getOrderAmount()<orderTemp.getOrderAmount()){
					float amountTemp = user.getTotalAmount();
					//User表中totalAmount=原数据+(修改后的金额-修改前的金额)
					orderAmount=amountTemp-(orderTemp.getOrderAmount()-orders.getOrderAmount());
				}
				Users userTemp =new Users();
				userTemp.setTotalAmount(orderAmount);
				userTemp.setId(orders.getUserid());
				return usersDao.updateByKey(userTemp);
			}
		}catch (Exception e){
			throw new Exception(e);
		}
		
		return 0;
	}




	@Override
	public int updateOrdersStausByUserid(Integer userid) throws Exception {
		// TODO Auto-generated method stub
		try{
			return ordersDao.updateOrdersStausByUserid(userid);
		}catch (Exception e){
			throw new Exception(e.getMessage());
		}
		
	}
}