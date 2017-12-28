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
	private Copy copy;
	public int generateOrderLineNbr = 0;
	public int generateOrderId = 0;
	public int generateSerialNbr = 0;

	public Controller(CustomerDirectory cDir, ProductDirectory pDir, JFrame frame) {
		this.cDir = cDir;
		this.pDir = pDir;
		this.frame = frame;

	}

	public OrderLine createOrderLine(String number) {
		OrderLine l = new OrderLine(number);
		l.setNumber(number);
		return l;
	}

	public Copy createCopy(String serialNumber) {
		Copy c = new Copy(serialNumber);
		c.setserialNumber(serialNumber);
		return c;
	}

	public HashMap<String, Customer> getCustomers() {
		return this.cDir.getCustomers();
	}

	public HashMap<String, Product> getProducts() {
		return this.pDir.getProducts();
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

	public HashMap<String, Customer> grabCustomer() {
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

	public OrderLine addOrderLine(String number, int quantity) {
		OrderLine ol = new OrderLine(number);
		ol.setNumber(number);
		ol.setQuantity(0);
		return ol;

	}

	public Order addOrder(String orderID, String deliveryDate, String customerNumber) {
		Customer c = this.cDir.findCustomer(customerNumber);
		if (c != null) {
			Order o1 = new Order();
			o1.setOrderID(orderID);
			o1.setDeliveryDate(deliveryDate);
			o1.setCustomer(c);
			c.addOrder(o1);
		}
		return null;
	}

	public int howManyCopies(String name) {

		Product pr = findProduct(name);
		int howManyCopies = pr.getCopies().size();

		return howManyCopies - howManyReservedCopies(name);
	}

	public int howManyReservedCopies(String name) {
		// Copy co = findCopy(number);
		int copiesReserved = 0;

		for (Customer cu : getCustomers().values()) {
			for (Order or : cu.getOrders().values()) {
				for (OrderLine ol : or.getOrderLines().values()) {
					if (ol.getProduct() != null) {
						if (ol.getProduct().getName().equals(name)) {
							copiesReserved += ol.getQuantity();
						}
					}
				}
			}
		}
		return copiesReserved;

	}

	public OrderLine findOrderLine(String number) {
		for (Customer cu : getCustomers().values()) {
			for (Order or : cu.getOrders().values()) {
				if (or.getOrderLines().containsKey(number)) {
					return or.getOrderLines().get(number);

				}
			}
		}

		return null;
	}

	public String addCopyToOrderLine(int quantity, String number, String name) {
		OrderLine ol = findOrderLine(number);
		Product product = findProduct(name);
		if (ol.getProduct() == null || ol.getProduct().getName().equals(name)) {
			ol.setProduct(product);
			int x = howManyCopies(name);
			int olQuantity = quantity;
			if (olQuantity <= x) {

				ol.setQuantity(ol.getQuantity() + quantity);
				return null;
			} else {
				return "Det finns inte tillräckligt med exemplar";
			}
		}
		return "Produkten stämmer inte överrens med den på raden" ;
	}

	public Copy findCopy(String serialNumber) {
		Copy a = this.findCopy(serialNumber);
		return a;
	}

	public int getTotalCostForOrder(String orderID) {
		int total = 0;
		Order or = findOrder(orderID);
		if (or!=null)
		for (OrderLine ol : or.getOrderLines().values()) {
			if (ol.getProduct() != null) {
				total += (int) (ol.getQuantity() * ol.getProduct().getPrice());
			}
		}
		return total;
	}

	public Order findOrder(String orderID) {
		for (Customer ca : getCustomers().values()) {
			for (Order or : ca.getOrders().values()) {
				if (or.getOrderID().equals(orderID)) {
					return or;
				}
			}
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
