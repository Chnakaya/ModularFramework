package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


import utility.Logs;

public class HomePage { 
	
	private static WebElement element = null;
	private static WebElement logout;

	//Click on Sign link present on home page
	public static WebElement link_MyAccount(WebDriver driver){
	
		element = driver.findElement(By.xpath("//a[text()='Sign In']"));
		Logs.info("My Account link element found");
		return element;
	}
 

	//Singin with Google account
	public static WebElement SignInwith_Google(WebDriver driver){
	
		element = driver.findElement(By.xpath("//span[text()='sign in with google']"));
		return element;
	}
 

	//User is getting logout
	public static WebElement link_LogoutAccount(WebDriver driver) throws InterruptedException {
	
		logout = driver.findElement(By.xpath("//a[@href='https://www.jabong.com/account/']"));
		Thread.sleep(5000);
		Actions action = new Actions(driver);
		action.moveToElement(logout).build().perform();
		element = driver.findElement(By.xpath("//a[@href='https://www.jabong.com/customer/account/logout/9ce842e2541f102a952d98d5c63d7b817395a50975bc4599d9ea666d8d4381e8/']"));
		Logs.info("Log Out link element found");
		return element;
   }
}
