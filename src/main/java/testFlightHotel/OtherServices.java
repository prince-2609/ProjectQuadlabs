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
public class OtherServices {

	@DataProvider
	public Object[][] getexceldata() throws Exception {
		return QaDataProvider.getTestdata("OtherServices", "Sheet4");
	}

	@Test(dataProvider = "getexceldata")
	public static void OtherProducts(String TestCaseId, String TestScenario, String Module, String LoginType,
			String URL, String Emailid, String SDN, String Employee, String TravelerType, String Username,
			String Password, String ItineraryName, String Optripcode, String Optripcity, String StartDate,
			String EndDate, String Optrip, String OPRemark, String ItineraryType, String Triptype, String PolicyName,
			String JourneyType, String TravelClass, String Departure, String Fullorigin, String DepartureDate,
			String ReturnDate, String DirectFlights, String NoOfProducts, String ProductsName, String CAJourneyType,
			String CAClass, String CAOCode, String CAOriginCity, String HRStarCategory, String SCPickTime,
			String SCPickCode, String SCPickLocation, String SCDropCode, String SCDropLocation, String SCCarType,
			String ForPerDiem, String CDCPickTime, String CDCPickCode, String CDCPickLocation, String CDCDropCode,
			String CDCDropLocation, String CDCCarType, String CDCRequirement, String CDCSupplier, String OPTypeVisa,
			String OPINomineeName, String OPIRelation, String OPIPolicyType, String OPIValidVisa, String OBusOrigin,
			String OBusDestination, String OBusBoardingPoint, String OBJournneyType, String ORJourneyType,
			String OROriginCode, String ORDestinationCode, String ORGender, String ORGovernmentId) throws Exception {

		QaExtentReport.test = QaExtentReport.report.createTest(TestCaseId + "-" + TestScenario);

		TestBase.Companycode(Module, URL);
		QaRobot.impliwait(30);
		if (LoginType.equalsIgnoreCase("Normal")) {
			Login.SbtLogin(Username, Password);
		} else if (LoginType.equalsIgnoreCase("SSO")) {
			QaRobot.PassValue("EmailId", Emailid);
			QaRobot.PassValue("SDN", SDN);
			QaExtentReport.extentScreenshot("LogIn Page");
			QaRobot.ClickOnElement("Encrypt");
			QaRobot.ClickOnElement("ESubmit");
			Thread.sleep(6000);
		}

		QaExtentReport.test.log(Status.INFO, "<b><i>Employee Name is  </i></b>" + Employee);
		QaExtentReport.test.log(Status.INFO, "<b><i> Traveler Type is  </i></b>" + TravelerType);

		QaRobot.ClickOnElement("NotificationClose");
		Thread.sleep(1000);
		QaExtentReport.extentScreenshot("Search Page");
		QaRobot.ClickOnElement("clickotherservice");
		Thread.sleep(10000);
		QaRobot.PassValue("PassItineraryName", ItineraryName);
		TestBase.listofautosuggestion(By.xpath("//div[@id='divTripDestinationCity']/p"), Optripcode, Optripcity,
				By.xpath("//input[@id='txtDestination']"));

		String DateSelection[] = StartDate.split("-");
		String year = DateSelection[2];
		String month = DateSelection[1];
		String expDate = DateSelection[0];
		String DateSelection1[] = EndDate.split("-");
		String year1 = DateSelection1[2];
		String month1 = DateSelection1[1];
		String expDate1 = DateSelection1[0];
		QaBrowser.driver
				.findElement(By.xpath("//div[@id='divTripsection']/div[2]/div/div/div/div/div[1]/div[3]/div/div/span"))
				.click();
		Thread.sleep(2000);
		StartAndEndDate(expDate, month, year, expDate1, month1, year1);
		QaRobot.selectTextFromDropdown("OPTrip", Optrip);
		QaRobot.PassValue("OPRemarks", OPRemark);
		Thread.sleep(2000);
		QaExtentReport.extentScreenshot("Itinerary Detail");
		QaRobot.ClickOnElement("CreateItinerary");
		QaExtentReport.extentScreenshot("Itinerary created successfully");

		String DateSelection2[] = DepartureDate.split("-");
		String year2 = DateSelection2[2];
		String month2 = DateSelection2[1];
		String expDate2 = DateSelection2[0];
		String DateSelection3[] = ReturnDate.split("-");
		String year3 = DateSelection3[2];
		String month3 = DateSelection3[1];
		String expDate3 = DateSelection3[0];
		if (ItineraryType.equalsIgnoreCase("Flight")) {
			QaRobot.ClickOnElement("FlightItinerary");
			Thread.sleep(3000);
			QaRobot.selectTextFromDropdown("Journeytype", JourneyType);
			QaRobot.selectTextFromDropdown("ClassOfTravel", TravelClass);
			TestBase.listofautosuggestion(By.xpath("//div[@id='divDepartureCity']/p"), Departure, Fullorigin,
					By.xpath("//input[@id='txtflightOrigin']"));
			Thread.sleep(2000);
//			QaRobot.selectTextFromDropdown("Policyname", PolicyName);
			if (JourneyType.equalsIgnoreCase("One Way")) {
				Thread.sleep(2000);
				QaBrowser.driver
						.findElement(
								By.xpath("//div[@id='divflightsection']/div/div[2]/div/div/div[3]/div[1]/div/div/span"))
						.click();
				selectDateInCalendarOneWay(expDate2, month2, year2);
			} else if (JourneyType.equalsIgnoreCase("Round Trip")) {
				Thread.sleep(2000);
				QaBrowser.driver
						.findElement(
								By.xpath("//div[@id='divflightsection']/div/div[2]/div/div/div[3]/div[1]/div/div/span"))
						.click();
				selectDateInCalendarRoundTrip(expDate2, month2, year2, expDate3, month3, year3);
			}
			Thread.sleep(2000);
			QaExtentReport.extentScreenshot("Flight Detail");
			if (DirectFlights.equalsIgnoreCase("Yes")) {
				QaRobot.ClickOnElement("Directflight");
			}
			Thread.sleep(3000);
			QaRobot.ClickOnElement("Saveproductitinerary");
			QaExtentReport.extentScreenshot("Flight Saved Successfully");

		} else if (ItineraryType.equalsIgnoreCase("Hotel")) {
			QaRobot.ClickOnElement("HotelItinerary");
		} else if (ItineraryType.equalsIgnoreCase("MoreProduct")) {
			int pAS = Integer.parseInt(NoOfProducts);
			for (int i = 1; i <= pAS; i++) {
				String[] tN = ProductsName.split(",");
				String b = tN[i - 1];
				if (b.equalsIgnoreCase("ComplexItineraryAir")) {
					QaRobot.ClickOnElement("Moreproductitinerary");
					Thread.sleep(3000);
					QaRobot.ClickOnElement("ComplexItineraryAir");
					Thread.sleep(3000);
					QaRobot.selectTextFromDropdown("CAJourneyType", CAJourneyType,
							"<b><i>Journey Type<b><i>" + " : " + CAJourneyType);
					Thread.sleep(3000);
					QaRobot.selectTextFromDropdown("CAClass", CAClass, "<b><i>Journey Type<b><i>" + " : " + CAClass);
					Thread.sleep(3000);
					TestBase.listofautosuggestion(By.xpath("//div[@id='divNonbDepartureCity']/p"), CAOCode,
							CAOriginCity, By.xpath("//input[@id='txtnonbflightOrigin']"));
					Thread.sleep(2000);
					QaExtentReport.extentScreenshot("Complex Itinerary Air");
					Thread.sleep(2000);
					QaRobot.ClickOnElement("CASaveFlight");

				} else if (b.equalsIgnoreCase("HotelsOnRequest")) {
					QaRobot.ClickOnElement("Moreproductitinerary");
					Thread.sleep(3000);
					QaRobot.ClickOnElement("HotelsOnRequest");
					Thread.sleep(3000);
					WebElement element = QaBrowser.driver.findElement(By.xpath("//select[@id='ddlnonbhotelPolicy']"));
					Select s = new Select(element);
					s.selectByIndex(1);
					Thread.sleep(3000);
					QaRobot.selectTextFromDropdown("HRStarCategory", HRStarCategory,
							"<b><i>Star Category<b><i>" + " : " + HRStarCategory);
					Thread.sleep(3000);
					QaExtentReport.extentScreenshot("Hotels On Request");
					Thread.sleep(2000);
					QaRobot.ClickOnElement("HRSaveHotel");

				} else if (b.equalsIgnoreCase("SelfDriveCar")) {
					QaRobot.ClickOnElement("Moreproductitinerary");
					Thread.sleep(3000);
					QaRobot.ClickOnElement("SelfDriveCar");
					Thread.sleep(3000);
					QaRobot.PassValue("SCPickTime", SCPickTime);
					TestBase.listofautosuggestion(By.xpath("//div[@id='divCarPickUpName']/p"), SCPickCode,
							SCPickLocation, By.xpath("//input[@id='txtcarpickupLocation']"));
					Thread.sleep(2000);
					TestBase.listofautosuggestion(By.xpath("//div[@id='divCarDropOffName']/p"), SCDropCode,
							SCDropLocation, By.xpath("//input[@id='txtcarDropoffLocation']"));
					Thread.sleep(2000);
					QaRobot.selectTextFromDropdown("SCCarType", SCCarType, "<b><i>Car Type<b><i>" + " : " + SCCarType);
					Thread.sleep(3000);
					QaExtentReport.extentScreenshot("Self Drive Car");
					Thread.sleep(2000);
					QaRobot.ClickOnElement("SCSaveCar");

				} else if (b.equalsIgnoreCase("Forex")) {
					QaRobot.ClickOnElement("Moreproductitinerary");
					Thread.sleep(3000);
					QaRobot.ClickOnElement("Forex");
					Thread.sleep(3000);
					QaRobot.PassValue("ForPerDiem", ForPerDiem);
					QaExtentReport.extentScreenshot("Forex");
					Thread.sleep(2000);
					QaRobot.ClickOnElement("ForSaveForex");

				} else if (b.equalsIgnoreCase("ChauffeurDrivenCar")) {
					QaRobot.ClickOnElement("Moreproductitinerary");
					Thread.sleep(3000);
					QaRobot.ClickOnElement("ChauffeurDrivenCar");
					Thread.sleep(3000);
					QaRobot.PassValue("CDCPickTime", CDCPickTime);
					Thread.sleep(3000);
					QaRobot.PassValue("CDCPickLocation", CDCPickLocation);
					Thread.sleep(2000);
					QaRobot.PassValue("CDCDropLocation", CDCDropLocation);
					Thread.sleep(2000);
					QaRobot.selectTextFromDropdown("CDCCarType", CDCCarType,
							"<b><i>Car Type<b><i>" + " : " + CDCCarType);
					Thread.sleep(3000);
					QaRobot.selectTextFromDropdown("CDCRequirement", CDCRequirement,
							"<b><i>Requirement<b><i>" + " : " + CDCRequirement);
					Thread.sleep(3000);
					QaRobot.selectTextFromDropdown("CDCSupplier", CDCSupplier,
							"<b><i>Supplier<b><i>" + " : " + CDCSupplier);
					Thread.sleep(3000);
					QaExtentReport.extentScreenshot("Chauffeur Driven Car");
					Thread.sleep(2000);
					QaRobot.ClickOnElement("CDCSaveTransfer");

				} else if (b.equalsIgnoreCase("Visa")) {
					QaRobot.ClickOnElement("Moreproductitinerary");
					Thread.sleep(3000);
					QaRobot.ClickOnElement("OPVisa");
					Thread.sleep(3000);
					QaRobot.selectTextFromDropdown("OPTypeVisa", OPTypeVisa,
							"<b><i>Car Type<b><i>" + " : " + OPTypeVisa);
					Thread.sleep(3000);
					QaExtentReport.extentScreenshot("Visa");
					Thread.sleep(2000);
					QaRobot.ClickOnElement("OPSaveVisa");

				} else if (b.equalsIgnoreCase("Insurance")) {
					QaRobot.ClickOnElement("Moreproductitinerary");
					Thread.sleep(3000);
					QaRobot.ClickOnElement("OPInsurance");
					Thread.sleep(3000);
					QaRobot.PassValue("OPINomineeName", OPINomineeName);
					QaRobot.PassValue("OPIRelation", OPIRelation);
					QaRobot.selectTextFromDropdown("OPIPolicyType", OPIPolicyType,
							"<b><i>Policy Type<b><i>" + " : " + OPIPolicyType);
					Thread.sleep(3000);
					QaRobot.selectTextFromDropdown("OPIValidVisa", OPIValidVisa,
							"<b><i>Valid Visa<b><i>" + " : " + OPIValidVisa);
					Thread.sleep(3000);
					QaExtentReport.extentScreenshot("Insurance");
					Thread.sleep(2000);
					QaRobot.ClickOnElement("OPSaveInsurane");

				} else if (b.equalsIgnoreCase("Bus")) {
					QaRobot.ClickOnElement("Moreproductitinerary");
					Thread.sleep(3000);
					QaRobot.ClickOnElement("OPBus");
					Thread.sleep(3000);
					QaRobot.PassValue("OBusOrigin", OBusOrigin);
					QaRobot.PassValue("OBusDestination", OBusDestination);
					QaRobot.PassValue("OBusBoardingPoint", OBusBoardingPoint);
					QaRobot.selectTextFromDropdown("OBJournneyType", OBJournneyType,
							"<b><i>Journey Type<b><i>" + " : " + OBJournneyType);
					Thread.sleep(3000);
					QaExtentReport.extentScreenshot("Bus");
					Thread.sleep(2000);
					QaRobot.ClickOnElement("OSaveBus");

				} else if (b.equalsIgnoreCase("Rail")) {
					QaRobot.ClickOnElement("Moreproductitinerary");
					Thread.sleep(3000);
					QaRobot.ClickOnElement("Rail");
					Thread.sleep(3000);
					QaRobot.selectTextFromDropdown("ORJourneyType", ORJourneyType,
							"<b><i>Journey Type<b><i>" + " : " + ORJourneyType);
					Thread.sleep(3000);
					QaRobot.PassValue("OROriginCode", OROriginCode);
					QaRobot.PassValue("ORDestinationCode", ORDestinationCode);
					QaRobot.selectTextFromDropdown("ORGender", ORGender, "<b><i>Gender<b><i>" + " : " + ORGender);
					Thread.sleep(3000);
					QaRobot.selectTextFromDropdown("ORGovernmentId", ORGovernmentId,
							"<b><i>GOvernment Id<b><i>" + " : " + ORGovernmentId);
					Thread.sleep(3000);
					QaExtentReport.extentScreenshot("Rail");
					Thread.sleep(2000);
					QaRobot.ClickOnElement("ORSaveRail");
				}
			}
			Thread.sleep(3000);
			QaRobot.ClickOnElement("OPCreateBooking");
			Thread.sleep(10000);
			String RefNo = QaBrowser.driver.switchTo().alert().getText();
			System.out.println(RefNo);
			QaBrowser.driver.switchTo().alert().accept();
			QaExtentReport.test.log(Status.INFO, RefNo);
			Thread.sleep(5000);
			QaExtentReport.extentScreenshot("Dashboard");
		}
	}

