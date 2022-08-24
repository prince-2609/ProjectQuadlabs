package TestScript.ModifySearch;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import Base.TestBase;
import TestScript.RoundTrip.Flightcheck;
import utilities.QaDataProvider;
import utilities.QaExcelRead;
import utilities.QaExtentReport;
import utilities.Logger;
import utilities.QaRobot;

@Listeners(listenerClass.Listener.class)
public class FlightAirline extends Flightcheck {

	TestBase t;
	QaExcelRead reader;
	// public static String excelsh;

	@DataProvider
	public Object[][] getexceldata() throws Exception {
		return QaDataProvider.getTestdata("modify","Duration");
	}

	@Test(dataProvider = "getexceldata")

	public static void Duration(String ccode,String URL,String username, String password, String origin, String forigin, String destination,
			String fdestination, String ddate, String Triptype, String adult, String child, String infant,
			String fcurrency, String fclass, String airlines, String type, String faretype) throws Exception {
		
		TestBase.Companycode(ccode,URL); 
		QaRobot.pageLoad(30);
		QaRobot.impliwait(30);
		
		QaExtentReport.test = QaExtentReport.report.createTest("Test on Flight Airline Filter");
//		Companycode(ccode);
//
//		test = report.createTest("Flight Airline Filter");

		TestBase.listofautosuggestion(By.xpath("//DIV[@id='divFLDepart']/P"), origin, forigin,
				By.xpath("//input[@id='fromcityAc']"));
//		QaRobot.impliwait(10);

		TestBase.listofautosuggestion(By.xpath("//DIV[@id='divFLArrival']/P"), destination, fdestination,
				By.xpath("//input[@id='tocityAc']"));

//		QaRobot.impliwait(10);

		String departdate = "id:id" + ddate;// id:id1252019
		String Fclass = "xpath://select[@id='ddl_class']/option[contains(text(),'" + fclass + "')]";
		String currency = "xpath://select[@id='ddl_currency']/option[contains(text(),'" + fcurrency + "')]";

		// departure date

		QaRobot.ClickOnElement("flight_depart_date");
		QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Flight Departure</i></b>");

		Thread.sleep(1000);

		// ClickOnElement("nextmonth_calender", "Clicked on Next Month Button");
		// ClickOnElement("nextmonth_calender", "Clicked on Next Month Button");

		QaRobot.getLocator(departdate).click();// id1252019

		// Pax
		QaRobot.ClickOnElement("select_pax");
		QaExtentReport.test.log(Status.INFO,"<b><i>clicked on select PAX</i></b>");

		// select adult
		QaRobot.selectValueFromDropdown("flight_adult", adult, "Selected Adult");

		// select child
		QaRobot.selectValueFromDropdown("flight_child", child, "Selected Child");

		// select infant
		QaRobot.selectValueFromDropdown("flight_infant", infant, "Selected Infant");

		// explicitwaitclickable(60,By.xpath("(//a[contains(text(),'More
		// Options')])[1]"));
		Thread.sleep(500);
		QaRobot.ClickOnElement("option");
		QaExtentReport.test.log(Status.INFO,"<b><i>clicked on interface</i></b>");

		// click on more option
		QaRobot.ClickOnElement("more_option");
		QaExtentReport.test.log(Status.INFO,"<b><i>clicked on more option</i></b>");

		// select currency

		QaRobot.ClickOnElement("flight_currency");
		QaExtentReport.test.log(Status.INFO,"<b><i>Selected Currency</i></b>");
		
		QaRobot.getLocator(currency).click();

		// select class
		QaRobot.ClickOnElement("flight_class");
		QaExtentReport.test.log(Status.INFO,"<b><i>Selected Class</i></b>");

		QaRobot.getLocator(Fclass).click();

		Thread.sleep(500);

		// PreferedAirline("preferd_airline", airlines, "search_airline");

		// take screenshot for search page

		String searchpage = Logger.takeScreenshot(driver, "Search Page");
		// test.log(Status.INFO, "Screenshot for Search Page");
		// test.addScreenCaptureFromPath(searchpage);
		test.log(Status.INFO, "Screenshot for Search Page",
				MediaEntityBuilder.createScreenCaptureFromPath(searchpage).build());

		// search
		QaRobot.ClickOnElement("flight_rsearch");
		QaExtentReport.test.log(Status.INFO,"<b><i>Clicked On Serach</i></b>");

		QaRobot.explicitwaitinvisible(240, By.xpath("//*[@class='progress-bar progress-bar-striped active']"));
		
		//Getting all airline name from filter 

		List<WebElement> airlinenames = driver
				.findElements(By.xpath("(//div[@class='filter_con ng-scope'])[4]/div/ul/li/label/span"));

		for (WebElement airline : airlinenames) {

			String airname = airline.getText();

			System.out.println("name is " + airname);

			// uncheck accordingly

			// check airline filter in Filter

			driver.findElement(
					By.xpath("(//div[@class='filter_con ng-scope'])[4]/div/ul/li/label/span[text()='" + airname + "']"))
					.click();

			// check airline filter outside Filter

			// driver.findElement(By.xpath("(//li[@class='airline_sepret_row fl
			// ng-scope']/span/span[text()='"+ airname +"'])[1]")).click();
			test.log(Status.INFO, "Clicked on " + airname);

			Thread.sleep(2000);
			
			//Verify result airline to filter airline

			List<WebElement> resultairlines = driver
					.findElements(By.xpath("//div[@class='fl_dep_ailine airl_Name']/span"));
			for (WebElement resultairname : resultairlines) {

				String RA = resultairname.getText();
				Thread.sleep(1000);
				try {
					Assert.assertEquals(airname, RA);
					Thread.sleep(1000);
					test.log(Status.PASS, "Selected Airline is matched with " + RA);
				} catch (Exception e) {
					System.out.print("Value does not match with " + RA);
					test.log(Status.FAIL, " Selected Airline is not matched with " + RA);
				}
			}

			// disable

			driver.findElement(
					By.xpath("(//div[@class='filter_con ng-scope'])[4]/div/ul/li/label/span[text()='" + airname + "']"))
					.click();
			Thread.sleep(4000);
		}
	}

	@AfterMethod
	public static void afterMetod() {
		test.getExtent().flush();
	}

}
