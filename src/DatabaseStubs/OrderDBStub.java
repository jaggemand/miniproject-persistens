package DatabaseStubs;

import dal.OrderDBIF;
import model.Order;

public class OrderDBStub implements OrderDBIF{
	
	//TODO i don't if this makes sence to make a stub for as of right now
	@Override
	public boolean addNewOrder(Order o) {
		// TODO Auto-generated method stub
		return true;
	}

}
