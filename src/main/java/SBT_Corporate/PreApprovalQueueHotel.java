package SBT_Corporate;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
public class PreApprovalQueueHotel 
{
	@DataProvider
	public Object[][] getexceldata() throws Exception 
	{
		return QaDataProvider.getTestdata("PreApprovalHotel", "PreApprovalQueueHotel");
	}
	
	public static void selectDependentPax(String adult, String child) throws InterruptedException 
	{
		int adt = Integer.parseInt(adult);
		int chd = Integer.parseInt(child);
		for (int i = 1; i < adt; i++) 
		{
			QaBrowser.driver.findElement(By.xpath("//input[@id='rptPaxDetails_ctl01_rptDetails_ctl0" + i + "_chk']")).click();
			Thread.sleep(3000);
		}
		for (int i = 1; i <= chd; i++)
		{
			QaBrowser.driver.findElement(By.xpath("//input[@id='rptPaxDetails_ctl02_rptDetails_ctl0" + i + "_chk']")).click();
			Thread.sleep(3000);
		}
	}
	
	public static void selectDependentPriority(String adult, String child) throws InterruptedException 
	{
		int adt = Integer.parseInt(adult);
		int chd = Integer.parseInt(child);
		for (int i = 1; i <= adt; i++) 
		{
			WebElement webelement = QaBrowser.driver.findElement(By.xpath("//select[@id='rptSelectionList_ctl01_rptSelection_ctl0" + i + "_ddlPriority']"));
			Select select = new Select(webelement);
			select.selectByIndex(i);
			Thread.sleep(3000);
		}
		for (int i = 1; i <= chd; i++) 
		{
			WebElement webelement = QaBrowser.driver.findElement(By.xpath("//select[@id='rptSelectionList_ctl02_rptSelection_ctl0" + i + "_ddlPriority']"));
			Select select = new Select(webelement);
			select.selectByIndex(i);
			Thread.sleep(3000);
		}
	  }
	
	public static void selectTextByLocator(String xpath, String value, String text) throws Exception
	{
		WebElement element = QaBrowser.driver.findElement(By.xpath(xpath));
		Select s = new Select(element);
		s.selectByVisibleText(value);
		QaExtentReport.test.log(Status.INFO, text);
	}
	
	public static void GuestAdultCheckout(String adult,String AdultDate, String AdultMonth, String AdultYear,String isd,String PhoneNumber) throws Exception 
	{
		int adt = Integer.parseInt(adult);
		for (int i = 1; i <= adt; i++) 
		{
			// Fill Day
			String adultdayElement = "(//select[@id='ctl00_contentMain_txt_DobAdt_H1_ddlDay'])[" + i + "]";
			String[] adultday = AdultDate.split(",");
			QaRobot.selectValueByLocator(adultdayElement, adultday[i - 1],"<b><i>Selected Day For Adult</i></b>");
						
			// Fill Month
			String adultmonthElement = "(//select[@id='ctl00_contentMain_txt_DobAdt_H1_ddlMonth'])[" + i + "]";
			String[] adultmm = AdultMonth.split(",");
			QaRobot.selectTextByLocator(adultmonthElement, adultmm[i - 1], "<b><i>Selected Month For Adult</i></b>");
						
			// Fill Year
			String adultyearElement = "(//select[@id='ctl00_contentMain_txt_DobAdt_H1_ddlYear'])[" + i + "]";
			String[] adulty = AdultYear.split(",");
			QaRobot.selectTextByLocator(adultyearElement, adulty[i - 1], "<b><i>Selected Year For Adult</i></b>");
		}
		// fill Phone number and isd
		String adultisdElement = "//input[@id='ctl00_contentMain_txt_isdAdt_H']";
		QaRobot.PassValueByLocator(adultisdElement, isd, "<b><i>Entered isd Number For Adult</i></b>");

		String adultphonenumberElement = "//input[@id='ctl00_contentMain_txt_phoneAdt_H']";
		QaRobot.PassValueByLocator(adultphonenumberElement, PhoneNumber, "<b><i>Entered phone Number For Adult</i></b>");
	}
	
