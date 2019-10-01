package com.techelevator;

public interface Worker {
	
	String getFirstName();
	String getLastName(); 
	int getHoursWorked();
	
	
	public double calculateWeeklyPay (int hoursWorked);

}
