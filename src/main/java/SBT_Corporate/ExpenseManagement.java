package SBT_Corporate;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

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
public class ExpenseManagement {
	@DataProvider
	public Object[][] getexceldata() throws Exception {
		return QaDataProvider.getTestdata("ExpenseManagement", "Sheet1");
	}

	@Test(dataProvider = "getexceldata")
	public static void Profiling1(String TestCaseId, String TestScenario, String Source, String URL, String Comapnycode,
			String LoginType, String Emailid, String SDN, String Username, String Password, String TripName,
			String Destination, String Destination_Name, String Start_Date, String End_Date, String TripType,
			String CostCenter, String PerDiemCurrency, String AdvanceCurrency, String Projectsheet,
			String PerDiemAmmount, String AdvanceAmount, String Description, String Category, String Merchant,
			String ExpenseFromDate, String ExpenseToDate, String ExpenseCurrency, String ExpenseAmount,
			String GSTNumber, String ModeOfPayment, String ExpenceComment, String Conveyance, String ConveyanceType,
			String Corigin, String COrigin_Name, String CDestination, String CDestination_Name,
			String ConveyanceFromDate, String ConveyanceToDate) throws Exception {
		QaExtentReport.test = QaExtentReport.report.createTest(TestCaseId + "-" + TestScenario);
		TestBase.Companycode(Source, URL);
		QaRobot.impliwait(30);
		if (LoginType.equalsIgnoreCase("Old Url")) {
			QaRobot.PassValue("User_name", Username);
//			QaExtentReport.test.log(Status.INFO, "<b><i>Write Username</i></b>");
			QaRobot.PassValue("Password", Password);
//			QaExtentReport.test.log(Status.INFO, "<b><i>Write Password</i></b>");
			QaRobot.ClickOnElement("Submit");
//			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on submit</i></b>");
		} else if (LoginType.equalsIgnoreCase("SSOLogin")) {
			QaRobot.PassValue("SSOEmail", Emailid);
			QaRobot.PassValue("SSOSDN", SDN);
			QaExtentReport.extentScreenshot("Sign In Page");
			QaRobot.ClickOnElement("SSOEncrypt");
			QaRobot.ClickOnElement("SSOSubmit");
		}
		// QaRobot.ScreenshotMethod("CorporateLogin","<b><i>Screenshot for Corporate
		// Login Page</i></b>");
		QaRobot.mouseHover("//a[@id='HeaderTop_aExpenseMngt']", "//span[@id='HeaderTop_lbltripsheet']");
//		QaRobot.ScreenshotMethod("CorporateDashboard","<b><i>Screenshot for Corporate Dashboard Page</i></b>");
		QaRobot.ClickOnElement("NewTrip");
		Thread.sleep(2000);
		QaExtentReport.extentScreenshot("New Expense sheet");

		String ParentWindow = QaBrowser.driver.getWindowHandle();
		Set<String> handles = QaBrowser.driver.getWindowHandles();
		for (String childWindow : handles) {
			if (!childWindow.equals(ParentWindow))
				QaBrowser.driver.switchTo().window(childWindow);
		}
		QaRobot.PassValue("TripName", TripName);
		QaExtentReport.test.log(Status.INFO, "<b><i>Trip Name is </i></b>" + TripName);
		Thread.sleep(2000);
		TestBase.listofautosuggestion(By.xpath("//div[@id='divTripDestinationCity']/p"), Destination, Destination_Name,
				By.xpath("//input[@id='txtDestination']"));
		Thread.sleep(3000);
//		QaExtentReport.test.log(Status.INFO, "<b><i>Destination city is </i></b>" + Destination_Name);
		String DateSelection[] = Start_Date.split("-");
		String year = DateSelection[2];
		String month = DateSelection[1];
		String expDate = DateSelection[0];
		String DateSelection1[] = End_Date.split("-");
		String year1 = DateSelection1[2];
		String month1 = DateSelection1[1];
		String expDate1 = DateSelection1[0];
		QaBrowser.driver.findElement(By.xpath("//div[@id='div_form']/div/div[3]/div/div[3]/div/div/span")).click();
		Thread.sleep(2000);
		selectDateInCalendarRoundTripNew(expDate, month, year, expDate1, month1, year1);

//		if (Next.equalsIgnoreCase("CurrentMonth")) {
//			QaBrowser.driver.findElement(By.xpath("//input[@id='txtStartDate']")).click();
//			QaBrowser.driver.findElement(By.xpath("//a[contains(@title,'" + Start_Date + "')]")).click();
//			QaExtentReport.test.log(Status.INFO, "<b><i>Start date is </i></b>" + Start_Date);
//			QaBrowser.driver.findElement(By.xpath("//input[@id='txtEndDate']")).click();
//			QaBrowser.driver.findElement(By.xpath("//a[contains(@title,'" + End_Date + "')]")).click();
//			QaExtentReport.test.log(Status.INFO, "<b><i>End date is </i></b>" + End_Date);
//		} else if (Next.equalsIgnoreCase("NextMonth")) {
//			QaBrowser.driver.findElement(By.xpath("//input[@id='txtStartDate']")).click();
//			Thread.sleep(2000);
//			QaRobot.ClickOnElement("NextmonthButton");
//			Thread.sleep(2000);
//			QaBrowser.driver.findElement(By.xpath("//a[contains(@title,'" + Start_Date + "')]")).click();
//			QaExtentReport.test.log(Status.INFO, "<b><i>Start date is </i></b>" + Start_Date);
//
//			QaBrowser.driver.findElement(By.xpath("//input[@id='txtEndDate']")).click();
//			QaBrowser.driver.findElement(By.xpath("//a[contains(@title,'" + End_Date + "')]")).click();
//			QaExtentReport.test.log(Status.INFO, "<b><i>End date is </i></b>" + End_Date);
//
//		}
		expense(TripType, CostCenter, PerDiemCurrency, AdvanceCurrency, Projectsheet, PerDiemAmmount, AdvanceAmount,
				Description);
		QaBrowser.driver.switchTo().window(ParentWindow);
		expense1(Category, Merchant, ExpenseFromDate, ExpenseToDate, ExpenseCurrency, ExpenseAmount, GSTNumber,
				ModeOfPayment, ExpenceComment, Conveyance, ConveyanceType, Corigin, COrigin_Name, CDestination,
				CDestination_Name, ConveyanceFromDate, ConveyanceToDate);
	}

