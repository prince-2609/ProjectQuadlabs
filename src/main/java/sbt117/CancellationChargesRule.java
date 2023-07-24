package sbt117;

import java.util.List;

import org.openqa.selenium.By;
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
public class CancellationChargesRule {

	@DataProvider
	public Object[][] getexceldata() throws Exception {
		return QaDataProvider.getTestdata("CancellationChargesRule", "Sheet1");
	}

	@Test(dataProvider = "getexceldata")
	public static void cancellationChargesRule(String TestCaseId, String TestCaseType, String TestScenario,
			String Source, String URL, String CompanyCode, String UserName, String Password, String RuleTitle,
			String SelectProduct, String SQty, String Supplier, String SalesChannelQty, String SalesChannel,
			String CriteriaQty, String CriteriaName, String AirQty, String Airlines, String BookDateFrom,
			String BookDateTo, String CabinClassQty, String CabinClass, String OriginFor, String OZqty, String OZone,
			String ORqty, String ORegion, String OCqty, String OCountry, String OCiQty, String OCity, String OAqty,
			String OAirport, String DestinationFor, String Zqty, String Zone, String Rqty, String Region, String Cqty,
			String Country, String CiQty, String City, String CorpQty, String SearchCorporate, String Aqty,
			String Airport, String BClassQty, String BookingClass, String PassengerQty, String Passengers,
			String BaseFareFrom, String BaseFareTo, String FareQty, String Fares, String S_CQty,
			String Subagent_Corporate, String CancellationFee, String CancellationFeeAmount,
			String CancellationFeeAppliedOn, String ReIssueFee, String ReIssueFeeAmount, String ReIssueFeeAppliedOn,
			String CancellationRemark) throws Exception {

		TestBase.Companycode(Source, URL);
		QaExtentReport.test = QaExtentReport.report.createTest(TestCaseId + "-" + TestScenario);
		QaRobot.PassValue("CompanyCode", CompanyCode);
		QaRobot.PassValue("UserName", UserName);
		QaRobot.PassValue("PasswordFD", Password);
		QaExtentReport.extentScreenshot("Sigh In Page");
		QaRobot.ClickOnElement("LogIn");
		QaRobot.switchframe("//frame[@name='login']");
		QaRobot.switchframe("//frame[@name='leftbar']");
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
		WebElement subMenu = QaBrowser.driver.findElement(By.xpath("(/html/body/div/div/table/tbody/tr[6]/td)[1]"));
		subMenu.click();
		QaExtentReport.extentScreenshot("Cancellation Charges Rule");
		QaRobot.ClickOnElement("CCRAddNewRule");
		QaRobot.PassValue("CCRAddTitle", RuleTitle);
		QaRobot.selectTextByLocator("//select[@id='ddlProduct']", SelectProduct);
		if (SelectProduct.equalsIgnoreCase("Hotel")) {
			if (SQty.equalsIgnoreCase("1") || SQty.equalsIgnoreCase("2") || SQty.equalsIgnoreCase("3")
					|| SQty.equalsIgnoreCase("4") || SQty.equalsIgnoreCase("5")) {
				QaRobot.transferData(SQty, Supplier, "//select[@id='ddlSupplier']/option");
			} else if (SQty.equalsIgnoreCase("All")) {
//				QaRobot.ClickOnElement("SelectAllSupplier");
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
			int pAS = Integer.parseInt(CriteriaQty);
			if (CriteriaQty.equalsIgnoreCase("1")) {
				for (int i = 1; i <= pAS; i++) {
					String[] tN = CriteriaName.split(",");
					String b = tN[i - 1];
					QaRobot.selectTextByLocator("//select[@id='key1']", b);
					if (b.equalsIgnoreCase("Airline")) {
						QaRobot.switchToWindow();
						int pA1 = Integer.parseInt(AirQty);
						for (int k = 1; k <= pA1; k++) {
							String[] tN1 = Airlines.split(",");
							String b1 = tN1[k - 1];
							List<WebElement> listOfRights1 = QaBrowser.driver
									.findElements(By.xpath("//select[@id='ListBoxAirlineFiller']/option"));
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
						QaRobot.ClickOnElement("IMDestinationSaveClose");

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

					} else if (b.equalsIgnoreCase("Corporate")) {
						QaRobot.switchToWindow();
						int p1 = Integer.parseInt(CorpQty);
						for (int k = 1; k <= p1; k++) {
							String[] tN1 = SearchCorporate.split(",");
							String b1 = tN1[k - 1];
							QaBrowser.driver.findElement(By.xpath("//input[@id='txtInputTextForCorporate']")).clear();
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
									.findElements(By.xpath("//select[@id='ListBoxPaxType']/option"));
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
							QaBrowser.driver.findElement(By.xpath("//input[@id='txtInputTextForSubagent']")).clear();
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
					if (b.equalsIgnoreCase("Airline")) {
						QaRobot.switchToWindow();
						int pb1 = Integer.parseInt(AirQty);
						for (int k = 1; k <= pb1; k++) {
							String[] tN1 = Airlines.split(",");
							String b1 = tN1[k - 1];
							List<WebElement> listOfRights1 = QaBrowser.driver
									.findElements(By.xpath("//select[@id='ListBoxAirline']/option"));
							for (WebElement autoRights1 : listOfRights1) {
								if (autoRights1.getText().equalsIgnoreCase(b1)) {
									autoRights1.click();
									break;
								}
							}
						}
						QaRobot.ClickOnElement("CCRAirlineSelectClose");

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
						QaRobot.ClickOnElement("IMDestinationSaveClose");

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

					} else if (b.equalsIgnoreCase("Corporate")) {
						QaRobot.switchToWindow();
						int p1 = Integer.parseInt(CorpQty);
						for (int k = 1; k <= p1; k++) {
							String[] tN1 = SearchCorporate.split(",");
							String b1 = tN1[k - 1];
							QaBrowser.driver.findElement(By.xpath("//input[@id='txtInputTextForCorporate']")).clear();
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
							QaBrowser.driver.findElement(By.xpath("//input[@id='txtInputTextForSubagent']")).clear();
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
							QaBrowser.driver.findElement(By.xpath("//input[@id='txtInputTextForSubagent']")).clear();
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
							QaBrowser.driver.findElement(By.xpath("//input[@id='txtInputTextForSubagent']")).clear();
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
			QaRobot.PassValue("CCRCancellationFeeF", CancellationFee);
			QaRobot.selectTextFromDropdown("CCRCancellationFeeAmount", CancellationFeeAmount, "");
			QaRobot.selectTextFromDropdown("CCRCancellationFeeOn", CancellationFeeAppliedOn, "");
			QaRobot.PassValue("CCRReissueFee", ReIssueFee);
			QaRobot.selectTextFromDropdown("CCRReissueFeeAmount", ReIssueFeeAmount, "");
			QaRobot.selectTextFromDropdown("CCRReissueFeeOn", ReIssueFeeAppliedOn, "");
			QaRobot.PassValue("CCRCancellationRemarkF", CancellationRemark);
		} else if (SelectProduct.equalsIgnoreCase("Hotel")) {
			QaRobot.PassValue("CCRCancellationFeeH", CancellationFee);
			QaRobot.selectTextFromDropdown("CCRCancellationFeeAmount", CancellationFeeAmount, "");
			QaRobot.selectTextFromDropdown("CCRCancellationFeeOn", CancellationFeeAppliedOn, "");
			QaRobot.PassValue("CCRCancellationRemarkH", CancellationRemark);
		}
		QaExtentReport.extentScreenshot("Cancellation Charges Rule");
		QaRobot.scrollPage(-1500);
		QaRobot.ClickOnElement("CCRSave");
	}

	@AfterMethod
	public static void afterMethod() {
		QaExtentReport.test.getExtent().flush();
	}
}
