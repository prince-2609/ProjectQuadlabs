package product.Flight.suite.Oneway;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Base.TestBase;
import entities.Login;
import utilities.Logger;
import utilities.QaBrowser;
import utilities.QaDataProvider;
import utilities.QaExtentReport;
import utilities.QaRobot;

@Listeners(listenerClass.Listener.class)
public class BookGuestFlight
{
	public static String resultPagePrice;

	@DataProvider
	public Object[][] getexceldata() throws Exception {

		return QaDataProvider.getTestdata("SBT_Flight", "Guest");
	}

	@Test(dataProvider = "getexceldata")
	public static void Sbt_flight_Search(String ccode, String URL,String compCode,String uname, String pwd, String corptraveller,String searchType, String origin,
			String forigin, String destination, String fdesti, String ddate, String triptype, String adult,
			String child, String infant, String currency, String fclass, String preairline,
			String nationality, String booknowindex, String policyindex, String tripindex,String adttitle, String adultfname,
			String adultlname, String adultdate, String adultmonth, String adultyear, String adultgender,
			String adultpassprot, String adultnationality, String adultedate, String adultemonth, String adulteyear,
			String adultpassportcomp,String isd,String phoneNumber, String chdtitle, String childfname, String childlname, String childdate,
			String childmonth, String childyear, String childgender, String childpassprot, String childnationality,
			String childedate, String childemonth, String childeyear, String childpassportcomp, String inftitle,
			String infantfname, String infantlname, String infantdate, String infantmonth, String infantyear,
			String infantgender, String infantTravellingWith, String infantpassprot, String infantnationality,
			String infantedate, String infantemonth, String infanteyear, String infantpassportcomp,String fop, String receiptno, String card, String cardtype,
			String cvv, String resultpagestep, String checkoutPageStep, String airReasonCode) throws Exception {
		
		QaExtentReport.test = QaExtentReport.report.createTest("Test On "+resultpagestep);
		TestBase.Companycode(ccode,URL); 
		QaRobot.impliwait(30);
		// login on sbt
		//Login.V12SbtLogin(compCode,uname, pwd);
		Login.SbtLogin(uname, pwd);
		
		// select the trip type
		QaRobot.ClickOnElement("trip_guest");
		QaExtentReport.test.log(Status.INFO, "<b><i>Search for guest trip</i></b>");
		// select one way trip
		QaRobot.ClickOnElement("ow_onewaytrip");
		QaExtentReport.test.log(Status.INFO, "<b><i>Flight oneway trip</i></b>");
		Thread.sleep(1000);
		
		TestBase.listofautosuggestion(By.xpath("//div[@id='divDepartureCity']/p"), origin, forigin,
				By.xpath("//input[@id='txtDepartureCity']"));
		Thread.sleep(1000);
		QaExtentReport.test.log(Status.INFO, "Departure city : " + forigin);

		Thread.sleep(1000);

		TestBase.listofautosuggestion(By.xpath("//div[@id='divDestinationCity']/p"), destination, fdesti,
				By.xpath("//input[@id='txtDestinationCity']"));
		Thread.sleep(1000);
		QaExtentReport.test.log(Status.INFO, "Arrival city : " + fdesti);

		
		// Thread.sleep(500);
		// click on departure date icon
		QaBrowser.driver.findElement(By.xpath("(//input[@id=\"txtDepartureDate\"]//following::span/img[@class=\"cal_click\"])[1]")).click();
		Thread.sleep(500);
		
		QaRobot.ClickOnElement("Background");
		QaExtentReport.test.log(Status.INFO, "<b><i>Background</i></b>");
		
		// click on next month
		//QaRobot.ClickOnElement("nextmonth_calender", "Clicked  on Next Month Button");
		
		// select the depature date
		QaBrowser.driver.findElement(By.xpath("//a[contains(@title,'" + ddate + "')]")).click();
		QaExtentReport.test.log(Status.INFO, "Depature date : " + ddate);
		
		// Click on travellers
				QaBrowser.driver.findElement(By.xpath("//span[@id='lblTravellers']")).click();

				// select the adult
				QaRobot.selectValueFromDropdown("dept_Adult", adult, "Select adult for booking");

				// select the child
				QaRobot.selectValueFromDropdown("dept_Child", child, "Select child for booking");

				// select the infant
				QaRobot.selectValueFromDropdown("dept_Infant", infant, "Select infant for booking");
				
				// click on dom
				QaBrowser.driver.findElement(By.xpath("//p[@class='m-b-0']")).click();


		// check the policy checkbox
		SearchDashboard.FlightpolicyCheck();
		// click on search flight button
		  QaRobot.ClickOnElement("ow_searchflight");
		  QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on search flight button</i></b>");

		  Thread.sleep(30000);
		// explicit wait till loader invisible
//		QaRobot.explicitwaitinvisible(400, By.xpath("//div[@class='flight-wait-progress progress ng-hide']"));
	

		if (QaBrowser.driver.findElement(By.xpath("//p[contains(text(),'Sorry, could not find desired results. Please try again.')]")).isDisplayed()) {
			// fail the test case and screenshot
//			String resultnotfound = Logger.takeScreenshot(QaBrowser.driver, "D:\\Screenshot\\resultnotfound.png");
//			QaExtentReport.test.log(Status.FAIL, "Results are not found");
		} else {

			// screenshot of result page
//			String resultpage = Logger.takeScreenshot(QaBrowser.driver, "D:\\Screenshot\\resultpage.png");
//			QaExtentReport.test.log(Status.INFO, "Result Page " + resultpage + "");
			// get current url

			String url = QaBrowser.driver.getCurrentUrl();

			System.out.println(url);

			String[] uid = url.split("=");

			System.out.println("SEssion id " + uid[1]);

			QaExtentReport.test.log(Status.INFO, "Result page url is  " + url);

			QaExtentReport.test.log(Status.INFO, "Session id is " + uid[1]);

			// get price of result page
			resultPagePrice = QaBrowser.driver.findElement(By.xpath("(//div[@class='fl_price_fmt']/p[2]/span/span[2])[" + tripindex + "]"))
					.getText();
			System.out.println("Result page price is " + resultPagePrice);
			QaExtentReport.test.log(Status.INFO, "Result page price is " + resultPagePrice);

			// get text of element that start start from 1
			String policytype = QaBrowser.driver.findElement(By.xpath("(//span[contains(@id,'PT_')])[" + policyindex + "]")).getText();
			
			if (resultpagestep.equalsIgnoreCase("Trip Request")) {
				// Send Quotation
				SBTResultPage.tripRequest(tripindex, resultPagePrice, policytype);

			} else if (resultpagestep.equalsIgnoreCase("Flight Book")) {
				// click on book now button with indexing
				QaBrowser.driver.findElement(By.xpath("(//input[contains(@id,'Anchor_')])[" + booknowindex + "]")).click();
				// check In policy and out policy text
				if (policytype.equalsIgnoreCase("Out Of Policy")) {

					QaBrowser.driver.switchTo().alert().accept();
				}
				
				checkoutpage(checkoutPageStep,adult,adttitle,adultfname,adultlname,adultdate,adultmonth,adultyear,adultgender,
						adultpassprot,adultnationality,adultedate,adultemonth,adulteyear,adultpassportcomp,isd,phoneNumber,child,chdtitle,
						childfname,childlname,childyear,childmonth,childdate,childgender,childpassprot,childnationality,childedate,
						childemonth,childeyear,childpassportcomp,infant,inftitle,infantfname,infantlname,infantyear,infantmonth,
						infantdate,infantgender,infantTravellingWith,infantpassprot,infantnationality,infantedate,infantemonth,
						infanteyear,infantpassportcomp,airReasonCode,fop,receiptno,card,cardtype,cvv);
			}
		}
	}

