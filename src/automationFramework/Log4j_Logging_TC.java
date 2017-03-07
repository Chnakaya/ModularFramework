package automationFramework;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pageObjects.HomePage;
import appModule.SignInAction;
import utility.Constant;
import utility.ExcelUtils;
import utility.Logs;

public class Log4j_Logging_TC {

	private static WebDriver driver = null;
	
	
	public static void main (String[] args) throws Exception{
		
		DOMConfigurator.configure("log4j.xml");
		
		Logs.startTestCase("Jabong_00_01");
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Sheet1");
		Logs.info("Excel sheet opened");
		
		driver = new FirefoxDriver();
		Logs.info("browser instatiate");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		driver.get(Constant.URL);					//Getting URL from Constant class
		Logs.info("URL is getting lanched");
		SignInAction.Execute(driver);				//Executing action_method from SignIn class
		System.out.println("Login Successfully, now it is the time to Log Off buddy.");
		
		HomePage.link_LogoutAccount(driver).click();//Logout method from HomePage class	
		Logs.info("Click action is perfomred on Log Out link");
		ExcelUtils.setCellData("Pass", 1, 3);		//Passing the parameters to the excel using methods from ExcelUtils class
		driver.quit();
		Logs.info("Browser closed");
		Logs.endTestCase("Selenium_Test_001");
		
	}
	
}
