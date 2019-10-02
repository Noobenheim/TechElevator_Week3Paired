package com.techelevator;

public class HourlyWorker extends Person implements Worker {
	private double hourlyRate;

	public double getHourlyRate() {
		return hourlyRate;
	}

	public HourlyWorker(String firstName, String lastName, double hourlyRate) {
		this.firstName = firstName;
		this.lastName = lastName; 
		this.hourlyRate = hourlyRate;
	}

	@Override
	public double calculateWeeklyPay(int hoursWorked) {
		double pay = hoursWorked * this.hourlyRate;
		double overtime = hoursWorked - 40;
		
		if (hoursWorked > 40) {
			pay = pay + (this.hourlyRate * overtime * .5);
			return pay;
		} 
		else {
			return pay;
		}
	}
}
