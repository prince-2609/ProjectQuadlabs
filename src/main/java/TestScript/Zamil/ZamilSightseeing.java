package TestScript.Zamil;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Base.TestBase;
import TestScript.RoundTrip.Flightcheck;
import entities.Zamil_Sightseeing;
import utilities.QaDataProvider;
import utilities.QaExcelRead;
import utilities.QaRobot;

public class ZamilSightseeing extends Flightcheck {
	
	TestBase t;
	QaExcelRead reader;
	
	@DataProvider
	public Object[][] getexceldata() throws Exception {
		
		
		return QaDataProvider.getTestdata("zamil","sightseeing");
	}
	
	@Test(dataProvider="getexceldata")
	
	public static void SightseeingTrip(String ccode,String country,String city,String cityname,String pickdate,String adult,String child,String nationality,String type,String currency,String Sbooking, String email, String title, String adultfname, String adultlname, String adultdate,
			String adultmonth, String adultyear, String adultisd, String adultphone, String adultnationality,
			String adultCountryOfResidence, String adultAddressLine,String adultmeal, String ctitle, String childfname,
			String childlname, String childdate, String childmonth, String childyear, String childnationality,
			String childCountryOfResidence, String childAddressLine,String childmeal, String cardmode, String cardtype, String cardno,
			String cardname, String cardmonth, String cardyear, String cardcvv, String btitle, String bfname,
			String blname, String baddress, String bcity, String bcityauto, String bstate, String bzipcode,
			String bcountry) throws Exception
	{
		
		Companycode(ccode);
		test = report.createTest("Zamil Sightseeing");
		
		QaRobot.ClickOnElement("zamil_sightseeing", "Clicked on sightseeing");
		
		Zamil_Sightseeing.Sightseen_search(ccode,country, city, cityname, pickdate, adult, child, nationality, type, currency,Sbooking,email, title, adultfname, adultlname,
				adultdate, adultmonth, adultyear, adultisd, adultphone, adultnationality,adultCountryOfResidence,adultAddressLine, adultmeal,ctitle, childfname,
				childlname, childdate, childmonth, childyear, childnationality,childCountryOfResidence,childAddressLine,childmeal,cardmode,
				cardtype,cardno,cardname,cardmonth,cardyear,cardcvv,btitle, bfname,blname,baddress,bcity,bcityauto,bstate,bzipcode,bcountry);
		
		
		
	}
	
	@AfterMethod
	public static void afterMetod()
	{
		test.getExtent().flush();
	}
	
	

}
