package entities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import Base.TestBase;
import TestScript.Algosaibi.AlgosaibiRoundtrip;
import utilities.QaLogger;
import utilities.QaRobot;

public class Algosaibi_roundtrip extends AlgosaibiRoundtrip 
{

	
	public static void flight_search(String username, String password, String origin, String forigin,
			String destination, String fdestination, String ddate, String adate, String Triptype, String adult,
			String child, String infant, String fcurrency, String fclass, String airlines, String emailid, String title,
			String adultfname, String adultmname, String adultlname, String adultdate, String adultmonth,
			String adultyear, String adultidno, String adultisd, String adultphone, String adultpassprot,
			String adultpassportcomp, String adultedate, String adultemonth, String adulteyear, String adultnationality,
			String ctitle, String childfname, String childlname, String childdate, String childmonth, String childyear,
			String childidno, String childpassprot, String childpassportcomp, String childedate, String childemonth,
			String childeyear, String childnationality, String ititle, String infantfname, String infantlname,
			String infantdate, String infantmonth, String infantyear, String infantidno, String infantTravelling,
			String infantpassprot, String infantpassportcomp, String infantedate, String infantemonth,
			String infanteyear, String infantnationality, String btitle, String bfname, String blname, String baddress,
			String bcity, String bcityauto, String bstate, String bzipcode, String bcountry, String cardmode,
			String type, String cardno, String cardname, String cardmonth, String cardyear, String cardcvv,
			String cardpwd, String couponno, String discountvalue) throws Exception {

		String departdate = "id:id" + ddate;// id:id1252019
		String arrivaldate = "id:id" + adate;
		String Fclass = "xpath://select[@id='ddl_class']/option[contains(text(),'" + fclass + "')]";
		String InternationalFare = "";
		String currency = "xpath://select[@id='ddl_currency']/option[contains(text(),'" + fcurrency + "')]";
		String Domesticstr="";
		double DomesticTotalFare=0;

		QaRobot.impliwait(40);

		QaRobot.ClickOnElement("algosaibi_roundtrip", "Clicked on RoundTrip");

		TestBase.listofautosuggestion(By.xpath("//DIV[@id='divFLDepart']/P"), origin, forigin,
				By.xpath("//input[@id='fromcityAc']"));
		QaRobot.impliwait(10);

		TestBase.listofautosuggestion(By.xpath("//DIV[@id='divFLArrival']/P"), destination, fdestination,
				By.xpath("//input[@id='tocityAc']"));

		QaRobot.impliwait(10);

		// departure date

		QaRobot.ClickOnElement("flight_depart_date", "Clicked on Flight Departure");

		Thread.sleep(500);

		//ClickOnElement("nextmonth_calender", "Clicked on Next Month Button");
		//ClickOnElement("nextmonth_calender", "Clicked on Next Month Button");

		QaRobot.getLocator(departdate).click();// id1252019

		// arrival date
		QaRobot.ClickOnElement("flight_return_date", "Clicked on Flight return date Button");
		Thread.sleep(500);

		QaRobot.getLocator(arrivaldate).click();
		Thread.sleep(500);

		// Pax
		QaRobot.ClickOnElement("algosaibi_pax", "clicked on select PAX");

		// select adult
		driver.findElement(By.xpath("//input[@id='ddlAdultInt']")).clear();
		QaRobot.PassValue("algosaibi_adult", adult, "Selected Adult");

		// select child
		driver.findElement(By.xpath("//input[@id='ddlChildInt']")).clear();
		QaRobot.PassValue("algosaibi_child", child, "Selected Child");

		// select infant
		driver.findElement(By.xpath("//input[@id='ddlInfantInt']")).clear();
		QaRobot.PassValue("algosaibi_infant", infant, "Selected Infant");

//		ClickOnElement("option", "clicked on interface");
//
//		// click on more option
//		ClickOnElement("travelmall_more_option", "clicked on more option");
//
//		// select currency
//
//		ClickOnElement("travelmall_flight_currency", "Selected Currency");
//		getLocator(currency).click();
//
//		// select class
//		ClickOnElement("travelmall_flight_class", "Selected Class");
//		getLocator(Fclass).click();
		
		driver.findElement(By.xpath("(//button[text()='"+ fclass +"'])[1]")).click();

		// PreferedAirline("preferd_airline", airlines, "search_airline");

		// take screenshot for search page


		String searchpage = QaLogger.takeScreenshot(driver, "Search Page");
		test.log(Status.INFO, "Screenshot for Search Page", MediaEntityBuilder.createScreenCaptureFromPath(searchpage).build());

		// click on metabook check
		// driver.findElement(By.xpath("//input[@id='metabook']")).click();
		
		

		// search
		QaRobot.ClickOnElement("algosaibi_search", "Clicked On Search");

		QaRobot.explicitwaitinvisible(180, By.xpath("//*[@class='progress-bar progress-bar-striped active']"));

		// get current url

		String url = driver.getCurrentUrl();

		System.out.println(url);

		String[] uid = url.split("=");

		// System.out.println(id[0]);

		// System.out.println(id[1]);

		test.log(Status.INFO, "Result page url is  " + url);

		test.log(Status.INFO, "Session id is " + uid[1]);

		// If not getting result

		WebElement ResultNotFound = QaRobot.getWebElement("flightresultnotfound");

		if (ResultNotFound.isDisplayed()) {

			try {

				test.log(Status.FAIL, "Result is not found");

				// take screenshot for result page

				String resultnotfound = QaLogger.takeScreenshot(driver, "resultnotfound");
				test.log(Status.INFO, "Screenshot for Resultnotfound", MediaEntityBuilder.createScreenCaptureFromPath(resultnotfound).build());

				test.info(MarkupHelper.createCodeBlock(getLogText("\\\\erp-staging\\Cache\\Booking\\local\\store", uid[1]),
						CodeLanguage.XML));

				QaRobot.ClickOnElement("algosaibi_gohome", "clicked on Home Page");

				System.out.println("Result Not Found");

			} catch (Throwable e) {

				System.out.println(e);
			}
		}

		else {

			// Domestic and International

			boolean international = driver.findElements(By.xpath("//input[starts-with(@id,'Anchor_')]")).size() > 0;

			boolean local = driver.findElements(By.xpath("//*[@id='btnProcess']")).size() > 0;

			if (international) {

				WebElement international_Flights = driver.findElement(By.xpath("//input[starts-with(@id,'Anchor_')]"));

				// take screenshot for International result page

				String resultpage = QaLogger.takeScreenshot(driver, "International Result page");
				test.log(Status.INFO, "Screenshot for InternationalResultpage", MediaEntityBuilder.createScreenCaptureFromPath(resultpage).build());

				// get result page fare

				InternationalFare = QaRobot.getWebElement("result_fare").getText();

				System.out.println("International result fare is " + InternationalFare);

				// fare_breakups(result);

				// Fare_Rule();

				// Flight_Iteneary("anjali.jain@quadlabs.com");

				international_Flights.click();

			} else

			if (local) {

				WebElement local_flight = driver.findElement(By.xpath("//*[@id='btnProcess']"));

				// get result page fare

				String ToatlDomesticfare = QaRobot.getWebElement("domestic_result_fare").getText();

				String[] Domesticfare = ToatlDomesticfare.split(" ");

				System.out.println("Domestic result fare is " + Domesticfare[1]);
				
				int adultvalue = Integer.parseInt(adult);
				int childvalue = Integer.parseInt(child);
				int infantvalue = Integer.parseInt(infant);
				
				double TotalPax = adultvalue + childvalue +infantvalue;
				
				System.out.println("Total Pax is " + TotalPax);
				
				//Total fare for Total Pax
				
				String domestic = Domesticfare[1].replace(",","");
				
				System.out.print(domestic);
				
				double value=Double.parseDouble(domestic);
				
				DomesticTotalFare = value* TotalPax;
				
				System.out.println("multiply value " + DomesticTotalFare);
				
				Domesticstr=Double.toString(DomesticTotalFare);
				
				System.out.println(Domesticstr);
				
				// take screenshot for Domestic result page
				
				String resultpage = QaLogger.takeScreenshot(driver, "Domestic Result page");
				test.log(Status.INFO, "Screenshot for DomesticResultpage", MediaEntityBuilder.createScreenCaptureFromPath(resultpage).build());
				
				local_flight.click();

			}
			QaRobot.explicitwaitvisible(60, By.xpath("//input[@id='ctl00_contentMain_btnSendEnquiry']"));

			// change Selection

			// List<WebElement> change_selection=
			// driver.findElements(By.xpath("//a[@id='ctl00_contentMain_expATag']"));
			//
			// if(change_selection.size() > 0)
			// {
			//
			// driver.findElement(By.xpath("//a[@id='ctl00_contentMain_expATag']")).click();
			// ClickOnElement("flight_book", "Clicked On Book");
			// explicitwaitvisible(60,
			// By.xpath("//a[@id='ctl00_contentMain_clientDetail_lbtnSubmit']"));
			// }

			// compare value of result and checkout before fee on checkout
			// page

			String checkout = QaRobot.getWebElement("checkout_fare").getText();

			System.out.print("checout fare before fee is " + checkout);

			if (Triptype.equalsIgnoreCase("international")) {

				CompareFareValue(InternationalFare, checkout, " checkout page " + checkout);
			}

//			 else {
//
//				CompareFareValue(Domesticstr, checkout, " checkout page " + checkout);
//
//			}

			// client email
			QaRobot.PassValue("client_email", emailid, "Entered Client Email");

			// explicitwaitclickable(400,By.xpath("//input[@id='ctl00_contentMain_btnSubmit']"));

			adultCheckout(Triptype, adult, title, adultfname, adultlname, adultdate, adultmonth, adultyear, adultidno,
					adultisd, adultphone, adultpassprot, adultpassportcomp, adultedate, adultemonth, adulteyear,
					adultnationality);

			childCheckout(Triptype, child, ctitle, childfname, childlname, childdate, childmonth, childyear, childidno,
					childpassprot, childpassportcomp, childedate, childemonth, childeyear, childnationality);

			infantCheckout(Triptype, infant, ititle, infantfname, infantlname, infantdate, infantmonth, infantyear,
					infantidno, infantTravelling, infantpassprot, infantpassportcomp, infantedate, infantemonth,
					infanteyear, infantnationality);

			// DiscountCoupon("discout_textbox", "discount_msg",
			// "discount_amount",
			// couponno,discountvalue);

			// condition for credit and online

			card(cardmode, type, cardno, cardname, cardmonth, cardyear, cardcvv);

			// compare value of payment and checkout value after fee on checkout
			// page

			String checkout1 = QaRobot.getWebElement("checkout_fare").getText();

			System.out.println("checout fare after fee is " + checkout1);

			// compare value of payment and checkout value

			String payment = QaRobot.getWebElement("payment_fare").getText();

			System.out.println("Payment fare is " + payment);

			CompareFareValue(checkout1, payment, " Payment page " + payment);

			Billing(btitle, bfname, blname, baddress, bcity, bcityauto, bstate, bzipcode, bcountry);

			// check terms and condition
			QaRobot.ClickOnElement("check_terms", "Clicked On Terms condition");

			// take screenshot for checkout page

			String checkoutpage = QaLogger.takeScreenshot(driver, "Checkoutpage");
			test.log(Status.INFO, "Screenshot for Checkoutpage", MediaEntityBuilder.createScreenCaptureFromPath(checkoutpage).build());

			// If getting change selection then click on send Enquiry

			WebElement change = driver.findElement(By.xpath("//a[@id='ctl00_contentMain_expATag']"));

			if (change.isDisplayed()) {

				// click send_enquiry button
				QaRobot.ClickOnElement("send_enquiry", "Clicked on sendenquiry button");
				QaRobot.explicitwaitinvisible(250, By.xpath("//div[@class='preloading-image']"));
				String bookingid = QaRobot.getWebElement("booking_no").getText();
				test.log(Status.INFO, "Booking number is " + bookingid);
				System.out.println("Booking Id is " + bookingid);

				// take screenshot sendenquiry
		
				String sendenquiry = QaLogger.takeScreenshot(driver, "sendenquiry");
				test.log(Status.INFO, "Screenshot for Send Enquiry", MediaEntityBuilder.createScreenCaptureFromPath(sendenquiry).build());
				
				QaRobot.ClickOnElement("algosaibi_gohome", "clicked on Home Page");

			} else {

				// click confirm button
				QaRobot.ClickOnElement("confirm", "Clicked on confirm Button");

				QaRobot.explicitwaitinvisible(250, By.xpath("//div[@class='preloading-image']"));

				// Go to home page after getting fraud check

				List<WebElement> fraud_check = driver
						.findElements(By.xpath("//span[@id='ctl00_contentMain_lblErrHeading']"));

				if (fraud_check.size() > 0)

				{
					try {

						test.log(Status.FAIL, "Fraud check is coming after payment");

						// take screenshot for confirm page


						String fraudcheck = QaLogger.takeScreenshot(driver, "fraudcheck");
						test.log(Status.INFO, "Screenshot for Fraud Check", MediaEntityBuilder.createScreenCaptureFromPath(fraudcheck).build());
						test.info(MarkupHelper.createCodeBlock(
								getLogText("\\\\erp-staging\\Cache\\Booking\\local\\store", uid[1]), CodeLanguage.XML));

						QaRobot.ClickOnElement("algosaibi_gohome", "clicked on Home Page");

					} catch (Throwable e) {

						System.out.println(e);
					}
				} else {

					// take screenshot for confirm page

					String confirmpage = QaLogger.takeScreenshot(driver, "confirmpage");
					test.log(Status.INFO, "Screenshot for Confirm Page", MediaEntityBuilder.createScreenCaptureFromPath(confirmpage).build());

					// compare value of payment and Confirm page

					String confirm_page = QaRobot.getWebElement("confirm_fare").getText();

					String ExcludeTotalFare[] = confirm_page.split(" ");

					System.out.println("Confirm fare is " + ExcludeTotalFare[1]);

					CompareFareValue(payment, ExcludeTotalFare[1], " confirm page " + ExcludeTotalFare[1]);

					String bookingid = QaRobot.getWebElement("booking_no").getText();
					test.log(Status.INFO, "Booking number is " + bookingid);
					System.out.println("Booking Id is " + bookingid);
					
						String pnrno = QaRobot.getWebElement("pnr_no").getText();
						test.log(Status.INFO, "PNR number is " + pnrno);
						System.out.println("PNR no is " + pnrno);

						String status = QaRobot.getWebElement("status").getText();
						test.log(Status.INFO, "Booking Status is " + status);
						System.out.println("Booking Status is " + status);
				
					
				}

			}
		}
		
		test.info(MarkupHelper.createCodeBlock(getLogText("\\\\erp-staging\\Cache\\Booking\\local\\store", uid[1]),CodeLanguage.XML));
		QaRobot.ClickOnElement("algosaibi_gohome", "clicked on Home Page");

	}


}
