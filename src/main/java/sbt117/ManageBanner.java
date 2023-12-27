package sbt117;

import java.util.List;
import java.util.Set;

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
public class ManageBanner {

	@DataProvider
	public Object[][] getexceldata() throws Exception {
		return QaDataProvider.getTestdata("ManageBanner", "Sheet1");
	}

	@Test(dataProvider = "getexceldata")
	public static void travellerProfiling(String TestCaseId, String TestCaseType, String TestScenario, String Source,
			String URL, String CompanyCode, String UserName, String Password, String CorporateName, String BannerTitle,
			String BannerDescription, String BranchQty, String Branch, String TTQty, String TravelerType,
			String Preference) throws Exception {

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
		QaRobot.ClickOnElement("ManageBanner");
		QaRobot.ClickOnElement("ADDManageBanner");
		QaRobot.PassValue("BannerTitle", BannerTitle);
		QaRobot.PassValue("BannerDescription", BannerDescription);
		String ParentWindow1 = QaBrowser.driver.getWindowHandle();
		int BN = Integer.parseInt(BranchQty);
		for (int k = 1; k <= BN; k++) {
			String[] tN1 = Branch.split(",");
			String b1 = tN1[k - 1];
			List<WebElement> listOfRights1 = QaBrowser.driver.findElements(
					By.xpath("/html/body/form/div[5]/div[2]/div[2]/div/div[1]/div[3]/div/div/div/ul/li/label"));
			for (WebElement autoRights1 : listOfRights1) {
				if (autoRights1.getText().equalsIgnoreCase(b1)) {
					autoRights1.click();
					break;
				}
			}
		}
		Thread.sleep(3000);
		int BNT = Integer.parseInt(TTQty);
		for (int k = 1; k <= BNT; k++) {
			String[] tN1 = TravelerType.split(",");
			String b1 = tN1[k - 1];
			List<WebElement> listOfRights1 = QaBrowser.driver.findElements(
					By.xpath("/html/body/form/div[5]/div[2]/div[2]/div/div[1]/div[6]/div/div/ul/li/label"));
			for (WebElement autoRights1 : listOfRights1) {
				if (autoRights1.getText().equalsIgnoreCase(b1)) {
					autoRights1.click();
					break;
				}
			}
		}
		Thread.sleep(3000);
		QaRobot.ClickOnElement("MBUploadFile");
		Set<String> handles1 = QaBrowser.driver.getWindowHandles();
		for (String childWindow1 : handles1) {
			if (!childWindow1.equals(ParentWindow1))
				QaBrowser.driver.switchTo().window(childWindow1);
		}
		QaRobot.PassValue("MBBrowseFile",
				"D:\\OneDrive - QuadLabs Technologies Pvt Ltd (HQ - Gurgaon)\\Desktop\\Banner.jpg");
		Thread.sleep(2000);
		QaRobot.ClickOnElement("MBUpload");
		QaRobot.alertAccept();
		Thread.sleep(2000);
		QaBrowser.driver.switchTo().window(ParentWindow1);
		Thread.sleep(2000);
		QaBrowser.driver.switchTo().parentFrame();
		QaRobot.switchframe("//frame[@name='login']");
		QaRobot.switchframe("//frame[@name='main']");
		QaRobot.switchframe("//frame[@id='frm2']");
		QaRobot.selectTextByLocator("//select[@id='lstoffer']", Preference);
		Thread.sleep(3000);
		QaRobot.ClickOnElement("MBSave");
		Thread.sleep(3000);
		QaExtentReport.extentScreenshot("Manage Banners");
		Thread.sleep(2000);
		QaRobot.ClickOnElement("ManageBannerClose");
	}

	@AfterMethod
	public static void afterMethod() {
		QaExtentReport.test.getExtent().flush();
	}
}
