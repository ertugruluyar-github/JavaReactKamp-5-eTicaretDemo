package eTicaretDemo.core.concretes;

import java.util.HashMap;

import eTicaretDemo.Main;
import eTicaretDemo.core.abstracts.ILoginValidationService;
import eTicaretDemo.entities.concretes.Customer;

public class LoginValidationManager implements ILoginValidationService {
	
	@Override
	public boolean validateIsEmtyEmail(String email) {
		if (email.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean validateLogin(String email, String password) {
		HashMap<String, String> loginInfos = new HashMap<String, String>();
		boolean isLoginCorrect = false;
		if (!Main.customers.isEmpty()) {
			for (Customer customer : Main.customers) {
				loginInfos.put(customer.getEmail(), customer.getPassword());
			}
			if (loginInfos.containsKey(email)) {
				isLoginCorrect = loginInfos.get(email) == password;
			}
		}
		return isLoginCorrect;
	}
	
	@Override
	public boolean validateIsEmtypassword(String password) {
		if (password.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

}
