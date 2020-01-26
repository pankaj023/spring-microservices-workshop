package com.doomon.atm.controller;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import com.doomon.atm.model.Notes;
import com.doomon.atm.service.ATMService;


/**
 * This controller supports user interaction via the UI
 */
@RestController
@RequestMapping("/atm")
public class ATMController {

	@Autowired
	@Qualifier(value ="atmServiceImpl")
	ATMService atmService;
	
	Set <Integer> denomination ;
	
	
	ATMController(){
		denomination = new HashSet<>();
		denomination.add(10);
		denomination.add(20);
		denomination.add(50);
		denomination.add(100);
		denomination.add(200);
		denomination.add(500);
		denomination.add(1000);
	}

	@RequestMapping("/withdraw/{amount}")
	public Notes withDrawMoney(@PathVariable int amount) {
		Notes notes = new Notes();
		if(amount%10 != 0) {
			System.out.println("Inside exception");
			notes.setMessage("FAIL: Withdrawal amount should be multiple of 10");
		}
		else {
			Map <Integer, Integer> map = atmService.withDraw(amount);
			notes.setDenomination(map);
			notes.setMessage("SUCCESS");
			System.out.println(map);
		}
		

		return notes;
	}
	
	@RequestMapping("/withdraw/{type}/{amount}")
	public Notes withDrawMoneyDenomination(@PathVariable int type,@PathVariable int amount){
		Notes notes = new Notes();
		
		if(amount%10 != 0) {
			System.out.println("Inside exception");
			notes.setMessage("FAIL: Withdrawal amount should be multiple of 10");
		}
		else if(!denomination.contains(type)) {
			System.out.println("Inside exception");
			notes.setMessage("FAIL: Denomination should be 10,20,50,100,200,500,1000");
		}
		else {
			Map <Integer, Integer> map = atmService.withDrawDenomination(type,amount);
			notes.setDenomination(map);
			notes.setMessage("SUCCESS");
			System.out.println(map);
		}
		return notes;
	}


}
