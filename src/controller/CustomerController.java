package controller;

import dal.CustomerDBIF;
import model.Customer;

/**
 * 
 * @author Nikolai
 * @version 1
 */
/**
Last updated: 17-03-2023

- Documentation and comments added
*/
public class CustomerController {
	private CustomerDBIF customerDataBase;
	
	/**
	Creates an instance of the CustomerController class with the given customer database.
	@param customerDataBase the customer database to use for storing and retrieving customer information.
	*/
	public CustomerController(CustomerDBIF customerDataBase) {
		this.customerDataBase = customerDataBase;
	}
	
	/**
	Finds the customer with the given customer number in the customer database.
	@param customerNumber the customer number to search for.
	@return the Customer object with the given customer number, or null if no such customer exists in the database.
	*/
	public Customer findCustomerByCustomerNumber(int customerNumber) {
		return customerDataBase.findCustomerByCustomerNumber(customerNumber);
	}
}
