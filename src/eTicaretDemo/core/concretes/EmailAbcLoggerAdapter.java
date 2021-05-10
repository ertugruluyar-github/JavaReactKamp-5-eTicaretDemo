package eTicaretDemo.core.concretes;

import eTicaretDemo.core.abstracts.ILogger;
import eTicaretDemo.externalServices.loggerServices.abcLoggerService.EmailAbcLogger;

public class EmailAbcLoggerAdapter implements ILogger {

	@Override
	public void log(String message) {
		EmailAbcLogger logger = new EmailAbcLogger();
		logger.logToEmail(message);
	}

}
