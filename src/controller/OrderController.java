package controller;

import java.util.Calendar;

import dal.CustomerDBIF;
import dal.OrderDBIF;
import dal.ProductDBIF;
import model.Customer;
import model.Order;

/**
Last updated: 17-03-2023

- Documentation and comments added
*/

public class OrderController {
	private Order currentOrder;
	private OrderDBIF odb;
	private ProductDBIF pdb;
	private CustomerDBIF cdb;
	
	
	/**
	Creates an instance of the OrderController class with the given order database, product database, and customer database.
	@param orderDataBase the order database to use for storing and retrieving orders.
	@param productDatabase the product database to use for retrieving product information.
	@param customerDatabase the customer database to use for retrieving customer information.
	*/
	public OrderController(OrderDBIF orderDataBase, ProductDBIF productDatabase, CustomerDBIF customerDatabase) {
		this.odb = orderDataBase;
		this.pdb = productDatabase;
		this.cdb = customerDatabase;
	}
	
	/**
	Creates a new order and sets its delivery date, payment date, and order status.
	@return the new Order object.
	*/
	public Order createNewOrder() {
		// Create a new Order object and assign it to the currentOrder variable.
		currentOrder = new Order();

		// Set the delivery date of the new order to 7 days from the current date.
		currentOrder.getDeliveryDate().add(Calendar.DAY_OF_MONTH, 7);

		// Set the payment date of the new order to 30 days from the current date.
		currentOrder.getPaymentDate().add(Calendar.DAY_OF_MONTH, 30);

		// Set the order status of the new order to 1 (i.e. "Pending").
		currentOrder.setOrderStatus(1);

		// Return the new Order object.
		return currentOrder;
	}
	
	/**
	Adds a product to the current order with the given product number and quantity.
	@param productNumber the product number to search for.
	@param quantity the quantity of the product to add to the order.
	@return true if the product was successfully added to the order, false otherwise.
	*/
	public boolean addProductToOrder(int productNumber, int quantity) {
		// Find the product in the product database by its product number and add it to the order
		// using the currentOrder's addProduct method.
		return currentOrder.addProduct(pdb.findProductByProductNumber(productNumber), quantity);
	}
	
	/**
	Adds customer information to the current order by finding the customer
	with the given customer number and setting it as the order's customer.
	@param customerNumber the customer number to search for.
	@return true if the customer was found and added to the order successfully, false otherwise.
	*/
	public boolean addCustomerInformation(int customerNumber) {
		// Find the customer with the given customer number.
		Customer newCustomer = cdb.findCustomerByCustomerNumber(customerNumber);
		boolean success = false;
		// If the customer is found, set it as the order's customer and set success to true.
		if(newCustomer != null) {
			currentOrder.setCustomer(newCustomer);
			success = true;
		}
		
		return success;
	}
	
	/**
	Completes the current order by setting its status to 2, calculating the total cost,
	and adding it to the order database.
	@return true if the order was successfully completed, false otherwise.
	*/
	public boolean completeOrder() {
		
		boolean success = false;
		// Check if the order has a customer and at least one order line.
		if(currentOrder.getCustomer() != null && currentOrder.getOrderLineList().size() > 0) {
			currentOrder.setOrderStatus(2);
			currentOrder.setTotalCost(currentOrder.getTotalPrice());
			odb.addNewOrder(currentOrder);
			success = true;
		}
		
		return success;
	}
}
