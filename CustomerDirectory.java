package org.lu.ics.labbar;

import java.util.HashMap;

public class CustomerDirectory {

	private HashMap<String, Customer> customers = new HashMap<String, Customer>();

	public HashMap<String, Customer> getCustomers() {
		return this.customers;
	}

	public void setCustomers(HashMap<String, Customer> customers) {
		this.customers = customers;
	}

	public void addCustomer(Customer c) {
		customers.put(c.getCustomerNumber(), c);

	}

	public Customer findCustomer(String customerNumber) {
		return this.customers.get(customerNumber);
	}

	public Customer removeCustomer(String customerNumber) {
		Customer c = this.findCustomer(customerNumber);
		if (c != null) {
			this.customers.remove(customerNumber);	 
		}
		return c; 
	
	}
