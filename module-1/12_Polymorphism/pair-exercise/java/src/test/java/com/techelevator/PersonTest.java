package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PersonTest {
	
	Person name; 
	
	@Before 
	
	public void names () {
		name = new Person("FirstName", "LastName"); 
	}
	
	@Test
	public void correct_first_name() {
		String firstName = name.getFirstName();
		Assert.assertEquals("FirstName", firstName);
	}
	
	@Test
	public void correct_last_name() {
		String lastName = name.getLastName();
		Assert.assertEquals("LastName", lastName);
	}

}
