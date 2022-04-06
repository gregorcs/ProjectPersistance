package controller;

import java.util.Scanner;

import controller.order.SaleOrderController;

import model.order.LineItem;
import model.order.SalesOrder;
import model.person.Customer;
import model.product.Product;

public class MainMenu {

	private Scanner scanner;
	private ProductController prodControl;
	private Product product;

	private String employeeId = "234";
	private String customerId = "543";
	private String deliveryStatus = "preparing";
	private String deliveryDate = "2022/03/25";
	private String orderId = "1148";

	
	public MainMenu() {
		scanner = new Scanner(System.in);
	}
	
	public void createNewOrder() {
		SalesOrder order = new SalesOrder();
		prodControl = new ProductController();
		SaleOrderController orderControl = new SaleOrderController();
		String idToFind;
		float finalAmount = 0;

		System.out.println("Welcome back!");

		int choice = 0;

		while (choice != 3) {

			checkout(order, choice, finalAmount, orderControl);
			System.out.println("1.To start adding products");
			System.out.println("3. To terminate");
			choice = scanner.nextInt();
			scanner.nextLine();
			switch (choice) {
			case 1:
				choice = menuChoice();
				switch (choice) {
				case 1:
					//addProductToOrder()		puts case 1 into a method
					int quantity = 0;
					quantity = chooseQuantity();
					LineItem lineItem = new LineItem(quantity, product);
					order.addLineItem(lineItem);
					break;
				default:
					break;
				}
				break;
			default:
				break;
			}
		}

	}

	private void addProductToOrder() {
		// TODO Auto-generated method stub
		
	}

	public int chooseQuantity() {
		int quantity = 0;
		System.out.println("Enter quantity: ");
		Scanner abc = new Scanner(System.in);
		
		if (abc.hasNextInt()) {
			quantity = abc.nextInt();
		}
		//error here somewhere
		
		return quantity;
		
	}
	
	public int menuChoice() {
		ProductController prodControl = new ProductController();
		int choice = 0;
		
		System.out.println("Enter id to find: ");
		String idToFind = scanner.nextLine();
		product = prodControl.getProduct(idToFind);
		System.out.println("Name: " + product.getName());
		System.out.println("Stock: " + product.getStock());
		System.out.println("Productid: " + product.getProductId());
		System.out.println("1. Add to basket");
		System.out.println("2. Purchase products");
		System.out.println("10. continue without adding");
		System.out.println("3. leave");
		
		choice = scanner.nextInt();
		return choice;
	}
	
	
	public void checkout(SalesOrder order, int choice, float finalAmount, SaleOrderController orderControl) {

		if (!order.getItemsToBuy().isEmpty()) {
			System.out.println("Do you want to check out? 1. Yes 2. No");
			choice = scanner.nextInt();
			if (choice == 1) {
				System.out.println(order.getItemsToBuy().get(0).getProduct().getName());
				order.setAmount(finalAmount);
				order.setOrderId(orderId);
				order.setDeliveryStatus(deliveryStatus);
				order.setDeliveryDate(deliveryDate);
				order.setCustomerId(customerId);
				order.setEmployeeId(employeeId);
				orderControl.createSalesOrder(order);
			} 
		} else {
			System.out.println("nothing to buy");
		}
	}

	public void createCustomer() {
		Customer customer = new Customer();
	}

	public int MainMenuText() {
		System.out.println("****** Main Menu ******");
		System.out.println(" (1) Create a New Order");
		System.out.println(" (0) Quit the Program");
		System.out.print("\n Choice:");

		while (!scanner.hasNextInt()) {
			System.out.println("Input must be a number - please try again.");
			scanner.nextLine();
		}
		int choice = scanner.nextInt();
		return choice;
	}
}
