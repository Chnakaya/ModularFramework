package automationFramework;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pageObjects.HomePage;
import utility.Constant;
import utility.ExcelUtils;
import appModule.SignInAction;

public class Apache_POI_TC {

	public static WebDriver driver = null;;
	
	public static void main(String[] args) throws Exception{
		
		//Setting up the excel path and name and making Sheet ready to accept the arguments by using setExcelFile method from ExcelUtils class
		
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Sheet1"); 	
		driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get(Constant.URL);					//Getting URL from Constant class
		SignInAction.Execute(driver);				//Executing action_method from SignIn class
		System.out.println("Sucessfully login");
		HomePage.link_LogoutAccount(driver).click();//Logout method from HomePage class	
		System.out.println("Successfully logout");
		ExcelUtils.setCellData("Pass", 1, 3);		//Passing the parameters to the excel using methods from ExcelUtils class
		driver.quit();
	}
}
