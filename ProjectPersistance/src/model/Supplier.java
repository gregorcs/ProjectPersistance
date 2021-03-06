package model;

import java.util.ArrayList;

import model.product.Product;

public class Supplier {

	private String name;
	private String address;
	private String country;
	private String phoneNumber;
	private String email;
	
	private ArrayList<Product> suppliedProducts;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public ArrayList<Product> getSuppliedProducts() {
		return suppliedProducts;
	}
	public void setSuppliedProducts(ArrayList<Product> suppliedProducts) {
		this.suppliedProducts = suppliedProducts;
	}
	
	
}
