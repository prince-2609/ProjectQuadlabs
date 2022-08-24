package CAM;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Base.TestBase;
import utilities.QaBrowser;
import utilities.QaDataProvider;
import utilities.QaExtentReport;
import utilities.QaRobot;
@Listeners(listenerClass.Listener.class)
public class policyWorkflow
{
	static String monthName = "";
	static int currentMonthNumber;

	@DataProvider
	public Object[][] getexceldata() throws Exception 
	{
		return QaDataProvider.getTestdata("Policyworkflow", "Sheet1");
	}
	
	@Test(dataProvider = "getexceldata")
	public static void Profiling(String Source, String URL, String Comapnycode, String Username, String Password,
			String TravelPolicyTitle, String Travelpurpose, String TravelCategory, String Product, String RuleAppliedOn,
			String policy_criteria, String CostFrom, String CostTo, String TxtAirlines, String month,
			String monthNumber, String Bookingdatefrom, String month_nameto, String month_numberto,
			String BookingdateTo) throws Exception {


		TestBase.Companycode(Source,URL); 
		QaRobot.impliwait(30);
		
		QaExtentReport.test = QaExtentReport.report.createTest("Test On Policy work flow");
		//write comapany code
		
		//QaRobot.PassValue("Comapnycode",Comapnycode,"write Comapnycode");
		
		QaRobot.PassValue("User_name",Username);
		QaExtentReport.test.log(Status.INFO,"<b><i>Write Username</i></b>");
			
		QaRobot.PassValue("Password",Password);
		QaExtentReport.test.log(Status.INFO,"<b><i>Write Password</i></b>");
		
		QaRobot.ClickOnElement("Submit");
		QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on submit</i></b>");

		Thread.sleep(1000);

		QaRobot.mouseHover("//a[@id='HeaderTop_aSetting']", "//span[@id='HeaderTop_lblPolicyManagement']");
		Thread.sleep(100);

		QaRobot.ClickOnElement("Managetravelpolicy");
		QaExtentReport.test.log(Status.INFO,"<b><i>click on Managetravelpolicy</i></b>");
		Thread.sleep(100);

		QaRobot.ClickOnElement("Add_Policy");
		QaExtentReport.test.log(Status.INFO,"<b><i>click on Add_Policy</i></b>");
		Thread.sleep(100);

		QaRobot.PassValue("TravelPolicyTitle", TravelPolicyTitle);
		QaExtentReport.test.log(Status.INFO,"<b><i>Write TravelPolicyTitle</i></b>");
		Thread.sleep(100);

		if (Travelpurpose.equalsIgnoreCase("Business")) {

			WebElement element = QaBrowser.driver.findElement(By.xpath("//input[@id='radioBussinessTrip']"));
			JavascriptExecutor executor = (JavascriptExecutor) QaBrowser.driver;
			executor.executeScript("arguments[0].click();", element);

		} else if (Travelpurpose.equalsIgnoreCase("Family")) {
			WebElement element = QaBrowser.driver.findElement(By.xpath("//input[@id='radioAnnualFamilyTrip']"));
			JavascriptExecutor executor = (JavascriptExecutor) QaBrowser.driver;
			executor.executeScript("arguments[0].click();", element);
		} else if (Travelpurpose.equalsIgnoreCase("Guest")) {
			WebElement element = QaBrowser.driver.findElement(By.xpath("//input[@id='radioguest']"));
			JavascriptExecutor executor = (JavascriptExecutor) QaBrowser.driver;
			executor.executeScript("arguments[0].click();", element);
		}
		QaRobot.selectTextFromDropdown("SelectTravelCategory", TravelCategory, "SelectTravelCategory");
		Thread.sleep(100);

		QaRobot.selectTextFromDropdown("SelectProduct", Product, "SelectProduct");
		Thread.sleep(100);

		if (RuleAppliedOn.equalsIgnoreCase("Corporate")) {
			QaRobot.selectTextFromDropdown("RuleAppliedOn", RuleAppliedOn, "RuleAppliedOn");
			Thread.sleep(100);

			QaRobot.ClickOnElement("Selectvaluefromlist");
			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Selectvaluefromlist</i></b>");
			Thread.sleep(100);

			QaRobot.ClickOnElement("Add_rule");
			QaExtentReport.test.log(Status.INFO,"<b><i>Click on Add_rule</i></b>");
			Thread.sleep(1000);
		}

		else if (RuleAppliedOn.equalsIgnoreCase("Corporate-Branch")) {
			QaRobot.selectTextFromDropdown("RuleAppliedOn", RuleAppliedOn, "RuleAppliedOn");
			Thread.sleep(100);

			QaRobot.ClickOnElement("Selectvaluefromlist");
			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Selectvaluefromlist</i></b>");
			Thread.sleep(100);

			QaRobot.ClickOnElement("Add_rule");
			QaExtentReport.test.log(Status.INFO,"<b><i>Click on Add_rule</i></b>");
			Thread.sleep(3000);

		}
		if (policy_criteria.equalsIgnoreCase("Cost Range")) {

			QaRobot.selectTextFromDropdown("criteria_Flight", policy_criteria, "criteria_Flight");
			Thread.sleep(100);

			QaRobot.PassValue("Cosfrom", CostFrom);
			QaExtentReport.test.log(Status.INFO,"<b><i>Write Cosfrom</i></b>");
			Thread.sleep(100);

			QaRobot.PassValue("Costto", CostTo);
			QaExtentReport.test.log(Status.INFO,"<b><i>Write Costto</i></b>");
			Thread.sleep(100);

			QaRobot.ClickOnElement("Selectandclose_btn");
			QaExtentReport.test.log(Status.INFO,"<b><i>Click on Selectandclose_btn</i></b>");
			Thread.sleep(1000);

		} else if (policy_criteria.equalsIgnoreCase("Airline Criteria"))

		{
			QaRobot.selectTextFromDropdown("criteria_Flight", policy_criteria, "criteria_Flight");
			Thread.sleep(1000);

			QaRobot.PassValue("TxtAirlines", TxtAirlines);
			QaExtentReport.test.log(Status.INFO,"<b><i>TxtAirlines</i></b>");
			Thread.sleep(1000);

			QaRobot.ClickOnElement("Selectairline");
			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Selectairline</i></b>");
			Thread.sleep(1000);

			QaRobot.ClickOnElement("Add_airline");
			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Add_airline</i></b>");
			Thread.sleep(100);

			QaRobot.ClickOnElement("Select&close");
			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Select&close</i></b>");
			Thread.sleep(1000);
		}

		else if (policy_criteria.equalsIgnoreCase("Booking Date")) {
			QaRobot.selectTextFromDropdown("criteria_Hotel", policy_criteria, "criteria_Hotel");
			Thread.sleep(1000);

			QaRobot.ClickOnElement("Bookingdatefrom");
			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Bookingdatefrom</i></b>");
			Thread.sleep(3000);
			
			QaRobot.ClickOnElement("btnMonthNext");
			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Bookingdatefrom</i></b>");
			
			QaBrowser.driver.findElement(By.xpath("//input[@value='"+Bookingdatefrom+" ']")).click();
			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Bookingdatefrom</i></b>");
			
			QaRobot.ClickOnElement("BookingdateTo");
			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Bookingdatefrom</i></b>");
			
			QaBrowser.driver.findElement(By.xpath("//input[@value='"+BookingdateTo+"']")).click();
			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Bookingdatefrom</i></b>");

			// get current month name

//			JavascriptExecutor j = (JavascriptExecutor) QaBrowser.driver;
//			String currentMonthName = (String) 
//			j.executeScript("return document.getElementById('CalenderControl_spnHead').value");
//			String[] s1 = currentMonthName.split(" ");
//			monthName = s1[0];
//			if (monthName.equalsIgnoreCase("Jan")) {
//				currentMonthNumber = 1;
//			} else if (monthName.equalsIgnoreCase("Feb")) {
//				currentMonthNumber = 2;
//			} else if (monthName.equalsIgnoreCase("Mar")) {
//				currentMonthNumber = 3;
//			} else if (monthName.equalsIgnoreCase("Apr")) {
//				currentMonthNumber = 4;
//			} else if (monthName.equalsIgnoreCase("May")) {
//				currentMonthNumber = 5;
//			} else if (monthName.equalsIgnoreCase("Jun")) {
//				currentMonthNumber = 6;
//			} else if (monthName.equalsIgnoreCase("Jul")) {
//				currentMonthNumber = 7;
//			} else if (monthName.equalsIgnoreCase("Aug")) {
//				currentMonthNumber = 8;
//			} else if (monthName.equalsIgnoreCase("Sep")) {
//				currentMonthNumber = 9;
//			} else if (monthName.equalsIgnoreCase("Oct")) {
//				currentMonthNumber = 10;
//			} else if (monthName.equalsIgnoreCase("Nov")) {
//				currentMonthNumber = 11;
//			} else if (monthName.equalsIgnoreCase("Dec")) {
//				currentMonthNumber = 12;
//			}
//			int userMonthNumber = Integer.parseInt(monthNumber);
//			int diff = userMonthNumber - currentMonthNumber;
//			for (int i = 1; i <= diff; i++) {
//				QaBrowser.driver.findElement(By.xpath("//input[@id='btnMonthNext']")).click();
//			}
//
//			QaBrowser.driver.findElement(By.xpath("//input[@value='" + Bookingdatefrom + "']")).click();
//
//			QaRobot.ClickOnElement("BookingdateTo");
//			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on BookingdateTo</i></b>");
//			Thread.sleep(1000);
//			JavascriptExecutor jTo = (JavascriptExecutor) QaBrowser.driver;
//			String currentMonthNameTo = (String) 
//			jTo.executeScript("return document.getElementById('CalenderControl_spnHead').value");
//			String[] sTo = currentMonthNameTo.split(" ");
//			monthName = sTo[0];
//			if (monthName.equalsIgnoreCase("Jan")) {
//				currentMonthNumber = 1;
//			} else if (monthName.equalsIgnoreCase("Feb")) {
//				currentMonthNumber = 2;
//			} else if (monthName.equalsIgnoreCase("Mar")) {
//				currentMonthNumber = 3;
//			} else if (monthName.equalsIgnoreCase("Apr")) {
//				currentMonthNumber = 4;
//			} else if (monthName.equalsIgnoreCase("May")) {
//				currentMonthNumber = 5;
//			} else if (monthName.equalsIgnoreCase("Jun")) {
//				currentMonthNumber = 6;
//			} else if (monthName.equalsIgnoreCase("Jul")) {
//				currentMonthNumber = 7;
//			} else if (monthName.equalsIgnoreCase("Aug")) {
//				currentMonthNumber = 8;
//			} else if (monthName.equalsIgnoreCase("Sep")) {
//				currentMonthNumber = 9;
//			} else if (monthName.equalsIgnoreCase("Oct")) {
//				currentMonthNumber = 10;
//			} else if (monthName.equalsIgnoreCase("Nov")) {
//				currentMonthNumber = 11;
//			} else if (monthName.equalsIgnoreCase("Dec")) {
//				currentMonthNumber = 12;
//			}
//			int userMonthNumberTo = Integer.parseInt(month_numberto);
//			int diffTo = userMonthNumberTo - currentMonthNumber;
//			for (int i = 1; i <= diffTo; i++) {
//				QaBrowser.driver.findElement(By.xpath("//input[@value='" + BookingdateTo + "']")).click();
//			}
//
			QaRobot.ClickOnElement("SelectBookDate");
			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on SelectBookDate</i></b>");
			Thread.sleep(1000);

			QaRobot.ClickOnElement("Save_Policy_hotel");
			QaExtentReport.test.log(Status.INFO,"<b><i>Save_Policy_hotel</i></b>");
		}

//		QaRobot.ClickOnElement("Save_policy");
//		QaExtentReport.test.log(Status.INFO,"<b><i>Click on Save_policy</i></b>");
//		Thread.sleep(100);

		// QaRobot.ClickOnElement("Policy_close","Click on Policy_close");
		// Thread.sleep(1000);
	}

	@AfterMethod
	public static void afterMetod() {
		QaExtentReport.test.getExtent().flush();
	}

}
