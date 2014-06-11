package com.frame.action;

import java.lang.reflect.Method;

import lombok.Data;
import lombok.EqualsAndHashCode;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;

@EqualsAndHashCode(callSuper=false)
@Data
@Scope("prototype")
@ParentPackage("json-default")
@Namespace("")
@Action(value="superAction",results={
	@Result(name="list",type="json")
})
public class SuperAction{
	private String method;
	private String service;
	
	public void execute () throws Exception {
		Method mhd = ApplicationContextUtils.getBean(service).getClass().getDeclaredMethod(method);
		mhd.invoke(ApplicationContextUtils.getBean(service).getClass().newInstance());
	}
	
}
