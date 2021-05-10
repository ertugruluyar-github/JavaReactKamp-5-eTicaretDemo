package eTicaretDemo.business.concretes;

import java.util.ArrayList;
import java.util.List;

import eTicaretDemo.business.abstracts.ICustomerService;
import eTicaretDemo.core.abstracts.IAlert;
import eTicaretDemo.core.abstracts.ILogger;
import eTicaretDemo.core.abstracts.ILoginValidationService;
import eTicaretDemo.core.abstracts.IRegisterValidationService;
import eTicaretDemo.dataAccess.abstracts.ICustomerDal;
import eTicaretDemo.entities.concretes.Customer;

public class CustomerManager implements ICustomerService {
	
	ICustomerDal customerDal;
	IRegisterValidationService registerValidationService;
	ILoginValidationService loginValidationService;
	ILogger logger;
	IAlert alert;
	public CustomerManager(
			ICustomerDal customerDal,
			IRegisterValidationService registerValidationService,
			ILoginValidationService loginValidationService,
			ILogger logger,
			IAlert alert) {
		this.customerDal = customerDal;
		this.registerValidationService = registerValidationService;
		this.loginValidationService = loginValidationService;
		this.logger = logger;
		this.alert = alert;
	}

	@Override
	public void add(Customer customer) {
		this.customerDal.add(customer);
		alert.showInfoAlert("Üye veri tabanýna kaydedildi: " + customer.getFirstName());
	}

	@Override
	public void delete(Customer customer) {
		this.customerDal.delete(customer);
		alert.showInfoAlert("Hesap silindi. Üye: " + customer.getFirstName());
	}

	@Override
	public void update(Customer customer) {
		this.customerDal.update(customer);
		alert.showInfoAlert("Hesap güncellendi. Üye: " + customer.getFirstName());
	}

	@Override
	public Customer get(int id) {
		// TODO Auto-generated method stub
		return this.customerDal.get(id);
	}

	@Override
	public List<Customer> getAll() {
		// TODO Auto-generated method stub
		return this.customerDal.getAll();
	}
	
	@Override
	public void sendActivationEmailToCustomer(Customer customer) {
		logger.log("Doðrulama e-postasý gönderildi.");
		alert.showInfoAlert("Doðrulama e-postasý gönderildi: " + customer.getEmail());
	}

	@Override
	public void activateCustomer(Customer customer) {
		customer.setAccountActive(true);
		logger.log("Hesabýnýz baþarýyla aktif edildi: " + customer.getEmail());
		alert.showInfoAlert("Hesabýnýz baþarýyla aktif edildi: " + customer.getEmail());
	}

	@Override
	public void deactivateCustomer(Customer customer) {
		customer.setAccountActive(false);
		logger.log("Hesabýnýz askýya alýndý: " + customer.getEmail());
		alert.showInfoAlert("Hesabýnýz askýya alýndý: " + customer.getEmail());
	}

	@Override
	public boolean registerCustomer(Customer customer) {
		ArrayList<String> emails = new ArrayList<String>();
		if (!emails.isEmpty()) {
			this.getAll().forEach((c) -> emails.add(c.getEmail()));
		}
		boolean isValidFirstName = registerValidationService.validateFirstName(customer.getFirstName());
		boolean isValidLastName = registerValidationService.validateLastName(customer.getLastName());
		boolean isValidEmail = registerValidationService.validateEmail(customer.getEmail());
		boolean isUniqueEmail = registerValidationService.validateIsUniqueEmail(emails, customer.getEmail());
		boolean isValidPassword = registerValidationService.validatePassword(customer.getPassword());
		boolean isValid = true;
		
		if (!isValidFirstName) {
			alert.showInfoAlert("Girdiðiniz ad geçersiz.");
			isValid = isValid && false;
		}
		
		if (!isValidLastName) {
			alert.showInfoAlert("Girdiðiniz soyad geçersiz.");
			isValid = isValid && false;
		}
		
		if (!isValidEmail) {
			alert.showInfoAlert("Girdiðiniz email geçersiz.");
			isValid = isValid && false;
		}
		
		if (!isUniqueEmail) {
			alert.showInfoAlert("Girdiðiniz email baþkasý tarafýndan kullanýlýyor.");
			isValid = isValid && false;
		}
		
		if (!isValidPassword) {
			alert.showInfoAlert("Girdiðiniz þifre geçersiz.");
			isValid = isValid && false;
		}
		
		if (isValid) {
			alert.showInfoAlert("Kayýt olma iþlemi baþarýyla gerçekleþti.");
			return isValid;
		} else {
			alert.showInfoAlert("Kayýt olma iþlemi baþarýsýz.");
			return isValid;
		}
		
	}

	@Override
	public boolean loginCustomer(String email, String password) {
		boolean isEmptyEmail = loginValidationService.validateIsEmtyEmail(email);
		boolean isValidLogin = loginValidationService.validateLogin(email, password);
		boolean isEmptyPassword = loginValidationService.validateIsEmtypassword(password);
		boolean isValid = true;
		
		if (isEmptyEmail) {
			alert.showInfoAlert("Email alaný boþ býrakýlamaz.");
			isValid = isValid && false;
		}
		
		if (!isValidLogin) {
			alert.showInfoAlert("Girdiðiniz email veya þifre hatalý.");
			isValid = isValid && false;
		}
		
		if (isEmptyPassword) {
			alert.showInfoAlert("Þifre alaný boþ býrakýlamaz.");
			isValid = isValid && false;
		}
		
		if (isValid) {
			alert.showInfoAlert("Giriþ baþarýyla gerçekleþti.");
			return isValid;
		} else {
			alert.showInfoAlert("Giriþ baþarýsýz.");
			return isValid;
		}
		
		
	}

}
