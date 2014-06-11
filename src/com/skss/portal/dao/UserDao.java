package com.skss.portal.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.frame.dao.BaseDao;
import com.skss.portal.entity.User;

@Repository("dao.UserDao")
public class UserDao extends BaseDao<User> {
	
	public List<User> getAllUser() {
		int count = getCountBySql("select count(*) from cms_back_user");
		return null;
	}
	public void saveUser(User user) {
		saveOrUpdate(user);
	}
}
