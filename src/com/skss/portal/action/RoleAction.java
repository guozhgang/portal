package com.skss.portal.action;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import lombok.Data;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;

import com.frame.action.ActionUtil;
import com.frame.entity.Combobox;
import com.skss.portal.entity.TbRole;
import com.skss.portal.service.RoleService;

@Scope("prototype")
@ParentPackage("json-default")
@Namespace("")
@Action(value="roleAction",results={
	@Result(name="list",type="json")
})
@Data
public class RoleAction extends ActionUtil<RoleAction> {
	@Resource(name = "service.roleService")
	private RoleService roleService;
	private TbRole tbRole;
	private String menuIds;

	public void saveRole(){
		String[] menuIdArray = menuIds != null ? menuIds.split(",") : null;
		roleService.saveRole(tbRole, menuIdArray);
		if(!"".equals(tbRole.getRoleId())&&tbRole.getRoleId() != null){
			try {
				super.print("true");
				logger.info("角色添加成功");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				logger.info("角色添加失败,请联系管理员！");
			}
		}
	}
	//获得所有角色
	public void findAllRole() {
		List<TbRole> list = roleService.findPaginationList(start,rows);
		int count = roleService.findCount();
		try {
			super.printJSONForDataGrid(list, count);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("加载角色列表失败:"+e.getMessage());
		}
	}
	public void findAllRoleCombobox() {
		List<Combobox> cbblist = roleService.findAllRole();
		try {
			super.printJSONForTreeOrCombo(cbblist);
			logger.info("角色获取成功!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("角色获取失败,请联系管理员!"+e.getMessage());
		}
	}
	
	public void deleteRole(){
		try {
			roleService.deleteRole(tbRole);
			super.print("true");
			logger.info("角色删除成功!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("角色删除失败,请联系管理员!");
		}
	}
	
	
	
}
