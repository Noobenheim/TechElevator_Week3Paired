package com.techelevator;

import java.math.BigDecimal;

public class BankTeller {
	
	public static void main(String[] args) {
		
		BankAccount checkingAccount = new CheckingAccount();
		BankAccount savingsAccount = new SavingsAccount();

		BankCustomer jayGatsby = new BankCustomer();
		jayGatsby.addAccount(checkingAccount);
		jayGatsby.addAccount(savingsAccount);

		System.out.println(String.format("Jay Gatsby has %s accounts.", jayGatsby.getAccounts().length));
		System.out.println();

		BigDecimal amountToDeposit = new BigDecimal("100.00");
		depositMoney(checkingAccount, amountToDeposit);
		tellAccountBalances(jayGatsby);

		BigDecimal amountToTransfer = new BigDecimal("150");
		transferMoney(checkingAccount, savingsAccount, amountToTransfer);
		tellAccountBalances(jayGatsby);

		amountToTransfer = new BigDecimal("150");
		transferMoney(checkingAccount, savingsAccount, amountToTransfer);
		tellAccountBalances(jayGatsby);
		
		amountToTransfer = new BigDecimal("100");
		transferMoney(savingsAccount, checkingAccount, amountToTransfer);
		tellAccountBalances(jayGatsby);
		
		amountToTransfer = new BigDecimal("50");
		transferMoney(savingsAccount, checkingAccount, amountToTransfer);
		tellAccountBalances(jayGatsby);
	}

	public static void tellAccountBalances(BankCustomer customer) {
		BankAccount[] accounts = customer.getAccounts();
		
		for( BankAccount account : accounts ) {
			System.out.println("Your "+accountType(account)+" has $"+account.getBalance());
		}
		System.out.println();
	}
	
	public static void depositMoney(BankAccount account, BigDecimal amount) {
		BigDecimal originalBalance = account.getBalance();
		account.deposit(amount);
		BigDecimal newBalance = account.getBalance();
		if( originalBalance.equals(newBalance) ) {
			System.out.println("I'm sorry, I was not able to deposit $"+amount+" to your "+accountType(account));
		} else {
			System.out.println("Successfully deposited $"+amount+" to your "+accountType(account));
		}
	}
	
	public static void transferMoney(BankAccount fromAccount, BankAccount toAccount, BigDecimal amount) {
		BigDecimal originalBalance = fromAccount.getBalance();
		fromAccount.transfer(toAccount, amount);
		BigDecimal newBalance = fromAccount.getBalance();
		if( originalBalance.equals(newBalance) ) {
			System.out.println("I'm sorry, I was not able to transfer $"+amount+" from your "+accountType(fromAccount)+" to your "+accountType(toAccount));
		} else {
			System.out.println("Successfully transferred $"+amount+" from your "+accountType(fromAccount)+" to your "+accountType(toAccount));
		}
	}
	
	public static String accountType(BankAccount account) {
		if( account.getClass().equals(CheckingAccount.class) ) {
			return "Checking Account";
		} else if( account.getClass().equals(SavingsAccount.class) ) {
			return "Savings Account";
		} else {
			return "Bank Account";
		}
	}
}
