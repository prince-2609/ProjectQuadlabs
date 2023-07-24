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
public class Hotel {

	@DataProvider
	public Object[][] getexceldata() throws Exception {
		return QaDataProvider.getTestdata("JOLO_SBT_Flight_Hotel_Car", "Sheet13");
	}

	@Test(dataProvider = "getexceldata")
	public static void Sbt_Hotel_Search(String TestCaseId, String TestScenario, String EmployeName, String TravelerType,
			String CreatorName, String ccode, String Server, String URL, String UserName, String Password,
			String CorporateTraveller, String TravellerType, String Trip, String CityCode, String CityTitle,
			String CheckInDate, String CheckOutDate, String Rooms, String Adult, String Child, String ChildAge,
			String ModifySearch, String TravellerTypeM, String ChangeTripLocation, String CityCodeM, String CityTitleM,
			String ChangeTripDate, String CheckInDateM, String CheckOutDateM, String ChangeRooms, String RoomsM,
			String AdultM, String ChildM, String ChildAgeM, String Applyfilter, String ChangeStarRating,
			String StarRatingM, String ChangePropertyType, String SelectProperty, String Resultpagestep,
			String ProductType, String TripType, String OriginCityCode, String OriginLocation,
			String DestinationCityCode, String DestinationLocation, String DepartureDate, String ReturnDate,
			String adult, String child, String infant, String Class, String ShowDirectFlight, String PickUpCode,
			String PickUpCity, String PickUpDate, String DropOffDate, String DriversAge,
			String DropOffToDifferentLocation, String DropOffCode, String DropOffCity, String SelectItineraryAs,
			String QuoteTitle, String QuoteRemark, String Checkoutpagestep, String FOP, String CardType,
			String CreditCardNumber, String CardHolderName, String CardExpiryDate) throws Exception {
		QaExtentReport.test = QaExtentReport.report.createTest(TestCaseId + "-" + TestScenario);
		TestBase.Companycode(ccode, URL);
		QaRobot.impliwait(30);
		Login.SbtLogin(UserName, Password);
		QaExtentReport.test.log(Status.INFO, "<b><i>Employee Name is  </i></b>" + EmployeName);
		QaExtentReport.test.log(Status.INFO, "<b><i> Traveler Type is  </i></b>" + TravelerType);
		QaRobot.ClickOnElement("HotelJ");
		SearchDashboard.selectEmployeeWithID(CorporateTraveller);
		if (TravellerType.equalsIgnoreCase("Individual")) {
			QaRobot.ClickOnElement("trip_Busniess");
			SBT_JOLO_TripType.hotelTripType(TravellerType, CityCode, CityTitle, CheckInDate, CheckOutDate, Rooms, Adult,
					Child, ChildAge);
			SBT_JOLO_ResultPage.ResultPageForHotel(CreatorName, Server, TravellerType, Trip, Rooms, Adult, Child,
					ModifySearch, TravellerTypeM, ChangeTripLocation, CityCodeM, CityTitleM, ChangeTripDate,
					CheckInDateM, CheckOutDateM, ChangeRooms, RoomsM, AdultM, ChildM, ChildAgeM, Applyfilter,
					ChangeStarRating, StarRatingM, ChangePropertyType, SelectProperty, Resultpagestep, ProductType,
					TripType, OriginCityCode, OriginLocation, DestinationCityCode, DestinationLocation, DepartureDate,
					ReturnDate, adult, child, infant, Class, ShowDirectFlight, PickUpCode, PickUpCity, PickUpDate,
					DropOffDate, DriversAge, DropOffToDifferentLocation, DropOffCode, DropOffCity, SelectItineraryAs,
					QuoteTitle, QuoteRemark, Checkoutpagestep, FOP, CardType, CreditCardNumber, CardHolderName,
					CardExpiryDate);
		} else if (TravellerType.equalsIgnoreCase("Dependent")) {
		} else if (TravellerType.equalsIgnoreCase("Personal")) {
		}
	}

	@AfterTest
	public static void After_Test() {
		QaExtentReport.test.getExtent().flush();
	}
}
