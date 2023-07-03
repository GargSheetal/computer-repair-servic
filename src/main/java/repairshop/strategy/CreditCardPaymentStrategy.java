/**
 * 
 */
package repairshop.strategy;

/**
 * @author sheetal
 *
 */
public class CreditCardPaymentStrategy implements PaymentStrategy {
	private String creditCardNumber;

    public CreditCardPaymentStrategy(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }
    
    public String getPaymentGatewayName() {
    	return "CREDITCARD";
    }

    @Override
    public String processPayment(double amount) {
    	// Implementing CreditCard payment logic
        System.out.println("Processing CreditCard payment...");
        System.out.println("creditCardNumber: " + creditCardNumber);
        System.out.println("Amount: $" + amount);
        // Perform actual CreditCard payment processing, authorization, etc.
        System.out.println("Payment successful through Credit Card!");
        return "creditcard-" + System.currentTimeMillis();	// transaction_id
    }
}

