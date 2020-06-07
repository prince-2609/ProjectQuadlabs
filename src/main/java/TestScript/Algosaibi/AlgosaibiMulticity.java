package TestScript.Algosaibi;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.TestBase;
import TestScript.RoundTrip.Flightcheck;
import entities.Algosaibi_multicity;
import utilities.QaExcelRead;
import utilities.QaRobot;
import utilities.QaDataProvider;

public class AlgosaibiMulticity extends Flightcheck 
{


	TestBase t;
	QaExcelRead reader;

	@DataProvider
	public Object[][] getexceldata() throws Exception {
		
		return QaDataProvider.getTestdata("algosaibi","Multicity");
	}
	

	@Test(dataProvider = "getexceldata")

	public static void flightMultiCitytest(String ccode,String username, String password, String origin, String forigin,
			String destination, String fdestination, String origin1, String forigin1, String destination1,
			String fdestination1, String ddate, String adate, String adate1,String Triptype, String adult, String child, String infant,
			String fclass, String airlines, String emailid, String title, String adultfname, String adultmname,
			String adultlname, String adultdate, String adultmonth, String adultyear,String adultidno,  String adultisd,
			String adultphone, String adultpassprot, String adultpassportcomp, String adultedate, String adultemonth,
			String adulteyear, String adultnationality, String ctitle, String childfname, String childlname,
			String childdate, String childmonth, String childyear,String childidno, String childpassprot,
			String childpassportcomp, String childedate, String childemonth, String childeyear, String childnationality,
			String ititle, String infantfname, String infantlname, String infantdate, String infantmonth,
			String infantyear,String infantidno,  String infantTravelling, String infantpassprot,
			String infantpassportcomp, String infantedate, String infantemonth, String infanteyear,
			String infantnationality, String btitle, String bfname, String blname, String baddress, String bcity,
			String bcityauto, String bstate, String bzipcode, String bcountry, String cardmode, String type,
			String cardno, String cardname, String cardmonth, String cardyear, String cardcvv, String cardpwd,String couponno,String discountvalue)
			throws Exception {

		//TestBase.impliwait(30);
		// click on multicity button
		
		Companycode(ccode);
		
		driver.findElement(By.xpath("//label[@class='radio-inline tab-3blk']")).click();

		QaRobot.impliwait(30);

		// select first depart city
		TestBase.listofautosuggestion(By.xpath("//DIV[@id='dynamultidepart1']/P"), origin, forigin,
				By.xpath("//input[@id='depcity1']"));
		QaRobot.impliwait(10);

		// select first arrival city
		TestBase.listofautosuggestion(By.xpath("//DIV[@id='dynamultiarr1']/P"), destination, fdestination,
				By.xpath("//input[@id='arrcity1']"));

		QaRobot.impliwait(10);

		// click on second depart city
		QaRobot.getWebElement("secondcity").click();

		// select second arrival city
		TestBase.listofautosuggestion(By.xpath("//DIV[@id='dynamultiarr2']/P"), origin1,
				forigin1, By.xpath("//input[@id='arrcity2']"));

		QaRobot.impliwait(10);
		
		//after issue resolved ...................
		
//		//add more city
//		
//		driver.findElement(By.xpath("//i[@class='fa fa-plus']")).click();
//
//		// click on third depart city
//		getWebElement("travelmall_addmulticity").click();
//
//		TestBase.impliwait(10);
//		
//		driver.findElement(By.xpath("//input[@id='depcity3']")).click();
//		
//		// select third arrival city
//		TestBase.listofautosuggestion(By.xpath("//DIV[@id='dynamultiarr3']/P"), destination1, fdestination1,
//				By.xpath("//input[@id='arrcity3']"));
//		
//		TestBase.impliwait(10);
		
		test = report.createTest("Algosaibi flight MultiCity");

		Algosaibi_multicity.flightMulticity_search(ddate, adate, adate1,Triptype, adult, child, infant, fclass, airlines,
				emailid, title, adultfname, adultmname, adultlname, adultdate, adultmonth, adultyear,adultidno,
				adultisd, adultphone, adultpassprot, adultpassportcomp, adultedate, adultemonth, adulteyear,
				adultnationality, ctitle, childfname, childlname, childdate, childmonth, childyear, childidno,
				childpassprot, childpassportcomp, childedate, childemonth, childeyear, childnationality, ititle,
				infantfname, infantlname, infantdate, infantmonth, infantyear,infantidno, infantTravelling,
				infantpassprot, infantpassportcomp, infantedate, infantemonth, infanteyear, infantnationality, btitle,
				bfname, blname, baddress, bcity, bcityauto, bstate, bzipcode, bcountry, cardmode, type, cardno,
				cardname, cardmonth, cardyear, cardcvv, cardpwd,couponno,discountvalue);
	

	}
	
	@AfterMethod
	public static void afterMetod()
	{
		test.getExtent().flush();
	}

}
