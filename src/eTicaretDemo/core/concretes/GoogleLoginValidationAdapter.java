package eTicaretDemo.core.concretes;

import eTicaretDemo.core.abstracts.ILoginValidationService;
import eTicaretDemo.externalServices.google.GoogleLoginValidation;

public class GoogleLoginValidationAdapter implements ILoginValidationService {
	
	@Override
	public boolean validateIsEmtyEmail(String email) {
		GoogleLoginValidation validator = new GoogleLoginValidation();
		return validator.validateIsEmtyEmail(email);
	}
	
	@Override
	public boolean validateLogin(String email, String password) {
		GoogleLoginValidation validator = new GoogleLoginValidation();
		return validator.validateLogin(email, password);
	}
	
	@Override
	public boolean validateIsEmtypassword(String password) {
		GoogleLoginValidation validator = new GoogleLoginValidation();
		return validator.validateIsEmtypassword(password);
	}
	
}
