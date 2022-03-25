package controller;

import java.util.Scanner;

import DAO.DaoCustomer;

public class CustomerController {
	public static void create() {
		String id, name, address, zipcode, city, phoneNumber;
		
		System.out.println("***** Customer Creation *****");
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Please enter the name of the customer:");
		name = keyboard.nextLine();
		
		System.out.println("Please enter the address of the customer:");
		address = keyboard.nextLine();
		
		System.out.println("Please enter the zipcode of the customer:");
		zipcode = keyboard.nextLine();
		
		System.out.println("Please enter the city of the customer:");
		city = keyboard.nextLine();
		
		System.out.println("Please enter the customer's phone number:");
		phoneNumber = keyboard.nextLine();
		
		id = phoneNumber;
		
		//DaoCustomer.create(id, name, address, zipcode, city, phoneNumber);
	}
}
