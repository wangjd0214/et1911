package com.etoak.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.etoak.bean.Car;
import com.etoak.service.CarService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/car")
@Slf4j
public class CarController {
	
	@Autowired
	CarService carService;
	
	//跳转添加页面
	@RequestMapping("/toAdd")
	public String toAdd() {
		return "car/add";
	}
	
	@RequestMapping("/add")
	public String add(MultipartFile file,Car car) throws IllegalStateException, IOException {
		//获取文件名
		String originalFilename = file.getOriginalFilename();
		
		log.info("文件名称 - {}",file.getOriginalFilename());
		log.info("param - {}",car);
		
		//新文件名
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		String newFileName = uuid + "-" +originalFilename;
		
		//目标文件位置
		File destFile = new File("d:/Test file upload",newFileName);
		file.transferTo(destFile);
		
		car.setPic("/pic/"+newFileName);
		
		//调用service进行添加
		carService.addCar(car);
		
		//重定向跳转页面
		return "redirect:/car/toAdd";
	}
	
}









