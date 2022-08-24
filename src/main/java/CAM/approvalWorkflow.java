package CAM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
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
public class approvalWorkflow
{
	@DataProvider
	public Object[][] getexceldata() throws Exception 
	{
		return QaDataProvider.getTestdata("Approvalworkflow", "Sheet1");
	}

	@Test(dataProvider = "getexceldata")
	
	public static void Profiling(String Source,String URL, String Comapnycode,String Username, 
			String Password, String ApprovalProduct, String ApprovaTravelCategory, String WorkflowAppliedOn, 
			String TotalApprover,String ApprovalFlow,String InPolicyl1,String	InPolicyl1_title,String	InPolicyl2,
			String InPolicyl2_title,String	OutPolicy1,String OutPolicy1_title, String	OutPolicy2, String OutPolicy2_title) throws Exception {
		
		TestBase.Companycode(Source,URL); 
		QaRobot.impliwait(30);
		
		QaExtentReport.test = QaExtentReport.report.createTest("Test on Approval Work Flow");
		
		//write comapany code
		
		QaRobot.PassValue("Comapnycode",Comapnycode);
		QaExtentReport.test.log(Status.INFO,"<b><i>Write Comapny code</i></b>");
		
		QaRobot.PassValue("User_name",Username);
		QaExtentReport.test.log(Status.INFO,"<b><i>Write Username</i></b>");
		
		QaRobot.PassValue("Password",Password);
		QaExtentReport.test.log(Status.INFO, "<b><i>Write Password</i></b>");
		
		QaRobot.ClickOnElement("Submit");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on submit</i></b>");
		
		QaRobot.mouseHover("//a[@id='HeaderTop_aSetting']","//span[@id='HeaderTop_lblPolicyManagement']");
		
		//Approval Workflow
		
		QaRobot.ClickOnElement("Corporateapprovalworkflow");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Corporate approval workflow</i></b>");
		
		QaRobot.ClickOnElement("Add_approvalworkflow");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Add_approval workflow</i></b>");
	    
	    QaRobot.selectTextFromDropdown("Product_select", ApprovalProduct, "Select Product_select");
	    Thread.sleep(2000);
	   
	    QaRobot.selectTextFromDropdown("Travelcategory", ApprovaTravelCategory, "Travelcategory");
	    Thread.sleep(2000);

		QaRobot.selectTextFromDropdown("Workflowappliedon", WorkflowAppliedOn, "Select Workflowappliedon");
		Thread.sleep(2000);
	    
	    QaRobot.selectTextFromDropdown("Totalapprover",TotalApprover,"Select Totalapprover");
	    Thread.sleep(2000);
	
	    QaRobot.ClickOnElement("Add_All");
	    QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Add_All</i></b>");
		Thread.sleep(2000);
	    
	    if(ApprovalFlow.equalsIgnoreCase("Parallel"))
		{	
			WebElement element = QaBrowser.driver.findElement(By.xpath("//input[@id='rbtnlistApprovalFlow_0']"));
			JavascriptExecutor executor = (JavascriptExecutor)QaBrowser.driver;
			executor.executeScript("arguments[0].click();", element);
		}
		else if(ApprovalFlow.equalsIgnoreCase("Sequential"))
		{
			WebElement element = QaBrowser.driver.findElement(By.xpath("//input[@id='rbtnlistApprovalFlow_1']"));
			JavascriptExecutor executor = (JavascriptExecutor)QaBrowser.driver;
			executor.executeScript("arguments[0].click();", element);
		}
	    
	 TestBase.listofautosuggestion(By.xpath("//DIV[@id='divInPolicyApprover1']/p"), InPolicyl1, InPolicyl1_title, 
			By.xpath("//input[@id='txtInPolicyApprover1']"));
	 Thread.sleep(2000);
	 
	 TestBase.listofautosuggestion(By.xpath("//DIV[@id='divInPolicyApprover2']/p"), InPolicyl2, InPolicyl2_title, 
				By.xpath("//input[@id='txtInPolicyApprover2']"));
	 Thread.sleep(2000);
	 
	 TestBase.listofautosuggestion(By.xpath("//DIV[@id='divOutPolicyApprover1']/p"), OutPolicy1, OutPolicy1_title, 
				By.xpath("//input[@id='txtOutPolicyApprover1']"));
	 Thread.sleep(2000);

	 TestBase.listofautosuggestion(By.xpath("//DIV[@id='divOutPolicyApprover2']/p"), OutPolicy2, OutPolicy2_title, 
				By.xpath("//input[@id='txtOutPolicyApprover2']"));
	 Thread.sleep(2000);

	 QaRobot.ClickOnElement("Submit_btn");
	 QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Submit Button</i></b>");
	 Thread.sleep(2000);
}


	@AfterMethod
	public static void afterMetod() 
	{
		QaExtentReport.test.getExtent().flush();
	}
}

