package com.class03;

import org.openqa.selenium.By;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utils.CommonMethods;

public class NewtoursExample extends CommonMethods {
	
	@BeforeClass()
	public void setUP() {
		setUpDriver("chrome", "http://newtours.demoaut.com/");
		driver.findElement(By.xpath("//a[text()='REGISTER']")).click();
	}
	
	@Test(groups= "Smoke", dependsOnGroups = "Regression")
	public void userInformation() {
		sendText(driver.findElement(By.cssSelector("input#email")),"usertest@gmail.com");
		sendText(driver.findElement(By.cssSelector("input[name='password']")), "passtest");
		sendText(driver.findElement(By.cssSelector("input[name='confirmPassword']")), "passtest");
		
	}
	
	@Test(groups ="Regression")
	public void contactInformation() {
		sendText(driver.findElement(By.cssSelector("input[name='firstName']")), "nameTest");	
		sendText(driver.findElement(By.cssSelector("input[name='lastName']")), "lastnameTest");
		sendText(driver.findElement(By.cssSelector("input[name='phone']")), "phoneTest");
		sendText(driver.findElement(By.cssSelector("input[name='userName']")), "userTest");
	}
	
	@Test(groups ="Regression")
	public void AddressInformation(){
		
		sendText(driver.findElement(By.cssSelector("input[name='address1']")), "addressTest");	
		sendText(driver.findElement(By.cssSelector("input[name='city']")), "cityTest");
		sendText(driver.findElement(By.cssSelector("input[name='state']")), "stateTest");
		sendText(driver.findElement(By.cssSelector("input[name='postalCode']")), "postalTest");
	}
	
	@AfterGroups(groups= "Smoke")
	
	public void tearDown() {
		
		driver.findElement(By.cssSelector("input[name='register']")).click();
		driver.close();
	}

}