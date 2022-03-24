package DAO.interfaces;

import model.order.SalesOrder;

public interface SalesOrderInterface {

	public String buildSalesOrderInsertString(SalesOrder salesOrder);
}
