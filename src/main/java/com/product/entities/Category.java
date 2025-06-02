package com.product.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long categoryId;
	@Column
	private String categoryName;
	@Column
	private String createdCategoryDate;
	@Column
	private String updatedCategoryDate;
	
	@OneToMany(mappedBy = "category")
	@JsonManagedReference("category-subcategory")
	private List<SubCategory> subcategory;
	
	@OneToMany(mappedBy = "category")
	@JsonManagedReference("category-product")
	private List<Product> product;


	public long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCreatedCategoryDate() {
		return createdCategoryDate;
	}
	public void setCreatedCategoryDate(String createdCategoryDate) {
		this.createdCategoryDate = createdCategoryDate;
	}
	public String getUpdatedCategoryDate() {
		return updatedCategoryDate;
	}
	public void setUpdatedCategoryDate(String updatedCategoryDate) {
		this.updatedCategoryDate = updatedCategoryDate;
	}
	public List<SubCategory> getSubcategory() {
		return subcategory;
	}
	public void setSubcategory(List<SubCategory> subcategory) {
		this.subcategory = subcategory;
	}
	public List<Product> getProduct() {
		return product;
	}
	public void setProduct(List<Product> product) {
		this.product = product;
	}
	

}
