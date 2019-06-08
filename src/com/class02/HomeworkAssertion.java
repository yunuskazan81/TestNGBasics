package com.class02;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import utils.CommonMethods;

public class HomeworkAssertion extends CommonMethods{

	/*
	 // uplodading photo in selenium
	 String filename = "test.txt";
File file = new File(filename);       
String path = file.getAbsolutePath();

driver.findElement(By.cssSelector("i.fa.fa-upload")).click();
driver.findElement(By.cssSelector("div[class=internal] i.entypo-upload")).sendKeys(path);
driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
driver.findElement(By.cssSelector("button.btn.btn-green.btn-lg")).click(); //upload button
	 
	 
	 Identify Priority of Test Cases
	 
https://opensource-demo.orangehrmlive.com/

TC 1: OrangeHRM Verify Successful Login
Step 1: Open browser and navigate to OrangeHRM
Step 2: Enter valid UID and valid PWD and click login button
Step 3: Verify user successfully logged in

TC 2: OrangeHRM Add Employee
	Step 1: Click on PIM link and Add Employee
	Step 2: Provide Details and Save
	Step 3: Verify Employee is added 

TC 3: OrangeHRM Verify Employee Details
	Step 1: Click on PIM link and Employee List
	Step 2: Search for employee by it id
	Step 3: Verify Employee details are displayed 

Note: Create BeforeClass and AfterClass annotations to open browser and logout from the application
	 
	 
	 */
	
	@BeforeClass
	
	public void openBrowser() {
		
		setUpDriver("chrome", "https://opensource-demo.orangehrmlive.com/");
		
		
	}
	
	@Test(priority = 1, enabled=true)
	
	public void login() {
		
		WebElement element= driver.findElement(By.cssSelector("input#txtUsername"));
		String value= "Admin";
		sendText(element, value);
		
		element= driver.findElement(By.cssSelector("input#txtPassword"));
		value= "admin123";
		sendText(element, value);
		
		driver.findElement(By.cssSelector("input#btnLogin")).click();
		
		
		String Expected= "Dashboard";
		String actual= driver.findElement(By.xpath("//h1[text()='Dashboard']")).getText();
		String message="Actual value is matched with expected = "+Expected;
		
		Assert.assertEquals(actual, Expected);
		System.out.println(message);
	}
	
	
	@Test(priority = 2, enabled= true)
	
	public void clickPIM() throws InterruptedException {
		
		WebDriverWait wait=new WebDriverWait(driver, 10);
		
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='menu_pim_viewPimModule']")));
		
		WebElement hover =driver.findElement(By.xpath("//a[@id='menu_pim_viewPimModule']"));
		
		hover.click();
		
		
		WebElement addEmployeeButton= driver.findElement(By.cssSelector("a#menu_pim_addEmployee"));
		
		addEmployeeButton.click();
		
		
		WebElement element= driver.findElement(By.cssSelector("input#firstName"));
		String value= "Yunus";
		sendText(element, value);
		
		element= driver.findElement(By.cssSelector("input#middleName"));
		value= "Emre";
		sendText(element, value);
		
		element= driver.findElement(By.cssSelector("input#lastName"));
		value= "Kazan";
		sendText(element, value); 
		
		
		element= driver.findElement(By.cssSelector("input#employeeId"));  // input#btnSave
		value= "001243";
		sendText(element, value);
		
		WebElement elementSendKey= driver.findElement(By.xpath("//input[@id='photofile']"));
		uploadFileSelect(elementSendKey, "/Users/yunuskazan/Yunus/myphoto.jpg");
	
		element= driver.findElement(By.cssSelector("input#chkLogin"));  
		element.click();
		
		element= driver.findElement(By.cssSelector("input#user_name"));  // input#btnSave
		value= "yunuskazan81";
		sendText(element, value);
		
		element= driver.findElement(By.cssSelector("input#user_password"));  // input#btnSave
		String password= "yK198781.";
		sendText(element, password);
		element= driver.findElement(By.cssSelector("input#re_password"));  // input#btnSave
		String confirm= "yK198781.";
		sendText(element, confirm);
		
		Assert.assertEquals(password, confirm);
		
		element= driver.findElement(By.cssSelector("select#status"));
		String text= "Enabled";
		selectValueFromDD(element, text);
		
		
		element= driver.findElement(By.cssSelector("input#btnSave"));  
		element.click();
		
		takeAscreenShot("screenShots", "TheInternet");
		Thread.sleep(3000);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//input[@value='Edit']")).click();
		driver.findElement(By.xpath("//input[@value='Emre']")).clear();
		
		
		WebElement radio= driver.findElement(By.xpath("//label[@for='personal_optGender_1']"));
			String Text= radio.getText();
			String gender= "Male";
			Assert.assertEquals(Text, gender);
			radio.click();
			
		
		WebElement nationality= driver.findElement(By.xpath("//select[@id='personal_cmbNation']"));
		
		String myCountry= "Turkish";
		Select select= new Select(nationality);
		
		List<WebElement> countries= select.getOptions();
		
		for(WebElement country : countries) {
			
			String countryText= country.getText();
			if(countryText.equals(myCountry)) {
				select.selectByVisibleText(myCountry);
				break;
			}
			
		}
		
