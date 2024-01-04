package SBT_Corporate;

import static org.testng.Assert.fail;

import java.util.List;
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
public class PlanYourTrip 
{
	@DataProvider
	public Object[][] getexceldata() throws Exception 
	{
		return QaDataProvider.getTestdata("PlanYourTripAll", "PlanYourTripAll");
	}
	
	@Test(dataProvider = "getexceldata")
	public static void Profiling1(String Source,String URL, String Comapnycode,String Username,String Password, String Enquiryid,String BookingType,
			String FlightPolicy,String Hotelpolicy,String ApprovalType,String AirReasonCode,String HotelReasonCode) throws Exception 
	{
		TestBase.Companycode(Source,URL); 
		QaRobot.impliwait(30);
		
		QaExtentReport.test = QaExtentReport.report.createTest("Test on Plan Your Trip");
	
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
		Thread.sleep(3000);
		
		QaRobot.ScreenshotMethod("View","<b><i>Screenshot for View Button</i></b>");
		
		QaRobot.ClickOnElement("ViewClose");
		QaExtentReport.test.log(Status.INFO, "<b><i>Click on View Close Button</i></b>");
		
		QaRobot.ClickOnElement("Book");
		QaExtentReport.test.log(Status.INFO,  "<b><i>Click on Book</i></b>");
		Thread.sleep(3000);
		
		QaRobot.ScreenshotMethod("BookButton","<b><i>Screenshot for Book Button</i></b>");
		
		if (BookingType.equalsIgnoreCase("Flight"))
		{
			QaRobot.ClickOnElement("SearchType");
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on Search Type Of Product</i></b>");
			Thread.sleep(10000);
			
			if(FlightPolicy.equalsIgnoreCase("InPolicy"))
			{
				QaRobot.ClickOnElement("InPolicy");
				QaExtentReport.test.log(Status.INFO, "<b><i>Click on In Policy Button</i></b>");
				Thread.sleep(5000);
				
				QaRobot.ClickOnElement("AddToCart11");
				QaExtentReport.test.log(Status.INFO, "<b><i>Click on Add To Cart Button</i></b>");
				Thread.sleep(3000);
				
				String ParentWindow = QaBrowser.driver.getWindowHandle();
				Set<String> handles = QaBrowser.driver.getWindowHandles();
				for (String childWindow : handles) 
				{
					if (!childWindow.equals(ParentWindow))
						QaBrowser.driver.switchTo().window(childWindow);
				}
				
				QaRobot.ClickOnElement("CloseButton");
				QaExtentReport.test.log(Status.INFO, "<b><i>Click on Close Button</i></b>");
				
				QaBrowser.driver.switchTo().window(ParentWindow);
			}
			else if (FlightPolicy.equalsIgnoreCase("OutPolicy"))	
			{
				QaRobot.ClickOnElement("OutPolicy");
				QaExtentReport.test.log(Status.INFO, "<b><i>Click on In Policy Button</i></b>");
				Thread.sleep(5000);
				
				QaRobot.ClickOnElement("AddToCart2");
				QaExtentReport.test.log(Status.INFO, "<b><i>Click on Add To Cart Button</i></b>");
				Thread.sleep(3000);
				
				Alert alt = QaBrowser.driver.switchTo().alert();
				alt.accept();
				
				String ParentWindow = QaBrowser.driver.getWindowHandle();
				Set<String> handles = QaBrowser.driver.getWindowHandles();
				for (String childWindow : handles) 
				{
					if (!childWindow.equals(ParentWindow))
						QaBrowser.driver.switchTo().window(childWindow);
				}
				
				QaRobot.ClickOnElement("CloseButton");
				QaExtentReport.test.log(Status.INFO, "<b><i>Click on Close Button</i></b>");
				
				QaBrowser.driver.switchTo().window(ParentWindow);
			}
			else if (FlightPolicy.equalsIgnoreCase("Null"))	
			{
				QaRobot.ClickOnElement("AddToCart11");
				QaExtentReport.test.log(Status.INFO, "<b><i>Click on Add To Cart Button</i></b>");
				Thread.sleep(3000);
				
				String ParentWindow = QaBrowser.driver.getWindowHandle();
				Set<String> handles = QaBrowser.driver.getWindowHandles();
				for (String childWindow : handles) 
				{
					if (!childWindow.equals(ParentWindow))
						QaBrowser.driver.switchTo().window(childWindow);
				}
				
				QaRobot.ClickOnElement("CloseButton");
				QaExtentReport.test.log(Status.INFO, "<b><i>Click on Close Button</i></b>");
				
				QaBrowser.driver.switchTo().window(ParentWindow);
			}
			
			QaRobot.ClickOnElement("YourItinery");
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on Your Itinery Button</i></b>");
			
			if(ApprovalType.equalsIgnoreCase("SendForApproval"))
			{
				QaRobot.ClickOnElement("SendForApproval3");
				QaExtentReport.test.log(Status.INFO, "<b><i>Click on Send For Approval Button</i></b>");
				
				String ParentWindow = QaBrowser.driver.getWindowHandle();
				Set<String> handles = QaBrowser.driver.getWindowHandles();
				for (String childWindow : handles) 
				{
					if (!childWindow.equals(ParentWindow))
						QaBrowser.driver.switchTo().window(childWindow);
				}
				
				WebElement DropDown = QaBrowser.driver.findElement(By.xpath("//select[@id='corpReasonF']"));
				Select s = new Select(DropDown);
				s.selectByVisibleText(AirReasonCode);
				
				QaRobot.ClickOnElement("SendButton");
				QaExtentReport.test.log(Status.INFO, "<b><i>Click on Send Button</i></b>");
				
				Alert alt = QaBrowser.driver.switchTo().alert();
				alt.accept();
				Thread.sleep(20000);
				
				Alert alt1 = QaBrowser.driver.switchTo().alert();
				alt1.accept();
				Thread.sleep(5000);
			
				QaBrowser.driver.switchTo().window(ParentWindow);
				Thread.sleep(40000);
				
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
				Thread.sleep(10000);
				
				QaRobot.ScreenshotMethod("View","<b><i>Screenshot for View Button</i></b>");
				
				QaRobot.ClickOnElement("ViewClose");
				QaExtentReport.test.log(Status.INFO, "<b><i>Click on View Close Button</i></b>");
				Thread.sleep(3000);
				
				QaRobot.ClickOnElement("Book");
				QaExtentReport.test.log(Status.INFO,  "<b><i>Click on Book</i></b>");
				Thread.sleep(2000);
				
				QaRobot.ScreenshotMethod("BookButton","<b><i>Screenshot for Book Button</i></b>");
				
				QaRobot.ClickOnElement("ProceedToCheckout");
				QaExtentReport.test.log(Status.INFO, "<b><i>Click on ProceedToCheckout</i></b>");
				Thread.sleep(3000);
								
				QaRobot.ScreenshotMethod("ProceedCheckout","<b><i>Screenshot for ProceedToCheckout</i></b>");
			}
			else if (ApprovalType.equalsIgnoreCase("ProceedToCheckout"))	
			{
				QaRobot.ClickOnElement("ProceedToCheckout");
				QaExtentReport.test.log(Status.INFO, "<b><i>Click on ProceedToCheckout</i></b>");
				Thread.sleep(3000);
				
				QaRobot.ScreenshotMethod("ProceedCheckout","<b><i>Screenshot for ProceedToCheckout</i></b>");
			}
			
			PlanYourTrip.procheck();
		}
		else if (BookingType.equalsIgnoreCase("Hotel"))
		{
			QaRobot.ClickOnElement("SearchType1");
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on Search Type Of Product</i></b>");
			Thread.sleep(10000);
			
			List<WebElement> listOfPolicytype = QaBrowser.driver.findElements(By.xpath("//div[@class='fl_upref_right']"));
			int bookindex = 10;
			for (WebElement policytype : listOfPolicytype) 
			{
				bookindex = bookindex + 1;
				String type = policytype.getText();
				System.out.println(type);
				if (type.equalsIgnoreCase(Hotelpolicy)) {
					// click on select room button with indexing (starting from 11)
					QaBrowser.driver.findElement(By.xpath("//p[@id='htlrm0" + bookindex+ "']")).click();
					
					if (isElementAvailable("//div[@id='nrm_box_1']/div[2]/div/h3")) {
						fail("Unable to procced booking due to getting no room availability");
					} else {
						// select the room
						QaBrowser.driver.findElement(By.xpath("(//span[text()='Add To Cart'])[1]")).click();
						
						if (type.equalsIgnoreCase("Out Of Policy")) {
							QaBrowser.driver.switchTo().alert().accept();
						}
						
						String ParentWindow = QaBrowser.driver.getWindowHandle();
						Set<String> handles = QaBrowser.driver.getWindowHandles();
						for (String childWindow : handles) 
						{
							if (!childWindow.equals(ParentWindow))
								QaBrowser.driver.switchTo().window(childWindow);
						}
						
						QaRobot.ClickOnElement("CloseButton");
						QaExtentReport.test.log(Status.INFO, "<b><i>Click on Close Button</i></b>");
						
						QaBrowser.driver.switchTo().window(ParentWindow);
					break;
					}}
				 else {
					QaExtentReport.test.log(Status.INFO, "Corporate policy is not matched with " + Hotelpolicy);
					System.out.println("Corporate policy is not matched");
				}
			}
			
			Thread.sleep(3000);
			
			WebElement WebElement = QaBrowser.driver.findElement(By.xpath("//a[@id='AViewCart']"));
			JavascriptExecutor js = (JavascriptExecutor) QaBrowser.driver;
			js.executeScript("arguments[0].click()", WebElement);
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on Your Itinery Button</i></b>");
			Thread.sleep(3000);
			
			
//			QaRobot.ClickOnElement("YourItinery");
//			QaExtentReport.test.log(Status.INFO, "<b><i>Click on Your Itinery Button</i></b>");
			
			if(ApprovalType.equalsIgnoreCase("SendForApproval"))
			{
				QaRobot.ClickOnElement("SendForApproval3");
				QaExtentReport.test.log(Status.INFO, "<b><i>Click on Send For Approval Button</i></b>");
				
				String ParentWindow = QaBrowser.driver.getWindowHandle();
				Set<String> handles = QaBrowser.driver.getWindowHandles();
				for (String childWindow : handles) 
				{
					if (!childWindow.equals(ParentWindow))
						QaBrowser.driver.switchTo().window(childWindow);
				}
				
				WebElement DropDown = QaBrowser.driver.findElement(By.xpath("(//select[@id='corpReasonH'])[1]"));
				Select s = new Select(DropDown);
				s.selectByVisibleText(HotelReasonCode);
				
				QaRobot.ClickOnElement("SendButton1");
				QaExtentReport.test.log(Status.INFO, "<b><i>Click on Send Button</i></b>");
				
				Alert alt = QaBrowser.driver.switchTo().alert();
				alt.accept();
				Thread.sleep(20000);
				
				Alert alt1 = QaBrowser.driver.switchTo().alert();
				alt1.accept();
				Thread.sleep(5000);
				
				QaBrowser.driver.switchTo().window(ParentWindow);
				Thread.sleep(40000);
				
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
				Thread.sleep(5000);
				
				QaRobot.ClickOnElement("Book");
				QaExtentReport.test.log(Status.INFO,  "<b><i>Click on Book</i></b>");
				Thread.sleep(2000);
				QaRobot.ScreenshotMethod("BookButton","<b><i>Screenshot for Book Button</i></b>");
				
				QaRobot.ClickOnElement("ProceedToCheckout");
				QaExtentReport.test.log(Status.INFO, "<b><i>Click on ProceedToCheckout</i></b>");
				Thread.sleep(3000);
				
				QaRobot.ScreenshotMethod("ProceedCheckout","<b><i>Screenshot for ProceedToCheckout</i></b>");
			}
			else if (ApprovalType.equalsIgnoreCase("ProceedToCheckout"))	
			{
				QaRobot.ClickOnElement("ProceedToCheckout");
				QaExtentReport.test.log(Status.INFO, "<b><i>Click on ProceedToCheckout</i></b>");
				Thread.sleep(3000);
				
				QaRobot.ScreenshotMethod("ProceedCheckout","<b><i>Screenshot for ProceedToCheckout</i></b>");
			}
			WebElement WebElement4 = QaBrowser.driver.findElement(By.xpath("/html/body/div/form/div[4]/div/div/section/div[1]/div[2]/div[4]/div[1]/div[4]/div[2]/div[7]/div[4]/ul/li/a"));
			JavascriptExecutor js4 = (JavascriptExecutor) QaBrowser.driver;
			js4.executeScript("arguments[0].click()", WebElement4);
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on FareBreackup</i></b>");
			Thread.sleep(3000);
			
			QaRobot.ScreenshotMethod("FareBreackup","<b><i>Screenshot for Fare Breackup</i></b>");
			
			WebElement WebElement5 = QaBrowser.driver.findElement(By.xpath("//a[@title='Close']"));
			JavascriptExecutor js5 = (JavascriptExecutor) QaBrowser.driver;
			js5.executeScript("arguments[0].click()", WebElement5);
			Thread.sleep(2000);
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on FareBreackupClose</i></b>");
			
			QaRobot.ClickOnElement("CheckBox1");
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on CheckBox</i></b>");
			
			QaRobot.ClickOnElement("TermCondition");
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on TermCondition</i></b>");
			
			QaRobot.ScreenshotMethod("FinalBook","<b><i>Screenshot for Final Book</i></b>");
			
			String url = QaBrowser.driver.getCurrentUrl();
			String[] uid = url.split("=");
			QaExtentReport.test.log(Status.INFO, "<b><i>Session id is </i></b>" + uid[1]);
			
			QaRobot.ClickOnElement("FinalBook1");
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on FinalBook</i></b>");
			
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
		else if (BookingType.equalsIgnoreCase("Flight+Hotel"))
		{
			QaRobot.ClickOnElement("SearchType");
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on Search Type Of Product</i></b>");
			Thread.sleep(10000);
			
			if(FlightPolicy.equalsIgnoreCase("InPolicy"))
			{
				QaRobot.ClickOnElement("InPolicy");
				QaExtentReport.test.log(Status.INFO, "<b><i>Click on In Policy Button</i></b>");
				Thread.sleep(5000);
				
				QaRobot.ClickOnElement("AddToCart11");
				QaExtentReport.test.log(Status.INFO, "<b><i>Click on Add To Cart Button</i></b>");
				Thread.sleep(3000);
				
				String ParentWindow = QaBrowser.driver.getWindowHandle();
				Set<String> handles = QaBrowser.driver.getWindowHandles();
				for (String childWindow : handles) 
				{
					if (!childWindow.equals(ParentWindow))
						QaBrowser.driver.switchTo().window(childWindow);
				}
				
				QaRobot.ClickOnElement("CloseButton");
				QaExtentReport.test.log(Status.INFO, "<b><i>Click on Close Button</i></b>");
				
				QaBrowser.driver.switchTo().window(ParentWindow);
			}
			else if (FlightPolicy.equalsIgnoreCase("OutPolicy"))	
			{
				QaRobot.ClickOnElement("OutPolicy");
				QaExtentReport.test.log(Status.INFO, "<b><i>Click on In Policy Button</i></b>");
				Thread.sleep(5000);
				
				QaRobot.ClickOnElement("AddToCart2");
				QaExtentReport.test.log(Status.INFO, "<b><i>Click on Add To Cart Button</i></b>");
				Thread.sleep(3000);
				
				Alert alt = QaBrowser.driver.switchTo().alert();
				alt.accept();
				
				String ParentWindow = QaBrowser.driver.getWindowHandle();
				Set<String> handles = QaBrowser.driver.getWindowHandles();
				for (String childWindow : handles) 
				{
					if (!childWindow.equals(ParentWindow))
						QaBrowser.driver.switchTo().window(childWindow);
				}
				
				QaRobot.ClickOnElement("CloseButton");
				QaExtentReport.test.log(Status.INFO, "<b><i>Click on Close Button</i></b>");
				
				QaBrowser.driver.switchTo().window(ParentWindow);
			}
			else if (FlightPolicy.equalsIgnoreCase("Null"))	
			{
				QaRobot.ClickOnElement("AddToCart11");
				QaExtentReport.test.log(Status.INFO, "<b><i>Click on Add To Cart Button</i></b>");
				Thread.sleep(3000);
				
				String ParentWindow = QaBrowser.driver.getWindowHandle();
				Set<String> handles = QaBrowser.driver.getWindowHandles();
				for (String childWindow : handles) 
				{
					if (!childWindow.equals(ParentWindow))
						QaBrowser.driver.switchTo().window(childWindow);
				}
				
				QaRobot.ClickOnElement("CloseButton");
				QaExtentReport.test.log(Status.INFO, "<b><i>Click on Close Button</i></b>");
				
				QaBrowser.driver.switchTo().window(ParentWindow);
			}
			
			QaRobot.ClickOnElement("YourItinery");
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on Your Itinery Button</i></b>");
			Thread.sleep(5000);
			
			QaRobot.ClickOnElement("SearchType1");
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on Search Type Of Product</i></b>");
			Thread.sleep(10000);
			
			List<WebElement> listOfPolicytype = QaBrowser.driver.findElements(By.xpath("//div[@class='fl_upref_right']"));
			int bookindex = 10;
			for (WebElement policytype : listOfPolicytype) 
			{
				bookindex = bookindex + 1;
				String type = policytype.getText();
				System.out.println(type);
				if (type.equalsIgnoreCase(Hotelpolicy)) {
					// click on select room button with indexing (starting from 11)
					QaBrowser.driver.findElement(By.xpath("//p[@id='htlrm0" + bookindex+ "']")).click();
					
					if (isElementAvailable("//div[@id='nrm_box_1']/div[2]/div/h3")) {
						fail("Unable to procced booking due to getting no room availability");
					} else {
						// select the room
						QaBrowser.driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/section[1]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[3]/div/div/div/div/div[2]/label[1]/div[5]/p/span")).click();
						
						if (type.equalsIgnoreCase("Out Of Policy")) {
							QaBrowser.driver.switchTo().alert().accept();
						}
						
						String ParentWindow = QaBrowser.driver.getWindowHandle();
						Set<String> handles = QaBrowser.driver.getWindowHandles();
						for (String childWindow : handles) 
						{
							if (!childWindow.equals(ParentWindow))
								QaBrowser.driver.switchTo().window(childWindow);
						}
						
						QaRobot.ClickOnElement("CloseButton");
						QaExtentReport.test.log(Status.INFO, "<b><i>Click on Close Button</i></b>");
						
						QaBrowser.driver.switchTo().window(ParentWindow);
					break;
					}}
				 else {
					QaExtentReport.test.log(Status.INFO, "Corporate policy is not matched with " + Hotelpolicy);
					System.out.println("Corporate policy is not matched");
				}
			}
			
			QaRobot.ClickOnElement("YourItinery");
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on Your Itinery Button</i></b>");
			
			if(ApprovalType.equalsIgnoreCase("SendForApproval"))
			{
				QaRobot.ClickOnElement("SendForApproval3");
				QaExtentReport.test.log(Status.INFO, "<b><i>Click on Send For Approval Button</i></b>");
				
				String ParentWindow = QaBrowser.driver.getWindowHandle();
				Set<String> handles = QaBrowser.driver.getWindowHandles();
				for (String childWindow : handles) 
				{
					if (!childWindow.equals(ParentWindow))
						QaBrowser.driver.switchTo().window(childWindow);
				}
				
				WebElement DropDown = QaBrowser.driver.findElement(By.xpath("//select[@id='corpReasonF']"));
				Select s = new Select(DropDown);
				s.selectByVisibleText(AirReasonCode);
				
				WebElement DropDown1 = QaBrowser.driver.findElement(By.xpath("//select[@id='corpReasonH']"));
				Select s1 = new Select(DropDown1);
				s1.selectByVisibleText(HotelReasonCode);
				
				QaRobot.ClickOnElement("SendButton2");
				QaExtentReport.test.log(Status.INFO, "<b><i>Click on Send Button</i></b>");
				
				Alert alt = QaBrowser.driver.switchTo().alert();
				alt.accept();
				Thread.sleep(20000);
				
				Alert alt1 = QaBrowser.driver.switchTo().alert();
				alt1.accept();
				Thread.sleep(5000);
				
				QaBrowser.driver.switchTo().window(ParentWindow);
				Thread.sleep(40000);
				
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
				Thread.sleep(3000);
				
				QaRobot.ScreenshotMethod("View","<b><i>Screenshot for View Button</i></b>");
				
				QaRobot.ClickOnElement("ViewClose");
				QaExtentReport.test.log(Status.INFO, "<b><i>Click on View Close Button</i></b>");
				
				QaRobot.ClickOnElement("Book");
				QaExtentReport.test.log(Status.INFO,  "<b><i>Click on Book</i></b>");
				Thread.sleep(2000);
				QaRobot.ScreenshotMethod("BookButton","<b><i>Screenshot for Book Button</i></b>");
				
				QaRobot.ClickOnElement("ProceedToCheckout");
				QaExtentReport.test.log(Status.INFO, "<b><i>Click on ProceedToCheckout</i></b>");
				Thread.sleep(3000);
				
				QaRobot.ScreenshotMethod("ProceedCheckout","<b><i>Screenshot for ProceedToCheckout</i></b>");
			}
			else if (ApprovalType.equalsIgnoreCase("ProceedToCheckout"))	
			{
				QaRobot.ClickOnElement("ProceedToCheckout");
				QaExtentReport.test.log(Status.INFO, "<b><i>Click on ProceedToCheckout</i></b>");
				Thread.sleep(3000);
				
				QaRobot.ScreenshotMethod("ProceedCheckout","<b><i>Screenshot for ProceedToCheckout</i></b>");
			}
			
			PlanYourTrip.flightHotelApproval();
		}
		
		else if (BookingType.equalsIgnoreCase("Hotel+Flight"))
		{
			QaRobot.ClickOnElement("SearchType1");
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on Search Type Of Product</i></b>");
			Thread.sleep(10000);
			
			List<WebElement> listOfPolicytype = QaBrowser.driver.findElements(By.xpath("//div[@class='fl_upref_right']"));
			int bookindex = 10;
			for (WebElement policytype : listOfPolicytype) 
			{
				bookindex = bookindex + 1;
				String type = policytype.getText();
				System.out.println(type);
				if (type.equalsIgnoreCase(Hotelpolicy)) {
					// click on select room button with indexing (starting from 11)
					QaBrowser.driver.findElement(By.xpath("//p[@id='htlrm0" + bookindex+ "']")).click();
					
					if (isElementAvailable("//div[@id='nrm_box_1']/div[2]/div/h3")) {
						fail("Unable to procced booking due to getting no room availability");
					} else {
						// select the room
						QaBrowser.driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/section[1]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[3]/div/div/div/div/div[2]/label[1]/div[5]/p/span")).click();
						
						if (type.equalsIgnoreCase("Out Of Policy")) {
							QaBrowser.driver.switchTo().alert().accept();
						}
						
						String ParentWindow = QaBrowser.driver.getWindowHandle();
						Set<String> handles = QaBrowser.driver.getWindowHandles();
						for (String childWindow : handles) 
						{
							if (!childWindow.equals(ParentWindow))
								QaBrowser.driver.switchTo().window(childWindow);
						}
						
						QaRobot.ClickOnElement("CloseButton");
						QaExtentReport.test.log(Status.INFO, "<b><i>Click on Close Button</i></b>");
						
						QaBrowser.driver.switchTo().window(ParentWindow);
					break;
					}}
				 else {
					QaExtentReport.test.log(Status.INFO, "Corporate policy is not matched with " + Hotelpolicy);
					System.out.println("Corporate policy is not matched");
				}
			}
			
			QaRobot.ClickOnElement("YourItinery");
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on Your Itinery Button</i></b>");
			Thread.sleep(5000);
			
			QaRobot.ClickOnElement("SearchType");
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on Search Type Of Product</i></b>");
			Thread.sleep(10000);
			
			if(FlightPolicy.equalsIgnoreCase("InPolicy"))
			{
				QaRobot.ClickOnElement("InPolicy");
				QaExtentReport.test.log(Status.INFO, "<b><i>Click on In Policy Button</i></b>");
				Thread.sleep(5000);
				
				QaRobot.ClickOnElement("AddToCart11");
				QaExtentReport.test.log(Status.INFO, "<b><i>Click on Add To Cart Button</i></b>");
				Thread.sleep(3000);
				
				String ParentWindow = QaBrowser.driver.getWindowHandle();
				Set<String> handles = QaBrowser.driver.getWindowHandles();
				for (String childWindow : handles) 
				{
					if (!childWindow.equals(ParentWindow))
						QaBrowser.driver.switchTo().window(childWindow);
				}
				
				QaRobot.ClickOnElement("CloseButton");
				QaExtentReport.test.log(Status.INFO, "<b><i>Click on Close Button</i></b>");
				
				QaBrowser.driver.switchTo().window(ParentWindow);
			}
			else if (FlightPolicy.equalsIgnoreCase("OutPolicy"))	
			{
				QaRobot.ClickOnElement("OutPolicy");
				QaExtentReport.test.log(Status.INFO, "<b><i>Click on In Policy Button</i></b>");
				Thread.sleep(5000);
				
				QaRobot.ClickOnElement("AddToCart2");
				QaExtentReport.test.log(Status.INFO, "<b><i>Click on Add To Cart Button</i></b>");
				Thread.sleep(3000);
				
				Alert alt = QaBrowser.driver.switchTo().alert();
				alt.accept();
				
				String ParentWindow = QaBrowser.driver.getWindowHandle();
				Set<String> handles = QaBrowser.driver.getWindowHandles();
				for (String childWindow : handles) 
				{
					if (!childWindow.equals(ParentWindow))
						QaBrowser.driver.switchTo().window(childWindow);
				}
				
				QaRobot.ClickOnElement("CloseButton");
				QaExtentReport.test.log(Status.INFO, "<b><i>Click on Close Button</i></b>");
				
				QaBrowser.driver.switchTo().window(ParentWindow);
			}
			else if (FlightPolicy.equalsIgnoreCase("Null"))	
			{
				QaRobot.ClickOnElement("AddToCart11");
				QaExtentReport.test.log(Status.INFO, "<b><i>Click on Add To Cart Button</i></b>");
				Thread.sleep(3000);
				
				String ParentWindow = QaBrowser.driver.getWindowHandle();
				Set<String> handles = QaBrowser.driver.getWindowHandles();
				for (String childWindow : handles) 
				{
					if (!childWindow.equals(ParentWindow))
						QaBrowser.driver.switchTo().window(childWindow);
				}
				
				QaRobot.ClickOnElement("CloseButton");
				QaExtentReport.test.log(Status.INFO, "<b><i>Click on Close Button</i></b>");
				
				QaBrowser.driver.switchTo().window(ParentWindow);
			}
			
			QaRobot.ClickOnElement("YourItinery");
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on Your Itinery Button</i></b>");
			
			if(ApprovalType.equalsIgnoreCase("SendForApproval"))
			{
				QaRobot.ClickOnElement("SendForApproval3");
				QaExtentReport.test.log(Status.INFO, "<b><i>Click on Send For Approval Button</i></b>");
				
				String ParentWindow = QaBrowser.driver.getWindowHandle();
				Set<String> handles = QaBrowser.driver.getWindowHandles();
				for (String childWindow : handles) 
				{
					if (!childWindow.equals(ParentWindow))
						QaBrowser.driver.switchTo().window(childWindow);
				}
				
				WebElement DropDown = QaBrowser.driver.findElement(By.xpath("//select[@id='corpReasonF']"));
				Select s = new Select(DropDown);
				s.selectByVisibleText(AirReasonCode);
				
				WebElement DropDown1 = QaBrowser.driver.findElement(By.xpath("//select[@id='corpReasonH']"));
				Select s1 = new Select(DropDown1);
				s1.selectByVisibleText(HotelReasonCode);
				
				QaRobot.ClickOnElement("SendButton3");
				QaExtentReport.test.log(Status.INFO, "<b><i>Click on Send Button</i></b>");
				
				Alert alt = QaBrowser.driver.switchTo().alert();
				alt.accept();
				Thread.sleep(20000);
				
				Alert alt1 = QaBrowser.driver.switchTo().alert();
				alt1.accept();
				Thread.sleep(5000);
				
				QaBrowser.driver.switchTo().window(ParentWindow);
				Thread.sleep(40000);
				
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
				Thread.sleep(3000);
				
				QaRobot.ScreenshotMethod("View","<b><i>Screenshot for View Button</i></b>");
				
				QaRobot.ClickOnElement("ViewClose");
				QaExtentReport.test.log(Status.INFO, "<b><i>Click on View Close Button</i></b>");
				
				QaRobot.ClickOnElement("Book");
				QaExtentReport.test.log(Status.INFO,  "<b><i>Click on Book</i></b>");
				Thread.sleep(2000);
				QaRobot.ScreenshotMethod("BookButton","<b><i>Screenshot for Book Button</i></b>");
				
				QaRobot.ClickOnElement("ProceedToCheckout");
				QaExtentReport.test.log(Status.INFO, "<b><i>Click on ProceedToCheckout</i></b>");
				Thread.sleep(3000);
				
				QaRobot.ScreenshotMethod("ProceedCheckout","<b><i>Screenshot for ProceedToCheckout</i></b>");
			}
			else if (ApprovalType.equalsIgnoreCase("ProceedToCheckout"))	
			{
				QaRobot.ClickOnElement("ProceedToCheckout");
				QaExtentReport.test.log(Status.INFO, "<b><i>Click on ProceedToCheckout</i></b>");
				Thread.sleep(3000);
				
				QaRobot.ScreenshotMethod("ProceedCheckout","<b><i>Screenshot for ProceedToCheckout</i></b>");
			}
			PlanYourTrip.flightHotelApproval();
		}
	}
	
	@AfterMethod
	public static void afterMetod() 
	{
		QaExtentReport.test.getExtent().flush();
//		QaBrowser.driver.close();
	}

	private static boolean isElementAvailable(String xpath) {
		try {
			QaBrowser.driver.findElement(By.xpath(xpath));
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public static void procheck() throws Exception
	{
		WebElement WebElement = QaBrowser.driver.findElement(By.xpath("/html/body/div/form/div[4]/div/div/section/div/div[2]/div[4]/div[1]/div[4]/div[2]/div[7]/div[3]/div[10]/ul/li/a"));
		JavascriptExecutor js = (JavascriptExecutor) QaBrowser.driver;
		js.executeScript("arguments[0].click()", WebElement);
		QaExtentReport.test.log(Status.INFO, "<b><i>Click on MoreDetails</i></b>");
		Thread.sleep(3000);
		
		QaRobot.ScreenshotMethod("MoreDetails","<b><i>Screenshot for More Details</i></b>");
		
		WebElement WebElement1 = QaBrowser.driver.findElement(By.xpath("//a[@title='Close']"));
		JavascriptExecutor js1 = (JavascriptExecutor) QaBrowser.driver;
		js1.executeScript("arguments[0].click()", WebElement1);
		QaExtentReport.test.log(Status.INFO, "<b><i>Click on MoreDetailsClose</i></b>");
		
		WebElement WebElement2 = QaBrowser.driver.findElement(By.xpath("/html/body/div/form/div[4]/div/div/section/div/div[2]/div[4]/div[1]/div[4]/div[2]/div[7]/div[5]/div[10]/ul/li[1]/a"));
		JavascriptExecutor js2 = (JavascriptExecutor) QaBrowser.driver;
		js2.executeScript("arguments[0].click()", WebElement2);
		QaExtentReport.test.log(Status.INFO, "<b><i>Click on MoreDetails</i></b>");
		Thread.sleep(3000);
		
		QaRobot.ScreenshotMethod("MoreDetails","<b><i>Screenshot for More Details</i></b>");
		
		WebElement WebElement3 = QaBrowser.driver.findElement(By.xpath("//a[@title='Close']"));
		JavascriptExecutor js3 = (JavascriptExecutor) QaBrowser.driver;
		js3.executeScript("arguments[0].click()", WebElement3);
		QaExtentReport.test.log(Status.INFO, "<b><i>Click on MoreDetailsClose</i></b>");
		
		WebElement WebElement4 = QaBrowser.driver.findElement(By.xpath("/html/body/div/form/div[4]/div/div/section/div/div[2]/div[4]/div[1]/div[4]/div[2]/div[7]/div[5]/div[10]/ul/li[2]/a"));
		JavascriptExecutor js4 = (JavascriptExecutor) QaBrowser.driver;
		js4.executeScript("arguments[0].click()", WebElement4);
		QaExtentReport.test.log(Status.INFO, "<b><i>Click on FareBreackup</i></b>");
		Thread.sleep(3000);
		
		QaRobot.ScreenshotMethod("FareBreackup","<b><i>Screenshot for Fare Breackup</i></b>");
		
		WebElement WebElement5 = QaBrowser.driver.findElement(By.xpath("/html/body/div/form/div[4]/div/div/div[15]/div/div/div[1]/button/span"));
		JavascriptExecutor js5 = (JavascriptExecutor) QaBrowser.driver;
		js5.executeScript("arguments[0].click()", WebElement5);
		QaExtentReport.test.log(Status.INFO, "<b><i>Click on FareBreackupClose</i></b>");
		
		QaRobot.ClickOnElement("CheckBox1");
		QaExtentReport.test.log(Status.INFO, "<b><i>Click on CheckBox</i></b>");
		
		QaRobot.ClickOnElement("TermCondition");
		QaExtentReport.test.log(Status.INFO, "<b><i>Click on TermCondition</i></b>");
		
		QaRobot.ScreenshotMethod("FinalBook","<b><i>Screenshot for Final Book</i></b>");
		
		String url = QaBrowser.driver.getCurrentUrl();
		String[] uid = url.split("=");
		QaExtentReport.test.log(Status.INFO, "<b><i>Session id is </i></b>" + uid[1]);
		
		QaRobot.ClickOnElement("FinalBook11");
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
	
	public static void flightHotelApproval() throws Exception
	{
		WebElement WebElement4 = QaBrowser.driver.findElement(By.xpath("/html/body/div/form/div[4]/div/div/section/div/div[2]/div[4]/div[1]/div[4]/div[2]/div[7]/div[3]/div[10]/ul/li/a"));
		JavascriptExecutor js4 = (JavascriptExecutor) QaBrowser.driver;
		js4.executeScript("arguments[0].click()", WebElement4);
		QaExtentReport.test.log(Status.INFO, "<b><i>Click on More Details 1</i></b>");
		Thread.sleep(3000);
		
		QaRobot.ScreenshotMethod("MoreDetails1","<b><i>Screenshot for More Details</i></b>");
		
		WebElement WebElement5 = QaBrowser.driver.findElement(By.xpath("/html/body/div[2]/div/div/a"));
		JavascriptExecutor js5 = (JavascriptExecutor) QaBrowser.driver;
		js5.executeScript("arguments[0].click()", WebElement5);
		Thread.sleep(2000);
		QaExtentReport.test.log(Status.INFO, "<b><i>Click on More Details Close 1</i></b>");
		
		WebElement WebElement6 = QaBrowser.driver.findElement(By.xpath("/html/body/div/form/div[4]/div/div/section/div/div[2]/div[4]/div[1]/div[4]/div[2]/div[7]/div[5]/div[10]/ul/li[1]/a"));
		JavascriptExecutor js6 = (JavascriptExecutor) QaBrowser.driver;
		js6.executeScript("arguments[0].click()", WebElement6);
		QaExtentReport.test.log(Status.INFO, "<b><i>Click on More Details 2</i></b>");
		Thread.sleep(3000);
		
		QaRobot.ScreenshotMethod("MoreDetails2","<b><i>Screenshot for More Details 2</i></b>");
		
		WebElement WebElement7 = QaBrowser.driver.findElement(By.xpath("/html/body/div[2]/div/div/a"));
		JavascriptExecutor js7 = (JavascriptExecutor) QaBrowser.driver;
		js7.executeScript("arguments[0].click()", WebElement7);
		Thread.sleep(2000);
		QaExtentReport.test.log(Status.INFO, "<b><i>Click on More Details Close 2</i></b>");
		
		WebElement WebElement8 = QaBrowser.driver.findElement(By.xpath("/html/body/div/form/div[4]/div/div/section/div/div[2]/div[4]/div[1]/div[4]/div[2]/div[7]/div[5]/div[10]/ul/li[2]/a"));
		JavascriptExecutor js8 = (JavascriptExecutor) QaBrowser.driver;
		js8.executeScript("arguments[0].click()", WebElement8);
		QaExtentReport.test.log(Status.INFO, "<b><i>Click on FareBreackup 1</i></b>");
		Thread.sleep(3000);
		
		QaRobot.ScreenshotMethod("FareBreackup","<b><i>Screenshot for Fare Breackup 1</i></b>");
		
		WebElement WebElement9 = QaBrowser.driver.findElement(By.xpath("/html/body/div/form/div[4]/div/div/div[15]/div/div/div[1]/button/span"));
		JavascriptExecutor js9 = (JavascriptExecutor) QaBrowser.driver;
		js9.executeScript("arguments[0].click()", WebElement9);
		Thread.sleep(2000);
		QaExtentReport.test.log(Status.INFO, "<b><i>Click on FareBreackupClose 1</i></b>");
		
		WebElement WebElement10 = QaBrowser.driver.findElement(By.xpath("/html/body/div/form/div[4]/div/div/section/div/div[2]/div[4]/div[1]/div[4]/div[2]/div[8]/div[4]/ul/li/a"));
		JavascriptExecutor js10 = (JavascriptExecutor) QaBrowser.driver;
		js10.executeScript("arguments[0].click()", WebElement10);
		QaExtentReport.test.log(Status.INFO, "<b><i>Click on FareBreackup 2</i></b>");
		Thread.sleep(3000);
		
		QaRobot.ScreenshotMethod("FareBreackup","<b><i>Screenshot for Fare Breackup 2</i></b>");
		
		WebElement WebElement11 = QaBrowser.driver.findElement(By.xpath("/html/body/div[2]/div/div/a"));
		JavascriptExecutor js11 = (JavascriptExecutor) QaBrowser.driver;
		js11.executeScript("arguments[0].click()", WebElement11);
		Thread.sleep(2000);
		QaExtentReport.test.log(Status.INFO, "<b><i>Click on FareBreackupClose 2</i></b>");
		
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
		
		WebElement DropDown1 = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_ddlFop2']"));
		Select s1 = new Select(DropDown1);
		s1.selectByVisibleText("Bill To Company");
		
		QaRobot.ClickOnElement("Ok1");
		QaExtentReport.test.log(Status.INFO, "<b><i>Click on Ok Button</i></b>");
		
		QaRobot.ClickOnElement("Proceed");
		QaExtentReport.test.log(Status.INFO,"<b><i>Click on Proceed</i></b>");
		
		WebElement getT1 = QaBrowser.driver.findElement(By.xpath("(//html//body//div//span)[70]"));
		String getTxt1 = getT1.getText();
		QaExtentReport.test.log(Status.INFO, "<b><i>Booking Id Is </i></b>"+getTxt1);
		
		QaRobot.ScreenshotMethod("FinalResult","<b><i>Screenshot for Search Page</i></b>");
	}
}
