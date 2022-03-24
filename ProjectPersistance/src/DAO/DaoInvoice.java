package DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import model.order.Invoice;

public interface DaoInvoice{
	
	public void create(Invoice invoice);
	
	public Invoice read(String id) throws SQLException;
	
	public void update(Invoice invoice);
	
	public void delete(Invoice invoice);
	
	public Invoice findById(String id);
	
	public ArrayList<Invoice> readAll();
	
	
}
