package model.order;

import model.product.Product;

public class LineItem {

	private int quantity;
	private Product product;
	private SalesOrder saleOrder;
	
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
}