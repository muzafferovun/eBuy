package eBuy.core.concretes;

import eBuy.core.abstracts.Logger;

public class FileLogger implements Logger {

	@Override
	public void log(String message) {
		System.out.println("Dosya kaydedildi"+message);
		
	}
}
