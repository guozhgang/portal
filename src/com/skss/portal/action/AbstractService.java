package com.skss.portal.action;

import java.lang.reflect.Method;

import lombok.Data;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;

import com.frame.action.ActionUtil;
import com.frame.action.ApplicationContextUtils;


@Scope("prototype")
@ParentPackage("json-default")
@Namespace("")
@Action(value="roleeAction",results={
	@Result(name="list",type="json")
})
@Data
public class AbstractService extends ActionUtil<AbstractService>{
	private String method;
	private String service;
	public void execute() throws Exception{
		Class<? extends Object> cls = ApplicationContextUtils.getBean(service).getClass();
		Method mhd = cls.getDeclaredMethod(method);
		mhd.invoke(cls.newInstance());
	}
	public void tt() {
		System.out.println("3256");
	}
}
