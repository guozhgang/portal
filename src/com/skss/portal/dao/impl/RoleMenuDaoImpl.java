package com.skss.portal.dao.impl;

import org.springframework.stereotype.Repository;

import com.frame.dao.BaseDao;
import com.skss.portal.dao.RoleMenuDao;
import com.skss.portal.entity.TbRoleMenu;

@Repository("dao.roleMenuDao")
public class RoleMenuDaoImpl extends BaseDao<TbRoleMenu> implements RoleMenuDao{

	public void saveRoleMenu(TbRoleMenu roleMenu) {
		// TODO Auto-generated method stub
		saveOrUpdate(roleMenu);
	}

}
