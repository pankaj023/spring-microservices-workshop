package com.doomon.atm.serviceImpl;

import java.util.HashMap;
import java.util.Map;

import com.doomon.atm.model.Currency;
import com.doomon.atm.service.DispenseChainService;

public class Rupee10DispenserServiceImpl implements   DispenseChainService {

	private DispenseChainService chain;

	@Override
	public void setNextChain(DispenseChainService nextChain) {
		this.chain=nextChain;
	}

	@Override
	public Map<Integer, Integer> dispense(Currency cur) {
		Map<Integer, Integer> map = new HashMap<>();
		if(cur.getAmount() >= 10){
			int num = cur.getAmount()/10;
			map.put(10, num);
			int remainder = cur.getAmount() % 10;
			System.out.println("Dispensing "+num+" 10 note");
			if(remainder !=0) {
				map.putAll(this.chain.dispense(new Currency(remainder)));
			}
		}else{
			map.putAll(this.chain.dispense(cur));
		}
		return map;
	}


}

