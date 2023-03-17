package dal;

import model.Order;
/**
Last updated: 17-03-2023

- Documentation and comments added
*/
/**
Interface for OrderDB. Defines method for adding a new order to the database.
*/
public interface OrderDBIF {
	/**
	Adds a new order to the database.
	@param o The Order object to be added.
	@return The Order object with updated information, including the generated order number.
	*/
	public Order addNewOrder(Order o);
}
