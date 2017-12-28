package Githubtest;

import java.util.HashMap;

public class Customer {

	private String customerNumber;
	private String name;
	private String address;
	private CustomerDirectory customerDirectory;
	private HashMap<String, Order> orders = new HashMap<String, Order>();
	
	public Customer (String name, String customerNumber, String address) {
		this.name=name;
		this.customerNumber=customerNumber;
		this.address=address;
	}

	public String getCustomerNumber() {
		return this.customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public HashMap<String, Order> getOrders() {
		return this.orders;
	}

	public void setOrders(HashMap<String, Order> orders) {
		this.orders = orders;
	}

	public CustomerDirectory getCustomerDirecotry() {
		return this.customerDirectory;
	}

	public void setKundregister(CustomerDirectory customerDirectory) {
		this.customerDirectory = customerDirectory;
	}

	public void addOrder(Order o) {
		orders.put(o.getOrderID(), o);

	}

	public Order findOrder(String orderID) {
		return orders.get(orderID);
	}

	public Order removeOrder(String orderID) {
		Order o = this.findOrder(orderID);
		if (o.getOrderID().equals(orderID)) {
			this.orders.remove(orderID);
		}
		return null;
	}
}