package testcases;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import DAO.DaoProduct;
import DAO.DaoSalesOrder;
import model.order.SalesOrder;
import model.product.Product;

class ProductTests {

	@Test
	void ProductWasFoundById() {
		//Arrange
		boolean isCorrect = true;
		String idToBeFound = "0204";
		DaoProduct daoProduct= new DaoProduct();
		Product foundProduct = new Product();
		//Act
		try {
			//this clean, on god no cap
			foundProduct = daoProduct.read(idToBeFound);
		} catch (Exception e) {
			e.printStackTrace();
			isCorrect = false;
			System.out.println(e.getMessage());
		}
		System.out.print(foundProduct.getName());
		System.out.print(foundProduct.getCategory());
		//System.out.print(foundOrder.getItemsToBuy().get(0).getQuantity());
		//Assert
		assertEquals(idToBeFound, foundProduct.getProductId());
		assertTrue(isCorrect);	
		}

}
