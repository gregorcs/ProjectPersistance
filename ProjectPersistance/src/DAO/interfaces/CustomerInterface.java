package DAO.interfaces;

import java.util.Collection;

import model.person.Customer;

public interface CustomerInterface {
	public int create(Customer customer) throws Exception;
	public Customer read(String id) throws Exception;
	public Customer update(Customer customer) throws Exception;
	public void delete(Customer customer) throws Exception;
	public Collection<Customer> findById(String id) throws Exception;
	public Collection<Customer> findByAttributes(String type, String attributes) throws Exception;
	public Collection<Customer> readAll() throws Exception;
}
