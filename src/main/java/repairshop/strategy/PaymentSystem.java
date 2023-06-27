/**
 * 
 */
package repairshop.strategy;

/**
 * @author sheetal
 *
 */
public class PaymentSystem {
	private PaymentStrategy paymentStrategy;

	public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
		this.paymentStrategy = paymentStrategy;
	}
	
	public String processPayment(double amount) {
		if(paymentStrategy == null) {
			throw new Error("No payment strategy is set. Please set a payment strategy before making a payment.");
		}
		return paymentStrategy.processPayment(amount);
	}
}
