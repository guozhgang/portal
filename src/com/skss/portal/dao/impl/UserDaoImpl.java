package com.skss.portal.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.frame.dao.BaseDao;
import com.skss.portal.dao.UserDao;
import com.skss.portal.entity.User;

@Repository("dao.UserDao")
public class UserDaoImpl extends BaseDao<User> implements UserDao {
	private final Log log = LogFactory.getLog(getClass());
	
	public List<User> getAllUser() {
		int count = getCountBySql("select count(*) from cms_back_user");
		log.info("log4j记录日志成功");
		return null;
	}
}
