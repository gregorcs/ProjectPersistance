package controller.order;

import java.util.ArrayList;

import DAO.DaoSalesOrder;
import model.order.LineItem;
import model.order.SalesOrder;

public class SaleOrderController {

	private SalesOrder order;
	private DaoSalesOrder salesOrderDao;
	//bad orderId here
	private int orderId = 602;
	
	public void createSalesOrder(float amount, String deliveryStatus, String deliveryDate, String customerId, String employeeId, ArrayList<LineItem> itemsToBuy) {
		order = new SalesOrder( amount,  deliveryStatus,  deliveryDate,  customerId,  employeeId, itemsToBuy);
		
		try {
			salesOrderDao = new DaoSalesOrder();
			order.setOrderId(Integer.toString(orderId));
			salesOrderDao.create(order);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	public void createInvoice() {
	}
	
}