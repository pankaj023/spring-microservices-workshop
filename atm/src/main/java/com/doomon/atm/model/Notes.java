package com.doomon.atm.model;

import java.util.Map;

public class Notes {
	private Map<Integer, Integer> denomination;
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Map<Integer, Integer> getDenomination() {
		return denomination;
	}

	public void setDenomination(Map<Integer, Integer> denomination) {
		this.denomination = denomination;
	}

}
