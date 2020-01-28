package com.phpTravels.qa.pages;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.phpTravels.qa.base.TestBase;
import com.phpTravels.qa.util.TestUtil;


public class HotelsPage extends TestBase{
	private Logger log = LogManager.getLogger(this.getClass());
	TestUtil testutil = new TestUtil();
	 public HotelsPage() {
		 PageFactory.initElements(driver, this);
	 }
	 @FindBy(xpath = "//h3/span[1][contains(text(),'Hotels')]//../span[2][contains(text(),'pune')]")
		WebElement HotelSearchListtitle;
	 
	 @FindBy(xpath = "//*[@id='LIST']/li[1]/div/div/div[1]/div/img")
	    private WebElement hotelimage;
	
	 @FindBy(xpath = "//*[@id='LIST']/li[@style='display: list-item;']//div//h5/a")
	    private WebElement hotelname;
	 
	 @FindBy(xpath = "//*[@id='LIST']/li[@style='display: list-item;']")
	    private WebElement hotelname1;
	 
	 @FindBy(xpath = "//*[@id='LIST']/li[@style='display: list-item;']//div//h5/a")
	    private List<WebElement> totalhotels;
	 
	 
	 @FindBy(xpath = "//*[@id='LIST']/li[@style='display: list-item;']//div[@class='price']/span")
	    private List<WebElement> hotelprice;
	 
	 @FindBy(xpath = "//*[@id='LIST']/li[@style='display: list-item;']")
	    private WebElement hotelprice1;
	 

	 public HotelsPage hotelResults() {
		 HashMap<String, String> hmap = new HashMap<String, String>();
		 log.info("Checking if result is displayed");
		 testutil.waitUntilElementIsVisible(hotelimage);
		 String name=hotelname.getText();
		System.out.println("=========HotelName==========="+name);
		 System.out.println(totalhotels.size());
		 log.info("Printing thr hotel name and price on Page 1"); 
		// List<WebElement> totalhotels = hotelname1.findElements(By.xpath("//div//h5/a"));
		 //List<WebElement> totalHP = hotelprice1.findElements(By.xpath("//div[@class='price']/span"));
		
		for(int i=1; i<=totalhotels.size()-1;i++) {
			hmap.put(totalhotels.get(i).getText(), hotelprice.get(i).getText());
			/*String hotelname1 = driver.findElement(By.xpath("//*[@id='LIST']/li[@style='display: list-item;']["+i+"]//div//h5/a")).getText();
			System.out.println(hotelname1);*/
			/*String hotelprice = driver.findElement(By.xpath("//*[@id='LIST']/li[@style='display: list-item;']["+i+"]//div[@class='price']/span")).getText();
			System.out.println(hotelname1);*/
			//System.out.println(hotelname1);
		}
		 // Display content using Iterator
		Set set = hmap.entrySet();
		Iterator iterator = set.iterator();
	      while(iterator.hasNext()) {
	         Map.Entry mentry = (Map.Entry)iterator.next();
	         System.out.print("Hotel Name is: "+ mentry.getKey() + "===> & Hotel Pricw is: "+mentry.getValue());
	         System.out.println(mentry.getValue());
	      }
		 
		 return new HotelsPage();
	 }
}
