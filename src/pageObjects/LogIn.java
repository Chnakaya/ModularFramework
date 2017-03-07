package pageObjects;

import org.openqa.selenium.*;
import utility.Logs;
 
public class LogIn {
 
        private static WebElement element = null;
 
    //User is entering username
    public static WebElement txtbx_UserName(WebDriver driver){
        
    	element = driver.findElement(By.id("Email"));
    	Logs.info("Username text box found");
		return element;
 
         }
 
    
    //Proceed further by clicking on next button
    public static WebElement button_next(WebDriver driver){
    	
    	element = driver.findElement(By.id("next"));
    	return element;
    }
    
    
    //User is entering username
     public static WebElement txtbx_Password(WebDriver driver){
 
        element = driver.findElement(By.id("Passwd"));
        Logs.info("Password text box found");
 		return element;
 
     }
 
     
     //User is getting logged in by clicking on sign in button
     public static WebElement btn_LogIn(WebDriver driver){
 
         element = driver.findElement(By.id("signIn"));
         Logs.info("sign in button found");
         return element;
 
      }
 
}