/**
 * 
 */
package repairshop.strategy;

/**
 * @author sheetal
 *
 */
public class GooglePayPaymentStrategy implements PaymentStrategy {

	private String googlePayId;

    public GooglePayPaymentStrategy(String googlePayId) {
        this.googlePayId = googlePayId;
    }
    
	@Override
	public String processPayment(double amount) {
		// Implementing GooglePay payment logic
        System.out.println("Processing GooglePay payment...");
        System.out.println("googlePayId: " + googlePayId);
        System.out.println("Amount: $" + amount);
        // Perform actual GooglePay payment processing, authorization, etc.
		System.out.println("Payment successful through Google Pay");
		return "googlepay-" + System.currentTimeMillis();	// transaction_id
	}

}
