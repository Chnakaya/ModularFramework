package automationFramework;
import java.util.concurrent.TimeUnit;
//no use of 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pageObjects.HomePage;
import appModule.SignInAction;
public class Param_TC {
	
	public static WebDriver driver = null;
	
	public static void main(String[] args) throws Exception{
	
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.amazon.in");
		
		SignInAction.Execute(driver, "santosh.rathodsantosh.rathod@gmail.com", "indiragratho");
		
		HomePage.link_LogoutAccount(driver).click();
}
}
