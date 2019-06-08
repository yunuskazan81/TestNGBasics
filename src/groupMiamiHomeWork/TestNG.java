package groupMiamiHomeWork;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import utils.CommonMethods;

public class TestNG extends CommonMethods{

	@Test
	public static void methodFunction() throws InterruptedException {
		
		
		/*
		 * TC 1: Users Application Form Fill
		 * 1.Open chrome browser
		 * 2.Go to “http://uitestpractice.com/”
		 * 3.Click on “Forms” link
		 * 4.Fill out the entire form
		 * 5.Close the browser
		 * MUST USE Functions: 
		 */
		String value= "http://uitestpractice.com/";
		
		setUpDriver("chrome", value);
		
		WebElement  clickform= driver.findElement(By.xpath("//a[text()='Form']"));
		
		actionClick(clickform);
		
		WebElement username= driver.findElement(By.cssSelector("input#firstname"));
		value= "Yunus";
		sendText(username, value);
		
		
		WebElement lastname= driver.findElement(By.cssSelector("input#lastname"));
		value= "Kazan";
		sendText(lastname, value);
		
		// we only couldn't figure out this radio button function. we tried all way we learned, but i does not work properly;
		List<WebElement> element1= driver.findElements(By.cssSelector("input[type='radio']"));
		value= "Single";
		radioButton(element1, value);
		

		List<WebElement> hobbies= driver.findElements(By.cssSelector("label.checkbox-inline"));
		checkBox(hobbies, "All");
			
		// MultipleCheckBox(hobbies, "Cricket", "Dancing", "Reading");
		
		
		WebElement element= driver.findElement(By.cssSelector("select#sel1"));
		
		value= "Egypt";
				
		dropDown(element, value);
		
		WebElement datebox= driver.findElement(By.cssSelector("input[placeholder='Enter Date of birth']"));
		datebox.click();
		
		
		String month= "Jun";
		WebElement Month= driver.findElement(By.cssSelector("select[data-handler='selectMonth']"));
		dropDown(Month, month);
		
		
		String year = "1987";
		WebElement Year= driver.findElement(By.cssSelector("select[data-handler='selectYear']"));
		dropDown(Year, year);
		
		
		
		String Day= "26";
		List<WebElement> Table= driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
		calender(Table, Day);
		
		element= driver.findElement(By.cssSelector("input[placeholder='Enter PhoneNumber']"));
		value= "7613083456";
		sendText(element, value);
		
		element= driver.findElement(By.cssSelector("input[placeholder='Enter UserName']"));
		value= "yunuskazan81";
		sendText(element, value);
		
		element= driver.findElement(By.cssSelector("input#email"));  
		value= "yunuskazan81@gmail.com";
		sendText(element, value);
		
		
		element= driver.findElement(By.cssSelector("textarea#comment"));    
		value= "I am a Software Automation Test Engineer";
		sendText(element, value);
		
		
		element= driver.findElement(By.cssSelector("input#pwd"));
		value= "yKaz198781.";
		sendText(element, value);
		
		Thread.sleep(10000);
		element= driver.findElement(By.cssSelector("button[type='submit']"));
		clickElement(element);
		
		

	}
	
	
	@Test
	public static void Calender() throws InterruptedException {
		
		String url="https://jqueryui.com/";
		setUpDriver("chrome", url);
		
		WebElement datelink= driver.findElement(By.xpath("//a[text()='Datepicker']"));
		
		datelink.click();
		
		WebElement frame= driver.findElement(By.cssSelector("iframe.demo-frame"));
		
		driver.switchTo().frame(frame);
		
	WebElement datebox=	driver.findElement(By.cssSelector("input#datepicker"));
	
	datebox.click();
	
	String date= "10";
	String verifyDate= "08/10/2019";
	String monthyear= "August 2019";
	String monthtext= null;
	
	do {
		
		WebElement next= driver.findElement(By.xpath("//span[text()='Next']"));
		
		next.click();
		
		Thread.sleep(1000);
		
		monthtext= driver.findElement(By.cssSelector("div.ui-datepicker-title")).getText();

	} while(!(monthyear.equals(monthtext)));	
		
	Thread.sleep(3000);
	
	List <WebElement> cells=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
	for(WebElement cell: cells) {
		
		String EachText= cell.getText();
		
		if(EachText.contains(date)) {
			cell.click();
			break;
		}
	}
	
	String ActualDate= driver.findElement(By.cssSelector("input#datepicker")).getAttribute("value");
	
	if(verifyDate.equalsIgnoreCase(ActualDate)) {
		
		System.out.println(ActualDate+" has been entered succesfully");
	}
	else {
		System.out.println(ActualDate+" has NOT been verified succesfully");
		
	}
	
}
	
	
	@Test
	public static void WebTable() throws InterruptedException {
		
		String url= "http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx";
		setUpDriver("chrome", url);
		
		
		driver.findElement(By.cssSelector("input#ctl00_MainContent_username")).sendKeys("Tester");
		driver.findElement(By.cssSelector("input#ctl00_MainContent_password")).sendKeys("test");
		driver.findElement(By.cssSelector("input#ctl00_MainContent_login_button")).click();  //a[text()='Order']
		
		driver.findElement(By.xpath("//a[text()='Order']")).click();
		
		
		
		WebElement alloptions=  driver.findElement(By.cssSelector("select#ctl00_MainContent_fmwOrder_ddlProduct"));
		
		Select select= new Select(alloptions);
		
		List<WebElement> dropdown= select.getOptions();
		
		Iterator<WebElement> it= dropdown.iterator();
		
		while(it.hasNext()) {
			
			String options= it.next().getText();
			
			//System.out.println(options);	
		}
		
		select.selectByVisibleText("ScreenSaver");
	
		
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input[id*='txtQuantity']")).sendKeys("4");  
		driver.findElement(By.cssSelector("input[id*='txtUnitPrice']")).sendKeys("100");
		driver.findElement(By.cssSelector("input[id*='txtDiscount']")).sendKeys("25");
		driver.findElement(By.cssSelector("input[value*='Calculate']")).click();  
		
	WebElement resetBut=driver.findElement(By.cssSelector("input[value*='Reset']"));
	
	if(resetBut.isDisplayed() & resetBut.isEnabled()) {
		
		resetBut.click();
	}
	
	
	WebElement alloption=  driver.findElement(By.cssSelector("select#ctl00_MainContent_fmwOrder_ddlProduct"));
	
	Select select1= new Select(alloption);
	
	List<WebElement> dropdown1= select1.getOptions();
	
	Iterator<WebElement> It= dropdown1.iterator();
	
	while(it.hasNext()) {
		
		String option= It.next().getText();
		
		System.out.println(option);	
	}
	
	
		select1.selectByVisibleText("MyMoney");
	
		
		driver.findElement(By.cssSelector("input[id*='txtQuantity']")).sendKeys("4");  
		driver.findElement(By.cssSelector("input[id*='txtUnitPrice']")).sendKeys("100");
		driver.findElement(By.cssSelector("input[id*='txtDiscount']")).sendKeys("25");
		driver.findElement(By.cssSelector("input[value*='Calculate']")).click();  
		
		driver.findElement(By.cssSelector("input[id*='txtName']")).sendKeys("Yunus Kazan");
		driver.findElement(By.cssSelector("input[id*='TextBox2']")).sendKeys("4830 mariners way");
		driver.findElement(By.cssSelector("input[id*='TextBox3']")).sendKeys("Coconut Creek");
		driver.findElement(By.cssSelector("input[id*='TextBox4']")).sendKeys("FL");
		driver.findElement(By.cssSelector("input[id*='TextBox5']")).sendKeys("33087");
		
	WebElement ccButton= driver.findElement(By.cssSelector("input[id*='cardList_1']"));
//	WebElement listText= driver.findElement(By.xpath("//h2[contains(@text(),'List of All Orders')]"));
//	
//	String listALl= listText.getText();
//	System.out.println(listALl);
	
	if(ccButton.isEnabled()) {
		
		ccButton.click();
	}
	
		driver.findElement(By.cssSelector("input[id*='TextBox6']")).sendKeys("2504545049453943223");
		
		driver.findElement(By.cssSelector("input[id*='TextBox1']")).sendKeys("09/2025");  //input[value*='Reset']
		
		Thread.sleep(3000);
		
		WebElement processBut= driver.findElement(By.cssSelector("a[id*='InsertButton']"));// //a[text()='View all orders']
		
		if (processBut.isDisplayed()& processBut.isEnabled()) {
			
			processBut.click();
		}
		
		
		driver.findElement(By.xpath("//a[text()='View all orders']")).click();
		
	
		
		String name="Yunus Kazan";
		String street= "4830 mariners way";
		String city= "Coconut Creek";
		String state ="FL";
		String zipcode= "33087";
		
		
		
		List<WebElement> cells= driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td"));
		List<WebElement> rows= driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr"));
		
		ArrayList<String> order= new ArrayList<>();
		
		for(WebElement cell:cells) {
			
			String cellText= cell.getText();
			
			order.add(cellText);
		}
			
		
		if(order.contains(name) & order.contains(street) & order.contains(city) & order.contains(state)& order.contains(zipcode))
			
		{ 	
			driver.findElement(By.xpath("//table[contains(@id, '_orderGrid')]/tbody/tr[2]/td[1]")).click();	
			Thread.sleep(3000);
	}		
			
/*
	WebElement delete=	driver.findElement(By.cssSelector("input#ctl00_MainContent_btnDelete"));
	
	Thread.sleep(3000);
	delete.click(); 
	
	*/
		
		
	// click order details button;
	WebElement checkOrder= driver.findElement(By.xpath("//table[contains(@id,'orderGrid')]/tbody/tr/td[13]"));
	
	Thread.sleep(3000);
	checkOrder.click();
	
	
	// clear Address boxes;
	driver.findElement(By.cssSelector("input[id*='TextBox2']")).clear();
	driver.findElement(By.cssSelector("input[id*='TextBox3']")).clear();
	driver.findElement(By.cssSelector("input[id*='TextBox4']")).clear();
	driver.findElement(By.cssSelector("input[id*='TextBox5']")).clear();
	
	// sendkey for new Address;
	WebElement strt= driver.findElement(By.cssSelector("input[id*='TextBox2']"));
	WebElement cty= driver.findElement(By.cssSelector("input[id*='TextBox3']"));
	WebElement stat= driver.findElement(By.cssSelector("input[id*='TextBox4']"));
	WebElement zip= driver.findElement(By.cssSelector("input[id*='TextBox5']"));
	
		strt.sendKeys("5840 Atlantic Blvd.");
		cty.sendKeys("Pompano Beach");
		stat.sendKeys("FL");
		zip.sendKeys("33064");
		
		ArrayList<String> UpdatedAddress= new ArrayList<>();
		
		UpdatedAddress.add(strt.getAttribute("value"));
		UpdatedAddress.add(cty.getAttribute("value"));
		UpdatedAddress.add(stat.getAttribute("value"));
		UpdatedAddress.add(zip.getAttribute("value"));	
	
	
		// verify new Address and Update;
	if(UpdatedAddress.contains(strt.getText())& UpdatedAddress.contains(cty.getText())& UpdatedAddress.contains(stat.getText())& UpdatedAddress.contains(zip.getText()))
		{
			WebElement update= driver.findElement(By.cssSelector("a#ctl00_MainContent_fmwOrder_UpdateButton"));
			Thread.sleep(3000);
			update.click();
			
		}

		System.out.println("Costumer address has been updated succesfully. New Address is "+ UpdatedAddress);

	}
	
	
	@AfterTest
	public void driverClose() throws InterruptedException {
		

		Thread.sleep(1000);
		
		driver.close();
	}

}
