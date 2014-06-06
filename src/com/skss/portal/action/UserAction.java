package com.skss.portal.action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;

import com.skss.portal.service.UserService;
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace("")
@Action(value="userAction",results={
	@Result(name="success",location="/success.jsp"),
	@Result(name="error",location="/error.jsp")
})
public class UserAction {
	
	@Resource(name="service.UserService")
	private UserService userService;
	public String getAllUser(){
		return userService.getAllUser();
	}
}
