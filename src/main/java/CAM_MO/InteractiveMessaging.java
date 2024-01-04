package CAM_MO;

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
public class InteractiveMessaging {

	@DataProvider
	public Object[][] getexceldata() throws Exception {
		return QaDataProvider.getTestdata("InteractiveMessaging", "Flight");
	}

	@Test(dataProvider = "getexceldata")
	public static void travellerProfiling(String TestCaseId, String TestCaseType, String TestScenario, String Source,
			String URL, String CompanyCode, String UserName, String Password, String CorporateName, String RuleTitle,
			String SelectProduct, String SQty, String Supplier, String SelectSalesChannel, String CriteriaQty,
			String CriteriaName, String AirQty, String Airlines, String BookDateFrom, String BookDateTo,
			String TripDateFrom, String TripDateTo, String CorpQty, String SearchCorporate, String DestinationFor,
			String Zqty, String Zone, String Rqty, String Region, String Cqty, String Country, String CiQty,
			String City, String Aqty, String Airport, String DaysQty, String Days, String MarketQty,
			String SelectMarketType, String TravellerQty, String TravellerType, String AppliedQty, String AppliedOn)
			throws Exception {

		TestBase.Companycode(Source, URL);
		QaExtentReport.test = QaExtentReport.report.createTest(TestCaseId + "-" + TestScenario);

		QaRobot.PassValue("CompanyCode", CompanyCode);
		QaRobot.PassValue("UserName", UserName);
		QaRobot.PassValue("PasswordFD", Password);
		QaExtentReport.extentScreenshot("Sigh In Page");
		QaRobot.ClickOnElement("LogIn");
		QaRobot.switchframe("//frame[@name='login']");
		QaRobot.switchframe("//frame[@name='leftbar']");
		QaRobot.ClickOnElement("CorporateManagement");
		QaRobot.ClickOnElement("InteractiveMessaging");
		QaBrowser.driver.switchTo().parentFrame();
		QaRobot.switchframe("//frame[@name='main']");
		QaRobot.switchframe("//frame[@id='frm2']");
		
		
		QaRobot.ClickOnElement("AddNewRule");
		QaRobot.PassValue("AddTitle", RuleTitle);
		QaRobot.ClickOnElement("ActiveInteractiveMessaging");
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

					} else if (b.equalsIgnoreCase("Destination")) {
						QaRobot.switchToWindow();
						if (DestinationFor.equalsIgnoreCase("Zone")) {
							QaRobot.ClickOnElement("IMZone");
							QaRobot.transferData(Zqty, Zone,"//select[@id='ListBoxZone']/option");
						} else if (DestinationFor.equalsIgnoreCase("Region")) {
							QaRobot.ClickOnElement("IMRegion");
							QaRobot.transferData(Rqty, Region,"//select[@id='ListBoxRegion']/option");
						} else if (DestinationFor.equalsIgnoreCase("Country")) {
							QaRobot.ClickOnElement("IMCountry");
							QaRobot.transferDataWithPassValue(Cqty, Country, "//input[@id='txtSearch']","//div[@id='divSearch']/p");
						} else if (DestinationFor.equalsIgnoreCase("City")) {
							QaRobot.ClickOnElement("IMCity");
							QaRobot.transferDataWithPassValue(CiQty, City, "//input[@id='txtSearch']","//div[@id='divSearch']/p");
						} else if (DestinationFor.equalsIgnoreCase("Airport")) {
							QaRobot.ClickOnElement("IMAirport");
							QaRobot.transferDataWithPassValue(Aqty, Airport, "//input[@id='txtSearch']","//div[@id='divSearch']/p");
						}
						QaRobot.ClickOnElement("IMDestinationSaveClose");

					} else if (b.equalsIgnoreCase("Weekdays")) {
						QaRobot.switchToWindow();
						QaRobot.transferData(DaysQty, Days, "//select[@id='ListBoxWeekdays']/option");
						QaRobot.ClickOnElement("DaysSelectClose");

					} else if (b.equalsIgnoreCase("Market Type")) {
						QaRobot.switchToWindow();
						QaRobot.transferData(MarketQty, SelectMarketType, "//select[@id='ListBoxMarketType']/option");
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

					} else if (b.equalsIgnoreCase("Destination")) {
						QaRobot.switchToWindow();
						if (DestinationFor.equalsIgnoreCase("Zone")) {
							QaRobot.ClickOnElement("IMZone");
							QaRobot.transferData(Zqty, Zone,"//select[@id='ListBoxZone']/option");
						} else if (DestinationFor.equalsIgnoreCase("Region")) {
							QaRobot.ClickOnElement("IMRegion");
							QaRobot.transferData(Rqty, Region,"//select[@id='ListBoxRegion']/option");
						} else if (DestinationFor.equalsIgnoreCase("Country")) {
							QaRobot.ClickOnElement("IMCountry");
							QaRobot.transferDataWithPassValue(Cqty, Country, "//input[@id='txtSearch']","//div[@id='divSearch']/p");

						} else if (DestinationFor.equalsIgnoreCase("City")) {
							QaRobot.ClickOnElement("IMCity");
							QaRobot.transferDataWithPassValue(CiQty, City, "//input[@id='txtSearch']","//div[@id='divSearch']/p");
						} else if (DestinationFor.equalsIgnoreCase("Airport")) {
							QaRobot.ClickOnElement("IMAirport");
							QaRobot.transferDataWithPassValue(Aqty, Airport, "//input[@id='txtSearch']","//div[@id='divSearch']/p");
						}
						QaRobot.ClickOnElement("IMDestinationSaveClose");

					} else if (b.equalsIgnoreCase("Weekdays")) {
						QaRobot.switchToWindow();
						QaRobot.transferData(DaysQty, Days, "//select[@id='ListBoxWeekdays']/option");
						QaRobot.ClickOnElement("DaysSelectClose");

					} else if (b.equalsIgnoreCase("Market Type")) {
						QaRobot.switchToWindow();
						QaRobot.transferData(MarketQty, SelectMarketType, "//select[@id='ListBoxMarketType']/option");
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
						QaRobot.ClickOnElement("DaysSelectClose");

					} else if (b.equalsIgnoreCase("Market Type")) {
						QaRobot.switchToWindow();
						QaRobot.transferData(MarketQty, SelectMarketType, "//select[@id='ListBoxMarketType']/option");
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
						QaRobot.transferData(MarketQty, SelectMarketType, "//select[@id='ListBoxMarketType']/option");
						QaRobot.ClickOnElement("MarketTypeSelectClose");
					}
				}
			}
		}
		QaRobot.transferData(TravellerQty, TravellerType,
				"/html/body/form/div[4]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[2]/td/div[1]/fieldset[1]/table/tbody/tr[3]/td/fieldset/table[2]/tbody/tr/td[2]/span/label");
		QaRobot.transferData(AppliedQty, AppliedOn,
				"/html/body/form/div[4]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[2]/td/div[1]/fieldset[1]/table/tbody/tr[3]/td/fieldset/table[3]/tbody/tr/td[2]//label");
		QaRobot.PassValue("ChooseFile", "C:\\Users\\Shubham.Natkar\\Desktop\\FlightRule.jpg");
		Thread.sleep(3000);
//		QaRobot.ClickOnElement("SaveInteractiveMessaging");
//		QaRobot.ClickOnElement("CloseInteractiveMessaging");
	}

	@AfterMethod
	public static void afterMethod() {
//		QaExtentReport.test.getExtent().flush();
	}
}
