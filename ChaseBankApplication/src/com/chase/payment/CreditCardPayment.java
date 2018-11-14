package com.chase.payment;


import javax.persistence.*;


@Entity
@Table(name="payment_info")
public class CreditCardPayment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="payment_id")
	private int id;
	
	@Column(name="creditcardnumber")
	private String creditCardNumber;
	
	@Column(name="expirydate")
	private String expiryDate;
	
	@Column(name="cvv")
	private String cvv;
	
	@Column(name="holdername")
	private String holderName;

	public CreditCardPayment() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}
}
