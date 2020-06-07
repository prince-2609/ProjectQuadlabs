package TestScript.Travelmall;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Base.TestBase;
import TestScript.RoundTrip.Flightcheck;
import entities.Travelmall_TOneway;
import utilities.QaDataProvider;
import utilities.QaExcelRead;
import utilities.QaRobot;

public class TravelmallToneway extends Flightcheck {

	TestBase t;
	QaExcelRead reader;

	@DataProvider
	public Object[][] getexceldata() throws Exception {

		
		return QaDataProvider.getTestdata("travelmalloneway","TransferOneway");
	}

	@Test(dataProvider = "getexceldata")

	public static void transferOneway(String ccode, String Country, String Pickuptype, String dropofftype,
			String pickuplocation, String pickloctionlist, String dropofflocation, String droplocationlist,
			String adult, String child, String departdate, String servicetime, String Extratime, String currency,
			String nationality, String Tbooking, String Arrival, String terminal, String flightno, String hours,
			String minute,String departure, String dropterminal, String dropflightno, String drophours, String dropminute, String email,
			String title, String adultfname, String adultlname, String adultdate, String adultmonth, String adultyear,
			String adultisd, String adultphone, String adultnationality, String adultCountryOfResidence,
			String adultAddressLine,String adultmeal, String ctitle, String childfname, String childlname, String childdate,
			String childmonth, String childyear, String childnationality, String childCountryOfResidence,
			String childAddressLine,String childmeal, String cardmode, String type, String cardno, String cardname, String cardmonth,
			String cardyear, String cardcvv, String btitle, String bfname, String blname, String baddress, String bcity,
			String bcityauto, String bstate, String bzipcode, String bcountry) throws Exception {

		Companycode(ccode);

		test = report.createTest("Transfer Oneway");

		QaRobot.ClickOnElement("Transfer", "Clicked on Transfer");

		Travelmall_TOneway.Transfer_OneWaysearch(ccode,Country, Pickuptype, dropofftype, pickuplocation, pickloctionlist,
				dropofflocation, droplocationlist, adult, child, departdate, servicetime, Extratime, currency,
				nationality, Tbooking, Arrival, terminal, flightno, hours, minute,departure, dropterminal, dropflightno,
				drophours, dropminute, email, title, adultfname, adultlname, adultdate, adultmonth, adultyear, adultisd,
				adultphone, adultnationality, adultCountryOfResidence, adultAddressLine, adultmeal,ctitle, childfname, childlname,
				childdate, childmonth, childyear, childnationality, childCountryOfResidence, childAddressLine, childmeal,cardmode,
				type, cardno, cardname, cardmonth, cardyear, cardcvv, btitle, bfname, blname, baddress, bcity,
				bcityauto, bstate, bzipcode, bcountry);
	}

	@AfterMethod
	public static void afterMetod() {
		test.getExtent().flush();
	}
}
