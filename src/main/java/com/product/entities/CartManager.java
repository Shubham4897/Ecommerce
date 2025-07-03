package com.product.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Cart")
public class CartManager {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long cartId;
	@Column
	private long quantity;
	@Column
	private String createdDate;
	@Column
    private String updatedDate;
	
	@JoinColumn(name="productId")
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnore
	private Product product;
	
	@JoinColumn(name="userId")
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnore
	private Users user;
	
	
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public long getCartId() {
		return cartId;
	}
	public void setCartId(long cartId) {
		this.cartId = cartId;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}
	public Long getProductId() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
