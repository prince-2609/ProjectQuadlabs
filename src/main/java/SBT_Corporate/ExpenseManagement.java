package SBT_Corporate;

import java.util.Set;

import org.openqa.selenium.Alert;
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
public class ExpenseManagement {
	@DataProvider
	public Object[][] getexceldata() throws Exception {
		return QaDataProvider.getTestdata("ExpenseManagement", "Expensemanagement1");
	}

	@Test(dataProvider = "getexceldata")
	public static void Profiling1(String TestCaseId, String TestScenario,String Source, String URL, String Comapnycode, String LoginType, String Emailid,
			String SDN, String Username, String Password, String TripName, String Destination, String Destination_Name,
			String Next, String Start_Date, String End_Date, String TripType, String CostCenter, String PerDiemCurrency,
			String AdvanceCurrency, String Projectsheet,String PerDiemAmmount, String AdvanceAmount, String Description, String Category,
			String Merchant, String ExpenseDate, String ExpenseCurrency, String ExpenseAmount, String GSTNumber,
			String ModeOfPayment, String ExpenceComment) throws Exception {
		QaExtentReport.test = QaExtentReport.report.createTest(TestCaseId + "-" + TestScenario);
		TestBase.Companycode(Source, URL);
		QaRobot.impliwait(30);
		if (LoginType.equalsIgnoreCase("Old Url")) {
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
		// QaRobot.ScreenshotMethod("CorporateLogin","<b><i>Screenshot for Corporate
		// Login Page</i></b>");
		QaRobot.mouseHover("//a[@id='HeaderTop_aExpenseMngt']", "//span[@id='HeaderTop_lbltripsheet']");
//		QaRobot.ScreenshotMethod("CorporateDashboard","<b><i>Screenshot for Corporate Dashboard Page</i></b>");
		QaRobot.ClickOnElement("NewTrip");
		Thread.sleep(2000);
		QaExtentReport.extentScreenshot("New Expense sheet");

		String ParentWindow = QaBrowser.driver.getWindowHandle();
		Set<String> handles = QaBrowser.driver.getWindowHandles();
		for (String childWindow : handles) {
			if (!childWindow.equals(ParentWindow))
				QaBrowser.driver.switchTo().window(childWindow);
		}
		QaRobot.PassValue("TripName", TripName);
		QaExtentReport.test.log(Status.INFO, "<b><i>Trip Name is </i></b>" + TripName);
		Thread.sleep(2000);
		TestBase.listofautosuggestion(By.xpath("//div[@id='divTripDestinationCity']/p"), Destination, Destination_Name,
				By.xpath("//input[@id='txtDestination']"));
		Thread.sleep(3000);
//		QaExtentReport.test.log(Status.INFO, "<b><i>Destination city is </i></b>" + Destination_Name);

		if (Next.equalsIgnoreCase("CurrentMonth")) {
			QaBrowser.driver.findElement(By.xpath("//input[@id='txtStartDate']")).click();
			QaBrowser.driver.findElement(By.xpath("//a[contains(@title,'" + Start_Date + "')]")).click();
			QaExtentReport.test.log(Status.INFO, "<b><i>Start date is </i></b>" + Start_Date);
			QaBrowser.driver.findElement(By.xpath("//input[@id='txtEndDate']")).click();
			QaBrowser.driver.findElement(By.xpath("//a[contains(@title,'" + End_Date + "')]")).click();
			QaExtentReport.test.log(Status.INFO, "<b><i>End date is </i></b>" + End_Date);
		} else if (Next.equalsIgnoreCase("NextMonth")) {
			QaBrowser.driver.findElement(By.xpath("//input[@id='txtStartDate']")).click();
			Thread.sleep(2000);
			QaRobot.ClickOnElement("NextmonthButton");
			Thread.sleep(2000);
			QaBrowser.driver.findElement(By.xpath("//a[contains(@title,'" + Start_Date + "')]")).click();
			QaExtentReport.test.log(Status.INFO, "<b><i>Start date is </i></b>" + Start_Date);

			QaBrowser.driver.findElement(By.xpath("//input[@id='txtEndDate']")).click();
			QaBrowser.driver.findElement(By.xpath("//a[contains(@title,'" + End_Date + "')]")).click();
			QaExtentReport.test.log(Status.INFO, "<b><i>End date is </i></b>" + End_Date);

		}
		expense(TripType, CostCenter, PerDiemCurrency, AdvanceCurrency,Projectsheet, PerDiemAmmount, AdvanceAmount, Description);
		QaBrowser.driver.switchTo().window(ParentWindow);
		expense1(Category, Merchant, ExpenseDate, ExpenseCurrency, ExpenseAmount, GSTNumber, ModeOfPayment,
				ExpenceComment);
	}

	@AfterMethod
	public static void afterMetod() {
		QaExtentReport.test.getExtent().flush();
//		QaBrowser.driver.close();
	}

	public static void expense(String TripType, String CostCenter, String PerDiemCurrency, String AdvanceCurrency,String Projectsheet,
			String PerDiemAmmount, String AdvanceAmount, String Description) throws Exception {
		WebElement DropDown = QaBrowser.driver.findElement(By.xpath("//select[@id='ddltriptype']"));
		Select s = new Select(DropDown);
		s.selectByVisibleText(TripType);

		WebElement DropDown1 = QaBrowser.driver.findElement(By.xpath("//select[@id='ddlcostcenter']"));
		Select s1 = new Select(DropDown1);
		s1.selectByVisibleText(CostCenter);
		Thread.sleep(2000);
		WebElement DropDown4 = QaBrowser.driver.findElement(By.xpath("//select[@id='ddlProject']"));
		Select s4 = new Select(DropDown4);
		s4.selectByVisibleText(Projectsheet);
		QaRobot.ClickOnElement("PerDiemAllowance");
		QaExtentReport.test.log(Status.INFO, "<b><i>Click on Per Diem Allowance</i></b>");

		QaRobot.ClickOnElement("AdvanceAllowance");
		QaExtentReport.test.log(Status.INFO, "<b><i>Click on Advance Amount</i></b>");

		WebElement DropDown2 = QaBrowser.driver.findElement(By.xpath("//select[@id='ddlPerDiemCurrency']"));
		Select s2 = new Select(DropDown2);
		s2.selectByVisibleText(PerDiemCurrency);

		QaRobot.PassValue("PerDiemAmmount", PerDiemAmmount);
		QaExtentReport.test.log(Status.INFO, "<b><i>Per Diem Ammount Is </i></b>" + PerDiemAmmount);

		WebElement DropDown3 = QaBrowser.driver.findElement(By.xpath("//select[@id='ddlAdvanceCurrency']"));
		Select s3 = new Select(DropDown3);
		s3.selectByVisibleText(AdvanceCurrency);

		QaRobot.PassValue("AdvanceAmount", AdvanceAmount);
		QaExtentReport.test.log(Status.INFO, "<b><i>Advance Amount Is </i></b>" + AdvanceAmount);
		Thread.sleep(2000);
		QaRobot.PassValue("Descriptionexp", Description);
		QaExtentReport.test.log(Status.INFO, "<b><i>Description Is </i></b>" + Description);
		Thread.sleep(2000);
		QaExtentReport.extentScreenshot("Expense sheet");
		Thread.sleep(2000);
		QaRobot.ClickOnElement("expenseSaveButton");
//		QaExtentReport.test.log(Status.INFO, "<b><i>Click on Save Button</i></b>");
		Alert alt = QaBrowser.driver.switchTo().alert();
		alt.accept();
	}

	public static void expense1(String Category, String Merchant, String ExpenseDate, String ExpenseCurrency,
			String ExpenseAmount, String GSTNumber, String ModeOfPayment, String ExpenceComment) throws Exception {
		QaRobot.ClickOnElement("SelectTripName");
		QaExtentReport.test.log(Status.INFO, "<b><i>Click on Select Trip Name</i></b>");

		QaRobot.ClickOnElement("AddExpenseButton");
		Thread.sleep(2000);
		QaExtentReport.extentScreenshot("AddExpense");
		Thread.sleep(3000);

		String ParentWindow1 = QaBrowser.driver.getWindowHandle();
		Set<String> handles1 = QaBrowser.driver.getWindowHandles();
		for (String childWindow1 : handles1) {
			if (!childWindow1.equals(ParentWindow1))
				QaBrowser.driver.switchTo().window(childWindow1);
		}
		QaRobot.ClickOnElement("AddExpenseButton1");
		QaExtentReport.extentScreenshot("AddExpense1");

		WebElement DropDown4 = QaBrowser.driver.findElement(By.xpath("//select[@id='ddlCategory']"));
		Select s4 = new Select(DropDown4);
		s4.selectByVisibleText(Category);

		QaRobot.PassValue("Merchant", Merchant);
//		QaExtentReport.test.log(Status.INFO, "<b><i>Write Merchant</i></b>");

		QaRobot.ClickOnElement("ExpenseDate");
//		QaExtentReport.test.log(Status.INFO, "<b><i>Click on Expense Date Button</i></b>");

		QaBrowser.driver.findElement(By.xpath("//a[contains(@title,'" + ExpenseDate + "')]")).click();
		QaExtentReport.test.log(Status.INFO, "<b><i>Expense date is</i></b>" + ExpenseDate);

		WebElement DropDown5 = QaBrowser.driver.findElement(By.xpath("//select[@id='ddlExpenseCurrency']"));
		Select s5 = new Select(DropDown5);
		s5.selectByVisibleText(ExpenseCurrency);

		QaRobot.PassValue("ExpenseAmount", ExpenseAmount);
		QaExtentReport.test.log(Status.INFO, "<b><i>Expense Amount Is </i></b>" + ExpenseAmount);
		Thread.sleep(2000);
		WebElement DropDown6 = QaBrowser.driver.findElement(By.xpath("//select[@id='ddlGSTNumber']"));
		Select s6 = new Select(DropDown6);
		s6.selectByVisibleText(GSTNumber);
		Thread.sleep(2000);
		WebElement DropDown7 = QaBrowser.driver.findElement(By.xpath("//select[@id='ddlExpenseMOP']"));
		Select s7 = new Select(DropDown7);
		s7.selectByVisibleText(ModeOfPayment);
		Thread.sleep(2000);
		QaRobot.PassValue("ExpenceComment", ExpenceComment);
		QaExtentReport.test.log(Status.INFO, "<b><i>Expense Comment Is </i></b>" + ExpenceComment);
		QaExtentReport.extentScreenshot("Expense Details");
		Thread.sleep(2000);
		QaRobot.ClickOnElement("ExpenseAdd");
		Thread.sleep(2000);
//		QaExtentReport.test.log(Status.INFO, "<b><i>Click on Expense Add Button</i></b>");
		Alert alt4 = QaBrowser.driver.switchTo().alert();
		alt4.accept();
//		QaRobot.ClickOnElement("ExpenseAdd");
//		Thread.sleep(3000);
		Alert alt1 = QaBrowser.driver.switchTo().alert();
		alt1.accept();
//		Alert alt2 = QaBrowser.driver.switchTo().alert();
//		alt2.accept();
		QaBrowser.driver.switchTo().window(ParentWindow1);

		QaRobot.ClickOnElement("SendForApproval");
		QaExtentReport.extentScreenshot("SendForApproval");
//		QaExtentReport.test.log(Status.INFO, "<b><i>Click on Send For Approval Button</i></b>");

		String ParentWindow2 = QaBrowser.driver.getWindowHandle();
		Set<String> handles2 = QaBrowser.driver.getWindowHandles();
		for (String childWindow2 : handles2) {
			if (!childWindow2.equals(ParentWindow2))
				QaBrowser.driver.switchTo().window(childWindow2);
		}
		QaExtentReport.extentScreenshot("Approval");
		QaRobot.ClickOnElement("ApprovalButton");

//		QaExtentReport.test.log(Status.INFO, "<b><i>Click on Final Approval Button</i></b>");

		Alert alt3 = QaBrowser.driver.switchTo().alert();
		alt3.accept();

		QaBrowser.driver.switchTo().window(ParentWindow2);
	}
}
