package org.lu.ics.labbar;

import java.util.HashMap;

public class ProductDirectory {

	private HashMap<String, Product> products = new HashMap<String, Product>();

	public HashMap<String, Product> getProducts() {
		return products;
	}

	public void setProducts(HashMap<String, Product> products) {
		this.products = products;
	}

	public void addProducts(Product p) {
		products.put(p.getName(), p);

	}

	public Product findProduct(String name) {
		return products.get(name);
	}

	public Product removeProduct(String name) {
		Product p = this.findProduct(name);
		if (p.getName().equals(name)) {
			this.products.remove(name);
		}
		return p;
	}
}