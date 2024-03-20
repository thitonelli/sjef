package com.example.sjef.entities.enums;

public enum OrderStatus {

	SHIPPED(1),
	DELIVERED(2),
	CANCELED(3),
	WAITING_PAYMENT(4),
	PAID(5);

	private int code;

	private OrderStatus(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public static OrderStatus valueOf(int code) {
		for (OrderStatus value : OrderStatus.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid OrderStatus code");
	}
}