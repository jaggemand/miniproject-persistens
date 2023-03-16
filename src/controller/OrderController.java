package controller;

import java.util.Calendar;

import dal.CustomerDBIF;
import dal.OrderDBIF;
import dal.ProductDBIF;
import model.Customer;
import model.Order;

public class OrderController {
	private Order currentOrder;
	private OrderDBIF orderDataBase;
	private ProductDBIF pdb;
	private CustomerDBIF cdb;
	
	public OrderController(OrderDBIF orderDataBase, ProductDBIF productDatabase, CustomerDBIF customerDatabase) {
		this.orderDataBase = orderDataBase;
		this.pdb = productDatabase;
		this.cdb = customerDatabase;
	}
	
	public Order createNewOrder() {
		
		currentOrder = new Order();
		currentOrder.getDeliveryDate().add(Calendar.DAY_OF_MONTH, 7);
		currentOrder.getPaymentDate().add(Calendar.DAY_OF_MONTH, 30);
		currentOrder.setOrderStatus(1);
		
		return null;
	}
	
	public boolean addProductToOrder(int productNumber, int quantity) {
		return currentOrder.addProduct(pdb.findProductByProductNumber(productNumber), quantity);
	}
	
	public boolean addCustomerInformation(int customerNumber) {
		
		Customer newCustomer = cdb.findCustomerByCustomerNumber(customerNumber);
		boolean success = false;
		
		if(newCustomer != null) {
			currentOrder.setCustomer(newCustomer);
			success = true;
		}
		
		return success;
	}
	
	public boolean completeOrder() {
		
		boolean success = false;
		
		//TODO: maybe do the transaction to deduct items from stock
		
		if(currentOrder.getCustomer() != null && currentOrder.getOrderLineList().size() > 0) {
			currentOrder.setOrderStatus(2);
			currentOrder.setTotalCost(currentOrder.getTotalPrice());
			orderDataBase.addNewOrder(currentOrder);
			success = true;
		}
		
		return success;
	}
}
