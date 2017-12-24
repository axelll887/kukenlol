package org.lu.ics.labbar;

import java.util.HashMap;

import javax.swing.JFrame;

public class Controller {
	private OrderLine orderLines;
	private Order orders;
	private Customer customer;
	private CustomerDirectory cDir;
	private ProductDirectory pDir;
	private JFrame frame; 

	public Controller(CustomerDirectory cDir, ProductDirectory pDir, JFrame frame) {
		this.cDir = cDir; 
		this.pDir = pDir; 
		this.frame = frame; 
		

	}
	
	public Copy createCopy(String serialnumber) {
		Copy c = new Copy();
		c.setSerialnumber(serialnumber);
		return c;
	}

	public Customer addCustomer(String customerNumber, String name, String address) {
		Customer aCustomer = new Customer(customerNumber, name, address);
		aCustomer.setCustomerNumber(customerNumber);
		aCustomer.setName(name);
		aCustomer.setAddress(address);

		this.cDir.addCustomer(aCustomer);
		return aCustomer; 
		

	}

	public Customer findCustomer(String customerNumber) {
		return cDir.findCustomer(customerNumber);
	}

	public Customer removeCustomer(String customerNumber) {
		Customer customer = this.cDir.removeCustomer(customerNumber);
		if(customer != null){
		return customer;
	}
	return null; 
	}
	
	public HashMap<String, Customer> grabCustomer(){
		HashMap<String, Customer> customers = cDir.getCustomers();
		return customers;
	}

	public Product addProduct(String productName, double price, String kategory) {
		Product aProduct = new Product(productName, price, kategory);
		aProduct.setProductName(productName);
		aProduct.setKategory(kategory);
		aProduct.setPrice(price);

		this.pDir.addProducts(aProduct);
		return aProduct;
	}

	public Product findProduct(String productName) {
		return pDir.findProduct(productName); 
		
	}

	public Product removeProduct(String productName) {
		Product p = pDir.removeProduct(productName);
		if (p != null) {
			return p;
		}
		return null; 
		
	}

	public  void addOrder(String orderID, String deliveryDate) {
			Order order = new Order();
			order.setOrderID(orderID);
			order.setDeliveryDate(deliveryDate);
			customer.addOrder(order);
		
	}

	public String getOrder(String customerNumber) {
		Customer k = this.cDir.findCustomer(customerNumber);
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
	
	public Copy addCopy(String serialnumber, String productName) {
		Product p = this.pDir.findProduct(productName);
		if(p != null) {
			Copy c = new Copy(); 
			c.setSerialnumber(serialnumber);
			c.setProduct(p);
			p.addCopy(c);
		}
		return null; 
		
	}

}
	
