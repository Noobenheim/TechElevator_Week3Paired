package com.techelevator;

public class HourlyWorker extends Company {

	private double hourlyRate;

	

	public double getHourlyRate() {
		return hourlyRate;
	}

	public HourlyWorker(String firstName, String lastName, int hoursWorked, double hourlyRate) {
		this.firstName = firstName;
		this.lastName = lastName; 
		this.hourlyRate = hourlyRate; 
		this.hoursWorked = hoursWorked; 

	}

	@Override
	public double calculateWeeklyPay(int hoursWorked) {
		double pay = this.hoursWorked * this.hourlyRate;
		double overtime = this.hoursWorked - 40;
		
		if (this.hoursWorked > 40) {
			pay = pay + (this.hourlyRate * overtime * .5);
			return pay;
		} 
		else {
			return pay;
		}
	}

}
