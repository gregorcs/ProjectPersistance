package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

import DAO.interfaces.ProductInterface;
import model.product.Product;

public class DaoProduct implements ProductInterface {
	
	Connection con = DBConnection.getInstance().getDBcon();
	
	public String buildProductInsertString(Product product) {
		String productInsert = "INSERT INTO Product (productId, name,  description, category, countryOfOrigin, minStock, "
				+ "stock, purchasePrice, salesPrice, rentPrice) values "
				+ "('" + product.getProductId() + "', '" + product.getName() + "', '"
				+ product.getDescription() + "', '" + product.getCategory() + "', '" + product.getCountryOfOrigin()
				+ "', '" + product.getMinStock() + "', '" + product.getStock() + "', '" + product.getPurchasePrice()
				+ "', '" + product.getSalesPrice() + "', '" + product.getRentPrice() + "')";

			System.out.println(productInsert);
			return productInsert;
		}
		
		public PreparedStatement buildReadProductString(String id) {
			String readProduct = "SELECT * FROM Product WHERE productId = ?";
			PreparedStatement stmt = null;
			try {
				stmt = con.prepareStatement(readProduct);
				stmt.setString(1, id);
			} catch (SQLException e) {
				System.out.println(e + " Assembling prepared statement went wrong");
				e.printStackTrace();
			}
			return stmt;
		}
		
		public int create(Product product) throws Exception {
			String productInsert = buildProductInsertString(product);
			int insertedKey = 1;
			
			try {
				Statement stmt = con.createStatement();
				stmt.executeUpdate(productInsert, Statement.RETURN_GENERATED_KEYS);
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
				DBConnection.closeConnection();
			}
			
			return insertedKey;
		}

		public Product read(String id) throws Exception {
			PreparedStatement stmt = buildReadProductString(id);
			Product fetchedProduct = null;
			
			try {
				ResultSet rs = stmt.executeQuery();
				if (rs.next()) {
					fetchedProduct.setProductId(rs.getString("productId"));
					fetchedProduct.setName(rs.getString("name"));
					fetchedProduct.setDescription(rs.getString("description"));
					fetchedProduct.setCategory(rs.getString("category"));
					fetchedProduct.setCountryOfOrigin(rs.getString("countryOfOrigin"));
					fetchedProduct.setMinStock(rs.getInt("minStock"));
					fetchedProduct.setStock(rs.getInt("stock"));
					fetchedProduct.setPurchasePrice(rs.getFloat("purchasePrice"));
					fetchedProduct.setSalesPrice(rs.getFloat("salesPrice"));
					fetchedProduct.setRentPrice(rs.getFloat("rentPrice"));
				}
				
			} catch (SQLException e) {
				throw new Exception("SQL exception");
			} catch (NullPointerException e) {
				throw new Exception("Null pointer exception, possible connection problems");
			} catch (Exception e) {
				throw new Exception("Technical error");
			} finally {
				DBConnection.closeConnection();
			}
			return fetchedProduct;
		}

		public Product update(Product product) throws Exception {
			return null;
		}

		public void delete(Product product) throws Exception {
		
		}

		public Collection<Product> findById(String id) throws Exception {
			return null;
		}

		public Collection<Product> findByAttributes(String type, String attributes) throws Exception {
			return null;
		}

		public Collection<Product> readAll() throws Exception {
			return null;
		}
}