package model;

import java.util.ArrayList;
import java.util.Calendar;

public class Order {
	private ArrayList<OrderLine> orderLineList;
	private Customer customer;
	private int orderNumber;
	private Calendar deliveryDate;
	private Calendar paymentDate;
	private double totalCost;
	
	public Order() {
		//constructer is purposly empty
	}
	
	public Order(ArrayList<OrderLine> orderLineList, Customer customer, int orderNumber, Calendar deliveryDate,
			Calendar paymentDate, double totalCost) {
		this.orderLineList = orderLineList;
		this.customer = customer;
		this.orderNumber = orderNumber;
		this.deliveryDate = deliveryDate;
		this.paymentDate = paymentDate;
		this.totalCost = totalCost;
	}

	public boolean addProduct(Product product, int quantity) {
		//TODO
		return false;
	}
	
	public boolean setCustomer(Customer customer) {
		//TODO
		return false;
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
