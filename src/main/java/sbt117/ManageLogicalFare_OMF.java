package sbt117;

import org.openqa.selenium.By;
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
public class ManageLogicalFare_OMF {

	@DataProvider
	public Object[][] getexceldata() throws Exception {
		return QaDataProvider.getTestdata("ManageLogicalFare_OMF", "Sheet5");
	}

	@Test(dataProvider = "getexceldata")
	public static void OBTFulfillment(String TestCaseId, String TestCaseType, String TestScenario, String Source,
			String URL, String CompanyCode, String UserName, String Password, String CorporateName,
			String EditDeleteRules, String NOOfRules, String SupplierOBT, String OfficeHourBranch,
			String OfficeHourTicketPCC, String OfficeHourTicketBranch, String AfterOfficeHourticketPCC,
			String AuthorizedBookingqueue, String CheckQty, String checkname, String Selectcheck, String EffectiveDate,
			String EditQty, String EditRules, String EOfficeHourBranch, String EOfficeHourTicketPCC) throws Exception {

		TestBase.Companycode(Source, URL);
		QaExtentReport.test = QaExtentReport.report.createTest(TestCaseId + "-" + TestScenario);

		QaRobot.PassValue("CompanyCode", CompanyCode);
		QaRobot.PassValue("UserName", UserName);
		QaRobot.PassValue("PasswordFD", Password);
		QaExtentReport.extentScreenshot("Sigh In Page");
		QaRobot.ClickOnElement("LogIn");
		Thread.sleep(2000);
		QaExtentReport.extentScreenshot("Successfully Login");
		QaRobot.switchframe("//frame[@name='login']");
		QaRobot.switchframe("//frame[@name='leftbar']");
		QaRobot.ClickOnElement("CorporateManagement");
		QaRobot.ClickOnElement("SearchCorporate");
		QaBrowser.driver.switchTo().parentFrame();
		QaRobot.switchframe("//frame[@name='main']");
		QaRobot.switchframe("//frame[@id='frm2']");
		QaRobot.PassValue("CompanyName", CorporateName);
		QaExtentReport.extentScreenshot("Corporate Name");
		QaRobot.ClickOnElement("SearchCompanyName");
		QaExtentReport.test.log(Status.INFO, "<b><i>Corporate Name</i></b>" + " - " + CorporateName);
		String AccountId = QaBrowser.driver.findElement(By.xpath("//span[@id='GridView1_ctl02_Label2']")).getText();
		QaExtentReport.test.log(Status.INFO, "<b><i>Account Id</i></b>" + " - " + AccountId);
		QaRobot.ClickOnElement("ClickOnSearchCompanyName");
		QaBrowser.driver.switchTo().parentFrame();
		QaRobot.switchframe("//frame[@id='toolHeader']");
		QaRobot.ClickOnElement("CPCorporateManagement");
		QaBrowser.driver.switchTo().parentFrame();
		QaRobot.switchframe("//frame[@id='frm2']");
		QaExtentReport.extentScreenshot("Corporate Management");
//		QaRobot.ClickOnElement("ManageLogicalFare");

//		if (SLogicalFare.equalsIgnoreCase("AsPerTravelPolicy")) {
//			QaRobot.ClickOnElement("Aspertravelpolicy");
//
//			QaRobot.ClickOnElement("ManagelogicalfareSave");
//			String Status1 = QaBrowser.driver.findElement(By.xpath("//span[@id='GridView1_ctl02_Label2']"))
//					.getText();
//			QaExtentReport.test.log(Status.INFO, "<b><i>Account Id</i></b>" + " - " + Status1);
//		} else if (SLogicalFare.equalsIgnoreCase("AsPerPrefferedFlightTiming")) {
//			QaRobot.ClickOnElement("AsPerPrefferedFlightTiming");
//			if (AppliedFareOn.equalsIgnoreCase("Domestic")) {
//
//				QaRobot.ClickOnElement("Clickondom");
//				Thread.sleep(2000);
//				// QaRobot.ClickOnElement("clickonint");
//				QaRobot.selectTextFromDropdown("HHFD1", HHFD);
//				Thread.sleep(2000);
//				QaRobot.selectTextFromDropdown("MMFD1", MMFD);
//				Thread.sleep(2000);
//				QaRobot.selectTextFromDropdown("HHFBD1", HHFBD);
//				Thread.sleep(2000);
//				QaRobot.selectTextFromDropdown("HHRD1", HHFBD);
//				Thread.sleep(2000);
//				QaRobot.selectTextFromDropdown("MMRD1", HHFBD);
//				Thread.sleep(2000);
//				QaRobot.selectTextFromDropdown("HHRBD1", HHFBD);
//				Thread.sleep(2000);
//				QaRobot.ClickOnElement("Clickonsave");
//				String Status1 = QaBrowser.driver.findElement(By.xpath("//span[@id='GridView1_ctl02_Label2']"))
//						.getText();
//				QaExtentReport.test.log(Status.INFO, "<b><i>Account Id</i></b>" + " - " + Status1);
//			} else if (AppliedFareOn.equalsIgnoreCase("International")) {
//				QaRobot.ClickOnElement("Clickondom");
//				Thread.sleep(2000);
//				QaRobot.ClickOnElement("clickonint");
//				Thread.sleep(2000);
//				QaRobot.selectTextFromDropdown("HHFI", HHFI);
//				Thread.sleep(2000);
//				QaRobot.selectTextFromDropdown("MMFI", MMFI);
//				Thread.sleep(2000);
//				QaRobot.selectTextFromDropdown("HHFBI", HHFBI);
//				Thread.sleep(2000);
//				QaRobot.selectTextFromDropdown("HHRI", HHRI);
//				Thread.sleep(2000);
//				QaRobot.selectTextFromDropdown("MMRI", MMRI);
//				Thread.sleep(2000);
//				QaRobot.selectTextFromDropdown("HHRBI", HHRBI);
//				Thread.sleep(2000);
//
//				QaRobot.ClickOnElement("Clickonsave");
//				String Status1 = QaBrowser.driver.findElement(By.xpath("//span[@id='GridView1_ctl02_Label2']"))
//						.getText();
//				QaExtentReport.test.log(Status.INFO, "<b><i>Account Id</i></b>" + " - " + Status1);
//			} else if (AppliedFareOn.equalsIgnoreCase("All")) {
//				QaRobot.ClickOnElement("Clickondom");
//				Thread.sleep(2000);
//				QaRobot.selectTextFromDropdown("HHFD1", HHFD);
//				Thread.sleep(2000);
//				QaRobot.selectTextFromDropdown("MMFD1", MMFD);
//				Thread.sleep(2000);
//				QaRobot.selectTextFromDropdown("HHFBD1", HHFBD);
//				Thread.sleep(2000);
//				QaRobot.selectTextFromDropdown("HHRD1", HHFBD);
//				Thread.sleep(2000);
//				QaRobot.selectTextFromDropdown("MMRD1", HHFBD);
//				Thread.sleep(2000);
//				QaRobot.selectTextFromDropdown("HHRBD1", HHFBD);
//				Thread.sleep(2000);
//				QaRobot.ClickOnElement("clickonint");
//				Thread.sleep(2000);
//				QaRobot.selectTextFromDropdown("HHFI", HHFI);
//				Thread.sleep(2000);
//				QaRobot.selectTextFromDropdown("MMFI", MMFI);
//				Thread.sleep(2000);
//				QaRobot.selectTextFromDropdown("HHFBI", HHFBI);
//				Thread.sleep(2000);
//				QaRobot.selectTextFromDropdown("HHRI", HHRI);
//				Thread.sleep(2000);
//				QaRobot.selectTextFromDropdown("MMRI", MMRI);
//				Thread.sleep(2000);
//				QaRobot.selectTextFromDropdown("HHRBI", HHRBI);
//				Thread.sleep(2000);
//
//				QaRobot.ClickOnElement("Clickonsave");
//				String Status1 = QaBrowser.driver.findElement(By.xpath("//span[@id='GridView1_ctl02_Label2']"))
//						.getText();
//				QaExtentReport.test.log(Status.INFO, "<b><i>Account Id</i></b>" + " - " + Status1);
//			}
//		}
	}

	@AfterMethod
	public static void afterMethod() {
		QaExtentReport.test.getExtent().flush();
	}
}
