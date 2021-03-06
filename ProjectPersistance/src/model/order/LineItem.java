package model.order;

import model.product.Product;

public class LineItem {

	private int quantity;
	private Product product;
	private SalesOrder saleOrder;
	
	public LineItem(int quantity, Product product) {
		super();
		this.quantity = quantity;
		this.setProduct(product);
	}
	
	public LineItem(int quantity, Product product, SalesOrder saleOrder) {
		super();
		this.quantity = quantity;
		this.product = product;
		this.saleOrder = saleOrder;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public SalesOrder getSaleOrder() {
		return saleOrder;
	}

	public void setSaleOrder(SalesOrder saleOrder) {
		this.saleOrder = saleOrder;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}