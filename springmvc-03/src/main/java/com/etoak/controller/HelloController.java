package com.etoak.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/hello")
public class HelloController {
	
	@RequestMapping("/index")
	public String index(HttpServletRequest request) {
		//获得参数
		String name = request.getParameter("name");
		
		//向request域传值
		request.setAttribute("result", "Hello "+name);
		
		return "hello/index";
	}
}
