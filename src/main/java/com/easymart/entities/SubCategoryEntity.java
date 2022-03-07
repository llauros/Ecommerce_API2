package com.easymart.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.easymart.models.SubCategory;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_subcategoria")
public class SubCategoryEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O campo nome não pode estar em branco ou ser nulo")
	@Size(min = 3, max = 100, message = "O campo nome não pode conter menos que {min} e não deve ultrapassar a {max} caracteres")
	@Column(name = "nome", length = 100)
	private String name;
	
	/*@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private Category category;*/
	
	@JsonIgnore
	@ManyToMany(mappedBy = "subCategories")
	private Set<ProductEntity> products = new HashSet<>();
	
	public SubCategoryEntity() {}
	
	public SubCategoryEntity (SubCategory model) {
		this.id = model.getId();
		this.name = model.getName();
	}
	
	public SubCategoryEntity (String name) {
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
