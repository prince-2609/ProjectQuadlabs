package product.Flight.suite.Oneway;

import org.openqa.selenium.By;
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
public class flightBusinessAddToCart
{
	public static String resultPagePrice;

	@DataProvider
	public Object[][] getexceldata() throws Exception {

		return QaDataProvider.getTestdata("SBT_Flight", "Addtocart");
	}

	@Test(dataProvider = "getexceldata")
	public static void Sbt_flight_Search(String ccode,String URL, String compCode, String uname, String pwd, String corptraveller,
			String origin, String forigin, String destination, String fdesti, String ddate, String triptype,
			String adult, String child, String infant, String currency, String fclass, String preairline,
			String nationality, String booknowindex, String policyindex,
			String addtocartindex, String addToCartRemarks) throws Exception {

		QaExtentReport.test = QaExtentReport.report.createTest("Test On Add to cart flight for Business");
		TestBase.Companycode(ccode,URL); 
		QaRobot.impliwait(30);
		Login.SbtLogin(uname, pwd);
		// login on sbt
//		Login.V12SbtLogin(compCode, uname, pwd);
		// close notification
		// QaBrowser.driver.findElement(By.xpath("//a[@id='btnClosePopUpNotification']")).click();
		// select the traveler
		SearchDashboard.selectEmployeeWithID(corptraveller);
		// select the trip type
		QaRobot.ClickOnElement("trip_Busniess");
		QaExtentReport.test.log(Status.INFO, "<b><i>Search for business trip</i></b>");
		// select one way trip
		QaRobot.ClickOnElement("ow_onewaytrip");
		QaExtentReport.test.log(Status.INFO, "<b><i>Flight oneway trip</i></b>");
		Thread.sleep(1000);
		TestBase.listofautosuggestion(By.xpath("//div[@id='divDepartureCity']/p"), origin, forigin,
				By.xpath("//input[@id='txtDepartureCity']"));
		Thread.sleep(1000);
		
		QaBrowser.driver.findElement(By.xpath("//div[@id='divDepartureCity']/p")).click();

		QaExtentReport.test.log(Status.INFO, "Departure city : " + forigin);

		Thread.sleep(1000);

		TestBase.listofautosuggestion(By.xpath("//div[@id='divDestinationCity']/p"), destination, fdesti,
				By.xpath("//input[@id='txtDestinationCity']"));
		Thread.sleep(1000);
		QaExtentReport.test.log(Status.INFO, "Arrival city : " + fdesti);

		// Thread.sleep(500);
		// click on departure date icon
		QaBrowser.driver.findElement(By.xpath("//*[@id=\"flight_way1\"]/div[2]/div[1]/div/div/label/span[2]/span[1]/img")).click();

		Thread.sleep(500);
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
		
		QaExtentReport.extentScreenshot("Search Page");
		
		// click on search flight button
		QaRobot.ClickOnElement("ow_searchflight");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on search flight button</i></b>");

		Thread.sleep(20000);
		// explicit wait till loader invisible
//		QaRobot.explicitwaitinvisible(200, By.xpath("//div[@class='flight-wait-progress progress ng-hide']"));

		if (QaBrowser.driver.findElement(By.xpath("//p[contains(text(),'Sorry, could not find desired results. Please try again.')]")).isDisplayed()) {
			// fail the test case and screenshot
//			String resultnotfound = Logger.takeScreenshot(QaBrowser.driver, "D:\\Screenshot\\resultnotfound.png");
//			QaExtentReport.test.log(Status.FAIL, "Results are not found");
		} else {

			// get price of result page
			resultPagePrice = QaBrowser.driver.findElement(By.xpath("(//div[@class='fl_price_fmt']/p[2]/span/span[2])[" + booknowindex + "]")).getText();
			System.out.println("Result page price is " + resultPagePrice);
			QaExtentReport.test.log(Status.INFO, "Result page price is " + resultPagePrice);
			QaExtentReport.extentScreenshot("Result1 Page");
			// get text of element that start start from 1
			String policytype = QaBrowser.driver.findElement(By.xpath("(//span[contains(@id,'PT_')])[" + policyindex + "]")).getText();

			// Send Quotation
			SBTResultPage.addToCart(addtocartindex, addToCartRemarks,resultPagePrice,policytype);
			QaExtentReport.extentScreenshot("Result Page");
		}
	}

	@AfterTest
	public static void After_Test() {

		QaExtentReport.test.getExtent().flush();

	}
}
