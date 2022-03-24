package model.order;

import java.util.Date;

public class Invoice {

	private Date payemntDate;
	private int amount;

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
