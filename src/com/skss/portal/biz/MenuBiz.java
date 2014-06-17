package com.skss.portal.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.skss.portal.dao.MenuDao;
import com.skss.portal.entity.Menu;

@Repository("biz.menuBiz")
public class MenuBiz {
	@Resource(name = "dao.menuDao")
	private MenuDao menuDao;
	
	public List<Menu> getAllMenu(String menuId) {
		String sql = "select * from cms_back_menu where ";
		if(menuId==null || "null".equals(menuId)){
			sql+="parent_menu_id = '0'";
		}else{
			sql+="parent_menu_id='"+menuId+"'";
		}
		sql+=" order by menu_order_id asc";
		return menuDao.getAllMenu(sql);
	}
	
	public int getMenuCount(String parentMenuId){
		return menuDao.getMenuCount(parentMenuId);
	}
}
