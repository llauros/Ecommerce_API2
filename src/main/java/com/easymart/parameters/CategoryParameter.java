package com.easymart.parameters;

import com.easymart.models.Category;

public class CategoryParameter {
	
	private Long id;
	private String name;
	
	public CategoryParameter(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	

	public Category toModel() {
		Category model = new Category();
		
		model.setId(this.id);
		model.setName(this.name);
	
		return model;
	}
}
