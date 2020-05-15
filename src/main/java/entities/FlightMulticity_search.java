package entities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import TestScript.Multicity.FlightMulticity;
import utilities.QaLogger;
import utilities.QaRobot;

public class FlightMulticity_search extends FlightMulticity {

	public static void flightMulticity_search(String ddate, String adate, String adate1, String Triptype, String adult,
			String child, String infant, String fclass, String airlines, String emailid, String title,
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

		//String departdate1 = "id:id" + ddate;// id:id1252019
		//String departdate2 = "id:id" + adate;
		//String departdate3 = "id:id" + adate1;
		// String Adult = "xpath://div[@id='adultMultiDiv']//li[@value='" +
		// adult + "']";
		// String Child = "xpath://div[@id='childMultiDiv']//li[@value='" +
		// child + "']";
		// String Infant = "xpath://div[@id='infantMultiDiv']//li[@value='" +
		// infant + "']";
		String Fclass = "xpath://select[@id='DDLCabinClass_Multicity']/option[contains(text(),'" + fclass + "')]";
		String result = "";

		// departure date1
		

		QaRobot.explicitwaitinvisible(30, By.xpath("//DIV[@id='dynamultiarr3']/P"));
		
		Thread.sleep(500);

		QaRobot.ClickOnElement("dep_date1", "Clicked on Flight Departure");
		
		Thread.sleep(500);

		driver.findElement(By.xpath("//a[@title='Show the next month']")).click();
		
		JavascriptExecutor tripDays = (JavascriptExecutor) driver;
		WebElement departdate =driver.findElement(By.id("id"+ddate+""));
        tripDays.executeScript("arguments[0].click();", departdate);
		

		// departure date2
		Thread.sleep(500);
		QaRobot.ClickOnElement("dep_date2", "Clicked on Flight return date Button");
		QaRobot.explicitwaitinvisible(10, By.id("id182020"));
		JavascriptExecutor tripDays1 = (JavascriptExecutor) driver;
		WebElement departdate1 =driver.findElement(By.id("id"+adate+""));
        tripDays1.executeScript("arguments[0].click();", departdate1);
	
       Thread.sleep(500);
        
		// departure date3
        QaRobot.explicitwaitinvisible(10, By.id("id182019"));
		QaRobot.ClickOnElement("dep_date3", "Clicked on Flight return date Button");
		QaRobot.explicitwaitinvisible(10, By.id("id182020"));
		JavascriptExecutor tripDays2 = (JavascriptExecutor) driver;
		WebElement departdate2 =driver.findElement(By.id("id"+adate1+""));
        tripDays2.executeScript("arguments[0].click();", departdate2);
		
        Thread.sleep(500);

		// Pax
        Thread.sleep(500);
		QaRobot.ClickOnElement("select_mulpax", "clicked on select PAX");

		// select adult
		QaRobot.selectValueFromDropdown("flight_multiadult", adult, "Selected Adult");

		// select child
		QaRobot.selectValueFromDropdown("flight_multichild", child, "Selected Child");

		// select infant
		QaRobot.selectValueFromDropdown("flight_multiinfant", infant, "Selected Infant");

		QaRobot.ClickOnElement("option", "clicked on interface");

		// click on more option
		QaRobot.ClickOnElement("multi_option", "clicked on more option");

		// select class
		QaRobot.ClickOnElement("flight_mclass", "Selected Class");
		QaRobot.getLocator(Fclass).click();

		// PreferedAirline("preferd_airline", airlines, "search_airline");

		// take screenshot for search page
		
		String searchpage = QaLogger.takeScreenshot(driver, "Search Page");
		//test.log(Status.INFO, "Screenshot for Search Page");
		//test.addScreenCaptureFromPath(searchpage);
		test.log(Status.INFO, "Screenshot for Search Page", MediaEntityBuilder.createScreenCaptureFromPath(searchpage).build());
		
		// search
		QaRobot.ClickOnElement("flight_msearch", "Clicked On Serach");
		
		
		//Total time for page load
		
		long start = System.currentTimeMillis();
				
		System.out.println("Start time - " + start); 
		
		QaRobot.explicitwaitinvisible(280, By.xpath("//*[@class='progress-bar progress-bar-striped active']"));

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

			// fare_breakups(result, "fare breakup");

			// Fare_Rule();

			// Flight_Iteneary("anjali.jain@quadlabs.com");

			QaRobot.ClickOnElement("flight_book", "Clicked On Book");

			QaRobot.explicitwaitvisible(60, By.xpath("//input[@id='ctl00_contentMain_btnSubmit']"));

			// compare value of result and checkout before fee on checkoutpage

			String checkout = QaRobot.getWebElement("checkout_fare").getText();

			System.out.print("checout fare before fee is " + checkout);

			//CompareFareValue(result, checkout, " checkout page " + checkout);

			// client email
			QaRobot.PassValue("client_email", emailid, "Entered "+emailid+" Client Email");

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
			
			
			//flight information for RoundTrip outbound
			
			String details = QaRobot.getWebElement("flight_paxdetails").getText();
			System.out.println("Pax Details for multicity trip -> "  + details);
			test.log(Status.INFO,"Pax Details for multicity trip ->  "  + details);
			
			String airline = QaRobot.getWebElement("flight_airline").getText();
			System.out.println("Flight Airline for multicity trip  -> "  + airline);
			test.log(Status.INFO,"Flight Airline for multicity trip -> "  + airline);
			
			String outbound = QaRobot.getWebElement("flight_outbound").getText();
			System.out.println("Trip Type ->  "  + outbound);
			test.log(Status.INFO,"Trip Type ->  "  + outbound);
			
			String deptname = QaRobot.getWebElement("flight_dept").getText();
			System.out.println("Flight Departure for multicity trip ->  " + deptname);
			test.log(Status.INFO,"Flight Departure for multicity trip -> "  + deptname);
			
			String depttime = QaRobot.getWebElement("flight_depttime").getText();
			System.out.println("Flight departur time for multicity trip -> "  + depttime);
			test.log(Status.INFO,"Flight departur time for multicity trip -> "  + depttime);
			
			String arrname = QaRobot.getWebElement("flight_arrival").getText();
			System.out.println("Flight Arrival for multicity trip ->  "  + arrname);
			test.log(Status.INFO,"Flight Arrival for multicity trip ->  "  + arrname);
			
			String arrtime = QaRobot.getWebElement("flight_arrtime").getText();
			System.out.println("Flight Arrival time for multicity trip ->  "  + arrtime);
			test.log(Status.INFO,"Flight Arrival time for multicity trip ->  "  + arrtime);
			
			String chkclass = QaRobot.getWebElement("flight_chkclass").getText();
			System.out.println("Flight Class for multicity trip ->  "  + chkclass);
			test.log(Status.INFO,"Flight Class for multicity trip ->  "  + chkclass);
			
			String aircrafttype = QaRobot.getWebElement("flight_aircraft").getText();
			System.out.println("Flight Air craft Type for multicity trip ->  "  + aircrafttype);
			test.log(Status.INFO,"Flight Air craft Type for multicity trip ->  "  + aircrafttype);
			
			String airnumber = QaRobot.getWebElement("flight_number").getText();
			System.out.println("Flight Number for multicity trip ->  "  + airnumber);
			test.log(Status.INFO,"Flight Number for multicity trip ->  "  + airnumber);
			
			String duration = QaRobot.getWebElement("flight_durationtime").getText();
			System.out.println("Flight Duration for multicity trip ->  "  + duration);
			test.log(Status.INFO,"Flight Duration for multicity trip ->  "  + duration);
			
			
			//flight information for Outbound
			
			
			String rairline = QaRobot.getWebElement("flight_rairline").getText();
			System.out.println("Flight Airline for multicity trip  -> "  + rairline);
			test.log(Status.INFO,"Flight Airline for multicity trip -> "  + rairline);
			
			String routbound = QaRobot.getWebElement("flight_routbound").getText();
			System.out.println("Trip Type  ->  "  + routbound);
			test.log(Status.INFO,"Trip Type ->  "  + routbound);
			
			String rdeptname = QaRobot.getWebElement("flight_rdept").getText();
			System.out.println("Flight Departure for multicity trip ->  " + rdeptname);
			test.log(Status.INFO,"Flight Departure for multicity trip -> "  + rdeptname);
			
			String rdepttime = QaRobot.getWebElement("flight_rdepttime").getText();
			System.out.println("Flight departur time for multicity trip -> "  + rdepttime);
			test.log(Status.INFO,"Flight departur time for multicity trip -> "  + rdepttime);
			
			String rarrname = QaRobot.getWebElement("flight_rarrival").getText();
			System.out.println("Flight Arrival for multicity trip ->  "  + rarrname);
			test.log(Status.INFO,"Flight Arrival for multicity trip ->  "  + rarrname);
			
			String rarrtime = QaRobot.getWebElement("flight_rarrtime").getText();
			System.out.println("Flight Arrival time for multicity trip ->  "  + rarrtime);
			test.log(Status.INFO,"Flight Arrival time for multicity trip ->  "  + rarrtime);
			
			String rchkclass = QaRobot.getWebElement("flight_rchkclass").getText();
			System.out.println("Flight Class for multicity trip ->  "  + rchkclass);
			test.log(Status.INFO,"Flight Class for multicity trip ->  "  + rchkclass);
			
			String raircrafttype = QaRobot.getWebElement("flight_raircraft").getText();
			System.out.println("Flight Air craft Type for multicity trip ->  "  + raircrafttype);
			test.log(Status.INFO,"Flight Air craft Type for multicity trip ->  "  + raircrafttype);
			
			String rairnumber = QaRobot.getWebElement("flight_rnumber").getText();
			System.out.println("Flight Number for multicity trip ->  "  + rairnumber);
			test.log(Status.INFO,"Flight Number for multicity trip ->  "  + rairnumber);
			
			String rduration = QaRobot.getWebElement("flight_rdurationtime").getText();
			System.out.println("Flight Duration for multicity trip ->  "  + rduration);
			test.log(Status.INFO,"Flight Duration for multicity trip ->  "  + rduration);
			
			//flight information for Outbound
			
			
			String mairline = QaRobot.getWebElement("flight_mairline").getText();
			System.out.println("Flight Airline for multicity trip  -> "  + mairline);
			test.log(Status.INFO,"Flight Airline for multicity trip -> "  + mairline);
			
			String moutbound = QaRobot.getWebElement("flight_moutbound").getText();
			System.out.println("Trip Type  ->  "  + moutbound);
			test.log(Status.INFO,"Trip Type ->  "  + moutbound);
			
			String mdeptname = QaRobot.getWebElement("flight_mdept").getText();
			System.out.println("Flight Departure for multicity trip ->  " + mdeptname);
			test.log(Status.INFO,"Flight Departure for multicity trip -> "  + mdeptname);
			
			String mdepttime = QaRobot.getWebElement("flight_mdepttime").getText();
			System.out.println("Flight departur time for multicity trip -> "  + mdepttime);
			test.log(Status.INFO,"Flight departur time for multicity trip -> "  + mdepttime);
			
			String marrname = QaRobot.getWebElement("flight_marrival").getText();
			System.out.println("Flight Arrival for multicity trip ->  "  + marrname);
			test.log(Status.INFO,"Flight Arrival for multicity trip ->  "  + marrname);
			
			String marrtime = QaRobot.getWebElement("flight_marrtime").getText();
			System.out.println("Flight Arrival time for multicity trip ->  "  + marrtime);
			test.log(Status.INFO,"Flight Arrival time for multicity trip ->  "  + marrtime);
			
			String mchkclass = QaRobot.getWebElement("flight_mchkclass").getText();
			System.out.println("Flight Class for multicity trip ->  "  + mchkclass);
			test.log(Status.INFO,"Flight Class for multicity trip ->  "  + mchkclass);
			
			String maircrafttype = QaRobot.getWebElement("flight_maircraft").getText();
			System.out.println("Flight Air craft Type for multicity trip ->  "  + maircrafttype);
			test.log(Status.INFO,"Flight Air craft Type for multicity trip ->  "  + maircrafttype);
			
			String mairnumber = QaRobot.getWebElement("flight_mnumber").getText();
			System.out.println("Flight Number for multicity trip ->  "  + mairnumber);
			test.log(Status.INFO,"Flight Number for multicity trip ->  "  + mairnumber);
			
			String mduration = QaRobot.getWebElement("flight_mdurationtime").getText();
			System.out.println("Flight Duration for multicity trip ->  "  + mduration);
			test.log(Status.INFO,"Flight Duration for multicity trip ->  "  + mduration);
			
			

			// compare value of payment and checkout value

			String payment = QaRobot.getWebElement("payment_fare").getText();

			System.out.println("Payment fare is " + payment);

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
		
		test.info(MarkupHelper.createCodeBlock(getLogText("\\\\erp-staging\\Cache\\Booking\\local\\store", uid[1]),CodeLanguage.XML));
		QaRobot.ClickOnElement("Go_Home", "clicked on Home Page");
	}
}
