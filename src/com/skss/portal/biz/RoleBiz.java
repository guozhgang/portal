package com.skss.portal.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.skss.portal.dao.RoleDao;
import com.skss.portal.entity.TbRole;

@Repository("biz.roleBiz")
public class RoleBiz {
	@Resource(name = "dao.roleDao")
	private RoleDao roleDao;
	
	public void saveRole(TbRole role){
		roleDao.saveRole(role);
	}
	public List<TbRole> getRole() {
		return roleDao.getRole();
	}
	public List<TbRole> findPaginationList(int start, int limit)
	{
		return roleDao.findPaginationRole(start, limit);
	}
	public List<TbRole> findAllRole(){
		return roleDao.findAllRole();
	}
	public int findCount(){
		return roleDao.findCount();
	}
	public void deleteRole(TbRole role) {
		roleDao.deleteRole(role);
	}
}
