package jOLO_SBT;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import Base.TestBase;
import utilities.QaBrowser;
import utilities.QaExtentReport;
import utilities.QaRobot;

public class SBT_JOLO_TripType {
	public static WebDriver driver;

	public static void flightTriptype(String TravellerType, String TripType, String OriginCityCode,
			String OriginLocation, String DestinationCityCode, String DestinationLocation, String DepartureDate,
			String ReturnDate, String adult, String child, String infant, String Class, String ShowDirectFlight)
			throws Exception {
		String DateSelection[] = DepartureDate.split("-");
		String year = DateSelection[2];
		String month = DateSelection[1];
		String expDate = DateSelection[0];
		String DateSelection1[] = ReturnDate.split("-");
		String year1 = DateSelection1[2];
		String month1 = DateSelection1[1];
		String expDate1 = DateSelection1[0];
		if (TripType.equalsIgnoreCase("OneWay")) {
			QaRobot.ClickOnElement("OneWayJ");
			Assert.assertFalse(OriginCityCode == DestinationCityCode, "Origin And Destination City Code Can't Be Same");
			Assert.assertFalse(OriginLocation == DestinationLocation,
					"Origin And Destination City Location Can't Be Same");
			TestBase.listofautosuggestion(By.xpath("//div[@id='divDepartureCity']/p"), OriginCityCode, OriginLocation,
					By.xpath("//input[@id='txtDepartureCity']"));
			QaExtentReport.test.log(Status.INFO,
					"<b><i>Departure city : </i></b>" + OriginCityCode + " - " + OriginLocation);
			Thread.sleep(2000);
			TestBase.listofautosuggestion(By.xpath("//div[@id='divDestinationCity']/p"), DestinationCityCode,
					DestinationLocation, By.xpath("//input[@id='txtDestinationCity']"));
			QaExtentReport.test.log(Status.INFO,
					"<b><i>Arrival city : </i></b>" + DestinationCityCode + " - " + DestinationLocation);
			Thread.sleep(2000);
			QaBrowser.driver
					.findElement(By.xpath("//div[@id='flight_way1']/div[2]/div[1]/div/div/label/span[2]/span[1]/img"))
					.click();
			Thread.sleep(2000);
			selectDateInCalendarOneWay(expDate, month, year);
			if (TravellerType.equalsIgnoreCase("Individual")) {
			} else {
				QaRobot.ClickOnElement("TravellersJ");
				QaRobot.selectValueFromDropdown("JAdult", adult,
						"<b><i>Select adult for booking</i></b>" + " - " + adult);
				Thread.sleep(2000);
				QaRobot.selectValueFromDropdown("JChild", child,
						"<b><i>Select child for booking</i></b>" + " - " + child);
				Thread.sleep(2000);
				QaRobot.selectValueFromDropdown("JInfant", infant,
						"<b><i>Select infant for booking</i></b>" + " - " + infant);
				Thread.sleep(2000);
				QaRobot.ClickOnElement("TravellersJ");
			}
			QaRobot.selectTextByLocator("//select[@id='ddlClass']", Class,
					"<b><i>Select Class for booking </i></b>" + Class);
			Thread.sleep(2000);
			if (ShowDirectFlight.equalsIgnoreCase("Yes")) {
				QaRobot.ClickOnElement("ShowDirectFlightJ");
			}
		} else if (TripType.equalsIgnoreCase("RoundTrip")) {
			QaRobot.ClickOnElement("RoundTripJ");
			Assert.assertFalse(OriginCityCode == DestinationCityCode, "Origin And Destination City Code Can't Be Same");
			Assert.assertFalse(OriginLocation == DestinationLocation,
					"Origin And Destination City Location Can't Be Same");
			TestBase.listofautosuggestion(By.xpath("//div[@id='divDepartureCity']/p"), OriginCityCode, OriginLocation,
					By.xpath("//input[@id='txtDepartureCity']"));
			QaExtentReport.test.log(Status.INFO,
					"<b><i>Departure city : </i></b>" + OriginCityCode + " - " + OriginLocation);
			Thread.sleep(2000);
			TestBase.listofautosuggestion(By.xpath("//div[@id='divDestinationCity']/p"), DestinationCityCode,
					DestinationLocation, By.xpath("//input[@id='txtDestinationCity']"));
			QaExtentReport.test.log(Status.INFO,
					"<b><i>Arrival city : </i></b>" + DestinationCityCode + " - " + DestinationLocation);
			Thread.sleep(2000);
			QaBrowser.driver
					.findElement(By.xpath("//div[@id='flight_way1']/div[2]/div[1]/div/div/label/span[2]/span[1]/img"))
					.click();
			Thread.sleep(2000);
			selectDateInCalendarRoundTrip(expDate, month, year, expDate1, month1, year1);
			if (TravellerType.equalsIgnoreCase("Individual")) {
			} else {
				QaRobot.ClickOnElement("TravellersJ");
				QaRobot.selectValueFromDropdown("JAdult", adult,
						"<b><i>Select adult for booking</i></b>" + " - " + adult);
				Thread.sleep(2000);
				QaRobot.selectValueFromDropdown("JChild", child,
						"<b><i>Select child for booking</i></b>" + " - " + child);
				Thread.sleep(2000);
				QaRobot.selectValueFromDropdown("JInfant", infant,
						"<b><i>Select infant for booking</i></b>" + " - " + infant);
				Thread.sleep(2000);
				QaRobot.ClickOnElement("TravellersJ");
			}
			QaRobot.selectTextByLocator("//select[@id='ddlClass']", Class,
					"<b><i>Select Class for booking </i></b>" + Class);
			Thread.sleep(2000);
			if (ShowDirectFlight.equalsIgnoreCase("Yes")) {
				QaRobot.ClickOnElement("ShowDirectFlightJ");
			}
		} else if (TripType.equalsIgnoreCase("MultiCity")) {
			QaRobot.ClickOnElement("Multicity");
		}
		QaRobot.ClickOnElement("FlightPolicyCheckJ");
		try {
			QaExtentReport.extentScreenshot("Search Page");
			QaRobot.ClickOnElement("FinalSearchJ");
		} catch (Exception e) {
			throw (e);
		}
	}