		element= driver.findElement(By.xpath("//input[@id='personal_txtOtherID']"));
		String idcard= "Passport";
		sendText(element, idcard);
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		element= driver.findElement(By.xpath("//img[@class='ui-datepicker-trigger']"));
		element.click();
		
		
		WebElement month= driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
		
		select= new Select(month);
		String selectMonth= "Dec";
		List<WebElement> allmonths= select.getOptions();
		
		for(WebElement eachmonth :allmonths ) {
			
			String monthText= eachmonth.getText();
			
			if(monthText.equals(selectMonth)) {
			select.selectByVisibleText(selectMonth);
			Thread.sleep(3000);
			break;
			}
		}
		
		
		WebElement year= driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
		
		select= new Select(year);
		
		String selectYear= "2022";
		
		List<WebElement> allyears= select.getOptions();
		
		for(WebElement eachyear :allyears ) {
			
			String yearText= eachyear.getText();
			
			if(yearText.equals(selectYear)) {
			select.selectByVisibleText(yearText);
			Thread.sleep(3000);
			break;
			}
		}
		
		String Expected= "31";
		
		List<WebElement> day= driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
		
		
		for(WebElement dayCell : day) {
			
			String cellText= dayCell.getText();
			
			if(cellText.equals(Expected)) {
				js.executeScript("arguments[0].click();", dayCell);
				break;
			}
			
		}
		
		String selectedDate = driver.findElement(By.xpath("//input[@id='personal_txtLicExpDate']")).getText();
		
		String expiration= "2022-12-31";
		
		SoftAssert soft= new SoftAssert();
		
		soft.assertEquals(selectedDate, expiration);
		
		System.out.println("Your Passport ID expiration date is= "+ expiration);
		
		
		element= driver.findElement(By.xpath("//select[@id='personal_cmbMarital']"));
		
		select= new Select(element);
		
		List<WebElement> marital= select.getOptions();
		String gText= "Single";
		
		for(WebElement Gender :marital) {
			
			String genText= Gender.getText();
			
			if(genText.equals(gText)) {
			select.selectByVisibleText(gText);
			break;
			
			}
		}
		
		
		element= driver.findElement(By.xpath("//input[@id='personal_DOB']/../img"));
		js.executeScript("arguments[0].click();", element);
		
		WebElement birthMont= driver.findElement(By.xpath("//div[contains(@class,'ui-datepicker-title')]/select"));
		selectValueFromDD(birthMont, "Jun");
		
		
		WebElement birthyear= driver.findElement(By.xpath("//div[contains(@class,'ui-datepicker-title')]/select[2]"));
		selectValueFromDD(birthyear, "1987");
		
		List<WebElement> Table= driver.findElements(By.xpath("//table[contains(@class,'ui-datepicker-calendar')]/tbody/tr/td"));
		String birthDay= "26";
		calender(Table,birthDay );
		
		WebElement selectBirth= driver.findElement(By.xpath("//input[@id='personal_DOB']"));
		String dob= selectBirth.getText();
		String expDob= "1987-06-26";
		soft.assertEquals(dob, expDob);
		
		System.out.println("Your Date of birth is= "+ expDob);
		
		element= driver.findElement(By.xpath("//input[@id='btnSave']"));
		element.click();
		
		takeAscreenShot("TheInternet", "OrangeHRM");

		Thread.sleep(3000);
		
		}
	
	
	@Test(priority = 3, enabled = false)
	
	public void EditPerson() throws InterruptedException {
		
	// employee login 
		
		//setUpDriver("chrome", "https://opensource-demo.orangehrmlive.com/");
		
//		WebElement element= driver.findElement(By.cssSelector("input#txtUsername"));
//		String username= "yunuskazan81";
//		sendText(element, username);
//		
//		
//		element=  driver.findElement(By.cssSelector("input#txtPassword"));
//		String passwrd= "yK198781.";
//		sendText(element, passwrd);
		
//		WebElement edit= driver.findElement(By.cssSelector("input#btnSave"));
//		edit.click();
		
		
		
		
//		driver.findElement(By.cssSelector("a#menu_pim_viewMyDetails")).click();
		
				
		
		
		
	}
	
	
	@Test(priority = 4, enabled= true)
	
	public void searchAndVerify() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		Thread.sleep(5000);
		
		WebElement element= driver.findElement(By.xpath("//a[@id='menu_directory_viewDirectory']"));
		js.executeScript("arguments[0].click();", element);
		
		element = driver.findElement(By.xpath("//input[@id='searchDirectory_emp_name_empName']"));
		sendText(element, "Yunus Kazan");
		
		element = driver.findElement(By.xpath("//input[@id='searchBtn']"));
		js.executeScript("arguments[0].click();", element);
		
		
		List<WebElement> elementRows= driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
		List<WebElement> elementCells= driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr/td"));
		
		for(int i=2; i<elementRows.size(); i++) {
			
			for(int k=1; k<elementCells.size(); k++) {
				
			WebElement edited= driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr["+i+"]/td["+k+"]")); 
			
			String actual=edited.getText();
			String name= "Yunus Kazan";
			
			if(actual.equals(name)) {
				
				String message= "Actual value is matched with expected = "+ name+" Test is done succesfully";
				System.out.println(message);
				break;
			}	
				
			}
			
		}
		
		
		
	}
	
	@AfterClass
	
	public  void closeDriver() throws InterruptedException {
		Thread.sleep(5000);
		driver.close();
	}
	
	
}
