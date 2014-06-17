package com.skss.portal.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.frame.dao.BaseDao;
import com.skss.portal.dao.MenuDao;
import com.skss.portal.entity.Menu;

@Repository("dao.menuDao")
public class MenuDaoImpl extends BaseDao<Menu> implements MenuDao {

	public List<Menu> getAllMenu(String sql) {
		// TODO Auto-generated method stub
		List<Menu> list = findListBySQL(sql);
		return list;
	}

	public int getMenuCount(String parentMenuId) {
		// TODO Auto-generated method stub
		return getCountBySql("select count(*) from cms_back_menu where parent_menu_id=?", parentMenuId);
	}

	public void say() {
		// TODO Auto-generated method stub
		System.out.println("say hello");
	}

}
