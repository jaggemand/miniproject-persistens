package DatabaseStubs;

import java.util.ArrayList;

import dal.OrderDBIF;
import model.Order;

public class OrderDBStub implements OrderDBIF{
	
	ArrayList<Order> list;
	
	public OrderDBStub() {
		list = new ArrayList<>();
	}
	@Override
	public Order addNewOrder(Order o) {
		// TODO Auto-generated method stub
		return o;
	}

}
