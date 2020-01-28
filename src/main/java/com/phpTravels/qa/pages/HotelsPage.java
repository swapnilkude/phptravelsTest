package com.phpTravels.qa.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.phpTravels.qa.base.TestBase;


public class HotelsPage extends TestBase{
	private Logger log = LogManager.getLogger(this.getClass());
	 public HotelsPage() {
		 PageFactory.initElements(driver, this);
	 }
	 @FindBy(xpath = "//*[@id='LIST']/li[@style='display: list-item;']//div//h5/a")
	    private WebElement hotelname;
	 
	 @FindBy(xpath = "//*[@id='LIST']/li[@style='display: list-item;']//div[@class='price']/span")
	    private WebElement hotelprice;
	 

	 public void hotelResults() {
		 log.info("Checking if result is displayed");
		 String name=hotelname.getText();
		 System.out.println("=========HotelName==========="+name);
	 }
}
