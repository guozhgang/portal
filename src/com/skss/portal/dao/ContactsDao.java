package com.skss.portal.dao;


import java.util.List;

import com.skss.portal.entity.Contacts;


public interface ContactsDao {
	public List<Contacts> findContacts();
}
