package controller.order;

import model.order.Invoice;
import model.order.SalesOrder;

public class SaleOrderController {

	private SalesOrder order;
	private Invoice invoice;
	
	public void createSalesOrder() {
		order = new SalesOrder();
	}
	
	public void createInvoice() {
		invoice = new Invoice();
	}
	
}