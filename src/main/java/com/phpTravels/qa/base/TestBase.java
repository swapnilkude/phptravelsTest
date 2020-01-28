package com.phpTravels.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
//import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.phpTravels.qa.util.TestUtil;
import com.phpTravels.qa.util.WebEventListener;

public class TestBase {
	Logger log= Logger.getLogger(this.getClass());
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static  WebEventListener eventListener;
	
	 //Create a constructor and initialize the variables
	static String current_dir = System.getProperty("user.dir");

	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(current_dir+"\\src\\main\\java\\com\\phpTravels\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization() throws InterruptedException {
		String browserName = prop.getProperty("browser");
		String url = prop.getProperty("url");
		System.out.println("*********************************"+       url           +"*****************************************");
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver",current_dir+"\\driverExes\\chromedriver\\chromedriver.exe");	
			ChromeOptions options = new ChromeOptions();
			options.addArguments("test-type");
			options.addArguments("start-maximized");
			options.addArguments("disable-infobars");
			options.addArguments("--disable-extensions"); 
			driver = new ChromeDriver(options);
		}
		else if(browserName.equals("IE")){
			System.setProperty("webdriver.ie.driver",current_dir+"\\driverExes\\IEDriver\\IEDriverServer.exe");	
			//E:\\Training\\Automation\\TestNG\\Workplace\\PHPTravels
			driver = new InternetExplorerDriver();
	}
	/*	e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;*/
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS); //create util class for timeunit
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		Assert.assertEquals(driver.getTitle(), "PHPTRAVELS | Travel Technology Partner");
	}	

	
	
}