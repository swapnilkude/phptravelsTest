package com.phpTravels.qa.pages;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.google.common.base.Verify;
import com.phpTravels.qa.base.TestBase;

import com.phpTravels.qa.util.TestUtil;


public class HomePage extends TestBase {
	Logger log= Logger.getLogger(this.getClass());
	TestUtil testutil = new TestUtil();

	@FindBy(xpath = "//h3/span[1][contains(text(),'Hotels')]//../span[2][contains(text(),'pune')]")
	WebElement HotelSearchListtitle;

	@FindBy(xpath = "//*[@class='text-center hotels active']")
	WebElement quickHomePageHotelLink;

	@FindBy(xpath = "//*[@id='s2id_autogen1']/a/span[1]")
	WebElement destinationarea;

	@FindBy(xpath = "//*[@id='select2-drop']/div/input")
	WebElement destinationbox;

	@FindBy(xpath = "//*[@id='select2-drop']/ul/li/ul/li/div/span")
	WebElement locationsearch;

	@FindBy(xpath = "//*[@id='checkin']")
	WebElement checkin;

	@FindBy(xpath = "//*[@id='checkout']")
	WebElement checkout;

	@FindBy(xpath = "//*[@id='hotels']/div/div/form/div/div/div[4]/button")
	WebElement hotelSearch;
	
	@FindBy(xpath = "//*[@id='datepickers-container']/div[1]/nav/div[2]")
	WebElement monthbar;
	
	@FindBy(xpath = "//*[@id='datepickers-container']/div[1]/div/div[2]/div/div")
	List<WebElement> monthlist;
	
	@FindBy(xpath = "//*[@id='datepickers-container']/div[2]/nav/div[2]")
	WebElement co_monthbar;
	
	@FindBy(xpath = "//*[@id='datepickers-container']/div[2]/div/div[2]/div/div")
	List<WebElement> co_monthlist;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public HotelsPage quickHomePageHotelLinkPage() {
		
		testutil.waitUntilElementIsVisible(quickHomePageHotelLink);
		boolean t1 = quickHomePageHotelLink.isDisplayed();
		assertTrue(t1, "Test Passed");
		return new HotelsPage();
	}

	public HotelsPage selectDestination() {
		testutil.waitUntilElementIsClickable(destinationarea);
		destinationarea.click();
		destinationbox.sendKeys("Pune");
		Verify.verify(destinationarea.isEnabled(), "Test passed");
		locationsearch.click();

		return new HotelsPage();
	}
	public HomePage selectCheckInDate(String enterMonth, int enterdate) {
		testutil.waitUntilElementIsClickable(checkout);
		checkin.click();
		monthbar.click();
		monthlist.size();
		for(int i =0; i<= monthlist.size()-1;i++) {
			String month = monthlist.get(i).getText();
			if(month.equalsIgnoreCase(enterMonth)) {
			driver.findElement(By.xpath("//*[@id='datepickers-container']/div[1]/div/div[2]/div/div[@data-month='"+i+"']")).click();
			WebElement ele = 
					driver.findElement(By.xpath("//*[@id='datepickers-container']/div[1]/div/div[1]/div[2]/div[@data-date='"+enterdate+"'][@data-month='"+i+"']"));
			JavascriptExecutor executer = (JavascriptExecutor) driver;
			executer.executeScript("argumnts[0].click", ele);
			break;
			}
		}
		return new HomePage();
	}
	//This method/step is to select the check out date
	public HomePage selectCheckOutDate(String enterCoMonth, int enterCodate) {
		testutil.waitUntilElementIsClickable(checkout);
		checkout.click();
		co_monthbar.click();
		co_monthlist.size();
		for(int i =0; i<= co_monthlist.size()-1;i++) {
			String month = co_monthlist.get(i).getText();
			//select the the month chosen by user
			if(month.equalsIgnoreCase(enterCoMonth)) {
			//click on the month to be selected
			driver.findElement(By.xpath("//*[@id='datepickers-container']/div[2]/div/div[2]/div/div[@data-month='"+i+"']")).click();
			//click on the date to select
			WebElement ele = 
					driver.findElement(By.xpath("//*[@id='datepickers-container']/div[2]/div/div[1]/div[2]/div[@data-date='"+enterCodate+"'][@data-month='"+i+"']"));
			JavascriptExecutor executer = (JavascriptExecutor) driver;
			executer.executeScript("argumnts[0].click", ele);
			break;
			}
		}
		return new HomePage();
	}

	public HotelsPage searchHotesls() throws InterruptedException, IOException {
		testutil.waitUntilElementIsVisible(hotelSearch);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", hotelSearch);
			testutil.waitUntilElementIsVisible(HotelSearchListtitle);
			HotelSearchListtitle.getText();
			Assert.assertEquals(HotelSearchListtitle.isDisplayed(), true);
			TestUtil.takeScreenshotAtEndOfTest();
			Thread.sleep(3000);
		return new HotelsPage();
	}
}
