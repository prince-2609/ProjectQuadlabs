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
public class Reimbursement 
{
	@DataProvider
	public Object[][] getexceldata() throws Exception 
	{
		return QaDataProvider.getTestdata("ExpenseManagement", "Reimbursement");
	}

	@Test(dataProvider = "getexceldata")
	public static void Profiling1(String Source,String URL, String Comapnycode,String Username,String Password,String TripName,
			String Action) throws Exception 
	{
		TestBase.Companycode(Source,URL); 
		QaRobot.impliwait(30);
		
		QaExtentReport.test = QaExtentReport.report.createTest("Test on Reimbursement");
	
		QaRobot.PassValue("User_name",Username);
		QaExtentReport.test.log(Status.INFO,"<b><i>Write Username</i></b>");
		
		QaRobot.PassValue("Password",Password);
		QaExtentReport.test.log(Status.INFO, "<b><i>Write Password</i></b>");
		
		QaRobot.ClickOnElement("Submit");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on submit</i></b>");
		
		QaRobot.ScreenshotMethod("CorporateLogin","<b><i>Screenshot for Corporate Login Page</i></b>");
	
		QaRobot.mouseHover("//a[@id='HeaderTop_aExpenseMngt']", "//span[@id='HeaderTop_lblReimbursements']");
		
		QaRobot.ScreenshotMethod("CorporateDashboard","<b><i>Screenshot for Reimbursement Page</i></b>");
		
		QaRobot.ClickOnElement("PendingApprovals");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Pending Approvals</i></b>");
		
		QaRobot.PassValue("TripName1",TripName);
		QaExtentReport.test.log(Status.INFO, "<b><i>Write Password</i></b>");
		
		QaRobot.ClickOnElement("ApplyFilters");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Apply Filters Button</i></b>");
		
		QaRobot.ScreenshotMethod("TripName","<b><i>Screenshot for Trip Name</i></b>");
		
		if (Action.equalsIgnoreCase("FinanceApprove"))
		{
			QaRobot.ClickOnElement("FinanceApprove");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Finance Approve Button</i></b>");
			
			BankReconcilation();
		}
		else if (Action.equalsIgnoreCase("FinanceReject"))
		{
			QaRobot.ClickOnElement("FinanceReject");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Finance Reject Button</i></b>");
		}
		else if (Action.equalsIgnoreCase("AskForClarification"))
		{
			QaRobot.ClickOnElement("AskForClarification");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Ask For Clarification Button</i></b>");
		}
	}
	
	@AfterMethod
	public static void afterMetod()
	{
		QaExtentReport.test.getExtent().flush();
//		QaBrowser.driver.close();
	}
	
	public static void BankReconcilation() throws Exception
	{
		QaRobot.ClickOnElement("BankReconcilation");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on BankReconcilation</i></b>");
		
		QaRobot.ClickOnElement("ApplyFilters");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Apply Filters Button</i></b>");
		
		QaRobot.ClickOnElement("CheckBox123");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on CheckBox</i></b>");
		
		QaRobot.ScreenshotMethod("CheckBox","<b><i>Screenshot for Check Box</i></b>");
		
		QaRobot.ClickOnElement("ReconcileFromAll");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Reconcile From All</i></b>");
		
		QaRobot.ClickOnElement("Reconciled");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Reconciled</i></b>");
		
		QaRobot.ScreenshotMethod("Reconciled","<b><i>Screenshot for Reconciled</i></b>");
	}
}
