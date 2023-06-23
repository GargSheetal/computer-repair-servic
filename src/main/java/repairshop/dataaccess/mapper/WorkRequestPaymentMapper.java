/**
 * 
 */
package repairshop.dataaccess.mapper;

import repairshop.dataaccess.model.WorkRequestPayment.WorkRequestPayment;

/**
 * @author sheetal
 *
 */
public interface WorkRequestPaymentMapper {
	
	WorkRequestPayment selectWorkRequestPaymentById(int workRequestPaymentId);
	
	WorkRequestPayment selectWorkRequestPaymentByPaymentConfirmationNumber(String paymentConfirmationNumber);
	
	void addWorkRequestPayment(WorkRequestPayment workRequestPayment);
	
	void updateWorkRequestPayment(WorkRequestPayment workRequestPayment);
	
	void deleteWorkRequestPayment(int workRequestPaymentId);

}
