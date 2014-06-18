package com.frame.entity;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

/**
 * 符合extjs tree格式的bean
 * @author Administrator
 * @time 2014年6月18日,上午10:07:35
 */
@Data
public class ExtJsTree {
	private String id;
	private String text;
	private boolean leaf;
	private List list = new ArrayList();
	
	
}
