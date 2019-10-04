package com.techelevator;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class BankAccountTest {

	private BankAccount testBankAccount; 
	
	@Before
	public void setup() {
		testBankAccount = new BankAccount();

	}
	
	@Test
	public void verify_bank_account_is_depositing () {
		BigDecimal deposit = new BigDecimal(10.0); 
		BigDecimal balance = (testBankAccount.getBalance().add(deposit)); 
		Assert.assertEquals(new BigDecimal(10), balance);
		
	}
	
	@Test
	public void verify_bank_account_is_withdrawing () {
		BigDecimal withdraw = new BigDecimal(10.0); 
		BigDecimal balance = (testBankAccount.getBalance().subtract(withdraw)); 
		Assert.assertEquals(new BigDecimal(-10), balance);
		
	}
	
	@Test
	public void verify_bank_account_is_transferring_out_of_original_account() {
		BigDecimal transfer = new BigDecimal(10.0); 
		BigDecimal balance = (testBankAccount.withdraw(transfer)); 
		Assert.assertEquals(new BigDecimal(-10), balance);
		
	}
}
