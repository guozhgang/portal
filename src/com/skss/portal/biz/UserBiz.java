package com.skss.portal.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.skss.portal.dao.UserDao;
import com.skss.portal.entity.User;

@Repository("biz.UserBiz")
public class UserBiz {
	@Resource(name="dao.UserDao")
	private UserDao userDao;
	public List<User> getAllUser(){
		return userDao.getAllUser();
	}
	
	public void save(User user) {
		userDao.save(user);
	}
	
	public List<User> findAllUser() {
		return userDao.findAllUser();
	}
}
