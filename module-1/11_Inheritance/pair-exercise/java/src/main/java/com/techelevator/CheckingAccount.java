package com.techelevator;

import java.math.BigDecimal;

public class CheckingAccount extends LimitedAccount {
	/**
	 * The Overdraft Fee amount that will be charged if balance goes below {@link #OVERDRAFT_FEE_LIMIT}
	 */
	public static final BigDecimal OVERDRAFT_FEE_AMOUNT = new BigDecimal(10);
	/**
	 * Will not allow the balance to go below this amount
	 */
	public static final BigDecimal BALANCE_MINIMUM_LIMIT = new BigDecimal(-100);
	/**
	 * The amount of money which if the balance goes below this value will charge an {@link #OVERDRAFT_FEE_AMOUNT}
	 */
	public static final BigDecimal OVERDRAFT_FEE_LIMIT = new BigDecimal(0);
	
	/**
	 * Creates a {@code CheckingAccount} that has a fee of {@link #OVERDRAFT_FEE_AMOUNT}, a balance limit of 
	 * {@link #BALANCE_MINIMUM_LIMIT}, and an overdraft limit of {@link #OVERDRAFT_FEE_LIMIT}
	 */
	public CheckingAccount() {
		super(OVERDRAFT_FEE_AMOUNT, BALANCE_MINIMUM_LIMIT, OVERDRAFT_FEE_LIMIT);
	}
}