	public static void GuestChildCheckout(String child,String ChildDate, String ChildMonth, String ChildYear) throws Exception 
	{
		int chd = Integer.parseInt(child);
		for (int i = 1; i <= chd; i++) 
		{
			// Fill Day
			String childdayElement = "(//select[@id='ctl00_contentMain_txt_DobChd_H_ddlDay'])[" + i + "]";
			String[] childday = ChildDate.split(",");
			QaRobot.selectValueByLocator(childdayElement, childday[i - 1],"<b><i>Selected Day For Child</i></b>");
						
			// Fill Month
			String childmonthElement = "(//select[@id='ctl00_contentMain_txt_DobChd_H_ddlMonth'])[" + i + "]";
			String[] childmm = ChildMonth.split(",");
			QaRobot.selectTextByLocator(childmonthElement, childmm[i - 1], "<b><i>Selected Month For Child</i></b>");
						
			// Fill Year
			String childyearElement = "(//select[@id='ctl00_contentMain_txt_DobChd_H_ddlYear'])[" + i + "]";
			String[] childy = ChildYear.split(",");
			QaRobot.selectTextByLocator(childyearElement,childy[i - 1], "<b><i>Selected Year For Child</i></b>");
		}
	}
	
	
	@Test(dataProvider = "getexceldata")
	public static void Profiling1(String Source,String URL, String Comapnycode,String Username,String Password, String Enquiryid,String BookingType,
			String adult,String child,String AdultDate,String AdultMonth,String AdultYear,String isd,String PhoneNumber,String ChildDate,String ChildMonth,String ChildYear) throws Exception 
	{
		TestBase.Companycode(Source,URL); 
		QaRobot.impliwait(30);
		
		QaExtentReport.test = QaExtentReport.report.createTest("Test on Pre Approval Queue For Hotel Queue");
	
		QaRobot.PassValue("User_name",Username);
		QaExtentReport.test.log(Status.INFO,"<b><i>Write Username</i></b>");
		
		QaRobot.PassValue("Password",Password);
		QaExtentReport.test.log(Status.INFO, "<b><i>Write Password</i></b>");
		
		QaRobot.ClickOnElement("Submit");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on submit</i></b>");
		
		QaRobot.ScreenshotMethod("CorporateLogin","<b><i>Screenshot for Corporate Login Page</i></b>");
		
		QaRobot.mouseHover("//a[@id='HeaderTop_aBookingMenu']", "//span[@id='HeaderTop_lblEnquiryQueue']");
	
		QaRobot.ScreenshotMethod("CorporateDashboard","<b><i>Screenshot for Corporate Dashboard Page</i></b>");
		
		QaRobot.ClickOnElement("Additionalsearch");
		QaExtentReport.test.log(Status.INFO, "<b><i>Click on Additionalsearch</i></b>");
		
		QaRobot.PassValue("EnterEnquiryId", Enquiryid);
		QaExtentReport.test.log(Status.INFO, "<b><i>Write Enquiry Id Is</i></b>  "+Enquiryid);
		
		QaRobot.ScreenshotMethod("EnquiryId","<b><i>Screenshot for Enquiry Id</i></b>");
		
		QaRobot.ClickOnElement("Search");
		QaExtentReport.test.log(Status.INFO, "<b><i>Click on Search Button</i></b>");
		
		QaRobot.ClickOnElement("View");
		QaExtentReport.test.log(Status.INFO, "<b><i>Click on View Button</i></b>");
		Thread.sleep(5000);
		
		QaRobot.ScreenshotMethod("View","<b><i>Screenshot for View Button</i></b>");
		
		QaRobot.ClickOnElement("ViewClose");
		QaExtentReport.test.log(Status.INFO, "<b><i>Click on View Close Button</i></b>");
		
		QaRobot.ClickOnElement("Book");
		QaExtentReport.test.log(Status.INFO,  "<b><i>Click on Book</i></b>");
		
		QaRobot.ScreenshotMethod("BookButton","<b><i>Screenshot for Book Button</i></b>");
		
		QaRobot.ClickOnElement("ProceedToCheckout");
		QaExtentReport.test.log(Status.INFO, "<b><i>Click on ProceedToCheckout</i></b>");
		Thread.sleep(3000);
		
		QaRobot.ScreenshotMethod("ProceedCheckout","<b><i>Screenshot for ProceedToCheckout</i></b>");
		
		if(BookingType.equalsIgnoreCase("Dependent"))
		{
			String ParentWindow = QaBrowser.driver.getWindowHandle();
			
			QaRobot.ClickOnElement("dept_AssociatePax");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Associate pax</i></b>");
			Thread.sleep(3000);
			
			Set<String> handles = QaBrowser.driver.getWindowHandles();
			for (String childWindow : handles) 
			{
				if (!childWindow.equals(ParentWindow))
					QaBrowser.driver.switchTo().window(childWindow);
			}
			
			PreApprovalQueueHotel.selectDependentPax(adult,child);
			Thread.sleep(3000);
			
			QaRobot.ClickOnElement("dept_AddToList");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on add to list Button</i></b>");
			Thread.sleep(3000);
			
			PreApprovalQueueHotel.selectDependentPriority(adult, child);
			
			QaRobot.ClickOnElement("dept_AssociateButton");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Associate Button</i></b>");
			Thread.sleep(3000);
			
			QaBrowser.driver.switchTo().window(ParentWindow);
		
			PreApprovalQueueHotel.checkout();
		}
		else if(BookingType.equalsIgnoreCase("Guest"))
		{
			PreApprovalQueueHotel.GuestAdultCheckout(adult, AdultDate, AdultMonth, AdultYear, isd, PhoneNumber);
			
			PreApprovalQueueHotel.GuestChildCheckout(child, ChildDate, ChildMonth, ChildYear);
			
			WebElement WebElement2 = QaBrowser.driver.findElement(By.xpath("//a[normalize-space()='Fare Breakup']"));
			JavascriptExecutor js2 = (JavascriptExecutor) QaBrowser.driver;
			js2.executeScript("arguments[0].click()", WebElement2);
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on FareBreackup</i></b>");
			Thread.sleep(3000);
//			QaRobot.ClickOnElement("FareBreackup");
//			QaExtentReport.test.log(Status.INFO, "<b><i>Click on FareBreackup</i></b>");
//			Thread.sleep(3000);
			
			QaRobot.ScreenshotMethod("FareBreackup","<b><i>Screenshot for Fare Breackup</i></b>");
			
			WebElement WebElement3 = QaBrowser.driver.findElement(By.xpath("//a[@title='Close']"));
			JavascriptExecutor js3 = (JavascriptExecutor) QaBrowser.driver;
			js3.executeScript("arguments[0].click()", WebElement3);
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on FareBreackupClose</i></b>");
//			QaRobot.ClickOnElement("FareBreackupClose");
//			QaExtentReport.test.log(Status.INFO, "<b><i>Click on FareBreackupClose</i></b>");
			
			PreApprovalQueueHotel.checkout1();
		}
		
		else 
		{
			PreApprovalQueueHotel.checkout();
		}
		
	}
		
