package com.skss.portal.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.frame.action.SuperAction;
import com.skss.portal.biz.UserBiz;
import com.skss.portal.entity.User;

@Service("service.UserService")
public class UserService {
	private User user;
	@Resource(name="biz.UserBiz")
	private UserBiz userBiz;	
	public String getAllUser(){
		List<User> list=userBiz.getAllUser();
		if(list.size()!=0){
			return "success";
		}
		return "error";
	}
	public void save() {
		userBiz.save(user);
	}
	public List<User> findAllUser() {
		return userBiz.findAllUser();
	}
}
