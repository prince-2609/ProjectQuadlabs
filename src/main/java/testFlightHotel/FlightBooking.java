package testFlightHotel;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import Base.TestBase;
import entities.Login;
import product.Flight.suite.Oneway.SBTCheckoutPayment;
import product.Flight.suite.Oneway.SBTResultPage;
import product.Flight.suite.Oneway.SearchDashboard;
import utilities.QaBrowser;
import utilities.QaDataProvider;
import utilities.QaExtentReport;
import utilities.QaRobot;

@Listeners(listenerClass.Listener.class)
public class FlightBooking {

	@DataProvider
	public Object[][] getexceldata() throws Exception {
		return QaDataProvider.getTestdata("FlightBooking", "Sheet8");
	}

	@Test(dataProvider = "getexceldata")
	public static void flightBooking(String TestCaseId, String TestScenario, String Source, String MoURL,
			String CompanyCode, String UserName, String Password, String CorporateName, String SearchRuleStatus,
			String RSqty, String RulesAppliedOnSearchPage, String ccode, String LoginType, String URL, String Emailid,
			String SDN, String EmployeName, String TravelerType, String uname, String pwd, String CoporateName,
			String FareBranding, String DashboardType, String corptraveller, String searchType, String triptype,
			String Trip, String origin, String forigin, String destination, String fdesti, String Policy,
			String DepartureDate, String ReturnDate, String ResultRuleStatus, String RRqty,
			String RulesAppliedOnResultPage, String adult, String child, String infant, String currency, String fclass,
			String PolicyType, String Stops, String ChooseAirLine, String OneWayAirLine, String RoundTripAirLine,
			String OneWayFareType, String RoundTripFareType, String booknowindex, String policyindex, String tripindex,
			String ProductType, String CityCode, String CityTitle, String CheckInDate, String CheckOutDate,
			String passportnumber, String fop, String receiptno, String card, String AppliedOn, String CQty,
			String CName, String cardtype, String cvv, String Resultpagestep, String AddToCartRemarks,
			String CheckOutRuleStatus, String RCqty, String RulesAppliedOnCheckOutPage, String checkoutPageStep,
			String SeatSelection, String AdultSeatSelection, String ChildSeatSelection, String airReasonCode,
			String CreatedBy) throws Exception {
		QaExtentReport.test = QaExtentReport.report.createTest(TestCaseId + "-" + TestScenario);
//		TestBase.moLogin(Source, MoURL);
//		QaRobot.PassValue("CompanyCode", CompanyCode);
//		QaRobot.PassValue("UserName", UserName);
//		QaRobot.PassValue("PasswordFD", Password);
//		QaExtentReport.extentScreenshot("Sigh In Page");
//		QaRobot.ClickOnElement("LogIn");
//		Thread.sleep(3000);
//		QaRobot.switchframe("//frame[@name='login']");
//		QaRobot.switchframe("//frame[@name='leftbar']");
//		QaRobot.ClickOnElement("CorporateManagement");
//		Thread.sleep(3000);
//		QaRobot.ClickOnElement("SearchCorporate");
//		QaBrowser.driver.switchTo().parentFrame();
//		QaRobot.switchframe("//frame[@name='main']");
//		QaRobot.switchframe("//frame[@id='frm2']");
//		QaRobot.PassValue("CompanyName", CorporateName);
//		QaRobot.ClickOnElement("SearchCompanyName");
//		QaExtentReport.test.log(Status.INFO, "<b><i>Corporate Name</i></b>" + " - " + CorporateName);
//		String AccountId = QaBrowser.driver.findElement(By.xpath("//span[@id='GridView1_ctl02_Label2']")).getText();
//		QaExtentReport.test.log(Status.INFO, "<b><i>Account Id</i></b>" + " - " + AccountId);
//		QaRobot.ClickOnElement("ClickOnSearchCompanyName");
//		QaBrowser.driver.switchTo().parentFrame();
//		QaRobot.switchframe("//frame[@id='toolHeader']");
//		QaRobot.ClickOnElement("CPCorporateManagement");
//		QaBrowser.driver.switchTo().parentFrame();
//		QaRobot.switchframe("//frame[@id='frm2']");
//		QaRobot.ClickOnElement("ManageCorporateCard");
//		QaRobot.ClickOnElement("DeleteCard");
//		Thread.sleep(2000);
//		QaRobot.alertAccept();
//		Thread.sleep(2000);
//		QaRobot.ClickOnElement("Add_CardManagement");
//		Thread.sleep(3000);
//		QaRobot.selectTextFromDropdown("CMCardOption", "Credit Card", "");
//		Thread.sleep(2000);
//		QaRobot.selectTextFromDropdown("CMCardType", "VISA", "");
//		Thread.sleep(2000);
//		QaRobot.PassValue("CardName1", "ShubhamCard");
//		QaRobot.PassValue("CardNo1", "4555555555555555");
//		QaRobot.selectTextFromDropdown("CMExpiryMonth1", "NOV", "");
//		QaRobot.selectTextFromDropdown("CMExpiryYear1", "2033", "");
//		QaRobot.selectTextFromDropdown("CMRuleAppliedOn", AppliedOn, "");
//		Thread.sleep(2000);
//		int pAS1 = Integer.parseInt(CQty);
//		for (int k = 1; k <= pAS1; k++) {
////			String[] tN1 = CName.split(",");
////			String b1 = tN1[k - 1];
//			List<WebElement> listOfRights = QaBrowser.driver.findElements(By.xpath(
//					"/html/body/div[1]/form/div[5]/div/div/div[1]/div/div[2]/div[2]/div/div/div[16]/div[4]/div/div/div/select/option"));
//			for (WebElement autoRights : listOfRights) {
//				System.out.println(autoRights.getText());
//				if (autoRights.getText().equalsIgnoreCase(CName)) {
//					autoRights.click();
//					QaRobot.ClickOnElement("CAddClass");
//				}
//			}
//		}
//		QaRobot.ClickOnElement("CAir");
//		QaRobot.ClickOnElement("CTerm");
//		Thread.sleep(5000);
//		QaExtentReport.extentScreenshot("Card");
//		QaRobot.ClickOnElement("CardSave");
//		Thread.sleep(3000);
//		QaExtentReport.extentScreenshot("Manage Card");
//		Thread.sleep(3000);
		TestBase.Companycode(ccode, URL);
		QaRobot.impliwait(30);
		if (LoginType.equalsIgnoreCase("Normal")) {
			Login.SbtLogin(uname, pwd);
		} else if (LoginType.equalsIgnoreCase("SSO")) {
			QaRobot.PassValue("EmailId", Emailid);
			QaRobot.PassValue("SDN", SDN);
			QaRobot.ClickOnElement("Encrypt");
			QaRobot.ClickOnElement("ESubmit");
			Thread.sleep(5000);
		}
//		QaRobot.getWebElement("sbt_Login1").sendKeys(uname);
//		QaRobot.getWebElement("sbt_Pasword1").sendKeys(pwd);
//		QaExtentReport.extentScreenshot("Sigh In Page");
//		QaRobot.getWebElement("sbt_submit").click();
		QaExtentReport.test.log(Status.INFO, "<b><i>Employee Name is  </i></b>" + EmployeName);
		QaExtentReport.test.log(Status.INFO, "<b><i> Traveler Type is  </i></b>" + TravelerType);
		if (ccode.equalsIgnoreCase("sbt")) {
			if (CoporateName.equalsIgnoreCase("Poonam_Corp")) {
				QaRobot.ClickOnElement("ChooseCorporate1");
				QaExtentReport.test.log(Status.INFO, "<b><i> Coporate Name is  </i></b>" + CoporateName);
				QaExtentReport.extentScreenshot("Choose Corporate");
			} else if (CoporateName.equalsIgnoreCase("Amazon")) {
				QaRobot.ClickOnElement("ChooseCorporate2");
				QaExtentReport.test.log(Status.INFO, "<b><i> Coporate Name is  </i></b>" + CoporateName);
				QaExtentReport.extentScreenshot("Choose Corporate");
			}
		} else if (ccode.equalsIgnoreCase("preprod117")) {
			if (CoporateName.equalsIgnoreCase("Demo Corporate")) {
				QaRobot.ClickOnElement("ChooseCorporate1");
				QaExtentReport.test.log(Status.INFO, "<b><i> Coporate Name is  </i></b>" + CoporateName);
				QaExtentReport.extentScreenshot("Choose Corporate");
			} else if (CoporateName.equalsIgnoreCase("Lux_Test_corp")) {
				QaRobot.ClickOnElement("ChooseCorporate2");
				QaExtentReport.test.log(Status.INFO, "<b><i> Coporate Name is  </i></b>" + CoporateName);
				QaExtentReport.extentScreenshot("Choose Corporate");
			} else if (CoporateName.equalsIgnoreCase("Amazon")) {
				QaExtentReport.extentScreenshot("Choose Corporate");
				QaRobot.ClickOnElement("ChooseCorporate2");
				QaExtentReport.test.log(Status.INFO, "<b><i> Coporate Name is  </i></b>" + CoporateName);
			}
		}
		if (DashboardType.equalsIgnoreCase("Old")) {
//			QaRobot.ClickOnElement("NotificationClose");
//			Thread.sleep(2000);
			if (TravelerType.equalsIgnoreCase("Administrator") || TravelerType.equalsIgnoreCase("Travel Arranger")) {
				SearchDashboard.selectEmployeeWithID(corptraveller);
			}
			String DateSelection[] = DepartureDate.split("-");
			String year = DateSelection[2];
			String month = DateSelection[1];
			String expDate = DateSelection[0];
			String DateSelection1[] = ReturnDate.split("-");
			String year1 = DateSelection1[2];
			String month1 = DateSelection1[1];
			String expDate1 = DateSelection1[0];
			if (searchType.equalsIgnoreCase("Individual")) {
				QaRobot.ClickOnElement("trip_Busniess");
			} else if (searchType.equalsIgnoreCase("Dependent")) {
				QaRobot.ClickOnElement("trip_Family");
			}
			if (Trip.equalsIgnoreCase("OneWay")) {
				QaRobot.ClickOnElement("ow_onewaytrip");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on OneWay</i></b>");
				TestBase.listofautosuggestion(By.xpath("//div[@id='divDepartureCity']/p"), origin, forigin,
						By.xpath("//input[@id='txtDepartureCity']"));
				QaExtentReport.test.log(Status.INFO, "<b><i>Departure city</i></b>" + " : " + forigin);
				Thread.sleep(2000);
				TestBase.listofautosuggestion(By.xpath("//div[@id='divDestinationCity']/p"), destination, fdesti,
						By.xpath("//input[@id='txtDestinationCity']"));
				QaExtentReport.test.log(Status.INFO, "<b><i>Arrival city</i></b>" + " : " + fdesti);
				Thread.sleep(2000);
//		QaRobot.selectTextFromDropdown("APolicy", Policy);
				Thread.sleep(2000);
				QaBrowser.driver
						.findElement(
								By.xpath("//div[@id='flight_way1']/div[2]/div[1]/div/div/label/span[2]/span[1]/img"))
						.click();
				selectDateInCalendarOneWay(expDate, month, year);
			} else if (Trip.equalsIgnoreCase("RoundTrip")) {
				QaRobot.ClickOnElement("ow_roundtrip");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Round Trip</i></b>");
				TestBase.listofautosuggestion(By.xpath("//div[@id='divDepartureCity']/p"), origin, forigin,
						By.xpath("//input[@id='txtDepartureCity']"));
				QaExtentReport.test.log(Status.INFO, "<b><i>Departure city</i></b>" + " : " + forigin);
				Thread.sleep(2000);
				TestBase.listofautosuggestion(By.xpath("//div[@id='divDestinationCity']/p"), destination, fdesti,
						By.xpath("//input[@id='txtDestinationCity']"));
				QaExtentReport.test.log(Status.INFO, "<b><i>Arrival city</i></b>" + " : " + fdesti);
				Thread.sleep(2000);
//		QaRobot.selectTextFromDropdown("APolicy", Policy);l
				Thread.sleep(2000);
				QaBrowser.driver
						.findElement(
								By.xpath("//div[@id='flight_way1']/div[2]/div[1]/div/div/label/span[2]/span[1]/img"))
						.click();
				Thread.sleep(2000);
				selectDateInCalendarRoundTrip(expDate, month, year, expDate1, month1, year1);
			}
			if (searchType.equalsIgnoreCase("Individual")) {
			} else {
				QaRobot.ClickOnElement("dept_Travellers");
				QaRobot.selectValueFromDropdown("dept_Adult", adult,
						"<b><i>Select adult for booking</i></b>" + " - " + adult);
				Thread.sleep(2000);

				QaRobot.selectValueFromDropdown("dept_Child", child,
						"<b><i>Select child for booking</i></b>" + " - " + child);
				Thread.sleep(2000);

				QaRobot.selectValueFromDropdown("dept_Infant", infant,
						"<b><i>Select infant for booking</i></b>" + " - " + infant);
				Thread.sleep(2000);
//				QaBrowser.driver.findElement(By.xpath("//div[@id='Wallet_Status_divwalletmainUI']/div/div[1]/div"))
//				.click();
				QaBrowser.driver.findElement(By.xpath("//div[@id='bannermaindiv']/div/div/div[1]/div/h3")).click();
			}
			QaRobot.selectTextFromDropdown("ow_class", fclass, "<b><i>Cabin Class<b><i>" + " : " + fclass);
			// click on addtional search
			// QaRobot.ClickOnElement("ow_addsearch", "additional search options");
			// select currency
			// QaRobot.selectTextFromDropdown("ow_currency", currency,
			// "search currency : " + currency);
			// select nationality
			// QaRobot.selectTextFromDropdown("ow_nationality", nationality,
			// "nationality : " + nationality);
//			SearchDashboard.FlightpolicyCheck();
			QaExtentReport.extentScreenshot("Search Page");
			QaRobot.ClickOnElement("ow_searchflight");
		} else if (DashboardType.equalsIgnoreCase("New")) {
			QaRobot.ClickOnElement("NotificationClose");
			Thread.sleep(2000);
//			QaRobot.ClickOnElement("NBookAs");
//			Thread.sleep(2000);
			if (TravelerType.equalsIgnoreCase("Administrator") || TravelerType.equalsIgnoreCase("Travel Arranger")) {
				SearchDashboard.selectEmployeeWithID(corptraveller);
				if (searchType.equalsIgnoreCase("Individual")) {
					QaRobot.ClickOnElement("trip_Busniess");
				} else if (searchType.equalsIgnoreCase("Dependent")) {
					QaRobot.ClickOnElement("trip_Family");
				}
			}
			String DateSelection[] = DepartureDate.split("-");
			String year = DateSelection[2];
			String month = DateSelection[1];
			String expDate = DateSelection[0];
			String DateSelection1[] = ReturnDate.split("-");
			String year1 = DateSelection1[2];
			String month1 = DateSelection1[1];
			String expDate1 = DateSelection1[0];

			if (Trip.equalsIgnoreCase("OneWay")) {
				WebElement element = QaBrowser.driver
						.findElement(By.xpath("//div[@id='tab1']/div[1]/div[1]/div/div/select"));
				Select s = new Select(element);
				s.selectByIndex(1);
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on OneWay</i></b>");
				TestBase.listofautosuggestion(By.xpath("//div[@id='divDepartureCity']/p"), origin, forigin,
						By.xpath("//input[@id='txtDepartureCity']"));
				QaExtentReport.test.log(Status.INFO, "<b><i>Departure city</i></b>" + " : " + forigin);
				Thread.sleep(2000);
				TestBase.listofautosuggestion(By.xpath("//div[@id='divDestinationCity']/p"), destination, fdesti,
						By.xpath("//input[@id='txtDestinationCity']"));
				QaExtentReport.test.log(Status.INFO, "<b><i>Arrival city</i></b>" + " : " + fdesti);
				Thread.sleep(2000);
//		QaRobot.selectTextFromDropdown("APolicy", Policy);
				Thread.sleep(2000);
				QaBrowser.driver.findElement(By.xpath("//div[@id='tab1']/div[2]/div[4]/div[1]/span[2]/img")).click();
				selectDateInCalendarOneWayNew(expDate, month, year);
			} else if (Trip.equalsIgnoreCase("RoundTrip")) {
				WebElement element = QaBrowser.driver
						.findElement(By.xpath("//div[@id='tab1']/div[1]/div[1]/div/div/select"));
				Select s = new Select(element);
				s.selectByIndex(0);
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Round Trip</i></b>");
				TestBase.listofautosuggestion(By.xpath("//div[@id='divDepartureCity']/p"), origin, forigin,
						By.xpath("//input[@id='txtDepartureCity']"));
				QaExtentReport.test.log(Status.INFO, "<b><i>Departure city</i></b>" + " : " + forigin);
				Thread.sleep(2000);
				TestBase.listofautosuggestion(By.xpath("//div[@id='divDestinationCity']/p"), destination, fdesti,
						By.xpath("//input[@id='txtDestinationCity']"));
				QaExtentReport.test.log(Status.INFO, "<b><i>Arrival city</i></b>" + " : " + fdesti);
				Thread.sleep(2000);
//		QaRobot.selectTextFromDropdown("APolicy", Policy);l
				Thread.sleep(2000);
				QaBrowser.driver.findElement(By.xpath("//div[@id='tab1']/div[2]/div[4]/div[1]/span[2]/img")).click();
				Thread.sleep(2000);
				selectDateInCalendarRoundTripNew(expDate, month, year, expDate1, month1, year1);
			}
			if (searchType.equalsIgnoreCase("Individual")) {
			} else {
				QaRobot.ClickOnElement("dept_Travellers");
				QaRobot.selectValueFromDropdown("dept_Adult", adult,
						"<b><i>Select adult for booking</i></b>" + " - " + adult);
				Thread.sleep(2000);

				QaRobot.selectValueFromDropdown("dept_Child", child,
						"<b><i>Select child for booking</i></b>" + " - " + child);
				Thread.sleep(2000);

				QaRobot.selectValueFromDropdown("dept_Infant", infant,
						"<b><i>Select infant for booking</i></b>" + " - " + infant);
				Thread.sleep(2000);
				QaBrowser.driver.findElement(By.xpath("//div[@id='noticemaindiv']/div/div/div[1]/div[1]")).click();
			}
			QaRobot.selectTextFromDropdown("ow_class", fclass, "<b><i>Cabin Class<b><i>" + " : " + fclass);
			// click on addtional search
			// QaRobot.ClickOnElement("ow_addsearch", "additional search options");
			// select currency
			// QaRobot.selectTextFromDropdown("ow_currency", currency,
			// "search currency : " + currency);
			// select nationality
			// QaRobot.selectTextFromDropdown("ow_nationality", nationality,
			// "nationality : " + nationality);
//			SearchDashboard.FlightpolicyCheck();
			QaExtentReport.extentScreenshot("Search Page");
			QaRobot.ClickOnElement("ow_searchflight");
			Thread.sleep(5000);
		}
		if (SearchRuleStatus.equalsIgnoreCase("Applied")) {
//			QaRobot.switchToWindow();
//			SoftAssert softAssert = new SoftAssert();
//			int pAS1 = Integer.parseInt(RSqty);
//			if (pAS1 == 1) {
//				for (int k = 1; k <= pAS1; k++) {
//					String[] tN1 = RulesAppliedOnSearchPage.split(",");
//					String b1 = tN1[k - 1];
//					if (QaBrowser.driver.getPageSource().contains(b1)) {
//						Thread.sleep(3000);
//						QaBrowser.driver.findElement(By.xpath("(//*[contains(text(),'" + b1 + "')])[1]")).isDisplayed();
//						Thread.sleep(3000);
//						QaExtentReport.extentScreenshot(b1 + "-" + "Rule is Working on Search Page");
//					} else {
//						softAssert.assertTrue(false, b1 + "-" + "Rule is not Working on Search Page");
////						Assert.assertTrue(false, b1 + " " + "Rule is not Working");
//					}
//				}
//			} else {
//				for (int k = 1; k <= pAS1; k++) {
//					String[] tN1 = RulesAppliedOnSearchPage.split(",");
//					String b1 = tN1[k - 1];
//					if (QaBrowser.driver.getPageSource().contains(b1)) {
////						Thread.sleep(3000);
//						QaBrowser.driver.findElement(By.xpath("(//*[contains(text(),'" + b1 + "')])[1]")).isDisplayed();
//						Thread.sleep(2000);
//						QaExtentReport.extentScreenshot(b1 + "-" + "Rule is Working on Search Page");
////						Thread.sleep(3000);
////						QaRobot.ClickOnElement("NextPicture");
//					} else {
//						softAssert.assertTrue(false, b1 + "-" + "Rule is not Working on Search Page");
////						Assert.assertTrue(false, b1 + " " + "Rule is not Working");
//					}
//				}
//			}
//			softAssert.assertAll();

//			List<WebElement> listOfRights1 = QaBrowser.driver.findElements(By.xpath("//div[@id='IMdivimage']/div/div/div/div/marquee/p"));
//			for (WebElement autoRights1 : listOfRights1) {
//				String abc = autoRights1.getText();
//				System.out.println(abc);
//				String[] tN1 = RulesNotAppliedOnSearchPage.split(",");
//				if(autoRights1.getText().equalsIgnoreCase(tN1[0])||autoRights1.getText().equalsIgnoreCase(tN1[1])||autoRights1.getText().equalsIgnoreCase(tN1[2])||autoRights1.getText().equalsIgnoreCase(tN1[3])||autoRights1.getText().equalsIgnoreCase(tN1[4])||autoRights1.getText().equalsIgnoreCase(tN1[5])) {
//					Assert.assertTrue(false,abc + "Rule is Extra Working");
//				}
//			}
			QaRobot.ClickOnElement("OkContinue");
		}
		Thread.sleep(15000);

//		if (QaBrowser.driver
//				.findElement(
//						By.xpath("//p[contains(text(),'Sorry, could not find desired results. Please try again.')]"))
//				.isDisplayed()) {
//			QaExtentReport.extentScreenshot("Could not find desired results");
//			Assert.assertTrue(false, "Sorry, could not find desired results. Please try again.");
//		} else {
		String url = QaBrowser.driver.getCurrentUrl();
		String[] uid = url.split("=");
		QaExtentReport.test.log(Status.INFO, "<b><i>Session id is </i></b>" + uid[1]);

		if (ResultRuleStatus.equalsIgnoreCase("Applied")) {
//			SoftAssert softAssert = new SoftAssert();
//			int pAS1 = Integer.parseInt(RRqty);
//			if (pAS1 == 1) {
//				for (int k = 1; k <= pAS1; k++) {
//					String[] tN1 = RulesAppliedOnResultPage.split(",");
//					String b1 = tN1[k - 1];
//					if (QaBrowser.driver.getPageSource().contains(b1)) {
//						Thread.sleep(3000);
//						QaBrowser.driver.findElement(By.xpath("(//*[contains(text(),'" + b1 + "')])[1]")).isDisplayed();
//						Thread.sleep(3000);
//						QaExtentReport.extentScreenshot(b1 + "-" + "Rule is Working on Result Page");
//					} else {
//						softAssert.assertTrue(false, b1 + "-" + "Rule is not Working on Result Page");
////							Assert.assertTrue(false, b1 + " " + "Rule is not Working");
//					}
//				}
//			} else {
//				for (int k = 1; k <= pAS1; k++) {
//					String[] tN1 = RulesAppliedOnResultPage.split(",");
//					String b1 = tN1[k - 1];
//					if (QaBrowser.driver.getPageSource().contains(b1)) {
////						Thread.sleep(3000);
//						QaBrowser.driver.findElement(By.xpath("(//*[contains(text(),'" + b1 + "')])[1]")).isDisplayed();
//						Thread.sleep(2000);
//						QaExtentReport.extentScreenshot(b1 + "-" + "Rule is Working on Result Page");
////						Thread.sleep(3000);
////						QaRobot.ClickOnElement("NextPicture");
//					} else {
//						softAssert.assertTrue(false, b1 + "-" + "Rule is not Working on Result Page");
////							Assert.assertTrue(false, b1 + " " + "Rule is not Working");
//					}
//				}
//			}
//			softAssert.assertAll();
		}
		if (DashboardType.equalsIgnoreCase("Old")) {
			if (PolicyType.equalsIgnoreCase("OutPolicy")) {
				QaRobot.ClickOnElement("OutPolicy117");
			}

			List<WebElement> listOfStop = QaBrowser.driver.findElements(By.xpath(
					"//div[@id='FareDetailsController']/div[1]/div[2]/div/div[1]/div/div[3]/div[4]/div[2]/ul/li/span"));
			for (WebElement autoStop : listOfStop) {
//				System.out.println(autoAirline.getText());
				if (autoStop.getText().equalsIgnoreCase(Stops)) {
					autoStop.click();
					break;
				}
			}
		} else if (DashboardType.equalsIgnoreCase("New")) {
			if (PolicyType.equalsIgnoreCase("OutPolicy")) {
				if (Source.equalsIgnoreCase("Live")) {
					QaRobot.ClickOnElement("OutPolicy118");
				} else {
					QaRobot.ClickOnElement("OutPolicy118");
				}
			}
			if (Source.equalsIgnoreCase("Live")) {
				List<WebElement> listOfStop = QaBrowser.driver.findElements(By.xpath(
						"/html/body/div[1]/div[2]/div/section/div[2]/div[2]/div/div[1]/div/div[3]/div[5]/div[2]/ul/li/span"));
				for (WebElement autoStop : listOfStop) {
//					System.out.println(autoAirline.getText());
					if (autoStop.getText().equalsIgnoreCase(Stops)) {
						autoStop.click();
						break;
					}
				}
			} else {
				List<WebElement> listOfStop = QaBrowser.driver.findElements(By.xpath(
						"//div[@id='FareDetailsController']/div[2]/div/div[1]/div/div[3]/div[4]/div[2]/ul/li/span"));
//				List<WebElement> listOfStop = QaBrowser.driver.findElements(By.xpath(
//						"//div[@id='FareDetailsController']/div[2]/div/div[1]/div/div[3]/div[5]/div[2]/ul/li/span"));
				for (WebElement autoStop : listOfStop) {
//					System.out.println(autoAirline.getText());
					if (autoStop.getText().equalsIgnoreCase(Stops)) {
						autoStop.click();
						break;
					}
				}
			}
		}
		Thread.sleep(5000);
		if (ChooseAirLine.equalsIgnoreCase("Yes")) {
			List<WebElement> listOfAirLine = QaBrowser.driver
					.findElements(By.xpath("//div[@id='tdContainerTblAirlines']/ul/li/label/span"));
			for (WebElement autoAirline : listOfAirLine) {
				if (autoAirline.getText().equalsIgnoreCase(OneWayAirLine)) {
					autoAirline.click();
					break;
				}
			}
		}
		QaRobot.scrollPage(-1000);
		if (FareBranding.equalsIgnoreCase("Off")) {
			if (triptype.equalsIgnoreCase("Domestic")) {
				Thread.sleep(5000);
				if (Trip.equalsIgnoreCase("OneWay")) {
					String resultPagePrice = QaBrowser.driver
							.findElement(
									By.xpath("(//div[@class='fl_price_fmt']/p[2]/span/span[2])[" + tripindex + "]"))
							.getText();
//				QaExtentReport.test.log(Status.INFO, "<b><i>Result page price is </i></b>" + resultPagePrice);
					String policytype = QaBrowser.driver
							.findElement(By.xpath("(//span[contains(@id,'PT_')])[" + policyindex + "]")).getText();
					System.out.println(policytype);
					QaExtentReport.extentScreenshot("Result Page");
					if (Resultpagestep.equalsIgnoreCase("Trip Request")) {
						SBTResultPage.tripRequest(tripindex, resultPagePrice, policytype);
					} else if (Resultpagestep.equalsIgnoreCase("Flight Book")) {
						WebElement Book = QaBrowser.driver
								.findElement(By.xpath("(//input[contains(@id,'Anchor_')])[" + booknowindex + "]"));
						JavascriptExecutor js2 = (JavascriptExecutor) QaBrowser.driver;
						js2.executeScript("arguments[0].click()", Book);
						if (policytype.equalsIgnoreCase("Out Of Policy")) {
							QaBrowser.driver.switchTo().alert().accept();
						}
						checkoutpage(ccode, FareBranding, searchType, Trip, adult, child, infant, Stops, ProductType,
								fop, receiptno, card, cardtype, cvv, CheckOutRuleStatus, RCqty,
								RulesAppliedOnCheckOutPage, checkoutPageStep, SeatSelection, AdultSeatSelection,
								ChildSeatSelection, airReasonCode, CreatedBy);
					} else if (Resultpagestep.equalsIgnoreCase("Addtocart")) {
						SBTResultPage.addToCart(booknowindex, AddToCartRemarks, resultPagePrice, policytype);
					}
				} else if (Trip.equalsIgnoreCase("RoundTrip")) {
					if (Resultpagestep.equalsIgnoreCase("Trip Request")) {
//				SBTResultPage.tripRequest(tripindex, resultPagePrice, policytype);
					} else if (Resultpagestep.equalsIgnoreCase("Flight Book")) {
						QaExtentReport.extentScreenshot("Result Page1");
						QaRobot.ClickOnElement("InPolicyTab");
						Thread.sleep(3000);
						WebElement Outbound = QaBrowser.driver.findElement(
								By.xpath("(//input[contains(@id,'radio_Outbound')])[" + booknowindex + "]"));
						JavascriptExecutor js2 = (JavascriptExecutor) QaBrowser.driver;
						js2.executeScript("arguments[0].click()", Outbound);
						WebElement Inbound = QaBrowser.driver.findElement(
								By.xpath("(//input[contains(@id,'radio_Inbound')])[" + booknowindex + "]"));
						JavascriptExecutor js3 = (JavascriptExecutor) QaBrowser.driver;
						js3.executeScript("arguments[0].click()", Inbound);
						QaExtentReport.extentScreenshot("Result Page2");
						QaRobot.ClickOnElement("rt_Continue");
						checkoutpage(ccode, FareBranding, searchType, Trip, adult, child, infant, Stops, ProductType,
								fop, receiptno, card, cardtype, cvv, CheckOutRuleStatus, RCqty,
								RulesAppliedOnCheckOutPage, checkoutPageStep, SeatSelection, AdultSeatSelection,
								ChildSeatSelection, airReasonCode, CreatedBy);
					} else if (Resultpagestep.equalsIgnoreCase("Addtocart")) {
//				SBTResultPage.addToCart(addtocartindex, addToCartRemarks,resultPagePrice,policytype);
					}
				}
			} else if (triptype.equalsIgnoreCase("International")) {
				Thread.sleep(5000);
				String resultPagePrice = QaBrowser.driver
						.findElement(By.xpath("(//div[@class='fl_price_fmt']/p[2]/span/span[2])[" + tripindex + "]"))
						.getText();
				QaExtentReport.test.log(Status.INFO, "<b><i>Result page price is </i></b>" + resultPagePrice);
				String policytype = QaBrowser.driver
						.findElement(By.xpath("(//span[contains(@id,'PT_')])[" + policyindex + "]")).getText();
				QaExtentReport.extentScreenshot("Result Page");
				if (Resultpagestep.equalsIgnoreCase("Trip Request")) {
					SBTResultPage.tripRequest(tripindex, resultPagePrice, policytype);
				} else if (Resultpagestep.equalsIgnoreCase("Flight Book")) {
					WebElement Book = QaBrowser.driver
							.findElement(By.xpath("(//input[contains(@id,'Anchor_')])[" + booknowindex + "]"));
					JavascriptExecutor js2 = (JavascriptExecutor) QaBrowser.driver;
					js2.executeScript("arguments[0].click()", Book);
					if (policytype.equalsIgnoreCase("Out Of Policy")) {
						QaBrowser.driver.switchTo().alert().accept();
					}
					checkoutpage(ccode, FareBranding, searchType, Trip, adult, child, infant, Stops, ProductType, fop,
							receiptno, card, cardtype, cvv, CheckOutRuleStatus, RCqty, RulesAppliedOnCheckOutPage,
							checkoutPageStep, SeatSelection, AdultSeatSelection, ChildSeatSelection, airReasonCode,
							CreatedBy);
				}
			}
		} else if (FareBranding.equalsIgnoreCase("On")) {
//			if (Resultpagestep.equalsIgnoreCase("Add to Cart")) {
//				String getT = QaBrowser.driver.findElement(By.xpath("(//span[contains(@id,'PT')])[1]")).getText();
//				System.out.println(getT);
//				QaExtentReport.extentScreenshot("Flight Results");
			if (Trip.equalsIgnoreCase("OneWay")) {
				if (triptype.equalsIgnoreCase("Domestic")) {
//					QaRobot.scrollPage(500);
					QaRobot.ClickOnElement("AFlightItinerary");
					Thread.sleep(15000);
					QaExtentReport.extentScreenshot("Flight Itinerary");
					Thread.sleep(5000);
					QaRobot.ClickOnElement("AMoreDetails");
					Thread.sleep(7000);
					QaRobot.scrollPage(300);
					Thread.sleep(3000);
					QaExtentReport.extentScreenshot("More Details");
					String getT = QaBrowser.driver.findElement(By.xpath(
							"//div[contains(@id,'moredetails')]/div/div/div[1]/div[2]/div[1]/div/div/div/span/span[2]"))
							.getText();
//				int Bi = Integer.parseInt(KIQty);
//				for (int i = 1; i <= Bi; i++) {
//					String BrandTitle = QaBrowser.driver.findElement(By.xpath(
//							"(/html/body/div[1]/div[2]/div/section/div[2]/div[1]/div[2]/div/div[2]/div/div[2]/div/div/div/div/div[2]/div[1]/div[1]/div[3]/div/div/div[2]/div/div/div[2]/div/div/h2)["
//									+ i + "]"))
//							.getText();
//					System.out.println(BrandTitle);
//					String BrandInfo = QaBrowser.driver.findElement(By.xpath(
//							"(/html/body/div[1]/div[2]/div/section/div[2]/div[1]/div[2]/div/div[2]/div/div[2]/div/div/div/div/div[2]/div[1]/div[1]/div[3]/div/div/div[2]/div/div/div[2]/div/div/p)["
//									+ i + "]"))
//							.getText();
//					System.out.println(BrandInfo);
//					String currentInfo = "00";
//					if (BrandTitle.equalsIgnoreCase("Check in baggage")) {
//						currentInfo = "1";
//					} else if (BrandTitle.equalsIgnoreCase("Carry on baggage")) {
//						currentInfo = "2";
//					} else if (BrandTitle.equalsIgnoreCase("Hand baggage")) {
//						currentInfo = "3";
//					} else if (BrandTitle.equalsIgnoreCase("Meal")) {
//						currentInfo = "4";
//					} else if (BrandTitle.equalsIgnoreCase("Miles Earned")) {
//						currentInfo = "5";
//					} else if (BrandTitle.equalsIgnoreCase("Seats")) {
//						currentInfo = "6";
//					} else if (BrandTitle.equalsIgnoreCase("Refunds")) {
//						currentInfo = "7";
//					} else if (BrandTitle.equalsIgnoreCase("Rebooking")) {
//						currentInfo = "8";
//					} else if (BrandTitle.equalsIgnoreCase("Complimentary")) {
//						currentInfo = "9";
//					}
//					int c = Integer.parseInt(currentInfo);
//					String Fe[] = BINotes.split(",");
//					String a = Fe[c - 1];
//					System.out.println(a);
//					if (BrandTitle.equalsIgnoreCase("Check in baggage")) {
//						Assert.assertTrue(a.equalsIgnoreCase(BrandInfo), "Wrong informaion applied");
//						QaExtentReport.test.log(Status.INFO,
//								"<b><i>" + BrandTitle + "</i></b>" + " Informaion applied correctly");
//					} else if (BrandTitle.equalsIgnoreCase("Carry on baggage")) {
//						Assert.assertTrue(a.equalsIgnoreCase(BrandInfo), "Wrong informaion applied");
//						QaExtentReport.test.log(Status.INFO,
//								"<b><i>" + BrandTitle + "</i></b>" + " Informaion applied correctly");
//					} else if (BrandTitle.equalsIgnoreCase("Hand baggage")) {
//						Assert.assertTrue(a.equalsIgnoreCase(BrandInfo), "Wrong informaion applied");
//						QaExtentReport.test.log(Status.INFO,
//								"<b><i>" + BrandTitle + "</i></b>" + " Informaion applied correctly");
//					} else if (BrandTitle.equalsIgnoreCase("Meal")) {
//						Assert.assertTrue(a.equalsIgnoreCase(BrandInfo), "Wrong informaion applied");
//						QaExtentReport.test.log(Status.INFO,
//								"<b><i>" + BrandTitle + "</i></b>" + " Informaion applied correctly");
//					} else if (BrandTitle.equalsIgnoreCase("Miles Earned")) {
//						Assert.assertTrue(a.equalsIgnoreCase(BrandInfo), "Wrong informaion applied");
//						QaExtentReport.test.log(Status.INFO,
//								"<b><i>" + BrandTitle + "</i></b>" + " Informaion applied correctly");
//					} else if (BrandTitle.equalsIgnoreCase("Seats")) {
//						Assert.assertTrue(a.equalsIgnoreCase(BrandInfo), "Wrong informaion applied");
//						QaExtentReport.test.log(Status.INFO,
//								"<b><i>" + BrandTitle + "</i></b>" + " Informaion applied correctly");
//					} else if (BrandTitle.equalsIgnoreCase("Refunds")) {
//						Assert.assertTrue(a.equalsIgnoreCase(BrandInfo), "Wrong informaion applied");
//						QaExtentReport.test.log(Status.INFO,
//								"<b><i>" + BrandTitle + "</i></b>" + " Informaion applied correctly");
//					} else if (BrandTitle.equalsIgnoreCase("Rebooking")) {
//						Assert.assertTrue(a.equalsIgnoreCase(BrandInfo), "Wrong informaion applied");
//						QaExtentReport.test.log(Status.INFO,
//								"<b><i>" + BrandTitle + "</i></b>" + " Informaion applied correctly");
//					} else if (BrandTitle.equalsIgnoreCase("Complimentary")) {
//						Assert.assertTrue(a.equalsIgnoreCase(BrandInfo), "Wrong informaion applied");
//						QaExtentReport.test.log(Status.INFO,
//								"<b><i>" + BrandTitle + "</i></b>" + " Informaion applied correctly");
//					}
//				}
					QaRobot.ClickOnElement("AFareDetails");
					Thread.sleep(7000);
					QaRobot.switchToWindow();
					QaRobot.ClickOnElement("AFareRules");
					Thread.sleep(3000);
					QaExtentReport.extentScreenshot("Fare Rules");
//					int Cq = Integer.parseInt(ChargesQty);
					for (int i = 1; i <= 1; i++) {
//						if (Source.equalsIgnoreCase("Live")) {
//						String MiniRules = QaBrowser.driver.findElement(By.xpath(
//								"(/html/body/div[1]/div[2]/div/section/div[2]/div[2]/div/div[2]/div/div[2]/div/div/div/div/div[2]/div[1]/div[1]/div[3]/div/div/div[5]/div/div/div[2]/div/div/div[1]/div/div/div/div/div/div[1]/div[2]/div/div[1]/table/tbody/tr/th)["
//										+ i + "]"))
//								.getText();
//						System.out.println(MiniRules);
//						String MiniRulesCharge = QaBrowser.driver.findElement(By.xpath(
//								"(/html/body/div[1]/div[2]/div/section/div[2]/div[2]/div/div[2]/div/div[2]/div/div/div/div/div[2]/div[1]/div[1]/div[3]/div/div/div[5]/div/div/div[2]/div/div/div[1]/div/div/div/div/div/div[1]/div[2]/div/div[1]/table/tbody/tr/td)["
//										+ i + "]"))
//								.getText();
//						System.out.println(MiniRulesCharge);
//						String currentCharges = "00";
//						if (MiniRules.equalsIgnoreCase("Cancellation Fees – Before Departure")) {
//							currentCharges = "1";
//						} else if (MiniRules.equalsIgnoreCase("Cancellation Fees – After Departure")) {
//							currentCharges = "2";
//						} else if (MiniRules.equalsIgnoreCase("Rescheduling Fees – Before Departure")) {
//							currentCharges = "3";
//						} else if (MiniRules.equalsIgnoreCase("Rescheduling Fees – After Departure")) {
//							currentCharges = "4";
//						} else if (MiniRules.equalsIgnoreCase("Company Cancellation Fees")) {
//							currentCharges = "5";
//						} else if (MiniRules.equalsIgnoreCase("Company Rescheduling Fees")) {
//							currentCharges = "6";
//						} else if (MiniRules.equalsIgnoreCase("Rerouting Charges")) {
//							currentCharges = "7";
//						} else if (MiniRules.equalsIgnoreCase("No Show Fees")) {
//							currentCharges = "8";
//						}
//						int c = Integer.parseInt(currentCharges);
//						String Fe[] = Fees.split(",");
//						String a = Fe[c - 1];
////						String a1 = a + ".00";
//						String a1 = a;
//						System.out.println(a1);
//						if (MiniRules.equalsIgnoreCase("Cancellation Fees – Before Departure")) {
//							Assert.assertTrue(a1.equalsIgnoreCase(MiniRulesCharge), "Wrong charges applied");
//							QaExtentReport.test.log(Status.INFO,
//									"<b><i>" + MiniRules + "</i></b>" + " Charges applied correctly");
//						} else if (MiniRules.equalsIgnoreCase("Cancellation Fees – After Departure")) {
//							Assert.assertTrue(a1.equalsIgnoreCase(MiniRulesCharge), "Wrong charges applied");
//							QaExtentReport.test.log(Status.INFO,
//									"<b><i>" + MiniRules + "</i></b>" + " Charges applied correctly");
//						} else if (MiniRules.equalsIgnoreCase("Rescheduling Fees – Before Departure")) {
//							Assert.assertTrue(a1.equalsIgnoreCase(MiniRulesCharge), "Wrong charges applied");
//							QaExtentReport.test.log(Status.INFO,
//									"<b><i>" + MiniRules + "</i></b>" + " Charges applied correctly");
//						} else if (MiniRules.equalsIgnoreCase("Rescheduling Fees – After Departure")) {
//							Assert.assertTrue(a1.equalsIgnoreCase(MiniRulesCharge), "Wrong charges applied");
//							QaExtentReport.test.log(Status.INFO,
//									"<b><i>" + MiniRules + "</i></b>" + " Charges applied correctly");
//						} else if (MiniRules.equalsIgnoreCase("Company Cancellation Fees")) {
//							Assert.assertTrue(a1.equalsIgnoreCase(MiniRulesCharge), "Wrong charges applied");
//							QaExtentReport.test.log(Status.INFO,
//									"<b><i>" + MiniRules + "</i></b>" + " Charges applied correctly");
//						} else if (MiniRules.equalsIgnoreCase("Company Rescheduling Fees")) {
//							Assert.assertTrue(a1.equalsIgnoreCase(MiniRulesCharge), "Wrong charges applied");
//							QaExtentReport.test.log(Status.INFO,
//									"<b><i>" + MiniRules + "</i></b>" + " Charges applied correctly");
//						} else if (MiniRules.equalsIgnoreCase("Rerouting Charges")) {
//							Assert.assertTrue(a1.equalsIgnoreCase(MiniRulesCharge), "Wrong charges applied");
//							QaExtentReport.test.log(Status.INFO,
//									"<b><i>" + MiniRules + "</i></b>" + " Charges applied correctly");
//						} else if (MiniRules.equalsIgnoreCase("No Show Fees")) {
//							Assert.assertTrue(a1.equalsIgnoreCase(MiniRulesCharge), "Wrong charges applied");
//							QaExtentReport.test.log(Status.INFO,
//									"<b><i>" + MiniRules + "</i></b>" + " Charges applied correctly");
//						}
//						} else {
//						String MiniRules = QaBrowser.driver.findElement(By.xpath(
//								"(/html/body/div[1]/div[2]/div/section/div[2]/div[1]/div[2]/div/div[2]/div/div[2]/div/div/div/div/div[2]/div[1]/div[1]/div[3]/div/div/div[5]/div/div/div[2]/div/div/div[1]/div/div/div/div/div/div[1]/div[2]/div/div[1]/table/tbody/tr/th)["
//										+ i + "]"))
//								.getText();
//						System.out.println(MiniRules);
//						String MiniRulesCharge = QaBrowser.driver.findElement(By.xpath(
//								"(/html/body/div[1]/div[2]/div/section/div[2]/div[1]/div[2]/div/div[2]/div/div[2]/div/div/div/div/div[2]/div[1]/div[1]/div[3]/div/div/div[5]/div/div/div[2]/div/div/div[1]/div/div/div/div/div/div[1]/div[2]/div/div[1]/table/tbody/tr/td)["
//										+ i + "]"))
//								.getText();
//						System.out.println(MiniRulesCharge);
//						String currentCharges = "00";
//						if (MiniRules.equalsIgnoreCase("Cancellation Fees – Before Departure")) {
//							currentCharges = "1";
//						} else if (MiniRules.equalsIgnoreCase("Cancellation Fees – After Departure")) {
//							currentCharges = "2";
//						} else if (MiniRules.equalsIgnoreCase("Rescheduling Fees – Before Departure")) {
//							currentCharges = "3";
//						} else if (MiniRules.equalsIgnoreCase("Rescheduling Fees – After Departure")) {
//							currentCharges = "4";
//						} else if (MiniRules.equalsIgnoreCase("Company Cancellation Fees")) {
//							currentCharges = "5";
//						} else if (MiniRules.equalsIgnoreCase("Company Rescheduling Fees")) {
//							currentCharges = "6";
//						} else if (MiniRules.equalsIgnoreCase("Rerouting Charges")) {
//							currentCharges = "7";
//						} else if (MiniRules.equalsIgnoreCase("No Show Fees")) {
//							currentCharges = "8";
//						}
//						int c = Integer.parseInt(currentCharges);
//						String Fe[] = Fees.split(",");
//						String a = Fe[c - 1];
//						String a1 = a + ".00";
//						System.out.println(a1);
//						if (MiniRules.equalsIgnoreCase("Cancellation Fees-Before Departure")) {
//							Assert.assertTrue(a1.equalsIgnoreCase(MiniRulesCharge), "Wrong charges applied");
//							QaExtentReport.test.log(Status.INFO,
//									"<b><i>" + MiniRules + "</i></b>" + " Charges applied correctly");
//						} else if (MiniRules.equalsIgnoreCase("Cancellation Fees-After Departure")) {
//							Assert.assertTrue(a1.equalsIgnoreCase(MiniRulesCharge), "Wrong charges applied");
//							QaExtentReport.test.log(Status.INFO,
//									"<b><i>" + MiniRules + "</i></b>" + " Charges applied correctly");
//						} else if (MiniRules.equalsIgnoreCase("Rescheduling Fees-Before Departure")) {
//							Assert.assertTrue(a1.equalsIgnoreCase(MiniRulesCharge), "Wrong charges applied");
//							QaExtentReport.test.log(Status.INFO,
//									"<b><i>" + MiniRules + "</i></b>" + " Charges applied correctly");
//						} else if (MiniRules.equalsIgnoreCase("Rescheduling Fees-After Departure")) {
//							Assert.assertTrue(a1.equalsIgnoreCase(MiniRulesCharge), "Wrong charges applied");
//							QaExtentReport.test.log(Status.INFO,
//									"<b><i>" + MiniRules + "</i></b>" + " Charges applied correctly");
//						} else if (MiniRules.equalsIgnoreCase("Company Cancellation Fees")) {
//							Assert.assertTrue(a1.equalsIgnoreCase(MiniRulesCharge), "Wrong charges applied");
//							QaExtentReport.test.log(Status.INFO,
//									"<b><i>" + MiniRules + "</i></b>" + " Charges applied correctly");
//						} else if (MiniRules.equalsIgnoreCase("Company Rescheduling Fees")) {
//							Assert.assertTrue(a1.equalsIgnoreCase(MiniRulesCharge), "Wrong charges applied");
//							QaExtentReport.test.log(Status.INFO,
//									"<b><i>" + MiniRules + "</i></b>" + " Charges applied correctly");
//						} else if (MiniRules.equalsIgnoreCase("Rerouting")) {
//							Assert.assertTrue(a1.equalsIgnoreCase(MiniRulesCharge), "Wrong charges applied");
//							QaExtentReport.test.log(Status.INFO,
//									"<b><i>" + MiniRules + "</i></b>" + " Charges applied correctly");
//						} else if (MiniRules.equalsIgnoreCase("No Show Fees")) {
//							Assert.assertTrue(a1.equalsIgnoreCase(MiniRulesCharge), "Wrong charges applied");
//							QaExtentReport.test.log(Status.INFO,
//									"<b><i>" + MiniRules + "</i></b>" + " Charges applied correctly");
//						}
//						}
					}
					Thread.sleep(5000);
					QaRobot.ClickOnElement("AFareBreakup");
					Thread.sleep(3000);
					QaExtentReport.extentScreenshot("Fare Breakup");
					Thread.sleep(5000);
					QaRobot.ClickOnElement("ABaggageInformation");
					Thread.sleep(3000);
					QaExtentReport.extentScreenshot("Baggage Information");
					Thread.sleep(10000);
					QaRobot.ClickOnElement("ACloseFareDetails");
					Thread.sleep(5000);
					QaRobot.scrollPage(-400);
					if (OneWayAirLine.equalsIgnoreCase("Air India")) {
						if (OneWayFareType.equalsIgnoreCase("Comfort")) {
							QaRobot.ClickOnElement("AddToCartJ1");
							if (getT.equalsIgnoreCase("Out of policy")) {
								QaRobot.alertAccept();
							}
						} else if (OneWayFareType.equalsIgnoreCase("Economy Basic")) {
							QaRobot.ClickOnElement("AddToCartJ1");
							if (getT.equalsIgnoreCase("Out of policy")) {
								QaRobot.alertAccept();
							}
						} else if (OneWayFareType.equalsIgnoreCase("Economy Starter Max")) {
							QaRobot.ClickOnElement("AddToCartJ3");
							if (getT.equalsIgnoreCase("Out of policy")) {
								QaRobot.alertAccept();
							}
						}
					} else if (OneWayAirLine.equalsIgnoreCase("Indigo")) {
						if (OneWayFareType.equalsIgnoreCase("Flexi Fare")) {
							QaRobot.ClickOnElement("AddToCartJ1");
							if (getT.equalsIgnoreCase("Out of policy")) {
								QaRobot.alertAccept();
							}
						} else if (OneWayFareType.equalsIgnoreCase("SAVER")) {
							QaRobot.ClickOnElement("AddToCartJ1");
							if (getT.equalsIgnoreCase("Out of policy")) {
								QaRobot.alertAccept();
							}
						} else if (OneWayFareType.equalsIgnoreCase("BUSINESS")) {
							QaRobot.ClickOnElement("AddToCartJ3");
							if (getT.equalsIgnoreCase("Out of policy")) {
								QaRobot.alertAccept();
							}
						}
					} else if (OneWayAirLine.equalsIgnoreCase("Akasa Air")) {
						if (OneWayFareType.equalsIgnoreCase("Economy")) {
							QaRobot.ClickOnElement("AddToCartJ1");
							if (getT.equalsIgnoreCase("Out of policy")) {
								QaRobot.alertAccept();
							}
						} else if (OneWayFareType.equalsIgnoreCase("SAVER")) {
							QaRobot.ClickOnElement("AddToCartJ1");
							if (getT.equalsIgnoreCase("Out of policy")) {
								QaRobot.alertAccept();
							}
						} else if (OneWayFareType.equalsIgnoreCase("BUSINESS")) {
							QaRobot.ClickOnElement("AddToCartJ3");
							if (getT.equalsIgnoreCase("Out of policy")) {
								QaRobot.alertAccept();
							}
						}
					} else if (OneWayAirLine.equalsIgnoreCase("SpiceJet")) {
						if (OneWayFareType.equalsIgnoreCase("Spice Saver")) {
							QaRobot.ClickOnElement("AddToCartJ1");
							if (getT.equalsIgnoreCase("Out of policy")) {
								QaRobot.alertAccept();
							}
						} else if (OneWayFareType.equalsIgnoreCase("PUB")) {
							QaRobot.ClickOnElement("AddToCartJ1");
							if (getT.equalsIgnoreCase("Out of policy")) {
								QaRobot.alertAccept();
							}
						} else if (OneWayFareType.equalsIgnoreCase("FLEXIBLE BUSINESS")) {
							QaRobot.ClickOnElement("AddToCartJ3");
							if (getT.equalsIgnoreCase("Out of policy")) {
								QaRobot.alertAccept();
							}
						} else if (OneWayFareType.equalsIgnoreCase("BUSINESS SAVER")) {
							QaRobot.ClickOnElement("AddToCartJ4");
							if (getT.equalsIgnoreCase("Out of policy")) {
								QaRobot.alertAccept();
							}
						}
					} else if (OneWayAirLine.equalsIgnoreCase("Vistara")) {
						if (OneWayFareType.equalsIgnoreCase("ECO LITE")) {
							QaRobot.ClickOnElement("AddToCartJ1");
							if (getT.equalsIgnoreCase("Out of policy")) {
								QaRobot.alertAccept();
							}
						} else if (OneWayFareType.equalsIgnoreCase("ECO STANDARD")) {
							QaRobot.ClickOnElement("AddToCartJ1");
							if (getT.equalsIgnoreCase("Out of policy")) {
								QaRobot.alertAccept();
							}
						} else if (OneWayFareType.equalsIgnoreCase("FLEXIBLE BUSINESS")) {
							QaRobot.ClickOnElement("AddToCartJ3");
							if (getT.equalsIgnoreCase("Out of policy")) {
								QaRobot.alertAccept();
							}
						} else if (OneWayFareType.equalsIgnoreCase("BUSINESS SAVER")) {
							QaRobot.ClickOnElement("AddToCartJ4");
							if (getT.equalsIgnoreCase("Out of policy")) {
								QaRobot.alertAccept();
							}
						}
					} else if (OneWayAirLine.equalsIgnoreCase("Air Asia")) {
						if (OneWayFareType.equalsIgnoreCase("Economy Fare")) {
							QaRobot.ClickOnElement("AddToCartJ1");
							if (getT.equalsIgnoreCase("Out of policy")) {
								QaRobot.alertAccept();
							}
						} else if (OneWayFareType.equalsIgnoreCase("ECO STANDARD")) {
							QaRobot.ClickOnElement("AddToCartJ1");
							if (getT.equalsIgnoreCase("Out of policy")) {
								QaRobot.alertAccept();
							}
						} else if (OneWayFareType.equalsIgnoreCase("FLEXIBLE BUSINESS")) {
							QaRobot.ClickOnElement("AddToCartJ3");
							if (getT.equalsIgnoreCase("Out of policy")) {
								QaRobot.alertAccept();
							}
						} else if (OneWayFareType.equalsIgnoreCase("BUSINESS SAVER")) {
							QaRobot.ClickOnElement("AddToCartJ4");
							if (getT.equalsIgnoreCase("Out of policy")) {
								QaRobot.alertAccept();
							}
						}
					}

					Thread.sleep(3000);
					QaRobot.switchToWindow();
					QaRobot.ClickOnElement("NotificationCloseJ");
					QaRobot.scrollPage(-400);
				} else if (triptype.equalsIgnoreCase("International")) {
					if (searchType.equalsIgnoreCase("Individual")) {
						String getT = QaBrowser.driver.findElement(By.xpath(
								"/html/body/div[1]/div[2]/div/section/div[2]/div[2]/div/div[2]/div[2]/div[1]/div/div/div[2]/div/div[2]/div[1]/div[2]/div/div[2]/div/span/span"))
								.getText();
						QaRobot.ClickOnElement("SelectInter");
						QaRobot.ClickOnElement("AddToCartJ1");
						if (getT.equalsIgnoreCase("Out policy")) {
							QaRobot.alertAccept();
						}
					} else if (searchType.equalsIgnoreCase("Dependent")) {
						String getT1 = QaBrowser.driver.findElement(By.xpath(
								"/html/body/div[1]/div[2]/div/section/div[2]/div[2]/div/div[2]/div[2]/div[1]/div/div/div[2]/div/div[2]/div[1]/div[2]/div/div[2]/div/span/span"))
								.getText();
						QaRobot.ClickOnElement("SelectInter");
						QaRobot.ClickOnElement("AddToCartJ1");
						if (getT1.equalsIgnoreCase("Out policy")) {
							QaRobot.alertAccept();
						}
					}
					QaRobot.switchToWindow();
					QaRobot.ClickOnElement("NotificationCloseJ");
				}
			} else if (Trip.equalsIgnoreCase("RoundTrip")) {
				if (triptype.equalsIgnoreCase("Domestic")) {
					QaRobot.ClickOnElement("AFlightItinerary");
					Thread.sleep(15000);
					QaExtentReport.extentScreenshot("Flight Itinerary");
					Thread.sleep(10000);
					QaRobot.ClickOnElement("AMoreDetails");
					Thread.sleep(7000);
					QaRobot.scrollPage(300);
					Thread.sleep(3000);
					QaExtentReport.extentScreenshot("More Details");
					String getT = QaBrowser.driver.findElement(By.xpath(
							"//div[contains(@id,'moredetails')]/div/div/div[1]/div[2]/div[1]/div/div/div/span/span[2]"))
							.getText();
//					int Bi = Integer.parseInt(KIQty);
//					for (int i = 1; i <= Bi; i++) {
//						String BrandTitle = QaBrowser.driver.findElement(By.xpath(
//								"(/html/body/div[1]/div[2]/div/section/div[2]/div[1]/div[2]/div/div[2]/div/div[2]/div/div/div/div/div[2]/div[1]/div[1]/div[3]/div/div/div[2]/div/div/div[2]/div/div/h2)["
//										+ i + "]"))
//								.getText();
//						System.out.println(BrandTitle);
//						String BrandInfo = QaBrowser.driver.findElement(By.xpath(
//								"(/html/body/div[1]/div[2]/div/section/div[2]/div[1]/div[2]/div/div[2]/div/div[2]/div/div/div/div/div[2]/div[1]/div[1]/div[3]/div/div/div[2]/div/div/div[2]/div/div/p)["
//										+ i + "]"))
//								.getText();
//						System.out.println(BrandInfo);
//						String currentInfo = "00";
//						if (BrandTitle.equalsIgnoreCase("Check in baggage")) {
//							currentInfo = "1";
//						} else if (BrandTitle.equalsIgnoreCase("Carry on baggage")) {
//							currentInfo = "2";
//						} else if (BrandTitle.equalsIgnoreCase("Hand baggage")) {
//							currentInfo = "3";
//						} else if (BrandTitle.equalsIgnoreCase("Meal")) {
//							currentInfo = "4";
//						} else if (BrandTitle.equalsIgnoreCase("Miles Earned")) {
//							currentInfo = "5";
//						} else if (BrandTitle.equalsIgnoreCase("Seats")) {
//							currentInfo = "6";
//						} else if (BrandTitle.equalsIgnoreCase("Refunds")) {
//							currentInfo = "7";
//						} else if (BrandTitle.equalsIgnoreCase("Rebooking")) {
//							currentInfo = "8";
//						} else if (BrandTitle.equalsIgnoreCase("Complimentary")) {
//							currentInfo = "9";
//						}
//						int c = Integer.parseInt(currentInfo);
//						String Fe[] = BINotes.split(",");
//						String a = Fe[c - 1];
//						System.out.println(a);
//						if (BrandTitle.equalsIgnoreCase("Check in baggage")) {
//							Assert.assertTrue(a.equalsIgnoreCase(BrandInfo), "Wrong informaion applied");
//							QaExtentReport.test.log(Status.INFO,
//									"<b><i>" + BrandTitle + "</i></b>" + " Informaion applied correctly");
//						} else if (BrandTitle.equalsIgnoreCase("Carry on baggage")) {
//							Assert.assertTrue(a.equalsIgnoreCase(BrandInfo), "Wrong informaion applied");
//							QaExtentReport.test.log(Status.INFO,
//									"<b><i>" + BrandTitle + "</i></b>" + " Informaion applied correctly");
//						} else if (BrandTitle.equalsIgnoreCase("Hand baggage")) {
//							Assert.assertTrue(a.equalsIgnoreCase(BrandInfo), "Wrong informaion applied");
//							QaExtentReport.test.log(Status.INFO,
//									"<b><i>" + BrandTitle + "</i></b>" + " Informaion applied correctly");
//						} else if (BrandTitle.equalsIgnoreCase("Meal")) {
//							Assert.assertTrue(a.equalsIgnoreCase(BrandInfo), "Wrong informaion applied");
//							QaExtentReport.test.log(Status.INFO,
//									"<b><i>" + BrandTitle + "</i></b>" + " Informaion applied correctly");
//						} else if (BrandTitle.equalsIgnoreCase("Miles Earned")) {
//							Assert.assertTrue(a.equalsIgnoreCase(BrandInfo), "Wrong informaion applied");
//							QaExtentReport.test.log(Status.INFO,
//									"<b><i>" + BrandTitle + "</i></b>" + " Informaion applied correctly");
//						} else if (BrandTitle.equalsIgnoreCase("Seats")) {
//							Assert.assertTrue(a.equalsIgnoreCase(BrandInfo), "Wrong informaion applied");
//							QaExtentReport.test.log(Status.INFO,
//									"<b><i>" + BrandTitle + "</i></b>" + " Informaion applied correctly");
//						} else if (BrandTitle.equalsIgnoreCase("Refunds")) {
//							Assert.assertTrue(a.equalsIgnoreCase(BrandInfo), "Wrong informaion applied");
//							QaExtentReport.test.log(Status.INFO,
//									"<b><i>" + BrandTitle + "</i></b>" + " Informaion applied correctly");
//						} else if (BrandTitle.equalsIgnoreCase("Rebooking")) {
//							Assert.assertTrue(a.equalsIgnoreCase(BrandInfo), "Wrong informaion applied");
//							QaExtentReport.test.log(Status.INFO,
//									"<b><i>" + BrandTitle + "</i></b>" + " Informaion applied correctly");
//						} else if (BrandTitle.equalsIgnoreCase("Complimentary")) {
//							Assert.assertTrue(a.equalsIgnoreCase(BrandInfo), "Wrong informaion applied");
//							QaExtentReport.test.log(Status.INFO,
//									"<b><i>" + BrandTitle + "</i></b>" + " Informaion applied correctly");
//						}
//					}
					QaRobot.ClickOnElement("AFareDetails");
					Thread.sleep(7000);
					QaRobot.switchToWindow();
					QaRobot.ClickOnElement("AFareRules");
					Thread.sleep(3000);
					QaExtentReport.extentScreenshot("Fare Rules");
//					int Cq = Integer.parseInt(ChargesQty);
					for (int i = 1; i <= 1; i++) {
//						if (Source.equalsIgnoreCase("Live")) {
//							String MiniRules = QaBrowser.driver.findElement(By.xpath(
//									"(/html/body/div[1]/div[2]/div/section/div[2]/div[2]/div/div[2]/div/div[2]/div/div/div/div/div[2]/div[1]/div[1]/div[3]/div/div/div[5]/div/div/div[2]/div/div/div[1]/div/div/div/div/div/div[1]/div[2]/div/div[1]/table/tbody/tr/th)["
//											+ i + "]"))
//									.getText();
//							System.out.println(MiniRules);
//							String MiniRulesCharge = QaBrowser.driver.findElement(By.xpath(
//									"(/html/body/div[1]/div[2]/div/section/div[2]/div[2]/div/div[2]/div/div[2]/div/div/div/div/div[2]/div[1]/div[1]/div[3]/div/div/div[5]/div/div/div[2]/div/div/div[1]/div/div/div/div/div/div[1]/div[2]/div/div[1]/table/tbody/tr/td)["
//											+ i + "]"))
//									.getText();
//							System.out.println(MiniRulesCharge);
//							String currentCharges = "00";
//							if (MiniRules.equalsIgnoreCase("Cancellation Fees – Before Departure")) {
//								currentCharges = "1";
//							} else if (MiniRules.equalsIgnoreCase("Cancellation Fees – After Departure")) {
//								currentCharges = "2";
//							} else if (MiniRules.equalsIgnoreCase("Rescheduling Fees – Before Departure")) {
//								currentCharges = "3";
//							} else if (MiniRules.equalsIgnoreCase("Rescheduling Fees – After Departure")) {
//								currentCharges = "4";
//							} else if (MiniRules.equalsIgnoreCase("Company Cancellation Fees")) {
//								currentCharges = "5";
//							} else if (MiniRules.equalsIgnoreCase("Company Rescheduling Fees")) {
//								currentCharges = "6";
//							} else if (MiniRules.equalsIgnoreCase("Rerouting Charges")) {
//								currentCharges = "7";
//							} else if (MiniRules.equalsIgnoreCase("No Show Fees")) {
//								currentCharges = "8";
//							}
//							int c = Integer.parseInt(currentCharges);
//							String Fe[] = Fees.split(",");
//							String a = Fe[c - 1];
////							String a1 = a + ".00";
//							String a1 = a;
//							System.out.println(a1);
//							if (MiniRules.equalsIgnoreCase("Cancellation Fees – Before Departure")) {
//								Assert.assertTrue(a1.equalsIgnoreCase(MiniRulesCharge), "Wrong charges applied");
//								QaExtentReport.test.log(Status.INFO,
//										"<b><i>" + MiniRules + "</i></b>" + " Charges applied correctly");
//							} else if (MiniRules.equalsIgnoreCase("Cancellation Fees – After Departure")) {
//								Assert.assertTrue(a1.equalsIgnoreCase(MiniRulesCharge), "Wrong charges applied");
//								QaExtentReport.test.log(Status.INFO,
//										"<b><i>" + MiniRules + "</i></b>" + " Charges applied correctly");
//							} else if (MiniRules.equalsIgnoreCase("Rescheduling Fees – Before Departure")) {
//								Assert.assertTrue(a1.equalsIgnoreCase(MiniRulesCharge), "Wrong charges applied");
//								QaExtentReport.test.log(Status.INFO,
//										"<b><i>" + MiniRules + "</i></b>" + " Charges applied correctly");
//							} else if (MiniRules.equalsIgnoreCase("Rescheduling Fees – After Departure")) {
//								Assert.assertTrue(a1.equalsIgnoreCase(MiniRulesCharge), "Wrong charges applied");
//								QaExtentReport.test.log(Status.INFO,
//										"<b><i>" + MiniRules + "</i></b>" + " Charges applied correctly");
//							} else if (MiniRules.equalsIgnoreCase("Company Cancellation Fees")) {
//								Assert.assertTrue(a1.equalsIgnoreCase(MiniRulesCharge), "Wrong charges applied");
//								QaExtentReport.test.log(Status.INFO,
//										"<b><i>" + MiniRules + "</i></b>" + " Charges applied correctly");
//							} else if (MiniRules.equalsIgnoreCase("Company Rescheduling Fees")) {
//								Assert.assertTrue(a1.equalsIgnoreCase(MiniRulesCharge), "Wrong charges applied");
//								QaExtentReport.test.log(Status.INFO,
//										"<b><i>" + MiniRules + "</i></b>" + " Charges applied correctly");
//							} else if (MiniRules.equalsIgnoreCase("Rerouting Charges")) {
//								Assert.assertTrue(a1.equalsIgnoreCase(MiniRulesCharge), "Wrong charges applied");
//								QaExtentReport.test.log(Status.INFO,
//										"<b><i>" + MiniRules + "</i></b>" + " Charges applied correctly");
//							} else if (MiniRules.equalsIgnoreCase("No Show Fees")) {
//								Assert.assertTrue(a1.equalsIgnoreCase(MiniRulesCharge), "Wrong charges applied");
//								QaExtentReport.test.log(Status.INFO,
//										"<b><i>" + MiniRules + "</i></b>" + " Charges applied correctly");
//							}
//						} else {
//							String MiniRules = QaBrowser.driver.findElement(By.xpath(
//									"(/html/body/div[1]/div[2]/div/section/div[2]/div[1]/div[2]/div/div[2]/div/div[2]/div/div/div/div/div[2]/div[1]/div[1]/div[3]/div/div/div[5]/div/div/div[2]/div/div/div[1]/div/div/div/div/div/div[1]/div[2]/div/div[1]/table/tbody/tr/th)["
//											+ i + "]"))
//									.getText();
//							System.out.println(MiniRules);
//							String MiniRulesCharge = QaBrowser.driver.findElement(By.xpath(
//									"(/html/body/div[1]/div[2]/div/section/div[2]/div[1]/div[2]/div/div[2]/div/div[2]/div/div/div/div/div[2]/div[1]/div[1]/div[3]/div/div/div[5]/div/div/div[2]/div/div/div[1]/div/div/div/div/div/div[1]/div[2]/div/div[1]/table/tbody/tr/td)["
//											+ i + "]"))
//									.getText();
//							System.out.println(MiniRulesCharge);
//							String currentCharges = "00";
//							if (MiniRules.equalsIgnoreCase("Cancellation Fees – Before Departure")) {
//								currentCharges = "1";
//							} else if (MiniRules.equalsIgnoreCase("Cancellation Fees – After Departure")) {
//								currentCharges = "2";
//							} else if (MiniRules.equalsIgnoreCase("Rescheduling Fees – Before Departure")) {
//								currentCharges = "3";
//							} else if (MiniRules.equalsIgnoreCase("Rescheduling Fees – After Departure")) {
//								currentCharges = "4";
//							} else if (MiniRules.equalsIgnoreCase("Company Cancellation Fees")) {
//								currentCharges = "5";
//							} else if (MiniRules.equalsIgnoreCase("Company Rescheduling Fees")) {
//								currentCharges = "6";
//							} else if (MiniRules.equalsIgnoreCase("Rerouting Charges")) {
//								currentCharges = "7";
//							} else if (MiniRules.equalsIgnoreCase("No Show Fees")) {
//								currentCharges = "8";
//							}
//							int c = Integer.parseInt(currentCharges);
//							String Fe[] = Fees.split(",");
//							String a = Fe[c - 1];
//							String a1 = a + ".00";
//							System.out.println(a1);
//							if (MiniRules.equalsIgnoreCase("Cancellation Fees-Before Departure")) {
//								Assert.assertTrue(a1.equalsIgnoreCase(MiniRulesCharge), "Wrong charges applied");
//								QaExtentReport.test.log(Status.INFO,
//										"<b><i>" + MiniRules + "</i></b>" + " Charges applied correctly");
//							} else if (MiniRules.equalsIgnoreCase("Cancellation Fees-After Departure")) {
//								Assert.assertTrue(a1.equalsIgnoreCase(MiniRulesCharge), "Wrong charges applied");
//								QaExtentReport.test.log(Status.INFO,
//										"<b><i>" + MiniRules + "</i></b>" + " Charges applied correctly");
//							} else if (MiniRules.equalsIgnoreCase("Rescheduling Fees-Before Departure")) {
//								Assert.assertTrue(a1.equalsIgnoreCase(MiniRulesCharge), "Wrong charges applied");
//								QaExtentReport.test.log(Status.INFO,
//										"<b><i>" + MiniRules + "</i></b>" + " Charges applied correctly");
//							} else if (MiniRules.equalsIgnoreCase("Rescheduling Fees-After Departure")) {
//								Assert.assertTrue(a1.equalsIgnoreCase(MiniRulesCharge), "Wrong charges applied");
//								QaExtentReport.test.log(Status.INFO,
//										"<b><i>" + MiniRules + "</i></b>" + " Charges applied correctly");
//							} else if (MiniRules.equalsIgnoreCase("Company Cancellation Fees")) {
//								Assert.assertTrue(a1.equalsIgnoreCase(MiniRulesCharge), "Wrong charges applied");
//								QaExtentReport.test.log(Status.INFO,
//										"<b><i>" + MiniRules + "</i></b>" + " Charges applied correctly");
//							} else if (MiniRules.equalsIgnoreCase("Company Rescheduling Fees")) {
//								Assert.assertTrue(a1.equalsIgnoreCase(MiniRulesCharge), "Wrong charges applied");
//								QaExtentReport.test.log(Status.INFO,
//										"<b><i>" + MiniRules + "</i></b>" + " Charges applied correctly");
//							} else if (MiniRules.equalsIgnoreCase("Rerouting")) {
//								Assert.assertTrue(a1.equalsIgnoreCase(MiniRulesCharge), "Wrong charges applied");
//								QaExtentReport.test.log(Status.INFO,
//										"<b><i>" + MiniRules + "</i></b>" + " Charges applied correctly");
//							} else if (MiniRules.equalsIgnoreCase("No Show Fees")) {
//								Assert.assertTrue(a1.equalsIgnoreCase(MiniRulesCharge), "Wrong charges applied");
//								QaExtentReport.test.log(Status.INFO,
//										"<b><i>" + MiniRules + "</i></b>" + " Charges applied correctly");
//							}
//						}
					}
					Thread.sleep(5000);
					QaRobot.ClickOnElement("AFareBreakup");
					Thread.sleep(3000);
					QaExtentReport.extentScreenshot("Fare Breakup");
					Thread.sleep(5000);
					QaRobot.ClickOnElement("ABaggageInformation");
					Thread.sleep(3000);
					QaExtentReport.extentScreenshot("Baggage Information");
					Thread.sleep(10000);
					QaRobot.ClickOnElement("ACloseFareDetails");
					Thread.sleep(5000);
					QaRobot.scrollPage(-400);
					if (OneWayAirLine.equalsIgnoreCase("Air India")) {
						if (OneWayFareType.equalsIgnoreCase("Comfort")) {
							QaRobot.ClickOnElement("AddToCartJ1");
							if (getT.equalsIgnoreCase("Out of policy")) {
								QaRobot.alertAccept();
							}
						} else if (OneWayFareType.equalsIgnoreCase("Economy Basic")) {
							QaRobot.ClickOnElement("AddToCartJ2");
							if (getT.equalsIgnoreCase("Out of policy")) {
								QaRobot.alertAccept();
							}
						} else if (OneWayFareType.equalsIgnoreCase("Economy Starter Max")) {
							QaRobot.ClickOnElement("AddToCartJ3");
							if (getT.equalsIgnoreCase("Out of policy")) {
								QaRobot.alertAccept();
							}
						}
					} else if (OneWayAirLine.equalsIgnoreCase("Indigo")) {
						if (OneWayFareType.equalsIgnoreCase("Flexi Fare")) {
							QaRobot.ClickOnElement("AddToCartJ1");
							if (getT.equalsIgnoreCase("Out of policy")) {
								QaRobot.alertAccept();
							}
						} else if (OneWayFareType.equalsIgnoreCase("SAVER")) {
							QaRobot.ClickOnElement("AddToCartJ2");
							if (getT.equalsIgnoreCase("Out of policy")) {
								QaRobot.alertAccept();
							}
						} else if (OneWayFareType.equalsIgnoreCase("BUSINESS")) {
							QaRobot.ClickOnElement("AddToCartJ3");
							if (getT.equalsIgnoreCase("Out of policy")) {
								QaRobot.alertAccept();
							}
						}
					} else if (OneWayAirLine.equalsIgnoreCase("Akasa Air")) {
						if (OneWayFareType.equalsIgnoreCase("Economy")) {
							QaRobot.ClickOnElement("AddToCartJ1");
							if (getT.equalsIgnoreCase("Out of policy")) {
								QaRobot.alertAccept();
							}
						} else if (OneWayFareType.equalsIgnoreCase("SAVER")) {
							QaRobot.ClickOnElement("AddToCartJ1");
							if (getT.equalsIgnoreCase("Out of policy")) {
								QaRobot.alertAccept();
							}
						} else if (OneWayFareType.equalsIgnoreCase("BUSINESS")) {
							QaRobot.ClickOnElement("AddToCartJ3");
							if (getT.equalsIgnoreCase("Out of policy")) {
								QaRobot.alertAccept();
							}
						}
					} else if (OneWayAirLine.equalsIgnoreCase("SpiceJet")) {
						if (OneWayFareType.equalsIgnoreCase("Spice Saver")) {
							QaRobot.ClickOnElement("AddToCartJ1");
							if (getT.equalsIgnoreCase("Out of policy")) {
								QaRobot.alertAccept();
							}
						} else if (OneWayFareType.equalsIgnoreCase("PUB")) {
							QaRobot.ClickOnElement("AddToCartJ1");
							if (getT.equalsIgnoreCase("Out of policy")) {
								QaRobot.alertAccept();
							}
						} else if (OneWayFareType.equalsIgnoreCase("FLEXIBLE BUSINESS")) {
							QaRobot.ClickOnElement("AddToCartJ3");
							if (getT.equalsIgnoreCase("Out of policy")) {
								QaRobot.alertAccept();
							}
						} else if (OneWayFareType.equalsIgnoreCase("BUSINESS SAVER")) {
							QaRobot.ClickOnElement("AddToCartJ4");
							if (getT.equalsIgnoreCase("Out of policy")) {
								QaRobot.alertAccept();
							}
						}
					} else if (OneWayAirLine.equalsIgnoreCase("Vistara")) {
						if (OneWayFareType.equalsIgnoreCase("ECO LITE")) {
							QaRobot.ClickOnElement("AddToCartJ1");
							if (getT.equalsIgnoreCase("Out of policy")) {
								QaRobot.alertAccept();
							}
						} else if (OneWayFareType.equalsIgnoreCase("ECO STANDARD")) {
							QaRobot.ClickOnElement("AddToCartJ1");
							if (getT.equalsIgnoreCase("Out of policy")) {
								QaRobot.alertAccept();
							}
						} else if (OneWayFareType.equalsIgnoreCase("FLEXIBLE BUSINESS")) {
							QaRobot.ClickOnElement("AddToCartJ3");
							if (getT.equalsIgnoreCase("Out of policy")) {
								QaRobot.alertAccept();
							}
						} else if (OneWayFareType.equalsIgnoreCase("BUSINESS SAVER")) {
							QaRobot.ClickOnElement("AddToCartJ4");
							if (getT.equalsIgnoreCase("Out of policy")) {
								QaRobot.alertAccept();
							}
						}
					} else if (OneWayAirLine.equalsIgnoreCase("Air Asia")) {
						if (OneWayFareType.equalsIgnoreCase("Economy Fare")) {
							QaRobot.ClickOnElement("AddToCartJ1");
							if (getT.equalsIgnoreCase("Out of policy")) {
								QaRobot.alertAccept();
							}
						} else if (OneWayFareType.equalsIgnoreCase("ECO STANDARD")) {
							QaRobot.ClickOnElement("AddToCartJ1");
							if (getT.equalsIgnoreCase("Out of policy")) {
								QaRobot.alertAccept();
							}
						} else if (OneWayFareType.equalsIgnoreCase("FLEXIBLE BUSINESS")) {
							QaRobot.ClickOnElement("AddToCartJ3");
							if (getT.equalsIgnoreCase("Out of policy")) {
								QaRobot.alertAccept();
							}
						} else if (OneWayFareType.equalsIgnoreCase("BUSINESS SAVER")) {
							QaRobot.ClickOnElement("AddToCartJ4");
							if (getT.equalsIgnoreCase("Out of policy")) {
								QaRobot.alertAccept();
							}
						}
					}
					Thread.sleep(3000);
					QaRobot.switchToWindow();
					QaRobot.ClickOnElement("NotificationCloseJ");
					QaRobot.ClickOnElement("ResultRJ");
					Thread.sleep(5000);
					if (Source.equalsIgnoreCase("Live")) {
						List<WebElement> listOfStop = QaBrowser.driver.findElements(By.xpath(
								"/html/body/div[1]/div[2]/div/section/div[2]/div[2]/div/div[1]/div/div[3]/div[5]/div[2]/ul/li/span"));
						for (WebElement autoStop : listOfStop) {
//							System.out.println(autoAirline.getText());
							if (autoStop.getText().equalsIgnoreCase(Stops)) {
								autoStop.click();
								break;
							}
						}
					} else {
						List<WebElement> listOfStop1 = QaBrowser.driver.findElements(By.xpath(
								"/html/body/div[1]/div[2]/div/section/div[2]/div[2]/div/div[1]/div/div[3]/div[4]/div[2]/ul/li/span"));
						for (WebElement autoStop1 : listOfStop1) {
//							System.out.println(autoAirline.getText());
							if (autoStop1.getText().equalsIgnoreCase(Stops)) {
								autoStop1.click();
								break;
							}
						}
					}
					List<WebElement> listOfAirLine = QaBrowser.driver
							.findElements(By.xpath("//div[@id='tdContainerTblAirlines']/ul/li/label/span"));
					for (WebElement autoAirline : listOfAirLine) {
						if (autoAirline.getText().equalsIgnoreCase(RoundTripAirLine)) {
							autoAirline.click();
							break;
						}
					}
					QaRobot.scrollPage(-1000);
					Thread.sleep(5000);
					QaRobot.ClickOnElement("AFlightItinerary");
					Thread.sleep(15000);
					QaExtentReport.extentScreenshot("Flight Itinerary");
					Thread.sleep(10000);
					QaRobot.ClickOnElement("AMoreDetails");
					Thread.sleep(7000);
					QaRobot.scrollPage(300);
					Thread.sleep(3000);
					QaExtentReport.extentScreenshot("More Details");
					String getT1 = QaBrowser.driver.findElement(By.xpath(
							"//div[contains(@id,'moredetails')]/div/div/div[1]/div[2]/div[1]/div/div/div/span/span[2]"))
							.getText();
//					int Bir = Integer.parseInt(KIQty);
//					for (int i = 1; i <= Bir; i++) {
//						String BrandTitle = QaBrowser.driver.findElement(By.xpath(
//								"(/html/body/div[1]/div[2]/div/section/div[2]/div[1]/div[2]/div/div[2]/div/div[2]/div/div/div/div/div[2]/div[1]/div[1]/div[3]/div/div/div[2]/div/div/div[2]/div/div/h2)["
//										+ i + "]"))
//								.getText();
//						System.out.println(BrandTitle);
//						String BrandInfo = QaBrowser.driver.findElement(By.xpath(
//								"(/html/body/div[1]/div[2]/div/section/div[2]/div[1]/div[2]/div/div[2]/div/div[2]/div/div/div/div/div[2]/div[1]/div[1]/div[3]/div/div/div[2]/div/div/div[2]/div/div/p)["
//										+ i + "]"))
//								.getText();
//						System.out.println(BrandInfo);
//						String currentInfo = "00";
//						if (BrandTitle.equalsIgnoreCase("Check in baggage")) {
//							currentInfo = "1";
//						} else if (BrandTitle.equalsIgnoreCase("Carry on baggage")) {
//							currentInfo = "2";
//						} else if (BrandTitle.equalsIgnoreCase("Hand baggage")) {
//							currentInfo = "3";
//						} else if (BrandTitle.equalsIgnoreCase("Meal")) {
//							currentInfo = "4";
//						} else if (BrandTitle.equalsIgnoreCase("Miles Earned")) {
//							currentInfo = "5";
//						} else if (BrandTitle.equalsIgnoreCase("Seats")) {
//							currentInfo = "6";
//						} else if (BrandTitle.equalsIgnoreCase("Refunds")) {
//							currentInfo = "7";
//						} else if (BrandTitle.equalsIgnoreCase("Rebooking")) {
//							currentInfo = "8";
//						} else if (BrandTitle.equalsIgnoreCase("Complimentary")) {
//							currentInfo = "9";
//						}
//						int c = Integer.parseInt(currentInfo);
//						String Fe[] = BINotes.split(",");
//						String a = Fe[c - 1];
//						System.out.println(a);
//						if (BrandTitle.equalsIgnoreCase("Check in baggage")) {
//							Assert.assertTrue(a.equalsIgnoreCase(BrandInfo), "Wrong informaion applied");
//							QaExtentReport.test.log(Status.INFO,
//									"<b><i>" + BrandTitle + "</i></b>" + " Informaion applied correctly");
//						} else if (BrandTitle.equalsIgnoreCase("Carry on baggage")) {
//							Assert.assertTrue(a.equalsIgnoreCase(BrandInfo), "Wrong informaion applied");
//							QaExtentReport.test.log(Status.INFO,
//									"<b><i>" + BrandTitle + "</i></b>" + " Informaion applied correctly");
//						} else if (BrandTitle.equalsIgnoreCase("Hand baggage")) {
//							Assert.assertTrue(a.equalsIgnoreCase(BrandInfo), "Wrong informaion applied");
//							QaExtentReport.test.log(Status.INFO,
//									"<b><i>" + BrandTitle + "</i></b>" + " Informaion applied correctly");
//						} else if (BrandTitle.equalsIgnoreCase("Meal")) {
//							Assert.assertTrue(a.equalsIgnoreCase(BrandInfo), "Wrong informaion applied");
//							QaExtentReport.test.log(Status.INFO,
//									"<b><i>" + BrandTitle + "</i></b>" + " Informaion applied correctly");
//						} else if (BrandTitle.equalsIgnoreCase("Miles Earned")) {
//							Assert.assertTrue(a.equalsIgnoreCase(BrandInfo), "Wrong informaion applied");
//							QaExtentReport.test.log(Status.INFO,
//									"<b><i>" + BrandTitle + "</i></b>" + " Informaion applied correctly");
//						} else if (BrandTitle.equalsIgnoreCase("Seats")) {
//							Assert.assertTrue(a.equalsIgnoreCase(BrandInfo), "Wrong informaion applied");
//							QaExtentReport.test.log(Status.INFO,
//									"<b><i>" + BrandTitle + "</i></b>" + " Informaion applied correctly");
//						} else if (BrandTitle.equalsIgnoreCase("Refunds")) {
//							Assert.assertTrue(a.equalsIgnoreCase(BrandInfo), "Wrong informaion applied");
//							QaExtentReport.test.log(Status.INFO,
//									"<b><i>" + BrandTitle + "</i></b>" + " Informaion applied correctly");
//						} else if (BrandTitle.equalsIgnoreCase("Rebooking")) {
//							Assert.assertTrue(a.equalsIgnoreCase(BrandInfo), "Wrong informaion applied");
//							QaExtentReport.test.log(Status.INFO,
//									"<b><i>" + BrandTitle + "</i></b>" + " Informaion applied correctly");
//						} else if (BrandTitle.equalsIgnoreCase("Complimentary")) {
//							Assert.assertTrue(a.equalsIgnoreCase(BrandInfo), "Wrong informaion applied");
//							QaExtentReport.test.log(Status.INFO,
//									"<b><i>" + BrandTitle + "</i></b>" + " Informaion applied correctly");
//						}
//					}
					QaRobot.ClickOnElement("AFareDetails");
					Thread.sleep(7000);
					QaRobot.switchToWindow();
					QaRobot.ClickOnElement("AFareRules");
					Thread.sleep(3000);
					QaExtentReport.extentScreenshot("Fare Rules");
//					int Cq1 = Integer.parseInt(ChargesQty);
					for (int i = 1; i <= 1; i++) {
//						if (Source.equalsIgnoreCase("Live")) {
//							String MiniRules = QaBrowser.driver.findElement(By.xpath(
//									"(/html/body/div[1]/div[2]/div/section/div[2]/div[2]/div/div[2]/div/div[2]/div/div/div/div/div[2]/div[1]/div[1]/div[3]/div/div/div[5]/div/div/div[2]/div/div/div[1]/div/div/div/div/div/div[1]/div[2]/div/div[1]/table/tbody/tr/th)["
//											+ i + "]"))
//									.getText();
//							System.out.println(MiniRules);
//							String MiniRulesCharge = QaBrowser.driver.findElement(By.xpath(
//									"(/html/body/div[1]/div[2]/div/section/div[2]/div[2]/div/div[2]/div/div[2]/div/div/div/div/div[2]/div[1]/div[1]/div[3]/div/div/div[5]/div/div/div[2]/div/div/div[1]/div/div/div/div/div/div[1]/div[2]/div/div[1]/table/tbody/tr/td)["
//											+ i + "]"))
//									.getText();
//							System.out.println(MiniRulesCharge);
//							String currentCharges = "00";
//							if (MiniRules.equalsIgnoreCase("Cancellation Fees – Before Departure")) {
//								currentCharges = "1";
//							} else if (MiniRules.equalsIgnoreCase("Cancellation Fees – After Departure")) {
//								currentCharges = "2";
//							} else if (MiniRules.equalsIgnoreCase("Rescheduling Fees – Before Departure")) {
//								currentCharges = "3";
//							} else if (MiniRules.equalsIgnoreCase("Rescheduling Fees – After Departure")) {
//								currentCharges = "4";
//							} else if (MiniRules.equalsIgnoreCase("Company Cancellation Fees")) {
//								currentCharges = "5";
//							} else if (MiniRules.equalsIgnoreCase("Company Rescheduling Fees")) {
//								currentCharges = "6";
//							} else if (MiniRules.equalsIgnoreCase("Rerouting Charges")) {
//								currentCharges = "7";
//							} else if (MiniRules.equalsIgnoreCase("No Show Fees")) {
//								currentCharges = "8";
//							}
//							int c = Integer.parseInt(currentCharges);
//							String Fe[] = Fees.split(",");
//							String a = Fe[c - 1];
////							String a1 = a + ".00";
//							String a1 = a;
//							System.out.println(a1);
//							if (MiniRules.equalsIgnoreCase("Cancellation Fees – Before Departure")) {
//								Assert.assertTrue(a1.equalsIgnoreCase(MiniRulesCharge), "Wrong charges applied");
//								QaExtentReport.test.log(Status.INFO,
//										"<b><i>" + MiniRules + "</i></b>" + " Charges applied correctly");
//							} else if (MiniRules.equalsIgnoreCase("Cancellation Fees – After Departure")) {
//								Assert.assertTrue(a1.equalsIgnoreCase(MiniRulesCharge), "Wrong charges applied");
//								QaExtentReport.test.log(Status.INFO,
//										"<b><i>" + MiniRules + "</i></b>" + " Charges applied correctly");
//							} else if (MiniRules.equalsIgnoreCase("Rescheduling Fees – Before Departure")) {
//								Assert.assertTrue(a1.equalsIgnoreCase(MiniRulesCharge), "Wrong charges applied");
//								QaExtentReport.test.log(Status.INFO,
//										"<b><i>" + MiniRules + "</i></b>" + " Charges applied correctly");
//							} else if (MiniRules.equalsIgnoreCase("Rescheduling Fees – After Departure")) {
//								Assert.assertTrue(a1.equalsIgnoreCase(MiniRulesCharge), "Wrong charges applied");
//								QaExtentReport.test.log(Status.INFO,
//										"<b><i>" + MiniRules + "</i></b>" + " Charges applied correctly");
//							} else if (MiniRules.equalsIgnoreCase("Company Cancellation Fees")) {
//								Assert.assertTrue(a1.equalsIgnoreCase(MiniRulesCharge), "Wrong charges applied");
//								QaExtentReport.test.log(Status.INFO,
//										"<b><i>" + MiniRules + "</i></b>" + " Charges applied correctly");
//							} else if (MiniRules.equalsIgnoreCase("Company Rescheduling Fees")) {
//								Assert.assertTrue(a1.equalsIgnoreCase(MiniRulesCharge), "Wrong charges applied");
//								QaExtentReport.test.log(Status.INFO,
//										"<b><i>" + MiniRules + "</i></b>" + " Charges applied correctly");
//							} else if (MiniRules.equalsIgnoreCase("Rerouting Charges")) {
//								Assert.assertTrue(a1.equalsIgnoreCase(MiniRulesCharge), "Wrong charges applied");
//								QaExtentReport.test.log(Status.INFO,
//										"<b><i>" + MiniRules + "</i></b>" + " Charges applied correctly");
//							} else if (MiniRules.equalsIgnoreCase("No Show Fees")) {
//								Assert.assertTrue(a1.equalsIgnoreCase(MiniRulesCharge), "Wrong charges applied");
//								QaExtentReport.test.log(Status.INFO,
//										"<b><i>" + MiniRules + "</i></b>" + " Charges applied correctly");
//							}
//						} else {
//							String MiniRules = QaBrowser.driver.findElement(By.xpath(
//									"(/html/body/div[1]/div[2]/div/section/div[2]/div[1]/div[2]/div/div[2]/div/div[2]/div/div/div/div/div[2]/div[1]/div[1]/div[3]/div/div/div[5]/div/div/div[2]/div/div/div[1]/div/div/div/div/div/div[1]/div[2]/div/div[1]/table/tbody/tr/th)["
//											+ i + "]"))
//									.getText();
//							System.out.println(MiniRules);
//							String MiniRulesCharge = QaBrowser.driver.findElement(By.xpath(
//									"(/html/body/div[1]/div[2]/div/section/div[2]/div[1]/div[2]/div/div[2]/div/div[2]/div/div/div/div/div[2]/div[1]/div[1]/div[3]/div/div/div[5]/div/div/div[2]/div/div/div[1]/div/div/div/div/div/div[1]/div[2]/div/div[1]/table/tbody/tr/td)["
//											+ i + "]"))
//									.getText();
//							System.out.println(MiniRulesCharge);
//							String currentCharges = "00";
//							if (MiniRules.equalsIgnoreCase("Cancellation Fees – Before Departure")) {
//								currentCharges = "1";
//							} else if (MiniRules.equalsIgnoreCase("Cancellation Fees – After Departure")) {
//								currentCharges = "2";
//							} else if (MiniRules.equalsIgnoreCase("Rescheduling Fees – Before Departure")) {
//								currentCharges = "3";
//							} else if (MiniRules.equalsIgnoreCase("Rescheduling Fees – After Departure")) {
//								currentCharges = "4";
//							} else if (MiniRules.equalsIgnoreCase("Company Cancellation Fees")) {
//								currentCharges = "5";
//							} else if (MiniRules.equalsIgnoreCase("Company Rescheduling Fees")) {
//								currentCharges = "6";
//							} else if (MiniRules.equalsIgnoreCase("Rerouting Charges")) {
//								currentCharges = "7";
//							} else if (MiniRules.equalsIgnoreCase("No Show Fees")) {
//								currentCharges = "8";
//							}
//							int c = Integer.parseInt(currentCharges);
//							String Fe[] = Fees.split(",");
//							String a = Fe[c - 1];
//							String a1 = a + ".00";
//							System.out.println(a1);
//							if (MiniRules.equalsIgnoreCase("Cancellation Fees-Before Departure")) {
//								Assert.assertTrue(a1.equalsIgnoreCase(MiniRulesCharge), "Wrong charges applied");
//								QaExtentReport.test.log(Status.INFO,
//										"<b><i>" + MiniRules + "</i></b>" + " Charges applied correctly");
//							} else if (MiniRules.equalsIgnoreCase("Cancellation Fees-After Departure")) {
//								Assert.assertTrue(a1.equalsIgnoreCase(MiniRulesCharge), "Wrong charges applied");
//								QaExtentReport.test.log(Status.INFO,
//										"<b><i>" + MiniRules + "</i></b>" + " Charges applied correctly");
//							} else if (MiniRules.equalsIgnoreCase("Rescheduling Fees-Before Departure")) {
//								Assert.assertTrue(a1.equalsIgnoreCase(MiniRulesCharge), "Wrong charges applied");
//								QaExtentReport.test.log(Status.INFO,
//										"<b><i>" + MiniRules + "</i></b>" + " Charges applied correctly");
//							} else if (MiniRules.equalsIgnoreCase("Rescheduling Fees-After Departure")) {
//								Assert.assertTrue(a1.equalsIgnoreCase(MiniRulesCharge), "Wrong charges applied");
//								QaExtentReport.test.log(Status.INFO,
//										"<b><i>" + MiniRules + "</i></b>" + " Charges applied correctly");
//							} else if (MiniRules.equalsIgnoreCase("Company Cancellation Fees")) {
//								Assert.assertTrue(a1.equalsIgnoreCase(MiniRulesCharge), "Wrong charges applied");
//								QaExtentReport.test.log(Status.INFO,
//										"<b><i>" + MiniRules + "</i></b>" + " Charges applied correctly");
//							} else if (MiniRules.equalsIgnoreCase("Company Rescheduling Fees")) {
//								Assert.assertTrue(a1.equalsIgnoreCase(MiniRulesCharge), "Wrong charges applied");
//								QaExtentReport.test.log(Status.INFO,
//										"<b><i>" + MiniRules + "</i></b>" + " Charges applied correctly");
//							} else if (MiniRules.equalsIgnoreCase("Rerouting")) {
//								Assert.assertTrue(a1.equalsIgnoreCase(MiniRulesCharge), "Wrong charges applied");
//								QaExtentReport.test.log(Status.INFO,
//										"<b><i>" + MiniRules + "</i></b>" + " Charges applied correctly");
//							} else if (MiniRules.equalsIgnoreCase("No Show Fees")) {
//								Assert.assertTrue(a1.equalsIgnoreCase(MiniRulesCharge), "Wrong charges applied");
//								QaExtentReport.test.log(Status.INFO,
//										"<b><i>" + MiniRules + "</i></b>" + " Charges applied correctly");
//							}
//						}
					}
					Thread.sleep(5000);
					QaRobot.ClickOnElement("AFareBreakup");
					Thread.sleep(3000);
					QaExtentReport.extentScreenshot("Fare Breakup");
					Thread.sleep(5000);
					QaRobot.ClickOnElement("ABaggageInformation");
					Thread.sleep(3000);
					QaExtentReport.extentScreenshot("Baggage Information");
					Thread.sleep(10000);
					QaRobot.ClickOnElement("ACloseFareDetails");
					Thread.sleep(5000);
					QaRobot.scrollPage(-400);
					if (RoundTripAirLine.equalsIgnoreCase("Air India")) {
						if (RoundTripFareType.equalsIgnoreCase("Comfort")) {
							QaRobot.ClickOnElement("AddToCartJ1");
							if (getT1.equalsIgnoreCase("Out of policy")) {
								QaRobot.alertAccept();
							}
						} else if (RoundTripFareType.equalsIgnoreCase("Economy Basic")) {
							QaRobot.ClickOnElement("AddToCartJ2");
							if (getT1.equalsIgnoreCase("Out of policy")) {
								QaRobot.alertAccept();
							}
						} else if (RoundTripFareType.equalsIgnoreCase("Economy Starter Max")) {
							QaRobot.ClickOnElement("AddToCartJ3");
							if (getT1.equalsIgnoreCase("Out of policy")) {
								QaRobot.alertAccept();
							}
						}
					} else if (RoundTripAirLine.equalsIgnoreCase("Indigo")) {
						if (RoundTripFareType.equalsIgnoreCase("Flexi Fare")) {
							QaRobot.ClickOnElement("AddToCartJ1");
							if (getT.equalsIgnoreCase("Out of policy")) {
								QaRobot.alertAccept();
							}
						} else if (RoundTripFareType.equalsIgnoreCase("SME FARE")) {
							QaRobot.ClickOnElement("AddToCartJ1");
							if (getT1.equalsIgnoreCase("Out of policy")) {
								QaRobot.alertAccept();
							}
						} else if (RoundTripFareType.equalsIgnoreCase("SAVER")) {
							QaRobot.ClickOnElement("AddToCartJ2");
							if (getT1.equalsIgnoreCase("Out of policy")) {
								QaRobot.alertAccept();
							}
						} else if (RoundTripFareType.equalsIgnoreCase("BUSINESS")) {
							QaRobot.ClickOnElement("AddToCartJ3");
							if (getT1.equalsIgnoreCase("Out of policy")) {
								QaRobot.alertAccept();
							}
						}
					} else if (RoundTripAirLine.equalsIgnoreCase("Akasa Air")) {
						if (RoundTripFareType.equalsIgnoreCase("Economy")) {
							QaRobot.ClickOnElement("AddToCartJ1");
							if (getT1.equalsIgnoreCase("Out of policy")) {
								QaRobot.alertAccept();
							}
						} else if (RoundTripFareType.equalsIgnoreCase("SAVER")) {
							QaRobot.ClickOnElement("AddToCartJ1");
							if (getT1.equalsIgnoreCase("Out of policy")) {
								QaRobot.alertAccept();
							}
						} else if (RoundTripFareType.equalsIgnoreCase("BUSINESS")) {
							QaRobot.ClickOnElement("AddToCartJ3");
							if (getT1.equalsIgnoreCase("Out of policy")) {
								QaRobot.alertAccept();
							}
						}
					} else if (RoundTripAirLine.equalsIgnoreCase("SpiceJet")) {
						if (RoundTripFareType.equalsIgnoreCase("Spice Saver")) {
							QaRobot.ClickOnElement("AddToCartJ1");
							if (getT1.equalsIgnoreCase("Out of policy")) {
								QaRobot.alertAccept();
							}
						} else if (RoundTripFareType.equalsIgnoreCase("PUB")) {
							QaRobot.ClickOnElement("AddToCartJ1");
							if (getT1.equalsIgnoreCase("Out of policy")) {
								QaRobot.alertAccept();
							}
						} else if (RoundTripFareType.equalsIgnoreCase("FLEXIBLE BUSINESS")) {
							QaRobot.ClickOnElement("AddToCartJ3");
							if (getT1.equalsIgnoreCase("Out of policy")) {
								QaRobot.alertAccept();
							}
						} else if (RoundTripFareType.equalsIgnoreCase("BUSINESS SAVER")) {
							QaRobot.ClickOnElement("AddToCartJ4");
							if (getT1.equalsIgnoreCase("Out of policy")) {
								QaRobot.alertAccept();
							}
						}
					} else if (RoundTripAirLine.equalsIgnoreCase("Vistara")) {
						if (RoundTripFareType.equalsIgnoreCase("ECO LITE")) {
							QaRobot.ClickOnElement("AddToCartJ1");
							if (getT1.equalsIgnoreCase("Out of policy")) {
								QaRobot.alertAccept();
							}
						} else if (RoundTripFareType.equalsIgnoreCase("ECO STANDARD")) {
							QaRobot.ClickOnElement("AddToCartJ1");
							if (getT1.equalsIgnoreCase("Out of policy")) {
								QaRobot.alertAccept();
							}
						} else if (RoundTripFareType.equalsIgnoreCase("FLEXIBLE BUSINESS")) {
							QaRobot.ClickOnElement("AddToCartJ3");
							if (getT1.equalsIgnoreCase("Out of policy")) {
								QaRobot.alertAccept();
							}
						} else if (RoundTripFareType.equalsIgnoreCase("BUSINESS SAVER")) {
							QaRobot.ClickOnElement("AddToCartJ4");
							if (getT1.equalsIgnoreCase("Out of policy")) {
								QaRobot.alertAccept();
							}
						}
					} else if (RoundTripAirLine.equalsIgnoreCase("Air Asia")) {
						if (RoundTripFareType.equalsIgnoreCase("Economy Fare")) {
							QaRobot.ClickOnElement("AddToCartJ1");
							if (getT1.equalsIgnoreCase("Out of policy")) {
								QaRobot.alertAccept();
							}
						} else if (RoundTripFareType.equalsIgnoreCase("ECO STANDARD")) {
							QaRobot.ClickOnElement("AddToCartJ1");
							if (getT1.equalsIgnoreCase("Out of policy")) {
								QaRobot.alertAccept();
							}
						} else if (RoundTripFareType.equalsIgnoreCase("FLEXIBLE BUSINESS")) {
							QaRobot.ClickOnElement("AddToCartJ3");
							if (getT1.equalsIgnoreCase("Out of policy")) {
								QaRobot.alertAccept();
							}
						} else if (RoundTripFareType.equalsIgnoreCase("BUSINESS SAVER")) {
							QaRobot.ClickOnElement("AddToCartJ4");
							if (getT1.equalsIgnoreCase("Out of policy")) {
								QaRobot.alertAccept();
							}
						}
					}
					Thread.sleep(3000);
					QaRobot.switchToWindow();
					QaRobot.ClickOnElement("NotificationCloseJ");
				} else if (triptype.equalsIgnoreCase("International")) {
					List<WebElement> listOfStop = QaBrowser.driver.findElements(By.xpath(
							"//div[@id='FareDetailsController']/div[2]/div/div[1]/div/div[3]/div[4]/div[2]/ul/li/span"));
//					List<WebElement> listOfStop = QaBrowser.driver.findElements(By.xpath(
//							"//div[@id='FareDetailsController']/div[2]/div/div[1]/div/div[3]/div[5]/div[2]/ul/li/span"));
					for (WebElement autoStop : listOfStop) {
//						System.out.println(autoAirline.getText());
						if (autoStop.getText().equalsIgnoreCase(Stops)) {
							autoStop.click();
							break;
						}
					}
					Thread.sleep(3000);
					String getT = QaBrowser.driver.findElement(By.xpath(
							"/html/body/div[1]/div[2]/div/section/div[2]/div[2]/div/div[2]/div[2]/div[1]/div/div/div[2]/div/div[2]/div[1]/div[2]/div/div[2]/div/span/span"))
							.getText();
					QaRobot.ClickOnElement("SelectInter");
					QaRobot.scrollPage(400);
					Thread.sleep(3000);
					QaRobot.ClickOnElement("AddToCartJ1");
					if (getT.equalsIgnoreCase("Out policy")) {
						QaRobot.alertAccept();
					}
					QaRobot.switchToWindow();
					QaRobot.ClickOnElement("NotificationCloseJ");
				}
			}
			QaRobot.scrollPage(-400);
			Thread.sleep(3000);
			QaRobot.ClickOnElement("YourItineraryFJ");
			Thread.sleep(5000);
			QaExtentReport.extentScreenshot("Your Itinerary");
			QaRobot.switchToWindow();
			if (DashboardType.equalsIgnoreCase("Old")) {
//				if (ProductType.equalsIgnoreCase("Flight")) {
//					QaRobot.ClickOnElement("ProceedToCheckoutC");
//				}else if (ProductType.equalsIgnoreCase("Flight+Hotel")) {
//					addHotel(Server, ProductType, CityCode, CityTitle, CheckInDate, CheckOutDate);
//					QaRobot.switchToWindow();
//					QaRobot.ClickOnElement("ProceedToCheckoutC");
//				} else if (ProductType.equalsIgnoreCase("Flight+Car")) {
//					addCar(Server, ProductType, PickUpCode, PickUpCity, CheckInDate, CheckOutDate, DriversAge);
//					QaRobot.switchToWindow();
//					if (SelectItineraryAs.equalsIgnoreCase("SendForApproval")) {
//						String getT1 = QaBrowser.driver.findElement(By.xpath(
//								"//div[@id='tdContent']/div[1]/div[3]/div/div/div[3]/div[1]/div/div/div[1]/ul/li[1]/div/span"))
//								.getText();
//						System.out.println(getT1);
//						String getTxt1[] = getT1.split(" ");
//						String Enquiryid = getTxt1[2];
//						System.out.println(Enquiryid);
//						QaExtentReport.test.log(Status.INFO, "<b><i>Enquiry id is </i></b>" + Enquiryid);
//						QaRobot.ClickOnElement("SendForApprovalF");
//						QaRobot.switchToWindow();
//						QaRobot.PassValue("TextAreaF", "Test");
//						QaRobot.ClickOnElement("SendF");
//						QaRobot.alertAccept();
//						Thread.sleep(3000);
//						QaRobot.alertAccept();
//						Thread.sleep(3000);
//						QaRobot.mouseHover("//a[@id='HeaderTop_aBookingMenu']", "//span[@id='HeaderTop_lblEnquiryQueue']");
//						Thread.sleep(5000);
//						QaRobot.ClickOnElement("Additionalsearch");
//						QaRobot.PassValue("EnterEnquiryId", Enquiryid);
//						QaRobot.ClickOnElement("Search");
//						QaRobot.ClickOnElement("Book");
//						QaRobot.ClickOnElement("ProceedToCheckoutC");
//					} else if (SelectItineraryAs.equalsIgnoreCase("ProceedToCheckout")) {
//						QaRobot.ClickOnElement("ProceedToCheckoutC");
//					}
//				} else if (ProductType.equalsIgnoreCase("Flight+Hotel+Car")) {
//					addHotel(Server, ProductType, CityCode, CityTitle, CheckInDate, CheckOutDate);
////						QaRobot.switchToWindow();
//					addCar(Server, ProductType, PickUpCode, PickUpCity, CheckInDate, CheckOutDate, DriversAge);
//					QaRobot.switchToWindow();
//					if (SelectItineraryAs.equalsIgnoreCase("SendForApproval")) {
//						String getT1 = QaBrowser.driver.findElement(By.xpath(
//								"//div[@id='tdContent']/div[1]/div[3]/div/div/div[3]/div[1]/div/div/div[1]/ul/li[1]/div/span"))
//								.getText();
//						System.out.println(getT1);
//						String getTxt1[] = getT1.split(" ");
//						String Enquiryid = getTxt1[2];
//						System.out.println(Enquiryid);
//						QaExtentReport.test.log(Status.INFO, "<b><i>Enquiry id is </i></b>" + Enquiryid);
//						QaRobot.ClickOnElement("SendForApprovalF");
//						QaRobot.switchToWindow();
//						QaRobot.PassValue("TextAreaF", "Test");
//						QaRobot.ClickOnElement("SendF");
//						QaRobot.alertAccept();
//						Thread.sleep(3000);
//						QaRobot.alertAccept();
//						Thread.sleep(3000);
//						QaRobot.mouseHover("//a[@id='HeaderTop_aBookingMenu']", "//span[@id='HeaderTop_lblEnquiryQueue']");
//						Thread.sleep(5000);
//						QaRobot.ClickOnElement("Additionalsearch");
//						QaRobot.PassValue("EnterEnquiryId", Enquiryid);
//						QaRobot.ClickOnElement("Search");
//						QaRobot.ClickOnElement("Book");
//						QaRobot.ClickOnElement("ProceedToCheckoutC");
//					} else if (SelectItineraryAs.equalsIgnoreCase("ProceedToCheckout")) {
//						QaRobot.ClickOnElement("ProceedToCheckoutC");
//					}
//				} else if (ProductType.equalsIgnoreCase("Flight+Car+Hotel")) {
//					addCar(Server, ProductType, PickUpCode, PickUpCity, CheckInDate, CheckOutDate, DriversAge);
////						QaRobot.switchToWindow();
//					addHotel(Server, ProductType, CityCode, CityTitle, CheckInDate, CheckOutDate);
//					QaRobot.switchToWindow();
//					if (SelectItineraryAs.equalsIgnoreCase("SendForApproval")) {
//						String getT1 = QaBrowser.driver.findElement(By.xpath(
//								"//div[@id='tdContent']/div[1]/div[3]/div/div/div[3]/div[1]/div/div/div[1]/ul/li[1]/div/span"))
//								.getText();
//						System.out.println(getT1);
//						String getTxt1[] = getT1.split(" ");
//						String Enquiryid = getTxt1[2];
//						System.out.println(Enquiryid);
//						QaExtentReport.test.log(Status.INFO, "<b><i>Enquiry id is </i></b>" + Enquiryid);
//						QaRobot.ClickOnElement("SendForApprovalF");
//						QaRobot.switchToWindow();
//						QaRobot.PassValue("TextAreaF", "Test");
//						QaRobot.ClickOnElement("SendF");
//						QaRobot.alertAccept();
//						Thread.sleep(3000);
//						QaRobot.alertAccept();
//						Thread.sleep(3000);
//						QaRobot.mouseHover("//a[@id='HeaderTop_aBookingMenu']", "//span[@id='HeaderTop_lblEnquiryQueue']");
//						Thread.sleep(5000);
//						QaRobot.ClickOnElement("Additionalsearch");
//						QaRobot.PassValue("EnterEnquiryId", Enquiryid);
//						QaRobot.ClickOnElement("Search");
//						QaRobot.ClickOnElement("Book");
//						QaRobot.ClickOnElement("ProceedToCheckoutC");
//					} else if (SelectItineraryAs.equalsIgnoreCase("ProceedToCheckout")) {
//						QaRobot.ClickOnElement("ProceedToCheckoutC");
//					}
//			}
			} else if (DashboardType.equalsIgnoreCase("New")) {
				if (ProductType.equalsIgnoreCase("Flight")) {
					if (Source.equalsIgnoreCase("Live")) {
						QaRobot.ClickOnElement("ProceedToCheckoutC");
					} else {
						QaRobot.ClickOnElement("ProceedToCheckoutC");
					}
				} else if (ProductType.equalsIgnoreCase("Flight+Hotel")) {
					addHotel(ProductType, CityCode, CityTitle, CheckInDate, CheckOutDate);
					QaRobot.switchToWindow();
					QaRobot.ClickOnElement("SendForApprovalC");
				}
			}
			checkoutpage(ccode, FareBranding, searchType, Trip, adult, child, infant, Stops, ProductType, fop,
					receiptno, card, cardtype, cvv, CheckOutRuleStatus, RCqty, RulesAppliedOnCheckOutPage,
					checkoutPageStep, SeatSelection, AdultSeatSelection, ChildSeatSelection, airReasonCode, CreatedBy);
		}

//		if (TravellerType.equalsIgnoreCase("Individual")) {
//			SBT_JOLO_CheckoutPage.checkoutForFlight(CreatorName, Server, TravellerType, ProductType, QuoteTitle,
//					QuoteRemark, Checkoutpagestep, FOP, CardType, CreditCardNumber, CardHolderName, CardExpiryDate);
//		} else if (TravellerType.equalsIgnoreCase("Dependent")) {
//					SBT_JOLO_CheckoutPage.checkoutForCar(CreatorName, TravellerType, ProductType, QuoteTitle, QuoteRemark,
//							Checkoutpagestep, FOP, CardType, CreditCardNumber, CardHolderName, CardExpiryDate);
//		}
//		}
//		}
//		}
	}

