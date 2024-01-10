package SBT_Corporate;

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
public class ExpenseManagementReport {
	@DataProvider
	public Object[][] getexceldata() throws Exception {
		return QaDataProvider.getTestdata("ExpenseManagement", "ExpensemgmtReport1");
	}

	@Test(dataProvider = "getexceldata")
	public static void Profiling1(String TestCaseId, String TestScenario, String Source, String URL, String Comapnycode,
			String LoginType, String Emailid, String SDN, String Username, String Password, String SelectReport,
			String ApplyFilter, String ReportType, String Branch, String CostCenter, String Department,
			String Designation, String Grade, String Project, String ProductName, String BranchNumber,
			String BranchName, String LSRReportType, String LSRDivision, String LSRDepartment, String LSRCostCenter,
			String LSRProductType) throws Exception {
		QaExtentReport.test = QaExtentReport.report.createTest(TestCaseId + "-" + TestScenario);
		TestBase.Companycode(Source, URL);
		QaRobot.impliwait(30);

		if (LoginType.equalsIgnoreCase("Old Url")) {
			QaRobot.PassValue("User_name", Username);
			QaExtentReport.test.log(Status.INFO, "<b><i>Write Username</i></b>");
			QaRobot.PassValue("Password", Password);
			QaExtentReport.test.log(Status.INFO, "<b><i>Write Password</i></b>");
			QaRobot.ClickOnElement("Submit");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on submit</i></b>");
		} else if (LoginType.equalsIgnoreCase("SSOLogin")) {
			QaRobot.PassValue("SSOEmail", Emailid);
			QaRobot.PassValue("SSOSDN", SDN);
			QaExtentReport.extentScreenshot("Sign In Page");
			QaRobot.ClickOnElement("SSOEncrypt");
			QaRobot.ClickOnElement("SSOSubmit");
		}
		if (SelectReport.equalsIgnoreCase("ExpenseReport")) {
			QaRobot.mouseHover("//a[@id='HeaderTop_aExpenseMngt']", "//span[@id='HeaderTop_lblReptDashboard']");
			Thread.sleep(10000);
//			QaRobot.ScreenshotMethod("CorporateDashboard", "<b><i>Screenshot for Corporate Dashboard Page</i></b>");
			if (ApplyFilter.equalsIgnoreCase("TRUE")) {
				expenseReport(ReportType, Branch, CostCenter, Department, Designation, Grade, Project);
				Thread.sleep(3000);
			} else if (ApplyFilter.equalsIgnoreCase("FALSE")) {
				System.out.println("Monthly Report");
				Thread.sleep(3000);
			}
		}

		else if (SelectReport.equalsIgnoreCase("Daily Sales Report")) {
			QaRobot.mouseHover("//a[@id='HeaderTop_aReportMenu']", "//span[@id='HeaderTop_lblSalesReport']");
			Thread.sleep(3000);

//			QaRobot.ScreenshotMethod("CorporateDashboard", "<b><i>Screenshot for Corporate Dashboard Page</i></b>");

			QaRobot.ClickOnElement("DailySalesReport");
			QaExtentReport.extentScreenshot("DailySalesReport");
//			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Daily Sales Report</i></b>");
			Thread.sleep(3000);

			if (ProductName.equalsIgnoreCase("All")) {
				DailySalesReports(BranchNumber, BranchName);
				Thread.sleep(3000);
			} else if (ProductName.equalsIgnoreCase("Flight")) {
				WebElement DropDown = QaBrowser.driver.findElement(By.xpath("//select[@id='ddlProductType']"));
				Select s = new Select(DropDown);
				s.selectByVisibleText(ProductName);
				Thread.sleep(3000);

				DailySalesReports(BranchNumber, BranchName);
				Thread.sleep(3000);
			} else if (ProductName.equalsIgnoreCase("Hotel")) {
				WebElement DropDown = QaBrowser.driver.findElement(By.xpath("//select[@id='ddlProductType']"));
				Select s = new Select(DropDown);
				s.selectByVisibleText(ProductName);
				Thread.sleep(3000);

				DailySalesReports(BranchNumber, BranchName);
				Thread.sleep(3000);
			}
			QaRobot.ClickOnElement("ReportSearch");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Search for Daily Sales Report</i></b>");
			Thread.sleep(3000);
		}

		else if (SelectReport.equalsIgnoreCase("Daily Refund Report")) {
			QaRobot.mouseHover("//a[@id='HeaderTop_aReportMenu']", "//span[@id='HeaderTop_lblSalesReport']");
			Thread.sleep(3000);

			QaRobot.ScreenshotMethod("CorporateDashboard", "<b><i>Screenshot for Corporate Dashboard Page</i></b>");
			Thread.sleep(3000);

			QaRobot.ClickOnElement("DailyRefundReport");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Daily Refund Report</i></b>");
			Thread.sleep(3000);

			if (ProductName.equalsIgnoreCase("All")) {
				DailyRefundReports(BranchNumber, BranchName);
				Thread.sleep(3000);
			} else if (ProductName.equalsIgnoreCase("Flight")) {
				WebElement DropDown = QaBrowser.driver.findElement(By.xpath("//select[@id='ddlProductType']"));
				Select s = new Select(DropDown);
				s.selectByVisibleText(ProductName);
				Thread.sleep(3000);

				DailyRefundReports(BranchNumber, BranchName);
				Thread.sleep(3000);
			}

			else if (ProductName.equalsIgnoreCase("Hotel")) {
				WebElement DropDown = QaBrowser.driver.findElement(By.xpath("//select[@id='ddlProductType']"));
				Select s = new Select(DropDown);
				s.selectByVisibleText(ProductName);
				Thread.sleep(3000);

				DailyRefundReports(BranchNumber, BranchName);
				Thread.sleep(3000);
			}
			QaRobot.ClickOnElement("ReportSearch");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Search for Daily Refund Report</i></b>");
			Thread.sleep(3000);
		}

		else if (SelectReport.equalsIgnoreCase("Loss Saving Report")) {
			QaRobot.mouseHover("//a[@id='HeaderTop_aReportMenu']", "//span[@id='HeaderTop_lblSalesReport']");
			Thread.sleep(3000);

			QaRobot.ScreenshotMethod("CorporateDashboard", "<b><i>Screenshot for Corporate Dashboard Page</i></b>");

			QaRobot.ClickOnElement("LossSavingReport");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Loss Saving Report</i></b>");
			Thread.sleep(3000);

			QaRobot.ClickOnElement("FilterYourResult");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Filter Your Result Button</i></b>");
			Thread.sleep(3000);

			QaRobot.ClickOnElement("LSRFromDate");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on From Date Button</i></b>");
			Thread.sleep(3000);

			QaRobot.ClickOnElement("LSRFromSelectDate");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on From Date Button</i></b>");
			Thread.sleep(3000);

			QaRobot.ClickOnElement("LSRToDate");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on To Date Button</i></b>");
			Thread.sleep(3000);

			QaRobot.ClickOnElement("LSRToSelectDate");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on From Date Button</i></b>");
			Thread.sleep(3000);

			if (LSRReportType.equalsIgnoreCase("Weekly")) {
				WebElement DropDown = QaBrowser.driver.findElement(By.xpath("//select[@id='ddlReportType']"));
				Select s = new Select(DropDown);
				s.selectByVisibleText(LSRReportType);
				Thread.sleep(3000);
			} else if (LSRReportType.equalsIgnoreCase("Monthly")) {
				WebElement DropDown = QaBrowser.driver.findElement(By.xpath("//select[@id='ddlReportType']"));
				Select s = new Select(DropDown);
				s.selectByVisibleText(LSRReportType);
				Thread.sleep(3000);
			} else if (LSRReportType.equalsIgnoreCase("Quarterly")) {
				WebElement DropDown = QaBrowser.driver.findElement(By.xpath("//select[@id='ddlReportType']"));
				Select s = new Select(DropDown);
				s.selectByVisibleText(LSRReportType);
				Thread.sleep(3000);
			} else if (LSRReportType.equalsIgnoreCase("Half Yearly")) {
				WebElement DropDown = QaBrowser.driver.findElement(By.xpath("//select[@id='ddlReportType']"));
				Select s = new Select(DropDown);
				s.selectByVisibleText(LSRReportType);
				Thread.sleep(3000);
			} else if (LSRReportType.equalsIgnoreCase("Yearly")) {
				WebElement DropDown = QaBrowser.driver.findElement(By.xpath("//select[@id='ddlReportType']"));
				Select s = new Select(DropDown);
				s.selectByVisibleText(LSRReportType);
				Thread.sleep(3000);
			}

			if (LSRDivision.equalsIgnoreCase("account")) {
				WebElement DropDown1 = QaBrowser.driver.findElement(By.xpath("//select[@id='ddlDivision']"));
				Select s1 = new Select(DropDown1);
				s1.selectByVisibleText(LSRDivision);
				Thread.sleep(3000);
			} else if (LSRDivision.equalsIgnoreCase("Developer")) {
				WebElement DropDown1 = QaBrowser.driver.findElement(By.xpath("//select[@id='ddlDivision']"));
				Select s1 = new Select(DropDown1);
				s1.selectByVisibleText(LSRDivision);
				Thread.sleep(3000);
			} else if (LSRDivision.equalsIgnoreCase("Support")) {
				WebElement DropDown1 = QaBrowser.driver.findElement(By.xpath("//select[@id='ddlDivision']"));
				Select s1 = new Select(DropDown1);
				s1.selectByVisibleText(LSRDivision);
				Thread.sleep(3000);
			} else if (LSRDivision.equalsIgnoreCase("Team")) {
				WebElement DropDown1 = QaBrowser.driver.findElement(By.xpath("//select[@id='ddlDivision']"));
				Select s1 = new Select(DropDown1);
				s1.selectByVisibleText(LSRDivision);
				Thread.sleep(3000);
			}

			if (LSRDepartment.equalsIgnoreCase("Support")) {
				WebElement DropDown2 = QaBrowser.driver.findElement(By.xpath("//select[@id='ddlDeparment']"));
				Select s2 = new Select(DropDown2);
				s2.selectByVisibleText(LSRDepartment);
				Thread.sleep(3000);
			} else if (LSRDepartment.equalsIgnoreCase("Developer")) {
				WebElement DropDown2 = QaBrowser.driver.findElement(By.xpath("//select[@id='ddlDeparment']"));
				Select s2 = new Select(DropDown2);
				s2.selectByVisibleText(LSRDepartment);
				Thread.sleep(3000);
			} else if (LSRDepartment.equalsIgnoreCase("QA")) {
				WebElement DropDown2 = QaBrowser.driver.findElement(By.xpath("//select[@id='ddlDeparment']"));
				Select s2 = new Select(DropDown2);
				s2.selectByVisibleText(LSRDepartment);
				Thread.sleep(3000);
			}

			if (LSRCostCenter.equalsIgnoreCase("QA")) {
				WebElement DropDown3 = QaBrowser.driver.findElement(By.xpath("//select[@id='ddlCostCenter']"));
				Select s3 = new Select(DropDown3);
				s3.selectByVisibleText(LSRCostCenter);
				Thread.sleep(3000);
			} else if (LSRCostCenter.equalsIgnoreCase("Developer")) {
				WebElement DropDown3 = QaBrowser.driver.findElement(By.xpath("//select[@id='ddlCostCenter']"));
				Select s3 = new Select(DropDown3);
				s3.selectByVisibleText(LSRCostCenter);
				Thread.sleep(3000);
			} else if (LSRCostCenter.equalsIgnoreCase("Support")) {
				WebElement DropDown3 = QaBrowser.driver.findElement(By.xpath("//select[@id='ddlCostCenter']"));
				Select s3 = new Select(DropDown3);
				s3.selectByVisibleText(LSRCostCenter);
				Thread.sleep(3000);
			} else if (LSRCostCenter.equalsIgnoreCase("Team")) {
				WebElement DropDown3 = QaBrowser.driver.findElement(By.xpath("//select[@id='ddlCostCenter']"));
				Select s3 = new Select(DropDown3);
				s3.selectByVisibleText(LSRCostCenter);
				Thread.sleep(3000);
			}

			if (LSRProductType.equalsIgnoreCase("Flight")) {
				WebElement DropDown4 = QaBrowser.driver.findElement(By.xpath("//select[@id='ddlProduct']"));
				Select s4 = new Select(DropDown4);
				s4.selectByVisibleText(LSRProductType);
				Thread.sleep(3000);
			} else if (LSRProductType.equalsIgnoreCase("Hotel")) {
				WebElement DropDown4 = QaBrowser.driver.findElement(By.xpath("//select[@id='ddlProduct']"));
				Select s4 = new Select(DropDown4);
				s4.selectByVisibleText(LSRProductType);
				Thread.sleep(3000);
			}
			QaRobot.ClickOnElement("LSRSearch");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Loss Saving Reports Search Button</i></b>");
			Thread.sleep(3000);

			QaRobot.ClickOnElement("ExportToExcel");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Export To Excel Button</i></b>");
			Thread.sleep(3000);
		}

		else if (SelectReport.equalsIgnoreCase("Report Dashboard")) {
			QaRobot.mouseHover("//a[@id='HeaderTop_aReportMenu']", "//span[@id='HeaderTop_lblSalesReport']");
			Thread.sleep(3000);

			QaRobot.ScreenshotMethod("CorporateDashboard", "<b><i>Screenshot for Corporate Dashboard Page</i></b>");

			QaRobot.ClickOnElement("ReportDashboard");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Report Dashboard</i></b>");
			Thread.sleep(3000);

			if (ApplyFilter.equalsIgnoreCase("TRUE")) {
				Reports(ReportType, Branch, CostCenter, Department, Designation, Grade, Project);
				Thread.sleep(3000);
			} else if (ApplyFilter.equalsIgnoreCase("FALSE")) {
				System.out.println("Yearly Report");
				Thread.sleep(3000);
			}
		}
	}

