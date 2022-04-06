package model.order;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class SalesOrder {

	private String orderId;
	
	private String date;
	private float amount;
	private String deliveryStatus;
	private String deliveryDate;
	
	private String customerId;
	private String employeeId;
	private Invoice invoice;
	
	private ArrayList<LineItem> itemsToBuy;
	
	public SalesOrder(String date, float amount, String deliveryStatus, String deliveryDate, String customer,
			String employee) {
		super();
		this.date = date;
		this.amount = amount;
		this.deliveryStatus = deliveryStatus;
		this.deliveryDate = deliveryDate;
		this.customerId = customer;
		this.employeeId = employee;
	}
	
	public SalesOrder(float amount, String deliveryStatus, String deliveryDate, String customerId, String employeeId, ArrayList<LineItem> itemsToBuy) {
		super();
		this.date = createDate();
		this.amount = amount;
		this.deliveryStatus = deliveryStatus;
		this.deliveryDate = deliveryDate;
		this.customerId = customerId;
		this.employeeId = employeeId;
		this.itemsToBuy = itemsToBuy;
	}

	public SalesOrder() {
		itemsToBuy = new ArrayList<LineItem>();
		this.date = createDate();
	}

	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public String getDeliveryStatus() {
		return deliveryStatus;
	}
	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}
	public String getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customer) {
		this.customerId = customer;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employee) {
		this.employeeId = employee;
	}
	public Invoice getInvoice() {
		return invoice;
	}
	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
	
	public boolean addLineItem(LineItem lineItem) {
		lineItem.setSaleOrder(this);
		return itemsToBuy.add(lineItem);
	}

	public ArrayList<LineItem> getItemsToBuy() {
		return itemsToBuy;
	}
	public void setItemsToBuy(ArrayList<LineItem> itemsToBuy) {
		this.itemsToBuy = itemsToBuy;
	}

	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	
	public String createDate() {
	    SimpleDateFormat formatter = new SimpleDateFormat("YYYY/MM/dd");  
	    Date date = new Date();  
	    return formatter.format(date);  
	}
}
