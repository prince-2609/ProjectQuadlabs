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
//import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import Base.TestBase;
import entities.Login;
//import jOLO_SBT.SBT_JOLO_CheckoutPage;
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
		return QaDataProvider.getTestdata("SBT_Flight", "TestFlightDiffentAirline");
	}

	@Test(dataProvider = "getexceldata")
	public static void onewayBussinessFlightTrip(String TestCaseId, String TestScenario, String Source, String MoURL,
			String CompanyCode, String UserName, String Password, String CreCanRule_BInfo_PreAirline_Policy_Interactive,
			String CreateCancellationChargeRule, String CRuleTitle, String CSelectProduct, String CQty,
			String CSupplier, String SalesChannelQty, String SalesChannel, String CCriteriaQty, String CCriteriaName,
			String CAirQty, String CAirlines, String CBookDateFrom, String CBookDateTo, String CabinClassQty,
			String CabinClass, String COriginFor, String CCOZqty, String CCOZone, String CCORqty, String CCORegion,
			String CCOCqty, String CCOCountry, String CCOCiQty, String CCOCity, String CCOAqty, String CCOAirport,
			String CDestinationFor, String CCZqty, String CCZone, String CCRqty, String CCRegion, String CCCqty,
			String CCCountry, String CCCiQty, String CCCity, String CCorpQty, String CSearchCorporate, String CCAqty,
			String CCAirport, String BClassQty, String BookingClass, String PassengerQty, String Passengers,
			String BaseFareFrom, String BaseFareTo, String FareQty, String Fares, String S_CQty,
			String Subagent_Corporate, String ChargesQty, String Charges, String Fees, String Amount, String CAppliedOn,
			String CancellationRemark, String BrandInformation, String Title, String Airline, String BICabinClass,
			String BookingClassQty, String BIBookingClass, String BIMarketType, String BrandName, String BrandDetails1,
			String BrandDetails2, String BIUploadImage, String BISalesChannelQty, String BISalesChannel, String KIQty,
			String KeyInformation, String BINotes, String PreferredAirline, String PACorporateName, String PAPAirQty,
			String PAPAirlines, String OriginType, String OCo, String PAOCountry, String OCi, String PAOCity,
			String OAirP, String OAirPort, String DestinationType, String DCo, String PADCountry, String DCi,
			String PADCity, String DAirP, String DAirPort, String Co_BranchQty, String Corporate_Branch,
			String TripStartDate, String TripEndDate, String CreatePolicy, String CorporateName,
			String TravelPolicyTitle, String Travelpurpose, String TravelCategory, String Product, String RuleAppliedOn,
			String SelectQty, String SelectFromList, String PCriteriaQty, String PCriteriaName, String PAirQty,
			String PAirlines, String POriginFor, String POZqty, String POZone, String PORqty, String PORegion,
			String POCqty, String POCountry, String POCiQty, String POCity, String PDestinationFor, String DZqty,
			String DZone, String DRqty, String DRegion, String DCqty, String DCountry, String DCiQty, String DCity,
			String CostFrom, String CostTo, String PBookDateFrom, String PBookDateTo, String PTripDateFrom,
			String PTripDateTo, String MarketType, String CabinQty, String Cabins, String OutPolicyReason,
			String CreateInteractiveMessage, String SRqty, String Rules, String RuleTitle, String SelectProduct,
			String SQty, String Supplier, String SelectSalesChannel, String CriteriaQty, String CriteriaName,
			String AirQty, String Airlines, String BookDateFrom, String BookDateTo, String TripDateFrom,
			String TripDateTo, String CorpQty, String SearchCorporate, String DayInAdvance, String DestinationFor,
			String Zqty, String Zone, String Rqty, String Region, String Cqty, String Country, String CiQty,
			String City, String Aqty, String Airport, String OriginFor, String OZqty, String OZone, String ORqty,
			String ORegion, String OCqty, String OCountry, String OCiQty, String OCity, String OAqty, String OAirport,
			String GDSQty, String GDS, String DaysQty, String Days, String MarketQty, String SelectMarketType,
			String TravellerQty, String TravellerType, String AppliedQty, String AppliedOn, String Remarks,
			String UploadImage, String SearchRuleStatus, String RSqty, String RulesAppliedOnSearchPage, String ccode,
			String URL, String EmployeName, String TravelerType, String uname, String pwd, String CoporateName,
			String FareBranding, String DashboardType, String corptraveller, String searchType, String triptype,
			String Trip, String origin, String forigin, String destination, String fdesti, String Policy,
			String DepartureDate, String ReturnDate, String ResultRuleStatus, String RRqty,
			String RulesAppliedOnResultPage, String adult, String child, String infant, String currency, String fclass,
			String PolicyType, String Stops, String ChooseAirLine, String OneWayAirLine, String RoundTripAirLine,
			String OneWayFareType, String RoundTripFareType, String booknowindex, String policyindex, String tripindex,
			String ProductType, String passportnumber, String fop, String receiptno, String card, String cardtype,
			String cvv, String Resultpagestep, String AddToCartRemarks, String CheckOutRuleStatus, String RCqty,
			String RulesAppliedOnCheckOutPage, String checkoutPageStep, String SeatSelection, String AdultSeatSelection,
			String ChildSeatSelection, String airReasonCode, String CreatedBy) throws Exception {
		QaExtentReport.test = QaExtentReport.report.createTest(TestCaseId + "-" + TestScenario);
		if (CreCanRule_BInfo_PreAirline_Policy_Interactive.equalsIgnoreCase("Yes")) {
			TestBase.moLogin(Source, MoURL);
			QaRobot.PassValue("CompanyCode", CompanyCode);
			QaRobot.PassValue("UserName", UserName);
			QaRobot.PassValue("PasswordFD", Password);
			QaExtentReport.extentScreenshot("Sigh In Page");
			QaRobot.ClickOnElement("LogIn");
			QaRobot.switchframe("//frame[@name='login']");
			QaRobot.switchframe("//frame[@name='leftbar']");
			if (CreateCancellationChargeRule.equalsIgnoreCase("Yes")) {
				QaRobot.ClickOnElement("Administation");
				Thread.sleep(3000);
				QaRobot.ClickOnElement("DefaultSetting");
				QaBrowser.driver.switchTo().parentFrame();
				QaRobot.switchframe("//frame[@name='main']");
				QaRobot.switchframe("//frame[@id='toolHeader']");
				WebElement mainMenu = QaBrowser.driver.findElement(By.xpath("//td[@id='acharges']/a"));
				mainMenu.click();
				QaBrowser.driver.switchTo().parentFrame();
				QaRobot.switchframe("//frame[@id='frm2']");
				if (Source.equalsIgnoreCase("sbt")) {
					WebElement subMenu = QaBrowser.driver
							.findElement(By.xpath("(/html/body/div/div/table/tbody/tr[6]/td)[1]"));
					subMenu.click();
				} else if (Source.equalsIgnoreCase("preprod117")) {
					WebElement subMenu = QaBrowser.driver
							.findElement(By.xpath("(/html/body/div/div/table/tbody/tr[5]/td)[1]"));
					subMenu.click();
				} else if (Source.equalsIgnoreCase("Live")) {
					WebElement subMenu = QaBrowser.driver
							.findElement(By.xpath("/html/body/div/div/table/tbody/tr[4]/td"));
					subMenu.click();
				}
				QaExtentReport.extentScreenshot("Cancellation Charges Rule");
				QaRobot.ClickOnElement("CCRAddNewRule");
				QaRobot.PassValue("CCRAddTitle", CRuleTitle);
				QaRobot.selectTextByLocator("//select[@id='ddlProduct']", CSelectProduct);
				if (CSelectProduct.equalsIgnoreCase("Hotel")) {
					if (CQty.equalsIgnoreCase("1") || CQty.equalsIgnoreCase("2") || CQty.equalsIgnoreCase("3")
							|| CQty.equalsIgnoreCase("4") || CQty.equalsIgnoreCase("5")) {
						QaRobot.transferData(CQty, CSupplier, "//select[@id='ddlSupplier']/option");
					} else if (CQty.equalsIgnoreCase("All")) {
//						QaRobot.ClickOnElement("SelectAllSupplier");
					}
				}
				int pAS1 = Integer.parseInt(SalesChannelQty);
				for (int k = 1; k <= pAS1; k++) {
					String[] tN1 = SalesChannel.split(",");
					String b1 = tN1[k - 1];
					List<WebElement> listOfRights1 = QaBrowser.driver
							.findElements(By.xpath("//table[@id='ListBoxSalesChannel']/tbody/tr/td/label"));
					for (WebElement autoRights1 : listOfRights1) {
						if (autoRights1.getText().equalsIgnoreCase(b1)) {
							autoRights1.click();
						}
					}
				}
				if (SelectProduct.equalsIgnoreCase("Flight")) {
					int pAS = Integer.parseInt(CCriteriaQty);
					if (CCriteriaQty.equalsIgnoreCase("1")) {
						for (int i = 1; i <= pAS; i++) {
							String[] tN = CCriteriaName.split(",");
							String b = tN[i - 1];
							QaRobot.selectTextByLocator("//select[@id='key1']", b);
							if (b.equalsIgnoreCase("Airline")) {
								QaRobot.switchToWindow();
								int pA1 = Integer.parseInt(CAirQty);
								for (int k = 1; k <= pA1; k++) {
									String[] tN1 = CAirlines.split(",");
									String b1 = tN1[k - 1];
									List<WebElement> listOfRights1 = QaBrowser.driver
											.findElements(By.xpath("//select[@id='ListBoxAirline']/option"));
									for (WebElement autoRights1 : listOfRights1) {
										if (autoRights1.getText().equalsIgnoreCase(b1)) {
											autoRights1.click();
										}
									}
								}
								QaRobot.ClickOnElement("CCRAirlineSelectClose");

							} else if (b.equalsIgnoreCase("Cabin Class")) {
								QaRobot.switchToWindow();
								int pA1 = Integer.parseInt(CabinClassQty);
								for (int k = 1; k <= pA1; k++) {
									String[] tN1 = CabinClass.split(",");
									String b1 = tN1[k - 1];
									List<WebElement> listOfRights1 = QaBrowser.driver
											.findElements(By.xpath("//select[@id='ListBoxCabinClass']/option"));
									for (WebElement autoRights1 : listOfRights1) {
										if (autoRights1.getText().equalsIgnoreCase(b1)) {
											autoRights1.click();
										}
									}
								}
								QaRobot.ClickOnElement("CCRCabinClassSelectClose");

							} else if (b.equalsIgnoreCase("Origin")) {
								QaRobot.switchToWindow();
								if (COriginFor.equalsIgnoreCase("Zone")) {
									QaRobot.ClickOnElement("IMZone");
									QaRobot.transferData(CCOZqty, CCOZone, "//select[@id='ListBoxZone']/option");
								} else if (COriginFor.equalsIgnoreCase("Region")) {
									QaRobot.ClickOnElement("IMRegion");
									QaRobot.transferData(CCORqty, CCORegion, "//select[@id='ListBoxRegion']/option");
								} else if (COriginFor.equalsIgnoreCase("Country")) {
									QaRobot.ClickOnElement("IMCountry");
									QaRobot.transferDataWithPassValue(CCOCqty, CCOCountry, "//input[@id='txtSearch']",
											"//div[@id='divSearch']/p");
								} else if (COriginFor.equalsIgnoreCase("City")) {
									QaRobot.ClickOnElement("IMCity");
									QaRobot.transferDataWithPassValue(CCOCiQty, CCOCity, "//input[@id='txtSearch']",
											"//div[@id='divSearch']/p");
								} else if (COriginFor.equalsIgnoreCase("Airport")) {
									QaRobot.ClickOnElement("IMAirport");
									QaRobot.transferDataWithPassValue(CCOAqty, CCOAirport, "//input[@id='txtSearch']",
											"//div[@id='divSearch']/p");
								}
								QaRobot.ClickOnElement("IMDestinationSaveClose");

							} else if (b.equalsIgnoreCase("Destination")) {
								QaRobot.switchToWindow();
								if (CDestinationFor.equalsIgnoreCase("Zone")) {
									QaRobot.ClickOnElement("IMZone");
									QaRobot.transferData(CCZqty, CCZone, "//select[@id='ListBoxZone']/option");
								} else if (CDestinationFor.equalsIgnoreCase("Region")) {
									QaRobot.ClickOnElement("IMRegion");
									QaRobot.transferData(CCRqty, CCRegion, "//select[@id='ListBoxRegion']/option");
								} else if (CDestinationFor.equalsIgnoreCase("Country")) {
									QaRobot.ClickOnElement("IMCountry");
									QaRobot.transferDataWithPassValue(CCCqty, CCCountry, "//input[@id='txtSearch']",
											"//div[@id='divSearch']/p");
								} else if (CDestinationFor.equalsIgnoreCase("City")) {
									QaRobot.ClickOnElement("IMCity");
									QaRobot.transferDataWithPassValue(CCCiQty, CCCity, "//input[@id='txtSearch']",
											"//div[@id='divSearch']/p");
								} else if (CDestinationFor.equalsIgnoreCase("Airport")) {
									QaRobot.ClickOnElement("IMAirport");
									QaRobot.transferDataWithPassValue(CCAqty, CCAirport, "//input[@id='txtSearch']",
											"//div[@id='divSearch']/p");
								}
								QaRobot.ClickOnElement("IMDestinationSaveClose");

							} else if (b.equalsIgnoreCase("Corporate")) {
								QaRobot.switchToWindow();
								int p1 = Integer.parseInt(CorpQty);
								for (int k = 1; k <= p1; k++) {
									String[] tN1 = SearchCorporate.split(",");
									String b1 = tN1[k - 1];
									QaBrowser.driver.findElement(By.xpath("//input[@id='txtInputTextForCorporate']"))
											.clear();
									QaRobot.PassValue("PassCorp", b1);
									List<WebElement> listOfRights1 = QaBrowser.driver
											.findElements(By.xpath("//select[@id='ListBoxCorporate']/option"));
									for (WebElement autoRights1 : listOfRights1) {
										if (autoRights1.getText().equalsIgnoreCase(b1)) {
											autoRights1.click();
											QaRobot.ClickOnElement("AddCorp");
										}
									}
								}
								QaRobot.ClickOnElement("CorpSelectClose");

							} else if (b.equalsIgnoreCase("Booking Class")) {
								QaRobot.switchToWindow();
								int p1 = Integer.parseInt(BClassQty);
								for (int k = 1; k <= p1; k++) {
									String[] tN1 = BookingClass.split(",");
									String b1 = tN1[k - 1];
									List<WebElement> listOfRights1 = QaBrowser.driver
											.findElements(By.xpath("//select[@id='ListBoxBookingClass']/option"));
									for (WebElement autoRights1 : listOfRights1) {
										if (autoRights1.getText().equalsIgnoreCase(b1)) {
											autoRights1.click();
										}
									}
								}
								QaRobot.ClickOnElement("CCRBookingClassSelectClose");

							} else if (b.equalsIgnoreCase("Pax Type")) {
								QaRobot.switchToWindow();
								int p1 = Integer.parseInt(PassengerQty);
								for (int k = 1; k <= p1; k++) {
									String[] tN1 = Passengers.split(",");
									String b1 = tN1[k - 1];
									List<WebElement> listOfRights1 = QaBrowser.driver
											.findElements(By.xpath("//select[@id='ListBoxPaxType']/option"));
									for (WebElement autoRights1 : listOfRights1) {
										if (autoRights1.getText().equalsIgnoreCase(b1)) {
											autoRights1.click();
										}
									}
								}
								QaRobot.ClickOnElement("CCRPaxTypeSelectClose");

							} else if (b.equalsIgnoreCase("Base Fare")) {
								QaRobot.switchToWindow();
								QaRobot.PassValue("CCRBaseFareFrom", BaseFareFrom);
								QaRobot.PassValue("CCRBaseFareTo", BaseFareTo);
								QaRobot.ClickOnElement("CCRBaseFareSelectClose");

							} else if (b.equalsIgnoreCase("Booking Date")) {
								QaRobot.switchToWindow();
								QaRobot.ClickOnElement("BookDateFrom");
								String DateSelection[] = CBookDateFrom.split("-");
								String year = DateSelection[2];
								String month = DateSelection[1];
								String expDate = DateSelection[0];
								QaRobot.selectDateInCalendarIM(expDate, month, year);
								QaRobot.ClickOnElement("BookDateTo");
								String DateSelection1[] = CBookDateTo.split("-");
								String year1 = DateSelection1[2];
								String month1 = DateSelection1[1];
								String expDate1 = DateSelection1[0];
								QaRobot.selectDateInCalendarIM(expDate1, month1, year1);
								QaRobot.ClickOnElement("AddBookDate");
								QaRobot.ClickOnElement("IMBookDateSelectClose");

							} else if (b.equalsIgnoreCase("Base Fare")) {
								QaRobot.switchToWindow();
								QaRobot.PassValue("CCRBaseFareFrom", BaseFareFrom);
								QaRobot.PassValue("CCRBaseFareTo", BaseFareTo);
								QaRobot.ClickOnElement("CCRBaseFareSelectClose");

							} else if (b.equalsIgnoreCase("Fare Type")) {
								QaRobot.switchToWindow();
								int p1 = Integer.parseInt(FareQty);
								for (int k = 1; k <= p1; k++) {
									String[] tN1 = Fares.split(",");
									String b1 = tN1[k - 1];
									List<WebElement> listOfRights1 = QaBrowser.driver
											.findElements(By.xpath("//select[@id='ListBoxFareType']/option"));
									for (WebElement autoRights1 : listOfRights1) {
										if (autoRights1.getText().equalsIgnoreCase(b1)) {
											autoRights1.click();
										}
									}
								}
								QaRobot.ClickOnElement("CCRFareSelectClose");

							} else if (b.equalsIgnoreCase("B2B/Corporate")) {
								QaRobot.switchToWindow();
								QaRobot.ClickOnElement("CCRSub");
								QaRobot.ClickOnElement("CCRCarp");
								int p1 = Integer.parseInt(S_CQty);
								for (int k = 1; k <= p1; k++) {
									String[] tN1 = Subagent_Corporate.split(",");
									String b1 = tN1[k - 1];
									QaBrowser.driver.findElement(By.xpath("//input[@id='txtInputTextForSubagent']"))
											.clear();
									QaRobot.PassValue("CCRPassCorp", b1);
									List<WebElement> listOfRights1 = QaBrowser.driver
											.findElements(By.xpath("//select[@id='ListBoxSubagent']/option"));
									for (WebElement autoRights1 : listOfRights1) {
										if (autoRights1.getText().equalsIgnoreCase(b1)) {
											autoRights1.click();
											QaRobot.ClickOnElement("CCRAddCorp");
										}
									}
								}
								QaRobot.ClickOnElement("CCRSub_CarpSelectClose");
							}
						}
					} else {
						for (int i = 1; i <= pAS; i++) {
							String[] tN = CCriteriaName.split(",");
							String b = tN[i - 1];
							String s = Integer.toString(i);
							if (s.equalsIgnoreCase("1")) {
								QaRobot.selectTextByLocator("//select[@id='key1']", b);
							} else {
								QaRobot.ClickOnElement("IMAddNewCriteria");
								QaRobot.selectTextByLocator("//select[@id='key" + i + "']", b);
							}
							if (b.equalsIgnoreCase("Airline")) {
								QaRobot.switchToWindow();
								int pA1 = Integer.parseInt(CAirQty);
								for (int k = 1; k <= pA1; k++) {
									String[] tN1 = CAirlines.split(",");
									String b1 = tN1[k - 1];
									List<WebElement> listOfRights1 = QaBrowser.driver
											.findElements(By.xpath("//select[@id='ListBoxAirline']/option"));
									for (WebElement autoRights1 : listOfRights1) {
										if (autoRights1.getText().equalsIgnoreCase(b1)) {
											autoRights1.click();
										}
									}
								}
								QaRobot.ClickOnElement("CCRAirlineSelectClose");

							} else if (b.equalsIgnoreCase("Cabin Class")) {
								QaRobot.switchToWindow();
								int pA1 = Integer.parseInt(CabinClassQty);
								for (int k = 1; k <= pA1; k++) {
									String[] tN1 = CabinClass.split(",");
									String b1 = tN1[k - 1];
									List<WebElement> listOfRights1 = QaBrowser.driver
											.findElements(By.xpath("//select[@id='ListBoxCabinClass']/option"));
									for (WebElement autoRights1 : listOfRights1) {
										if (autoRights1.getText().equalsIgnoreCase(b1)) {
											autoRights1.click();
										}
									}
								}
								QaRobot.ClickOnElement("CCRCabinClassSelectClose");

							} else if (b.equalsIgnoreCase("Origin")) {
								QaRobot.switchToWindow();
								if (COriginFor.equalsIgnoreCase("Zone")) {
									QaRobot.ClickOnElement("IMZone");
									QaRobot.transferData(CCOZqty, CCOZone, "//select[@id='ListBoxZone']/option");
								} else if (COriginFor.equalsIgnoreCase("Region")) {
									QaRobot.ClickOnElement("IMRegion");
									QaRobot.transferData(CCORqty, CCORegion, "//select[@id='ListBoxRegion']/option");
								} else if (COriginFor.equalsIgnoreCase("Country")) {
									QaRobot.ClickOnElement("IMCountry");
									QaRobot.transferDataWithPassValue(CCOCqty, CCOCountry, "//input[@id='txtSearch']",
											"//div[@id='divSearch']/p");
								} else if (COriginFor.equalsIgnoreCase("City")) {
									QaRobot.ClickOnElement("IMCity");
									QaRobot.transferDataWithPassValue(CCOCiQty, CCOCity, "//input[@id='txtSearch']",
											"//div[@id='divSearch']/p");
								} else if (COriginFor.equalsIgnoreCase("Airport")) {
									QaRobot.ClickOnElement("IMAirport");
									QaRobot.transferDataWithPassValue(CCOAqty, CCOAirport, "//input[@id='txtSearch']",
											"//div[@id='divSearch']/p");
								}
								QaRobot.ClickOnElement("IMDestinationSaveClose");

							} else if (b.equalsIgnoreCase("Destination")) {
								QaRobot.switchToWindow();
								if (CDestinationFor.equalsIgnoreCase("Zone")) {
									QaRobot.ClickOnElement("IMZone");
									QaRobot.transferData(CCZqty, CCZone, "//select[@id='ListBoxZone']/option");
								} else if (CDestinationFor.equalsIgnoreCase("Region")) {
									QaRobot.ClickOnElement("IMRegion");
									QaRobot.transferData(CCRqty, CCRegion, "//select[@id='ListBoxRegion']/option");
								} else if (CDestinationFor.equalsIgnoreCase("Country")) {
									QaRobot.ClickOnElement("IMCountry");
									QaRobot.transferDataWithPassValue(CCCqty, CCCountry, "//input[@id='txtSearch']",
											"//div[@id='divSearch']/p");
								} else if (CDestinationFor.equalsIgnoreCase("City")) {
									QaRobot.ClickOnElement("IMCity");
									QaRobot.transferDataWithPassValue(CCCiQty, CCCity, "//input[@id='txtSearch']",
											"//div[@id='divSearch']/p");
								} else if (CDestinationFor.equalsIgnoreCase("Airport")) {
									QaRobot.ClickOnElement("IMAirport");
									QaRobot.transferDataWithPassValue(CCAqty, CCAirport, "//input[@id='txtSearch']",
											"//div[@id='divSearch']/p");
								}
								QaRobot.ClickOnElement("IMDestinationSaveClose");

							} else if (b.equalsIgnoreCase("Corporate")) {
								QaRobot.switchToWindow();
								int p1 = Integer.parseInt(CorpQty);
								for (int k = 1; k <= p1; k++) {
									String[] tN1 = SearchCorporate.split(",");
									String b1 = tN1[k - 1];
									QaBrowser.driver.findElement(By.xpath("//input[@id='txtInputTextForCorporate']"))
											.clear();
									QaRobot.PassValue("PassCorp", b1);
									List<WebElement> listOfRights1 = QaBrowser.driver
											.findElements(By.xpath("//select[@id='ListBoxCorporate']/option"));
									for (WebElement autoRights1 : listOfRights1) {
										if (autoRights1.getText().equalsIgnoreCase(b1)) {
											autoRights1.click();
											QaRobot.ClickOnElement("AddCorp");
										}
									}
								}
								QaRobot.ClickOnElement("CorpSelectClose");

							} else if (b.equalsIgnoreCase("Booking Class")) {
								QaRobot.switchToWindow();
								int p1 = Integer.parseInt(BClassQty);
								for (int k = 1; k <= p1; k++) {
									String[] tN1 = BookingClass.split(",");
									String b1 = tN1[k - 1];
									List<WebElement> listOfRights1 = QaBrowser.driver
											.findElements(By.xpath("//select[@id='ListBoxBookingClass']/option"));
									for (WebElement autoRights1 : listOfRights1) {
										if (autoRights1.getText().equalsIgnoreCase(b1)) {
											autoRights1.click();
										}
									}
								}
								QaRobot.ClickOnElement("CCRBookingClassSelectClose");

							} else if (b.equalsIgnoreCase("Pax Type")) {
								QaRobot.switchToWindow();
								int p1 = Integer.parseInt(PassengerQty);
								for (int k = 1; k <= p1; k++) {
									String[] tN1 = Passengers.split(",");
									String b1 = tN1[k - 1];
									List<WebElement> listOfRights1 = QaBrowser.driver
											.findElements(By.xpath("//select[@id='ListBoxPaxType']/option"));
									for (WebElement autoRights1 : listOfRights1) {
										if (autoRights1.getText().equalsIgnoreCase(b1)) {
											autoRights1.click();
										}
									}
								}
								QaRobot.ClickOnElement("CCRPaxTypeSelectClose");

							} else if (b.equalsIgnoreCase("Base Fare")) {
								QaRobot.switchToWindow();
								QaRobot.PassValue("CCRBaseFareFrom", BaseFareFrom);
								QaRobot.PassValue("CCRBaseFareTo", BaseFareTo);
								QaRobot.ClickOnElement("CCRBaseFareSelectClose");

							} else if (b.equalsIgnoreCase("Booking Date")) {
								QaRobot.switchToWindow();
								QaRobot.ClickOnElement("BookDateFrom");
								String DateSelection[] = CBookDateFrom.split("-");
								String year = DateSelection[2];
								String month = DateSelection[1];
								String expDate = DateSelection[0];
								QaRobot.selectDateInCalendarIM(expDate, month, year);
								QaRobot.ClickOnElement("BookDateTo");
								String DateSelection1[] = CBookDateTo.split("-");
								String year1 = DateSelection1[2];
								String month1 = DateSelection1[1];
								String expDate1 = DateSelection1[0];
								QaRobot.selectDateInCalendarIM(expDate1, month1, year1);
								QaRobot.ClickOnElement("AddBookDate");
								QaRobot.ClickOnElement("IMBookDateSelectClose");

							} else if (b.equalsIgnoreCase("Base Fare")) {
								QaRobot.switchToWindow();
								QaRobot.PassValue("CCRBaseFareFrom", BaseFareFrom);
								QaRobot.PassValue("CCRBaseFareTo", BaseFareTo);
								QaRobot.ClickOnElement("CCRBaseFareSelectClose");

							} else if (b.equalsIgnoreCase("Fare Type")) {
								QaRobot.switchToWindow();
								int p1 = Integer.parseInt(FareQty);
								for (int k = 1; k <= p1; k++) {
									String[] tN1 = Fares.split(",");
									String b1 = tN1[k - 1];
									List<WebElement> listOfRights1 = QaBrowser.driver
											.findElements(By.xpath("//select[@id='ListBoxFareType']/option"));
									for (WebElement autoRights1 : listOfRights1) {
										if (autoRights1.getText().equalsIgnoreCase(b1)) {
											autoRights1.click();
										}
									}
								}
								QaRobot.ClickOnElement("CCRFareSelectClose");

							} else if (b.equalsIgnoreCase("B2B/Corporate")) {
								QaRobot.switchToWindow();
								QaRobot.ClickOnElement("CCRSub");
								QaRobot.ClickOnElement("CCRCarp");
								int p1 = Integer.parseInt(S_CQty);
								for (int k = 1; k <= p1; k++) {
									String[] tN1 = Subagent_Corporate.split(",");
									String b1 = tN1[k - 1];
									QaBrowser.driver.findElement(By.xpath("//input[@id='txtInputTextForSubagent']"))
											.clear();
									QaRobot.PassValue("CCRPassCorp", b1);
									List<WebElement> listOfRights1 = QaBrowser.driver
											.findElements(By.xpath("//select[@id='ListBoxSubagent']/option"));
									for (WebElement autoRights1 : listOfRights1) {
										if (autoRights1.getText().equalsIgnoreCase(b1)) {
											autoRights1.click();
											QaRobot.ClickOnElement("CCRAddCorp");
										}
									}
								}
								QaRobot.ClickOnElement("CCRSub_CarpSelectClose");
							}
						}
						QaExtentReport.extentScreenshot("Cancellation Charges Rule");
					}
				} else if (SelectProduct.equalsIgnoreCase("Hotel")) {
					int pAS = Integer.parseInt(CriteriaQty);
					if (CriteriaQty.equalsIgnoreCase("1")) {
						for (int i = 1; i <= pAS; i++) {
							String[] tN = CriteriaName.split(",");
							String b = tN[i - 1];
							QaRobot.selectTextByLocator("//select[@id='key1']", b);
							if (b.equalsIgnoreCase("Destination")) {
								QaRobot.switchToWindow();
								if (DestinationFor.equalsIgnoreCase("Zone")) {
									QaRobot.ClickOnElement("IMZone");
									QaRobot.transferData(Zqty, Zone, "//select[@id='ListBoxZone']/option");
								} else if (DestinationFor.equalsIgnoreCase("Region")) {
									QaRobot.ClickOnElement("IMRegion");
									QaRobot.transferData(Rqty, Region, "//select[@id='ListBoxRegion']/option");
								} else if (DestinationFor.equalsIgnoreCase("Country")) {
									QaRobot.ClickOnElement("IMCountry");
									QaRobot.transferDataWithPassValue(Cqty, Country, "//input[@id='txtSearch']",
											"//div[@id='divSearch']/p");
								} else if (DestinationFor.equalsIgnoreCase("City")) {
									QaRobot.ClickOnElement("IMCity");
									QaRobot.transferDataWithPassValue(CiQty, City, "//input[@id='txtSearch']",
											"//div[@id='divSearch']/p");
								} else if (DestinationFor.equalsIgnoreCase("Airport")) {
									QaRobot.ClickOnElement("IMAirport");
									QaRobot.transferDataWithPassValue(Aqty, Airport, "//input[@id='txtSearch']",
											"//div[@id='divSearch']/p");
								}
								QaRobot.ClickOnElement("IMDestinationSaveClose");

							} else if (b.equalsIgnoreCase("Base Fare")) {
								QaRobot.switchToWindow();
								QaRobot.PassValue("CCRBaseFareFrom", BaseFareFrom);
								QaRobot.PassValue("CCRBaseFareTo", BaseFareTo);
								QaRobot.ClickOnElement("CCRBaseFareSelectClose");

							} else if (b.equalsIgnoreCase("B2B/Corporate")) {
								QaRobot.switchToWindow();
								QaRobot.ClickOnElement("CCRSub");
								QaRobot.ClickOnElement("CCRCarp");
								int p1 = Integer.parseInt(S_CQty);
								for (int k = 1; k <= p1; k++) {
									String[] tN1 = Subagent_Corporate.split(",");
									String b1 = tN1[k - 1];
									QaBrowser.driver.findElement(By.xpath("//input[@id='txtInputTextForSubagent']"))
											.clear();
									QaRobot.PassValue("CCRPassCorp", b1);
									List<WebElement> listOfRights1 = QaBrowser.driver
											.findElements(By.xpath("//select[@id='ListBoxSubagent']/option"));
									for (WebElement autoRights1 : listOfRights1) {
										if (autoRights1.getText().equalsIgnoreCase(b1)) {
											autoRights1.click();
											QaRobot.ClickOnElement("CCRAddCorp");
										}
									}
								}
								QaRobot.ClickOnElement("CCRSub_CarpSelectClose");
							}
						}
					} else {
						for (int i = 1; i <= pAS; i++) {
							String[] tN = CriteriaName.split(",");
							String b = tN[i - 1];
							String s = Integer.toString(i);
							if (s.equalsIgnoreCase("1")) {
								QaRobot.selectTextByLocator("//select[@id='key1']", b);
							} else {
								QaRobot.ClickOnElement("IMAddNewCriteria");
								QaRobot.selectTextByLocator("//select[@id='key" + i + "']", b);
							}
							if (b.equalsIgnoreCase("Destination")) {
								QaRobot.switchToWindow();
								if (DestinationFor.equalsIgnoreCase("Zone")) {
									QaRobot.ClickOnElement("IMZone");
									QaRobot.transferData(Zqty, Zone, "//select[@id='ListBoxZone']/option");
								} else if (DestinationFor.equalsIgnoreCase("Region")) {
									QaRobot.ClickOnElement("IMRegion");
									QaRobot.transferData(Rqty, Region, "//select[@id='ListBoxRegion']/option");
								} else if (DestinationFor.equalsIgnoreCase("Country")) {
									QaRobot.ClickOnElement("IMCountry");
									QaRobot.transferDataWithPassValue(Cqty, Country, "//input[@id='txtSearch']",
											"//div[@id='divSearch']/p");
								} else if (DestinationFor.equalsIgnoreCase("City")) {
									QaRobot.ClickOnElement("IMCity");
									QaRobot.transferDataWithPassValue(CiQty, City, "//input[@id='txtSearch']",
											"//div[@id='divSearch']/p");
								} else if (DestinationFor.equalsIgnoreCase("Airport")) {
									QaRobot.ClickOnElement("IMAirport");
									QaRobot.transferDataWithPassValue(Aqty, Airport, "//input[@id='txtSearch']",
											"//div[@id='divSearch']/p");
								}
								QaRobot.ClickOnElement("IMDestinationSaveClose");

							} else if (b.equalsIgnoreCase("Base Fare")) {
								QaRobot.switchToWindow();
								QaRobot.PassValue("CCRBaseFareFrom", BaseFareFrom);
								QaRobot.PassValue("CCRBaseFareTo", BaseFareTo);
								QaRobot.ClickOnElement("CCRBaseFareSelectClose");

							} else if (b.equalsIgnoreCase("B2B/Corporate")) {
								QaRobot.switchToWindow();
								QaRobot.ClickOnElement("CCRSub");
								QaRobot.ClickOnElement("CCRCarp");
								int p1 = Integer.parseInt(S_CQty);
								for (int k = 1; k <= p1; k++) {
									String[] tN1 = Subagent_Corporate.split(",");
									String b1 = tN1[k - 1];
									QaBrowser.driver.findElement(By.xpath("//input[@id='txtInputTextForSubagent']"))
											.clear();
									QaRobot.PassValue("CCRPassCorp", b1);
									List<WebElement> listOfRights1 = QaBrowser.driver
											.findElements(By.xpath("//select[@id='ListBoxSubagent']/option"));
									for (WebElement autoRights1 : listOfRights1) {
										if (autoRights1.getText().equalsIgnoreCase(b1)) {
											autoRights1.click();
											QaRobot.ClickOnElement("CCRAddCorp");
										}
									}
								}
								QaRobot.ClickOnElement("CCRSub_CarpSelectClose");
							}
						}
					}
				}
				QaExtentReport.extentScreenshot("Cancellation Charges Rule");
				if (SelectProduct.equalsIgnoreCase("Flight")) {
					int Cq = Integer.parseInt(ChargesQty);
					for (int i = 1; i <= Cq; i++) {
						String Charge[] = Charges.split(",");
						String Fe[] = Fees.split(",");
						String a1 = Fe[i - 1];
						String Am[] = Amount.split(",");
						String a2 = Am[i - 1];
						String Ao[] = CAppliedOn.split(",");
						String a3 = Ao[i - 1];
						String currentCharges = "00";
						if (Charge[i - 1].equalsIgnoreCase("Cancellation Fees-Before Departure")) {
							currentCharges = "1";
						} else if (Charge[i - 1].equalsIgnoreCase("Cancellation Fees-After Departure")) {
							currentCharges = "2";
						} else if (Charge[i - 1].equalsIgnoreCase("Rescheduling Fees-Before Departure")) {
							currentCharges = "3";
						} else if (Charge[i - 1].equalsIgnoreCase("Rescheduling Fees-After Departure")) {
							currentCharges = "4";
						} else if (Charge[i - 1].equalsIgnoreCase("Company Cancellation Fees")) {
							currentCharges = "5";
						} else if (Charge[i - 1].equalsIgnoreCase("Company Rescheduling Fees")) {
							currentCharges = "6";
						} else if (Charge[i - 1].equalsIgnoreCase("Rerouting")) {
							currentCharges = "7";
						} else if (Charge[i - 1].equalsIgnoreCase("No Show Charge")) {
							currentCharges = "8";
						}
						int c = Integer.parseInt(currentCharges);
						QaBrowser.driver.findElement(By.xpath(
								"(/html/body/form/div[5]/table[2]/tbody/tr/td[1]/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[2]/td/div[1]/fieldset[1]/table/tbody/tr[4]/td/fieldset/table/tbody/tr/td/input)["
										+ c + "]"))
								.sendKeys(a1);
						WebElement element = QaBrowser.driver.findElement(By.xpath(
								"(/html/body/form/div[5]/table[2]/tbody/tr/td[1]/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[2]/td/div[1]/fieldset[1]/table/tbody/tr[4]/td/fieldset/table/tbody/tr/td[5]/select)["
										+ c + "]"));
						Select s = new Select(element);
						s.selectByVisibleText(a2);
						WebElement element1 = QaBrowser.driver.findElement(By.xpath(
								"(/html/body/form/div[5]/table[2]/tbody/tr/td[1]/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[2]/td/div[1]/fieldset[1]/table/tbody/tr[4]/td/fieldset/table/tbody/tr/td[7]/select)["
										+ c + "]"));
						Select s1 = new Select(element1);
						s1.selectByVisibleText(a3);
					}
					QaRobot.PassValue("CCRCancellationRemarkF", CancellationRemark);
				} else if (SelectProduct.equalsIgnoreCase("Hotel")) {
//					QaRobot.PassValue("CCRCancellationFeeH", CancellationFee);
//					QaRobot.selectTextFromDropdown("CCRCancellationFeeAmount", CancellationFeeAmount, "");
//					QaRobot.selectTextFromDropdown("CCRCancellationFeeOn", CancellationFeeAppliedOn, "");
//					QaRobot.PassValue("CCRCancellationRemarkH", CancellationRemark);
				}
				QaExtentReport.extentScreenshot("Cancellation Charges Rule");
				QaRobot.scrollPage(-1500);
				Thread.sleep(3000);
				QaRobot.ClickOnElement("CCRSave");
				QaBrowser.driver.switchTo().defaultContent();
				QaRobot.switchframe("//frame[@name='login']");
				QaRobot.switchframe("//frame[@name='leftbar']");
			}
			if (BrandInformation.equalsIgnoreCase("Yes")) {
				if (CreateCancellationChargeRule.equalsIgnoreCase("No")) {
					QaRobot.ClickOnElement("Administation");
					Thread.sleep(3000);
				}
				QaRobot.ClickOnElement("SupplierCrediantials");
				QaBrowser.driver.switchTo().parentFrame();
				QaRobot.switchframe("//frame[@name='main']");
				QaRobot.switchframe("//frame[@id='toolHeader']");
				WebElement mainMenu = QaBrowser.driver.findElement(By.xpath("//td[@id='tdAirlineMgmt']/a"));
				mainMenu.click();
				QaBrowser.driver.switchTo().parentFrame();
				QaRobot.switchframe("//frame[@id='frm2']");
				if (Source.equalsIgnoreCase("sbt")) {
					WebElement subMenu = QaBrowser.driver
							.findElement(By.xpath("(/html/body/div/div/table/tbody/tr[15]/td)[1]"));
					subMenu.click();
				} else if (Source.equalsIgnoreCase("preprod117")) {
					WebElement subMenu = QaBrowser.driver
							.findElement(By.xpath("(/html/body/div/div/table/tbody/tr[17]/td)[1]"));
					subMenu.click();
				} else if (Source.equalsIgnoreCase("Live")) {
					WebElement subMenu = QaBrowser.driver
							.findElement(By.xpath("(/html/body/div/div/table/tbody/tr[15]/td)[1]"));
					subMenu.click();
				}
				QaExtentReport.extentScreenshot("Brand Informations");
				QaRobot.ClickOnElement("AddNewBrandInfo");
				QaRobot.PassValue("BITitle", Title);
				TestBase.listofautosuggestion(By.xpath("//div[@id='divAirCity']/p"), Airline, Airline,
						By.xpath("//input[@id='txtAirline']"));
				QaRobot.selectTextFromDropdown("CabinClass", BICabinClass, "");
				String ParentWindow = QaBrowser.driver.getWindowHandle();
				QaRobot.ClickOnElement("AddBookingClass");
				Set<String> handles = QaBrowser.driver.getWindowHandles();
				for (String childWindow : handles) {
					if (!childWindow.equals(ParentWindow))
						QaBrowser.driver.switchTo().window(childWindow);
				}
				int pAS1 = Integer.parseInt(BookingClassQty);
				for (int k = 1; k <= pAS1; k++) {
					String[] tN1 = BIBookingClass.split(",");
					String b1 = tN1[k - 1];
					List<WebElement> listOfRights1 = QaBrowser.driver.findElements(
							By.xpath("/html/body/div/div/div/div/div/div/div/div[1]/div[1]/select/option"));
					for (WebElement autoRights1 : listOfRights1) {
						if (autoRights1.getText().equalsIgnoreCase(b1)) {
							autoRights1.click();
							QaRobot.ClickOnElement("AddClass");
						}
					}
				}
				QaRobot.ClickOnElement("ClassSelectClose");
				QaRobot.selectTextFromDropdown("BIMarketType", BIMarketType, "MarketType");
				Thread.sleep(3000);
				QaRobot.PassValue("BIBrandName", BrandName);
				Thread.sleep(3000);
				QaExtentReport.extentScreenshot("Brand Information Page");
				String a = BrandDetails1;
				String b = BrandDetails2;
				int TotalNo = a.length() + b.length();
				System.out.println(TotalNo);
				if (TotalNo <= 50000) {
					String BD = BrandDetails1 + BrandDetails2;
					System.out.println(BD);
					QaRobot.PassValue("BIBrandDetails", BD);
				} else {
					QaExtentReport.test.log(Status.INFO,
							"<b><i>" + "Total number of character provided is " + TotalNo + "</i></b>");
					Assert.assertTrue(TotalNo <= 50000, "Please check text,Text characters should not more than 50000");
				}
				QaRobot.scrollPage(1000);
				QaRobot.PassValue("BIChooseFile", BIUploadImage);
				int pAS2 = Integer.parseInt(BISalesChannelQty);
				for (int k = 1; k <= pAS2; k++) {
					String[] tN1 = BISalesChannel.split(",");
					String b1 = tN1[k - 1];
					List<WebElement> listOfRights1 = QaBrowser.driver
							.findElements(By.xpath("//table[@id='chkbxSalesChanel']/tbody/tr/td/label"));
					for (WebElement autoRights1 : listOfRights1) {
						if (autoRights1.getText().equalsIgnoreCase(b1)) {
							System.out.println(autoRights1.getText());
							autoRights1.click();
						}
					}
				}
				QaExtentReport.extentScreenshot("Brand Information Page");
				QaRobot.ClickOnElement("BISave");
				Thread.sleep(3000);
				QaRobot.alertAccept();
				Thread.sleep(3000);
				QaRobot.ClickOnElement("BBrandKeyInformation");
				Thread.sleep(3000);
				int Qk = Integer.parseInt(KIQty);
				for (int i = 1; i <= Qk; i++) {
					String[] tK = KeyInformation.split(",");
					String k = tK[i - 1];
					QaRobot.selectTextFromDropdown("BIKeyInformation", k, "KeyInformation");
					String[] tN = BINotes.split(",");
					String n = tN[i - 1];
					QaRobot.PassValue("BINotes", n);
					QaRobot.ClickOnElement("BBAdd");
					Thread.sleep(3000);
				}
				QaRobot.scrollPage(200);
				Thread.sleep(3000);
				QaExtentReport.extentScreenshot("Brand Key Information Page");
				QaRobot.ClickOnElement("BISave");
				QaExtentReport.test.log(Status.INFO, QaBrowser.driver.switchTo().alert().getText());
				QaRobot.alertAccept();
				QaBrowser.driver.switchTo().defaultContent();
				QaRobot.switchframe("//frame[@name='login']");
				QaRobot.switchframe("//frame[@name='leftbar']");
			}
			if (PreferredAirline.equalsIgnoreCase("Yes")) {
				QaRobot.ClickOnElement("CorporateManagement");
				Thread.sleep(3000);
				QaRobot.ClickOnElement("SearchCorporate");
				QaBrowser.driver.switchTo().parentFrame();
				QaRobot.switchframe("//frame[@name='main']");
				QaRobot.switchframe("//frame[@id='frm2']");
				QaRobot.PassValue("CompanyName", PACorporateName);
				QaRobot.ClickOnElement("SearchCompanyName");
				QaExtentReport.test.log(Status.INFO, "<b><i>Corporate Name</i></b>" + " - " + CorporateName);
				String AccountId = QaBrowser.driver.findElement(By.xpath("//span[@id='GridView1_ctl02_Label2']"))
						.getText();
				QaExtentReport.test.log(Status.INFO, "<b><i>Account Id</i></b>" + " - " + AccountId);
				QaRobot.ClickOnElement("ClickOnSearchCompanyName");
				QaBrowser.driver.switchTo().parentFrame();
				QaRobot.switchframe("//frame[@id='toolHeader']");
				QaRobot.ClickOnElement("CPCorporateManagement");
				QaBrowser.driver.switchTo().parentFrame();
				QaRobot.switchframe("//frame[@id='frm2']");
				QaRobot.ClickOnElement("PreferredAirline");
				QaRobot.ClickOnElement("Add_PreferredAirline");
				int pAS2 = Integer.parseInt(PAPAirQty);
				for (int k = 1; k <= pAS2; k++) {
					String[] tN1 = PAPAirlines.split(",");
					String b1 = tN1[k - 1];
					QaBrowser.driver
							.findElement(By.xpath(
									"//div[@id='genpro']/div/div/div/div[2]/div[1]/div/span/span[1]/span/ul/li/input"))
							.clear();
					QaRobot.PassValue("PAAddAirline", b1);
					List<WebElement> listOfRights1 = QaBrowser.driver
							.findElements(By.xpath("/html/body/span/span/span/ul/li"));
					for (WebElement autoRights1 : listOfRights1) {
						if (autoRights1.getText().equalsIgnoreCase(b1)) {
							autoRights1.click();
							break;
						}
					}
				}
				if (OriginType.equalsIgnoreCase("Country")) {
					QaRobot.ClickOnElement("PAOCountry");
					TestBase.listofautosuggestion(By.xpath("//div[@id='divCity']/p"), OCo, PAOCountry,
							By.xpath("//input[@id='txtOrgin']"));
				} else if (OriginType.equalsIgnoreCase("City")) {
					QaRobot.ClickOnElement("PAOCity");
					TestBase.listofautosuggestion(By.xpath("//div[@id='divCity']/p"), OCi, PAOCity,
							By.xpath("//input[@id='txtOrgin']"));
				} else if (OriginType.equalsIgnoreCase("AirPort")) {
					QaRobot.ClickOnElement("PAOAirPort");
					TestBase.listofautosuggestion(By.xpath("//div[@id='divCity']/p"), OAirP, OAirPort,
							By.xpath("//input[@id='txtOrgin']"));
				}
				if (DestinationType.equalsIgnoreCase("Country")) {
					QaRobot.ClickOnElement("PADCountry");
					TestBase.listofautosuggestion(By.xpath("//div[@id='divCity1']/p"), DCo, PADCountry,
							By.xpath("//input[@id='txtDestination']"));
				} else if (DestinationType.equalsIgnoreCase("City")) {
					QaRobot.ClickOnElement("PADCity");
					TestBase.listofautosuggestion(By.xpath("//div[@id='divCity1']/p"), DCi, PADCity,
							By.xpath("//input[@id='txtDestination']"));
				} else if (DestinationType.equalsIgnoreCase("AirPort")) {
					QaRobot.ClickOnElement("PADAirPort");
					TestBase.listofautosuggestion(By.xpath("//div[@id='divCity1']/p"), DAirP, DAirPort,
							By.xpath("//input[@id='txtDestination']"));
				}
				int pAS = Integer.parseInt(Co_BranchQty);
				for (int k = 1; k <= pAS; k++) {
					String[] tN1 = Corporate_Branch.split(",");
					String b1 = tN1[k - 1];
					QaBrowser.driver
							.findElement(By.xpath(
									"//div[@id='genpro']/div/div/div/div[2]/div[6]/div/span/span[1]/span/ul/li/input"))
							.clear();
					QaRobot.PassValue("SelectCoBranch", b1);
					List<WebElement> listOfRights1 = QaBrowser.driver
							.findElements(By.xpath("/html/body/span/span/span/ul/li"));
					for (WebElement autoRights1 : listOfRights1) {
						if (autoRights1.getText().equalsIgnoreCase(b1)) {
							autoRights1.click();
							break;
						}
					}
				}
				Thread.sleep(3000);
				QaExtentReport.extentScreenshot("Preferred Airline");
				QaRobot.ClickOnElement("PreferredAirlineSave");
				QaBrowser.driver.switchTo().defaultContent();
				QaRobot.switchframe("//frame[@name='login']");
				QaRobot.switchframe("//frame[@name='leftbar']");
			}
			if (CreatePolicy.equalsIgnoreCase("Yes")) {
				if (PreferredAirline.equalsIgnoreCase("No")) {
					QaRobot.ClickOnElement("CorporateManagement");
					Thread.sleep(3000);
				}
				QaRobot.ClickOnElement("SearchCorporate");
				QaBrowser.driver.switchTo().parentFrame();
				QaRobot.switchframe("//frame[@name='main']");
				QaRobot.switchframe("//frame[@id='frm2']");
				QaRobot.PassValue("CompanyName", CorporateName);
				QaRobot.ClickOnElement("SearchCompanyName");
				QaExtentReport.test.log(Status.INFO, "<b><i>Corporate Name</i></b>" + " - " + CorporateName);
				String AccountId = QaBrowser.driver.findElement(By.xpath("//span[@id='GridView1_ctl02_Label2']"))
						.getText();
				QaExtentReport.test.log(Status.INFO, "<b><i>Account Id</i></b>" + " - " + AccountId);
				QaRobot.ClickOnElement("ClickOnSearchCompanyName");
				QaBrowser.driver.switchTo().parentFrame();
				QaRobot.switchframe("//frame[@id='toolHeader']");
				QaRobot.ClickOnElement("CPCorporateManagement");
				QaBrowser.driver.switchTo().parentFrame();
				QaRobot.switchframe("//frame[@id='frm2']");
				QaRobot.ClickOnElement("ManagetravelpolicyP");
				QaRobot.ClickOnElement("Add_Policy");
				QaRobot.PassValue("TravelPolicyTitle", TravelPolicyTitle);
				if (Travelpurpose.equalsIgnoreCase("Business")) {
					WebElement element = QaBrowser.driver.findElement(By.xpath("//input[@id='radioBussinessTrip']"));
					JavascriptExecutor executor = (JavascriptExecutor) QaBrowser.driver;
					executor.executeScript("arguments[0].click();", element);
				} else if (Travelpurpose.equalsIgnoreCase("Family")) {
					WebElement element = QaBrowser.driver.findElement(By.xpath("//input[@id='radioAnnualFamilyTrip']"));
					JavascriptExecutor executor = (JavascriptExecutor) QaBrowser.driver;
					executor.executeScript("arguments[0].click();", element);
				} else if (Travelpurpose.equalsIgnoreCase("Guest")) {
					WebElement element = QaBrowser.driver.findElement(By.xpath("//input[@id='radioguest']"));
					JavascriptExecutor executor = (JavascriptExecutor) QaBrowser.driver;
					executor.executeScript("arguments[0].click();", element);
				}
				QaRobot.selectTextFromDropdown("SelectTravelCategory", TravelCategory);
				QaRobot.selectTextFromDropdown("SelectProduct", Product);
				QaRobot.selectTextFromDropdown("RuleAppliedOn", RuleAppliedOn);
				Thread.sleep(3000);
				int pAS = Integer.parseInt(SelectQty);
				for (int i = 1; i <= pAS; i++) {
					String[] tN = SelectFromList.split(",");
					String b = tN[i - 1];
					List<WebElement> listOfRights = QaBrowser.driver.findElements(By.xpath(
							"/html/body/div/form/div[5]/div/div/div[2]/div[3]/div[2]/div/div/div/div[4]/div[3]/div/div/div/div/div/select/option"));
					for (WebElement autoRights : listOfRights) {
						if (autoRights.getText().equalsIgnoreCase(b)) {
							autoRights.click();
							QaRobot.ClickOnElement("AddList");
						}
					}
				}
				Thread.sleep(3000);
				if (Product.equalsIgnoreCase("Flight")) {
					int pAS1 = Integer.parseInt(PCriteriaQty);
					if (PCriteriaQty.equalsIgnoreCase("1")) {
						for (int i = 1; i <= pAS1; i++) {
							String[] tN = PCriteriaName.split(",");
							String b = tN[i - 1];
							QaRobot.selectTextByLocator("//select[@id='grdFlight_ctl02_ddlFlightKey']", b);
							if (b.equalsIgnoreCase("Airline Criteria")) {
								QaRobot.switchToWindow();
								int pAS2 = Integer.parseInt(PAirQty);
								for (int k = 1; k <= pAS2; k++) {
									String[] tN1 = PAirlines.split(",");
									String b1 = tN1[k - 1];
									QaBrowser.driver.findElement(By.xpath("//input[@id='txtAirline']")).clear();
									QaRobot.PassValue("PassAirline", b1);
									List<WebElement> listOfRights1 = QaBrowser.driver
											.findElements(By.xpath("//select[@id='ListBoxAirlineFiller']/option"));
									for (WebElement autoRights1 : listOfRights1) {
										if (autoRights1.getText().equalsIgnoreCase(b1)) {
											autoRights1.click();
											QaRobot.ClickOnElement("IMAddAirline");
											break;
										}
									}
								}
								QaRobot.ClickOnElement("PSelect&close");

							} else if (b.equalsIgnoreCase("Booking Date")) {
//								QaRobot.switchToWindow();
//								QaRobot.ClickOnElement("Bookingdatefrom");
//								String DateSelection[] = BookDateFrom.split("-");
//								String year = DateSelection[2];
//								String month = DateSelection[1];
//								String expDate = DateSelection[0];
//								QaRobot.selectDateInCalendarIM(expDate, month, year);
//								QaRobot.ClickOnElement("BookingdateTo");
//								String DateSelection1[] = BookDateTo.split("-");
//								String year1 = DateSelection1[2];
//								String month1 = DateSelection1[1];
//								String expDate1 = DateSelection1[0];
//								QaRobot.selectDateInCalendarIM(expDate1, month1, year1);
//								QaRobot.ClickOnElement("AddBookDate");
//								QaRobot.ClickOnElement("IMBookDateSelectClose");

							} else if (b.equalsIgnoreCase("Trip Date")) {
//								QaRobot.switchToWindow();
//								QaRobot.ClickOnElement("TripDateFrom");
//								String DateSelection[] = TripDateFrom.split("-");
//								String year = DateSelection[2];
//								String month = DateSelection[1];
//								String expDate = DateSelection[0];
//								QaRobot.selectDateInCalendarIM(expDate, month, year);
//								QaRobot.ClickOnElement("TripDateTo");
//								String DateSelection1[] = TripDateTo.split("-");
//								String year1 = DateSelection1[2];
//								String month1 = DateSelection1[1];
//								String expDate1 = DateSelection1[0];
//								QaRobot.selectDateInCalendarIM(expDate1, month1, year1);
//								QaRobot.ClickOnElement("AddTripDate");
//								QaRobot.ClickOnElement("IMTripDateSelectClose");

							} else if (b.equalsIgnoreCase("Origin")) {
								QaRobot.switchToWindow();
								if (POriginFor.equalsIgnoreCase("Zone")) {
									QaRobot.ClickOnElement("SOZone");
									QaRobot.transferData(POZqty, POZone, "//select[@id='ListBoxOriginZone']/option");
									QaRobot.ClickOnElement("SOAdd");
								} else if (POriginFor.equalsIgnoreCase("Region")) {
									QaRobot.ClickOnElement("SORegion");
									QaRobot.transferData(PORqty, PORegion,
											"//select[@id='ListBoxOriginRegion']/option");
									QaRobot.ClickOnElement("SOAdd");
								} else if (POriginFor.equalsIgnoreCase("Country")) {
									QaRobot.ClickOnElement("SOZone");
									QaRobot.transferData(POZqty, POZone, "//select[@id='ListBoxOriginZone']/option");
									QaRobot.ClickOnElement("SOCountry");
									QaRobot.transferData(POCqty, POCountry,
											"//select[@id='ListBoxOriginCountry']/option");
									QaRobot.ClickOnElement("SOAdd");
								} else if (POriginFor.equalsIgnoreCase("City")) {
									QaRobot.ClickOnElement("SOZone");
									QaRobot.transferData(POZqty, POZone, "//select[@id='ListBoxOriginZone']/option");
									QaRobot.ClickOnElement("SOCountry");
									QaRobot.transferData(POCqty, POCountry,
											"//select[@id='ListBoxOriginCountry']/option");
									QaRobot.ClickOnElement("SOCity");
									QaRobot.transferData(POCiQty, POCity, "//select[@id='ListBoxOriginCity']/option");
									QaRobot.ClickOnElement("SOAdd");
								}
								QaRobot.ClickOnElement("OriginSaveClose");

							} else if (b.equalsIgnoreCase("Destination")) {
								QaRobot.switchToWindow();
								if (PDestinationFor.equalsIgnoreCase("Zone")) {
									QaRobot.ClickOnElement("SDZone");
									QaRobot.transferData(DZqty, DZone, "//select[@id='ListBoxDestinationZone']/option");
									QaRobot.ClickOnElement("SDAdd");
								} else if (PDestinationFor.equalsIgnoreCase("Region")) {
									QaRobot.ClickOnElement("SDRegion");
									QaRobot.transferData(DRqty, DRegion,
											"//select[@id='ListBoxDestinationRegion']/option");
									QaRobot.ClickOnElement("SDAdd");
								} else if (PDestinationFor.equalsIgnoreCase("Country")) {
									QaRobot.ClickOnElement("SDZone");
									QaRobot.transferData(DZqty, DZone, "//select[@id='ListBoxDestinationZone']/option");
									QaRobot.ClickOnElement("SDCountry");
									QaRobot.transferData(DCqty, DCountry,
											"//select[@id='ListBoxDestinationCountry']/option");
									QaRobot.ClickOnElement("SDAdd");
								} else if (PDestinationFor.equalsIgnoreCase("City")) {
									QaRobot.ClickOnElement("SDZone");
									QaRobot.transferData(DZqty, DZone, "//select[@id='ListBoxDestinationZone']/option");
									QaRobot.ClickOnElement("SDCountry");
									QaRobot.transferData(DCqty, DCountry,
											"//select[@id='ListBoxDestinationCountry']/option");
									QaRobot.ClickOnElement("SDCity");
									QaRobot.transferData(DCiQty, DCity,
											"//select[@id='ListBoxDestinationCity']/option");
									QaRobot.ClickOnElement("SDAdd");
								}
								QaRobot.ClickOnElement("DestinationSaveClose");
							} else if (b.equalsIgnoreCase("Cost Range")) {
								QaRobot.switchToWindow();
								QaRobot.PassValue("CostFrom", CostFrom);
								QaRobot.PassValue("CostTo", CostTo);
								QaRobot.ClickOnElement("CostRangeSelectClose");
							} else if (b.equalsIgnoreCase("Market Type")) {
								QaRobot.switchToWindow();
								if (MarketType.equalsIgnoreCase("Domestic")) {
									QaRobot.ClickOnElement("MARDomestic");
								} else if (MarketType.equalsIgnoreCase("International")) {
									QaRobot.ClickOnElement("MARInternational");
								}
								QaRobot.ClickOnElement("MARSaveClose");
							}
						}

					} else {
						for (int i = 1; i <= pAS1; i++) {
							String[] tN = PCriteriaName.split(",");
							String b = tN[i - 1];
							String s = Integer.toString(i);
							if (s.equalsIgnoreCase("1")) {
								QaRobot.selectTextByLocator("//select[@id='grdFlight_ctl02_ddlFlightKey']", b);
							} else {
								Thread.sleep(3000);
								QaRobot.ClickOnElement("SAddNewCriteriaFlight");
								QaRobot.selectTextByLocator(
										"//select[@id='grdFlight_ctl0" + (i + 1) + "_ddlFlightKey']", b);
							}
							if (b.equalsIgnoreCase("Airline Criteria")) {
								QaRobot.switchToWindow();
								int pAS2 = Integer.parseInt(PAirQty);
								for (int k = 1; k <= pAS2; k++) {
									String[] tN1 = PAirlines.split(",");
									String b1 = tN1[k - 1];
									QaBrowser.driver.findElement(By.xpath("//input[@id='txtAirline']")).clear();
									QaRobot.PassValue("PassAirline", b1);
									List<WebElement> listOfRights1 = QaBrowser.driver
											.findElements(By.xpath("//select[@id='ListBoxAirlineFiller']/option"));
									for (WebElement autoRights1 : listOfRights1) {
										if (autoRights1.getText().equalsIgnoreCase(b1)) {
											autoRights1.click();
											QaRobot.ClickOnElement("IMAddAirline");
											break;
										}
									}
								}
								QaRobot.ClickOnElement("PSelect&close");

							} else if (b.equalsIgnoreCase("Booking Date")) {
//								QaRobot.switchToWindow();
//								QaRobot.ClickOnElement("Bookingdatefrom");
//								String DateSelection[] = BookDateFrom.split("-");
//								String year = DateSelection[2];
//								String month = DateSelection[1];
//								String expDate = DateSelection[0];
//								QaRobot.selectDateInCalendarIM(expDate, month, year);
//								QaRobot.ClickOnElement("BookingdateTo");
//								String DateSelection1[] = BookDateTo.split("-");
//								String year1 = DateSelection1[2];
//								String month1 = DateSelection1[1];
//								String expDate1 = DateSelection1[0];
//								QaRobot.selectDateInCalendarIM(expDate1, month1, year1);
//								QaRobot.ClickOnElement("AddBookDate");
//								QaRobot.ClickOnElement("IMBookDateSelectClose");

							} else if (b.equalsIgnoreCase("Trip Date")) {
//								QaRobot.switchToWindow();
//								QaRobot.ClickOnElement("TripDateFrom");
//								String DateSelection[] = TripDateFrom.split("-");
//								String year = DateSelection[2];
//								String month = DateSelection[1];
//								String expDate = DateSelection[0];
//								QaRobot.selectDateInCalendarIM(expDate, month, year);
//								QaRobot.ClickOnElement("TripDateTo");
//								String DateSelection1[] = TripDateTo.split("-");
//								String year1 = DateSelection1[2];
//								String month1 = DateSelection1[1];
//								String expDate1 = DateSelection1[0];
//								QaRobot.selectDateInCalendarIM(expDate1, month1, year1);
//								QaRobot.ClickOnElement("AddTripDate");
//								QaRobot.ClickOnElement("IMTripDateSelectClose");

							} else if (b.equalsIgnoreCase("Origin")) {
								QaRobot.switchToWindow();
								if (POriginFor.equalsIgnoreCase("Zone")) {
									QaRobot.ClickOnElement("SOZone");
									QaRobot.transferData(POZqty, POZone, "//select[@id='ListBoxOriginZone']/option");
									QaRobot.ClickOnElement("SOAdd");
								} else if (POriginFor.equalsIgnoreCase("Region")) {
									QaRobot.ClickOnElement("SORegion");
									QaRobot.transferData(PORqty, PORegion,
											"//select[@id='ListBoxOriginRegion']/option");
									QaRobot.ClickOnElement("SOAdd");
								} else if (POriginFor.equalsIgnoreCase("Country")) {
									QaRobot.ClickOnElement("SOZone");
									QaRobot.transferData(POZqty, POZone, "//select[@id='ListBoxOriginZone']/option");
									QaRobot.ClickOnElement("SOCountry");
									QaRobot.transferData(POCqty, POCountry,
											"//select[@id='ListBoxOriginCountry']/option");
									QaRobot.ClickOnElement("SOAdd");
								} else if (POriginFor.equalsIgnoreCase("City")) {
									QaRobot.ClickOnElement("SOZone");
									QaRobot.transferData(POZqty, POZone, "//select[@id='ListBoxOriginZone']/option");
									QaRobot.ClickOnElement("SOCountry");
									QaRobot.transferData(POCqty, POCountry,
											"//select[@id='ListBoxOriginCountry']/option");
									QaRobot.ClickOnElement("SOCity");
									QaRobot.transferData(POCiQty, POCity, "//select[@id='ListBoxOriginCity']/option");
									QaRobot.ClickOnElement("SOAdd");
								}
								QaRobot.ClickOnElement("OriginSaveClose");

							} else if (b.equalsIgnoreCase("Destination")) {
								QaRobot.switchToWindow();
								if (PDestinationFor.equalsIgnoreCase("Zone")) {
									QaRobot.ClickOnElement("SDZone");
									QaRobot.transferData(DZqty, DZone, "//select[@id='ListBoxDestinationZone']/option");
									QaRobot.ClickOnElement("SDAdd");
								} else if (PDestinationFor.equalsIgnoreCase("Region")) {
									QaRobot.ClickOnElement("SDRegion");
									QaRobot.transferData(DRqty, DRegion,
											"//select[@id='ListBoxDestinationRegion']/option");
									QaRobot.ClickOnElement("SDAdd");
								} else if (PDestinationFor.equalsIgnoreCase("Country")) {
									QaRobot.ClickOnElement("SDZone");
									QaRobot.transferData(DZqty, DZone, "//select[@id='ListBoxDestinationZone']/option");
									QaRobot.ClickOnElement("SDCountry");
									QaRobot.transferData(DCqty, DCountry,
											"//select[@id='ListBoxDestinationCountry']/option");
									QaRobot.ClickOnElement("SDAdd");
								} else if (PDestinationFor.equalsIgnoreCase("City")) {
									QaRobot.ClickOnElement("SDZone");
									QaRobot.transferData(DZqty, DZone, "//select[@id='ListBoxDestinationZone']/option");
									QaRobot.ClickOnElement("SDCountry");
									QaRobot.transferData(DCqty, DCountry,
											"//select[@id='ListBoxDestinationCountry']/option");
									QaRobot.ClickOnElement("SDCity");
									QaRobot.transferData(DCiQty, DCity,
											"//select[@id='ListBoxDestinationCity']/option");
									QaRobot.ClickOnElement("SDAdd");
								}
								QaRobot.ClickOnElement("DestinationSaveClose");

							} else if (b.equalsIgnoreCase("Cost Range")) {
								QaRobot.switchToWindow();
								QaRobot.PassValue("CostFrom", CostFrom);
								QaRobot.PassValue("CostTo", CostTo);
								QaRobot.ClickOnElement("CostRangeSelectClose");
							} else if (b.equalsIgnoreCase("Market Type")) {
								QaRobot.switchToWindow();
								if (MarketType.equalsIgnoreCase("Domestic")) {
									QaRobot.ClickOnElement("MARDomestic");
								} else if (MarketType.equalsIgnoreCase("International")) {
									QaRobot.ClickOnElement("MARInternational");
								}
								QaRobot.ClickOnElement("MARSaveClose");
							}
						}
					}
					Thread.sleep(3000);
					int pAS0 = Integer.parseInt(CabinQty);
					for (int k = 1; k <= pAS0; k++) {
						String[] tN = Cabins.split(",");
						String b = tN[k - 1];
						List<WebElement> listOfRights = QaBrowser.driver.findElements(
								By.xpath("//div[@id='divTitleCabinDetails']/div/div[2]/div/div/div/span/label"));
						for (WebElement autoRights : listOfRights) {
							if (autoRights.getText().equalsIgnoreCase(b)) {
								if (b.equalsIgnoreCase("Economy")) {
								} else {
									autoRights.click();
								}
							}
						}
					}
//					QaRobot.transferData(CabinQty, Cabins,
//							"//div[@id='divTitleCabinDetails']/div/div[2]/div/div/div/span/label");
					QaRobot.PassValue("PTextArea", OutPolicyReason);
					QaRobot.ClickOnElement("SaveFlightPolicy");
//					QaRobot.ClickOnElement("PClose");
					QaBrowser.driver.switchTo().defaultContent();
					QaRobot.switchframe("//frame[@name='login']");
					QaRobot.switchframe("//frame[@name='leftbar']");

				} else if (Product.equalsIgnoreCase("Hotel")) {

				} else if (Product.equalsIgnoreCase("Car")) {
					int pAS3 = Integer.parseInt(CriteriaQty);
					if (CriteriaQty.equalsIgnoreCase("1")) {
						for (int i = 1; i <= pAS3; i++) {
							String[] tN = CriteriaName.split(",");
							String b = tN[i - 1];
							QaRobot.selectTextByLocator("//select[@id='grdCar_ctl02_ddlCarKey']", b);
							if (b.equalsIgnoreCase("Origin")) {
								QaRobot.switchToWindow();
								if (OriginFor.equalsIgnoreCase("Zone")) {
									QaRobot.ClickOnElement("SOZone");
									QaRobot.transferData(OZqty, OZone, "//select[@id='ListBoxOriginZone']/option");
									QaRobot.ClickOnElement("SOAdd");
								} else if (OriginFor.equalsIgnoreCase("Region")) {
									QaRobot.ClickOnElement("SORegion");
									QaRobot.transferData(ORqty, ORegion, "//select[@id='ListBoxOriginRegion']/option");
									QaRobot.ClickOnElement("SOAdd");
								} else if (OriginFor.equalsIgnoreCase("Country")) {
									QaRobot.ClickOnElement("SOZone");
									QaRobot.transferData(OZqty, OZone, "//select[@id='ListBoxOriginZone']/option");
									QaRobot.ClickOnElement("SOCountry");
									QaRobot.transferData(OCqty, OCountry,
											"//select[@id='ListBoxOriginCountry']/option");
									QaRobot.ClickOnElement("SOAdd");
								} else if (OriginFor.equalsIgnoreCase("City")) {
									QaRobot.ClickOnElement("SOZone");
									QaRobot.transferData(OZqty, OZone, "//select[@id='ListBoxOriginZone']/option");
									QaRobot.ClickOnElement("SOCountry");
									QaRobot.transferData(OCqty, OCountry,
											"//select[@id='ListBoxOriginCountry']/option");
									QaRobot.ClickOnElement("SOCity");
									QaRobot.transferData(OCiQty, OCity, "//select[@id='ListBoxOriginCity']/option");
									QaRobot.ClickOnElement("SOAdd");
								}
								QaRobot.ClickOnElement("OriginSaveClose");
							} else if (b.equalsIgnoreCase("Destination")) {
								QaRobot.switchToWindow();
								if (DestinationFor.equalsIgnoreCase("Zone")) {
									QaRobot.ClickOnElement("SDZone");
									QaRobot.transferData(DZqty, DZone, "//select[@id='ListBoxDestinationZone']/option");
									QaRobot.ClickOnElement("SDAdd");
								} else if (DestinationFor.equalsIgnoreCase("Region")) {
									QaRobot.ClickOnElement("SDRegion");
									QaRobot.transferData(DRqty, DRegion,
											"//select[@id='ListBoxDestinationRegion']/option");
									QaRobot.ClickOnElement("SDAdd");
								} else if (DestinationFor.equalsIgnoreCase("Country")) {
									QaRobot.ClickOnElement("SDZone");
									QaRobot.transferData(DZqty, DZone, "//select[@id='ListBoxDestinationZone']/option");
									QaRobot.ClickOnElement("SDCountry");
									QaRobot.transferData(DCqty, DCountry,
											"//select[@id='ListBoxDestinationCountry']/option");
									QaRobot.ClickOnElement("SDAdd");
								} else if (DestinationFor.equalsIgnoreCase("City")) {
									QaRobot.ClickOnElement("SDZone");
									QaRobot.transferData(DZqty, DZone, "//select[@id='ListBoxDestinationZone']/option");
									QaRobot.ClickOnElement("SDCountry");
									QaRobot.transferData(DCqty, DCountry,
											"//select[@id='ListBoxDestinationCountry']/option");
									QaRobot.ClickOnElement("SDCity");
									QaRobot.transferData(DCiQty, DCity,
											"//select[@id='ListBoxDestinationCity']/option");
									QaRobot.ClickOnElement("SDAdd");
								}
								QaRobot.ClickOnElement("DestinationSaveClose");
							} else if (b.equalsIgnoreCase("Cost Range")) {
								QaRobot.switchToWindow();
								QaRobot.PassValue("CostFrom", CostFrom);
								QaRobot.PassValue("CostTo", CostTo);
								QaRobot.ClickOnElement("CostRangeSelectClose");
							} else if (b.equalsIgnoreCase("Booking Date")) {
//								QaRobot.switchToWindow();
//								QaRobot.ClickOnElement("BookDateFrom");
//								String DateSelection[] = BookDateFrom.split("-");
//								String year = DateSelection[2];
//								String month = DateSelection[1];
//								String expDate = DateSelection[0];
//								QaRobot.selectDateInCalendarIM(expDate, month, year);
//								QaRobot.ClickOnElement("BookDateTo");
//								String DateSelection1[] = BookDateTo.split("-");
//								String year1 = DateSelection1[2];
//								String month1 = DateSelection1[1];
//								String expDate1 = DateSelection1[0];
//								QaRobot.selectDateInCalendarIM(expDate1, month1, year1);
//								QaRobot.ClickOnElement("AddBookDate");
//								QaRobot.ClickOnElement("IMBookDateSelectClose");

							} else if (b.equalsIgnoreCase("Trip Date")) {
//								QaRobot.switchToWindow();
//								QaRobot.ClickOnElement("TripDateFrom");
//								String DateSelection[] = TripDateFrom.split("-");
//								String year = DateSelection[2];
//								String month = DateSelection[1];
//								String expDate = DateSelection[0];
//								QaRobot.selectDateInCalendarIM(expDate, month, year);
//								QaRobot.ClickOnElement("TripDateTo");
//								String DateSelection1[] = TripDateTo.split("-");
//								String year1 = DateSelection1[2];
//								String month1 = DateSelection1[1];
//								String expDate1 = DateSelection1[0];
//								QaRobot.selectDateInCalendarIM(expDate1, month1, year1);
//								QaRobot.ClickOnElement("AddTripDate");
//								QaRobot.ClickOnElement("IMTripDateSelectClose");

							} else if (b.equalsIgnoreCase("Market Type")) {
								QaRobot.switchToWindow();
								if (MarketType.equalsIgnoreCase("Domestic")) {
									QaRobot.ClickOnElement("MARDomestic");
								} else if (MarketType.equalsIgnoreCase("International")) {
									QaRobot.ClickOnElement("MARInternational");
								}
								QaRobot.ClickOnElement("MARSaveClose");
							}
						}
					} else {
						for (int i = 1; i <= pAS3; i++) {
							String[] tN = CriteriaName.split(",");
							String b = tN[i - 1];
							String s = Integer.toString(i);
							if (s.equalsIgnoreCase("1")) {
								QaRobot.selectTextByLocator("//select[@id='grdCar_ctl02_ddlCarKey']", b);
							} else {
								QaRobot.ClickOnElement("SAddNewCriteriaCar");
								QaRobot.selectTextByLocator("//select[@id='grdCar_ctl0" + (i + 1) + "_ddlCarKey']", b);
							}
							if (b.equalsIgnoreCase("Origin")) {
								QaRobot.switchToWindow();
								if (OriginFor.equalsIgnoreCase("Zone")) {
									QaRobot.ClickOnElement("SOZone");
									QaRobot.transferData(OZqty, OZone, "//select[@id='ListBoxOriginZone']/option");
									QaRobot.ClickOnElement("SOAdd");
								} else if (OriginFor.equalsIgnoreCase("Region")) {
									QaRobot.ClickOnElement("SORegion");
									QaRobot.transferData(ORqty, ORegion, "//select[@id='ListBoxOriginRegion']/option");
									QaRobot.ClickOnElement("SOAdd");
								} else if (OriginFor.equalsIgnoreCase("Country")) {
									QaRobot.ClickOnElement("SOZone");
									QaRobot.transferData(OZqty, OZone, "//select[@id='ListBoxOriginZone']/option");
									QaRobot.ClickOnElement("SOCountry");
									QaRobot.transferData(OCqty, OCountry,
											"//select[@id='ListBoxOriginCountry']/option");
									QaRobot.ClickOnElement("SOAdd");
								} else if (OriginFor.equalsIgnoreCase("City")) {
									QaRobot.ClickOnElement("SOZone");
									QaRobot.transferData(OZqty, OZone, "//select[@id='ListBoxOriginZone']/option");
									QaRobot.ClickOnElement("SOCountry");
									QaRobot.transferData(OCqty, OCountry,
											"//select[@id='ListBoxOriginCountry']/option");
									QaRobot.ClickOnElement("SOCity");
									QaRobot.transferData(OCiQty, OCity, "//select[@id='ListBoxOriginCity']/option");
									QaRobot.ClickOnElement("SOAdd");
								}
								QaRobot.ClickOnElement("OriginSaveClose");
							} else if (b.equalsIgnoreCase("Destination")) {
								QaRobot.switchToWindow();
								if (DestinationFor.equalsIgnoreCase("Zone")) {
									QaRobot.ClickOnElement("SDZone");
									QaRobot.transferData(DZqty, DZone, "//select[@id='ListBoxDestinationZone']/option");
									QaRobot.ClickOnElement("SDAdd");
								} else if (DestinationFor.equalsIgnoreCase("Region")) {
									QaRobot.ClickOnElement("SDRegion");
									QaRobot.transferData(DRqty, DRegion,
											"//select[@id='ListBoxDestinationRegion']/option");
									QaRobot.ClickOnElement("SDAdd");
								} else if (DestinationFor.equalsIgnoreCase("Country")) {
									QaRobot.ClickOnElement("SDZone");
									QaRobot.transferData(DZqty, DZone, "//select[@id='ListBoxDestinationZone']/option");
									QaRobot.ClickOnElement("SDCountry");
									QaRobot.transferData(DCqty, DCountry,
											"//select[@id='ListBoxDestinationCountry']/option");
									QaRobot.ClickOnElement("SDAdd");
								} else if (DestinationFor.equalsIgnoreCase("City")) {
									QaRobot.ClickOnElement("SDZone");
									QaRobot.transferData(DZqty, DZone, "//select[@id='ListBoxDestinationZone']/option");
									QaRobot.ClickOnElement("SDCountry");
									QaRobot.transferData(DCqty, DCountry,
											"//select[@id='ListBoxDestinationCountry']/option");
									QaRobot.ClickOnElement("SDCity");
									QaRobot.transferData(DCiQty, DCity,
											"//select[@id='ListBoxDestinationCity']/option");
									QaRobot.ClickOnElement("SDAdd");
								}
								QaRobot.ClickOnElement("DestinationSaveClose");
							} else if (b.equalsIgnoreCase("Cost Range")) {
								QaRobot.switchToWindow();
								QaRobot.PassValue("CostFrom", CostFrom);
								QaRobot.PassValue("CostTo", CostTo);
								QaRobot.ClickOnElement("CostRangeSelectClose");
							} else if (b.equalsIgnoreCase("Booking Date")) {
//								QaRobot.switchToWindow();
//								QaRobot.ClickOnElement("BookDateFrom");
//								String DateSelection[] = BookDateFrom.split("-");
//								String year = DateSelection[2];
//								String month = DateSelection[1];
//								String expDate = DateSelection[0];
//								QaRobot.selectDateInCalendarIM(expDate, month, year);
//								QaRobot.ClickOnElement("BookDateTo");
//								String DateSelection1[] = BookDateTo.split("-");
//								String year1 = DateSelection1[2];
//								String month1 = DateSelection1[1];
//								String expDate1 = DateSelection1[0];
//								QaRobot.selectDateInCalendarIM(expDate1, month1, year1);
//								QaRobot.ClickOnElement("AddBookDate");
//								QaRobot.ClickOnElement("IMBookDateSelectClose");

							} else if (b.equalsIgnoreCase("Trip Date")) {
//								QaRobot.switchToWindow();
//								QaRobot.ClickOnElement("TripDateFrom");
//								String DateSelection[] = TripDateFrom.split("-");
//								String year = DateSelection[2];
//								String month = DateSelection[1];
//								String expDate = DateSelection[0];
//								QaRobot.selectDateInCalendarIM(expDate, month, year);
//								QaRobot.ClickOnElement("TripDateTo");
//								String DateSelection1[] = TripDateTo.split("-");
//								String year1 = DateSelection1[2];
//								String month1 = DateSelection1[1];
//								String expDate1 = DateSelection1[0];
//								QaRobot.selectDateInCalendarIM(expDate1, month1, year1);
//								QaRobot.ClickOnElement("AddTripDate");
//								QaRobot.ClickOnElement("IMTripDateSelectClose");

							} else if (b.equalsIgnoreCase("Market Type")) {
								QaRobot.switchToWindow();
								if (MarketType.equalsIgnoreCase("Domestic")) {
									QaRobot.ClickOnElement("MARDomestic");
								} else if (MarketType.equalsIgnoreCase("International")) {
									QaRobot.ClickOnElement("MARInternational");
								}
								QaRobot.ClickOnElement("MARSaveClose");
							}
						}
					}
					QaRobot.ClickOnElement("SaveCarPolicy");
					QaBrowser.driver.switchTo().defaultContent();
					QaRobot.switchframe("//frame[@name='login']");
					QaRobot.switchframe("//frame[@name='leftbar']");
				}
			}
			if (CreateInteractiveMessage.equalsIgnoreCase("Yes")) {
				if (CreateCancellationChargeRule.equalsIgnoreCase("No") || CreatePolicy.equalsIgnoreCase("No")) {
					QaRobot.ClickOnElement("CorporateManagement");
					Thread.sleep(3000);
				}
				QaRobot.ClickOnElement("InteractiveMessaging");
				Thread.sleep(3000);
				QaBrowser.driver.switchTo().parentFrame();
				QaRobot.switchframe("//frame[@name='main']");
				QaRobot.switchframe("//frame[@id='frm2']");
				int pAS2 = Integer.parseInt(SRqty);
				for (int k = 1; k <= pAS2; k++) {
					String[] tN = Rules.split(",");
					String b = tN[k - 1];
					List<WebElement> listOfRules = QaBrowser.driver
							.findElements(By.xpath("//table[@id='GridView1']/tbody/tr/td/a"));
					for (WebElement autoRule : listOfRules) {
						if (autoRule.getText().equalsIgnoreCase(b)) {
							autoRule.click();
							QaRobot.ClickOnElement("InActiveInteractiveMessaging");
							QaRobot.ClickOnElement("SaveInteractiveMessaging");
							QaRobot.alertAccept();
							Thread.sleep(3000);
							break;
						}
					}
				}
				QaRobot.ClickOnElement("AddNewRule");
				QaRobot.PassValue("AddTitle", RuleTitle);
				QaRobot.selectTextByLocator("//select[@id='ddlProduct']", SelectProduct);
				if (SQty.equalsIgnoreCase("1") || SQty.equalsIgnoreCase("2") || SQty.equalsIgnoreCase("3")
						|| SQty.equalsIgnoreCase("4") || SQty.equalsIgnoreCase("5")) {
					QaRobot.transferData(SQty, Supplier, "//select[@id='ddlSupplier']/option");
				} else if (SQty.equalsIgnoreCase("All")) {
					QaRobot.ClickOnElement("SelectAllSupplier");
				}
				if (SelectSalesChannel.equalsIgnoreCase("Corporate SBT")) {
					QaRobot.ClickOnElement("CorporateSbt");
				} else if (SelectSalesChannel.equalsIgnoreCase("Point of Sale")) {
					QaRobot.ClickOnElement("PointOfSale");
				} else if (SelectSalesChannel.equalsIgnoreCase("All")) {
					QaRobot.ClickOnElement("CorporateSbt");
					QaRobot.ClickOnElement("PointOfSale");
				}
				if (SelectProduct.equalsIgnoreCase("Flight")) {
					int pAS = Integer.parseInt(CriteriaQty);
					if (CriteriaQty.equalsIgnoreCase("1")) {
						for (int i = 1; i <= pAS; i++) {
							String[] tN = CriteriaName.split(",");
							String b = tN[i - 1];
							QaRobot.selectTextByLocator("//select[@id='key1']", b);
							if (b.equalsIgnoreCase("Airline")) {
								QaRobot.switchToWindow();
								int pAS1 = Integer.parseInt(AirQty);
								for (int k = 1; k <= pAS1; k++) {
									String[] tN1 = Airlines.split(",");
									String b1 = tN1[k - 1];
									QaBrowser.driver.findElement(By.xpath("//input[@id='txtAirline']")).clear();
									QaRobot.PassValue("PassAirline", b1);
									List<WebElement> listOfRights1 = QaBrowser.driver
											.findElements(By.xpath("//select[@id='ListBoxAirlineFiller']/option"));
									for (WebElement autoRights1 : listOfRights1) {
										if (autoRights1.getText().equalsIgnoreCase(b1)) {
											autoRights1.click();
											QaRobot.ClickOnElement("IMAddAirline");
											break;
										}
									}
								}
								QaRobot.ClickOnElement("IMAirlineSelectClose");

							} else if (b.equalsIgnoreCase("Booking Date")) {
								QaRobot.switchToWindow();
								QaRobot.ClickOnElement("BookDateFrom");
								String DateSelection[] = BookDateFrom.split("-");
								String year = DateSelection[2];
								String month = DateSelection[1];
								String expDate = DateSelection[0];
								QaRobot.selectDateInCalendarIM(expDate, month, year);
								QaRobot.ClickOnElement("BookDateTo");
								String DateSelection1[] = BookDateTo.split("-");
								String year1 = DateSelection1[2];
								String month1 = DateSelection1[1];
								String expDate1 = DateSelection1[0];
								QaRobot.selectDateInCalendarIM(expDate1, month1, year1);
								QaRobot.ClickOnElement("AddBookDate");
								QaRobot.ClickOnElement("IMBookDateSelectClose");

							} else if (b.equalsIgnoreCase("Trip Date")) {
								QaRobot.switchToWindow();
								QaRobot.ClickOnElement("TripDateFrom");
								String DateSelection[] = TripDateFrom.split("-");
								String year = DateSelection[2];
								String month = DateSelection[1];
								String expDate = DateSelection[0];
								QaRobot.selectDateInCalendarIM(expDate, month, year);
								QaRobot.ClickOnElement("TripDateTo");
								String DateSelection1[] = TripDateTo.split("-");
								String year1 = DateSelection1[2];
								String month1 = DateSelection1[1];
								String expDate1 = DateSelection1[0];
								QaRobot.selectDateInCalendarIM(expDate1, month1, year1);
								QaRobot.ClickOnElement("AddTripDate");
								QaRobot.ClickOnElement("IMTripDateSelectClose");

							} else if (b.equalsIgnoreCase("Corporate")) {
								QaRobot.switchToWindow();
								int pAS1 = Integer.parseInt(CorpQty);
								for (int k = 1; k <= pAS1; k++) {
									String[] tN1 = SearchCorporate.split(",");
									String b1 = tN1[k - 1];
									QaBrowser.driver.findElement(By.xpath("//input[@id='txtInputTextForCorporate']"))
											.clear();
									QaRobot.PassValue("PassCorp", b1);
									List<WebElement> listOfRights1 = QaBrowser.driver
											.findElements(By.xpath("//select[@id='ListBoxCorporate']/option"));
									for (WebElement autoRights1 : listOfRights1) {
										if (autoRights1.getText().equalsIgnoreCase(b1)) {
											autoRights1.click();
											QaRobot.ClickOnElement("AddCorp");
										}
									}
								}
								QaRobot.ClickOnElement("CorpSelectClose");

							} else if (b.equalsIgnoreCase("DayInAdvance")) {
								QaRobot.switchToWindow();
								QaRobot.PassValue("IMDayInAdvance", DayInAdvance);
								QaRobot.ClickOnElement("IMDIAdvanceSaveClose");

							} else if (b.equalsIgnoreCase("Origin")) {
								QaRobot.switchToWindow();
								if (OriginFor.equalsIgnoreCase("Zone")) {
									QaRobot.ClickOnElement("IMZone");
									QaRobot.transferData(OZqty, OZone, "//select[@id='ListBoxZone']/option");
								} else if (OriginFor.equalsIgnoreCase("Region")) {
									QaRobot.ClickOnElement("IMRegion");
									QaRobot.transferData(ORqty, ORegion, "//select[@id='ListBoxRegion']/option");
								} else if (OriginFor.equalsIgnoreCase("Country")) {
									QaRobot.ClickOnElement("IMCountry");
									QaRobot.transferDataWithPassValue(OCqty, OCountry, "//input[@id='txtSearch']",
											"//div[@id='divSearch']/p");
								} else if (OriginFor.equalsIgnoreCase("City")) {
									QaRobot.ClickOnElement("IMCity");
									QaRobot.transferDataWithPassValue(OCiQty, OCity, "//input[@id='txtSearch']",
											"//div[@id='divSearch']/p");
								} else if (OriginFor.equalsIgnoreCase("Airport")) {
									QaRobot.ClickOnElement("IMAirport");
									QaRobot.transferDataWithPassValue(OAqty, OAirport, "//input[@id='txtSearch']",
											"//div[@id='divSearch']/p");
								}
								QaRobot.ClickOnElement("IMOriginSaveClose");

							} else if (b.equalsIgnoreCase("Destination")) {
								QaRobot.switchToWindow();
								if (DestinationFor.equalsIgnoreCase("Zone")) {
									QaRobot.ClickOnElement("IMZone");
									QaRobot.transferData(Zqty, Zone, "//select[@id='ListBoxZone']/option");
								} else if (DestinationFor.equalsIgnoreCase("Region")) {
									QaRobot.ClickOnElement("IMRegion");
									QaRobot.transferData(Rqty, Region, "//select[@id='ListBoxRegion']/option");
								} else if (DestinationFor.equalsIgnoreCase("Country")) {
									QaRobot.ClickOnElement("IMCountry");
									QaRobot.transferDataWithPassValue(Cqty, Country, "//input[@id='txtSearch']",
											"//div[@id='divSearch']/p");
								} else if (DestinationFor.equalsIgnoreCase("City")) {
									QaRobot.ClickOnElement("IMCity");
									QaRobot.transferDataWithPassValue(CiQty, City, "//input[@id='txtSearch']",
											"//div[@id='divSearch']/p");
								} else if (DestinationFor.equalsIgnoreCase("Airport")) {
									QaRobot.ClickOnElement("IMAirport");
									QaRobot.transferDataWithPassValue(Aqty, Airport, "//input[@id='txtSearch']",
											"//div[@id='divSearch']/p");
								}
								QaRobot.ClickOnElement("IMDestinationSaveClose");

							} else if (b.equalsIgnoreCase("GDS")) {
								QaRobot.switchToWindow();
								QaRobot.transferData(GDSQty, GDS, "//select[@id='ListBoxGDS']/option");
								QaRobot.ClickOnElement("IMGDSSaveClose");

							} else if (b.equalsIgnoreCase("Weekdays")) {
								QaRobot.switchToWindow();
								QaRobot.transferData(DaysQty, Days, "//select[@id='ListBoxWeekdays']/option");
								QaRobot.ClickOnElement("DaysSelectClose");

							} else if (b.equalsIgnoreCase("Market Type")) {
								QaRobot.switchToWindow();
								QaRobot.transferData(MarketQty, SelectMarketType,
										"//select[@id='ListBoxMarketType']/option");
								QaRobot.ClickOnElement("MarketTypeSelectClose");
							}
						}

					} else {
						for (int i = 1; i <= pAS; i++) {
							String[] tN = CriteriaName.split(",");
							String b = tN[i - 1];
							String s = Integer.toString(i);
							if (s.equalsIgnoreCase("1")) {
								QaRobot.selectTextByLocator("//select[@id='key1']", b);
							} else {
								QaRobot.ClickOnElement("IMAddNewCriteria");
								QaRobot.selectTextByLocator("//select[@id='key" + i + "']", b);
							}
							if (b.equalsIgnoreCase("Airline")) {
								QaRobot.switchToWindow();
								int pAS1 = Integer.parseInt(AirQty);
								for (int k = 1; k <= pAS1; k++) {
									String[] tN1 = Airlines.split(",");
									String b1 = tN1[k - 1];
									QaBrowser.driver.findElement(By.xpath("//input[@id='txtAirline']")).clear();
									QaRobot.PassValue("PassAirline", b1);
									List<WebElement> listOfRights1 = QaBrowser.driver
											.findElements(By.xpath("//select[@id='ListBoxAirlineFiller']/option"));
									for (WebElement autoRights1 : listOfRights1) {
										if (autoRights1.getText().equalsIgnoreCase(b1)) {
											autoRights1.click();
											QaRobot.ClickOnElement("IMAddAirline");
											break;
										}
									}
								}
								QaRobot.ClickOnElement("IMAirlineSelectClose");

							} else if (b.equalsIgnoreCase("Booking Date")) {
								QaRobot.switchToWindow();
								QaRobot.ClickOnElement("BookDateFrom");
								String DateSelection[] = BookDateFrom.split("-");
								String year = DateSelection[2];
								String month = DateSelection[1];
								String expDate = DateSelection[0];
								QaRobot.selectDateInCalendarIM(expDate, month, year);
								QaRobot.ClickOnElement("BookDateTo");
								String DateSelection1[] = BookDateTo.split("-");
								String year1 = DateSelection1[2];
								String month1 = DateSelection1[1];
								String expDate1 = DateSelection1[0];
								QaRobot.selectDateInCalendarIM(expDate1, month1, year1);
								QaRobot.ClickOnElement("AddBookDate");
								QaRobot.ClickOnElement("IMBookDateSelectClose");

							} else if (b.equalsIgnoreCase("Trip Date")) {
								QaRobot.switchToWindow();
								QaRobot.ClickOnElement("TripDateFrom");
								String DateSelection[] = TripDateFrom.split("-");
								String year = DateSelection[2];
								String month = DateSelection[1];
								String expDate = DateSelection[0];
								QaRobot.selectDateInCalendarIM(expDate, month, year);
								QaRobot.ClickOnElement("TripDateTo");
								String DateSelection1[] = TripDateTo.split("-");
								String year1 = DateSelection1[2];
								String month1 = DateSelection1[1];
								String expDate1 = DateSelection1[0];
								QaRobot.selectDateInCalendarIM(expDate1, month1, year1);
								QaRobot.ClickOnElement("AddTripDate");
								QaRobot.ClickOnElement("IMTripDateSelectClose");

							} else if (b.equalsIgnoreCase("Corporate")) {
								QaRobot.switchToWindow();
								int pAS1 = Integer.parseInt(CorpQty);
								for (int k = 1; k <= pAS1; k++) {
									String[] tN1 = SearchCorporate.split(",");
									String b1 = tN1[k - 1];
									QaBrowser.driver.findElement(By.xpath("//input[@id='txtInputTextForCorporate']"))
											.clear();
									QaRobot.PassValue("PassCorp", b1);
									List<WebElement> listOfRights1 = QaBrowser.driver
											.findElements(By.xpath("//select[@id='ListBoxCorporate']/option"));
									for (WebElement autoRights1 : listOfRights1) {
										if (autoRights1.getText().equalsIgnoreCase(b1)) {
											autoRights1.click();
											QaRobot.ClickOnElement("AddCorp");
										}
									}
								}
								QaRobot.ClickOnElement("CorpSelectClose");

							} else if (b.equalsIgnoreCase("DayInAdvance")) {
								QaRobot.switchToWindow();
								QaRobot.PassValue("IMDayInAdvance", DayInAdvance);
								QaRobot.ClickOnElement("IMDIAdvanceSaveClose");

							} else if (b.equalsIgnoreCase("Origin")) {
								QaRobot.switchToWindow();
								if (OriginFor.equalsIgnoreCase("Zone")) {
									QaRobot.ClickOnElement("IMZone");
									QaRobot.transferData(OZqty, OZone, "//select[@id='ListBoxZone']/option");
								} else if (OriginFor.equalsIgnoreCase("Region")) {
									QaRobot.ClickOnElement("IMRegion");
									QaRobot.transferData(ORqty, ORegion, "//select[@id='ListBoxRegion']/option");
								} else if (OriginFor.equalsIgnoreCase("Country")) {
									QaRobot.ClickOnElement("IMCountry");
									QaRobot.transferDataWithPassValue(OCqty, OCountry, "//input[@id='txtSearch']",
											"//div[@id='divSearch']/p");
								} else if (OriginFor.equalsIgnoreCase("City")) {
									QaRobot.ClickOnElement("IMCity");
									QaRobot.transferDataWithPassValue(OCiQty, OCity, "//input[@id='txtSearch']",
											"//div[@id='divSearch']/p");
								} else if (OriginFor.equalsIgnoreCase("Airport")) {
									QaRobot.ClickOnElement("IMAirport");
									QaRobot.transferDataWithPassValue(OAqty, OAirport, "//input[@id='txtSearch']",
											"//div[@id='divSearch']/p");
								}
								QaRobot.ClickOnElement("IMOriginSaveClose");

							} else if (b.equalsIgnoreCase("Destination")) {
								QaRobot.switchToWindow();
								if (DestinationFor.equalsIgnoreCase("Zone")) {
									QaRobot.ClickOnElement("IMZone");
									QaRobot.transferData(Zqty, Zone, "//select[@id='ListBoxZone']/option");
								} else if (DestinationFor.equalsIgnoreCase("Region")) {
									QaRobot.ClickOnElement("IMRegion");
									QaRobot.transferData(Rqty, Region, "//select[@id='ListBoxRegion']/option");
								} else if (DestinationFor.equalsIgnoreCase("Country")) {
									QaRobot.ClickOnElement("IMCountry");
									QaRobot.transferDataWithPassValue(Cqty, Country, "//input[@id='txtSearch']",
											"//div[@id='divSearch']/p");
								} else if (DestinationFor.equalsIgnoreCase("City")) {
									QaRobot.ClickOnElement("IMCity");
									QaRobot.transferDataWithPassValue(CiQty, City, "//input[@id='txtSearch']",
											"//div[@id='divSearch']/p");
								} else if (DestinationFor.equalsIgnoreCase("Airport")) {
									QaRobot.ClickOnElement("IMAirport");
									QaRobot.transferDataWithPassValue(Aqty, Airport, "//input[@id='txtSearch']",
											"//div[@id='divSearch']/p");
								}
								QaRobot.ClickOnElement("IMDestinationSaveClose");

							} else if (b.equalsIgnoreCase("GDS")) {
								QaRobot.switchToWindow();
								QaRobot.transferData(GDSQty, GDS, "//select[@id='ListBoxGDS']/option");
								QaRobot.ClickOnElement("IMGDSSaveClose");

							} else if (b.equalsIgnoreCase("Weekdays")) {
								QaRobot.switchToWindow();
								QaRobot.transferData(DaysQty, Days, "//select[@id='ListBoxWeekdays']/option");
								QaRobot.ClickOnElement("DaysSelectClose");

							} else if (b.equalsIgnoreCase("Market Type")) {
								QaRobot.switchToWindow();
								QaRobot.transferData(MarketQty, SelectMarketType,
										"//select[@id='ListBoxMarketType']/option");
								QaRobot.ClickOnElement("MarketTypeSelectClose");
							}
						}
					}
				} else if (SelectProduct.equalsIgnoreCase("Hotel")) {
					int pAS = Integer.parseInt(CriteriaQty);
					if (CriteriaQty.equalsIgnoreCase("1")) {
						for (int i = 1; i <= pAS; i++) {
							String[] tN = CriteriaName.split(",");
							String b = tN[i - 1];
							QaRobot.selectTextByLocator("//select[@id='key1']", b);
							if (b.equalsIgnoreCase("Trip Date")) {
								QaRobot.switchToWindow();
								QaRobot.ClickOnElement("TripDateFrom");
								String DateSelection[] = TripDateFrom.split("-");
								String year = DateSelection[2];
								String month = DateSelection[1];
								String expDate = DateSelection[0];
								QaRobot.selectDateInCalendar(expDate, month, year);
								QaRobot.ClickOnElement("TripDateTo");
								String DateSelection1[] = TripDateTo.split("-");
								String year1 = DateSelection1[2];
								String month1 = DateSelection1[1];
								String expDate1 = DateSelection1[0];
								QaRobot.selectDateInCalendar(expDate1, month1, year1);
								QaRobot.ClickOnElement("IMTripDateSelectClose");

							} else if (b.equalsIgnoreCase("Weekdays")) {
								QaRobot.switchToWindow();
								QaRobot.transferData(DaysQty, Days, "//select[@id='ListBoxWeekdays']/option");
								QaRobot.ClickOnElement("DaysSelectClo	se");

							} else if (b.equalsIgnoreCase("Market Type")) {
								QaRobot.switchToWindow();
								QaRobot.transferData(MarketQty, SelectMarketType,
										"//select[@id='ListBoxMarketType']/option");
								QaRobot.ClickOnElement("MarketTypeSelectClose");
							}
						}

					} else {
						for (int i = 1; i <= pAS; i++) {
							String[] tN = CriteriaName.split(",");
							String b = tN[i - 1];
							String s = Integer.toString(i);
							if (s.equalsIgnoreCase("1")) {
								QaRobot.selectTextByLocator("//select[@id='key1']", b);
							} else {
								QaRobot.ClickOnElement("IMAddNewCriteria");
								QaRobot.selectTextByLocator("//select[@id='key" + i + "']", b);
							}
							if (b.equalsIgnoreCase("Trip Date")) {
								QaRobot.switchToWindow();
								QaRobot.ClickOnElement("TripDateFrom");
								String DateSelection[] = TripDateFrom.split("-");
								String year = DateSelection[2];
								String month = DateSelection[1];
								String expDate = DateSelection[0];
								QaRobot.selectDateInCalendarIM(expDate, month, year);
								QaRobot.ClickOnElement("TripDateTo");
								String DateSelection1[] = TripDateTo.split("-");
								String year1 = DateSelection1[2];
								String month1 = DateSelection1[1];
								String expDate1 = DateSelection1[0];
								QaRobot.selectDateInCalendarIM(expDate1, month1, year1);
								QaRobot.ClickOnElement("IMTripDateSelectClose");

							} else if (b.equalsIgnoreCase("Weekdays")) {
								QaRobot.switchToWindow();
								QaRobot.transferData(DaysQty, Days, "//select[@id='ListBoxWeekdays']/option");
								QaRobot.ClickOnElement("DaysSelectClose");

							} else if (b.equalsIgnoreCase("Market Type")) {
								QaRobot.switchToWindow();
								QaRobot.transferData(MarketQty, SelectMarketType,
										"//select[@id='ListBoxMarketType']/option");
								QaRobot.ClickOnElement("MarketTypeSelectClose");
							}
						}
					}
				}
				QaRobot.transferData(TravellerQty, TravellerType,
						"/html/body/form/div[4]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[2]/td/div[1]/fieldset[1]/table/tbody/tr[3]/td/fieldset/table[2]/tbody/tr/td[2]/span/label");
				QaRobot.transferData(AppliedQty, AppliedOn,
						"/html/body/form/div[4]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[2]/td/div[1]/fieldset[1]/table/tbody/tr[3]/td/fieldset/table[3]/tbody/tr/td[2]//label");
				QaRobot.PassValue("IMRemarks", Remarks);
				QaRobot.PassValue("ChooseFile", UploadImage);
				Thread.sleep(3000);
				QaExtentReport.extentScreenshot("" + RuleTitle + "");
				QaRobot.ClickOnElement("SaveInteractiveMessaging");
				QaRobot.alertAccept();
				QaRobot.ClickOnElement("CloseInteractiveMessaging");
			}
		}
		TestBase.Companycode(ccode, URL);
		QaRobot.impliwait(30);
		Login.SbtLogin(uname, pwd);
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
			QaRobot.ClickOnElement("NotificationClose");
			Thread.sleep(2000);
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
		Thread.sleep(10000);

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
						"//div[@id='FareDetailsController']/div[2]/div/div[1]/div/div[3]/div[5]/div[2]/ul/li/span"));
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
		QaRobot.scrollPage(-1500);
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
						checkoutpage(ccode, FareBranding, searchType, Trip, adult, child, infant, Stops, fop, receiptno,
								card, cardtype, cvv, CheckOutRuleStatus, RCqty, RulesAppliedOnCheckOutPage,
								checkoutPageStep, SeatSelection, AdultSeatSelection, ChildSeatSelection, airReasonCode,
								CreatedBy);
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
						checkoutpage(ccode, FareBranding, searchType, Trip, adult, child, infant, Stops, fop, receiptno,
								card, cardtype, cvv, CheckOutRuleStatus, RCqty, RulesAppliedOnCheckOutPage,
								checkoutPageStep, SeatSelection, AdultSeatSelection, ChildSeatSelection, airReasonCode,
								CreatedBy);
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
					checkoutpage(ccode, FareBranding, searchType, Trip, adult, child, infant, Stops, fop, receiptno,
							card, cardtype, cvv, CheckOutRuleStatus, RCqty, RulesAppliedOnCheckOutPage,
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
					QaRobot.ClickOnElement("AFlightItinerary");
					Thread.sleep(10000);
					QaExtentReport.extentScreenshot("Flight Itinerary");
					Thread.sleep(3000);
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
					int Cq = Integer.parseInt(ChargesQty);
					for (int i = 1; i <= Cq; i++) {
						if (Source.equalsIgnoreCase("Live")) {
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
						} else {
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
						}
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
					} else if (OneWayAirLine.equalsIgnoreCase("SpiceJet")) {
						if (OneWayFareType.equalsIgnoreCase("Spice Saver")) {
							QaRobot.ClickOnElement("AddToCartJ1");
							if (getT.equalsIgnoreCase("Out of policy")) {
								QaRobot.alertAccept();
							}
						} else if (OneWayFareType.equalsIgnoreCase("ECONOMY FLEX")) {
							QaRobot.ClickOnElement("AddToCartJ2");
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
					}

//					if (PolicyType.equalsIgnoreCase("OutPolicy")) {
//						if (OneWayAirLine.equalsIgnoreCase("Air India")) {
//							if (OneWayFareType.equalsIgnoreCase("Comfort")) {
//								QaRobot.ClickOnElement("AddToCartJ1");
//								QaBrowser.driver.switchTo().alert().accept();
//							} else if (OneWayFareType.equalsIgnoreCase("Economy Basic")) {
//								QaRobot.ClickOnElement("AddToCartJ2");
//								QaBrowser.driver.switchTo().alert().accept();
//							} else if (OneWayFareType.equalsIgnoreCase("Economy Starter Max")) {
//								QaRobot.ClickOnElement("AddToCartJ3");
//								QaBrowser.driver.switchTo().alert().accept();
//							}
//						} else if (OneWayAirLine.equalsIgnoreCase("Indigo")) {
//							if (OneWayFareType.equalsIgnoreCase("Flexi Fare")) {
//								QaRobot.ClickOnElement("AddToCartJ1");
//								QaBrowser.driver.switchTo().alert().accept();
//							} else if (OneWayFareType.equalsIgnoreCase("SAVER")) {
//								QaRobot.ClickOnElement("AddToCartJ2");
//								QaBrowser.driver.switchTo().alert().accept();
//							} else if (OneWayFareType.equalsIgnoreCase("BUSINESS")) {
//								QaRobot.ClickOnElement("AddToCartJ3");
//								QaBrowser.driver.switchTo().alert().accept();
//							}
//						} else if (OneWayAirLine.equalsIgnoreCase("Akasa Air")) {
//							if (OneWayFareType.equalsIgnoreCase("Economy")) {
//								QaRobot.ClickOnElement("AddToCartJ1");
//								QaBrowser.driver.switchTo().alert().accept();
//							} else if (OneWayFareType.equalsIgnoreCase("SAVER")) {
//								QaRobot.ClickOnElement("AddToCartJ2");
//								QaBrowser.driver.switchTo().alert().accept();
//							} else if (OneWayFareType.equalsIgnoreCase("BUSINESS")) {
//								QaRobot.ClickOnElement("AddToCartJ3");
//								QaBrowser.driver.switchTo().alert().accept();
//							}
//						} else if (OneWayAirLine.equalsIgnoreCase("SpiceJet")) {
//							if (OneWayFareType.equalsIgnoreCase("Spice Saver")) {
//								QaRobot.ClickOnElement("AddToCartJ1");
//								QaBrowser.driver.switchTo().alert().accept();
//							} else if (OneWayFareType.equalsIgnoreCase("ECONOMY FLEX")) {
//								QaRobot.ClickOnElement("AddToCartJ2");
//								QaBrowser.driver.switchTo().alert().accept();
//							} else if (OneWayFareType.equalsIgnoreCase("FLEXIBLE BUSINESS")) {
//								QaRobot.ClickOnElement("AddToCartJ3");
//								QaBrowser.driver.switchTo().alert().accept();
//							} else if (OneWayFareType.equalsIgnoreCase("BUSINESS SAVER")) {
//								QaRobot.ClickOnElement("AddToCartJ4");
//								QaBrowser.driver.switchTo().alert().accept();
//							}
//						} else if (OneWayAirLine.equalsIgnoreCase("Vistara")) {
//							if (OneWayFareType.equalsIgnoreCase("ECO LITE")) {
//								QaRobot.ClickOnElement("AddToCartJ1");
//								QaBrowser.driver.switchTo().alert().accept();
//							} else if (OneWayFareType.equalsIgnoreCase("ECONOMY FLEX")) {
//								QaRobot.ClickOnElement("AddToCartJ2");
//								QaBrowser.driver.switchTo().alert().accept();
//							} else if (OneWayFareType.equalsIgnoreCase("FLEXIBLE BUSINESS")) {
//								QaRobot.ClickOnElement("AddToCartJ3");
//								QaBrowser.driver.switchTo().alert().accept();
//							} else if (OneWayFareType.equalsIgnoreCase("BUSINESS SAVER")) {
//								QaRobot.ClickOnElement("AddToCartJ4");
//								QaBrowser.driver.switchTo().alert().accept();
//							}
//						} else {
//							Assert.assertEquals(false, "Please select correct Airline and Fare type." + OneWayFareType);
//							System.out.println("Please select correct Airline and Fare type.");
//						}
//					} else {
//						if (OneWayAirLine.equalsIgnoreCase("Air India")) {
//							if (OneWayFareType.equalsIgnoreCase("Comfort")) {
//								QaRobot.ClickOnElement("AddToCartJ1");
//							} else if (OneWayFareType.equalsIgnoreCase("Economy Basic")) {
//								QaRobot.ClickOnElement("AddToCartJ2");
//							} else if (OneWayFareType.equalsIgnoreCase("Economy Starter Max")) {
//								QaRobot.ClickOnElement("AddToCartJ3");
//							}
//						} else if (OneWayAirLine.equalsIgnoreCase("Indigo")) {
//							if (OneWayFareType.equalsIgnoreCase("Flexi Fare")) {
//								QaRobot.ClickOnElement("AddToCartJ1");
//							} else if (OneWayFareType.equalsIgnoreCase("SAVER")) {
//								QaRobot.ClickOnElement("AddToCartJ1");
//							} else if (OneWayFareType.equalsIgnoreCase("BUSINESS")) {
//								QaRobot.ClickOnElement("AddToCartJ3");
//							}
//						} else if (OneWayAirLine.equalsIgnoreCase("Akasa Air")) {
//							if (OneWayFareType.equalsIgnoreCase("Economy")) {
//								QaRobot.ClickOnElement("AddToCartJ1");
//							} else if (OneWayFareType.equalsIgnoreCase("SAVER")) {
//								QaRobot.ClickOnElement("AddToCartJ2");
//							} else if (OneWayFareType.equalsIgnoreCase("BUSINESS")) {
//								QaRobot.ClickOnElement("AddToCartJ3");
//							}
//						} else if (OneWayAirLine.equalsIgnoreCase("SpiceJet")) {
//							if (OneWayFareType.equalsIgnoreCase("Spice Saver")) {
//								QaRobot.ClickOnElement("AddToCartJ1");
//							} else if (OneWayFareType.equalsIgnoreCase("ECONOMY FLEX")) {
//								QaRobot.ClickOnElement("AddToCartJ2");
//							} else if (OneWayFareType.equalsIgnoreCase("FLEXIBLE BUSINESS")) {
//								QaRobot.ClickOnElement("AddToCartJ3");
//							} else if (OneWayFareType.equalsIgnoreCase("BUSINESS SAVER")) {
//								QaRobot.ClickOnElement("AddToCartJ4");
//							}
//						} else if (OneWayAirLine.equalsIgnoreCase("Vistara")) {
//							if (OneWayFareType.equalsIgnoreCase("ECO LITE")) {
//								QaRobot.ClickOnElement("AddToCartJ1");
//							} else if (OneWayFareType.equalsIgnoreCase("ECONOMY FLEX")) {
//								QaRobot.ClickOnElement("AddToCartJ2");
//							} else if (OneWayFareType.equalsIgnoreCase("FLEXIBLE BUSINESS")) {
//								QaRobot.ClickOnElement("AddToCartJ3");
//							} else if (OneWayFareType.equalsIgnoreCase("BUSINESS SAVER")) {
//								QaRobot.ClickOnElement("AddToCartJ4");
//							}
//						} else {
//							Assert.assertEquals(false, "Please select correct Airline and Fare type." + OneWayFareType);
//							System.out.println("Please select correct Airline and Fare type.");
//						}
//					}
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
					Thread.sleep(10000);
					QaExtentReport.extentScreenshot("Flight Itinerary");
					Thread.sleep(3000);
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
					int Cq = Integer.parseInt(ChargesQty);
					for (int i = 1; i <= Cq; i++) {
						if (Source.equalsIgnoreCase("Live")) {
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
						} else {
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
						}
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
						} else if (OneWayFareType.equalsIgnoreCase("ECONOMY FLEX")) {
							QaRobot.ClickOnElement("AddToCartJ2");
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
						if (OneWayFareType.equalsIgnoreCase("Standard")) {
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
//					if (PolicyType.equalsIgnoreCase("OutPolicy")) {
//						if (OneWayAirLine.equalsIgnoreCase("Air India")) {
//							if (OneWayFareType.equalsIgnoreCase("Comfort")) {
//								QaRobot.ClickOnElement("AddToCartJ1");
//								QaBrowser.driver.switchTo().alert().accept();
//							} else if (OneWayFareType.equalsIgnoreCase("Economy Basic")) {
//								QaRobot.ClickOnElement("AddToCartJ2");
//								QaBrowser.driver.switchTo().alert().accept();
//							} else if (OneWayFareType.equalsIgnoreCase("Economy Starter Max")) {
//								QaRobot.ClickOnElement("AddToCartJ3");
//								QaBrowser.driver.switchTo().alert().accept();
//							}
//						} else if (OneWayAirLine.equalsIgnoreCase("Indigo")) {
//							if (OneWayFareType.equalsIgnoreCase("Flexi Fare")) {
//								QaRobot.ClickOnElement("AddToCartJ1");
//								QaBrowser.driver.switchTo().alert().accept();
//							} else if (OneWayFareType.equalsIgnoreCase("SAVER")) {
//								QaRobot.ClickOnElement("AddToCartJ1");
//								QaBrowser.driver.switchTo().alert().accept();
//							} else if (OneWayFareType.equalsIgnoreCase("BUSINESS")) {
//								QaRobot.ClickOnElement("AddToCartJ3");
//								QaBrowser.driver.switchTo().alert().accept();
//							}
//						} else if (OneWayAirLine.equalsIgnoreCase("Akasa Air")) {
//							if (OneWayFareType.equalsIgnoreCase("Economy")) {
//								QaRobot.ClickOnElement("AddToCartJ1");
//								QaBrowser.driver.switchTo().alert().accept();
//							} else if (OneWayFareType.equalsIgnoreCase("SAVER")) {
//								QaRobot.ClickOnElement("AddToCartJ2");
//								QaBrowser.driver.switchTo().alert().accept();
//							} else if (OneWayFareType.equalsIgnoreCase("BUSINESS")) {
//								QaRobot.ClickOnElement("AddToCartJ3");
//								QaBrowser.driver.switchTo().alert().accept();
//							}
//						} else if (OneWayAirLine.equalsIgnoreCase("SpiceJet")) {
//							if (OneWayFareType.equalsIgnoreCase("Spice Saver")) {
//								QaRobot.ClickOnElement("AddToCartJ1");
//								QaBrowser.driver.switchTo().alert().accept();
//							} else if (OneWayFareType.equalsIgnoreCase("ECONOMY FLEX")) {
//								QaRobot.ClickOnElement("AddToCartJ2");
//								QaBrowser.driver.switchTo().alert().accept();
//							} else if (OneWayFareType.equalsIgnoreCase("FLEXIBLE BUSINESS")) {
//								QaRobot.ClickOnElement("AddToCartJ3");
//								QaBrowser.driver.switchTo().alert().accept();
//							} else if (OneWayFareType.equalsIgnoreCase("BUSINESS SAVER")) {
//								QaRobot.ClickOnElement("AddToCartJ4");
//								QaBrowser.driver.switchTo().alert().accept();
//							}
//						} else if (OneWayAirLine.equalsIgnoreCase("Vistara")) {
//							if (OneWayFareType.equalsIgnoreCase("ECO LITE")) {
//								QaRobot.ClickOnElement("AddToCartJ1");
//								QaBrowser.driver.switchTo().alert().accept();
//							} else if (OneWayFareType.equalsIgnoreCase("ECONOMY FLEX")) {
//								QaRobot.ClickOnElement("AddToCartJ2");
//								QaBrowser.driver.switchTo().alert().accept();
//							} else if (OneWayFareType.equalsIgnoreCase("FLEXIBLE BUSINESS")) {
//								QaRobot.ClickOnElement("AddToCartJ3");
//								QaBrowser.driver.switchTo().alert().accept();
//							} else if (OneWayFareType.equalsIgnoreCase("BUSINESS SAVER")) {
//								QaRobot.ClickOnElement("AddToCartJ4");
//								QaBrowser.driver.switchTo().alert().accept();
//							}
//						} else {
//							Assert.assertEquals(false, "Please select correct Airline and Fare type." + OneWayFareType);
//							System.out.println("Please select correct Airline and Fare type.");
//						}
//					} else {
//						if (OneWayAirLine.equalsIgnoreCase("Air India")) {
//							if (OneWayFareType.equalsIgnoreCase("Comfort")) {
//								QaRobot.ClickOnElement("AddToCartJ1");
//							} else if (OneWayFareType.equalsIgnoreCase("Economy Basic")) {
//								QaRobot.ClickOnElement("AddToCartJ2");
//							} else if (OneWayFareType.equalsIgnoreCase("Economy Starter Max")) {
//								QaRobot.ClickOnElement("AddToCartJ3");
//							}
//						} else if (OneWayAirLine.equalsIgnoreCase("Indigo")) {
//							if (OneWayFareType.equalsIgnoreCase("Flexi Fare")) {
//								QaRobot.ClickOnElement("AddToCartJ1");
//							} else if (OneWayFareType.equalsIgnoreCase("SAVER")) {
//								QaRobot.ClickOnElement("AddToCartJ1");
//							} else if (OneWayFareType.equalsIgnoreCase("BUSINESS")) {
//								QaRobot.ClickOnElement("AddToCartJ3");
//							}
//						} else if (OneWayAirLine.equalsIgnoreCase("Akasa Air")) {
//							if (OneWayFareType.equalsIgnoreCase("Economy")) {
//								QaRobot.ClickOnElement("AddToCartJ1");
//							} else if (OneWayFareType.equalsIgnoreCase("SAVER")) {
//								QaRobot.ClickOnElement("AddToCartJ2");
//							} else if (OneWayFareType.equalsIgnoreCase("BUSINESS")) {
//								QaRobot.ClickOnElement("AddToCartJ3");
//							}
//						} else if (OneWayAirLine.equalsIgnoreCase("SpiceJet")) {
//							if (OneWayFareType.equalsIgnoreCase("Spice Saver")) {
//								QaRobot.ClickOnElement("AddToCartJ1");
//							} else if (OneWayFareType.equalsIgnoreCase("ECONOMY FLEX")) {
//								QaRobot.ClickOnElement("AddToCartJ2");
//							} else if (OneWayFareType.equalsIgnoreCase("FLEXIBLE BUSINESS")) {
//								QaRobot.ClickOnElement("AddToCartJ3");
//							} else if (OneWayFareType.equalsIgnoreCase("BUSINESS SAVER")) {
//								QaRobot.ClickOnElement("AddToCartJ4");
//							}
//						} else if (OneWayAirLine.equalsIgnoreCase("Vistara")) {
//							if (OneWayFareType.equalsIgnoreCase("ECO LITE")) {
//								QaRobot.ClickOnElement("AddToCartJ1");
//							} else if (OneWayFareType.equalsIgnoreCase("ECONOMY FLEX")) {
//								QaRobot.ClickOnElement("AddToCartJ2");
//							} else if (OneWayFareType.equalsIgnoreCase("FLEXIBLE BUSINESS")) {
//								QaRobot.ClickOnElement("AddToCartJ3");
//							} else if (OneWayFareType.equalsIgnoreCase("BUSINESS SAVER")) {
//								QaRobot.ClickOnElement("AddToCartJ4");
//							}
//						} else {
//							Assert.assertEquals(false, "Please select correct Airline and Fare type." + OneWayFareType);
//							System.out.println("Please select correct Airline and Fare type.");
//						}
//					}
					Thread.sleep(3000);
					QaRobot.switchToWindow();
					QaRobot.ClickOnElement("NotificationCloseJ");
					QaRobot.ClickOnElement("ResultRJ");
					Thread.sleep(5000);
					if (Source.equalsIgnoreCase("Live")) {
						List<WebElement> listOfStop = QaBrowser.driver.findElements(By.xpath(
								"//div[@id='FareDetailsController']/div[2]/div/div[1]/div/div[3]/div[5]/div[2]/ul/li/span"));
						for (WebElement autoStop : listOfStop) {
//							System.out.println(autoAirline.getText());
							if (autoStop.getText().equalsIgnoreCase(Stops)) {
								autoStop.click();
								break;
							}
						}
					} else {
						List<WebElement> listOfStop1 = QaBrowser.driver.findElements(By.xpath(
								"//div[@id='FareDetailsController']/div[2]/div/div[1]/div/div[3]/div[5]/div[2]/ul/li/span"));
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
					Thread.sleep(10000);
					QaExtentReport.extentScreenshot("Flight Itinerary");
					Thread.sleep(3000);
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
					int Cq1 = Integer.parseInt(ChargesQty);
					for (int i = 1; i <= Cq1; i++) {
						if (Source.equalsIgnoreCase("Live")) {
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
						} else {
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
						}
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
						} else if (RoundTripFareType.equalsIgnoreCase("ECONOMY FLEX")) {
							QaRobot.ClickOnElement("AddToCartJ2");
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
						if (RoundTripFareType.equalsIgnoreCase("Standard")) {
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
//					if (PolicyType.equalsIgnoreCase("OutPolicy")) {
//						if (RoundTripAirLine.equalsIgnoreCase("Air India")) {
//							if (RoundTripFareType.equalsIgnoreCase("Comfort")) {
//								QaRobot.ClickOnElement("AddToCartJ1");
//								QaBrowser.driver.switchTo().alert().accept();
//							} else if (RoundTripFareType.equalsIgnoreCase("Economy Basic")) {
//								QaRobot.ClickOnElement("AddToCartJ2");
//								QaBrowser.driver.switchTo().alert().accept();
//							} else if (RoundTripFareType.equalsIgnoreCase("Economy Starter Max")) {
//								QaRobot.ClickOnElement("AddToCartJ3");
//								QaBrowser.driver.switchTo().alert().accept();
//							}
//						} else if (RoundTripAirLine.equalsIgnoreCase("Indigo")) {
//							if (RoundTripFareType.equalsIgnoreCase("Flexi Fare")) {
//								QaRobot.ClickOnElement("AddToCartJ1");
//								QaBrowser.driver.switchTo().alert().accept();
//							} else if (RoundTripFareType.equalsIgnoreCase("SAVER")) {
//								QaRobot.ClickOnElement("AddToCartJ1");
//								QaBrowser.driver.switchTo().alert().accept();
//							} else if (RoundTripFareType.equalsIgnoreCase("BUSINESS")) {
//								QaRobot.ClickOnElement("AddToCartJ3");
//								QaBrowser.driver.switchTo().alert().accept();
//							}
//						} else if (OneWayAirLine.equalsIgnoreCase("Akasa Air")) {
//							if (OneWayFareType.equalsIgnoreCase("Economy")) {
//								QaRobot.ClickOnElement("AddToCartJ1");
//								QaBrowser.driver.switchTo().alert().accept();
//							} else if (OneWayFareType.equalsIgnoreCase("SAVER")) {
//								QaRobot.ClickOnElement("AddToCartJ2");
//								QaBrowser.driver.switchTo().alert().accept();
//							} else if (OneWayFareType.equalsIgnoreCase("BUSINESS")) {
//								QaRobot.ClickOnElement("AddToCartJ3");
//								QaBrowser.driver.switchTo().alert().accept();
//							}
//						} else if (RoundTripAirLine.equalsIgnoreCase("SpiceJet")) {
//							if (RoundTripFareType.equalsIgnoreCase("Spice Saver")) {
//								QaRobot.ClickOnElement("AddToCartJ1");
//								QaBrowser.driver.switchTo().alert().accept();
//							} else if (RoundTripFareType.equalsIgnoreCase("ECONOMY FLEX")) {
//								QaRobot.ClickOnElement("AddToCartJ2");
//								QaBrowser.driver.switchTo().alert().accept();
//							} else if (RoundTripFareType.equalsIgnoreCase("FLEXIBLE BUSINESS")) {
//								QaRobot.ClickOnElement("AddToCartJ3");
//								QaBrowser.driver.switchTo().alert().accept();
//							} else if (RoundTripFareType.equalsIgnoreCase("BUSINESS SAVER")) {
//								QaRobot.ClickOnElement("AddToCartJ4");
//								QaBrowser.driver.switchTo().alert().accept();
//							}
//						} else if (RoundTripAirLine.equalsIgnoreCase("Vistara")) {
//							if (RoundTripFareType.equalsIgnoreCase("ECO LITE")) {
//								QaRobot.ClickOnElement("AddToCartJ1");
//								QaBrowser.driver.switchTo().alert().accept();
//							} else if (RoundTripFareType.equalsIgnoreCase("ECONOMY FLEX")) {
//								QaRobot.ClickOnElement("AddToCartJ2");
//								QaBrowser.driver.switchTo().alert().accept();
//							} else if (RoundTripFareType.equalsIgnoreCase("FLEXIBLE BUSINESS")) {
//								QaRobot.ClickOnElement("AddToCartJ3");
//								QaBrowser.driver.switchTo().alert().accept();
//							} else if (RoundTripFareType.equalsIgnoreCase("BUSINESS SAVER")) {
//								QaRobot.ClickOnElement("AddToCartJ4");
//								QaBrowser.driver.switchTo().alert().accept();
//							}
//						} else {
//							Assert.assertEquals(false, "Please select correct Airline and Fare type." + OneWayFareType);
//							System.out.println("Please select correct Airline and Fare type.");
//						}
//					} else {
//						if (RoundTripAirLine.equalsIgnoreCase("Air India")) {
//							if (RoundTripFareType.equalsIgnoreCase("Comfort")) {
//								QaRobot.ClickOnElement("AddToCartJ1");
//							} else if (RoundTripFareType.equalsIgnoreCase("Economy Basic")) {
//								QaRobot.ClickOnElement("AddToCartJ2");
//							} else if (RoundTripFareType.equalsIgnoreCase("Economy Starter Max")) {
//								QaRobot.ClickOnElement("AddToCartJ3");
//							}
//						} else if (RoundTripAirLine.equalsIgnoreCase("Indigo")) {
//							if (RoundTripFareType.equalsIgnoreCase("Flexi Fare")) {
//								QaRobot.ClickOnElement("AddToCartJ1");
//							} else if (RoundTripFareType.equalsIgnoreCase("SAVER")) {
//								QaRobot.ClickOnElement("AddToCartJ1");
//							} else if (RoundTripFareType.equalsIgnoreCase("BUSINESS")) {
//								QaRobot.ClickOnElement("AddToCartJ3");
//							}
//						} else if (OneWayAirLine.equalsIgnoreCase("Akasa Air")) {
//							if (OneWayFareType.equalsIgnoreCase("Economy")) {
//								QaRobot.ClickOnElement("AddToCartJ1");
//							} else if (OneWayFareType.equalsIgnoreCase("SAVER")) {
//								QaRobot.ClickOnElement("AddToCartJ2");
//							} else if (OneWayFareType.equalsIgnoreCase("BUSINESS")) {
//								QaRobot.ClickOnElement("AddToCartJ3");
//							}
//						} else if (RoundTripAirLine.equalsIgnoreCase("SpiceJet")) {
//							if (RoundTripFareType.equalsIgnoreCase("Spice Saver")) {
//								QaRobot.ClickOnElement("AddToCartJ1");
//							} else if (RoundTripFareType.equalsIgnoreCase("ECONOMY FLEX")) {
//								QaRobot.ClickOnElement("AddToCartJ2");
//							} else if (RoundTripFareType.equalsIgnoreCase("FLEXIBLE BUSINESS")) {
//								QaRobot.ClickOnElement("AddToCartJ3");
//							} else if (RoundTripFareType.equalsIgnoreCase("BUSINESS SAVER")) {
//								QaRobot.ClickOnElement("AddToCartJ4");
//							}
//						} else if (RoundTripAirLine.equalsIgnoreCase("Vistara")) {
//							if (RoundTripFareType.equalsIgnoreCase("ECO LITE")) {
//								QaRobot.ClickOnElement("AddToCartJ1");
//							} else if (RoundTripFareType.equalsIgnoreCase("ECONOMY FLEX")) {
//								QaRobot.ClickOnElement("AddToCartJ2");
//							} else if (RoundTripFareType.equalsIgnoreCase("FLEXIBLE BUSINESS")) {
//								QaRobot.ClickOnElement("AddToCartJ3");
//							} else if (RoundTripFareType.equalsIgnoreCase("BUSINESS SAVER")) {
//								QaRobot.ClickOnElement("AddToCartJ4");
//							}
//						} else {
//							Assert.assertEquals(false,
//									"Please select correct Airline and Fare type." + RoundTripFareType);
//							System.out.println("Please select correct Airline and Fare type.");
//						}
//					}
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
						QaRobot.ClickOnElement("ProceedToCheckoutCN");
					}
				}
			}
			checkoutpage(ccode, FareBranding, searchType, Trip, adult, child, infant, Stops, fop, receiptno, card,
					cardtype, cvv, CheckOutRuleStatus, RCqty, RulesAppliedOnCheckOutPage, checkoutPageStep,
					SeatSelection, AdultSeatSelection, ChildSeatSelection, airReasonCode, CreatedBy);
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
			String child, String infant, String Stops, String fop, String receiptno, String card, String cardtype,
			String cvv, String CheckOutRuleStatus, String RCqty, String RulesAppliedOnCheckOutPage,
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
				Thread.sleep(3000);
				QaRobot.scrollPage(1000);
				QaRobot.ClickOnElement("ow_chkterms");
//				QaExtentReport.test.log(Status.INFO, "<b><i>check the terms and condition</i></b>");
//				if (ccode.equalsIgnoreCase("sbt")) {
//					QaRobot.ClickOnElement("ow_chkbook");
//				} else if (ccode.equalsIgnoreCase("preprod117")) {
//					QaRobot.ClickOnElement("ow_chkbook");
//				}
////				QaExtentReport.test.log(Status.INFO,
////						"<b><i>book button to proceed the booking from checkout page</i></b>");
//				if (SeatSelection.equalsIgnoreCase("Yes")) {
//					String ParentWindow1 = QaBrowser.driver.getWindowHandle();
//					Set<String> handles1 = QaBrowser.driver.getWindowHandles();
//					for (String childWindow1 : handles1) {
//						if (!childWindow1.equals(ParentWindow1))
//							QaBrowser.driver.switchTo().window(childWindow1);
//					}
//					QaRobot.ClickOnElement("SeatSelect");
//					Thread.sleep(5000);
//					QaBrowser.driver.switchTo().window(ParentWindow1);
//					String SelectSeat[] = AdultSeatSelection.split(",");
//					String Seat1 = SelectSeat[0];
//					String Seat2 = SelectSeat[1];
//					String Seat3 = SelectSeat[2];
//					String Seat4 = SelectSeat[3];
//					String CSelectSeat[] = ChildSeatSelection.split(",");
//					String CSeat1 = CSelectSeat[0];
//					String CSeat2 = CSelectSeat[1];
////					String CSeat3 = CSelectSeat[2];
//					if (searchType.equalsIgnoreCase("Individual")) {
//						if (Trip.equalsIgnoreCase("OneWay")) {
//							if (Stops.equalsIgnoreCase("0")) {
//								List<WebElement> listOfRights1 = QaBrowser.driver
//										.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//								for (WebElement autoRights1 : listOfRights1) {
//									if (autoRights1.getText().equalsIgnoreCase(Seat1)) {
//										autoRights1.click();
//										QaExtentReport.extentScreenshot("Seat Selection Page");
//										Thread.sleep(5000);
//										QaRobot.ClickOnElement("OW_ContinueBooking");
//										break;
//									}
//								}
//							} else if (Stops.equalsIgnoreCase("1")) {
//								List<WebElement> listOfRights1 = QaBrowser.driver
//										.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//								for (WebElement autoRights1 : listOfRights1) {
//									if (autoRights1.getText().equalsIgnoreCase(Seat1)) {
//										autoRights1.click();
//										QaExtentReport.extentScreenshot("Seat Selection Page");
//										Thread.sleep(5000);
//										QaRobot.ClickOnElement("OW_ContinueBooking");
//										break;
//									}
//								}
//								Thread.sleep(3000);
//								List<WebElement> listOfRights2 = QaBrowser.driver
//										.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//								for (WebElement autoRights2 : listOfRights2) {
//									if (autoRights2.getText().equalsIgnoreCase(Seat2)) {
//										autoRights2.click();
//										QaExtentReport.extentScreenshot("Seat Selection Page");
//										Thread.sleep(5000);
//										QaRobot.ClickOnElement("OW_ContinueBooking");
//										break;
//									}
//								}
//							} else if (Stops.equalsIgnoreCase("2")) {
//								List<WebElement> listOfRights1 = QaBrowser.driver
//										.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//								for (WebElement autoRights1 : listOfRights1) {
//									if (autoRights1.getText().equalsIgnoreCase(Seat1)) {
//										autoRights1.click();
//										QaExtentReport.extentScreenshot("Seat Selection Page");
//										Thread.sleep(5000);
//										QaRobot.ClickOnElement("OW_ContinueBooking");
//										break;
//									}
//								}
//								Thread.sleep(3000);
//								List<WebElement> listOfRights2 = QaBrowser.driver
//										.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//								for (WebElement autoRights2 : listOfRights2) {
//									if (autoRights2.getText().equalsIgnoreCase(Seat2)) {
//										autoRights2.click();
//										QaExtentReport.extentScreenshot("Seat Selection Page");
//										Thread.sleep(5000);
//										QaRobot.ClickOnElement("OW_ContinueBooking");
//										break;
//									}
//								}
//								Thread.sleep(3000);
//								List<WebElement> listOfRights3 = QaBrowser.driver
//										.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//								for (WebElement autoRights3 : listOfRights3) {
//									if (autoRights3.getText().equalsIgnoreCase(Seat3)) {
//										autoRights3.click();
//										QaExtentReport.extentScreenshot("Seat Selection Page");
//										Thread.sleep(5000);
//										QaRobot.ClickOnElement("OW_ContinueBooking");
//										break;
//									}
//								}
//							}
//						} else if (Trip.equalsIgnoreCase("RoundTrip")) {
//							if (Stops.equalsIgnoreCase("0")) {
//								List<WebElement> listOfRights1 = QaBrowser.driver
//										.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//								for (WebElement autoRights1 : listOfRights1) {
//									if (autoRights1.getText().equalsIgnoreCase(Seat1)) {
//										autoRights1.click();
//										QaExtentReport.extentScreenshot("Seat Selection Page");
//										Thread.sleep(5000);
//										QaRobot.ClickOnElement("OW_ContinueBooking");
//										break;
//									}
//								}
//								Thread.sleep(3000);
//								List<WebElement> listOfRights2 = QaBrowser.driver
//										.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//								for (WebElement autoRights2 : listOfRights2) {
//									if (autoRights2.getText().equalsIgnoreCase(Seat2)) {
//										autoRights2.click();
//										QaExtentReport.extentScreenshot("Seat Selection Page");
//										Thread.sleep(5000);
//										QaRobot.ClickOnElement("OW_ContinueBooking");
//										break;
//									}
//								}
//							} else if (Stops.equalsIgnoreCase("1")) {
//								List<WebElement> listOfRights1 = QaBrowser.driver
//										.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//								for (WebElement autoRights1 : listOfRights1) {
//									if (autoRights1.getText().equalsIgnoreCase(Seat1)) {
//										autoRights1.click();
//										QaExtentReport.extentScreenshot("Seat Selection Page");
//										Thread.sleep(5000);
//										QaRobot.ClickOnElement("OW_ContinueBooking");
//										break;
//									}
//								}
//								Thread.sleep(3000);
//								List<WebElement> listOfRights2 = QaBrowser.driver
//										.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//								for (WebElement autoRights2 : listOfRights2) {
//									if (autoRights2.getText().equalsIgnoreCase(Seat2)) {
//										autoRights2.click();
//										QaExtentReport.extentScreenshot("Seat Selection Page");
//										Thread.sleep(5000);
//										QaRobot.ClickOnElement("OW_ContinueBooking");
//										break;
//									}
//								}
//								Thread.sleep(3000);
//								List<WebElement> listOfRights3 = QaBrowser.driver
//										.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//								for (WebElement autoRights3 : listOfRights3) {
//									if (autoRights3.getText().equalsIgnoreCase(Seat3)) {
//										autoRights3.click();
//										QaExtentReport.extentScreenshot("Seat Selection Page");
//										Thread.sleep(5000);
//										QaRobot.ClickOnElement("OW_ContinueBooking");
//										break;
//									}
//								}
//								Thread.sleep(3000);
//								List<WebElement> listOfRights4 = QaBrowser.driver
//										.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//								for (WebElement autoRights4 : listOfRights4) {
//									if (autoRights4.getText().equalsIgnoreCase(Seat4)) {
//										autoRights4.click();
//										QaExtentReport.extentScreenshot("Seat Selection Page");
//										Thread.sleep(5000);
//										QaRobot.ClickOnElement("OW_ContinueBooking");
//										break;
//									}
//								}
//							}
//						}
//					} else {
//						if (Trip.equalsIgnoreCase("OneWay")) {
//							if (Stops.equalsIgnoreCase("0")) {
//								if (adult.equalsIgnoreCase("1")) {
//									List<WebElement> listOfRights1 = QaBrowser.driver
//											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//									for (WebElement autoRights1 : listOfRights1) {
//										if (autoRights1.getText().equalsIgnoreCase(Seat1)) {
//											autoRights1.click();
//											QaExtentReport.extentScreenshot("Seat Selection Page");
//											Thread.sleep(5000);
//											break;
//										}
//									}
//								} else if (adult.equalsIgnoreCase("2")) {
//									List<WebElement> listOfRights1 = QaBrowser.driver
//											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//									for (WebElement autoRights1 : listOfRights1) {
//										if (autoRights1.getText().equalsIgnoreCase(Seat1)) {
//											autoRights1.click();
//											QaExtentReport.extentScreenshot("Seat Selection Page");
//											Thread.sleep(5000);
//											break;
//										}
//									}
//									Thread.sleep(3000);
//									QaRobot.ClickOnElement("Seat2");
//									Thread.sleep(3000);
//									List<WebElement> listOfRights2 = QaBrowser.driver
//											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//									for (WebElement autoRights2 : listOfRights2) {
//										if (autoRights2.getText().equalsIgnoreCase(Seat2)) {
//											autoRights2.click();
//											QaExtentReport.extentScreenshot("Seat Selection Page");
//											Thread.sleep(5000);
//											break;
//										}
//									}
//								} else if (adult.equalsIgnoreCase("3")) {
//									List<WebElement> listOfRights1 = QaBrowser.driver
//											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//									for (WebElement autoRights1 : listOfRights1) {
//										if (autoRights1.getText().equalsIgnoreCase(Seat1)) {
//											autoRights1.click();
//											QaExtentReport.extentScreenshot("Seat Selection Page");
//											Thread.sleep(5000);
//											break;
//										}
//									}
//									Thread.sleep(3000);
//									QaRobot.ClickOnElement("Seat2");
//									Thread.sleep(3000);
//									List<WebElement> listOfRights2 = QaBrowser.driver
//											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//									for (WebElement autoRights2 : listOfRights2) {
//										if (autoRights2.getText().equalsIgnoreCase(Seat2)) {
//											autoRights2.click();
//											QaExtentReport.extentScreenshot("Seat Selection Page");
//											Thread.sleep(5000);
//											break;
//										}
//									}
//									Thread.sleep(3000);
//									QaRobot.ClickOnElement("Seat3");
//									Thread.sleep(3000);
//									List<WebElement> listOfRights3 = QaBrowser.driver
//											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//									for (WebElement autoRights3 : listOfRights3) {
//										if (autoRights3.getText().equalsIgnoreCase(Seat3)) {
//											autoRights3.click();
//											QaExtentReport.extentScreenshot("Seat Selection Page");
//											Thread.sleep(5000);
//											break;
//										}
//									}
//								}
//								if (child.equalsIgnoreCase("1")) {
//									if (adult.equalsIgnoreCase("1")) {
//										Thread.sleep(3000);
//										QaRobot.ClickOnElement("Seat2");
//										Thread.sleep(3000);
//									} else if (adult.equalsIgnoreCase("2")) {
//										Thread.sleep(3000);
//										QaRobot.ClickOnElement("Seat3");
//										Thread.sleep(3000);
//									}
//									List<WebElement> listOfRights1 = QaBrowser.driver
//											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//									for (WebElement autoRights1 : listOfRights1) {
//										if (autoRights1.getText().equalsIgnoreCase(CSeat1)) {
//											autoRights1.click();
//											QaExtentReport.extentScreenshot("Seat Selection Page");
//											Thread.sleep(5000);
//											break;
//										}
//									}
//								} else if (child.equalsIgnoreCase("2")) {
//									if (adult.equalsIgnoreCase("1")) {
//										Thread.sleep(3000);
//										QaRobot.ClickOnElement("Seat2");
//										Thread.sleep(3000);
//										List<WebElement> listOfRights1 = QaBrowser.driver
//												.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//										for (WebElement autoRights1 : listOfRights1) {
//											if (autoRights1.getText().equalsIgnoreCase(CSeat1)) {
//												autoRights1.click();
//												QaExtentReport.extentScreenshot("Seat Selection Page");
//												Thread.sleep(5000);
//												break;
//											}
//										}
//										Thread.sleep(3000);
//										QaRobot.ClickOnElement("Seat3");
//										List<WebElement> listOfRights2 = QaBrowser.driver
//												.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//										for (WebElement autoRights2 : listOfRights2) {
//											if (autoRights2.getText().equalsIgnoreCase(CSeat2)) {
//												autoRights2.click();
//												QaExtentReport.extentScreenshot("Seat Selection Page");
//												Thread.sleep(5000);
//												break;
//											}
//										}
//									} else if (adult.equalsIgnoreCase("2")) {
//										Thread.sleep(3000);
//										QaRobot.ClickOnElement("Seat3");
//										Thread.sleep(3000);
//										List<WebElement> listOfRights1 = QaBrowser.driver
//												.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//										for (WebElement autoRights1 : listOfRights1) {
//											if (autoRights1.getText().equalsIgnoreCase(CSeat1)) {
//												autoRights1.click();
//												QaExtentReport.extentScreenshot("Seat Selection Page");
//												Thread.sleep(5000);
//												break;
//											}
//										}
//										Thread.sleep(3000);
//										QaRobot.ClickOnElement("Seat4");
//										List<WebElement> listOfRights2 = QaBrowser.driver
//												.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//										for (WebElement autoRights2 : listOfRights2) {
//											if (autoRights2.getText().equalsIgnoreCase(CSeat2)) {
//												autoRights2.click();
//												QaExtentReport.extentScreenshot("Seat Selection Page");
//												Thread.sleep(5000);
//												break;
//											}
//										}
//									}
//								}
//								QaRobot.ClickOnElement("OW_ContinueBooking");
//							} else if (Stops.equalsIgnoreCase("1")) {
//								if (adult.equalsIgnoreCase("1")) {
//									List<WebElement> listOfRights1 = QaBrowser.driver
//											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//									for (WebElement autoRights1 : listOfRights1) {
//										if (autoRights1.getText().equalsIgnoreCase(Seat1)) {
//											autoRights1.click();
//											QaExtentReport.extentScreenshot("Seat Selection Page");
//											Thread.sleep(5000);
//											break;
//										}
//									}
//								} else if (adult.equalsIgnoreCase("2")) {
//									List<WebElement> listOfRights1 = QaBrowser.driver
//											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//									for (WebElement autoRights1 : listOfRights1) {
//										if (autoRights1.getText().equalsIgnoreCase(Seat1)) {
//											autoRights1.click();
//											QaExtentReport.extentScreenshot("Seat Selection Page");
//											Thread.sleep(5000);
//											break;
//										}
//									}
//									Thread.sleep(3000);
//									QaRobot.ClickOnElement("Seat2");
//									Thread.sleep(3000);
//									List<WebElement> listOfRights2 = QaBrowser.driver
//											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//									for (WebElement autoRights2 : listOfRights2) {
//										if (autoRights2.getText().equalsIgnoreCase(Seat2)) {
//											autoRights2.click();
//											QaExtentReport.extentScreenshot("Seat Selection Page");
//											Thread.sleep(5000);
//											break;
//										}
//									}
//								} else if (adult.equalsIgnoreCase("3")) {
//									List<WebElement> listOfRights1 = QaBrowser.driver
//											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//									for (WebElement autoRights1 : listOfRights1) {
//										if (autoRights1.getText().equalsIgnoreCase(Seat1)) {
//											autoRights1.click();
//											QaExtentReport.extentScreenshot("Seat Selection Page");
//											Thread.sleep(5000);
//											break;
//										}
//									}
//									Thread.sleep(3000);
//									QaRobot.ClickOnElement("Seat2");
//									Thread.sleep(3000);
//									List<WebElement> listOfRights2 = QaBrowser.driver
//											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//									for (WebElement autoRights2 : listOfRights2) {
//										if (autoRights2.getText().equalsIgnoreCase(Seat2)) {
//											autoRights2.click();
//											QaExtentReport.extentScreenshot("Seat Selection Page");
//											Thread.sleep(5000);
//											break;
//										}
//									}
//									Thread.sleep(3000);
//									QaRobot.ClickOnElement("Seat3");
//									Thread.sleep(3000);
//									List<WebElement> listOfRights3 = QaBrowser.driver
//											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//									for (WebElement autoRights3 : listOfRights3) {
//										if (autoRights3.getText().equalsIgnoreCase(Seat3)) {
//											autoRights3.click();
//											QaExtentReport.extentScreenshot("Seat Selection Page");
//											Thread.sleep(5000);
//											break;
//										}
//									}
//								}
//								if (child.equalsIgnoreCase("1")) {
//									if (adult.equalsIgnoreCase("1")) {
//										Thread.sleep(3000);
//										QaRobot.ClickOnElement("Seat2");
//										Thread.sleep(3000);
//									} else if (adult.equalsIgnoreCase("2")) {
//										Thread.sleep(3000);
//										QaRobot.ClickOnElement("Seat3");
//										Thread.sleep(3000);
//									}
//									List<WebElement> listOfRights1 = QaBrowser.driver
//											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//									for (WebElement autoRights1 : listOfRights1) {
//										if (autoRights1.getText().equalsIgnoreCase(CSeat1)) {
//											autoRights1.click();
//											QaExtentReport.extentScreenshot("Seat Selection Page");
//											Thread.sleep(5000);
//											break;
//										}
//									}
//								} else if (child.equalsIgnoreCase("2")) {
//									if (adult.equalsIgnoreCase("1")) {
//										Thread.sleep(3000);
//										QaRobot.ClickOnElement("Seat2");
//										Thread.sleep(3000);
//										List<WebElement> listOfRights1 = QaBrowser.driver
//												.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//										for (WebElement autoRights1 : listOfRights1) {
//											if (autoRights1.getText().equalsIgnoreCase(CSeat1)) {
//												autoRights1.click();
//												QaExtentReport.extentScreenshot("Seat Selection Page");
//												Thread.sleep(5000);
//												break;
//											}
//										}
//										Thread.sleep(3000);
//										QaRobot.ClickOnElement("Seat3");
//										List<WebElement> listOfRights2 = QaBrowser.driver
//												.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//										for (WebElement autoRights2 : listOfRights2) {
//											if (autoRights2.getText().equalsIgnoreCase(CSeat2)) {
//												autoRights2.click();
//												QaExtentReport.extentScreenshot("Seat Selection Page");
//												Thread.sleep(5000);
//												break;
//											}
//										}
//									} else if (adult.equalsIgnoreCase("2")) {
//										Thread.sleep(3000);
//										QaRobot.ClickOnElement("Seat3");
//										Thread.sleep(3000);
//										List<WebElement> listOfRights1 = QaBrowser.driver
//												.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//										for (WebElement autoRights1 : listOfRights1) {
//											if (autoRights1.getText().equalsIgnoreCase(CSeat1)) {
//												autoRights1.click();
//												QaExtentReport.extentScreenshot("Seat Selection Page");
//												Thread.sleep(5000);
//												break;
//											}
//										}
//										Thread.sleep(3000);
//										QaRobot.ClickOnElement("Seat4");
//										List<WebElement> listOfRights2 = QaBrowser.driver
//												.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//										for (WebElement autoRights2 : listOfRights2) {
//											if (autoRights2.getText().equalsIgnoreCase(CSeat2)) {
//												autoRights2.click();
//												QaExtentReport.extentScreenshot("Seat Selection Page");
//												Thread.sleep(5000);
//												break;
//											}
//										}
//									}
//								}
//								QaRobot.ClickOnElement("OW_ContinueBooking");
//								Thread.sleep(5000);
//								if (adult.equalsIgnoreCase("1")) {
//									List<WebElement> listOfRights1 = QaBrowser.driver
//											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//									for (WebElement autoRights1 : listOfRights1) {
//										if (autoRights1.getText().equalsIgnoreCase(Seat1)) {
//											autoRights1.click();
//											QaExtentReport.extentScreenshot("Seat Selection Page");
//											Thread.sleep(5000);
//											break;
//										}
//									}
//								} else if (adult.equalsIgnoreCase("2")) {
//									List<WebElement> listOfRights1 = QaBrowser.driver
//											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//									for (WebElement autoRights1 : listOfRights1) {
//										if (autoRights1.getText().equalsIgnoreCase(Seat1)) {
//											autoRights1.click();
//											QaExtentReport.extentScreenshot("Seat Selection Page");
//											Thread.sleep(5000);
//											break;
//										}
//									}
//									Thread.sleep(3000);
//									QaRobot.ClickOnElement("Seat5");
//									Thread.sleep(3000);
//									List<WebElement> listOfRights2 = QaBrowser.driver
//											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//									for (WebElement autoRights2 : listOfRights2) {
//										if (autoRights2.getText().equalsIgnoreCase(Seat2)) {
//											autoRights2.click();
//											QaExtentReport.extentScreenshot("Seat Selection Page");
//											Thread.sleep(5000);
//											break;
//										}
//									}
//								} else if (adult.equalsIgnoreCase("3")) {
//									List<WebElement> listOfRights1 = QaBrowser.driver
//											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//									for (WebElement autoRights1 : listOfRights1) {
//										if (autoRights1.getText().equalsIgnoreCase(Seat1)) {
//											autoRights1.click();
//											QaExtentReport.extentScreenshot("Seat Selection Page");
//											Thread.sleep(5000);
//											break;
//										}
//									}
//									Thread.sleep(3000);
//									QaRobot.ClickOnElement("Seat5");
//									Thread.sleep(3000);
//									List<WebElement> listOfRights2 = QaBrowser.driver
//											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//									for (WebElement autoRights2 : listOfRights2) {
//										if (autoRights2.getText().equalsIgnoreCase(Seat2)) {
//											autoRights2.click();
//											QaExtentReport.extentScreenshot("Seat Selection Page");
//											Thread.sleep(5000);
//											break;
//										}
//									}
//									Thread.sleep(3000);
//									QaRobot.ClickOnElement("Seat6");
//									Thread.sleep(3000);
//									List<WebElement> listOfRights3 = QaBrowser.driver
//											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//									for (WebElement autoRights3 : listOfRights3) {
//										if (autoRights3.getText().equalsIgnoreCase(Seat3)) {
//											autoRights3.click();
//											QaExtentReport.extentScreenshot("Seat Selection Page");
//											Thread.sleep(5000);
//											break;
//										}
//									}
//								}
//								if (child.equalsIgnoreCase("1")) {
//									if (adult.equalsIgnoreCase("1")) {
//										Thread.sleep(3000);
//										QaRobot.ClickOnElement("Seat5");
//										Thread.sleep(3000);
//									} else if (adult.equalsIgnoreCase("2")) {
//										Thread.sleep(3000);
//										QaRobot.ClickOnElement("Seat6");
//										Thread.sleep(3000);
//									}
//									List<WebElement> listOfRights1 = QaBrowser.driver
//											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//									for (WebElement autoRights1 : listOfRights1) {
//										if (autoRights1.getText().equalsIgnoreCase(CSeat1)) {
//											autoRights1.click();
//											QaExtentReport.extentScreenshot("Seat Selection Page");
//											Thread.sleep(5000);
//											break;
//										}
//									}
//								} else if (child.equalsIgnoreCase("2")) {
//									if (adult.equalsIgnoreCase("1")) {
//										Thread.sleep(3000);
//										QaRobot.ClickOnElement("Seat2");
//										Thread.sleep(3000);
//										List<WebElement> listOfRights1 = QaBrowser.driver
//												.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//										for (WebElement autoRights1 : listOfRights1) {
//											if (autoRights1.getText().equalsIgnoreCase(CSeat1)) {
//												autoRights1.click();
//												QaExtentReport.extentScreenshot("Seat Selection Page");
//												Thread.sleep(5000);
//												break;
//											}
//										}
//										Thread.sleep(3000);
//										QaRobot.ClickOnElement("Seat3");
//										List<WebElement> listOfRights2 = QaBrowser.driver
//												.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//										for (WebElement autoRights2 : listOfRights2) {
//											if (autoRights2.getText().equalsIgnoreCase(CSeat2)) {
//												autoRights2.click();
//												QaExtentReport.extentScreenshot("Seat Selection Page");
//												Thread.sleep(5000);
//												break;
//											}
//										}
//									} else if (adult.equalsIgnoreCase("2")) {
//										Thread.sleep(3000);
//										QaRobot.ClickOnElement("Seat3");
//										Thread.sleep(3000);
//										List<WebElement> listOfRights1 = QaBrowser.driver
//												.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//										for (WebElement autoRights1 : listOfRights1) {
//											if (autoRights1.getText().equalsIgnoreCase(CSeat1)) {
//												autoRights1.click();
//												QaExtentReport.extentScreenshot("Seat Selection Page");
//												Thread.sleep(5000);
//												break;
//											}
//										}
//										Thread.sleep(3000);
//										QaRobot.ClickOnElement("Seat4");
//										List<WebElement> listOfRights2 = QaBrowser.driver
//												.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//										for (WebElement autoRights2 : listOfRights2) {
//											if (autoRights2.getText().equalsIgnoreCase(CSeat2)) {
//												autoRights2.click();
//												QaExtentReport.extentScreenshot("Seat Selection Page");
//												Thread.sleep(5000);
//												break;
//											}
//										}
//									}
//								}
//								QaRobot.ClickOnElement("OW_ContinueBooking");
//							} else if (Stops.equalsIgnoreCase("2")) {
//								List<WebElement> listOfRights1 = QaBrowser.driver
//										.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//								for (WebElement autoRights1 : listOfRights1) {
//									if (autoRights1.getText().equalsIgnoreCase(Seat1)) {
//										autoRights1.click();
//										QaExtentReport.extentScreenshot("Seat Selection Page");
//										Thread.sleep(5000);
//										QaRobot.ClickOnElement("OW_ContinueBooking");
//										break;
//									}
//								}
//								Thread.sleep(3000);
//								List<WebElement> listOfRights2 = QaBrowser.driver
//										.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//								for (WebElement autoRights2 : listOfRights2) {
//									if (autoRights2.getText().equalsIgnoreCase(Seat2)) {
//										autoRights2.click();
//										QaExtentReport.extentScreenshot("Seat Selection Page");
//										Thread.sleep(5000);
//										QaRobot.ClickOnElement("OW_ContinueBooking");
//										break;
//									}
//								}
//								Thread.sleep(3000);
//								List<WebElement> listOfRights3 = QaBrowser.driver
//										.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//								for (WebElement autoRights3 : listOfRights3) {
//									if (autoRights3.getText().equalsIgnoreCase(Seat3)) {
//										autoRights3.click();
//										QaExtentReport.extentScreenshot("Seat Selection Page");
//										Thread.sleep(5000);
//										QaRobot.ClickOnElement("OW_ContinueBooking");
//										break;
//									}
//								}
//							}
//						} else if (Trip.equalsIgnoreCase("RoundTrip")) {
//							if (Stops.equalsIgnoreCase("0")) {
//								if (adult.equalsIgnoreCase("1")) {
//									List<WebElement> listOfRights1 = QaBrowser.driver
//											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//									for (WebElement autoRights1 : listOfRights1) {
//										if (autoRights1.getText().equalsIgnoreCase(Seat1)) {
//											autoRights1.click();
//											QaExtentReport.extentScreenshot("Seat Selection Page");
//											Thread.sleep(5000);
//											break;
//										}
//									}
//								} else if (adult.equalsIgnoreCase("2")) {
//									List<WebElement> listOfRights1 = QaBrowser.driver
//											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//									for (WebElement autoRights1 : listOfRights1) {
//										if (autoRights1.getText().equalsIgnoreCase(Seat1)) {
//											autoRights1.click();
//											QaExtentReport.extentScreenshot("Seat Selection Page");
//											Thread.sleep(5000);
//											break;
//										}
//									}
//									Thread.sleep(3000);
//									QaRobot.ClickOnElement("Seat2");
//									Thread.sleep(3000);
//									List<WebElement> listOfRights2 = QaBrowser.driver
//											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//									for (WebElement autoRights2 : listOfRights2) {
//										if (autoRights2.getText().equalsIgnoreCase(Seat2)) {
//											autoRights2.click();
//											QaExtentReport.extentScreenshot("Seat Selection Page");
//											Thread.sleep(5000);
//											break;
//										}
//									}
//								} else if (adult.equalsIgnoreCase("3")) {
//									List<WebElement> listOfRights1 = QaBrowser.driver
//											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//									for (WebElement autoRights1 : listOfRights1) {
//										if (autoRights1.getText().equalsIgnoreCase(Seat1)) {
//											autoRights1.click();
//											QaExtentReport.extentScreenshot("Seat Selection Page");
//											Thread.sleep(5000);
//											break;
//										}
//									}
//									Thread.sleep(3000);
//									QaRobot.ClickOnElement("Seat2");
//									Thread.sleep(3000);
//									List<WebElement> listOfRights2 = QaBrowser.driver
//											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//									for (WebElement autoRights2 : listOfRights2) {
//										if (autoRights2.getText().equalsIgnoreCase(Seat2)) {
//											autoRights2.click();
//											QaExtentReport.extentScreenshot("Seat Selection Page");
//											Thread.sleep(5000);
//											break;
//										}
//									}
//									Thread.sleep(3000);
//									QaRobot.ClickOnElement("Seat3");
//									Thread.sleep(3000);
//									List<WebElement> listOfRights3 = QaBrowser.driver
//											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//									for (WebElement autoRights3 : listOfRights3) {
//										if (autoRights3.getText().equalsIgnoreCase(Seat3)) {
//											autoRights3.click();
//											QaExtentReport.extentScreenshot("Seat Selection Page");
//											Thread.sleep(5000);
//											break;
//										}
//									}
//								}
//								if (child.equalsIgnoreCase("1")) {
//									if (adult.equalsIgnoreCase("1")) {
//										Thread.sleep(3000);
//										QaRobot.ClickOnElement("Seat2");
//										Thread.sleep(3000);
//									} else if (adult.equalsIgnoreCase("2")) {
//										Thread.sleep(3000);
//										QaRobot.ClickOnElement("Seat3");
//										Thread.sleep(3000);
//									}
//									List<WebElement> listOfRights1 = QaBrowser.driver
//											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//									for (WebElement autoRights1 : listOfRights1) {
//										if (autoRights1.getText().equalsIgnoreCase(CSeat1)) {
//											autoRights1.click();
//											QaExtentReport.extentScreenshot("Seat Selection Page");
//											Thread.sleep(5000);
//											break;
//										}
//									}
//								} else if (child.equalsIgnoreCase("2")) {
//									if (adult.equalsIgnoreCase("1")) {
//										Thread.sleep(3000);
//										QaRobot.ClickOnElement("Seat2");
//										Thread.sleep(3000);
//										List<WebElement> listOfRights1 = QaBrowser.driver
//												.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//										for (WebElement autoRights1 : listOfRights1) {
//											if (autoRights1.getText().equalsIgnoreCase(CSeat1)) {
//												autoRights1.click();
//												QaExtentReport.extentScreenshot("Seat Selection Page");
//												Thread.sleep(5000);
//												break;
//											}
//										}
//										Thread.sleep(3000);
//										QaRobot.ClickOnElement("Seat3");
//										List<WebElement> listOfRights2 = QaBrowser.driver
//												.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//										for (WebElement autoRights2 : listOfRights2) {
//											if (autoRights2.getText().equalsIgnoreCase(CSeat2)) {
//												autoRights2.click();
//												QaExtentReport.extentScreenshot("Seat Selection Page");
//												Thread.sleep(5000);
//												break;
//											}
//										}
//									} else if (adult.equalsIgnoreCase("2")) {
//										Thread.sleep(3000);
//										QaRobot.ClickOnElement("Seat3");
//										Thread.sleep(3000);
//										List<WebElement> listOfRights1 = QaBrowser.driver
//												.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//										for (WebElement autoRights1 : listOfRights1) {
//											if (autoRights1.getText().equalsIgnoreCase(CSeat1)) {
//												autoRights1.click();
//												QaExtentReport.extentScreenshot("Seat Selection Page");
//												Thread.sleep(5000);
//												break;
//											}
//										}
//										Thread.sleep(3000);
//										QaRobot.ClickOnElement("Seat4");
//										List<WebElement> listOfRights2 = QaBrowser.driver
//												.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//										for (WebElement autoRights2 : listOfRights2) {
//											if (autoRights2.getText().equalsIgnoreCase(CSeat2)) {
//												autoRights2.click();
//												QaExtentReport.extentScreenshot("Seat Selection Page");
//												Thread.sleep(5000);
//												break;
//											}
//										}
//									}
//								}
//								QaRobot.ClickOnElement("OW_ContinueBooking");
//								Thread.sleep(3000);
//								if (adult.equalsIgnoreCase("1")) {
//									List<WebElement> listOfRights1 = QaBrowser.driver
//											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//									for (WebElement autoRights1 : listOfRights1) {
//										if (autoRights1.getText().equalsIgnoreCase(Seat1)) {
//											autoRights1.click();
//											QaExtentReport.extentScreenshot("Seat Selection Page");
//											Thread.sleep(5000);
//											break;
//										}
//									}
//								} else if (adult.equalsIgnoreCase("2")) {
//									List<WebElement> listOfRights1 = QaBrowser.driver
//											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//									for (WebElement autoRights1 : listOfRights1) {
//										if (autoRights1.getText().equalsIgnoreCase(Seat1)) {
//											autoRights1.click();
//											QaExtentReport.extentScreenshot("Seat Selection Page");
//											Thread.sleep(5000);
//											break;
//										}
//									}
//									Thread.sleep(3000);
//									QaRobot.ClickOnElement("Seat5");
//									Thread.sleep(3000);
//									List<WebElement> listOfRights2 = QaBrowser.driver
//											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//									for (WebElement autoRights2 : listOfRights2) {
//										if (autoRights2.getText().equalsIgnoreCase(Seat2)) {
//											autoRights2.click();
//											QaExtentReport.extentScreenshot("Seat Selection Page");
//											Thread.sleep(5000);
//											break;
//										}
//									}
//								} else if (adult.equalsIgnoreCase("3")) {
//									List<WebElement> listOfRights1 = QaBrowser.driver
//											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//									for (WebElement autoRights1 : listOfRights1) {
//										if (autoRights1.getText().equalsIgnoreCase(Seat1)) {
//											autoRights1.click();
//											QaExtentReport.extentScreenshot("Seat Selection Page");
//											Thread.sleep(5000);
//											break;
//										}
//									}
//									Thread.sleep(3000);
//									QaRobot.ClickOnElement("Seat5");
//									Thread.sleep(3000);
//									List<WebElement> listOfRights2 = QaBrowser.driver
//											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//									for (WebElement autoRights2 : listOfRights2) {
//										if (autoRights2.getText().equalsIgnoreCase(Seat2)) {
//											autoRights2.click();
//											QaExtentReport.extentScreenshot("Seat Selection Page");
//											Thread.sleep(5000);
//											break;
//										}
//									}
//									Thread.sleep(3000);
//									QaRobot.ClickOnElement("Seat6");
//									Thread.sleep(3000);
//									List<WebElement> listOfRights3 = QaBrowser.driver
//											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//									for (WebElement autoRights3 : listOfRights3) {
//										if (autoRights3.getText().equalsIgnoreCase(Seat3)) {
//											autoRights3.click();
//											QaExtentReport.extentScreenshot("Seat Selection Page");
//											Thread.sleep(5000);
//											break;
//										}
//									}
//								}
//								if (child.equalsIgnoreCase("1")) {
//									if (adult.equalsIgnoreCase("1")) {
//										Thread.sleep(3000);
//										QaRobot.ClickOnElement("Seat4");
//										Thread.sleep(3000);
//									} else if (adult.equalsIgnoreCase("2")) {
//										Thread.sleep(3000);
//										QaRobot.ClickOnElement("Seat6");
//										Thread.sleep(3000);
//									}
//									List<WebElement> listOfRights1 = QaBrowser.driver
//											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//									for (WebElement autoRights1 : listOfRights1) {
//										if (autoRights1.getText().equalsIgnoreCase(CSeat1)) {
//											autoRights1.click();
//											QaExtentReport.extentScreenshot("Seat Selection Page");
//											Thread.sleep(5000);
//											break;
//										}
//									}
//								} else if (child.equalsIgnoreCase("2")) {
//									if (adult.equalsIgnoreCase("1")) {
//										Thread.sleep(3000);
//										QaRobot.ClickOnElement("Seat4");
//										Thread.sleep(3000);
//										List<WebElement> listOfRights1 = QaBrowser.driver
//												.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//										for (WebElement autoRights1 : listOfRights1) {
//											if (autoRights1.getText().equalsIgnoreCase(CSeat1)) {
//												autoRights1.click();
//												QaExtentReport.extentScreenshot("Seat Selection Page");
//												Thread.sleep(5000);
//												break;
//											}
//										}
//										Thread.sleep(3000);
//										QaRobot.ClickOnElement("Seat5");
//										List<WebElement> listOfRights2 = QaBrowser.driver
//												.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//										for (WebElement autoRights2 : listOfRights2) {
//											if (autoRights2.getText().equalsIgnoreCase(CSeat2)) {
//												autoRights2.click();
//												QaExtentReport.extentScreenshot("Seat Selection Page");
//												Thread.sleep(5000);
//												break;
//											}
//										}
//									} else if (adult.equalsIgnoreCase("2")) {
//										Thread.sleep(3000);
//										QaRobot.ClickOnElement("Seat5");
//										Thread.sleep(3000);
//										List<WebElement> listOfRights1 = QaBrowser.driver
//												.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//										for (WebElement autoRights1 : listOfRights1) {
//											if (autoRights1.getText().equalsIgnoreCase(CSeat1)) {
//												autoRights1.click();
//												QaExtentReport.extentScreenshot("Seat Selection Page");
//												Thread.sleep(5000);
//												break;
//											}
//										}
//										Thread.sleep(3000);
//										QaRobot.ClickOnElement("Seat6");
//										List<WebElement> listOfRights2 = QaBrowser.driver
//												.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//										for (WebElement autoRights2 : listOfRights2) {
//											if (autoRights2.getText().equalsIgnoreCase(CSeat2)) {
//												autoRights2.click();
//												QaExtentReport.extentScreenshot("Seat Selection Page");
//												Thread.sleep(5000);
//												break;
//											}
//										}
//									}
//								}
//								QaRobot.ClickOnElement("OW_ContinueBooking");
//							} else if (Stops.equalsIgnoreCase("1")) {
//								if (adult.equalsIgnoreCase("1")) {
//									List<WebElement> listOfRights1 = QaBrowser.driver
//											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//									for (WebElement autoRights1 : listOfRights1) {
//										if (autoRights1.getText().equalsIgnoreCase(Seat1)) {
//											autoRights1.click();
//											QaExtentReport.extentScreenshot("Seat Selection Page");
//											Thread.sleep(5000);
//											break;
//										}
//									}
//								} else if (adult.equalsIgnoreCase("2")) {
//									List<WebElement> listOfRights1 = QaBrowser.driver
//											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//									for (WebElement autoRights1 : listOfRights1) {
//										if (autoRights1.getText().equalsIgnoreCase(Seat1)) {
//											autoRights1.click();
//											QaExtentReport.extentScreenshot("Seat Selection Page");
//											Thread.sleep(5000);
//											break;
//										}
//									}
//									Thread.sleep(3000);
//									QaRobot.ClickOnElement("Seat2");
//									Thread.sleep(3000);
//									List<WebElement> listOfRights2 = QaBrowser.driver
//											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//									for (WebElement autoRights2 : listOfRights2) {
//										if (autoRights2.getText().equalsIgnoreCase(Seat2)) {
//											autoRights2.click();
//											QaExtentReport.extentScreenshot("Seat Selection Page");
//											Thread.sleep(5000);
//											break;
//										}
//									}
//								} else if (adult.equalsIgnoreCase("3")) {
//									List<WebElement> listOfRights1 = QaBrowser.driver
//											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//									for (WebElement autoRights1 : listOfRights1) {
//										if (autoRights1.getText().equalsIgnoreCase(Seat1)) {
//											autoRights1.click();
//											QaExtentReport.extentScreenshot("Seat Selection Page");
//											Thread.sleep(5000);
//											break;
//										}
//									}
//									Thread.sleep(3000);
//									QaRobot.ClickOnElement("Seat2");
//									Thread.sleep(3000);
//									List<WebElement> listOfRights2 = QaBrowser.driver
//											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//									for (WebElement autoRights2 : listOfRights2) {
//										if (autoRights2.getText().equalsIgnoreCase(Seat2)) {
//											autoRights2.click();
//											QaExtentReport.extentScreenshot("Seat Selection Page");
//											Thread.sleep(5000);
//											break;
//										}
//									}
//									Thread.sleep(3000);
//									QaRobot.ClickOnElement("Seat3");
//									Thread.sleep(3000);
//									List<WebElement> listOfRights3 = QaBrowser.driver
//											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//									for (WebElement autoRights3 : listOfRights3) {
//										if (autoRights3.getText().equalsIgnoreCase(Seat3)) {
//											autoRights3.click();
//											QaExtentReport.extentScreenshot("Seat Selection Page");
//											Thread.sleep(5000);
//											break;
//										}
//									}
//								}
//								if (child.equalsIgnoreCase("1")) {
//									if (adult.equalsIgnoreCase("1")) {
//										Thread.sleep(3000);
//										QaRobot.ClickOnElement("Seat2");
//										Thread.sleep(3000);
//									} else if (adult.equalsIgnoreCase("2")) {
//										Thread.sleep(3000);
//										QaRobot.ClickOnElement("Seat3");
//										Thread.sleep(3000);
//									}
//									List<WebElement> listOfRights1 = QaBrowser.driver
//											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//									for (WebElement autoRights1 : listOfRights1) {
//										if (autoRights1.getText().equalsIgnoreCase(CSeat1)) {
//											autoRights1.click();
//											QaExtentReport.extentScreenshot("Seat Selection Page");
//											Thread.sleep(5000);
//											break;
//										}
//									}
//								} else if (child.equalsIgnoreCase("2")) {
//									if (adult.equalsIgnoreCase("1")) {
//										Thread.sleep(3000);
//										QaRobot.ClickOnElement("Seat2");
//										Thread.sleep(3000);
//										List<WebElement> listOfRights1 = QaBrowser.driver
//												.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//										for (WebElement autoRights1 : listOfRights1) {
//											if (autoRights1.getText().equalsIgnoreCase(CSeat1)) {
//												autoRights1.click();
//												QaExtentReport.extentScreenshot("Seat Selection Page");
//												Thread.sleep(5000);
//												break;
//											}
//										}
//										Thread.sleep(3000);
//										QaRobot.ClickOnElement("Seat3");
//										List<WebElement> listOfRights2 = QaBrowser.driver
//												.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//										for (WebElement autoRights2 : listOfRights2) {
//											if (autoRights2.getText().equalsIgnoreCase(CSeat2)) {
//												autoRights2.click();
//												QaExtentReport.extentScreenshot("Seat Selection Page");
//												Thread.sleep(5000);
//												break;
//											}
//										}
//									} else if (adult.equalsIgnoreCase("2")) {
//										Thread.sleep(3000);
//										QaRobot.ClickOnElement("Seat3");
//										Thread.sleep(3000);
//										List<WebElement> listOfRights1 = QaBrowser.driver
//												.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//										for (WebElement autoRights1 : listOfRights1) {
//											if (autoRights1.getText().equalsIgnoreCase(CSeat1)) {
//												autoRights1.click();
//												QaExtentReport.extentScreenshot("Seat Selection Page");
//												Thread.sleep(5000);
//												break;
//											}
//										}
//										Thread.sleep(3000);
//										QaRobot.ClickOnElement("Seat4");
//										List<WebElement> listOfRights2 = QaBrowser.driver
//												.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//										for (WebElement autoRights2 : listOfRights2) {
//											if (autoRights2.getText().equalsIgnoreCase(CSeat2)) {
//												autoRights2.click();
//												QaExtentReport.extentScreenshot("Seat Selection Page");
//												Thread.sleep(5000);
//												break;
//											}
//										}
//									}
//								}
//								QaRobot.ClickOnElement("OW_ContinueBooking");
//								Thread.sleep(5000);
//								QaRobot.ClickOnElement("Seat4");
//								Thread.sleep(3000);
//								if (adult.equalsIgnoreCase("1")) {
//									List<WebElement> listOfRights1 = QaBrowser.driver
//											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//									for (WebElement autoRights1 : listOfRights1) {
//										if (autoRights1.getText().equalsIgnoreCase(Seat2)) {
//											autoRights1.click();
//											QaExtentReport.extentScreenshot("Seat Selection Page");
//											Thread.sleep(5000);
//											break;
//										}
//									}
//								} else if (adult.equalsIgnoreCase("2")) {
//									List<WebElement> listOfRights1 = QaBrowser.driver
//											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//									for (WebElement autoRights1 : listOfRights1) {
//										if (autoRights1.getText().equalsIgnoreCase(Seat3)) {
//											autoRights1.click();
//											QaExtentReport.extentScreenshot("Seat Selection Page");
//											Thread.sleep(5000);
//											break;
//										}
//									}
//									Thread.sleep(3000);
//									QaRobot.ClickOnElement("Seat5");
//									Thread.sleep(3000);
//									List<WebElement> listOfRights2 = QaBrowser.driver
//											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//									for (WebElement autoRights2 : listOfRights2) {
//										if (autoRights2.getText().equalsIgnoreCase(Seat4)) {
//											autoRights2.click();
//											QaExtentReport.extentScreenshot("Seat Selection Page");
//											Thread.sleep(5000);
//											break;
//										}
//									}
//								} else if (adult.equalsIgnoreCase("3")) {
//									List<WebElement> listOfRights1 = QaBrowser.driver
//											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//									for (WebElement autoRights1 : listOfRights1) {
//										if (autoRights1.getText().equalsIgnoreCase(Seat2)) {
//											autoRights1.click();
//											QaExtentReport.extentScreenshot("Seat Selection Page");
//											Thread.sleep(5000);
//											break;
//										}
//									}
//									Thread.sleep(3000);
//									QaRobot.ClickOnElement("Seat5");
//									Thread.sleep(3000);
//									List<WebElement> listOfRights2 = QaBrowser.driver
//											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//									for (WebElement autoRights2 : listOfRights2) {
//										if (autoRights2.getText().equalsIgnoreCase(Seat3)) {
//											autoRights2.click();
//											QaExtentReport.extentScreenshot("Seat Selection Page");
//											Thread.sleep(5000);
//											break;
//										}
//									}
//									Thread.sleep(3000);
//									QaRobot.ClickOnElement("Seat6");
//									Thread.sleep(3000);
//									List<WebElement> listOfRights3 = QaBrowser.driver
//											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//									for (WebElement autoRights3 : listOfRights3) {
//										if (autoRights3.getText().equalsIgnoreCase(Seat4)) {
//											autoRights3.click();
//											QaExtentReport.extentScreenshot("Seat Selection Page");
//											Thread.sleep(5000);
//											break;
//										}
//									}
//								}
//								if (child.equalsIgnoreCase("1")) {
//									if (adult.equalsIgnoreCase("1")) {
//										Thread.sleep(3000);
//										QaRobot.ClickOnElement("Seat4");
//										Thread.sleep(3000);
//									} else if (adult.equalsIgnoreCase("2")) {
//										Thread.sleep(3000);
//										QaRobot.ClickOnElement("Seat6");
//										Thread.sleep(3000);
//									}
//									List<WebElement> listOfRights1 = QaBrowser.driver
//											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//									for (WebElement autoRights1 : listOfRights1) {
//										if (autoRights1.getText().equalsIgnoreCase(CSeat2)) {
//											autoRights1.click();
//											QaExtentReport.extentScreenshot("Seat Selection Page");
//											Thread.sleep(5000);
//											break;
//										}
//									}
//								} else if (child.equalsIgnoreCase("2")) {
//									if (adult.equalsIgnoreCase("1")) {
//										Thread.sleep(3000);
//										QaRobot.ClickOnElement("Seat2");
//										Thread.sleep(3000);
//										List<WebElement> listOfRights1 = QaBrowser.driver
//												.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//										for (WebElement autoRights1 : listOfRights1) {
//											if (autoRights1.getText().equalsIgnoreCase(CSeat1)) {
//												autoRights1.click();
//												QaExtentReport.extentScreenshot("Seat Selection Page");
//												Thread.sleep(5000);
//												break;
//											}
//										}
//										Thread.sleep(3000);
//										QaRobot.ClickOnElement("Seat3");
//										List<WebElement> listOfRights2 = QaBrowser.driver
//												.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//										for (WebElement autoRights2 : listOfRights2) {
//											if (autoRights2.getText().equalsIgnoreCase(CSeat2)) {
//												autoRights2.click();
//												QaExtentReport.extentScreenshot("Seat Selection Page");
//												Thread.sleep(5000);
//												break;
//											}
//										}
//									} else if (adult.equalsIgnoreCase("2")) {
//										Thread.sleep(3000);
//										QaRobot.ClickOnElement("Seat3");
//										Thread.sleep(3000);
//										List<WebElement> listOfRights1 = QaBrowser.driver
//												.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//										for (WebElement autoRights1 : listOfRights1) {
//											if (autoRights1.getText().equalsIgnoreCase(CSeat1)) {
//												autoRights1.click();
//												QaExtentReport.extentScreenshot("Seat Selection Page");
//												Thread.sleep(5000);
//												break;
//											}
//										}
//										Thread.sleep(3000);
//										QaRobot.ClickOnElement("Seat4");
//										List<WebElement> listOfRights2 = QaBrowser.driver
//												.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//										for (WebElement autoRights2 : listOfRights2) {
//											if (autoRights2.getText().equalsIgnoreCase(CSeat2)) {
//												autoRights2.click();
//												QaExtentReport.extentScreenshot("Seat Selection Page");
//												Thread.sleep(5000);
//												break;
//											}
//										}
//									}
//								}
//								QaRobot.ClickOnElement("OW_ContinueBooking");
//								Thread.sleep(5000);
//								if (adult.equalsIgnoreCase("1")) {
//									List<WebElement> listOfRights1 = QaBrowser.driver
//											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//									for (WebElement autoRights1 : listOfRights1) {
//										if (autoRights1.getText().equalsIgnoreCase(Seat1)) {
//											autoRights1.click();
//											QaExtentReport.extentScreenshot("Seat Selection Page");
//											Thread.sleep(5000);
//											break;
//										}
//									}
//								} else if (adult.equalsIgnoreCase("2")) {
//									List<WebElement> listOfRights1 = QaBrowser.driver
//											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//									for (WebElement autoRights1 : listOfRights1) {
//										if (autoRights1.getText().equalsIgnoreCase(Seat1)) {
//											autoRights1.click();
//											QaExtentReport.extentScreenshot("Seat Selection Page");
//											Thread.sleep(5000);
//											break;
//										}
//									}
//									Thread.sleep(3000);
//									QaRobot.ClickOnElement("Seat8");
//									Thread.sleep(3000);
//									List<WebElement> listOfRights2 = QaBrowser.driver
//											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//									for (WebElement autoRights2 : listOfRights2) {
//										if (autoRights2.getText().equalsIgnoreCase(Seat2)) {
//											autoRights2.click();
//											QaExtentReport.extentScreenshot("Seat Selection Page");
//											Thread.sleep(5000);
//											break;
//										}
//									}
//								} else if (adult.equalsIgnoreCase("3")) {
//									List<WebElement> listOfRights1 = QaBrowser.driver
//											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//									for (WebElement autoRights1 : listOfRights1) {
//										if (autoRights1.getText().equalsIgnoreCase(Seat1)) {
//											autoRights1.click();
//											QaExtentReport.extentScreenshot("Seat Selection Page");
//											Thread.sleep(5000);
//											break;
//										}
//									}
//									Thread.sleep(3000);
//									QaRobot.ClickOnElement("Seat8");
//									Thread.sleep(3000);
//									List<WebElement> listOfRights2 = QaBrowser.driver
//											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//									for (WebElement autoRights2 : listOfRights2) {
//										if (autoRights2.getText().equalsIgnoreCase(Seat2)) {
//											autoRights2.click();
//											QaExtentReport.extentScreenshot("Seat Selection Page");
//											Thread.sleep(5000);
//											break;
//										}
//									}
//									Thread.sleep(3000);
//									QaRobot.ClickOnElement("Seat9");
//									Thread.sleep(3000);
//									List<WebElement> listOfRights3 = QaBrowser.driver
//											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//									for (WebElement autoRights3 : listOfRights3) {
//										if (autoRights3.getText().equalsIgnoreCase(Seat3)) {
//											autoRights3.click();
//											QaExtentReport.extentScreenshot("Seat Selection Page");
//											Thread.sleep(5000);
//											break;
//										}
//									}
//								}
//								if (child.equalsIgnoreCase("1")) {
//									if (adult.equalsIgnoreCase("1")) {
//										Thread.sleep(3000);
//										QaRobot.ClickOnElement("Seat2");
//										Thread.sleep(3000);
//									} else if (adult.equalsIgnoreCase("2")) {
//										Thread.sleep(3000);
//										QaRobot.ClickOnElement("Seat9");
//										Thread.sleep(3000);
//									}
//									List<WebElement> listOfRights1 = QaBrowser.driver
//											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//									for (WebElement autoRights1 : listOfRights1) {
//										if (autoRights1.getText().equalsIgnoreCase(CSeat1)) {
//											autoRights1.click();
//											QaExtentReport.extentScreenshot("Seat Selection Page");
//											Thread.sleep(5000);
//											break;
//										}
//									}
//								} else if (child.equalsIgnoreCase("2")) {
//									if (adult.equalsIgnoreCase("1")) {
//										Thread.sleep(3000);
//										QaRobot.ClickOnElement("Seat2");
//										Thread.sleep(3000);
//										List<WebElement> listOfRights1 = QaBrowser.driver
//												.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//										for (WebElement autoRights1 : listOfRights1) {
//											if (autoRights1.getText().equalsIgnoreCase(CSeat1)) {
//												autoRights1.click();
//												QaExtentReport.extentScreenshot("Seat Selection Page");
//												Thread.sleep(5000);
//												break;
//											}
//										}
//										Thread.sleep(3000);
//										QaRobot.ClickOnElement("Seat10");
//										List<WebElement> listOfRights2 = QaBrowser.driver
//												.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//										for (WebElement autoRights2 : listOfRights2) {
//											if (autoRights2.getText().equalsIgnoreCase(CSeat2)) {
//												autoRights2.click();
//												QaExtentReport.extentScreenshot("Seat Selection Page");
//												Thread.sleep(5000);
//												break;
//											}
//										}
//									} else if (adult.equalsIgnoreCase("2")) {
//										Thread.sleep(3000);
//										QaRobot.ClickOnElement("Seat3");
//										Thread.sleep(3000);
//										List<WebElement> listOfRights1 = QaBrowser.driver
//												.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//										for (WebElement autoRights1 : listOfRights1) {
//											if (autoRights1.getText().equalsIgnoreCase(CSeat1)) {
//												autoRights1.click();
//												QaExtentReport.extentScreenshot("Seat Selection Page");
//												Thread.sleep(5000);
//												break;
//											}
//										}
//										Thread.sleep(3000);
//										QaRobot.ClickOnElement("Seat10");
//										List<WebElement> listOfRights2 = QaBrowser.driver
//												.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//										for (WebElement autoRights2 : listOfRights2) {
//											if (autoRights2.getText().equalsIgnoreCase(CSeat2)) {
//												autoRights2.click();
//												QaExtentReport.extentScreenshot("Seat Selection Page");
//												Thread.sleep(5000);
//												break;
//											}
//										}
//									}
//								}
//								QaRobot.ClickOnElement("OW_ContinueBooking");
//								Thread.sleep(5000);
//								if (adult.equalsIgnoreCase("1")) {
//									List<WebElement> listOfRights1 = QaBrowser.driver
//											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//									for (WebElement autoRights1 : listOfRights1) {
//										if (autoRights1.getText().equalsIgnoreCase(Seat2)) {
//											autoRights1.click();
//											QaExtentReport.extentScreenshot("Seat Selection Page");
//											Thread.sleep(5000);
//											break;
//										}
//									}
//								} else if (adult.equalsIgnoreCase("2")) {
//									List<WebElement> listOfRights1 = QaBrowser.driver
//											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//									for (WebElement autoRights1 : listOfRights1) {
//										if (autoRights1.getText().equalsIgnoreCase(Seat3)) {
//											autoRights1.click();
//											QaExtentReport.extentScreenshot("Seat Selection Page");
//											Thread.sleep(5000);
//											break;
//										}
//									}
//									Thread.sleep(3000);
//									QaRobot.ClickOnElement("Seat11");
//									Thread.sleep(3000);
//									List<WebElement> listOfRights2 = QaBrowser.driver
//											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//									for (WebElement autoRights2 : listOfRights2) {
//										if (autoRights2.getText().equalsIgnoreCase(Seat4)) {
//											autoRights2.click();
//											QaExtentReport.extentScreenshot("Seat Selection Page");
//											Thread.sleep(5000);
//											break;
//										}
//									}
//								} else if (adult.equalsIgnoreCase("3")) {
//									List<WebElement> listOfRights1 = QaBrowser.driver
//											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//									for (WebElement autoRights1 : listOfRights1) {
//										if (autoRights1.getText().equalsIgnoreCase(Seat2)) {
//											autoRights1.click();
//											QaExtentReport.extentScreenshot("Seat Selection Page");
//											Thread.sleep(5000);
//											break;
//										}
//									}
//									Thread.sleep(3000);
//									QaRobot.ClickOnElement("Seat11");
//									Thread.sleep(3000);
//									List<WebElement> listOfRights2 = QaBrowser.driver
//											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//									for (WebElement autoRights2 : listOfRights2) {
//										if (autoRights2.getText().equalsIgnoreCase(Seat3)) {
//											autoRights2.click();
//											QaExtentReport.extentScreenshot("Seat Selection Page");
//											Thread.sleep(5000);
//											break;
//										}
//									}
//									Thread.sleep(3000);
//									QaRobot.ClickOnElement("Seat12");
//									Thread.sleep(3000);
//									List<WebElement> listOfRights3 = QaBrowser.driver
//											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//									for (WebElement autoRights3 : listOfRights3) {
//										if (autoRights3.getText().equalsIgnoreCase(Seat4)) {
//											autoRights3.click();
//											QaExtentReport.extentScreenshot("Seat Selection Page");
//											Thread.sleep(5000);
//											break;
//										}
//									}
//								}
//								if (child.equalsIgnoreCase("1")) {
//									if (adult.equalsIgnoreCase("1")) {
//										Thread.sleep(3000);
//										QaRobot.ClickOnElement("Seat10");
//										Thread.sleep(3000);
//									} else if (adult.equalsIgnoreCase("2")) {
//										Thread.sleep(3000);
//										QaRobot.ClickOnElement("Seat12");
//										Thread.sleep(3000);
//									}
//									List<WebElement> listOfRights1 = QaBrowser.driver
//											.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//									for (WebElement autoRights1 : listOfRights1) {
//										if (autoRights1.getText().equalsIgnoreCase(CSeat2)) {
//											autoRights1.click();
//											QaExtentReport.extentScreenshot("Seat Selection Page");
//											Thread.sleep(5000);
//											break;
//										}
//									}
//								} else if (child.equalsIgnoreCase("2")) {
//									if (adult.equalsIgnoreCase("1")) {
//										Thread.sleep(3000);
//										QaRobot.ClickOnElement("Seat11");
//										Thread.sleep(3000);
//										List<WebElement> listOfRights1 = QaBrowser.driver
//												.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//										for (WebElement autoRights1 : listOfRights1) {
//											if (autoRights1.getText().equalsIgnoreCase(CSeat1)) {
//												autoRights1.click();
//												QaExtentReport.extentScreenshot("Seat Selection Page");
//												Thread.sleep(5000);
//												break;
//											}
//										}
//										Thread.sleep(3000);
//										QaRobot.ClickOnElement("Seat12");
//										List<WebElement> listOfRights2 = QaBrowser.driver
//												.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//										for (WebElement autoRights2 : listOfRights2) {
//											if (autoRights2.getText().equalsIgnoreCase(CSeat2)) {
//												autoRights2.click();
//												QaExtentReport.extentScreenshot("Seat Selection Page");
//												Thread.sleep(5000);
//												break;
//											}
//										}
//									} else if (adult.equalsIgnoreCase("2")) {
//										Thread.sleep(3000);
//										QaRobot.ClickOnElement("Seat11");
//										Thread.sleep(3000);
//										List<WebElement> listOfRights1 = QaBrowser.driver
//												.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//										for (WebElement autoRights1 : listOfRights1) {
//											if (autoRights1.getText().equalsIgnoreCase(CSeat1)) {
//												autoRights1.click();
//												QaExtentReport.extentScreenshot("Seat Selection Page");
//												Thread.sleep(5000);
//												break;
//											}
//										}
//										Thread.sleep(3000);
//										QaRobot.ClickOnElement("Seat12");
//										List<WebElement> listOfRights2 = QaBrowser.driver
//												.findElements(By.xpath("//div[@id='divLayout']/div//div/a/div"));
//										for (WebElement autoRights2 : listOfRights2) {
//											if (autoRights2.getText().equalsIgnoreCase(CSeat2)) {
//												autoRights2.click();
//												QaExtentReport.extentScreenshot("Seat Selection Page");
//												Thread.sleep(5000);
//												break;
//											}
//										}
//									}
//								}
//							}
//							QaRobot.ClickOnElement("OW_ContinueBooking");
//						}
//					}
//				} else if (SeatSelection.equalsIgnoreCase("No")) {
//					if (ccode.equalsIgnoreCase("sbt")) {
//						String ParentWindow1 = QaBrowser.driver.getWindowHandle();
//						Set<String> handles1 = QaBrowser.driver.getWindowHandles();
//						for (String childWindow1 : handles1) {
//							if (!childWindow1.equals(ParentWindow1))
//								QaBrowser.driver.switchTo().window(childWindow1);
//						}
//						QaRobot.ClickOnElement("SeatNotSelect");
//					} else if (ccode.equalsIgnoreCase("preprod117")) {
//						String ParentWindow1 = QaBrowser.driver.getWindowHandle();
//						Set<String> handles1 = QaBrowser.driver.getWindowHandles();
//						for (String childWindow1 : handles1) {
//							if (!childWindow1.equals(ParentWindow1))
//								QaBrowser.driver.switchTo().window(childWindow1);
//						}
//						QaRobot.ClickOnElement("SeatNotSelect");
////						QaBrowser.driver.switchTo().alert().accept();
//					}
//				}
//				Thread.sleep(10000);
//				String paymentprice = QaBrowser.driver.findElement(By.xpath("//span[@id='ctl00_contentMain_lblTAmt']"))
//						.getText();
//				System.out.println("Price of payment page " + paymentprice);
//				QaExtentReport.test.log(Status.INFO, "<b><i>Price of payment page </i></b>" + paymentprice);
//				// select FOP
//				if (fop.equalsIgnoreCase("Cash")) {
//					SBTCheckoutPayment.fopCash(fop, receiptno);
//				} else if (fop.equalsIgnoreCase("Bill To Company")) {
//					SBTCheckoutPayment.fopBillToComapnay(fop);
//					QaRobot.ClickOnElement("click_OK");
//				} else {
//					SBTCheckoutPayment.fopCreditDebit(card, cardtype, cvv);
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
