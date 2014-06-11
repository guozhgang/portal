package com.skss.portal.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.skss.portal.dao.ContactsDao;
import com.skss.portal.entity.Contacts;

@Repository("biz.contactsBiz")
public class ContactsBiz {
	@Resource(name="dao.contactsDao")
	private ContactsDao contactsDao;
	
	public List<Contacts> findContacts() {
		return contactsDao.findContacts();
	} 
}
