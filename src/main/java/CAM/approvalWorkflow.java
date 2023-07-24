package CAM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Base.TestBase;
import utilities.QaBrowser;
import utilities.QaDataProvider;
import utilities.QaExtentReport;
import utilities.QaRobot;

@Listeners(listenerClass.Listener.class)
public class approvalWorkflow {
	
	@DataProvider
	public Object[][] getexceldata() throws Exception {
		return QaDataProvider.getTestdata("Approvalworkflow", "Sheet2");
	}

	@Test(dataProvider = "getexceldata")
	public static void Profiling(String Source, String URL, String Comapnycode, String Username, String Password,
			String ApprovalProduct, String ApprovaTravelCategory, String WorkflowAppliedOn, String SelectQty,
			String SelectFromList, String TotalApprover, String ApprovalFlow, String InPolicyl1,
			String InPolicyl1_title, String InPolicyl2, String InPolicyl2_title, String OutPolicy1,
			String OutPolicy1_title, String OutPolicy2, String OutPolicy2_title) throws Exception {

		TestBase.Companycode(Source, URL);
		QaRobot.impliwait(30);

		QaExtentReport.test = QaExtentReport.report.createTest("Test on Approval Work Flow");
//		QaRobot.PassValue("Comapnycode",Comapnycode);
		QaRobot.PassValue("User_name", Username);
		QaRobot.PassValue("Password", Password);
		QaRobot.ClickOnElement("Submit");
		QaRobot.mouseHover("//a[@id='HeaderTop_aSetting']", "//span[@id='HeaderTop_lblPolicyManagement']");
		QaRobot.ClickOnElement("Corporateapprovalworkflow");
		QaRobot.ClickOnElement("Add_approvalworkflow");
		QaRobot.selectTextFromDropdown("Product_select", ApprovalProduct);
		Thread.sleep(2000);
		QaRobot.selectTextFromDropdown("Travelcategory", ApprovaTravelCategory);
		Thread.sleep(2000);
		QaRobot.selectTextFromDropdown("Workflowappliedon", WorkflowAppliedOn);
		Thread.sleep(2000);
		QaRobot.selectTextFromDropdown("Totalapprover", TotalApprover);
		Thread.sleep(5000);
		int pAS = Integer.parseInt(SelectQty);
		for (int i = 1; i <= pAS; i++) {
			String[] tN = SelectFromList.split(",");
			String b = tN[i - 1];
			List<WebElement> listOfRights = QaBrowser.driver.findElements(By.xpath("//select[@id='listUser']/option"));
			for (WebElement autoRights : listOfRights) {
				if (autoRights.getText().equalsIgnoreCase(b)) {
					autoRights.click();
					QaRobot.ClickOnElement("AddList");
				}
			}
		}
		Thread.sleep(5000);
		if (ApprovalFlow.equalsIgnoreCase("Parallel")) {
			WebElement element = QaBrowser.driver.findElement(By.xpath("//input[@id='rbtnlistApprovalFlow_0']"));
			JavascriptExecutor executor = (JavascriptExecutor) QaBrowser.driver;
			executor.executeScript("arguments[0].click();", element);
		} else if (ApprovalFlow.equalsIgnoreCase("Sequential")) {
			WebElement element = QaBrowser.driver.findElement(By.xpath("//input[@id='rbtnlistApprovalFlow_1']"));
			JavascriptExecutor executor = (JavascriptExecutor) QaBrowser.driver;
			executor.executeScript("arguments[0].click();", element);
		}
		Thread.sleep(3000);
		if (TotalApprover.equalsIgnoreCase("1")) {
			TestBase.listofautosuggestion(By.xpath("//DIV[@id='divInPolicyApprover1']/p"), InPolicyl1, InPolicyl1_title,
					By.xpath("//input[@id='txtInPolicyApprover1']"));
			QaBrowser.driver.findElement(By.xpath("//div[@id='divInPolicyApprover1']/p[2]")).click();
			Thread.sleep(2000);

			TestBase.listofautosuggestion(By.xpath("//DIV[@id='divOutPolicyApprover1']/p"), OutPolicy1,
					OutPolicy1_title, By.xpath("//input[@id='txtOutPolicyApprover1']"));
			QaBrowser.driver.findElement(By.xpath("//div[@id='divOutPolicyApprover1']/p[2]")).click();
			Thread.sleep(2000);
		} else if (TotalApprover.equalsIgnoreCase("2")) {
			TestBase.listofautosuggestion(By.xpath("//DIV[@id='divInPolicyApprover1']/p"), InPolicyl1, InPolicyl1_title,
					By.xpath("//input[@id='txtInPolicyApprover1']"));
			QaBrowser.driver.findElement(By.xpath("//div[@id='divInPolicyApprover1']/p[2]")).click();
			Thread.sleep(2000);

			TestBase.listofautosuggestion(By.xpath("//DIV[@id='divInPolicyApprover2']/p"), InPolicyl2, InPolicyl2_title,
					By.xpath("//input[@id='txtInPolicyApprover2']"));
			QaBrowser.driver.findElement(By.xpath("//div[@id='divInPolicyApprover2']/p[2]")).click();
			Thread.sleep(2000);

			TestBase.listofautosuggestion(By.xpath("//DIV[@id='divOutPolicyApprover1']/p"), OutPolicy1,
					OutPolicy1_title, By.xpath("//input[@id='txtOutPolicyApprover1']"));
			QaBrowser.driver.findElement(By.xpath("//div[@id='divOutPolicyApprover1']/p[2]")).click();
			Thread.sleep(2000);

			TestBase.listofautosuggestion(By.xpath("//DIV[@id='divOutPolicyApprover2']/p"), OutPolicy2,
					OutPolicy2_title, By.xpath("//input[@id='txtOutPolicyApprover2']"));
			QaBrowser.driver.findElement(By.xpath("//div[@id='divOutPolicyApprover2']/p[2]")).click();
			Thread.sleep(2000);
		}
		QaRobot.ClickOnElement("Submit_btn");
	}

	@AfterMethod
	public static void afterMetod() {
//		QaExtentReport.test.getExtent().flush();
	}
}
