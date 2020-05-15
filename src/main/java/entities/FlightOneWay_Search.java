 package entities;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;


import TestScript.OneWay.FlightOneWay;
import utilities.QaLogger;
import utilities.QaRobot;

public class FlightOneWay_Search extends FlightOneWay {

	@SuppressWarnings("deprecation")
	public static void flight_search(String ddate, String Triptype, String adult, String child, String infant,
			String fcurrency, String fclass, String airlines, String emailid, String title, String adultfname,
			String adultmname, String adultlname, String adultdate, String adultmonth, String adultyear,
			String adultidno, String adultisd, String adultphone, String adultpassprot, String adultpassportcomp,
			String adultedate, String adultemonth, String adulteyear, String adultnationality, String ctitle,
			String childfname, String childlname, String childdate, String childmonth, String childyear,
			String childidno, String childpassprot, String childpassportcomp, String childedate, String childemonth,
			String childeyear, String childnationality, String ititle, String infantfname, String infantlname,
			String infantdate, String infantmonth, String infantyear, String infantidno, String infantTravelling,
			String infantpassprot, String infantpassportcomp, String infantedate, String infantemonth,
			String infanteyear, String infantnationality, String btitle, String bfname, String blname, String baddress,
			String bcity, String bcityauto, String bstate, String bzipcode, String bcountry, String cardmode,
			String type, String cardno, String cardname, String cardmonth, String cardyear, String cardcvv,
			String cardpwd, String couponno, String discountvalue) throws Exception {

		String departdate = "id:id" + ddate;// id:id1252019
		String Fclass = "xpath://select[@id='ddl_class']/option[contains(text(),'" + fclass + "')]";
		String result = "";
		String currency = "xpath://select[@id='ddl_currency']/option[contains(text(),'" + fcurrency + "')]";

		// departure date
		
		Thread.sleep(500);
		QaRobot.ClickOnElement("flight_depart_date", "Clicked on Flight Departure");

		Thread.sleep(500);

		//ClickOnElement("nextmonth_calender", "Clicked on Next Month Button");
		// ClickOnElement("nextmonth_calender", "Clicked on Next Month Button");

		QaRobot.getLocator(departdate).click();// id1252019
		
		Thread.sleep(500);

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

		// take screenshot for search page

		String searchpage = QaLogger.takeScreenshot(driver, "Search Page");
		//test.log(Status.INFO, "Screenshot for Search Page");
		//test.addScreenCaptureFromPath(searchpage);
		test.log(Status.INFO, "Screenshot for Search Page", MediaEntityBuilder.createScreenCaptureFromPath(searchpage).build());

		// search
		QaRobot.ClickOnElement("flight_rsearch", "Clicked On Serach");
		
		//Total time for page load
		
		long start = System.currentTimeMillis();
				
		System.out.println("Start time - " + start); 

		QaRobot.explicitwaitinvisible(240, By.xpath("//*[@class='progress-bar progress-bar-striped active']"));
		
		//get current url
		
		String url= driver.getCurrentUrl();
		
		System.out.println(url);
		
		String[] uid = url.split("=");
		
		//System.out.println(id[0]);
		
		//System.out.println(id[1]);
		
		test.log(Status.INFO, "Result page url is  " + url);
		
		test.log(Status.INFO, "Session id is " + uid[1]);
		
		// If not getting result

//		WebElement ResultNotFound = getWebElement("flightresultnotfound");
		List<WebElement> ResultNotFound = driver
				.findElements(By.xpath("//*[text()='Oops! Seems like no flight journeys are available for the selected serach criteria.']"));

		if (ResultNotFound.size() > 0) {

			try {
				
				test.log(Status.FAIL, "Result is not found");
				
				// take screenshot for result page

				String resultnotfound = QaLogger.takeScreenshot(driver, "resultnotfound");
				test.log(Status.INFO, "Screenshot for Resultnotfound", MediaEntityBuilder.createScreenCaptureFromPath(resultnotfound).build());

				test.info(MarkupHelper.createCodeBlock(getLogText("\\\\erp-staging\\Cache\\Booking\\local\\store", uid[1]),CodeLanguage.XML));						

				QaRobot.ClickOnElement("Go_Home", "clicked on Home Page");
				
				System.out.println("Result Not Found");

			} catch (Throwable e) {

				System.out.println(e);
			}
		}

		else {
			
			
			long finish = System.currentTimeMillis();
			
			
			System.out.println("Finish time - " + finish); 
			
			long totalTime = finish - start; 
			
			long totaltime_s= totalTime / 1000;
			
			System.out.println("Total time for loading results - " + totaltime_s + " Second "); 
			
			test.log(Status.INFO, "Total time for loading results - " + totaltime_s + " Second ");


			// take screenshot for result page

			String resultpage = QaLogger.takeScreenshot(driver, "Resultpage");
			test.log(Status.INFO, "Screenshot for Resultpage", MediaEntityBuilder.createScreenCaptureFromPath(resultpage).build());

			// get total amount of result page

			result = QaRobot.getWebElement("result_fare").getText();

			System.out.println("result fare is " + result);
			test.log(Status.INFO, "result fare is " + result);

			 //fare_breakups(result);

			 //Fare_Rule();

			 //Flight_Iteneary("anjali.jain@quadlabs.com");

			// book

			QaRobot.ClickOnElement("flight_book", "Clicked On Book");

			QaRobot.explicitwaitvisible(340, By.xpath("//a[@id='aTermCond']"));

			QaRobot.impliwait(30);

			// compare value of result and checkout before fee on checkout
			// page

			String checkout = QaRobot.getWebElement("checkout_fare").getText();

			System.out.print("checout fare before fee is " + checkout);
			
			test.log(Status.INFO,"checout fare before fee is " + checkout);

			//CompareFareValue(result, checkout, " checkout page " + checkout);

			// client email
			QaRobot.PassValue("client_email", emailid, "Entered  " +emailid+" Client Email");

			// explicitwaitclickable(400,By.xpath("//input[@id='ctl00_contentMain_btnSubmit']"));

			adultCheckout(Triptype, adult, title, adultfname, adultlname, adultdate, adultmonth, adultyear, adultidno,
					adultisd, adultphone, adultpassprot, adultpassportcomp, adultedate, adultemonth, adulteyear,
					adultnationality);

			childCheckout(Triptype, child, ctitle, childfname, childlname, childdate, childmonth, childyear, childidno,
					childpassprot, childpassportcomp, childedate, childemonth, childeyear, childnationality);

			infantCheckout(Triptype, infant, ititle, infantfname, infantlname, infantdate, infantmonth, infantyear,
					infantidno, infantTravelling, infantpassprot, infantpassportcomp, infantedate, infantemonth,
					infanteyear, infantnationality);

			// DiscountCoupon("discout_textbox", "discount_msg","discount_amount", couponno,discountvalue);

			//condition for credit and online
			card(cardmode, type, cardno, cardname, cardmonth, cardyear, cardcvv);

			// compare value of payment and checkout value after fee on checkout
			// page

			String checkout1 = QaRobot.getWebElement("checkout_fare").getText();

			System.out.println("checout fare after fee is " + checkout1);
			
			test.log(Status.INFO,"checout fare after fee is " + checkout1);
			
			//flight information for One way trip
			
			String details = QaRobot.getWebElement("flight_paxdetails").getText();
			System.out.println("Pax Details for One Way trip -> "  + details);
			test.log(Status.INFO,"Pax Details for One Way trip ->  "  + details);
			
			String airline = QaRobot.getWebElement("flight_airline").getText();
			System.out.println("Flight Airline for One Way trip  -> "  + airline);
			test.log(Status.INFO,"Flight Airline for One Way trip -> "  + airline);
			
			String outbound = QaRobot.getWebElement("flight_outbound").getText();
			System.out.println("Trip Type ->  "  + outbound);
			test.log(Status.INFO,"Trip Type ->  "  + outbound);
			
			String deptname = QaRobot.getWebElement("flight_dept").getText();
			System.out.println("Flight Departure for One Way trip ->  " + deptname);
			test.log(Status.INFO,"Flight Departure for One Way trip -> "  + deptname);
			
			String depttime = QaRobot.getWebElement("flight_depttime").getText();
			System.out.println("Flight departur time for One Way trip -> "  + depttime);
			test.log(Status.INFO,"Flight departur time for One Way trip -> "  + depttime);
			
			String arrname = QaRobot.getWebElement("flight_arrival").getText();
			System.out.println("Flight Arrival for One Way trip ->  "  + arrname);
			test.log(Status.INFO,"Flight Arrival for One Way trip ->  "  + arrname);
			
			String arrtime = QaRobot.getWebElement("flight_arrtime").getText();
			System.out.println("Flight Arrival time for One Way trip ->  "  + arrtime);
			test.log(Status.INFO,"Flight Arrival time for One Way trip ->  "  + arrtime);
			
			String chkclass = QaRobot.getWebElement("flight_chkclass").getText();
			System.out.println("Flight Class for One Way trip ->  "  + chkclass);
			test.log(Status.INFO,"Flight Class for One Way trip ->  "  + chkclass);
			
			String aircrafttype = QaRobot.getWebElement("flight_aircraft").getText();
			System.out.println("Flight Air craft Type for One Way trip ->  "  + aircrafttype);
			test.log(Status.INFO,"Flight Air craft Type for One Way trip ->  "  + aircrafttype);
			
			String airnumber = QaRobot.getWebElement("flight_number").getText();
			System.out.println("Flight Number for One Way trip ->  "  + airnumber);
			test.log(Status.INFO,"Flight Number for One Way trip ->  "  + airnumber);
			
			String duration = QaRobot.getWebElement("flight_durationtime").getText();
			System.out.println("Flight Duration for One Way trip ->  "  + duration);
			test.log(Status.INFO,"Flight Duration for One Way trip ->  "  + duration);
			
		
			// compare value of payment and checkout value

			String payment = QaRobot.getWebElement("payment_fare").getText();

			System.out.println("Payment fare is " + payment);
			
			test.log(Status.INFO,"Payment fare is " + payment);

			//CompareFareValue(checkout1, payment, " Payment page " + payment);
			

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
				QaRobot.ClickOnElement("Go_Home", "clicked on Home Page");
				
			} else {

				// click confirm button
				QaRobot.ClickOnElement("confirm", "Clicked on confirm Button");

				QaRobot.explicitwaitinvisible(150, By.xpath("//div[@class='preloading-image']"));

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
						test.info(MarkupHelper.createCodeBlock(getLogText("\\\\erp-staging\\Cache\\Booking\\local\\store", uid[1]),CodeLanguage.XML));						
						QaRobot.ClickOnElement("Go_Home", "clicked on Home Page");
						
						
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

					String status = QaRobot.getWebElement("status").getText();
					test.log(Status.INFO, "Booking Status is " + status);
					System.out.println("Booking Status is " + status);
					
					if(status.equalsIgnoreCase("confirmed"))
					{

						String pnrno = QaRobot.getWebElement("pnr_no").getText();
						test.log(Status.INFO, "PNR number is " + pnrno);
						System.out.println("PNR no is " + pnrno);
					}	
					else
					{
						test.log(Status.INFO, "PNR not created because booking dropped UC ");
						System.out.println("PNR not created because booking dropped UC ");
					}
					
				}
			}
		}
		
		//Attached Log
		
//		List<File> ListOfLogFile=getLogText1("\\\\release\\QuadXchange\\COM\\Logs\\BookingEngine\\DT\\AirSearch\\SABRE",uid[1]);
//		for(File Onelogfile:ListOfLogFile)
//		{
//			test.info("LogFileForFlight " + Onelogfile.getAbsolutePath());
//			test.info(MarkupHelper.createCodeBlock(FileUtils.readFileToString(Onelogfile)));
//	}
		test.info(MarkupHelper.createCodeBlock(getLogText("\\\\erp-staging\\Cache\\Booking\\local\\store", uid[1]),CodeLanguage.XML));
		QaRobot.ClickOnElement("Go_Home", "clicked on Home Page");
	}

}
