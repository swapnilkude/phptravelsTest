package com.phpTravels.qa.unwantedpages;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.phpTravels.qa.base.TestBase;
import com.phpTravels.qa.pages.HotelsPage;
import com.phpTravels.qa.pages.MyAccountPage;

public class HomePage2 extends TestBase{

	@FindBy(xpath="//a[@title='Hotels']//span[text()='Hotels   ']")
	WebElement hotelsLink;
	
	@FindBy(xpath="//a[@title='Travelstart']//span[text()='Flights  ']")
	WebElement flightsLink;
	
	@FindBy(xpath="//a[@title='Tours']//span[text()='Tours    ']")
	WebElement toursLink;
	
	@FindBy(xpath="//a[@title='Cars']//span[text()='Cars     ']")
	WebElement carsLink;
	
	@FindBy(xpath="//a[@title='Offers']//span[text()='Offers   ']")
	WebElement offersLink;
	
	@FindBy(xpath="//a[@title='Ivisa']//span[text()='c']")
	WebElement visaLink;
	
	@FindBy(xpath="//a[@title='Blog']//span[text()='Blog     ']")
	WebElement blogLink;
	
	@FindBy(xpath="//a[text()='info@levilova.com']")
	WebElement mailLink;
	
	@FindBy(xpath="//*[@id=\"li_myaccount\"]/a")
	WebElement myAccountLink;
	
	@FindBy(xpath="//li/a[text()=' Login']")
	WebElement myAccountLoginLink;
	
	@FindBy(xpath="//li/a[text()='  Sign Up']")
	WebElement myAccountSignUpLink;
	
	@FindBy(xpath="//*[@id=\"sidebar_left\"]/div/div/ul/li[2]/a/strong/text()")
	WebElement currencyLink;
	
	@FindBy(xpath="//*[@id=\"sidebar_left\"]/div/div/ul/ul/li/a/img")
	WebElement languageLink;
	
	@FindBy(xpath="//*[@class='text-center hotels active']")
	WebElement quickHomePageHotelLink;
	
	@FindBy(xpath="//*[@id=\"select2-drop\"]/div/input")
	WebElement quickHomePageSearchtxtFd;
	
	
	
	public HomePage2() {
		PageFactory.initElements(driver, this);
	}
	
	public HotelsPage hotelsLinkPage() {
		
		hotelsLink.click();
		return new HotelsPage();
	}
	
	public FlightsPage flightsLinkPage() {
		
		flightsLink.click();
		return new FlightsPage();
	}
	
	public ToursPage toursLinkPage() {
			
		toursLink.click();
		return new ToursPage();
	}
	
	public CarsPage carsLinkPage() {
		
		carsLink.click();
		return new CarsPage();
	}
	public OffersPage offersLinkPage() {
		
		offersLink.click();
		return new OffersPage();
	}

	public VisaPage visaLinkPage() {
		
		visaLink.click();
		return new VisaPage();
	}

	public BlogPage blogLinkPage() {
		
		blogLink.click();
		return new BlogPage();
	}
	public HomePage2 mailLinkPage() {
		
		mailLink.click();
		return new HomePage2();
	}

	public MyAccountPage myAccountLinkPage() {
	
		myAccountLink.click();
		return new MyAccountPage();		
	}

	public CurrencyPage currencyLinkPage() {
		
		currencyLink.click();
		return new CurrencyPage();
	}

	public HotelsPage languageLinkPage() {
		
		hotelsLink.click();
		return new HotelsPage();
	}
	
