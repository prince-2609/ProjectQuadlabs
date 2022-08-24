package product.Flight.suite.Oneway;

import static org.testng.Assert.fail;

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
public class BookPersonalHotel
{
	public static String resultPagePrice;

	@DataProvider
	public Object[][] getexceldata() throws Exception {

		return QaDataProvider.getTestdata("SBT_Hotel", "Personal");
	}

	@Test(dataProvider = "getexceldata")
	public static void Sbt_flight_Search(String ccode, String URL,String compcode, String uname, String pwd, String corptraveller,String searchType,
			String origin, String forigin, String chkindate, String chkoutdate, String room,String adult,
			String child, String infant,String ageofchildren,String nationality, String booknowindex,String adttitle, String adultfname, String adultlname,
			String adultdate, String adultmonth, String adultyear, String adultgender,String chdtitle, String childfname, String childlname,
			String childdate, String childmonth, String childyear, String childgender,String fop, String receiptno, String card, String cardType,
			String cvv, String checkoutPageStep, String hotelReasonCode, String hotelRemarks)
			throws Exception {

		QaExtentReport.test = QaExtentReport.report.createTest("Test On Personal Hotel");
		TestBase.Companycode(ccode,URL); 
		QaRobot.impliwait(30);
		// login on sbt
		Login.SbtLogin(uname, pwd);
		// click on search Hotel
		QaRobot.ClickOnElement("search_hotel");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Hotel search</i></b>");
		// select the traveler
		SearchDashboard.selectEmployeeWithID(corptraveller);
		// select the trip type
		QaRobot.ClickOnElement("trip_personal");
		QaExtentReport.test.log(Status.INFO, "<b><i>Search for personal trip</i></b>");
		
		TestBase.listofautosuggestion(By.xpath("//div[@id='divHotelName']/p"), origin, forigin,
				By.xpath("//input[@id='txtHHLCity']"));
		Thread.sleep(1000);
		
		QaBrowser.driver.findElement(By.xpath("//div[@id='divHotelName']/p")).click();

		QaExtentReport.test.log(Status.INFO, "Destination city : " + forigin);

		Thread.sleep(1000);
		// click on check in date icon
		QaBrowser.driver.findElement(By.xpath("(//span[@class='pikcalndr datepick-trigger'])[9]/img")).click();
		Thread.sleep(500);
		// click on next month
		// QaRobot.ClickOnElement("nextmonth_calender", "Clicked on Next Month Button");
		// QaRobot.ClickOnElement("nextmonth_calender", "Next Month Button");
		// select the checkin date
		QaBrowser.driver.findElement(By.xpath("//a[contains(@title,'" + chkindate + "')]")).click();
		QaExtentReport.test.log(Status.INFO, "CheckIN date : " + chkindate);

//		   Thread.sleep(500);
//		// click on check out date icon
//			QaBrowser.driver.findElement(By.xpath("(//span[@class='pikcalndr datepick-trigger'])[10]/img")).click();
//			Thread.sleep(500);
//		// select the checkout date
//			QaBrowser.driver.findElement(By.xpath("//a[contains(@title,'" + chkoutdate +"')]")).click();
//			QaExtentReport.test.log(Status.INFO,"CheckOut date : " + chkoutdate);

		//select the room
				QaRobot.selectValueFromDropdown("dep_hotel_traveler", room, "Selected the room");
				
				SearchDashboard.selectRoomPax(room, adult, child,ageofchildren);
	
		// sceernshot of search interface
		// String searchpage = Logger.takeScreenshot(QaBrowser.driver,
		// "D:\\Screenshot\\searchPage.png");
		// QaExtentReport.test.log(Status.INFO, "Search Page "+searchpage+"");
		// click on search hotel button
		QaRobot.ClickOnElement("search_button");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on search Hotel button</i></b>");
		
		Thread.sleep(15000);
//		QaRobot.explicitwaitinvisible(300, By.xpath("div[@class='loadbar ld_hotel']"));

		// No result found
		if (QaBrowser.driver.findElement(By.xpath("//div[@id='NoResultmsg']/div/h1")).isDisplayed()) {
			// fail the test case and screenshot
//			String resultnotfound = Logger.takeScreenshot(QaBrowser.driver, "D:\\Screenshot\\resultnotfound.png");
//			QaExtentReport.test.log(Status.FAIL, "Results are not found");
		} else {

			// explicit wait till loader invisible
//			QaRobot.explicitwaitinvisible(200, By.xpath("//i[@class='htl-rslt-loader-img']"));

			// click on Prefered check ALL
//			QaRobot.ClickOnElement("PreferedChkAll");
//			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on prefered check</i></b>");

			// screenshot of result page
			// String resultpage = Logger.takeScreenshot(QaBrowser.driver,
			// "D:\\Screenshot\\resultpage.png");
			// QaExtentReport.test.log(Status.INFO, "Result page " + resultpage + "");
			Thread.sleep(5000);
			// get price on result page
			String resultPrice = QaBrowser.driver.findElement(By.xpath("(//p[@class='price_bonus_count'])[" + booknowindex + "]")).getText();
			System.out.println("Result page price is " + resultPrice);
			QaExtentReport.test.log(Status.INFO, "Result page price is " + resultPrice);
			String[] p = resultPrice.split(" ");
			resultPagePrice = p[1];

			
			// click on select room button with indexing (starting from 11)
			int bookingIndex = Integer.parseInt(booknowindex);
			QaBrowser.driver.findElement(By.xpath("//p[@id='htlrm0" + (bookingIndex + 10) + "']")).click();

			// wait for loader

//			QaRobot.explicitwaitinvisible(60, By.xpath("(//div[@id='page_preloader'])[1]"));

			// get current url

			String url = QaBrowser.driver.getCurrentUrl();

			System.out.println(url);

			String[] uid = url.split("=");

			System.out.println("SEssion id " + uid[1]);

			QaExtentReport.test.log(Status.INFO, "Result page url is  " + url);

			QaExtentReport.test.log(Status.INFO, "Session id is " + uid[1]);

			
				// select the room
				QaBrowser.driver.findElement(By.xpath("(//a[text()='BOOK'])[1]")).click();

				

				// explicit wait till terms and condition check box visible
//				QaRobot.explicitwaitvisible(180, By.xpath("//input[@id='ctl00_contentMain_chkTerms']"));

				// screenshot of checkout page
				// String checkoutpage = Logger.takeScreenshot(QaBrowser.driver,
				// "D:\\Screenshot\\checkoutpage.png");
				// QaExtentReport.test.log(Status.INFO, "Checkout page " + checkoutpage + "");
				// get price on checkout page
				String chkoutPrice = QaBrowser.driver.findElement(By.xpath("//span[@id='ctl00_contentMain_totcashPrice_HHL']")).getText();
				System.out.println("Price on checkout page is " + chkoutPrice);
				QaExtentReport.test.log(Status.INFO, "Price on checkout page is  " + chkoutPrice);
				
				SBTCheckoutPayment.PersonalHotelAdultCheckout(adult,  adttitle,  adultfname,  adultlname, adultdate,  adultmonth,  adultyear,  adultgender);
				
				SBTCheckoutPayment.PersonalHotelChildCheckout(child, chdtitle,  childfname,  childlname, childdate,  childmonth,  childyear,  childgender);
//				// select reason of booking
//				WebElement element = QaBrowser.driver
//						.findElement(By.xpath("//select[@id='ctl00_contentMain_CorporateFDReasonDDLHHL']"));
//				Select sel = new Select(element);
//				sel.selectByIndex(1);

			}

			if (checkoutPageStep.equalsIgnoreCase("Quote")) {
				SBTCheckoutPayment.checkoutHotelQuote(hotelReasonCode, hotelRemarks);

			} else if (checkoutPageStep.equalsIgnoreCase("Fullfillment")) {

				// check the terms and condition checkbox
				QaRobot.ClickOnElement("ow_chkterms");
				QaExtentReport.test.log(Status.INFO, "<b><i>check the terms and condition</i></b>");
				
				// proceed the booking from checkout page
				QaRobot.ClickOnElement("ow_chkbook");
				QaExtentReport.test.log(Status.INFO, "<b><i>book button to proceed the booking from checkout page</i></b>");
				// check if getting Compulsory Conditions on checkou page after procceding hotel
				if (QaBrowser.driver.findElement(By.xpath("//p[@id='ContractDetails']")).isDisplayed()) {
					// get the text and termination the test case
					String details = QaBrowser.driver.findElement(By.xpath("//p[@id='ContractDetails']")).getText();
					System.out.println(details);
					QaExtentReport.test.log(Status.FAIL,"Unable to proceed booking due to getting no availabilty in hotel " + details);
					fail("Unable to proceed booking due to getting no availabilty in hotel");

				} 
					// accept alert to proceed from checkout page
					// QaBrowser.driver.switchTo().alert().accept();
					// wait till payment page display
//					QaRobot.explicitwaitvisible(300, By.xpath("//div[@class='value_package_details']"));

					// screenshot of Payment page
					String paymentpage = Logger.takeScreenshot(QaBrowser.driver, "D:\\Screenshot\\paymentpage.png");
					QaExtentReport.test.log(Status.INFO, "Payment Page " + paymentpage + "");
					// get price on Payment page
					String paymentPrice = QaBrowser.driver.findElement(By.xpath("//span[@id='ctl00_contentMain_lblTAmt']")).getText();
					System.out.println("Price on Payment page is " + paymentPrice);
					QaExtentReport.test.log(Status.INFO, "Price on Payment page is  " + paymentPrice);
					// select FOP
//					if (fop.equalsIgnoreCase("Cash")) {
//						SBTCheckoutPayment.fopCash(fop, receiptno);
//					}
//					if (fop.equalsIgnoreCase("Bill To Company")) {
//						SBTCheckoutPayment.fopBillToComapnay(fop);
//					} else {
//						SBTCheckoutPayment.fopCreditDebit(card, cardType, cvv);
//					}

					QaRobot.ClickOnElement("ow_paymentprocced");
					QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on procced button</i></b>");

					Thread.sleep(1000);
					// screenshot of Confirmation page
					String confirmpage = Logger.takeScreenshot(QaBrowser.driver, "D:\\Screenshot\\confirmpage.png");
					QaExtentReport.test.log(Status.INFO, "Confirmation page " + confirmpage + "");

					// booking status
					String bookingStatus = QaBrowser.driver.findElement(By.xpath("//span[@class='nc_status_color']"))
							.getText();
					System.out.println("Booking Status is " + bookingStatus);
					QaExtentReport.test.log(Status.INFO, "Booking Status is  " + bookingStatus);
					// Confirmation code
					String confirmationCode = QaBrowser.driver.findElement(By.xpath("//p[@class='nc_status_p']"))
							.getText();
					System.out.println("Confirmation code is " + confirmationCode);
					QaExtentReport.test.log(Status.INFO, "Confirmation code is  " + confirmationCode);
					// Confirm page price
					String confirmePrice = QaBrowser.driver.findElement(By.xpath("(//div[@class='nc_fcelllast'])[3]"))
							.getText();
					System.out.println("Confirm Page Price is " + confirmePrice);
					QaExtentReport.test.log(Status.INFO, "Confirm Page Price is  " + confirmePrice);
					// Booking id
					String bookingID = QaBrowser.driver.findElement(By.xpath("//span[@class='nc_bookid_no']"))
							.getText();
					System.out.println("Booking ID is " + bookingID);
					QaExtentReport.test.log(Status.INFO, "Booking ID is  " + bookingID);
				}
				// Click on home page
				// QaBrowser.driver.findElement(By.xpath("//img[@id='ctl00_HeaderTop_imgCompanyWise']")).click();
			}
		

	@AfterTest
	public static void After_Test() {

		QaExtentReport.test.getExtent().flush();

	}



}
