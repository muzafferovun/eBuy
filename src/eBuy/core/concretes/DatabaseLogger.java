package eBuy.core.concretes;

import eBuy.core.abstracts.Logger;

public class DatabaseLogger implements Logger  {

	@Override
	public void log(String message) {
		System.out.println("Database Log : "+message);
		
	}

}