	public static void hotelTripType(String TravellerType, String CityCode, String CityTitle, String CheckInDate,
			String CheckOutDate, String Rooms, String Adult, String Child, String ChildAge) throws Exception {
		TestBase.listofautosuggestion(By.xpath("//div[@id='divHotelName']/p"), CityCode, CityTitle,
				By.xpath("//input[@id='txtHHLCity']"));
		QaExtentReport.test.log(Status.INFO, "<b><i>City Name : </i></b>" + CityCode + "-" + CityTitle);
		Thread.sleep(2000);
		QaBrowser.driver.findElement(By.xpath("//div[@id='tab2']/div/div[4]/div[1]/label/span[2]/span[1]/img")).click();
		Thread.sleep(2000);
		String DateSelection[] = CheckInDate.split("-");
		String year = DateSelection[2];
		String month = DateSelection[1];
		String expDate = DateSelection[0];
		String DateSelection1[] = CheckOutDate.split("-");
		String year1 = DateSelection1[2];
		String month1 = DateSelection1[1];
		String expDate1 = DateSelection1[0];
		selectDateInCalendarHotel(expDate, month, year, expDate1, month1, year1);
		String[] adultcount = Adult.split(",");
		String[] childcount = Child.split(",");
		Assert.assertFalse(Integer.parseInt(Rooms) > 5, "Invalid Number of Rooms provided" + " - " + Rooms);
		WebElement RoomsH = QaBrowser.driver.findElement(By.xpath("//select[@id='ddlRoom']"));
		Select selectRooms = new Select(RoomsH);
		selectRooms.selectByVisibleText(Rooms);
		if (TravellerType.equalsIgnoreCase("Individual")) {
		} else {
			for (int i = 1; i <= Integer.parseInt(Rooms); i++) {
				WebElement adultelement = QaBrowser.driver
						.findElement(By.xpath("//select[@id='ddlHHLAdultR" + i + "']"));
				Select selectadult = new Select(adultelement);
				selectadult.selectByVisibleText(adultcount[i - 1]);
				Thread.sleep(2000);

				WebElement childelement = QaBrowser.driver
						.findElement(By.xpath("//select[@id='ddlHHLChildR" + i + "']"));
				Select selectchild = new Select(childelement);
				selectchild.selectByValue(childcount[i - 1]);
				Thread.sleep(2000);
			}
			String[] ageofchild = ChildAge.split(",");
			for (String chd : childcount) {
				int chdcount = Integer.parseInt(chd);
				for (int i = 1; i <= chdcount; i++) {
					String ac = ageofchild[i - 1];
					Assert.assertFalse(Integer.parseInt(ac) > 11, "Invalid Child Age Selection" + " : " + ac);
					WebElement childrenage = QaBrowser.driver
							.findElement(By.xpath("//select[@id='ddlHHLChild" + chdcount + "R" + i + "']"));
					Select selectage = new Select(childrenage);
					selectage.selectByValue(ageofchild[i - 1]);
					Thread.sleep(2000);
				}
			}
		}
		QaRobot.ClickOnElement("HotelPolicyCheckJ");
		try {
			QaExtentReport.extentScreenshot("Search Page");
			QaRobot.ClickOnElement("FinalSearchHJ");
		} catch (Exception e) {
			throw (e);
		}
	}