	@AfterMethod
	public static void afterMetod() {
		QaExtentReport.test.getExtent().flush();
//		QaBrowser.driver.close(); 
	}

	public static void selectDateInCalendarRoundTripNew(String Day, String Month, String Year, String Day1,
			String Month1, String Year1) throws InterruptedException, ParseException {
		Date date = new Date();
		DateFormat d = new SimpleDateFormat("dd-MM-yyyy");
		String NewDate = d.format(date);
		Date date1 = d.parse(NewDate);
		System.out.println(date1);

		String currentMonthNumber = "00";
		if (Month.equalsIgnoreCase("Jan")) {
			currentMonthNumber = "01";
		} else if (Month.equalsIgnoreCase("Feb")) {
			currentMonthNumber = "02";
		} else if (Month.equalsIgnoreCase("Mar")) {
			currentMonthNumber = "03";
		} else if (Month.equalsIgnoreCase("Apr")) {
			currentMonthNumber = "04";
		} else if (Month.equalsIgnoreCase("May")) {
			currentMonthNumber = "05";
		} else if (Month.equalsIgnoreCase("Jun")) {
			currentMonthNumber = "06";
		} else if (Month.equalsIgnoreCase("Jul")) {
			currentMonthNumber = "07";
		} else if (Month.equalsIgnoreCase("Aug")) {
			currentMonthNumber = "08";
		} else if (Month.equalsIgnoreCase("Sep")) {
			currentMonthNumber = "09";
		} else if (Month.equalsIgnoreCase("Oct")) {
			currentMonthNumber = "10";
		} else if (Month.equalsIgnoreCase("Nov")) {
			currentMonthNumber = "11";
		} else if (Month.equalsIgnoreCase("Dec")) {
			currentMonthNumber = "12";
		}
		Date date2 = d.parse(Day + "-" + Integer.parseInt(currentMonthNumber) + "-" + Year);
		System.out.println(date2);

		String currentMonthNumber1 = "00";
		if (Month.equalsIgnoreCase("Jan")) {
			currentMonthNumber1 = "01";
		} else if (Month.equalsIgnoreCase("Feb")) {
			currentMonthNumber1 = "02";
		} else if (Month.equalsIgnoreCase("Mar")) {
			currentMonthNumber1 = "03";
		} else if (Month.equalsIgnoreCase("Apr")) {
			currentMonthNumber1 = "04";
		} else if (Month.equalsIgnoreCase("May")) {
			currentMonthNumber1 = "05";
		} else if (Month.equalsIgnoreCase("Jun")) {
			currentMonthNumber1 = "06";
		} else if (Month.equalsIgnoreCase("Jul")) {
			currentMonthNumber1 = "07";
		} else if (Month.equalsIgnoreCase("Aug")) {
			currentMonthNumber1 = "08";
		} else if (Month.equalsIgnoreCase("Sep")) {
			currentMonthNumber1 = "09";
		} else if (Month.equalsIgnoreCase("Oct")) {
			currentMonthNumber1 = "10";
		} else if (Month.equalsIgnoreCase("Nov")) {
			currentMonthNumber1 = "11";
		} else if (Month.equalsIgnoreCase("Dec")) {
			currentMonthNumber1 = "12";
		}

		Date date3 = d.parse(Day1 + "-" + Integer.parseInt(currentMonthNumber1) + "-" + Year1);
		System.out.println(date3);

		QaExtentReport.test.log(Status.INFO, "<b><i>Select Departure Date  </i></b>" + Day + "-" + Month + "-" + Year);
		QaExtentReport.test.log(Status.INFO, "<b><i>Select Return Date  </i></b>" + Day1 + "-" + Month1 + "-" + Year1);

		if (Integer.parseInt(Day) > 31) {
			System.out.println("Invalid date provided " + Day + "-" + Month + "-" + Year);
			QaExtentReport.test.log(Status.FAIL,
					"<b><i>Invalid date provided  </i></b>" + Day + "-" + Month + "-" + Year);
//			throw new B2cExceptionClass("Invalid date provided " + Day + "/" + Month + "/" + Year);
		}

		if (Month.equals("Feb") && Integer.parseInt(Day) > 28) {
			System.out.println("Invalid date provided " + Day + "-" + Month + "-" + Year);
			QaExtentReport.test.log(Status.FAIL,
					"<b><i>Invalid date provided  </i></b>" + Day + "-" + Month + "-" + Year);
//			throw new B2cExceptionClass("Invalid date provided " + Day + "-" + Month + "-" + Year);
		}

		if (Integer.parseInt(Day1) > 31) {
			System.out.println("Invalid date provided " + Day1 + "-" + Month1 + "-" + Year1);
			QaExtentReport.test.log(Status.FAIL,
					"<b><i>Invalid date provided  </i></b>" + Day1 + "-" + Month1 + "-" + Year1);
//			throw new B2cExceptionClass("Invalid date provided " + Day1 + "-" + Month1 + "-" + Year1);
		}

		if (Month.equals("Feb") && Integer.parseInt(Day1) > 28) {
			System.out.println("Invalid date provided " + Day1 + "-" + Month1 + "-" + Year1);
			QaExtentReport.test.log(Status.FAIL,
					"<b><i>Invalid date provided  </i></b>" + Day1 + "-" + Month1 + "-" + Year1);
//			throw new B2cExceptionClass("Invalid date provided " + Day1 + "-" + Month1 + "-" + Year1);
		}

		String monthYear = QaBrowser.driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div")).getText();
		String month = monthYear.split(" ")[0];
		String year = monthYear.split(" ")[1];

		if (date2.before(date1)) {
			System.out.println("Invalid date provided " + Day + "-" + Month + "-" + Year);
			QaExtentReport.test.log(Status.FAIL,
					"<b><i>Invalid date provided  </i></b>" + Day + "-" + Month + "-" + Year);
//			throw new B2cExceptionClass("Invalid date provided " + Day + "-" + Month + "-" + Year);
		} else {
			while (!(month.equals(Month) && year.equals(Year))) {
				QaBrowser.driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/a[3]")).click();
				monthYear = QaBrowser.driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div")).getText();
				month = monthYear.split(" ")[0];
				year = monthYear.split(" ")[1];
			}

			List<WebElement> allDates = QaBrowser.driver
					.findElements(By.xpath("/html/body/div[2]/div/div[2]/div/table/tbody/tr/td/a"));

			for (WebElement ele : allDates) {
				String dt = ele.getText();

				if (dt.equalsIgnoreCase(Day)) {
					ele.click();
					break;
				}
			}
			Thread.sleep(2000);
			String monthYear1 = QaBrowser.driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div"))
					.getText();
			Thread.sleep(3000);
			String month1 = monthYear1.split(" ")[0];
			Thread.sleep(3000);
			String year1 = monthYear1.split(" ")[1];

			if (date3.before(date2)) {
				QaExtentReport.test.log(Status.FAIL,
						"<b><i>Invalid Return date provided  </i></b>" + Day1 + "-" + Month1 + "-" + Year1);
			} else {
				while (!(month1.equals(Month1) && year1.equals(Year1))) {
					QaBrowser.driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/a[3]")).click();
					monthYear1 = QaBrowser.driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div"))
							.getText();
					month1 = monthYear1.split(" ")[0];
					year1 = monthYear1.split(" ")[1];
				}
				List<WebElement> allDates1 = QaBrowser.driver
						.findElements(By.xpath("/html/body/div[2]/div/div[2]/div/table/tbody/tr/td/a"));
				for (WebElement ele1 : allDates1) {
					String dt1 = ele1.getText();
					if (dt1.equalsIgnoreCase(Day1)) {
						ele1.click();
						break;
					}
				}
			}
		}
	}

