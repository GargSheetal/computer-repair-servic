package repairshop.dataaccess.model.WorkRequestPayment;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import repairshop.xml.DateAdapter;
import repairshop.dataaccess.model.WorkRequest.WorkRequest;

@JsonRootName(value = "work_request_payment")
@XmlRootElement(name = "work_request_payment")
@XmlAccessorType(XmlAccessType.FIELD)
public class WorkRequestPayment {

	@JsonProperty("work_request_payment_id")
	@XmlAttribute(name = "work_request_payment_id", required = true)
	private int workRequestPaymentId;
	
	@JsonProperty("work_request")
	@XmlElement(name = "work_request")
	private WorkRequest workRequest = new WorkRequest();	// Foreign key reference
	
	@JsonProperty("payment_confirmation_number")
	@XmlElement(name = "payment_confirmation_number")
	private String paymentConfirmationNumber;
	
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	@XmlJavaTypeAdapter(DateAdapter.class)
	private Date paymentTimestamp;
	
	@JsonProperty("amount")
	@XmlElement(name = "amount")
	private double amount;
	
	@JsonProperty("payment_gateway")
	@XmlElement(name = "payment_gateway")
	private String paymentGateway;
	
	public WorkRequestPayment() {}

	public WorkRequestPayment(int workRequestPaymentId, WorkRequest workRequest, String paymentConfirmationNumber,
			Date paymentTimestamp, double amount, String paymentGateway) {
		this.workRequestPaymentId = workRequestPaymentId;
		this.workRequest = workRequest;
		this.paymentConfirmationNumber = paymentConfirmationNumber;
		this.paymentTimestamp = paymentTimestamp;
		this.amount = amount;
		this.paymentGateway = paymentGateway;
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

	public String getPaymentGateway() {
		return paymentGateway;
	}

	public void setPaymentGateway(String paymentGateway) {
		this.paymentGateway = paymentGateway;
	}

	@Override
	public String toString() {
		return "\nWorkRequestPayment [workRequestPaymentId=" + this.workRequestPaymentId + ", workRequest=" + this.workRequest.getWorkRequestId()
				+ ", paymentConfirmationNumber=" + this.paymentConfirmationNumber + ", paymentTimestamp=" + this.paymentTimestamp
				+ ", amount=" + this.amount + ", paymentGateway=" + this.paymentGateway + "]";
	}
	
}
