package CAM_MO;

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
public class TravelBanRules {

	@DataProvider
	public Object[][] getexceldata() throws Exception {
		return QaDataProvider.getTestdata("TravelBanRules", "Sheet1");
	}

	@Test(dataProvider = "getexceldata")
	public static void travellerProfiling(String TestCaseId, String TestCaseType, String TestScenario, String Source,
			String URL, String CompanyCode, String UserName, String Password, String CorporateName, String TitleTBR,
			String BranchName, String RuleAppliedOn, String TBRQty, String CorporateList, String DepartmentList,
			String GradeList, String CostCenterList, String Functionality) throws Exception {

		TestBase.Companycode(Source, URL);
		QaExtentReport.test = QaExtentReport.report.createTest(TestCaseId + "-" + TestScenario);

		QaRobot.PassValue("CompanyCode", CompanyCode);
		QaRobot.PassValue("UserName", UserName);
		QaRobot.PassValue("PasswordFD", Password);
		QaExtentReport.extentScreenshot("Sigh In Page");
		QaRobot.ClickOnElement("LogIn");
		QaRobot.switchframe("//frame[@name='login']");
		QaRobot.switchframe("//frame[@name='leftbar']");
		QaRobot.ClickOnElement("CorporateManagement");
		QaRobot.ClickOnElement("SearchCorporate");
		QaBrowser.driver.switchTo().parentFrame();
		QaRobot.switchframe("//frame[@name='main']");
		QaRobot.switchframe("//frame[@id='frm2']");
		QaRobot.PassValue("CompanyName", CorporateName);
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
		QaRobot.ClickOnElement("TravelBanRules");
		QaRobot.ClickOnElement("ADDTravelBanRules");
		QaRobot.PassValue("TitleTravelBanRules", TitleTBR);
		QaRobot.selectTextByLocator("//select[@id='ddlBranch']", BranchName);
		Thread.sleep(3000);
		QaRobot.selectTextByLocator("//select[@id='ddlAppliedOn']", RuleAppliedOn);
		Thread.sleep(3000);
		int TBR = Integer.parseInt(TBRQty);
		for (int k = 1; k <= TBR; k++) {
			if (RuleAppliedOn.equalsIgnoreCase("Corporate-Branch")) {
				String[] tN1 = CorporateList.split(",");
				String b1 = tN1[k - 1];
				List<WebElement> listOfRights1 = QaBrowser.driver.findElements(By.xpath(
						"/html/body/div/form/div[4]/div/div/div[2]/div[3]/div[2]/div/div[2]/ul/li/div/div/div/div[1]/div/div/select/option"));
				for (WebElement autoRights1 : listOfRights1) {
					if (autoRights1.getText().equalsIgnoreCase(b1)) {
						autoRights1.click();
						QaRobot.ClickOnElement("ADDT");
						break;
					}
				}
			} else if (RuleAppliedOn.equalsIgnoreCase("Department")) {
				String[] tN1 = DepartmentList.split(",");
				String b1 = tN1[k - 1];
				List<WebElement> listOfRights1 = QaBrowser.driver.findElements(By.xpath(
						"/html/body/div/form/div[4]/div/div/div[2]/div[3]/div[2]/div/div[2]/ul/li/div/div/div/div[1]/div/div/select/option"));
				for (WebElement autoRights1 : listOfRights1) {
					if (autoRights1.getText().equalsIgnoreCase(b1)) {
						autoRights1.click();
						QaRobot.ClickOnElement("ADDT");
						break;
					}
				}
			} else if (RuleAppliedOn.equalsIgnoreCase("Grade")) {
				String[] tN1 = GradeList.split(",");
				String b1 = tN1[k - 1];
				List<WebElement> listOfRights1 = QaBrowser.driver.findElements(By.xpath(
						"/html/body/div/form/div[4]/div/div/div[2]/div[3]/div[2]/div/div[2]/ul/li/div/div/div/div[1]/div/div/select/option"));
				for (WebElement autoRights1 : listOfRights1) {
					if (autoRights1.getText().equalsIgnoreCase(b1)) {
						autoRights1.click();
						QaRobot.ClickOnElement("ADDT");
						break;
					}
				}
			} else if (RuleAppliedOn.equalsIgnoreCase("CostCenter")) {
				String[] tN1 = CostCenterList.split(",");
				String b1 = tN1[k - 1];
				List<WebElement> listOfRights1 = QaBrowser.driver.findElements(By.xpath(
						"/html/body/div/form/div[4]/div/div/div[2]/div[3]/div[2]/div/div[2]/ul/li/div/div/div/div[1]/div/div/select/option"));
				for (WebElement autoRights1 : listOfRights1) {
					if (autoRights1.getText().equalsIgnoreCase(b1)) {
						autoRights1.click();
						QaRobot.ClickOnElement("ADDT");
						break;
					}
				}
			}

		}
		Thread.sleep(3000);
		if (Functionality.equalsIgnoreCase("SearchPanel")) {
			QaRobot.ClickOnElement("SearchPanelTBR");
		} else if (Functionality.equalsIgnoreCase("PlanYourTrip")) {
			QaRobot.ClickOnElement("PlanYourTripTBR");
		}
		QaRobot.ClickOnElement("SaveTBR");
		Thread.sleep(3000);
		QaExtentReport.extentScreenshot("Travel Ban Rules");
		Thread.sleep(2000);
		QaRobot.ClickOnElement("TravelBanRulesClose");
	}

	@AfterMethod
	public static void afterMethod() {
		QaExtentReport.test.getExtent().flush();
	}
}
