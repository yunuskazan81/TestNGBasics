package com.class05;

import org.openqa.selenium.By;
import org.testng.annotations.*;

import utils.CommonMethods;

public class demoTest extends CommonMethods {
	
	@Parameters({"browser","url"})
	@Test
	public void testCrossBrowser(String browser, String url) {
		if(browser.equalsIgnoreCase("chrome")) {
		setUpDriver(browser, url);
		sendText(driver.findElement(By.cssSelector("input#user-name")),"standard_user");
		sendText(driver.findElement(By.cssSelector("input#password")), "secret_sauce");
		driver.findElement(By.cssSelector("input.btn_action")).click();
		driver.close();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			setUpDriver(browser, url);
			sendText(driver.findElement(By.cssSelector("input#user-name")),"standard_user");
			sendText(driver.findElement(By.cssSelector("input#password")), "secret_sauce");
			driver.findElement(By.cssSelector("input[value='LOGIN'")).click();	
			driver.close();
		}
	}

}	