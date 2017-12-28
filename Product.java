package Githubtest;

import java.util.HashMap;

public class Product {

	private String name;
	private double price;
	private String kategory;
	private HashMap<String, OrderLine> orderLine = new HashMap<String, OrderLine>();
	private HashMap<String, Copy> copies = new HashMap<String, Copy>();
	private ProductDirectory productDirectory;
	
	public Product (String name, double price, String kategory ) {
		this.name=name;
		this.price=price;
		this.kategory=kategory;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getKategory() {
		return this.kategory;
	}

	public void setKategory(String kategory) {
		this.kategory = kategory;
	}

	public HashMap<String, OrderLine> getOrderLine() {
		return this.orderLine;
	}

	public void setOrderLine(HashMap<String, OrderLine> orderLine) {
		this.orderLine = orderLine;
	}

	public HashMap<String, Copy> getCopies() {
		return this.copies;
	}

	public void setCopies(HashMap<String, Copy> copies) {
		this.copies = copies;
	}

	public ProductDirectory getProductDirectory() {
		return this.productDirectory;
	}

	public void setProductDirectory(ProductDirectory productDirectory) {
		this.productDirectory = productDirectory;
	}

	public void addCopy(Copy c) {
		copies.put(c.getserialNumber(), c);

	}

	public Copy findCopy(String serialNumber) {
		return copies.get(serialNumber);
	}

	public Copy removeCopy(String serialNumber) {
		Copy e = this.findCopy(serialNumber);
		if (e!=null) {
			this.copies.remove(serialNumber);
		}
		return e;
	}
}
