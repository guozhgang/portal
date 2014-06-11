package com.skss.portal.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.skss.portal.dao.RoleMenuDao;
import com.skss.portal.entity.TbRoleMenu;

@Repository("biz.roleMenuBiz")
public class RoleMenuBiz {
	@Resource(name = "dao.roleMenuDao")
	private RoleMenuDao roleMenuDao;
	public void saveRoleMenu(TbRoleMenu roleMenu) {
		roleMenuDao.saveRoleMenu(roleMenu);
	}
}
