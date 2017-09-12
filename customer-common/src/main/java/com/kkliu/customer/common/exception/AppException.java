/*
 * Copyright (c) 2017 customer.com All rights reserved.
 * 本软件源代码版权归----所有,未经许可不得任意复制与传播.
 */
package com.kkliu.customer.common.exception;

/**
 * AppException
 * @author kkliu
 * @since 2017-09-11
 */
public class AppException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	public AppException() {
		super();
	}
	
	public AppException(String message) {
		super(message);
	}
	
	public AppException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public AppException(Throwable cause) {
		super(cause);
	}
}
