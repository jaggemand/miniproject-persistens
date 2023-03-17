package dal;

import model.Customer;

/**

Interface for CustomerDB class, defines the methods to be implemented by the class that will handle customer data storage and retrieval.
*/
public interface CustomerDBIF {
	
	/**
	Finds a customer in the database based on their customer number.
	@param customerNumber the customer number to search for.
	@return the customer object if found, null otherwise.
	*/
	public Customer findCustomerByCustomerNumber(int customerNumber);
}
