package utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public static XSSFWorkbook ExcelWBook;
	public static XSSFSheet ExcelWSheet;
	public static XSSFCell Cell;
	public static XSSFRow row;
	
	

	//This method is to set the File path and to open the Excel file, Pass Excel Path and Sheetname as Arguments to this method
	
	public static void setExcelFile(String Path, String SheetName) throws Exception{
		try {
			
			FileInputStream ExcelFile = new FileInputStream (Path);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
		}catch (Exception e){
			throw e;
		}
	
	}
		
	//This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num
		
		public static String getCellData(int RowNum, int ColNum){
		try{
		Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
		String CellData = Cell.getStringCellValue();
		
		return CellData;
		}catch (Exception e){
			return "";
		}
			
}
		
		//This method is to write in the Excel cell, Row num and Col num are the parameters
		
		@SuppressWarnings("deprecation")
		public static void setCellData(String Result, int RowNum, int ColNum) throws Exception{
			
			try{
			
				row = ExcelWSheet.getRow(RowNum);
				Cell = row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);
				
				if(Cell==null){
					Cell= row.createCell(ColNum);
					Cell.setCellValue(Result);
				}else{
					Cell.setCellValue(Result);
				}
								
			
			// Constant variables Test Data path and Test Data file name
			
			FileOutputStream fileOut = new FileOutputStream (Constant.Path_TestData+Constant.File_TestData);
			ExcelWBook.write(fileOut);
			fileOut.flush();
			fileOut.close();
			
			}catch(Exception e){
				throw (e);
			
			}
		
		}
	}		
		
		
		
		

		


	
	

