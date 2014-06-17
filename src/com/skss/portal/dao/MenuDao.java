package com.skss.portal.dao;

import java.util.List;

import com.skss.portal.entity.Menu;

public interface MenuDao {
	public List<Menu> getAllMenu(String sql);
	public int getMenuCount(String parentMenuId);
	
	public void say();
}
