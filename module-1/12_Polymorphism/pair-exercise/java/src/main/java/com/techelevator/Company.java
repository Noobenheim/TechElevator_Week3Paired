package com.techelevator;

public class Company implements Worker{
	
	protected String firstName;
	protected String lastName;
	protected int hoursWorked; 


	public String firstName() {
		return firstName();
	}

	public String lastName() {
		return lastName();
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
	
	public int getHoursWorked() {
		return hoursWorked;
	}


	@Override
	public double calculateWeeklyPay(int hoursWorked) {
		
		return 0;
	}

}
