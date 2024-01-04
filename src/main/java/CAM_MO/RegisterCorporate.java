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
public class RegisterCorporate {

	@DataProvider
	public Object[][] getexceldata() throws Exception {
		return QaDataProvider.getTestdata("RegisterCorporate1", "Sheet1");
	}

	@Test(dataProvider = "getexceldata")
	public static void registerCorporate(String TestCaseId, String TestCaseType, String TestScenario, String Source,
			String URL, String CompanyCode, String UserName, String Password, String CorporateName, String BranchName,
			String BusinessCurrency, String Address1, String PostBox, String Contry, String CityName, String Telephone,
			String CustomerType, String CreditLimit, String Alert1, String Alert2, String Alert3,
			String SelectBrandingSetting) throws Exception {

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
		QaRobot.ClickOnElement("RegisterCorporate");
		QaBrowser.driver.switchTo().parentFrame();
		QaRobot.switchframe("//frame[@name='main']");
		QaRobot.switchframe("//frame[@id='frm2']");
		QaRobot.PassValue("CorporateName", CorporateName);
		Thread.sleep(3000);
		QaRobot.selectTextByLocator("//select[@id='branchname']", BranchName);
		QaRobot.selectTextByLocator("//select[@id='Currency']", BusinessCurrency);
		QaRobot.PassValue("Address1", Address1);
		QaRobot.PassValue("PostBox", PostBox);
		QaRobot.selectTextByLocator("//select[@id='ddlcountry']", Contry);
		String City[] = CityName.split(",");
		String City1 = City[0];
		String City2 = City[1];
		TestBase.listofautosuggestion(By.xpath("//div[@id='divCity']/p"), City1, City2,
				By.xpath("//input[@id='txtSearch']"));
		QaRobot.PassValue("Telephone", Telephone);
		QaRobot.ClickOnElement("FinancialDetails");
		QaRobot.selectTextByLocator("//select[@id='PaymentMethod']", CustomerType);

		if (CustomerType.equalsIgnoreCase("Cash")) {
			QaRobot.scrollPage("700");
			QaRobot.ClickOnElement("CreditCard");
			QaRobot.ClickOnElement("Wallet");
			QaRobot.ClickOnElement("Cash");
			QaRobot.ClickOnElement("DefaultCash");
		} else if (CustomerType.equalsIgnoreCase("Credit")) {
			QaRobot.PassValue("CreditLimit", CreditLimit);
			QaRobot.PassValue("Alert1", Alert1);
			QaRobot.PassValue("Alert2", Alert2);
			QaRobot.PassValue("Alert3", Alert3);
			QaRobot.scrollPage("400");
			QaRobot.ClickOnElement("CreditCard");
			QaRobot.ClickOnElement("SCreditLimit");
			QaRobot.ClickOnElement("Wallet");
			QaRobot.ClickOnElement("Cash");
			QaRobot.ClickOnElement("DefaultCreditLimit");
		}

		QaRobot.ClickOnElement("ProductAccess");
		QaRobot.scrollPage("700");
		QaRobot.ClickOnElement("AllSuppliers");
		List<WebElement> listOfBrandingSetting = QaBrowser.driver
				.findElements(By.xpath("//table[@id='rblDocumentSetting']/tbody/tr/td/label"));
		for (WebElement autoBrandingSetting : listOfBrandingSetting) {
			if (autoBrandingSetting.getText().equalsIgnoreCase(SelectBrandingSetting)) {
				autoBrandingSetting.click();
				break;
			} else {
			}
		}
		QaRobot.ClickOnElement("SaveButton1");
//		QaRobot.switchframe("//frame[@name='login']");
//		QaRobot.switchframe("//frame[@name='leftbar']");
//		QaRobot.ClickOnElement("SearchCorporate");
//		QaBrowser.driver.switchTo().parentFrame();
//		QaRobot.switchframe("//frame[@name='main']");
//		QaRobot.switchframe("//frame[@id='frm2']");
//		QaRobot.PassValue("CompanyName", CorporateName);
//		QaRobot.ClickOnElement("SearchCompanyName");
//		QaExtentReport.test.log(Status.INFO, "<b><i>Corporate Name</i></b>" + " - " + CorporateName);
//		QaExtentReport.test.log(Status.INFO, "<b><i>Customer Type</i></b>" + " - " + CustomerType);
//		String AccountId = QaBrowser.driver.findElement(By.xpath("//span[@id='GridView1_ctl02_Label2']")).getText();
//		QaExtentReport.test.log(Status.INFO, "<b><i>Account Id</i></b>" + " - " + AccountId);
//		QaRobot.ClickOnElement("ClickOnSearchCompanyName");
//		QaRobot.ClickOnElement("ActivateCorporate");
//		QaRobot.ClickOnElement("FinancialDetails");
//		QaRobot.scrollPage("700");
//		QaRobot.ClickOnElement("SelectCardTypeD");
//		QaRobot.ClickOnElement("SMAsterCard");
//		QaRobot.ClickOnElement("SVisa");
//		QaRobot.ClickOnElement("AssociateCardType");
//		QaRobot.ClickOnElement("SaveButton");
	}

	@AfterMethod
	public static void afterMethod() {
		QaExtentReport.test.getExtent().flush();
	}
}
