package com.class02;

import org.openqa.selenium.By;
import org.testng.annotations.*;

import utils.CommonMethods;

public class Task1 extends CommonMethods{
	
	/*
	
	TC 1: OrangeHRM Title Validation

TC 2: OrangeHRM Successful Login 
https://opensource-demo.orangehrmlive.com/
Please make sure to use the following:
 annotations:
	@BeforeMethod
	@AfterMethod
	@Test

What would you do if you do not want to execute any specific test case?
What would you do if you want to execute any specific test case first?
	
	 */
	
	@BeforeClass
	public void startDriver() {
		
		String url= "https://opensource-demo.orangehrmlive.com/";
		setUpDriver("chrome", url);
	}
	
	@Test(priority = 1)
	public void verifyTitle () {
		
		String verifyTitle= driver.getTitle();
		
		if (verifyTitle.equals("OrangeHRM")) {
			System.out.println("The "+verifyTitle+" is displayed");
		}else {
			System.out.println("The "+verifyTitle+" is NOT displayed");
		}
		
	}
	
	
	@Test(priority = 2)
	public void login () {
		
		
		String url= "https://opensource-demo.orangehrmlive.com/";
		setUpDriver("chrome", url);
		
		sendText(driver.findElement(By.cssSelector("input#txtUsername")), "Admin");
		
		sendText(driver.findElement(By.cssSelector("input#txtPassword")), "admin123");
		
		clickElement(driver.findElement(By.cssSelector("input#btnLogin")));
		
	}
	
	@AfterClass
	public void closedriver() {
		
		driver.close();
	}
	
	

}
