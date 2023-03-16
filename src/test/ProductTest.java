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
	private static ProductDB productDataBase1;
	private static Product product1;
	private static Product product2;
	private static int identity1;
	private static int identity2;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		createTestProducts();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		removeTestProducts();
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
		// Arrange
		Product checkProduct = null;
		boolean success = false;

		// Act
		ProductController productController = new ProductController(productDataBase);
		success = productController.updateProductStock(identity1, 5);
		if (!success) {
			fail("Could not update product stock");
		} else {
			checkProduct = productController.findProductByProductNumber(identity1);
		}

		// Assert
		assertEquals(30, checkProduct.getStockAmount());
	}

	@Test
	void shouldReturn2Products() {
		// Arrange
		productDataBase = new ProductDB();
		ArrayList<Product> list = new ArrayList<>();
		ProductController productController = new ProductController(productDataBase);

		// Act
		list = productController.selectStockLocation(1);
		// Assert
		assertEquals(2, list.size());
	}

	static void createTestProducts() {
		// Arrange
		productDataBase1 = new ProductDB();
		ProductController productController = new ProductController(productDataBase1);
		product1 = null;
		product2 = null;
		identity1 = -1;
		identity2 = -1;

		// Act
		product1 = productController.createNewProduct("Cowboy Hat", 100.0, 200.0, 50.0, "USA", 5, 25, 3, 1, 1);
		product2 = productController.createNewProduct("Cowboy Hat", 100.0, 200.0, 50.0, "USA", 5, 25, 3, 1, 1);
		identity1 = product1.getProductNumber();
		identity2 = product2.getProductNumber();
	}

	static void removeTestProducts() {
		// Arrange
		productDataBase1 = new ProductDB();
		ProductController productController = new ProductController(productDataBase1);

		// Act
		productController.removeProduct(identity1);
		productController.removeProduct(identity2);
	}

}
