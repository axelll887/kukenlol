package Githubtest;

import java.util.HashMap;

import javax.swing.JFrame;

public class Controller {
	private OrderLine orderLines;
	private Order orders;
	private Customer customer;
	private CustomerDirectory cDir;
	private ProductDirectory pDir;
	private JFrame frame; 
	private Product product;

	public Controller(CustomerDirectory cDir, ProductDirectory pDir, JFrame frame) {
		this.cDir = cDir; 
		this.pDir = pDir; 
		this.frame = frame; 
		

	}

	public Customer addCustomer(String name, String customerNumber, String address) {
		Customer aCustomer = new Customer(name, customerNumber, address);
		aCustomer.setName(name);
		aCustomer.setCustomerNumber(customerNumber);
		aCustomer.setAddress(address);

		this.cDir.addCustomer(aCustomer);
		return aCustomer;		

	}

	public Customer findCustomer(String customerNumber) {
		 return cDir.findCustomer(customerNumber);
	}

	public Customer removeCustomer(String customerNumber) {
		 return cDir.removeCustomer(customerNumber);
	}
	
	public HashMap<String, Customer> grabCustomer(){
		HashMap<String, Customer> c = cDir.getCustomers();
		return c;
	}

	public Product addProduct(String name, double price, String kategory) {
		Product p = new Product(name, price, kategory);
		p.setName(name);
		p.setPrice(price);
		p.setKategory(kategory);


		this.pDir.addProducts(p);
		return p;
	}

	public Product findProduct(String name) {
		
		return pDir.findProduct(name); 
	}

	public Product removeProduct(String name) {
		Product p = this.pDir.removeProduct(name);
		if (p != null) {
			return p;
		}
		return null;
	}

	public Order addOrder(String orderID, String deliveryDate, String customerNumber) {
		Customer c= this.cDir.findCustomer(customerNumber);
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

}
