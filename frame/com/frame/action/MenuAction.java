package com.frame.action;

import javax.annotation.Resource;

import lombok.Data;
import net.sf.json.JSONArray;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;

import com.skss.portal.service.ContactsService;
import com.skss.portal.service.MenuService;
@Data
@Scope("prototype")
@ParentPackage("json-default")
@Namespace("")
@Action(value="menuAction",results={
	@Result(type="json"),
	@Result(name="error",location="/error.jsp")
})
/**
 * 
 * ClassName：MenuAction
 * 功能描述：菜单action
 * 作者：guozhigang
 * 日期：2014年5月17日,下午11:52:08
 * 版本：V1.0
 */
public class MenuAction extends ActionUtil<MenuAction>{
	@Resource(name = "service.menuService")
	private MenuService menuService;
	@Resource(name="service.contactsService")
	private ContactsService contactsService;
	private String id = null;
/**
 * 
 * 方法名称：getMenu
 * 方法描述：查询符合条件的菜单
 * 参数：      
 * 返回值： void
 */
	public void getMenu(){
		JSONArray json = menuService.getMenu(id);
		try {
			response.setContentType("text/javascript;charset=utf-8");
			print(json);
			logger.info("菜单加载成功！！！");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info("菜单加载失败"+e.getMessage());
		} 
	}
	
	
}
