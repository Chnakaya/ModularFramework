package utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Utils {

	public static WebDriver driver = null;
	
	public static WebDriver openBrowser(int iTestCaseRow) {
		
		String sBrowserName;
		try{
		
			sBrowserName = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Browser);
		if (sBrowserName.equalsIgnoreCase("Mozilla")){
			driver = new FirefoxDriver();
			Logs.info("browser instatiate");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(Constant.URL);					//Getting URL from Constant class
			Logs.info("URL is getting lanched");
		}
		}catch(Exception e){
			Logs.error("Class Utils | Method OpenBrowser | Exception desc" +e.getMessage());
		}
		return driver;
		}

	public static String getTestCaseName(String sTestCase) throws Exception{
		
		String value = sTestCase;
		try{
			
			int posi = value.indexOf("@");
			value = value.substring(0, posi);
			posi = value.lastIndexOf(".");
			value= value.substring(posi +1);
			return value;
		}catch(Exception e){
			Logs.error("Class Utils | Method getTestCaseName | Exception desc : "+e.getMessage());
		throw(e);
		}
	}
	


public static int getRowContains(String sTestCaseName, int colNum) throws Exception{
	int i;
	
    try {
	    int rowCount = ExcelWSheet.getLastRowNum();
	    for ( i=0 ; i<rowCount; i++){
	        if  (ExcelUtils.getCellData(i,colNum).equalsIgnoreCase(sTestCaseName)){
	            break;
	           }
	        }
        return i;
    }catch (Exception e){
	    Logs.error("Class ExcelUtil | Method getRowContains | Exception desc : " + e.getMessage());
        throw(e);
	    }
    }
	}


