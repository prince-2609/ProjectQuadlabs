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
public class Flight {

	@DataProvider
	public Object[][] getexceldata() throws Exception {
		return QaDataProvider.getTestdata("JOLO_SBT_Flight_Hotel_Car", "Sheet14");
	}

	@Test(dataProvider = "getexceldata")
	public static void Sbt_Flight_Search(String TestCaseId, String TestScenario, String EmployeName,
			String TravelerType, String CreatorName, String ccode, String Server, String URL, String UserName,
			String Password, String CorporateTraveller, String TravellerType, String Trip, String TripType,
			String OriginCityCode, String OriginLocation, String DestinationCityCode, String DestinationLocation,
			String DepartureDate, String ReturnDate, String adult, String child, String infant, String Class,
			String ShowDirectFlight, String ModifySearch, String ChangeTrip, String TripTypeM, String OriginCityCodeM,
			String OriginLocationM, String DestinationCityCodeM, String DestinationLocationM, String ChangeTripDate,
			String DepartureDateM, String ReturnDateM, String ChangeTravellers, String adultM, String childM,
			String infantM, String ChangeClass, String ClassM, String ShowDirectFlightM, String Applyfilter,
			String ChooseFareType, String FareType, String ChooseAirLine, String OneWayAirLine, String RoundTripAirLine,
			String OneWayFareType, String RoundTripFareType, String Resultpagestep, String ProductType, String CityCode,
			String CityTitle, String CheckInDate, String CheckOutDate, String PickUpCode, String PickUpCity,
			String PickUpDate, String DropOffDate, String PickUpTime, String DropOffTime, String DriversAge,
			String DropOffToDifferentLocation, String DropOffCode, String DropOffCity, String SelectItineraryAs,
			String QuoteTitle, String QuoteRemark, String Checkoutpagestep, String FOP, String CardType,
			String CreditCardNumber, String CardHolderName, String CardExpiryDate) throws Exception {
		QaExtentReport.test = QaExtentReport.report.createTest(TestCaseId + "-" + TestScenario);
		TestBase.Companycode(ccode, URL);
		QaRobot.impliwait(30);
		Login.SbtLogin(UserName, Password);
		QaExtentReport.test.log(Status.INFO, "<b><i>Employee Name is  </i></b>" + EmployeName);
		QaExtentReport.test.log(Status.INFO, "<b><i> Traveler Type is  </i></b>" + TravelerType);
		QaRobot.ClickOnElement("FlightJ");
		SearchDashboard.selectEmployeeWithID(CorporateTraveller);
		if (TravellerType.equalsIgnoreCase("Individual")) {
			QaRobot.ClickOnElement("trip_Busniess");
			SBT_JOLO_TripType.flightTriptype(TravellerType, TripType, OriginCityCode, OriginLocation,
					DestinationCityCode, DestinationLocation, DepartureDate, ReturnDate, adult, child, infant, Class,
					ShowDirectFlight);
			SBT_JOLO_ResultPage.ResultPageForFlight(CreatorName, Server, TravellerType, Trip, TripType, adult, child,
					infant, ModifySearch, ChangeTrip, TripTypeM, OriginCityCodeM, OriginLocationM, DestinationCityCodeM,
					DestinationLocationM, ChangeTripDate, DepartureDateM, ReturnDateM, ChangeTravellers, adultM, childM,
					infantM, ChangeClass, ClassM, ShowDirectFlightM, Applyfilter, ChooseFareType, FareType,
					ChooseAirLine, OneWayAirLine, RoundTripAirLine, OneWayFareType, RoundTripFareType, Resultpagestep,
					ProductType, CityCode, CityTitle, CheckInDate, CheckOutDate, PickUpCode, PickUpCity, PickUpDate,
					DropOffDate, PickUpTime, DropOffTime, DriversAge, DropOffToDifferentLocation, DropOffCode,
					DropOffCity, SelectItineraryAs, QuoteTitle, QuoteRemark, Checkoutpagestep, FOP, CardType,
					CreditCardNumber, CardHolderName, CardExpiryDate);
		} else if (TravellerType.equalsIgnoreCase("Dependent")) {
		} else if (TravellerType.equalsIgnoreCase("Personal")) {
		}
	}

	@AfterTest
	public static void After_Test() {
		QaExtentReport.test.getExtent().flush();
	}
}
