package com.doomon.atm.serviceImpl;

import java.util.HashMap;
import java.util.Map;

import com.doomon.atm.model.Currency;
import com.doomon.atm.service.DispenseChainService;

public class Rupee50DispenserServiceImpl implements   DispenseChainService {

	private DispenseChainService chain;

	@Override
	public void setNextChain(DispenseChainService nextChain) {
		this.chain=nextChain;
	}

	@Override
	public Map<Integer, Integer> dispense(Currency cur) {
		Map<Integer, Integer> map = new HashMap<>();
		if(cur.getAmount() >= 50){
			int num = cur.getAmount()/50;
			map.put(50, num);
			int remainder = cur.getAmount() % 50;
			System.out.println("Dispensing "+num+" 50 note");
			if(remainder !=0) {
				map.putAll(this.chain.dispense(new Currency(remainder)));
			}
		}else{
			map.putAll(this.chain.dispense(cur));
		}
		
		return map;
	}


}