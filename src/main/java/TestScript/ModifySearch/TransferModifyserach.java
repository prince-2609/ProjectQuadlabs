package TestScript.ModifySearch;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import Base.TestBase;
import TestScript.RoundTrip.Flightcheck;
import utilities.QaDataProvider;
import utilities.QaExcelRead;
import utilities.Logger;
import utilities.QaRobot;

public class TransferModifyserach extends Flightcheck {

	TestBase t;
	QaExcelRead reader;

	@DataProvider
	public Object[][] getexceldata() throws Exception {

		
		return QaDataProvider.getTestdata("TransferOneWay","modify");
	}

	@Test(dataProvider = "getexceldata")

	public static void transferOneway(String ccode,String Country, String Pickuptype, String dropofftype, String pickuplocation,
			String pickloctionlist, String dropofflocation, String droplocationlist, String adult, String child,
			String departdate, String servicetime, String Extratime, String currency, String nationality,
			String mod_country, String modpickuplocation, String modpickloctionlist, String moddropofflocation,
			String moddroplocationlist, String modPickuptype, String moddropofftype, String modadult, String modchild,
			String moddepartdate,String modservicetime,String modExtratime,String modcurrency,String modcountryofresi,String modnationality) throws Exception {

		
		Companycode(ccode);
		
		String departdate1 = "id:id" + departdate;// id:id1252019
		String moddepartdate1 = "id:id" + moddepartdate;// id:id1252019
		test = report.createTest("Transfer Oneway");

		QaRobot.ClickOnElement("Transfer", "Clicked on Transfer");

		// select Country

		QaRobot.selectTextFromDropdown("T_Country", Country, "Selected Transfer Country");

		// select pickup type

		QaRobot.selectValueFromDropdown("T_picktype", Pickuptype, "Selected Pickup Type");

		// select drop off type

		QaRobot.selectValueFromDropdown("T_dropofftype", dropofftype, "Selected Dropoff Type");

		// select pick up loctaion

		TestBase.listofautosuggestion(By.xpath("//div[@id='popUP_div']/p"), modpickuplocation, modpickloctionlist,
				By.xpath("//input[@id='TFR_PkUpLocation_txt']"));
		QaRobot.impliwait(60);

		// select drop off location

		TestBase.listofautosuggestion(By.xpath("//div[@id='TFR_DropOFF_div']/p"), moddropofflocation,
				moddroplocationlist, By.xpath("//input[@id='TFR_DropOFF_Location']"));

		QaRobot.impliwait(60);

		// select Adult value

		QaRobot.selectValueFromDropdown("T_Adult", adult, "Selected Adult for Transfer");

		// select Child value

		QaRobot.selectValueFromDropdown("T_child", child, "Selected Child for Transfer");

		// departure date

		QaRobot.ClickOnElement("T_departdate", "Clicked on Transfer Departure");

		Thread.sleep(1000);

		// ClickOnElement("nextmonth_calender", "Clicked on Next Month Button");
		// ClickOnElement("nextmonth_calender", "Clicked on Next Month Button");

		QaRobot.getLocator(departdate1).click();// id1252019

		Thread.sleep(500);

		// select Service time

		QaRobot.selectTextFromDropdown("T_Servicetime", servicetime, "Selected Serivice Time");

		// click on more option

		QaRobot.ClickOnElement("T_moreoption", "clicked on more option");

		// select Extra time

		QaRobot.selectValueFromDropdown("T_Extratime", Extratime, "Selected Extra Time");

		// select currency

		QaRobot.selectValueFromDropdown("T_currency", currency, "Selected Currency");

		// Select Nationality
		QaRobot.selectTextFromDropdown("T_Nationality", nationality, "Selected Nationality");

		// take screenshot for search page

		String searchpage = Logger.takeScreenshot(driver, "Search Page");
		test.log(Status.INFO, "Screenshot for Search Page",
				MediaEntityBuilder.createScreenCaptureFromPath(searchpage).build());

		// search
		QaRobot.ClickOnElement("T_Serach", "Clicked On Serach");

		QaRobot.explicitwaitinvisible(70, By.xpath("//div[@class='loadbar ld_trnsfr']"));

		// get current url

		String url = driver.getCurrentUrl();

		System.out.println(url);

		String[] uid = url.split("=");

		// System.out.println(id[0]);

		// System.out.println(id[1]);

		test.log(Status.INFO, "Result page url is  " + url);

		test.log(Status.INFO, "Session id is " + uid[1]);

		// take screenshot for result page

		String resultpage = Logger.takeScreenshot(driver, "Resultpage");
		test.log(Status.INFO, "Screenshot for Resultpage",
				MediaEntityBuilder.createScreenCaptureFromPath(resultpage).build());

		// Click on Modify Search

		QaRobot.ClickOnElement("T_mod_transfer", "Clicked on Transfer ModifySearch");

		// Click on RoundTrip

		QaRobot.ClickOnElement("T_mod_round", "Clicked on RoundTrip");

		// Select Country
		QaRobot.selectTextFromDropdown("T_mod_country", mod_country, "Selected Nationality");

		// select pickup type

		QaRobot.selectValueFromDropdown("T_mod_picktype", modPickuptype, "Selected Pickup Type");

		// select drop off type

		QaRobot.selectValueFromDropdown("T_mod_droptype", moddropofftype, "Selected Dropoff Type");

		// select pick up loctaion

		TestBase.listofautosuggestion(By.xpath("//div[@id='divHTCity']/p"), modpickuplocation, modpickloctionlist,
				By.xpath("//input[@id='txtHTCity']"));
		QaRobot.impliwait(60);

		// select drop off location

		TestBase.listofautosuggestion(By.xpath("//div[@id='divDropOff']/p"), moddropofflocation,
				moddroplocationlist, By.xpath("//input[@id='txtDropoffLocation']"));

		QaRobot.impliwait(60);

		// select Adult value

		QaRobot.selectValueFromDropdown("T_mod_adult", modadult, "Selected Adult for Transfer");

		// select Child value

		QaRobot.selectValueFromDropdown("T_mod_child", modchild, "Selected Child for Transfer");

		// departure date

		QaRobot.ClickOnElement("T_departdate", "Clicked on Transfer Departure");

		Thread.sleep(1000);

		// ClickOnElement("nextmonth_calender", "Clicked on Next Month Button");
		// ClickOnElement("nextmonth_calender", "Clicked on Next Month Button");

		QaRobot.getLocator(moddepartdate1).click();// id1252019

		Thread.sleep(500);

		// select Service time

		QaRobot.selectTextFromDropdown("T_mod_sertym", modservicetime, "Selected Serivice Time");

		// select Extra time

		QaRobot.selectValueFromDropdown("T_mod_exttym", modExtratime, "Selected Extra Time");

		// select currency

		QaRobot.selectValueFromDropdown("T_mod_currency", modcurrency, "Selected Currency");
		
		// Select CountryOfResi
		QaRobot.selectTextFromDropdown("T_mod_countryresi", modcountryofresi, "Selected CountryOfResidence");

		// Select Nationality
		QaRobot.selectTextFromDropdown("T_mod_nationality", modnationality, "Selected Nationality");

	}

	@AfterMethod
	public static void afterMetod() {
		test.getExtent().flush();
	}

}
