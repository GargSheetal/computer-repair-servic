/**
 * 
 */
package repairshop.strategy;

/**
 * @author sheetal
 *
 */
public interface PaymentStrategy {
	
	String processPayment(double amount);	// returns transaction_id from payment_gateway

}