	public HotelsPage quickHomePageHotelLinkPage() throws InterruptedException {
		//pick the date of the checkin
		quickHomePageHotelLink.click();
		//driver.findElement(By.xpath("//*[@id='body-section']/div[1]/div/div/div[1]/div/ul/li[1]/a")).click();
		//*[@id='select2-drop']/div/input
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#dpd1 > input")).click();
		
		Thread.sleep(2000);
		String chckInExpectedMouth= "Feb 2020";
		String chckOutExpectedMouth= "Feb 2020";		
		
		String chckInCurrentMonth=driver.findElement(By.cssSelector("body > div:nth-child(23) > div.datepicker-days > table > thead > tr:nth-child(1) > th.switch")).getText();
		
		if (chckInExpectedMouth.equals(chckInCurrentMonth)) {
			System.out.println("The month entered is already selected");
		}
		//if expectedMouth entering is not already selected the do the following
		else {
			for(int j=1; j<12;j++) {
				//clicking on the next button
				driver.findElement(By.xpath("/html/body/div[14]/div[1]/table/thead/tr[1]/th[3]")).click();
				//Thread.sleep(2000);
			
				//returning the value of current month
				chckInCurrentMonth=driver.findElement(By.xpath("/html/body/div[14]/div[1]/table/thead/tr[1]/th[2]")).getText();
			
				
				if (chckInExpectedMouth.equals(chckInCurrentMonth)) {
					System.out.println("Expected month now selected  " + chckInCurrentMonth);
					break; //because we do not want to loop to carry on with next link being clicked again
				}
			}
		}
		//Thread.sleep(2000);
		//getting the days of the month
		//td contains the days of the month
		//webElement for the parent
		WebElement chckInDatePicker=driver.findElement(By.xpath("/html/body/div[14]/div[1]/table/tbody"));
	
		//pick up all tds - days inside trs of tbody
		List<WebElement> chckInDates=chckInDatePicker.findElements(By.tagName("td"));
		
		//for each date in a collection of dates webElements
		for(WebElement chckInDate : chckInDates) {
		
			String chckInCalenDates = chckInDate.getText();
			System.out.println(chckInCalenDates);
			
			if(chckInCalenDates.equals("5")) {
				chckInDate.click();
				break;
			}
	
		}//end of for loop
	  //pick the date of the checkout
		String chckOutCurrentMonth=driver.findElement(By.xpath("//*[@id=\"dpd2\"]/input")).getText();
		
		if (chckOutExpectedMouth.equals(chckOutCurrentMonth)) {
			System.out.println("The check out month entered is already selected");
		}
		//if expectedMouth entering is not already selected the do the following
		else {
			for(int i=1; i<12;i++) {
				//clicking on the next button
				driver.findElement(By.xpath("/html/body/div[15]/div[1]/table/thead/tr[1]/th[3]")).click();
				//Thread.sleep(2000);
				
				//returning the value of current month
				chckOutCurrentMonth=driver.findElement(By.xpath("/html/body/div[14]/div[1]/table/thead/tr[1]/th[2]")).getText();
			
				
				if (chckOutExpectedMouth.equals(chckOutCurrentMonth)) {
					System.out.println("CHeck out Expected month now selected  " + chckOutCurrentMonth);
					break; //because we do not want to loop to carry on with next link being clicked again
				}
			}
		}
		//Thread.sleep(2000);
		//getting the days of the month
		//td contains the days of the month
		//webElement for the parent
		WebElement chckOutDatePicker=driver.findElement(By.xpath("/html/body/div[15]/div[1]/table/tbody"));
		///html/body/div[15]/div[1]/table/tbody
		
		
		
		//pick up all tds - days inside trs of tbody
		List<WebElement> chckOutDates=chckOutDatePicker.findElements(By.tagName("td"));
		
		//for each date in a collection of dates webElements
		for(WebElement chckOutDate : chckOutDates) {
		
			String chckOutCalenDates = chckOutDate.getText();
			System.out.println(chckOutCalenDates);
			
			
			if(chckOutCalenDates.equals("7")) {
				chckOutDate.click();
				Thread.sleep(2000);
				System.out.println(chckOutDate);
				break;
			
	
			}//end of if
		
	
		}//end of for loop
		
		
		//leave everything else selected then click search button
		driver.findElement(By.xpath("//*[@id=\"HOTELS\"]/form/div[3]/div[3]/button")).click();
		System.out.println("Search completed");
	return new HotelsPage();
	
	}	
}
	