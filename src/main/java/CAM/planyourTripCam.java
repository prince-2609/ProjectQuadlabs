package CAM;

import org.openqa.selenium.By;

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
public class planyourTripCam
{
	@DataProvider
	public Object[][] getexceldata() throws Exception
	{
		return QaDataProvider.getTestdata("PlanyourtripCam", "Sheet1");
	}

	@Test(dataProvider = "getexceldata")
	public static void Profiling(String Source,String URL,String Comapnycode,String	Username,String	Password,
			String Itinerary,String	Destination,String	Distinationtitle,String	Trip_Startdate,String Trip_Enddate,String	Remarks,
			String Searchtype, String	flightjourneytype, String Flightorigin, String	Flightorigintitle, String flightpolicy, String Flightdepartdate, 
			String FlightReturnDate,String flightremarks,String hotelpolicy, String Checkindate, String	Checkoutdate,
            String hotelremarks,String Nonbookableproduct, String 	Typeofvisa,String	Visa_remarks, String Ins_Nominee_Name, String Ins_Relation) throws Exception {

		TestBase.Companycode(Source,URL); 
		QaRobot.impliwait(30);
		
		QaExtentReport.test = QaExtentReport.report.createTest("Test On Plan your trip");
		//write comapany code
		
		//QaRobot.PassValue("Comapnycode",Comapnycode,"write Comapnycode");
		
		QaRobot.PassValue("User_name",Username);
		QaExtentReport.test.log(Status.INFO,"<b><i>Write Username</i></b>");
			
		QaRobot.PassValue("Password",Password);
		QaExtentReport.test.log(Status.INFO,"<b><i>Write Password</i></b>");
		
		QaRobot.ClickOnElement("Submit");
		QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on submit</i></b>");
		
   QaRobot.ClickOnElement("AddTrip");
		QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on AddTrip</i></b>");
		
		QaRobot.PassValue("Itinerary", Itinerary);
		QaExtentReport.test.log(Status.INFO,"<b><i>Write Itinerary</i></b>");
		Thread.sleep(2000);
		
		TestBase.listofautosuggestion(By.xpath("//DIV[@id='divTripDestinationCity']/p"), Destination, Distinationtitle, 
				By.xpath("//input[@id='txtDestination']"));
		
		Thread.sleep(400);
		
        QaRobot.ClickOnElement("Trip_Startdate"); // calendar
		QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Trip_Startdate</i></b>");
        
        Thread.sleep(4000);
        
//       QaRobot.ClickOnElement("Next_month"); // calendar
//		QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Next_month</i></b>");
        
        Thread.sleep(2000);
        
		QaBrowser.driver.findElement(By.xpath("//a[@title='Select "+Trip_Startdate+"']")).click(); //Trip_Startdate
		
		Thread.sleep(4000);
		
        QaRobot.ClickOnElement("Trip_Enddate"); // calendar
		QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Trip_Enddate</i></b>");
		
		QaBrowser.driver.findElement(By.xpath("//a[@title='Select "+Trip_Enddate+"']")).click(); //Trip_Enddate
			        
		Thread.sleep(100);
		
		QaRobot.PassValue("Remarks", Remarks);
		QaExtentReport.test.log(Status.INFO,"<b><i>Remarks</i></b>");
		Thread.sleep(1000);
		
		QaRobot.ClickOnElement("btncreatetrip");
		QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on btncreatetrip</i></b>");
		Thread.sleep(100);   
		
//		QaRobot.ClickOnElement("Edit");
//		QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Edit</i></b>");
//		Thread.sleep(6000);
		
//		QaRobot.ClickOnElement("More_products");
//		QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on More_products</i></b>");
		
		if(Searchtype.equalsIgnoreCase("Add Flight"))
		{		
			PlaYourTripFlight(flightjourneytype, Flightorigin, Flightorigintitle,  flightpolicy,
					 Flightdepartdate,FlightReturnDate,  flightremarks);
		}
		
		else if(Searchtype.equalsIgnoreCase("Add Flight+Add Hotel"))
			
		{
			PlaYourTripFlight(flightjourneytype, Flightorigin, Flightorigintitle,  flightpolicy,Flightdepartdate,FlightReturnDate,  flightremarks);
			
			PlaYourTripHotel1(hotelpolicy, hotelremarks, Checkindate,Checkoutdate);
		}
		
		else if(Searchtype.equalsIgnoreCase("More Products"))
			{
				PlaYourTripMoreProducts(Nonbookableproduct, Typeofvisa, Visa_remarks, Ins_Nominee_Name,	Ins_Relation);
			}
			
			
		else if(Searchtype.equalsIgnoreCase("Add Hotel"))
		{
			PlaYourTripHotel1(hotelpolicy,hotelremarks, Checkindate,Checkoutdate);
			
		}
      else if(Searchtype.equalsIgnoreCase("Add Flight+Add Hotel+More Products"))
			
		{
			PlaYourTripFlight(flightjourneytype, Flightorigin, Flightorigintitle,  flightpolicy,Flightdepartdate, FlightReturnDate, flightremarks);
			
			PlaYourTripHotel1(hotelpolicy, hotelremarks, Checkindate,Checkoutdate);
			
			PlaYourTripMoreProducts( Nonbookableproduct,  Typeofvisa,  Visa_remarks,
	Ins_Nominee_Name,	Ins_Relation);
			
		}
	
		
		QaRobot.ClickOnElement("sendapproval");
		QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on sendapproval</i></b>");
		Thread.sleep(1000);
		QaRobot.ClickOnElement("btntripapproval");
		QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on btntripapproval</i></b>");
		Thread.sleep(5000);
		
		QaBrowser.driver.switchTo().alert().accept();
		Thread.sleep(20000); 
		
}

