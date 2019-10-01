package com.techelevator;

import java.math.BigDecimal;

public class LimitedAccount extends BankAccount {
	// Data Members
	/**
	 * {@code BigDecimal} amount representing the amount that would be deducted
	 * from the balance as a fee.
	 */
	private final BigDecimal FEE_AMOUNT;
	/**
	 * {@code BigDecimal} amount representing the minimum limit a balance can hit.
	 * The balance will never be allowed to be lower than this amount.
	 */
	private final BigDecimal PREVENT_WITHDRAW_AMOUNT;
	/**
	 * @code BigDecimal} amount representing how low the balance can be before
	 * a fee is deducted from the balance. If the balance is lower than
	 * this amount, a fee will be deducted upon withdraw.
	 */
	private final BigDecimal OVERDRAFT_BALANCE_AMOUNT;

	/**
	 * Creates a limited account using {@code BigDecimal}s.
	 * 
	 * @param feeAmount {@code BigDecimal} Fee amount that gets withdrawn if under set limit
	 * @param preventWithdrawAmount {@code BigDecimal} Will now allow balance to go below this limit
	 * @param overdraftBalanceAmount {@code BigDecimal} Will charge the fee if below this limit
	 */
	public LimitedAccount(BigDecimal feeAmount, BigDecimal preventWithdrawAmount, BigDecimal overdraftBalanceAmount) {
		FEE_AMOUNT = feeAmount;
		PREVENT_WITHDRAW_AMOUNT = preventWithdrawAmount;
		OVERDRAFT_BALANCE_AMOUNT = overdraftBalanceAmount;
	}
	/**
	 * Creates a limited account using {@code int}s.
	 * 
	 * @param feeAmount {@code int} Fee amount that gets withdrawn if under set limit
	 * @param preventWithdrawAmount {@code int} Will now allow balance to go below this limit
	 * @param overdraftBalanceAmount {@code int} Will charge the fee if below this limit
	 */
	public LimitedAccount(int feeAmount, int preventWithdrawAmount, int overdraftBalanceAmount) {
		this(new BigDecimal(feeAmount), new BigDecimal(preventWithdrawAmount), new BigDecimal(overdraftBalanceAmount));
	}
	
	// Class Methods
    /**
     * Decrements account balance by {@code amountToWithdraw} with
     * restrictions and consequences: <ul>
     * <li>If the balance would ever be dropped below {@link #PREVENT_WITHDRAW_AMOUNT}, including the fee,
     * the transaction is canceled and nothing will happen.</li>
     * <li>If the balance would drop below {@link #OVERDRAFT_BALANCE_AMOUNT}, a fee of {@link #OVERDRAFT_FEE_AMOUNT} will occur.</li>
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
		BigDecimal targetBalanceWithOverdraft = targetBalance.subtract(FEE_AMOUNT);
		
		// is the balance with the overdraft and amount withdrawn less than the limit minimum?
		if (targetBalanceWithOverdraft.compareTo(PREVENT_WITHDRAW_AMOUNT) < 0) {
			// it is, do nothing to this account
			return this.getBalance();
		}

		// is the balance with the amount withdrawn less than the limit to avoid overdraft fee?
		if (targetBalance.compareTo(OVERDRAFT_BALANCE_AMOUNT) < 0) {
			// it is, withdraw an overdraft fee using the parent method
			super.withdraw(FEE_AMOUNT);
		}
		// if we got here, we know it didn't hit the the limit minimum and overdraft is taken care of.
		// just withdraw the amount from the account using the parent method and return the new balance
		return super.withdraw(amountToWithdraw);
	}
}
