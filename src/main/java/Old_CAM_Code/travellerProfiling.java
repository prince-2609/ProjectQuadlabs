package Old_CAM_Code;

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
public class travellerProfiling
{
	@DataProvider
	public Object[][] getexceldata() throws Exception 
	{
		return QaDataProvider.getTestdata("Travellerprofling", "sheet1");
	}
	
	@Test(dataProvider = "getexceldata")
	public static void Profiling(String Source,String URL,String Comapnycode,String	Username,String	Password, String Select_branch,
			String Department_name,String Add_designation,String Category_code, String Category_Name, String  Travel_Category,
			String Category_Code, String Language, String Reason_Code,String Reason_Name) throws Exception {

     
		TestBase.Companycode(Source,URL); 
		QaRobot.impliwait(30);
		
		QaExtentReport.test = QaExtentReport.report.createTest("Test On Policy work flow");
		//write comapany code
		
		//QaRobot.PassValue("Comapnycode",Comapnycode,"write Comapnycode");
		
		QaRobot.PassValue("User_name",Username);
		QaExtentReport.test.log(Status.INFO,"<b><i>Write Username</i></b>");
			
		QaRobot.PassValue("Password",Password);
		QaExtentReport.test.log(Status.INFO,"<b><i>Write Password</i></b>");
		
		QaRobot.ClickOnElement("Submit");
		QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on submit</i></b>");
		
		Thread.sleep(1000);
		
		
		QaRobot.mouseHover("//a[@id='HeaderTop_aSetting']","//span[@id='HeaderTop_lblComapnayManagement']");
		
		QaRobot.ClickOnElement("Managedepartment"); // Manage department
		QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Managedepartment</i></b>");
		
		QaRobot.ClickOnElement("Add_department");
		QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Add_department</i></b>");
		
		QaRobot.selectTextFromDropdown("Select_department", Select_branch, "Select Select_department");
	    Thread.sleep(1000);
		
	    QaRobot.PassValue("Department_name",Department_name);
		QaExtentReport.test.log(Status.INFO,"<b><i>Write Department_name</i></b>");
	    
	    QaRobot.ClickOnElement("Save_department");
		QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Save_department</i></b>");
		
		QaBrowser.driver.switchTo().alert().accept();
	    
	    QaRobot.ClickOnElement("close_department");
		QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on close_department</i></b>");
	    
		QaRobot.ClickOnElement("Manage_designation"); // Manage designation
		QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Manage_designation</i></b>");
		
		QaRobot.ClickOnElement("Add_managedesignation");
		QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Add_managedesignation</i></b>");
		
		QaRobot.PassValue("Add_designation",Add_designation);
		QaExtentReport.test.log(Status.INFO,"<b><i>Write Add_designation</i></b>");
		
		QaRobot.ClickOnElement("Add_branch");
		QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Add_branch</i></b>");
		
		QaRobot.ClickOnElement("Save_designation");
		QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Save_designation</i></b>");
		
		QaBrowser.driver.switchTo().alert().accept();
		
		QaRobot.ClickOnElement("close_designation");
		QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on close_designation</i></b>");
		
		
		QaRobot.ClickOnElement("Manage_Grade"); // manage grade
		QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Manage_Grade</i></b>");
		
		QaRobot.ClickOnElement("Add_grade");
		QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Add_grade</i></b>");
		
        QaRobot.PassValue("Category_code", Category_code);
		QaExtentReport.test.log(Status.INFO,"<b><i>Write Category_code</i></b>");
		
      QaRobot.PassValue("Category_name", Category_Name);
		QaExtentReport.test.log(Status.INFO,"<b><i>Write Category_name</i></b>");
		
		QaRobot.ClickOnElement("Book_family");
		QaExtentReport.test.log(Status.INFO,"<b><i>click on checkbox Book_family</i></b>");
		
		QaRobot.ClickOnElement("Personal");
		QaExtentReport.test.log(Status.INFO,"<b><i>Click on checkbox Personal</i></b>");
		
	QaRobot.ClickOnElement("Grade_branch_associate");
		QaExtentReport.test.log(Status.INFO,"<b><i>Associate all Grade_branch_associate</i></b>");
		
		QaRobot.ClickOnElement("Add_grade");
		QaExtentReport.test.log(Status.INFO,"<b><i>Click on Add_grade</i></b>");
		
		QaBrowser.driver.switchTo().alert().accept();
		
		QaRobot.ClickOnElement("Close_grade");
		QaExtentReport.test.log(Status.INFO,"<b><i>Click on Close_grade</i></b>");
		
		QaRobot.ClickOnElement("Managetravel_category");//Manage Grade
		QaExtentReport.test.log(Status.INFO,"<b><i>Click on Managetravel_category</i></b>");
		
   	QaRobot.ClickOnElement("Add_travel_category");
		QaExtentReport.test.log(Status.INFO,"<b><i>Click on Add_travel_category</i></b>");
		
	QaRobot.PassValue("txtTravelCategory", Travel_Category);
		QaExtentReport.test.log(Status.INFO,"<b><i>Write txtTravelCategory</i></b>");
		
	QaRobot.PassValue("txtTravelCategoryCode", Category_Code);
		QaExtentReport.test.log(Status.INFO,"<b><i>Write txtTravelCategoryCode</i></b>");
		
QaRobot.ClickOnElement("Radio_btn_businesstrip");
		QaExtentReport.test.log(Status.INFO,"<b><i>Click on Radio_btn_businesstrip</i></b>");
		
	QaRobot.ClickOnElement("chkApplyPolicy");
		QaExtentReport.test.log(Status.INFO,"<b><i>Click on chkApplyPolicy</i></b>");
		
	QaRobot.ClickOnElement("chkStatus");
		QaExtentReport.test.log(Status.INFO,"<b><i>Click on chkStatus</i></b>");
		
	QaRobot.ClickOnElement("Add_Managetravel");
		QaExtentReport.test.log(Status.INFO,"<b><i>Click on Add_Managetravel</i></b>");
		
	QaBrowser.driver.switchTo().alert().accept();
		
		QaRobot.ClickOnElement("Close_travel_category");
		QaExtentReport.test.log(Status.INFO,"<b><i>Close Travel category</i></b>");
		
		
		QaRobot.ClickOnElement("Manage_Predefined_Reasons");
		QaExtentReport.test.log(Status.INFO,"<b><i>Click on Manage Predefined Reasons</i></b>");
		
		QaRobot.ClickOnElement("Add_Predefined_reasons");
		QaExtentReport.test.log(Status.INFO,"<b><i>Add Predefinedreasons</i></b>");
		
		QaRobot.selectTextFromDropdown("Language_Code", Language, " Write Language_Code");
		
	   QaRobot.PassValue("Reason_Code", Reason_Code);
	   QaExtentReport.test.log(Status.INFO,"<b><i>Write Reason_Code</i></b>");
	   
	   QaRobot.PassValue("Reason_Name", Reason_Name);
	   QaExtentReport.test.log(Status.INFO,"<b><i>Write Reason_Name</i></b>");
	   
	   QaRobot.ClickOnElement("chkAllProducts");
	   QaExtentReport.test.log(Status.INFO,"<b><i>Click on all products</i></b>");
	   
	   QaRobot.ClickOnElement("chkStatus");
	   QaExtentReport.test.log(Status.INFO,"<b><i>Check Active status</i></b>");
	   
	   QaRobot.ClickOnElement("add_Predefinedreasons");
	   QaExtentReport.test.log(Status.INFO,"<b><i>Click on add button</i></b>");
	   
	   QaBrowser.driver.switchTo().alert().accept();
	   
	   QaRobot.ClickOnElement("Close_Predefined_reasons");
	   QaExtentReport.test.log(Status.INFO,"<b><i>Close button</i></b>");
	   
	   QaRobot.ClickOnElement("Close_Predefined_reasons");
	   QaExtentReport.test.log(Status.INFO,"<b><i>Close button</i></b>");
	   
	   
	}
	
	@AfterMethod
	public static void afterMetod() 
	{
		QaExtentReport.test.getExtent().flush();
	}
}