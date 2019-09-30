package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class BankCustomer {

	private String name;
	private String address;
	private String phoneNumber;
	private List <BankAccount> accounts = new ArrayList <BankAccount> ();
	
	public void addAccount (BankAccount newAccount) {
		accounts.add(newAccount);
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public BankAccount[] getAccount() {
		return accounts.toArray(new BankAccount[accounts.size()]);
	}
	
}
