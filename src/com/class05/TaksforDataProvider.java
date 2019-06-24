package com.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utils.CommonMethods;

public class TaksforDataProvider extends CommonMethods{

	/*
	 Identify Priority of Test Cases

http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Process.aspx
TC 1: Saucedemo Username1(Data Provider - Quantity:, Customer name:,Street: City:, State: ,Zip:,Card:,Card Nr:, Expire date )
Step 1: Open browser and navigate to smartbearsoftware
Step 2: Enter valid username, password and click login button
Step 3: Verify user successfully logged in
Step 4: Click on Order
Step 5: Make an order for two user,enter all the information for both users(Quantity:, Customer name:,Street: City:, State: ,Zip:,Card:,Card Nr:, Expire date)
Step 6: Take ScreenShot before submitting each user 

	 */
	
	@Parameters ({"browser", "url", "Username", "Password"})
	@BeforeClass (alwaysRun = true)
	public void setdriver(String browser, String url, String Username, String Password) {
		
		setUpDriver(browser, url);
		
		WebElement element= driver.findElement(By.cssSelector("input#ctl00_MainContent_username"));
		sendText(element, Username);
		
		element= driver.findElement(By.cssSelector("input#ctl00_MainContent_password"));
		sendText(element, Password); 
		
		
		element= driver.findElement(By.cssSelector("input#ctl00_MainContent_login_button"));
		element.click();
		
		
		element= driver.findElement(By.xpath("//h1[text()='Web Orders']"));
		Assert.assertEquals(element.isDisplayed(), true);
		System.out.println("Logged in successfully");
		
		takeAscreenShot("TaskAboutDataprovider", "LoginSuccesfully");
	}
	
	
	
	@DataProvider()
	public Object [][] setData(){
		Object [][] data = new Object[2][9];
		
		data[0][0]="4";
		data[0][1]="Yunus Kazan";
		data[0][2]="4850 marine blvd Apt:F";
		data[0][3]="Fort Lauderdale, FL";
		data[0][4]="U.S";
		data[0][5]="33465";
		data[0][6]="4353453405043589";
		data[0][7]="03/22";
		data[0][8]="MasterCard";
		
		data[1][0]="2";
		data[1][1]="John Pokemonian";
		data[1][2]="112234 Ocean blvd Apt:F";
		data[1][3]="Miami, FL";
		data[1][4]="U.S";
		data[1][5]="33067";
		data[1][6]="6985649203402433";
		data[1][7]="09/23";
		data[1][8]="Visa";
		
		return data;
	}
	
	
	
	@Test(dataProvider = "setData")
	public void createUser(String Quantity , String userName, String street, String city, String state, String zip, String cCard, String EXP, String cardType) {
		
		JavascriptExecutor js= (JavascriptExecutor)driver; 
			
		WebElement element= driver.findElement(By.xpath("//a[text()='Order']"));
		js.executeScript("arguments[0].click();", element);
		
		element= driver.findElement(By.cssSelector("input[id*='txtQuantity']"));
		sendText(element, Quantity);
		
		element= driver.findElement(By.cssSelector("input[id*='txtName']"));
		sendText(element, userName);
		
		element= driver.findElement(By.cssSelector("input[id*='TextBox2']"));
		sendText(element, street);
		
		element= driver.findElement(By.cssSelector("input[id*='TextBox3']"));
		sendText(element, city);
		
		element= driver.findElement(By.cssSelector("input[id*='TextBox4']"));
		sendText(element, state);
		
		element= driver.findElement(By.cssSelector("input[id*='TextBox5']"));
		sendText(element, zip);
		
		element= driver.findElement(By.cssSelector("input[value='"+cardType+"']"));
		String actual= element.getText();
		element.click();
		
		element= driver.findElement(By.cssSelector("input[id*='TextBox6']"));
		sendText(element, cCard);
		
		element= driver.findElement(By.cssSelector("input[id*='TextBox1']"));
		sendText(element, EXP);
		
		takeAscreenShot("TaskAboutDataprovider", "UserOrder");
		
		element= driver.findElement(By.cssSelector("a[id*='InsertButton']"));
		actual= element.getText();
		Assert.assertEquals(actual, "Process");
		js.executeScript("arguments[0].click();", element);
		
		takeAscreenShot("TaskAboutDataprovider", "UserSavedOrder");
		
		element= driver.findElement(By.xpath("//a[text()='View all orders']"));
		actionClick(element);
		
		
		
		
	}
	
}
