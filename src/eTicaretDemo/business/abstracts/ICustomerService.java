package eTicaretDemo.business.abstracts;

import java.util.List;

import eTicaretDemo.entities.concretes.Customer;

public interface ICustomerService {
	void add(Customer customer);
	void delete(Customer customer);
	void update(Customer customer);
	Customer get(int id);
	List<Customer> getAll();
	
	void sendActivationEmailToCustomer(Customer customer);
	void activateCustomer(Customer customer);
	void deactivateCustomer(Customer customer);
	boolean registerCustomer(Customer customer);
	boolean loginCustomer(String email, String password);
}