	@AfterTest
	public static void After_Test() {
		QaExtentReport.test.getExtent().flush();
//		QaBrowser.driver.close();
	}

	public static void StartAndEndDate(String Day, String Month, String Year, String Day1, String Month1, String Year1)
			throws InterruptedException, ParseException {
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
		} else if (Month1.equalsIgnoreCase("Feb")) {
			currentMonthNumber1 = "02";
		} else if (Month1.equalsIgnoreCase("Mar")) {
			currentMonthNumber1 = "03";
		} else if (Month1.equalsIgnoreCase("Apr")) {
			currentMonthNumber1 = "04";
		} else if (Month1.equalsIgnoreCase("May")) {
			currentMonthNumber1 = "05";
		} else if (Month1.equalsIgnoreCase("Jun")) {
			currentMonthNumber1 = "06";
		} else if (Month1.equalsIgnoreCase("Jul")) {
			currentMonthNumber1 = "07";
		} else if (Month1.equalsIgnoreCase("Aug")) {
			currentMonthNumber1 = "08";
		} else if (Month1.equalsIgnoreCase("Sep")) {
			currentMonthNumber1 = "09";
		} else if (Month1.equalsIgnoreCase("Oct")) {
			currentMonthNumber1 = "10";
		} else if (Month1.equalsIgnoreCase("Nov")) {
			currentMonthNumber1 = "11";
		} else if (Month1.equalsIgnoreCase("Dec")) {
			currentMonthNumber1 = "12";
		}