	@AfterMethod
	public static void afterMetod() {
		QaExtentReport.test.getExtent().flush();
//		QaBrowser.driver.close();
	}

	public static void expenseReport(String ReportType, String Branch, String CostCenter, String Department,
			String Designation, String Grade, String Project) throws Exception {
		QaRobot.ClickOnElement("ReportType");
		QaExtentReport.extentScreenshot("ReportType");
		Thread.sleep(5000);

		if (ReportType.equalsIgnoreCase("Monthly")) {
			QaRobot.ClickOnElement("Monthly");
			Thread.sleep(5000);
		} else if (ReportType.equalsIgnoreCase("Quarterly")) {
			QaRobot.ClickOnElement("Quarterly");
			Thread.sleep(5000);
		} else if (ReportType.equalsIgnoreCase("Half Yearly")) {
			QaRobot.ClickOnElement("HalfYearly");
			Thread.sleep(5000);
		} else if (ReportType.equalsIgnoreCase("Yearly")) {
			QaRobot.ClickOnElement("Yearly");
			Thread.sleep(5000);
		}
//		QaRobot.ScreenshotMethod("ReportType", "<b><i>Screenshot for Report Type</i></b>");
		QaRobot.ClickOnElement("MainNavigation");
		Thread.sleep(5000);
		QaRobot.ClickOnElement("Branch");
		Thread.sleep(5000);
		if (Branch.equalsIgnoreCase("Chennai1")) {
			QaRobot.ClickOnElement("Chennai1Branch");
			Thread.sleep(5000);
		} else if (Branch.equalsIgnoreCase("Test117")) {
			QaRobot.ClickOnElement("Test117777");
			Thread.sleep(5000);
		} else if (Branch.equalsIgnoreCase("Delhi")) {
			QaRobot.ClickOnElement("DelhiBranch");
			Thread.sleep(5000);
		} else if (Branch.equalsIgnoreCase("Mumbai")) {
			QaRobot.ClickOnElement("MumbaiBranch");
			Thread.sleep(5000);
		} else if (Branch.equalsIgnoreCase("poonam")) {
			QaRobot.ClickOnElement("Poonamcorp");
			Thread.sleep(5000);
		}
		QaExtentReport.extentScreenshot("BranchReport");

		QaRobot.ClickOnElement("CostCenter");
		Thread.sleep(5000);
		if (CostCenter.equalsIgnoreCase("QA")) {
			QaRobot.ClickOnElement("QA");
			Thread.sleep(5000);
		} else if (CostCenter.equalsIgnoreCase("Developer")) {
			QaRobot.ClickOnElement("Developer");
			Thread.sleep(5000);
		} else if (CostCenter.equalsIgnoreCase("Support")) {
			QaRobot.ClickOnElement("Support");
			Thread.sleep(5000);
		} else if (CostCenter.equalsIgnoreCase("Team")) {
			QaRobot.ClickOnElement("Team");
			Thread.sleep(5000);
		}
		QaExtentReport.extentScreenshot("Costcenter Report");

		QaRobot.ClickOnElement("Department");
		Thread.sleep(5000);
		if (Department.equalsIgnoreCase("HRDepart")) {
			QaRobot.ClickOnElement("HRDepart");
			Thread.sleep(5000);
		} else if (Department.equalsIgnoreCase("Developerdepart")) {
			QaRobot.ClickOnElement("Developerdepart");
			Thread.sleep(5000);
		} else if (Department.equalsIgnoreCase("QA123")) {
			QaRobot.ClickOnElement("QA123depart");
			Thread.sleep(5000);
		} else if (Department.equalsIgnoreCase("QA")) {
			QaRobot.ClickOnElement("QADepart");
			Thread.sleep(5000);
		} else if (Department.equalsIgnoreCase("FinanceDepa")) {
			QaRobot.ClickOnElement("FinanceDepart");
			Thread.sleep(5000);
		}
		QaExtentReport.extentScreenshot("Department Report");

		QaRobot.ClickOnElement("Designation");
		Thread.sleep(5000);
		if (Designation.equalsIgnoreCase("QA")) {
			QaRobot.ClickOnElement("QADesign");
			Thread.sleep(5000);
		} else if (Designation.equalsIgnoreCase("CEO")) {
			QaRobot.ClickOnElement("CEODesign");
			Thread.sleep(5000);
		} else if (Designation.equalsIgnoreCase("Developer")) {
			QaRobot.ClickOnElement("DeveloperDesign");
			Thread.sleep(5000);
		} else if (Designation.equalsIgnoreCase("Manager")) {
			QaRobot.ClickOnElement("Managerdesign");
			Thread.sleep(5000);
		}
		QaExtentReport.extentScreenshot("Designation Report");

		QaRobot.ClickOnElement("Grade");
		Thread.sleep(5000);
		if (Grade.equalsIgnoreCase("Grade1")) {
			QaRobot.ClickOnElement("Grade1");
			Thread.sleep(5000);
		} else if (Grade.equalsIgnoreCase("Grade10")) {
			QaRobot.ClickOnElement("Grade101");
			Thread.sleep(5000);
		} else if (Grade.equalsIgnoreCase("L4")) {
			QaRobot.ClickOnElement("L4Grade");
			Thread.sleep(5000);
		} else if (Grade.equalsIgnoreCase("Team")) {
			QaRobot.ClickOnElement("Team2");
			Thread.sleep(5000);
		}
		QaExtentReport.extentScreenshot("Grade Report");

		QaRobot.ClickOnElement("Project");
		Thread.sleep(5000);
		if (Project.equalsIgnoreCase("Testproject")) {
			QaRobot.ClickOnElement("TestProjectTravog");
			Thread.sleep(5000);
		} else if (Project.equalsIgnoreCase("Developer")) {
			QaRobot.ClickOnElement("Developer4");
			Thread.sleep(5000);
		} else if (Project.equalsIgnoreCase("Support")) {
			QaRobot.ClickOnElement("Support4");
			Thread.sleep(5000);
		} else if (Project.equalsIgnoreCase("Team")) {
			QaRobot.ClickOnElement("Team3");
			Thread.sleep(5000);
		}
		QaExtentReport.extentScreenshot("Project Report");
//		QaRobot.ScreenshotMethod("Project", "<b><i>Screenshot for Project Type</i></b>");
	}

