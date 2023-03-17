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
	
	/**
	 * Test method to check that the findCustomerByCustomerNumber method
	 * returns a non-null Customer object.
	 */
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