	@AfterTest
	public static void After_Test() {

		QaExtentReport.test.getExtent().flush();

	}
	
	public static void checkoutpage(String checkoutPageStep,String adult,String adttitle,String adultfname,String adultlname,String adultdate,String adultmonth,
			String adultyear,String adultgender,String adultpassprot,String adultnationality,String adultedate,String adultemonth,String adulteyear,
			String adultpassportcomp,String isd,String phoneNumber,String child,String chdtitle,String childfname,String childlname, String childyear,String  childmonth,
			String childdate,String childgender,String childpassprot,String childnationality,String childedate,String childemonth,String childeyear,
			String childpassportcomp,String infant,String inftitle,String infantfname,String infantlname,String infantyear,String infantmonth,String infantdate,String infantgender,String infantTravellingWith,String infantpassprot,String infantnationality,
			String infantedate,String infantemonth,String infanteyear,String infantpassportcomp,String airReasonCode,String fop,String receiptno,String card,String cardtype,String cvv) throws Exception 
	{
		// if getting change selction on check out page
		if (QaBrowser.driver.findElement(By.xpath("//a[@id='ctl00_contentMain_expATag']")).isDisplayed()) {
			QaExtentReport.test.log(Status.FAIL, "Geeting change selection");
		} else {
			// explicit wait till terms and condition check box visible
//			QaRobot.explicitwaitvisible(180, By.xpath("//input[@id='ctl00_contentMain_chkTerms']"));
			// screenshot of checkout page
			String checkoutpage = Logger.takeScreenshot(QaBrowser.driver, "D:\\Screenshot\\checkoutpage.png");
			QaExtentReport.test.log(Status.INFO, "Successful Booking " + checkoutpage + "");
			// get the checkout page booking price
			String checkoutprice = QaBrowser.driver.findElement(By.xpath("//span[@id='ctl00_contentMain_totcashPrice']")).getText();
			System.out.println("Price of checkout page " + checkoutprice);
			QaExtentReport.test.log(Status.INFO, "Price of checkout page " + checkoutprice + "");
			
			
			SBTCheckoutPayment.GuestAdultCheckout(adult, adttitle, adultfname, adultlname, adultdate, adultmonth,
					adultyear, adultgender, adultpassprot, adultnationality, adultedate, adultemonth, adulteyear,
					adultpassportcomp,isd,phoneNumber);
			SBTCheckoutPayment.PersonalChildCheckout(child, chdtitle, childfname, childlname, childyear, childmonth,
					childdate, childgender, childpassprot, childnationality, childedate, childemonth, childeyear,
					childpassportcomp);
			SBTCheckoutPayment.PersonalInfantCheckout(infant, inftitle, infantfname, infantlname, infantyear,
					infantmonth, infantdate, infantgender, infantTravellingWith, infantpassprot, infantnationality,
					infantedate, infantemonth, infanteyear, infantpassportcomp);

		
			if (checkoutPageStep.equalsIgnoreCase("Quote")) {
				SBTCheckoutPayment.checkoutFlightQuote(airReasonCode);

			} else if (checkoutPageStep.equalsIgnoreCase("Fullfillment")) {
				
				//select the air reason code
				QaRobot.selectTextFromDropdown("airReasonCodeOnCheckout", airReasonCode,"Selected air reason code " +airReasonCode);
				// check the terms and condition checkbox
				QaRobot.ClickOnElement("ow_chkterms");
				QaExtentReport.test.log(Status.INFO, "<b><i>check the terms and condition</i></b>");
				// proceed the booking from checkout page
				QaRobot.ClickOnElement("ow_chkbook");
				QaExtentReport.test.log(Status.INFO, "<b><i>book button to proceed the booking from checkout page</i></b>");
				// accept alert to proceed from checkout page
				QaBrowser.driver.switchTo().alert().accept();
				// wait till payment page display
//				QaRobot.explicitwaitvisible(300, By.xpath("//div[@id='ctl00_contentMain_div_Heading']"));
				// screenshot of Payment page
				String paymentpage = Logger.takeScreenshot(QaBrowser.driver, "D:\\Screenshot\\paymentpage.png");
				QaExtentReport.test.log(Status.INFO, "Successful Booking " + paymentpage + "");

				// get the payment page booking price
				String paymentprice = QaBrowser.driver.findElement(By.xpath("//span[@id='ctl00_contentMain_lblTAmt']")).getText();
				System.out.println("Price of payment page " + paymentprice);
				QaExtentReport.test.log(Status.INFO, "Price of payment page " + paymentprice + "");
				// select FOP
				if (fop.equalsIgnoreCase("Cash")) {
					SBTCheckoutPayment.fopCash(fop, receiptno);
				} else {
					SBTCheckoutPayment.fopCreditDebit(card, cardtype, cvv);
				}
				QaRobot.ClickOnElement("ow_paymentprocced");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on procced button</i></b>");
				Thread.sleep(2000);
				// screenshot of Confirmation page
//				String confirmpage = Logger.takeScreenshot(QaBrowser.driver, "D:\\Screenshot\\confirmpage.png");
//				QaExtentReport.test.log(Status.INFO, "Successful Booking " + confirmpage + "");

				// booking status
				String bookingStatus = QaBrowser.driver.findElement(By.xpath("//span[@class='nc_status_color']")).getText();
				System.out.println("Booking Status is " + bookingStatus);
				QaExtentReport.test.log(Status.INFO, "Booking Status is  " + bookingStatus);
				// Confirmation code
				String pnr = QaBrowser.driver.findElement(By.xpath("//p[@class='nc_status_p']")).getText();
				System.out.println("PNR is " + pnr);
				QaExtentReport.test.log(Status.INFO, "PNR is  " + pnr);
				// Confirm page price
				String confirmePrice = QaBrowser.driver.findElement(By.xpath("(//div[@class='nc_fcelllast'])[3]")).getText();
				System.out.println("Confirm Page Price is " + confirmePrice);
				QaExtentReport.test.log(Status.INFO, "Confirm Page Price is  " + confirmePrice);
				// Booking id
				String bookingID = QaBrowser.driver.findElement(By.xpath("//span[@class='nc_bookid_no']")).getText();
				System.out.println("Booking ID is " + bookingID);
				QaExtentReport.test.log(Status.INFO, "Booking ID is  " + bookingID);

			}
		}
	}
	

}
