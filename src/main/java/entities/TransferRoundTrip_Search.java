package entities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import Base.TestBase;
import TestScript.RoundTrip.TransferRoundTrip;
import utilities.Logger;
import utilities.QaRobot;

public class TransferRoundTrip_Search extends TransferRoundTrip {

	@SuppressWarnings("deprecation")
	public static void Transfer_Roundsearch(String ccode,String Country, String Pickuptype, String dropofftype,
			String pickuplocation, String pickloctionlist, String dropofflocation, String droplocationlist,
			String adult, String child, String departdate, String returndate, String servicetime, String returntime,
			String Extratime, String currency, String nationality, String Tbooking, String Arrival, String terminal,
			String flightno, String hours, String minute, String Dterminal, String Dflightno, String Dhours,
			String Dminute, String email, String title, String adultfname, String adultlname, String adultdate,
			String adultmonth, String adultyear, String adultisd, String adultphone, String adultnationality,
			String adultCountryOfResidence, String adultAddressLine,String adultmeal, String ctitle, String childfname,
			String childlname, String childdate, String childmonth, String childyear, String childnationality,
			String childCountryOfResidence, String childAddressLine, String childmeal,String cardmode, String type, String cardno,
			String cardname, String cardmonth, String cardyear, String cardcvv, String btitle, String bfname,
			String blname, String baddress, String bcity, String bcityauto, String bstate, String bzipcode,
			String bcountry) throws Exception {

		String departdate1 = "id:id" + departdate;// id:id1252019
		String returndate1 = "id:id" + returndate;// id:id1252019
		// String result="";
		String Tresult = "xpath://a[@id='Continue" + Tbooking + "']";
		String TTerminal = "xpath://input[@id='txtFlightTer" + Tbooking + "']";
		String Tflightno = "xpath://input[@id='txtFlightnumA" + Tbooking + "']";
		String ArrivalHour = "//select[@id='txtarrivalhrs" + Tbooking + "']";
		String ArrivalMin = "//select[@id='txtarrivalmin" + Tbooking + "']";

		String TDTerminal = "xpath://input[@id='txtDepartureFlightTer" + Tbooking + "']";
		String TDflightno = "xpath://input[@id='txtDepartureFlightnumA" + Tbooking + "']";
		String DepartHour = "//select[@id='txtDeparturehrs" + Tbooking + "']";
		String DepartMin = "//select[@id='txtDeparturemin" + Tbooking + "']";
		// String THotel = "xpath://input[@id='txtDepart" + Tbooking + "']";

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

		// Return date

		QaRobot.ClickOnElement("T_Return", "Clicked on Transfer Retrun Date");

		Thread.sleep(1000);

		// ClickOnElement("nextmonth_calender", "Clicked on Next Month Button");
		// ClickOnElement("nextmonth_calender", "Clicked on Next Month Button");

		QaRobot.getLocator(returndate1).click();// id1252019

		Thread.sleep(500);

		// select Service time

		QaRobot.selectTextFromDropdown("T_Servicetime", servicetime, "Selected Serivice Time");

		// select Return time

		QaRobot.selectTextFromDropdown("T_Retruntime", returntime, "Selected Return Time");

		// click on more option

		QaRobot.ClickOnElement("T_moreoption", "clicked on more option");

		// select Extra time

		QaRobot.selectValueFromDropdown("T_Extratime", Extratime, "Selected Extra Time");

		// select currency

		QaRobot.selectValueFromDropdown("T_currency", currency, "Selected Currency");

		// Select Nationality
		QaRobot.selectTextFromDropdown("T_Nationality", nationality, "Selected Nationality");

		// take screenshot for search page

		String searchpage = Logger.takeScreenshot(driver, "Search Page");
		test.log(Status.INFO, "Screenshot for Search Page",
				MediaEntityBuilder.createScreenCaptureFromPath(searchpage).build());

		// search
		QaRobot.ClickOnElement("T_Serach", "Clicked On Serach");

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

		String resultpage = Logger.takeScreenshot(driver, "Resultpage");
		test.log(Status.INFO, "Screenshot for Resultpage",
				MediaEntityBuilder.createScreenCaptureFromPath(resultpage).build());

		// Getting result page ammount

		WebElement resultamt = driver.findElement(By.xpath("//span[@id='spnamount" + Tbooking + "']"));

		String ResultAmt = resultamt.getText();

		System.out.println("ResultPage Total Cost is " + ResultAmt);

		QaRobot.getLocator(Tresult).click();

		QaRobot.explicitwaitvisible(100, By.xpath("//a[text()='Book Now']"));

		// Select Arrival

		TestBase.listofautosuggestion(By.xpath("//div[@id='divHTCity" + Tbooking + "']/p"), pickuplocation, Arrival,
				By.xpath("//input[@id='txtArrival" + Tbooking + "']"));

		QaRobot.impliwait(30);

		QaRobot.getLocator(TTerminal).sendKeys(terminal);

		QaRobot.getLocator(Tflightno).sendKeys(flightno);

		QaRobot.selectValueByLocator(ArrivalHour, hours, "Selected Arrival Hours");

		QaRobot.selectValueByLocator(ArrivalMin, minute, "Selected Arrival Minute");

		// Select Departure

		TestBase.listofautosuggestion(By.xpath("//div[@id='DRdivHTCity" + Tbooking + "']/p"), pickuplocation, Arrival,
				By.xpath("//input[@id='txtDepartureFlight" + Tbooking + "']"));

		QaRobot.impliwait(30);

		QaRobot.getLocator(TDTerminal).sendKeys(Dterminal);

		QaRobot.getLocator(TDflightno).sendKeys(Dflightno);

		QaRobot.selectValueByLocator(DepartHour, Dhours, "Selected Departure Hours");

		QaRobot.selectValueByLocator(DepartMin, Dminute, "Selected Departure Minute");

		// take screenshot for Book page

		String bookpage = Logger.takeScreenshot(driver, "BookPage");
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

		String checkoutpage = Logger.takeScreenshot(driver, "Checkoutpage");
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

		String confirmpage = Logger.takeScreenshot(driver, "confirmpage");
		test.log(Status.INFO, "Screenshot for Confirm Page",
				MediaEntityBuilder.createScreenCaptureFromPath(confirmpage).build());
		// test.info(MarkupHelper.createCodeBlock(getLogText("\\\\erp-staging\\Cache\\Booking\\local",
		// uid[1]),
		// CodeLanguage.XML));

		QaRobot.ClickOnElement("Go_Home", "clicked on Home Page");

	}

}
