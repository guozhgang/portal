package com.skss.portal.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.frame.entity.Combobox;
import com.skss.portal.biz.RoleBiz;
import com.skss.portal.biz.RoleMenuBiz;
import com.skss.portal.entity.TbRole;
import com.skss.portal.entity.TbRoleMenu;
import com.skss.portal.entity.TreeNode;

@Service("service.roleService")
public class RoleService {
	@Resource(name = "biz.roleBiz")
	private RoleBiz roleBiz;
	@Resource(name = "biz.roleMenuBiz")
	private RoleMenuBiz roleMenuBiz;
	public void saveRole(TbRole role, String[] menuIdArray){
		roleBiz.saveRole(role);		
		if(role.getRoleId() != null) {  //保存角色所拥有的权限
			
			for(int i=0;i<menuIdArray.length;i++){
				TbRoleMenu roleMenu = new TbRoleMenu();
				roleMenu.setRmRoleId(role.getRoleId());
				roleMenu.setRmMenuId(menuIdArray[i]);
				roleMenuBiz.saveRoleMenu(roleMenu);
			}
		}
	}
	public List<TbRole> getRole() {
		return roleBiz.getRole();
	}
	//按分页获得集合
	public List<TbRole> findPaginationList(int start, int limit) {
		return roleBiz.findPaginationList(start, limit);
	}
	public List<Combobox> findAllRole() {
		List<TbRole> list = roleBiz.findAllRole();
		List<Combobox> cbblist = new ArrayList<Combobox>();
		if(list.size() != 0) {
			for(int i =0; i < list.size(); i++) {
				Combobox cbb = new Combobox();
				cbb.setId(list.get(i).getRoleId());
				cbb.setText(list.get(i).getRoleName());
				cbblist.add(cbb);
			}
			
		}
		return cbblist;
	}
	//获得角色的总记录数目
	public int findCount(){
		return roleBiz.findCount();
	}
	//删除角色
	public void deleteRole(TbRole role) {
		roleBiz.deleteRole(role);
	}
}