	public static void selectDateInCalendarRoundTripNew1(String Day, String Month, String Year, String Day1,
			String Month1, String Year1,String Conveyance) throws Exception {
		Date date = new Date();
		DateFormat d = new SimpleDateFormat("dd-MM-yyyy");
		String NewDate = d.format(date);
		Date date1 = d.parse(NewDate);
		System.out.println(date1);

		String currentMonthNumber = "00";
		if (Month.equalsIgnoreCase("Jan")) {
			currentMonthNumber = "01";
		} else if (Month.equalsIgnoreCase("Feb")) {
			currentMonthNumber = "02";
		} else if (Month.equalsIgnoreCase("Mar")) {
			currentMonthNumber = "03";
		} else if (Month.equalsIgnoreCase("Apr")) {
			currentMonthNumber = "04";
		} else if (Month.equalsIgnoreCase("May")) {
			currentMonthNumber = "05";
		} else if (Month.equalsIgnoreCase("Jun")) {
			currentMonthNumber = "06";
		} else if (Month.equalsIgnoreCase("Jul")) {
			currentMonthNumber = "07";
		} else if (Month.equalsIgnoreCase("Aug")) {
			currentMonthNumber = "08";
		} else if (Month.equalsIgnoreCase("Sep")) {
			currentMonthNumber = "09";
		} else if (Month.equalsIgnoreCase("Oct")) {
			currentMonthNumber = "10";
		} else if (Month.equalsIgnoreCase("Nov")) {
			currentMonthNumber = "11";
		} else if (Month.equalsIgnoreCase("Dec")) {
			currentMonthNumber = "12";
		}
		Date date2 = d.parse(Day + "-" + Integer.parseInt(currentMonthNumber) + "-" + Year);
		System.out.println(date2);

		String currentMonthNumber1 = "00";
		if (Month.equalsIgnoreCase("Jan")) {
			currentMonthNumber1 = "01";
		} else if (Month.equalsIgnoreCase("Feb")) {
			currentMonthNumber1 = "02";
		} else if (Month.equalsIgnoreCase("Mar")) {
			currentMonthNumber1 = "03";
		} else if (Month.equalsIgnoreCase("Apr")) {
			currentMonthNumber1 = "04";
		} else if (Month.equalsIgnoreCase("May")) {
			currentMonthNumber1 = "05";
		} else if (Month.equalsIgnoreCase("Jun")) {
			currentMonthNumber1 = "06";
		} else if (Month.equalsIgnoreCase("Jul")) {
			currentMonthNumber1 = "07";
		} else if (Month.equalsIgnoreCase("Aug")) {
			currentMonthNumber1 = "08";
		} else if (Month.equalsIgnoreCase("Sep")) {
			currentMonthNumber1 = "09";
		} else if (Month.equalsIgnoreCase("Oct")) {
			currentMonthNumber1 = "10";
		} else if (Month.equalsIgnoreCase("Nov")) {
			currentMonthNumber1 = "11";
		} else if (Month.equalsIgnoreCase("Dec")) {
			currentMonthNumber1 = "12";
		}

		Date date3 = d.parse(Day1 + "-" + Integer.parseInt(currentMonthNumber1) + "-" + Year1);
		System.out.println(date3);

		QaExtentReport.test.log(Status.INFO, "<b><i>Select Departure Date  </i></b>" + Day + "-" + Month + "-" + Year);
		QaExtentReport.test.log(Status.INFO, "<b><i>Select Return Date  </i></b>" + Day1 + "-" + Month1 + "-" + Year1);

		if (Integer.parseInt(Day) > 31) {
			System.out.println("Invalid date provided " + Day + "-" + Month + "-" + Year);
			QaExtentReport.test.log(Status.FAIL,
					"<b><i>Invalid date provided  </i></b>" + Day + "-" + Month + "-" + Year);
//			throw new B2cExceptionClass("Invalid date provided " + Day + "/" + Month + "/" + Year);
		}

		if (Month.equals("Feb") && Integer.parseInt(Day) > 28) {
			System.out.println("Invalid date provided " + Day + "-" + Month + "-" + Year);
			QaExtentReport.test.log(Status.FAIL,
					"<b><i>Invalid date provided  </i></b>" + Day + "-" + Month + "-" + Year);
//			throw new B2cExceptionClass("Invalid date provided " + Day + "-" + Month + "-" + Year);
		}

		if (Integer.parseInt(Day1) > 31) {
			System.out.println("Invalid date provided " + Day1 + "-" + Month1 + "-" + Year1);
			QaExtentReport.test.log(Status.FAIL,
					"<b><i>Invalid date provided  </i></b>" + Day1 + "-" + Month1 + "-" + Year1);
//			throw new B2cExceptionClass("Invalid date provided " + Day1 + "-" + Month1 + "-" + Year1);
		}

		if (Month.equals("Feb") && Integer.parseInt(Day1) > 28) {
			System.out.println("Invalid date provided " + Day1 + "-" + Month1 + "-" + Year1);
			QaExtentReport.test.log(Status.FAIL,
					"<b><i>Invalid date provided  </i></b>" + Day1 + "-" + Month1 + "-" + Year1);
//			throw new B2cExceptionClass("Invalid date provided " + Day1 + "-" + Month1 + "-" + Year1);
		}

		String monthYear = QaBrowser.driver.findElement(By.xpath("/html/body/div[5]/div/div[2]/div/div")).getText();
		String month = monthYear.split(" ")[0];
		String year = monthYear.split(" ")[1];

		if (date2.before(date1)) {
			System.out.println("Invalid date provided " + Day + "-" + Month + "-" + Year);
			QaExtentReport.test.log(Status.FAIL,
					"<b><i>Invalid date provided  </i></b>" + Day + "-" + Month + "-" + Year);
//			throw new B2cExceptionClass("Invalid date provided " + Day + "-" + Month + "-" + Year);
		} else {
			while (!(month.equals(Month) && year.equals(Year))) {
				QaBrowser.driver.findElement(By.xpath("/html/body/div[5]/div/div[1]/a[3]")).click();
				monthYear = QaBrowser.driver.findElement(By.xpath("/html/body/div[5]/div/div[2]/div/div")).getText();
				month = monthYear.split(" ")[0];
				year = monthYear.split(" ")[1];
			}
			List<WebElement> allDates = QaBrowser.driver
					.findElements(By.xpath("/html/body/div[5]/div/div[2]/div/table/tbody/tr/td/a"));
			for (WebElement ele : allDates) {
				String dt = ele.getText();
				if (dt.equalsIgnoreCase(Day)) {
					ele.click();
					break;
				}
			}
			Thread.sleep(2000);
			if(Conveyance.equalsIgnoreCase("Yes")) {
				QaRobot.ClickOnElement("ConveyanceDate1");
			}else {
				QaRobot.ClickOnElement("ExpenseDate1");
			}
			Thread.sleep(2000);
			String monthYear1 = QaBrowser.driver.findElement(By.xpath("/html/body/div[5]/div/div[2]/div/div"))
					.getText();
			Thread.sleep(3000);
			String month1 = monthYear1.split(" ")[0];
			Thread.sleep(3000);
			String year1 = monthYear1.split(" ")[1];

			if (date3.before(date2)) {
				QaExtentReport.test.log(Status.FAIL,
						"<b><i>Invalid Return date provided  </i></b>" + Day1 + "-" + Month1 + "-" + Year1);
			} else {
				while (!(month1.equals(Month1) && year1.equals(Year1))) {
					QaBrowser.driver.findElement(By.xpath("/html/body/div[5]/div/div[1]/a[3]")).click();
					monthYear1 = QaBrowser.driver.findElement(By.xpath("/html/body/div[5]/div/div[2]/div/div"))
							.getText();
					month1 = monthYear1.split(" ")[0];
					year1 = monthYear1.split(" ")[1];
				}
				List<WebElement> allDates1 = QaBrowser.driver
						.findElements(By.xpath("/html/body/div[5]/div/div[2]/div/table/tbody/tr/td/a"));
				for (WebElement ele1 : allDates1) {
					String dt1 = ele1.getText();
					if (dt1.equalsIgnoreCase(Day1)) {
						ele1.click();
						break;
					}
				}
			}
		}
	}

