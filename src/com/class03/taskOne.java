package com.class03;


import org.openqa.selenium.By;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import utils.CommonMethods;

public class taskOne extends CommonMethods{
	
	@BeforeGroups({"Smoke1","Regression1","Regression2"})
    public void setUp() {
        setUpDriver("chrome", "https://www.saucedemo.com/");
    }
    
    
    @Test(priority = 3, groups = {"Smoke1"}, dependsOnGroups = {"Regression2"})
    public void personOneLogin() {
        driver.findElement(By.xpath("//input[contains(@id,'user-name')]")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[contains(@id,'password')]")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[contains(@class,'btn_action')]")).click();
         driver.findElement(By.xpath("//button[text()='Open Menu']")).click();
        driver.close();
    }
    
    
    @Test(priority = 1, groups = {"Regression1"})
    public void personThreeLogin() {
        driver.findElement(By.xpath("//input[contains(@id,'user-name')]")).sendKeys("problem_user");
        driver.findElement(By.xpath("//input[contains(@id,'password')]")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[contains(@class,'btn_action')]")).click();
         driver.findElement(By.xpath("    //button[text()='Open Menu']")).click();
        driver.close();
    }
    
    @Test(priority = 2, groups = {"Regression2"}, dependsOnGroups = {"Regression1"})
    public void personFourLogin() {
        driver.findElement(By.xpath("//input[contains(@id,'user-name')]")).sendKeys("performance_glitch_user");
        driver.findElement(By.xpath("//input[contains(@id,'password')]")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[contains(@class,'btn_action')]")).click();
        driver.findElement(By.xpath("//button[text()='Open Menu']")).click();
        driver.close();
    }
    
    @AfterGroups({"Smoke1","Regression1","Regression2"})
    public void close() {
        System.out.println("after group");
    }

	

}