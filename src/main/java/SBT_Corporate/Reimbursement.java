package SBT_Corporate;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Base.TestBase;
import utilities.QaDataProvider;
import utilities.QaExtentReport;
import utilities.QaRobot;

@Listeners(listenerClass.Listener.class)
public class Reimbursement {
	@DataProvider
	public Object[][] getexceldata() throws Exception {
		return QaDataProvider.getTestdata("ExpenseManagement", "Reimbursement1");
	}

	@Test(dataProvider = "getexceldata")
	public static void Profiling1(String TestCaseId, String TestScenario,String Source, String URL, String Comapnycode, String LoginType, String Emailid,
			String SDN, String Username, String Password, String TripName, String Action) throws Exception {
		QaExtentReport.test = QaExtentReport.report.createTest(TestCaseId + "-" + TestScenario);
		TestBase.Companycode(Source, URL);
		QaRobot.impliwait(30);
		if (LoginType.equalsIgnoreCase("Old Url")) {
			QaRobot.PassValue("User_name", Username);
			QaExtentReport.test.log(Status.INFO, "<b><i>Username</i></b>");
			QaRobot.PassValue("Password", Password);
			QaExtentReport.test.log(Status.INFO, "<b><i>Password</i></b>");
			QaRobot.ClickOnElement("Submit");
		} else if (LoginType.equalsIgnoreCase("SSOLogin")) {
			QaRobot.PassValue("SSOEmail", Emailid);
			QaRobot.PassValue("SSOSDN", SDN);
			QaExtentReport.extentScreenshot("Sign In Page");
			QaRobot.ClickOnElement("SSOEncrypt");
			QaRobot.ClickOnElement("SSOSubmit");
		}
		QaRobot.mouseHover("//a[@id='HeaderTop_aExpenseMngt']", "//span[@id='HeaderTop_lblReimbursements']");
		QaRobot.ClickOnElement("PendingApprovals");
//		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Pending Approvals</i></b>");

		QaRobot.PassValue("TripName1", TripName);
		QaRobot.ClickOnElement("ApplyFilters");
		QaExtentReport.extentScreenshot("Pending approval");
		if (Action.equalsIgnoreCase("FinanceApprove")) {
			QaRobot.ClickOnElement("FinanceApprove");
			QaExtentReport.extentScreenshot("Finance approved");
			BankReconcilation();
		} else if (Action.equalsIgnoreCase("FinanceReject")) {
			QaRobot.ClickOnElement("FinanceReject");
			QaExtentReport.extentScreenshot("Finance Rejected");
//			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Finance Reject Button</i></b>");
		} else if (Action.equalsIgnoreCase("AskForClarification")) {
			QaRobot.ClickOnElement("AskForClarification");
			QaExtentReport.extentScreenshot("AskForClarification");
		}
	}

	@AfterMethod
	public static void afterMetod() {
		QaExtentReport.test.getExtent().flush();
//		QaBrowser.driver.close();
	}

	public static void BankReconcilation() throws Exception {
		QaRobot.ClickOnElement("BankReconcilation");
//		QaExtentReport.extentScreenshot("BankReconcilation");
		QaRobot.ClickOnElement("ApplyFilters");
		QaExtentReport.extentScreenshot("ApplyFilters");
//		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Apply Filters Button</i></b>");
		Thread.sleep(3000);
		QaRobot.ClickOnElement("CheckBox123");
//		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on CheckBox</i></b>");
		QaExtentReport.extentScreenshot("CheckBox123");
//		QaRobot.ScreenshotMethod("CheckBox", "<b><i>Screenshot for Check Box</i></b>");
		Thread.sleep(3000);
		QaRobot.ClickOnElement("ReconcileFromAll");
//		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Reconcile From All</i></b>");
		QaExtentReport.extentScreenshot("ReconcileFromAll");
		QaRobot.ClickOnElement("Reconciled");
//		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Reconciled</i></b>");
		QaExtentReport.extentScreenshot("Reconciled");
//		QaRobot.ScreenshotMethod("Reconciled", "<b><i>Screenshot for Reconciled</i></b>");
	}
}
