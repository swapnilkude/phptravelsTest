package com.phpTravels.qa.testcases;

import java.io.IOException;
import java.text.ParseException;

import org.apache.log4j.Logger;
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
	
	@Test(priority=4,description="verify list and price of search hotels on hotel landing  page")
	public void namePriceHoteslsTest() throws InterruptedException, ParseException, IOException {
		log.info("verify list and price of search hotels on hotel landing  page");
		hotelPage.hotelResults();
	}
	

}
