package com.techelevator;

import java.math.BigDecimal;

public class BankAccount {
	
	public BankAccount () {
		balance = new BigDecimal(0); 
	}
	
	private String accountNumber;
	private BigDecimal balance;
	
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public BigDecimal getBalance() {
		return balance;
	} 
	
	public BigDecimal deposit(BigDecimal amountToDeposit) {
		balance = this.balance.add(amountToDeposit); 
		return balance; 
	}
	
	public BigDecimal withdraw (BigDecimal amountToWithdraw) {
		balance = this.balance.subtract(amountToWithdraw);
		return balance;
	}
	
	public void transfer(BankAccount destinationAccount, BigDecimal transferAmount) {
		destinationAccount.deposit(transferAmount);
		this.withdraw(transferAmount);
		
	}

}
