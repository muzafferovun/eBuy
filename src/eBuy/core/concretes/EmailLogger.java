package eBuy.core.concretes;

import eBuy.core.abstracts.Logger;

public class EmailLogger implements Logger {

	@Override
	public void log(String message) {
		System.out.println("Email Gönderildi -> "+message);
		
	}

}
