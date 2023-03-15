package dal;

import model.Customer;

public interface CustomerDBIF {
	public Customer findCustomerByCustomerNumber(int customerNumber);
}
