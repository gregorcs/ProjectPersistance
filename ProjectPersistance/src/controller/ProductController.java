package controller;

import java.util.ArrayList;

import DAO.DaoProduct;
import model.product.Product;

public class ProductController {
	public Product getProduct(String id) {
		DaoProduct daoProduct = new DaoProduct();
		try {
			return daoProduct.read(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Product> getProductList(String type, String attributes) {
		return null;
	}
}