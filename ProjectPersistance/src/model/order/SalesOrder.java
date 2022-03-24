package model.order;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import model.person.Customer;
import model.person.Employee;

public class SalesOrder {

	private String orderId;
	
	private String date;
	private int amount;
	private String deliveryStatus;
	private Date deliveryDate;
	
	private Customer customer;
	private Employee employee;
	private Invoice invoice;
	
	private ArrayList<LineItem> itemsToBuy;
	
	public SalesOrder(String date, int amount, String deliveryStatus, Date deliveryDate, Customer customer,
			Employee employee) {
		super();
		this.date = date;
		this.amount = amount;
		this.deliveryStatus = deliveryStatus;
		this.deliveryDate = deliveryDate;
		this.customer = customer;
		this.employee = employee;
	}
	
	public SalesOrder(int amount, String deliveryStatus, /*Date deliveryDate,*/ Customer customer, Employee employee, ArrayList<LineItem> itemsToBuy) {
		super();
		this.date = createDate();
		this.amount = amount;
		this.deliveryStatus = deliveryStatus;
		this.deliveryDate = deliveryDate;
		this.customer = customer;
		this.employee = employee;
		this.itemsToBuy = itemsToBuy;
	}

	public String getDate() {
		return date;
	}
	public void String (String date) {
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
	
	public boolean addLineItem(LineItem lineItem) {
		return itemsToBuy.add(lineItem);
	}

	public ArrayList<LineItem> getItemsToBuy() {
		return itemsToBuy;
	}
	public void setItemsToBuy(ArrayList<LineItem> itemsToBuy) {
		this.itemsToBuy = itemsToBuy;
	}
	
	public String getCustomerId() {
		return customer.getCustomerId();
	}
	
	public String getEmployeeId() {
		return employee.getEmployeeId();
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	
	public String  createDate() {
	    SimpleDateFormat formatter = new SimpleDateFormat("YYYY/MM/dd");  
	    Date date = new Date();  
	    return formatter.format(date);  
	}
}