	@AfterTest
	public static void After_Test() {
		QaExtentReport.test.getExtent().flush();
//		QaBrowser.driver.close();
	}

	public static void checkoutpage(String ccode, String FareBranding, String searchType, String Trip, String adult,
			String child, String infant, String Stops, String ProductType, String fop, String receiptno, String card,
			String cardtype, String cvv, String CheckOutRuleStatus, String RCqty, String RulesAppliedOnCheckOutPage,
			String checkoutPageStep, String SeatSelection, String AdultSeatSelection, String ChildSeatSelection,
			String airReasonCode, String CreatedBy) throws Exception {
		if (QaBrowser.driver.findElement(By.xpath("//a[@id='ctl00_contentMain_expATag']")).isDisplayed()) {
			Assert.assertTrue(false, "Geeting change selection");
			QaExtentReport.test.log(Status.FAIL, "Geeting change selection");
		} else {
			String checkoutprice = QaBrowser.driver
					.findElement(By.xpath("//span[@id='ctl00_contentMain_totcashPrice']")).getText();
			System.out.println(checkoutprice);
			QaExtentReport.test.log(Status.INFO, "<b><i>Price of checkout page </i></b>" + checkoutprice);
			Thread.sleep(5000);
			QaExtentReport.extentScreenshot("Checkout Page");

//			if (CheckOutRuleStatus.equalsIgnoreCase("Applied")) {
//				SoftAssert softAssert = new SoftAssert();
//				int pAS1 = Integer.parseInt(RCqty);
//				if (pAS1 == 1) {
//					for (int k = 1; k <= pAS1; k++) {
//						String[] tN1 = RulesAppliedOnCheckOutPage.split(",");
//						String b1 = tN1[k - 1];
//						if (QaBrowser.driver.getPageSource().contains(b1)) {
//							Thread.sleep(3000);
//							QaBrowser.driver.findElement(By.xpath("(//*[contains(text(),'" + b1 + "')])[1]"))
//									.isDisplayed();
//							Thread.sleep(3000);
//							QaExtentReport.extentScreenshot(b1 + "-" + "Rule is Working on Checkout Page");
//						} else {
//							softAssert.assertTrue(false, b1 + "-" + "Rule is not Working on Checkout Page");
////							Assert.assertTrue(false, b1 + " " + "Rule is not Working");
//						}
//					}
//				} else {
//					for (int k = 1; k <= pAS1; k++) {
//						String[] tN1 = RulesAppliedOnCheckOutPage.split(",");
//						String b1 = tN1[k - 1];
//						if (QaBrowser.driver.getPageSource().contains(b1)) {
//							Thread.sleep(3000);
//							QaBrowser.driver.findElement(By.xpath("(//*[contains(text(),'" + b1 + "')])[1]"))
//									.isDisplayed();
//							Thread.sleep(3000);
//							QaExtentReport.extentScreenshot(b1 + "-" + "Rule is Working on Checkout Page");
//							QaRobot.ClickOnElement("NextPicture");
//						} else {
//							softAssert.assertTrue(false, b1 + "-" + "Rule is not Working on Checkout Page");
////							Assert.assertTrue(false, b1 + " " + "Rule is not Working");
//						}
//					}
//				}
//				softAssert.assertAll();
//			}
			if (searchType.equalsIgnoreCase("Dependent")) {
				SBTCheckoutPayment.CheckoutForFlightDependent(adult, child, infant);
			}
			if (checkoutPageStep.equalsIgnoreCase("Hold and quote")) {
				QaRobot.ClickOnElement("ow_chkterms");
//				QaExtentReport.test.log(Status.INFO, "<b><i>check the terms and condition</i></b>");
				SBTCheckoutPayment.holdAndQuote();
			} else if (checkoutPageStep.equalsIgnoreCase("Quote")) {
				SBTCheckoutPayment.checkoutFlightQuote(airReasonCode);
			} else if (checkoutPageStep.equalsIgnoreCase("Fullfillment")) {
				if (FareBranding.equalsIgnoreCase("Off")) {
					if (ccode.equalsIgnoreCase("sbt")) {
						WebElement element = QaBrowser.driver
								.findElement(By.xpath("//select[@id='ctl00_contentMain_CorporateFDReasonDDL']"));
						Select sel = new Select(element);
						sel.selectByIndex(1);
						Thread.sleep(3000);
						QaRobot.ClickOnElement("ow_billtobranch");
					}
					if (ccode.equalsIgnoreCase("preprod117")) {
						WebElement element = QaBrowser.driver
								.findElement(By.xpath("//select[@id='ctl00_contentMain_CorporateFDReasonDDL']"));
						Select sel = new Select(element);
						sel.selectByIndex(1);
						Thread.sleep(3000);
						QaRobot.ClickOnElement("ow_billtobranch");
					}
				}
				if (FareBranding.equalsIgnoreCase("On")) {
					SoftAssert softAssert = new SoftAssert();
					if (ccode.equalsIgnoreCase("sbt")) {
						WebElement element = QaBrowser.driver
								.findElement(By.xpath("//select[@id='ctl00_contentMain_CorporateFDReasonDDL']"));
						Select sel = new Select(element);
						sel.selectByIndex(1);
						Thread.sleep(3000);
						QaRobot.ClickOnElement("ow_billtobranch");
					}
					if (ccode.equalsIgnoreCase("preprod117")) {
						if (ProductType.equalsIgnoreCase("Flight")) {
							if (Trip.equalsIgnoreCase("OneWay")) {
								if (Stops.equalsIgnoreCase("0")) {
									QaRobot.scrollPage(500);
									Thread.sleep(2000);
									try {
										QaRobot.ClickOnElement("Clickonbaggage1");
										Thread.sleep(3000);
										QaExtentReport.extentScreenshot("Baggage 1");
										Thread.sleep(3000);
										WebElement Baggage = QaBrowser.driver.findElement(
												By.xpath("//select[@id='ctl00_contentMain_ddl_baggageAdt']"));
										Select sel = new Select(Baggage);
										sel.selectByIndex(1);
									} catch (Exception e) {
										softAssert.assertTrue(false, "Baggage is not showing");
									}
									Thread.sleep(3000);
									try {
										QaRobot.ClickOnElement("ClickonMeals1");
										Thread.sleep(7000);
										QaExtentReport.extentScreenshot("Meals 1");
										Thread.sleep(4000);
										WebElement Meals1 = QaBrowser.driver.findElement(By.xpath(
												"(//select[contains(@id,'ctl00_contentMain_ddlMealPrefOB_ADT')])[1]"));
										Select sel1 = new Select(Meals1);
										sel1.selectByIndex(1);
									} catch (Exception e) {
										softAssert.assertTrue(false, "Meal is not showing");
									}
									Thread.sleep(3000);
								} else if (Stops.equalsIgnoreCase("1")) {
									QaRobot.scrollPage(500);
									Thread.sleep(2000);
									try {
										QaRobot.ClickOnElement("Clickonbaggage1");
										Thread.sleep(3000);
										QaExtentReport.extentScreenshot("Baggage 1");
										Thread.sleep(3000);
										WebElement Baggage = QaBrowser.driver.findElement(
												By.xpath("//select[@id='ctl00_contentMain_ddl_baggageAdt']"));
										Select sel = new Select(Baggage);
										sel.selectByIndex(1);
									} catch (Exception e) {
										softAssert.assertTrue(false, "Baggage is not showing");
									}
									Thread.sleep(3000);
									try {
										QaRobot.ClickOnElement("ClickonMeals1");
										Thread.sleep(7000);
										QaExtentReport.extentScreenshot("Meals 1");
										Thread.sleep(4000);
										WebElement Meals1 = QaBrowser.driver.findElement(By.xpath(
												"(//select[contains(@id,'ctl00_contentMain_ddlMealPrefOB_ADT')])[1]"));
										Select sel1 = new Select(Meals1);
										sel1.selectByIndex(1);
									} catch (Exception e) {
										softAssert.assertTrue(false, "Meal 1 is not showing");
									}
									Thread.sleep(3000);
									try {
										QaRobot.ClickOnElement("ClickonMeals2");
										Thread.sleep(7000);
										QaExtentReport.extentScreenshot("Meals 2");
										Thread.sleep(4000);
										WebElement Meals2 = QaBrowser.driver.findElement(By.xpath(
												"(//select[contains(@id,'ctl00_contentMain_ddlMealPrefOB_ADT')])[2]"));
										Select sel2 = new Select(Meals2);
										sel2.selectByIndex(1);
									} catch (Exception e) {
										softAssert.assertTrue(false, "Meal 2 is not showing");
									}
									Thread.sleep(3000);
								}
							} else if (Trip.equalsIgnoreCase("RoundTrip")) {
								if (Stops.equalsIgnoreCase("0")) {
									QaRobot.scrollPage(500);
									Thread.sleep(2000);
									try {
										QaRobot.ClickOnElement("Clickonbaggage1");
										Thread.sleep(3000);
										QaExtentReport.extentScreenshot("Baggage 1");
										Thread.sleep(3000);
										WebElement Baggage1 = QaBrowser.driver.findElement(By.xpath(
												"(//select[contains(@id,'ctl00_contentMain_ddl_baggageAdt')])[1]"));
										Select sel1 = new Select(Baggage1);
										sel1.selectByIndex(1);
									} catch (Exception e) {
										softAssert.assertTrue(false, "Baggage 1 is not showing");
									}
									Thread.sleep(3000);
									try {
										QaRobot.ClickOnElement("Clickonbaggage2");
										Thread.sleep(3000);
										QaExtentReport.extentScreenshot("Baggage 2");
										Thread.sleep(3000);
										WebElement Baggage2 = QaBrowser.driver.findElement(By.xpath(
												"(//select[contains(@id,'ctl00_contentMain_ddl_baggageAdt')])[2]"));
										Select sel2 = new Select(Baggage2);
										sel2.selectByIndex(1);
									} catch (Exception e) {
										softAssert.assertTrue(false, "Baggage 2 is not showing");
									}
									Thread.sleep(3000);
									try {
										QaRobot.ClickOnElement("ClickonMeals1");
										Thread.sleep(7000);
										QaExtentReport.extentScreenshot("Meals 1");
										Thread.sleep(4000);
										WebElement Meals1 = QaBrowser.driver.findElement(By
												.xpath("(//select[contains(@id,'ctl00_contentMain_ddlMealPref')])[1]"));
										Select sel3 = new Select(Meals1);
										sel3.selectByIndex(1);
									} catch (Exception e) {
										softAssert.assertTrue(false, "Outbound Meal is not showing");
									}
									Thread.sleep(3000);
									try {
										QaRobot.ClickOnElement("ClickonMeals2");
										Thread.sleep(7000);
										QaExtentReport.extentScreenshot("Meals 2");
										Thread.sleep(4000);
										WebElement Meals2 = QaBrowser.driver.findElement(By
												.xpath("(//select[contains(@id,'ctl00_contentMain_ddlMealPref')])[2]"));
										Select sel4 = new Select(Meals2);
										sel4.selectByIndex(1);
									} catch (Exception e) {
										softAssert.assertTrue(false, "Inbound Meal is not showing");
									}
									Thread.sleep(3000);
								} else if (Stops.equalsIgnoreCase("1")) {
									QaRobot.scrollPage(500);
									Thread.sleep(2000);
									try {
										QaRobot.ClickOnElement("Clickonbaggage1");
										Thread.sleep(3000);
										QaExtentReport.extentScreenshot("Baggage 1");
										Thread.sleep(3000);
										WebElement Baggage1 = QaBrowser.driver.findElement(By.xpath(
												"(//select[contains(@id,'ctl00_contentMain_ddl_baggageAdt')])[1]"));
										Select sel1 = new Select(Baggage1);
										sel1.selectByIndex(1);
									} catch (Exception e) {
										softAssert.assertTrue(false, "Baggage 1 is not showing");
									}
									Thread.sleep(3000);
									try {
										QaRobot.ClickOnElement("Clickonbaggage2");
										Thread.sleep(3000);
										QaExtentReport.extentScreenshot("Baggage 2");
										Thread.sleep(3000);
										WebElement Baggage2 = QaBrowser.driver.findElement(By.xpath(
												"(//select[contains(@id,'ctl00_contentMain_ddl_baggageAdt')])[2]"));
										Select sel2 = new Select(Baggage2);
										sel2.selectByIndex(1);
									} catch (Exception e) {
										softAssert.assertTrue(false, "Baggage 2 is not showing");
									}
									Thread.sleep(3000);
									try {
										QaRobot.ClickOnElement("ClickonMeals1");
										Thread.sleep(7000);
										QaExtentReport.extentScreenshot("Meals 1");
										Thread.sleep(4000);
										WebElement Meals1 = QaBrowser.driver.findElement(By
												.xpath("(//select[contains(@id,'ctl00_contentMain_ddlMealPref')])[1]"));
										Select sel3 = new Select(Meals1);
										sel3.selectByIndex(1);
									} catch (Exception e) {
										softAssert.assertTrue(false, "Outbound Meal 1 is not showing");
									}
									Thread.sleep(3000);
									try {
										QaRobot.ClickOnElement("ClickonMeals2");
										Thread.sleep(7000);
										QaExtentReport.extentScreenshot("Meals 2");
										Thread.sleep(4000);
										WebElement Meals2 = QaBrowser.driver.findElement(By
												.xpath("(//select[contains(@id,'ctl00_contentMain_ddlMealPref')])[2]"));
										Select sel4 = new Select(Meals2);
										sel4.selectByIndex(1);
									} catch (Exception e) {
										softAssert.assertTrue(false, "Outbound Meal 2 is not showing");
									}
									Thread.sleep(3000);
									try {
										QaRobot.ClickOnElement("ClickonMeals3");
										Thread.sleep(7000);
										QaExtentReport.extentScreenshot("Meals 3");
										Thread.sleep(4000);
										WebElement Meals3 = QaBrowser.driver.findElement(By
												.xpath("(//select[contains(@id,'ctl00_contentMain_ddlMealPref')])[3]"));
										Select sel5 = new Select(Meals3);
										sel5.selectByIndex(1);
									} catch (Exception e) {
										softAssert.assertTrue(false, "Inbound Meal 1 is not showing");
									}
									Thread.sleep(3000);
									try {
										QaRobot.ClickOnElement("ClickonMeals4");
										Thread.sleep(7000);
										QaExtentReport.extentScreenshot("Meals 4");
										Thread.sleep(4000);
										WebElement Meals4 = QaBrowser.driver.findElement(By
												.xpath("(//select[contains(@id,'ctl00_contentMain_ddlMealPref')])[4]"));
										Select sel6 = new Select(Meals4);
										sel6.selectByIndex(1);
									} catch (Exception e) {
										softAssert.assertTrue(false, "Inbound Meal 2 is not showing");
									}
									Thread.sleep(3000);
								}
							}
							String checkoutprice1 = QaBrowser.driver
									.findElement(By.xpath("//span[@id='ctl00_contentMain_totcashPrice']")).getText();
							System.out.println(checkoutprice1);
							QaExtentReport.test.log(Status.INFO,
									"<b><i>Price after adding Meal and Baggage </i></b>" + checkoutprice1);
							Thread.sleep(5000);
//							WebElement element = QaBrowser.driver
//									.findElement(By.xpath("//select[@id='ctl00_contentMain_CorporateFDReasonDDL']"));
//							Select sel = new Select(element);
//							sel.selectByIndex(1);
//							Thread.sleep(3000);
//							WebElement element1 = QaBrowser.driver.findElement(
//									By.xpath("//select[contains(@id,'ctl00_contentMain_dynamicdatacapture')][1]"));
//							Select sel1 = new Select(element1);
//							sel1.selectByIndex(1);
//							Thread.sleep(3000);
							QaExtentReport.extentScreenshot("Baggage and Meals");
							softAssert.assertAll();
						} else if (ProductType.equalsIgnoreCase("Flight+Hotel")) {
//							WebElement element = QaBrowser.driver
//									.findElement(By.xpath("//select[@id='ctl00_contentMain_CorporateFDReasonDDL']"));
//							Select sel = new Select(element);
//							sel.selectByIndex(1);
//							Thread.sleep(3000);
//							WebElement element1 = QaBrowser.driver.findElement(
//									By.xpath("//select[contains(@id,'ctl00_contentMain_dynamicdatacapture')][1]"));
//							Select sel1 = new Select(element1);
//							sel1.selectByIndex(1);
//							Thread.sleep(3000);
//							WebElement element2 = QaBrowser.driver.findElement(
//									By.xpath("//select[@id='ctl00_contentMain_CorporateFDReasonDDLHHLM']"));
//							Select sel2 = new Select(element2);
//							sel2.selectByIndex(1);
//							Thread.sleep(3000);
						}
//						QaRobot.ClickOnElement("ow_billtobranch");
					}
				}
				Thread.sleep(3000);
				QaRobot.scrollPage(1000);
				QaRobot.ClickOnElement("ow_chkterms");
//				QaExtentReport.test.log(Status.INFO, "<b><i>check the terms and condition</i></b>");
				if (ccode.equalsIgnoreCase("sbt")) {
					QaRobot.ClickOnElement("ow_chkbook");
				} else if (ccode.equalsIgnoreCase("preprod117")) {
					QaRobot.ClickOnElement("ow_chkbook");
				}
////				QaExtentReport.test.log(Status.INFO,
////						"<b><i>book button to proceed the booking from checkout page</i></b>");
				if (SeatSelection.equalsIgnoreCase("Yes")) {
					String ParentWindow1 = QaBrowser.driver.getWindowHandle();
					Set<String> handles1 = QaBrowser.driver.getWindowHandles();
					for (String childWindow1 : handles1) {
						if (!childWindow1.equals(ParentWindow1))
							QaBrowser.driver.switchTo().window(childWindow1);
					}
					QaRobot.ClickOnElement("SeatSelect");
					Thread.sleep(5000);
					QaBrowser.driver.switchTo().window(ParentWindow1);
					String SelectSeat[] = AdultSeatSelection.split(",");
					String Seat1 = SelectSeat[0];
					String Seat2 = SelectSeat[1];
					String Seat3 = SelectSeat[2];
					String Seat4 = SelectSeat[3];
					String CSelectSeat[] = ChildSeatSelection.split(",");
					String CSeat1 = CSelectSeat[0];
					String CSeat2 = CSelectSeat[1];
//					String CSeat3 = CSelectSeat[2];
					if (searchType.equalsIgnoreCase("Individual")) {
						if (Trip.equalsIgnoreCase("OneWay")) {
							if (Stops.equalsIgnoreCase("0")) {
								List<WebElement> listOfRights1 = QaBrowser.driver
										.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
								for (WebElement autoRights1 : listOfRights1) {
									if (autoRights1.getText().equalsIgnoreCase(Seat1)) {
										autoRights1.click();
										QaExtentReport.extentScreenshot("Seat Selection Page");
										Thread.sleep(5000);
										QaRobot.ClickOnElement("OW_ContinueBooking");
										break;
									}
								}
							} else if (Stops.equalsIgnoreCase("1")) {
								List<WebElement> listOfRights1 = QaBrowser.driver
										.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
								for (WebElement autoRights1 : listOfRights1) {
									if (autoRights1.getText().equalsIgnoreCase(Seat1)) {
										autoRights1.click();
										QaExtentReport.extentScreenshot("Seat Selection Page");
										Thread.sleep(5000);
										QaRobot.ClickOnElement("OW_ContinueBooking");
										break;
									}
								}
								Thread.sleep(3000);
								List<WebElement> listOfRights2 = QaBrowser.driver
										.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
								for (WebElement autoRights2 : listOfRights2) {
									if (autoRights2.getText().equalsIgnoreCase(Seat2)) {
										autoRights2.click();
										QaExtentReport.extentScreenshot("Seat Selection Page");
										Thread.sleep(5000);
										QaRobot.ClickOnElement("OW_ContinueBooking");
										break;
									}
								}
							} else if (Stops.equalsIgnoreCase("2")) {
								List<WebElement> listOfRights1 = QaBrowser.driver
										.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
								for (WebElement autoRights1 : listOfRights1) {
									if (autoRights1.getText().equalsIgnoreCase(Seat1)) {
										autoRights1.click();
										QaExtentReport.extentScreenshot("Seat Selection Page");
										Thread.sleep(5000);
										QaRobot.ClickOnElement("OW_ContinueBooking");
										break;
									}
								}
								Thread.sleep(3000);
								List<WebElement> listOfRights2 = QaBrowser.driver
										.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
								for (WebElement autoRights2 : listOfRights2) {
									if (autoRights2.getText().equalsIgnoreCase(Seat2)) {
										autoRights2.click();
										QaExtentReport.extentScreenshot("Seat Selection Page");
										Thread.sleep(5000);
										QaRobot.ClickOnElement("OW_ContinueBooking");
										break;
									}
								}
								Thread.sleep(3000);
								List<WebElement> listOfRights3 = QaBrowser.driver
										.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
								for (WebElement autoRights3 : listOfRights3) {
									if (autoRights3.getText().equalsIgnoreCase(Seat3)) {
										autoRights3.click();
										QaExtentReport.extentScreenshot("Seat Selection Page");
										Thread.sleep(5000);
										QaRobot.ClickOnElement("OW_ContinueBooking");
										break;
									}
								}
							}
						} else if (Trip.equalsIgnoreCase("RoundTrip")) {
							if (Stops.equalsIgnoreCase("0")) {
								List<WebElement> listOfRights1 = QaBrowser.driver
										.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
								for (WebElement autoRights1 : listOfRights1) {
									if (autoRights1.getText().equalsIgnoreCase(Seat1)) {
										autoRights1.click();
										QaExtentReport.extentScreenshot("Seat Selection Page");
										Thread.sleep(5000);
										QaRobot.ClickOnElement("OW_ContinueBooking");
										break;
									}
								}
								Thread.sleep(3000);
								List<WebElement> listOfRights2 = QaBrowser.driver
										.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
								for (WebElement autoRights2 : listOfRights2) {
									if (autoRights2.getText().equalsIgnoreCase(Seat2)) {
										autoRights2.click();
										QaExtentReport.extentScreenshot("Seat Selection Page");
										Thread.sleep(5000);
										QaRobot.ClickOnElement("OW_ContinueBooking");
										break;
									}
								}
							} else if (Stops.equalsIgnoreCase("1")) {
								List<WebElement> listOfRights1 = QaBrowser.driver
										.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
								for (WebElement autoRights1 : listOfRights1) {
									if (autoRights1.getText().equalsIgnoreCase(Seat1)) {
										autoRights1.click();
										QaExtentReport.extentScreenshot("Seat Selection Page");
										Thread.sleep(5000);
										QaRobot.ClickOnElement("OW_ContinueBooking");
										break;
									}
								}
								Thread.sleep(3000);
								List<WebElement> listOfRights2 = QaBrowser.driver
										.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
								for (WebElement autoRights2 : listOfRights2) {
									if (autoRights2.getText().equalsIgnoreCase(Seat2)) {
										autoRights2.click();
										QaExtentReport.extentScreenshot("Seat Selection Page");
										Thread.sleep(5000);
										QaRobot.ClickOnElement("OW_ContinueBooking");
										break;
									}
								}
								Thread.sleep(3000);
								List<WebElement> listOfRights3 = QaBrowser.driver
										.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
								for (WebElement autoRights3 : listOfRights3) {
									if (autoRights3.getText().equalsIgnoreCase(Seat3)) {
										autoRights3.click();
										QaExtentReport.extentScreenshot("Seat Selection Page");
										Thread.sleep(5000);
										QaRobot.ClickOnElement("OW_ContinueBooking");
										break;
									}
								}
								Thread.sleep(3000);
								List<WebElement> listOfRights4 = QaBrowser.driver
										.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
								for (WebElement autoRights4 : listOfRights4) {
									if (autoRights4.getText().equalsIgnoreCase(Seat4)) {
										autoRights4.click();
										QaExtentReport.extentScreenshot("Seat Selection Page");
										Thread.sleep(5000);
										QaRobot.ClickOnElement("OW_ContinueBooking");
										break;
									}
								}
							}
						}
					} else {
						if (Trip.equalsIgnoreCase("OneWay")) {
							if (Stops.equalsIgnoreCase("0")) {
								if (adult.equalsIgnoreCase("1")) {
									List<WebElement> listOfRights1 = QaBrowser.driver
											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
									for (WebElement autoRights1 : listOfRights1) {
										if (autoRights1.getText().equalsIgnoreCase(Seat1)) {
											autoRights1.click();
											QaExtentReport.extentScreenshot("Seat Selection Page");
											Thread.sleep(5000);
											break;
										}
									}
								} else if (adult.equalsIgnoreCase("2")) {
									List<WebElement> listOfRights1 = QaBrowser.driver
											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
									for (WebElement autoRights1 : listOfRights1) {
										if (autoRights1.getText().equalsIgnoreCase(Seat1)) {
											autoRights1.click();
											QaExtentReport.extentScreenshot("Seat Selection Page");
											Thread.sleep(5000);
											break;
										}
									}
									Thread.sleep(3000);
									QaRobot.ClickOnElement("Seat2");
									Thread.sleep(3000);
									List<WebElement> listOfRights2 = QaBrowser.driver
											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
									for (WebElement autoRights2 : listOfRights2) {
										if (autoRights2.getText().equalsIgnoreCase(Seat2)) {
											autoRights2.click();
											QaExtentReport.extentScreenshot("Seat Selection Page");
											Thread.sleep(5000);
											break;
										}
									}
								} else if (adult.equalsIgnoreCase("3")) {
									List<WebElement> listOfRights1 = QaBrowser.driver
											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
									for (WebElement autoRights1 : listOfRights1) {
										if (autoRights1.getText().equalsIgnoreCase(Seat1)) {
											autoRights1.click();
											QaExtentReport.extentScreenshot("Seat Selection Page");
											Thread.sleep(5000);
											break;
										}
									}
									Thread.sleep(3000);
									QaRobot.ClickOnElement("Seat2");
									Thread.sleep(3000);
									List<WebElement> listOfRights2 = QaBrowser.driver
											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
									for (WebElement autoRights2 : listOfRights2) {
										if (autoRights2.getText().equalsIgnoreCase(Seat2)) {
											autoRights2.click();
											QaExtentReport.extentScreenshot("Seat Selection Page");
											Thread.sleep(5000);
											break;
										}
									}
									Thread.sleep(3000);
									QaRobot.ClickOnElement("Seat3");
									Thread.sleep(3000);
									List<WebElement> listOfRights3 = QaBrowser.driver
											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
									for (WebElement autoRights3 : listOfRights3) {
										if (autoRights3.getText().equalsIgnoreCase(Seat3)) {
											autoRights3.click();
											QaExtentReport.extentScreenshot("Seat Selection Page");
											Thread.sleep(5000);
											break;
										}
									}
								}
								if (child.equalsIgnoreCase("1")) {
									if (adult.equalsIgnoreCase("1")) {
										Thread.sleep(3000);
										QaRobot.ClickOnElement("Seat2");
										Thread.sleep(3000);
									} else if (adult.equalsIgnoreCase("2")) {
										Thread.sleep(3000);
										QaRobot.ClickOnElement("Seat3");
										Thread.sleep(3000);
									}
									List<WebElement> listOfRights1 = QaBrowser.driver
											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
									for (WebElement autoRights1 : listOfRights1) {
										if (autoRights1.getText().equalsIgnoreCase(CSeat1)) {
											autoRights1.click();
											QaExtentReport.extentScreenshot("Seat Selection Page");
											Thread.sleep(5000);
											break;
										}
									}
								} else if (child.equalsIgnoreCase("2")) {
									if (adult.equalsIgnoreCase("1")) {
										Thread.sleep(3000);
										QaRobot.ClickOnElement("Seat2");
										Thread.sleep(3000);
										List<WebElement> listOfRights1 = QaBrowser.driver
												.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
										for (WebElement autoRights1 : listOfRights1) {
											if (autoRights1.getText().equalsIgnoreCase(CSeat1)) {
												autoRights1.click();
												QaExtentReport.extentScreenshot("Seat Selection Page");
												Thread.sleep(5000);
												break;
											}
										}
										Thread.sleep(3000);
										QaRobot.ClickOnElement("Seat3");
										List<WebElement> listOfRights2 = QaBrowser.driver
												.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
										for (WebElement autoRights2 : listOfRights2) {
											if (autoRights2.getText().equalsIgnoreCase(CSeat2)) {
												autoRights2.click();
												QaExtentReport.extentScreenshot("Seat Selection Page");
												Thread.sleep(5000);
												break;
											}
										}
									} else if (adult.equalsIgnoreCase("2")) {
										Thread.sleep(3000);
										QaRobot.ClickOnElement("Seat3");
										Thread.sleep(3000);
										List<WebElement> listOfRights1 = QaBrowser.driver
												.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
										for (WebElement autoRights1 : listOfRights1) {
											if (autoRights1.getText().equalsIgnoreCase(CSeat1)) {
												autoRights1.click();
												QaExtentReport.extentScreenshot("Seat Selection Page");
												Thread.sleep(5000);
												break;
											}
										}
										Thread.sleep(3000);
										QaRobot.ClickOnElement("Seat4");
										List<WebElement> listOfRights2 = QaBrowser.driver
												.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
										for (WebElement autoRights2 : listOfRights2) {
											if (autoRights2.getText().equalsIgnoreCase(CSeat2)) {
												autoRights2.click();
												QaExtentReport.extentScreenshot("Seat Selection Page");
												Thread.sleep(5000);
												break;
											}
										}
									}
								}
								QaRobot.ClickOnElement("OW_ContinueBooking");
							} else if (Stops.equalsIgnoreCase("1")) {
								if (adult.equalsIgnoreCase("1")) {
									List<WebElement> listOfRights1 = QaBrowser.driver
											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
									for (WebElement autoRights1 : listOfRights1) {
										if (autoRights1.getText().equalsIgnoreCase(Seat1)) {
											autoRights1.click();
											QaExtentReport.extentScreenshot("Seat Selection Page");
											Thread.sleep(5000);
											break;
										}
									}
								} else if (adult.equalsIgnoreCase("2")) {
									List<WebElement> listOfRights1 = QaBrowser.driver
											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
									for (WebElement autoRights1 : listOfRights1) {
										if (autoRights1.getText().equalsIgnoreCase(Seat1)) {
											autoRights1.click();
											QaExtentReport.extentScreenshot("Seat Selection Page");
											Thread.sleep(5000);
											break;
										}
									}
									Thread.sleep(3000);
									QaRobot.ClickOnElement("Seat2");
									Thread.sleep(3000);
									List<WebElement> listOfRights2 = QaBrowser.driver
											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
									for (WebElement autoRights2 : listOfRights2) {
										if (autoRights2.getText().equalsIgnoreCase(Seat2)) {
											autoRights2.click();
											QaExtentReport.extentScreenshot("Seat Selection Page");
											Thread.sleep(5000);
											break;
										}
									}
								} else if (adult.equalsIgnoreCase("3")) {
									List<WebElement> listOfRights1 = QaBrowser.driver
											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
									for (WebElement autoRights1 : listOfRights1) {
										if (autoRights1.getText().equalsIgnoreCase(Seat1)) {
											autoRights1.click();
											QaExtentReport.extentScreenshot("Seat Selection Page");
											Thread.sleep(5000);
											break;
										}
									}
									Thread.sleep(3000);
									QaRobot.ClickOnElement("Seat2");
									Thread.sleep(3000);
									List<WebElement> listOfRights2 = QaBrowser.driver
											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
									for (WebElement autoRights2 : listOfRights2) {
										if (autoRights2.getText().equalsIgnoreCase(Seat2)) {
											autoRights2.click();
											QaExtentReport.extentScreenshot("Seat Selection Page");
											Thread.sleep(5000);
											break;
										}
									}
									Thread.sleep(3000);
									QaRobot.ClickOnElement("Seat3");
									Thread.sleep(3000);
									List<WebElement> listOfRights3 = QaBrowser.driver
											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
									for (WebElement autoRights3 : listOfRights3) {
										if (autoRights3.getText().equalsIgnoreCase(Seat3)) {
											autoRights3.click();
											QaExtentReport.extentScreenshot("Seat Selection Page");
											Thread.sleep(5000);
											break;
										}
									}
								}
								if (child.equalsIgnoreCase("1")) {
									if (adult.equalsIgnoreCase("1")) {
										Thread.sleep(3000);
										QaRobot.ClickOnElement("Seat2");
										Thread.sleep(3000);
									} else if (adult.equalsIgnoreCase("2")) {
										Thread.sleep(3000);
										QaRobot.ClickOnElement("Seat3");
										Thread.sleep(3000);
									}
									List<WebElement> listOfRights1 = QaBrowser.driver
											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
									for (WebElement autoRights1 : listOfRights1) {
										if (autoRights1.getText().equalsIgnoreCase(CSeat1)) {
											autoRights1.click();
											QaExtentReport.extentScreenshot("Seat Selection Page");
											Thread.sleep(5000);
											break;
										}
									}
								} else if (child.equalsIgnoreCase("2")) {
									if (adult.equalsIgnoreCase("1")) {
										Thread.sleep(3000);
										QaRobot.ClickOnElement("Seat2");
										Thread.sleep(3000);
										List<WebElement> listOfRights1 = QaBrowser.driver
												.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
										for (WebElement autoRights1 : listOfRights1) {
											if (autoRights1.getText().equalsIgnoreCase(CSeat1)) {
												autoRights1.click();
												QaExtentReport.extentScreenshot("Seat Selection Page");
												Thread.sleep(5000);
												break;
											}
										}
										Thread.sleep(3000);
										QaRobot.ClickOnElement("Seat3");
										List<WebElement> listOfRights2 = QaBrowser.driver
												.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
										for (WebElement autoRights2 : listOfRights2) {
											if (autoRights2.getText().equalsIgnoreCase(CSeat2)) {
												autoRights2.click();
												QaExtentReport.extentScreenshot("Seat Selection Page");
												Thread.sleep(5000);
												break;
											}
										}
									} else if (adult.equalsIgnoreCase("2")) {
										Thread.sleep(3000);
										QaRobot.ClickOnElement("Seat3");
										Thread.sleep(3000);
										List<WebElement> listOfRights1 = QaBrowser.driver
												.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
										for (WebElement autoRights1 : listOfRights1) {
											if (autoRights1.getText().equalsIgnoreCase(CSeat1)) {
												autoRights1.click();
												QaExtentReport.extentScreenshot("Seat Selection Page");
												Thread.sleep(5000);
												break;
											}
										}
										Thread.sleep(3000);
										QaRobot.ClickOnElement("Seat4");
										List<WebElement> listOfRights2 = QaBrowser.driver
												.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
										for (WebElement autoRights2 : listOfRights2) {
											if (autoRights2.getText().equalsIgnoreCase(CSeat2)) {
												autoRights2.click();
												QaExtentReport.extentScreenshot("Seat Selection Page");
												Thread.sleep(5000);
												break;
											}
										}
									}
								}
								QaRobot.ClickOnElement("OW_ContinueBooking");
								Thread.sleep(5000);
								if (adult.equalsIgnoreCase("1")) {
									List<WebElement> listOfRights1 = QaBrowser.driver
											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
									for (WebElement autoRights1 : listOfRights1) {
										if (autoRights1.getText().equalsIgnoreCase(Seat1)) {
											autoRights1.click();
											QaExtentReport.extentScreenshot("Seat Selection Page");
											Thread.sleep(5000);
											break;
										}
									}
								} else if (adult.equalsIgnoreCase("2")) {
									List<WebElement> listOfRights1 = QaBrowser.driver
											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
									for (WebElement autoRights1 : listOfRights1) {
										if (autoRights1.getText().equalsIgnoreCase(Seat1)) {
											autoRights1.click();
											QaExtentReport.extentScreenshot("Seat Selection Page");
											Thread.sleep(5000);
											break;
										}
									}
									Thread.sleep(3000);
									QaRobot.ClickOnElement("Seat5");
									Thread.sleep(3000);
									List<WebElement> listOfRights2 = QaBrowser.driver
											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
									for (WebElement autoRights2 : listOfRights2) {
										if (autoRights2.getText().equalsIgnoreCase(Seat2)) {
											autoRights2.click();
											QaExtentReport.extentScreenshot("Seat Selection Page");
											Thread.sleep(5000);
											break;
										}
									}
								} else if (adult.equalsIgnoreCase("3")) {
									List<WebElement> listOfRights1 = QaBrowser.driver
											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
									for (WebElement autoRights1 : listOfRights1) {
										if (autoRights1.getText().equalsIgnoreCase(Seat1)) {
											autoRights1.click();
											QaExtentReport.extentScreenshot("Seat Selection Page");
											Thread.sleep(5000);
											break;
										}
									}
									Thread.sleep(3000);
									QaRobot.ClickOnElement("Seat5");
									Thread.sleep(3000);
									List<WebElement> listOfRights2 = QaBrowser.driver
											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
									for (WebElement autoRights2 : listOfRights2) {
										if (autoRights2.getText().equalsIgnoreCase(Seat2)) {
											autoRights2.click();
											QaExtentReport.extentScreenshot("Seat Selection Page");
											Thread.sleep(5000);
											break;
										}
									}
									Thread.sleep(3000);
									QaRobot.ClickOnElement("Seat6");
									Thread.sleep(3000);
									List<WebElement> listOfRights3 = QaBrowser.driver
											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
									for (WebElement autoRights3 : listOfRights3) {
										if (autoRights3.getText().equalsIgnoreCase(Seat3)) {
											autoRights3.click();
											QaExtentReport.extentScreenshot("Seat Selection Page");
											Thread.sleep(5000);
											break;
										}
									}
								}
								if (child.equalsIgnoreCase("1")) {
									if (adult.equalsIgnoreCase("1")) {
										Thread.sleep(3000);
										QaRobot.ClickOnElement("Seat5");
										Thread.sleep(3000);
									} else if (adult.equalsIgnoreCase("2")) {
										Thread.sleep(3000);
										QaRobot.ClickOnElement("Seat6");
										Thread.sleep(3000);
									}
									List<WebElement> listOfRights1 = QaBrowser.driver
											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
									for (WebElement autoRights1 : listOfRights1) {
										if (autoRights1.getText().equalsIgnoreCase(CSeat1)) {
											autoRights1.click();
											QaExtentReport.extentScreenshot("Seat Selection Page");
											Thread.sleep(5000);
											break;
										}
									}
								} else if (child.equalsIgnoreCase("2")) {
									if (adult.equalsIgnoreCase("1")) {
										Thread.sleep(3000);
										QaRobot.ClickOnElement("Seat2");
										Thread.sleep(3000);
										List<WebElement> listOfRights1 = QaBrowser.driver
												.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
										for (WebElement autoRights1 : listOfRights1) {
											if (autoRights1.getText().equalsIgnoreCase(CSeat1)) {
												autoRights1.click();
												QaExtentReport.extentScreenshot("Seat Selection Page");
												Thread.sleep(5000);
												break;
											}
										}
										Thread.sleep(3000);
										QaRobot.ClickOnElement("Seat3");
										List<WebElement> listOfRights2 = QaBrowser.driver
												.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
										for (WebElement autoRights2 : listOfRights2) {
											if (autoRights2.getText().equalsIgnoreCase(CSeat2)) {
												autoRights2.click();
												QaExtentReport.extentScreenshot("Seat Selection Page");
												Thread.sleep(5000);
												break;
											}
										}
									} else if (adult.equalsIgnoreCase("2")) {
										Thread.sleep(3000);
										QaRobot.ClickOnElement("Seat3");
										Thread.sleep(3000);
										List<WebElement> listOfRights1 = QaBrowser.driver
												.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
										for (WebElement autoRights1 : listOfRights1) {
											if (autoRights1.getText().equalsIgnoreCase(CSeat1)) {
												autoRights1.click();
												QaExtentReport.extentScreenshot("Seat Selection Page");
												Thread.sleep(5000);
												break;
											}
										}
										Thread.sleep(3000);
										QaRobot.ClickOnElement("Seat4");
										List<WebElement> listOfRights2 = QaBrowser.driver
												.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
										for (WebElement autoRights2 : listOfRights2) {
											if (autoRights2.getText().equalsIgnoreCase(CSeat2)) {
												autoRights2.click();
												QaExtentReport.extentScreenshot("Seat Selection Page");
												Thread.sleep(5000);
												break;
											}
										}
									}
								}
								QaRobot.ClickOnElement("OW_ContinueBooking");
							} else if (Stops.equalsIgnoreCase("2")) {
								List<WebElement> listOfRights1 = QaBrowser.driver
										.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
								for (WebElement autoRights1 : listOfRights1) {
									if (autoRights1.getText().equalsIgnoreCase(Seat1)) {
										autoRights1.click();
										QaExtentReport.extentScreenshot("Seat Selection Page");
										Thread.sleep(5000);
										QaRobot.ClickOnElement("OW_ContinueBooking");
										break;
									}
								}
								Thread.sleep(3000);
								List<WebElement> listOfRights2 = QaBrowser.driver
										.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
								for (WebElement autoRights2 : listOfRights2) {
									if (autoRights2.getText().equalsIgnoreCase(Seat2)) {
										autoRights2.click();
										QaExtentReport.extentScreenshot("Seat Selection Page");
										Thread.sleep(5000);
										QaRobot.ClickOnElement("OW_ContinueBooking");
										break;
									}
								}
								Thread.sleep(3000);
								List<WebElement> listOfRights3 = QaBrowser.driver
										.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
								for (WebElement autoRights3 : listOfRights3) {
									if (autoRights3.getText().equalsIgnoreCase(Seat3)) {
										autoRights3.click();
										QaExtentReport.extentScreenshot("Seat Selection Page");
										Thread.sleep(5000);
										QaRobot.ClickOnElement("OW_ContinueBooking");
										break;
									}
								}
							}
						} else if (Trip.equalsIgnoreCase("RoundTrip")) {
							if (Stops.equalsIgnoreCase("0")) {
								if (adult.equalsIgnoreCase("1")) {
									List<WebElement> listOfRights1 = QaBrowser.driver
											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
									for (WebElement autoRights1 : listOfRights1) {
										if (autoRights1.getText().equalsIgnoreCase(Seat1)) {
											autoRights1.click();
											QaExtentReport.extentScreenshot("Seat Selection Page");
											Thread.sleep(5000);
											break;
										}
									}
								} else if (adult.equalsIgnoreCase("2")) {
									List<WebElement> listOfRights1 = QaBrowser.driver
											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
									for (WebElement autoRights1 : listOfRights1) {
										if (autoRights1.getText().equalsIgnoreCase(Seat1)) {
											autoRights1.click();
											QaExtentReport.extentScreenshot("Seat Selection Page");
											Thread.sleep(5000);
											break;
										}
									}
									Thread.sleep(3000);
									QaRobot.ClickOnElement("Seat2");
									Thread.sleep(3000);
									List<WebElement> listOfRights2 = QaBrowser.driver
											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
									for (WebElement autoRights2 : listOfRights2) {
										if (autoRights2.getText().equalsIgnoreCase(Seat2)) {
											autoRights2.click();
											QaExtentReport.extentScreenshot("Seat Selection Page");
											Thread.sleep(5000);
											break;
										}
									}
								} else if (adult.equalsIgnoreCase("3")) {
									List<WebElement> listOfRights1 = QaBrowser.driver
											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
									for (WebElement autoRights1 : listOfRights1) {
										if (autoRights1.getText().equalsIgnoreCase(Seat1)) {
											autoRights1.click();
											QaExtentReport.extentScreenshot("Seat Selection Page");
											Thread.sleep(5000);
											break;
										}
									}
									Thread.sleep(3000);
									QaRobot.ClickOnElement("Seat2");
									Thread.sleep(3000);
									List<WebElement> listOfRights2 = QaBrowser.driver
											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
									for (WebElement autoRights2 : listOfRights2) {
										if (autoRights2.getText().equalsIgnoreCase(Seat2)) {
											autoRights2.click();
											QaExtentReport.extentScreenshot("Seat Selection Page");
											Thread.sleep(5000);
											break;
										}
									}
									Thread.sleep(3000);
									QaRobot.ClickOnElement("Seat3");
									Thread.sleep(3000);
									List<WebElement> listOfRights3 = QaBrowser.driver
											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
									for (WebElement autoRights3 : listOfRights3) {
										if (autoRights3.getText().equalsIgnoreCase(Seat3)) {
											autoRights3.click();
											QaExtentReport.extentScreenshot("Seat Selection Page");
											Thread.sleep(5000);
											break;
										}
									}
								}
								if (child.equalsIgnoreCase("1")) {
									if (adult.equalsIgnoreCase("1")) {
										Thread.sleep(3000);
										QaRobot.ClickOnElement("Seat2");
										Thread.sleep(3000);
									} else if (adult.equalsIgnoreCase("2")) {
										Thread.sleep(3000);
										QaRobot.ClickOnElement("Seat3");
										Thread.sleep(3000);
									}
									List<WebElement> listOfRights1 = QaBrowser.driver
											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
									for (WebElement autoRights1 : listOfRights1) {
										if (autoRights1.getText().equalsIgnoreCase(CSeat1)) {
											autoRights1.click();
											QaExtentReport.extentScreenshot("Seat Selection Page");
											Thread.sleep(5000);
											break;
										}
									}
								} else if (child.equalsIgnoreCase("2")) {
									if (adult.equalsIgnoreCase("1")) {
										Thread.sleep(3000);
										QaRobot.ClickOnElement("Seat2");
										Thread.sleep(3000);
										List<WebElement> listOfRights1 = QaBrowser.driver
												.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
										for (WebElement autoRights1 : listOfRights1) {
											if (autoRights1.getText().equalsIgnoreCase(CSeat1)) {
												autoRights1.click();
												QaExtentReport.extentScreenshot("Seat Selection Page");
												Thread.sleep(5000);
												break;
											}
										}
										Thread.sleep(3000);
										QaRobot.ClickOnElement("Seat3");
										List<WebElement> listOfRights2 = QaBrowser.driver
												.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
										for (WebElement autoRights2 : listOfRights2) {
											if (autoRights2.getText().equalsIgnoreCase(CSeat2)) {
												autoRights2.click();
												QaExtentReport.extentScreenshot("Seat Selection Page");
												Thread.sleep(5000);
												break;
											}
										}
									} else if (adult.equalsIgnoreCase("2")) {
										Thread.sleep(3000);
										QaRobot.ClickOnElement("Seat3");
										Thread.sleep(3000);
										List<WebElement> listOfRights1 = QaBrowser.driver
												.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
										for (WebElement autoRights1 : listOfRights1) {
											if (autoRights1.getText().equalsIgnoreCase(CSeat1)) {
												autoRights1.click();
												QaExtentReport.extentScreenshot("Seat Selection Page");
												Thread.sleep(5000);
												break;
											}
										}
										Thread.sleep(3000);
										QaRobot.ClickOnElement("Seat4");
										List<WebElement> listOfRights2 = QaBrowser.driver
												.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
										for (WebElement autoRights2 : listOfRights2) {
											if (autoRights2.getText().equalsIgnoreCase(CSeat2)) {
												autoRights2.click();
												QaExtentReport.extentScreenshot("Seat Selection Page");
												Thread.sleep(5000);
												break;
											}
										}
									}
								}
								QaRobot.ClickOnElement("OW_ContinueBooking");
								Thread.sleep(3000);
								if (adult.equalsIgnoreCase("1")) {
									List<WebElement> listOfRights1 = QaBrowser.driver
											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
									for (WebElement autoRights1 : listOfRights1) {
										if (autoRights1.getText().equalsIgnoreCase(Seat1)) {
											autoRights1.click();
											QaExtentReport.extentScreenshot("Seat Selection Page");
											Thread.sleep(5000);
											break;
										}
									}
								} else if (adult.equalsIgnoreCase("2")) {
									List<WebElement> listOfRights1 = QaBrowser.driver
											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
									for (WebElement autoRights1 : listOfRights1) {
										if (autoRights1.getText().equalsIgnoreCase(Seat1)) {
											autoRights1.click();
											QaExtentReport.extentScreenshot("Seat Selection Page");
											Thread.sleep(5000);
											break;
										}
									}
									Thread.sleep(3000);
									QaRobot.ClickOnElement("Seat5");
									Thread.sleep(3000);
									List<WebElement> listOfRights2 = QaBrowser.driver
											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
									for (WebElement autoRights2 : listOfRights2) {
										if (autoRights2.getText().equalsIgnoreCase(Seat2)) {
											autoRights2.click();
											QaExtentReport.extentScreenshot("Seat Selection Page");
											Thread.sleep(5000);
											break;
										}
									}
								} else if (adult.equalsIgnoreCase("3")) {
									List<WebElement> listOfRights1 = QaBrowser.driver
											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
									for (WebElement autoRights1 : listOfRights1) {
										if (autoRights1.getText().equalsIgnoreCase(Seat1)) {
											autoRights1.click();
											QaExtentReport.extentScreenshot("Seat Selection Page");
											Thread.sleep(5000);
											break;
										}
									}
									Thread.sleep(3000);
									QaRobot.ClickOnElement("Seat5");
									Thread.sleep(3000);
									List<WebElement> listOfRights2 = QaBrowser.driver
											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
									for (WebElement autoRights2 : listOfRights2) {
										if (autoRights2.getText().equalsIgnoreCase(Seat2)) {
											autoRights2.click();
											QaExtentReport.extentScreenshot("Seat Selection Page");
											Thread.sleep(5000);
											break;
										}
									}
									Thread.sleep(3000);
									QaRobot.ClickOnElement("Seat6");
									Thread.sleep(3000);
									List<WebElement> listOfRights3 = QaBrowser.driver
											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
									for (WebElement autoRights3 : listOfRights3) {
										if (autoRights3.getText().equalsIgnoreCase(Seat3)) {
											autoRights3.click();
											QaExtentReport.extentScreenshot("Seat Selection Page");
											Thread.sleep(5000);
											break;
										}
									}
								}
								if (child.equalsIgnoreCase("1")) {
									if (adult.equalsIgnoreCase("1")) {
										Thread.sleep(3000);
										QaRobot.ClickOnElement("Seat4");
										Thread.sleep(3000);
									} else if (adult.equalsIgnoreCase("2")) {
										Thread.sleep(3000);
										QaRobot.ClickOnElement("Seat6");
										Thread.sleep(3000);
									}
									List<WebElement> listOfRights1 = QaBrowser.driver
											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
									for (WebElement autoRights1 : listOfRights1) {
										if (autoRights1.getText().equalsIgnoreCase(CSeat1)) {
											autoRights1.click();
											QaExtentReport.extentScreenshot("Seat Selection Page");
											Thread.sleep(5000);
											break;
										}
									}
								} else if (child.equalsIgnoreCase("2")) {
									if (adult.equalsIgnoreCase("1")) {
										Thread.sleep(3000);
										QaRobot.ClickOnElement("Seat4");
										Thread.sleep(3000);
										List<WebElement> listOfRights1 = QaBrowser.driver
												.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
										for (WebElement autoRights1 : listOfRights1) {
											if (autoRights1.getText().equalsIgnoreCase(CSeat1)) {
												autoRights1.click();
												QaExtentReport.extentScreenshot("Seat Selection Page");
												Thread.sleep(5000);
												break;
											}
										}
										Thread.sleep(3000);
										QaRobot.ClickOnElement("Seat5");
										List<WebElement> listOfRights2 = QaBrowser.driver
												.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
										for (WebElement autoRights2 : listOfRights2) {
											if (autoRights2.getText().equalsIgnoreCase(CSeat2)) {
												autoRights2.click();
												QaExtentReport.extentScreenshot("Seat Selection Page");
												Thread.sleep(5000);
												break;
											}
										}
									} else if (adult.equalsIgnoreCase("2")) {
										Thread.sleep(3000);
										QaRobot.ClickOnElement("Seat5");
										Thread.sleep(3000);
										List<WebElement> listOfRights1 = QaBrowser.driver
												.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
										for (WebElement autoRights1 : listOfRights1) {
											if (autoRights1.getText().equalsIgnoreCase(CSeat1)) {
												autoRights1.click();
												QaExtentReport.extentScreenshot("Seat Selection Page");
												Thread.sleep(5000);
												break;
											}
										}
										Thread.sleep(3000);
										QaRobot.ClickOnElement("Seat6");
										List<WebElement> listOfRights2 = QaBrowser.driver
												.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
										for (WebElement autoRights2 : listOfRights2) {
											if (autoRights2.getText().equalsIgnoreCase(CSeat2)) {
												autoRights2.click();
												QaExtentReport.extentScreenshot("Seat Selection Page");
												Thread.sleep(5000);
												break;
											}
										}
									}
								}
								QaRobot.ClickOnElement("OW_ContinueBooking");
							} else if (Stops.equalsIgnoreCase("1")) {
								if (adult.equalsIgnoreCase("1")) {
									List<WebElement> listOfRights1 = QaBrowser.driver
											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
									for (WebElement autoRights1 : listOfRights1) {
										if (autoRights1.getText().equalsIgnoreCase(Seat1)) {
											autoRights1.click();
											QaExtentReport.extentScreenshot("Seat Selection Page");
											Thread.sleep(5000);
											break;
										}
									}
								} else if (adult.equalsIgnoreCase("2")) {
									List<WebElement> listOfRights1 = QaBrowser.driver
											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
									for (WebElement autoRights1 : listOfRights1) {
										if (autoRights1.getText().equalsIgnoreCase(Seat1)) {
											autoRights1.click();
											QaExtentReport.extentScreenshot("Seat Selection Page");
											Thread.sleep(5000);
											break;
										}
									}
									Thread.sleep(3000);
									QaRobot.ClickOnElement("Seat2");
									Thread.sleep(3000);
									List<WebElement> listOfRights2 = QaBrowser.driver
											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
									for (WebElement autoRights2 : listOfRights2) {
										if (autoRights2.getText().equalsIgnoreCase(Seat2)) {
											autoRights2.click();
											QaExtentReport.extentScreenshot("Seat Selection Page");
											Thread.sleep(5000);
											break;
										}
									}
								} else if (adult.equalsIgnoreCase("3")) {
									List<WebElement> listOfRights1 = QaBrowser.driver
											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
									for (WebElement autoRights1 : listOfRights1) {
										if (autoRights1.getText().equalsIgnoreCase(Seat1)) {
											autoRights1.click();
											QaExtentReport.extentScreenshot("Seat Selection Page");
											Thread.sleep(5000);
											break;
										}
									}
									Thread.sleep(3000);
									QaRobot.ClickOnElement("Seat2");
									Thread.sleep(3000);
									List<WebElement> listOfRights2 = QaBrowser.driver
											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
									for (WebElement autoRights2 : listOfRights2) {
										if (autoRights2.getText().equalsIgnoreCase(Seat2)) {
											autoRights2.click();
											QaExtentReport.extentScreenshot("Seat Selection Page");
											Thread.sleep(5000);
											break;
										}
									}
									Thread.sleep(3000);
									QaRobot.ClickOnElement("Seat3");
									Thread.sleep(3000);
									List<WebElement> listOfRights3 = QaBrowser.driver
											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
									for (WebElement autoRights3 : listOfRights3) {
										if (autoRights3.getText().equalsIgnoreCase(Seat3)) {
											autoRights3.click();
											QaExtentReport.extentScreenshot("Seat Selection Page");
											Thread.sleep(5000);
											break;
										}
									}
								}
								if (child.equalsIgnoreCase("1")) {
									if (adult.equalsIgnoreCase("1")) {
										Thread.sleep(3000);
										QaRobot.ClickOnElement("Seat2");
										Thread.sleep(3000);
									} else if (adult.equalsIgnoreCase("2")) {
										Thread.sleep(3000);
										QaRobot.ClickOnElement("Seat3");
										Thread.sleep(3000);
									}
									List<WebElement> listOfRights1 = QaBrowser.driver
											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
									for (WebElement autoRights1 : listOfRights1) {
										if (autoRights1.getText().equalsIgnoreCase(CSeat1)) {
											autoRights1.click();
											QaExtentReport.extentScreenshot("Seat Selection Page");
											Thread.sleep(5000);
											break;
										}
									}
								} else if (child.equalsIgnoreCase("2")) {
									if (adult.equalsIgnoreCase("1")) {
										Thread.sleep(3000);
										QaRobot.ClickOnElement("Seat2");
										Thread.sleep(3000);
										List<WebElement> listOfRights1 = QaBrowser.driver
												.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
										for (WebElement autoRights1 : listOfRights1) {
											if (autoRights1.getText().equalsIgnoreCase(CSeat1)) {
												autoRights1.click();
												QaExtentReport.extentScreenshot("Seat Selection Page");
												Thread.sleep(5000);
												break;
											}
										}
										Thread.sleep(3000);
										QaRobot.ClickOnElement("Seat3");
										List<WebElement> listOfRights2 = QaBrowser.driver
												.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
										for (WebElement autoRights2 : listOfRights2) {
											if (autoRights2.getText().equalsIgnoreCase(CSeat2)) {
												autoRights2.click();
												QaExtentReport.extentScreenshot("Seat Selection Page");
												Thread.sleep(5000);
												break;
											}
										}
									} else if (adult.equalsIgnoreCase("2")) {
										Thread.sleep(3000);
										QaRobot.ClickOnElement("Seat3");
										Thread.sleep(3000);
										List<WebElement> listOfRights1 = QaBrowser.driver
												.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
										for (WebElement autoRights1 : listOfRights1) {
											if (autoRights1.getText().equalsIgnoreCase(CSeat1)) {
												autoRights1.click();
												QaExtentReport.extentScreenshot("Seat Selection Page");
												Thread.sleep(5000);
												break;
											}
										}
										Thread.sleep(3000);
										QaRobot.ClickOnElement("Seat4");
										List<WebElement> listOfRights2 = QaBrowser.driver
												.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
										for (WebElement autoRights2 : listOfRights2) {
											if (autoRights2.getText().equalsIgnoreCase(CSeat2)) {
												autoRights2.click();
												QaExtentReport.extentScreenshot("Seat Selection Page");
												Thread.sleep(5000);
												break;
											}
										}
									}
								}
								QaRobot.ClickOnElement("OW_ContinueBooking");
								Thread.sleep(5000);
								QaRobot.ClickOnElement("Seat4");
								Thread.sleep(3000);
								if (adult.equalsIgnoreCase("1")) {
									List<WebElement> listOfRights1 = QaBrowser.driver
											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
									for (WebElement autoRights1 : listOfRights1) {
										if (autoRights1.getText().equalsIgnoreCase(Seat2)) {
											autoRights1.click();
											QaExtentReport.extentScreenshot("Seat Selection Page");
											Thread.sleep(5000);
											break;
										}
									}
								} else if (adult.equalsIgnoreCase("2")) {
									List<WebElement> listOfRights1 = QaBrowser.driver
											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
									for (WebElement autoRights1 : listOfRights1) {
										if (autoRights1.getText().equalsIgnoreCase(Seat3)) {
											autoRights1.click();
											QaExtentReport.extentScreenshot("Seat Selection Page");
											Thread.sleep(5000);
											break;
										}
									}
									Thread.sleep(3000);
									QaRobot.ClickOnElement("Seat5");
									Thread.sleep(3000);
									List<WebElement> listOfRights2 = QaBrowser.driver
											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
									for (WebElement autoRights2 : listOfRights2) {
										if (autoRights2.getText().equalsIgnoreCase(Seat4)) {
											autoRights2.click();
											QaExtentReport.extentScreenshot("Seat Selection Page");
											Thread.sleep(5000);
											break;
										}
									}
								} else if (adult.equalsIgnoreCase("3")) {
									List<WebElement> listOfRights1 = QaBrowser.driver
											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
									for (WebElement autoRights1 : listOfRights1) {
										if (autoRights1.getText().equalsIgnoreCase(Seat2)) {
											autoRights1.click();
											QaExtentReport.extentScreenshot("Seat Selection Page");
											Thread.sleep(5000);
											break;
										}
									}
									Thread.sleep(3000);
									QaRobot.ClickOnElement("Seat5");
									Thread.sleep(3000);
									List<WebElement> listOfRights2 = QaBrowser.driver
											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
									for (WebElement autoRights2 : listOfRights2) {
										if (autoRights2.getText().equalsIgnoreCase(Seat3)) {
											autoRights2.click();
											QaExtentReport.extentScreenshot("Seat Selection Page");
											Thread.sleep(5000);
											break;
										}
									}
									Thread.sleep(3000);
									QaRobot.ClickOnElement("Seat6");
									Thread.sleep(3000);
									List<WebElement> listOfRights3 = QaBrowser.driver
											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
									for (WebElement autoRights3 : listOfRights3) {
										if (autoRights3.getText().equalsIgnoreCase(Seat4)) {
											autoRights3.click();
											QaExtentReport.extentScreenshot("Seat Selection Page");
											Thread.sleep(5000);
											break;
										}
									}
								}
								if (child.equalsIgnoreCase("1")) {
									if (adult.equalsIgnoreCase("1")) {
										Thread.sleep(3000);
										QaRobot.ClickOnElement("Seat4");
										Thread.sleep(3000);
									} else if (adult.equalsIgnoreCase("2")) {
										Thread.sleep(3000);
										QaRobot.ClickOnElement("Seat6");
										Thread.sleep(3000);
									}
									List<WebElement> listOfRights1 = QaBrowser.driver
											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
									for (WebElement autoRights1 : listOfRights1) {
										if (autoRights1.getText().equalsIgnoreCase(CSeat2)) {
											autoRights1.click();
											QaExtentReport.extentScreenshot("Seat Selection Page");
											Thread.sleep(5000);
											break;
										}
									}
								} else if (child.equalsIgnoreCase("2")) {
									if (adult.equalsIgnoreCase("1")) {
										Thread.sleep(3000);
										QaRobot.ClickOnElement("Seat2");
										Thread.sleep(3000);
										List<WebElement> listOfRights1 = QaBrowser.driver
												.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
										for (WebElement autoRights1 : listOfRights1) {
											if (autoRights1.getText().equalsIgnoreCase(CSeat1)) {
												autoRights1.click();
												QaExtentReport.extentScreenshot("Seat Selection Page");
												Thread.sleep(5000);
												break;
											}
										}
										Thread.sleep(3000);
										QaRobot.ClickOnElement("Seat3");
										List<WebElement> listOfRights2 = QaBrowser.driver
												.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
										for (WebElement autoRights2 : listOfRights2) {
											if (autoRights2.getText().equalsIgnoreCase(CSeat2)) {
												autoRights2.click();
												QaExtentReport.extentScreenshot("Seat Selection Page");
												Thread.sleep(5000);
												break;
											}
										}
									} else if (adult.equalsIgnoreCase("2")) {
										Thread.sleep(3000);
										QaRobot.ClickOnElement("Seat3");
										Thread.sleep(3000);
										List<WebElement> listOfRights1 = QaBrowser.driver
												.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
										for (WebElement autoRights1 : listOfRights1) {
											if (autoRights1.getText().equalsIgnoreCase(CSeat1)) {
												autoRights1.click();
												QaExtentReport.extentScreenshot("Seat Selection Page");
												Thread.sleep(5000);
												break;
											}
										}
										Thread.sleep(3000);
										QaRobot.ClickOnElement("Seat4");
										List<WebElement> listOfRights2 = QaBrowser.driver
												.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
										for (WebElement autoRights2 : listOfRights2) {
											if (autoRights2.getText().equalsIgnoreCase(CSeat2)) {
												autoRights2.click();
												QaExtentReport.extentScreenshot("Seat Selection Page");
												Thread.sleep(5000);
												break;
											}
										}
									}
								}
								QaRobot.ClickOnElement("OW_ContinueBooking");
								Thread.sleep(5000);
								if (adult.equalsIgnoreCase("1")) {
									List<WebElement> listOfRights1 = QaBrowser.driver
											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
									for (WebElement autoRights1 : listOfRights1) {
										if (autoRights1.getText().equalsIgnoreCase(Seat1)) {
											autoRights1.click();
											QaExtentReport.extentScreenshot("Seat Selection Page");
											Thread.sleep(5000);
											break;
										}
									}
								} else if (adult.equalsIgnoreCase("2")) {
									List<WebElement> listOfRights1 = QaBrowser.driver
											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
									for (WebElement autoRights1 : listOfRights1) {
										if (autoRights1.getText().equalsIgnoreCase(Seat1)) {
											autoRights1.click();
											QaExtentReport.extentScreenshot("Seat Selection Page");
											Thread.sleep(5000);
											break;
										}
									}
									Thread.sleep(3000);
									QaRobot.ClickOnElement("Seat8");
									Thread.sleep(3000);
									List<WebElement> listOfRights2 = QaBrowser.driver
											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
									for (WebElement autoRights2 : listOfRights2) {
										if (autoRights2.getText().equalsIgnoreCase(Seat2)) {
											autoRights2.click();
											QaExtentReport.extentScreenshot("Seat Selection Page");
											Thread.sleep(5000);
											break;
										}
									}
								} else if (adult.equalsIgnoreCase("3")) {
									List<WebElement> listOfRights1 = QaBrowser.driver
											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
									for (WebElement autoRights1 : listOfRights1) {
										if (autoRights1.getText().equalsIgnoreCase(Seat1)) {
											autoRights1.click();
											QaExtentReport.extentScreenshot("Seat Selection Page");
											Thread.sleep(5000);
											break;
										}
									}
									Thread.sleep(3000);
									QaRobot.ClickOnElement("Seat8");
									Thread.sleep(3000);
									List<WebElement> listOfRights2 = QaBrowser.driver
											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
									for (WebElement autoRights2 : listOfRights2) {
										if (autoRights2.getText().equalsIgnoreCase(Seat2)) {
											autoRights2.click();
											QaExtentReport.extentScreenshot("Seat Selection Page");
											Thread.sleep(5000);
											break;
										}
									}
									Thread.sleep(3000);
									QaRobot.ClickOnElement("Seat9");
									Thread.sleep(3000);
									List<WebElement> listOfRights3 = QaBrowser.driver
											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
									for (WebElement autoRights3 : listOfRights3) {
										if (autoRights3.getText().equalsIgnoreCase(Seat3)) {
											autoRights3.click();
											QaExtentReport.extentScreenshot("Seat Selection Page");
											Thread.sleep(5000);
											break;
										}
									}
								}
								if (child.equalsIgnoreCase("1")) {
									if (adult.equalsIgnoreCase("1")) {
										Thread.sleep(3000);
										QaRobot.ClickOnElement("Seat2");
										Thread.sleep(3000);
									} else if (adult.equalsIgnoreCase("2")) {
										Thread.sleep(3000);
										QaRobot.ClickOnElement("Seat9");
										Thread.sleep(3000);
									}
									List<WebElement> listOfRights1 = QaBrowser.driver
											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
									for (WebElement autoRights1 : listOfRights1) {
										if (autoRights1.getText().equalsIgnoreCase(CSeat1)) {
											autoRights1.click();
											QaExtentReport.extentScreenshot("Seat Selection Page");
											Thread.sleep(5000);
											break;
										}
									}
								} else if (child.equalsIgnoreCase("2")) {
									if (adult.equalsIgnoreCase("1")) {
										Thread.sleep(3000);
										QaRobot.ClickOnElement("Seat2");
										Thread.sleep(3000);
										List<WebElement> listOfRights1 = QaBrowser.driver
												.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
										for (WebElement autoRights1 : listOfRights1) {
											if (autoRights1.getText().equalsIgnoreCase(CSeat1)) {
												autoRights1.click();
												QaExtentReport.extentScreenshot("Seat Selection Page");
												Thread.sleep(5000);
												break;
											}
										}
										Thread.sleep(3000);
										QaRobot.ClickOnElement("Seat10");
										List<WebElement> listOfRights2 = QaBrowser.driver
												.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
										for (WebElement autoRights2 : listOfRights2) {
											if (autoRights2.getText().equalsIgnoreCase(CSeat2)) {
												autoRights2.click();
												QaExtentReport.extentScreenshot("Seat Selection Page");
												Thread.sleep(5000);
												break;
											}
										}
									} else if (adult.equalsIgnoreCase("2")) {
										Thread.sleep(3000);
										QaRobot.ClickOnElement("Seat3");
										Thread.sleep(3000);
										List<WebElement> listOfRights1 = QaBrowser.driver
												.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
										for (WebElement autoRights1 : listOfRights1) {
											if (autoRights1.getText().equalsIgnoreCase(CSeat1)) {
												autoRights1.click();
												QaExtentReport.extentScreenshot("Seat Selection Page");
												Thread.sleep(5000);
												break;
											}
										}
										Thread.sleep(3000);
										QaRobot.ClickOnElement("Seat10");
										List<WebElement> listOfRights2 = QaBrowser.driver
												.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
										for (WebElement autoRights2 : listOfRights2) {
											if (autoRights2.getText().equalsIgnoreCase(CSeat2)) {
												autoRights2.click();
												QaExtentReport.extentScreenshot("Seat Selection Page");
												Thread.sleep(5000);
												break;
											}
										}
									}
								}
								QaRobot.ClickOnElement("OW_ContinueBooking");
								Thread.sleep(5000);
								if (adult.equalsIgnoreCase("1")) {
									List<WebElement> listOfRights1 = QaBrowser.driver
											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
									for (WebElement autoRights1 : listOfRights1) {
										if (autoRights1.getText().equalsIgnoreCase(Seat2)) {
											autoRights1.click();
											QaExtentReport.extentScreenshot("Seat Selection Page");
											Thread.sleep(5000);
											break;
										}
									}
								} else if (adult.equalsIgnoreCase("2")) {
									List<WebElement> listOfRights1 = QaBrowser.driver
											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
									for (WebElement autoRights1 : listOfRights1) {
										if (autoRights1.getText().equalsIgnoreCase(Seat3)) {
											autoRights1.click();
											QaExtentReport.extentScreenshot("Seat Selection Page");
											Thread.sleep(5000);
											break;
										}
									}
									Thread.sleep(3000);
									QaRobot.ClickOnElement("Seat11");
									Thread.sleep(3000);
									List<WebElement> listOfRights2 = QaBrowser.driver
											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
									for (WebElement autoRights2 : listOfRights2) {
										if (autoRights2.getText().equalsIgnoreCase(Seat4)) {
											autoRights2.click();
											QaExtentReport.extentScreenshot("Seat Selection Page");
											Thread.sleep(5000);
											break;
										}
									}
								} else if (adult.equalsIgnoreCase("3")) {
									List<WebElement> listOfRights1 = QaBrowser.driver
											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
									for (WebElement autoRights1 : listOfRights1) {
										if (autoRights1.getText().equalsIgnoreCase(Seat2)) {
											autoRights1.click();
											QaExtentReport.extentScreenshot("Seat Selection Page");
											Thread.sleep(5000);
											break;
										}
									}
									Thread.sleep(3000);
									QaRobot.ClickOnElement("Seat11");
									Thread.sleep(3000);
									List<WebElement> listOfRights2 = QaBrowser.driver
											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
									for (WebElement autoRights2 : listOfRights2) {
										if (autoRights2.getText().equalsIgnoreCase(Seat3)) {
											autoRights2.click();
											QaExtentReport.extentScreenshot("Seat Selection Page");
											Thread.sleep(5000);
											break;
										}
									}
									Thread.sleep(3000);
									QaRobot.ClickOnElement("Seat12");
									Thread.sleep(3000);
									List<WebElement> listOfRights3 = QaBrowser.driver
											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
									for (WebElement autoRights3 : listOfRights3) {
										if (autoRights3.getText().equalsIgnoreCase(Seat4)) {
											autoRights3.click();
											QaExtentReport.extentScreenshot("Seat Selection Page");
											Thread.sleep(5000);
											break;
										}
									}
								}
								if (child.equalsIgnoreCase("1")) {
									if (adult.equalsIgnoreCase("1")) {
										Thread.sleep(3000);
										QaRobot.ClickOnElement("Seat10");
										Thread.sleep(3000);
									} else if (adult.equalsIgnoreCase("2")) {
										Thread.sleep(3000);
										QaRobot.ClickOnElement("Seat12");
										Thread.sleep(3000);
									}
									List<WebElement> listOfRights1 = QaBrowser.driver
											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
									for (WebElement autoRights1 : listOfRights1) {
										if (autoRights1.getText().equalsIgnoreCase(CSeat2)) {
											autoRights1.click();
											QaExtentReport.extentScreenshot("Seat Selection Page");
											Thread.sleep(5000);
											break;
										}
									}
								} else if (child.equalsIgnoreCase("2")) {
									if (adult.equalsIgnoreCase("1")) {
										Thread.sleep(3000);
										QaRobot.ClickOnElement("Seat11");
										Thread.sleep(3000);
										List<WebElement> listOfRights1 = QaBrowser.driver
												.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
										for (WebElement autoRights1 : listOfRights1) {
											if (autoRights1.getText().equalsIgnoreCase(CSeat1)) {
												autoRights1.click();
												QaExtentReport.extentScreenshot("Seat Selection Page");
												Thread.sleep(5000);
												break;
											}
										}
										Thread.sleep(3000);
										QaRobot.ClickOnElement("Seat12");
										List<WebElement> listOfRights2 = QaBrowser.driver
												.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
										for (WebElement autoRights2 : listOfRights2) {
											if (autoRights2.getText().equalsIgnoreCase(CSeat2)) {
												autoRights2.click();
												QaExtentReport.extentScreenshot("Seat Selection Page");
												Thread.sleep(5000);
												break;
											}
										}
									} else if (adult.equalsIgnoreCase("2")) {
										Thread.sleep(3000);
										QaRobot.ClickOnElement("Seat11");
										Thread.sleep(3000);
										List<WebElement> listOfRights1 = QaBrowser.driver
												.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
										for (WebElement autoRights1 : listOfRights1) {
											if (autoRights1.getText().equalsIgnoreCase(CSeat1)) {
												autoRights1.click();
												QaExtentReport.extentScreenshot("Seat Selection Page");
												Thread.sleep(5000);
												break;
											}
										}
										Thread.sleep(3000);
										QaRobot.ClickOnElement("Seat12");
										List<WebElement> listOfRights2 = QaBrowser.driver
												.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
										for (WebElement autoRights2 : listOfRights2) {
											if (autoRights2.getText().equalsIgnoreCase(CSeat2)) {
												autoRights2.click();
												QaExtentReport.extentScreenshot("Seat Selection Page");
												Thread.sleep(5000);
												break;
											}
										}
									}
								}
							}
							QaRobot.ClickOnElement("OW_ContinueBooking");
						}
					}
				} else if (SeatSelection.equalsIgnoreCase("No")) {
					if (ccode.equalsIgnoreCase("sbt")) {
						String ParentWindow1 = QaBrowser.driver.getWindowHandle();
						Set<String> handles1 = QaBrowser.driver.getWindowHandles();
						for (String childWindow1 : handles1) {
							if (!childWindow1.equals(ParentWindow1))
								QaBrowser.driver.switchTo().window(childWindow1);
						}
						QaRobot.ClickOnElement("SeatNotSelect");
					} else if (ccode.equalsIgnoreCase("preprod117")) {
						String ParentWindow1 = QaBrowser.driver.getWindowHandle();
						Set<String> handles1 = QaBrowser.driver.getWindowHandles();
						for (String childWindow1 : handles1) {
							if (!childWindow1.equals(ParentWindow1))
								QaBrowser.driver.switchTo().window(childWindow1);
						}
						QaRobot.ClickOnElement("SeatNotSelect");
//						QaBrowser.driver.switchTo().alert().accept();
					}
				}
				Thread.sleep(10000);
//				String paymentprice = QaBrowser.driver.findElement(By.xpath("//span[@id='ctl00_contentMain_lblTAmt']"))
//						.getText();
//				System.out.println("Price of payment page " + paymentprice);
//				QaExtentReport.test.log(Status.INFO, "<b><i>Price of payment page </i></b>" + paymentprice);
				// select FOP
//				if (fop.equalsIgnoreCase("Cash")) {
//					SBTCheckoutPayment.fopCash(fop, receiptno);
//				} else if (fop.equalsIgnoreCase("Bill To Company")) {
//					SBTCheckoutPayment.fopBillToComapnay(fop);
//					QaRobot.ClickOnElement("click_OK");
//				} else {
//					SBTCheckoutPayment.fopCreditDebit(ProductType, card, cardtype, cvv);
//				}
//
//				QaExtentReport.extentScreenshot("Payment Page");
//				QaRobot.ClickOnElement("ow_paymentprocced");
////				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on procced button</i></b>");
//				Thread.sleep(2000);
//				String bookingStatus = QaBrowser.driver.findElement(By.xpath("//span[@class='nc_status_color']"))
//						.getText();
//				System.out.println("Booking Status is " + bookingStatus);
//				QaExtentReport.test.log(Status.INFO, "<b><i>Booking Status is </i></b>" + bookingStatus);
//				// Confirmation code
//				String pnr = QaBrowser.driver.findElement(By.xpath("//p[@class='nc_status_p']")).getText();
//				System.out.println("PNR is " + pnr);
//				QaExtentReport.test.log(Status.INFO, "<b><i>PNR is </i></b>" + pnr);
//				// Confirm page price
////				String confirmePrice = QaBrowser.driver.findElement(By.xpath("(//div[@class='nc_fcelllast'])[4]"))
////						.getText();
////				System.out.println("Confirm Page Price is " + confirmePrice);
////				QaExtentReport.test.log(Status.INFO, "<b><i>Confirm Page Price is </i></b>" + confirmePrice);
//				// Booking id
//				String bookingID = QaBrowser.driver.findElement(By.xpath("//span[@class='nc_bookid_no']")).getText();
//				String a[] = bookingID.split(" ");
//				String number = a[2];
//				System.out.println("Booking ID is " + number);
//				QaExtentReport.test.log(Status.INFO, "<b><i>Booking id is </i></b>" + number);
//				QaExtentReport.extentScreenshot("Confirm Page");
//
//				QaRobot.mouseHover("//a[@id='ctl00_HeaderTop_aBookingMenu']",
//						"//span[@id='ctl00_HeaderTop_lblBookingQueue']");
////				QaExtentReport.extentScreenshot("CorporateDashboard Page");
////
////				QaRobot.ScreenshotMethod("CorporateDashboard", "<b><i>Screenshot for Corporate Dashboard Page</i></b>");
////				Thread.sleep(3000);
//
//				QaRobot.PassValue("RefNo", number);
////				QaExtentReport.test.log(Status.INFO, "<b><i>Write Ref No</i></b>");
//
//				QaRobot.ClickOnElement("SearchRefNo");
//
//				QaRobot.ClickOnElement("RefBooking");
//
//				QaExtentReport.extentScreenshot("Booking Card");
//
//				String Creater = QaBrowser.driver.findElement(By.xpath("//span[@id='lblCreatedBy']")).getText();
//				System.out.println("Created By " + Creater);
//				QaExtentReport.test.log(Status.INFO, "<b><i>Created By </i></b>" + Creater);
//
//				if (CreatedBy.equalsIgnoreCase(Creater)) {
//					QaExtentReport.test.log(Status.INFO, "<b><i>Creater is Correct  </i></b>" + CreatedBy);
//				} else {
//					QaExtentReport.test.log(Status.FAIL, "<b><i>Creater is Different  </i></b>" + CreatedBy);
//				}
			}
		}
	}

