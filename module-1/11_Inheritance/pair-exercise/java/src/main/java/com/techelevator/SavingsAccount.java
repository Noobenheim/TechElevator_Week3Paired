package com.techelevator;

import java.math.BigDecimal;

public class SavingsAccount extends BankAccount {
	
	@Override
	public BigDecimal withdraw(BigDecimal amountToWithdraw) {

		BigDecimal targetBalance = this.getBalance().subtract(amountToWithdraw);
		BigDecimal targetBalanceWithFee = targetBalance.subtract(new BigDecimal(2.00));

		if (targetBalanceWithFee.compareTo(new BigDecimal(0.00)) < 0) {
			return this.getBalance();
		}

		if (targetBalance.compareTo(new BigDecimal(150.00)) < 0) {
			super.withdraw(new BigDecimal(2.00));
		}
		return super.withdraw(amountToWithdraw);
	}

}
