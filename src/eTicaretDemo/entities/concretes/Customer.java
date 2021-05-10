package eTicaretDemo.entities.concretes;

import eTicaretDemo.entities.abstracts.IEntity;

public class Customer implements IEntity {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private boolean isAccountActive;
	
	public Customer() {}

	public Customer(int id, String firstName, String lastName, String email, String password) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.isAccountActive = false;
	}
	
	public Customer(String firstName, String lastName, String email, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.isAccountActive = false;
	}
	
	// Getter - Setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAccountActive() {
		return isAccountActive;
	}

	public void setAccountActive(boolean isAccountActive) {
		this.isAccountActive = isAccountActive;
	}
	
}
