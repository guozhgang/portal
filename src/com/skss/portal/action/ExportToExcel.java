package com.skss.portal.action;

import java.io.File;
import java.io.OutputStream;
import java.util.List;

import javax.annotation.Resource;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.frame.action.ActionUtil;
import com.skss.portal.entity.Contacts;
import com.skss.portal.service.ContactsService;

@Scope("prototype")
@ParentPackage("json-default")
@Namespace("")
@Action(value="contactsAction",results={
	@Result(type="json"),
	@Result(name="error",location="/error.jsp")
})
public class ExportToExcel extends ActionUtil{
	@Resource(name="service.contactsService")
	private ContactsService contactsService;
	public void createExcel() {}
	/*public static void main(String[] args) {
		ApplicationContext ac =new ClassPathXmlApplicationContext("com/skss/portal/config/applicationContext.xml");
		ContactsService ct=(ContactsService)ac.getBean("service.contactsService");
		List<Contacts> list = ct.findContacts();
		ExportToExcel et= new ExportToExcel();
		//et.createExcel(list);
	}*/
}