	public static void selectDateInCalendarOneWay(String Day, String Month, String Year) throws Exception {
		Date date = new Date();
		DateFormat d = new SimpleDateFormat("dd-MM-yyyy");
		String NewDate = d.format(date);
		Date date1 = d.parse(NewDate);

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

		QaExtentReport.test.log(Status.INFO, "<b><i>Select Date  </i></b>" + Day + "-" + Month + "-" + Year);

		Assert.assertFalse(Integer.parseInt(Day) > 31, "Invalid date provided " + Day + "-" + Month + "-" + Year);
		Assert.assertFalse(Month.equals("Feb") && Integer.parseInt(Day) > 28,
				"Invalid date provided " + Day + "-" + Month + "-" + Year);
		Thread.sleep(3000);
		String monthYear = QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[1]/div")).getText();
		Thread.sleep(5000);
		String month = monthYear.split(" ")[0];
		Thread.sleep(4000);
		String year = monthYear.split(" ")[1];

		Assert.assertFalse(date2.before(date1), "Invalid date provided " + Day + "-" + Month + "-" + Year);
		while (!(month.equals(Month) && year.equals(Year))) {
			QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/a[3]")).click();

			monthYear = QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[1]/div")).getText();
			month = monthYear.split(" ")[0];
			year = monthYear.split(" ")[1];
		}

		List<WebElement> allDates = QaBrowser.driver
				.findElements(By.xpath("/html/body/div[3]/div/div[2]/div[1]/table/tbody/tr/td"));

		for (WebElement ele : allDates) {
			String dt = ele.getText();

			if (dt.equalsIgnoreCase(Day)) {
				ele.click();
				ele.click();
				break;
			}
		}
//		}
	}

