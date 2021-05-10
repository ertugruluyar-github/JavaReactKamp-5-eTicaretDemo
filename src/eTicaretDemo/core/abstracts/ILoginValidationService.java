package eTicaretDemo.core.abstracts;

public interface ILoginValidationService {
	boolean validateIsEmtyEmail(String email);
	boolean validateLogin(String email, String password);
	boolean validateIsEmtypassword(String password);
}
