package com.phpTravels.qa.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.phpTravels.qa.base.TestBase;
import com.phpTravels.qa.util.TestUtil;

public class AdminPage extends TestBase  {
	Logger log= Logger.getLogger(this.getClass());
	TestUtil testutil = new TestUtil();
	public AdminPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//h3/span[1][contains(text(),'Hotels')]//../span[2][contains(text(),'pune')]")
	WebElement HotelSearchListtitle;
	public void adminHomePage() {
		// TODO Auto-generated method stub
		
	}
}
