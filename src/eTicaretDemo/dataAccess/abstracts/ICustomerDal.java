package eTicaretDemo.dataAccess.abstracts;

import java.util.List;

import eTicaretDemo.entities.concretes.Customer;

public interface ICustomerDal {
	void add(Customer customer);
	void delete(Customer customer);
	void update(Customer customer);
	Customer get(int id);
	List<Customer> getAll();
}
