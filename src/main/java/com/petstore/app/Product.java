package com.petstore.app;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {
	@JsonProperty("Id")
	private String id;
	
	@JsonProperty("Category")
	private String category;
	
	@JsonProperty("Name")
	private String name;
	
	@JsonProperty("Price")
	private BigDecimal price;
	
	private int quantity;

	public Product() {}
	
	public Product(String id, String category, String name, BigDecimal price, int quantity) {
		super();
		this.id = id;
		this.category = category;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}	
}
