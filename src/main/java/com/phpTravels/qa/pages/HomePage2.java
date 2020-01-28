package com.phpTravels.qa.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.phpTravels.qa.base.TestBase;

import com.phpTravels.qa.util.TestUtil;

public class HomePage2 extends TestBase {
	Logger log = Logger.getLogger(this.getClass());
	TestUtil testutil = new TestUtil();

	@FindBy(xpath = "//a[@data-name='hotels']")
	WebElement hotelsLink;
	// a[@title='Hotels']//span[text()='Hotels ']
	// a[@title='Hotels Results']//span[text()='Hotels ']

	@FindBy(xpath = "//*[@class='text-center hotels active']")
	WebElement quickHomePageHotelLink;

	@FindBy(xpath = "//*[@id=\"select2-drop\"]/div/input")
	WebElement quickHomePageSearchtxtFd;

	@FindBy(xpath = "//*[@id='s2id_autogen1']/a/span[1]")
	WebElement destinationarea;

	@FindBy(xpath = "//*[@id='select2-drop']/div/input")
	WebElement destinationbox;

	@FindBy(xpath = "//*[@id='select2-drop']/ul/li/ul/li/div/span")
	WebElement locationsearch;

	@FindBy(xpath = "//*[@id='checkin']")
	WebElement checkin;
	@FindBy(xpath = "//*[@id='datepickers-container']/div[1]/nav/div[2]")
	WebElement checkInMnthTitle;
	@FindBy(xpath = "//*[@id='datepickers-container']/div[1]/div/div[2]/div/div[1]") // *[@id="datepickers-container"]/div[1]/div/div[2]/div/div
	WebElement checkInMnthName;
	@FindBy(xpath = "//*[@id='datepickers-container']/div[1]/div/div[1]/div[2]/div")
	WebElement checkInDate;
	@FindBy(xpath = "//*[@id='datepickers-container']/div[1]/div/div[1]/div[2]/div")
	WebElement checkInDate1;
	@FindBy(xpath = "//*[@id='checkout']")
	WebElement checkout;
	@FindBy(xpath = "//*[@id='datepickers-container']/div[2]/nav/div[2]")
	WebElement checkOutMnthTitle;
	int chckoutmonth = 0;
	String comnthxp = "//*[@id='datepickers-container']/div[2]/div/div[2]/div/div[@data-month='0']";

	@FindBy(xpath = "//*[@id='datepickers-container']/div[2]/div/div[2]/div/div[@data-month='0']")
	WebElement checkoutMonth;

	int checkoutDate = testutil.currentDate() + 2;
	String choutdtstring = "//*[@id='datepickers-container']/div[2]/div/div[1]/div[2]/div[@data-date='" + checkoutDate
			+ "'][@data-month='0']";

	@FindBy(xpath = "choutdtstring")
	WebElement dcheckoutdate;

	@FindBy(xpath = "//*[@id='hotels']/div/div/form/div/div/div[4]/button")
	WebElement hotelSearch;

	public HomePage2() {
		PageFactory.initElements(driver, this);
	}

	public HotelsPage quickHomePageHotelLinkPage() throws InterruptedException {

		quickHomePageHotelLink.click();
		destinationarea.click();
		destinationbox.sendKeys("Pune");
		locationsearch.click();
		checkin.click();
		checkInMnthTitle.click();
		// Checkin values
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		int chkindate = testutil.currentDate();
		System.out.println(" Check in date  " + chkindate);
		String chckInExpectedMonth = "Jan";
		String datexp1 = "//*[@id='datepickers-container']/div[1]/div/div[1]/div[2]/div[@data-date='28'][@data-month='";
		String datexp2 = "']";

		WebElement datepicker_cell_month = driver
				.findElement(By.xpath("//*[@id='datepickers-container']/div[1]/div/div/div[2]"));
		// *[@id='datepickers-container']/div[1]/div/div/div[2]/div
		// *[@id='datepickers-container']/div[1]/div/div[2]/div
		// *[@id='datepickers-container']/div[1]/div/div/div[2]
		List<WebElement> chckInMonths = datepicker_cell_month.findElements(By.tagName("Div"));
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		for (WebElement chckInMonth : chckInMonths) {
			chckInMonth.isEnabled();
			String selectedMonth = chckInMonth.getText();
			System.out.println(selectedMonth);
			if (selectedMonth.equalsIgnoreCase(chckInExpectedMonth)) {

				String selmonth = chckInMonth.getAttribute("data-month").toString();
				System.out.println("selmonth    " + selmonth);
				Integer intg = new Integer(selmonth);
				chckInMonths.get(intg).click();
				String datexp = datexp1 + intg + datexp2;
				// System.out.println(datexp+" datexp");
				WebElement testdate2 = driver.findElement(By.xpath(datexp));
				testdate2.isEnabled();
				Thread.sleep(3000);
				testdate2.click();
				Thread.sleep(60000);
				break;
			}
		}

		// leave everything else selected then click search button

		// Check out Values declaration

		// checkout.click();
		checkoutMonth.click();
		dcheckoutdate.click();

		System.out.println("Search completed");
		return new HotelsPage();

	}

