package controller;

import java.util.Scanner;

import DAO.DaoCustomer;

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