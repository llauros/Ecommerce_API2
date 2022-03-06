package com.easymart.services;

import java.util.List;

import com.easymart.models.Category;

/**
 * @author lucas
 */
public interface CategoryService {

	public List<Category> findAll();
	
	public Category findById(Long id);
	
	public Category create(Category model);
	
	public Category update(Category model);
	
	public boolean deleteById(Long id);
}
