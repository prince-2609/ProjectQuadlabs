package CarporateSBT;

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
public class BookAndQuoteFlight
{
	@DataProvider
	public Object[][] getexceldata() throws Exception 
	{
		return QaDataProvider.getTestdata("PreApprovalFlight", "BookAndQuote");
	}
	
	@Test(dataProvider = "getexceldata")
	public static void Profiling1(String TestCaseId,String Employee,String TravelArranger,String Travlername,String Source,String URL, String Comapnycode,String Username,String Password, String RefNo,
			String BookingType,String adult,String child,String infant,String CreatedBy) throws Exception 
	{
		TestBase.Companycode(Source,URL); 
		QaRobot.impliwait(30);
		
		QaExtentReport.test = QaExtentReport.report.createTest(TestCaseId);
		
		QaRobot.PassValue("User_name",Username);
		QaExtentReport.test.log(Status.INFO,"<b><i>Write Username</i></b>");
		
		QaRobot.PassValue("Password",Password);
		QaExtentReport.test.log(Status.INFO, "<b><i>Write Password</i></b>");
		
		QaRobot.ClickOnElement("Submit");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on submit</i></b>");
		
		QaExtentReport.extentScreenshot("Corporate Login Page");
		QaRobot.ScreenshotMethod("CorporateLogin","<b><i>Screenshot for Corporate Login Page</i></b>");
		
		QaExtentReport.test.log(Status.INFO, "<b><i>Employee Name is  </i></b>"+Employee);
		QaExtentReport.test.log(Status.INFO, "<b><i>Travel Arranger Name is  </i></b>"+Travlername);
		
		QaRobot.mouseHover("//a[@id='HeaderTop_aBookingMenu']", "//span[@id='HeaderTop_lblBookingQueue']");
		
		QaExtentReport.extentScreenshot("Corporate Dashboard Page");
		QaRobot.ScreenshotMethod("CorporateDashboard","<b><i>Screenshot for Corporate Dashboard Page</i></b>");
		
		QaRobot.PassValue("EnterRefNo", RefNo);
		QaExtentReport.test.log(Status.INFO, "<b><i>Write Ref No Is</i></b>"+RefNo);
		
		QaExtentReport.extentScreenshot("Enquiry Id");
		QaRobot.ScreenshotMethod("RefNo","<b><i>Screenshot for Enquiry Id</i></b>");
		
		QaRobot.ClickOnElement("SearchButton");
		QaExtentReport.test.log(Status.INFO, "<b><i>Click on Search Button</i></b>");
		
		QaExtentReport.extentScreenshot("Book Button");
		QaRobot.ClickOnElement("BookButton");
		QaExtentReport.test.log(Status.INFO,  "<b><i>Click on Book Button</i></b>");
		
		QaRobot.ScreenshotMethod("BookButton","<b><i>Screenshot for Book Button</i></b>");
		
		if(BookingType.equalsIgnoreCase("Dependent"))
		{	
			QaRobot.ClickOnElement("MoreDetails");
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on MoreDetails</i></b>");
			Thread.sleep(3000);
			
			QaExtentReport.extentScreenshot("Book Button");
			QaRobot.ScreenshotMethod("MoreDetails","<b><i>Screenshot for More Details</i></b>");
			
			QaRobot.ClickOnElement("MoreDetailsClose");
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on MoreDetailsClose</i></b>");
			
			QaRobot.ClickOnElement("FareBreackup");
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on FareBreackup</i></b>");
			Thread.sleep(3000);
			
			QaExtentReport.extentScreenshot("FareBreackup");
			QaRobot.ScreenshotMethod("FareBreackup","<b><i>Screenshot for Fare Breackup</i></b>");
			
			QaRobot.ClickOnElement("FareBreackupCloseMY");
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on FareBreackupClose</i></b>");
			
			if(infant.equalsIgnoreCase("0"))
			{		
				QaRobot.ClickOnElement("CheckBox");
				QaExtentReport.test.log(Status.INFO, "<b><i>Click on CheckBox</i></b>");
				
				QaRobot.ClickOnElement("TermCondition");
				QaExtentReport.test.log(Status.INFO, "<b><i>Click on TermCondition</i></b>");
				
				QaRobot.ScreenshotMethod("FinalBook","<b><i>Screenshot for Final Book</i></b>");
				
				String url1 = QaBrowser.driver.getCurrentUrl();
				String[] uid = url1.split("=");
				QaExtentReport.test.log(Status.INFO, "<b><i>Session id is </i></b>" + uid[1]);
				
				QaExtentReport.extentScreenshot("FinalBook");
				QaRobot.ClickOnElement("FinalBook");
				QaExtentReport.test.log(Status.INFO, "<b><i>Click on FinalBook</i></b>");
				
				Alert alt = QaBrowser.driver.switchTo().alert();
				alt.accept();
				
				WebElement DropDown3 = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_ddlFop1']"));
				Select s3 = new Select(DropDown3);
				s3.selectByVisibleText("Bill To Company");
				
				QaRobot.ClickOnElement("Ok");
				QaExtentReport.test.log(Status.INFO, "<b><i>Click on Ok Button</i></b>");
				
				QaExtentReport.extentScreenshot("Proceed");
				QaRobot.ScreenshotMethod("Proceed","<b><i>Screenshot for Procced Page</i></b>");
				
				QaRobot.ClickOnElement("Proceed");
				QaExtentReport.test.log(Status.INFO,"<b><i>Click on Proceed</i></b>");
				
				WebElement getT2 = QaBrowser.driver.findElement(By.xpath("(//html//body//div//span)[70]"));
				String getTxt2 = getT2.getText();
				QaExtentReport.test.log(Status.INFO, "<b><i>Booking Id Is </i></b>"+getTxt2);
				
				QaExtentReport.extentScreenshot("FinalResult");
				QaRobot.ScreenshotMethod("FinalResult","<b><i>Screenshot for Search Page</i></b>");
			}
			
			else if(infant.equalsIgnoreCase("1"))
			{
				WebElement DropDown1 = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_ddl_travell_with']"));
				Select s1 = new Select(DropDown1);
				s1.selectByVisibleText("Adult1");
				
				QaRobot.ClickOnElement("CheckBox");
				QaExtentReport.test.log(Status.INFO, "<b><i>Click on CheckBox</i></b>");
				
				QaRobot.ClickOnElement("TermCondition");
				QaExtentReport.test.log(Status.INFO, "<b><i>Click on TermCondition</i></b>");
				
				QaRobot.ScreenshotMethod("FinalBook","<b><i>Screenshot for Final Book</i></b>");
			
				String url1 = QaBrowser.driver.getCurrentUrl();
				String[] uid = url1.split("=");
				QaExtentReport.test.log(Status.INFO, "<b><i>Session id is </i></b>" + uid[1]);
				
				QaExtentReport.extentScreenshot("FinalBook");
				QaRobot.ClickOnElement("FinalBook");
				QaExtentReport.test.log(Status.INFO, "<b><i>Click on FinalBook</i></b>");
				
				Alert alt = QaBrowser.driver.switchTo().alert();
				alt.accept();
				
				WebElement DropDown3 = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_ddlFop1']"));
				
				Select s3 = new Select(DropDown3);
				s3.selectByVisibleText("Bill To Company");
				
				QaRobot.ClickOnElement("Ok");
				QaExtentReport.test.log(Status.INFO, "<b><i>Click on Ok Button</i></b>");
				
				QaExtentReport.extentScreenshot("Proceed");
				QaRobot.ScreenshotMethod("Proceed","<b><i>Screenshot for Procced Page</i></b>");
				
				QaRobot.ClickOnElement("Proceed");
				QaExtentReport.test.log(Status.INFO,"<b><i>Click on Proceed</i></b>");
				
				WebElement getT2 = QaBrowser.driver.findElement(By.xpath("(//html//body//div//span)[70]"));
				String getTxt2 = getT2.getText();
				QaExtentReport.test.log(Status.INFO, "<b><i>Booking Id Is </i></b>"+getTxt2);
				
				QaExtentReport.extentScreenshot("FinalResult");
				QaRobot.ScreenshotMethod("FinalResult","<b><i>Screenshot for Search Page</i></b>");
			}
			
			else if(infant.equalsIgnoreCase("2")) 
			{
				WebElement DropDown2 = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_ddl_travell_with']"));
				Select s2 = new Select(DropDown2);
				s2.selectByVisibleText("Adult1");
				
				QaRobot.ClickOnElement("CheckBox");
				QaExtentReport.test.log(Status.INFO, "<b><i>Click on CheckBox</i></b>");
				
				QaRobot.ClickOnElement("TermCondition");
				QaExtentReport.test.log(Status.INFO, "<b><i>Click on TermCondition</i></b>");
				
				QaRobot.ScreenshotMethod("FinalBook","<b><i>Screenshot for Final Book</i></b>");
				
				String url = QaBrowser.driver.getCurrentUrl();
				String[] uid = url.split("=");
				QaExtentReport.test.log(Status.INFO, "<b><i>Session id is </i></b>" + uid[1]);
				
				QaExtentReport.extentScreenshot("FinalBook");
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
				
				QaExtentReport.extentScreenshot("Proceed");
				QaRobot.ClickOnElement("Proceed");
				QaExtentReport.test.log(Status.INFO,"<b><i>Click on Proceed</i></b>");
				
				WebElement getT1 = QaBrowser.driver.findElement(By.xpath("(//html//body//div//span)[70]"));
				String getTxt1 = getT1.getText();
				QaExtentReport.test.log(Status.INFO, "<b><i>Booking Id Is </i></b>"+getTxt1);
				
				QaExtentReport.extentScreenshot("FinalResult");
				QaRobot.ScreenshotMethod("FinalResult","<b><i>Screenshot for Search Page</i></b>");
			}
		}
		
		else
		{
			QaRobot.ClickOnElement("MoreDetails");
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on MoreDetails</i></b>");
			Thread.sleep(3000);
			
			QaExtentReport.extentScreenshot("MoreDetails");
			QaRobot.ScreenshotMethod("MoreDetails","<b><i>Screenshot for More Details</i></b>");
			
			QaRobot.ClickOnElement("MoreDetailsClose");
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on MoreDetailsClose</i></b>");
			
			QaRobot.ClickOnElement("FareBreackup");
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on FareBreackup</i></b>");
			Thread.sleep(3000);
			
			QaExtentReport.extentScreenshot("FareBreackup");
			QaRobot.ScreenshotMethod("FareBreackup","<b><i>Screenshot for Fare Breackup</i></b>");
			
			QaRobot.ClickOnElement("FareBreackupCloseMY");
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on FareBreackupClose</i></b>");
			
			QaRobot.ClickOnElement("CheckBox");
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on CheckBox</i></b>");
			
			QaRobot.ClickOnElement("TermCondition");
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on TermCondition</i></b>");
			
			QaRobot.ScreenshotMethod("FinalBook","<b><i>Screenshot for Final Book</i></b>");
			
			String url2 = QaBrowser.driver.getCurrentUrl();
			String[] uid = url2.split("=");
			QaExtentReport.test.log(Status.INFO, "<b><i>Session id is </i></b>" + uid[1]);
			
			QaExtentReport.extentScreenshot("FinalBook");
			QaRobot.ClickOnElement("FinalBook");
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on FinalBook</i></b>");
			
			Alert alt = QaBrowser.driver.switchTo().alert();
			alt.accept();
			
			WebElement DropDown = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_ddlFop1']"));
			Select s = new Select(DropDown);
			s.selectByVisibleText("Bill To Company");
			
			QaRobot.ClickOnElement("Ok");
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on Ok Button</i></b>");
			
			QaExtentReport.extentScreenshot("Proceed");
			QaRobot.ScreenshotMethod("Proceed","<b><i>Screenshot for Procced Page</i></b>");
			
			QaRobot.ClickOnElement("Proceed");
			QaExtentReport.test.log(Status.INFO,"<b><i>Click on Proceed</i></b>");
			
			WebElement getT = QaBrowser.driver.findElement(By.xpath("(//html//body//div//span)[70]"));
			String getTxt = getT.getText();
			
			String bookingID = QaBrowser.driver.findElement(By.xpath("//span[@class='nc_bookid_no']")).getText();
			String a []= bookingID.split(" ");
			String number = a[2];
			QaExtentReport.test.log(Status.INFO, "<b><i>Booking Id Is </i></b>"+getTxt);
			QaExtentReport.test.log(Status.INFO, "<b><i>Booking id is </i></b>" + bookingID);
			
			QaExtentReport.extentScreenshot("Confirm Page");
			
			QaRobot.mouseHover("//a[@id='ctl00_HeaderTop_aBookingMenu']", "//span[@id='ctl00_HeaderTop_lblBookingQueue']");
			QaExtentReport.extentScreenshot("CorporateDashboard Page");
			
			QaRobot.ScreenshotMethod("CorporateDashboard","<b><i>Screenshot for Corporate Dashboard Page</i></b>");
			Thread.sleep(3000);
			
			QaRobot.PassValue("RefNo",number);
			QaExtentReport.test.log(Status.INFO,"<b><i>Write Ref No</i></b>");
			
			QaRobot.ClickOnElement("SearchRefNo");
			 
			QaRobot.ClickOnElement("RefBooking");
			
			QaExtentReport.extentScreenshot("Booking Card");
			
			QaExtentReport.test.log(Status.INFO, "<b><i>Created by accepted </i></b>"+CreatedBy);
			
			String Creater = QaBrowser.driver.findElement(By.xpath("//span[@id='lblCreatedBy']")).getText();
			System.out.println("Created By " + Creater);
			QaExtentReport.test.log(Status.INFO, "<b><i>Created By </i></b>" + Creater);
			
			if(CreatedBy.equalsIgnoreCase(Creater))
			{
				QaExtentReport.test.log(Status.INFO, "<b><i>Creater is Correct  </i></b>"+CreatedBy);
			}
			else
			{
				QaExtentReport.test.log(Status.FAIL, "<b><i>Creater is Different  </i></b>"+CreatedBy);
			}
		}
	}	
	
	@AfterMethod
	public static void afterMetod()
	{
		QaExtentReport.test.getExtent().flush();
//		QaBrowser.driver.close();
	}
}
