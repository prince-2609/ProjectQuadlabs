package Old_CAM_Code;

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
public class Preferred_Airline {

	@DataProvider
	public Object[][] getexceldata() throws Exception {
		return QaDataProvider.getTestdata("PreferredAirline", "Sheet2");
	}

	@Test(dataProvider = "getexceldata")
	public static void preferred_Airline(String TestCaseId, String TestScenario, String Source, String MoURL,
			String CompanyCode, String UserName, String Password, String CorporateName, String PAirQty,
			String PAirlines, String OriginType, String OCo, String OCountry, String OCi, String OCity, String OAirP,
			String OAirPort, String DestinationType, String DCo, String DCountry, String DCi, String DCity,
			String DAirP, String DAirPort, String Co_BranchQty, String Corporate_Branch, String TripStartDate,
			String TripEndDate) throws Exception {
		QaExtentReport.test = QaExtentReport.report.createTest(TestCaseId + "-" + TestScenario);
		TestBase.moLogin(Source, MoURL);
		QaRobot.PassValue("CompanyCode", CompanyCode);
		QaRobot.PassValue("UserName", UserName);
		QaRobot.PassValue("PasswordFD", Password);
		QaExtentReport.extentScreenshot("Sigh In Page");
		QaRobot.ClickOnElement("LogIn");
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
		QaRobot.ClickOnElement("PreferredAirline");
		QaRobot.ClickOnElement("Add_PreferredAirline");
		int pAS2 = Integer.parseInt(PAirQty);
		for (int k = 1; k <= pAS2; k++) {
			String[] tN1 = PAirlines.split(",");
			String b1 = tN1[k - 1];
			QaBrowser.driver
					.findElement(
							By.xpath("//div[@id='genpro']/div/div/div/div[2]/div[1]/div/span/span[1]/span/ul/li/input"))
					.clear();
			QaRobot.PassValue("PAAddAirline", b1);
			List<WebElement> listOfRights1 = QaBrowser.driver.findElements(By.xpath("/html/body/span/span/span/ul/li"));
			for (WebElement autoRights1 : listOfRights1) {
				if (autoRights1.getText().equalsIgnoreCase(b1)) {
					autoRights1.click();
					break;
				}
			}
		}
		if (OriginType.equalsIgnoreCase("Country")) {
			QaRobot.ClickOnElement("PAOCountry");
			TestBase.listofautosuggestion(By.xpath("//div[@id='divCity']/p"), OCo, OCountry,
					By.xpath("//input[@id='txtOrgin']"));
		} else if (OriginType.equalsIgnoreCase("City")) {
			QaRobot.ClickOnElement("PAOCity");
			TestBase.listofautosuggestion(By.xpath("//div[@id='divCity']/p"), OCi, OCity,
					By.xpath("//input[@id='txtOrgin']"));
		} else if (OriginType.equalsIgnoreCase("AirPort")) {
			QaRobot.ClickOnElement("PAOAirPort");
			TestBase.listofautosuggestion(By.xpath("//div[@id='divCity']/p"), OAirP, OAirPort,
					By.xpath("//input[@id='txtOrgin']"));
		}
		if (DestinationType.equalsIgnoreCase("Country")) {
			QaRobot.ClickOnElement("PADCountry");
			TestBase.listofautosuggestion(By.xpath("//div[@id='divCity1']/p"), DCo, DCountry,
					By.xpath("//input[@id='txtDestination']"));
		} else if (DestinationType.equalsIgnoreCase("City")) {
			QaRobot.ClickOnElement("PADCity");
			TestBase.listofautosuggestion(By.xpath("//div[@id='divCity1']/p"), DCi, DCity,
					By.xpath("//input[@id='txtDestination']"));
		} else if (DestinationType.equalsIgnoreCase("AirPort")) {
			QaRobot.ClickOnElement("PADAirPort");
			TestBase.listofautosuggestion(By.xpath("//div[@id='divCity1']/p"), DAirP, DAirPort,
					By.xpath("//input[@id='txtDestination']"));
		}
		int pAS = Integer.parseInt(Co_BranchQty);
		for (int k = 1; k <= pAS; k++) {
			String[] tN1 = Corporate_Branch.split(",");
			String b1 = tN1[k - 1];
			QaBrowser.driver
					.findElement(
							By.xpath("//div[@id='genpro']/div/div/div/div[2]/div[6]/div/span/span[1]/span/ul/li/input"))
					.clear();
			QaRobot.PassValue("SelectCoBranch", b1);
			List<WebElement> listOfRights1 = QaBrowser.driver.findElements(By.xpath("/html/body/span/span/span/ul/li"));
			for (WebElement autoRights1 : listOfRights1) {
				if (autoRights1.getText().equalsIgnoreCase(b1)) {
					autoRights1.click();
					break;
				}
			}
		}
		Thread.sleep(3000);
		QaExtentReport.extentScreenshot("Preferred Airline");
		QaRobot.ClickOnElement("PreferredAirlineSave");
	}

	@AfterMethod
	public static void afterMethod() {
		QaExtentReport.test.getExtent().flush();
	}
}
