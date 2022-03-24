package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.order.SalesOrder;

public class DaoSalesOrder {
	
	Connection con = DBConnection.getInstance().getDBcon();

	private String buildSalesOrderInsertString(SalesOrder salesOrder) {
		String salesOrderInsert = "INSERT INTO SaleOrder (orderId, employeeId, customerId, date, amount, deliveryStatus, deliveryDate) values ";
		salesOrderInsert += "('" + salesOrder.getOrderId() + "', '" + salesOrder.getEmployeeId() + "', '" + salesOrder.getCustomerId() + "', '" 
		+ "2022/03/24" + "', '" + salesOrder.getAmount()
		+ "', '" + salesOrder.getDeliveryStatus() + "', '" + "2022/03/28" + "')";
		
		System.out.println(salesOrderInsert);
		return salesOrderInsert;
	}
	
	public int insertSalesOrder(SalesOrder salesOrder) throws Exception {
		String salesOrderInsert = buildSalesOrderInsertString(salesOrder);
		int insertedKey = 1;
		
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(salesOrderInsert, Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = stmt.getGeneratedKeys();
			
			while (rs.next()) {
				insertedKey = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			insertedKey = -1;
			//these Exceptions should be replaced by my own ex: DatabaseLayerException
			throw new Exception("SQL exception");
		} catch (NullPointerException e) {
			insertedKey = -2;
			throw new Exception("Null pointer exception, possible connection problems");
		} catch (Exception e) {
			insertedKey = -3;
			throw new Exception("Technical error");
		} finally {
			//what exactly happens if you close con here instead?
			DBConnection.closeConnection();
		}
		
		return insertedKey;
	}
}