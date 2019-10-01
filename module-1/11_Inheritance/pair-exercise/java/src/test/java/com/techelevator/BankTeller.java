package com.techelevator;

import java.math.BigDecimal;

public class BankTeller {
	
	public static void main(String[] args) {
		
		BankAccount checkingAccount = new CheckingAccount();
		BankAccount savingsAccount = new SavingsAccount();

		BankCustomer jayGatsby = new BankCustomer();
		jayGatsby.addAccount(checkingAccount);
		jayGatsby.addAccount(savingsAccount);

		System.out.println(String.format("Jay Gatsby has %s accounts.", jayGatsby.getAccount().length));

		BigDecimal amountToDeposit = new BigDecimal("100.00");
		BigDecimal newBalance = checkingAccount.deposit(amountToDeposit);
		System.out.println(newBalance); 

		BigDecimal amountToTransfer = new BigDecimal("150");
		checkingAccount.transfer(savingsAccount, amountToTransfer);
		System.out.println(savingsAccount.getBalance()); 	
		System.out.println(checkingAccount.getBalance()); 

		amountToTransfer = new BigDecimal("150");
		checkingAccount.transfer(savingsAccount, amountToTransfer);
		System.out.println(savingsAccount.getBalance()); 	
		System.out.println(checkingAccount.getBalance()); 
	}

}
