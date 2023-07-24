package CAM;

import java.util.List;

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
public class policyWorkflow {
	static String monthName = "";
	static int currentMonthNumber;

	@DataProvider
	public Object[][] getexceldata() throws Exception {
		return QaDataProvider.getTestdata("Policyworkflow", "Car1");
	}

	@Test(dataProvider = "getexceldata")
	public static void Profiling(String Source, String URL, String Comapnycode, String Username, String Password,
			String TravelPolicyTitle, String Travelpurpose, String TravelCategory, String Product, String RuleAppliedOn,
			String SelectQty, String SelectFromList, String CriteriaQty, String CriteriaName, String OriginFor,
			String OZqty, String OZone, String ORqty, String ORegion, String OCqty, String OCountry, String OCiQty,
			String OCity, String DestinationFor, String DZqty, String DZone, String DRqty, String DRegion, String DCqty,
			String DCountry, String DCiQty, String DCity, String CostFrom, String CostTo, String BookDateFrom,
			String BookDateTo, String TripDateFrom, String TripDateTo, String MarketType) throws Exception {
		TestBase.Companycode(Source, URL);
		QaRobot.impliwait(30);
		QaExtentReport.test = QaExtentReport.report.createTest("Test On Policy Work Flow");
		QaRobot.PassValue("User_name", Username);
		QaRobot.PassValue("Password", Password);
		QaRobot.ClickOnElement("Submit");
		QaRobot.mouseHover("//a[@id='HeaderTop_aSetting']", "//span[@id='HeaderTop_lblPolicyManagement']");
		QaRobot.ClickOnElement("Managetravelpolicy");
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
		int pAS = Integer.parseInt(SelectQty);
		for (int i = 1; i <= pAS; i++) {
			String[] tN = SelectFromList.split(",");
			String b = tN[i - 1];
			List<WebElement> listOfRights = QaBrowser.driver.findElements(By.xpath(
					"/html/body/div/form/div[10]/div/div/div[2]/div[3]/div[2]/div/div/div/div[4]/div[3]/div/div/div[1]/div/div/select/option"));
			for (WebElement autoRights : listOfRights) {
				if (autoRights.getText().equalsIgnoreCase(b)) {
					autoRights.click();
					QaRobot.ClickOnElement("AddList");
				}
			}
		}
		if (Product.equalsIgnoreCase("Flight")) {
//			int pAS = Integer.parseInt(CriteriaQty);
//			if (CriteriaQty.equalsIgnoreCase("1")) {
//				for (int i = 1; i <= pAS; i++) {
//					String[] tN = CriteriaName.split(",");
//					String b = tN[i - 1];
//					QaRobot.selectTextByLocator("//select[@id='grdFlight_ctl02_ddlFlightKey']", policy_criteria);
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
//					} else if (b.equalsIgnoreCase("Destination")) {
//						QaRobot.switchToWindow();
//						if (DestinationFor.equalsIgnoreCase("Zone")) {
//							QaRobot.ClickOnElement("IMZone");
//							QaRobot.transferData(Zqty, Zone,"//select[@id='ListBoxZone']/option");
//						} else if (DestinationFor.equalsIgnoreCase("Region")) {
//							QaRobot.ClickOnElement("IMRegion");
//							QaRobot.transferData(Rqty, Region,"//select[@id='ListBoxRegion']/option");
//						} else if (DestinationFor.equalsIgnoreCase("Country")) {
//							QaRobot.ClickOnElement("IMCountry");
//							QaRobot.transferDataWithPassValue(Cqty, Country, "//input[@id='txtSearch']","//div[@id='divSearch']/p");
//
//						} else if (DestinationFor.equalsIgnoreCase("City")) {
//							QaRobot.ClickOnElement("IMCity");
//							QaRobot.transferDataWithPassValue(CiQty, City, "//input[@id='txtSearch']","//div[@id='divSearch']/p");
//						} else if (DestinationFor.equalsIgnoreCase("Airport")) {
//							QaRobot.ClickOnElement("IMAirport");
//							QaRobot.transferDataWithPassValue(Aqty, Airport, "//input[@id='txtSearch']","//div[@id='divSearch']/p");
//						}
//						QaRobot.ClickOnElement("DestinationSaveClose");
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
//					} else if (b.equalsIgnoreCase("Destination")) {
//						QaRobot.switchToWindow();
//						if (DestinationFor.equalsIgnoreCase("Zone")) {
//							QaRobot.ClickOnElement("IMZone");
//							QaRobot.transferData(Zqty, Zone,"//select[@id='ListBoxZone']/option");
//						} else if (DestinationFor.equalsIgnoreCase("Region")) {
//							QaRobot.ClickOnElement("IMRegion");
//							QaRobot.transferData(Rqty, Region,"//select[@id='ListBoxRegion']/option");
//						} else if (DestinationFor.equalsIgnoreCase("Country")) {
//							QaRobot.ClickOnElement("IMCountry");
//							QaRobot.transferDataWithPassValue(Cqty, Country, "//input[@id='txtSearch']","//div[@id='divSearch']/p");
//
//						} else if (DestinationFor.equalsIgnoreCase("City")) {
//							QaRobot.ClickOnElement("IMCity");
//							QaRobot.transferDataWithPassValue(CiQty, City, "//input[@id='txtSearch']","//div[@id='divSearch']/p");
//						} else if (DestinationFor.equalsIgnoreCase("Airport")) {
//							QaRobot.ClickOnElement("IMAirport");
//							QaRobot.transferDataWithPassValue(Aqty, Airport, "//input[@id='txtSearch']","//div[@id='divSearch']/p");
//						}
//						QaRobot.ClickOnElement("DestinationSaveClose");
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
							QaRobot.transferData(OCqty, OCountry, "//select[@id='ListBoxOriginCountry']/option");
							QaRobot.ClickOnElement("SOAdd");
						} else if (OriginFor.equalsIgnoreCase("City")) {
							QaRobot.ClickOnElement("SOZone");
							QaRobot.transferData(OZqty, OZone, "//select[@id='ListBoxOriginZone']/option");
							QaRobot.ClickOnElement("SOCountry");
							QaRobot.transferData(OCqty, OCountry, "//select[@id='ListBoxOriginCountry']/option");
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
							QaRobot.transferData(DRqty, DRegion, "//select[@id='ListBoxDestinationRegion']/option");
							QaRobot.ClickOnElement("SDAdd");
						} else if (DestinationFor.equalsIgnoreCase("Country")) {
							QaRobot.ClickOnElement("SDZone");
							QaRobot.transferData(DZqty, DZone, "//select[@id='ListBoxDestinationZone']/option");
							QaRobot.ClickOnElement("SDCountry");
							QaRobot.transferData(DCqty, DCountry, "//select[@id='ListBoxDestinationCountry']/option");
							QaRobot.ClickOnElement("SDAdd");
						} else if (DestinationFor.equalsIgnoreCase("City")) {
							QaRobot.ClickOnElement("SDZone");
							QaRobot.transferData(DZqty, DZone, "//select[@id='ListBoxDestinationZone']/option");
							QaRobot.ClickOnElement("SDCountry");
							QaRobot.transferData(DCqty, DCountry, "//select[@id='ListBoxDestinationCountry']/option");
							QaRobot.ClickOnElement("SDCity");
							QaRobot.transferData(DCiQty, DCity, "//select[@id='ListBoxDestinationCity']/option");
							QaRobot.ClickOnElement("SDAdd");
						}
						QaRobot.ClickOnElement("DestinationSaveClose");
					} else if (b.equalsIgnoreCase("Cost Range")) {
						QaRobot.switchToWindow();
						QaRobot.PassValue("CostFrom", CostFrom);
						QaRobot.PassValue("CostTo", CostTo);
						QaRobot.ClickOnElement("CostRangeSelectClose");
					} else if (b.equalsIgnoreCase("Booking Date")) {
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

					} else if (b.equalsIgnoreCase("Trip Date")) {
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
							QaRobot.transferData(OCqty, OCountry, "//select[@id='ListBoxOriginCountry']/option");
							QaRobot.ClickOnElement("SOAdd");
						} else if (OriginFor.equalsIgnoreCase("City")) {
							QaRobot.ClickOnElement("SOZone");
							QaRobot.transferData(OZqty, OZone, "//select[@id='ListBoxOriginZone']/option");
							QaRobot.ClickOnElement("SOCountry");
							QaRobot.transferData(OCqty, OCountry, "//select[@id='ListBoxOriginCountry']/option");
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
							QaRobot.transferData(DRqty, DRegion, "//select[@id='ListBoxDestinationRegion']/option");
							QaRobot.ClickOnElement("SDAdd");
						} else if (DestinationFor.equalsIgnoreCase("Country")) {
							QaRobot.ClickOnElement("SDZone");
							QaRobot.transferData(DZqty, DZone, "//select[@id='ListBoxDestinationZone']/option");
							QaRobot.ClickOnElement("SDCountry");
							QaRobot.transferData(DCqty, DCountry, "//select[@id='ListBoxDestinationCountry']/option");
							QaRobot.ClickOnElement("SDAdd");
						} else if (DestinationFor.equalsIgnoreCase("City")) {
							QaRobot.ClickOnElement("SDZone");
							QaRobot.transferData(DZqty, DZone, "//select[@id='ListBoxDestinationZone']/option");
							QaRobot.ClickOnElement("SDCountry");
							QaRobot.transferData(DCqty, DCountry, "//select[@id='ListBoxDestinationCountry']/option");
							QaRobot.ClickOnElement("SDCity");
							QaRobot.transferData(DCiQty, DCity, "//select[@id='ListBoxDestinationCity']/option");
							QaRobot.ClickOnElement("SDAdd");
						}
						QaRobot.ClickOnElement("DestinationSaveClose");
					} else if (b.equalsIgnoreCase("Cost Range")) {
						QaRobot.switchToWindow();
						QaRobot.PassValue("CostFrom", CostFrom);
						QaRobot.PassValue("CostTo", CostTo);
						QaRobot.ClickOnElement("CostRangeSelectClose");
					} else if (b.equalsIgnoreCase("Booking Date")) {
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

					} else if (b.equalsIgnoreCase("Trip Date")) {
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
		}
		QaRobot.ClickOnElement("SaveCarPolicy");
	}

	@AfterMethod
	public static void afterMetod() {
//		QaExtentReport.test.getExtent().flush();
	}

}
