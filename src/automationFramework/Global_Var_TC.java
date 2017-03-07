package automationFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import appModule.SignInAction;
import pageObjects.HomePage;

import utility.Constant;

public class Global_Var_TC {

public static WebDriver driver = null;
	
	public static void main(String[] args) throws Exception{
	
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get(Constant.URL);
		
		SignInAction.Execute(driver, Constant.username, Constant.password);
		
		HomePage.link_LogoutAccount(driver).click();
}
}