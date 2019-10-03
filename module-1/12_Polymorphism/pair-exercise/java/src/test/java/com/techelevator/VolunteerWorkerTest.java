package com.techelevator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

public class VolunteerWorkerTest {
		VolunteerWorker worker;
		
		@Before
		public void setupWorker() {
			worker = new VolunteerWorker("FirstName", "LastName");
		}
		
		@Test
		public void weekly_pay_is_correct() {
			int hoursWorked = 35;
			double pay = worker.calculateWeeklyPay(hoursWorked);
			Assert.assertEquals(0.0, pay, 0.01);
		}
		
		@Test
		public void correctly_does_not_return_overtime() {
			int hoursWorked = 55;
			double payWithNoOvertime = worker.calculateWeeklyPay(hoursWorked);
			// no overtime payments
			Assert.assertEquals(0.0, payWithNoOvertime, 0.01);
			
		}
		
		@Test
		public void no_hours_worked_gives_no_pay() {
			int hoursWorked = 0;
			double pay = worker.calculateWeeklyPay(hoursWorked);
			Assert.assertEquals(0, pay, 0.01);
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