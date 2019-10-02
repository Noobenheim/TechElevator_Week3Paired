package com.techelevator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BankCustomer {
	// Data Members
	/**
	 * The amount of money required in all accounts to be a VIP customer.
	 */
	private final BigDecimal VIP_AMOUNT = new BigDecimal(25_000);
	/**
	 * The name of the {@code BankCustomer} as a {@code String}.
	 */
	private String name;
	/**
	 * The address of the {@code BankCustomer} as a {@code String}.
	 */
	private String address;
	/**
	 * The phone number of the {@code BankCustomer} as a {@code String}.
	 */
	private String phoneNumber;
	/**
	 * A {@code List} of bank accounts owned by the {@code BankCustomer}.
	 */
	private List <BankAccount> accounts = new ArrayList <BankAccount> ();
	
	// Getters and Setters
	/**
     * Returns a {@code String} representing the name of the customer.
     *
     * @return Person's Name
     */
	public String getName() {
		return name;
	}
	
	/**
     * Sets the person's name.
     *
     * @param name {@code String} Name of the person.
     * @return Person's Name
     */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Returns a {@code String} representing the address of the customer.
	 * 
	 * @return Person's Address
	 */
	public String getAddress() {
		return address;
	}
	
	/**
	 * Sets the person's address.
	 * 
	 * @param address {@code String} Address of the person.
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * Returns a {@code String} representing the phone number of the customer.
	 * 
	 * @return The phone number
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	/**
	 * Sets the person's phone number.
	 * 
	 * @param phoneNumber {@code String} Phone number of the person.
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	/**
	 * Gets all the accounts owned by the person.
	 * 
	 * @return An {@code Array} of {@code BankAccount}
	 */
	public BankAccount[] getAccounts() {
		// return the list converted to an array
		return accounts.toArray(new BankAccount[accounts.size()]);
	}

	/**
	 * Adds a {@code BankAccount} to the {@code accounts} {@code List}.
	 * 
	 * @param newAccount {@code BankAccount} Account to be added.
	 */
	public void addAccount (BankAccount newAccount) {
		accounts.add(newAccount);
	}
	
	/**
	 * Adds up the total balances in all {@code BankAccount}s to see if
	 * the balance is greater than or equal to {@link #VIP_AMOUNT}.
	 * 
	 * @return True if balance is greater than or equal to, or
	 * false if the balance is less than the {@link #VIP_AMOUNT}
	 */
	public boolean isVip() {
		BigDecimal total = new BigDecimal(0);
		for(BankAccount account : accounts ) {
			total = total.add(account.getBalance());
			if( total.compareTo(VIP_AMOUNT) >= 0 ) {
				return true;
			}
		}
		return false;
	}
}
