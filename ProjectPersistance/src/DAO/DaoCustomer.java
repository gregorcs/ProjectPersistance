package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

import DAO.interfaces.CustomerInterface;
import model.person.Customer;

public class DaoCustomer implements CustomerInterface {
	Connection con = DBConnection.getInstance().getDBcon();
	
	public String buildCustomerInsertString(Customer customer) {
		String productInsert = "INSERT INTO Customer () values "
					+ "('" + customer.getCustomerId() + "', '" + customer.getName() + "', '" + customer.getAddress()
					+ "', '" + customer.getZipcode() + "', '" + customer.getCity() + "', '" + customer.getPhoneNumber()
					+ "')";

				System.out.println(productInsert);
				return productInsert;
			}
			
			public PreparedStatement buildReadCustomerString(String id) {
				String readCustomer = "SELECT * FROM Customer WHERE customerId = ?";
				PreparedStatement stmt = null;
				try {
					stmt = con.prepareStatement(readCustomer);
					stmt.setString(1, id);
				} catch (SQLException e) {
					System.out.println(e + " Assembling prepared statement went wrong");
					e.printStackTrace();
				}
				return stmt;
			}
			
			public int create(Customer customer) throws Exception {
				String productInsert = buildCustomerInsertString(customer);
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

			public Customer read(String id) throws Exception {
				PreparedStatement stmt = buildReadCustomerString(id);
				Customer fetchedCustomer = new Customer();
				
				try {
					ResultSet rs = stmt.executeQuery();
					if (rs.next()) {
						fetchedCustomer.setCustomerId(rs.getString("productId"));
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
				return fetchedCustomer;
			}

			public Customer update(Customer customer) throws Exception {
				return null;
			}

			public void delete(Customer customer) throws Exception {
			
			}

			public Collection<Customer> findById(String id) throws Exception {
				return null;
			}

			public Collection<Customer> findByAttributes(String type, String attributes) throws Exception {
				return null;
			}

			public Collection<Customer> readAll() throws Exception {
				return null;
			}
}