package com.techelevator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

public class SalaryWorkerTest {
	SalaryWorker worker;
	
	@Before
	public void setupWorker() {
		worker = new SalaryWorker("FirstName", "LastName", 52000*2);
	}
	
	@Test
	public void weekly_pay_is_correct() {
		int hoursWorked = 35;
		double pay = worker.calculateWeeklyPay(hoursWorked);
		Assert.assertEquals(2000.0, pay, 0.01);
	}
	
	@Test
	public void doesnt_allow_negative_or_zero_annual_pay() {
		try {
			worker = new SalaryWorker("FirstName", "LastName", 0.0);
			Assert.fail("Worker annual pay cannot be 0");
		} catch( IllegalArgumentException e) {
		}
		
		try {
			worker = new SalaryWorker("FirstName", "LastName", -10.0);
			Assert.fail("Worker annual pay cannot be less than 0");
		} catch( IllegalArgumentException e ) {
		}
	}
	
	@Test
	public void correctly_does_not_return_overtime() {
		int hoursWorked = 55;
		double payWithNoOvertime = worker.calculateWeeklyPay(hoursWorked);
		// no overtime payments
		Assert.assertEquals(2000.0, payWithNoOvertime, 0.01);
		
		hoursWorked = 35;
		payWithNoOvertime = worker.calculateWeeklyPay(hoursWorked);
		Assert.assertEquals(2000.0, payWithNoOvertime, 0.01);
	}
	
	@Test
	public void correct_payment() {
		int hoursWorked = 20;
		double pay = worker.calculateWeeklyPay(hoursWorked);
		Assert.assertEquals(2000.0, pay, 0.01);
	}
	
	@Test
	public void no_hours_worked_gives_pay() {
		int hoursWorked = 0;
		double pay = worker.calculateWeeklyPay(hoursWorked);
		Assert.assertEquals(2000.0, pay, 0.01);
	}
	
	@Test
	public void correct_first_name() {
		String firstName = worker.getFirstName();
		Assert.assertEquals("FirstName", firstName);
	}
	
	@Test
	public void correct_last_name() {
		String lastName = worker.getLastName();
		Assert.assertEquals("LastName", lastName);
	}
}
