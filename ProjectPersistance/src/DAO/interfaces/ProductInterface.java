package DAO.interfaces;

import java.util.Collection;

import model.product.Product;

public interface ProductInterface {
	public int create(Product product) throws Exception;
	public Product read(String id) throws Exception;
	public Product update(Product product) throws Exception;
	public void delete(Product product) throws Exception;
	public Collection<Product> findById(String id) throws Exception;
	public Collection<Product> findByAttributes(String type, String attributes) throws Exception;
	public Collection<Product> readAll() throws Exception;
}