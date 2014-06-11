package com.skss.portal.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.frame.dao.BaseDao;
import com.skss.portal.dao.ContactsDao;
import com.skss.portal.entity.Contacts;

@Repository("dao.contactsDao")
public class ContactsDaoImpl extends BaseDao<Contacts> implements ContactsDao{

	public List<Contacts> findContacts() {
		// TODO Auto-generated method stub
		List<Contacts> list = findListBySQL("select * from cms_back_contacts");
		return list;
	}
	
}
