package model.product;

public class Clothing extends Product {

	private int size;
	private String gender;
	private String material;
	private String color;
	
	public Clothing(String name, String productId, String description, String category, String countryOfOrigin, int minStock, int stock,
			float purchasePrice, float salesPrice, float rentPrice, int size, String gender, String material,
			String color) {
		super(name, productId, description, category, countryOfOrigin, minStock, stock, purchasePrice, salesPrice, rentPrice);
		this.size = size;
		this.gender = gender;
		this.material = material;
		this.color = color;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	
}
