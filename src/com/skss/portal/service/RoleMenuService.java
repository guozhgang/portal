package com.skss.portal.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.skss.portal.biz.RoleMenuBiz;
import com.skss.portal.entity.TbRoleMenu;

@Service("service.roleMenuService")
public class RoleMenuService {
	@Resource(name = "biz.roleMenuBiz")
	private RoleMenuBiz roleMenuBiz;
	public void saveRoleMenu(TbRoleMenu roleMenu) {
		
	}
}
