package sbt117;

import java.util.List;

import org.openqa.selenium.By;
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
public class ObtAutofulfillment_OtherMiscFunctionality {

	@DataProvider
	public Object[][] getexceldata() throws Exception {
		return QaDataProvider.getTestdata("OBTFulfillmentSetting_OMF", "Sheet5");
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
		QaRobot.ClickOnElement("OBTFulfillmentclick");

		if (EditDeleteRules.equalsIgnoreCase("Save")) {
			Thread.sleep(2000);
			QaRobot.selectTextFromDropdown("SupplierOBT", SupplierOBT);
			Thread.sleep(3000);
			QaRobot.selectTextFromDropdown("OfficeHourBranch", OfficeHourBranch);
			Thread.sleep(3000);
			QaRobot.selectTextFromDropdown("OfficeHourTicketPCC", OfficeHourTicketPCC);
			Thread.sleep(3000);
			QaRobot.selectTextFromDropdown("OfficeHourTicketBranch", OfficeHourTicketBranch);
			Thread.sleep(3000);
			QaRobot.selectTextFromDropdown("AfterofficeHourTicketPCC", AfterOfficeHourticketPCC);
			Thread.sleep(3000);
			QaRobot.PassValue("AuthorizedBookingQueue", AuthorizedBookingqueue);
			Thread.sleep(3000);
			QaExtentReport.extentScreenshot("Detail filled");
			int SC = Integer.parseInt(CheckQty);
			for (int k = 1; k <= SC; k++) {
				String[] tN1 = checkname.split(",");
				String b1 = tN1[k - 1];
				System.out.println(b1);
				List<WebElement> listOfSC = QaBrowser.driver.findElements(By.xpath(
						"/html/body/form/div[5]/div/div/div/div/div/div[1]/div/div[2]/div/div/div/div/div//input"));
				for (WebElement autoSC : listOfSC) {
					System.out.println(autoSC.getText());
					if (autoSC.getText().equalsIgnoreCase(b1)) {
						autoSC.click();
						break;
					}
				}
			}
			QaExtentReport.extentScreenshot("Saved successfully");
			QaRobot.scrollPage(500);
			Thread.sleep(2000);
			QaExtentReport.extentScreenshot("Rules");
			Thread.sleep(2000);
			QaRobot.ClickOnElement("SaveOBTRules");
		} else if (EditDeleteRules.equalsIgnoreCase("Edit")) {
//			QaRobot.scrollPage(-500);
			int pAS1 = Integer.parseInt(EditQty);
			for (int k = 1; k <= pAS1; k++) {
				String[] tN1 = EditRules.split(",");
				String b1 = tN1[k - 1];
				System.out.println(b1);
				WebElement abc = QaBrowser.driver.findElement(By.xpath(
						"(/html/body/form/div[5]/div/div/div/div/div/div[2]/div/div[2]/div[2]/table/tbody/tr/td[21]/a[1])["
								+ b1 + "]"));
				abc.click();
				Thread.sleep(3000);
//				QaRobot.scrollPage(-500);
//				Thread.sleep(3000);
				QaExtentReport.extentScreenshot("Saved Rules");
				String[] tN2 = EOfficeHourBranch.split(",");
				String b2 = tN2[k - 1];
				System.out.println(b2);
				String[] tN3 = EOfficeHourTicketPCC.split(",");
				String b3 = tN3[k - 1];
				System.out.println(b3);
				QaRobot.selectTextFromDropdown("OfficeHourBranch", b2);
				Thread.sleep(3000);
				QaRobot.selectTextFromDropdown("OfficeHourTicketPCC", b3);
				Thread.sleep(3000);
				QaRobot.scrollPage(500);
				Thread.sleep(2000);
				QaExtentReport.extentScreenshot("Saved successfully");
				Thread.sleep(2000);
				QaRobot.ClickOnElement("UpdateRules");

			}
		} else if (EditDeleteRules.equalsIgnoreCase("Delete")) {
			QaRobot.scrollPage(500);
			QaExtentReport.extentScreenshot("Rules");
			Thread.sleep(3000);
			int pAS1 = Integer.parseInt(NOOfRules);
			for (int k = 1; k <= pAS1; k++) {
				QaRobot.scrollPage(500);
				QaExtentReport.extentScreenshot("Rules");
				QaRobot.ClickOnElement("DeleteOBT");
			}
		}
	}

	@AfterMethod
	public static void afterMethod() {
		QaExtentReport.test.getExtent().flush();
	}

}
