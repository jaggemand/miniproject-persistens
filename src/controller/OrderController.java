package controller;

import dal.OrderDBIF;
import model.Order;

public class OrderController {
	private Order currentOrder;
	private OrderDBIF orderDataBase;
	
	public OrderController(OrderDBIF orderDataBase) {
		
	}
	
	public Order createNewOrder() {
		return null;
	}
	
	public boolean addProductToOrder(int productNumber, int quantity) {
		return false;
	}
	
	public boolean addCustomerInformation(int customerNumber) {
		return false;
	}
	
	public boolean completeOrder() {
		return false;
	}
}
