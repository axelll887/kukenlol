package Githubtest;

import java.util.HashMap;

public class Order {

	private String orderID;
	private String deliveryDate;
	private Customer customer;
	private HashMap<String, OrderLine> orderLines = new HashMap<String, OrderLine>();

	public String getOrderID() {
		return this.orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public String getDeliveryDate() {
		return this.deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getCustomerName() {
		return this.customer.getName();
	}
	public Customer getCustomer() {
		return this.customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public HashMap<String, OrderLine> getOrderLines() {
		return this.orderLines;
	}

	public void setOrderLines(HashMap<String, OrderLine> orderLines) {
		this.orderLines = orderLines;
	}

	public void addOrderLine(OrderLine ol) {
		orderLines.put(ol.getNumber(), ol);

	}

	public OrderLine findOrderLines(String number) {
		return orderLines.get(number);
	}

	public OrderLine removeOrderLines(String number) {
		OrderLine ol = this.findOrderLines(number);
		if (ol.getNumber().equals(number)) {
			this.orderLines.remove(number);
		}
		return null;
	}
}
