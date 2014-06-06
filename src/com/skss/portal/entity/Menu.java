package com.skss.portal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="cms_back_menu")
public class Menu {
	private String menuId;
	private String menuName;
	private String parentMenuId;
	private String menuUrl;
	private String menuOrderId;
	private String menuShow;
	private String menuIcon;
	private String menuIsLeaf;
	
	public Menu(){}
	
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "menu_id")
	public String getMenuId() {
		return menuId;
	}
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	@Column(name="menu_name")
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	@Column(name="parent_menu_id")
	public String getParentMenuId() {
		return parentMenuId;
	}
	public void setParentMenuId(String parentMenuId) {
		this.parentMenuId = parentMenuId;
	}
	@Column(name="menu_url")
	public String getMenuUrl() {
		return menuUrl;
	}
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
	@Column(name="menu_order_id")
	public String getMenuOrderId() {
		return menuOrderId;
	}
	public void setMenuOrderId(String menuOrderId) {
		this.menuOrderId = menuOrderId;
	}
	@Column(name="menu_show")
	public String getMenuShow() {
		return menuShow;
	}
	public void setMenuShow(String menuShow) {
		this.menuShow = menuShow;
	}
	@Column(name="menu_icon")
	public String getMenuIcon() {
		return menuIcon;
	}
	public void setMenuIcon(String menuIcon) {
		this.menuIcon = menuIcon;
	}
	@Column(name="menu_is_leaf")
	public String getMenuIsLeaf() {
		return menuIsLeaf;
	}
	public void setMenuIsLeaf(String menuIsLeaf) {
		this.menuIsLeaf = menuIsLeaf;
	}
	
	
}
