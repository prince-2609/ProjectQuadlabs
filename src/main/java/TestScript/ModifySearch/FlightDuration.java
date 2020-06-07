package TestScript.ModifySearch;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import Base.TestBase;
import TestScript.RoundTrip.Flightcheck;
import utilities.QaDataProvider;
import utilities.QaExcelRead;
import utilities.Logger;
import utilities.QaRobot;

public class FlightDuration extends Flightcheck {

	TestBase t;
	QaExcelRead reader;
	// public static String excelsh;

	@DataProvider
	public Object[][] getexceldata() throws Exception {

		
		
		return QaDataProvider.getTestdata("modify","Duration");
	}

	@Test(dataProvider = "getexceldata")

	public static void Duration(String ccode,String username, String password, String origin, String forigin, String destination,
			String fdestination, String ddate, String Triptype, String adult, String child, String infant,
			String fcurrency, String fclass, String airlines, String type, String faretype) throws Exception {

		Companycode(ccode);
		
		test = report.createTest("Flight Duration");

		TestBase.listofautosuggestion(By.xpath("//DIV[@id='divFLDepart']/P"), origin, forigin,
				By.xpath("//input[@id='fromcityAc']"));
		QaRobot.impliwait(10);

		TestBase.listofautosuggestion(By.xpath("//DIV[@id='divFLArrival']/P"), destination, fdestination,
				By.xpath("//input[@id='tocityAc']"));

		QaRobot.impliwait(10);

		String departdate = "id:id" + ddate;// id:id1252019
		String Fclass = "xpath://select[@id='ddl_class']/option[contains(text(),'" + fclass + "')]";
		String currency = "xpath://select[@id='ddl_currency']/option[contains(text(),'" + fcurrency + "')]";

		float dtype = 0;

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

		String searchpage = Logger.takeScreenshot(driver, "Search Page");
		// test.log(Status.INFO, "Screenshot for Search Page");
		// test.addScreenCaptureFromPath(searchpage);
		test.log(Status.INFO, "Screenshot for Search Page",
				MediaEntityBuilder.createScreenCaptureFromPath(searchpage).build());

		// search
		QaRobot.ClickOnElement("flight_rsearch", "Clicked On Serach");

		QaRobot.explicitwaitinvisible(240, By.xpath("//*[@class='progress-bar progress-bar-striped active']"));

		// // DURATION

		
		//getting Duration Button text
		
		String textvalue = driver.findElement(By.xpath("(//span[@class='ng-binding clsDuration full bxs txt-ac'])[1]"))
				.getText();
		System.out.println("Button value is " + textvalue);
		String[] text = textvalue.split("-");
		float range = Float.valueOf(text[0].replace("h", " ")).floatValue();
		float range1 = Float.valueOf(text[1].replace("h", " ")).floatValue();
		dtype = range1;

		System.out.println("Range is " + range + range1);

		if (dtype <= range1) {

			QaRobot.ClickOnElement("dur_val0to5",
					"Clicked on Duration that duration is between " + range + " to " + range1 + " Hours");
			Thread.sleep(2000);
			
			// Result not Found
			WebElement resultForDirect = QaRobot.getWebElement("flightresultnotfound");

			if (resultForDirect.isDisplayed()) {
				ResultnotFound("Result is not found between " + range + " to " + range1 + " Hours");
				System.out.println("Result is not found between " + range + " to " + range1);
				
			}
			
			List<WebElement> val0to5 = driver.findElements(By.xpath("//div[@class='fl_duration']"));
			for (WebElement value : val0to5) {
				try {
					String v = value.getText();
					float afterreplace = Float.valueOf(v.replace("h ", ".").replace('m', ' ')).floatValue();

					if (afterreplace <= range1) {

						System.out.println("value is " + afterreplace);
						test.log(Status.PASS, "Duration is between " + afterreplace);
					}
					Thread.sleep(1000);
				} catch (Exception e) {

					System.out.println("Value does not match ");
					test.log(Status.FAIL, "Duration is not between " + range + " to " + range1 + " Hours" );
				}
			}

		}
		QaRobot.ClickOnElement("ac_dur1", "Unactive button between " + range + " to " + range1);

		String textvalue1 = driver.findElement(By.xpath("(//span[@class='ng-binding clsDuration full bxs txt-ac'])[2]"))
				.getText();
		System.out.println("Button value is " + textvalue1);
		String[] text1 = textvalue1.split("-");
		float range2 = Float.valueOf(text1[0].replace("h", " ")).floatValue();
		float range3 = Float.valueOf(text1[1].replace("h", " ")).floatValue();
		dtype = range3;
		if (dtype >= range2 && dtype <= range3) {

			QaRobot.ClickOnElement("dur_val5to10",
					"Clicked on Duration that duration is between " + range2 + " to " + range3 + " Hours");
			Thread.sleep(2000);
			// Result not Found
			WebElement resultForDirect = QaRobot.getWebElement("flightresultnotfound");

			if (resultForDirect.isDisplayed()) {
				ResultnotFound("Result is not found between " + range2 + " to " + range3 + " Hours");
				System.out.println("Result is not found between " + range2 + " to " + range3);
			
			}
			List<WebElement> val5to10 = driver.findElements(By.xpath("//div[@class='fl_duration']"));
			for (WebElement value : val5to10) {
				try {
					String v = value.getText();
					float afterreplace = Float.valueOf(v.replace("h ", ".").replace('m', ' ')).floatValue();

					if (afterreplace >= range2 && afterreplace <= range3) {

						System.out.println("value is " + afterreplace);
						test.log(Status.PASS, " Duration is " + afterreplace);
					}
					Thread.sleep(1000);
				} catch (Exception e) {
					System.out.println("Value does not match ");
					test.log(Status.FAIL, "Duration is not between " + range2 + " to " + range3 + " Hours " );
				}
			}

		}
		Thread.sleep(500);
		QaRobot.ClickOnElement("ac_dur1", "Unactive button between " + range2 + " to " + range3);
		
		Thread.sleep(500);

		String textvalue2 = driver.findElement(By.xpath("(//span[@class='ng-binding clsDuration full bxs txt-ac'])[3]"))
				.getText();
		System.out.println("Button value is " + textvalue2);
		String[] text2 = textvalue2.split("-");
		float range4 = Float.valueOf(text2[0].replace("h", " ")).floatValue();
		float range5 = Float.valueOf(text2[1].replace("h", " ")).floatValue();
		dtype = range5;
		if (dtype >= range4 && dtype <= range5) {

			QaRobot.ClickOnElement("dur_val10to15",
					"Clicked on Duration that duration is between " + range4 + " to " + range5 + " Hours");
			Thread.sleep(2000);
			// Result not Found
			WebElement resultForDirect = QaRobot.getWebElement("flightresultnotfound");

			if (resultForDirect.isDisplayed()) {
				ResultnotFound("Result is not found between " + range4 + " to " + range5);
			}
			List<WebElement> val10to15 = driver.findElements(By.xpath("//div[@class='fl_duration']"));
			for (WebElement value : val10to15) {
				try {
					String v = value.getText();
					float afterreplace = Float.valueOf(v.replace("h ", ".").replace('m', ' ')).floatValue();

					if (afterreplace >= range4 && afterreplace <= range5) {

						System.out.println("value is " + afterreplace);
						test.log(Status.PASS, "Duration is " + afterreplace);
					}
					Thread.sleep(1000);
				} catch (Exception e) {
					System.out.println("Value does not match ");
					test.log(Status.FAIL, "Duration is not between " + range4 + " to " + range5 + " Hours " );
				}
			}

		}

		QaRobot.ClickOnElement("ac_dur1", "Unactive button between " + range4 + " to " + range5);

		String textvalue3 = driver.findElement(By.xpath("(//span[@class='ng-binding clsDuration full bxs txt-ac'])[4]"))
				.getText();
		System.out.println("Button value is " + textvalue3);
		String[] text3 = textvalue3.split("-");
		float range6 = Float.valueOf(text3[0].replace("h+", " ")).floatValue();
		dtype = range6;

		if (dtype >= range6) {

			QaRobot.ClickOnElement("dur_val15+", "Clicked on Duration that duration is more than " + range6 + " Hours");
			Thread.sleep(2000);
			// Result not Found
			WebElement resultForDirect = QaRobot.getWebElement("flightresultnotfound");

			if (resultForDirect.isDisplayed()) {
				ResultnotFound("Result is not found more than " + range6 + " Hours");
			}
			List<WebElement> val15 = driver.findElements(By.xpath("//div[@class='fl_duration']"));
			for (WebElement value : val15) {
				try {
					String v = value.getText();
					float afterreplace = Float.valueOf(v.replace("h ", ".").replace('m', ' ')).floatValue();

					if (afterreplace >= range6) {

						System.out.println("value is " + afterreplace);
						test.log(Status.PASS,
								"Duration is "  + afterreplace);
					}
					Thread.sleep(1000);
				} catch (Exception e) {
					System.out.println("Value does not match ");
					test.log(Status.FAIL, "Duration is not More than " + range6 + " Hours " );
				}
			}

		}

		QaRobot.ClickOnElement("ac_dur1", "Unactive button between " + range4);

		// stop

		Thread.sleep(2000);
		if (type.equalsIgnoreCase("Direct")) {

			// zero Stop

			QaRobot.ClickOnElement("zerostop", "Clicked on Direct Flight");
			Thread.sleep(2000);

			// If not getting result
			WebElement resultForDirect = QaRobot.getWebElement("flightresultnotfound");

			if (resultForDirect.isDisplayed()) {
				ResultnotFound("Result is not found for direct flight");
			}
			List<WebElement> zerostopvalue = driver
					.findElements(By.xpath("//p[@class='fl_dur_stop ng-binding' and contains(text(),'Direct')]"));
			for (WebElement value0 : zerostopvalue) {
				try {
					Assert.assertEquals(type, value0.getText());
					test.log(Status.PASS, "Value is match by " + type + " Stop");
					System.out.println("Value is match by " + type + " Stop");
				} catch (Exception e) {
					System.out.print("Value does not match " + e);
					test.log(Status.FAIL, "Value is not match by " + type);
				}
			}
			QaRobot.ClickOnElement("AfterOnStop", "Unactive Direct Flight");

		} else if (type.equalsIgnoreCase("1Stop")) {
			QaRobot.ClickOnElement("onestop", "Clicked on One Stop");
			Thread.sleep(2000);

			// If not getting result
			WebElement resultForDirect = QaRobot.getWebElement("flightresultnotfound");

			if (resultForDirect.isDisplayed()) {
				ResultnotFound("Result is not found for One stop flight");
			}
			List<WebElement> onestopvalue = driver
					.findElements(By.xpath("//p[@class='fl_dur_stop ng-binding' and contains(text(),'1Stop')]"));
			for (WebElement value1 : onestopvalue) {
				try {
					Assert.assertEquals(type, value1.getText());
					System.out.println("Value is match by " + type + " Stop");
					test.log(Status.PASS, "Value is match by " + type);
				} catch (Exception e) {
					System.out.print("Value does not match " + e);
					test.log(Status.FAIL, "Value is not match by" + type);
				}
			}

			QaRobot.ClickOnElement("AfterOnStop", "Unactive One Stop");
		} else if (type.equalsIgnoreCase("2Stop")) {
			QaRobot.ClickOnElement("twostop", "Clicked on One Stop");
			Thread.sleep(2000);

			// If not getting result
			WebElement resultForDirect = QaRobot.getWebElement("flightresultnotfound");

			if (resultForDirect.isDisplayed()) {
				ResultnotFound("Result is not found for two and more than two stop for flight");
			}
			List<WebElement> twostopvalue = driver
					.findElements(By.xpath("//p[@class='fl_dur_stop ng-binding' and contains(text(),'2Stop')]"));
			for (WebElement value2 : twostopvalue) {
				try {
					Assert.assertEquals(type, value2.getText());
					test.log(Status.PASS, "Value is match by " + type);
					System.out.println("Value is match by " + type + " Stop");
				} catch (Exception e) {
					System.out.print("Value does not match " + e);
					test.log(Status.FAIL, "Value is not match by " + type);
				}
			}

			QaRobot.ClickOnElement("AfterOnStop", "Unactive Two and More than two Stop");
		}

		Thread.sleep(1000);

		// FARE TYPE

		if (faretype.equalsIgnoreCase("Refundable")) {

			QaRobot.ClickOnElement("f_refundable", "Clicked on Refundable Flight");
			Thread.sleep(2000);

			// If not getting result
			WebElement resultForDirect = QaRobot.getWebElement("flightresultnotfound");

			if (resultForDirect.isDisplayed()) {
				ResultnotFound("Result is not found for Refundable Flight");
			}
			List<WebElement> refundablevalue = driver.findElements(
					By.xpath("//p[@class='set_RefundableFare ng-binding' and contains(text(),'Refundable')]"));
			for (WebElement refund : refundablevalue) {
				try {
					Assert.assertEquals(faretype, refund.getText());
					System.out.println("Value is match by " + faretype);
					test.log(Status.PASS, "Value is match by " + faretype);
				} catch (Exception e) {
					System.out.print("Value does not match " + e);
					test.log(Status.FAIL, "Value is not match by " + faretype);
				}
			}

			QaRobot.ClickOnElement("f_refundable", "Unactive Refundable Flight");

		} else if (faretype.equalsIgnoreCase("Non-Refundable")) {
			QaRobot.ClickOnElement("f_nonrefundable", "Clicked on Non Refundable Stop");
			Thread.sleep(2000);

			// If not getting result
			WebElement resultForDirect = QaRobot.getWebElement("flightresultnotfound");

			if (resultForDirect.isDisplayed()) {
				ResultnotFound("Result is not found for Non-Refundable Flight");
			}
			List<WebElement> NonRefundablepvalue = driver.findElements(
					By.xpath("//p[@class='set_RefundableFare ng-binding' and contains(text(),'Non-Refundable')]"));
			for (WebElement nonrefund : NonRefundablepvalue) {
				try {
					Assert.assertEquals(faretype, nonrefund.getText());
					System.out.println("Value is match by " + faretype);
					test.log(Status.PASS, "Value is match by " + faretype);
				} catch (Exception e) {
					System.out.print("Value does not match " + e);
					test.log(Status.FAIL, "Value is not match by" + faretype);
				}
			}
			QaRobot.ClickOnElement("f_nonrefundable", "Unactive Non Refundable Flight");
		}

	}

	@AfterMethod
	public static void afterMetod() {
		test.getExtent().flush();
	}

}
