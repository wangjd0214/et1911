package com.etoak.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.etoak.bean.Car;
import com.etoak.bean.CarVo;
import com.etoak.bean.PageVo;
import com.etoak.exception.ParamException;
import com.etoak.service.CarService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/car")
@Slf4j
public class CarController {
	
	@Autowired
	CarService carService;
	
	@RequestMapping("/toAdd")
	public String toAdd() {
		return "car/add";
	}
	
	@RequestMapping("/add")
	public String add(MultipartFile file,@Valid Car car,BindingResult bindingResult,HttpServletRequest request) throws IllegalStateException, IOException {
		
		//校验
		//获取所有的校验结果
		List<ObjectError> allErrors = bindingResult.getAllErrors();
		if(!CollectionUtils.isEmpty(allErrors)) {
			StringBuffer errorBuf = new StringBuffer();
			for(ObjectError error:allErrors) {
				String errorMsg = error.getDefaultMessage();
				errorBuf.append(errorMsg).append(";");
			}
			//校验的错误信息写到request域,
			//request.setAttribute("paramError", errorBuf.toString());
			//请求转发
			//return "forward:/car/toAdd";
			throw new ParamException(errorBuf.toString());
		}
		
		String originalFilename = file.getOriginalFilename();
		
		log.info("文件名称 - {}",file.getOriginalFilename());
		log.info("param - {}",car);
		
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		String newFileName = uuid + "-" +originalFilename;
		
		
		File destFile = new File("d:/Test file upload",newFileName);
		file.transferTo(destFile);
		
		car.setPic("/pic/"+newFileName);
		
		carService.addCar(car);
		
		return "redirect:/car/toAdd";
	}

	
	@RequestMapping("/toList")
	public String toList() {
		return "car/listcar";
	}
	
	@GetMapping("/list")
	@ResponseBody
	public PageVo<CarVo> queryList(
			@RequestParam(required = false,defaultValue = "1") int pageNumber,
			@RequestParam(required = false,defaultValue = "8") int pageSize,
			CarVo carVo,
			String[] priceList){
		
				return carService.queryList(pageNumber, pageSize, carVo,priceList);
		
	}
	
	
	@GetMapping("/getBrand")
	@ResponseBody
	public List<String> getBrand() {
		return carService.getAllBrand();
	}
	
	@GetMapping("/getSeries")
	@ResponseBody
	public List<String> getSeries(String brand) {
		return carService.getSeriesByBrand(brand);
	}
	
}