	public static void addHotel(String ProductType, String CityCode, String CityTitle, String CheckInDate,
			String CheckOutDate) throws Exception {
		QaRobot.ClickOnElement("AddHotelC");
		QaRobot.switchframe("//iframe[@id='AddCartPopupFrame']");
//		if (ProductType.equalsIgnoreCase("Car+Flight+Hotel") || ProductType.equalsIgnoreCase("Car+Hotel")
//				|| ProductType.equalsIgnoreCase("Car+Hotel+Flight")) {
		TestBase.listofautosuggestion4(By.xpath("//div[@id='divHTCity']/p"), CityCode, CityTitle,
				By.xpath("//input[@id='txtHotelSearch']"));
		QaExtentReport.test.log(Status.INFO, "<b><i>City Name : </i></b>" + CityCode + "-" + CityTitle);
		Thread.sleep(3000);
//		}
//		if (ProductType.equalsIgnoreCase("Car+Flight+Hotel") || ProductType.equalsIgnoreCase("Flight+Hotel")
//				|| ProductType.equalsIgnoreCase("Flight+Hotel+Car")
//				|| ProductType.equalsIgnoreCase("Flight+Car+Hotel")) {
//			QaBrowser.driver.findElement(By.xpath("//div[@id='divHTCity']/p")).click();
//		}
//			QaBrowser.driver
//					.findElement(By.xpath("//form[@id='HotelSearchCntrl']/div/div[3]/div[1]/label/span[2]/a/img"))
//					.click();
//			Thread.sleep(2000);
//			String DateSelection[] = CheckInDate.split("-");
//			String year = DateSelection[2];
//			String month = DateSelection[1];
//			String expDate = DateSelection[0];
//			String DateSelection1[] = CheckOutDate.split("-");
//			String year1 = DateSelection1[2];
//			String month1 = DateSelection1[1];
//			String expDate1 = DateSelection1[0];
//			selectDateInCalendarHotel(expDate, month, year, expDate1, month1, year1);
		Thread.sleep(2000);
//		QaRobot.ClickOnElement("CheckPolicyHotelC");
		QaExtentReport.extentScreenshot("Add Hotel");
		QaRobot.ClickOnElement("SearchHotelC1");
//		Thread.sleep(2000);
//		QaRobot.ClickOnElement("SearchHotelProceed");
		Thread.sleep(8000);
		QaRobot.scrollPage(300);
		QaRobot.ClickOnElement("HotelSelectC");
//		if (Server.equalsIgnoreCase("Staging")) {
		String getT = QaBrowser.driver.findElement(By.xpath("(//span[contains(@id,'Policy1')])[3]")).getText();
		QaExtentReport.extentScreenshot("Hotel Results");
		QaRobot.ClickOnElement("AddToCartHotelCX");
		if (getT.equalsIgnoreCase("Out policy")) {
			QaRobot.alertAccept();
		}
//		} else if (Server.equalsIgnoreCase("Xchange") || Server.equalsIgnoreCase("tpstg")) {
//			if (Server.equalsIgnoreCase("Xchange")) {
//				String getT1 = QaBrowser.driver.findElement(By.xpath("(//span[contains(@id,'Policy324503')])[3]"))
//						.getText();
//				QaExtentReport.extentScreenshot("Hotel Results");
//				QaRobot.ClickOnElement("AddToCartHotelCX");
//				if (getT1.equalsIgnoreCase("Out Of Policy")) {
//					QaRobot.alertAccept();
//				}
//			} else if (Server.equalsIgnoreCase("tpstg")) {
//				String getT1 = QaBrowser.driver.findElement(By.xpath("(//span[contains(@id,'Policy4')])[3]")).getText();
//				QaExtentReport.extentScreenshot("Hotel Results");
//				QaRobot.ClickOnElement("AddToCartHotelCX");
//				if (getT1.equalsIgnoreCase("Out Of Policy")) {
//					QaRobot.alertAccept();
//				}
//			}
//		}
		QaRobot.switchToWindow();
		QaRobot.ClickOnElement("HotelNotificationCloseC");
		QaRobot.scrollPage(-300);
		QaRobot.ClickOnElement("YourItineraryC");
		Thread.sleep(5000);
		QaExtentReport.extentScreenshot("Your Itinerary");
	}

