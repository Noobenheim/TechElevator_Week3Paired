package com.techelevator;

public class VolunteerWorker extends Company {


	public VolunteerWorker (String firstName, String lastName, int hoursWorked) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.hoursWorked = hoursWorked; 
	}

	@Override
	public double calculateWeeklyPay(int hoursWorked) {
		double pay = hoursWorked * 0;
		return pay;
	}
	

}
