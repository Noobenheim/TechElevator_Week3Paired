package com.techelevator;

import java.math.BigDecimal;

public class CheckingAccount extends BankAccount {
	// Data Members
	/**
	 * {@code BigDecimal} amount representing the amount that would be deducted
	 * from the balance as an Overdraft Fee.
	 */
	private static final BigDecimal OVERDRAFT_FEE_AMOUNT = new BigDecimal(10.00);
	/**
	 * {@code BigDecimal} amount representing the minimum limit a balance can hit.
	 * The balance will never be allowed to be lower than this amount.
	 */
	private static final BigDecimal PREVENT_WITHDRAW_AMOUNT = new BigDecimal(-100.00);
	/**
	 * @code BigDecimal} amount representing how low the balance can be before
	 * an Overdraft Fee is deducted from the balance. If the balance is lower than
	 * this amount, an Overdraft Fee will be deducted upon withdraw.
	 */
	private static final BigDecimal OVERDRAFT_BALANCE_AMOUNT = new BigDecimal(0.00);
	
	// Class Methods
    /**
     * Decrements account balance by {@code amountToWithdraw} with
     * restrictions and consequences: <ul>
     * <li>If the balance would ever be dropped below {@link #PREVENT_WITHDRAW_AMOUNT}, including the overdraft fee,
     * the transaction is canceled and nothing will happen.</li>
     * <li>If the balance would drop below {@link #OVERDRAFT_BALANCE_AMOUNT}, an overdraft fee of {@link #OVERDRAFT_FEE_AMOUNT} will occur.</li>
     * </ul>
     *
     * @param amountToWithdraw {@code BigDecimal} Amount to
     *                         withdraw.
     * @return Current Account Balance
     */
	@Override
	public BigDecimal withdraw(BigDecimal amountToWithdraw) {
		// figure out what the balance would be if we withdrew the amountToWithdraw
		BigDecimal targetBalance = this.getBalance().subtract(amountToWithdraw);
		// figure out what the balance would be if we withdrew the amountToWithdraw and withdrew the overdraft
		BigDecimal targetBalanceWithOverdraft = targetBalance.subtract(OVERDRAFT_FEE_AMOUNT);
		
		// is the balance with the overdraft and amount withdrawn less than the limit minimum?
		if (targetBalanceWithOverdraft.compareTo(PREVENT_WITHDRAW_AMOUNT) < 0) {
			// it is, do nothing to this account
			return this.getBalance();
		}

		// is the balance with the amount withdrawn less than the limit to avoid overdraft fee?
		if (targetBalance.compareTo(OVERDRAFT_BALANCE_AMOUNT) < 0) {
			// it is, withdraw an overdraft fee using the parent method
			super.withdraw(OVERDRAFT_FEE_AMOUNT);
		}
		// if we got here, we know it didn't hit the the limit minimum and overdraft is taken care of.
		// just withdraw the amount from the account using the parent method and return the new balance
		return super.withdraw(amountToWithdraw);
	}
}