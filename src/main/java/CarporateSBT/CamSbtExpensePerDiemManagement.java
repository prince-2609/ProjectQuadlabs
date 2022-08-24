package CarporateSBT;

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
public class CamSbtExpensePerDiemManagement 
{
	@DataProvider
	public Object[][] getexceldata() throws Exception 
	{
		return QaDataProvider.getTestdata("CamSbtExpenseManagement", "PerDiemAllowance");
	}

	@Test(dataProvider = "getexceldata")
	public static void Profiling1(String Source,String URL, String Comapnycode,String Username,String Password,String AllowanceName,
			String DestinationAdd,String Destination_Add,String CurrencyType,String EnterAmount,String Categories,String CategorySelect,
			String CategoryName,String ApplicableOn,String ApplicableSearchType,String TypeSelect, String TypeName) throws Exception 
	{
		TestBase.Companycode(Source,URL); 
		QaRobot.impliwait(30);
		
		QaExtentReport.test = QaExtentReport.report.createTest("Test on CAM SBT Expense Management");
	
		QaRobot.PassValue("User_name",Username);
		QaExtentReport.test.log(Status.INFO,"<b><i>Write Username</i></b>");
		
		QaRobot.PassValue("Password",Password);
		QaExtentReport.test.log(Status.INFO, "<b><i>Write Password</i></b>");
		
		QaRobot.ClickOnElement("Submit");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on submit</i></b>");
		
		QaRobot.ScreenshotMethod("CorporateLogin","<b><i>Screenshot for Corporate Login Page</i></b>");
	
		QaRobot.mouseHover("//span[@id='HeaderTop_lblSettingMenu']", "//span[@id='HeaderTop_lblComapnayManagement']");
		
		QaRobot.ScreenshotMethod("CorporateDashboard","<b><i>Screenshot for Corporate Dashboard Page</i></b>");
		
		QaRobot.ClickOnElement("PerDiemAllowance1");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Per Diem Allowance</i></b>");
		
		QaRobot.ClickOnElement("AddNew");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Add New Button</i></b>");
		
		String ParentWindow = QaBrowser.driver.getWindowHandle();
		Set<String> handles = QaBrowser.driver.getWindowHandles();
		for (String childWindow : handles) 
		{
			if (!childWindow.equals(ParentWindow))
				QaBrowser.driver.switchTo().window(childWindow);
		}
		
		QaRobot.PassValue("AllowanceName",AllowanceName);
		QaExtentReport.test.log(Status.INFO, "<b><i>Write Allowance Name </i></b>"+AllowanceName);
		
		TestBase.listofautosuggestion(By.xpath("//div[@id='divTripDestinationCity']/p"), DestinationAdd,Destination_Add,By.xpath("//input[@id='txtDestination']"));
		QaExtentReport.test.log(Status.INFO, "<b><i>Destination city is </i></b>" + Destination_Add);
		
		WebElement DropDown = QaBrowser.driver.findElement(By.xpath("//select[@id='ddlCurrency']"));
		Select s = new Select(DropDown);
		s.selectByVisibleText(CurrencyType);
		
		QaRobot.PassValue("EnterAmmount",EnterAmount);
		QaExtentReport.test.log(Status.INFO, "<b><i>Write Amount </i></b>"+AllowanceName);
		
		QaRobot.ClickOnElement("Categories");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Category Select</i></b>");
		
		Categories(Categories,CategorySelect,CategoryName);
		
		WebElement DropDown1 = QaBrowser.driver.findElement(By.xpath("//select[@id='ddlApplicableOn']"));
		Select s1 = new Select(DropDown1);
		s1.selectByVisibleText(ApplicableOn);
		Thread.sleep(5000);
		
		applicableSearchType(ApplicableSearchType,TypeSelect,TypeName);
		Thread.sleep(3000);
		
		QaRobot.ClickOnElement("PerDeimAllowanceSave");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Per Deim Allowance Save</i></b>");
	}
	
	@AfterMethod
	public static void afterMetod()
	{
		QaExtentReport.test.getExtent().flush();
//		QaBrowser.driver.close();
	}
	
	public static void Categories(String Categories,String CategorySelect,String CategoryName) throws Exception
	{
		if (Categories.equalsIgnoreCase("SelectAll"))
		{
			QaRobot.ClickOnElement("selectAll");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on select All Button</i></b>");
			QaRobot.ClickOnElement("Categories");
		}else if (Categories.equalsIgnoreCase("ClearAll"))
		{
			QaRobot.ClickOnElement("ClearAll");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on select All Button</i></b>");
			QaRobot.ClickOnElement("Categories");
		}else if (Categories.equalsIgnoreCase("CategorySelect"))
		{
			int cS = Integer.parseInt(CategorySelect);
			for (int i = 1; i <= cS; i++) 
			{
				String[] CategoryN = CategoryName.split(",");
				String a = CategoryN[i-1];
				TestBase.listofautosuggestion1(By.xpath("//div[@class='scrolableDiv']/li"),a,By.xpath("//input[@placeholder='Search']"));
			}
	        QaRobot.ClickOnElement("Categories");
		}
	}
	
	public static void applicableSearchType(String ApplicableSearchType,String TypeSelect, String TypeName) throws Exception
	{
		if (ApplicableSearchType.equalsIgnoreCase("SelectAllType"))
		{
			QaRobot.ClickOnElement("SelectAllType");
			Thread.sleep(3000);
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Select All Applicable Type</i></b>");
		}else if (ApplicableSearchType.equalsIgnoreCase("SearchType"))
		{
			int tS = Integer.parseInt(TypeSelect);
			for (int i = 1; i <= tS; i++) 
			{
				String[] tN = TypeName.split(",");
				String b = tN[i-1];
				TestBase.listofautosuggestion2(By.xpath("(//div[@class='checkbox pt0'])[2]/table/tbody/tr/td"),b,By.xpath("//input[@id='txtSearch']"));
			}
		}
	}
}