	@AfterMethod
	public static void afterMetod() 
	{
		QaExtentReport.test.getExtent().flush();
//		QaBrowser.driver.close();
	}	
	
	public static void checkout() throws Exception
	{
		QaRobot.ClickOnElement("FareBreackup1");
		QaExtentReport.test.log(Status.INFO, "<b><i>Click on FareBreackup</i></b>");
		Thread.sleep(3000);
		
		QaRobot.ScreenshotMethod("FareBreackup","<b><i>Screenshot for Fare Breackup</i></b>");
		
		QaRobot.ClickOnElement("FareBreackupClose1");
		QaExtentReport.test.log(Status.INFO, "<b><i>Click on FareBreackupClose</i></b>");
		Thread.sleep(3000);
		
		QaRobot.ClickOnElement("CheckBox1");
		QaExtentReport.test.log(Status.INFO, "<b><i>Click on CheckBox</i></b>");
		
		QaRobot.ClickOnElement("TermCondition");
		QaExtentReport.test.log(Status.INFO, "<b><i>Click on TermCondition</i></b>");
		
		QaRobot.ScreenshotMethod("FinalBook","<b><i>Screenshot for Final Book</i></b>");
		
		String url2 = QaBrowser.driver.getCurrentUrl();
		String[] uid = url2.split("=");
		QaExtentReport.test.log(Status.INFO, "<b><i>Session id is </i></b>" + uid[1]);
		
		QaRobot.ClickOnElement("FinalBook1");
		QaExtentReport.test.log(Status.INFO, "<b><i>Click on FinalBook</i></b>");
		
//		Alert alt = QaBrowser.driver.switchTo().alert();
//		alt.accept();
		
		WebElement DropDown = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_ddlFop1']"));
		Select s = new Select(DropDown);
		s.selectByVisibleText("Bill To Company");
		
		QaRobot.ClickOnElement("Ok");
		QaExtentReport.test.log(Status.INFO, "<b><i>Click on Ok Button</i></b>");
		
		QaRobot.ScreenshotMethod("Proceed","<b><i>Screenshot for Procced Page</i></b>");
		
		QaRobot.ClickOnElement("Proceed");
		QaExtentReport.test.log(Status.INFO,"<b><i>Click on Proceed</i></b>");
		
		WebElement getT = QaBrowser.driver.findElement(By.xpath("(//html//body//div//span)[70]"));
		String getTxt = getT.getText();
		QaExtentReport.test.log(Status.INFO, "<b><i>Booking Id Is </i></b>"+getTxt);
		
		QaRobot.ScreenshotMethod("FinalResult","<b><i>Screenshot for Search Page</i></b>");
	}
	
