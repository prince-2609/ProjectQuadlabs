package product.Flight.suite.Oneway;

import static org.testng.Assert.fail;

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
import utilities.QaBrowser;
import utilities.QaDataProvider;
import utilities.QaExtentReport;
import utilities.QaRobot;

@Listeners(listenerClass.Listener.class)
public class BookBusinessHotelWithName
{
	@DataProvider
	public Object[][] getexceldata() throws Exception 
	{
		return QaDataProvider.getTestdata("SBT_Hotel", "SearchWithHotelName");
	}

	@Test(dataProvider = "getexceldata")
	public static void Sbt_flight_Search(String TestCaseId,String Employee,String TravelerType,String TravelerName,String ccode, String URL, String compcode, String uname, String pwd,
			String corptraveller, String searchType, String origin, String forigin, String chkindate, String chkoutdate,
			String adult, String child, String nationality, String hotelName, String starCategory, String booknowindex,
			String policyindex, String fop, String receiptno, String card, String cardType, String cvv,
			String hotelReasonCode,String CreatedBy) throws Exception {
		
		QaExtentReport.test = QaExtentReport.report.createTest(TestCaseId);
		TestBase.Companycode(ccode,URL); 
		QaRobot.impliwait(30);
		// login on sbt
		Login.SbtLogin(uname, pwd);
		// Login.V12SbtLogin(compcode, uname, pwd);
		// click on search Hotel
		QaRobot.ClickOnElement("search_hotel");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Hotel search</i></b>");
		
		QaExtentReport.test.log(Status.INFO, "<b><i>Employee Name is  </i></b>"+Employee);
		QaExtentReport.test.log(Status.INFO, "<b><i>Travel Arranger Name is  </i></b>"+TravelerName);
		
		// select the traveler
		SearchDashboard.selectEmployeeWithID(corptraveller);
		// select the trip type
		QaRobot.ClickOnElement("trip_Busniess");
		QaExtentReport.test.log(Status.INFO, "<b><i>Search for business trip</i></b>");

		Thread.sleep(1000);
		TestBase.listofautosuggestion(By.xpath("//div[@id='divHotelName']/p"), origin, forigin,By.xpath("//input[@id='txtHHLCity']"));
		Thread.sleep(2000);

		QaExtentReport.test.log(Status.INFO, "<b><i>Destination city : </i></b>" + forigin);

		Thread.sleep(1000);
		// click on check in date icon
		QaBrowser.driver.findElement(By.xpath("(//span[@class='pikcalndr datepick-trigger'])[9]/img")).click();
		Thread.sleep(500);
		// click on next month
		 QaRobot.ClickOnElement("nextmonth_calender");

		// select the checkin date
		QaBrowser.driver.findElement(By.xpath("//a[contains(@title,'" + chkindate + "')]")).click();
		QaExtentReport.test.log(Status.INFO, "<b><i>CheckIN date : </i></b>" + chkindate);
		
		Thread.sleep(500);
		// check the policy checkbox
		//SearchDashboard.hotelPolicyCheck();
		// sceernshot of search interface
		// String searchpage = Logger.takeScreenshot(QaBrowser.driver,
		// "D:\\Screenshot\\searchPage.png";
		// QaExtentReport.test.log(Status.INFO, "Search Page "+searchpage+"");
		// click on search hotel button
		
		QaRobot.ClickOnElement("Search_CheckBox");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Check Box</i></b>");
		
		Thread.sleep(2000);
		QaExtentReport.extentScreenshot("Sigh In Page");
		
		QaRobot.ClickOnElement("search_button");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on search Hotel button</i></b>");

//		QaRobot.explicitwaitinvisible(600, By.xpath("div[@class='loadbar ld_hotel']"));
//		QaRobot.explicitwaitinvisible(200, By.xpath("div[@class='loadbar ld_hotel']"));
	
		Thread.sleep(30000);
		
		// No result found
		if (QaBrowser.driver.findElement(By.xpath("//div[@id='NoResultmsg']/div/h1")).isDisplayed()) 
		{
			// fail the test case and screenshot
//			String resultnotfound = Logger.takeScreenshot(QaBrowser.driver, "D:\\Screenshot\\resultnotfound.png");
//			QaExtentReport.test.log(Status.FAIL, "Results are not found");
		} 
		else 
		{
			// explicit wait till loader invisible
//			QaRobot.explicitwaitinvisible(200, By.xpath("//i[@class='htl-rslt-loader-img']"));

			
			// click on Prefered check ALL
//			QaRobot.ClickOnElement("PreferedChkAll");
//			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on prefered check</i></b>");

			// screenshot of result page
			// String resultpage = Logger.takeScreenshot(QaBrowser.driver,
			// "D:\\Screenshot\\resultpage.png");
			// QaExtentReport.test.log(Status.INFO, "Result page " + resultpage + "");

			// get current url

			String url = QaBrowser.driver.getCurrentUrl();

			System.out.println(url);

			String[] uid = url.split("=");

			System.out.println("SEssion id " + uid[1]);

//			QaExtentReport.test.log(Status.INFO, "Result page url is  " + url);

			QaExtentReport.test.log(Status.INFO, "<b><i>Session id is </i></b>" + uid[1]);
			
			
//			 hotel booking with specific name of hotel
			 SBTResultPage.searchHotelWithName(hotelName);
			
			
			// hotel booking with specific star rating
//			SBTResultPage.searchHotelWithStarCategory(starCategory);
			
			// get text of element that start start from 1
			String policytype = QaBrowser.driver.findElement(By.xpath("//div[@id='hotel_price_con" + policyindex + "']/div/div/span")).getText();
			// click on select room button with indexing
			QaBrowser.driver.findElement(By.xpath("//a[@id='htlrm0" + booknowindex + "']")).click();
			QaExtentReport.extentScreenshot("Result1 Page");

			// wait for loader

//			QaRobot.explicitwaitinvisible(60, By.xpath("(//div[@id='page_preloader'])[1]"));

			// check room availability
			if (isElementAvailable("//div[@id='nrm_box_1']/div[2]/div/h3")) 
			{
				fail("Unable to procced booking due to getting no room availability");
			} 
			else 
			{
				// select the room
				QaBrowser.driver.findElement(By.xpath("(//a[text()='BOOK'])[1]")).click();
				
				QaExtentReport.extentScreenshot("Result Page");
				// check In policy and out policy text
				if (policytype.equalsIgnoreCase("Out Of Policy")) 
				{
					QaBrowser.driver.switchTo().alert().accept();
				}

				// explicit wait till terms and condition check box visible
//				QaRobot.explicitwaitvisible(180, By.xpath("//input[@id='ctl00_contentMain_chkTerms']"));

				// screenshot of checkout page
				// String checkoutpage = Logger.takeScreenshot(QaBrowser.driver,
				// "D:\\Screenshot\\checkoutpage.png");
				// QaExtentReport.test.log(Status.INFO, "Checkout page " + checkoutpage + "");
				// get price on checkout page
				String chkoutPrice = QaBrowser.driver.findElement(By.xpath("//span[@id='ctl00_contentMain_totcashPrice_HHL']")).getText();
				System.out.println("Price on checkout page is " + chkoutPrice);
				QaExtentReport.test.log(Status.INFO, "<b><i>Price on checkout page is  </i></b>" + chkoutPrice);
				// select reason of booking
				WebElement element = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_CorporateFDReasonDDLHHL']"));
				Select sel = new Select(element);
				sel.selectByIndex(1);

				// check the terms and condition checkbox
				QaRobot.ClickOnElement("ow_chkterms");
				QaExtentReport.test.log(Status.INFO, "<b><i>check the terms and condition</i></b>");
				
				QaExtentReport.extentScreenshot("Checkout Page");
				
				// proceed the booking from checkout page
				QaRobot.ClickOnElement("ow_chkbook");
				QaExtentReport.test.log(Status.INFO, "<b><i>book button to proceed the booking from checkout page</i></b>");
				
				// check if getting Compulsory Conditions on checkout page after procceding hotel
				if (QaBrowser.driver.findElement(By.xpath("//p[@id='ContractDetails']")).isDisplayed()) 
				{
					// get the text and termination the test case
					String details = QaBrowser.driver.findElement(By.xpath("//p[@id='ContractDetails']")).getText();
					System.out.println(details);
					QaExtentReport.test.log(Status.FAIL,"Unable to proceed booking due to getting no availabilty in hotel " + details);
					fail("Unable to proceed booking due to getting no availabilty in hotel");

				}
				// accept alert to proceed from checkout page
				// QaBrowser.driver.switchTo().alert().accept();
				// wait till payment page display
//				QaRobot.explicitwait(300, By.xpath("//div[@class='value_package_details']"));

				// screenshot of Payment page
//				String paymentpage = Logger.takeScreenshot(QaBrowser.driver, "D:\\Screenshot\\paymentpage.png");
//				QaExtentReport.test.log(Status.INFO, "Payment Page " + paymentpage + "");
				// get price on Payment page
				String paymentPrice = QaBrowser.driver.findElement(By.xpath("//span[@id='ctl00_contentMain_lblTAmt']")).getText();
				System.out.println("Price on Payment page is " + paymentPrice);
				QaExtentReport.test.log(Status.INFO, "<b><i>Price on Payment page is  </i></b>" + paymentPrice);
				// select FOP
				if (fop.equalsIgnoreCase("Cash")) 
				{
					SBTCheckoutPayment.fopCash(fop, receiptno);
				}
				else if (fop.equalsIgnoreCase("Bill To Company")) 
				{
					SBTCheckoutPayment.fopBillToComapnay(fop);
				} else 
				{
					SBTCheckoutPayment.fopCreditDebit(card, cardType, cvv);
				}
				
				QaExtentReport.extentScreenshot("Payment Page");
				
				QaRobot.ClickOnElement("ow_paymentprocced");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on procced button</i></b>");

				Thread.sleep(1000);
				// screenshot of Confirmation page
//				String confirmpage = Logger.takeScreenshot(QaBrowser.driver, "D:\\Screenshot\\confirmpage.png");
//				QaExtentReport.test.log(Status.INFO, "Confirmation page " + confirmpage + "");

				// booking status
				String bookingStatus = QaBrowser.driver.findElement(By.xpath("//span[@class='nc_status_color']")).getText();
				System.out.println("Booking Status is " + bookingStatus);
				QaExtentReport.test.log(Status.INFO, "<b><i>Booking Status is  </i></b>" + bookingStatus);
				// Confirmation code
				String confirmationCode = QaBrowser.driver.findElement(By.xpath("//p[@class='nc_status_p']")).getText();
				System.out.println("Confirmation code is " + confirmationCode);
				QaExtentReport.test.log(Status.INFO, "<b><i>Confirmation code is  </i></b>" + confirmationCode);
				// Confirm page price
				String confirmePrice = QaBrowser.driver.findElement(By.xpath("(//div[@class='nc_fcelllast'])[3]"))
						.getText();
				System.out.println("Confirm Page Price is " + confirmePrice);
				QaExtentReport.test.log(Status.INFO, "<b><i>Confirm Page Price is  </i></b>" + confirmePrice);
				// Booking id
				String bookingID = QaBrowser.driver.findElement(By.xpath("//span[@class='nc_bookid_no']")).getText();
				String a []= bookingID.split(" ");
				String number = a[2];
				System.out.println("Booking ID is " + bookingID);
				QaExtentReport.test.log(Status.INFO, "<b><i>Booking id is </i></b>" + bookingID);
				QaExtentReport.extentScreenshot("Confirm Page");
				
				QaRobot.mouseHover("//a[@id='ctl00_HeaderTop_aBookingMenu']", "//span[@id='ctl00_HeaderTop_lblBookingQueue']");
				QaExtentReport.extentScreenshot("CorporateDashboard Page");
				
				QaRobot.ScreenshotMethod("CorporateDashboard","<b><i>Screenshot for Corporate Dashboard Page</i></b>");
				Thread.sleep(3000);
				
				QaRobot.PassValue("RefNo",number);
				QaExtentReport.test.log(Status.INFO,"<b><i>Write Ref No</i></b>");
				
				QaRobot.ClickOnElement("SearchRefNo");
				 
				QaRobot.ClickOnElement("RefBooking");
				
				QaExtentReport.extentScreenshot("Booking Card");
				
				String Creater = QaBrowser.driver.findElement(By.xpath("//span[@id='lblCreatedBy']")).getText();
				System.out.println("Created By " + Creater);
				QaExtentReport.test.log(Status.INFO, "<b><i>Created By </i></b>" + Creater);
				
				if(CreatedBy.equalsIgnoreCase(Creater))
				{
					QaExtentReport.test.log(Status.INFO, "<b><i>Creater is Correct  </i></b>"+CreatedBy);
				}
				else
				{
					QaExtentReport.test.log(Status.FAIL, "<b><i>Creater is Different  </i></b>"+CreatedBy);
				}
			}
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
	public static void After_Test() 
	{
		QaExtentReport.test.getExtent().flush();

	}

}
