package product.Flight.suite.Oneway;

import static org.testng.Assert.fail;

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
import entities.Login;
import utilities.Logger;
import utilities.QaBrowser;
import utilities.QaDataProvider;
import utilities.QaExtentReport;
import utilities.QaRobot;

@Listeners(listenerClass.Listener.class)
public class BookBusinessHotelWithPolicyType 
{
	@DataProvider
	public Object[][] getexceldata() throws Exception 
	{
		return QaDataProvider.getTestdata("SBT_Hotel", "BookHotelWithPolicyType");
	}

	@Test(dataProvider = "getexceldata")
	public static void Sbt_flight_Search(String ccode, String URL, String compcode, String uname, String pwd,
			String corptraveller, String searchType, String origin, String forigin, String chkindate, String chkoutdate,
			String adult, String child, String nationality, String policy,
			String fop, String receiptno, String card, String cardType, String cvv, String hotelReasonCode)
			throws Exception {
		
		QaExtentReport.test = QaExtentReport.report.createTest("Test On Book Hotel with specific name");
		TestBase.Companycode(ccode,URL); 
		QaRobot.impliwait(30);
		// write comapny code
		TestBase.Companycode(ccode, URL);
		// login on sbt 
		Login.SbtLogin(uname, pwd);
		// Login.V12SbtLogin(compcode, uname, pwd);
		// click on search Hotel
		QaRobot.ClickOnElement("search_hotel");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Hotel search</i></b>");
		// select the traveler
		SearchDashboard.selectEmployeeWithID(corptraveller);
		// select the trip type
		QaRobot.ClickOnElement("trip_Busniess");
		QaExtentReport.test.log(Status.INFO, "<b><i>Search for business trip</i></b>");

		Thread.sleep(1000);
		TestBase.listofautosuggestion(By.xpath("//div[@id='divHotelName']/p"), origin, forigin,
				By.xpath("//input[@id='txtHHLCity']"));
		Thread.sleep(2000);

		QaBrowser.driver.findElement(By.xpath("//div[@id='divHotelName']/p")).click();
		QaExtentReport.test.log(Status.INFO, "Destination city : " + forigin);

		Thread.sleep(1000);
		// click on check in date icon
		QaBrowser.driver.findElement(By.xpath("(//span[@class='pikcalndr datepick-trigger'])[9]/img")).click();
		Thread.sleep(500);
		// click on next month
		// QaRobot.ClickOnElement("nextmonth_calender", "Clicked on Next Month Button");

		// select the checkin date
		QaBrowser.driver.findElement(By.xpath("//a[contains(@title,'" + chkindate + "')]")).click();
		QaExtentReport.test.log(Status.INFO, "CheckIN date : " + chkindate);

		// check the policy checkbox
		SearchDashboard.hotelPolicyCheck();
		// sceernshot of search interface
		// String searchpage = Logger.takeScreenshot(QaBrowser.driver,
		// "D:\\Screenshot\\searchPage.png");
		// QaExtentReport.test.log(Status.INFO, "Search Page "+searchpage+"");
		QaExtentReport.extentScreenshot("Sigh In Page");
		// click on search hotel button
		QaRobot.ClickOnElement("search_button");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on search Hotel button</i></b>");

//		QaRobot.explicitwaitinvisible(300, By.xpath("div[@class='loadbar ld_hotel']"));

		// No result found
		if (QaBrowser.driver.findElement(By.xpath("//div[@id='NoResultmsg']/div/h1")).isDisplayed()) {
			// fail the test case and screenshot
//			String resultnotfound = Logger.takeScreenshot(QaBrowser.driver, "D:\\Screenshot\\resultnotfound.png");
//			QaExtentReport.test.log(Status.FAIL, "Results are not found");
		} else {

			// explicit wait till loader invisible
//			QaRobot.explicitwaitinvisible(400, By.xpath("//i[@class='htl-rslt-loader-img']"));
			// screenshot of result page
			// String resultpage = Logger.takeScreenshot(QaBrowser.driver,
			// "D:\\Screenshot\\resultpage.png");
			// QaExtentReport.test.log(Status.INFO, "Result page " + resultpage + "");

			// get current url

			String url = QaBrowser.driver.getCurrentUrl();

			System.out.println(url);

			String[] uid = url.split("=");

			System.out.println("SEssion id " + uid[1]);

			QaExtentReport.test.log(Status.INFO, "Result page url is  " + url);

			QaExtentReport.test.log(Status.INFO, "Session id is " + uid[1]);
			
			Thread.sleep(45000);
			// click on Prefered check ALL
			QaRobot.ClickOnElement("PreferedChkAll");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on prefered check</i></b>");

			// get the list of policy type
			List<WebElement> listOfPolicytype = QaBrowser.driver.findElements(By.xpath("//div[@class='fl_upref_right']"));
			int bookindex = 10;
			for (WebElement policytype : listOfPolicytype) 
			{
				bookindex = bookindex + 1;
				String type = policytype.getText();
				System.out.println(type);
				if (type.equalsIgnoreCase(policy)) {
					// click on select room button with indexing (starting from 11)
					QaBrowser.driver.findElement(By.xpath("//p[@id='htlrm0" + bookindex+ "']")).click();
					Thread.sleep(3000);
				
					// wait for loader

//					QaRobot.explicitwaitinvisible(60, By.xpath("(//div[@id='page_preloader'])[1]"));

				
					// check room availability
//					if (isElementAvailable("//div[@id='nrm_box_1']/div[2]/div/h3")) {
//						fail("Unable to procced booking due to getting no room availability");
//					} else {
						// select the room
						QaBrowser.driver.findElement(By.xpath("(//a[text()='BOOK'])[1]")).click();
						QaExtentReport.extentScreenshot("Result Page");
					// check In policy and out policy text
					if (type.equalsIgnoreCase("Out Of Policy")) {

						QaBrowser.driver.switchTo().alert().accept();
					}

					break;
//					}
					}
				 else {
					QaExtentReport.test.log(Status.INFO, "Corporate policy is not matched with " + policy);
					System.out.println("Corporate policy is not matched");
				}
			}

			// explicit wait till terms and condition check box visible
//			QaRobot.explicitwaitvisible(180, By.xpath("//input[@id='ctl00_contentMain_chkTerms']"));

			// screenshot of checkout page
			// String checkoutpage = Logger.takeScreenshot(QaBrowser.driver,
			// "D:\\Screenshot\\checkoutpage.png");
			// QaExtentReport.test.log(Status.INFO, "Checkout page " + checkoutpage + "");
			// get price on checkout page
			String chkoutPrice = QaBrowser.driver
					.findElement(By.xpath("//span[@id='ctl00_contentMain_totcashPrice_HHL']")).getText();
			System.out.println("Price on checkout page is " + chkoutPrice);
			QaExtentReport.test.log(Status.INFO, "Price on checkout page is  " + chkoutPrice);
			// select reason of booking
			WebElement element = QaBrowser.driver
					.findElement(By.xpath("//select[@id='ctl00_contentMain_CorporateFDReasonDDLHHL']"));
			Select sel = new Select(element);
			sel.selectByIndex(1);

			// check the terms and condition checkbox
			QaRobot.ClickOnElement("ow_chkterms");
			QaExtentReport.test.log(Status.INFO, "<b><i>check the terms and condition</i></b>");
			QaExtentReport.extentScreenshot("Checkout Page");
			// proceed the booking from checkout page
			QaRobot.ClickOnElement("ow_chkbook");
			QaExtentReport.test.log(Status.INFO, "<b><i>book button to proceed the booking from checkout page</i></b>");
			
			// check if getting Compulsory Conditions on checkou page after procceding hotel
			if (QaBrowser.driver.findElement(By.xpath("//p[@id='ContractDetails']")).isDisplayed()) {
				// get the text and termination the test case
				String details = QaBrowser.driver.findElement(By.xpath("//p[@id='ContractDetails']")).getText();
				System.out.println(details);
				QaExtentReport.test.log(Status.FAIL,
						"Unable to proceed booking due to getting no availabilty in hotel " + details);
				fail("Unable to proceed booking due to getting no availabilty in hotel");

			}
			// accept alert to proceed from checkout page
			// QaBrowser.driver.switchTo().alert().accept();
			// wait till payment page display
//			QaRobot.explicitwaitvisible(300, By.xpath("//div[@class='value_package_details']"));

			// screenshot of Payment page
//			String paymentpage = Logger.takeScreenshot(QaBrowser.driver, "D:\\Screenshot\\paymentpage.png");
//			QaExtentReport.test.log(Status.INFO, "Payment Page " + paymentpage + "");
			// get price on Payment page
			String paymentPrice = QaBrowser.driver.findElement(By.xpath("//span[@id='ctl00_contentMain_lblTAmt']"))
					.getText();
			System.out.println("Price on Payment page is " + paymentPrice);
			QaExtentReport.test.log(Status.INFO, "Price on Payment page is  " + paymentPrice);
			// select FOP
			if (fop.equalsIgnoreCase("Cash")) {
				SBTCheckoutPayment.fopCash(fop, receiptno);
			}
			if (fop.equalsIgnoreCase("Bill To Company")) {
				SBTCheckoutPayment.fopBillToComapnay(fop);
			} else {
				SBTCheckoutPayment.fopCreditDebit(card, cardType, cvv);
			}
			QaExtentReport.extentScreenshot("Payment Page");
			
			QaRobot.ClickOnElement("ow_paymentprocced");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on procced button</i></b>");

			Thread.sleep(1000);
			// screenshot of Confirmation page
			String confirmpage = Logger.takeScreenshot(QaBrowser.driver, "D:\\Screenshot\\confirmpage.png");
			QaExtentReport.test.log(Status.INFO, "Confirmation page " + confirmpage + "");

			// booking status
			String bookingStatus = QaBrowser.driver.findElement(By.xpath("//span[@class='nc_status_color']")).getText();
			System.out.println("Booking Status is " + bookingStatus);
			QaExtentReport.test.log(Status.INFO, "Booking Status is  " + bookingStatus);
			// Confirmation code
			String confirmationCode = QaBrowser.driver.findElement(By.xpath("//p[@class='nc_status_p']")).getText();
			System.out.println("Confirmation code is " + confirmationCode);
			QaExtentReport.test.log(Status.INFO, "Confirmation code is  " + confirmationCode);
			// Confirm page price
			String confirmePrice = QaBrowser.driver.findElement(By.xpath("(//div[@class='nc_fcelllast'])[3]"))
					.getText();
			System.out.println("Confirm Page Price is " + confirmePrice);
			QaExtentReport.test.log(Status.INFO, "Confirm Page Price is  " + confirmePrice);
			// Booking id
			String bookingID = QaBrowser.driver.findElement(By.xpath("//span[@class='nc_bookid_no']")).getText();
			System.out.println("Booking ID is " + bookingID);
			QaExtentReport.test.log(Status.INFO, "Booking ID is  " + bookingID);
			QaExtentReport.extentScreenshot("Confirm Page");

			// Click on home page
			// QaBrowser.driver.findElement(By.xpath("//img[@id='ctl00_HeaderTop_imgCompanyWise']")).click();

		}
	}
	
		private static boolean isElementAvailable(String xpath) {
			try {
				QaBrowser.driver.findElement(By.xpath(xpath));
			} catch (Exception e) {
				return false;
			}
			return true;
		}


	@AfterTest
	public static void After_Test() {
		QaExtentReport.test.getExtent().flush();

	}
	

}
