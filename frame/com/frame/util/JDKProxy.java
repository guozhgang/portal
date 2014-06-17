package com.frame.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.stereotype.Service;


/**
 * 使用jdk实现动态代理
 * @author Administrator
 * 
 */
@Service("proxy.jdkProxy")
public class JDKProxy implements InvocationHandler{
	private Object target;  //委托类
	
	/**
	 * 绑定委托类并返回代理对象
	 * @param target
	 * @return
	 */
	public Object bind(Object target) {
		this.target = target;
		//返回代理类对象
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object result = null;
		System.out.println("事物开始之前");
		result = method.invoke(target, args);
		System.out.println("事物开始之后"+result);
		return result;
	}
}
