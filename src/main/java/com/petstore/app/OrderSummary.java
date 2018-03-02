package com.petstore.app;

import java.math.BigDecimal;
import java.util.List;

public class OrderSummary {
	
	private BigDecimal total;
	private List<Product> products;
	
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
}
