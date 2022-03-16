package com.easymart.entities;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.easymart.models.Category;

@Entity
@Table(name = "tb_categoria")
public class CategoryEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome", length = 100)
	private String name;
	
	@OneToMany(mappedBy = "category", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private Set<SubCategoryEntity> subCategories;
	
	@OneToMany(mappedBy = "category")
	private List<ProductEntity> products;
	
	public CategoryEntity() {}
	
	public CategoryEntity (Category model) {
		this.id = model.getId();
		this.name = model.getName();
	}
	
	public CategoryEntity (String name) {
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
	
	public Set<SubCategoryEntity> getSubCategories() {
		return subCategories;
	}
	public void setSubCategories(Set<SubCategoryEntity> subCategories) {
		this.subCategories = subCategories;
	}
	public List<ProductEntity> getProducts() {
		return products;
	}
	public void setProducts(List<ProductEntity> products) {
		this.products = products;
	}

	public Category toModel() {
		Category model = new Category();
		
		model.setId(this.id);
		model.setName(this.name);
		
		return model;
	} 
	
	public Category toModelSubcategoryList() {
		Category model = new Category();
		
		model.setId(this.id);
		model.setName(this.name);
		
		return model;
	}

}
