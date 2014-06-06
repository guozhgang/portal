package com.skss.portal.action;


import java.io.IOException;

import javax.annotation.Resource;

import net.sf.json.JSONArray;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;

import com.frame.action.ActionUtil;
import com.skss.portal.service.ColumnService;

@Scope("prototype")
@ParentPackage("json-default")
@Namespace("")
@Action(value="columnAction", results={
	@Result(type="json")
})
public class ColumnAction extends ActionUtil{
	@Resource(name = "service.columnService")
	private ColumnService columnService;
	private String id = null;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获得栏目列表
	 */
	public void getColumn() {
		
		JSONArray json = columnService.getColumn(id);
		try {
			response.setContentType("text/javascript;charset=utf-8");
			print(json);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
