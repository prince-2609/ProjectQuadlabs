package product.Flight.suite.Oneway;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Base.TestBase;
import TestScript.RoundTrip.Flightcheck;
import entities.Login;
import utilities.QaBrowser;
import utilities.QaDataProvider;
import utilities.QaExtentReport;
import utilities.QaRobot;

@Listeners(listenerClass.Listener.class)
public class HotelBusinessAddToCart extends Flightcheck
{
	public static String resultPagePrice;

	@DataProvider
	public Object[][] getexceldata() throws Exception {

		return QaDataProvider.getTestdata("SBT_Hotel", "AddToCart");
	}

	@Test(dataProvider = "getexceldata")
	public static void Sbt_flight_Search(String ccode, String URL,String compcode, String uname, String pwd, String corptraveller,String searchType,
			String origin, String forigin, String chkindate, String chkoutdate, String adult,
			String child, String nationality, String booknowindex, String policyindex, String addToCartIndex,String hotelRemarks)
			throws Exception {

		QaExtentReport.test = QaExtentReport.report.createTest("Test On Add to cart Hotel");
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
		QaRobot.ClickOnElement("trip_Busniess");
		QaExtentReport.test.log(Status.INFO, "<b><i>Search for business trip</i></b>");

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

		// click on addtional search
		// QaRobot.ClickOnElement("ow_addsearch", "additional search options");
		// select currency
		// QaRobot.selectTextFromDropdown("ow_currency", currency,
		// "search currency : " + currency);
		// check the policy checkbox
		SearchDashboard.hotelPolicyCheck();
		// sceernshot of search interface
		// String searchpage = Logger.takeScreenshot(QaBrowser.driver,
		// "D:\\Screenshot\\searchPage.png");
		// QaExtentReport.test.log(Status.INFO, "Search Page "+searchpage+"");
		// click on search hotel button
		QaRobot.ClickOnElement("search_button");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on search Hotel button</i></b>");
		
//		QaRobot.explicitwaitinvisible(300, By.xpath("div[@class='loadbar ld_hotel']"));
		Thread.sleep(15000);
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

			// get price on result page
			String resultPrice = QaBrowser.driver.findElement(By.xpath("(//p[@class='price_bonus_count'])[" + booknowindex + "]")).getText();
			System.out.println("Result page price is " + resultPrice);
			QaExtentReport.test.log(Status.INFO, "Result page price is " + resultPrice);
			String[] p = resultPrice.split(" ");
			resultPagePrice = p[1];

			// get text of element that start start from 1
			String policytype = QaBrowser.driver.findElement(By.xpath("//div[@id='hotel_price_con" + policyindex + "']/div/div/span")).getText();
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

			SBTResultPage.hotelAddToCart(addToCartIndex, hotelRemarks, policytype,resultPrice);
				

			}
}
		@AfterTest
		public static void After_Test() {

			QaExtentReport.test.getExtent().flush();

		}

	}