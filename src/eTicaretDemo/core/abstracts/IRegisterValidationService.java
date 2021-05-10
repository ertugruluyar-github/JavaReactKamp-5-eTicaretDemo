package eTicaretDemo.core.abstracts;

import java.util.List;

public interface IRegisterValidationService {
	boolean validateFirstName(String firstName);
	boolean validateLastName(String lastName);
	boolean validateEmail(String email);
	boolean validateIsUniqueEmail(List<String> emails, String email);
	boolean validatePassword(String password);
}
