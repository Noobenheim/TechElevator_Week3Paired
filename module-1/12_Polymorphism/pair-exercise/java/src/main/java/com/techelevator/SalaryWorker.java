package com.techelevator;

public class SalaryWorker extends Company {

	private double annualSalary;

	
	public double getAnnualSalary() {
		return annualSalary;
	}
	
	public SalaryWorker (String firstName, String lastName, int hoursWorked, double annualSalary) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.annualSalary = annualSalary;
		this.hoursWorked = hoursWorked; 
	
	}

	@Override
	public double calculateWeeklyPay(int hoursWorked) {
		//does not care how many hoursWorked are specified
		double pay = annualSalary / 52; 
			return pay; 
	}



	
	
}
