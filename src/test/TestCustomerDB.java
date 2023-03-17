package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dal.CustomerDB;
import model.Customer;

class TestCustomerDB {

	/**

	Test case to verify the functionality of the findCustomerByCustomerNumber() method in the CustomerDB class.
	*/
	@Test
	void shouldFindCustomerOnNumber3() {
		//arrange
		CustomerDB cdb = new CustomerDB();
		
		//act
		Customer c = cdb.findCustomerByCustomerNumber(3);
		
		//assert
		assertNotEquals(c, null);
	}
	
	/**
	Test case for checking that a customer cannot be found with customer number 0
	*/
	@Test
	void shouldNotfindCustomerOnNumber0() {
		//arrange
				CustomerDB cdb = new CustomerDB();
				
				//act
				Customer c = cdb.findCustomerByCustomerNumber(0);
				
				//assert
				assertEquals(c, null);
	}

}