	public static void expense(String TripType, String CostCenter, String PerDiemCurrency, String AdvanceCurrency,
			String Projectsheet, String PerDiemAmmount, String AdvanceAmount, String Description) throws Exception {
		WebElement DropDown = QaBrowser.driver.findElement(By.xpath("//select[@id='ddltriptype']"));
		Select s = new Select(DropDown);
		s.selectByVisibleText(TripType);

		WebElement DropDown1 = QaBrowser.driver.findElement(By.xpath("//select[@id='ddlcostcenter']"));
		Select s1 = new Select(DropDown1);
		s1.selectByVisibleText(CostCenter);
		Thread.sleep(2000);
		WebElement DropDown4 = QaBrowser.driver.findElement(By.xpath("//select[@id='ddlProject']"));
		Select s4 = new Select(DropDown4);
		s4.selectByVisibleText(Projectsheet);
		QaRobot.ClickOnElement("PerDiemAllowance");
		QaExtentReport.test.log(Status.INFO, "<b><i>Click on Per Diem Allowance</i></b>");

		QaRobot.ClickOnElement("AdvanceAllowance");
		QaExtentReport.test.log(Status.INFO, "<b><i>Click on Advance Amount</i></b>");

		WebElement DropDown2 = QaBrowser.driver.findElement(By.xpath("//select[@id='ddlPerDiemCurrency']"));
		Select s2 = new Select(DropDown2);
		s2.selectByVisibleText(PerDiemCurrency);

		QaRobot.PassValue("PerDiemAmmount", PerDiemAmmount);
		QaExtentReport.test.log(Status.INFO, "<b><i>Per Diem Ammount Is </i></b>" + PerDiemAmmount);

		WebElement DropDown3 = QaBrowser.driver.findElement(By.xpath("//select[@id='ddlAdvanceCurrency']"));
		Select s3 = new Select(DropDown3);
		s3.selectByVisibleText(AdvanceCurrency);

		QaRobot.PassValue("AdvanceAmount", AdvanceAmount);
		QaExtentReport.test.log(Status.INFO, "<b><i>Advance Amount Is </i></b>" + AdvanceAmount);
		Thread.sleep(2000);
		QaRobot.PassValue("Descriptionexp", Description);
		QaExtentReport.test.log(Status.INFO, "<b><i>Description Is </i></b>" + Description);
		Thread.sleep(2000);
		QaExtentReport.extentScreenshot("Expense sheet");
		Thread.sleep(2000);
		QaRobot.ClickOnElement("expenseSaveButton");
//		QaExtentReport.test.log(Status.INFO, "<b><i>Click on Save Button</i></b>");
		Alert alt = QaBrowser.driver.switchTo().alert();
		alt.accept();
	}

