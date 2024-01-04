package Old_CAM_Code;

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
public class manageTravellers
{
	@DataProvider
	public Object[][] getexceldata() throws Exception 
	{
		return QaDataProvider.getTestdata("ManagetravellersCAM", "Sheet6");
	}

	@Test(dataProvider = "getexceldata")
	public static void Profiling(String Source, String URL, String Comapnycode,String Username, 
            String Password, String  Title, String Tfirstname, String Tlastname, String Year,
            String Month,String DOBDate, String user, String Email, String BranchName, String Language,String Country_Of_Residence,String Mobile_No_country, String Mobile_No, String HA_state,String HA_city, String HA_Citytitle, String BA_state,String BA_city, String BA_Citytitle, String Mobilecountry, 
            String mobilenumber , String Passportno, String    DOBYear,String DOBmonth, String    DOB_Date, String Placeofissue, String Placeofissuetitle, String Validfrom, String Expiryyear, String Expirydate, String Visanumber, 
            String Countryofvisa, String issuedate, String Dateofexpiryyear, String Dateofexpirydate, 
            String Dtitle, String    Dfirstname, String     Dlastname, String    Gender, String Dependent_year, 
            String Dependent_date, String Relation, String DependentCountryCode, 
            String Dependentnumber, String DependentPassportno, String    DependentNationality, String PassportIssuingcountry, 
            String    PassportPlaceofissue, String PassportPlaceofissuetitle, String PassportYear, String Passportdate,
            String DependentVisa_Number, String    DependentVisa_Country, String    DependentVisa_startyear, String    DependentVisa_startdate, 
            String    DependentVisa_Endyear, String    DependentVisa_EndDate,String TravelCategory12,String TotalApprover12,
            String IPLevel1,String IPLevel1Title,String OPLevel1,String OPLevel1Title,
            String IPLevel2,String IPLevel2Title,String  OPLevel2,String OPLevel2Title,
            String IPLevel3,String IPLevel3Title,String OPLevel3, String OPLevel3Title,String Delegation,String LeaveStartDate,String LeaveEndDate,
            String DelegatedEmail,String DelegatedEmailName,String OldPassword,String NewPassword,String ConfirmNewPassword) throws Exception {

		TestBase.Companycode(Source,URL); 
		QaRobot.impliwait(30);
		
		QaExtentReport.test = QaExtentReport.report.createTest("Test on Manage Travellers");

    QaRobot.PassValue("User_name",Username);
    QaExtentReport.test.log(Status.INFO,"<b><i>Write Username</i></b>");

    QaRobot.PassValue("Password",Password);
    QaExtentReport.test.log(Status.INFO,"<b><i>Write Password</i></b>");

    QaRobot.ClickOnElement("Submit");
    QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on submit</i></b>");

    Thread.sleep(1000);
    QaRobot.mouseHover("//a[@id='HeaderTop_aSetting']","//span[@id='HeaderTop_lblUserManagement']");

    
    //Create traveller

//    QaRobot.ClickOnElement("C_travellers");
//    QaExtentReport.test.log(Status.INFO,"<b><i>clicked on new travellers</i></b>");
//    
//    QaRobot.selectValueFromDropdown("T_title", Title, "click on T_title");
//    
//    QaRobot.PassValue("T_f_name", Tfirstname);
//    QaExtentReport.test.log(Status.INFO,"<b><i>Write First name</i></b>");
//    
//    QaRobot.PassValue("T_L_name", Tlastname);
//    QaExtentReport.test.log(Status.INFO,"<b><i>Write lastname</i></b>");
//    
//    QaRobot.PassValue("U_name", user);
//    QaExtentReport.test.log(Status.INFO,"<b><i>Write U_name</i></b>");
//    
//    QaRobot.PassValue("Email", Email);
//    QaExtentReport.test.log(Status.INFO,"<b><i>Write Email</i></b>");
//    
//    QaRobot.selectTextFromDropdown("Branchname", BranchName , "click on Branchname");
//    
//    QaRobot.selectTextFromDropdown("Language", Language, "Select Language");
//    
//QaRobot.selectTextFromDropdown("Country_Of_Residence", Country_Of_Residence, "Select Country_Of_Residence");
//    
//    
//QaRobot.selectTextFromDropdown("Mobile_No_country", Mobile_No_country, "Select Mobile_No_country");
//
//QaRobot.PassValue("Mobile_No", Mobile_No);
//QaExtentReport.test.log(Status.INFO,"<b><i>Select Mobile_No</i></b>");
//    
//QaRobot.ClickOnElement("Approvexp");
//QaExtentReport.test.log(Status.INFO,"<b><i>clicked on Approvexp</i></b>");
//
//QaRobot.ClickOnElement("checkout");
//QaExtentReport.test.log(Status.INFO,"<b><i>clicked on checkout</i></b>");
//
//QaRobot.ClickOnElement("Allow_live_access");
//QaExtentReport.test.log(Status.INFO,"<b><i>clicked on Allow_live_access</i></b>");
//
//QaRobot.ClickOnElement("Check_acknowledgement");
//QaExtentReport.test.log(Status.INFO,"<b><i>clicked on Check_acknowledgement</i></b>");
//
//QaRobot.ClickOnElement("Check_okay");
//QaExtentReport.test.log(Status.INFO,"<b><i>clicked on Check_okay</i></b>");
//
//QaRobot.ClickOnElement("btn_save"); 
//QaExtentReport.test.log(Status.INFO,"<b><i>clicked on btn_save</i></b>");
//Thread.sleep(2000);
//
//QaRobot.ClickOnElement("C_user"); // clicked on created user
//QaExtentReport.test.log(Status.INFO,"<b><i>clicked on Created user</i></b>");
//
//Thread.sleep(100);    
//
//QaRobot.ClickOnElement("P_details"); //passport details
//QaExtentReport.test.log(Status.INFO,"<b><i>clicked on Passport details</i></b>");
//
//QaRobot.ClickOnElement("add_passport"); //add passport details
//QaExtentReport.test.log(Status.INFO,"<b><i>clicked on add_passport</i></b>");
//
//Thread.sleep(100);
//QaRobot.PassValue("Passportno",Passportno);
//QaExtentReport.test.log(Status.INFO,"<b><i>clicked on Passportno</i></b>");
//Thread.sleep(100);
//
//QaRobot.ClickOnElement("DOB");
//QaExtentReport.test.log(Status.INFO,"<b><i>Click on DOB</i></b>");
//
//Thread.sleep(2000);
//QaRobot.selectTextFromDropdown("DOBYear", DOBYear, "Selected year");
//
//QaRobot.selectTextFromDropdown("DOBmonth",DOBmonth,"Slected month");
//
//QaBrowser.driver.findElement(By.xpath("//a[text()='"+DOB_Date+"']")).click();
//
//Thread.sleep(2000);
//TestBase.listofautosuggestion(By.xpath("//div[@id='divCityPassport']/p"), Placeofissue, Placeofissuetitle,
//        By.xpath("//input[@id='txtSearchCity']"));
//Thread.sleep(2000);
//
//QaRobot.ClickOnElement("Validfrom");
//QaExtentReport.test.log(Status.INFO,"<b><i>Click on Validfrom</i></b>");
//
//Thread.sleep(100);
//
//QaBrowser.driver.findElement(By.xpath("//a[text()='"+Validfrom+"']")).click();
//
//Thread.sleep(100);
//
//QaRobot.ClickOnElement("Expiry");
//QaExtentReport.test.log(Status.INFO,"<b><i>Click on Expiry</i></b>");
//
//Thread.sleep(2000);
//
//QaRobot.selectTextFromDropdown("Expiry_year",Expiryyear,"Slected year");
//
//Thread.sleep(200);
//
//QaBrowser.driver.findElement(By.xpath("//a[text()='"+Expirydate+"']")).click();
//
//QaRobot.ClickOnElement("Primary_checkbox");
//QaExtentReport.test.log(Status.INFO,"<b><i>click on Primary_checkbox</i></b>");
//
//QaRobot.ClickOnElement("Add_btn");
//QaExtentReport.test.log(Status.INFO,"<b><i>Click on btn</i></b>");
//
////QaRobot.ClickOnElement("Close_btn1");
////QaExtentReport.test.log(Status.INFO,"<b><i>Click on btn</i></b>");
//
//QaRobot.ClickOnElement("Visadetails"); // Visa Details
//QaExtentReport.test.log(Status.INFO,"<b><i>Click on Visadetails</i></b>");
//
//QaRobot.ClickOnElement("Add_btn");
//QaExtentReport.test.log(Status.INFO,"<b><i>Click on btn</i></b>");
//Thread.sleep(100);
//
//QaRobot.PassValue("Visanumber", Visanumber);
//QaExtentReport.test.log(Status.INFO,"<b><i>Write Visanumber</i></b>");
//
//Thread.sleep(100);
//
//QaRobot.selectTextFromDropdown("Cntryofvisa",Countryofvisa,"Write Cntryofvisa");
//
//Thread.sleep(100);
//
//QaRobot.ClickOnElement("Dateofissue");
//QaExtentReport.test.log(Status.INFO,"<b><i>Click on Dateofissue</i></b>");
//Thread.sleep(100);
//
//QaRobot.ClickOnElement("Previous_month");
//QaExtentReport.test.log(Status.INFO,"<b><i>Click on Previous_month</i></b>");
//Thread.sleep(100);
//
//QaBrowser.driver.findElement(By.xpath("//a[text()='"+issuedate+"']")).click();
//
//Thread.sleep(100);
//
//QaRobot.ClickOnElement("Dateofissue");
//QaExtentReport.test.log(Status.INFO,"<b><i>Click on Dateofissue</i></b>");
//Thread.sleep(100);
//
//QaRobot.ClickOnElement("Dateofexpiry");
//QaExtentReport.test.log(Status.INFO,"<b><i>Click on Dateofexpiry</i></b>");
//Thread.sleep(2000); 
//
//QaRobot.selectTextFromDropdown("Dateofexpiryyear",Dateofexpiryyear,"Slected Dateofexpiryyear");
//
//Thread.sleep(200);
//
//QaBrowser.driver.findElement(By.xpath("//a[text()='"+Dateofexpirydate+"']")).click();
//
//Thread.sleep(200);
//
//QaRobot.ClickOnElement("Addbutton");
//QaExtentReport.test.log(Status.INFO,"<b><i>Click on Add_btn</i></b>");
  
QaRobot.ClickOnElement("ApproverDelegationDetails");
QaExtentReport.test.log(Status.INFO,"<b><i>Click on Approver Delegation Details</i></b>");

WebElement DropDown = QaBrowser.driver.findElement(By.xpath("//select[@id='ddltravelcategory']"));
Select s = new Select(DropDown);
s.selectByVisibleText(TravelCategory12);
Thread.sleep(2000);

WebElement DropDown1 = QaBrowser.driver.findElement(By.xpath("//select[@id='ddlApproverLevel']"));
Select s1 = new Select(DropDown1);
s1.selectByVisibleText(TotalApprover12);
Thread.sleep(2000);

if (TotalApprover12.equalsIgnoreCase("1")) 
{
	TestBase.listofautosuggestion(By.xpath("//div[@id='divInPolicyApprover1']/p"), IPLevel1, IPLevel1Title,
			By.xpath("/html/body/form/div[9]/div/div/div/div[2]/div[2]/div[2]/ul/li[2]/div/div/div[2]/div/div/input[1]"));
	QaBrowser.driver.findElement(By.xpath("//div[@id='divInPolicyApprover1']/p")).click();
	Thread.sleep(2000);
	
	TestBase.listofautosuggestion(By.xpath("//div[@id='divOutPolicyApprover1']/p"), OPLevel1, OPLevel1Title,
			By.xpath("/html/body/form/div[9]/div/div/div/div[2]/div[2]/div[2]/ul/li[3]/div/div/div[2]/div/div/input[1]"));
	QaBrowser.driver.findElement(By.xpath("//div[@id='divOutPolicyApprover1']/p")).click();
	Thread.sleep(2000);
}
else if (TotalApprover12.equalsIgnoreCase("2"))
{
	TestBase.listofautosuggestion(By.xpath("//div[@id='divInPolicyApprover1']/p"), IPLevel1, IPLevel1Title,
			By.xpath("/html/body/form/div[9]/div/div/div/div[2]/div[2]/div[2]/ul/li[2]/div/div/div[2]/div/div/input[1]"));
	QaBrowser.driver.findElement(By.xpath("//div[@id='divInPolicyApprover1']/p")).click();
	Thread.sleep(2000);
	
	TestBase.listofautosuggestion(By.xpath("//div[@id='divOutPolicyApprover1']/p"), OPLevel1, OPLevel1Title,
			By.xpath("/html/body/form/div[9]/div/div/div/div[2]/div[2]/div[2]/ul/li[3]/div/div/div[2]/div/div/input[1]"));
	QaBrowser.driver.findElement(By.xpath("//div[@id='divOutPolicyApprover1']/p")).click();
	Thread.sleep(2000);
	
	TestBase.listofautosuggestion(By.xpath("//div[@id='divInPolicyApprover2']/p"), IPLevel2, IPLevel2Title,
			By.xpath("/html/body/form/div[9]/div/div/div/div[2]/div[2]/div[2]/ul/li[2]/div/div/div[3]/div/div/input[1]"));
	QaBrowser.driver.findElement(By.xpath("//div[@id='divInPolicyApprover2']/p")).click();
	Thread.sleep(2000);
	
	TestBase.listofautosuggestion(By.xpath("//div[@id='divOutPolicyApprover2']/p"), OPLevel2, OPLevel2Title,
			By.xpath("/html/body/form/div[9]/div/div/div/div[2]/div[2]/div[2]/ul/li[3]/div/div/div[3]/div/div/input[1]"));
	QaBrowser.driver.findElement(By.xpath("//div[@id='divOutPolicyApprover2']/p")).click();
	Thread.sleep(2000);
}
else if (TotalApprover12.equalsIgnoreCase("3"))
{
	TestBase.listofautosuggestion(By.xpath("//div[@id='divInPolicyApprover1']/p"), IPLevel1, IPLevel1Title,
			By.xpath("/html/body/form/div[9]/div/div/div/div[2]/div[2]/div[2]/ul/li[2]/div/div/div[2]/div/div/input[1]"));
	QaBrowser.driver.findElement(By.xpath("//div[@id='divInPolicyApprover1']/p")).click();
	Thread.sleep(2000);
	
	TestBase.listofautosuggestion(By.xpath("//div[@id='divOutPolicyApprover1']/p"), OPLevel1, OPLevel1Title,
			By.xpath("/html/body/form/div[9]/div/div/div/div[2]/div[2]/div[2]/ul/li[3]/div/div/div[2]/div/div/input[1]"));
	QaBrowser.driver.findElement(By.xpath("//div[@id='divOutPolicyApprover1']/p")).click();
	Thread.sleep(2000);
	
	TestBase.listofautosuggestion(By.xpath("//div[@id='divInPolicyApprover2']/p"), IPLevel2, IPLevel2Title,
			By.xpath("/html/body/form/div[9]/div/div/div/div[2]/div[2]/div[2]/ul/li[2]/div/div/div[3]/div/div/input[1]"));
	QaBrowser.driver.findElement(By.xpath("//div[@id='divInPolicyApprover2']/p")).click();
	Thread.sleep(2000);
	
	TestBase.listofautosuggestion(By.xpath("//div[@id='divOutPolicyApprover2']/p"), OPLevel2, OPLevel2Title,
			By.xpath("/html/body/form/div[9]/div/div/div/div[2]/div[2]/div[2]/ul/li[3]/div/div/div[3]/div/div/input[1]"));
	QaBrowser.driver.findElement(By.xpath("//div[@id='divOutPolicyApprover2']/p")).click();
	Thread.sleep(2000);
	
	TestBase.listofautosuggestion(By.xpath("//div[@id='divInPolicyApprover3']/p"), IPLevel3, IPLevel3Title,
			By.xpath("/html/body/form/div[9]/div/div/div/div[2]/div[2]/div[2]/ul/li[2]/div/div/div[4]/div/div/input[1]"));
	QaBrowser.driver.findElement(By.xpath("//div[@id='divInPolicyApprover3']/p")).click();
	Thread.sleep(2000);
	
	TestBase.listofautosuggestion(By.xpath("//div[@id='divOutPolicyApprover3']/p"), OPLevel3, OPLevel3Title,
			By.xpath("/html/body/form/div[9]/div/div/div/div[2]/div[2]/div[2]/ul/li[3]/div/div/div[4]/div/div/input[1]"));
	QaBrowser.driver.findElement(By.xpath("//div[@id='divOutPolicyApprover3']/p")).click();
	Thread.sleep(2000);
}

QaRobot.ClickOnElement("SendADD");
QaExtentReport.test.log(Status.INFO,"<b><i>Click on Send Button</i></b>");
Thread.sleep(2000);

if (Delegation.equalsIgnoreCase("OnLeave"))
{
	  QaRobot.ClickOnElement("DelegationSlider");
		QaExtentReport.test.log(Status.INFO,"<b><i>Click on Delegation Slider Button</i></b>");
		Thread.sleep(2000);
		
		QaBrowser.driver.findElement(By.xpath("(//span[@class='input-group-addon datepick-trigger'])[1]")).click();
		
		QaBrowser.driver.findElement(By.xpath("//a[contains(@title,'" + LeaveStartDate + "')]")).click();
		QaExtentReport.test.log(Status.INFO, "CheckIN date : " + LeaveStartDate);
		
		QaBrowser.driver.findElement(By.xpath("(//span[@class='input-group-addon datepick-trigger'])[2]")).click();
		
		QaBrowser.driver.findElement(By.xpath("//a[contains(@title,'" + LeaveEndDate + "')]")).click();
		QaExtentReport.test.log(Status.INFO, "CheckIN date : " + LeaveEndDate);
		
		TestBase.listofautosuggestion(By.xpath("//div[@id='divuser8']/p"), DelegatedEmail, DelegatedEmailName,
				By.xpath("/html/body/form/div[9]/div/div/div/div[3]/div[2]/div[3]/div/input[1]"));
		QaBrowser.driver.findElement(By.xpath("//div[@id='divuser8']/p")).click();
		Thread.sleep(2000);
}
else 
{
	 QaRobot.ClickOnElement("FinalSaveADD");
		QaExtentReport.test.log(Status.INFO,"<b><i>Click on Final Save Button</i></b>");
		Thread.sleep(2000);
}

QaRobot.ClickOnElement("DelegationSave");
QaExtentReport.test.log(Status.INFO,"<b><i>Click on Approver Delegation Details</i></b>");

QaRobot.ClickOnElement("ChangePassword");
QaExtentReport.test.log(Status.INFO,"<b><i>Click on Approver Delegation Details</i></b>");
Thread.sleep(2000);

QaRobot.PassValue("OldPassword", OldPassword);
QaExtentReport.test.log(Status.INFO,"<b><i>DependentVisa_Number</i></b>");
Thread.sleep(2000);

QaRobot.PassValue("NewPassword", NewPassword);
QaExtentReport.test.log(Status.INFO,"<b><i>DependentVisa_Number</i></b>");
Thread.sleep(2000);

QaRobot.PassValue("ConfirmNewPassword", ConfirmNewPassword);
QaExtentReport.test.log(Status.INFO,"<b><i>DependentVisa_Number</i></b>");
Thread.sleep(2000);

QaRobot.ClickOnElement("FinalSaveCP");
QaExtentReport.test.log(Status.INFO,"<b><i>Click on Final Save Button</i></b>");
Thread.sleep(2000);

QaRobot.ClickOnElement("Close_btn1");
QaExtentReport.test.log(Status.INFO,"<b><i>Click on Final Save Button</i></b>");
Thread.sleep(2000);

		
		
//		TestBase.Companycode(Source,URL); 
//		QaRobot.impliwait(30);
//		
//		QaExtentReport.test = QaExtentReport.report.createTest("Test on Manage Travellers");
//	
//	//write comapany code
//	
//	QaRobot.PassValue("Comapnycode",Comapnycode);
//	QaExtentReport.test.log(Status.INFO,"<b><i>Write Comapnycode</i></b>");
//	
//	QaRobot.PassValue("User_name",Username);
//	QaExtentReport.test.log(Status.INFO,"<b><i>Write Username</i></b>");
//		
//	QaRobot.PassValue("Password",Password);
//	QaExtentReport.test.log(Status.INFO,"<b><i>Write Password</i></b>");
//	
//	QaRobot.ClickOnElement("Submit");
//	QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on submit</i></b>");
//	
//	QaRobot.mouseHover("//a[@id='HeaderTop_aSetting']","//span[@id='HeaderTop_lblUserManagement']");
//	//Create traveller
//	
//	QaRobot.ClickOnElement("C_travellers");
//	QaExtentReport.test.log(Status.INFO,"<b><i>clicked on new travellers</i></b>");
//	
//	QaRobot.selectValueFromDropdown("T_title", Title, "click on T_title");
//	
//	QaRobot.PassValue("T_f_name", Tfirstname);
//	QaExtentReport.test.log(Status.INFO,"<b><i>Write First name</i></b>");
//	
//	QaRobot.PassValue("T_L_name", Tlastname);
//	QaExtentReport.test.log(Status.INFO,"<b><i>Write lastname</i></b>");
//	
////	QaRobot.ClickOnElement("DOB_Calender");
////	QaExtentReport.test.log(Status.INFO,"<b><i>Click on calender</i></b>");
////	
////	Thread.sleep(2000);
////
////	QaRobot.selectTextFromDropdown("DOB_month",Month,"Slected month");
////	
////	QaRobot.selectTextFromDropdown("DOB_Year", Year, "Selected year");
////	
////	QaBrowser.driver.findElement(By.xpath("//a[text()='"+DOBDate+"']")).click();
//	
//	QaRobot.PassValue("U_name", user);
//	QaExtentReport.test.log(Status.INFO,"<b><i>Write U_name</i></b>");
//	
//	QaRobot.PassValue("Email", Email);
//	QaExtentReport.test.log(Status.INFO,"<b><i>Write Email</i></b>");
//	
//	QaRobot.selectTextFromDropdown("Branchname", BranchName , "click on Branchname");
//	QaRobot.selectTextFromDropdown("HA_state", HA_state , "click on HA_state");
//	
//	TestBase.listofautosuggestion(By.xpath("//div[@id='divCity']/p"), HA_city, HA_Citytitle,By.xpath("//input[@id='txtcity']"));
//	
//	Thread.sleep(1000);
//	
//	QaRobot.selectTextFromDropdown("BA_state", BA_state , "click on BA_state");
//	
//	TestBase.listofautosuggestion(By.xpath("//div[@id='divCity_Business']/p"), BA_city, BA_Citytitle,By.xpath("//input[@id='txtcity_Business']"));
//	
//	QaRobot.selectTextFromDropdown("M_country", Mobilecountry, "Write M_country");
//	
//	QaRobot.PassValue("number", mobilenumber);
//	QaExtentReport.test.log(Status.INFO,"<b><i>Write number</i></b>");
//	
//	QaRobot.ClickOnElement("Approvexp");
//	QaExtentReport.test.log(Status.INFO,"<b><i>clicked on Approvexp</i></b>");
//	
//	QaRobot.ClickOnElement("checkout");
//	QaExtentReport.test.log(Status.INFO,"<b><i>clicked on checkout</i></b>");
//	
//	QaRobot.ClickOnElement("chkAcknowledgment");
//	QaExtentReport.test.log(Status.INFO,"<b><i>clicked on chkAcknowledgment</i></b>");
//	
//	QaRobot.ClickOnElement("Okay");
//	QaExtentReport.test.log(Status.INFO,"<b><i>clicked on Okay</i></b>");
//	
//	QaRobot.ClickOnElement("btn_save"); 
//	QaExtentReport.test.log(Status.INFO,"<b><i>clicked on btn_save</i></b>");
//	Thread.sleep(2000);
//	
//	QaRobot.ClickOnElement("C_user"); // clicked on created user
//	QaExtentReport.test.log(Status.INFO,"<b><i>clicked on Created user</i></b>");
//	
//   QaRobot.ClickOnElement("P_details"); //passport details
//   QaExtentReport.test.log(Status.INFO,"<b><i>clicked on Passport details</i></b>");
//	
//	QaRobot.ClickOnElement("Add_C_details");
//	QaExtentReport.test.log(Status.INFO,"<b><i>clicked on Add btn</i></b>");
//	
//	QaRobot.PassValue("Passportno",Passportno);
//	QaExtentReport.test.log(Status.INFO,"<b><i>clicked on Passportno</i></b>");
//	
//	TestBase.listofautosuggestion(By.xpath("//div[@id='divCityPassport']/p"), Placeofissue, Placeofissuetitle,By.xpath("//input[@id='txtSearchCity']"));
//	
//	QaRobot.ClickOnElement("Validfrom");
//	QaExtentReport.test.log(Status.INFO,"<b><i>Click on Validfrom</i></b>");
//	
//	QaBrowser.driver.findElement(By.xpath("//a[text()='"+Validfrom+"']")).click();
//	QaExtentReport.test.log(Status.INFO,"<b><i>Write Username</i></b>");
//	
//	QaRobot.ClickOnElement("Expiry");
//	QaExtentReport.test.log(Status.INFO,"<b><i>Click on Expiry</i></b>");
//	
//	QaRobot.selectTextFromDropdown("Expiry_year",Expiryyear,"Slected year");
//	Thread.sleep(2000);
//	
//	QaBrowser.driver.findElement(By.xpath("//a[text()='"+Expirydate+"']")).click();
//	
//	QaRobot.ClickOnElement("Primary_checkbox");
//	QaExtentReport.test.log(Status.INFO,"<b><i>click on Primary_checkbox</i></b>");
//	
//	QaRobot.ClickOnElement("Add_btn"); 
//	QaExtentReport.test.log(Status.INFO,"<b><i>Click on btn</i></b>");
//	
//	QaRobot.ClickOnElement("Visadetails"); // Visa Details
//	QaExtentReport.test.log(Status.INFO,"<b><i>Click on Visadetails</i></b>");
//	
//	QaRobot.ClickOnElement("Add_btn");
//	QaExtentReport.test.log(Status.INFO,"<b><i>Click on btn</i></b>");
//	
//	QaRobot.PassValue("Visanumber", Visanumber);
//	QaExtentReport.test.log(Status.INFO,"<b><i>Write Visanumber</i></b>");
//	
//	QaRobot.selectTextFromDropdown("Cntryofvisa",Countryofvisa,"Write Cntryofvisa");
//	
//	Thread.sleep(100);
//	
//	QaRobot.ClickOnElement("Dateofissue");
//	QaExtentReport.test.log(Status.INFO,"<b><i>Click on Dateofissue</i></b>");
//	
//	QaRobot.ClickOnElement("Previous_month");
//	QaExtentReport.test.log(Status.INFO,"<b><i>Click on Previous_month</i></b>");
//	
//	QaBrowser.driver.findElement(By.xpath("//a[text()='"+issuedate+"']")).click();
//	
//	Thread.sleep(100);
//	
//	QaRobot.ClickOnElement("Dateofissue");
//	QaExtentReport.test.log(Status.INFO,"<b><i>Click on Dateofissue</i></b>");
//	
//	QaRobot.ClickOnElement("Dateofexpiry");
//	QaExtentReport.test.log(Status.INFO,"<b><i>Click on Dateofexpiry</i></b>");
//	
//    QaRobot.selectTextFromDropdown("Dateofexpiryyear",Dateofexpiryyear,"Slected Dateofexpiryyear");
//	
//	QaBrowser.driver.findElement(By.xpath("//a[text()='"+Dateofexpirydate+"']")).click();
//	
//	QaRobot.ClickOnElement("Addbutton"); 
//	QaExtentReport.test.log(Status.INFO,"<b><i>Click on Add_btn</i></b>");

    //QaRobot.ClickOnElement("C_user","clicked on Created user"); // created user
	
	//Thread.sleep(100);

//	QaRobot.ClickOnElement("DependentDetails"); // Dependent Details
//	QaExtentReport.test.log(Status.INFO,"<b><i>Click on DependentDetails</i></b>");
//	
//	QaRobot.ClickOnElement("Adddependent");
//	QaExtentReport.test.log(Status.INFO,"<b><i>Click on Adddependent</i></b>");
//	
//	QaRobot.selectValueFromDropdown("Dependenttitle", Dtitle, "click on Dependenttitle");
//	
//	QaRobot.PassValue("Dependent_name", Dfirstname);
//	QaExtentReport.test.log(Status.INFO,"<b><i>Write Dependent_name</i></b>");
//	
//	QaRobot.PassValue("Dependent_lastname", Dlastname);
//	QaExtentReport.test.log(Status.INFO,"<b><i>Write Dependent_lastname</i></b>");
//	
//	if(Gender.equalsIgnoreCase("Male"))
//	{
//		QaRobot.ClickOnElement("Male");
//		QaExtentReport.test.log(Status.INFO,"<b><i>Click on Male</i></b>");
//	}
//	else if(Gender.equalsIgnoreCase("Female"))
//	{
//		QaRobot.ClickOnElement("Female");
//		QaExtentReport.test.log(Status.INFO,"<b><i>Click on Female</i></b>");
//	}
//	else if(Gender.equalsIgnoreCase("Non Binary"))
//	{
//		QaRobot.ClickOnElement("Non_Binary");
//		QaExtentReport.test.log(Status.INFO,"<b><i>Click on Non_Binary</i></b>");
//	}
//    QaRobot.ClickOnElement("Dependent_calender");
//    QaExtentReport.test.log(Status.INFO,"<b><i>Click on Dependent_calender</i></b>");
//	
//	QaRobot.selectTextFromDropdown("Dependent_year",Dependent_year,"selected Dependent_year");
//	
//	QaBrowser.driver.findElement(By.xpath("//a[text()='"+Dependent_date+"']")).click();	
//	
//    QaRobot.selectTextFromDropdown("DependentRelation",Relation,"select DependentRelation");
//	
//	QaRobot.PassValue("DependentMobileCountryCode", DependentCountryCode);
//	QaExtentReport.test.log(Status.INFO,"<b><i>Write DependentMobileCountryCode</i></b>");
//	
//    QaRobot.PassValue("Dependentnumber", Dependentnumber);
//    QaExtentReport.test.log(Status.INFO,"<b><i>Write Dependentnumber</i></b>");
//	
//   QaRobot.ClickOnElement("control_checkbox");
//   QaExtentReport.test.log(Status.INFO,"<b><i>Click on control_checkbox</i></b>");
//	
//   QaRobot.ClickOnElement("control_checkbox2");
//   QaExtentReport.test.log(Status.INFO,"<b><i>Click on control_checkbox2</i></b>");
//	
//   QaRobot.ClickOnElement("Dependent_save");
//   QaExtentReport.test.log(Status.INFO,"<b><i>Click on Dependent_save</i></b>");
//	
//	QaRobot.ClickOnElement("Edit_dependent"); // Edit  dependent once saved
//	QaExtentReport.test.log(Status.INFO,"<b><i>Click on Edit_dependent</i></b>");
//	
//	QaRobot.ClickOnElement("Dependentpassport_tab"); // Add passport for dependent
//	QaExtentReport.test.log(Status.INFO,"<b><i>Click on Dependentpassport_tab</i></b>");
//	
//	QaRobot.ClickOnElement("Add_passport_btn");
//	QaExtentReport.test.log(Status.INFO,"<b><i>Click on Add_passport_btn</i></b>");
//	
//     QaRobot.PassValue("Txtpassno", DependentPassportno);
//     QaExtentReport.test.log(Status.INFO,"<b><i>Write Txtpassno</i></b>");
//     
//   QaRobot.selectTextFromDropdown("DependentNationality",DependentNationality,"select DependentNationality");
//	
//   QaRobot.selectTextFromDropdown("PassportIssuingcountry",PassportIssuingcountry,"select PassportIssuingcountry");
//	
//	TestBase.listofautosuggestion(By.xpath("//div[@id='divCityPassport']/p"), PassportPlaceofissue, PassportPlaceofissuetitle,
//			By.xpath("//input[@id='txtSearchCity']"));
//	
//	QaRobot.ClickOnElement("Expirey");
//	QaExtentReport.test.log(Status.INFO,"<b><i>Click on Expirey</i></b>");
//	
//     QaRobot.selectTextFromDropdown("PassportYear",PassportYear,"selected PassportYear");
//	
//	QaBrowser.driver.findElement(By.xpath("//a[text()='"+Passportdate+"']")).click();	
//	
//	QaRobot.ClickOnElement("Primarycheckbox");
//	QaExtentReport.test.log(Status.INFO,"<b><i>Click on Primarycheckbox</i></b>");
//	
//	QaRobot.ClickOnElement("Dependent_addbtn");
//	QaExtentReport.test.log(Status.INFO,"<b><i>Click on Dependent_addbtn</i></b>");
//	
//	QaRobot.ClickOnElement("Dependent_uservisa"); //Add Dependent Visa
//	  QaExtentReport.test.log(Status.INFO,"<b><i>Click on Dependent_uservisa</i></b>");
//	
//	QaRobot.ClickOnElement("Dependent_addvisa");
//	QaExtentReport.test.log(Status.INFO,"<b><i>Click on Dependent_addvisa</i></b>");
//	
//	QaRobot.PassValue("DependentVisa_Number", DependentVisa_Number);
//	QaExtentReport.test.log(Status.INFO,"<b><i>DependentVisa_Number</i></b>");
//	
//    QaRobot.selectTextFromDropdown("DependentVisa_CountryCode",DependentVisa_Country,"selected DependentVisa_CountryCode");
//	
//	QaRobot.ClickOnElement("DependentVStart_day");
//	QaExtentReport.test.log(Status.INFO,"<b><i>Click on DependentVStart_day</i></b>");
//	
//    QaRobot.selectTextFromDropdown("DependentVisa_startyear",DependentVisa_startyear,"selected DependentVisa_startyear");
//	QaBrowser.driver.findElement(By.xpath("//a[text()='"+DependentVisa_startdate+"']")).click();	
//	
//	QaRobot.ClickOnElement("DependentVEnd_day");
//	QaExtentReport.test.log(Status.INFO,"<b><i>Click on DependentVEnd_day</i></b>");
//	
//    QaRobot.selectTextFromDropdown("DependentVisa_Endyear",DependentVisa_Endyear,"selected DependentVisa_Endyear");
//	
//	QaBrowser.driver.findElement(By.xpath("//a[text()='"+DependentVisa_EndDate+"']")).click();
//	
//	QaRobot.ClickOnElement("Dependent_savebtn");
//	QaExtentReport.test.log(Status.INFO,"<b><i>Click on Dependent_savebtn</i></b>");
//	
//	QaRobot.ClickOnElement("ApproverDelegationDetails");
//	QaExtentReport.test.log(Status.INFO,"<b><i>Click on Approver Delegation Details</i></b>");
//	
//	WebElement DropDown = QaBrowser.driver.findElement(By.xpath("//select[@id='ddltravelcategory']"));
//    Select s = new Select(DropDown);
//    s.selectByVisibleText(TravelCategory12);
//	
//    WebElement DropDown1 = QaBrowser.driver.findElement(By.xpath("//select[@id='ddlApproverLevel']"));
//    Select s1 = new Select(DropDown1);
//    s1.selectByVisibleText(TotalApprover12);
//	
//    if (TotalApprover12.equalsIgnoreCase("1")) 
//    {
//    	TestBase.listofautosuggestion(By.xpath("//div[@id='divInPolicyApprover1']/p"), IPLevel1, IPLevel1Title,
//    			By.xpath("/html/body/form/div[9]/div/div/div/div[2]/div[2]/div[2]/ul/li[2]/div/div/div[2]/div/div/input[1]"));
//    	
//    	TestBase.listofautosuggestion(By.xpath("//div[@id='divOutPolicyApprover1']/p"), OPLevel1, OPLevel1Title,
//    			By.xpath("/html/body/form/div[9]/div/div/div/div[2]/div[2]/div[2]/ul/li[3]/div/div/div[2]/div/div/input[1]"));
//    }
//    else if (TotalApprover12.equalsIgnoreCase("2"))
//    {
//    	TestBase.listofautosuggestion(By.xpath("//div[@id='divInPolicyApprover1']/p"), IPLevel1, IPLevel1Title,
//    			By.xpath("/html/body/form/div[9]/div/div/div/div[2]/div[2]/div[2]/ul/li[2]/div/div/div[2]/div/div/input[1]"));
//    	
//    	TestBase.listofautosuggestion(By.xpath("//div[@id='divOutPolicyApprover1']/p"), OPLevel1, OPLevel1Title,
//    			By.xpath("/html/body/form/div[9]/div/div/div/div[2]/div[2]/div[2]/ul/li[3]/div/div/div[2]/div/div/input[1]"));
//    	
//    	TestBase.listofautosuggestion(By.xpath("//div[@id='divInPolicyApprover2']/p"), IPLevel2, IPLevel2Title,
//    			By.xpath("/html/body/form/div[9]/div/div/div/div[2]/div[2]/div[2]/ul/li[2]/div/div/div[3]/div/div/input[1]"));
//    	
//    	TestBase.listofautosuggestion(By.xpath("//div[@id='divOutPolicyApprover2']/p"), OPLevel2, OPLevel2Title,
//    			By.xpath("/html/body/form/div[9]/div/div/div/div[2]/div[2]/div[2]/ul/li[3]/div/div/div[3]/div/div/input[1]"));
//    }
//    else if (TotalApprover12.equalsIgnoreCase("3"))
//    {
//    	TestBase.listofautosuggestion(By.xpath("//div[@id='divInPolicyApprover1']/p"), IPLevel1, IPLevel1Title,
//    			By.xpath("/html/body/form/div[9]/div/div/div/div[2]/div[2]/div[2]/ul/li[2]/div/div/div[2]/div/div/input[1]"));
//    	
//    	TestBase.listofautosuggestion(By.xpath("//div[@id='divOutPolicyApprover1']/p"), OPLevel1, OPLevel1Title,
//    			By.xpath("/html/body/form/div[9]/div/div/div/div[2]/div[2]/div[2]/ul/li[3]/div/div/div[2]/div/div/input[1]"));
//    	
//    	TestBase.listofautosuggestion(By.xpath("//div[@id='divInPolicyApprover2']/p"), IPLevel2, IPLevel2Title,
//    			By.xpath("/html/body/form/div[9]/div/div/div/div[2]/div[2]/div[2]/ul/li[2]/div/div/div[3]/div/div/input[1]"));
//    	
//    	TestBase.listofautosuggestion(By.xpath("//div[@id='divOutPolicyApprover2']/p"), OPLevel2, OPLevel2Title,
//    			By.xpath("/html/body/form/div[9]/div/div/div/div[2]/div[2]/div[2]/ul/li[3]/div/div/div[3]/div/div/input[1]"));
//    	
//    	TestBase.listofautosuggestion(By.xpath("//div[@id='divInPolicyApprover3']/p"), IPLevel3, IPLevel3Title,
//    			By.xpath("/html/body/form/div[9]/div/div/div/div[2]/div[2]/div[2]/ul/li[2]/div/div/div[4]/div/div/input[1]"));
//    	
//    	TestBase.listofautosuggestion(By.xpath("//div[@id='divOutPolicyApprover3']/p"), OPLevel3, OPLevel3Title,
//    			By.xpath("/html/body/form/div[9]/div/div/div/div[2]/div[2]/div[2]/ul/li[3]/div/div/div[4]/div/div/input[1]"));
//    }
//    
//    QaRobot.ClickOnElement("SendADD");
//	QaExtentReport.test.log(Status.INFO,"<b><i>Click on Send Button</i></b>");
//    
//    if (Delegation.equalsIgnoreCase("OnLeave"))
//    {
//    	  QaRobot.ClickOnElement("DelegationSlider");
//    		QaExtentReport.test.log(Status.INFO,"<b><i>Click on Delegation Slider Button</i></b>");
//    }
//    else 
//    {
//    	 QaRobot.ClickOnElement("FinalSaveADD");
//    		QaExtentReport.test.log(Status.INFO,"<b><i>Click on Final Save Button</i></b>");
//    }
//    
//    QaRobot.ClickOnElement("ApproverDelegationDetails");
//	QaExtentReport.test.log(Status.INFO,"<b><i>Click on Approver Delegation Details</i></b>");
//    
//    QaRobot.PassValue("OldPassword", OldPassword);
//	QaExtentReport.test.log(Status.INFO,"<b><i>DependentVisa_Number</i></b>");
//    
//    QaRobot.PassValue("NewPassword", NewPassword);
//	QaExtentReport.test.log(Status.INFO,"<b><i>DependentVisa_Number</i></b>");
//    
//    QaRobot.PassValue("ConfirmNewPassword", ConfirmNewPassword);
//	QaExtentReport.test.log(Status.INFO,"<b><i>DependentVisa_Number</i></b>");
//    
//    QaRobot.ClickOnElement("FinalSaveCP");
//	QaExtentReport.test.log(Status.INFO,"<b><i>Click on Final Save Button</i></b>");
	}
	
	@AfterMethod
	public static void afterMetod() {
		QaExtentReport.test.getExtent().flush();
	}
}
