package com.skss.portal.action;

import java.lang.reflect.Method;

import javax.annotation.Resource;

import lombok.Data;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.context.ApplicationContext;
import com.skss.portal.entity.User;
import com.skss.portal.service.UserService;
@Data
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace("")
@Action(value="userAction",results={
	@Result(name="success",location="/success.jsp"),
	@Result(name="error",location="/error.jsp")
})
public class UserAction extends com.frame.action.ActionUtil<UserAction>{
	
	@Resource(name="service.UserService")
	private UserService userService;
	private User user;
	public String getAllUser(){
		return userService.getAllUser();
	}
	
	public void save() {
		//userService.save(user);
		String className = "RoleAction";
		javax.servlet.ServletContext application = org.apache.struts2.ServletActionContext.getRequest().getSession().getServletContext();
		ApplicationContext cc = org.springframework.web.context.support.WebApplicationContextUtils.getWebApplicationContext(application);
		cc.getBean("roleAction");
		//http://www.blogjava.net/coderdream/archive/2012/04/09/162644.html 
		Class cls = null;
		try {
			cls = (Class)Class.forName(className).newInstance();
			System.out.println(cls.getName());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(UserAction.class.getName());
		
		try {
			Method method = cls.getClass().getDeclaredMethod("findAllRole");
			method.invoke("findAllRole".getClass().newInstance());
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	public void dd(){
		System.out.println("ddd");
	}
}
