package Old_CAM_Code;

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
public class corporateProfiling
{
	@DataProvider
	public Object[][] getexceldata() throws Exception 
	{
		return QaDataProvider.getTestdata("corporateprofiling", "sheet1");
	}

	@Test(dataProvider = "getexceldata")
	public static void Profiling(String Source,String URL,String Comapnycode,String	Username,String	Password, String Division_Name,
			String Corporate_Branch_name, String Branch_country, String City, String Citytitle, String Mobile_number, String GST_No, 
			String FirstName_Title,String GST_Holder_First_Name, String	GST_Holder_Last_Name, String GST_Holder_Email, 
			String Cost_Center_Code, String Cost_Center_Name, String Project_Code, String	Project_Name, String Expense_Category,
			String Business_Unit_Code, String	Business_Unit_Name, String	Business_Unit_Head, String	Business_Unit_Email,
			String Business_Unit_Contact_No) throws Exception {

		TestBase.Companycode(Source,URL); 
		QaRobot.impliwait(30);
		
		QaExtentReport.test = QaExtentReport.report.createTest("Test on corporate Profiling");
		//write comapany code
		
		//QaRobot.PassValue("Comapnycode",Comapnycode,"write Comapnycode");
		
		QaRobot.PassValue("User_name",Username);
		QaExtentReport.test.log(Status.INFO,"<b><i>Write Username</i></b>");
		
		QaRobot.PassValue("Password",Password);
		QaExtentReport.test.log(Status.INFO, "<b><i>Write Password</i></b>");
		
		QaRobot.ClickOnElement("Submit");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on submit</i></b>");
		
		QaRobot.mouseHover("//a[@id='HeaderTop_aSetting']","//span[@id='HeaderTop_lblComapnayManagement']");
		
		QaRobot.ClickOnElement("Manage_division"); //Manage Division
		QaExtentReport.test.log(Status.INFO, "<b><i>Click on Manage division</i></b>");
		
		QaRobot.ClickOnElement("Add_division");
		QaExtentReport.test.log(Status.INFO, "<b><i>Click on Add_division</i></b>");
		
		QaRobot.PassValue("Division_name", Division_Name);
		QaExtentReport.test.log(Status.INFO, "<b><i>Write Division name</i></b>");
		
		QaRobot.ClickOnElement("Status_active");
		QaExtentReport.test.log(Status.INFO, "<b><i>Click on active status</i></b>");
		
		QaRobot.ClickOnElement("Managedivision_Save_btn");
		QaExtentReport.test.log(Status.INFO, "<b><i>Managedivision_Save_btn</i></b>");
		
        QaRobot.ClickOnElement("Close_division");
        QaExtentReport.test.log(Status.INFO, "<b><i>Click on Close_division</i></b>");
        
		QaRobot.ClickOnElement("Manage_Branch"); // Manage Branch
		QaExtentReport.test.log(Status.INFO, "<b><i>Click on Mange branch</i></b>");
		
		QaRobot.ClickOnElement("Branch_add");
		QaExtentReport.test.log(Status.INFO, "<b><i>Add branch</i></b>");
		
		QaRobot.PassValue("Corprate_branch_name", Corporate_Branch_name);
		QaExtentReport.test.log(Status.INFO, "<b><i>Write corporate branch name</i></b>");
		
		QaRobot.selectTextFromDropdown("Branch_country", Branch_country, "Select Branch country");
		Thread.sleep(2000);
		
		TestBase.listofautosuggestion(By.xpath("/html/body/div/form/div[7]/div/div/div[2]/div[1]/div[2]/div/div/div/div[11]/div[2]/div/p"), City, Citytitle,
				By.xpath("//input[@id='txtCity']")); 
		Thread.sleep(1000);
		
		QaRobot.PassValue("Branch_mobile", Mobile_number);
		QaExtentReport.test.log(Status.INFO, "<b><i>Write Mobile Number</i></b>");
		
		QaRobot.PassValue("Branch_GSTNo", GST_No);
		QaExtentReport.test.log(Status.INFO, "<b><i>Write Branch GSTNo</i></b>");
		
		QaRobot.selectTextFromDropdown("GST_title", FirstName_Title, "Select GST title");
		Thread.sleep(2000);
		
		QaRobot.PassValue("GSTHolderFirstName", GST_Holder_First_Name);
		QaExtentReport.test.log(Status.INFO, "<b><i>Write GST Holder First Name</i></b>");
		
		QaRobot.PassValue("GSTHolderLastName", GST_Holder_Last_Name);
		QaExtentReport.test.log(Status.INFO, "<b><i>Write GST Holder Last Name</i></b>");
		
		QaRobot.PassValue("GSTEmail", GST_Holder_Email);
		QaExtentReport.test.log(Status.INFO, "<b><i>Write GST Holder Email</i></b>");
		
		QaRobot.ClickOnElement("Branch_save");
		QaExtentReport.test.log(Status.INFO, "<b><i>Click on save button</i></b>");
		
     	QaBrowser.driver.switchTo().alert().accept();
     	
        QaRobot.ClickOnElement("Close_Branch");
        QaExtentReport.test.log(Status.INFO, "<b><i>Close Branch</i></b>");
		
		QaRobot.ClickOnElement("Cost_center"); // cost center
		QaExtentReport.test.log(Status.INFO, "<b><i>Click on Cost center</i></b>");
		
		QaRobot.ClickOnElement("Add_cost_center");
		QaExtentReport.test.log(Status.INFO, "<b><i>Add cost center</i></b>");
		
		QaRobot.PassValue("Cost_center_code", Cost_Center_Code);
		QaExtentReport.test.log(Status.INFO, "<b><i>Write Cost center code</i></b>");
		
		QaRobot.PassValue("Cost_center_name", Cost_Center_Name);
		QaExtentReport.test.log(Status.INFO, "<b><i>Write Cost center name</i></b>");
		
		QaRobot.ClickOnElement("Active_status");
		QaExtentReport.test.log(Status.INFO, "<b><i>Check Active status</i></b>");
		
		QaRobot.ClickOnElement("Select_all");
		QaExtentReport.test.log(Status.INFO, "<b><i>Select all</i></b>");
		
		QaRobot.ClickOnElement("Save_btn");
		QaExtentReport.test.log(Status.INFO, "<b><i>Save_btn</i></b>");
		
		QaRobot.ClickOnElement("Btn_close");
		QaExtentReport.test.log(Status.INFO, "<b><i>Btn_close</i></b>");
	
		QaRobot.ClickOnElement("Manage_Project"); // Manage Project
		QaExtentReport.test.log(Status.INFO, "<b><i>Click on Manage_Project</i></b>");
		
		QaRobot.ClickOnElement("Add_Project");
		QaExtentReport.test.log(Status.INFO, "<b><i>Add Project</i></b>");
		
		QaRobot.PassValue("Project_code", Project_Code);
		QaExtentReport.test.log(Status.INFO, "<b><i>Write Project code</i></b>");
		
		QaRobot.PassValue("Project_name", Project_Name);
		QaExtentReport.test.log(Status.INFO, "<b><i>Write Project name</i></b>");
		
		QaRobot.ClickOnElement("Active_Project");
		QaExtentReport.test.log(Status.INFO, "<b><i>Check Active Project</i></b>");
		
		QaRobot.ClickOnElement("save_Project");
		QaExtentReport.test.log(Status.INFO, "<b><i>save Project</i></b>");
		
		   QaBrowser.driver.switchTo().alert().accept();
		   
		QaRobot.ClickOnElement("Close_project");
		QaExtentReport.test.log(Status.INFO, "<b><i>Close project</i></b>");
		
		QaRobot.ClickOnElement("Manage_Expense_Report"); // Manage Expense Report
		QaExtentReport.test.log(Status.INFO, "<b><i>Click on Manage Expense Report</i></b>");
		
		QaRobot.PassValue("Expense_category", Expense_Category);
		QaExtentReport.test.log(Status.INFO, "<b><i>Write Expense category</i></b>");
		
		QaRobot.ClickOnElement("Add_expense");
		QaExtentReport.test.log(Status.INFO, "<b><i>Click on Add expense</i></b>");
		
		QaRobot.ClickOnElement("Close_expense");
		QaExtentReport.test.log(Status.INFO, "<b><i>Close expense</i></b>");
		
		QaRobot.ClickOnElement("Manage_Business_Unit"); // Manage Project
		QaExtentReport.test.log(Status.INFO, "<b><i>Click on Manage_Business_Unit</i></b>");
		
		QaRobot.ClickOnElement("Add_business_unit");
		QaExtentReport.test.log(Status.INFO, "<b><i>Add business unit</i></b>");
		
		QaRobot.PassValue("Business_unit_code", Business_Unit_Code);
		QaExtentReport.test.log(Status.INFO, "<b><i>Write Business unit code</i></b>");
		
		QaRobot.PassValue("Business_Unit_Name", Business_Unit_Name);
		QaExtentReport.test.log(Status.INFO, "<b><i>Write Business Unit Name</i></b>");
		
		QaRobot.PassValue("Business_Unit_Head",Business_Unit_Head);
		QaExtentReport.test.log(Status.INFO, "<b><i>Write Business Unit Head</i></b>");
		
		QaRobot.PassValue("Business_Unit_Email", Business_Unit_Email);
		QaExtentReport.test.log(Status.INFO, "<b><i>Write Business Unit Email</i></b>");
		
		QaRobot.PassValue("Business_Unit_Contact_No", Business_Unit_Contact_No);
		QaExtentReport.test.log(Status.INFO, "<b><i>Write Business_Unit_Contact_No</i></b>");
		
		QaRobot.ClickOnElement("Active_business_unit"); // Business Unit
		QaExtentReport.test.log(Status.INFO, "<b><i>Check Active_business_unit</i></b>");
		
		QaRobot.ClickOnElement("Add_branch");
		QaExtentReport.test.log(Status.INFO, "<b><i>Add_branch</i></b>");
		
		QaRobot.ClickOnElement("Save_Unit");
		QaExtentReport.test.log(Status.INFO, "<b><i>Save Unit</i></b>");
		
		QaRobot.ClickOnElement("Close_unit");
		QaExtentReport.test.log(Status.INFO, "<b><i>Close unit</i></b>");
	}
	
	@AfterMethod
	public static void afterMetod() 
	{
		QaExtentReport.test.getExtent().flush();
	}
}

