package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import DAO.interfaces.SalesOrderInterface;
import model.order.LineItem;
import model.order.SalesOrder;

public class DaoSalesOrder implements SalesOrderInterface{
	
	Connection con = DBConnection.getInstance().getDBcon();

	
	public String buildSalesOrderInsertString(SalesOrder salesOrder) {
		//not good because of sql injection, would fix
		String salesOrderInsert = "INSERT INTO SaleOrder (orderId, employeeId, customerId, date, amount, deliveryStatus, deliveryDate) values ";
		salesOrderInsert += "('" + salesOrder.getOrderId() + "', '" + salesOrder.getEmployeeId() + "', '" + salesOrder.getCustomerId() + "', '" 
		+ salesOrder.getDate() + "', '" + salesOrder.getAmount()
		+ "', '" + salesOrder.getDeliveryStatus() + "', '" + salesOrder.getDeliveryDate() + "')";
		
		System.out.println(salesOrderInsert);
		return salesOrderInsert;
	}
	
	public PreparedStatement buildReadSalesOrderString(String id) {
		String readOrder = "SELECT * FROM SaleOrder WHERE orderId = ?";
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(readOrder);
			stmt.setString(1, id);
		} catch (SQLException e) {
			System.out.println(e + " Assembling prepared statement went wrong");
			e.printStackTrace();
		}
		return stmt;
	}
	
	public PreparedStatement buildReadLineItemString(String orderId) {
		String readOrder = "SELECT * FROM LineItem WHERE orderId = ?";
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(readOrder);
			stmt.setString(1, orderId);
		} catch (SQLException e) {
			System.out.println(e + " Assembling prepared statement went wrong");
			e.printStackTrace();
		}
		return stmt;
	}
	
	public String buildLineItemString(LineItem lineItem) {
		//this should throw an error
		String lineItemInsert = "INSERT INTO LineItem (orderId, productId, quantity) values ";
		lineItemInsert += "('" + lineItem.getSaleOrder().getOrderId() + "', '" + lineItem.getProduct().getProductId()+ "', '" 
		+ lineItem.getQuantity() + "')";
		System.out.println(lineItemInsert);
		
		return lineItemInsert;
	}

	
	public PreparedStatement buildProductUpdateString(int quantity, String productId) {
		String updateProduct = "UPDATE Product SET stock = stock - ? WHERE id = ?";
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(updateProduct);
			stmt.setString(1, Integer.toString(quantity));
			stmt.setString(2, productId);
		} catch (SQLException e) {
			System.out.println(e + " Assembling prepared statement went wrong");
			e.printStackTrace();
		}
		return stmt;
	}
	
	@Override
	public int create(SalesOrder salesOrder) throws Exception {
		String salesOrderInsert = buildSalesOrderInsertString(salesOrder);
		int insertedKey = 1;
		
		try {
		   // con.setAutoCommit(false);
			Statement stmt = con.createStatement();
			stmt.executeUpdate(salesOrderInsert, Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = stmt.getGeneratedKeys();
			
			for (LineItem lineItem : salesOrder.getItemsToBuy()) {
				String lineItemInsert = buildLineItemString(lineItem);
				stmt.executeUpdate(lineItemInsert);
				PreparedStatement updateItem = buildProductUpdateString(lineItem.getQuantity(), lineItem.getProduct().getProductId());
				updateItem.executeUpdate();
			}
			
			while (rs.next()) {
				insertedKey = rs.getInt(1);
			}
	       // con.commit();
			
		} catch (SQLException e) {
			insertedKey = -1;
			/*
			if (con != null) {
		        try {
		          System.err.print("Transaction is being rolled back");
		          con.rollback();
		        } catch (SQLException excep) {
		          System.out.println(excep.getMessage());
		        }
			}
			*/
			System.out.println(e.getMessage());
		} catch (NullPointerException e) {
			insertedKey = -2;
			throw new Exception("Null pointer exception, possible connection problems");
		} catch (Exception e) {
			insertedKey = -3;
			throw new Exception("Technical error");
		} finally {
			con.setAutoCommit(true);
			DBConnection.closeConnection();
		}
		
		return insertedKey;
	}
	
	@Override
	public SalesOrder read(String id) throws Exception {
		PreparedStatement stmt = buildReadSalesOrderString(id);
		SalesOrder fetchedOrder = new SalesOrder();
		
		try {
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				fetchedOrder.setOrderId(rs.getString("orderId"));
				fetchedOrder.setEmployeeId(rs.getString("employeeId"));
				fetchedOrder.setCustomerId(rs.getString("customerId"));
				fetchedOrder.setDate(rs.getString("date"));
				fetchedOrder.setAmount(rs.getString("amount"));
				fetchedOrder.setDeliveryStatus(rs.getString("deliveryStatus"));
				fetchedOrder.setDeliveryDate(rs.getString("deliveryDate"));
			}
			
		} catch (SQLException e) {
			//these Exceptions should be replaced by my own ex: DatabaseLayerException
			throw new Exception("SQL exception");
		} catch (NullPointerException e) {
			throw new Exception("Null pointer exception, possible connection problems");
		} catch (Exception e) {
			throw new Exception("Technical error");
		} finally {
			DBConnection.closeConnection();
		}
		return fetchedOrder;
	}

	@Override
	public SalesOrder update(SalesOrder order) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(SalesOrder order) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<SalesOrder> findById(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<SalesOrder> findByAttributes(String type, String attributes) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<SalesOrder> readAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
