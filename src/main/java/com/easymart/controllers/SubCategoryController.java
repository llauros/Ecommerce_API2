package com.easymart.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easymart.models.SubCategory;
import com.easymart.parameters.SubCategoryParameter;
import com.easymart.presenters.SubCategoryPresenter;
import com.easymart.services.SubCategoryService;

@RestController
@RequestMapping("/sub-categories")
public class SubCategoryController {

	@Autowired
	private SubCategoryService service;

	@GetMapping
	public ResponseEntity<List<SubCategoryPresenter>> findAll() {
		List<SubCategory> result = this.service.findAll();

		if (result != null) {		
			return new ResponseEntity(result.stream().map(a -> new SubCategoryPresenter(a)).collect(Collectors.toList()), HttpStatus.OK);
		}
		
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/{id}")
	public ResponseEntity<SubCategoryPresenter> findById(@PathVariable Long id) {
		SubCategory result = this.service.findById(id);

		if (result != null) {
			return new ResponseEntity(new SubCategoryPresenter(result), HttpStatus.OK);	
		}
		
		return new ResponseEntity(HttpStatus.NO_CONTENT);		
	}

	@PostMapping
	public ResponseEntity<SubCategoryPresenter> create(@RequestBody SubCategoryParameter parameter) {
		
		if (parameter != null) {
			SubCategory model = parameter.toModel();

			return new ResponseEntity(new SubCategoryPresenter(this.service.create(model)), HttpStatus.CREATED);	
		}
		
		return new ResponseEntity(HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<SubCategoryPresenter> update(@PathVariable Long id, @RequestBody SubCategoryParameter parameter) {
		
		if (parameter != null) {
			SubCategory user = parameter.toModel();
			user.setId(id);
			
			SubCategory result = this.service.update(user);
			
			if(result != null) {				
				return new ResponseEntity(new SubCategoryPresenter(result), HttpStatus.CREATED);
			} else {
				return new ResponseEntity(HttpStatus.NO_CONTENT);	
			}	
		}
		
		return new ResponseEntity(HttpStatus.NO_CONTENT);		
	}

	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		boolean result = this.service.deleteById(id);

		if (result) {
			return new ResponseEntity(HttpStatus.OK);
		}

		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

}
