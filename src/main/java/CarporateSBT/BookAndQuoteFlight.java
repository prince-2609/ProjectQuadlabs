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
	public static void Profiling1(String Source,String URL, String Comapnycode,String Username,String Password, String RefNo,
			String BookingType,String adult,String child,String infant) throws Exception 
	{
		TestBase.Companycode(Source,URL); 
		QaRobot.impliwait(30);
		
		QaExtentReport.test = QaExtentReport.report.createTest("Test on My Booking For Flight");
	
		QaRobot.PassValue("User_name",Username);
		QaExtentReport.test.log(Status.INFO,"<b><i>Write Username</i></b>");
		
		QaRobot.PassValue("Password",Password);
		QaExtentReport.test.log(Status.INFO, "<b><i>Write Password</i></b>");
		
		QaRobot.ClickOnElement("Submit");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on submit</i></b>");
		
		QaRobot.ScreenshotMethod("CorporateLogin","<b><i>Screenshot for Corporate Login Page</i></b>");
		
		QaRobot.mouseHover("//a[@id='HeaderTop_aBookingMenu']", "//span[@id='HeaderTop_lblBookingQueue']");
		
		QaRobot.ScreenshotMethod("CorporateDashboard","<b><i>Screenshot for Corporate Dashboard Page</i></b>");
		
		QaRobot.PassValue("EnterRefNo", RefNo);
		QaExtentReport.test.log(Status.INFO, "<b><i>Write Ref No Is</i></b>"+RefNo);
		
		QaRobot.ScreenshotMethod("RefNo","<b><i>Screenshot for Enquiry Id</i></b>");
		
		QaRobot.ClickOnElement("SearchButton");
		QaExtentReport.test.log(Status.INFO, "<b><i>Click on Search Button</i></b>");
		
		QaRobot.ClickOnElement("BookButton");
		QaExtentReport.test.log(Status.INFO,  "<b><i>Click on Book Button</i></b>");
		
		QaRobot.ScreenshotMethod("BookButton","<b><i>Screenshot for Book Button</i></b>");
		
		if(BookingType.equalsIgnoreCase("Dependent"))
		{	
			QaRobot.ClickOnElement("MoreDetails");
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on MoreDetails</i></b>");
			Thread.sleep(3000);
			
			QaRobot.ScreenshotMethod("MoreDetails","<b><i>Screenshot for More Details</i></b>");
			
			QaRobot.ClickOnElement("MoreDetailsClose");
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on MoreDetailsClose</i></b>");
			
			QaRobot.ClickOnElement("FareBreackup");
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on FareBreackup</i></b>");
			Thread.sleep(3000);
			
			QaRobot.ScreenshotMethod("FareBreackup","<b><i>Screenshot for Fare Breackup</i></b>");
			
			QaRobot.ClickOnElement("FareBreackupClose");
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
				
				QaRobot.ClickOnElement("CheckBox");
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
				
				QaRobot.ClickOnElement("CheckBox");
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
		
		else
		{
			QaRobot.ClickOnElement("MoreDetails");
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on MoreDetails</i></b>");
			Thread.sleep(3000);
			
			QaRobot.ScreenshotMethod("MoreDetails","<b><i>Screenshot for More Details</i></b>");
			
			QaRobot.ClickOnElement("MoreDetailsClose");
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on MoreDetailsClose</i></b>");
			
			QaRobot.ClickOnElement("FareBreackup");
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on FareBreackup</i></b>");
			Thread.sleep(3000);
			
			QaRobot.ScreenshotMethod("FareBreackup","<b><i>Screenshot for Fare Breackup</i></b>");
			
			QaRobot.ClickOnElement("FareBreackupClose");
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on FareBreackupClose</i></b>");
			
			QaRobot.ClickOnElement("CheckBox");
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
//		QaBrowser.driver.close();
	}
}
