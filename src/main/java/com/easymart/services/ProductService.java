package com.easymart.services;

import java.util.List;

import com.easymart.models.Product;

/**
 * @author lucas
 */
public interface ProductService {

	public List<Product> findAll();
	
	public Product findById(Long id);
	
	public Product create(Product model);
	
	public Product update(Product model);
	
	public boolean deleteById(Long id);
}
