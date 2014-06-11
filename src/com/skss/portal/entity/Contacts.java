package com.skss.portal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="cms_back_contacts")
public class Contacts {
	private String ctsId;
	private String regionCode;
	private String regionName;
	private String name;
	private String job;
	private String officeTel;
	private String houseTel;
	private String mobileTel;
	
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "cts_id")
	public String getCtsId() {
		return ctsId;
	}
	public void setCtsId(String ctsId) {
		this.ctsId = ctsId;
	}
	
	@Column(name="region_code")
	public String getRegionCode() {
		return regionCode;
	}
	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}
	@Column(name="region_name")
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="job")
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	@Column(name="office_tel")
	public String getOfficeTel() {
		return officeTel;
	}
	public void setOfficeTel(String officeTel) {
		this.officeTel = officeTel;
	}
	@Column(name="house_tel")
	public String getHouseTel() {
		return houseTel;
	}
	public void setHouseTel(String houseTel) {
		this.houseTel = houseTel;
	}
	@Column(name="mobile_tel")
	public String getMobileTel() {
		return mobileTel;
	}
	public void setMobileTel(String mobileTel) {
		this.mobileTel = mobileTel;
	}
	
	
}
