package com.skss.portal.action;

import java.lang.reflect.Method;

import javax.annotation.Resource;

import lombok.Data;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.frame.action.ApplicationContextUtils;
import com.skss.portal.entity.User;
import com.skss.portal.service.UserService;

public class UserAction {
	
	@Resource(name="service.UserService")
	private UserService userService;
	private User user;
	public String getAllUser(){
		return userService.getAllUser();
	}
	
	public void save() {
		String actionName = "user.userAction";
		ApplicationContext ax = new ClassPathXmlApplicationContext("com/skss/portal/config/applicationContext.xml");
		Object uc = ax.getBean(actionName);
		try {
			Method method = uc.getClass().getDeclaredMethod("dd");
			method.invoke(uc.getClass().newInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void dd(){
		System.out.println("ddd");
	}
	
}
