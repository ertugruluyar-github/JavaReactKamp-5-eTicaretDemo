package eTicaretDemo.externalServices.google;

public class GoogleRegisterValidation {
	public boolean validateFirstName(String firstName) {
		if (firstName.length() < 3) {
			return false;
		} else {
			return true;
		}
	}
	
	public boolean validateLastName(String lastName) {
		if (lastName.length() < 3) {
			return false;
		} else {
			return true;
		}
	}
	
	public boolean validateEmail(String email) {
		
		boolean isValidEmail = true;
		if (isValidEmail) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean validateIsUniqueEmail(String email) {
		boolean isUniqueEmail = true;
		if (isUniqueEmail) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean validatePassword(String password) {
		if (password.length() < 6) {
			return false;
		} else {
			return true;
		}
	}
}
