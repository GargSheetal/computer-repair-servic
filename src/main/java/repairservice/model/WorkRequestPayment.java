package repairservice.model;

import java.util.Date;

public class WorkRequestPayment {

	private int workRequestPaymentId;
	private WorkRequest workRequest;	// Foreign key reference
	private String paymentConfirmationNumber;
	private Date paymentTimestamp;
	private double amount;
	
	public WorkRequestPayment() {}

	public WorkRequestPayment(int workRequestPaymentId, WorkRequest workRequest, String paymentConfirmationNumber,
			Date paymentTimestamp, double amount) {
		this.workRequestPaymentId = workRequestPaymentId;
		this.workRequest = workRequest;
		this.paymentConfirmationNumber = paymentConfirmationNumber;
		this.paymentTimestamp = paymentTimestamp;
		this.amount = amount;
	}

	public int getWorkRequestPaymentId() {
		return workRequestPaymentId;
	}

	public void setWorkRequestPaymentId(int workRequestPaymentId) {
		this.workRequestPaymentId = workRequestPaymentId;
	}

	public WorkRequest getWorkRequest() {
		return workRequest;
	}

	public void setWorkRequest(WorkRequest workRequest) {
		this.workRequest = workRequest;
	}

	public String getPaymentConfirmationNumber() {
		return paymentConfirmationNumber;
	}

	public void setPaymentConfirmationNumber(String paymentConfirmationNumber) {
		this.paymentConfirmationNumber = paymentConfirmationNumber;
	}

	public Date getPaymentTimestamp() {
		return paymentTimestamp;
	}

	public void setPaymentTimestamp(Date paymentTimestamp) {
		this.paymentTimestamp = paymentTimestamp;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
}
