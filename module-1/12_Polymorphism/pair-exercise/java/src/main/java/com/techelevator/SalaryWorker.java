package com.techelevator;

public class SalaryWorker extends Person implements Worker {
	private double annualSalary;
	
	public double getAnnualSalary() {
		return annualSalary;
	}
	
	public SalaryWorker (String firstName, String lastName, double annualSalary) {
		super(firstName, lastName);
		this.annualSalary = annualSalary;
		
		if (this.annualSalary <= 0) {
			throw new IllegalArgumentException("Annual salary cannot be lower than or equal to 0");
		}
	}

	@Override
	public double calculateWeeklyPay(int hoursWorked) {
		//does not care how many hoursWorked are specified
		double pay = annualSalary / 52; 
		return pay; 
	}
}
