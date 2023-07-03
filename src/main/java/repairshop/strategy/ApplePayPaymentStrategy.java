/**
 * 
 */
package repairshop.strategy;

/**
 * @author sheetal
 *
 */
public class ApplePayPaymentStrategy implements PaymentStrategy {

	private String applePayId;

    public ApplePayPaymentStrategy(String applePayId) {
        this.applePayId = applePayId;
    }
    
    public String getPaymentGatewayName() {
    	return "APPLEPAY";
    }
    
	@Override
	public String processPayment(double amount) {
		// Implementing ApplePay payment logic
        System.out.println("Processing ApplePay payment...");
        System.out.println("applePayId: " + applePayId);
        System.out.println("Amount: $" + amount);
        // Perform actual ApplePay payment processing, authorization, etc.
		System.out.println("Payment successful through Apple Pay");
		return "applepay-" + System.currentTimeMillis();	// transaction_id
	}
}
