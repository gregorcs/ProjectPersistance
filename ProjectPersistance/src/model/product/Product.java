package model.product;

public abstract class Product {

	private String name;
	private String description;
	private String category;
	private String countryOfOrigin;
	private int minStock;
	private int stock;
	private float purchasePrice;
	private float salesPrice;
	private float rentPrice;	
	
	public Product(String name, String description, String category, String countryOfOrigin, int minStock, int stock,
			float purchasePrice, float salesPrice, float rentPrice) {
		super();
		this.name = name;
		this.description = description;
		this.category = category;
		this.countryOfOrigin = countryOfOrigin;
		this.minStock = minStock;
		this.stock = stock;
		this.purchasePrice = purchasePrice;
		this.salesPrice = salesPrice;
		this.rentPrice = rentPrice;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getCountryOfOrigin() {
		return countryOfOrigin;
	}
	public void setCountryOfOrigin(String countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
	}
	public int getMinStock() {
		return minStock;
	}
	public void setMinStock(int minStock) {
		this.minStock = minStock;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public float getPurchasePrice() {
		return purchasePrice;
	}
	public void setPurchasePrice(float purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	public float getSalesPrice() {
		return salesPrice;
	}
	public void setSalesPrice(float salesPrice) {
		this.salesPrice = salesPrice;
	}
	public float getRentPrice() {
		return rentPrice;
	}
	public void setRentPrice(float rentPrice) {
		this.rentPrice = rentPrice;
	}
	
	
}
