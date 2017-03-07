//Test cases - Login and Logout

package automationFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pageObjects.HomePage;
import pageObjects.LogIn;

public class PageObjectModel {

	public static WebDriver driver = null;
	
public static void main(String[]  args){
	
	driver = new FirefoxDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	driver.get("https://www.amazon.in");

	//Accessing the object from the pageObject class
	HomePage.link_MyAccount(driver).click();
	LogIn.txtbx_UserName(driver).sendKeys("santosh.rathodsantosh.rathod@gmail.com");
	LogIn.txtbx_Password(driver).sendKeys("indiragratho");
	System.out.println("successfully login");
	LogIn.btn_LogIn(driver).click();
	
	try {
		HomePage.link_LogoutAccount(driver).click();
	} catch (Exception e) {
		
		e.printStackTrace();
	}
		
	driver.quit();

}	
}
