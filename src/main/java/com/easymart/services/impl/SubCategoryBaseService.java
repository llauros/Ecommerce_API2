package com.easymart.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easymart.entities.SubCategoryEntity;
import com.easymart.models.SubCategory;
import com.easymart.repositories.SubCategoryRepository;
import com.easymart.services.SubCategoryService;

/**
 * @author lucas
 */
@Service
public class SubCategoryBaseService implements SubCategoryService{

	@Autowired
	private SubCategoryRepository repository;

	@Override
	public List<SubCategory> findAll() {
		List<SubCategoryEntity> entity = this.repository.findAll();
		
		if(entity != null && !entity.isEmpty()) {
			return entity.stream().map( item -> item.toModel()).collect(Collectors.toList());
		} else {
			return null ;
		}
	}

	@Override
	public SubCategory findById(Long id) {
		Optional<SubCategoryEntity> entity = repository.findById(id);
		
		if(entity.isPresent()) {
			return entity.get().toModel();
		}
		return null;
	}
	
	@Override
	public SubCategory create(SubCategory model) {
		SubCategoryEntity entity = repository.save(new SubCategoryEntity(model));
		
		System.out.println(entity.getId());
		
		return entity.toModel();
	}

	@Override
	public SubCategory update(SubCategory model) {
			
		return repository.findById(model.getId()).map( result -> {
			
			result.setName(model.getName());
			
			return repository.save(result).toModel();
		}).orElseGet(() -> {
			return null;
		});
		
	}
	
	@Override
	public boolean deleteById(Long id) {
		
		Optional<SubCategoryEntity> result = repository.findById(id);
		
		if (result.isPresent()) {
			repository.deleteById(id);
			return true;
		}
		return false;
	}

}