	public static void carTriptype(String SearchType, String PickUpCode, String PickUpCity, String PickUpDate,
			String DropOffDate, String PickUpTime, String DropOffTime, String DriversAge, String CountryOfResidency,
			String Adult, String Child, String Infant, String DropOffToDifferentLocation, String DropOffCode,
			String DropOffCity) throws Exception {

		String DateSelection[] = PickUpDate.split("-");
		String year = DateSelection[2];
		String month = DateSelection[1];
		String expDate = DateSelection[0];
		String DateSelection1[] = DropOffDate.split("-");
		String year1 = DateSelection1[2];
		String month1 = DateSelection1[1];
		String expDate1 = DateSelection1[0];
		TestBase.listofautosuggestion(By.xpath("//div[@id='divCarPickUpName']/p"), PickUpCode, PickUpCity,
				By.xpath("//input[@id='CarSearch_txtPickUpCity']"));
		QaExtentReport.test.log(Status.INFO, "<b><i>PickUp city : </i></b>" + PickUpCode + " - " + PickUpCity);
		Thread.sleep(2000);
		QaRobot.ClickOnElement("PickUpDate");
		selectDateInCalendarOneWay(expDate, month, year);
		QaRobot.ClickOnElement("DropOffDate");
		selectDateInCalendarOneWay(expDate1, month1, year1);
		QaRobot.selectTextFromDropdown("PickUpTime", PickUpTime);
		QaRobot.selectTextFromDropdown("DropOffTime", DropOffTime);
//		QaRobot.selectTextFromDropdown("DriverAge", DriversAge);
		QaRobot.selectTextFromDropdown("Nationality", CountryOfResidency);

		if (SearchType.equalsIgnoreCase("Individual")) {
		} else {
			QaRobot.ClickOnElement("Travellers");
			QaRobot.selectValueFromDropdown("CAdult", Adult, "<b><i>Select adult for booking</i></b>" + " - " + Adult);
			Thread.sleep(2000);
			QaRobot.selectValueFromDropdown("CChild", Child, "<b><i>Select child for booking</i></b>" + " - " + Child);
			Thread.sleep(2000);
			QaRobot.selectValueFromDropdown("CInfant", Infant,
					"<b><i>Select infant for booking</i></b>" + " - " + Infant);
			Thread.sleep(2000);
			QaRobot.ClickOnElement("Travellers");
		}
		if (DropOffToDifferentLocation.equalsIgnoreCase("Yes")) {
			QaRobot.ClickOnElement("DropOffDifferentLocation");
			TestBase.listofautosuggestion(By.xpath("//div[@id='divCarDropUpName']/p"), DropOffCode, DropOffCity,
					By.xpath("//input[@id='CarSearch_txtDropUpCity']"));
			QaExtentReport.test.log(Status.INFO, "<b><i>DropOff city : </i></b>" + DropOffCode + " - " + DropOffCity);
			Thread.sleep(2000);
		}
		QaExtentReport.extentScreenshot("Search Page");
		QaRobot.ClickOnElement("ActiveCheckBox");
		QaRobot.ClickOnElement("SearchCar");
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
		String month = monthYear.split(" ")[0];
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
	}

