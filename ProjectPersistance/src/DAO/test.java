package DAO;

public class test {
	package databaselayer;

	import java.sql.Connection;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.ArrayList;

	import transportation.Vehicle;

	public class VehicleDao {

		Connection con = DBConnection.getInstance().getDBcon();
		
		private String buildInsertString(String VIN, String vehicleType, String brand, String model, double d) {
			String carInsert = "INSERT INTO Vehicle (VIN, vehicleType, vehicleBrand, vehicleSubBrand, pricePerHour) values ";
			carInsert += "('" + VIN + "', '" + vehicleType + "', '" + brand + "', '" + model + "', " + d + ")";	
			System.out.println(carInsert);
			return carInsert;
		}
		
		private String buildReadAllString() {
			String readAllVehicles = "SELECT * FROM Vehicle";
			System.out.println(readAllVehicles);
			return readAllVehicles;
		}
		
		private String buildDeleteString(Vehicle vehicle) {
			String deleteCar = "DELETE FROM Vehicle WHERE VIN=" + vehicle.getVIN();
			System.out.println(deleteCar);
			return deleteCar;
		}
		
		public int insertVehicle(Vehicle vehicle) throws Exception {
			String carInsert = buildInsertString(vehicle.getVIN(), vehicle.getVehicleType(), vehicle.getBrand(), vehicle.getModel(), vehicle.getPricePerHour());
			int insertedKey = 1;
			
			try {
				Statement stmt = con.createStatement();
				stmt.executeUpdate(carInsert, Statement.RETURN_GENERATED_KEYS);
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
		
		public void create(Vehicle vehicle) throws Exception {
			insertVehicle(vehicle);
		}


		public Object read() {
			// TODO Auto-generated method stub
			return null;
		}


		public void update() {
			// TODO Auto-generated method stub
			
		}


		public void delete(Vehicle vehicle) {
			
			try {
				
				
				
			} catch (Exception e) {
				System.out.println("Deletion went wrong: " + e.getMessage());
			}
		}


		public ArrayList<Vehicle> readAll() {
			ArrayList<Vehicle> vehicles = new ArrayList<>();
			String readAllString = buildReadAllString();
			
			String VIN;
			String vehicleType; 
			String brand; 
			String model;
			double pricePerHour;
			
			try {
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(readAllString);
			    while (rs.next()) {
			    	VIN = rs.getString(1);
			    	vehicleType = rs.getString(2);
			    	brand = rs.getString(3);
			    	model = rs.getString(4);
			    	pricePerHour = rs.getDouble(5);
			    	vehicles.add(new Vehicle(VIN, vehicleType, brand, model, pricePerHour));
			    }
			    stmt.close();
			} catch (SQLException e) {
				System.out.println("something went wrong when fetching data");
				e.printStackTrace();
			}
			
			return vehicles;
		}
	}
}
