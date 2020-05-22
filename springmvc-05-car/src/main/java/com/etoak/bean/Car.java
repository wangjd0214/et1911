package com.etoak.bean;

import lombok.Data;

@Data
public class Car {
	
	private Integer id;
	//Ʒ��
	private String brand;
	//��ϵ
	private String series;
	//�۸�
	private Integer price;
	//����ʱ��
	private String licensingTime;
	//����
	private String level;
	//������
	private String gearbox;
	//����
	private String outputVolume;
	//���
	private Integer mileage;
	//������
	private String location;
	//ͼƬ
	private String pic;
	private String summary;
	private String createTime;
}
