package controller;

import java.util.Scanner;

import DAO.DaoCustomer;

/*
public class MainMenu {

	public void MainMenu() {
		boolean running = true;
        while (running) {
            int choice = MainMenuText();
            switch (choice) {
                case 1:
                	CustomerController.create();
                  break;
                case 0:
                  System.out.println("You have been logged out successfully.");
                  running = false;
                  break;
                default:
                  System.out.println("Unknown error occurred.");
                  break;
            }
        }
        */
import java.util.ArrayList;
import java.util.Scanner;

import model.order.LineItem;
import model.person.Customer;
import model.product.Product;

public class MainMenu {

	private Scanner scanner;
	private ProductController prodControl;
	private Product product;
	private ArrayList<LineItem> basket;

	public void createNewOrder() {
		basket = new ArrayList<LineItem>();
		String idToFind;
		prodControl = new ProductController();
		scanner = new Scanner(System.in);
		System.out.println("Welcome back!");

		int choice = 0;

		while (choice != 3) {
			System.out.println("1.To start adding products");
			System.out.println("3. To terminate");
			choice = scanner.nextInt();
			scanner.nextLine();
			if (choice == 3) {
				break;
			} else {
				System.out.println("Enter id to find: ");
				idToFind = scanner.nextLine();
				product = prodControl.getProduct(idToFind);
				System.out.println("Name: " + product.getName());
				System.out.println("Stock: " + product.getStock());
				System.out.println("Productid: " + product.getProductId());
				System.out.println("1. Add to basket");
				System.out.println("2. continue without adding");
				System.out.println("3. leave");
				choice = scanner.nextInt();
	
				switch (choice) {
					case 1: int quantity = 0;
						System.out.println("Enter quantity: ");
						quantity = scanner.nextInt();
						scanner.nextLine();
						basket.add(new LineItem(quantity, product));
						break;
					default:
						break;
			}
			}
		}
	}
	
	public void createCustomer() {
		Customer customer = new Customer();
	}
    public int MainMenuText() {
    	Scanner keyboard = new Scanner(System.in);
        System.out.println("****** Main Menu ******");
        System.out.println(" (1) Create a New Order");
        System.out.println(" (0) Quit the Program");
        System.out.print("\n Choice:");

        while (!keyboard.hasNextInt()) {
            System.out.println("Input must be a number - please try again.");
            keyboard.nextLine();
        }
        int choice = keyboard.nextInt();
        return choice;
    }
}
