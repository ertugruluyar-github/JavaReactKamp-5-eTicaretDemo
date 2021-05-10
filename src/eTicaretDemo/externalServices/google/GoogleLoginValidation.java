package eTicaretDemo.externalServices.google;

public class GoogleLoginValidation {
	
	public boolean validateIsEmtyEmail(String email) {
		if (email.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}
	
	public boolean validateLogin(String email, String password) {
		return true;
	}
	
	public boolean validateIsEmtypassword(String password) {
		if (password.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}
	
}
