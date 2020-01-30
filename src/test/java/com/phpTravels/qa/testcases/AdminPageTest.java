package com.phpTravels.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.phpTravels.qa.base.TestBase;
import com.phpTravels.qa.pages.AdminPage;
import com.phpTravels.qa.pages.HomePage;
import com.phpTravels.qa.pages.HotelsPage;
import com.phpTravels.qa.util.TestUtil;

public class AdminPageTest extends TestBase {
	
	 AdminPage adminPage; 
	TestUtil testUtil;

	Logger log= Logger.getLogger(this.getClass());
	public AdminPageTest() {
		super();		
	}
	
	//@BeforeSuite
	public void setUp() throws InterruptedException {
		initialization("adminurl");
		log.info("Loading page");
		adminPage = new AdminPage();
		testUtil = new TestUtil();
	
		Assert.assertEquals(driver.getTitle(), "PHPTRAVELS | Travel Technology Partner");
	}

	//@Test(priority=0,description="Verify that hotel page is opened")
	public void quickHomePageHotelLinkPageTest() {
		log.info("Verify that Admin page is opened");
		adminPage.adminHomePage();
	}
	

}
