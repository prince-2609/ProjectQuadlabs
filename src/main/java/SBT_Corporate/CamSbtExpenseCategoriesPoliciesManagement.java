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
public class CamSbtExpenseCategoriesPoliciesManagement {
	@DataProvider
	public Object[][] getexceldata() throws Exception {
		return QaDataProvider.getTestdata("CamSbtExpenseManagement", "CategoriesAndPolicies");
	}

	@Test(dataProvider = "getexceldata")
	public static void Profiling1(String Source, String URL, String Comapnycode, String LoginType, String Emailid,
			String SDN, String Username, String Password, String CategoryName, String CatApplicableOn,
			String CatApplicableSearchType, String CatTypeSelect, String CatTypeName, String MaxFilingDays,
			String MaxAmountSpend, String TravalType, String MarkStatus) throws Exception {
		QaExtentReport.test = QaExtentReport.report.createTest("Test on CAM SBT Categories Policies Management");
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

		QaRobot.ClickOnElement("CategoriesAndPolicies");
		QaExtentReport.extentScreenshot("CategoriesAndPolicies");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Categories And Policies</i></b>");

		QaRobot.ClickOnElement("CatAddNew");
		QaExtentReport.extentScreenshot("CatAddNew");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Add New Button</i></b>");

		String ParentWindow = QaBrowser.driver.getWindowHandle();
		Set<String> handles = QaBrowser.driver.getWindowHandles();
		for (String childWindow : handles) {
			if (!childWindow.equals(ParentWindow))
				QaBrowser.driver.switchTo().window(childWindow);
		}

		QaRobot.PassValue("CategoryName", CategoryName);
		QaExtentReport.test.log(Status.INFO, "<b><i>Write Category Name</i></b>" + CategoryName);

		WebElement DropDown = QaBrowser.driver.findElement(By.xpath("//select[@id='ddlApplicableOn']"));
		Select s = new Select(DropDown);
		s.selectByVisibleText(CatApplicableOn);
		Thread.sleep(5000);

		catApplicableSearchType(CatApplicableSearchType, CatTypeSelect, CatTypeName);
		Thread.sleep(3000);

		QaRobot.ClickOnElement("ReceiptRequiredpolicy");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Receipt Required</i></b>");

		QaRobot.PassValue("MaxFilingDays", MaxFilingDays);
		QaExtentReport.test.log(Status.INFO, "<b><i>Write Max Filing Days</i></b>");

		QaRobot.PassValue("MaxAmountSpend", MaxAmountSpend);
		QaExtentReport.test.log(Status.INFO, "<b><i>Write Max Amount Spend</i></b>");

		WebElement DropDown1 = QaBrowser.driver.findElement(By.xpath("//select[@id='ddlTravelType']"));
		Select s1 = new Select(DropDown1);
		s1.selectByVisibleText(TravalType);
		Thread.sleep(2000);
		if (MarkStatus.equalsIgnoreCase("Yes")) {
			QaRobot.ClickOnElement("Statuscheck");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Status Button</i></b>");
		} else if (MarkStatus.equalsIgnoreCase("No")) {

		}
//		
		QaExtentReport.extentScreenshot("Policy rules");
		QaRobot.ClickOnElement("CategoriesAndPoliciesSave");
		QaExtentReport.extentScreenshot("Saved Categories and polices");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Categories And Policies Save Button</i></b>");
	}

	@AfterMethod
	public static void afterMetod() {
		QaExtentReport.test.getExtent().flush();
//		QaBrowser.driver.close();
	}

	public static void catApplicableSearchType(String CatApplicableSearchType, String CatTypeSelect, String CatTypeName)
			throws Exception {
		if (CatApplicableSearchType.equalsIgnoreCase("SelectAllType")) {
			QaRobot.ClickOnElement("SelectAllType");
			Thread.sleep(3000);
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Select All Applicable Type</i></b>");
		} else if (CatApplicableSearchType.equalsIgnoreCase("SearchType")) {
			int tS = Integer.parseInt(CatTypeSelect);
			for (int i = 1; i <= tS; i++) {
				String[] tN = CatTypeName.split(",");
				String b = tN[i - 1];
				TestBase.listofautosuggestion2(By.xpath("(//div[@class='checkbox pt0'])[2]/table/tbody/tr/td"), b,
						By.xpath("//input[@id='txtSearch']"));
			}
		}
	}

}