	public static void expense1(String Category, String Merchant, String ExpenseFromDate, String ExpenseToDate,
			String ExpenseCurrency, String ExpenseAmount, String GSTNumber, String ModeOfPayment, String ExpenceComment,
			String Conveyance, String ConveyanceType, String Corigin, String COrigin_Name, String CDestination,
			String CDestination_Name, String ConveyanceFromDate, String ConveyanceToDate) throws Exception {
		QaRobot.ClickOnElement("SelectTripName");
		QaExtentReport.test.log(Status.INFO, "<b><i>Click on Select Trip Name</i></b>");

		QaRobot.ClickOnElement("AddExpenseButton");
		Thread.sleep(2000);
		QaExtentReport.extentScreenshot("AddExpense");
		Thread.sleep(3000);

		String ParentWindow1 = QaBrowser.driver.getWindowHandle();
		Set<String> handles1 = QaBrowser.driver.getWindowHandles();
		for (String childWindow1 : handles1) {
			if (!childWindow1.equals(ParentWindow1))
				QaBrowser.driver.switchTo().window(childWindow1);
		}
		QaRobot.ClickOnElement("AddExpenseButton1");
		QaExtentReport.extentScreenshot("AddExpense1");

		WebElement DropDown4 = QaBrowser.driver.findElement(By.xpath("//select[@id='ddlCategory']"));
		Select s4 = new Select(DropDown4);
		s4.selectByVisibleText(Category);

		QaRobot.PassValue("Merchant", Merchant);
//		QaExtentReport.test.log(Status.INFO, "<b><i>Write Merchant</i></b>");

		String DateSelection[] = ExpenseFromDate.split("-");
		String year = DateSelection[2];
		String month = DateSelection[1];
		String expDate = DateSelection[0];
		String DateSelection1[] = ExpenseToDate.split("-");
		String year1 = DateSelection1[2];
		String month1 = DateSelection1[1];
		String expDate1 = DateSelection1[0];
		QaRobot.ClickOnElement("ExpenseDate");
		Thread.sleep(2000);
		selectDateInCalendarRoundTripNew1(expDate, month, year, expDate1, month1, year1,Conveyance);

//		QaExtentReport.test.log(Status.INFO, "<b><i>Click on Expense Date Button</i></b>");
//		QaBrowser.driver.findElement(By.xpath("//a[contains(@title,'" + ExpenseDate + "')]")).click();
//		QaExtentReport.test.log(Status.INFO, "<b><i>Expense date is</i></b>" + ExpenseDate);
//		QaBrowser.driver.findElement(By.xpath("//a[contains(@title,'" + ExpenseDate + "')]")).click();
//		QaExtentReport.test.log(Status.INFO, "<b><i>Expense date is</i></b>" + ExpenseDate);

		WebElement DropDown5 = QaBrowser.driver.findElement(By.xpath("//select[@id='ddlExpenseCurrency']"));
		Select s5 = new Select(DropDown5);
		s5.selectByVisibleText(ExpenseCurrency);

		QaRobot.PassValue("ExpenseAmount", ExpenseAmount);
		QaExtentReport.test.log(Status.INFO, "<b><i>Expense Amount Is </i></b>" + ExpenseAmount);
		Thread.sleep(2000);
		WebElement DropDown6 = QaBrowser.driver.findElement(By.xpath("//select[@id='ddlGSTNumber']"));
		Select s6 = new Select(DropDown6);
		s6.selectByVisibleText(GSTNumber);
		Thread.sleep(2000);
		WebElement DropDown7 = QaBrowser.driver.findElement(By.xpath("//select[@id='ddlExpenseMOP']"));
		Select s7 = new Select(DropDown7);
		s7.selectByVisibleText(ModeOfPayment);
		Thread.sleep(2000);
		QaRobot.PassValue("ExpenceComment", ExpenceComment);
		QaExtentReport.test.log(Status.INFO, "<b><i>Expense Comment Is </i></b>" + ExpenceComment);
		QaExtentReport.extentScreenshot("Expense Details");
		Thread.sleep(2000);
		if (Conveyance.equalsIgnoreCase("Yes")) {
			QaRobot.ClickOnElement("ConveyanceAdd");
			Thread.sleep(2000);
			WebElement DropDown8 = QaBrowser.driver.findElement(By.xpath("//select[@id='ddlPerDiemProduct']"));
			Select s8 = new Select(DropDown8);
			s8.selectByVisibleText(ConveyanceType);
			Thread.sleep(2000);
			TestBase.listofautosuggestion(By.xpath("/html/body/div[1]/div[1]"), Corigin, COrigin_Name,
					By.xpath("//input[@id='txtPerDiemOrigin']"));
//			QaBrowser.driver.findElement(By.xpath("/html/body/div[1]/div[1]")).click();
			Thread.sleep(3000);
			TestBase.listofautosuggestion(By.xpath("/html/body/div[2]/div[3]"), CDestination, CDestination_Name,
					By.xpath("//input[@id='txtPerDiemDestination']"));
//			QaBrowser.driver.findElement(By.xpath("/html/body/div[2]/div[3]")).click();
			Thread.sleep(3000);
			String DateSelectionC[] = ConveyanceFromDate.split("-");
			String yearC = DateSelectionC[2];
			String monthC = DateSelectionC[1];
			String expDateC = DateSelectionC[0];
			String DateSelection1C[] = ConveyanceToDate.split("-");
			String year1C = DateSelection1C[2];
			String month1C = DateSelection1C[1];
			String expDate1C = DateSelection1C[0];
			QaRobot.ClickOnElement("ConveyanceDate");
			Thread.sleep(2000);
			selectDateInCalendarRoundTripNew1(expDateC, monthC, yearC, expDate1C, month1C, year1C,Conveyance);
			WebElement DropDown9 = QaBrowser.driver.findElement(By.xpath("//select[@id='ddlPerDiemMOP']"));
			Select s9 = new Select(DropDown9);
			s9.selectByVisibleText(ModeOfPayment);
			Thread.sleep(2000);
			QaRobot.PassValue("ConveyanceComment", ExpenceComment);
			QaExtentReport.test.log(Status.INFO, "<b><i>Expense Comment Is </i></b>" + ExpenceComment);
			QaExtentReport.extentScreenshot("Expense Details");
			Thread.sleep(2000);
		}
//		/html/body/div/div
//		/html/body/div[2]/div
		QaRobot.ClickOnElement("ExpenseAdd");
		Thread.sleep(2000);
//		QaExtentReport.test.log(Status.INFO, "<b><i>Click on Expense Add Button</i></b>");
		Alert alt4 = QaBrowser.driver.switchTo().alert();
		alt4.accept();
//		QaRobot.ClickOnElement("ExpenseAdd");
//		Thread.sleep(3000);
		Alert alt1 = QaBrowser.driver.switchTo().alert();
		alt1.accept();
//		Alert alt2 = QaBrowser.driver.switchTo().alert();
//		alt2.accept();
		QaBrowser.driver.switchTo().window(ParentWindow1);

		QaRobot.ClickOnElement("SendForApproval");
		QaExtentReport.extentScreenshot("SendForApproval");
//		QaExtentReport.test.log(Status.INFO, "<b><i>Click on Send For Approval Button</i></b>");

		String ParentWindow2 = QaBrowser.driver.getWindowHandle();
		Set<String> handles2 = QaBrowser.driver.getWindowHandles();
		for (String childWindow2 : handles2) {
			if (!childWindow2.equals(ParentWindow2))
				QaBrowser.driver.switchTo().window(childWindow2);
		}
		QaExtentReport.extentScreenshot("Approval");
		QaRobot.ClickOnElement("ApprovalButton");

//		QaExtentReport.test.log(Status.INFO, "<b><i>Click on Final Approval Button</i></b>");

		Alert alt3 = QaBrowser.driver.switchTo().alert();
		alt3.accept();

		QaBrowser.driver.switchTo().window(ParentWindow2);
	}
}
