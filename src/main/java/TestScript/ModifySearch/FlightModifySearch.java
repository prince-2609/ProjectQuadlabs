package TestScript.ModifySearch;

import java.lang.reflect.Method;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import Base.TestBase;
import TestScript.RoundTrip.Flightcheck;
import utilities.QaDataProvider;
import utilities.QaExcelRead;
import utilities.QaLogger;
import utilities.QaRobot;

public class FlightModifySearch extends Flightcheck {

	TestBase t;
	QaExcelRead reader;
	public static String excelsh;

	@DataProvider
	public Object[][] getexceldata() throws Exception
	{

		return QaDataProvider.getExceldata("modify","mfytest");
	}
	
	@BeforeMethod
	public void beforeTestMethod(Method testMethod) {

		excelsh = testMethod.getName();
		System.out.println(excelsh);
	}

	@Test(dataProvider = "getexceldata")

	public static void mfytest(String ccode,String username, String password, String origin, String forigin,
			String destination, String fdestination, String ddate, String Triptype, String adult, String child,
			String infant, String fcurrency, String fclass, String airlines, String Morigin, String Mforigin,
			String Mdestination, String Mfdestination, String mdate, String madate, String madult, String mchild,
			String minfant, String mfclass, String mfcurrency, String mnationality, String mcountryResd, String Schedule,String ScheduleType) throws Exception {

		// TestBase.impliwait(30);
		// click on multicity button
		
		Companycode(ccode);

		test = report.createTest("flight Oneway Modify");

		TestBase.listofautosuggestion(By.xpath("//DIV[@id='divFLDepart']/P"), origin, forigin,
				By.xpath("//input[@id='fromcityAc']"));
		QaRobot.impliwait(10);

		TestBase.listofautosuggestion(By.xpath("//DIV[@id='divFLArrival']/P"), destination, fdestination,
				By.xpath("//input[@id='tocityAc']"));

		QaRobot.impliwait(10);

		String departdate = "id:id" + ddate;// id:id1252019
		String Fclass = "xpath://select[@id='ddl_class']/option[contains(text(),'" + fclass + "')]";
		String currency = "xpath://select[@id='ddl_currency']/option[contains(text(),'" + fcurrency + "')]";
		String modifydepdate = "xpath://a[contains(@title,'" + mdate + "')]";
		String modifyarrdate = "xpath://a[contains(@title,'" + madate + "')]";

		// departure date

		QaRobot.ClickOnElement("flight_depart_date", "Clicked on Flight Departure");

		Thread.sleep(1000);

		// ClickOnElement("nextmonth_calender", "Clicked on Next Month Button");
		// ClickOnElement("nextmonth_calender", "Clicked on Next Month Button");

		QaRobot.getLocator(departdate).click();// id1252019

		// Pax
		QaRobot.ClickOnElement("select_pax", "clicked on select PAX");

		// select adult
		QaRobot.selectValueFromDropdown("flight_adult", adult, "Selected Adult");

		// select child
		QaRobot.selectValueFromDropdown("flight_child", child, "Selected Child");

		// select infant
		QaRobot.selectValueFromDropdown("flight_infant", infant, "Selected Infant");

		// explicitwaitclickable(60,By.xpath("(//a[contains(text(),'More
		// Options')])[1]"));
		Thread.sleep(500);
		QaRobot.ClickOnElement("option", "clicked on interface");

		// click on more option
		QaRobot.ClickOnElement("more_option", "clicked on more option");

		// select currency

		QaRobot.ClickOnElement("flight_currency", "Selected Currency");
		QaRobot.getLocator(currency).click();

		// select class
		QaRobot.ClickOnElement("flight_class", "Selected Class");
		QaRobot.getLocator(Fclass).click();

		Thread.sleep(500);

		// PreferedAirline("preferd_airline", airlines, "search_airline");

		// take screenshot for search page

		String searchpage = QaLogger.takeScreenshot(driver, "Search Page");
		// test.log(Status.INFO, "Screenshot for Search Page");
		// test.addScreenCaptureFromPath(searchpage);
		test.log(Status.INFO, "Screenshot for Search Page",
				MediaEntityBuilder.createScreenCaptureFromPath(searchpage).build());

		// search
		QaRobot.ClickOnElement("flight_rsearch", "Clicked On Serach");

		QaRobot.explicitwaitinvisible(240, By.xpath("//*[@class='progress-bar progress-bar-striped active']"));
		// Thread.sleep(1000);

		// MODIFY SEARCH

		QaRobot.ClickOnElement("f_modify_search", "Clicked on Modify Search");

		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='MtxtDepartureCity0']")).clear();
		driver.findElement(By.xpath("//input[@id='MtxtDestinationCity0']")).clear();

