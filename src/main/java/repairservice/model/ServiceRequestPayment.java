package repairservice.model;

import java.util.Date;

public class ServiceRequestPayment {

	private ServiceRequest serviceRequest;	// Foreign key reference
	private String paymentConfirmationNumber;
	private Date paymentTimestamp;
	private double amount;
	
	public ServiceRequestPayment() {}
	
	public ServiceRequestPayment(ServiceRequest serviceRequest, String paymentConfirmationNumber, Date paymentTimestamp,
			double amount) {
		this.serviceRequest = serviceRequest;
		this.paymentConfirmationNumber = paymentConfirmationNumber;
		this.paymentTimestamp = paymentTimestamp;
		this.amount = amount;
	}

	public ServiceRequest getServiceRequest() {
		return serviceRequest;
	}

	public void setServiceRequest(ServiceRequest serviceRequest) {
		this.serviceRequest = serviceRequest;
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
