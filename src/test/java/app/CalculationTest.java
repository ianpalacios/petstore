package app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.petstore.app.DatabaseBroker;
import com.petstore.app.OrderSummary;
import com.petstore.app.Product;

public class CalculationTest {
	
	@Test
	public void calculateSingleProduct() {
		
		OrderSummary summary = new OrderSummary();
		List<Product> products = new ArrayList<Product>();
		products.add(new Product("1", "Test Category", "Test Name", new BigDecimal(9.00), 2));
		summary.setProducts(products);
		
		BigDecimal total = DatabaseBroker.calculateTotal(summary);
		assertEquals(new BigDecimal(18.00), total);
	}
	
	@Test
	public void calculateMultiProduct() {
		
		OrderSummary summary = new OrderSummary();
		List<Product> products = new ArrayList<Product>();
		products.add(new Product("1", "Test Category", "Test Name", new BigDecimal(5.00), 1));
		products.add(new Product("2", "Test Category", "Test Name", new BigDecimal(5.00), 2));
		summary.setProducts(products);
		
		BigDecimal total = DatabaseBroker.calculateTotal(summary);
		assertEquals(new BigDecimal(15.00), total);
	}
}
