package com.techelevator;

import java.math.BigDecimal;

public class BankAccount {
	// Data Members
	/**
	 * The account number, represented as a {@code String}
	 */
	private String accountNumber;
	/**
	 * The balance of the {@code BankAccount} in {@code BigDecimal}
	 */
	private BigDecimal balance;
	
	// Constructor(s)
	public BankAccount () {
		balance = new BigDecimal(0); 
	}
	
	// Getters and Setters
    /**
     * Returns a {@code String} representing the account
     * number of the class.
     *
     * @return Account Number
     */
	public String getAccountNumber() {
		return accountNumber;
	}
    /**
     * Sets a {@code String} representing the account
     * number of the class.
     *
     * @param accountNumber {@code String} account number
     */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
    /**
     * Returns a {@code BigDecimal} of the current account
     * balance.
     *
     * @return Account Number
     */
	public BigDecimal getBalance() {
		return balance;
	}
	
	// Class Methods
    /**
     * Increments account balance by {@code amountToDeposit}.
     *
     * @param amountToDeposit {@code BigDecimal} Amount of
     *                        money to deposit int account.
     * @return Current Account Balance
     */
	public BigDecimal deposit(BigDecimal amountToDeposit) {
		// set the balance to the balance plus the amountToDeposit
		balance = this.balance.add(amountToDeposit); 
		// return the new balance
		return balance; 
	}
	
    /**
     * Decrements account balance by {@code amountToWithdraw}
     *
     * @param amountToWithdraw {@code BigDecimal} Amount to
     *                         withdraw.
     * @return Current Account Balance
     */
	public BigDecimal withdraw (BigDecimal amountToWithdraw) {
		// set the balance to the balance minus the amountToWithdraw
		balance = this.balance.subtract(amountToWithdraw);
		// return the changed balance
		return balance;
	}
	
	/**
     * Decrements account balance by {@code transferAmount} and
     * calls the {@code deposit} method in {@code destinationAccount}.
     *
     * @param destinationAccount {@code BankAccount} Account to deposit
     *                           {@code transferAmount} into.
     * @param amountToWithdraw {@code BigDecimal} Amount to withdraw.
     * @return Current Account Balance
     */
	public void transfer(BankAccount destinationAccount, BigDecimal transferAmount) {
		// get the original balance
		BigDecimal originalBalance = this.getBalance();
		// withdraw the transferAmount from the balance
		this.withdraw(transferAmount);
		// make sure the amount changed
		if( !this.getBalance().equals(originalBalance) ) {
			// if the balance changed, deposit the amount into the destination account
			destinationAccount.deposit(transferAmount);
		}
	}
}