	public static void DailySalesReports(String BranchNumber, String BranchName) throws Exception {
		QaRobot.ClickOnElement("FromDate");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Daily Sales Report</i></b>");
		Thread.sleep(3000);

		QaRobot.ClickOnElement("PreviousYear");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Daily Sales Report</i></b>");
		Thread.sleep(3000);

		QaRobot.ClickOnElement("FromSelectDate");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Daily Sales Report</i></b>");
		Thread.sleep(3000);

		QaRobot.ClickOnElement("ToDate");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Daily Sales Report</i></b>");
		Thread.sleep(3000);

		QaRobot.ClickOnElement("ToSelectDate");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Daily Sales Report</i></b>");
		Thread.sleep(3000);

		int bN = Integer.parseInt(BranchNumber);
		for (int i = 1; i <= bN; i++) {
			String[] BranchN = BranchName.split(",");
			String a = BranchN[i - 1];
			TestBase.listofautosuggestion3(By.xpath("//select[@id='frmbranch']/option"), a,
					By.xpath("//input[@id='branch_insert']"));
		}
	}

	public static void DailyRefundReports(String BranchNumber, String BranchName) throws Exception {
		QaRobot.ClickOnElement("RFromDate");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Daily Sales Report</i></b>");
		Thread.sleep(3000);

		QaRobot.ClickOnElement("PreviousYear");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Daily Sales Report</i></b>");
		Thread.sleep(3000);

		QaRobot.ClickOnElement("FromSelectDate");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Daily Sales Report</i></b>");
		Thread.sleep(3000);

		QaRobot.ClickOnElement("RToDate");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Daily Sales Report</i></b>");
		Thread.sleep(3000);

		QaRobot.ClickOnElement("ToSelectDate");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Daily Sales Report</i></b>");
		Thread.sleep(3000);

		int bN = Integer.parseInt(BranchNumber);
		for (int i = 1; i <= bN; i++) {
			String[] BranchN = BranchName.split(",");
			String a = BranchN[i - 1];
			TestBase.listofautosuggestion3(By.xpath("//select[@id='frmbranch']/option"), a,
					By.xpath("//input[@id='branch_insert']"));
		}
	}

