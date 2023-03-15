package test;

import model.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderLineTest {
	
	Product testProduct;
	Product testProduct2;

	@BeforeEach
	void setUp() throws Exception {
		testProduct = new Product(1, "Test produkt", 45.5, 99.0, 30.0, "USA", 5, 1,50);
		testProduct2 = new Product(2, "Test produkt 2", 16.7, 50, 10, "Danmark", 30, 1,50);
	}

	@Test
	void getProduct(){
		// Arrange
	    OrderLine orderLine = new OrderLine(testProduct, 5)
	    
	    // Act
	    Product product = orderLine.getProduct();
	    
	    // Assert
	    assertEquals(testProduct, product);
	}


}
