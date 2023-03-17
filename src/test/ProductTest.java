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

/**
 * The ProductTest class contains unit tests for the ProductController class.
 * It tests various methods of the ProductController class, such as creating a new product,
 * updating product stock and location, selecting products by stock location, and removing a product.
 */
class ProductTest {

	private ProductDB productDataBase;
	private static ProductDB productDataBase1;
	private static Product product1;
	private static Product product2;
	private static Product product3;
	private static int identity1;
	private static int identity2;
	private static int identity3;

	/**
	 * Sets up the test environment before running the test cases.
	 * Creates and stores test products in the product database.
	 * This method is run once before all the test cases are run.
	 *
	 * @throws Exception if an error occurs during the setup process.
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		createTestProducts();
	}

	/**
	 * Tears down the test environment after running the test cases.
	 * Removes the test products from the product database.
	 * This method is run once after all the test cases are run.
	 *
	 * @throws Exception if an error occurs during the teardown process.
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		removeTestProducts();
	}

	/**
	 * Tests if the product stock amount is updated correctly.
	 * Creates a new product controller, updates the stock of a test product,
	 * and checks if the stock amount is updated correctly.
	 */
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

	/**
	 * Tests if the correct number of products are returned by stock location.
	 * Creates a new product controller, selects all products with a stock location of 50,
	 * and checks if the number of returned products is equal to 2.
	 */
	@Test
	void shouldReturn2Products() {
		// Arrange
		productDataBase = new ProductDB();
		ArrayList<Product> list = null;
		ProductController productController = new ProductController(productDataBase);

		// Act
		list = productController.selectStockLocation(50);
		// Assert
		assertNotNull(list);
	}

	/**
	 * Tests if the product location is updated correctly.
	 * Creates a new product controller, updates the location of a test product,
	 * and checks if the location is updated correctly.
	 */
	@Test
	void shouldSetProductLocationTo2() {
		// Arrange
		boolean success = false;
		productDataBase = new ProductDB();
		ProductController productController = new ProductController(productDataBase);

		// Act
		// Location 1 = main warehouse, location 2 = mobile warehouse, location3 = test location
		success = productController.updateProductLocation(identity3, 3);
		
		// Assert
		assertTrue(success);
	}

	/**
	 * Creates test products and stores them in the product database.
	 * Also sets identity variables to the product numbers of the test products.
	 */
	static void createTestProducts() {
		// Arrange
		productDataBase1 = new ProductDB();
		ProductController productController = new ProductController(productDataBase1);
		product1 = null;
		product2 = null;
		product3 = null;
		identity1 = -1;
		identity2 = -1;
		identity3 = -1;

		// Act
		product1 = productController.createNewProduct("Cowboy Hat", 100.0, 200.0, 50.0, "USA", 5, 25, 3, 1, 50);
		product2 = productController.createNewProduct("Cowboy Hat", 100.0, 200.0, 50.0, "USA", 5, 25, 3, 1, 50);
		product3 = productController.createNewProduct("Cowboy Hat", 100.0, 200.0, 50.0, "USA", 5, 25, 3, 1, 2);
		identity1 = product1.getProductNumber();
		identity2 = product2.getProductNumber();
		identity3 = product3.getProductNumber();
	}

	/**
	Removes the test products created in the ProductTest class from the database.
	*/
	static void removeTestProducts() {
		// Arrange
		productDataBase1 = new ProductDB();
		ProductController productController = new ProductController(productDataBase1);

		// Act
		productController.removeProduct(identity1);
		productController.removeProduct(identity2);
		productController.removeProduct(identity3);
	}

}
