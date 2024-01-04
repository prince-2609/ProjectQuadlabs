	package SBT_Corporate;

import java.util.Set;

import org.openqa.selenium.Alert;
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
public class PreApprovalQueueFlight
{
	@DataProvider
	public Object[][] getexceldata() throws Exception 
	{
		return QaDataProvider.getTestdata("PreApprovalFlight", "PreApprovalQueue");
	}
	
	public static void selectDependentPax(String adult, String child, String infant) throws InterruptedException 
	{
		int adt = Integer.parseInt(adult);
		int chd = Integer.parseInt(child);
		int inf = Integer.parseInt(infant);
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
		for (int i = 1; i <= inf; i++)
		{
			QaBrowser.driver.findElement(By.xpath("//input[@id='rptPaxDetails_ctl03_rptDetails_ctl0" + i + "_chk']")).click();
			Thread.sleep(3000);
		}
	}
	
	public static void selectDependentPriority(String adult, String child, String infant) throws InterruptedException 
	{
		int adt = Integer.parseInt(adult);
		int chd = Integer.parseInt(child);
		int inf = Integer.parseInt(infant);
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
		for (int i = 1; i <= inf; i++) 
		{
			WebElement webelement = QaBrowser.driver.findElement(By.xpath("//select[@id='rptSelectionList_ctl03_rptSelection_ctl0" + i + "_ddlPriority']"));
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
	
	public static void GuestAdultCheckout(String adult,String AdultDate, String AdultMonth, String AdultYear, String AdultPassport,String AdultNationality,
			String AdultExpiryDate, String AdultExpiryMonth, String AdultExpiryYear, String AdultPassportContry,String isd,String PhoneNumber) throws Exception 
	{
		int adt = Integer.parseInt(adult);
		for (int i = 1; i <= adt; i++) 
		{
			// Fill Day
			String adultdayElement = "(//select[@id='ctl00_contentMain_txt_birthDateAdt_ddlDay'])[" + i + "]";
			String[] adultday = AdultDate.split(",");
			QaRobot.selectValueByLocator(adultdayElement, adultday[i - 1],"<b><i>Selected Day For Adult</i></b>");
						
			// Fill Month
			String adultmonthElement = "(//select[@id='ctl00_contentMain_txt_birthDateAdt_ddlMonth'])[" + i + "]";
			String[] adultmm = AdultMonth.split(",");
			QaRobot.selectTextByLocator(adultmonthElement, adultmm[i - 1], "<b><i>Selected Month For Adult</i></b>");
						
			// Fill Year
			String adultyearElement = "(//select[@id='ctl00_contentMain_txt_birthDateAdt_ddlYear'])[" + i + "]";
			String[] adulty = AdultYear.split(",");
			QaRobot.selectTextByLocator(adultyearElement, adulty[i - 1], "<b><i>Selected Year For Adult</i></b>");

			// Fill Passport
			String adultpassportElement = "//input[@id='txt_passportAdt" + i + "']";
			String[] adultpass = AdultPassport.split(",");
			QaRobot.PassValueByLocator(adultpassportElement, adultpass[i - 1],"<b><i>Entered Passport Number For Adult</i></b>" + i + "");

			// fill nationality
			String adultnationalityElement = "(//select[@id='ctl00_contentMain_ddl_nationalityAdt'])[" + i + "]";
			String[] adultnat = AdultNationality.split(",");
			QaRobot.selectTextByLocator(adultnationalityElement, adultnat[i - 1], "<b><i>Selected Nationality For Adult</i></b>");

			// FIll passport Day
			String adultedayElement = "(//select[@id='ctl00_contentMain_txt_ex_dateAdt_ddlDay'])[" + i + "]";
			String[] adulteday = AdultExpiryDate.split(",");
			QaRobot.selectValueByLocator(adultedayElement, adulteday[i - 1],"<b><i>Selected Expiry Day For Adult</i></b>");
			
			// Fill Month
			String adultemonthElement = "(//select[@id='ctl00_contentMain_txt_ex_dateAdt_ddlMonth'])[" + i + "]";
			String[] adultemm = AdultExpiryMonth.split(",");
			QaRobot.selectTextByLocator(adultemonthElement, adultemm[i - 1], "<b><i>Selected Expiry Month For Adult</i></b>");
			
			// Fill Year
			String adulteyearElement = "(//select[@id='ctl00_contentMain_txt_ex_dateAdt_ddlYear'])[" + i + "]";
			String[] adultey = AdultExpiryYear.split(",");
			QaRobot.selectTextByLocator(adulteyearElement, adultey[i - 1], "<b><i>Selected Expiry Year For Adult</i></b>");

			// fill Passport issuing country
			String adultpasscountryElement = "(//select[@id='ctl00_contentMain_ddl_passCountryAdt'])[" + i + "]";
			String[] adultpc = AdultPassportContry.split(",");
			QaRobot.selectTextByLocator(adultpasscountryElement, adultpc[i - 1], "<b><i>Selected Passport Country For Adult</i></b>");

		}
		// fill Phone number and isd
		String adultisdElement = "//input[@id='ctl00_contentMain_txt_isdAdt']";
		QaRobot.PassValueByLocator(adultisdElement, isd, "<b><i>Entered isd Number For Adult</i></b>");

		String adultphonenumberElement = "//input[@id='ctl00_contentMain_txt_pax_phoneAdt']";
		QaRobot.PassValueByLocator(adultphonenumberElement, PhoneNumber, "<b><i>Entered phone Number For Adult</i></b>");
	}
	
	public static void GuestChildCheckout(String child,String ChildDate, String ChildMonth, String ChildYear, String ChildPassport,String ChildNationality,
			String ChildExpiryDate, String ChildExpiryMonth, String ChildExpiryYear, String ChildPassportContry) throws Exception 
	{
		int chd = Integer.parseInt(child);
		for (int i = 1; i <= chd; i++) 
		{
			// Fill Day
			String childdayElement = "(//select[@id='ctl00_contentMain_txt_birthDateChd_ddlDay'])[" + i + "]";
			String[] childday = ChildDate.split(",");
			QaRobot.selectValueByLocator(childdayElement, childday[i - 1],"<b><i>Selected Day For Child</i></b>");
						
			// Fill Month
			String childmonthElement = "(//select[@id='ctl00_contentMain_txt_birthDateChd_ddlMonth'])[" + i + "]";
			String[] childmm = ChildMonth.split(",");
			QaRobot.selectTextByLocator(childmonthElement, childmm[i - 1], "<b><i>Selected Month For Child</i></b>");
						
			// Fill Year
			String childyearElement = "(//select[@id='ctl00_contentMain_txt_birthDateChd_ddlYear'])[" + i + "]";
			String[] childy = ChildYear.split(",");
			QaRobot.selectTextByLocator(childyearElement,childy[i - 1], "<b><i>Selected Year For Child</i></b>");

			// Fill Passport
			String childpassportElement = "//input[@id='txt_passportChd" + i + "']";
			String[] childpass = ChildPassport.split(",");
			QaRobot.PassValueByLocator(childpassportElement, childpass[i - 1],"<b><i>Entered Passport Number For Child</i></b>" + i + "");

			// fill nationality
			String childnationalityElement = "(//select[@id='ctl00_contentMain_ddl_nationalityChd'])[" + i + "]";
			String[] childnat = ChildNationality.split(",");
			QaRobot.selectTextByLocator(childnationalityElement, childnat[i - 1], "<b><i>Selected Nationality For Child</i></b>");

			// FIll passport Day
			String childedayElement = "(//select[@id='ctl00_contentMain_txt_ex_dateChd_ddlDay'])[" + i + "]";
			String[] childeday = ChildExpiryDate.split(",");
			QaRobot.selectValueByLocator(childedayElement, childeday[i - 1],"<b><i>Selected Expiry Day For Child</i></b>");
			
			// Fill Month
			String childemonthElement = "(//select[@id='ctl00_contentMain_txt_ex_dateChd_ddlMonth'])[" + i + "]";
			String[] childemm = ChildExpiryMonth.split(",");
			QaRobot.selectTextByLocator(childemonthElement, childemm[i - 1], "<b><i>Selected Expiry Month For Child</i></b>");
			
			// Fill Year
			String childeyearElement = "(//select[@id='ctl00_contentMain_txt_ex_dateChd_ddlYear'])[" + i + "]";
			String[] childey = ChildExpiryYear.split(",");
			QaRobot.selectTextByLocator(childeyearElement, childey[i - 1], "<b><i>Selected Expiry Year For Child</i></b>");

			// fill Passport issuing country
			String childpasscountryElement = "(//select[@id='ctl00_contentMain_ddl_passCountryChd'])[" + i + "]";
			String[] childpc = ChildPassportContry.split(",");
			QaRobot.selectTextByLocator(childpasscountryElement, childpc[i - 1], "<b><i>Selected Passport Country For Child</i></b>");

		}
	}
	
	public static void GuestInfantCheckout(String infant,String InfantDate, String InfantMonth, String InfantYear,String TravellingWith, String InfantPassport,String InfantNationality,
			String InfantExpiryDate, String InfantExpiryMonth, String InfantExpiryYear, String InfantPassportContry) throws Exception 
	{
		int inf = Integer.parseInt(infant);
		for (int i = 1; i <= inf; i++) 
		{
			// Fill Day
			String infantdayElement = "(//select[@id='ctl00_contentMain_txt_birthDateInf_ddlDay'])[" + i + "]";
			String[] infantday = InfantDate.split(",");
			QaRobot.selectValueByLocator(infantdayElement, infantday[i - 1],"<b><i>Selected Day For Infant</i></b>");
						
			// Fill Month
			String infantmonthElement = "(//select[@id='ctl00_contentMain_txt_birthDateInf_ddlMonth'])[" + i + "]";
			String[] infantmm = InfantMonth.split(",");
			QaRobot.selectTextByLocator(infantmonthElement, infantmm[i - 1], "<b><i>Selected Month For Infant</i></b>");
						
			// Fill Year
			String infantyearElement = "(//select[@id='ctl00_contentMain_txt_birthDateInf_ddlYear'])[" + i + "]";
			String[] infanty = InfantYear.split(",");
			QaRobot.selectTextByLocator(infantyearElement, infanty[i - 1], "<b><i>Selected Year For Infant</i></b>");
			
			String infanttravellingElement = "(//select[@id='ctl00_contentMain_ddl_travell_with'])[" + i + "]";
			String[] infanttravel = TravellingWith.split(",");
			QaRobot.selectTextByLocator(infanttravellingElement, infanttravel[i - 1],"<b><i>Selected Travelling with For Infant</i></b>");

			// Fill Passport
			String infantpassportElement = "//input[@id='txt_passportInf" + i + "']";
			String[] infantpass = InfantPassport.split(",");
			QaRobot.PassValueByLocator(infantpassportElement, infantpass[i - 1],"<b><i>Entered Passport Number For Infant</i></b>" + i + "");

			// fill nationality
			String infantnationalityElement = "(//select[@id='ctl00_contentMain_ddl_nationalityInf'])[" + i + "]";
			String[] infantnat = InfantNationality.split(",");
			QaRobot.selectTextByLocator(infantnationalityElement, infantnat[i - 1], "<b><i>Selected Nationality For Infant</i></b>");

			// FIll passport Day
			String infantedayElement = "(//select[@id='ctl00_contentMain_txt_ex_dateInf_ddlDay'])[" + i + "]";
			String[] infanteday = InfantExpiryDate.split(",");
			QaRobot.selectValueByLocator(infantedayElement, infanteday[i - 1],"<b><i>Selected Expiry Day For Infant</i></b>");
			
			// Fill Month
			String infantemonthElement = "(//select[@id='ctl00_contentMain_txt_ex_dateInf_ddlMonth'])[" + i + "]";
			String[] infantemm = InfantExpiryMonth.split(",");
			QaRobot.selectTextByLocator(infantemonthElement, infantemm[i - 1], "<b><i>Selected Expiry Month For Infant</i></b>");
			
			// Fill Year
			String infanteyearElement = "(//select[@id='ctl00_contentMain_txt_ex_dateInf_ddlYear'])[" + i + "]";
			String[] infantey = InfantExpiryYear.split(",");
			QaRobot.selectTextByLocator(infanteyearElement, infantey[i - 1], "<b><i>Selected Expiry Year For Infant</i></b>");

			// fill Passport issuing country
			String infantpasscountryElement = "(//select[@id='ctl00_contentMain_ddl_passCountryInf'])[" + i + "]";
			String[] infantpc = InfantPassportContry.split(",");
			QaRobot.selectTextByLocator(infantpasscountryElement, infantpc[i - 1],"<b><i>Selected Passport Country For Infant</i></b>");
		}
	}
	
	@Test(dataProvider = "getexceldata")
	public static void Profiling1(String Source,String URL, String Comapnycode,String Username,String Password, String Enquiryid,
			String BookingType,String adult,String child,String infant,String AdultDate, String AdultMonth, String AdultYear, String AdultPassport,String AdultNationality,
			String AdultExpiryDate, String AdultExpiryMonth, String AdultExpiryYear, String AdultPassportContry,String isd,String PhoneNumber,
			String ChildDate, String ChildMonth, String ChildYear, String ChildPassport,String ChildNationality,String ChildExpiryDate, 
			String ChildExpiryMonth, String ChildExpiryYear, String ChildPassportContry,String InfantDate, String InfantMonth, String InfantYear,String TravellingWith, String InfantPassport,String InfantNationality,
			String InfantExpiryDate, String InfantExpiryMonth, String InfantExpiryYear, String InfantPassportContry) throws Exception 
	{
		TestBase.Companycode(Source,URL); 
		QaRobot.impliwait(30);
		
		QaExtentReport.test = QaExtentReport.report.createTest("Test on Pre Approval Queue For Flight");
	
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
		
		QaRobot.ScreenshotMethod("Book","<b><i>Screenshot for Book Button</i></b>");
		
		QaRobot.ClickOnElement("ProceedToCheckout");
		QaExtentReport.test.log(Status.INFO, "<b><i>Click on ProceedToCheckout</i></b>");
		
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
			
			PreApprovalQueueFlight.selectDependentPax(adult,child,infant);
			Thread.sleep(3000);
			
			QaRobot.ClickOnElement("dept_AddToList");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on add to list Button</i></b>");
			Thread.sleep(3000);
			
			PreApprovalQueueFlight.selectDependentPriority(adult, child, infant);
			
			QaRobot.ClickOnElement("dept_AssociateButton");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Associate Button</i></b>");
			Thread.sleep(3000);
			
			QaBrowser.driver.switchTo().window(ParentWindow);
			
			QaRobot.ClickOnElement("MoreDetails");
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on MoreDetails</i></b>");
			Thread.sleep(3000);
			
			QaRobot.ScreenshotMethod("MoreDetails","<b><i>Screenshot for More Details</i></b>");
			
			QaRobot.ClickOnElement("MoreDetailsClose");
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on MoreDetailsClose</i></b>");
			
			QaRobot.ClickOnElement("FareBreackup1");
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on FareBreackup</i></b>");
			Thread.sleep(3000);
			
			QaRobot.ScreenshotMethod("FareBreackup","<b><i>Screenshot for Fare Breackup</i></b>");
			
			QaRobot.ClickOnElement("FareBreackupClose");
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on FareBreackupClose</i></b>");
			
			if(infant.equalsIgnoreCase("0"))
			{
				QaRobot.ClickOnElement("CheckBox1");
				QaExtentReport.test.log(Status.INFO, "<b><i>Click on CheckBox</i></b>");
				
				QaRobot.ClickOnElement("TermCondition");
				QaExtentReport.test.log(Status.INFO, "<b><i>Click on TermCondition</i></b>");
				
				QaRobot.ScreenshotMethod("FinalBook","<b><i>Screenshot for Final Book</i></b>");
				
				String url1 = QaBrowser.driver.getCurrentUrl();
				String[] uid = url1.split("=");
				QaExtentReport.test.log(Status.INFO, "<b><i>Session id is </i></b>" + uid[1]);
				
				QaRobot.ClickOnElement("FinalBook");
				QaExtentReport.test.log(Status.INFO, "<b><i>Click on FinalBook</i></b>");
				
				Alert alt = QaBrowser.driver.switchTo().alert();
				alt.accept();
				
				WebElement DropDown3 = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_ddlFop1']"));
				
				Select s3 = new Select(DropDown3);
				s3.selectByVisibleText("Bill To Company");
				
				QaRobot.ClickOnElement("Ok");
				QaExtentReport.test.log(Status.INFO, "<b><i>Click on Ok Button</i></b>");
				
				QaRobot.ScreenshotMethod("Proceed","<b><i>Screenshot for Procced Page</i></b>");
				
				QaRobot.ClickOnElement("Proceed");
				QaExtentReport.test.log(Status.INFO,"<b><i>Click on Proceed</i></b>");
				
				WebElement getT2 = QaBrowser.driver.findElement(By.xpath("(//html//body//div//span)[70]"));
				String getTxt2 = getT2.getText();
				QaExtentReport.test.log(Status.INFO, "<b><i>Booking Id Is </i></b>"+getTxt2);
				
				QaRobot.ScreenshotMethod("FinalResult","<b><i>Screenshot for Search Page</i></b>");
			}
			
			else if(infant.equalsIgnoreCase("1"))
			{
				WebElement DropDown1 = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_ddl_travell_with']"));
				Select s1 = new Select(DropDown1);
				s1.selectByVisibleText("Adult1");
				
				QaRobot.ClickOnElement("CheckBox1");
				QaExtentReport.test.log(Status.INFO, "<b><i>Click on CheckBox</i></b>");
				
				QaRobot.ClickOnElement("TermCondition");
				QaExtentReport.test.log(Status.INFO, "<b><i>Click on TermCondition</i></b>");
				
				QaRobot.ScreenshotMethod("FinalBook","<b><i>Screenshot for Final Book</i></b>");
				
				String url1 = QaBrowser.driver.getCurrentUrl();
				String[] uid = url1.split("=");
				QaExtentReport.test.log(Status.INFO, "<b><i>Session id is </i></b>" + uid[1]);
				
				QaRobot.ClickOnElement("FinalBook");
				QaExtentReport.test.log(Status.INFO, "<b><i>Click on FinalBook</i></b>");
				
				Alert alt = QaBrowser.driver.switchTo().alert();
				alt.accept();
				
				WebElement DropDown3 = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_ddlFop1']"));
				
				Select s3 = new Select(DropDown3);
				s3.selectByVisibleText("Bill To Company");
				
				QaRobot.ClickOnElement("Ok");
				QaExtentReport.test.log(Status.INFO, "<b><i>Click on Ok Button</i></b>");
				
				QaRobot.ScreenshotMethod("Proceed","<b><i>Screenshot for Procced Page</i></b>");
				
				QaRobot.ClickOnElement("Proceed");
				QaExtentReport.test.log(Status.INFO,"<b><i>Click on Proceed</i></b>");
				
				WebElement getT2 = QaBrowser.driver.findElement(By.xpath("(//html//body//div//span)[70]"));
				String getTxt2 = getT2.getText();
				QaExtentReport.test.log(Status.INFO, "<b><i>Booking Id Is </i></b>"+getTxt2);
				
				QaRobot.ScreenshotMethod("FinalResult","<b><i>Screenshot for Search Page</i></b>");
			}
			
			else if(infant.equalsIgnoreCase("2")) 
			{
				WebElement DropDown2 = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_ddl_travell_with']"));
				Select s2 = new Select(DropDown2);
				s2.selectByVisibleText("Adult1");
				
				QaRobot.ClickOnElement("CheckBox1");
				QaExtentReport.test.log(Status.INFO, "<b><i>Click on CheckBox</i></b>");
				
				QaRobot.ClickOnElement("TermCondition");
				QaExtentReport.test.log(Status.INFO, "<b><i>Click on TermCondition</i></b>");
				
				QaRobot.ScreenshotMethod("FinalBook","<b><i>Screenshot for Final Book</i></b>");
				
				String url = QaBrowser.driver.getCurrentUrl();
				String[] uid = url.split("=");
				QaExtentReport.test.log(Status.INFO, "<b><i>Session id is </i></b>" + uid[1]);
				
				QaRobot.ClickOnElement("FinalBook");
				QaExtentReport.test.log(Status.INFO, "<b><i>Click on FinalBook</i></b>");
				
				Alert alt = QaBrowser.driver.switchTo().alert();
				alt.accept();
				
				WebElement DropDown = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_ddlFop1']"));
				Select s = new Select(DropDown);
				s.selectByVisibleText("Bill To Company");
				
				QaRobot.ClickOnElement("Ok");
				QaExtentReport.test.log(Status.INFO, "<b><i>Click on Ok Button</i></b>");
				
				QaRobot.ScreenshotMethod("Proceed","<b><i>Screenshot for Procced Page</i></b>");
			
				QaRobot.ClickOnElement("Proceed");
				QaExtentReport.test.log(Status.INFO,"<b><i>Click on Proceed</i></b>");
				
				WebElement getT1 = QaBrowser.driver.findElement(By.xpath("(//html//body//div//span)[70]"));
				String getTxt1 = getT1.getText();
				QaExtentReport.test.log(Status.INFO, "<b><i>Booking Id Is </i></b>"+getTxt1);
				
				QaRobot.ScreenshotMethod("FinalResult","<b><i>Screenshot for Search Page</i></b>");
				}	
		}
		
		else if(BookingType.equalsIgnoreCase("Guest"))
		{
			PreApprovalQueueFlight.GuestAdultCheckout(adult, AdultDate, AdultMonth, AdultYear, AdultPassport, AdultNationality, AdultExpiryDate,
					AdultExpiryMonth, AdultExpiryYear, AdultPassportContry, isd, PhoneNumber);
			
			PreApprovalQueueFlight.GuestChildCheckout(child, ChildDate, ChildMonth, ChildYear, ChildPassport, ChildNationality, ChildExpiryDate,
					ChildExpiryMonth, ChildExpiryYear, ChildPassportContry);
			
			PreApprovalQueueFlight.GuestInfantCheckout(infant, InfantDate, InfantMonth, InfantYear, TravellingWith, InfantPassport,
					InfantNationality, InfantExpiryDate, InfantExpiryMonth, InfantExpiryYear, InfantPassportContry);
			
			WebElement WebElement = QaBrowser.driver.findElement(By.xpath("//a[@class='btn_smallyellow fancybox']"));
			JavascriptExecutor js = (JavascriptExecutor) QaBrowser.driver;
			js.executeScript("arguments[0].click()", WebElement);
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on MoreDetails</i></b>");
			Thread.sleep(3000);
//			QaRobot.ClickOnElement("MoreDetails");
//			QaExtentReport.test.log(Status.INFO, "<b><i>Click on MoreDetails</i></b>");
//			Thread.sleep(3000);
			
			QaRobot.ScreenshotMethod("MoreDetails","<b><i>Screenshot for More Details</i></b>");
		
			WebElement WebElement1 = QaBrowser.driver.findElement(By.xpath("//a[@title='Close']"));
			JavascriptExecutor js1 = (JavascriptExecutor) QaBrowser.driver;
			js1.executeScript("arguments[0].click()", WebElement1);
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on MoreDetailsClose</i></b>");
			
//			QaRobot.ClickOnElement("MoreDetailsClose");
//			QaExtentReport.test.log(Status.INFO, "<b><i>Click on MoreDetailsClose</i></b>");
			
			WebElement WebElement2 = QaBrowser.driver.findElement(By.xpath("(//a[@class='btn_smallyellow'])[2]"));
			JavascriptExecutor js2 = (JavascriptExecutor) QaBrowser.driver;
			js2.executeScript("arguments[0].click()", WebElement2);
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on FareBreackup</i></b>");
			Thread.sleep(3000);
//			QaRobot.ClickOnElement("FareBreackup");
//			QaExtentReport.test.log(Status.INFO, "<b><i>Click on FareBreackup</i></b>");
//			Thread.sleep(3000);
			
			QaRobot.ScreenshotMethod("FareBreackup","<b><i>Screenshot for Fare Breackup</i></b>");
			
			WebElement WebElement3 = QaBrowser.driver.findElement(By.xpath("(//button[@type='button'])[10]"));
			JavascriptExecutor js3 = (JavascriptExecutor) QaBrowser.driver;
			js3.executeScript("arguments[0].click()", WebElement3);
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on FareBreackupClose</i></b>");
//			QaRobot.ClickOnElement("FareBreackupClose");
//			QaExtentReport.test.log(Status.INFO, "<b><i>Click on FareBreackupClose</i></b>");
			
			QaRobot.ClickOnElement("TermCondition");
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on TermCondition</i></b>");
			
			QaRobot.ScreenshotMethod("FinalBook","<b><i>Screenshot for Final Book</i></b>");
			
			String url2 = QaBrowser.driver.getCurrentUrl();
			String[] uid = url2.split("=");
			QaExtentReport.test.log(Status.INFO, "<b><i>Session id is </i></b>" + uid[1]);
			
			QaRobot.ClickOnElement("FinalBook");
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on FinalBook</i></b>");
			
			Alert alt = QaBrowser.driver.switchTo().alert();
			alt.accept();
			
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
		
		else 
		{
			QaRobot.ClickOnElement("MoreDetails");
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on MoreDetails</i></b>");
			Thread.sleep(3000);
			
			QaRobot.ScreenshotMethod("MoreDetails","<b><i>Screenshot for More Details</i></b>");
			
			QaRobot.ClickOnElement("MoreDetailsClose");
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on MoreDetailsClose</i></b>");
			
			QaRobot.ClickOnElement("FareBreackup1");
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on FareBreackup</i></b>");
			Thread.sleep(3000);
			
			QaRobot.ScreenshotMethod("FareBreackup","<b><i>Screenshot for Fare Breackup</i></b>");
			
			QaRobot.ClickOnElement("FareBreackupClose");
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on FareBreackupClose</i></b>");
			
			QaRobot.ClickOnElement("CheckBox1");
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on CheckBox</i></b>");
			
			QaRobot.ClickOnElement("TermCondition");
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on TermCondition</i></b>");
			
			QaRobot.ScreenshotMethod("FinalBook","<b><i>Screenshot for Final Book</i></b>");
			
			String url2 = QaBrowser.driver.getCurrentUrl();
			String[] uid = url2.split("=");
			QaExtentReport.test.log(Status.INFO, "<b><i>Session id is </i></b>" + uid[1]);
			
			QaRobot.ClickOnElement("FinalBook");
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on FinalBook</i></b>");
			
			Alert alt = QaBrowser.driver.switchTo().alert();
			alt.accept();
			
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

	@AfterMethod
	public static void afterMetod() 
	{
		QaExtentReport.test.getExtent().flush();
//		Desktop.getDesktop().browse(new File ("report.html").toURI());
//		QaBrowser.driver.close();
	}
}
