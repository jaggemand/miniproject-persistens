package test;

import model.*;
import controller.*;
import dal.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductTest {
	
	private ProductDB productDataBase;
	Product product;
	int identity;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	createTestProduct();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {

	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void shouldUpdateProductStockTo30() {
		productDataBase = new ProductDB();
		//Arrange
		Product checkProduct = null;
		boolean success = false;
		
		//Act
		ProductController productController = new ProductController(productDataBase);
		success = productController.updateProductStock(identity, 5);
		if (!success) {
			fail("Could not update product stock");
		} else {
			product = productController.findProductByProductNumber(1);	
		}
		
		//Assert
		assertEquals(30, checkProduct);
	}
	
	@Test
	void shouldReturn2Products() {
		//Arrange
		productDataBase = new ProductDB();
		ArrayList<Product> list = new ArrayList<>();
		ProductController productController = new ProductController(productDataBase);
		
		//Act
		list = productController.selectStockLocation(2);
		
		//Assert
		assertEquals(39, list.size());
	}
	
	
	static void createTestProduct() {
		//Arrange
		productDataBase = new ProductDB();
		ProductController productController = new ProductController(productDataBase);
		product = null;
		identity = -1;
		
		//Act
		product = productController.createNewProduct("Cowboy Hat", 100.0, 200.0, 50.0, "USA", 5, 25, 3, 1, 2);
		identity = product.getProductNumber();
		
		//Assert
		//?
	}

}
