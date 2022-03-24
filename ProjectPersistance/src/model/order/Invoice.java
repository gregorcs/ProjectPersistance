package model.order;

import java.util.Date;

public class Invoice {

	private int orderId;
	private Date payemntDate;
	private int amount;
	
	public Invoice() {
		
	}
	
	public Invoice(int orderId, Date payemntDate, int amount) {
		super();
		this.orderId = orderId;
		this.payemntDate = payemntDate;
		this.amount = amount;
	}
	
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Date getPayemntDate() {
		return payemntDate;
	}

	public void setPayemntDate(Date payemntDate) {
		this.payemntDate = payemntDate;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
}
