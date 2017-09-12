/*
 * Copyright (c) 2017 customer.com All rights reserved.
 * 本软件源代码版权归----所有,未经许可不得任意复制与传播.
 */
package com.kkliu.customer.web.utils;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.kkliu.customer.common.Constants;

/**
 * web工具类
 * @author kkliu
 * @since 2017-09-11
 */
public class WebUtils {
	public String getStaticFilePath(String file){
	    HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
	    //HttpServletResponse resp = ((ServletWebRequest)RequestContextHolder.getRequestAttributes()).getResponse();
	    return req.getContextPath() + file + "?v="+Constants.SYSTEM_START_TIME.getTime();
	}
}
