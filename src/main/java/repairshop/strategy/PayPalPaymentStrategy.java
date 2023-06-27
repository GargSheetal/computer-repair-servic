/**
 * 
 */
package repairshop.strategy;

/**
 * @author sheetal
 *
 */
public class PayPalPaymentStrategy implements PaymentStrategy {

	private String paypalId;

    public PayPalPaymentStrategy(String paypalId) {
        this.paypalId = paypalId;
    }
	
    public String getPaymentGatewayName() {
    	return "PAYPAL";
    }
    
	@Override
	public String processPayment(double amount) {
		// Implement PayPal payment logic here
        System.out.println("Processing PayPal payment...");
        System.out.println("paypalId: " + paypalId);
        System.out.println("Amount: $" + amount);
        // Perform actual PayPal payment processing, authorization, etc.
		System.out.println("Payment successful through PayPal");
		return "paypal-" + System.currentTimeMillis();	// transaction_id
	}
}
