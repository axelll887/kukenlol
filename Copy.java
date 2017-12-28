package Githubtest;

public class Copy {
    
	private String serialNumber;
	private Product product;

	public Copy(String serialNumber) {
		this.serialNumber=serialNumber;
		
	}
	
	
	
	public String getserialNumber() {
		return this.serialNumber;
	}

	public void setserialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
