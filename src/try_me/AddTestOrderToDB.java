package try_me;

import controller.OrderController;
import dal.CustomerDB;
import dal.OrderDB;
import dal.ProductDB;

public class AddTestOrderToDB {

	public static void main(String[] args) {
		//Products
		//1550 denim jeans
		//1557 cowboy vest
		//1585 cowboy hat
		
		//Customer
		//1004 Adam
		
		OrderController oc = new OrderController(new OrderDB(), new ProductDB(), new CustomerDB());
		
		oc.createNewOrder();
		
		oc.addProductToOrder(1550, 5);
		oc.addProductToOrder(1557, 2);
		oc.addProductToOrder(1585, 2);
		
		oc.addCustomerInformation(1004);
		
		oc.completeOrder();

	}

}
