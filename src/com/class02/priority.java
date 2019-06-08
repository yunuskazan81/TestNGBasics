package com.class02;

import org.testng.annotations.*;

public class priority {
	
	@Test
	public void first() {
		
		System.out.println("First test");
	}

	@Test (priority = 1)
public void second() {
		
		System.out.println("second test");
	}
	@Test(priority = 2)
public void third() {
	
	System.out.println("third test");
}

	@Test(priority = 3)
public void fourth() {
	
	System.out.println("fourth test");
}


}
