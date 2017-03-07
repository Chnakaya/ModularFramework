package appModule;

import org.openqa.selenium.WebDriver;

import pageObjects.HomePage;
import pageObjects.LogIn;
import utility.ExcelUtils;

import utility.Logs;

public class SignInAction {

	
public static void Execute(WebDriver driver){
	
	//Fetching data from Excel sheet
	String sUsername = ExcelUtils.getCellData(1, 1);
	Logs.info("Username picked from Excel is "+ sUsername);
	
	String sPassword = ExcelUtils.getCellData(1, 2);
	Logs.info("Password picked from Excel is "+ sPassword );
	
	//HomePage actions
	HomePage.link_MyAccount(driver).click();
	HomePage.SignInwith_Google(driver).click();
	
	//LogIn page actions
	LogIn.txtbx_UserName(driver).sendKeys(sUsername);
	LogIn.button_next(driver).click();
	LogIn.txtbx_Password(driver).sendKeys(sPassword);
	LogIn.btn_LogIn(driver).click();
	Logs.info("Click action performed on Submit button");
	
	}	
}
