package com.techelevator;

import java.math.BigDecimal;

public class CheckingAccount extends BankAccount {

	@Override
	public BigDecimal withdraw(BigDecimal amountToWithdraw) {

		BigDecimal targetBalance = this.getBalance().subtract(amountToWithdraw);
		BigDecimal targetBalanceWithOverdraft = targetBalance.subtract(new BigDecimal(10.00));
		
		if (targetBalanceWithOverdraft.compareTo(new BigDecimal(-100.00)) < 0) {
			return this.getBalance();
		}

		if (targetBalance.compareTo(new BigDecimal(0.00)) < 0) {
			super.withdraw(new BigDecimal(10.00));
		}
		return super.withdraw(amountToWithdraw);
	}

}
