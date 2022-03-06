package com.easymart.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easymart.entities.CategoryEntity;
import com.easymart.entities.ProductEntity;
import com.easymart.models.Product;
import com.easymart.repositories.ProductRepository;
import com.easymart.services.ProductService;

/**
 * @author lucas
 */
@Service
public class ProductBaseService implements ProductService{

	@Autowired
	private ProductRepository repository;

	@Override
	public List<Product> findAll() {
		List<ProductEntity> entity = this.repository.findAll();
		
		if(entity != null && !entity.isEmpty()) {
			return entity.stream().map( item -> item.toModel()).collect(Collectors.toList());
		} else {
			return null ;
		}
	}

	@Override
	public Product findById(Long id) {
		Optional<ProductEntity> entity = repository.findById(id);
		
		if(entity.isPresent()) {
			return entity.get().toModel();
		}
		return null;
	}
	
	@Override
	public Product create(Product user) {
		ProductEntity entity = repository.save(new ProductEntity(user));
		
		return entity.toModel();
	}

	@Override
	public Product update(Product model) {
			
		return repository.findById(model.getId()).map( result -> {
			
			result.setName(model.getName());
			result.setDescription(model.getDescription());
			result.setPrice(model.getPrice());
			result.setPhoto(model.getPhoto());
			if(model.getCategory() != null) {
				result.setCategory(new CategoryEntity(model.getCategory()));
			}
						
			return repository.save(result).toModel();
		}).orElseGet(() -> {
			return null;
		});
		
	}
	
	@Override
	public boolean deleteById(Long id) {
		
		Optional<ProductEntity> result = repository.findById(id);
		
		if (result.isPresent()) {
			repository.deleteById(id);
			return true;
		}
		return false;
	}

}