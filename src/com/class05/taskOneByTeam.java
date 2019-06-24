package com.class05;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utils.CommonMethods;

public class taskOneByTeam  extends CommonMethods {
	@Parameters({"browser", "url"})
	@BeforeMethod 
	public void setUp(String browser, String url) {
	
		
	setUpDriver(browser, url);	
	driver.findElement(By.xpath("//input[contains(@id,'username')]")).sendKeys("Tester");
	driver.findElement(By.xpath("//input[contains(@id,'password')]")).sendKeys("test");
	driver.findElement(By.xpath("//input[contains(@id,'login_button')]")).click();
	
	}

	@DataProvider(name ="setOfData")

	public Object [][] setUpData() {
		
		Object [] [] data = new Object[2][9]	;
		
		data[0][0]="100";
		data[0][1]="John Smith";	
		data[0][2]="123 street ";
		data[0][3]="Ashburn";	
		data[0][4]="Va";
		data[0][5]="20147";	
		data[0][6]="Visa";
		data[0][7]="0000";	
		data[0][8]="00/00";	
		
		
		data[1][0]="200";
		data[1][1]="Mary Smith";	
		data[1][2]="123 street ";
		data[1][3]="Ashburn";	
		data[1][4]="Va";
		data[1][5]="20147";	
		data[1][6]="MasterCard";
		data[1][7]="0001";	
		data[1][8]="01/00";	
		
				
	    return data;
		
	}

	@Test(dataProvider = "setOfData")
	public void  testUsers(String quantity, String customerName, String street, String city, String state, String zip, String card , String cardNr, String date) throws IOException {
	
		driver.findElement(By.xpath("//a[text()='Order']")).click();
	driver.findElement(By.xpath("//input[contains(@id,'Quantity')]")).sendKeys(quantity);
	driver.findElement(By.xpath("//input[contains(@id,'Name')]")).sendKeys(customerName);
	driver.findElement(By.xpath("//input[contains(@id,'TextBox2')]")).sendKeys(street);
	driver.findElement(By.xpath("//input[contains(@id,'TextBox3')]")).sendKeys(city);
	driver.findElement(By.xpath("//input[contains(@id,'TextBox4')]")).sendKeys(state);
	driver.findElement(By.xpath("//input[contains(@id,'TextBox5')]")).sendKeys(zip);
	driver.findElement(By.xpath("//input[contains(@value, '"+card+"')]")).click();
	driver.findElement(By.xpath("//input[contains(@id,'TextBox6')]")).sendKeys(cardNr);
	driver.findElement(By.xpath("//input[contains(@name,'TextBox1')]")).sendKeys(date);
	
	if(customerName.contains("John Smith")) {
	takeAscreenShot("Task1", "smartbearsoftwareUserOne");
	}
	else  {
		takeAscreenShot("Task1", "smartbearsoftwareUserTwo");
	}
	driver.findElement(By.xpath("//a[contains(@id,'InsertButton')]")).click();
		
		
		
	}

	@AfterMethod 
	public void tearDown() {
	driver.close();

	}
}

