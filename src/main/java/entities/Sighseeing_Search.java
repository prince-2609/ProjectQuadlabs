package entities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import Base.TestBase;
import TestScript.Sighseeing123.Sighseeing;
import utilities.Logger;
import utilities.QaRobot;

public class Sighseeing_Search extends Sighseeing {

	public static void Sightseen_search(String ccode,String country, String city, String cityname, String pickdate, String adult,
			String child, String nationality, String type, String currency, String Sbooking, String email, String title,
			String adultfname, String adultlname, String adultdate, String adultmonth, String adultyear,
			String adultisd, String adultphone, String adultnationality, String adultCountryOfResidence,
			String adultAddressLine, String adultmeal,String ctitle, String childfname, String childlname, String childdate,
			String childmonth, String childyear, String childnationality, String childCountryOfResidence,
			String childAddressLine,String childmeal, String cardmode, String cardtype, String cardno, String cardname, String cardmonth,
			String cardyear, String cardcvv, String btitle, String bfname, String blname, String baddress, String bcity,
			String bcityauto, String bstate, String bzipcode, String bcountry) throws Exception {

		// String departdate = "id:id" + pickdate;
		String Sresult = "xpath:(//a[@class='btn btn-primary btn-select'])[" + Sbooking + "]";
		String SProcced = "xpath:(//a[text()='Proceed'])[" + Sbooking + "]";
		String Sbook = "xpath://a[@id='btnbook" + Sbooking + "']";

		// select Country

		QaRobot.selectTextFromDropdown("S_Country", country, "Selected Sightseeing Country");

		// Entered City

		TestBase.listofautosuggestion(By.xpath("//div[@id='divSSGCity']/p"), city, cityname,
				By.xpath("//input[@id='SSG_City']"));

		Thread.sleep(1000);

		// departure date

		QaRobot.ClickOnElement("S_pickupdate", "Clicked on Sightseen Departure");

		JavascriptExecutor tripDays = (JavascriptExecutor) driver;

		WebElement departdate = driver.findElement(By.id("id" + pickdate + ""));

		tripDays.executeScript("arguments[0].click();", departdate);

		Thread.sleep(500);

		// select Adult value

		QaRobot.selectValueFromDropdown("S_Adult", adult, "Selected Adult for Sightseen");

		// select Child value

		QaRobot.selectValueFromDropdown("S_child", child, "Selected Child for Sightseen");

		// Select Nationality
		QaRobot.selectTextFromDropdown("S_nationality", nationality, "Selected Nationality");

		// Select Type
		// selectTextFromDropdown("S_Type", type, "Selected Nationality");

		// select currency
		QaRobot.selectValueFromDropdown("S_Currency", currency, "Selected Currency");

		// take screenshot for search page

		String searchpage1 = Logger.takeScreenshot(driver, "Search Page1");
		System.out.println("Screenshot path     " + searchpage1);
		test.log(Status.INFO, "Screenshot for Search Page",
				MediaEntityBuilder.createScreenCaptureFromPath(searchpage1).build());

		// search
		QaRobot.ClickOnElement("S_search", "Clicked On Serach");

		QaRobot.explicitwaitinvisible(50, By.xpath("//div[@class='loadbar ld_sghtsng']"));

		// get current url

		String url = driver.getCurrentUrl();

		System.out.println(url);

		String[] uid = url.split("=");

		// System.out.println(id[0]);

		// System.out.println(id[1]);

		test.log(Status.INFO, "Result page url is  " + url);

		test.log(Status.INFO, "Session id is " + uid[1]);

		// Getting result page ammount

		WebElement resultamt = driver.findElement(By.xpath("//span[@id='spnPrice" + Sbooking + "']"));

		String ResultAmt = resultamt.getText();

		System.out.println("ResultPage Total Cost is " + ResultAmt);

		// take screenshot for result page

		String resultpage = Logger.takeScreenshot(driver, "Resultpage");
		test.log(Status.INFO, "Screenshot for Resultpage",
				MediaEntityBuilder.createScreenCaptureFromPath(resultpage).build());

		QaRobot.getLocator(Sresult).click();

		QaRobot.explicitwaitvisible(30, By.xpath("(//a[text()='Proceed'])[" + Sbooking + "]"));

		QaRobot.getLocator(SProcced).click();

		// explicitwaitinvisible(30, By.xpath("(//a[text()='Proceed'])[" +
		// Sbooking + "]"));

		// explicitwaitvisible(30, By.xpath("//a[@id='btnbook" + Sbooking +
		// "']"));
		//WebElement book = driver.findElement(By.xpath("//a[@id='btnbook" + Sbooking + "']"));
		boolean book = driver.findElements(By.xpath("//a[@id='btnbook" + Sbooking + "']")).size() > 0;
		if (book) {

			QaRobot.getLocator(Sbook).click();
		}

		// explicitwaitinvisible(30, By.xpath("//a[@id='btnbook" + Sbooking +
		// "']"));

		// client email
		QaRobot.PassValue("Transferclient_email", email, "Entered Client Email");

		// Getting Checkout page ammount

		String CheckoutAmt = QaRobot.getWebElement("S_checkoutamt").getText();

		System.out.println("Checkout Page Total Cost is " + CheckoutAmt);

		// compare value of result and checkout page

		CompareFareValue(ResultAmt, CheckoutAmt, " Checkout page " + CheckoutAmt);

		TransferadultCheckout(ccode,adult, title, adultfname, adultlname, adultdate, adultmonth, adultyear, adultisd,
				adultphone, adultnationality, adultCountryOfResidence, adultAddressLine,adultmeal);

		TransferchildCheckout(ccode,child, ctitle, childfname, childlname, childdate, childmonth, childyear, childnationality,
				childCountryOfResidence, childAddressLine,childmeal);

		// condition for credit and online
		card(cardmode, cardtype, cardno, cardname, cardmonth, cardyear, cardcvv);

		Billing(btitle, bfname, blname, baddress, bcity, bcityauto, bstate, bzipcode, bcountry);

		// check terms and condition
		QaRobot.ClickOnElement("check_terms", "Clicked On Terms condition");

		// Getting Payment page ammount

		String paymentAmt = QaRobot.getWebElement("S_paymentamt").getText();

		System.out.println("Payment Page Total Cost is " + paymentAmt);

		// take screenshot for checkout page

		String checkoutpage = Logger.takeScreenshot(driver, "Checkoutpage");
		test.log(Status.INFO, "Screenshot for Checkoutpage",
				MediaEntityBuilder.createScreenCaptureFromPath(checkoutpage).build());

		// click confirm button
		QaRobot.ClickOnElement("confirm", "Clicked on confirm Button");

		String bookingid = QaRobot.getWebElement("booking_no").getText();
		test.log(Status.INFO, "Booking number is " + bookingid);
		System.out.println("Booking Id is " + bookingid);

		String status = QaRobot.getWebElement("Transfer_status").getText();
		test.log(Status.INFO, "Booking Status is " + status);
		System.out.println("Booking Status is " + status);

		// Getting Confirm page ammount

		String confirmAmt = QaRobot.getWebElement("S_confirmamt").getText();

		System.out.println("Confirm Page Total Cost is " + confirmAmt);
		
		// compare value of Payment and confirm page

		CompareFareValue(paymentAmt, confirmAmt, " Confirm page " + confirmAmt);
		
		// take screenshot for confirm page

		String confirmpage = Logger.takeScreenshot(driver, "confirmpage");
		test.log(Status.INFO, "Screenshot for Confirm Page",
				MediaEntityBuilder.createScreenCaptureFromPath(confirmpage).build());
		// test.info(MarkupHelper.createCodeBlock(getLogText("\\\\erp-staging\\Cache\\Booking\\local",
		// uid[1]),CodeLanguage.XML));
		QaRobot.ClickOnElement("Go_Home", "clicked on Home Page");

	}

}
