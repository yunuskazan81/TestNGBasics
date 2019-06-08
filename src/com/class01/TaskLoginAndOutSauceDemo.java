package com.class01;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.CommonMethods;

public class TaskLoginAndOutSauceDemo extends CommonMethods {
	
	
	
	/*


	TC 1: Swag Lab Title and Login Verification

@BeforeMethod should contain navigation to the URL and title verification

@Test should contain steps to login and “Product” word verification

@AfterMethod should logOut from the application and close the browser
Collapse

  https://www.saucedemo.com/index.html
  
	 */
	
	
	@BeforeMethod
	
	public void setupdriver() {
		
		String url= "https://www.saucedemo.com/index.html";
		
		setUpDriver("chrome", url);
		
		
	}
	
	
	@Test(priority = 1)
	public void Login() {
		String username= "standard_user";
		String pass= "secret_sauce";
		WebElement user= driver.findElement(By.cssSelector("input#user-name"));
		WebElement password= driver.findElement(By.cssSelector("input#password"));
		WebElement login= driver.findElement(By.cssSelector("input.btn_action"));
		sendText(user, username);
		sendText(password, pass);
		login.click();
		
	}
	
	
	@Test(priority = 3)
	
	public void Logout () {
		
		
		String username= "standard_user";
		String pass= "secret_sauce";
		WebElement user= driver.findElement(By.cssSelector("input#user-name"));
		WebElement password= driver.findElement(By.cssSelector("input#password"));
		WebElement login= driver.findElement(By.cssSelector("input.btn_action"));
		sendText(user, username);
		sendText(password, pass);
		login.click();
		
		//button[text()='Open Menu']
	WebElement openmenu= driver.findElement(By.xpath("//button[text()='Open Menu']"));
	
	openmenu.click();
	
	WebElement logout= driver.findElement(By.cssSelector("a#logout_sidebar_link"));
	
	Actions action= new   Actions(driver);
	
	action.moveToElement(logout).click().perform();
	
	}
	
	
	@Test(priority = 2)
	
	public void checkAllMunebarElement() {
		
		
		String username= "standard_user";
		String pass= "secret_sauce";
		WebElement user= driver.findElement(By.cssSelector("input#user-name"));
		WebElement password= driver.findElement(By.cssSelector("input#password"));
		WebElement login= driver.findElement(By.cssSelector("input.btn_action"));
		sendText(user, username);
		sendText(password, pass);
		login.click();
		
		//all items button
	WebElement openmenu1= driver.findElement(By.xpath("//button[text()='Open Menu']"));
	
	openmenu1.click();
	
	WebElement allitems= driver.findElement(By.cssSelector("a#inventory_sidebar_link"));
	
	Actions action2= new   Actions(driver);
	
	action2.moveToElement(allitems).click().perform();
	
	}
	
	
	@Test(priority = 4)
	
	public void about() {
// about button
	
		String username= "standard_user";
		String pass= "secret_sauce";
		WebElement user= driver.findElement(By.cssSelector("input#user-name"));
		WebElement password= driver.findElement(By.cssSelector("input#password"));
		WebElement login= driver.findElement(By.cssSelector("input.btn_action"));
		sendText(user, username);
		sendText(password, pass);
		login.click();
		
		
WebElement openmenu2= driver.findElement(By.cssSelector("div.bm-burger-button"));	

 	openmenu2.click();
	
	WebDriverWait wait1=new WebDriverWait(driver, 5);
	
	 wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a#about_sidebar_link")));
	
WebElement about= driver.findElement(By.cssSelector("a#about_sidebar_link"));
	
	Actions action= new Actions(driver);
	
	action.moveToElement(about).click().perform();
	
	WebDriverWait wait2=new WebDriverWait(driver, 5);
	
	 wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='WATCH DEMO']")));
	
	driver.navigate().back();
	
	}
	
	
	@Test (priority = 5)
	
	public void reset() {
	 
		//reset button
		
		String username= "standard_user";
		String pass= "secret_sauce";
		WebElement user= driver.findElement(By.cssSelector("input#user-name"));
		WebElement password= driver.findElement(By.cssSelector("input#password"));
		WebElement login= driver.findElement(By.cssSelector("input.btn_action"));
		sendText(user, username);
		sendText(password, pass);
		login.click();
	 
    WebElement openmenu3= driver.findElement(By.cssSelector("div.bm-burger-button"));
    
    openmenu3.click();
	
    WebElement reset= driver.findElement(By.cssSelector("a#reset_sidebar_link"));
	
	Actions action= new   Actions(driver);
	
	action.moveToElement(reset).click().perform();
	
	}
	
	@AfterMethod 
	
	public void close() {
		
		driver.close();
	}

}
