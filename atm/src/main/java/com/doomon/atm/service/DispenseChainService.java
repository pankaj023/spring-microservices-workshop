package com.doomon.atm.service;

import java.util.Map;

import com.doomon.atm.model.Currency;

public interface DispenseChainService {

	void setNextChain(DispenseChainService nextChain);
	
	Map<Integer, Integer> dispense(Currency cur);
}