	public HotelsPage quickHomePageHotelLinkPage1() throws InterruptedException {
		// pick the date of the checkin
		quickHomePageHotelLink.click();
		destinationarea.click();
		destinationbox.sendKeys("Pune");
		locationsearch.click();
		checkin.click();

		String testdate = driver.findElement(By.cssSelector(
				"#datepickers-container > div:nth-child(1) > div > div > div.datepicker--cells.datepicker--cells-days > div:nth-child(30)"))
				.getText();

		System.out.println("===============================" + testdate + "========================");

		// driver.findElement(By.xpath("//*[@id='body-section']/div[1]/div/div/div[1]/div/ul/li[1]/a")).click();
		// *[@id='select2-drop']/div/input
		Thread.sleep(2000);
		// driver.findElement(By.cssSelector("#dpd1 > input")).click();

		Thread.sleep(2000);
		String chckInExpectedMouth = "Feb 2020";
		String chckOutExpectedMouth = "Feb 2020";

		String chckInCurrentMonth = driver
				.findElement(By.cssSelector(
						"body > div:nth-child(23) > div.datepicker-days > table > thead > tr:nth-child(1) > th.switch"))
				.getText();

		if (chckInExpectedMouth.equals(chckInCurrentMonth)) {
			System.out.println("The month entered is already selected");
		}
		// if expectedMouth entering is not already selected the do the following
		else {
			for (int j = 1; j < 12; j++) {
				// clicking on the next button
				driver.findElement(By.xpath("/html/body/div[14]/div[1]/table/thead/tr[1]/th[3]")).click();
				// Thread.sleep(2000);

				// returning the value of current month
				chckInCurrentMonth = driver.findElement(By.xpath("/html/body/div[14]/div[1]/table/thead/tr[1]/th[2]"))
						.getText();

				if (chckInExpectedMouth.equals(chckInCurrentMonth)) {
					System.out.println("Expected month now selected  " + chckInCurrentMonth);
					break; // because we do not want to loop to carry on with next link being clicked again
				}
			}
		}
		// Thread.sleep(2000);
		// getting the days of the month
		// td contains the days of the month
		// webElement for the parent
		WebElement chckInDatePicker = driver.findElement(By.xpath("/html/body/div[14]/div[1]/table/tbody"));

		// pick up all tds - days inside trs of tbody
		List<WebElement> chckInDates = chckInDatePicker.findElements(By.tagName("td"));

		// for each date in a collection of dates webElements
		for (WebElement chckInDate : chckInDates) {

			String chckInCalenDates = chckInDate.getText();
			System.out.println(chckInCalenDates);

			if (chckInCalenDates.equals("5")) {
				chckInDate.click();
				break;
			}

		} // end of for loop
			// pick the date of the checkout
		String chckOutCurrentMonth = driver.findElement(By.xpath("//*[@id=\"dpd2\"]/input")).getText();

		if (chckOutExpectedMouth.equals(chckOutCurrentMonth)) {
			System.out.println("The check out month entered is already selected");
		}
		// if expectedMouth entering is not already selected the do the following
		else {
			for (int i = 1; i < 12; i++) {
				// clicking on the next button
				driver.findElement(By.xpath("/html/body/div[15]/div[1]/table/thead/tr[1]/th[3]")).click();
				// Thread.sleep(2000);

				// returning the value of current month
				chckOutCurrentMonth = driver.findElement(By.xpath("/html/body/div[14]/div[1]/table/thead/tr[1]/th[2]"))
						.getText();

				if (chckOutExpectedMouth.equals(chckOutCurrentMonth)) {
					System.out.println("CHeck out Expected month now selected  " + chckOutCurrentMonth);
					break; // because we do not want to loop to carry on with next link being clicked again
				}
			}
		}
		// Thread.sleep(2000);
		// getting the days of the month
		// td contains the days of the month
		// webElement for the parent
		WebElement chckOutDatePicker = driver.findElement(By.xpath("/html/body/div[15]/div[1]/table/tbody"));
		/// html/body/div[15]/div[1]/table/tbody

		// pick up all tds - days inside trs of tbody
		List<WebElement> chckOutDates = chckOutDatePicker.findElements(By.tagName("td"));

		// for each date in a collection of dates webElements
		for (WebElement chckOutDate : chckOutDates) {

			String chckOutCalenDates = chckOutDate.getText();
			System.out.println(chckOutCalenDates);

			if (chckOutCalenDates.equals("7")) {
				chckOutDate.click();
				Thread.sleep(2000);
				System.out.println(chckOutDate);
				break;
			}

		} // end of if

		// end of for loop

		// leave everything else selected then click search button
		System.out.println("Search completed");
		return new HotelsPage();
	}
}