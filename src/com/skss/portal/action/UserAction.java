package com.skss.portal.action;

import javax.annotation.Resource;

import lombok.Data;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;

import com.frame.action.ActionUtil;
import com.skss.portal.entity.User;
import com.skss.portal.service.UserService;

@Scope("prototype")
@ParentPackage("json-default")
@Namespace("")
@Action(value="userAction",results={
	@Result(name="list",type="json")
})
@Data
public class UserAction extends ActionUtil<UserAction>{
	private User user;
	@Resource(name = "service.UserService")
	private UserService userService;
	public void save() {
		userService.save();
		if(!"".equals(user.getUserid()) && null != user.getUserid()) {
			try {
				super.print("true");
				logger.info("用户增加成功!");
			} catch (Exception e) {
				// TODO: handle exception
				logger.info("用户增加失败,请联系管理员!"+e.getMessage());
			}
		}
	}
}
