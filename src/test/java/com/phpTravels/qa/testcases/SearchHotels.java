package com.phpTravels.qa.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

/**
 * 
 */
public class SearchHotels {
	
	LaunchClose lauchClose;
	
	//@Test
	public void searchHotel() throws InterruptedException {
		
		lauchClose =new LaunchClose();
		lauchClose.launchApp();
		Thread.sleep(5000);
		lauchClose.driver.findElement(By.xpath("//*[@id=\'body-section\']/div[1]/div/div/div[1]/div/ul/li[1]/a")).click();
		
		Thread.sleep(2000);
		lauchClose.driver.findElement(By.cssSelector("#dpd1 > input")).click();
		Thread.sleep(2000);
		
		String expectedMouth= "June 2018";
		String currentMonth=lauchClose.driver.findElement(By.cssSelector("body > div:nth-child(23) > div.datepicker-days > table > thead > tr:nth-child(1) > th.switch")).getText();
		
		if (expectedMouth.equals(currentMonth)) {
			System.out.println("The month entered is already selected");
		}
		//if expectedMouth entering is not already selected the do the following
		else {
			for(int j=1; j<12;j++) {
				//clicking on the next button
				lauchClose.driver.findElement(By.xpath("/html/body/div[14]/div[1]/table/thead/tr[1]/th[3]")).click();
				Thread.sleep(2000);
				//returning the value of current month
				currentMonth=lauchClose.driver.findElement(By.xpath("/html/body/div[14]/div[1]/table/thead/tr[1]/th[2]")).getText();				
				if (expectedMouth.equals(currentMonth)) {
					System.out.println("Expected month now selected  " + currentMonth);
					break; //because we do not want to loop to carry on with next link being clicked again
				}
			}
		}
		Thread.sleep(2000);
		//getting the days of the month
		//td contains the days of the month
		//webElement for the parent
		WebElement datePicker=lauchClose.driver.findElement(By.xpath("/html/body/div[14]/div[1]/table/tbody"));
		//pick up all tds - days inside trs of tbody
		List<WebElement> dates=datePicker.findElements(By.tagName("td"));
		
		//for each date in a collection of dates webElements
		for(WebElement date : dates) {
		
			String calenDates = date.getText();
			System.out.println(calenDates);
			
			
			if(calenDates.equals("5")) {
				date.click();
				break;
		}		
	}
	
	}
  
}
