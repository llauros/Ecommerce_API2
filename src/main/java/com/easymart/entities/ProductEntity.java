package com.easymart.entities;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.easymart.models.Category;
import com.easymart.models.Product;

@Entity
@Table(name = "tb_produto")
public class ProductEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "O campo nome não pode estar em branco ou ser nulo")
	@Size(min = 3, max = 100, message = "O campo nome não pode conter menos que {min} e não deve ultrapassar a {max} caracteres")
	@Column(name = "nome", length = 100)
	private String name;

	@NotBlank(message = "O campo descricao não pode estar em branco ou ser nulo")
	@Size(min = 3, max = 500, message = "O campo descricao não pode conter menos que {min} e não deve ultrapassar a {max} caracteres")
	@Column(name = "descricao", length = 500)
	private String description;

	@NotNull
	@Digits(integer = 5, fraction = 2, message = "Valor incorreto")
	@Column(name = "preco")
	private BigDecimal price;

	@Column(name = "foto")
	private String photo;
	
    @ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.REFRESH)
    @JoinColumn(name = "id_categoria")
	private CategoryEntity category;

	public ProductEntity() {}

	public ProductEntity(Product model) {
		this.name = model.getName();
		this.description = model.getDescription();
		this.price = model.getPrice();
		this.photo = model.getPhoto();
	}
	
	public ProductEntity(String name, String description, BigDecimal price, String photo, CategoryEntity category) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.photo = photo;
		this.category = category;
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
	public String getDescription() {
		return description;
	}	
	public void setDescription(String description) {
		this.description = description;
	}	
	public BigDecimal getPrice() {
		return price;
	}	
	public void setPrice(BigDecimal price) {
		this.price = price;
	}	
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}	
	public CategoryEntity getCategory() {
		return category;
	}
	public void setCategory(CategoryEntity category) {
		this.category = category;
	}

	public Product toModel() {
		Product model = new Product();

		model.setId(this.id);
		model.setName(this.name);
		model.setDescription(this.description);
		model.setPrice(this.price);
		model.setPhoto(this.photo);
		if(this.category != null) {
			model.setCategory(this.category.toModel());
		}
		
		return model;
	}
}
