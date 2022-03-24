package model.product;

public class Miscallaneous extends Product {

	private String details;

	public Miscallaneous(String name, String description, String category, String countryOfOrigin, int minStock,
			int stock, float purchasePrice, float salesPrice, float rentPrice, String details) {
		super(name, description, category, countryOfOrigin, minStock, stock, purchasePrice, salesPrice, rentPrice);
		this.details = details;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
	
	
}
