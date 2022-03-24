package model.product;

import java.util.ArrayList;

public abstract class Product {

	private String productId;
	private String name;
	private String description;
	private String category;
	private String countryOfOrigin;
	private int minStock;
	private int stock;
	private float purchasePrice;
	private float salesPrice;
	private float rentPrice;	
	
	private String supplierId;
	
	private ArrayList<Product> productDB;
	
	public Product(String name, String productId, String description, String category, String countryOfOrigin, int minStock, int stock,
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
		this.productId = productId;
	}
	
	public Product() {
		
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

	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public ArrayList<Product> getProductDB() {
		return productDB;
	}

	public void setProductDB(ArrayList<Product> productDB) {
		this.productDB = productDB;
	}
}