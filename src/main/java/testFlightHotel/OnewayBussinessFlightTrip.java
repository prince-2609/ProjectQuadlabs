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
public class OnewayBussinessFlightTrip {

	@DataProvider
	public Object[][] getexceldata() throws Exception {

		return QaDataProvider.getTestdata("SBT_Flight", "Sheet5");
	}

	@Test(dataProvider = "getexceldata")
	public static void onewayBussinessFlightTrip(String TestCaseId, String TestScenario, String Source, String MoURL,
			String CompanyCode, String UserName, String Password, String SRqty, String Rules, String RuleTitle,
			String SelectProduct, String SQty, String Supplier, String SelectSalesChannel, String CriteriaQty,
			String CriteriaName, String AirQty, String Airlines, String BookDateFrom, String BookDateTo,
			String TripDateFrom, String TripDateTo, String CorpQty, String SearchCorporate, String DayInAdvance,
			String DestinationFor, String Zqty, String Zone, String Rqty, String Region, String Cqty, String Country,
			String CiQty, String City, String Aqty, String Airport, String OriginFor, String OZqty, String OZone,
			String ORqty, String ORegion, String OCqty, String OCountry, String OCiQty, String OCity, String OAqty,
			String OAirport, String GDSQty, String GDS, String DaysQty, String Days, String MarketQty,
			String SelectMarketType, String TravellerQty, String TravellerType, String AppliedQty, String AppliedOn,
			String Remarks, String UploadImage, String SearchRuleStatus, String RSqty, String RulesAppliedOnSearchPage,
			String ccode, String URL, String EmployeName, String TravelerType, String uname, String pwd,
			String CoporateName, String corptraveller, String searchType, String triptype, String Trip, String origin,
			String forigin, String destination, String fdesti, String DepartureDate, String ReturnDate,
			String ResultRuleStatus, String RRqty, String RulesAppliedOnResultPage, String adult, String child,
			String infant, String currency, String fclass, String preairline, String nationality, String Stops,
			String AirLine, String booknowindex, String policyindex, String tripindex, String passportnumber,
			String fop, String receiptno, String card, String cardtype, String cvv, String resultpagestep,
			String CheckOutRuleStatus, String RCqty, String RulesAppliedOnCheckOutPage, String checkoutPageStep,
			String AdultSeatSelection, String ChildSeatSelection, String airReasonCode, String CreatedBy)
			throws Exception {
		QaExtentReport.test = QaExtentReport.report.createTest(TestCaseId + "-" + TestScenario);
//		TestBase.moLogin(Source, MoURL);
//		QaRobot.PassValue("CompanyCode", CompanyCode);
//		QaRobot.PassValue("UserName", UserName);
//		QaRobot.PassValue("PasswordFD", Password);
//		QaExtentReport.extentScreenshot("Sigh In Page");
//		QaRobot.ClickOnElement("LogIn");
//		QaRobot.switchframe("//frame[@name='login']");
//		QaRobot.switchframe("//frame[@name='leftbar']");
//		QaRobot.ClickOnElement("CorporateManagement");
//		Thread.sleep(3000);
//		QaRobot.ClickOnElement("InteractiveMessaging");
//		Thread.sleep(3000);
//		QaBrowser.driver.switchTo().parentFrame();
//		QaRobot.switchframe("//frame[@name='main']");
//		QaRobot.switchframe("//frame[@id='frm2']");
//		int pAS2 = Integer.parseInt(SRqty);
//		for (int k = 1; k <= pAS2; k++) {
//			String[] tN = Rules.split(",");
//			String b = tN[k - 1];
//			List<WebElement> listOfRules = QaBrowser.driver
//					.findElements(By.xpath("//table[@id='GridView1']/tbody/tr/td/a"));
//			for (WebElement autoRule : listOfRules) {
//				if (autoRule.getText().equalsIgnoreCase(b)) {
//					autoRule.click();
//					QaRobot.ClickOnElement("InActiveInteractiveMessaging");
//					QaRobot.ClickOnElement("SaveInteractiveMessaging");
//					QaRobot.alertAccept();
//					Thread.sleep(3000);
//					break;
//				}
//			}
//		}
//		QaRobot.ClickOnElement("AddNewRule");
//		QaRobot.PassValue("AddTitle", RuleTitle);
//		QaRobot.selectTextByLocator("//select[@id='ddlProduct']", SelectProduct);
//		if (SQty.equalsIgnoreCase("1") || SQty.equalsIgnoreCase("2") || SQty.equalsIgnoreCase("3")
//				|| SQty.equalsIgnoreCase("4") || SQty.equalsIgnoreCase("5")) {
//			QaRobot.transferData(SQty, Supplier, "//select[@id='ddlSupplier']/option");
//		} else if (SQty.equalsIgnoreCase("All")) {
//			QaRobot.ClickOnElement("SelectAllSupplier");
//		}
//		if (SelectSalesChannel.equalsIgnoreCase("Corporate SBT")) {
//			QaRobot.ClickOnElement("CorporateSbt");
//		} else if (SelectSalesChannel.equalsIgnoreCase("Point of Sale")) {
//			QaRobot.ClickOnElement("PointOfSale");
//		} else if (SelectSalesChannel.equalsIgnoreCase("All")) {
//			QaRobot.ClickOnElement("CorporateSbt");
//			QaRobot.ClickOnElement("PointOfSale");
//		}
//		if (SelectProduct.equalsIgnoreCase("Flight")) {
//			int pAS = Integer.parseInt(CriteriaQty);
//			if (CriteriaQty.equalsIgnoreCase("1")) {
//				for (int i = 1; i <= pAS; i++) {
//					String[] tN = CriteriaName.split(",");
//					String b = tN[i - 1];
//					QaRobot.selectTextByLocator("//select[@id='key1']", b);
//					if (b.equalsIgnoreCase("Airline")) {
//						QaRobot.switchToWindow();
//						int pAS1 = Integer.parseInt(AirQty);
//						for (int k = 1; k <= pAS1; k++) {
//							String[] tN1 = Airlines.split(",");
//							String b1 = tN1[k - 1];
//							QaBrowser.driver.findElement(By.xpath("//input[@id='txtAirline']")).clear();
//							QaRobot.PassValue("PassAirline", b1);
//							List<WebElement> listOfRights1 = QaBrowser.driver
//									.findElements(By.xpath("//select[@id='ListBoxAirlineFiller']/option"));
//							for (WebElement autoRights1 : listOfRights1) {
//								if (autoRights1.getText().equalsIgnoreCase(b1)) {
//									autoRights1.click();
//									QaRobot.ClickOnElement("IMAddAirline");
//									break;
//								}
//							}
//						}
//						QaRobot.ClickOnElement("IMAirlineSelectClose");
//
//					} else if (b.equalsIgnoreCase("Booking Date")) {
//						QaRobot.switchToWindow();
//						QaRobot.ClickOnElement("BookDateFrom");
//						String DateSelection[] = BookDateFrom.split("-");
//						String year = DateSelection[2];
//						String month = DateSelection[1];
//						String expDate = DateSelection[0];
//						QaRobot.selectDateInCalendarIM(expDate, month, year);
//						QaRobot.ClickOnElement("BookDateTo");
//						String DateSelection1[] = BookDateTo.split("-");
//						String year1 = DateSelection1[2];
//						String month1 = DateSelection1[1];
//						String expDate1 = DateSelection1[0];
//						QaRobot.selectDateInCalendarIM(expDate1, month1, year1);
//						QaRobot.ClickOnElement("AddBookDate");
//						QaRobot.ClickOnElement("IMBookDateSelectClose");
//
//					} else if (b.equalsIgnoreCase("Trip Date")) {
//						QaRobot.switchToWindow();
//						QaRobot.ClickOnElement("TripDateFrom");
//						String DateSelection[] = TripDateFrom.split("-");
//						String year = DateSelection[2];
//						String month = DateSelection[1];
//						String expDate = DateSelection[0];
//						QaRobot.selectDateInCalendarIM(expDate, month, year);
//						QaRobot.ClickOnElement("TripDateTo");
//						String DateSelection1[] = TripDateTo.split("-");
//						String year1 = DateSelection1[2];
//						String month1 = DateSelection1[1];
//						String expDate1 = DateSelection1[0];
//						QaRobot.selectDateInCalendarIM(expDate1, month1, year1);
//						QaRobot.ClickOnElement("AddTripDate");
//						QaRobot.ClickOnElement("IMTripDateSelectClose");
//
//					} else if (b.equalsIgnoreCase("Corporate")) {
//						QaRobot.switchToWindow();
//						int pAS1 = Integer.parseInt(CorpQty);
//						for (int k = 1; k <= pAS1; k++) {
//							String[] tN1 = SearchCorporate.split(",");
//							String b1 = tN1[k - 1];
//							QaBrowser.driver.findElement(By.xpath("//input[@id='txtInputTextForCorporate']")).clear();
//							QaRobot.PassValue("PassCorp", b1);
//							List<WebElement> listOfRights1 = QaBrowser.driver
//									.findElements(By.xpath("//select[@id='ListBoxCorporate']/option"));
//							for (WebElement autoRights1 : listOfRights1) {
//								if (autoRights1.getText().equalsIgnoreCase(b1)) {
//									autoRights1.click();
//									QaRobot.ClickOnElement("AddCorp");
//								}
//							}
//						}
//						QaRobot.ClickOnElement("CorpSelectClose");
//
//					} else if (b.equalsIgnoreCase("DayInAdvance")) {
//						QaRobot.switchToWindow();
//						QaRobot.PassValue("IMDayInAdvance", DayInAdvance);
//						QaRobot.ClickOnElement("IMDIAdvanceSaveClose");
//
//					} else if (b.equalsIgnoreCase("Origin")) {
//						QaRobot.switchToWindow();
//						if (OriginFor.equalsIgnoreCase("Zone")) {
//							QaRobot.ClickOnElement("IMZone");
//							QaRobot.transferData(OZqty, OZone, "//select[@id='ListBoxZone']/option");
//						} else if (OriginFor.equalsIgnoreCase("Region")) {
//							QaRobot.ClickOnElement("IMRegion");
//							QaRobot.transferData(ORqty, ORegion, "//select[@id='ListBoxRegion']/option");
//						} else if (OriginFor.equalsIgnoreCase("Country")) {
//							QaRobot.ClickOnElement("IMCountry");
//							QaRobot.transferDataWithPassValue(OCqty, OCountry, "//input[@id='txtSearch']",
//									"//div[@id='divSearch']/p");
//						} else if (OriginFor.equalsIgnoreCase("City")) {
//							QaRobot.ClickOnElement("IMCity");
//							QaRobot.transferDataWithPassValue(OCiQty, OCity, "//input[@id='txtSearch']",
//									"//div[@id='divSearch']/p");
//						} else if (OriginFor.equalsIgnoreCase("Airport")) {
//							QaRobot.ClickOnElement("IMAirport");
//							QaRobot.transferDataWithPassValue(OAqty, OAirport, "//input[@id='txtSearch']",
//									"//div[@id='divSearch']/p");
//						}
//						QaRobot.ClickOnElement("IMOriginSaveClose");
//
//					} else if (b.equalsIgnoreCase("Destination")) {
//						QaRobot.switchToWindow();
//						if (DestinationFor.equalsIgnoreCase("Zone")) {
//							QaRobot.ClickOnElement("IMZone");
//							QaRobot.transferData(Zqty, Zone, "//select[@id='ListBoxZone']/option");
//						} else if (DestinationFor.equalsIgnoreCase("Region")) {
//							QaRobot.ClickOnElement("IMRegion");
//							QaRobot.transferData(Rqty, Region, "//select[@id='ListBoxRegion']/option");
//						} else if (DestinationFor.equalsIgnoreCase("Country")) {
//							QaRobot.ClickOnElement("IMCountry");
//							QaRobot.transferDataWithPassValue(Cqty, Country, "//input[@id='txtSearch']",
//									"//div[@id='divSearch']/p");
//						} else if (DestinationFor.equalsIgnoreCase("City")) {
//							QaRobot.ClickOnElement("IMCity");
//							QaRobot.transferDataWithPassValue(CiQty, City, "//input[@id='txtSearch']",
//									"//div[@id='divSearch']/p");
//						} else if (DestinationFor.equalsIgnoreCase("Airport")) {
//							QaRobot.ClickOnElement("IMAirport");
//							QaRobot.transferDataWithPassValue(Aqty, Airport, "//input[@id='txtSearch']",
//									"//div[@id='divSearch']/p");
//						}
//						QaRobot.ClickOnElement("IMDestinationSaveClose");
//
//					} else if (b.equalsIgnoreCase("GDS")) {
//						QaRobot.switchToWindow();
//						QaRobot.transferData(GDSQty, GDS, "//select[@id='ListBoxGDS']/option");
//						QaRobot.ClickOnElement("IMGDSSaveClose");
//
//					} else if (b.equalsIgnoreCase("Weekdays")) {
//						QaRobot.switchToWindow();
//						QaRobot.transferData(DaysQty, Days, "//select[@id='ListBoxWeekdays']/option");
//						QaRobot.ClickOnElement("DaysSelectClose");
//
//					} else if (b.equalsIgnoreCase("Market Type")) {
//						QaRobot.switchToWindow();
//						QaRobot.transferData(MarketQty, SelectMarketType, "//select[@id='ListBoxMarketType']/option");
//						QaRobot.ClickOnElement("MarketTypeSelectClose");
//					}
//				}
//
//			} else {
//				for (int i = 1; i <= pAS; i++) {
//					String[] tN = CriteriaName.split(",");
//					String b = tN[i - 1];
//					String s = Integer.toString(i);
//					if (s.equalsIgnoreCase("1")) {
//						QaRobot.selectTextByLocator("//select[@id='key1']", b);
//					} else {
//						QaRobot.ClickOnElement("IMAddNewCriteria");
//						QaRobot.selectTextByLocator("//select[@id='key" + i + "']", b);
//					}
//					if (b.equalsIgnoreCase("Airline")) {
//						QaRobot.switchToWindow();
//						int pAS1 = Integer.parseInt(AirQty);
//						for (int k = 1; k <= pAS1; k++) {
//							String[] tN1 = Airlines.split(",");
//							String b1 = tN1[k - 1];
//							QaBrowser.driver.findElement(By.xpath("//input[@id='txtAirline']")).clear();
//							QaRobot.PassValue("PassAirline", b1);
//							List<WebElement> listOfRights1 = QaBrowser.driver
//									.findElements(By.xpath("//select[@id='ListBoxAirlineFiller']/option"));
//							for (WebElement autoRights1 : listOfRights1) {
//								if (autoRights1.getText().equalsIgnoreCase(b1)) {
//									autoRights1.click();
//									QaRobot.ClickOnElement("IMAddAirline");
//									break;
//								}
//							}
//						}
//						QaRobot.ClickOnElement("IMAirlineSelectClose");
//
//					} else if (b.equalsIgnoreCase("Booking Date")) {
//						QaRobot.switchToWindow();
//						QaRobot.ClickOnElement("BookDateFrom");
//						String DateSelection[] = BookDateFrom.split("-");
//						String year = DateSelection[2];
//						String month = DateSelection[1];
//						String expDate = DateSelection[0];
//						QaRobot.selectDateInCalendarIM(expDate, month, year);
//						QaRobot.ClickOnElement("BookDateTo");
//						String DateSelection1[] = BookDateTo.split("-");
//						String year1 = DateSelection1[2];
//						String month1 = DateSelection1[1];
//						String expDate1 = DateSelection1[0];
//						QaRobot.selectDateInCalendarIM(expDate1, month1, year1);
//						QaRobot.ClickOnElement("AddBookDate");
//						QaRobot.ClickOnElement("IMBookDateSelectClose");
//
//					} else if (b.equalsIgnoreCase("Trip Date")) {
//						QaRobot.switchToWindow();
//						QaRobot.ClickOnElement("TripDateFrom");
//						String DateSelection[] = TripDateFrom.split("-");
//						String year = DateSelection[2];
//						String month = DateSelection[1];
//						String expDate = DateSelection[0];
//						QaRobot.selectDateInCalendarIM(expDate, month, year);
//						QaRobot.ClickOnElement("TripDateTo");
//						String DateSelection1[] = TripDateTo.split("-");
//						String year1 = DateSelection1[2];
//						String month1 = DateSelection1[1];
//						String expDate1 = DateSelection1[0];
//						QaRobot.selectDateInCalendarIM(expDate1, month1, year1);
//						QaRobot.ClickOnElement("AddTripDate");
//						QaRobot.ClickOnElement("IMTripDateSelectClose");
//
//					} else if (b.equalsIgnoreCase("Corporate")) {
//						QaRobot.switchToWindow();
//						int pAS1 = Integer.parseInt(CorpQty);
//						for (int k = 1; k <= pAS1; k++) {
//							String[] tN1 = SearchCorporate.split(",");
//							String b1 = tN1[k - 1];
//							QaBrowser.driver.findElement(By.xpath("//input[@id='txtInputTextForCorporate']")).clear();
//							QaRobot.PassValue("PassCorp", b1);
//							List<WebElement> listOfRights1 = QaBrowser.driver
//									.findElements(By.xpath("//select[@id='ListBoxCorporate']/option"));
//							for (WebElement autoRights1 : listOfRights1) {
//								if (autoRights1.getText().equalsIgnoreCase(b1)) {
//									autoRights1.click();
//									QaRobot.ClickOnElement("AddCorp");
//								}
//							}
//						}
//						QaRobot.ClickOnElement("CorpSelectClose");
//
//					} else if (b.equalsIgnoreCase("DayInAdvance")) {
//						QaRobot.switchToWindow();
//						QaRobot.PassValue("IMDayInAdvance", DayInAdvance);
//						QaRobot.ClickOnElement("IMDIAdvanceSaveClose");
//
//					} else if (b.equalsIgnoreCase("Origin")) {
//						QaRobot.switchToWindow();
//						if (OriginFor.equalsIgnoreCase("Zone")) {
//							QaRobot.ClickOnElement("IMZone");
//							QaRobot.transferData(OZqty, OZone, "//select[@id='ListBoxZone']/option");
//						} else if (OriginFor.equalsIgnoreCase("Region")) {
//							QaRobot.ClickOnElement("IMRegion");
//							QaRobot.transferData(ORqty, ORegion, "//select[@id='ListBoxRegion']/option");
//						} else if (OriginFor.equalsIgnoreCase("Country")) {
//							QaRobot.ClickOnElement("IMCountry");
//							QaRobot.transferDataWithPassValue(OCqty, OCountry, "//input[@id='txtSearch']",
//									"//div[@id='divSearch']/p");
//						} else if (OriginFor.equalsIgnoreCase("City")) {
//							QaRobot.ClickOnElement("IMCity");
//							QaRobot.transferDataWithPassValue(OCiQty, OCity, "//input[@id='txtSearch']",
//									"//div[@id='divSearch']/p");
//						} else if (OriginFor.equalsIgnoreCase("Airport")) {
//							QaRobot.ClickOnElement("IMAirport");
//							QaRobot.transferDataWithPassValue(OAqty, OAirport, "//input[@id='txtSearch']",
//									"//div[@id='divSearch']/p");
//						}
//						QaRobot.ClickOnElement("IMOriginSaveClose");
//
//					} else if (b.equalsIgnoreCase("Destination")) {
//						QaRobot.switchToWindow();
//						if (DestinationFor.equalsIgnoreCase("Zone")) {
//							QaRobot.ClickOnElement("IMZone");
//							QaRobot.transferData(Zqty, Zone, "//select[@id='ListBoxZone']/option");
//						} else if (DestinationFor.equalsIgnoreCase("Region")) {
//							QaRobot.ClickOnElement("IMRegion");
//							QaRobot.transferData(Rqty, Region, "//select[@id='ListBoxRegion']/option");
//						} else if (DestinationFor.equalsIgnoreCase("Country")) {
//							QaRobot.ClickOnElement("IMCountry");
//							QaRobot.transferDataWithPassValue(Cqty, Country, "//input[@id='txtSearch']",
//									"//div[@id='divSearch']/p");
//						} else if (DestinationFor.equalsIgnoreCase("City")) {
//							QaRobot.ClickOnElement("IMCity");
//							QaRobot.transferDataWithPassValue(CiQty, City, "//input[@id='txtSearch']",
//									"//div[@id='divSearch']/p");
//						} else if (DestinationFor.equalsIgnoreCase("Airport")) {
//							QaRobot.ClickOnElement("IMAirport");
//							QaRobot.transferDataWithPassValue(Aqty, Airport, "//input[@id='txtSearch']",
//									"//div[@id='divSearch']/p");
//						}
//						QaRobot.ClickOnElement("IMDestinationSaveClose");
//
//					} else if (b.equalsIgnoreCase("GDS")) {
//						QaRobot.switchToWindow();
//						QaRobot.transferData(GDSQty, GDS, "//select[@id='ListBoxGDS']/option");
//						QaRobot.ClickOnElement("IMGDSSaveClose");
//
//					} else if (b.equalsIgnoreCase("Weekdays")) {
//						QaRobot.switchToWindow();
//						QaRobot.transferData(DaysQty, Days, "//select[@id='ListBoxWeekdays']/option");
//						QaRobot.ClickOnElement("DaysSelectClose");
//
//					} else if (b.equalsIgnoreCase("Market Type")) {
//						QaRobot.switchToWindow();
//						QaRobot.transferData(MarketQty, SelectMarketType, "//select[@id='ListBoxMarketType']/option");
//						QaRobot.ClickOnElement("MarketTypeSelectClose");
//					}
//				}
//			}
//		} else if (SelectProduct.equalsIgnoreCase("Hotel")) {
//			int pAS = Integer.parseInt(CriteriaQty);
//			if (CriteriaQty.equalsIgnoreCase("1")) {
//				for (int i = 1; i <= pAS; i++) {
//					String[] tN = CriteriaName.split(",");
//					String b = tN[i - 1];
//					QaRobot.selectTextByLocator("//select[@id='key1']", b);
//					if (b.equalsIgnoreCase("Trip Date")) {
//						QaRobot.switchToWindow();
//						QaRobot.ClickOnElement("TripDateFrom");
//						String DateSelection[] = TripDateFrom.split("-");
//						String year = DateSelection[2];
//						String month = DateSelection[1];
//						String expDate = DateSelection[0];
//						QaRobot.selectDateInCalendar(expDate, month, year);
//						QaRobot.ClickOnElement("TripDateTo");
//						String DateSelection1[] = TripDateTo.split("-");
//						String year1 = DateSelection1[2];
//						String month1 = DateSelection1[1];
//						String expDate1 = DateSelection1[0];
//						QaRobot.selectDateInCalendar(expDate1, month1, year1);
//						QaRobot.ClickOnElement("IMTripDateSelectClose");
//
//					} else if (b.equalsIgnoreCase("Weekdays")) {
//						QaRobot.switchToWindow();
//						QaRobot.transferData(DaysQty, Days, "//select[@id='ListBoxWeekdays']/option");
//						QaRobot.ClickOnElement("DaysSelectClose");
//
//					} else if (b.equalsIgnoreCase("Market Type")) {
//						QaRobot.switchToWindow();
//						QaRobot.transferData(MarketQty, SelectMarketType, "//select[@id='ListBoxMarketType']/option");
//						QaRobot.ClickOnElement("MarketTypeSelectClose");
//					}
//				}
//
//			} else {
//				for (int i = 1; i <= pAS; i++) {
//					String[] tN = CriteriaName.split(",");
//					String b = tN[i - 1];
//					String s = Integer.toString(i);
//					if (s.equalsIgnoreCase("1")) {
//						QaRobot.selectTextByLocator("//select[@id='key1']", b);
//					} else {
//						QaRobot.ClickOnElement("IMAddNewCriteria");
//						QaRobot.selectTextByLocator("//select[@id='key" + i + "']", b);
//					}
//					if (b.equalsIgnoreCase("Trip Date")) {
//						QaRobot.switchToWindow();
//						QaRobot.ClickOnElement("TripDateFrom");
//						String DateSelection[] = TripDateFrom.split("-");
//						String year = DateSelection[2];
//						String month = DateSelection[1];
//						String expDate = DateSelection[0];
//						QaRobot.selectDateInCalendarIM(expDate, month, year);
//						QaRobot.ClickOnElement("TripDateTo");
//						String DateSelection1[] = TripDateTo.split("-");
//						String year1 = DateSelection1[2];
//						String month1 = DateSelection1[1];
//						String expDate1 = DateSelection1[0];
//						QaRobot.selectDateInCalendarIM(expDate1, month1, year1);
//						QaRobot.ClickOnElement("IMTripDateSelectClose");
//
//					} else if (b.equalsIgnoreCase("Weekdays")) {
//						QaRobot.switchToWindow();
//						QaRobot.transferData(DaysQty, Days, "//select[@id='ListBoxWeekdays']/option");
//						QaRobot.ClickOnElement("DaysSelectClose");
//
//					} else if (b.equalsIgnoreCase("Market Type")) {
//						QaRobot.switchToWindow();
//						QaRobot.transferData(MarketQty, SelectMarketType, "//select[@id='ListBoxMarketType']/option");
//						QaRobot.ClickOnElement("MarketTypeSelectClose");
//					}
//				}
//			}
//		}
//		QaRobot.transferData(TravellerQty, TravellerType,
//				"/html/body/form/div[4]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[2]/td/div[1]/fieldset[1]/table/tbody/tr[3]/td/fieldset/table[2]/tbody/tr/td[2]/span/label");
//		QaRobot.transferData(AppliedQty, AppliedOn,
//				"/html/body/form/div[4]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[2]/td/div[1]/fieldset[1]/table/tbody/tr[3]/td/fieldset/table[3]/tbody/tr/td[2]//label");
//		QaRobot.PassValue("IMRemarks", Remarks);
//		QaRobot.PassValue("ChooseFile", UploadImage);
//		Thread.sleep(3000);
//		QaExtentReport.extentScreenshot("" + RuleTitle + "");
//		QaRobot.ClickOnElement("SaveInteractiveMessaging");
//		QaRobot.alertAccept();
//		QaRobot.ClickOnElement("CloseInteractiveMessaging");
		TestBase.Companycode(ccode, URL);
		QaRobot.impliwait(30);
		Login.SbtLogin(uname, pwd);
		QaExtentReport.test.log(Status.INFO, "<b><i>Employee Name is  </i></b>" + EmployeName);
		QaExtentReport.test.log(Status.INFO, "<b><i> Traveler Type is  </i></b>" + TravelerType);
		if (CoporateName.equalsIgnoreCase("Demo Corporate")) {
			QaRobot.ClickOnElement("ChooseCorporate1");
			QaExtentReport.test.log(Status.INFO, "<b><i> Coporate Name is  </i></b>" + CoporateName);
			QaExtentReport.extentScreenshot("Choose Corporate");
		} else if (CoporateName.equalsIgnoreCase("Lux_Test_corp")) {
			QaRobot.ClickOnElement("ChooseCorporate2");
			QaExtentReport.test.log(Status.INFO, "<b><i> Coporate Name is  </i></b>" + CoporateName);
			QaExtentReport.extentScreenshot("Choose Corporate");
		}
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
			QaBrowser.driver
					.findElement(By.xpath("//div[@id='flight_way1']/div[2]/div[1]/div/div/label/span[2]/span[1]/img"))
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
			QaBrowser.driver
					.findElement(By.xpath("//div[@id='flight_way1']/div[2]/div[1]/div/div/label/span[2]/span[1]/img"))
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
			QaBrowser.driver.findElement(By.xpath("//div[@id='Wallet_Status_divwalletmainUI']/div/div[1]/div")).click();
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
//		SearchDashboard.FlightpolicyCheck();
		QaExtentReport.extentScreenshot("Search Page");
		QaRobot.ClickOnElement("ow_searchflight");

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
//						Thread.sleep(3000);
//						QaBrowser.driver.findElement(By.xpath("(//*[contains(text(),'" + b1 + "')])[1]")).isDisplayed();
//						Thread.sleep(3000);
//						QaExtentReport.extentScreenshot(b1 + "-" + "Rule is Working on Search Page");
//						QaRobot.ClickOnElement("NextPicture");
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

		Thread.sleep(20000);

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

//			if (ResultRuleStatus.equalsIgnoreCase("Applied")) {
//				SoftAssert softAssert = new SoftAssert();
//				int pAS1 = Integer.parseInt(RRqty);
//				if (pAS1 == 1) {
//					for (int k = 1; k <= pAS1; k++) {
//						String[] tN1 = RulesAppliedOnResultPage.split(",");
//						String b1 = tN1[k - 1];
//						if (QaBrowser.driver.getPageSource().contains(b1)) {
//							Thread.sleep(3000);
//							QaBrowser.driver.findElement(By.xpath("(//*[contains(text(),'" + b1 + "')])[1]"))
//									.isDisplayed();
//							Thread.sleep(3000);
//							QaExtentReport.extentScreenshot(b1 + "-" + "Rule is Working on Result Page");
//						} else {
//							softAssert.assertTrue(false, b1 + "-" + "Rule is not Working on Result Page");
////							Assert.assertTrue(false, b1 + " " + "Rule is not Working");
//						}
//					}
//				} else {
//					for (int k = 1; k <= pAS1; k++) {
//						String[] tN1 = RulesAppliedOnResultPage.split(",");
//						String b1 = tN1[k - 1];
//						if (QaBrowser.driver.getPageSource().contains(b1)) {
//							Thread.sleep(3000);
//							QaBrowser.driver.findElement(By.xpath("(//*[contains(text(),'" + b1 + "')])[1]"))
//									.isDisplayed();
//							Thread.sleep(3000);
//							QaExtentReport.extentScreenshot(b1 + "-" + "Rule is Working on Result Page");
//							QaRobot.ClickOnElement("NextPicture");
//						} else {
//							softAssert.assertTrue(false, b1 + "-" + "Rule is not Working on Result Page");
////							Assert.assertTrue(false, b1 + " " + "Rule is not Working");
//						}
//					}
//				}
//				softAssert.assertAll();
//			}
		List<WebElement> listOfStop = QaBrowser.driver.findElements(
				By.xpath("//div[@id='FareDetailsController']/div[2]/div/div[1]/div/div[3]/div[4]/div[2]/ul/li/span"));
		for (WebElement autoStop : listOfStop) {
//			System.out.println(autoAirline.getText());
			if (autoStop.getText().equalsIgnoreCase(Stops)) {
				autoStop.click();
				break;
			}
		}
		Thread.sleep(5000);
		List<WebElement> listOfAirLine = QaBrowser.driver
				.findElements(By.xpath("//div[@id='tdContainerTblAirlines']/ul/li/label/span"));
		for (WebElement autoAirline : listOfAirLine) {
//			System.out.println(autoAirline.getText());
			if (autoAirline.getText().equalsIgnoreCase(AirLine)) {
				autoAirline.click();
				break;
			}
		}
		QaRobot.scrollPage(-1500);

		if (triptype.equalsIgnoreCase("Domestic")) {
			Thread.sleep(5000);
			if (Trip.equalsIgnoreCase("OneWay")) {
				String resultPagePrice = QaBrowser.driver
						.findElement(By.xpath("(//div[@class='fl_price_fmt']/p[2]/span/span[2])[" + tripindex + "]"))
						.getText();
//					QaExtentReport.test.log(Status.INFO, "<b><i>Result page price is </i></b>" + resultPagePrice);
				String policytype = QaBrowser.driver
						.findElement(By.xpath("(//span[contains(@id,'PT_')])[" + policyindex + "]")).getText();
				QaExtentReport.extentScreenshot("Result Page");
				if (resultpagestep.equalsIgnoreCase("Trip Request")) {
					SBTResultPage.tripRequest(tripindex, resultPagePrice, policytype);
				} else if (resultpagestep.equalsIgnoreCase("Flight Book")) {
					WebElement Book = QaBrowser.driver
							.findElement(By.xpath("(//input[contains(@id,'Anchor_')])[" + booknowindex + "]"));
					JavascriptExecutor js2 = (JavascriptExecutor) QaBrowser.driver;
					js2.executeScript("arguments[0].click()", Book);
					if (policytype.equalsIgnoreCase("Out Of Policy")) {
						QaBrowser.driver.switchTo().alert().accept();
					}
				}
			} else if (Trip.equalsIgnoreCase("RoundTrip")) {
				if (resultpagestep.equalsIgnoreCase("Trip Request")) {
//					SBTResultPage.tripRequest(tripindex, resultPagePrice, policytype);
				} else if (resultpagestep.equalsIgnoreCase("Flight Book")) {
					QaRobot.ClickOnElement("InPolicyTab");
					Thread.sleep(3000);
					WebElement Outbound = QaBrowser.driver
							.findElement(By.xpath("(//input[contains(@id,'radio_Outbound')])[" + booknowindex + "]"));
					JavascriptExecutor js2 = (JavascriptExecutor) QaBrowser.driver;
					js2.executeScript("arguments[0].click()", Outbound);
					WebElement Inbound = QaBrowser.driver
							.findElement(By.xpath("(//input[contains(@id,'radio_Inbound')])[" + booknowindex + "]"));
					JavascriptExecutor js3 = (JavascriptExecutor) QaBrowser.driver;
					js3.executeScript("arguments[0].click()", Inbound);
					QaExtentReport.extentScreenshot("Result Page");
					QaRobot.ClickOnElement("rt_Continue");
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
			if (resultpagestep.equalsIgnoreCase("Trip Request")) {
				SBTResultPage.tripRequest(tripindex, resultPagePrice, policytype);
			} else if (resultpagestep.equalsIgnoreCase("Flight Book")) {
				WebElement Book = QaBrowser.driver
						.findElement(By.xpath("(//input[contains(@id,'Anchor_')])[" + booknowindex + "]"));
				JavascriptExecutor js2 = (JavascriptExecutor) QaBrowser.driver;
				js2.executeScript("arguments[0].click()", Book);
				if (policytype.equalsIgnoreCase("Out Of Policy")) {
					QaBrowser.driver.switchTo().alert().accept();
				}
			}
		}
		checkoutpage(searchType, adult, child, infant, Stops, fop, receiptno, card, cardtype, cvv, CheckOutRuleStatus,
				RCqty, RulesAppliedOnCheckOutPage, checkoutPageStep, AdultSeatSelection, ChildSeatSelection,
				airReasonCode, CreatedBy);
//		}
	}

	@AfterTest
	public static void After_Test() {
		QaExtentReport.test.getExtent().flush();
	}

	public static void checkoutpage(String searchType, String adult, String child, String infant, String Stops,
			String fop, String receiptno, String card, String cardtype, String cvv, String CheckOutRuleStatus,
			String RCqty, String RulesAppliedOnCheckOutPage, String checkoutPageStep, String AdultSeatSelection,
			String ChildSeatSelection, String airReasonCode, String CreatedBy) throws Exception {
		if (QaBrowser.driver.findElement(By.xpath("//a[@id='ctl00_contentMain_expATag']")).isDisplayed()) {
			Assert.assertTrue(false, "Geeting change selection");
			QaExtentReport.test.log(Status.FAIL, "Geeting change selection");
		} else {
			String checkoutprice = QaBrowser.driver
					.findElement(By.xpath("//span[@id='ctl00_contentMain_totcashPrice']")).getText();
			System.out.println(checkoutprice);
			QaExtentReport.test.log(Status.INFO, "<b><i>Price of checkout page </i></b>" + checkoutprice);
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
				QaRobot.ClickOnElement("ow_billtobranch");
				Thread.sleep(3000);
				QaRobot.scrollPage(700);
				QaRobot.ClickOnElement("ow_chkterms");
//				QaExtentReport.test.log(Status.INFO, "<b><i>check the terms and condition</i></b>");
				QaRobot.ClickOnElement("ow_chkbook");
//				QaExtentReport.test.log(Status.INFO,
//						"<b><i>book button to proceed the booking from checkout page</i></b>");
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
				String CSelectSeat[] = ChildSeatSelection.split(",");
				String CSeat1 = CSelectSeat[0];
				String CSeat2 = CSelectSeat[1];
//				String CSeat3 = CSelectSeat[2];
				if (searchType.equalsIgnoreCase("Individual")) {
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
				} else {
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
				}
//				QaBrowser.driver.switchTo().alert().accept();
				Thread.sleep(7000);
				String paymentprice = QaBrowser.driver.findElement(By.xpath("//span[@id='ctl00_contentMain_lblTAmt']"))
						.getText();
				System.out.println("Price of payment page " + paymentprice);
				QaExtentReport.test.log(Status.INFO, "<b><i>Price of payment page </i></b>" + paymentprice);
				// select FOP
				if (fop.equalsIgnoreCase("Cash")) {
					SBTCheckoutPayment.fopCash(fop, receiptno);
				} else if (fop.equalsIgnoreCase("Bill To Company")) {
					SBTCheckoutPayment.fopBillToComapnay(fop);
					QaRobot.ClickOnElement("click_OK");
				} else {
					SBTCheckoutPayment.fopCreditDebit(card, cardtype, cvv);
				}

				QaExtentReport.extentScreenshot("Payment Page");
				QaRobot.ClickOnElement("ow_paymentprocced");
//				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on procced button</i></b>");
				Thread.sleep(2000);
				String bookingStatus = QaBrowser.driver.findElement(By.xpath("//span[@class='nc_status_color']"))
						.getText();
				System.out.println("Booking Status is " + bookingStatus);
				QaExtentReport.test.log(Status.INFO, "<b><i>Booking Status is </i></b>" + bookingStatus);
				// Confirmation code
				String pnr = QaBrowser.driver.findElement(By.xpath("//p[@class='nc_status_p']")).getText();
				System.out.println("PNR is " + pnr);
				QaExtentReport.test.log(Status.INFO, "<b><i>PNR is </i></b>" + pnr);
				// Confirm page price
				String confirmePrice = QaBrowser.driver.findElement(By.xpath("(//div[@class='nc_fcelllast'])[4]"))
						.getText();
				System.out.println("Confirm Page Price is " + confirmePrice);
				QaExtentReport.test.log(Status.INFO, "<b><i>Confirm Page Price is </i></b>" + confirmePrice);
				// Booking id
				String bookingID = QaBrowser.driver.findElement(By.xpath("//span[@class='nc_bookid_no']")).getText();
				String a[] = bookingID.split(" ");
				String number = a[2];
				System.out.println("Booking ID is " + number);
				QaExtentReport.test.log(Status.INFO, "<b><i>Booking id is </i></b>" + number);
				QaExtentReport.extentScreenshot("Confirm Page");

				QaRobot.mouseHover("//a[@id='ctl00_HeaderTop_aBookingMenu']",
						"//span[@id='ctl00_HeaderTop_lblBookingQueue']");
//				QaExtentReport.extentScreenshot("CorporateDashboard Page");
//
//				QaRobot.ScreenshotMethod("CorporateDashboard", "<b><i>Screenshot for Corporate Dashboard Page</i></b>");
//				Thread.sleep(3000);

				QaRobot.PassValue("RefNo", number);
//				QaExtentReport.test.log(Status.INFO, "<b><i>Write Ref No</i></b>");

				QaRobot.ClickOnElement("SearchRefNo");

				QaRobot.ClickOnElement("RefBooking");

				QaExtentReport.extentScreenshot("Booking Card");

				String Creater = QaBrowser.driver.findElement(By.xpath("//span[@id='lblCreatedBy']")).getText();
				System.out.println("Created By " + Creater);
				QaExtentReport.test.log(Status.INFO, "<b><i>Created By </i></b>" + Creater);

				if (CreatedBy.equalsIgnoreCase(Creater)) {
					QaExtentReport.test.log(Status.INFO, "<b><i>Creater is Correct  </i></b>" + CreatedBy);
				} else {
					QaExtentReport.test.log(Status.FAIL, "<b><i>Creater is Different  </i></b>" + CreatedBy);
				}
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

//			QaBrowser.driver.findElement(By.xpath("//div[@id='divReturnDate']/div/div/label/span[2]/span[1]/img"))
//					.click();
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
//				throw new B2cExceptionClass("Invalid Return date provided " + Day1 + "-" + Month1 + "-" + Year1);
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
}
