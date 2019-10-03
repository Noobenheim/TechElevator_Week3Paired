package com.techelevator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

public class HourlyWorkerTest {
	HourlyWorker worker;
	
	@Before
	public void setupWorker() {
		worker = new HourlyWorker("FirstName", "LastName", 30);
	}
	
	@Test
	public void get_hourly_rate_returns_rate() {
		double hourlyRate = worker.getHourlyRate();
		Assert.assertEquals(30.0, hourlyRate, 0.01);
	}
	
	@Test
	public void doesnt_allow_negative_or_zero_hourly_rate() {
		try {
			worker = new HourlyWorker("FirstName", "LastName", 0.0);
			Assert.fail("Worker hourly wage cannot be 0");
		} catch( IllegalArgumentException e) {
		}
		
		try {
			worker = new HourlyWorker("FirstName", "LastName", -10.0);
			Assert.fail("Worker hourly wage cannot be less than 0");
		} catch( IllegalArgumentException e ) {
		}
	}
	
	@Test
	public void correctly_return_overtime() {
		int hoursWorked = 40;
		double payWithOvertime = worker.calculateWeeklyPay(hoursWorked);
		// no overtime
		Assert.assertEquals(1200.0, payWithOvertime, 0.01);
		
		hoursWorked = 41;
		payWithOvertime = worker.calculateWeeklyPay(hoursWorked);
		Assert.assertEquals(1200.0 + 45.0, payWithOvertime, 0.01);
	}
	
	@Test
	public void correct_payment() {
		int hoursWorked = 20;
		double pay = worker.calculateWeeklyPay(hoursWorked);
		Assert.assertEquals(20.0*30.0, pay, 0.01);
	}
	
	@Test
	public void no_hours_worked_gives_no_pay() {
		int hoursWorked = 0;
		double pay = worker.calculateWeeklyPay(hoursWorked);
		Assert.assertEquals(0.0, pay, 0.01);
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
