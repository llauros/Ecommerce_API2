package com.easymart.parameters;

import com.easymart.models.SubCategory;

public class SubCategoryParameter {
	
	private String name;
	
	public SubCategoryParameter(Long id,String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	

	public SubCategory toModel() {
		SubCategory model = new SubCategory();
		
		model.setName(this.name);
	
		return model;
	}
}
