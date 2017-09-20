/*
 * Copyright (c) 2017 customer.com All rights reserved.
 * 本软件源代码版权归----所有,未经许可不得任意复制与传播.
 */
package com.kkliu.customer.web.controller;
import java.util.Date;
import javax.annotation.Resource;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import com.kkliu.customer.web.CustomDateEditor;
import org.springframework.web.context.request.WebRequest;
import org.springframework.stereotype.Controller;
import com.kkliu.customer.domain.Users;
import com.kkliu.customer.domain.common.Message;
import com.kkliu.customer.domain.common.Page;
import com.kkliu.customer.service.UsersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *users controller层
 * @author kkliu
 * @since 2017-09-11
 */
@Controller
@RequestMapping(value = "/users")
public class UsersController{
	private static final Logger LOGGER = LoggerFactory.getLogger(UsersController.class);
	@Resource private UsersService usersService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder, WebRequest request) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(true));
	}
	
	/**
	 * 列表展示
	 * @param users 实体对象
	 * @param page 分页对象
	 * @return
	 */
	@RequestMapping(method = {RequestMethod.GET,RequestMethod.POST})
	public String list(Users users,Page<Users> page,Model view) throws Exception{
		try {
			view.addAttribute("users",users);
//			Page<Users> usersTemp =usersService.selectPage(users,page);
			
			
			view.addAttribute("page",usersService.selectPage(users,page));			
		} catch (Exception e) {
			LOGGER.error("失败:"+e.getMessage(),e);
			throw e;
		}finally{
		}	
		return "users/list";
	}
	
	/**
	 * 响应新增(修改)页面
	 * @param id 对象编号
	 * @return
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public String edit(@PathVariable Integer id,Model view) throws Exception{
		try {
			if(id != null && id > 0) {
				Users users = usersService.selectEntry(id);
				if(users == null) {
//					return toJSON(Message.failure("您要修改的数据不存在或者已被删除!"));
					return null;
				}
				view.addAttribute("users",users);
			}			
		} catch (Exception e) {
			LOGGER.error("失败:"+e.getMessage(),e);
			throw e;
		}finally{
		}

		return "users/edit";
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
			int res = usersService.delUser(id);
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
			Users users = usersService.selectEntry(id);
			if(users == null) {
				return null;
			}
			view.addAttribute("users",users);
		} catch (Exception e) {
			LOGGER.error("失败:"+e.getMessage(),e);
			throw e;
		}finally{
		}

		return "users/view";
	}
	
	/**
	 * 保存方法
	 * @param users 实体对象
	 * @return
	 */
	@RequestMapping(value="/save",method = {RequestMethod.POST,RequestMethod.GET},produces="application/json")
	public @ResponseBody Message save(Users users,Model view) throws Exception{
    	Message msg= null;
    	try {
			int res = usersService.saveOrUpdate(users);
			msg  = res > 0 ? Message.success() : Message.failure();
		} catch (Exception e) {
			LOGGER.error("失败:"+e.getMessage(),e);
			msg = Message.failure();
		}finally{
		}
		return msg;
	}
	
}