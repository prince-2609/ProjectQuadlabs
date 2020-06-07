package entities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import TestScript.Travelmall.TravelmallMulticity;
import utilities.Logger;
import utilities.QaRobot;

public class Travelmall_Fmulticity extends TravelmallMulticity {
	
	
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

		QaRobot.ClickOnElement("dep_date1", "Clicked on Flight Departure");
		
		Thread.sleep(500);

		driver.findElement(By.xpath("//a[@class='datepick-cmd datepick-cmd-next ']")).click();
		
		JavascriptExecutor tripDays = (JavascriptExecutor) driver;
		WebElement departdate =driver.findElement(By.id("id"+ddate+""));
        tripDays.executeScript("arguments[0].click();", departdate);
		

		// departure date2
		Thread.sleep(500);
		QaRobot.ClickOnElement("dep_date2", "Clicked on Flight return date Button");
		Thread.sleep(500);
		JavascriptExecutor tripDays1 = (JavascriptExecutor) driver;
		WebElement departdate1 =driver.findElement(By.id("id"+adate+""));
        tripDays1.executeScript("arguments[0].click();", departdate1);
	
		// departure date3
        Thread.sleep(500);
		QaRobot.ClickOnElement("dep_date3", "Clicked on Flight return date Button");
		Thread.sleep(500);
		JavascriptExecutor tripDays2 = (JavascriptExecutor) driver;
		WebElement departdate2 =driver.findElement(By.id("id"+adate1+""));
        tripDays2.executeScript("arguments[0].click();", departdate2);
		

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

//		// click on more option
//		ClickOnElement("travelmall_multimoreoption", "clicked on more option");
//
//		// select class
//		ClickOnElement("travelmall_mclass", "Selected Class");
//		getLocator(Fclass).click();

		// PreferedAirline("preferd_airline", airlines, "search_airline");

		// take screenshot for search page
		
		String searchpage = Logger.takeScreenshot(driver, "Search Page");
		//test.log(Status.INFO, "Screenshot for Search Page");
		//test.addScreenCaptureFromPath(searchpage);
		test.log(Status.INFO, "Screenshot for Search Page", MediaEntityBuilder.createScreenCaptureFromPath(searchpage).build());
		
		// search
		QaRobot.ClickOnElement("travelmall_multisearch", "Clicked On Search");

		QaRobot.explicitwaitinvisible(200, By.xpath("//*[@class='progress-bar progress-bar-striped active']"));

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

				String resultnotfound = Logger.takeScreenshot(driver, "resultnotfound");
				test.log(Status.INFO, "Screenshot for Resultnotfound", MediaEntityBuilder.createScreenCaptureFromPath(resultnotfound).build());
				
				test.info(MarkupHelper.createCodeBlock(getLogText("\\\\erp-staging\\Cache\\Booking\\local\\store", uid[1]),CodeLanguage.XML));

				QaRobot.ClickOnElement("travelmall_gohome", "clicked on Home Page");

				System.out.println("Result Not Found");

			} catch (Throwable e) {

				System.out.println(e);
			}
		}

		else {

			// take screenshot for result page

			String resultpage = Logger.takeScreenshot(driver, "Resultpage");
			test.log(Status.INFO, "Screenshot for Resultpage", MediaEntityBuilder.createScreenCaptureFromPath(resultpage).build());

			// get total amount of result page

			result = QaRobot.getWebElement("result_fare").getText();

			System.out.println("result fare is " + result);

			// fare_breakups(result, "fare breakup");

			// Fare_Rule();

			// Flight_Iteneary("anjali.jain@quadlabs.com");

			QaRobot.ClickOnElement("flight_book", "Clicked On Book");

			QaRobot.explicitwaitvisible(60, By.xpath("//input[@id='ctl00_contentMain_btnSendEnquiry']"));

			// compare value of result and checkout before fee on checkoutpage

			String checkout = QaRobot.getWebElement("checkout_fare").getText();

			System.out.print("checout fare before fee is " + checkout);

			CompareFareValue(result, checkout, " checkout page " + checkout);

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

			String checkoutpage = Logger.takeScreenshot(driver, "Checkoutpage");
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
				String sendenquiry = Logger.takeScreenshot(driver, "sendenquiry");
				test.log(Status.INFO, "Screenshot for Send Enquiry", MediaEntityBuilder.createScreenCaptureFromPath(sendenquiry).build());
				QaRobot.ClickOnElement("travelmall_gohome", "clicked on Home Page");
				

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

						String fraudcheck = Logger.takeScreenshot(driver, "fraudcheck");
						
						test.log(Status.INFO, "Screenshot for Fraud Check", MediaEntityBuilder.createScreenCaptureFromPath(fraudcheck).build());
						
						test.info(MarkupHelper.createCodeBlock(getLogText("\\\\erp-staging\\Cache\\Booking\\local\\store", uid[1]),CodeLanguage.XML));

						QaRobot.ClickOnElement("travelmall_gohome", "clicked on Home Page");

					} catch (Throwable e) {

						System.out.println(e);
					}
				} else {
					
					// take screenshot for confirm page

					String confirmpage = Logger.takeScreenshot(driver, "confirmpage");
					
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
		QaRobot.ClickOnElement("travelmall_gohome", "clicked on Home Page");
	}

}
