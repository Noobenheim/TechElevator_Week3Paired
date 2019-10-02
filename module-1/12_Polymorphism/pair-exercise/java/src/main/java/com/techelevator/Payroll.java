package com.techelevator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Payroll {

	public static void main(String[] args) {
		Worker[] employees = new Worker[] {new MickeyMouse(), new GoofyGeef(), new DaisyDuck(), new MinnieMouse()};
		List<Worker> workers = new ArrayList<>( Arrays.asList(employees) );
		Map<Worker, Integer> workerToHoursWorked = new HashMap<>();
		
		workerToHoursWorked.put(workers.get(0), 90); // Mickey Mouse
		workerToHoursWorked.put(workers.get(1), 90); // Goofy Geef
		workerToHoursWorked.put(workers.get(2), 110); // Daisy Duck
		workerToHoursWorked.put(workers.get(3), 20); // Minnie Duck
		
		double totalPay = 0.0;
		int totalHours = 0;
		
		System.out.println("Employee\tHours Worked\t\tPay");
		System.out.println("====================================================");
		
		for(Worker worker : workers) {
			int hoursWorked = workerToHoursWorked.get(worker);
			double calculatePay = worker.calculateWeeklyPay(hoursWorked); 
			
			System.out.println(worker.getLastName() + ", " + worker.getFirstName() + "\t"+ hoursWorked + "\t\t\t$" + Double.toString(calculatePay));

			totalHours = totalHours + hoursWorked; 
			totalPay += calculatePay;
		}
		System.out.println(); 
		System.out.println("Total hours worked: " + totalHours);
		System.out.println("Total pay: " + totalPay);
	} 

}
