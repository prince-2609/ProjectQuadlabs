package entities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import Base.TestBase;
import TestScript.RoundTrip.Flightcheck;
import utilities.QaDataProvider;
import utilities.QaExcelRead;
import utilities.QaLogger;
import utilities.QaRobot;

public class Flightoneway_newcheckout extends Flightcheck {

	Base.TestBase t ;
	QaExcelRead reader;

	@DataProvider
	public Object[][] getexceldata() throws Exception {

		
		return QaDataProvider.getExceldata("OneWay","newcheckout");
	}

	@Test(dataProvider = "getexceldata")

	public static void flightOneway(String ccode,String username, String password, String origin, String forigin, String destination,
			String fdestination, String ddate, String Triptype, String adult, String child, String infant,
			String fcurrency, String fclass, String airlines, String title, String adultfname, String adultlname,
			String adultmonth, String adultyear, String adultdate, String adultidno, String adultmailid,
			String adultisd, String adultphone, String adultpassprot, String adultpassportcomp, String adultemonth,
			String adulteyear, String adultedate, String adultnationality, String ctitle, String childfname,
			String childlname, String childmonth, String childyear, String childdate, String childidno,
			String childpassprot, String childpassportcomp, String childemonth, String childeyear, String childedate,
			String childnationality, String ititle, String infantfname, String infantlname, String infantmonth,
			String infantyear, String infantdate, String infantidno, String infantTravelling, String infantpassprot,
			String infantpassportcomp, String infantemonth, String infanteyear, String infantedate,
			String infantnationality, String btitle, String bfname, String blname, String bemailid, String baddress,
			String bcity, String bcityauto, String bstate, String bzipcode, String bcountry, String cardmode,
			String type, String cardno, String cardname, String cardmonth, String cardyear, String cardcvv,
			String cardpwd, String couponno, String discountvalue, String faretype) throws Exception {
		
		Companycode(ccode);

		test = report.createTest("flight Oneway For New Checkout Page");
	
		Thread.sleep(500);

		TestBase.listofautosuggestion(By.xpath("//DIV[@id='divFLDepart']/P"), origin, forigin,
				By.xpath("//input[@id='fromcityAc']"));
		Thread.sleep(500);

		TestBase.listofautosuggestion(By.xpath("//DIV[@id='divFLArrival']/P"), destination, fdestination,
				By.xpath("//input[@id='tocityAc']"));

		Thread.sleep(500);

		String departdate = "id:id" + ddate;// id:id1252019
		String Fclass = "xpath://select[@id='ddl_class']/option[contains(text(),'" + fclass + "')]";
		String currency = "xpath://select[@id='ddl_currency']/option[contains(text(),'" + fcurrency + "')]";
		String result = "";
		String TFR = "";
		WebElement fareChange, creditcharge, Seatnotavailable, onlinecharge;

		// departure date

		QaRobot.ClickOnElement("flight_depart_date", "Clicked on Flight Departure");

		Thread.sleep(1000);

		// ClickOnElement("nextmonth_calender", "Clicked on Next Month Button");
		// ClickOnElement("nextmonth_calender", "Clicked on Next Month Button");

		QaRobot.getLocator(departdate).click();// id1252019

		// Pax
		QaRobot.ClickOnElement("select_pax", "clicked on select PAX");

		// select adult
		QaRobot.selectValueFromDropdown("flight_adult", adult, "Selected Adult");

		// select child
		QaRobot.selectValueFromDropdown("flight_child", child, "Selected Child");

		// select infant
		QaRobot.selectValueFromDropdown("flight_infant", infant, "Selected Infant");

		// explicitwaitclickable(60,By.xpath("(//a[contains(text(),'More
		// Options')])[1]"));
		Thread.sleep(500);
		QaRobot.ClickOnElement("option", "clicked on interface");

		// click on more option
		QaRobot.ClickOnElement("more_option", "clicked on more option");

		// select currency

		QaRobot.ClickOnElement("flight_currency", "Selected Currency");
		QaRobot.getLocator(currency).click();

		// select class
		QaRobot.ClickOnElement("flight_class", "Selected Class");
		QaRobot.getLocator(Fclass).click();

		Thread.sleep(500);

		// PreferedAirline("preferd_airline", airlines, "search_airline");

		// click for quick access

		QaRobot.ClickOnElement("quick_flight", "Clicked for quick access");

		// take screenshot for search page

		String searchpage = QaLogger.takeScreenshot(driver, "Search Page");
		test.log(Status.INFO, "Screenshot for Search Page",
				MediaEntityBuilder.createScreenCaptureFromPath(searchpage).build());

		// search
		QaRobot.ClickOnElement("flight_rsearch", "Clicked On Serach");

		QaRobot.explicitwaitinvisible(240, By.xpath("//*[@class='progress-bar progress-bar-striped active']"));

		// get current url

		String url = driver.getCurrentUrl();

		System.out.println(url);

		String[] uid = url.split("=");

		// System.out.println(id[0]);

		// System.out.println(id[1]);

		test.log(Status.INFO, "Result page url is  " + url);

		test.log(Status.INFO, "Session id is " + uid[1]);

		// If not getting result

		WebElement ResultNotFound = driver.findElement(By.xpath(
				"//p[text()='Oops! Seems like no flight journeys are available for the selected search criteria.']"));

		if (ResultNotFound.isDisplayed()) {
			try {

				test.log(Status.FAIL, "Result is not found");

				// take screenshot for result page

				String resultnotfound = QaLogger.takeScreenshot(driver, "resultnotfound");
				test.log(Status.INFO, "Screenshot for Resultnotfound",
						MediaEntityBuilder.createScreenCaptureFromPath(resultnotfound).build());

				QaRobot.ClickOnElement("new_chk_home", "clicked on Home Page");

				System.out.println("Result Not Found");

			} catch (Throwable e) {

				System.out.println(e);
			}
		}

		else {

			// take screenshot for result page

			String resultpage = QaLogger.takeScreenshot(driver, "Resultpage");
			test.log(Status.INFO, "Screenshot for Resultpage",
					MediaEntityBuilder.createScreenCaptureFromPath(resultpage).build());

			// get total amount of result page

			result = QaRobot.getWebElement("result_fare").getText();

			System.out.println("result fare is " + result);
			
			test.log(Status.PASS, "Result page fare is " + result);

			// fare_breakups(result);

			// Fare_Rule();

			// Flight_Iteneary("anjali.jain@quadlabs.com");

			TFR = driver.findElement(By.xpath("//span[@class='filter_state ng-binding']")).getText();
			String[] totalFlightResult = TFR.split(" ");
			int totalresults = Integer.parseInt(totalFlightResult[1]);
			System.out.println("Total " + totalresults);

			

			// book

			QaRobot.ClickOnElement("flight_book", "Clicked On Book");

			QaRobot.explicitwaitvisible(200, By.xpath("//span[@id='ShowTotalFare']"));

			// Seat not available

			Seatnotavailable = driver.findElement(By.xpath("//p[text()='The seat is no longer available ']"));
			Thread.sleep(500);

			if (Seatnotavailable.isDisplayed()) {

				// click on book another flight

				System.out.println("Seat status is " + Seatnotavailable.isDisplayed());
				QaRobot.ClickOnElement("new_chk_bookanotherflight", "Clicked on Book another flight");

				QaRobot.explicitwaitinvisible(140, By.xpath("//*[@class='progress-bar progress-bar-striped active']"));

				for (int i = 1; i <= totalresults; i++) {
					
				

					// get total amount of result page

					result = driver.findElement(By.xpath("(//span[@class='f_p_n_f_price ng-binding'])[("+ i +" * 3 + 1)]")).getText();

					System.out.println("result page fare after choose another flight is " + result);
					
					test.log(Status.PASS, "Result page fare after choose another flight is " + result);
					
					driver.findElement(By.xpath("(//input[starts-with(@id,'Anchor_')])[" + (i * 3 + 1) + "]")).click();
					QaRobot.explicitwaitvisible(250, By.xpath("//span[@id='ShowTotalFare']"));

					Seatnotavailable = driver.findElement(By.xpath("//p[text()='The seat is no longer available ']"));
					boolean seatNo = Seatnotavailable.isDisplayed();
					Thread.sleep(1000);

					if (Seatnotavailable.isDisplayed()) {

						QaRobot.ClickOnElement("new_chk_bookanotherflight", "Clicked on Book another flight");

						QaRobot.explicitwaitinvisible(200, By.xpath("//*[@class='progress-bar progress-bar-striped active']"));
						TFR = driver.findElement(By.xpath("//span[@class='filter_state ng-binding']")).getText();
						String[] totalFlightResult1 = TFR.split(" ");
						totalresults = Integer.parseInt(totalFlightResult1[1]);
						System.out.println("Total result " + totalresults);
						Thread.sleep(500);
					}

					else {

						System.out.println(seatNo);

						if (!seatNo) {
							break;
						}

					}

				}
			}


				// fare change

				fareChange = driver.findElement(By.xpath("//h1[text()='Fare Update']"));

				if (fareChange.isDisplayed()) {

					if (faretype.equalsIgnoreCase("Choose")) {
						QaRobot.ClickOnElement("new_chk_chooseanotherflight", "Clicked on book another flight button");

						QaRobot.explicitwaitinvisible(140, By.xpath("//*[@class='progress-bar progress-bar-striped active']"));

						for (int i = 1; i <= totalresults; i++) {

							driver.findElement(By.xpath("(//input[starts-with(@id,'Anchor_')])[" + (i * 3 + 1) + "]"))
									.click();

							QaRobot.explicitwaitvisible(250, By.xpath("//span[@id='ShowTotalFare']"));

							fareChange = driver.findElement(By.xpath("//h1[text()='Fare Update']"));
							boolean fareupdate = fareChange.isDisplayed();

							if (!fareupdate) {
								break;
							}
						}

					} else if (faretype.equalsIgnoreCase("Accept")) {

						QaRobot.ClickOnElement("new_chk_acceptflight", "Clicked on Accept and continue button");

						String checkout = QaRobot.getWebElement("Fnew_chkfare").getText();
						String[] checkoutfare = checkout.split(" ");

						System.out.println("Checkout page fare after fare update " + checkoutfare[1]);

						test.log(Status.PASS, "Checkout page fare after fare update " + checkoutfare[1]);
						Thread.sleep(1000);
					}

				}
			}

			// compare value of result and checkout before fee on checkout
			// page

			String checkout = QaRobot.getWebElement("Fnew_chkfare").getText();
			String[] checkoutfare = checkout.split(" ");

			System.out.print("checkout fare is " + checkoutfare[1]);

			test.log(Status.PASS, "Checkout page fare before fee is " + checkoutfare[1]);

			// CompareFareValue(result, checkoutfare[1], " checkout page " +
			// checkout);

			// take screenshot for Checkout page

			String checkoutpage = QaLogger.takeScreenshot(driver, "checkoutpage");
			test.log(Status.INFO, "Screenshot for Checkout Page",
					MediaEntityBuilder.createScreenCaptureFromPath(checkoutpage).build());

			Thread.sleep(500);
			adultNewCheckout(adult, title, adultfname, adultlname, adultmonth, adultyear, adultdate, adultidno,
					adultmailid, adultisd, adultphone, adultpassprot, adultpassportcomp, adultemonth, adulteyear,
					adultedate, adultnationality);

			childNewCheckout(child, ctitle, childfname, childlname, childmonth, childyear, childdate, childidno,
					childpassprot, childpassportcomp, childemonth, childeyear, childedate, childnationality);

			infantNewCheckout(child, infant, ititle, infantfname, infantlname, infantmonth, infantyear, infantdate,
					infantidno, infantTravelling, infantpassprot, infantpassportcomp, infantemonth, infanteyear,
					infantedate, infantnationality);

			// click on confirm button

			QaRobot.ClickOnElement("fnew_confirm", "Clicked on confirm button");
			Thread.sleep(1000);

			// condition for credit and online

			NewChkout_Card(cardmode, type, cardno, cardname, cardmonth, cardyear, cardcvv);

			//Newchekout_Billing(cardmode, btitle, bfname, blname, bemailid, baddress, bcity, bcityauto, bstate, bzipcode,
					//bcountry);

			// Print Online fee charge

			onlinecharge = driver.findElement(By.xpath("//div[text()='Convenience Fee ']"));
			if (onlinecharge.isDisplayed()) {

				String ocharge = QaRobot.getWebElement("new_chk_onlinecharge").getText();
				String[] ocharge1 = ocharge.split(" ");
				test.log(Status.PASS, "Convenience Fee is " + ocharge1[1]);
				System.out.println("Convenience Fee is " + ocharge1[1]);

			}

			// Print Credit card charge

			creditcharge = driver.findElement(By.xpath("//div[text()='Online Convenience Fee ']"));
			if (creditcharge.isDisplayed()) {

				String ccharge = QaRobot.getWebElement("new_chk_creditcharge").getText();
				String[] ccharge1 = ccharge.split(" ");
				test.log(Status.PASS, "Online Convenience Fee is " + ccharge1[1]);
				System.out.println("Online Convenience Fee is " + ccharge1[1]);

			}

			// get fare for payment page

			String payment = QaRobot.getWebElement("Fnew_chkfare").getText();
			String[] paymentfare = payment.split(" ");

			System.out.println("Payment page fare  is " + paymentfare[1]);

			test.log(Status.PASS, "Payment page fare is " + paymentfare[1]);

			QaRobot.ClickOnElement("new_chk_paynow", "Clicked on pay button");

			QaRobot.explicitwaitvisible(100, By.xpath("//h1[@class='text-truncate pt-0 ng-binding']"));

			// take screenshot for confirm page

			String confirmpage = QaLogger.takeScreenshot(driver, "confirmpage");
			test.log(Status.INFO, "Screenshot for Confirm Page",
					MediaEntityBuilder.createScreenCaptureFromPath(confirmpage).build());

			String bookingid = QaRobot.getWebElement("new_chk_bookingid").getText();
			test.log(Status.INFO, "Booking number is " + bookingid);
			System.out.println("Booking Id is " + bookingid);

			String status = QaRobot.getWebElement("new_chk_status").getText();
			test.log(Status.INFO, "Booking Status is " + status);
			System.out.println("Booking Status is " + status);

			String pnrno = QaRobot.getWebElement("new_chk_pnr").getText();
			test.log(Status.INFO, "PNR number is " + pnrno);
			System.out.println("PNR no is " + pnrno);

			// compare value of payment and confirm Page

			String confrim = QaRobot.getWebElement("Fnew_chkfare").getText();
			String[] confrimfare = confrim.split(" ");

			System.out.print("confirm page fare  is " + confrimfare[1]);

			test.log(Status.PASS, "Confirm page fare is " + confrimfare[1]);

			CompareFareValue(paymentfare[1], confrimfare[1], " confirm " + confrimfare[1]);

			// printing log in report

			test.info(MarkupHelper.createCodeBlock(getLogText("\\\\erp-staging\\Cache\\Booking\\local\\store", uid[1]),
					CodeLanguage.XML));
			QaRobot.ClickOnElement("new_chk_home", "clicked on Home Page");

		}

	@AfterMethod
	public static void afterMetod() {
		test.getExtent().flush();
	}

}