	public static void selectDateInCalendarOneWayNew(String Day, String Month, String Year) throws Exception {
		Date date = new Date();
		DateFormat d = new SimpleDateFormat("dd-MM-yyyy");
		String NewDate = d.format(date);
		Date date1 = d.parse(NewDate);

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

		QaExtentReport.test.log(Status.INFO, "<b><i>Select Date  </i></b>" + Day + "-" + Month + "-" + Year);

		Assert.assertFalse(Integer.parseInt(Day) > 31, "Invalid date provided " + Day + "-" + Month + "-" + Year);
		Assert.assertFalse(Month.equals("Feb") && Integer.parseInt(Day) > 28,
				"Invalid date provided " + Day + "-" + Month + "-" + Year);
		Thread.sleep(3000);
		String monthYear = QaBrowser.driver.findElement(By.xpath("/html/body/div[6]/div/div[2]/div[1]/div")).getText();
		Thread.sleep(5000);
		String month = monthYear.split(" ")[0];
		Thread.sleep(4000);
		String year = monthYear.split(" ")[1];
		Assert.assertFalse(date2.before(date1), "Invalid date provided " + Day + "-" + Month + "-" + Year);
		while (!(month.equals(Month) && year.equals(Year))) {
			QaBrowser.driver.findElement(By.xpath("/html/body/div[6]/div/div[1]/a[3]")).click();
			monthYear = QaBrowser.driver.findElement(By.xpath("/html/body/div[6]/div/div[2]/div[1]/div")).getText();
			month = monthYear.split(" ")[0];
			year = monthYear.split(" ")[1];
		}
		List<WebElement> allDates = QaBrowser.driver
				.findElements(By.xpath("/html/body/div[6]/div/div[2]/div[1]/table/tbody/tr/td"));
		for (WebElement ele : allDates) {
			String dt = ele.getText();
			if (dt.equalsIgnoreCase(Day)) {
				ele.click();
				ele.click();
				break;
			}
		}
//		}
	}

