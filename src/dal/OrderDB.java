package dal;

import model.Order;

public class OrderDB implements OrderDBIF{

	private static final String INSERT_ORDER = "INSERT INTO sales_order(contact_customer_number_fk,date,order_status_id_fk,delivery_date,total_cost,payment_date) VALUES (?, ?, ?, ?, ?, ?)";
	private static final String INSERT_ORDERLINE = "INSERT INTO order_line(product_number_fk,sales_order_number_fk,product_quantity) VALUES (?, ?, ?)";
	
	public OrderDB() {
		
	}
	
	@Override
	public boolean addNewOrder(Order o) {
		// TODO Auto-generated method stub
		return false;
	}

}
