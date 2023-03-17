package test;

import model.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
Last updated: 17-03-2023

- Documentation and comments added and updated
*/
class OrderLineTest {
	
	Product testProduct;
	Product testProduct2;

	@BeforeEach
	void setUp() throws Exception {
		testProduct = new Product(1, "Test produkt", 45.5, 99.0, 30.0, "USA", 5, 1,50);
		testProduct2 = new Product(2, "Test produkt 2", 16.7, 50, 10, "Danmark", 30, 1,50);
	}

	/**

	Test case for the getProduct() method in the OrderLine class.
	*/
	@Test
	void getProduct(){
		// Arrange
	    OrderLine orderLine = new OrderLine(testProduct, 5);
	    
	    // Act
	    Product product = orderLine.getProduct();
	    
	    // Assert
	    assertEquals(testProduct, product);
	}
	
	/**

	Test case for the setProduct() method in the OrderLine class.
	*/
	@Test
	void setProduct(){
		// Arrange
	    OrderLine orderLine = new OrderLine(testProduct, 5);
	    
	    // Act
	    orderLine.setProduct(testProduct2);
	    
	    // Assert
	    assertNotEquals(testProduct, orderLine.getProduct());
	    assertEquals(testProduct2, orderLine.getProduct());
	}
	
	/**

	Test case for the getQuantity() method in the OrderLine class.
	*/
	@Test
	void getQuantity(){
		// Arrange
	    OrderLine orderLine = new OrderLine(testProduct, 5);
	    
	    // Act
	    int quantity = orderLine.getQuantity();
	    
	    // Assert
	    assertEquals(5, quantity);
	}
	
	/**

	Test case for the setQuantity() method in the OrderLine class.
	*/
	@Test
	void setQuantity(){
		// Arrange
	    OrderLine orderLine = new OrderLine(testProduct, 5);
	    
	    // Act
	    orderLine.setQuantity(8);
	    
	    // Assert
	    assertNotEquals(5, orderLine.getQuantity());
	    assertEquals(8, orderLine.getQuantity());
	}
	
	/**

	Test case for the getTotalPriceTest() method in the OrderLine class.
	*/
	@Test
	void getTotalPriceTest(){
		// Arrange
	    OrderLine orderLine = new OrderLine(testProduct, 5);
	    
	    // Act
	    double total = orderLine.getTotalPrice();
	    
	    // Assert
	    assertEquals(495, total);
	}

}
