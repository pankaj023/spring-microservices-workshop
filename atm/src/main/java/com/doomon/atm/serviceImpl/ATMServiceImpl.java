package com.doomon.atm.serviceImpl;

import java.util.Map;

import org.springframework.context.annotation.Configuration;

import com.doomon.atm.model.Currency;
import com.doomon.atm.service.ATMService;
import com.doomon.atm.service.DispenseChainService;

@Configuration(value ="atmServiceImpl")
public class ATMServiceImpl implements ATMService {
	private DispenseChainService c1;

	public ATMServiceImpl() {
		// initialize the chain
		this.c1 = new Rupee1000DispenserServiceImpl();
		DispenseChainService c2 = new Rupee500DispenserServiceImpl();
		DispenseChainService c3 = new Rupee200DispenserServiceImpl();
		DispenseChainService c4 = new Rupee100DispenserServiceImpl();
		DispenseChainService c5= new Rupee50DispenserServiceImpl();
		DispenseChainService c6= new Rupee20DispenserServiceImpl();
		DispenseChainService c7= new Rupee10DispenserServiceImpl();

		// set the chain of responsibility
		c1.setNextChain(c2);
		c2.setNextChain(c3);
		c3.setNextChain(c4);
		c4.setNextChain(c5);
		c5.setNextChain(c6);
		c6.setNextChain(c7);
	}

	@Override
	public Map<Integer, Integer> withDraw(int amount) {
		return c1.dispense(new Currency(amount));
	}

	@Override
	public Map<Integer, Integer> withDrawDenomination(int type, int amount) {
		if(type == 1000) {
			System.out.println("inside 1000");
			return c1.dispense(new Currency(amount));
		}
		else if(type == 500){
			System.out.println("inside 500");
			this.c1 = new Rupee500DispenserServiceImpl();
			DispenseChainService c3 = new Rupee200DispenserServiceImpl();
			DispenseChainService c4 = new Rupee100DispenserServiceImpl();
			DispenseChainService c5= new Rupee50DispenserServiceImpl();
			DispenseChainService c6= new Rupee20DispenserServiceImpl();
			DispenseChainService c7= new Rupee10DispenserServiceImpl();

			// set the chain of responsibility
			c1.setNextChain(c3);
			c3.setNextChain(c4);
			c4.setNextChain(c5);
			c5.setNextChain(c6);
			c6.setNextChain(c7);
			return c1.dispense(new Currency(amount));
		}
		else if (type == 200) {
			this.c1 = new Rupee200DispenserServiceImpl();
			DispenseChainService c4 = new Rupee100DispenserServiceImpl();
			DispenseChainService c5= new Rupee50DispenserServiceImpl();
			DispenseChainService c6= new Rupee20DispenserServiceImpl();
			DispenseChainService c7= new Rupee10DispenserServiceImpl();

			// set the chain of responsibility
			c1.setNextChain(c4);
			c4.setNextChain(c5);
			c5.setNextChain(c6);
			c6.setNextChain(c7);
			return c1.dispense(new Currency(amount));
		}
		else if (type == 100) {
			this.c1 = new Rupee100DispenserServiceImpl();
			DispenseChainService c5= new Rupee50DispenserServiceImpl();
			DispenseChainService c6= new Rupee20DispenserServiceImpl();
			DispenseChainService c7= new Rupee10DispenserServiceImpl();

			// set the chain of responsibility
			c1.setNextChain(c5);
			c5.setNextChain(c6);
			c6.setNextChain(c7);
			return c1.dispense(new Currency(amount));
		}
		else if (type == 50) {
			this.c1 = new Rupee50DispenserServiceImpl();
			DispenseChainService c6= new Rupee20DispenserServiceImpl();
			DispenseChainService c7= new Rupee10DispenserServiceImpl();

			// set the chain of responsibility
			c1.setNextChain(c6);
			c6.setNextChain(c7);
			return c1.dispense(new Currency(amount));
		}
		else if (type == 20) {
			this.c1 = new Rupee20DispenserServiceImpl();
			DispenseChainService c7= new Rupee10DispenserServiceImpl();

			// set the chain of responsibility
			c1.setNextChain(c7);
			return c1.dispense(new Currency(amount));
		}
		else {
			this.c1 = new Rupee10DispenserServiceImpl();
			return c1.dispense(new Currency(amount));
		}
	}

}
