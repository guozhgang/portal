package com.frame.util;

import java.lang.reflect.ParameterizedType;

import org.apache.log4j.Logger;

public class Log4jUtil <T>{
	
	protected  Logger logger = Logger.getLogger(getEntity());
	
	@SuppressWarnings("unchecked")
	private Class<?> getEntity(){
		return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
}
