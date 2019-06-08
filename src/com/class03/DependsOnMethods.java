package com.class03;

import org.testng.annotations.Test;

public class DependsOnMethods {
	
	@Test(groups= "Smoke")
	public void one() {
		System.out.println("one test ");
	}
	
	@Test(dependsOnMethods="one")
	public void two() {
		System.out.println("two test ");
	}
	
	@Test(dependsOnMethods ="two")
	public void three() {
		System.out.println("three test ");
	}

}
