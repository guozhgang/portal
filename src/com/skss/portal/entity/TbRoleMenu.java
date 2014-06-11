package com.skss.portal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "cms_back_role_menu")
public class TbRoleMenu {
	private String rmId;
	private String rmRoleId;
	private String rmMenuId;
	
	public TbRoleMenu(){}
	
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "rm_id")
	public String getRmId() {
		return rmId;
	}
	public void setRmId(String rmId) {
		this.rmId = rmId;
	}
	
	@Column(name = "rm_role_id")
	public String getRmRoleId() {
		return rmRoleId;
	}
	public void setRmRoleId(String rmRoleId) {
		this.rmRoleId = rmRoleId;
	}
	@Column(name = "rm_menu_id")
	public String getRmMenuId() {
		return rmMenuId;
	}
	public void setRmMenuId(String rmMenuId) {
		this.rmMenuId = rmMenuId;
	}
	
	
}
