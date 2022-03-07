package com.easymart.presenters;

import java.math.BigDecimal;
import java.util.Set;
import java.util.stream.Collectors;

import com.easymart.models.Product;

public class ProductPresenter {
	private Long id;
	private String name;
	private String description;
	private BigDecimal price;
	private String photo;
	private CategoryPresenter category;
	private Set<SubCategoryPresenter> subCategories;
	
	public ProductPresenter(Product model) {
		this.id = model.getId();
		this.name = model.getName();
		this.description = model.getDescription();
		this.price = model.getPrice();
		this.photo = model.getPhoto();
		if(model.getCategory() != null) {
			this.category = new CategoryPresenter(model.getCategory());
		}
		if(model.getSubCategories() != null) {
			this.subCategories = model.getSubCategories()
					.stream().map( a -> new SubCategoryPresenter(a)).collect(Collectors.toSet());	
		}
	}
	
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public String getPhoto() {
		return photo;
	}
	public CategoryPresenter getCategory() {
		return category;
	}
	public Set<SubCategoryPresenter> getSubCategories() {
		return subCategories;
	}
	
}
