package TestScript.OneWay;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Base.TestBase;
import TestScript.RoundTrip.Flightcheck;
import entities.FlightOneWay_Search;
import utilities.QaDataProvider;
import utilities.QaExcelRead;
import utilities.QaExtentReport;

public class FlightOneWay extends Flightcheck {
	TestBase t;
	QaExcelRead reader;

	@DataProvider
	public Object[][] getexceldata() throws Exception {

		
		return QaDataProvider.getTestdata("OneWay","Sheet2");
	}
	
	@Test(dataProvider = "getexceldata")

	public static void flightOneway(String ccode,String username, String password, String origin, String forigin, String destination,
			String fdestination, String ddate,String Triptype, String adult, String child, String infant, String fcurrency,String fclass,
			String airlines, String emailid, String title, String adultfname, String adultmname, String adultlname,
			String adultdate, String adultmonth, String adultyear,String adultidno, String adultisd, String adultphone,
			String adultpassprot, String adultpassportcomp, String adultedate, String adultemonth, String adulteyear,
			String adultnationality, String ctitle, String childfname, String childlname, String childdate,
			String childmonth, String childyear,String childidno , String childpassprot, String childpassportcomp,
			String childedate, String childemonth, String childeyear,String childnationality, String ititle,
			String infantfname, String infantlname, String infantdate, String infantmonth, String infantyear,
			String infantidno, String infantTravelling, String infantpassprot, String infantpassportcomp,
			String infantedate, String infantemonth, String infanteyear, String infantnationality, String btitle,
			String bfname, String blname, String baddress, String bcity, String bcityauto, String bstate,
			String bzipcode, String bcountry, String cardmode, String type, String cardno, String cardname,
			String cardmonth, String cardyear, String cardcvv, String cardpwd,String couponno,String discountvalue) throws Exception {

		Companycode(ccode);
		
		Thread.sleep(2000);

		TestBase.listofautosuggestion(By.xpath("//DIV[@id='divFLDepart']/P"), origin, forigin,
				By.xpath("//input[@id='fromcityAc']"));
		//TestBase.impliwait(40);
		Thread.sleep(1000);

		TestBase.listofautosuggestion(By.xpath("//DIV[@id='divFLArrival']/P"), destination, fdestination,
				By.xpath("//input[@id='tocityAc']"));

		
		Thread.sleep(1000);
		
		QaExtentReport.test = QaExtentReport.report.createTest("flight Oneway");
		
		FlightOneWay_Search.flight_search(ddate, Triptype, adult, child, infant, fcurrency, fclass, airlines, emailid, title, adultfname, adultmname, adultlname, adultdate, adultmonth, adultyear, adultidno, adultisd, adultphone, adultpassprot, adultpassportcomp, adultedate, adultemonth, adulteyear, adultnationality, ctitle, childfname, childlname, childdate, childmonth, childyear, childidno, childpassprot, childpassportcomp, childedate, childemonth, childeyear, childnationality, ititle, infantfname, infantlname, infantdate, infantmonth, infantyear, infantidno, infantTravelling, infantpassprot, infantpassportcomp, infantedate, infantemonth, infanteyear, infantnationality, btitle, bfname, blname, baddress, bcity, bcityauto, bstate, bzipcode, bcountry, cardmode, type, cardno, cardname, cardmonth, cardyear, cardcvv, cardpwd, couponno, discountvalue);
		
	}
	@AfterMethod
	public static void afterMetod()
	{
		QaExtentReport.test.getExtent().flush();
	}
}
