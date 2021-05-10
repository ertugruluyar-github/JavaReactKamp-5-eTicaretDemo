package eTicaretDemo.core.concretes;

import java.util.List;

import eTicaretDemo.core.abstracts.IRegisterValidationService;
import eTicaretDemo.externalServices.google.GoogleRegisterValidation;

public class GoogleRegisterValidationAdapter implements IRegisterValidationService {

	@Override
	public boolean validateFirstName(String firstName) {
		GoogleRegisterValidation validator = new GoogleRegisterValidation();
		return validator.validateFirstName(firstName);
	}

	@Override
	public boolean validateLastName(String lastName) {
		GoogleRegisterValidation validator = new GoogleRegisterValidation();
		return validator.validateLastName(lastName);
	}

	@Override
	public boolean validateEmail(String email) {
		GoogleRegisterValidation validator = new GoogleRegisterValidation();
		return validator.validateEmail(email);
	}
	
	@Override
	public boolean validateIsUniqueEmail(List<String> emails, String email) {
		GoogleRegisterValidation validator = new GoogleRegisterValidation();
		return validator.validateIsUniqueEmail(email);
	}

	@Override
	public boolean validatePassword(String password) {
		GoogleRegisterValidation validator = new GoogleRegisterValidation();
		return validator.validatePassword(password);
	}

}
