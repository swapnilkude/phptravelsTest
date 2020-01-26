package com.phpTravels.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.phpTravels.qa.util.TestUtil;
import com.phpTravels.qa.util.WebEventListener;

//import com.crm.qa.util.TestUtil;
//import com.crm.qa.util.WebEventListener;
//import com.phpTravels.qa.
public class TestBase2 {
	//object level declaration
		public static WebDriver driver;
		public static Properties prop;
	    //so properties can be use at test and pages 
	    public  static EventFiringWebDriver e_driver;
	    public static WebEventListener eventListener;
	    
			public TestBase2() {
			        try{
			            prop=new Properties();
			            FileInputStream f= new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/phpTravels"
			                    + "/qa/config/config.properties");
			            prop.load(f);

			        }catch(FileNotFoundException e){
			            e.printStackTrace();      
			        }catch(IOException e){
			            e.printStackTrace();
			        }
			    }
			
			public static void initialization(){
		        
		        String browserName= prop.getProperty("browser");
		        //the browser drivers were installed using brew so they should automatically be on my system path
		        if(browserName.equals("chrome")){
		            //System.setProperty("webdriver.chrome.driver","/Users/yvonneak/Documents/AutomationFiles/webDrivers/chrome/chromedriver");
		           driver =new ChromeDriver();
		        }
		        else if(browserName.equals("FF")){
		            //System.setProperty
		            driver = new FirefoxDriver();
		        }
		        e_driver = new EventFiringWebDriver(driver);
		        //create object of EventListerHandler to register it wthe the EventFiringWebDriver
		    
		        eventListener = new WebEventListener();
		    
		       e_driver.register(eventListener);
		       driver = e_driver;
		       
		       driver.manage().window().maximize();
		       driver.manage().deleteAllCookies();
		       driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		       driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		    
		       driver.get(prop.getProperty("url"));
		               
		       }
			
		
	
}