package Tasks;

import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utils.CommonMethods;

public class Dataprovider extends CommonMethods {
	
	/*
 
 
 Identify Priority of Test Cases

http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete11%2fWebOrders%2fDefault.aspx

TC 1: WebOrder Verify Successful Login ( )
Step 1: Open browser and navigate to WebOrder
Step 2: Enter valid username, enter valid password and click on the  login button
Step 3: Verify user successfully logged in

TC 2: WebOrder Creating and verifying Users( )
Step 1: Create Two users and fill out all the required fields
 Step 2: Verify that user one name appears within the table 
 Step 3: Edit user one  and update user one’s State, assert the new updated State is displayed and save the changes.
 Step 4: Verify that user two name appears within the table 
 Step 5: Edit user two and update user two’s City and assert the new updated City is displayed and save the changes.

TC 3: WebOrder verifying Users( )
        Step 1 : Assert Both User one and User Two are displayed

Note: Create BeforeClass and AfterClass annotations to open browser and logout from the application. 
The creation of users two should depend on the creation of users one.
The validation both users should depend on the creation of both users. 
Create xml file and share a screenshot of the test.

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
	
	
	@Parameters({"Username", "Password"})
	@Test(enabled = false)
	public void login(String Username, String Password) {
		WebElement element= driver.findElement(By.cssSelector("input#ctl00_MainContent_username"));
		sendText(element, Username);
		
		element= driver.findElement(By.cssSelector("input#ctl00_MainContent_password"));
		sendText(element, Password); 
		
		
		element= driver.findElement(By.cssSelector("input#ctl00_MainContent_login_button"));
		element.click();
		
		
		element= driver.findElement(By.xpath("//h1[text()='Web Orders']"));
		Assert.assertEquals(element.isDisplayed(), true);
		System.out.println("Logged in successfully");
	}
	
	
	@DataProvider()
	public Object [][] setData(){
		Object [][] data = new Object[2][8];
		
		data[0][0]="4";
		data[0][1]="Yunus Kazan";
		data[0][2]="4850 marine blvd Apt:F";
		data[0][3]="Fort Lauderdale, FL";
		data[0][4]="Canada";
		data[0][5]="33465";
		data[0][6]="4353453405043589";
		data[0][7]="03/22";
		
		data[1][0]="2";
		data[1][1]="John Pokemonian";
		data[1][2]="112234 Ocean blvd Apt:F";
		data[1][3]="Miami, FL";
		data[1][4]="Mexico";
		data[1][5]="33067";
		data[1][6]="6985649203402433";
		data[1][7]="09/23";
		
		return data;
	}
	
	
	
	@Test(priority = 1, dataProvider = "setData")
	public void createUser(String Quantity , String userName, String street, String city, String state, String zip, String cCard, String EXP) {
		
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
		
		element= driver.findElement(By.cssSelector("input[id*='cardList_0']"));
		String actual= element.getAttribute("value");
		Assert.assertEquals(actual, "Visa");
		js.executeScript("arguments[0].click();", element);
		
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
	
	
	@Test(priority = 2, dataProvider = "setData", dependsOnMethods = "createUser")
	
	public void verifyUser(String Quantity , String userName, String street, String city, String state, String zip, String cCard, String EXP ) {
	
		
	String nameText = null;
	
	ArrayList<String> names= new ArrayList<>();
	
	List<WebElement> elements= driver.findElements(By.xpath("//table[contains(@id,'orderGrid')]/tbody/tr/td[2]"));
	
	for(int i=2; i<elements.size(); i++) {
		
		nameText= driver.findElement(By.xpath("//table[contains(@id,'orderGrid')]/tbody/tr["+i+"]/td[2]")).getText();
		
		names.add(nameText);
		
	}
	

	//System.out.println(names);
	
     if(names.contains(userName)) {
		
		System.out.println(userName+ " was verified to be ordered succesfully.");	
	}
     
     takeAscreenShot("TaskAboutDataprovider", "UserShownUpOrderList");
		
	}
	
	@Test(priority = 3, dataProvider = "setData", dependsOnMethods = "verifyUser")
	
	public void xUpdateCountry(String Quantity , String userName, String street, String city, String UpdatedState, String zip, String cCard, String EXP ) {
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		
		WebElement element= driver.findElement(By.cssSelector("input[type='image']"));
		actionClick(element);
		
		UpdatedState= "U.S";
		element= driver.findElement(By.cssSelector("input[id*='TextBox4']"));
		actionClick(element);
		sendText(element, UpdatedState);
		
		
		element= driver.findElement(By.cssSelector("input[id*='cardList_1']"));
		String actual= element.getAttribute("value");
		Assert.assertEquals(actual, "MasterCard");
		js.executeScript("arguments[0].click();", element);
		
		System.out.println(userName+" is succesfully updated credit card type  as " + actual);
		
		 element= driver.findElement(By.cssSelector("a[class*='btn_light']"));
		 actual= element.getText();
		 Assert.assertEquals(actual, "Update");
		 js.executeScript("arguments[0].click();", element);
			
		
		String NewStateText = null;
	
		
		ArrayList<String> names= new ArrayList<>();
		
		List<WebElement> elements= driver.findElements(By.xpath("//table[contains(@id,'orderGrid')]/tbody/tr/td[8]"));
		
		for(int i=2; i<elements.size(); i++) {
			
			element= driver.findElement(By.xpath("//table[contains(@id,'orderGrid')]/tbody/tr["+i+"]/td[8]"));
			
			NewStateText= element.getText();
			
			names.add(NewStateText);
			
		}
		//System.out.println(names);
		
	     if(names.contains(UpdatedState)) {
			
			System.out.println(userName+ " is succesfully updated country part of the address  as " + UpdatedState);	
		}
	     
	     takeAscreenShot("TaskAboutDataprovider", "UserAddressUpdatedSuccesfully");
		
	}
	
	
	@AfterClass (alwaysRun = true)
	public void tearDown() throws InterruptedException {
		
		Thread.sleep(5000);
		driver.close();
		
	}
	
}
