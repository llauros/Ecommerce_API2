package com.easymart.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.easymart.models.Category;
import com.easymart.models.SubCategory;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_subcategoria")
public class SubCategoryEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome", length = 100)
	private String name;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria")
	private CategoryEntity category;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "subCategories")
	private Set<ProductEntity> products = new HashSet<>();
	
	public SubCategoryEntity() {}
	
	public SubCategoryEntity (SubCategory model) {
		this.id = model.getId();
		this.name = model.getName();
		
		if(model.getCategory() != null) {
			this.category = new CategoryEntity(model.getCategory());
		}
	}	
	
	// Ambiente de Testes
	public SubCategoryEntity (String name, Category model) {
		this.name = name;
		
		if(model != null) {
			this.category = new CategoryEntity(model);
		}
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
	
	public CategoryEntity getCategory() {
		return category;
	}
	public void setCategory(CategoryEntity category) {
		this.category = category;
	}
	public Set<ProductEntity> getProducts() {
		return products;
	}
	//Quando trabalamos con coleções, devemos somente usar get
	public void setProducts(Set<ProductEntity> products) {
		this.products = products;
	}

	public SubCategory toModel() {
		SubCategory model = new SubCategory();
		
		model.setId(this.id);
		model.setName(this.name);
		
		return model;
	}
	
}
