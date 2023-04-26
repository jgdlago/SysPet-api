package com.petshopSystem.Enums;

public enum ServiceTypeEnum {
	BATH("Banho"),
	SHAVE("Tosa"),
	BATH_AND_SHAVE("Banho e tosa");

	private String value;

	private ServiceTypeEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
