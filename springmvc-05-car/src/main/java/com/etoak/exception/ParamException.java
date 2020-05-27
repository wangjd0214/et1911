package com.etoak.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

//自定义异常
public class ParamException extends RuntimeException{
	
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;

	public ParamException(String message) {
		super(message);
	}

}
