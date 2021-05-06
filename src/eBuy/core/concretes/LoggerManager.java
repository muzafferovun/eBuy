package eBuy.core.concretes;

import eBuy.core.abstracts.Logger;

public class LoggerManager {
	public Logger[] log(String className) {
		Logger[] loggers={};
		if(className=="User") {	loggers=new Logger[] {new EmailLogger(),new DatabaseLogger()};	}
		
		return loggers;
	}
}