	public static void selectDateInCalendarRoundTrip(String Day, String Month, String Year, String Day1, String Month1,
			String Year1) throws Exception {
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
		QaExtentReport.test.log(Status.INFO, "<b><i>Select Departure Date  </i></b>" + Day + "-" + Month + "-" + Year);
		QaExtentReport.test.log(Status.INFO, "<b><i>Select Return Date  </i></b>" + Day1 + "-" + Month1 + "-" + Year1);
		Assert.assertFalse(Integer.parseInt(Day) > 31, "Invalid date provided " + Day + "-" + Month + "-" + Year);
		Assert.assertFalse(Month.equals("Feb") && Integer.parseInt(Day) > 28,
				"Invalid date provided " + Day + "-" + Month + "-" + Year);
		Assert.assertFalse(Integer.parseInt(Day1) > 31, "Invalid date provided " + Day1 + "-" + Month1 + "-" + Year1);
		Assert.assertFalse(Month.equals("Feb") && Integer.parseInt(Day1) > 28,
				"Invalid date provided " + Day1 + "-" + Month1 + "-" + Year1);
		String monthYear = QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[1]/div")).getText();
		String month = monthYear.split(" ")[0];
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
				break;
			}
		}
		Thread.sleep(2000);
		String monthYear1 = QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[1]/div")).getText();
		String month1 = monthYear1.split(" ")[0];
		String year1 = monthYear1.split(" ")[1];
		Assert.assertFalse(date3.before(date2), "Invalid date provided " + Day1 + "-" + Month1 + "-" + Year1);
		while (!(month1.equals(Month1) && year1.equals(Year1))) {
			QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/a[3]")).click();
			monthYear1 = QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[1]/div")).getText();
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

	public static void selectDateInCalendarHotel(String Day, String Month, String Year, String Day1, String Month1,
			String Year1) throws Exception {
		Date date = new Date();
		DateFormat d = new SimpleDateFormat("dd-MM-yyyy");
		String NewDate = d.format(date);
		Date date1 = d.parse(NewDate);
//		System.out.println(date1);

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
//		System.out.println(date2);

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
//		System.out.println(date3);

		QaExtentReport.test.log(Status.INFO, "<b><i>Select Departure Date  </i></b>" + Day + "-" + Month + "-" + Year);
		QaExtentReport.test.log(Status.INFO, "<b><i>Select Return Date  </i></b>" + Day1 + "-" + Month1 + "-" + Year1);

		Assert.assertFalse(Integer.parseInt(Day) > 31, "Invalid date provided " + Day + "-" + Month + "-" + Year);
		Assert.assertFalse(Month.equals("Feb") && Integer.parseInt(Day) > 28,
				"Invalid date provided " + Day + "-" + Month + "-" + Year);
		Assert.assertFalse(Integer.parseInt(Day1) > 31, "Invalid date provided " + Day1 + "-" + Month1 + "-" + Year1);
		Assert.assertFalse(Month.equals("Feb") && Integer.parseInt(Day1) > 28,
				"Invalid date provided " + Day1 + "-" + Month1 + "-" + Year1);

		String monthYear = QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[1]/div")).getText();

		String month = monthYear.split(" ")[0];
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
				break;
			}
		}
		Thread.sleep(2000);
		String monthYear1 = QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[1]/div")).getText();
		Thread.sleep(2000);
//				System.out.println(monthYear1);
		String month1 = monthYear1.split(" ")[0];
		String year1 = monthYear1.split(" ")[1];

		Assert.assertFalse(date3.before(date2), "Invalid date provided " + Day1 + "-" + Month1 + "-" + Year1);
		while (!(month1.equals(Month1) && year1.equals(Year1))) {
			QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/a[3]")).click();

			monthYear1 = QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[1]/div")).getText();

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
