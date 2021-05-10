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
		alert.showInfoAlert("�ye veri taban�na kaydedildi: " + customer.getFirstName());
	}

	@Override
	public void delete(Customer customer) {
		this.customerDal.delete(customer);
		alert.showInfoAlert("Hesap silindi. �ye: " + customer.getFirstName());
	}

	@Override
	public void update(Customer customer) {
		this.customerDal.update(customer);
		alert.showInfoAlert("Hesap g�ncellendi. �ye: " + customer.getFirstName());
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
		logger.log("Do�rulama e-postas� g�nderildi.");
		alert.showInfoAlert("Do�rulama e-postas� g�nderildi: " + customer.getEmail());
	}

	@Override
	public void activateCustomer(Customer customer) {
		customer.setAccountActive(true);
		logger.log("Hesab�n�z ba�ar�yla aktif edildi: " + customer.getEmail());
		alert.showInfoAlert("Hesab�n�z ba�ar�yla aktif edildi: " + customer.getEmail());
	}

	@Override
	public void deactivateCustomer(Customer customer) {
		customer.setAccountActive(false);
		logger.log("Hesab�n�z ask�ya al�nd�: " + customer.getEmail());
		alert.showInfoAlert("Hesab�n�z ask�ya al�nd�: " + customer.getEmail());
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
			alert.showInfoAlert("Girdi�iniz ad ge�ersiz.");
			isValid = isValid && false;
		}
		
		if (!isValidLastName) {
			alert.showInfoAlert("Girdi�iniz soyad ge�ersiz.");
			isValid = isValid && false;
		}
		
		if (!isValidEmail) {
			alert.showInfoAlert("Girdi�iniz email ge�ersiz.");
			isValid = isValid && false;
		}
		
		if (!isUniqueEmail) {
			alert.showInfoAlert("Girdi�iniz email ba�kas� taraf�ndan kullan�l�yor.");
			isValid = isValid && false;
		}
		
		if (!isValidPassword) {
			alert.showInfoAlert("Girdi�iniz �ifre ge�ersiz.");
			isValid = isValid && false;
		}
		
		if (isValid) {
			alert.showInfoAlert("Kay�t olma i�lemi ba�ar�yla ger�ekle�ti.");
			return isValid;
		} else {
			alert.showInfoAlert("Kay�t olma i�lemi ba�ar�s�z.");
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
			alert.showInfoAlert("Email alan� bo� b�rak�lamaz.");
			isValid = isValid && false;
		}
		
		if (!isValidLogin) {
			alert.showInfoAlert("Girdi�iniz email veya �ifre hatal�.");
			isValid = isValid && false;
		}
		
		if (isEmptyPassword) {
			alert.showInfoAlert("�ifre alan� bo� b�rak�lamaz.");
			isValid = isValid && false;
		}
		
		if (isValid) {
			alert.showInfoAlert("Giri� ba�ar�yla ger�ekle�ti.");
			return isValid;
		} else {
			alert.showInfoAlert("Giri� ba�ar�s�z.");
			return isValid;
		}
		
		
	}

}
