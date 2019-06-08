package com.class04;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.CommonMethods;

public class SaucedemoTask extends CommonMethods{

	/*
	 
	 Identify Priority of Test Cases
https://www.saucedemo.com/

TC 1: Saucedemo Username1(tag the groups - Smoke)
Step 1: Open browser and navigate to Saucedemo
Step 2: Enter username standard_user and enter password secret_sauce and click login button
Step 3: Verify user successfully logged in

TC 2: Saucedemo Username2(tag the groups - Regression)
Step 1: Open browser and navigate to Saucedemo
Step 2: Enter username problem_user and enter password secret_sauce and click login button
Step 3: Verify user successfully logged in


Note: Create BeforeMethod and AfterMethod annotations to open browser and logout from the application. Create a xml file and include smoke.
	 
	 */
	@BeforeMethod()
	public void setdriver() {
		
		setUpDriver("chrome", "https://www.saucedemo.com/");
		
	}
	
	@Test( groups = {"Smoke"})
    public void Username1() {
        driver.findElement(By.xpath("//input[contains(@id,'user-name')]")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[contains(@id,'password')]")).sendKeys("secret_sauce");   
        
    }
	
	@Test(groups = {"Regression"}, dependsOnMethods = {"Username1"})
    public void Username2() {
        driver.findElement(By.xpath("//input[contains(@id,'user-name')]")).sendKeys("problem_user");
        driver.findElement(By.xpath("//input[contains(@id,'password')]")).sendKeys("secret_sauce");
       
    }
	
	@AfterMethod()
	
	public void tearDown() throws InterruptedException {
		driver.findElement(By.xpath("//input[contains(@class,'btn_action')]")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//div[text()='Products']")).isDisplayed(), true);
		Thread.sleep(3000);
		driver.close();
	}
	
}
