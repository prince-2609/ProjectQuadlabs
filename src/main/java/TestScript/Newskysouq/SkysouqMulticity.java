package TestScript.Newskysouq;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.TestBase;
import TestScript.RoundTrip.Flightcheck;
import entities.Skysouq_multicity;
import utilities.QaDataProvider;
import utilities.QaExcelRead;
import utilities.QaRobot;

public class SkysouqMulticity extends Flightcheck {

	TestBase t;
	QaExcelRead reader;

	@DataProvider
	public Object[][] getexceldata() throws Exception {

		
		
		return QaDataProvider.getTestdata("Newskysouq","Multicity");
	}

	@Test(dataProvider = "getexceldata")

	public static void flightMultiCitytest(String ccode, String language, String username, String password,
			String origin, String forigin, String destination, String fdestination, String origin1, String forigin1,
			String destination1, String fdestination1, String ddate, String adate, String adate1, String Triptype,
			String adult, String child, String infant, String fclass, String airlines, String emailid, String title,
			String adultfname, String adultmname, String adultlname, String adultdate, String adultmonth,
			String adultyear, String adultidno, String adultisd, String adultphone, String adultpassprot,
			String adultpassportcomp, String adultedate, String adultemonth, String adulteyear, String adultnationality,
			String ctitle, String childfname, String childlname, String childdate, String childmonth, String childyear,
			String childidno, String childpassprot, String childpassportcomp, String childedate, String childemonth,
			String childeyear, String childnationality, String ititle, String infantfname, String infantlname,
			String infantdate, String infantmonth, String infantyear, String infantidno, String infantTravelling,
			String infantpassprot, String infantpassportcomp, String infantedate, String infantemonth,
			String infanteyear, String infantnationality, String btitle, String bfname, String blname, String baddress,
			String bcity, String bcityauto, String bstate, String bzipcode, String bcountry, String cardmode,
			String type, String cardno, String cardname, String cardmonth, String cardyear, String cardcvv,
			String cardpwd, String couponno, String discountvalue) throws Exception {

		// TestBase.impliwait(30);
		// click on multicity button

		Companycode(ccode);

		// language validation

		if (language.equalsIgnoreCase("AR")) {

			Actions actions = new Actions(driver);
			WebElement menuOption = driver.findElement(By.xpath("//span[@id='headerlanguage']"));
			actions.moveToElement(menuOption).perform();
			driver.findElement(By.xpath("//p[@class='heading']")).click();
			WebElement selectMenuOption = driver.findElement(By.xpath("//a[@id='btnArabic']"));
			selectMenuOption.click();
		}
		if (language.equalsIgnoreCase("EN")) {

			Actions actions = new Actions(driver);
			WebElement menuOption = driver.findElement(By.xpath("//span[@id='headerlanguage']"));
			actions.moveToElement(menuOption).perform();
			driver.findElement(By.xpath("//p[@class='heading']")).click();
			WebElement selectMenuOption = driver.findElement(By.xpath("//a[@id='btnEnglish']"));
			selectMenuOption.click();
		}

		Thread.sleep(300);

		driver.findElement(By.xpath("(//label[@class='form-check-label'])[3]")).click();

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
		TestBase.listofautosuggestion(By.xpath("//DIV[@id='dynamultiarr2']/P"), origin1, forigin1,
				By.xpath("//input[@id='arrcity2']"));

		QaRobot.impliwait(10);

		// add more city

		driver.findElement(By.xpath("//button[@id='AddMultiCity2']")).click();

		QaRobot.impliwait(10);

		driver.findElement(By.xpath("//input[@id='depcity3']")).click();

		// select third arrival city
		TestBase.listofautosuggestion(By.xpath("//DIV[@id='dynamultiarr3']/P"), destination1, fdestination1,
				By.xpath("//input[@id='arrcity3']"));

		QaRobot.impliwait(10);

		test = report.createTest("Skysouq flight MultiCity");

		Skysouq_multicity.flightMulticity_search(language,ddate, adate, adate1, Triptype, adult, child, infant, fclass, airlines,
				emailid, title, adultfname, adultmname, adultlname, adultdate, adultmonth, adultyear, adultidno,
				adultisd, adultphone, adultpassprot, adultpassportcomp, adultedate, adultemonth, adulteyear,
				adultnationality, ctitle, childfname, childlname, childdate, childmonth, childyear, childidno,
				childpassprot, childpassportcomp, childedate, childemonth, childeyear, childnationality, ititle,
				infantfname, infantlname, infantdate, infantmonth, infantyear, infantidno, infantTravelling,
				infantpassprot, infantpassportcomp, infantedate, infantemonth, infanteyear, infantnationality, btitle,
				bfname, blname, baddress, bcity, bcityauto, bstate, bzipcode, bcountry, cardmode, type, cardno,
				cardname, cardmonth, cardyear, cardcvv, cardpwd, couponno, discountvalue);

	}

	@AfterMethod
	public static void afterMetod() {
		test.getExtent().flush();
	}

}