	public static void checkout1() throws Exception
	{
		QaRobot.ClickOnElement("TermCondition");
		QaExtentReport.test.log(Status.INFO, "<b><i>Click on TermCondition</i></b>");
		
		QaRobot.ScreenshotMethod("FinalBook","<b><i>Screenshot for Final Book</i></b>");
		
		String url2 = QaBrowser.driver.getCurrentUrl();
		String[] uid = url2.split("=");
		QaExtentReport.test.log(Status.INFO, "<b><i>Session id is </i></b>" + uid[1]);
		
		QaRobot.ClickOnElement("FinalBook");
		QaExtentReport.test.log(Status.INFO, "<b><i>Click on FinalBook</i></b>");
		
//		Alert alt = QaBrowser.driver.switchTo().alert();
//		alt.accept();
		
		WebElement DropDown = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_ddlFop1']"));
		Select s = new Select(DropDown);
		s.selectByVisibleText("Bill To Company");
		
		QaRobot.ClickOnElement("Ok");
		QaExtentReport.test.log(Status.INFO, "<b><i>Click on Ok Button</i></b>");
		
		QaRobot.ScreenshotMethod("Proceed","<b><i>Screenshot for Procced Page</i></b>");
		
		QaRobot.ClickOnElement("Proceed");
		QaExtentReport.test.log(Status.INFO,"<b><i>Click on Proceed</i></b>");
		
		WebElement getT = QaBrowser.driver.findElement(By.xpath("(//html//body//div//span)[70]"));
		String getTxt = getT.getText();
		QaExtentReport.test.log(Status.INFO, "<b><i>Booking Id Is </i></b>"+getTxt);
		
		QaRobot.ScreenshotMethod("FinalResult","<b><i>Screenshot for Search Page</i></b>");
	}
}

