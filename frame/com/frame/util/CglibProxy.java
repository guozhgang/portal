package com.frame.util;

import java.lang.reflect.Method;



import org.springframework.stereotype.Service;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;


/**
 * 使用cglib动态代理
 * @author： guozhigang
 * @time：2014年6月17日,下午2:00:01
 */
@Service
public class CglibProxy implements MethodInterceptor{
	private Object target;
	/**
	 * 创建代理对象
	 * @param target
	 * @return
	 */
	public Object getInstance(Object target) {
		this.target = target;
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(this.target.getClass());
		enhancer.setCallback(this);
		//创建代理对象
		return enhancer.create();
	}
	/**
	 * 回调方法
	 */
	public Object intercept(Object arg0, Method arg1, Object[] arg2,
			MethodProxy arg3) throws Throwable {
		System.out.println("事物开始之前");
		//arg3.invokeSuper(arg0, arg2);
		arg3.invoke(arg0, arg2);
		System.out.println("事物开始之后");
		return null;
	}
	
}
