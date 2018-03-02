package com.petstore.app;

import java.math.BigDecimal;
import java.util.List;

public class DatabaseBroker {

	// This is just for demo...would never work for real of course
	private static List<Product> tempProducts;
	
	public static int createOrder(int customerId, List<Product> products) {
		tempProducts = products;
		
		// ...
		
		int orderId = 1000;
		return orderId;
	}
	
	public static OrderSummary getOrderSummary(int customerId, int orderId) {
		OrderSummary orderSummary = new OrderSummary();
		orderSummary.setProducts(tempProducts);
		calculateTotal(orderSummary);
		return orderSummary;
	}
	
	public static BigDecimal calculateTotal(OrderSummary summary) {
		
		BigDecimal total = new BigDecimal(0.00);
		
		List<Product> products = summary.getProducts();
		for(Product product : products) {
			BigDecimal itemPrice = product.getPrice();
			itemPrice = itemPrice.multiply(new BigDecimal(product.getQuantity()));
			total = total.add(itemPrice);			
		}
		summary.setTotal(total);
		
		return total;
	}
}
