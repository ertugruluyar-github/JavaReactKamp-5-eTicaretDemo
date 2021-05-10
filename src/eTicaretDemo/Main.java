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
		
		// Geçerli kullanýcý
		Customer customer1 = new Customer(0, "Ahmet", "Eker", "ahmet.eker@gmail.com", "123456");
		// Email geçersiz kullanýcý
		Customer customer2 = new Customer(1, "Mehmet", "Ekin", "mehmet.ekin#gmail.com", "123456");
		// Soyisim ve þifre geçersiz kullanýcý
		Customer customer3 = new Customer(1, "Cihat", "", "cihat.eren@gmail.com", "12345");
		
		System.out.println("########## REGÝSTER #########");
		System.out.println();
		
		System.out.println("================ CUSTOMER1 ===================");
		System.out.println("---- REGÝSTER1 ----");
		boolean registerSuccessfull1 = customerManager.registerCustomer(customer1);
		if (registerSuccessfull1) {
			customerManager.add(customer1);
			customerManager.sendActivationEmailToCustomer(customer1);
			System.out.println("Kullanýcý aktivasyon emailini onayladý.");
			customerManager.activateCustomer(customer1);
		}
		
		System.out.println();
		
		System.out.println("================ CUSTOMER2 ===================");
		System.out.println("---- REGÝSTER2 ----");
		boolean registerSuccessfull2 = customerManager.registerCustomer(customer2);
		if (registerSuccessfull2) {
			customerManager.add(customer2);
			customerManager.sendActivationEmailToCustomer(customer2);
			System.out.println("Kullanýcý aktivasyon emailini onayladý.");
			customerManager.activateCustomer(customer2);
		}
		
		System.out.println();
		
		System.out.println("================ CUSTOMER3 ===================");
		System.out.println("---- REGÝSTER3 ----");
		boolean registerSuccessfull3 = customerManager.registerCustomer(customer3);
		if (registerSuccessfull3) {
			customerManager.add(customer3);
			customerManager.sendActivationEmailToCustomer(customer3);
			System.out.println("Kullanýcý aktivasyon emailini onayladý.");
			customerManager.activateCustomer(customer3);
		}
		
		System.out.println();
		System.out.println("########## LOGÝN #########");
		System.out.println();
		
		System.out.println("---- LOGÝN1 ----");
		customerManager.loginCustomer("ahmet.eker@gmail.com", "123456");
		System.out.println("---- LOGÝN2 ----");
		customerManager.loginCustomer("ahmet@gmail.com", "123456");
		System.out.println("---- LOGÝN3 ----");
		customerManager.loginCustomer("ahmet.eker@gmail.com", "123456789");
		System.out.println("---- LOGÝN4 ----");
		customerManager.loginCustomer("ahmet@gmail.com", "123456789");
		
	}

}
