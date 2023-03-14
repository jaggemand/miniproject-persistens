package model;

import java.util.ArrayList;
import java.util.Calendar;

public class Order {
	private ArrayList<OrderLine> orderLineList;
	private Customer customer;
	private int orderNumber;
	private double totalCost;
	private Calendar deliveryDate;
	private Calendar paymentDate;
	
	public Order() {
		//constructer is purposly empty
	}
	
	public boolean addProduct(Product product, int quantity) {
		//TODO
		return false;
	}
	
	public boolean setCustomer(Customer customer) {
		//TODO
		return false;
	}
}
