package model.product;

public class Accessories extends Product {

	private int size;
	private String material;
	private String color;
	
	public Accessories(String name, String description, String category, String countryOfOrigin, int minStock,
			int stock, float purchasePrice, float salesPrice, float rentPrice, int size, String material,
			String color) {
		super(name, description, category, countryOfOrigin, minStock, stock, purchasePrice, salesPrice, rentPrice);
		this.size = size;
		this.material = material;
		this.color = color;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
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
