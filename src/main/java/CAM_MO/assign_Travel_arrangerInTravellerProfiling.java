package CAM_MO;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Base.TestBase;
import entities.Login;
import product.Flight.suite.Oneway.SearchDashboard;
import utilities.QaBrowser;
import utilities.QaDataProvider;
import utilities.QaExtentReport;
import utilities.QaRobot;

@Listeners(listenerClass.Listener.class)
public class assign_Travel_arrangerInTravellerProfiling {

	@DataProvider
	public Object[][] getexceldata() throws Exception {
		return QaDataProvider.getTestdata("AssignTravelArranger", "Sheet1");
	}

	@Test(dataProvider = "getexceldata")
	public static void travellerProfiling(String TestCaseId, String TestScenario, String Source, String MoURL,
			String CompanyCode, String UserName, String Password, String CorporateName, String TravellerName,
			String TotalTraveller, String TravellerNames) throws Exception {
		QaExtentReport.test = QaExtentReport.report.createTest(TestCaseId + "-" + TestScenario);
		TestBase.moLogin(Source, MoURL);
		QaRobot.PassValue("CompanyCode", CompanyCode);
		QaRobot.PassValue("UserName", UserName);
		QaRobot.PassValue("PasswordFD", Password);
		QaExtentReport.extentScreenshot("Sigh In Page");
		QaRobot.ClickOnElement("LogIn");
		Thread.sleep(3000);
		QaRobot.switchframe("//frame[@name='login']");
		QaRobot.switchframe("//frame[@name='leftbar']");
		QaRobot.ClickOnElement("CorporateManagement");
		Thread.sleep(3000);
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
		QaRobot.ClickOnElement("ManageTravellers");
		QaRobot.ClickOnElement("ATSearchOption");
		Thread.sleep(3000);
		String HolderName[] = TravellerName.split(" ");
		String FN = HolderName[0];
		String LN = HolderName[1];
		QaRobot.PassValue("TravellerFN", FN);
		QaRobot.PassValue("TravellerLN", LN);
		QaRobot.ClickOnElement("ATSearchTraveller");
		Thread.sleep(3000);
		QaRobot.ClickOnElement("ATSelectTraveller");
		Thread.sleep(5000);
		QaExtentReport.extentScreenshot("Employee Profile");
		QaRobot.ClickOnElement("ATAssociate");
		int pAS = Integer.parseInt(TotalTraveller);
		for (int i = 1; i <= pAS; i++) {
			String[] tN = TravellerNames.split(",");
			String b = tN[i - 1];
			List<WebElement> listOfRights = QaBrowser.driver.findElements(By.xpath(
					"/html/body/div/form/div[5]/div/div/div/div[2]/div[2]/div/div[39]/div/div/div[1]/div/div/select/option"));
			for (WebElement autoRights : listOfRights) {
				if (autoRights.getText().equalsIgnoreCase(b)) {
					autoRights.click();
					QaRobot.ClickOnElement("ATAdd");
					break;
				}
			}
		}
		Thread.sleep(3000);
		QaRobot.scrollPage(500);
		QaExtentReport.extentScreenshot("Assign Travel Arranger");
		QaRobot.ClickOnElement("TravellerSave");
	}

	@AfterTest
	public void After_Test() {
		QaExtentReport.test.getExtent().flush();
	}
}
