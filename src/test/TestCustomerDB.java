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
	void shouldFindCustomerOnNumber3() {
		//arrange
		CustomerDB cdb = new CustomerDB();
		
		//act
		Customer c = cdb.findCustomerByCustomerNumber(3);
		
		//assert
		assertNotEquals(c, null);
	}
	
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
