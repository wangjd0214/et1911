package com.etoak.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.etoak.bean.Student;
import com.sun.org.apache.regexp.internal.recompile;

@Controller
@RequestMapping("/complex")
public class ComplexController {
	
	@GetMapping("/bean")
	public String bean(Student student,Model model) {
		System.out.println(student);
		
		model.addAttribute("result2", "ʹ��Model��ֵ");
		
		//����ת��
		return "forward:/simple/simple?id=2";
	}
	
}
