package com.frame.action;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
public class BookProxy implements InvocationHandler{
	private Object target;
	/**
	 * 判定委托对象并返回一个代理类
	 * @param target
	 * @return
	 */
	public Object bind(Object target) {
		this.target = target;
		//取得代理对象		
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
		Object result = null;
		System.out.println("事物开始");
		result = method.invoke(target, args);
		System.out.println("事务结束");
		return result;
	}

}
