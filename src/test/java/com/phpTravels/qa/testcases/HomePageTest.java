package com.phpTravels.qa.testcases;

import java.text.ParseException;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.phpTravels.qa.base.TestBase;
import com.phpTravels.qa.pages.HomePage;
import com.phpTravels.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	
	HomePage homePage;
	TestUtil testUtil;
	 Logger log= Logger.getLogger(HomePageTest.class);
	
	public HomePageTest() {
		super();
		
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		log.info("Loading page");
		homePage = new HomePage();
		testUtil = new TestUtil();
		
	}
	
	@Test(priority=1)
	public void quickHomePageHotelLinkPageTest() throws InterruptedException, ParseException {
		log.info("Doing the quick hotel search on the homepage");
		homePage.quickHomePageHotelLinkPage();
		
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
