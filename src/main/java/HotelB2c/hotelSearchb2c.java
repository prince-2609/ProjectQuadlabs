package HotelB2c;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Base.TestBase;
import TestScript.RoundTrip.Flightcheck;
import utilities.Logger;
import utilities.QaBrowser;
import utilities.QaDataProvider;
import utilities.QaExcelRead;
import utilities.QaExtentReport;
import utilities.QaRobot;

public class hotelSearchb2c extends Flightcheck {
	TestBase t;
	QaExcelRead reader;
	@DataProvider
	public Object[][] getexceldata() throws Exception {

		return QaDataProvider.getTestdata("Hotelsearch","Sheet1");
	}
	
	@Test(dataProvider = "getexceldata")

	public static void Hotelroom1(String ccode, String URL, String username, String password, String city, String Hcity, String sdate, String edate,String Adult,String selectRommIndex, String title, String firstname,
			String lastname, String phone,String Ctype, String Ccnumber, String Chname, String mm, String yyyy,String Securitycode,  String Btitle, String Bfirstname, String Blastname, String Baddress, String Bcity,String Btcity, String emailid) throws Exception {
		 
		QaExtentReport.test = QaExtentReport.report.createTest("Hotel Booking for B2C Users");

		TestBase.Companycode(ccode, URL);
		
		QaBrowser.driver.findElement(By.xpath("//a[@class='hm_tb_hotel']")).click(); // Hotels
		
		TestBase.listofautosuggestion(By.xpath("//DIV[@id='divHTCity']/p"), city, Hcity,
				By.xpath("//input[@id='txtHTCity']"));
		
		Thread.sleep(2000);
		
		QaRobot.ClickOnElement("Hotel_depart_date","Clicked on Hotel Departure"); // calender
		
		QaRobot.ClickOnElement("Calender_next_month","Clicked on next month");
		
		QaBrowser.driver.findElement(By.xpath("//a[@id='id"+sdate+"']")).click(); //sdate
		
		Thread.sleep(100);
		
		QaRobot.ClickOnElement("Hotel_end_date","Clicked on end date"); // calender
		
		QaBrowser.driver.findElement(By.xpath("//a[@id='id"+edate+"']")).click(); //edate
			        
		Thread.sleep(100);
		
		QaRobot.selectValueFromDropdown("flight_adult", Adult, "click on Adult"); 
		
		Thread.sleep(100);
		
		QaBrowser.driver.findElement(By.xpath("(//a[@class='btn btn-primary btn-block'])[3]")).click(); //Search
		
		QaRobot.explicitwaitinvisible(300,By.xpath("//div[@class='loadbar ld_hotel']")); //Loader
		
		QaBrowser.driver.findElement(By.xpath("//p[@id='htlrm0"+selectRommIndex+"']")).click(); //selectRoom
		
		Thread.sleep(100);
		
		QaRobot.ClickOnElement("Prices_and_taxes","Clicked on Prices and taxes"); // Prices and taxes
		
		Thread.sleep(1000);
		
		String Pricesandtaxes = Logger.takeScreenshot(QaBrowser.driver, "D:\\prices and taxes page");
		QaExtentReport.test.log(Status.INFO, "Screenshot for Pricesandtaxes"+Pricesandtaxes+"");
		
		QaRobot.ClickOnElement("Close","Clicked on close");
		
		Thread.sleep(100);
			
		QaRobot.ClickOnElement("Room_Book","Clicked on Book");
		
		Thread.sleep(5000);
		
		 QaRobot.PassValue("email_address",emailid,"Write emailid");
		
		QaRobot.selectValueFromDropdown("adult_title",title,"click on title"); 
		
		Thread.sleep(100);
		
		QaRobot.ClickOnElement("adult_First_name","Clicked on firstname"); //firstname
		
		//QaRobot.getWebElement("adult_First_name").getText();
		
		QaRobot.PassValue("adult_First_name",firstname,"Write firstname");
		
	     Thread.sleep(100);
		
        QaRobot.ClickOnElement("adult_last_name","Clicked on lastname"); //lasttname
        
        QaRobot.PassValue("adult_last_name",lastname,"Write lasttname");
        
        Thread.sleep(100);
        

        QaRobot.PassValue("Phone_number",phone,"Write phonenumber");
        
        Thread.sleep(100);
     
        QaRobot.selectTextFromDropdown("Card_type",Ctype,"click on card type"); //Cardtype
        
        Thread.sleep(100);
        
        QaRobot.PassValue("Credit_card_number",Ccnumber,"Write Credit card number");
	
        Thread.sleep(100);
        
        QaRobot.PassValue("Credit_card_name",Chname,"Write Credit card name");
        
        Thread.sleep(100);
        
        QaRobot.PassValue("MM",mm,"Write M M");
       
        Thread.sleep(100);
        
        QaRobot.PassValue("YYYY",yyyy,"Write Y Y Y Y");
        
        Thread.sleep(100);
       
        QaRobot.PassValue("CVV",Securitycode,"Write Security code");
        
        Thread.sleep(100);
        
        QaRobot.selectValueFromDropdown("B_adult_title",Btitle,"click on Btitle"); 
        
        Thread.sleep(100);
        
        QaRobot.PassValue("B_first_name",Bfirstname,"Write first name");
        
        Thread.sleep(100);
        
        QaRobot.PassValue("B_last_name",Blastname,"Write Last name");
        
        Thread.sleep(100);
        
        QaRobot.PassValue("B_address",Baddress,"Write address");
        
        Thread.sleep(100);
        
        TestBase.listofautosuggestion(By.xpath("//DIV[@id='divHTCity']/p"), Bcity, Btcity,
				By.xpath("//input[@id='ctl00_contentMain_payeeCity']")); 
        
        Thread.sleep(200);
        
        QaRobot.ClickOnElement("Terms_conditions","Clicked on terms&conditions"); //terms&conditions
        
        QaRobot.ClickOnElement("Confirm","Clicked on confirm");
        
        Thread.sleep(12000);
        
        //QaRobot.ClickOnElement("Send_Enquiry","Clicked on SendEnquiry");
        //Thread.sleep(200);
        
        String confirmationpage = Logger.takeScreenshot(QaBrowser.driver, "D:\\confirmationpage");
		QaExtentReport.test.log(Status.INFO, "Screenshot for connfirmpage"+confirmationpage+"");
      
		QaRobot.ClickOnElement("Check_Homepage","Clicked on logo");
        Thread.sleep(200);
		
	}
	@AfterMethod
	public static void afterMetod()
	{
		QaExtentReport.test.getExtent().flush();
	}
}

