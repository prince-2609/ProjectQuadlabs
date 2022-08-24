package CAM;

import org.openqa.selenium.Alert;
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
public class otherMiscFunctionality{

	@DataProvider
	public Object[][] getexceldata() throws Exception 
	{
		return QaDataProvider.getTestdata("otherMiscFunctionality", "Sheet1");
	}
	
	@Test(dataProvider = "getexceldata")
	
	public static void Profiling(String Source,String URL,String Comapnycode,String	Username,String	Password, String Title_Hotel, 
			String Supplier_name, String code, String Code_value, String validfrom, String	validtill, String Title, String	Enter_URL,
			String Display_Message, String Visible,String Lowest_Logical_Fare, String DomFromTimeHH, String
		DomFromTimeMM, String	DomFromBufferMM, String DomReturnTimeHH, String	DomReturnTimeMM, String	DomBufferTimeMM, 
		String IntFromTimeHH,String IntFromTimeMM, String IntFromBufferMM, String IntReturnTimeHH, String IntReturnTimeMM, 
		String IntBufferTimeMM, String Travel_Ban_Rules_Title, String Branch_Name, String Rule_applied_on, String Checkbox) throws Exception {

     
		TestBase.Companycode(Source,URL); 
		QaRobot.impliwait(30);
		
		QaExtentReport.test = QaExtentReport.report.createTest("Test on Other Misc Functionality");
		//write comapany code
		
		//QaRobot.PassValue("Comapnycode",Comapnycode,"write Comapnycode");
		
		QaRobot.PassValue("User_name",Username);
		QaExtentReport.test.log(Status.INFO,"<b><i>Write Username</i></b>");
		
		QaRobot.PassValue("Password",Password);
		QaExtentReport.test.log(Status.INFO, "<b><i>Write Password</i></b>");
		
		QaRobot.ClickOnElement("Submit");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on submit</i></b>");
		
		QaRobot.mouseHover("//a[@id='HeaderTop_aSetting']","//span[@id='HeaderTop_lblComapnayManagement']");
		
		QaRobot.ClickOnElement("Managehotelpromocode");
		QaExtentReport.test.log(Status.INFO, "<b><i>Add Managehotelpromocode</i></b>");
		
		QaRobot.ClickOnElement("Promocode_addhotel");
		QaExtentReport.test.log(Status.INFO, "<b><i>Add Promocode_addhotel</i></b>");
		
		QaRobot.PassValue("Promocode_title", Title_Hotel);
		QaExtentReport.test.log(Status.INFO, "<b><i>Write Promocode_title</i></b>");
		
     	QaRobot.ClickOnElement("Promocode_btnAddSupplier");
		QaExtentReport.test.log(Status.INFO, "<b><i>Add Promocode_btnAddSupplier</i></b>");
		
		QaRobot.PassValue("Write_supplier",Supplier_name);
		QaExtentReport.test.log(Status.INFO, "<b><i>Supplier_name</i></b>");
		
		QaRobot.ClickOnElement("Click_supplier");
		QaExtentReport.test.log(Status.INFO, "<b><i>Click supplier</i></b>");
		
		QaRobot.ClickOnElement("Add_supplier");
		QaExtentReport.test.log(Status.INFO, "<b><i>Add supplier</i></b>");
		
    	QaRobot.ClickOnElement("Select_close");
		QaExtentReport.test.log(Status.INFO, "<b><i>Select and close</i></b>");
		
		QaRobot.selectTextFromDropdown("Promocode", code, "Promocode");
		
		QaRobot.PassValue("Promocode_value", Code_value);
		QaExtentReport.test.log(Status.INFO, "<b><i>Promocode_value</i></b>");
		
		QaRobot.ClickOnElement("Promocode_validfrom");
		QaExtentReport.test.log(Status.INFO, "<b><i>Promocode_validfrom</i></b>");
		
		QaBrowser.driver.findElement(By.xpath("//input[@value='"+validfrom+"']")).click(); //validfrom
		
		QaRobot.ClickOnElement("Promocode_validTill");
		QaExtentReport.test.log(Status.INFO, "<b><i>Promocode_validTill</i></b>");
		
		QaBrowser.driver.findElement(By.xpath("//input[@value='"+validtill+"']")).click(); //validtill
		
		QaRobot.ClickOnElement("chkbxSalesChanel");
		QaExtentReport.test.log(Status.INFO, "<b><i>chkbx Corporate SBT</i></b>");
		
		QaRobot.ClickOnElement("chkbxSalesChanel_1");
		QaExtentReport.test.log(Status.INFO, "<b><i>chkbx Corporate (BOCA)</i></b>");
		
		QaRobot.ClickOnElement("Promocode_save");
		QaExtentReport.test.log(Status.INFO, "<b><i>click save</i></b>");
		
		Alert alt = QaBrowser.driver.switchTo().alert();
		alt.accept();
		
		QaRobot.ClickOnElement("Close_Promocode"); // managethirdpartylink
		QaExtentReport.test.log(Status.INFO, "<b><i>Click on Close Promocode</i></b>");
		
     	QaRobot.ClickOnElement("Managethirdpartylink"); // managethirdpartylink
		QaExtentReport.test.log(Status.INFO, "<b><i>Add Managethirdpartylink</i></b>");
		
		QaRobot.ClickOnElement("SelectService");
		QaExtentReport.test.log(Status.INFO, "<b><i>Click on Select Service</i></b>");
		
     	QaRobot.PassValue("Thirdpartylink_title",Title);
		QaExtentReport.test.log(Status.INFO, "<b><i>Write Title</i></b>");
		
     	QaRobot.PassValue("Thirdparty_url", Enter_URL);
		QaExtentReport.test.log(Status.INFO, "<b><i>Write Thirdparty_url</i></b>");
		
     	QaRobot.PassValue("Thirdparty_textarea", Display_Message);
		QaExtentReport.test.log(Status.INFO, "<b><i>Write Thirdparty_textarea</i></b>");
     	
     	if (Visible.equalsIgnoreCase("Admin"))
     	
     	{
     		QaRobot.ClickOnElement("Employee_checkbox");
		QaExtentReport.test.log(Status.INFO, "<b><i>Employee_checkbox</i></b>");
     		
     	}
     	
     	else if (Visible.equalsIgnoreCase("Employee"))
     	{
     		QaRobot.ClickOnElement("Admin_checkbox");
		QaExtentReport.test.log(Status.INFO, "<b><i>Check Admin_checkbox</i></b>");
     	}
     	else if (Visible.equalsIgnoreCase("Admin+Employee"))
     	{
     	
     	}
     	
     	
     	QaRobot.ClickOnElement("Add_Thirdpartylink");
		QaExtentReport.test.log(Status.INFO, "<b><i>Add_Thirdpartylink</i></b>");
		
		QaRobot.mouseHover("//a[@id='HeaderTop_aSetting']","//span[@id='HeaderTop_lblComapnayManagement']");
		
		QaRobot.ClickOnElement("ManageLogicalFare");
		QaExtentReport.test.log(Status.INFO, "<b><i>Add ManageLogicalFare</i></b>");
		
		if(Lowest_Logical_Fare.equalsIgnoreCase("As per travel policy"))
		{		
			QaRobot.ClickOnElement("AsPerTravelPolicy");
		QaExtentReport.test.log(Status.INFO, "<b><i>Lowest_Logical_Fare</i></b>");
		}
		
		else if(Lowest_Logical_Fare.equalsIgnoreCase("As per preferred Flight timing"))
			
		{
			QaRobot.ClickOnElement("chkPreferredFlightTiming");
		QaExtentReport.test.log(Status.INFO, "<b><i>chkPreferredFlightTiming</i></b>");
		
			QaRobot.ClickOnElement("Check_domestic");
		QaExtentReport.test.log(Status.INFO, "<b><i>Check_domestic</i></b>");
		
			QaRobot.selectTextFromDropdown("From_Domestic_Preferred_HH", DomFromTimeHH, "From_Domestic_Preferred_HH");
		
			QaRobot.selectTextFromDropdown("From_Domestic_Preferred_MM", DomFromTimeMM, "From_Domestic_Preferred_MM");
		
			QaRobot.selectTextFromDropdown("From_Domestic_Buffer_HH", DomFromBufferMM, "From_Domestic_Buffer_HH");
		
			QaRobot.selectTextFromDropdown("Return_Domestic_Preferred_HH", DomReturnTimeHH, "Return_Domestic_Preferred_HH");
		
		QaRobot.selectTextFromDropdown("Return_Domestic_Preferred_MM", DomReturnTimeMM, "Return_Domestic_Preferred_MM");
		
			QaRobot.selectTextFromDropdown("Return_Domestic_Buffer_MM", DomBufferTimeMM, "Return_Domestic_Buffer_MM");
		
			QaRobot.ClickOnElement("Check_International");
		QaExtentReport.test.log(Status.INFO, "<b><i>Check_International</i></b>");
		
			QaRobot.selectTextFromDropdown("From_International_Preferred_HH", IntFromTimeHH, "From_International_Preferred_HH");
		
			QaRobot.selectTextFromDropdown("From_International_Preferred_MM", IntFromTimeMM, "From_International_Preferred_MM");
		
			QaRobot.selectTextFromDropdown("From_International_Buffer_HH", IntFromBufferMM, "From_International_Buffer_HH");
		
			QaRobot.selectTextFromDropdown("Return_International_Preferred_HH", IntReturnTimeHH, "Return_International_HH");
		
	        QaRobot.selectTextFromDropdown("Return_International_Preferred_MM", IntReturnTimeMM, "Return_International_MM");

		    QaRobot.selectTextFromDropdown("Return_International_Buffer_HH", IntBufferTimeMM, "Return_International_Buffer_HH");
		}
		
		
		
	QaRobot.ClickOnElement("Save_Logical_Fare");
		QaExtentReport.test.log(Status.INFO, "<b><i>Save_Logical_Fare</i></b>");
		
	QaRobot.ClickOnElement("Close_Logical_Fare");
		QaExtentReport.test.log(Status.INFO, "<b><i>Close_Logical_Fare</i></b>");
	
		QaRobot.ClickOnElement("Travel_ban_rules");
		QaExtentReport.test.log(Status.INFO, "<b><i>Travel_ban_rules</i></b>");
		
		QaRobot.ClickOnElement("Add_travel_ban");
		QaExtentReport.test.log(Status.INFO, "<b><i>Add_travel_ban</i></b>");
		
		QaRobot.PassValue("TravelBanRuleName",Travel_Ban_Rules_Title);
		QaExtentReport.test.log(Status.INFO, "<b><i>Write TravelBanRuleName</i></b>");
		
		QaRobot.selectTextFromDropdown("TravelBanRuleName_Branch_Name", Branch_Name, "TravelBanRuleName_Branch_Name");
		Thread.sleep(5000);
		
		QaRobot.selectTextFromDropdown("TravelBanRuleName_applied_on", Rule_applied_on, "TravelBanRuleName_applied_on");
		
		Thread.sleep(5000);
		
		QaRobot.ClickOnElement("Rule_add_all");
		QaExtentReport.test.log(Status.INFO, "<b><i>Rule_add_all</i></b>");
		Thread.sleep(3000);
		
		if(Checkbox.equalsIgnoreCase("Search Panel"))
			{		
				QaRobot.ClickOnElement("chkSearchPanel");
				QaExtentReport.test.log(Status.INFO, "<b><i>chkSearchPanel</i></b>");
				Thread.sleep(500);
			}
			
	 else if(Checkbox.equalsIgnoreCase("Plan Your Trip"))
				
			{
		 QaRobot.ClickOnElement("chkPYT");
		 QaExtentReport.test.log(Status.INFO, "<b><i>chkPYT</i></b>");
		 Thread.sleep(500);	
			}
		
		QaRobot.ClickOnElement("Save_Travelbanrules");
		QaExtentReport.test.log(Status.INFO, "<b><i>Save_Travelbanrules</i></b>");
		
		QaRobot.ClickOnElement("Close_Predefined_reasons");
	 QaExtentReport.test.log(Status.INFO,"<b><i>Close button</i></b>");
		
	}
	
		
	
	@AfterMethod
	public static void afterMetod() 
	{
		QaExtentReport.test.getExtent().flush();
	}
	
	}