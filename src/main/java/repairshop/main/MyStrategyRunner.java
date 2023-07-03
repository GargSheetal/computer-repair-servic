package repairshop.main;

import repairshop.strategy.CreditCardPaymentStrategy;
import repairshop.strategy.PaymentSystem;

public class MyStrategyRunner {

	public static void main(String[] args) {
		PaymentSystem paymentSystem = new PaymentSystem();
		paymentSystem.setPaymentStrategy(new CreditCardPaymentStrategy("2345613456675678"));
		String transactionId = paymentSystem.processPayment(200);
		System.out.println("Transaction Id : " + transactionId);
	}

}