		Date date3 = d.parse(Day1 + "-" + Integer.parseInt(currentMonthNumber1) + "-" + Year1);
		System.out.println(date3);

//		QaExtentReport.test.log(Status.INFO, "<b><i>Select Departure Date  </i></b>" + Day + "-" + Month + "-" + Year);
//		QaExtentReport.test.log(Status.INFO, "<b><i>Select Return Date  </i></b>" + Day1 + "-" + Month1 + "-" + Year1);

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

		String monthYear = QaBrowser.driver.findElement(By.xpath("/html/body/div[9]/div/div[2]/div/div")).getText();

		String month = monthYear.split(" ")[0];
		String year = monthYear.split(" ")[1];

		if (date2.before(date1)) {
			System.out.println("Invalid date provided " + Day + "-" + Month + "-" + Year);
			QaExtentReport.test.log(Status.FAIL,
					"<b><i>Invalid date provided  </i></b>" + Day + "-" + Month + "-" + Year);
//			throw new B2cExceptionClass("Invalid date provided " + Day + "-" + Month + "-" + Year);
		} else {
			while (!(month.equals(Month) && year.equals(Year))) {
				QaBrowser.driver.findElement(By.xpath("/html/body/div[9]/div/div[1]/a[3]")).click();

				monthYear = QaBrowser.driver.findElement(By.xpath("/html/body/div[9]/div/div[2]/div/div")).getText();

				month = monthYear.split(" ")[0];
				year = monthYear.split(" ")[1];
			}

			List<WebElement> allDates = QaBrowser.driver
					.findElements(By.xpath("/html/body/div[9]/div/div[2]/div/table/tbody/tr/td/a"));

			for (WebElement ele : allDates) {
				String dt = ele.getText();

				if (dt.equalsIgnoreCase(Day)) {
					ele.click();
					break;
				}
			}
			Thread.sleep(2000);

//			QaBrowser.driver
//					.findElement(
//							By.xpath("//div[@id='divTripsection']/div[2]/div/div/div/div/div[1]/div[3]/div/div/span"))
//					.click();
//			Thread.sleep(2000);
			String monthYear1 = QaBrowser.driver.findElement(By.xpath("/html/body/div[9]/div/div[2]/div/div"))
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
					QaBrowser.driver.findElement(By.xpath("/html/body/div[9]/div/div[1]/a[3]")).click();
					monthYear1 = QaBrowser.driver.findElement(By.xpath("/html/body/div[9]/div/div[2]/div/div"))
							.getText();
					month1 = monthYear1.split(" ")[0];
					year1 = monthYear1.split(" ")[1];
				}
				List<WebElement> allDates1 = QaBrowser.driver
						.findElements(By.xpath("/html/body/div[9]/div/div[2]/div/table/tbody/tr/td/a"));
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
		Thread.sleep(4000);
		String monthYear = QaBrowser.driver.findElement(By.xpath("/html/body/div[9]/div/div[2]/div/div")).getText();
		Thread.sleep(3000);
		String month = monthYear.split(" ")[0];
		String year = monthYear.split(" ")[1];
		Assert.assertFalse(date2.before(date1), "Invalid date provided " + Day + "-" + Month + "-" + Year);
		while (!(month.equals(Month) && year.equals(Year))) {
			QaBrowser.driver.findElement(By.xpath("/html/body/div[9]/div/div[1]/a[3]")).click();
			monthYear = QaBrowser.driver.findElement(By.xpath("/html/body/div[9]/div/div[2]/div/div")).getText();
			month = monthYear.split(" ")[0];
			year = monthYear.split(" ")[1];
		}
		List<WebElement> allDates = QaBrowser.driver
				.findElements(By.xpath("/html/body/div[9]/div/div[2]/div/table/tbody/tr/td//a"));
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
		if (Month1.equalsIgnoreCase("Jan")) {
			currentMonthNumber1 = "01";
		} else if (Month1.equalsIgnoreCase("Feb")) {
			currentMonthNumber1 = "02";
		} else if (Month1.equalsIgnoreCase("Mar")) {
			currentMonthNumber1 = "03";
		} else if (Month1.equalsIgnoreCase("Apr")) {
			currentMonthNumber1 = "04";
		} else if (Month1.equalsIgnoreCase("May")) {
			currentMonthNumber1 = "05";
		} else if (Month1.equalsIgnoreCase("Jun")) {
			currentMonthNumber1 = "06";
		} else if (Month1.equalsIgnoreCase("Jul")) {
			currentMonthNumber1 = "07";
		} else if (Month1.equalsIgnoreCase("Aug")) {
			currentMonthNumber1 = "08";
		} else if (Month1.equalsIgnoreCase("Sep")) {
			currentMonthNumber1 = "09";
		} else if (Month1.equalsIgnoreCase("Oct")) {
			currentMonthNumber1 = "10";
		} else if (Month1.equalsIgnoreCase("Nov")) {
			currentMonthNumber1 = "11";
		} else if (Month1.equalsIgnoreCase("Dec")) {
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
		Thread.sleep(5000);
		String monthYear = QaBrowser.driver.findElement(By.xpath("/html/body/div[9]/div/div[2]/div/div")).getText();

//		Thread.sleep(10000);
		System.out.println(monthYear);
		String month = monthYear.split(" ")[0];
		String year = monthYear.split(" ")[1];

		if (date2.before(date1)) {
			System.out.println("Invalid date provided " + Day + "-" + Month + "-" + Year);
			QaExtentReport.test.log(Status.FAIL,
					"<b><i>Invalid date provided  </i></b>" + Day + "-" + Month + "-" + Year);
//			throw new B2cExceptionClass("Invalid date provided " + Day + "-" + Month + "-" + Year);
		} else {
			while (!(month.equals(Month) && year.equals(Year))) {
				QaBrowser.driver.findElement(By.xpath("/html/body/div[9]/div/div[1]/a[3]")).click();
				monthYear = QaBrowser.driver.findElement(By.xpath("/html/body/div[9]/div/div[2]/div/div")).getText();
				month = monthYear.split(" ")[0];
				year = monthYear.split(" ")[1];
			}

			List<WebElement> allDates = QaBrowser.driver
					.findElements(By.xpath("/html/body/div[9]/div/div[2]/div/table/tbody/tr/td//a"));

			for (WebElement ele : allDates) {
				String dt = ele.getText();

				if (dt.equalsIgnoreCase(Day)) {
					ele.click();
					break;
				}
			}
			Thread.sleep(2000);

			String monthYear1 = QaBrowser.driver.findElement(By.xpath("/html/body/div[9]/div/div[2]/div/div"))
					.getText();
			Thread.sleep(4000);
			String month1 = monthYear1.split(" ")[0];
			Thread.sleep(4000);
			String year1 = monthYear1.split(" ")[1];

			if (date3.before(date2)) {
				QaExtentReport.test.log(Status.FAIL,
						"<b><i>Invalid Return date provided  </i></b>" + Day1 + "-" + Month1 + "-" + Year1);
			} else {
				while (!(month1.equals(Month1) && year1.equals(Year1))) {
					QaBrowser.driver.findElement(By.xpath("/html/body/div[9]/div/div[1]/a[3]")).click();
					monthYear1 = QaBrowser.driver.findElement(By.xpath("/html/body/div[9]/div/div[2]/div/div"))
							.getText();
					month1 = monthYear1.split(" ")[0];
					year1 = monthYear1.split(" ")[1];
				}
				List<WebElement> allDates1 = QaBrowser.driver
						.findElements(By.xpath("/html/body/div[9]/div/div[2]/div/table/tbody/tr/td//a"));
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
