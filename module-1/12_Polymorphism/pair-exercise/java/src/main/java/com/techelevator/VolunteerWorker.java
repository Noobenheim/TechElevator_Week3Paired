package com.techelevator;

public class VolunteerWorker extends Person implements Worker {
	public VolunteerWorker (String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public double calculateWeeklyPay(int hoursWorked) {
		double pay = hoursWorked * 0;
		return pay;
	}
}
