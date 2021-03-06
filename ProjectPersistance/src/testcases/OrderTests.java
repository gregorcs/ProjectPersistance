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
	

	public void OrderWassAdded() {
		//Arrange
		boolean isCorrect = true;
		DaoSalesOrder salesOrderDao = new DaoSalesOrder();
		Miscallaneous misc = new Miscallaneous("necklace", "0204", "very good necklace", "necklace", "Bulgaria", 25,
				55, 4.52f, 4.60f, 5.00f, "you better buy it");

		//adding lineItem

		ArrayList<LineItem> itemsToBuy = new ArrayList<LineItem>();
		
		//assembling saleorder
		SalesOrder salesOrder = new SalesOrder("234", "on its way", "2022-04-24", "543", "234", itemsToBuy);
		salesOrder.setOrderId("587");
		LineItem lineItem = new LineItem(5, misc, salesOrder);
		itemsToBuy.add(lineItem);

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

	
	public void LineItemWasAdded() {
		//Arrange
		boolean isCorrect = true;
		DaoSalesOrder salesOrderDao = new DaoSalesOrder();
		Miscallaneous misc = new Miscallaneous("necklace", "346", "very good necklace", "necklace", "Bulgaria", 25,
				55, 4.52f, 4.60f, 5.00f, "you better buy it");

		//adding lineItem

		ArrayList<LineItem> itemsToBuy = new ArrayList<LineItem>();
		
		//assembling saleorder
		SalesOrder salesOrder = new SalesOrder("234", "on its way", "2022-04-24", "543", "234", itemsToBuy);
		salesOrder.setOrderId("575");
		LineItem lineItem = new LineItem(43, misc, salesOrder);
		itemsToBuy.add(lineItem);
		//Act
		try {
			//salesOrderDao.createLineItem(lineItem);
		} catch (Exception e) {
			e.printStackTrace();
			isCorrect = false;
			System.out.println(e.getMessage());
		}
		//Assert
		assertTrue(isCorrect);
	}

	
	@Test
	public void OrderWasFoundById() {
		//Arrange
		boolean isCorrect = true;
		String idToBeFound = "580";
		DaoSalesOrder salesOrderDao = new DaoSalesOrder();
		SalesOrder foundOrder = new SalesOrder();
		//Act
		try {
			//this clean, on god no cap
			foundOrder = salesOrderDao.read(idToBeFound);
		} catch (Exception e) {
			e.printStackTrace();
			isCorrect = false;
			System.out.println(e.getMessage());
		}
		System.out.print(foundOrder.getCustomerId());
		System.out.print(foundOrder.getDeliveryDate());
		//System.out.print(foundOrder.getItemsToBuy().get(0).getQuantity());
		//Assert
		assertEquals(idToBeFound, foundOrder.getOrderId());
		assertTrue(isCorrect);
	}
}
