package com.techelevator;

public class SavingsAccount extends LimitedAccount {
	/**
	 * The Service Fee amount that will be charged if balance goes below {@link #SERVICE_FEE_LIMIT}
	 */
	public static final int SERVICE_FEE_AMOUNT = 2;
	/**
	 * Will not allow the balance to go below this amount
	 */
	public static final int BALANCE_MINIMUM_LIMIT = 0;
	/**
	 * The amount of money which if the balance goes below this value will charge a {@link #SERVICE_FEE_AMOUNT}
	 */
	public static final int SERVICE_FEE_LIMIT = 150;
	
	/**
	 * Creates a {@code CheckingAccount} that has a fee of {@link #SERVICE_FEE_AMOUNT}, a balance limit of 
	 * {@link #BALANCE_MINIMUM_LIMIT}, and a service fee limit of {@link #SERVICE_FEE_LIMIT}
	 */
	public SavingsAccount() {
		super(SERVICE_FEE_AMOUNT, BALANCE_MINIMUM_LIMIT, SERVICE_FEE_LIMIT);
	}
}