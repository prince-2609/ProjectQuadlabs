package entities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import Base.TestBase;
import TestScript.Travelmall.TravelmallToneway;
import utilities.QaLogger;
import utilities.QaRobot;

public class Travelmall_TOneway extends TravelmallToneway {

	@SuppressWarnings("deprecation")
	public static void Transfer_OneWaysearch(String ccode,String Country, String Pickuptype, String dropofftype,
			String pickuplocation, String pickloctionlist, String dropofflocation, String droplocationlist,
			String adult, String child, String departdate, String servicetime, String Extratime, String currency,
			String nationality, String Tbooking, String Arrival, String terminal, String flightno, String hours,
			String minute, String departure,String dropterminal, String dropflightno, String drophours, String dropminute, String email,
			String title, String adultfname, String adultlname, String adultdate, String adultmonth, String adultyear,
			String adultisd, String adultphone, String adultnationality, String adultCountryOfResidence,
			String adultAddressLine,String adultmeal, String ctitle, String childfname, String childlname, String childdate,
			String childmonth, String childyear, String childnationality, String childCountryOfResidence,
			String childAddressLine,String childmeal, String cardmode, String type, String cardno, String cardname, String cardmonth,
			String cardyear, String cardcvv, String btitle, String bfname, String blname, String baddress, String bcity,
			String bcityauto, String bstate, String bzipcode, String bcountry) throws Exception {

		String departdate1 = "id:id" + departdate;// id:id1252019
		// String result="";
		String Tresult = "xpath://a[@id='Continue" + Tbooking + "']";
		String TTerminal = "xpath://input[@id='txtFlightTer" + Tbooking + "']";
		String Tflightno = "xpath://input[@id='txtFlightnumA" + Tbooking + "']";
		String ArrivalHour = "//select[@id='txtarrivalhrs" + Tbooking + "']";
		String ArrivalMin = "//select[@id='txtarrivalmin" + Tbooking + "']";
		
		String THotel = "xpath://input[@id='txtDepart" + Tbooking + "']";

		String TdropTerminal = "xpath://input[@id='txtDepFlightTer" + Tbooking + "']";
		String Tdropflightno = "xpath://input[@id='txtFlightnumD" + Tbooking + "']";
		String dropArrivalHour = "//select[@id='txtdeparthrs" + Tbooking + "']";
		String dropArrivalMin = "//select[@id='txtdepartmin" + Tbooking + "']";

		// select Country

		QaRobot.selectTextFromDropdown("T_Country", Country, "Selected Transfer Country");

		// select pickup type

		QaRobot.selectValueFromDropdown("T_picktype", Pickuptype, "Selected Pickup Type");

		// select drop off type

		QaRobot.selectValueFromDropdown("T_dropofftype", dropofftype, "Selected Dropoff Type");

		// select pick up loctaion

		TestBase.listofautosuggestion(By.xpath("//div[@id='popUP_div']/p"), pickuplocation, pickloctionlist,
				By.xpath("//input[@id='TFR_PkUpLocation_txt']"));
		QaRobot.impliwait(60);

		// select drop off location

		TestBase.listofautosuggestion(By.xpath("//div[@id='TFR_DropOFF_div']/p"), dropofflocation, droplocationlist,
				By.xpath("//input[@id='TFR_DropOFF_Location']"));

		QaRobot.impliwait(60);

		// select Adult value

		QaRobot.selectValueFromDropdown("T_Adult", adult, "Selected Adult for Transfer");

		// select Child value

		QaRobot.selectValueFromDropdown("T_child", child, "Selected Child for Transfer");

		// departure date

		QaRobot.ClickOnElement("T_departdate", "Clicked on Transfer Departure");

		Thread.sleep(1000);

		// ClickOnElement("nextmonth_calender", "Clicked on Next Month Button");
		// ClickOnElement("nextmonth_calender", "Clicked on Next Month Button");

		QaRobot.getLocator(departdate1).click();// id1252019

		Thread.sleep(500);

		// select Service time

		QaRobot.selectTextFromDropdown("T_Servicetime", servicetime, "Selected Serivice Time");

		// click on more option

		QaRobot.ClickOnElement("travelmall_more_option", "clicked on more option");

		// select Extra time

		QaRobot.selectValueFromDropdown("T_Extratime", Extratime, "Selected Extra Time");

		// select currency

		// selectValueFromDropdown("T_currency", currency, "Selected Currency");

		// Select Nationality
		// selectTextFromDropdown("T_Nationality", nationality, "Selected
		// Nationality");

		// take screenshot for search page

		String searchpage = QaLogger.takeScreenshot(driver, "Search Page");
		test.log(Status.INFO, "Screenshot for Search Page",
				MediaEntityBuilder.createScreenCaptureFromPath(searchpage).build());

		// search
		QaRobot.ClickOnElement("travelmall_flight_search", "Clicked On Serach");

		QaRobot.explicitwaitinvisible(70, By.xpath("//div[@class='loadbar ld_trnsfr']"));

		// get current url

		String url = driver.getCurrentUrl();

		System.out.println(url);

		String[] uid = url.split("=");

		// System.out.println(id[0]);

		// System.out.println(id[1]);

		test.log(Status.INFO, "Result page url is  " + url);

		test.log(Status.INFO, "Session id is " + uid[1]);

		// take screenshot for result page

		String resultpage = QaLogger.takeScreenshot(driver, "Resultpage");
		test.log(Status.INFO, "Screenshot for Resultpage",
				MediaEntityBuilder.createScreenCaptureFromPath(resultpage).build());

		// Getting result page ammount

		WebElement resultamt = driver.findElement(By.xpath("//span[@id='spnamount" + Tbooking + "']"));

		String ResultAmt = resultamt.getText();

		System.out.println("ResultPage Total Cost is " + ResultAmt);

		// click on select now

		QaRobot.getLocator(Tresult).click();

		QaRobot.explicitwaitvisible(100, By.xpath("//a[text()='Book Now']"));
		
		Thread.sleep(500);

		TestBase.listofautosuggestion(By.xpath("//div[@id='divHTCity" + Tbooking + "']/p"), pickuplocation, Arrival,
				By.xpath("//input[@id='txtArrival" + Tbooking + "']"));

		QaRobot.impliwait(30);
		
		QaRobot.getLocator(TTerminal).clear();
		QaRobot.getLocator(TTerminal).sendKeys(terminal);

		QaRobot.getLocator(Tflightno).sendKeys(flightno);

		QaRobot.selectValueByLocator(ArrivalHour, hours, "Selected Arrival Hours");

		QaRobot.selectValueByLocator(ArrivalMin, minute, "Selected Arrival Minute");

		if (dropofftype.equalsIgnoreCase("A")) {
			
			Thread.sleep(500);


			TestBase.listofautosuggestion(By.xpath("//div[@id='DdivHTCity_" + Tbooking + "']/p"), dropofflocation,
					departure, By.xpath("//input[@id='txtDepart" + Tbooking + "']"));

			QaRobot.impliwait(30);
			
			QaRobot.getLocator(TdropTerminal).clear();

			QaRobot.getLocator(TdropTerminal).sendKeys(dropterminal);

			QaRobot.getLocator(Tdropflightno).sendKeys(dropflightno);

			QaRobot.selectValueByLocator(dropArrivalHour, drophours, "Selected Depart Hours");

			QaRobot.selectValueByLocator(dropArrivalMin, dropminute, "Selected Depart Minute");
		}
		// take screenshot for Book page

		String bookpage = QaLogger.takeScreenshot(driver, "BookPage");
		test.log(Status.INFO, "Screenshot for Book Page",
				MediaEntityBuilder.createScreenCaptureFromPath(bookpage).build());

		QaRobot.ClickOnElement("T_book", "Clicked on transfer book");

		QaRobot.explicitwaitinvisible(60, By.xpath("//a[text()='Book Now']"));

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
		card(cardmode, type, cardno, cardname, cardmonth, cardyear, cardcvv);

		Billing(btitle, bfname, blname, baddress, bcity, bcityauto, bstate, bzipcode, bcountry);

		// take screenshot for checkout page

		String checkoutpage = QaLogger.takeScreenshot(driver, "Checkoutpage");
		test.log(Status.INFO, "Screenshot for Checkoutpage",
				MediaEntityBuilder.createScreenCaptureFromPath(checkoutpage).build());

		// check terms and condition
		QaRobot.ClickOnElement("check_terms", "Clicked On Terms condition");

		// Getting Payment page ammount

		String paymentAmt = QaRobot.getWebElement("S_paymentamt").getText();

		System.out.println("Payment Page Total Cost is " + paymentAmt);

		// click confirm button
		QaRobot.ClickOnElement("confirm", "Clicked on confirm Button");

		String bookingid = QaRobot.getWebElement("booking_no").getText();
		test.log(Status.INFO, "Booking number is " + bookingid);
		System.out.println("Booking Id is " + bookingid);

		// Getting Confirm page ammount

		String confirmAmt = QaRobot.getWebElement("S_confirmamt").getText();

		System.out.println("Confirm Page Total Cost is " + confirmAmt);

		// compare value of Payment and confirm page

		CompareFareValue(paymentAmt, confirmAmt, " Confirm page " + confirmAmt);

		String status = QaRobot.getWebElement("Transfer_status").getText();
		test.log(Status.INFO, "Booking Status is " + status);
		System.out.println("Booking Status is " + status);

		// take screenshot for confirm page

		String confirmpage = QaLogger.takeScreenshot(driver, "confirmpage");
		test.log(Status.INFO, "Screenshot for Confirm Page",
				MediaEntityBuilder.createScreenCaptureFromPath(confirmpage).build());
		// test.info(MarkupHelper.createCodeBlock(getLogText("\\\\erp-staging\\Cache\\Booking\\local",
		// uid[1]),
		// CodeLanguage.XML));

		QaRobot.ClickOnElement("travelmall_gohome", "clicked on Home Page");
	}

}
