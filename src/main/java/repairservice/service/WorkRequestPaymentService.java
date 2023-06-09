package repairservice.service;

import java.util.List;

import repairservice.daoimpl.WorkRequestPaymentDaoImpl;
import repairservice.model.WorkRequestPayment;

public class WorkRequestPaymentService {

	private WorkRequestPaymentDaoImpl workRequestPaymentDaoImpl;

	public WorkRequestPaymentService(WorkRequestPaymentDaoImpl workRequestPaymentDaoImpl) {
		this.workRequestPaymentDaoImpl = workRequestPaymentDaoImpl;
	}
	
	public WorkRequestPayment create(WorkRequestPayment payment) {
		return workRequestPaymentDaoImpl.create(payment);
	}
	
	public WorkRequestPayment getById(int paymentId) {
		return workRequestPaymentDaoImpl.getById(paymentId);
	}
	
	public List<WorkRequestPayment> getAll() {
		return workRequestPaymentDaoImpl.getAll();
	}
	
	public WorkRequestPayment update(WorkRequestPayment payment) {
		return workRequestPaymentDaoImpl.update(payment);
	}
	
	public int delete(int paymentId) {
		workRequestPaymentDaoImpl.delete(paymentId);
		return paymentId;
	}
}
