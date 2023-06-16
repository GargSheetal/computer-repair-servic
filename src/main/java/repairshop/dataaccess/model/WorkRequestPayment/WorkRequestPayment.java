package repairshop.dataaccess.model.WorkRequestPayment;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import repairshop.xml.DateAdapter;
import repairshop.dataaccess.model.WorkRequest.WorkRequest;

@XmlRootElement(name = "work_request_payment")
@XmlAccessorType(XmlAccessType.FIELD)
public class WorkRequestPayment {

	@XmlAttribute(name = "work_request_payment_id", required = true)
	private int workRequestPaymentId;
	
	@XmlElement(name = "work_request")
	private WorkRequest workRequest = new WorkRequest();	// Foreign key reference
	
	@XmlElement(name = "payment_confirmation_number")
	private String paymentConfirmationNumber;
	
	@XmlJavaTypeAdapter(DateAdapter.class)
	private Date paymentTimestamp;
	
	@XmlElement(name = "amount")
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
