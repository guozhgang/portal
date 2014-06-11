package com.skss.portal.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.frame.dao.BaseDao;
import com.skss.portal.entity.TbRole;

@Repository("dao.roleDao")
public class RoleDao extends BaseDao<TbRole>  {

	public void saveRole(TbRole role) {
		saveOrUpdate(role);
	}
	public List<TbRole> getRole() {
		return findListBySQL("select * from cms_back_role");
	}
	public List<TbRole> findPaginationRole(int start, int limit) {		
		return findPaginationListBySQL("select * from cms_back_role", start, limit);
	}
	public List<TbRole> findAllRole(){
		return findListBySQL("select * from cms_back_role");
	}
	public int findCount() {
		// TODO Auto-generated method stub
		return getCountBySql("select count(*) from cms_back_role");
	}
	public void deleteRole(TbRole role) {
		 delete(role);
	}
}
