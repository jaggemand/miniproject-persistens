package test;

import model.*;
import controller.*;
import dal.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductTest {
	
	private ProductDB productDataBase;
	private Product testProduct1;
	private Product testProduct2;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		//testProduct1 = new Product(3, "Cowboy Hat", 100.0, 200.0, 50.0, "USA", 5, 1, 25);
		//testProduct2 = new Product(4, "Cowboy Vest", 150.0, 250.0, 100.0, "Hungary", 5, 2, 30);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void shouldUpdateProductStockTo30() {
		productDataBase = new ProductDB();
		//Arrange
		Product hello = null;
		boolean success = false;
		
		//Act
		ProductController productController = new ProductController(productDataBase);
		success = productController.updateProductStock(1, 5);
		if (!success) {
			fail("Could not update product stock");
		} else {
			hello = productController.findProductByProductNumber(1);	
		}
		
		//Assert
		assertEquals(30, hello.getStockAmount());
	}

}
