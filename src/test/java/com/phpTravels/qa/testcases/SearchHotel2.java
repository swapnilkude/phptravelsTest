package com.phpTravels.qa.testcases;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Months;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class SearchHotel2 {
	
	LaunchClose lauchClose;
	
	//@Test
	public void searchHotel() throws InterruptedException, ParseException {
		
		lauchClose =new LaunchClose();
		lauchClose.launchApp();
		Thread.sleep(5000);
		lauchClose.driver.findElement(By.xpath("//*[@id=\'body-section\']/div[1]/div/div/div[1]/div/ul/li[1]/a")).click();
		//lauchClose.driver.findElement(By.className("select2-input")).sendKeys("London");
		Thread.sleep(2000);
		lauchClose.driver.findElement(By.cssSelector("#dpd1 > input")).click();
		Thread.sleep(2000);
		
		String setDateStr= "08/06/2018"; //DD/MM/YYYY
	
		String currDateStr=lauchClose.driver.findElement(By.className("switch")).getText();// MMMM/yyyy
	
		//convert to date formate usinf date object
		String pattern= "dd/MM/yyyy";
		Date setDate = new SimpleDateFormat( pattern).parse(setDateStr);
		String pattern2="MMMM yyyy";
		Date currDate = new SimpleDateFormat( pattern2).parse(currDateStr);
	
	
		//int monthDiff = Months.monthsBetween(new DateTime(currDate).withDayOfMonth(1), new DateTime(setDate).withDayOfMonth((1)).getMonths();
		int monthsDiff = Months.monthsBetween(new DateTime(currDate).withDayOfMonth(1), new DateTime(setDate).withDayOfMonth(1)).getMonths();
	
		boolean isFuture =true;
		//if months difference is negative convert to positive
		if(monthsDiff<0) {
			isFuture=false;
			monthsDiff= -1 *monthsDiff;
		}
		for (int i=0; i<monthsDiff; i++) {
			if (isFuture)
				//click the forward button
				lauchClose.driver.findElement(By.xpath("/html/body/div[14]/div[1]/table/thead/tr[1]/th[3]")).click();
			else
				lauchClose.driver.findElement(By.xpath("/html/body/div[14]/div[1]/table/thead/tr[1]/th[1]")).click();
				
		}
		
		lauchClose.driver.findElement(By.xpath("//td[text()='8']")).click();
	}

}
