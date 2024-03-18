package com.example.sjef.entities.enums;

public enum PaymentStatus {
	
	WAITING_PAYMENT(1),
	PAID(2);
	
	private int code;
	
	private PaymentStatus(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	

}
