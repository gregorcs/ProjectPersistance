package model.order;

import java.util.ArrayList;
import java.util.Date;

import model.person.Customer;
import model.person.Employee;

public class SalesOrder {

	private Date date;
	private int amount;
	private String deliveryStatus;
	private Date deliveryDate;
	
	private Customer customer;
	private Employee employee;
	private Invoice invoice;
	
	private ArrayList<LineItem> itemsToBuy;
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getDeliveryStatus() {
		return deliveryStatus;
	}
	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}
	public Date getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Invoice getInvoice() {
		return invoice;
	}
	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
	public ArrayList<LineItem> getItemsToBuy() {
		return itemsToBuy;
	}
	public void setItemsToBuy(ArrayList<LineItem> itemsToBuy) {
		this.itemsToBuy = itemsToBuy;
	}
	
	
	
}
