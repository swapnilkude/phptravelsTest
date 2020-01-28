package com.phpTravels.qa.testcases;

import java.io.IOException;
import java.text.ParseException;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.phpTravels.qa.base.TestBase;
import com.phpTravels.qa.pages.HomePage;
import com.phpTravels.qa.pages.HotelsPage;
import com.phpTravels.qa.util.TestUtil;

public class HotelsPageTest extends TestBase{
	
	HomePage homePage;
	TestUtil testUtil;
	HotelsPage hotelPage;
	Logger log= Logger.getLogger(this.getClass());
	
	public HotelsPageTest() {
		super();		
	}
/*	@BeforeSuite
	public void setUp() throws InterruptedException {
		initialization();
		log.info("Loading page");
		homePage = new HomePage();
		testUtil = new TestUtil();
		hotelPage = new HotelsPage();
	}*/
/*	@Test(priority=4,description="verify list and price of search hotels on hotel landing  page")
	public void namePriceHoteslsTest() {
		log.info("verify list and price of search hotels on hotel landing  page");
		hotelPage.hotelResults();
		
	}*/
	

}
