package com.doomon.atm.service;

import java.util.Map;

public interface ATMService {
	
	public Map<Integer, Integer> withDraw(int amount);
	public Map<Integer, Integer> withDrawDenomination(int type, int amount);

}
