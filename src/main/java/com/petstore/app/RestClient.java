package com.petstore.app;

import org.springframework.web.client.RestTemplate;

public class RestClient {	

	// TODO: Move to a configuration file
	public static final String API = "https://petstoreapp.azurewebsites.net/api/products/";

	public static Product[] getProducts() {
		try {
			RestTemplate restTemplate = new RestTemplate();
			return restTemplate.getForObject(API, Product[].class);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}		
	}
	
	public static Product getProduct(String id) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			return restTemplate.getForObject(API + id, Product.class);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}		
	}
}
