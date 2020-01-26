package com.doomon.atm.serviceImpl;

import java.util.HashMap;
import java.util.Map;

import com.doomon.atm.model.Currency;
import com.doomon.atm.service.DispenseChainService;

public class Rupee500DispenserServiceImpl implements   DispenseChainService {

	private DispenseChainService chain;

	@Override
	public void setNextChain(DispenseChainService nextChain) {
		this.chain=nextChain;
	}

	@Override
	public Map<Integer, Integer> dispense(Currency cur) {
		Map<Integer, Integer> map = new HashMap<>();
		if(cur.getAmount() >= 500){
			int num = cur.getAmount()/500;
			map.put(500, num);
			int remainder = cur.getAmount() % 500;
			System.out.println("Dispensing "+num+" 500 note");
			if(remainder !=0) {
				map.putAll(this.chain.dispense(new Currency(remainder)));
			}
		}else{
			map.putAll(this.chain.dispense(cur));
		}
		return map;
	}


}
