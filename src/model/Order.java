package model;

import java.util.ArrayList;
import java.util.Calendar;

/**
	Last updated: 15-03-2023
	
	- addProduct added
	- setAmount added
	- removeProduct added
	- getTotalPrice() added
	- Documentation and comments added
*/

public class Order {
	private ArrayList<OrderLine> orderLineList;
	private Customer customer;
	private int orderNumber;
	private Calendar creationDate;
	private Calendar deliveryDate;
	private Calendar paymentDate;
	private int orderStatus;
	private double totalCost;
	
	public Order() {
		//constructer is purposly empty
		this.orderLineList = new ArrayList<>();
		creationDate = Calendar.getInstance();
		deliveryDate = Calendar.getInstance();
		paymentDate = Calendar.getInstance();
	}
	
	public Order(ArrayList<OrderLine> orderLineList, Customer customer, int orderNumber,Calendar creationDate, Calendar deliveryDate,
			Calendar paymentDate, double totalCost, int orderStatus) {
		this.orderStatus = orderStatus;
		this.creationDate = creationDate;
		this.orderLineList = orderLineList;
		this.customer = customer;
		this.orderNumber = orderNumber;
		this.deliveryDate = deliveryDate;
		this.paymentDate = paymentDate;
		this.totalCost = totalCost;
	}
	/**

	Adds a product to the order, either by creating a new order line for the product,
	or by updating the quantity of an existing order line for the product.
	
	@param product The product to add to the order.	
	@param quantity The quantity of the product to add to the order.
	@return True if the product was added to the order, false otherwise.
	*/
	public boolean addProduct(Product product, int quantity) {
		// Create a new order line for the product and quantity
		OrderLine newOrderLine = new OrderLine(product, quantity);
		// Search for an existing order line for the product
		boolean found = false;
		
		for(int i = 0;!found && i<orderLineList.size(); i++){
			if(orderLineList.get(i).getProduct().equals(newOrderLine.getProduct())){
				// An existing order line for the product is found
				found = true;
				newOrderLine.setQuantity(orderLineList.get(i).getQuantity() + quantity);// Update the quantity of the order line
				orderLineList.remove(i); // Remove the existing order line
			}
		}
		// Add the new or updated order line to the order
		return orderLineList.add(newOrderLine);
	}
	
	/**
	Sets the quantity of a product in the order to a specified amount.
	
	@param product The product to set the quantity for.
	@param quantity The new quantity of the product in the order.
	@return True if the product is found in the order and the quantity is updated, false otherwise.
	*/
	public boolean setAmount(Product product, int quantity) {
		boolean found = false;
		
		// Search for the order line for the specified product
		for (int i = 0; !found && i < orderLineList.size(); i++) {
			if (orderLineList.get(i).getProduct().equals(product)) {
				// The order line for the product is found
				found = true;
				orderLineList.get(i).setQuantity(quantity); // Set the new quantity of the order line
			}
		}
		
		// Return true if the product was found and the quantity was updated, false otherwise
		return found;
	}
	
	/**
	
	Removes a product and its order line from the order.

	@param product The product to remove from the order.
	@return True if the product is found in the order and removed, false otherwise.
	*/
	public boolean removeProduct(Product product) {
		boolean found = false;
		
		// Search for the order line for the specified product
		for (int i = 0; !found && i < orderLineList.size(); i++) {
			if (orderLineList.get(i).getProduct().equals(product)) {
				// The order line for the product is found
				found = true;
				orderLineList.remove(i); // Remove the order line for the product
			}
		}
		
		// Return true if the product was found and removed, false otherwise
		return found;
	}
	
	/**
	
	Calculates the total price of the order.
	
	@return The total price of the order.
	*/
	public double getTotalPrice() {
		double total = 0;
		
		// Calculate the total price by summing the total prices of each order line in the order
		for (OrderLine orderLine : orderLineList) {
			total += orderLine.getTotalPrice();
		}
		
		// Return the total price of the order
		return total;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public ArrayList<OrderLine> getOrderLineList() {
		return orderLineList;
	}

	public void setOrderLineList(ArrayList<OrderLine> orderLineList) {
		this.orderLineList = orderLineList;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	
	public int getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Calendar getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Calendar deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Calendar getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Calendar paymentDate) {
		this.paymentDate = paymentDate;
	}
	
	public Calendar getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Calendar creationDate) {
		this.creationDate = creationDate;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public Customer getCustomer() {
		return customer;
	}
}