	public static void Reports(String ReportType, String Branch, String CostCenter, String Department,
			String Designation, String Grade, String Project) throws Exception {
		QaRobot.ClickOnElement("ReportsType");
		Thread.sleep(5000);

		if (ReportType.equalsIgnoreCase("Monthly")) {
			QaRobot.ClickOnElement("Monthly");
			Thread.sleep(5000);

			Alert alt = QaBrowser.driver.switchTo().alert();
			alt.accept();
		} else if (ReportType.equalsIgnoreCase("Quarterly")) {
			QaRobot.ClickOnElement("Quarterly");
			Thread.sleep(5000);

			Alert alt = QaBrowser.driver.switchTo().alert();
			alt.accept();
		} else if (ReportType.equalsIgnoreCase("Half Yearly")) {
			QaRobot.ClickOnElement("HalfYearly");
			Thread.sleep(5000);

			Alert alt = QaBrowser.driver.switchTo().alert();
			alt.accept();
		} else if (ReportType.equalsIgnoreCase("Yearly")) {
			QaRobot.ClickOnElement("Yearly");
			Thread.sleep(5000);

			Alert alt = QaBrowser.driver.switchTo().alert();
			alt.accept();
		}

		QaRobot.ScreenshotMethod("ReportType", "<b><i>Screenshot for Report Type</i></b>");

		QaRobot.ClickOnElement("MainNavigation");
		Thread.sleep(5000);

		QaRobot.ScreenshotMethod("MainNavigation", "<b><i>Screenshot for Main Navigation</i></b>");

		QaRobot.ClickOnElement("ReportsBranch");
		Thread.sleep(5000);

		if (Branch.equalsIgnoreCase("Apple")) {
			QaRobot.ClickOnElement("Apple");
			Thread.sleep(5000);

			Alert alt = QaBrowser.driver.switchTo().alert();
			alt.accept();
		} else if (Branch.equalsIgnoreCase("Imagine")) {
			QaRobot.ClickOnElement("Imagine");
			Thread.sleep(5000);

			Alert alt = QaBrowser.driver.switchTo().alert();
			alt.accept();
		} else if (Branch.equalsIgnoreCase("Igenica")) {
			QaRobot.ClickOnElement("Igenica");
			Thread.sleep(5000);

			Alert alt = QaBrowser.driver.switchTo().alert();
			alt.accept();
		} else if (Branch.equalsIgnoreCase("DelhiBranch")) {
			QaRobot.ClickOnElement("DelhiBranch");
			Thread.sleep(5000);

			Alert alt = QaBrowser.driver.switchTo().alert();
			alt.accept();
		}

		QaRobot.ScreenshotMethod("Branch", "<b><i>Screenshot for Branch Type</i></b>");

		QaRobot.ClickOnElement("ReportsCostCenter");
		Thread.sleep(5000);

		if (CostCenter.equalsIgnoreCase("QA")) {
			QaRobot.ClickOnElement("QA");
			Thread.sleep(5000);

			Alert alt = QaBrowser.driver.switchTo().alert();
			alt.accept();
		} else if (CostCenter.equalsIgnoreCase("Developer")) {
			QaRobot.ClickOnElement("Developer");
			Thread.sleep(5000);

			Alert alt = QaBrowser.driver.switchTo().alert();
			alt.accept();
		} else if (CostCenter.equalsIgnoreCase("Support")) {
			QaRobot.ClickOnElement("Support");
			Thread.sleep(5000);

			Alert alt = QaBrowser.driver.switchTo().alert();
			alt.accept();
		} else if (CostCenter.equalsIgnoreCase("Team")) {
			QaRobot.ClickOnElement("Team");
			Thread.sleep(5000);

			Alert alt = QaBrowser.driver.switchTo().alert();
			alt.accept();
		}

		QaRobot.ScreenshotMethod("CostCenter", "<b><i>Screenshot for Cost Center Type</i></b>");

		QaRobot.ClickOnElement("ReportsDepartment");
		Thread.sleep(5000);

		if (Department.equalsIgnoreCase("Support")) {
			QaRobot.ClickOnElement("Support1");
			Thread.sleep(5000);

			Alert alt = QaBrowser.driver.switchTo().alert();
			alt.accept();
		} else if (Department.equalsIgnoreCase("Developer")) {
			QaRobot.ClickOnElement("Developer1");
			Thread.sleep(5000);

			Alert alt = QaBrowser.driver.switchTo().alert();
			alt.accept();
		} else if (Department.equalsIgnoreCase("QA")) {
			QaRobot.ClickOnElement("QA1");
			Thread.sleep(5000);

			Alert alt = QaBrowser.driver.switchTo().alert();
			alt.accept();
		}

		QaRobot.ScreenshotMethod("Department", "<b><i>Screenshot for Department Type</i></b>");

		QaRobot.ClickOnElement("ReportsDesignation");
		Thread.sleep(5000);

		if (Designation.equalsIgnoreCase("Team")) {
			QaRobot.ClickOnElement("Team1");
			Thread.sleep(5000);

			Alert alt = QaBrowser.driver.switchTo().alert();
			alt.accept();
		} else if (Designation.equalsIgnoreCase("Support")) {
			QaRobot.ClickOnElement("Support2");
			Thread.sleep(5000);

			Alert alt = QaBrowser.driver.switchTo().alert();
			alt.accept();
		} else if (Designation.equalsIgnoreCase("Developer")) {
			QaRobot.ClickOnElement("Developer2");
			Thread.sleep(5000);

			Alert alt = QaBrowser.driver.switchTo().alert();
			alt.accept();
		} else if (Designation.equalsIgnoreCase("Tester")) {
			QaRobot.ClickOnElement("Tester");
			Thread.sleep(5000);

			Alert alt = QaBrowser.driver.switchTo().alert();
			alt.accept();
		}

		QaRobot.ScreenshotMethod("Designation", "<b><i>Screenshot for Designation Type</i></b>");

		QaRobot.ClickOnElement("ReportsGrade");
		Thread.sleep(5000);

		if (Grade.equalsIgnoreCase("Sales")) {
			QaRobot.ClickOnElement("Sales");
			Thread.sleep(5000);

			Alert alt = QaBrowser.driver.switchTo().alert();
			alt.accept();
		} else if (Grade.equalsIgnoreCase("Developer")) {
			QaRobot.ClickOnElement("Developer3");
			Thread.sleep(5000);

			Alert alt = QaBrowser.driver.switchTo().alert();
			alt.accept();
		} else if (Grade.equalsIgnoreCase("Support")) {
			QaRobot.ClickOnElement("Support3");
			Thread.sleep(5000);

			Alert alt = QaBrowser.driver.switchTo().alert();
			alt.accept();
		} else if (Grade.equalsIgnoreCase("Team")) {
			QaRobot.ClickOnElement("Team2");
			Thread.sleep(5000);

			Alert alt = QaBrowser.driver.switchTo().alert();
			alt.accept();
		}

		QaRobot.ScreenshotMethod("Grade", "<b><i>Screenshot for Grade Type</i></b>");

		QaRobot.ClickOnElement("ReportsProject");
		Thread.sleep(5000);

		if (Project.equalsIgnoreCase("Account")) {
			QaRobot.ClickOnElement("Account");
			Thread.sleep(5000);

			Alert alt = QaBrowser.driver.switchTo().alert();
			alt.accept();
		} else if (Project.equalsIgnoreCase("Developer")) {
			QaRobot.ClickOnElement("Developer4");
			Thread.sleep(5000);

			Alert alt = QaBrowser.driver.switchTo().alert();
			alt.accept();
		} else if (Project.equalsIgnoreCase("Support")) {
			QaRobot.ClickOnElement("Support4");
			Thread.sleep(5000);

			Alert alt = QaBrowser.driver.switchTo().alert();
			alt.accept();
		} else if (Project.equalsIgnoreCase("Team")) {
			QaRobot.ClickOnElement("Team3");
			Thread.sleep(5000);

			Alert alt = QaBrowser.driver.switchTo().alert();
			alt.accept();
		}
		QaRobot.ScreenshotMethod("Project", "<b><i>Screenshot for Project Type</i></b>");
	}
}
