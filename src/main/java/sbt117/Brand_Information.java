package sbt117;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
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
public class Brand_Information {

	@DataProvider
	public Object[][] getexceldata() throws Exception {
		return QaDataProvider.getTestdata("BrandInformation", "Sheet1");
	}

	@Test(dataProvider = "getexceldata")
	public static void brandInformation(String TestCaseId, String TestCaseType, String TestScenario, String Source,
			String URL, String CompanyCode, String UserName, String Password, String Title, String Airline,
			String CabinClass, String BookingClassQty, String BookingClass, String MarketType, String BrandName,
			String KeyInformation, String BrandDetails1, String BrandDetails2, String Notes, String UploadImage,
			String SalesChannelQty, String SalesChannel) throws Exception {
		TestBase.Companycode(Source, URL);
		QaExtentReport.test = QaExtentReport.report.createTest(TestCaseId + "-" + TestScenario);
		QaRobot.PassValue("CompanyCode", CompanyCode);
		QaRobot.PassValue("UserName", UserName);
		QaRobot.PassValue("PasswordFD", Password);
		QaExtentReport.extentScreenshot("Sigh In Page");
		QaRobot.ClickOnElement("LogIn");
		QaRobot.switchframe("//frame[@name='login']");
		QaRobot.switchframe("//frame[@name='leftbar']");
		QaRobot.ClickOnElement("Administation");
		Thread.sleep(3000);
		QaRobot.ClickOnElement("SupplierCrediantials");
		QaBrowser.driver.switchTo().parentFrame();
		QaRobot.switchframe("//frame[@name='main']");
		QaRobot.switchframe("//frame[@id='toolHeader']");
		WebElement mainMenu = QaBrowser.driver.findElement(By.xpath("//td[@id='tdAirlineMgmt']/a"));
		mainMenu.click();
		QaBrowser.driver.switchTo().parentFrame();
		QaRobot.switchframe("//frame[@id='frm2']");
		WebElement subMenu = QaBrowser.driver.findElement(By.xpath("(/html/body/div/div/table/tbody/tr[15]/td)[1]"));
		subMenu.click();
		QaExtentReport.extentScreenshot("Brand Informations");
		QaRobot.ClickOnElement("AddNewBrandInfo");
		QaRobot.PassValue("BITitle", Title);
		TestBase.listofautosuggestion(By.xpath("//div[@id='divAirCity']/p"), Airline, Airline,
				By.xpath("//input[@id='txtAirline']"));
		QaRobot.selectTextFromDropdown("CabinClass", CabinClass, "");
		String ParentWindow = QaBrowser.driver.getWindowHandle();
		QaRobot.ClickOnElement("AddBookingClass");
		Set<String> handles = QaBrowser.driver.getWindowHandles();
		for (String childWindow : handles) {
			if (!childWindow.equals(ParentWindow))
				QaBrowser.driver.switchTo().window(childWindow);
		}
		int pAS1 = Integer.parseInt(BookingClassQty);
		for (int k = 1; k <= pAS1; k++) {
			String[] tN1 = BookingClass.split(",");
			String b1 = tN1[k - 1];
			List<WebElement> listOfRights1 = QaBrowser.driver
					.findElements(By.xpath("/html/body/div/div/div/div/div/div/div/div[1]/div[1]/select/option"));
			for (WebElement autoRights1 : listOfRights1) {
				if (autoRights1.getText().equalsIgnoreCase(b1)) {
					autoRights1.click();
					QaRobot.ClickOnElement("AddClass");
				}
			}
		}
		QaRobot.ClickOnElement("ClassSelectClose");
		QaRobot.selectTextFromDropdown("BIMarketType", MarketType, "MarketType");
		QaRobot.PassValue("BIBrandName", BrandName);
		QaRobot.selectTextFromDropdown("BIKeyInformation", KeyInformation, "KeyInformation");
		QaExtentReport.extentScreenshot("Brand Information Page");
		String a = BrandDetails1;
		String b = BrandDetails2;
		int TotalNo = a.length() + b.length();
		System.out.println(TotalNo);
		if (TotalNo <= 50000) {
			String BD = BrandDetails1 + BrandDetails2;
			System.out.println(BD);
			QaRobot.PassValue("BIBrandDetails", BD);
		} else {
			QaExtentReport.test.log(Status.INFO,
					"<b><i>" + "Total number of character provided is " + TotalNo + "</i></b>");
			Assert.assertTrue(TotalNo <= 50000, "Please check text,Text characters should not more than 50000");
		}
		QaRobot.scrollPage(1000);
		QaRobot.PassValue("BINotes", Notes);
		QaRobot.PassValue("BIChooseFile", UploadImage);
		int pAS2 = Integer.parseInt(SalesChannelQty);
		for (int k = 1; k <= pAS2; k++) {
			String[] tN1 = SalesChannel.split(",");
			String b1 = tN1[k - 1];
			List<WebElement> listOfRights1 = QaBrowser.driver.findElements(By.xpath(
					"/html/body/form/div[4]/div/div/div/div/div/div[1]/div/div[2]/div/div/div[10]/div/div/table/tbody/tr/td/label"));
			for (WebElement autoRights1 : listOfRights1) {
				if (autoRights1.getText().equalsIgnoreCase(b1)) {
					autoRights1.click();
				}
			}
		}
		QaExtentReport.extentScreenshot("Brand Information Page");
		QaRobot.ClickOnElement("BISave");
		Thread.sleep(3000);
		QaExtentReport.test.log(Status.INFO, QaBrowser.driver.switchTo().alert().getText());
		QaRobot.alertAccept();
	}

	@AfterMethod
	public static void afterMethod() {
		QaExtentReport.test.getExtent().flush();
	}
}
