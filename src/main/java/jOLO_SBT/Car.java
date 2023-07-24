package jOLO_SBT;

import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import Base.TestBase;
import entities.Login;
import product.Flight.suite.Oneway.SearchDashboard;
import utilities.QaDataProvider;
import utilities.QaExtentReport;
import utilities.QaRobot;

@Listeners(listenerClass.Listener.class)
public class Car {

	@DataProvider
	public Object[][] getexceldata() throws Exception {
		return QaDataProvider.getTestdata("JOLO_SBT_Flight_Hotel_Car", "Sheet10");
	}

	@Test(dataProvider = "getexceldata")
	public static void Sbt_Car_Search(String TestCaseId, String TestScenario, String EmployeName, String TravelerType,
			String CreatorName, String ccode, String Server, String URL, String UserName, String Password,
			String CorporateTraveller, String SearchType, String Trip, String PickUpCode, String PickUpCity,
			String PickUpDate, String DropOffDate, String PickUpTime, String DropOffTime, String DriversAge,
			String CountryOfResidency, String Adult, String Child, String Infant, String DropOffToDifferentLocation,
			String DropOffCode, String DropOffCity, String ModifySearch, String TravellerTypeM, String ChangePickUpTrip,
			String PickUpCodeM, String PickUpCityM, String ChangePickUpDate, String PickUpDateM,
			String ChangeDropOffDate, String DropOffDateM, String ChangePickUpTime, String PickUpTimeM,
			String ChangeDropOffTime, String DropOffTimeM, String ChangeDriverAge, String DriversAgeM,
			String ChangeTravellers, String AdultM, String ChildM, String InfantM, String ChooseCarTypeM,
			String CarTypeM, String DropOffToDifferentLocationM, String DropOffCodeM, String DropOffCityM,
			String Applyfilter, String CarType, String Carqty, String CancelCarResult, String Classqty,
			String CancelClassResult, String ClassType, String CancleTransmission, String AirCondition,
			String Resultpagestep, String ProductType, String TripType, String OriginCityCode, String OriginLocation,
			String DestinationCityCode, String DestinationLocation, String DepartureDate, String ReturnDate,
			String CityCode, String CityTitle, String CheckInDate, String CheckOutDate, String SelectItineraryAs,
			String QuoteTitle, String QuoteRemark, String Checkoutpagestep, String FOP, String CardType,
			String CreditCardNumber, String CardHolderName, String CardExpiryDate) throws Exception {
		QaExtentReport.test = QaExtentReport.report.createTest(TestCaseId + "-" + TestScenario);
		TestBase.Companycode(ccode, URL);
		QaRobot.impliwait(30);
		Login.SbtLogin(UserName, Password);
		QaExtentReport.test.log(Status.INFO, "<b><i>Employee Name is  </i></b>" + EmployeName);
		QaExtentReport.test.log(Status.INFO, "<b><i> Traveler Type is  </i></b>" + TravelerType);
//		if (Server.equalsIgnoreCase("tpstg")) {
//			QaRobot.ClickOnElement("Travelport");
//			Thread.sleep(3000);
//		}
		QaRobot.ClickOnElement("Car");
		SearchDashboard.selectEmployeeWithID(CorporateTraveller);
		if (SearchType.equalsIgnoreCase("Individual")) {
			QaRobot.ClickOnElement("trip_Busniess");
			SBT_JOLO_TripType.carTriptype(SearchType, PickUpCode, PickUpCity, PickUpDate, DropOffDate, PickUpTime,
					DropOffTime, DriversAge, CountryOfResidency, Adult, Child, Infant, DropOffToDifferentLocation,
					DropOffCode, DropOffCity);
			SBT_JOLO_ResultPage.ResultPageForCar(CreatorName, Server, SearchType, Trip, ModifySearch, TravellerTypeM,
					ChangePickUpTrip, PickUpCodeM, PickUpCityM, ChangePickUpDate, PickUpDateM, ChangeDropOffDate,
					DropOffDateM, ChangePickUpTime, PickUpTimeM, ChangeDropOffTime, DropOffTimeM, ChangeDriverAge,
					DriversAgeM, ChangeTravellers, AdultM, ChildM, InfantM, ChooseCarTypeM, CarTypeM,
					DropOffToDifferentLocationM, DropOffCodeM, DropOffCityM, Applyfilter, CarType, Carqty,
					CancelCarResult, Classqty, CancelClassResult, ClassType, CancleTransmission, AirCondition,
					Resultpagestep, ProductType, TripType, OriginCityCode, OriginLocation, DestinationCityCode,
					DestinationLocation, DepartureDate, ReturnDate, CityCode, CityTitle, CheckInDate, CheckOutDate,
					SelectItineraryAs, QuoteTitle, QuoteRemark, Checkoutpagestep, FOP, CardType, CreditCardNumber,
					CardHolderName, CardExpiryDate);

		} else if (SearchType.equalsIgnoreCase("Dependent")) {
		} else if (SearchType.equalsIgnoreCase("Personal")) {
		}
	}

	@AfterTest
	public static void After_Test() {
		QaExtentReport.test.getExtent().flush();
	}
}
