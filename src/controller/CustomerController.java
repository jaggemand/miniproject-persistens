package controller;

import dal.CustomerDBIF;
import model.Customer;

/**
 * 
 * @author Nikolai
 * @version 1
 */
public class CustomerController {
	private CustomerDBIF customerDataBase;
	
	public CustomerController(CustomerDBIF customerDataBase) {
		this.customerDataBase = customerDataBase;
	}
	
	/**
	 * @param customerNumber
	 * @return Customer with given customerNumber
	 */
	public Customer findCustomerByCustomerNumber(int customerNumber) {
		return customerDataBase.findCustomerByCustomerNumber(customerNumber);
	}
}
