package test;

import model.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**

This class tests the functionalities of the Order class.
*/
class OrderTest {
	
	Product testProduct;
	Product testProduct2;
	
	Order testOrder;

	/**
	Sets up the initial state of the test environment.
	@throws Exception
	*/
	@BeforeEach
	void setUp() throws Exception {
		testOrder = new Order();
		testProduct = new Product(1, "Test produkt", 45.5, 99.0, 30.0, "USA", 5, 1,50);
		testProduct2 = new Product(2, "Test produkt 2", 16.7, 50, 10, "Danmark", 30, 1,50);
	}

	/**
	Tests if the product is added successfully to the order and the quantity is set correctly.
	*/
	@Test
	void addProductTest() {
		// Arrange
	    // The arrange step is done in the beforeAll and beforeEach
	    
	    // Act
	    boolean result = testOrder.addProduct(testProduct, 2);
	    
	    // Assert
	    assertTrue(result);
	    assertEquals(1, testOrder.getOrderLineList().size());
	    assertEquals(testProduct, testOrder.getOrderLineList().get(0).getProduct());
	    assertEquals(2, testOrder.getOrderLineList().get(0).getQuantity());
	}
	
	/**
	Tests if the quantity of an existing product is incremented correctly.
	*/
	@Test
	void addProductToIncrementTest() {
		// Arrange
	    // The arrange step is done in the beforeAll and beforeEach
	    
	    // Act
	    testOrder.addProduct(testProduct, 2);
	    testOrder.addProduct(testProduct, 5);
	    
	    // Assert
	    assertEquals(1, testOrder.getOrderLineList().size());
	    assertEquals(testProduct, testOrder.getOrderLineList().get(0).getProduct());
	    assertEquals(7, testOrder.getOrderLineList().get(0).getQuantity());
	}
	
	/**

	Tests if the quantity of a product is set correctly.
	*/
	@Test
	void setAmountTest() {
		// Arrange
	    testOrder.addProduct(testProduct, 2);
	    testOrder.addProduct(testProduct2, 5);
	    
	    // Act
	    testOrder.setAmount(testProduct, 1);
	    
	    // Assert
	    assertEquals(2, testOrder.getOrderLineList().size());
	    assertEquals(1, testOrder.getOrderLineList().get(0).getQuantity());
	}
	
	/**
	Tests if the product is removed successfully from the order.
	*/
	@Test
	void removeProductTest() {
		// Arrange
	    testOrder.addProduct(testProduct, 2);
	    testOrder.addProduct(testProduct2, 5);
	    
	    // Act
	    testOrder.removeProduct(testProduct2);
	    
	    // Assert
	    assertEquals(1, testOrder.getOrderLineList().size());
	    assertEquals(false, testOrder.getOrderLineList().contains(testProduct2));
	}
	
	/**
	Tests if the total price of the order is calculated correctly.
	*/
	@Test
	void getTotalPriceTest() {
		// Arrange
	    testOrder.addProduct(testProduct, 2);
	    testOrder.addProduct(testProduct2, 5);
	    
	    // Act
	    double total = testOrder.getTotalPrice();
	    
	    // Assert
	    assertEquals(448.0, total);
	}

}
