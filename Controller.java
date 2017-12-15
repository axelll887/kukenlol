package org.lu.ics.labbar;

import java.util.HashMap;

public class Controller {
	private OrderLine orderLines;
	private Order orders;
	private Customer customer;
	private CustomerDirectory customerDirectory;
	private ProductDirectory productDirectory;

	public Controller(CustomerDirectory customerdirectory) {
		this.customerDirectory = customerDirectory;
		this.orders = orders;

	}

	public Customer addCustomer(String name, String customerNumber, String address) {
		Customer c = new Customer();
		c.setName(name);
		c.setCustomerNumber(customerNumber);

		this.customerDirectory.addCustomer(c);

		return c;
	}

	public Customer findCustomer(String customerNumber) {
		Customer c;
		c = this.customerDirectory.findCustomer(customerNumber);
		if (c != null) {
			return c;
		}
		return null;
	}

	public Customer removeCustomer(String customerNumber) {
		Customer c = this.customerDirectory.removeCustomer(customerNumber);
		if (c != null) {
			return c;
		}
		return null;
	}

	public Product addProduct(String name, String kategory, int price) {
		Product p = new Product();
		p.setName(name);
		p.setKategory(kategory);
		p.setPrice(price);

		this.productDirectory.addProducts(p);

		return p;
	}

	public Product findProduct(String name) {
		Product p;
		p = this.productDirectory.findProduct(name);
		if (p != null) {
			return p;
		}
		return null;
	}

	public Product removeProduct(String name) {
		Product p = this.productDirectory.removeProduct(name);
		if (p != null) {
			return p;
		}
		return null;
	}

	public Order addOrder(String orderID, String deliveryDate, String customerNumber) {
		Customer c= this.customerDirectory.findCustomer(customerNumber);
		if (c != null) {
			Order o1 = new Order();
			o1.setOrderID(orderID);
			o1.setDeliveryDate(deliveryDate);
			o1.setCustomer(c);
			c.addOrder(o1);
		}
		return null;
	}

	public String getOrder(String customerNumber) {
		Customer k = this.customerDirectory.findCustomer(customerNumber);
		if (k != null) {
			if (k.getOrders().size() == 0) {
				return k.getName() + "har inga ordrar.";
			}
			String t = "";
			for (Order o : k.getOrders().values()) {
				t += "Order: " + o.getOrderID() + " " + o.getDeliveryDate();

			}
			return t;
		}
		return "Det finns ingen med det personnumret";
	}

}
	
