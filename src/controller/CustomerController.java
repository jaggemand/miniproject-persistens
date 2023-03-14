package controller;

import dal.CustomerDBIF;
import model.Customer;

public class CustomerController {
	private CustomerDBIF customerDataBase;
	
	public CustomerController(CustomerDBIF customerDataBase) {
		
	}
	
	public Customer findCustomerByCustomerNumber(int customerNumber) {
		return null;
	}
}