		TestBase.listofautosuggestion(By.xpath("//DIV[@id='divDepartureCity0']/P"), Morigin, Mforigin,
				By.xpath("//input[@id='MtxtDepartureCity0']"));
		QaRobot.impliwait(10);

		TestBase.listofautosuggestion(By.xpath("//DIV[@id='divDestinationCity0']/P"), Mdestination, Mfdestination,
				By.xpath("//input[@id='MtxtDestinationCity0']"));

		QaRobot.impliwait(10);

		QaRobot.ClickOnElement("f_mreturnway", "Clicked on Return way");

		QaRobot.ClickOnElement("f_mdate", "Clicked on Flight Departure");

		QaRobot.getLocator(modifydepdate).click();

		QaRobot.ClickOnElement("f_madate", "Clicked on Flight Arrival");

		QaRobot.getLocator(modifyarrdate).click();

		// click on travellers
		QaRobot.ClickOnElement("traveller_class", "Clicked on Traveller");

		// select adult value
		QaRobot.selectValueFromDropdown("f_madult", madult, "Selected Adult");

		// select child value
		QaRobot.selectValueFromDropdown("f_mchild", mchild, "Selected Child");

		// select infant value
		QaRobot.selectValueFromDropdown("f_minfant", minfant, "Selected infant");

		// select class value
		QaRobot.selectTextFromDropdown("f_mclass", mfclass, "Selected Class");

		Thread.sleep(1000);

		// clicked on close
		QaRobot.ClickOnElement("f_mtraclose", "Clicked on close");

		// clicked on advance search
		QaRobot.ClickOnElement("f_advance_search", "Clicked on Advance Search");

		// select currency
		QaRobot.selectTextFromDropdown("f_mcurrency", mfcurrency, "Selected Currency");

		// select nationality
		QaRobot.selectTextFromDropdown("f_mnationality", mnationality, "Selected Nationality");

		// select countryResidence
		//selectTextFromDropdown("f_mcountry_residence", mcountryResd, "Selected CountryResidenceValue");

		// clicked on search
		QaRobot.ClickOnElement("f_msearch", "Clicked on Search");
		QaRobot.explicitwaitinvisible(240, By.xpath("//*[@class='progress-bar progress-bar-striped active']"));
		// Thread.sleep(3000);

		// get current url

		String url = driver.getCurrentUrl();

		System.out.println(url);

		String[] uid = url.split("=");

		test.log(Status.INFO, "Result page url is " + url);

		test.log(Status.INFO, "Session id is " + uid[1]);

		// If not getting result

		ResultnotFound("Result is not found after modify search");

		Thread.sleep(2000);
		

		// schedule departure

