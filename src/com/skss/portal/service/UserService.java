package com.skss.portal.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.skss.portal.biz.UserBiz;
import com.skss.portal.entity.User;

@Service("service.UserService")
public class UserService {
	static Logger log= Logger.getLogger(UserService.class);
	@Resource(name="biz.UserBiz")
	private UserBiz userBiz;	
	public String getAllUser(){
		List<User> list=userBiz.getAllUser();
		if(list.size()!=0){
			return "success";
		}
		return "error";
	}
	public void save(User user) {
		userBiz.save(user);
	}
}
