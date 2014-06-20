package com.frame.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.frame.util.Constant;
import com.frame.util.Log4jUtil;
import com.opensymphony.xwork2.ActionContext;
@SuppressWarnings({ "rawtypes" })

public class ActionUtil<T> extends Log4jUtil <T>implements ServletRequestAware,ServletResponseAware,SessionAware{
	
	protected HttpServletRequest request;
	protected HttpServletResponse response;	
	protected Map session;
	private Map<String, Object> map = new HashMap<String, Object>();
	protected int rows;
	protected int page;
	protected int start;  //从第几条开始
	
	
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}
	public void setSession(Map session) {
		// TODO Auto-generated method stub
		this.session = session;
		
	}
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response = response;
	}
	public HttpServletRequest getRequest() {
		return this.request;
	}
	public HttpServletResponse getResponse() {
		return this.response;
	}
	public Map getSession() {
		return this.session;
	}
	
	
	public HttpServletRequest getRequest2(){
		return (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
	}

	public void print(Object obj) throws IOException{
		response.setContentType("text/html;charset=UTF-8"); //解决中文乱码
		PrintWriter out =  response.getWriter();	
		out.print(obj);
		out.flush();
		out.close();
	}
	
	public void printJSONForDataGrid(List list, int... count) throws IOException{
		
		map.put(Constant.ROWS, list);
		map.put(Constant.TOTAL, count);
		JSONArray json = JSONArray.fromObject(map);
		String dataJSON = json.toString();
		dataJSON = dataJSON.substring(1,dataJSON.length()-1);   //符合easyui的json格式
		
		this.print(dataJSON);
	}
	public void printJSON(List list, int total) throws IOException {
		map.put(Constant.ROOT, list);
		map.put(Constant.TOTALPROPERTY, total);
		JSONObject json = JSONObject.fromObject(map);
		this.print(json);
	}
	public void printJSONForTreeOrCombo(List list) throws IOException{
		//ParameterizedType pt = (ParameterizedType) ActionUtil.class.getField("list").getGenericType();
		JSONArray json = JSONArray.fromObject(list);
		this.print(json);
	}
	public Map<String, Object> getMap() {
		return map;
	}
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
		start = (this.page-1)*rows;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	
	
}
