package com.etoak.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.etoak.action.UserAction;
import com.etoak.service.UserService;

@Configuration
public class UserConfig {
	
	//注册一个spring bean 
	@Bean("userService")
	public UserService userService() {
		return new UserService();
	}
	
	/*
	 * @Bean public UserAction userAction() {
	 * 
	 * UserAction userAction = new UserAction();
	 * userAction.setUserService(this.userService());
	 * 
	 * return userAction; }
	 */
	
	
	 @Bean public UserAction userAction(@Qualifier("userService")UserService userService) { 
		 //return new UserAction(); 
		 UserAction userAction = new UserAction(); 
		 
		 //配合@Qualifier使用 
		 userAction.setUserService(userService); 
		 return userAction; 
	 }
}
