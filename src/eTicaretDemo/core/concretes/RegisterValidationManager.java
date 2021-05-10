package eTicaretDemo.core.concretes;

import java.util.List;

import eTicaretDemo.core.abstracts.EmailRegex;
import eTicaretDemo.core.abstracts.IRegisterValidationService;

public class RegisterValidationManager implements IRegisterValidationService {

	@Override
	public boolean validateFirstName(String firstName) {
		if (firstName.length() < 2) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean validateLastName(String lastName) {
		if (lastName.length() < 2) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean validateEmail(String email) {
		if (EmailRegex.checkEmail(email)) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public boolean validateIsUniqueEmail(List<String> emails ,String email) {
		boolean isUniqueEmail = emails.isEmpty() ? true : !emails.contains(email);
		if (isUniqueEmail) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean validatePassword(String password) {
		if (password.length() < 6) {
			return false;
		} else {
			return true;
		}
	}
	
}
