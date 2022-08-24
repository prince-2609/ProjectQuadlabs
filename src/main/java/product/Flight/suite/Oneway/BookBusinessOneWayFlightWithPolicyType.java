package product.Flight.suite.Oneway;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Base.TestBase;
import utilities.Logger;
import utilities.QaBrowser;
import utilities.QaDataProvider;
import utilities.QaExtentReport;
import utilities.QaRobot;

@Listeners(listenerClass.Listener.class)
public class BookBusinessOneWayFlightWithPolicyType
{
	public static String resultPagePrice;

	@DataProvider
	public Object[][] getexceldata() throws Exception {

		return QaDataProvider.getTestdata("SBT_Flight", "FlightBookingWithPolicyType");
	}

	@Test(dataProvider = "getexceldata")
	public static void Sbt_flight_Search(String ccode, String URL, String compCode, String uname, String pwd,
			String corptraveller, String searchType, String origin, String forigin, String destination, String fdesti,
			String ddate, String triptype, String adult, String child, String infant, String currency, String fclass,
			String preairline, String nationality,String policy, String passportnumber,
			String fop, String receiptno, String card, String cardtype, String cvv, String airReasonCode)
			throws Exception {
		
		QaExtentReport.test = QaExtentReport.report.createTest("Test On Book Business OneWay Flight With Policy Type " + policy);
		TestBase.Companycode(ccode,URL); 
		QaRobot.impliwait(30);
		// write comapny code
		// login on sbt
//		Login.V12SbtLogin(compCode, uname, pwd);
		// Login.SbtLogin(uname, pwd);

		// close notification
		// QaBrowser.driver.findElement(By.xpath("//a[@id='btnClosePopUpNotification']")).click();
		
		QaRobot.PassValue("User_name",uname);
		QaExtentReport.test.log(Status.INFO,"<b><i>Write Username</i></b>");
		
		QaRobot.PassValue("Password",pwd);
		QaExtentReport.test.log(Status.INFO, "<b><i>Write Password</i></b>");
		
		QaRobot.ClickOnElement("Submit");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on submit</i></b>");
		// select the traveler
		SearchDashboard.selectEmployeeWithID(corptraveller);
		// select the trip type
		QaRobot.ClickOnElement("trip_Busniess");
		QaExtentReport.test.log(Status.INFO, "<b><i>Search for business trip</i></b>");

		// select one way trip
		QaRobot.ClickOnElement("ow_onewaytrip");
		QaExtentReport.test.log(Status.INFO, "<b><i>Flight oneway trip</i></b>");
		
		Thread.sleep(3000);
		TestBase.listofautosuggestion(By.xpath("//div[@id='divDepartureCity']/p"), origin, forigin,
				By.xpath("//input[@id='txtDepartureCity']"));
		Thread.sleep(3000);

		QaExtentReport.test.log(Status.INFO, "Departure city : " + forigin);

		Thread.sleep(3000);

		TestBase.listofautosuggestion(By.xpath("//div[@id='divDestinationCity']/p"), destination, fdesti,
				By.xpath("//input[@id='txtDestinationCity']"));
		Thread.sleep(3000);
		QaExtentReport.test.log(Status.INFO, "Arrival city : " + fdesti);

		 Thread.sleep(500);
		// click on departure date icon
		QaBrowser.driver.findElement(By.xpath("//*[@id='flight_way1']/div[2]/div[1]/div/div/label/span[2]/span[1]/img")).click();
		// click on next month
		// QaRobot.ClickOnElement("nextmonth_calender", "Clicked on Next Month Button");
		// QaRobot.ClickOnElement("nextmonth_calender", "Next Month Button");

		// select the depature date
		QaBrowser.driver.findElement(By.xpath("//a[contains(@title,'" + ddate + "')]")).click();
		QaExtentReport.test.log(Status.INFO, "Depature date : " + ddate);
		
		QaBrowser.driver.findElement(By.xpath("//*[@id='flight_way1']/div[2]/div[1]/div/div/label/span[2]/span[1]/img")).click();

		// select cabin class
		/// QaRobot.selectTextFromDropdown("ow_class", fclass, "cabin class : " +
		// fclass);
		// click on addtional search
		// QaRobot.ClickOnElement("ow_addsearch", "additional search options");
		// select currency
		// QaRobot.selectTextFromDropdown("ow_currency", currency,
		// "search currency : " + currency);
		// select nationality
		// QaRobot.selectTextFromDropdown("ow_nationality", nationality,
		// "nationality : " + nationality);
		
		// check the policy checkbox
		SearchDashboard.FlightpolicyCheck();
		// click on search flight button
		QaRobot.ClickOnElement("ow_searchflight");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on search flight button</i></b>");

		Thread.sleep(10000);
		// explicit wait till loader invisible
//		QaRobot.explicitwaitinvisible(200, By.xpath("//div[@class='flight-wait-progress progress ng-hide']"));

		if (QaBrowser.driver
				.findElement(
						By.xpath("//p[contains(text(),'Sorry, could not find desired results. Please try again.')]"))
				.isDisplayed()) {
			// fail the test case and screenshot
//			String resultnotfound = Logger.takeScreenshot(QaBrowser.driver, "D:\\Screenshot\\resultnotfound.png");
//			QaExtentReport.test.log(Status.FAIL, "Results are not found");
		} else {

			// screenshot of result page
			String resultpage = Logger.takeScreenshot(QaBrowser.driver, "D:\\Screenshot\\resultpage.png");
			QaExtentReport.test.log(Status.INFO, "Result Page " + resultpage + "");
			// get current url

			String url = QaBrowser.driver.getCurrentUrl();

			System.out.println(url);

			String[] uid = url.split("=");

			System.out.println("SEssion id " + uid[1]);

			QaExtentReport.test.log(Status.INFO, "Result page url is  " + url);

			QaExtentReport.test.log(Status.INFO, "Session id is " + uid[1]);
			
			Thread.sleep(5000);
			// get text of element that start start from 1
			List<WebElement> listOfPolicytype = QaBrowser.driver
					.findElements(By.xpath("//div[@class='fl_upref_left ng-scope']"));

			int bookindex = 0;
			for (WebElement policytype : listOfPolicytype) {
				bookindex = bookindex + 1;
				String type = policytype.getText();
				if (type.equalsIgnoreCase(policy)) {
					// click on book now button with indexing
					QaBrowser.driver.findElement(By.xpath("(//input[contains(@id,'Anchor_')])[" + bookindex + "]"))
							.click();
					// check In policy and out policy text
					if (policy.equalsIgnoreCase("Out Of Policy")) {

						QaBrowser.driver.switchTo().alert().accept();
					}
					break;
				}else {
					QaExtentReport.test.log(Status.INFO, "Corporate policy is not matched with " + policy);
					System.out.println("Corporate policy is not matched");
				}
			}

			// if getting change selction on check out page

			if (QaBrowser.driver.findElement(By.xpath("//a[@id='ctl00_contentMain_expATag']")).isDisplayed()) {
				QaExtentReport.test.log(Status.FAIL, "Geeting change selection");
			} else {

				// explicit wait till terms and condition check box visible
//				QaRobot.explicitwaitvisible(180, By.xpath("//input[@id='ctl00_contentMain_chkTerms']"));
				// screenshot of checkout page
				String checkoutpage = Logger.takeScreenshot(QaBrowser.driver, "D:\\Screenshot\\checkoutpage.png");
				QaExtentReport.test.log(Status.INFO, "Successful Booking " + checkoutpage + "");
				// get the checkout page booking price
				String checkoutprice = QaBrowser.driver
						.findElement(By.xpath("//span[@id='ctl00_contentMain_totcashPrice']")).getText();
				System.out.println("Price of checkout page " + checkoutprice);
				QaExtentReport.test.log(Status.INFO, "Price of checkout page " + checkoutprice + "");

				WebElement element = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_CorporateFDReasonDDL']"));
				Select sel = new Select(element);
				sel.selectByIndex(1);
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
				String paymentprice = QaBrowser.driver.findElement(By.xpath("//span[@id='ctl00_contentMain_lblTAmt']"))
						.getText();
				System.out.println("Price of payment page " + paymentprice);
				QaExtentReport.test.log(Status.INFO, "Price of payment page " + paymentprice + "");
				
				WebElement DropDown1 = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_ddlFop1']"));
				Select s1 = new Select(DropDown1);
				s1.selectByVisibleText("Bill To Company");
				// select FOP
//				if (fop.equalsIgnoreCase("Cash")) {
//					SBTCheckoutPayment.fopCash(fop, receiptno);
//				} else {
//					SBTCheckoutPayment.fopCreditDebit(card, cardtype, cvv);
//				}
				QaRobot.ClickOnElement("ow_paymentprocced");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on procced button</i></b>");
				Thread.sleep(2000);
				// screenshot of Confirmation page
				String confirmpage = Logger.takeScreenshot(QaBrowser.driver, "D:\\Screenshot\\confirmpage.png");
				QaExtentReport.test.log(Status.INFO, "Successful Booking " + confirmpage + "");

				// booking status
				String bookingStatus = QaBrowser.driver.findElement(By.xpath("//span[@class='nc_status_color']"))
						.getText();
				System.out.println("Booking Status is " + bookingStatus);
				QaExtentReport.test.log(Status.INFO, "Booking Status is  " + bookingStatus);
				// Confirmation code
				String pnr = QaBrowser.driver.findElement(By.xpath("//p[@class='nc_status_p']")).getText();
				System.out.println("PNR is " + pnr);
				QaExtentReport.test.log(Status.INFO, "PNR is  " + pnr);
				// Confirm page price
				String confirmePrice = QaBrowser.driver.findElement(By.xpath("(//div[@class='nc_fcelllast'])[3]"))
						.getText();
				System.out.println("Confirm Page Price is " + confirmePrice);
				QaExtentReport.test.log(Status.INFO, "Confirm Page Price is  " + confirmePrice);
				// Booking id
				String bookingID = QaBrowser.driver.findElement(By.xpath("//span[@class='nc_bookid_no']")).getText();
				System.out.println("Booking ID is " + bookingID);
				QaExtentReport.test.log(Status.INFO, "Booking ID is  " + bookingID);

			}
		}
	}

	@AfterTest
	public static void After_Test() {

		QaExtentReport.test.getExtent().flush();

	}

}
