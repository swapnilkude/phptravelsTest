package com.phpTravels.qa.pages;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
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

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public HotelsPage quickHomePageHotelLinkPage() {
		boolean t1 = quickHomePageHotelLink.isDisplayed();
		assertTrue(t1, "Test Passed");
		return new HotelsPage();
	}

	public HotelsPage selectDestination() {

		destinationarea.click();
		destinationbox.sendKeys("Pune");
		Verify.verify(destinationarea.isEnabled(), "Test passed");
		locationsearch.click();

		return new HotelsPage();
	}

	public HotelsPage selectCheckinCheckoutDate() {
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		checkin.click();
		checkin.clear();
		checkin.sendKeys("01/30/20");
		// checkInMnthTitle.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		checkout.click();
		checkout.clear();
		checkout.sendKeys("01/31/20");
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		return new HotelsPage();
	}

	
	public HotelsPage searchHotesls() throws InterruptedException, IOException {
		hotelSearch.isEnabled();
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", hotelSearch);
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			//testutil.isElelmentpresent(HotelSearchListtitle);
			Assert.assertEquals(HotelSearchListtitle.isDisplayed(), true);
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			TestUtil.takeScreenshotAtEndOfTest();
			Thread.sleep(3000);
		return new HotelsPage();
	}
}
