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
public class CalenderRules_OtherMiscFunctionality {

	@DataProvider
	public Object[][] getexceldata() throws Exception {
		return QaDataProvider.getTestdata("CalenderRules_OMF", "Sheet5");
	}

	@Test(dataProvider = "getexceldata")
	public static void travellerProfiling(String TestCaseId, String TestCaseType, String TestScenario, String Source,
			String URL, String CompanyCode, String UserName, String Password, String CorporateName,
			String EditDeleteRules, String NOOfRules, String MarketType, String Product, String Disable,
			String DisableTime, String RemarkReason, String RestrictFor, String SalesChannelQty, String SCName,
			String EditQty, String EditRules, String EMarketType, String EProduct, String EDisable

	) throws Exception {
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
		QaRobot.ClickOnElement("CalendarRules");
		if (EditDeleteRules.equalsIgnoreCase("Create")) {
			QaRobot.ClickOnElement("AddRules");
			if (MarketType.equalsIgnoreCase("Domestic")) {
				QaRobot.ClickOnElement("Domesticcalendar");
			} else if (MarketType.equalsIgnoreCase("International")) {
				QaRobot.ClickOnElement("Internationalcalendar");
			}
			QaRobot.selectTextFromDropdown("Selectproduct", Product);
			Thread.sleep(2000);
			QaRobot.selectTextFromDropdown("Disablerules", Disable);
			QaRobot.PassValue("DisableTime", DisableTime);
			QaRobot.PassValue("RemarksReason", RemarkReason);

			if (RestrictFor.equalsIgnoreCase("Search Panel")) {
				QaRobot.ClickOnElement("RestrictForSP");
			} else if (RestrictFor.equalsIgnoreCase("Plan Your Trip")) {
				QaRobot.ClickOnElement("PYTrestrict");
			} else if (RestrictFor.equalsIgnoreCase("All")) {
				QaRobot.ClickOnElement("RestrictForSP");
				QaRobot.ClickOnElement("PYTrestrict");
			}
			int SC = Integer.parseInt(SalesChannelQty);
			for (int k = 1; k <= SC; k++) {
				String[] tN1 = SCName.split(",");
				String b1 = tN1[k - 1];
				System.out.println(b1);
				List<WebElement> listOfSC = QaBrowser.driver.findElements(By.xpath(
						"/html/body/div/form/div[4]/div/div/div[2]/div[2]/div[2]/div[6]/div/div/div/ul/li/label"));
				for (WebElement autoSC : listOfSC) {
					System.out.println(autoSC.getText());
					if (autoSC.getText().equalsIgnoreCase(b1)) {
						autoSC.click();
						break;
					}
				}
			}
			QaExtentReport.extentScreenshot("Saved successfully");
			QaRobot.ClickOnElement("CalendarRulesSave");
			Thread.sleep(3000);

			QaRobot.acceptAlert("Calender Rules");
			Thread.sleep(3000);
//			QaRobot.acceptAlert("Calender Rules");
		} else if (EditDeleteRules.equalsIgnoreCase("Edit")) {
			int pAS1 = Integer.parseInt(EditQty);
			for (int k = 1; k <= pAS1; k++) {
				String[] tN1 = EditRules.split(",");
				String b1 = tN1[k - 1];
				System.out.println(b1);
				WebElement abc = QaBrowser.driver.findElement(
						By.xpath("(/html/body/div/form/div[4]/div/div/div[3]/div/div/div/div/table/tbody/tr/td[9]/a)["
								+ b1 + "]"));
				abc.click();
				Thread.sleep(3000);
				QaExtentReport.extentScreenshot("Saved Rule");
				Thread.sleep(2000);
				if (EMarketType.equalsIgnoreCase("Domestic")) {
					QaRobot.ClickOnElement("Domesticcalendar");
				} else if (EMarketType.equalsIgnoreCase("International")) {
					QaRobot.ClickOnElement("Internationalcalendar");
				}
				String[] tN2 = EProduct.split(",");
				String b2 = tN2[k - 1];
				System.out.println(b2);
				String[] tN3 = EDisable.split(",");
				String b3 = tN3[k - 1];
				System.out.println(b3);
				QaRobot.selectTextFromDropdown("Selectproduct", b2);
				Thread.sleep(3000);
				QaRobot.selectTextFromDropdown("Disablerules", b3);
				Thread.sleep(3000);
				QaExtentReport.extentScreenshot("Saved successfully");
				QaRobot.ClickOnElement("CalendarRulesSave");
				Thread.sleep(3000);
				QaRobot.acceptAlert("Calender Rules");

			}
		} else if (EditDeleteRules.equalsIgnoreCase("Delete")) {
			int pAS1 = Integer.parseInt(NOOfRules);
			for (int k = 1; k <= pAS1; k++) {
				QaRobot.ClickOnElement("DeleteCalendar");
				QaRobot.acceptAlert("Delete Rules");
				Thread.sleep(2000);
				QaExtentReport.extentScreenshot("Successfully Deleted");
				Thread.sleep(4000);

			}
		}
	}

	@AfterMethod
	public static void afterMethod() {
		QaExtentReport.test.getExtent().flush();
	}

}
