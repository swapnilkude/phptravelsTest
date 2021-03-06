package com.phpTravels.qa.testcases;

import java.io.IOException;
import java.text.ParseException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.phpTravels.qa.base.TestBase;
import com.phpTravels.qa.pages.HomePage;
import com.phpTravels.qa.pages.HotelsPage;
import com.phpTravels.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	
	HomePage homePage;
	TestUtil testUtil;
	HotelsPage hotelPage;
	Logger log= Logger.getLogger(this.getClass());
	
	public HomePageTest() {
		super();		
	}

	@BeforeSuite
	public void setUp() throws InterruptedException {
		initialization("weburl");
		log.info("Loading page");
		homePage = new HomePage();
		testUtil = new TestUtil();
		hotelPage = new HotelsPage();
		Assert.assertEquals(driver.getTitle(), "PHPTRAVELS | Travel Technology Partner");
	}
	@DataProvider(name = "date-selecter")
    public Object[][] dataProviderMethod() {
        return new Object[][] { 
        	{ "Feb", 5 }, 
        	{ "Feb", 7 } 
        	};
    }
	@Test(priority=0,description="Verify that hotel page is opened")
	public void quickHomePageHotelLinkPageTest() {
		log.info("Verify that hotel page is opened");
		homePage.quickHomePageHotelLinkPage();
	}
	
	@Test(priority=1,description="Verify that user can select destination as 'Pune'")
	public void HotelLinkPageTest() throws InterruptedException, ParseException {
		log.info("verify that user can select destination as 'Pune'");
		homePage.selectDestination();
	}
	@Test(priority=2,description="Verify that user can select in out Date")
	public void selectCheckinDateTest() throws InterruptedException, ParseException {
		log.info("Verify that user can select in out Date");
		homePage.selectCheckInDate("Feb", 5);
		homePage.selectCheckOutDate("Feb", 7);
	}
	@Test(priority=3,description="Verify that user can search hotels")
	public void searchHoteslsTest() throws InterruptedException, ParseException, IOException {
		log.info("verify that user can search hotels");
		homePage.searchHotesls();
	}
	@Test(priority=4,description="verify list and price of search hotels on hotel landing  page")
	public void namePriceHoteslsTest() {
		log.info("verify list and price of search hotels on hotel landing  page");
		hotelPage.hotelResults();
		
	}
	@AfterSuite
	public void tearDown() {
		driver.quit();
	}
//	Verify that hotel link present on page
//	verify that user can select destination as 'Pune'
//	verify that checkin date is curent date
//	verify that the checkout date is checkin +2 days
//	verify that user serching for the "Pune" destination
//	verify that user search with valid destination,checkin and check out date
//	verify that user can see list of hotels as per the search criteria
	


}
