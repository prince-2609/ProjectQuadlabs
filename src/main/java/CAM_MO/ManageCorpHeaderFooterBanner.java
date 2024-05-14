package CAM_MO;

import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Base.TestBase;
import entities.Login;
import utilities.QaBrowser;
import utilities.QaDataProvider;
import utilities.QaExtentReport;
import utilities.QaRobot;

@Listeners(listenerClass.Listener.class)
public class ManageCorpHeaderFooterBanner {

	@DataProvider
	public Object[][] getexceldata() throws Exception {
		return QaDataProvider.getTestdata("ManageCorpHeaderFooterBanner", "Sheet1");
	}

	@Test(dataProvider = "getexceldata")
	public static void manageCorpHeaderFooterBanner(String TestCaseId, String TestCaseType, String TestScenario,
			String Source, String URL, String CompanyCode, String UserName, String Password, String CorporateName,
			String BannerTitle, String Preference, String ViewBanner, String ccode, String URL1, String Emailid,
			String SDN) throws Exception {

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
		QaRobot.ClickOnElement("HeaderFooterBanner");
		QaRobot.ClickOnElement("ADDManageHFBanner");
		QaRobot.PassValue("HFBannerTitle", BannerTitle);
		String ParentWindow1 = QaBrowser.driver.getWindowHandle();
		Thread.sleep(3000);
		QaRobot.ClickOnElement("MBUploadFile");
		Set<String> handles1 = QaBrowser.driver.getWindowHandles();
		for (String childWindow1 : handles1) {
			if (!childWindow1.equals(ParentWindow1))
				QaBrowser.driver.switchTo().window(childWindow1);
		}
		QaRobot.PassValue("MBBrowseFile",
				"D:\\OneDrive - QuadLabs Technologies Pvt Ltd (HQ - Gurgaon)\\Desktop\\Banners\\head_test1.jpg");
		Thread.sleep(2000);
		QaRobot.ClickOnElement("MBUpload");
		QaRobot.alertAccept();
		Thread.sleep(2000);
		QaBrowser.driver.switchTo().window(ParentWindow1);
		Thread.sleep(3000);
		QaBrowser.driver.switchTo().parentFrame();
		QaRobot.switchframe("//frame[@name='login']");
		QaRobot.switchframe("//frame[@name='main']");
		QaRobot.switchframe("//frame[@id='frm2']");
		QaRobot.ClickOnElement("FBUploadFile");
		Set<String> handles2 = QaBrowser.driver.getWindowHandles();
		for (String childWindow1 : handles2) {
			if (!childWindow1.equals(ParentWindow1))
				QaBrowser.driver.switchTo().window(childWindow1);
		}
		QaRobot.PassValue("MBBrowseFile",
				"D:\\OneDrive - QuadLabs Technologies Pvt Ltd (HQ - Gurgaon)\\Desktop\\Banners\\head_test2.jpg");
		Thread.sleep(2000);
		QaRobot.ClickOnElement("MBUpload");
		QaRobot.alertAccept();
		Thread.sleep(2000);
		QaBrowser.driver.switchTo().window(ParentWindow1);
		Thread.sleep(3000);
		QaBrowser.driver.switchTo().parentFrame();
		QaRobot.switchframe("//frame[@name='login']");
		QaRobot.switchframe("//frame[@name='main']");
		QaRobot.switchframe("//frame[@id='frm2']");
		QaRobot.selectTextByLocator("//select[@id='lstoffer']", Preference);
		Thread.sleep(3000);
		QaExtentReport.extentScreenshot("Header Footer Banner");
		Thread.sleep(3000);
		QaRobot.ClickOnElement("MBSave");
		Thread.sleep(3000);
		QaExtentReport.extentScreenshot("Manage Corp Header Footer Banner");
		Thread.sleep(2000);
		QaBrowser.driver.findElement(By.xpath("//a[@id='GridView1_ctl0" + ViewBanner + "_SABannerURL']")).click();
		Thread.sleep(6000);
		QaExtentReport.extentScreenshot("Banners");
		QaRobot.ClickOnElement("FBViewClose");
		Thread.sleep(3000);
		QaRobot.ClickOnElement("ManageBannerClose");

		TestBase.Companycode(ccode, URL1);
		QaRobot.impliwait(30);
		QaRobot.PassValue("EmailId", Emailid);
		QaRobot.PassValue("SDN", SDN);
		QaRobot.ClickOnElement("Encrypt");
		QaRobot.ClickOnElement("ESubmit");
		Thread.sleep(6000);
		QaRobot.ClickOnElement("NotificationClose");
		Thread.sleep(2000);
		QaExtentReport.extentScreenshot("Banner 1");
		QaRobot.scrollPage(1000);
		Thread.sleep(6000);
		QaExtentReport.extentScreenshot("Banner 2");
	}

	@AfterMethod
	public static void afterMethod() {
		QaBrowser.driver.quit();
		QaExtentReport.test.getExtent().flush();
	}
}
