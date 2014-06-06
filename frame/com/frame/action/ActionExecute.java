package com.frame.action;

import lombok.Data;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.context.annotation.Scope;
import java.lang.reflect.Method;

@Data
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace("")
@Action(value="utilAction")
public class ActionExecute <T> extends ActionUtil<T>{
	private String methodName;
	private String actionName;
	
	
	public void execute() {
		System.out.println("dddd");
	}
	
	
	
}
