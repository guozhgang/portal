package com.frame.action;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class ApplicationContextUtils implements ServletContextListener{

	public static  WebApplicationContext applicationContext;
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		applicationContext = WebApplicationContextUtils.getWebApplicationContext(arg0.getServletContext());
	}
	
	public static Object getBean(String name) {
		return applicationContext.getBean(name);
	}
	
}
