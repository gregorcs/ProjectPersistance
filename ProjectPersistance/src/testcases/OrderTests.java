package testcases;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;

import DAO.DBConnection;
import DAO.DaoSalesOrder;
import model.order.LineItem;
import model.order.SalesOrder;
import model.person.Customer;
import model.person.Employee;
import model.product.Miscallaneous;

class OrderTests {

	DBConnection con = DBConnection.getInstance();
	
	@Test
	public void OrderWassAdded() {
		//Arrange
		boolean isCorrect = true;
		DaoSalesOrder salesOrderDao = new DaoSalesOrder();
		Miscallaneous misc = new Miscallaneous("necklace", "346", "very good necklace", "necklace", "Bulgaria", 25,
				55, 4.52f, 4.60f, 5.00f, "you better buy it");
		//declaring persons
		Employee employee = new Employee("greg", "234");
		Customer customer = new Customer("543", "Alex", "thulevej", "9210", "Aalborg", "54323566", "yogmailcom");

		//adding lineItem
		LineItem lineItem = new LineItem(43, misc);
		ArrayList<LineItem> itemsToBuy = new ArrayList<LineItem>();
		itemsToBuy.add(lineItem);
		
		//assembling saleorder
		SalesOrder salesOrder = new SalesOrder(4266, "on its way", "2022-04-24", customer, employee, itemsToBuy);
		salesOrder.setOrderId("567");
		//Act
		try {
			salesOrderDao.create(salesOrder);
		} catch (Exception e) {
			e.printStackTrace();
			isCorrect = false;
			System.out.println(e.getMessage());
		}
		//Assert
		assertTrue(isCorrect);
	}

}
