package DAO.interfaces;

import java.util.Collection;

import model.order.SalesOrder;

public interface SalesOrderInterface {
	
	public int create(SalesOrder salesOrder) throws Exception;
	public SalesOrder read(String id) throws Exception;
	public SalesOrder update(SalesOrder order) throws Exception;
	public void delete(SalesOrder order) throws Exception;
	public Collection<SalesOrder> findById(String id) throws Exception;
	public Collection<SalesOrder> findByAttributes(String type, String attributes) throws Exception;
	public Collection<SalesOrder> readAll() throws Exception;
}
