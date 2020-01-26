package com.phpTravels.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class LaunchClose {
	
	WebDriver driver;
	
	@BeforeClass
	public void launchApp() {
		//instantiate Chrome Browser driver
		//System.setProperty("webdriver.chrome.driver", "/Users/yvonneak/Documents/webDrivers/chrome/chromedriver");
		
		driver = new ChromeDriver();
		
		driver.get("https://www.phptravels.net/");
		
		//boolean applaunch=driver.getCurrentUrl();
		
		System.out.println("browser has launched");
		
	}
	
	@AfterClass
	public void CloseApp() {
		driver.quit();
		
		System.out.println("browser has quite");
		
	}

}
