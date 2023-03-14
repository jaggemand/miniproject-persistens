package dal;

import model.Customer;

public interface CustomerDBIF {
	public Customer findCustomerByCustomerNumber(String customerNumber);
}
