/**
 * 
 */
package repairshop.strategy;

/**
 * @author sheetal
 *
 */
public interface PaymentStrategy {
	String getPaymentGatewayName();
	String processPayment(double amount);	// returns transaction_id from payment_gateway

}
