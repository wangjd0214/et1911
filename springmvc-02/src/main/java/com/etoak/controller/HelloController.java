package com.etoak.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//��ȡ����
		String name = request.getParameter("name");
		
		//����service
		
		//����ҳ��
		ModelAndView mv = new ModelAndView();
		mv.setViewName("hello");
		//��request��ֵ
		mv.addObject("result","Hello "+name);
		
		return mv;
	}

}
