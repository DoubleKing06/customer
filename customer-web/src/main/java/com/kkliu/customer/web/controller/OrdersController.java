/*
 * Copyright (c) 2017 customer.com All rights reserved.
 * 本软件源代码版权归----所有,未经许可不得任意复制与传播.
 */
package com.kkliu.customer.web.controller;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import com.kkliu.customer.domain.Orders;
import com.kkliu.customer.domain.Users;
import com.kkliu.customer.domain.common.Message;
import com.kkliu.customer.domain.common.Page;
import com.kkliu.customer.service.OrdersService;
import com.kkliu.customer.service.UsersService;
import com.kkliu.customer.web.CustomDateEditor;

/**
 *orders controller层
 * @author kkliu
 * @since 2017-09-11
 */
@Controller
@RequestMapping(value = "/orders")
public class OrdersController{
	private static final Logger LOGGER = LoggerFactory.getLogger(OrdersController.class);
	@Resource private OrdersService ordersService;
	@Resource private UsersService userService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder, WebRequest request) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(true));
	}
	
	/**
	 * 列表展示
	 * @param orders 实体对象
	 * @param page 分页对象
	 * @return
	 */
	@RequestMapping(method = {RequestMethod.GET,RequestMethod.POST})
	public String list(Orders orders,Page<Orders> page,Model view) throws Exception{
		try {
			view.addAttribute("orders",orders);
			view.addAttribute("page",ordersService.selectPage(orders,page));			
		} catch (Exception e) {
			LOGGER.error("失败:"+e.getMessage(),e);
			throw e;
		}finally{
		}	
		return "orders/list";
	}
	
	
	/**
	 * 列表展示
	 * @param orders 实体对象
	 * @param page 分页对象
	 * @return
	 */
	@RequestMapping(value="userOrderlist/{id}",method = {RequestMethod.GET,RequestMethod.POST})
	public String userOrderlist(@PathVariable int id,Page<Orders> page,Model view) throws Exception{
		try {
			System.out.println("---------->"+id);
			Orders orders =new Orders();
			view.addAttribute("orders",orders);
			if(id >0){
				orders.setUserid(id);
			}
			view.addAttribute("page",ordersService.selectPage(orders,page));			
		} catch (Exception e) {
			LOGGER.error("失败:"+e.getMessage(),e);
			throw e;
		}finally{
		}	
		return "orders/list";
	}
	
/*	*//**
	 * 列表展示某个用户的订单
	 * @param orders 实体对象
	 * @param page 分页对象
	 * @return
	 *//*
	@RequestMapping(value="userOrderlist/{id}",method = {RequestMethod.GET,RequestMethod.POST})
	public String userOrderlist(Integer id,Page<Orders> page,Model view) throws Exception{
		try {
			if(id != null && id > 0) {
				List<Orders> ordersList = ordersService.userOrderlist(id);
				if(ordersList == null) {
//					return toJSON(Message.failure("您要修改的数据不存在或者已被删除!"));
					return null;
				}
			view.addAttribute("ordersList",ordersList);
			Users user =new Users();
			user.setId((long)id);
			view.addAttribute("page",ordersService.selectPageForOrders(user, page));
			
			}
		} catch (Exception e) {
			LOGGER.error("失败:"+e.getMessage(),e);
			throw e;
		}finally{
		}	
		return "orders/userorderlist";
	}*/

	
	/**
	 * 响应新增(修改)页面
	 * @param id 对象编号
	 * @return
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public String edit(@PathVariable Integer id,Model view) throws Exception{
		try {
			if(id != null && id > 0) {
				Orders orders = ordersService.selectEntry(id);
				if(orders == null) {
//					return toJSON(Message.failure("您要修改的数据不存在或者已被删除!"));
					return null;
				}
				view.addAttribute("orders",orders);
			}			
		} catch (Exception e) {
			LOGGER.error("失败:"+e.getMessage(),e);
			throw e;
		}finally{
		}

		return "orders/edit";
	}
	
	/**
	 * 响应新增(修改)页面
	 * @param id 对象编号
	 * @return
	 */
	@RequestMapping(value="add/{id}",method=RequestMethod.PUT)
	public String add(@PathVariable Integer id,Model view) throws Exception{
		try {
			if(id != null && id > 0) {
				Users user =userService.selectEntry(id);
//				Orders orders = ordersService.selectEntry(id);
				if(user == null) {
//					return toJSON(Message.failure("您要修改的数据不存在或者已被删除!"));
					return null;
				}
				view.addAttribute("users",user);
			}	
		} catch (Exception e) {
			LOGGER.error("失败:"+e.getMessage(),e);
			throw e;
		}finally{
		}
		return "orders/add";
	}
	
	/**
	 * 通过编号删除对象
	 * @param id 对象编号
	 * @return
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public @ResponseBody Message del(@PathVariable Integer id,Model view) throws Exception{
    	Message msg = null;
    	try {
			int res = ordersService.deleteByKey(id);
			msg  = res > 0 ? Message.success() : Message.failure();
		} catch (Exception e) {
			LOGGER.error("失败:"+e.getMessage(),e);
			msg = Message.failure();
		}finally{
		}

		return msg;
	}
	
	/**
	 * 通过编号查看对象
	 * @param id 对象编号
	 * @return
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public String view(@PathVariable Integer id,Model view) throws Exception{
		try {
			Orders orders = ordersService.selectEntry(id);
			if(orders == null) {
				return null;
			}
			view.addAttribute("orders",orders);
		} catch (Exception e) {
			LOGGER.error("失败:"+e.getMessage(),e);
			throw e;
		}finally{
		}

		return "orders/view";
	}
	
	/**
	 * 保存方法
	 * @param orders 实体对象
	 * @return
	 */
	@RequestMapping(value="/save",method = {RequestMethod.POST,RequestMethod.GET},produces="application/json")
	public @ResponseBody Message save(Orders orders,Model view) throws Exception{
    	Message msg= null;
    	try {
    		
			int res = ordersService.saveOrUpdate(orders);
			msg  = res > 0 ? Message.success() : Message.failure();
		} catch (Exception e) {
			LOGGER.error("失败:"+e.getMessage(),e);
			msg = Message.failure();
		}finally{
		}
		return msg;
	}
	
	/**
	 * 保存方法
	 * @param user列表页面添加订单
	 * @return
	 */
	@RequestMapping(value="/addorder",method = {RequestMethod.POST,RequestMethod.GET},produces="application/json")
	public @ResponseBody Message addorder(Orders orders,Model view) throws Exception{
    	Message msg= null;
    	try {
    		Orders orderTemp = orders;
    		Date date = new Date(); 
    		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
    		String test = df.format(date).toString();
    		orderTemp.setOrdertime(test);
//    		System.out.println("------------"+orderTemp.getOrdertime());
			int res = ordersService.saveOrUpdate(orderTemp);
			msg  = res > 0 ? Message.success() : Message.failure();
		} catch (Exception e) {
			LOGGER.error("失败:"+e.getMessage(),e);
			msg = Message.failure();
		}finally{
		}
		return msg;
	}
	
}