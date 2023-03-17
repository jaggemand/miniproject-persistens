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
/**
Last updated: 17-03-2023

- Documentation and comments added and updated
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
	
	/**
	Sets the customer for the order
	@param customer The customer to set
	*/
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	Gets the list of order lines for the order
	@return The list of order lines
	*/
	public ArrayList<OrderLine> getOrderLineList() {
		return orderLineList;
	}

	/**
	Sets the list of order lines for the order
	@param orderLineList The list of order lines to set
	*/
	public void setOrderLineList(ArrayList<OrderLine> orderLineList) {
		this.orderLineList = orderLineList;
	}

	/**
	Gets the order number for the order
	@return The order number
	*/
	public int getOrderNumber() {
		return orderNumber;
	}

	/**
	Sets the order number for the order
	@param orderNumber The order number to set
	*/
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	
	/**
	Returns the current status of the order.
	@return An integer representing the current status of the order.
	*/
	public int getOrderStatus() {
		return orderStatus;
	}

	/**
	Sets the order status of the current order to the specified value.
	@param orderStatus an integer representing the new order status
	*/
	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}

	  /**
     * Returns the expected delivery date for this order.
     * @return the expected delivery date for this order
     */
	public Calendar getDeliveryDate() {
		return deliveryDate;
	}

    /**
     * Sets the expected delivery date for this order.
     * @param deliveryDate the new expected delivery date for this order
     */
	public void setDeliveryDate(Calendar deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

    /**
     * Returns the date on which payment for this order was made.
     * @return the date on which payment for this order was made
     */
	public Calendar getPaymentDate() {
		return paymentDate;
	}

    /**
     * Sets the date on which payment for this order was made.
     * @param paymentDate the new date on which payment for this order was made
     */
	public void setPaymentDate(Calendar paymentDate) {
		this.paymentDate = paymentDate;
	}
	
	  /**
     * Returns the date on which this order was created.
     * @return the date on which this order was created
     */
    public Calendar getCreationDate() {
        return creationDate;
    }
    
    /**
     * Sets the date on which this order was created.
     * @param creationDate the new date on which this order was created
     */
    public void setCreationDate(Calendar creationDate) {
        this.creationDate = creationDate;
    }
    
    /**
     * Returns the total cost of this order.
     * @return the total cost of this order
     */
    public double getTotalCost() {
        return totalCost;
    }

    /**

    Sets the total cost of the order.
    @param totalCost the total cost of the order.
    */
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	/**
	Returns the customer who placed the order.
	@return the customer who placed the order
	*/
	public Customer getCustomer() {
		return customer;
	}
}
