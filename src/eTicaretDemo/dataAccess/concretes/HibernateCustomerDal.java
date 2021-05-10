package eTicaretDemo.dataAccess.concretes;

import java.util.List;

import eTicaretDemo.Main;
import eTicaretDemo.dataAccess.abstracts.ICustomerDal;
import eTicaretDemo.entities.concretes.Customer;

public class HibernateCustomerDal implements ICustomerDal {

	@Override
	public void add(Customer customer) {
		Main.customers.add(customer);		
	}

	@Override
	public void delete(Customer customer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Customer customer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Customer get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
