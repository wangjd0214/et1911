package com.etoak.bean;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*@Getter
@Setter
@ToString*/
@Data
@NoArgsConstructor //�޲ι��췽��
@AllArgsConstructor //���ղ���˳�����ɹ��췽��
public class Student {
	private Integer id;
	private String name;
	private Integer age;
	
	private List<String> hobbyList;
	
	private Map<String,Object> stuMap;
	
	
}