		if (Schedule.equalsIgnoreCase("Departure")) {
			// ClickOnElement("sch_deparron", "Clicked on Departure Schedule");
			float stype = Float.parseFloat(ScheduleType);

			if (stype <= 6.0) {

				QaRobot.ClickOnElement("sch_val0to6", "Clicked on Departure that time is between 0 to 6");
				QaRobot.ClickOnElement("sch1_val0to6", "Clicked on Departure that time is between 0 to 6");
				// Result not Found
				WebElement resultForDirect = QaRobot.getWebElement("flightresultnotfound");

				if (resultForDirect.isDisplayed()) {
					ResultnotFound("Result is not found between 0 to 6 AM");
				}
				List<WebElement> val0to6 = driver.findElements(By.xpath("//div[@class='fl_dep_time']/span"));
				for (WebElement value : val0to6) {
					try {
						String v = value.getText();
						String[] arrval = v.split("\\n");
						float afterreplace = Float.valueOf(arrval[0].replace(":", ".")).floatValue();
						if (afterreplace <= 6) {
							// Assert.assertEquals(stype, afterreplace);
							System.out.print(afterreplace);
							test.log(Status.PASS,
									"Departure Time is between 0 to 6 AM " + stype + "and " + afterreplace);
						}
					} catch (Exception e) {
						System.out.print("Value does not match " + e);
						test.log(Status.FAIL, "Departure Time is not between 0 to 6 AM " + stype);
					}
				}

			}

			else if (stype >= 6.0 && stype <= 12.0) {

				QaRobot.ClickOnElement("sch_val6to12", "Clicked on Departure that time is between 6 to 12");
				QaRobot.ClickOnElement("sch1_val6to12", "Clicked on Departure that time is between 6 to 12");
				// ClickOnElement("sch1_val6to12", "Clicked on Departure that
				// time is between 6 to 12");
				Thread.sleep(2000);
				// Result not Found
				WebElement resultForDirect = QaRobot.getWebElement("flightresultnotfound");

				if (resultForDirect.isDisplayed()) {
					ResultnotFound("Result is not found between 6 to 12 AM");
				}
				List<WebElement> val6to12 = driver.findElements(By.xpath("//div[@class='fl_dep_time']/span"));
				for (WebElement value : val6to12) {
					try {
						String v = value.getText();
						String[] arrval = v.split("\\n");
						float afterreplace = Float.valueOf(arrval[0].replace(":", ".")).floatValue();
						if (afterreplace >= 6.0 || afterreplace <= 12.0) {
							// Assert.assertEquals(stype, afterreplace);
							System.out.println(afterreplace);
							test.log(Status.PASS,
									"Departure Time is between 6 to 12 AM " + stype + " and " + afterreplace);
						}
					} catch (Exception e) {
						System.out.print("Value does not match " + e);
						test.log(Status.FAIL, "Departure Time is not between 6 to 12 AM " + stype);
					}
				}
			} else if (stype >= 12.0 && stype <= 18.0) {

				QaRobot.ClickOnElement("sch_val12to18", "Clicked on Departure that time is between 12 to 18");
				QaRobot.ClickOnElement("sch1_val12to18", "Clicked on Departure that time is between 12 to 18");
				Thread.sleep(2000);
				// Result not Found
				WebElement resultForDirect = QaRobot.getWebElement("flightresultnotfound");

				if (resultForDirect.isDisplayed()) {
					ResultnotFound("Result is not found between 12 to 18 PM");
				}
				List<WebElement> val12to18 = driver.findElements(By.xpath("//div[@class='fl_dep_time']/span"));
				for (WebElement value : val12to18) {
					try {
						String v = value.getText();
						String[] arrval = v.split("\\n");
						float afterreplace = Float.valueOf(arrval[0].replace(":", ".")).floatValue();
						if (afterreplace >= 12.0 || afterreplace <= 18.0) {
							// Assert.assertEquals(stype, afterreplace);
							System.out.println(afterreplace);
							test.log(Status.PASS,
									"Departure Time is between 12 to 18 PM " + stype + " and " + afterreplace);
						}
					} catch (Exception e) {
						System.out.print("Value does not match " + e);
						test.log(Status.FAIL, "Departure Time is not between 12 to 18 PM " + stype);
					}
				}
			} else if (stype >= 18.0 && stype <= 24.0) {

				QaRobot.ClickOnElement("sch_val18to24", "Clicked on Departure that time is between 18 to 24");
				QaRobot.ClickOnElement("sch1_val18to24", "Clicked on Departure that time is between 18 to 24");
				Thread.sleep(2000);
				// Result not Found
				WebElement resultForDirect = QaRobot.getWebElement("flightresultnotfound");

				if (resultForDirect.isDisplayed()) {
					ResultnotFound("Result is not found between 18 to 24 PM");
				}
				List<WebElement> val18to24 = driver.findElements(By.xpath("//div[@class='fl_dep_time']/span"));
				for (WebElement value : val18to24) {
					try {
						String v = value.getText();
						String[] arrval = v.split("\\n");
						float afterreplace = Float.valueOf(arrval[0].replace(":", ".")).floatValue();
						if (afterreplace >= 18.0 || afterreplace <= 24.0) {
							// Assert.assertEquals(stype, afterreplace);
							System.out.println(afterreplace);
							test.log(Status.PASS,
									"Departure Time is between 18 to 24 PM " + stype + " and " + afterreplace);
						}
					} catch (Exception e) {
						System.out.print("Value does not match " + e);
						test.log(Status.FAIL, "Departure Time is not between 18 to 24 PM " + stype);
					}
				}
			}

		} else {
			QaRobot.ClickOnElement("sch_deparron", "Clicked on Arrival Schedule");
			float stype = Float.parseFloat(ScheduleType);

			if (stype <= 6.0) {

				QaRobot.ClickOnElement("sch_arr0to6", "Clicked on Arrival that time is between 0 to 6");
				QaRobot.ClickOnElement("sch1_arr0to6", "Clicked on Arrival that time is between 0 to 6");
				Thread.sleep(2000);
				// Result not Found
				WebElement resultForDirect = QaRobot.getWebElement("flightresultnotfound");

				if (resultForDirect.isDisplayed()) {
					ResultnotFound("Result is not found between 0 to 6 AM");
				}
				List<WebElement> val0to6 = driver.findElements(By.xpath("//div[@class='fl_arrive']/span"));
				for (WebElement value : val0to6) {
					try {
						String v = value.getText();
						String[] arrval = v.split("\\n");
						float afterreplace = Float.valueOf(arrval[0].replace(":", ".")).floatValue();
						if (afterreplace <= 6) {
							// Assert.assertEquals(stype, afterreplace);
							System.out.print(afterreplace);
							test.log(Status.PASS, "Arrival Time is between 0 to 6 AM " + stype + "and " + afterreplace);
						}
					} catch (Exception e) {
						System.out.print("Value does not match " + e);
						test.log(Status.FAIL, "Arrival Time is not between 0 to 6 AM " + stype);
					}
				}
			}

			else if (stype >= 6.0 && stype <= 12.0) {

				QaRobot.ClickOnElement("sch_arr6to12", "Clicked on Arrival that time is between 6 to 12");
				QaRobot.ClickOnElement("sch1_arr6to12", "Clicked on Arrival that time is between 6 to 12");
				Thread.sleep(2000);
				// Result not Found
				WebElement resultForDirect = QaRobot.getWebElement("flightresultnotfound");

				if (resultForDirect.isDisplayed()) {
					ResultnotFound("Result is not found between 6 to 12 AM");
				}
				List<WebElement> val6to12 = driver
						.findElements(By.xpath("//div[@class='fl_arrive']/span[contains(text(),'')]"));
				for (WebElement value : val6to12) {
					try {
						String v = value.getText();
						String[] arrval = v.split("\\n");
						float afterreplace = Float.valueOf(arrval[0].replace(":", ".")).floatValue();
						if (afterreplace >= 6.0 || afterreplace <= 12.0) {
							// Assert.assertEquals(stype, afterreplace);
							System.out.println(afterreplace);
							test.log(Status.PASS,
									"Arrival Time is between 6 to 12 AM " + stype + " and " + afterreplace);
						}
					} catch (Exception e) {
						System.out.print("Value does not match " + e);
						test.log(Status.FAIL, "Arrival Time is not between 6 to 12 AM " + stype);
					}
				}

			} else if (stype >= 12.0 && stype <= 18.0) {

				QaRobot.ClickOnElement("sch_arr12to18", "Clicked on Arrival that time is between 12 to 18");
				QaRobot.ClickOnElement("sch1_arr12to18", "Clicked on Arrival that time is between 12 to 18");
				Thread.sleep(2000);
				// Result not Found
				WebElement resultForDirect = QaRobot.getWebElement("flightresultnotfound");

				if (resultForDirect.isDisplayed()) {
					ResultnotFound("Result is not found between 12 to 18 PM");
				}
				List<WebElement> val12to18 = driver.findElements(By.xpath("//div[@class='fl_arrive']/span"));
				for (WebElement value : val12to18) {
					try {
						String v = value.getText();
						String[] arrval = v.split("\\n");
						float afterreplace = Float.valueOf(arrval[0].replace(":", ".")).floatValue();
						if (afterreplace >= 12.0 || afterreplace <= 18.0) {
							// Assert.assertEquals(stype, afterreplace);
							System.out.println(afterreplace);
							test.log(Status.PASS,
									"Arrival Time is between 12 to 18 PM " + stype + " and " + afterreplace);
						}
					} catch (Exception e) {
						System.out.print("Value does not match " + e);
						test.log(Status.FAIL, "Arrival Time is not between 12 to 18 PM " + stype);
					}
				}
			} else if (stype >= 18.0 && stype <= 24.0) {

				QaRobot.ClickOnElement("sch_arr18to24", "Clicked on Arrival that time is between 18 to 24");
				QaRobot.ClickOnElement("sch1_arr18to24", "Clicked on Arrival that time is between 18 to 24");
				Thread.sleep(2000);
				// Result not Found
				WebElement resultForDirect = QaRobot.getWebElement("flightresultnotfound");

				if (resultForDirect.isDisplayed()) {
					ResultnotFound("Result is not found between 18 to 24 PM");
				}
				List<WebElement> val18to24 = driver.findElements(By.xpath("//div[@class='fl_arrive']/span"));
				for (WebElement value : val18to24) {
					try {
						String v = value.getText();
						String[] arrval = v.split("\\n");
						float afterreplace = Float.valueOf(arrval[0].replace(":", ".")).floatValue();
						if (afterreplace >= 18.0 || afterreplace <= 24.0) {
							System.out.println(afterreplace);
							test.log(Status.PASS,
									"Arrival Time is between 18 to 24 PM " + stype + " and " + afterreplace);
						}
					} catch (Exception e) {
						System.out.print("Value does not match " + e);
						test.log(Status.FAIL, "Arrival Time is not between 18 to 24 PM " + stype);
					}
				}
			}

		}
		
		//check reset filter is work or not
		
		QaRobot.ClickOnElement("resetfilter", "clicked on reset filter");
	}
	
	

	@AfterMethod
	public static void afterMetod() {
		test.getExtent().flush();
	}

}
