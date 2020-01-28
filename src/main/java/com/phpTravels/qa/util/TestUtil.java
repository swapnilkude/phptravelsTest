package com.phpTravels.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.phpTravels.qa.base.TestBase;


public class TestUtil extends TestBase{
	
	public static long PAGE_LOAD_TIMEOUT = 60;
	public static long IMPLICIT_WAIT = 60;
	
	public static String TESTDATA_SHEET_PATH = "E:\\Training\\Automation\\TestNG\\Workplace\\PHPTravels\\src\\main\\java\\com\\phpTravels\\qa\\testdata\\FreeCrmTestData.xlsx";
	
	static Workbook book;
	static Sheet sheet;
	
	
	public void switchToFrame(){
		driver.switchTo().frame("mainpanel");
	}
	
	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}
	
	  public int currentDate() {
		  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd");
		   LocalDateTime now = LocalDateTime.now();
		  int day = now.getDayOfMonth()+1;
		  // String date = dtf.format(now);
		  // System.out.println(dtf.format(now));
		   return day;
	  }
	
	      public Date addDays(Date date, int days) {
	  
	          Calendar cal = Calendar.getInstance();
	          cal.setTime(date);
	          cal.add(Calendar.DATE, days); //minus number would decrement the days
	          return cal.getTime();
	      }
	    
	      
	    	  static public String addOneDay(String date) {
	    	    return LocalDate.parse(date).plusDays(1).toString();
	    	  }
	    	
	  
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
		
		}
	
	WebDriverWait wait = new WebDriverWait(driver, 10);
	
/*	public WebDriverWait isElelmentpresent(WebElement element){
		WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(element));
		return wait;
	}*/
	
}
