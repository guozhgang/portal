package com.skss.portal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="cms_front_column")
public class TbColumn {
	private String columnId;
	private String columnCode;
	private String columnName;
	private String columnUrl;
	private String parentColumnCode;
	private int topLevel;
	private int orderId;
	private byte canDelete;
	private int showSize;
	private int grade;
	private String userCanUser;
	private String ftlFile;
	
	public TbColumn(){
		
	}
	
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "column_id")
	public String getColumnId() {
		return columnId;
	}

	public void setColumnId(String columnId) {
		this.columnId = columnId;
	}
	@Column(name = "column_code")
	public String getColumnCode() {
		return columnCode;
	}

	public void setColumnCode(String columnCode) {
		this.columnCode = columnCode;
	}
	@Column(name = "column_name")
	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	@Column(name = "column_url")
	public String getColumnUrl() {
		return columnUrl;
	}

	public void setColumnUrl(String columnUrl) {
		this.columnUrl = columnUrl;
	}
	@Column(name = "parent_column_code")
	public String getParentColumnCode() {
		return parentColumnCode;
	}

	public void setParentColumnCode(String parentColumnCode) {
		this.parentColumnCode = parentColumnCode;
	}
	@Column(name = "top_level")
	public int getTopLevel() {
		return topLevel;
	}

	public void setTopLevel(int topLevel) {
		this.topLevel = topLevel;
	}
	@Column(name = "order_id")
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	@Column(name = "can_delete")
	public byte getCanDelete() {
		return canDelete;
	}

	public void setCanDelete(byte canDelete) {
		this.canDelete = canDelete;
	}
	@Column(name = "show_size")
	public int getShowSize() {
		return showSize;
	}

	public void setShowSize(int showSize) {
		this.showSize = showSize;
	}
	@Column(name = "grade")
	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
	@Column(name = "user_can_use")
	public String getUserCanUser() {
		return userCanUser;
	}

	public void setUserCanUser(String userCanUser) {
		this.userCanUser = userCanUser;
	}
	@Column(name = "ftl_file")
	public String getFtlFile() {
		return ftlFile;
	}

	public void setFtlFile(String ftlFile) {
		this.ftlFile = ftlFile;
	}
	
	
	
}