	public static void selectDateInCalendarRoundTrip(String Day, String Month, String Year, String Day1, String Month1,
			String Year1) throws InterruptedException, ParseException {
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

		String monthYear = QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[1]/div")).getText();

		String month = monthYear.split(" ")[0];
		String year = monthYear.split(" ")[1];

		if (date2.before(date1)) {
			System.out.println("Invalid date provided " + Day + "-" + Month + "-" + Year);
			QaExtentReport.test.log(Status.FAIL,
					"<b><i>Invalid date provided  </i></b>" + Day + "-" + Month + "-" + Year);
//			throw new B2cExceptionClass("Invalid date provided " + Day + "-" + Month + "-" + Year);
		} else {
			while (!(month.equals(Month) && year.equals(Year))) {
				QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/a[3]")).click();

				monthYear = QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[1]/div")).getText();

				month = monthYear.split(" ")[0];
				year = monthYear.split(" ")[1];
			}

			List<WebElement> allDates = QaBrowser.driver
					.findElements(By.xpath("/html/body/div[3]/div/div[2]/div[1]/table/tbody/tr/td"));

			for (WebElement ele : allDates) {
				String dt = ele.getText();

				if (dt.equalsIgnoreCase(Day)) {
					ele.click();
					break;
				}
			}
			Thread.sleep(2000);

			String monthYear1 = QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[1]/div"))
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
					QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/a[3]")).click();
					monthYear1 = QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[1]/div"))
							.getText();
					month1 = monthYear1.split(" ")[0];
					year1 = monthYear1.split(" ")[1];
				}
				List<WebElement> allDates1 = QaBrowser.driver
						.findElements(By.xpath("/html/body/div[3]/div/div[2]/div[1]/table/tbody/tr/td"));
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

		String monthYear = QaBrowser.driver.findElement(By.xpath("/html/body/div[6]/div/div[2]/div[1]/div")).getText();
		String month = monthYear.split(" ")[0];
		String year = monthYear.split(" ")[1];

		if (date2.before(date1)) {
			System.out.println("Invalid date provided " + Day + "-" + Month + "-" + Year);
			QaExtentReport.test.log(Status.FAIL,
					"<b><i>Invalid date provided  </i></b>" + Day + "-" + Month + "-" + Year);
//			throw new B2cExceptionClass("Invalid date provided " + Day + "-" + Month + "-" + Year);
		} else {
			while (!(month.equals(Month) && year.equals(Year))) {
				QaBrowser.driver.findElement(By.xpath("/html/body/div[6]/div/div[1]/a[3]")).click();
				monthYear = QaBrowser.driver.findElement(By.xpath("/html/body/div[6]/div/div[2]/div[1]/div")).getText();
				month = monthYear.split(" ")[0];
				year = monthYear.split(" ")[1];
			}

			List<WebElement> allDates = QaBrowser.driver
					.findElements(By.xpath("/html/body/div[6]/div/div[2]/div[1]/table/tbody/tr/td"));

			for (WebElement ele : allDates) {
				String dt = ele.getText();

				if (dt.equalsIgnoreCase(Day)) {
					ele.click();
					break;
				}
			}
			Thread.sleep(2000);

			String monthYear1 = QaBrowser.driver.findElement(By.xpath("/html/body/div[6]/div/div[2]/div[1]/div"))
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
					QaBrowser.driver.findElement(By.xpath("/html/body/div[17]/div/div[1]/a[3]")).click();
					monthYear1 = QaBrowser.driver.findElement(By.xpath("/html/body/div[6]/div/div[2]/div[1]/div"))
							.getText();
					month1 = monthYear1.split(" ")[0];
					year1 = monthYear1.split(" ")[1];
				}
				List<WebElement> allDates1 = QaBrowser.driver
						.findElements(By.xpath("/html/body/div[6]/div/div[2]/div[1]/table/tbody/tr/td"));
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
}
