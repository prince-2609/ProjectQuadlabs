package SBT_Corporate;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
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
public class CamSbtExpenseConveyanceAllowanceManagement {
	@DataProvider
	public Object[][] getexceldata() throws Exception {
		return QaDataProvider.getTestdata("CamSbtExpenseManagement", "ConveyanceAllowance");
	}

	@Test(dataProvider = "getexceldata")
	public static void Profiling1(String Source, String URL, String Comapnycode, String LoginType, String Emailid,
			String SDN, String Username, String Password, String ConveyanceAllowanceName, String RatePer,
			String RateAmount, String ConApplicableOn, String ConApplicableSearchType, String ConTypeSelect,
			String ConTypeName) throws Exception {
		QaExtentReport.test = QaExtentReport.report.createTest("Test on CAM SBT ConveyanceAllowance");
		TestBase.Companycode(Source, URL);
		QaRobot.impliwait(30);

		if (LoginType.equalsIgnoreCase("Old Url")) {
			QaExtentReport.test = QaExtentReport.report
					.createTest("Test on CAM SBT expense Categories Policies Management");

			QaRobot.PassValue("User_name", Username);
			QaExtentReport.test.log(Status.INFO, "<b><i>Write Username</i></b>");

			QaRobot.PassValue("Password", Password);
			QaExtentReport.test.log(Status.INFO, "<b><i>Write Password</i></b>");

			QaRobot.ClickOnElement("Submit");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on submit</i></b>");
		} else if (LoginType.equalsIgnoreCase("SSOLogin")) {
			QaRobot.PassValue("SSOEmail", Emailid);
			QaRobot.PassValue("SSOSDN", SDN);
			QaExtentReport.extentScreenshot("Sign In Page");
			QaRobot.ClickOnElement("SSOEncrypt");
			QaRobot.ClickOnElement("SSOSubmit");

		}

//		QaRobot.ScreenshotMethod("CorporateLogin", "<b><i>Screenshot for Corporate Login Page</i></b>");

		QaRobot.mouseHover("//span[@id='HeaderTop_lblSettingMenu']", "//span[@id='HeaderTop_lblComapnayManagement']");

//		QaRobot.ScreenshotMethod("CorporateDashboard", "<b><i>Screenshot for Corporate Dashboard Page</i></b>");
		QaExtentReport.extentScreenshot("Corporate Management");
		QaRobot.ClickOnElement("ConveyanceAllowance");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Conveyance Allowance</i></b>");
		QaExtentReport.extentScreenshot("AddNew Conveyance Allowance ");
		QaRobot.ClickOnElement("ConAddNew");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Add New Button</i></b>");

		String ParentWindow = QaBrowser.driver.getWindowHandle();
		Set<String> handles = QaBrowser.driver.getWindowHandles();
		for (String childWindow : handles) {
			if (!childWindow.equals(ParentWindow))
				QaBrowser.driver.switchTo().window(childWindow);
		}

		QaRobot.PassValue("ConveyanceAllowanceName", ConveyanceAllowanceName);
		QaExtentReport.test.log(Status.INFO, "<b><i>Write ConveyanceAllowanceName </i></b>" + ConveyanceAllowanceName);

		WebElement DropDown = QaBrowser.driver.findElement(By.xpath("//select[@id='ddlKMMile']"));
		Select s = new Select(DropDown);
		s.selectByVisibleText(RatePer);

		QaRobot.PassValue("RateAmount", RateAmount);
		QaExtentReport.test.log(Status.INFO, "<b><i>Write ConveyanceAllowanceName </i></b>" + ConveyanceAllowanceName);

		WebElement DropDown1 = QaBrowser.driver.findElement(By.xpath("//select[@id='ddlApplicableOn']"));
		Select s1 = new Select(DropDown1);
		s1.selectByVisibleText(ConApplicableOn);
		Thread.sleep(5000);

		conApplicableSearchType(ConApplicableSearchType, ConTypeSelect, ConTypeName);
		Thread.sleep(3000);
		QaExtentReport.extentScreenshot("Conveyance Allowance Data");
		QaRobot.ClickOnElement("ConveyanceAllowanceSave");
		QaExtentReport.extentScreenshot("Saved Conveyance Allowance");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Conveyance Allowance Save Button</i></b>");

	}

	@AfterMethod
	public static void afterMetod() {
		QaExtentReport.test.getExtent().flush();
//		QaBrowser.driver.close();
	}

	public static void conApplicableSearchType(String ConApplicableSearchType, String ConTypeSelect, String ConTypeName)
			throws Exception {
		if (ConApplicableSearchType.equalsIgnoreCase("SelectAllType")) {
			QaRobot.ClickOnElement("SelectAllType");
			Thread.sleep(3000);
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Select All Applicable Type</i></b>");
		} else if (ConApplicableSearchType.equalsIgnoreCase("SearchType")) {
			int tS = Integer.parseInt(ConTypeSelect);
			for (int i = 1; i <= tS; i++) {
				String[] tN = ConTypeName.split(",");
				String b = tN[i - 1];
				TestBase.listofautosuggestion2(By.xpath("(//div[@class='checkbox pt0'])[2]/table/tbody/tr/td"), b,
						By.xpath("//input[@id='txtSearch']"));
			}
		}
	}
}
