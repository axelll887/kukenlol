package org.lu.ics.labbar;

import java.util.HashMap;

public class CustomerDirectory {

	private HashMap<String, Customer> customers = new HashMap<String, Customer>();

	public HashMap<String, Customer> getCustomers() {
		return this.customers;
	}

	public void setKunder(HashMap<String, Customer> customers) {
		this.customers = customers;
	}

	public void addCustomer(Customer c) {
		customers.put(c.getCustomerNumber(), c);

	}

	public Customer findCustomer(String customerNumber) {
		return customers.get(customerNumber);
	}

	public Customer removeCustomer(String customerNumber) {
		Customer c = this.findCustomer(customerNumber);
		if (c.getCustomerNumber().equals(customerNumber)) {
			this.customers.remove(customerNumber);
		}
		return null;
	}
}