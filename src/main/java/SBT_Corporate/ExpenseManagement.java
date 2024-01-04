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
public class ExpenseManagement 
{
	@DataProvider
	public Object[][] getexceldata() throws Exception 
	{
		return QaDataProvider.getTestdata("ExpenseManagement", "ExpenseManagement");
	}

	@Test(dataProvider = "getexceldata")
	public static void Profiling1(String Source,String URL, String Comapnycode,String Username,String Password, String TripName,
			String Destination,String Destination_Name,String Next,String Start_Date,String End_Date,String TripType,String CostCenter,
			String PerDiemCurrency,String AdvanceCurrency,String PerDiemAmmount,String AdvanceAmount,String Description,
			String Category,String Merchant,String ExpenseDate,String ExpenseCurrency,String ExpenseAmount,String GSTNumber,
			String ModeOfPayment,String ExpenceComment) throws Exception 
	{
		TestBase.Companycode(Source,URL); 
		QaRobot.impliwait(30);
		
		QaExtentReport.test = QaExtentReport.report.createTest("Test on Expense Management");
	
		QaRobot.PassValue("User_name",Username);
		QaExtentReport.test.log(Status.INFO,"<b><i>Write Username</i></b>");
		
		QaRobot.PassValue("Password",Password);
		QaExtentReport.test.log(Status.INFO, "<b><i>Write Password</i></b>");
		
		QaRobot.ClickOnElement("Submit");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on submit</i></b>");
		
		QaRobot.ScreenshotMethod("CorporateLogin","<b><i>Screenshot for Corporate Login Page</i></b>");
	
		QaRobot.mouseHover("//a[@id='HeaderTop_aExpenseMngt']", "//span[@id='HeaderTop_lbltripsheet']");
		
		QaRobot.ScreenshotMethod("CorporateDashboard","<b><i>Screenshot for Corporate Dashboard Page</i></b>");
		
		QaRobot.ClickOnElement("NewTrip");
		QaExtentReport.test.log(Status.INFO, "<b><i>Click on New Trip</i></b>");
		
		String ParentWindow = QaBrowser.driver.getWindowHandle();
		Set<String> handles = QaBrowser.driver.getWindowHandles();
		for (String childWindow : handles) 
		{
			if (!childWindow.equals(ParentWindow))
				QaBrowser.driver.switchTo().window(childWindow);
		}
		
		QaRobot.PassValue("TripName",TripName);
		QaExtentReport.test.log(Status.INFO,"<b><i>Trip Name is </i></b>"+ TripName);
		
		TestBase.listofautosuggestion(By.xpath("//div[@id='divTripDestinationCity']/p"), Destination,Destination_Name,By.xpath("//input[@id='txtDestination']"));
		QaExtentReport.test.log(Status.INFO, "<b><i>Destination city is </i></b>" + Destination_Name);
		
		if(Next.equalsIgnoreCase("CurrentMonth"))
		{
			QaBrowser.driver.findElement(By.xpath("//input[@id='txtStartDate']")).click();
			QaBrowser.driver.findElement(By.xpath("//a[contains(@title,'" + Start_Date + "')]")).click();
			QaExtentReport.test.log(Status.INFO, "<b><i>Start date is </i></b>" + Start_Date);
			
			QaBrowser.driver.findElement(By.xpath("//input[@id='txtEndDate']")).click();	
			QaBrowser.driver.findElement(By.xpath("//a[contains(@title,'" + End_Date + "')]")).click();
			QaExtentReport.test.log(Status.INFO, "<b><i>End date is </i></b>" + End_Date);
		}	
		else if (Next.equalsIgnoreCase("NextMonth"))
		{	
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
		expense(TripType,CostCenter,PerDiemCurrency,AdvanceCurrency,PerDiemAmmount,AdvanceAmount,Description);
		QaBrowser.driver.switchTo().window(ParentWindow);
		expense1(Category,Merchant,ExpenseDate,ExpenseCurrency,ExpenseAmount,GSTNumber,ModeOfPayment,ExpenceComment);
	}
	
	@AfterMethod
	public static void afterMetod()
	{
		QaExtentReport.test.getExtent().flush();
//		QaBrowser.driver.close();
	}
	
	public static void expense(String TripType,String CostCenter,String PerDiemCurrency,String AdvanceCurrency,String PerDiemAmmount,
			String AdvanceAmount,String Description) throws Exception 
	{
		WebElement DropDown = QaBrowser.driver.findElement(By.xpath("//select[@id='ddltriptype']"));
		Select s = new Select(DropDown);
		s.selectByVisibleText(TripType);
		
		WebElement DropDown1 = QaBrowser.driver.findElement(By.xpath("//select[@id='ddlcostcenter']"));
		Select s1 = new Select(DropDown1);
		s1.selectByVisibleText(CostCenter);
	
		QaRobot.ClickOnElement("PerDiemAllowance");
		QaExtentReport.test.log(Status.INFO, "<b><i>Click on Per Diem Allowance</i></b>");
		
		QaRobot.ClickOnElement("AdvanceAllowance");
		QaExtentReport.test.log(Status.INFO, "<b><i>Click on Advance Amount</i></b>");
		
		WebElement DropDown2 = QaBrowser.driver.findElement(By.xpath("//select[@id='ddlPerDiemCurrency']"));
		Select s2 = new Select(DropDown2);
		s2.selectByVisibleText(PerDiemCurrency);
		
		QaRobot.PassValue("PerDiemAmmount",PerDiemAmmount);
		QaExtentReport.test.log(Status.INFO,"<b><i>Write Per Diem Ammount Is </i></b>"+ PerDiemAmmount);
		
		WebElement DropDown3 = QaBrowser.driver.findElement(By.xpath("//select[@id='ddlAdvanceCurrency']"));
		Select s3 = new Select(DropDown3);
		s3.selectByVisibleText(AdvanceCurrency);
		
		QaRobot.PassValue("AdvanceAmount",AdvanceAmount);
		QaExtentReport.test.log(Status.INFO,"<b><i>Write Advance Amount Is </i></b>"+ AdvanceAmount);
		
		QaRobot.PassValue("Description",Description);
		QaExtentReport.test.log(Status.INFO,"<b><i>Write Description Is </i></b>"+ Description);
		
		QaRobot.ClickOnElement("SaveButton");
		QaExtentReport.test.log(Status.INFO, "<b><i>Click on Save Button</i></b>");	
		
		Alert alt = QaBrowser.driver.switchTo().alert();
		alt.accept();
	}

		public static void expense1(String Category,String Merchant,String ExpenseDate,String ExpenseCurrency,String ExpenseAmount,String GSTNumber,
				String ModeOfPayment,String ExpenceComment) throws Exception
		{
		QaRobot.ClickOnElement("SelectTripName");
		QaExtentReport.test.log(Status.INFO, "<b><i>Click on Select Trip Name</i></b>");
		
		QaRobot.ClickOnElement("AddExpenseButton");
		QaExtentReport.test.log(Status.INFO, "<b><i>Click on Add Expense Button</i></b>");
		Thread.sleep(3000);
		
		String ParentWindow1 = QaBrowser.driver.getWindowHandle();
		Set<String> handles1 = QaBrowser.driver.getWindowHandles();
		for (String childWindow1 : handles1) 
		{
			if (!childWindow1.equals(ParentWindow1))
				QaBrowser.driver.switchTo().window(childWindow1);
		}
		
		QaRobot.ClickOnElement("AddExpenseButton1");
		
		WebElement DropDown4 = QaBrowser.driver.findElement(By.xpath("//select[@id='ddlCategory']"));
		Select s4 = new Select(DropDown4);
		s4.selectByVisibleText(Category);
		
		QaRobot.PassValue("Merchant",Merchant);
		QaExtentReport.test.log(Status.INFO,"<b><i>Write Merchant</i></b>");
		
		QaRobot.ClickOnElement("ExpenseDate");
		QaExtentReport.test.log(Status.INFO, "<b><i>Click on Expense Date Button</i></b>");	
		
		QaBrowser.driver.findElement(By.xpath("//a[contains(@title,'" + ExpenseDate + "')]")).click();
		QaExtentReport.test.log(Status.INFO, "<b><i>Expense date is</i></b>" + ExpenseDate);
		
		WebElement DropDown5 = QaBrowser.driver.findElement(By.xpath("//select[@id='ddlExpenseCurrency']"));
		Select s5 = new Select(DropDown5);
		s5.selectByVisibleText(ExpenseCurrency);
		
		QaRobot.PassValue("ExpenseAmount",ExpenseAmount);
		QaExtentReport.test.log(Status.INFO,"<b><i>Write Expense Amount Is </i></b>"+ ExpenseAmount);
		
		WebElement DropDown6 = QaBrowser.driver.findElement(By.xpath("//select[@id='ddlGSTNumber']"));
		Select s6 = new Select(DropDown6);
		s6.selectByVisibleText(GSTNumber);
		
		WebElement DropDown7 = QaBrowser.driver.findElement(By.xpath("//select[@id='ddlExpenseMOP']"));
		Select s7 = new Select(DropDown7);
		s7.selectByVisibleText(ModeOfPayment);
		
		QaRobot.PassValue("ExpenceComment",ExpenceComment);
		QaExtentReport.test.log(Status.INFO,"<b><i>Write Expense Comment Is </i></b>"+ ExpenceComment);
		
		QaRobot.ClickOnElement("ExpenseAdd");
		QaExtentReport.test.log(Status.INFO, "<b><i>Click on Expense Add Button</i></b>");	
		
		Alert alt4 = QaBrowser.driver.switchTo().alert();
		alt4.accept();
		Thread.sleep(2000);
		
		QaRobot.ClickOnElement("ExpenseAdd");	
		Thread.sleep(3000);
		
		Alert alt1 = QaBrowser.driver.switchTo().alert();
		alt1.accept();
		Thread.sleep(2000);
		
		Alert alt2 = QaBrowser.driver.switchTo().alert();
		alt2.accept();
		Thread.sleep(2000);
		
		QaBrowser.driver.switchTo().window(ParentWindow1);
		
		QaRobot.ClickOnElement("SendForApproval");
		QaExtentReport.test.log(Status.INFO, "<b><i>Click on Send For Approval Button</i></b>");	
		
		String ParentWindow2 = QaBrowser.driver.getWindowHandle();
		Set<String> handles2 = QaBrowser.driver.getWindowHandles();
		for (String childWindow2 : handles2) 
		{
			if (!childWindow2.equals(ParentWindow2))
				QaBrowser.driver.switchTo().window(childWindow2);
		}
		
		QaRobot.ClickOnElement("ApprovalButton");
		QaExtentReport.test.log(Status.INFO, "<b><i>Click on Final Approval Button</i></b>");
		
		Alert alt3 = QaBrowser.driver.switchTo().alert();
		alt3.accept();
		
		QaBrowser.driver.switchTo().window(ParentWindow2);
	}
}
