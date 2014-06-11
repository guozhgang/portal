package com.frame.entity;

import lombok.Data;

@Data
public class Combobox {
	public Combobox(){}
	public Combobox(String id, String text) {
		this.id = id;
		this.text = text;
	}
	private String id;
	private String text;
	
}
