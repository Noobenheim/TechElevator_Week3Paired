package com.techelevator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Payroll {

	public static void main(String[] args) {
		
		
		Company[] employees = new Company[] {new MickeyMouse(), new GoofyGeef(), new DaisyDuck()};
		
		List<Company> workers = new ArrayList<>();
		
		workers.addAll(Arrays.asList(employees));
		
		double totalPay = 0.0; 
		int totalHours = 0; 
		
		for(Company worker : workers) {
			int hoursWorked = worker.getHoursWorked(); 
			double calculatePay = worker.calculateWeeklyPay(hoursWorked); 
			
			System.out.println(worker.getLastName() + ", " + worker.getFirstName() + "\tHours Worked: "+ worker.getHoursWorked() + "\tThey were paid: $" + Double.toString(calculatePay));
		}	
		
		for (Company worker: workers) {
			int hoursWorked = worker.getHoursWorked();
			totalHours = totalHours + hoursWorked; 
			double pay = worker.calculateWeeklyPay(hoursWorked);
			totalPay += pay; 
		}
		System.out.println(); 
		System.out.println("Total hours worked: " + totalHours);
		System.out.println("Total pay: " + totalPay);
	} 

}
