package com.etoak.bean;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarVo extends Car {
	
	private String levelName;
	
	private String gearboxName;
	
	private String outputVolumeName;
	
	@JsonIgnore  //在返回结果时不返回此属性
	private List<Map<String,Integer>> priceMapList;
	
	
	@JsonIgnore  //在返回结果时不返回此属性
	private String vehicleAge;
	
	@JsonIgnore
	private Integer startYear;
	@JsonIgnore
	private Integer endYear;
}
