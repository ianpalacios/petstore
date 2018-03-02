package com.petstore.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class AppController {

	/*
	 * Pass in a list of Items { "itemId":1000, "quantity":1 }
	 */
    @RequestMapping(value = "/orders/{customerId}", method = RequestMethod.POST)
    public ResponseEntity<Integer> createOrder(@PathVariable("customerId") int customerId, @RequestBody List<Item> items, UriComponentsBuilder ucBuilder) {
        System.out.println("entering createOrder...");
        
        List<Product> cart = new ArrayList<Product>();
        for(Item item : items) {
        	String itemId = item.getItemId();
        	int quantity = item.getQuantity();
        	Product p = RestClient.getProduct(itemId);
        	p.setQuantity(quantity);
        	System.out.println("Product Id: " + p.getId());
        	
        	cart.add(p);
        }
        
        int orderId = DatabaseBroker.createOrder(customerId, cart);
        System.out.println("orderId: " + orderId);
        
        return new ResponseEntity<Integer>(new Integer(orderId), HttpStatus.CREATED);
    }   
    
    @RequestMapping(value = "/orders/{orderId}/customers/{customerId}", method = RequestMethod.GET)
    public ResponseEntity<OrderSummary> getOrderSummary(@PathVariable("orderId") int orderId, @PathVariable("customerId") int customerId) {
    	
    	OrderSummary orderSummary = DatabaseBroker.getOrderSummary(customerId, orderId);
    	
        return new ResponseEntity<OrderSummary>(orderSummary, HttpStatus.OK);
    }

}
