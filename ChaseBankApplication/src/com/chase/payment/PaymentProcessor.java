package com.chase.payment;

public class PaymentProcessor {
	public String ping() {
		return "Connectiong success";
	}
	
	public String processPayment(CreditCardPayment cd) {
		return "card comfrimed";
	}
}
