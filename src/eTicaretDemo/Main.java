package eTicaretDemo;

import java.util.ArrayList;

import eTicaretDemo.business.abstracts.ICustomerService;
import eTicaretDemo.business.concretes.CustomerManager;
import eTicaretDemo.core.concretes.EmailAbcLoggerAdapter;
import eTicaretDemo.core.concretes.GoogleLoginValidationAdapter;
import eTicaretDemo.core.concretes.GoogleRegisterValidationAdapter;
import eTicaretDemo.core.concretes.InfoAbcAlertAdapter;
import eTicaretDemo.core.concretes.LoginValidationManager;
import eTicaretDemo.core.concretes.RegisterValidationManager;
import eTicaretDemo.dataAccess.concretes.HibernateCustomerDal;
import eTicaretDemo.entities.concretes.Customer;

public class Main {
	
	//Sahte db
	public static ArrayList<Customer> customers = new ArrayList<Customer>();
		
	public static void main(String[] args) {
		
		ICustomerService customerManager = new CustomerManager(
				new HibernateCustomerDal(),
				new RegisterValidationManager(),
				new LoginValidationManager(),
				new EmailAbcLoggerAdapter(),
				new InfoAbcAlertAdapter()
			);
		
		// Ge�erli kullan�c�
		Customer customer1 = new Customer(0, "Ahmet", "Eker", "ahmet.eker@gmail.com", "123456");
		// Email ge�ersiz kullan�c�
		Customer customer2 = new Customer(1, "Mehmet", "Ekin", "mehmet.ekin#gmail.com", "123456");
		// Soyisim ve �ifre ge�ersiz kullan�c�
		Customer customer3 = new Customer(1, "Cihat", "", "cihat.eren@gmail.com", "12345");
		
		System.out.println("########## REG�STER #########");
		System.out.println();
		
		System.out.println("================ CUSTOMER1 ===================");
		System.out.println("---- REG�STER1 ----");
		boolean registerSuccessfull1 = customerManager.registerCustomer(customer1);
		if (registerSuccessfull1) {
			customerManager.add(customer1);
			customerManager.sendActivationEmailToCustomer(customer1);
			System.out.println("Kullan�c� aktivasyon emailini onaylad�.");
			customerManager.activateCustomer(customer1);
		}
		
		System.out.println();
		
		System.out.println("================ CUSTOMER2 ===================");
		System.out.println("---- REG�STER2 ----");
		boolean registerSuccessfull2 = customerManager.registerCustomer(customer2);
		if (registerSuccessfull2) {
			customerManager.add(customer2);
			customerManager.sendActivationEmailToCustomer(customer2);
			System.out.println("Kullan�c� aktivasyon emailini onaylad�.");
			customerManager.activateCustomer(customer2);
		}
		
		System.out.println();
		
		System.out.println("================ CUSTOMER3 ===================");
		System.out.println("---- REG�STER3 ----");
		boolean registerSuccessfull3 = customerManager.registerCustomer(customer3);
		if (registerSuccessfull3) {
			customerManager.add(customer3);
			customerManager.sendActivationEmailToCustomer(customer3);
			System.out.println("Kullan�c� aktivasyon emailini onaylad�.");
			customerManager.activateCustomer(customer3);
		}
		
		System.out.println();
		System.out.println("########## LOG�N #########");
		System.out.println();
		
		System.out.println("---- LOG�N1 ----");
		customerManager.loginCustomer("ahmet.eker@gmail.com", "123456");
		System.out.println("---- LOG�N2 ----");
		customerManager.loginCustomer("ahmet@gmail.com", "123456");
		System.out.println("---- LOG�N3 ----");
		customerManager.loginCustomer("ahmet.eker@gmail.com", "123456789");
		System.out.println("---- LOG�N4 ----");
		customerManager.loginCustomer("ahmet@gmail.com", "123456789");
		
	}

}
