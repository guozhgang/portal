package com.skss.portal.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.skss.portal.biz.ContactsBiz;
import com.skss.portal.entity.Contacts;

@Service("service.contactsService")
public class ContactsService {
	
	@Resource(name="biz.contactsBiz")
	private ContactsBiz contactsBiz;
	
	public List<Contacts> findContacts(){
		return contactsBiz.findContacts();
	}
}