	@AfterMethod
	public static void afterMetod() {
		QaExtentReport.test.getExtent().flush();
	}
	
	public static void PlaYourTripFlight( String flightjourneytype,String Flightorigin,String Flightorigintitle, String flightpolicy,
			String Flightdepartdate,String FlightReturnDate, String flightremarks) throws Exception
	{
		QaRobot.ClickOnElement("addflight");
		QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on addflight</i></b>");
		Thread.sleep(5000);
		
		   QaRobot.selectTextFromDropdown("flightjourneytype", flightjourneytype, "Select flightjourneytype");
		    Thread.sleep(2000);
		    
		if(flightjourneytype.equalsIgnoreCase("one way"))
			
		{
			
			TestBase.listofautosuggestion(By.xpath("//DIV[@id='divDepartureCity']/p"), Flightorigin, Flightorigintitle,
					By.xpath("//input[@id='txtflightOrigin']"));
			
			Thread.sleep(1000);
			
			
			 QaRobot.selectTextFromDropdown("Selectflightpolicy", flightpolicy, "Select Selectflightpolicy");
		    Thread.sleep(1000);
			
		    
	          QaRobot.ClickOnElement("Flight_departdate"); // calendar
	          QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Flight_departdate</i></b>");
	          Thread.sleep(4000);
			
//	          QaRobot.ClickOnElement("Nextmonthcalendar"); // next month calendar
//	          QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Nextmonthcalendar</i></b>");
//	          Thread.sleep(4000);
	          
	          QaBrowser.driver.findElement(By.xpath("//a[@title='Select "+Flightdepartdate+"']")).click(); 
	          Thread.sleep(100);
			
		}
		else if(flightjourneytype.equalsIgnoreCase("Round trip"))
		
		{
			TestBase.listofautosuggestion(By.xpath("//DIV[@id='divDepartureCity']/p"), Flightorigin, Flightorigintitle,
					By.xpath("//input[@id='txtflightOrigin']"));
			
			Thread.sleep(1000);
			
			
			 QaRobot.selectTextFromDropdown("Selectflightpolicy", flightpolicy, "Select Selectflightpolicy");
		    Thread.sleep(1000);
			
		    
	          QaRobot.ClickOnElement("Flight_departdate"); // calendar
	          QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Flight_departdate</i></b>");
	          Thread.sleep(4000);
			
//	          QaRobot.ClickOnElement("Nextmonthcalendar"); // next month calendar
//	          QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Nextmonthcalendar</i></b>");
//	          Thread.sleep(4000);
	          
	          QaBrowser.driver.findElement(By.xpath("//a[@title='Select "+Flightdepartdate+"']")).click(); 
	          Thread.sleep(1000);
	          
//	          QaRobot.ClickOnElement("Flight_returndate"); // return date
//	          QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Flight_returndate</i></b>");
	          
	          Thread.sleep(4000); 
	          
	          QaBrowser.driver.findElement(By.xpath("//a[@title='Select "+FlightReturnDate+"']")).click(); 
	          Thread.sleep(1000);
		}
		
          QaRobot.ClickOnElement("Clickoutside");
          QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Clickoutside</i></b>");
  		  Thread.sleep(1000);
  		
		  QaRobot.PassValue("flightremarks", flightremarks);
		  QaExtentReport.test.log(Status.INFO,"<b><i>Write Comapny code</i></b>");
		  Thread.sleep(1000);
		
		QaRobot.ClickOnElement("checkkpolicyflight");
		QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on checkkpolicyflight</i></b>");
		Thread.sleep(2000);
		
		QaRobot.ClickOnElement("Saveflight");
		QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Saveflight</i></b>");
		Thread.sleep(2000);
		
//		QaBrowser.driver.switchTo().alert().accept();
//		Thread.sleep(100);
		
	}
	public static void PlaYourTripHotel1(String hotelpolicy, String hotelremarks,String Checkindate, String	Checkoutdate)
			throws Exception
	{
	 QaRobot.ClickOnElement("AddHotel");
	 QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on AddHotel</i></b>");
     Thread.sleep(2000);

     QaRobot.selectTextFromDropdown("Selecthotelpolicy", hotelpolicy, "Select Selecthotelpolicy");
     
     Thread.sleep(1000);
     
     QaRobot.ClickOnElement("HotelCheckIn"); // HotelCheckIn
     QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on HotelCheckIn</i></b>");
     Thread.sleep(4000);
	
    QaBrowser.driver.findElement(By.xpath("//a[@title='Select "+Checkindate+"']")).click(); 
     Thread.sleep(1000);

     QaRobot.ClickOnElement("HotelCheckout"); // HotelCheckout
     QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on HotelCheckout</i></b>");
     Thread.sleep(4000);
	
    QaBrowser.driver.findElement(By.xpath("//a[@title='Select "+Checkoutdate+"']")).click(); 
     Thread.sleep(1000);
     
     QaRobot.PassValue("hotelremarks",hotelremarks);
     QaExtentReport.test.log(Status.INFO,"<b><i>hotelremarks</i></b>");
     Thread.sleep(100);
    
     QaRobot.ClickOnElement("checkkpolicyhotel");
     QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on checkkpolicyhotel</i></b>");
     Thread.sleep(100);
     
     QaRobot.ClickOnElement("savehotel");
     QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on savehotel</i></b>");
     Thread.sleep(100);
	}
	public static void PlaYourTripMoreProducts(String Nonbookableproduct, String Typeofvisa, String Visa_remarks,
			String Ins_Nominee_Name,String	Ins_Relation) throws Exception
			{
		QaRobot.ClickOnElement("More_products");
		QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on More_products</i></b>");
	     Thread.sleep(2000);
	     
	     if(Nonbookableproduct.equalsIgnoreCase("Visa"))
			{		
	    	 QaRobot.ClickOnElement("Vsa"); // Visa
	    	 QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Vsa</i></b>");
	    	 
	    	 QaRobot.selectTextFromDropdown("Typeofvisa", Typeofvisa, "Typeofvisa");
	    	 
	    	 QaRobot.PassValue("Visa_remarks", Visa_remarks);
	    	 QaExtentReport.test.log(Status.INFO,"<b><i>Write Visa_remarks</i></b>");
	    	 
	    	 QaRobot.ClickOnElement("btnsaveVisa"); // Save visa
	    	 QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on btnsaveVisa</i></b>");
	    	 
	    	 
			}
	     
	     else if(Nonbookableproduct.equalsIgnoreCase("Insurance"))
	     {
	    	 QaRobot.ClickOnElement("Ins"); // Insurance 
	    	 QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Ins</i></b>");
	 		Thread.sleep(1000);
	    	 QaRobot.PassValue("Ins_Nominee_Name",Ins_Nominee_Name);
	    	 QaExtentReport.test.log(Status.INFO,"<b><i>Write Ins_Nominee_Name</i></b>");
	    	Thread.sleep(1000);
	    	 QaRobot.PassValue("Ins_Relation",Ins_Relation);
	    	 QaExtentReport.test.log(Status.INFO,"<b><i>Write Ins_Relation</i></b>");
	    	 
	    	
	    	 QaRobot.ClickOnElement("Save_Insurance"); // Insurance
	    	 QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Save_Insurance</i></b>");
	    	 
	     }
	     
	     else if(Nonbookableproduct.equalsIgnoreCase("Visa+Insurance"))
	     {
	    	 QaRobot.ClickOnElement("Vsa");
	    	 QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Vsa</i></b>");
	    	 
              QaRobot.selectTextFromDropdown("Typeofvisa", Typeofvisa, "Typeofvisa");
	    	 
	    	 QaRobot.PassValue("Visa_remarks", Visa_remarks);
	    	 QaExtentReport.test.log(Status.INFO,"<b><i>Write Visa_remarks</i></b>");
	    	 Thread.sleep(2000);
	    	 
	    	 QaRobot.ClickOnElement("btnsaveVisa"); // Save visa
	    	 QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on btnsaveVisa</i></b>");
	    	 Thread.sleep(2000);
	    	 
	    	 QaRobot.ClickOnElement("More_products");
	    	 QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on More_products</i></b>");
	    	 Thread.sleep(3000);
	    	 
	    	 QaRobot.ClickOnElement("Ins"); //Add Insurance 
	    	 QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Ins</i></b>");
	    	 Thread.sleep(2000);
	    	 
	    	    QaRobot.PassValue("Ins_Nominee_Name",Ins_Nominee_Name);
	    	    QaExtentReport.test.log(Status.INFO,"<b><i>Write Ins_Nominee_Name</i></b>");
	    	    Thread.sleep(2000);
	    	    
		    	 QaRobot.PassValue("Ins_Relation",Ins_Relation);
		    	 QaExtentReport.test.log(Status.INFO,"<b><i>Write Ins_Relation</i></b>");
		    	 
		    	
		    	 QaRobot.ClickOnElement("Save_Insurance"); // save Insurance
		    	 QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Save_Insurance</i></b>");
	    	 
	    	 
	     }
	     
			}
			}
				


