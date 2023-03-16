package DatabaseStubs;

import dal.CustomerDBIF;
import model.Customer;

/**
 * 
 * @author Nikolai
 * @version 1
 * this class exists for the purpose of testing customerController
 */

public class CustomerDBStub implements CustomerDBIF {

	@Override
	public Customer findCustomerByCustomerNumber(int customerNumber) {
		return new Customer(1,"palle", "pallesen", "palle@palle.palle", "palle allé 30", "9999", "pallundia", "94113000");
	}

}
