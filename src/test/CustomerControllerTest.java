package test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import DatabaseStubs.CustomerDBStub;
import controller.CustomerController;
import model.Customer;

class CustomerControllerTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
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
	void customerNotNull() {
		//arrange
		CustomerController cc = new CustomerController(new CustomerDBStub());
		Customer customer = null;
		
		//act
		customer = cc.findCustomerByCustomerNumber(0);
		
		//assert
		assertNotEquals(customer, null);
	}

}
