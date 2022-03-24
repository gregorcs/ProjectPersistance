package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.order.Invoice;

public class DaoInvoiceImplementation implements DaoInvoice{

	Connection con = DBConnection.getInstance().getDBcon();

	
	@Override
	public void create(Invoice invoice) {
		String insertString = "INSERT INTO Invoice (orderId, paymntDate, amount VALUES ";
		insertString += "("+invoice.getOrderId()+", "+invoice.getPayemntDate()+", "+invoice.getAmount()+")";
		Statement stmt;
		try {
			stmt = con.createStatement();
			stmt.executeUpdate(insertString);
		}catch(Exception e) {
			
		}
	}

	@Override
	public Invoice read(String id) {
		
		String readString = "SELECT * FROM Vehicle WHERE orderId = " + id;
		Statement stmt;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(readString);
			return new Invoice(rs.getInt(1), rs.getDate(2), rs.getInt(3));       //ARE THESE NUMBERS AND ORDER CORRECT???
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void update(Invoice invoice) {
		
	}

	@Override
	public void delete(Invoice invoice) {
		String deleteString = "DELETE FROM Invoice WHERE orderId="+invoice.getOrderId();
		Statement stmt;
		try {
			stmt = con.createStatement();
			stmt.executeUpdate(deleteString);
		}catch(Exception e) {
			
		}
	}

	@Override
	public Invoice findById(String id) {
		return null;
	}

	@Override
	public ArrayList<Invoice> readAll() {
		return null;
	}

}
