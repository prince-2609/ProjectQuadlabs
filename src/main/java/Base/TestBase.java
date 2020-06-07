package Base;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import utilities.Logger;
import utilities.QaBrowser;
import utilities.QaRepositery;
import utilities.QaRobot;

public class TestBase {

	public static Properties obj;
	public static File file;
	public static FileInputStream fin;
	public static WebDriverWait wait;
	public static ExtentReports report;
	public static ExtentTest test;
	static SoftAssert softassert = new SoftAssert();

	public static String[] dblchildCat;
	public static String[] twnchildCat;
	public static String[] tplchildCat;
	public static String[] sinchildCat;
	public static String[] qudchildCat;

	private static Boolean initFlag = false;
	private static Boolean initCompletedFlag = false;
	static QaBrowser browser = new QaBrowser();
	static QaRepositery repositery = new QaRepositery();

	public static WebDriver driver;

	public static void init() throws Exception {
		if (initFlag) {
			return;
		}
		initFlag = true;
		Logger.initKlovReport();
		report = Logger.extent;
		test = Logger.test;
		repositery.init(obj);
		initCompletedFlag = true;
	}

	public static void Companycode(String ccode) throws Exception {
		init();
		if(!initCompletedFlag) {
			throw new Exception("Initialization not complete");
		}
		if (ccode.equalsIgnoreCase("ql")) {
			browser.launchBrowser("http://erp-staging/qlmetab2c");
			Logger.setProjectName("QlB2C");
		}
		if (ccode.equalsIgnoreCase("gt")) {
			browser.launchBrowser("http://travelmall.erp-staging.com");
			Logger.setProjectName("Travelmall");
		}
		if (ccode.equalsIgnoreCase("bn")) {
			browser.launchBrowser("http://erp-staging/algosaibib2c/");
			Logger.setProjectName("Algosaibi");
		}
		if (ccode.equalsIgnoreCase("ag")) {
			browser.launchBrowser("http://erp-staging/arivob2c/");
			Logger.setProjectName("Arivo");
		}
		if (ccode.equalsIgnoreCase("ts")) {
			browser.launchBrowser("http://erp-staging/holidaybaghdadb2c/");
			Logger.setProjectName("HolidayBaghdad");
		}
		if (ccode.equalsIgnoreCase("bd")) {
			browser.launchBrowser("http://erp-staging/gobdgo/");
			Logger.setProjectName("Gobdgo");
		}
		if (ccode.equalsIgnoreCase("mh")) {
			browser.launchBrowser("http://erp-staging/majestic/");
			Logger.setProjectName("Majestic");
		}
		if (ccode.equalsIgnoreCase("sb")) {
			browser.launchBrowser("http://preproduction/newskysouq/");
			Logger.setProjectName("NewSkysouq");
		}
		if (ccode.equalsIgnoreCase("zt")) {
			browser.launchBrowser("http://erp-staging/zamil/");
			Logger.setProjectName("Zamil");
		}
		Logger.setProjectName("Staging Server");

	}

	public static List<WebElement> listofautosuggestion(By suggestiontxt, String txt, String city_name, By d)
			throws InterruptedException {
		driver.findElement(d).sendKeys(txt);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		ArrayList<WebElement> autosuggestions = (ArrayList<WebElement>) driver.findElements(suggestiontxt);
		// System.out.println(autosuggestions.toString());
		for (WebElement autosuggestion : autosuggestions) {
			System.out.println(autosuggestion.getText());
			if (autosuggestion.getText().equalsIgnoreCase(city_name)) {
				System.out.println("equal");
				autosuggestion.click();
				break;
			} else {
				System.out.println("not equal");
			}
		}

		return autosuggestions;
	}

	// discount coupon
	public static void DiscountCoupon(String Locator, String msg, String amountxpath, String couponno,
			String disvalueofexcel) throws Exception {

		try {
			QaRobot.PassValue(Locator, couponno, "Entered " + couponno + " as coupon number");

			QaRobot.ClickOnElement("discount_button", "clicked on discount coupon");

			String discountMessage = QaRobot.getWebElement(msg).getText();

			test.log(Status.INFO, " Message is " + discountMessage);
			System.out.println(discountMessage);

			String discountAmount = QaRobot.getWebElement(amountxpath).getText();

			test.log(Status.PASS, "discount amount is " + discountAmount);
			System.out.println("Discounted amount is " + discountAmount);

		} catch (Exception e) {
			test.log(Status.FAIL, "Discount coupon not applied ");

			throw new Exception("Discount coupon not applied ");

		}

	}

	// flight itineray
	public static void Flight_Iteneary(String emailid) throws Exception {

		QaRobot.ClickOnElement("fare_iteneary", "clicked on flight iteneary");

		QaRobot.explicitwaitvisible(60, By.xpath("(//span[@class='ng-binding' and text()='Send Email'])[1]"));

		// send a flight iteneary

		QaRobot.ClickOnElement("email_link", "clicked on email link");

		// wait till visible close email
		QaRobot.explicitwaitvisible(60, By.xpath("//button[@class='btn btn-secondary ng-binding']"));

		QaRobot.PassValue("email_textbox", emailid, "Enterned " + emailid + "  as user email_id");

		QaRobot.ClickOnElement("send_mail", "Clicked on send email button");

		QaRobot.explicitwaitalert(100);

		// Switching to Alert
		Alert alert = TestBase.driver.switchTo().alert();

		// Capturing alert message.
		String alertMessage = TestBase.driver.switchTo().alert().getText();

		// Displaying alert message
		System.out.println(alertMessage);
		TestBase.test.log(Status.INFO, alertMessage);

		// Accepting alert
		alert.accept();

		QaRobot.ClickOnElement("close_email", "Clicked on close button");

		// wait till invisible close email
		QaRobot.explicitwaitinvisible(50, By.xpath("//button[@class='btn btn-secondary ng-binding']"));

		// print a Flight Iteneary

		QaRobot.ClickOnElement("print_link", "clicked on print link");

		// wait till visible print button
		QaRobot.explicitwaitvisible(160, By.xpath("//button[@class='btn_smallred ng-binding']"));

		// switch to current window for close

		// get window handle

		String beforewindowpopup = TestBase.driver.getWindowHandle();

		// click on print

		QaRobot.ClickOnElement("print_button", "clicked on print button");

		// now get all window handle after click print

		Set<String> afterwindowpopup = TestBase.driver.getWindowHandles();

		// remove all handle before pop up

		afterwindowpopup.remove(beforewindowpopup);

		System.out.print(afterwindowpopup);

		for (String printwindow : afterwindowpopup) {

			TestBase.driver.switchTo().window(printwindow);

			// System.out.println(driver.getTitle());

			try {

				// close the print window

				TestBase.driver.close();

			} catch (Throwable e) {

				System.out.println(e);
			}

		}

		// Now switch to current window

		TestBase.driver.switchTo().window(beforewindowpopup);

		// take a screen shot after print

		// String print = TakeScreenshot(driver, "PrintIteneary");

		// test.log(Status.INFO, "PrintIteneary : " +
		// test.addScreenCapture(print));

		QaRobot.ClickOnElement("close_print", "closed print screen");

		// wait till invisible print button
		QaRobot.explicitwaitinvisible(60, By.xpath("//button[@class='btn_smallred ng-binding']"));

		// take screenshot for fare_iteneary

		// String fareI = TakeScreenshot(driver, "fareIteneary");

		// test.log(Status.INFO, "fareIteneary : " +
		// test.addScreenCapture(fareI));

		QaRobot.ClickOnElement("fare_iteneary", "clicked on flight iteneary");

		QaRobot.explicitwaitinvisible(100, By.xpath("(//span[@class='ng-binding' and text()='Send Email'])[1]"));

	}

	// Fare Rule

	public static void Fare_Rule() throws Exception {

		QaRobot.ClickOnElement("fare_rule", "clicked on flight rule");

		// wait till visible booking class
		QaRobot.explicitwaitvisible(60, By.xpath("(//th[text()='Booking Class'])[1]"));

		// take screenshot for fare_rule

		// String fareR = TakeScreenshot(driver, "fareRule");

		// test.log(Status.INFO, "fareRule : " + test.addScreenCapture(fareR));

		QaRobot.ClickOnElement("fare_rule", "clicked on flight rule");

		// wait till economy class invisible

		QaRobot.explicitwaitinvisible(100, By.xpath("(//th[text()='Booking Class'])[1]"));

	}

	// fare Breakup

	public static void fare_breakups(String resultvalue) throws Exception

	{

		QaRobot.ClickOnElement("fare_breakup", "Clicked on FareBreakup");

		QaRobot.explicitwaitvisible(30, By.xpath("(//div[@class='fare_tb']//span[@class='ng-binding'])[1]"));

		// get total value of fare breakup
		String Fare_B_value = QaRobot.getWebElement("total_price").getText();

		System.out.println("Fare breakup value is " + Fare_B_value);

		// String ExcludeRP[] = resultvalue.split(" ");

		// System.out.println(ExcludeRP[0]);

		// System.out.println(ExcludeRP[1]);

		// String value = ExcludeRP[1];

		CompareFareValue(resultvalue, Fare_B_value, "fare breakup " + Fare_B_value);

		// take screenshot for fare_breakup
		// String fareb = TakeScreenshot(driver, "fare_breakup1");

		// test.log(Status.INFO, "fare_breakup : " +
		// test.addScreenCapture(fareb));

		QaRobot.ClickOnElement("fare_breakup", "Clicked on FareBreakup");

		QaRobot.explicitwaitinvisible(30, By.xpath("(//div[@class='fare_tb']//span[@class='ng-binding'])[1]"));

	}

	// Penalties info

	public static void penal_info() throws Exception {

		QaRobot.ClickOnElement("penalties_info", "clicked on penalties info");

		// take screenshot for penal_info
		// String penalI = TakeScreenshot(driver, "penal_info");

		// test.log(Status.INFO, "penal_info : " +
		// test.addScreenCapture(penalI));

		QaRobot.ClickOnElement("penalties_info", "clicked on penalties info");

	}

	// handle Prefered airline
	public static void PreferedAirline(String preairline, String airlines, String searchairline) throws Exception {
		// click prefered airline
		QaRobot.ClickOnElement(preairline, "Clicked on Prefered Airline");
		String[] airlinearr = airlines.split(",");
		for (int i = 0; i < airlinearr.length; i++) {
			String currentairline = airlinearr[i].toLowerCase();
			// send the airlinename in search box

			QaRobot.PassValue(searchairline, currentairline, "Entered " + currentairline + " Prefered Airline");

			// click selected airline
			String check = "//ul[@class='ui-multiselect-checkboxes ui-helper-reset']/li/label/span";
			List<WebElement> elements = driver.findElements(By.xpath(check));
			for (WebElement webelement : elements) {
				if (webelement.getText().toLowerCase().equals(currentairline)) {
					webelement.click();
					break;
				}
			}
			QaRobot.getWebElement(searchairline).clear();

		}
	}

	public static void Billing(String btitle, String bfname, String blname, String baddress, String bcity,
			String bcityauto, String bstate, String bzipcode, String bcountry) throws Exception {

		// Select billing title
		QaRobot.selectDropdownValuebyLocator("billing_title", btitle, "Entered " + btitle + " as billing title");

		// Billing fName
		QaRobot.PassValue("billing_fname", bfname, "Entered " + bfname + " as billing Firstname");

		// Billing lName
		QaRobot.PassValue("billing_lname", blname, "Entered " + blname + " as billing LastName");

		// Billing Address
		QaRobot.PassValue("billing_address1", baddress, "Entered " + baddress + " as billing address");

		// Select billing country
		QaRobot.selectTextFromDropdown("billing_country", bcountry, "Selected " + bcountry + " as billing Country");

		// billing city
		listofautosuggestion(By.xpath("//div[@id='divHTCity']/p"), bcity, bcityauto,
				By.xpath("//input[@id='ctl00_contentMain_payeeCity']"));

		// Select billing state
		QaRobot.selectTextFromDropdown("billing_state", bstate, "Entered " + bstate + " as billing state");

		// Billing zipcode
		QaRobot.PassValue("billing_zipcode", bzipcode, "Entered " + bzipcode + " as billing zipcode");

	}

	public static void card(String cardmode, String type, String cardno, String cardname, String cardmonth,
			String cardyear, String cardcvv) throws Exception {
		// condition for credit and online

		if (cardmode.equalsIgnoreCase("Credit Card") || cardmode.equalsIgnoreCase("استخدام بطاقة الائتمان")) {

			QaRobot.ClickOnElement("credit_card", "Clicked on credit card");
			if (type.equalsIgnoreCase("Master Card")) {

				QaRobot.selectTextFromDropdown("credit", type, "selected " + type + " as card type master card");
				QaRobot.PassValue("card_number", cardno, "Entered " + cardno + " as Card Number");
				QaRobot.PassValue("card_name", cardname, "Entered " + cardname + " as Card Holder Name");
				QaRobot.selectValueFromDropdown("card_month", cardmonth, "selected " + cardmonth + " as card Month");
				QaRobot.selectValueFromDropdown("card_year", cardyear, "selected " + cardyear + " as card Year");
				QaRobot.PassValue("card_cvv", cardcvv, "Entered " + cardcvv + " as card CVV Number");

			} else if (type.equalsIgnoreCase("visa")) {

				QaRobot.selectTextFromDropdown("credit", type, "selected " + type + " as card type master card");
				QaRobot.PassValue("card_number", cardno, "Entered " + cardno + " as Card Number");
				QaRobot.PassValue("card_name", cardname, "Entered " + cardname + " as Card Holder Name");
				QaRobot.selectValueFromDropdown("card_month", cardmonth, "selected " + cardmonth + " as card Month");
				QaRobot.selectValueFromDropdown("card_year", cardyear, "selected " + cardyear + " as card Year");
				QaRobot.PassValue("card_cvv", cardcvv, "Entered " + cardcvv + " as card CVV Number");

			}
		} else if (cardmode.equalsIgnoreCase("Debit Card") || cardmode.equalsIgnoreCase("ااستخدام بطاقة الخصم")) {

			QaRobot.ClickOnElement("debit_card", "Clicked on debit card");
			if (type.equalsIgnoreCase("Master Card")) {

				QaRobot.selectTextFromDropdown("debit", type, "selected " + type + " as card type master card");
				QaRobot.PassValue("card_number", cardno, "Entered " + cardno + " as Card Number");
				QaRobot.PassValue("card_name", cardname, "Entered " + cardname + " as Card Holder Name");
				QaRobot.selectValueFromDropdown("card_month", cardmonth, "selected " + cardmonth + " as card Month");
				QaRobot.selectValueFromDropdown("card_year", cardyear, "selected " + cardyear + " as card Year");
				QaRobot.PassValue("card_cvv", cardcvv, "Entered " + cardcvv + " as card CVV Number");

			} else if (type.equalsIgnoreCase("visa")) {

				QaRobot.selectTextFromDropdown("debit", type, "selected " + type + " as card type master card");
				QaRobot.PassValue("card_number", cardno, "Entered " + cardno + " as Card Number");
				QaRobot.PassValue("card_name", cardname, "Entered " + cardname + " as Card Holder Name");
				QaRobot.selectValueFromDropdown("card_month", cardmonth, "selected " + cardmonth + " as card Month");
				QaRobot.selectValueFromDropdown("card_year", cardyear, "selected " + cardyear + " as card Year");
				QaRobot.PassValue("card_cvv", cardcvv, "Entered " + cardcvv + " as card CVV Number");

			}

		}
	}

	public static void cardArabic(String cardmode, String type, String cardno, String cardname, String cardmonth,
			String cardyear, String cardcvv) throws Exception {
		// condition for credit and online

		if (cardmode.equalsIgnoreCase("استخدام بطاقة الائتمان")) {

			// ClickOnElement("credit_card", "Clicked on credit card");
			driver.findElement(By.xpath("//span[contains(text(),'استخدام بطاقة الائتمان')]")).click();
			if (type.equalsIgnoreCase("Master Card")) {

				QaRobot.selectTextFromDropdown("credit", type, "selected " + type + " as card type master card");
				QaRobot.PassValue("card_number", cardno, "Entered " + cardno + " as Card Number");
				QaRobot.PassValue("card_name", cardname, "Entered " + cardname + " as Card Holder Name");
				QaRobot.selectTextFromDropdown("card_month", cardmonth, "selected " + cardmonth + " as card Month");
				QaRobot.selectValueFromDropdown("card_year", cardyear, "selected " + cardyear + " as card Year");
				QaRobot.PassValue("card_cvv", cardcvv, "Entered " + cardcvv + " as card CVV Number");

			} else if (type.equalsIgnoreCase("visa")) {

				QaRobot.selectTextFromDropdown("credit", type, "selected " + type + " as card type master card");
				QaRobot.PassValue("card_number", cardno, "Entered " + cardno + " as Card Number");
				QaRobot.PassValue("card_name", cardname, "Entered " + cardname + " as Card Holder Name");
				QaRobot.selectTextFromDropdown("card_month", cardmonth, "selected " + cardmonth + " as card Month");
				QaRobot.selectValueFromDropdown("card_year", cardyear, "selected " + cardyear + " as card Year");
				QaRobot.PassValue("card_cvv", cardcvv, "Entered " + cardcvv + " as card CVV Number");

			}
		} else if (cardmode.equalsIgnoreCase("استخدام بطاقة الخصم")) {

			// ClickOnElement("debit_card", "Clicked on debit card");
			driver.findElement(By.xpath("//span[contains(text(),'استخدام بطاقة الخصم')]")).click();
			if (type.equalsIgnoreCase("Master Card")) {

				QaRobot.selectTextFromDropdown("debit", type, "selected " + type + " as card type master card");
				QaRobot.PassValue("card_number", cardno, "Entered " + cardno + " as Card Number");
				QaRobot.PassValue("card_name", cardname, "Entered " + cardname + " as Card Holder Name");
				QaRobot.selectTextFromDropdown("card_month", cardmonth, "selected " + cardmonth + " as card Month");
				QaRobot.selectValueFromDropdown("card_year", cardyear, "selected " + cardyear + " as card Year");
				QaRobot.PassValue("card_cvv", cardcvv, "Entered " + cardcvv + " as card CVV Number");

			} else if (type.equalsIgnoreCase("visa")) {

				QaRobot.selectTextFromDropdown("debit", type, "selected " + type + " as card type master card");
				QaRobot.PassValue("card_number", cardno, "Entered " + cardno + " as Card Number");
				QaRobot.PassValue("card_name", cardname, "Entered " + cardname + " as Card Holder Name");
				QaRobot.selectTextFromDropdown("card_month", cardmonth, "selected " + cardmonth + " as card Month");
				QaRobot.selectValueFromDropdown("card_year", cardyear, "selected " + cardyear + " as card Year");
				QaRobot.PassValue("card_cvv", cardcvv, "Entered " + cardcvv + " as card CVV Number");

			}

		}
	}

	public static void CompareFareValue(String ActualValue, String ExpectedValue, String Msg) throws Exception {

		softassert.assertEquals(ActualValue, ExpectedValue, Msg);
		if (ActualValue.equalsIgnoreCase(ExpectedValue)) {
			test.log(Status.PASS, "Verification Passed for value of " + Msg);
		}

		else {
			test.log(Status.FAIL, "Verification Failed for value of " + Msg);
			throw new Exception("Verification Failed for value of " + Msg);
		}
	}

	public static void adultCheckout(String Triptype, String adult, String title, String adultfname, String adultlname,
			String adultdate, String adultmonth, String adultyear, String adultidno, String adultisd, String adultphone,
			String adultpassprot, String adultpassportcomp, String adultedate, String adultemonth, String adulteyear,
			String adultnationality) throws Exception {

		int a = Integer.parseInt(adult);
		for (int i = 1; i <= a; i++) {

			// fill Title
			String adultTitleElement = "(//select[@id='ctl00_contentMain_ddlTitle'])";
			String[] adulttitle = title.split(",");
			QaRobot.selectDropdownValue(adultTitleElement, adulttitle[0],
					"Selected " + adulttitle[0] + " as title of Adult");

			// FIll Day

			String adultdayElement = "(//select[@id='ctl00_contentMain_txt_birthDateAdt_ddlDay'])";
			String[] adultday = adultdate.split(",");
			QaRobot.selectTextByLocator(adultdayElement, adultday[0],
					"Selected " + adultday[0] + " birth day of Adult");

			// Fill Month
			String adultmonthElement = "(//select[@id='ctl00_contentMain_txt_birthDateAdt_ddlMonth'])";
			String[] adultmm = adultmonth.split(",");
			QaRobot.selectDropdownValue(adultmonthElement, adultmm[0],
					"Selected " + adultmm[0] + " birth month of Adult");

			// Fill Year

			String adultyearElement = "(//select[@id='ctl00_contentMain_txt_birthDateAdt_ddlYear'])";
			String[] adulty = adultyear.split(",");
			QaRobot.selectTextByLocator(adultyearElement, adulty[0],
					"Selected " + adulty[0] + " as birth Year of Adult");

			// // fill identity number
			// List<WebElement> id_number_Adult = driver
			// .findElements(By.xpath("//input[@id='txt_IdentityNoAdt" + i +
			// "']"));
			//
			// if (id_number_Adult.size() > 0) {
			// String[] idno = adultidno.split(",");
			// // PassValueByLocator(id_number_Adult,idno[i-1],"Selected
			// // Identity no For Adult"+i+"");
			// driver.findElement(By.xpath("//input[@id='txt_IdentityNoAdt" + i
			// + "']")).sendKeys(idno[i - 1]);
			// } else {
			// System.out.print("No identity number for adult");
			// }

			// Fill First name
			String adultNameElement = "//input[@id='txt_firstNameAdt" + i + "']";
			String[] adultfirstname = adultfname.split(",");
			QaRobot.PassValueByLocator(adultNameElement, adultfirstname[i - 1],
					"Entered " + adultfirstname[i - 1] + " as Firstname of Adult");

			// Fill Last name

			String adultLNameElement = "//input[@id='txt_lastnameAdt" + i + "']";
			String[] adultlastname = adultlname.split(",");
			QaRobot.PassValueByLocator(adultLNameElement, adultlastname[i - 1],
					"Entered " + adultlastname[i - 1] + " as LastName of Adult");

			if (Triptype.equalsIgnoreCase("International")) {

				// Fill Passport
				String adultpassportElement = "//input[@id='txt_passportAdt" + i + "']";
				String[] adultpass = adultpassprot.split(",");
				QaRobot.PassValueByLocator(adultpassportElement, adultpass[i - 1],
						"Entered " + adultpass[i - 1] + " as passport number of Adult");

				// fill Passport issuing country
				String adultpasscountryElement = "(//select[@id='ctl00_contentMain_ddl_passCountryAdt'])";
				String[] adultpc = adultpassportcomp.split(",");
				QaRobot.selectTextByLocator(adultpasscountryElement, adultpc[0],
						"Selected " + adultpc[0] + "  as passport country of Adult");

				// FIll Expiry Day

				String adultedayElement = "(//select[@id='ctl00_contentMain_txt_ex_dateAdt_ddlDay'])";
				String[] adulteday = adultedate.split(",");
				QaRobot.selectTextByLocator(adultedayElement, adulteday[0],
						"Selected " + adulteday[0] + " as passport expiry day of Adult");

				// Fill Expiry Month
				String adultemonthElement = "(//select[@id='ctl00_contentMain_txt_ex_dateAdt_ddlMonth'])";
				String[] adultemm = adultemonth.split(",");
				QaRobot.selectDropdownValue(adultemonthElement, adultemm[0],
						"Selected " + adultemm[0] + "  as passport expiry month of Adult");

				// Fill Expiry Year

				String adulteyearElement = "(//select[@id='ctl00_contentMain_txt_ex_dateAdt_ddlYear'])";
				String[] adultey = adulteyear.split(",");
				QaRobot.selectTextByLocator(adulteyearElement, adultey[0],
						"Selected " + adultey[0] + " as passport expiry year of Adult");

				// fill nationality

				String adultnationalityElement = "(//select[@id='ctl00_contentMain_ddl_nationalityAdt'])";
				String[] adultnat = adultnationality.split(",");
				QaRobot.selectTextByLocator(adultnationalityElement, adultnat[0],
						"Selected " + adultnat[0] + "  as nationality of Adult");

			}

		}

		for (int i = 1; i < a; i++) {

			// fill Title
			String adultTitleElement1 = "(//select[@id='ctl00_contentMain_ddlTitle_" + i + "'])";
			String[] adulttitle1 = title.split(",");
			QaRobot.selectDropdownValue(adultTitleElement1, adulttitle1[i],
					"Selected " + adulttitle1[i] + " as title of Adult");

			// FIll Day

			String adultdayElement1 = "(//select[@id='ctl00_contentMain_txt_birthDateAdt_ddlDay_" + i + "'])";
			String[] adultday1 = adultdate.split(",");
			QaRobot.selectTextByLocator(adultdayElement1, adultday1[i],
					"Selected " + adultday1[i] + " as birth day of Adult");

			// Fill Month
			String adultmonthElement1 = "(//select[@id='ctl00_contentMain_txt_birthDateAdt_ddlMonth_" + i + "'])";
			String[] adultmm1 = adultmonth.split(",");
			QaRobot.selectDropdownValue(adultmonthElement1, adultmm1[i],
					"Selected " + adultmm1[i] + " as birth month of Adult");

			// Fill Year

			String adultyearElement1 = "(//select[@id='ctl00_contentMain_txt_birthDateAdt_ddlYear_" + i + "'])";
			String[] adulty1 = adultyear.split(",");
			QaRobot.selectTextByLocator(adultyearElement1, adulty1[i],
					"Selected " + adulty1[i] + " as birth year of Adult");

			if (Triptype.equalsIgnoreCase("International")) {

				// fill passport country
				String adultpasscountryElement1 = "(//select[@id='ctl00_contentMain_ddl_passCountryAdt_" + i + "'])";
				String[] adultpc1 = adultpassportcomp.split(",");
				QaRobot.selectTextByLocator(adultpasscountryElement1, adultpc1[i],
						"Selected " + adultpc1[i] + "  as passport country of Adult");

				// FIll Expiry Day

				String adultedayElement1 = "(//select[@id='ctl00_contentMain_txt_ex_dateAdt_ddlDay_" + i + "'])";
				String[] adulteday1 = adultedate.split(",");
				QaRobot.selectTextByLocator(adultedayElement1, adulteday1[i],
						"Selected " + adulteday1[i] + " as passport expiry day of Adult");

				// Fill Expiry Month
				String adultemonthElement1 = "(//select[@id='ctl00_contentMain_txt_ex_dateAdt_ddlMonth_" + i + "'])";
				String[] adultemm1 = adultemonth.split(",");
				QaRobot.selectDropdownValue(adultemonthElement1, adultemm1[i],
						"Selected " + adultemm1[i] + " as passport expiry month of Adult");

				// Fill Expiry Year

				String adulteyearElement1 = "(//select[@id='ctl00_contentMain_txt_ex_dateAdt_ddlYear_" + i + "'])";
				String[] adultey1 = adulteyear.split(",");
				QaRobot.selectTextByLocator(adulteyearElement1, adultey1[i],
						"Selected " + adultey1[i] + " as passport expiry year of Adult");

				// fill nationality

				String adultnationalityElement1 = "(//select[@id='ctl00_contentMain_ddl_nationalityAdt_" + i + "'])";
				String[] adultnat1 = adultnationality.split(",");
				QaRobot.selectTextByLocator(adultnationalityElement1, adultnat1[i],
						"Selected " + adultnat1[i] + " as nationality of Adult");

			}

		}

		// adult isd
		QaRobot.PassValue("adt_isd", adultisd, "Entered " + adultisd + " as ISD Number");

		// adult phone
		QaRobot.PassValue("adt_ph", adultphone, "Entered " + adultphone + " as Phone Number");

	}

	public static void TransferadultCheckout(String companycode, String adult, String title, String adultfname,
			String adultlname, String adultdate, String adultmonth, String adultyear, String adultisd,
			String adultphone, String adultnationality, String adultCountryOfResidence, String adultAddressLine,
			String adultmeal) throws Exception {

		int a = Integer.parseInt(adult);
		for (int i = 1; i <= a; i++) {

			// fill Title
			String adultTitleElement = "(//select[@id='ctl00_contentMain_ddlTitle'])";
			String[] adulttitle = title.split(",");
			QaRobot.selectDropdownValue(adultTitleElement, adulttitle[0], "Selected Title For Adult");

			// FIll Day

			String adultdayElement = "(//select[@id='ctl00_contentMain_txt_birthDateAdt_ddlDay'])";
			String[] adultday = adultdate.split(",");
			QaRobot.selectTextByLocator(adultdayElement, adultday[0], "Selected Day For Adult");

			// Fill Month
			String adultmonthElement = "(//select[@id='ctl00_contentMain_txt_birthDateAdt_ddlMonth'])";
			String[] adultmm = adultmonth.split(",");
			QaRobot.selectDropdownValue(adultmonthElement, adultmm[0], "Selected Month For Adult");

			// Fill Year

			String adultyearElement = "(//select[@id='ctl00_contentMain_txt_birthDateAdt_ddlYear'])";
			String[] adulty = adultyear.split(",");
			QaRobot.selectTextByLocator(adultyearElement, adulty[0], "Selected Year For Adult");

			// Fill First name
			String adultNameElement = "//input[@id='txt_firstNameAdt" + i + "']";
			String[] adultfirstname = adultfname.split(",");
			QaRobot.PassValueByLocator(adultNameElement, adultfirstname[i - 1], "Entered Name For Adult");

			// Fill Last name

			String adultLNameElement = "//input[@id='txt_lastnameAdt" + i + "']";
			String[] adultlastname = adultlname.split(",");
			QaRobot.PassValueByLocator(adultLNameElement, adultlastname[i - 1], "Entered Last Name For Adult");

			// Meal for majestic holidays

			if (companycode.equalsIgnoreCase("mh") || companycode.equalsIgnoreCase("zt")) {
				// select adult meal
				String adultmealElement = "(//select[@id='ctl00_contentMain_ddlSightMealOption'])";
				String[] adultmeal1 = adultmeal.split(",");
				QaRobot.selectTextByLocator(adultmealElement, adultmeal1[0], "Selected Meal For Adult");

			}

			// // fill nationality
			//
			// String adultnationalityElement =
			// "(//select[@id='ctl00_contentMain_ddl_nationalityAdt'])";
			// String[] adultnat = adultnationality.split(",");
			// selectTextByLocator(adultnationalityElement, adultnat[0],
			// "Selected Nationality For Adult");
			//
			// // fill Country of Residence
			//
			// String adultCountryResidence =
			// "(//select[@id='ctl00_contentMain_ddl_CountryofResidenceAdt'])";
			// String[] adultcount = adultCountryOfResidence.split(",");
			// selectTextByLocator(adultCountryResidence, adultcount[0],
			// "Selected Country of Residence For Adult");
			//
			// // fill Address Line1
			//
			// String adultAddress =
			// "(//input[@id='ctl00_contentMain_txtAddressAdt'])";
			// String[] adultAdd = adultAddressLine.split(",");
			// PassValueByLocator(adultAddress, adultAdd[0], "Entered Address
			// Line1 For Adult");

		}

		for (int i = 1; i < a; i++) {

			// fill Title
			String adultTitleElement1 = "(//select[@id='ctl00_contentMain_ddlTitle_" + i + "'])";
			String[] adulttitle1 = title.split(",");
			QaRobot.selectDropdownValue(adultTitleElement1, adulttitle1[i], "Selected Title For Adult");

			// FIll Day

			String adultdayElement1 = "(//select[@id='ctl00_contentMain_txt_birthDateAdt_ddlDay_" + i + "'])";
			String[] adultday1 = adultdate.split(",");
			QaRobot.selectTextByLocator(adultdayElement1, adultday1[i], "Selected Day For Adult");

			// Fill Month
			String adultmonthElement1 = "(//select[@id='ctl00_contentMain_txt_birthDateAdt_ddlMonth_" + i + "'])";
			String[] adultmm1 = adultmonth.split(",");
			QaRobot.selectDropdownValue(adultmonthElement1, adultmm1[i], "Selected Month For Adult");

			// Fill Year

			String adultyearElement1 = "(//select[@id='ctl00_contentMain_txt_birthDateAdt_ddlYear_" + i + "'])";
			String[] adulty1 = adultyear.split(",");
			QaRobot.selectTextByLocator(adultyearElement1, adulty1[i], "Selected Year For Adult");

			if (companycode.equalsIgnoreCase("mh")) {
				// select adult meal
				String adultmealElement1 = "(//select[@id='ctl00_contentMain_ddlSightMealOption_" + i + "'])";
				String[] adultmeal11 = adultmeal.split(",");
				QaRobot.selectTextByLocator(adultmealElement1, adultmeal11[i], "Selected Meal For Adult");

			}

			// // fill nationality
			//
			// String adultnationalityElement1 =
			// "(//select[@id='ctl00_contentMain_ddl_nationalityAdt_" + i +
			// "'])";
			// String[] adultnat1 = adultnationality.split(",");
			// selectTextByLocator(adultnationalityElement1, adultnat1[i],
			// "Selected Nationality For Adult" + i + "");

			// // fill Country of Residence
			//
			// String adultCountryResidence =
			// "(//select[@id='ctl00_contentMain_ddl_CountryofResidenceAdt_" + i
			// + "'])";
			// String[] adultcount = adultCountryOfResidence.split(",");
			// selectTextByLocator(adultCountryResidence, adultcount[i],
			// "Selected Country of Residence For Adult" + i + "");
			//
			// // fill Address Line1
			//
			// String adultAddress =
			// "(//input[@id='ctl00_contentMain_txtAddressAdt_" + i + "'])";
			// String[] adultAdd = adultAddressLine.split(",");
			// PassValueByLocator(adultAddress, adultAdd[i], "Entered Address
			// Line1 For Adult" + i + "");

		}

		// adult isd
		QaRobot.PassValue("adt_isd", adultisd, "Entered ISD Number");

		// adult phone
		QaRobot.PassValue("adt_ph", adultphone, "Entered Phone Number");

	}

	public static void childCheckout(String Triptype, String child, String ctitle, String childfname, String childlname,
			String childdate, String childmonth, String childyear, String childidno, String childpassprot,
			String childpassportcomp, String childedate, String childemonth, String childeyear, String childnationality)
			throws Exception {

		int a = Integer.parseInt(child);
		for (int i = 1; i <= a; i++) {
			// Fill First name
			String childNameElement = "//input[@id='txt_firstNameChd" + i + "']";
			String[] childfirstname = childfname.split(",");
			QaRobot.PassValueByLocator(childNameElement, childfirstname[i - 1],
					"Entered " + childfirstname[i - 1] + " as Firstname of child");

			// Fill Last name
			String childLNameElement = "//input[@id='txt_lastnameChd" + i + "']";
			String[] childlastname = childlname.split(",");
			QaRobot.PassValueByLocator(childLNameElement, childlastname[i - 1],
					"Entered " + childlastname[i - 1] + " as LastName of child");

			// fill Title
			String childTitleElement = "(//select[@id='ctl00_contentMain_ddl_titleChd'])";
			String[] childtitle = ctitle.split(",");
			QaRobot.selectDropdownValue(childTitleElement, childtitle[0],
					"Selected " + childtitle[0] + " title of child");

			// FIll Day
			String childdayElement = "(//select[@id='ctl00_contentMain_txt_birthDateChd_ddlDay'])";
			String[] childday = childdate.split(",");
			QaRobot.selectTextByLocator(childdayElement, childday[0], "Selected " + childday[0] + "birth day of child");

			// Fill Month
			String childmonthElement = "(//select[@id='ctl00_contentMain_txt_birthDateChd_ddlMonth'])";
			String[] childmm = childmonth.split(",");
			QaRobot.selectDropdownValue(childmonthElement, childmm[0],
					"Selected " + childmm[0] + " birth month of child");

			// Fill Year

			String childyearElement = "(//select[@id='ctl00_contentMain_txt_birthDateChd_ddlYear'])";
			String[] childy = childyear.split(",");
			QaRobot.selectTextByLocator(childyearElement, childy[0], "Selected " + childy[0] + "  year of child");

			// // fill identity number
			//
			// List<WebElement> id_number_child = driver
			// .findElements(By.xpath("//input[@id='txt_IdentityNoChd" + i +
			// "']"));
			//
			// if (id_number_child.size() > 0) {
			// String[] idnoc = childidno.split(",");
			// driver.findElement(By.xpath("//input[@id='txt_IdentityNoChd" + i
			// + "']")).sendKeys(idnoc[i - 1]);
			// } else {
			// System.out.print("No identity number for child");
			// }

			if (Triptype.equalsIgnoreCase("International")) {

				// Fill Passport
				String childpassportElement = "//input[@id='txt_passportChd" + i + "']";
				String[] childpass = childpassprot.split(",");
				QaRobot.PassValueByLocator(childpassportElement, childpass[i - 1],
						"Entered " + childpass[i - 1] + " as passport number of Child");

				// fill passport country

				String childpasscountryElement = "(//select[@id='ctl00_contentMain_ddl_passCountryChd'])";
				String[] childpc = childpassportcomp.split(",");
				QaRobot.selectTextByLocator(childpasscountryElement, childpc[0],
						"Selected " + childpc[0] + " as passport country of child");

				// FIll Expiry Day

				String childedayElement = "(//select[@id='ctl00_contentMain_txt_ex_dateChd_ddlDay'])";
				String[] childeday = childedate.split(",");
				QaRobot.selectTextByLocator(childedayElement, childeday[0],
						"Selected " + childeday[0] + " as passport expiry day of child");

				// Fill Expiry Month
				String childemonthElement = "(//select[@id='ctl00_contentMain_txt_ex_dateChd_ddlMonth'])";
				String[] childemm = childemonth.split(",");
				QaRobot.selectDropdownValue(childemonthElement, childemm[0],
						"Selected " + childemm[0] + " as passport expiry month of child");

				// Fill Expiry Year

				String childeyearElement = "(//select[@id='ctl00_contentMain_txt_ex_dateChd_ddlYear'])";
				String[] childey = childeyear.split(",");
				QaRobot.selectTextByLocator(childeyearElement, childey[0],
						"Selected " + childey[0] + " as passport expiry year of child");

				// fill nationality

				String childnationalityElement = "(//select[@id='ctl00_contentMain_ddl_nationalityChd'])";
				String[] childnat = childnationality.split(",");
				QaRobot.selectTextByLocator(childnationalityElement, childnat[0],
						"Selected " + childnat[0] + " as nationality of child");
			}

		}
		for (int i = 1; i < a; i++) {

			// fill Title
			String childTitleElement1 = "(//select[@id='ctl00_contentMain_ddl_titleChd_" + i + "'])";
			String[] childtitle1 = ctitle.split(",");
			QaRobot.selectDropdownValue(childTitleElement1, childtitle1[i],
					"Selected " + childtitle1[i] + " as title of Child");

			// FIll Day
			String childdayElement1 = "(//select[@id='ctl00_contentMain_txt_birthDateChd_ddlDay_" + i + "'])";
			String[] childday1 = childdate.split(",");
			QaRobot.selectTextByLocator(childdayElement1, childday1[i],
					"Selected " + childday1[i] + " as day of child");

			// Fill Month
			String childmonthElement1 = "(//select[@id='ctl00_contentMain_txt_birthDateChd_ddlMonth_" + i + "'])";
			String[] childmm1 = childmonth.split(",");
			QaRobot.selectDropdownValue(childmonthElement1, childmm1[i],
					"Selected " + childmm1[i] + " as month of child");

			// Fill Year
			String childyearElement1 = "(//select[@id='ctl00_contentMain_txt_birthDateChd_ddlYear_" + i + "'])";
			String[] childy1 = childyear.split(",");
			QaRobot.selectTextByLocator(childyearElement1, childy1[i], "Selected " + childy1[i] + " as year of child");

			if (Triptype.equalsIgnoreCase("International")) {

				// fill passport country
				String childpasscountryElement1 = "(//select[@id='ctl00_contentMain_ddl_passCountryChd_" + i + "'])";
				String[] childpc1 = childpassportcomp.split(",");
				QaRobot.selectTextByLocator(childpasscountryElement1, childpc1[i],
						"Selected " + childpc1[i] + " as passport country of child");

				// FIll Expiry Day
				String childedayElement1 = "(//select[@id='ctl00_contentMain_txt_ex_dateChd_ddlDay_" + i + "'])";
				String[] childeday1 = childedate.split(",");
				QaRobot.selectTextByLocator(childedayElement1, childeday1[i],
						"Selected " + childeday1[i] + "  as passport expiry day of child");

				// Fill Expiry Month
				String childemonthElement1 = "(//select[@id='ctl00_contentMain_txt_ex_dateChd_ddlMonth_" + i + "'])";
				String[] childemm1 = childemonth.split(",");
				QaRobot.selectDropdownValue(childemonthElement1, childemm1[i - 1],
						"Selected " + childemm1[i - 1] + " as passport expiry month of child");

				// Fill Expiry Year
				String childeyearElement1 = "(//select[@id='ctl00_contentMain_txt_ex_dateChd_ddlYear_" + i + "'])";
				String[] childey1 = childeyear.split(",");
				QaRobot.selectTextByLocator(childeyearElement1, childey1[i],
						"Selected " + childey1[i] + "  as passport expiry year of child");

				// fill nationality
				String childnationalityElement1 = "(//select[@id='ctl00_contentMain_ddl_nationalityChd_" + i + "'])";
				String[] childnat1 = childnationality.split(",");
				QaRobot.selectTextByLocator(childnationalityElement1, childnat1[i],
						"Selected " + childnat1[i] + " as nationality of child");
			}

		}
	}

	public static void TransferchildCheckout(String companycode, String child, String ctitle, String childfname,
			String childlname, String childdate, String childmonth, String childyear, String childnationality,
			String childCountryOfResidence, String childAddressLine, String childmeal) throws Exception {

		int a = Integer.parseInt(child);
		for (int i = 1; i <= a; i++) {
			// Fill First name
			String childNameElement = "//input[@id='txt_firstNameChd" + i + "']";
			String[] childfirstname = childfname.split(",");
			QaRobot.PassValueByLocator(childNameElement, childfirstname[i - 1], "Entered Name For child" + i + "");

			// Fill Last name
			String childLNameElement = "//input[@id='txt_lastnameChd" + i + "']";
			String[] childlastname = childlname.split(",");
			QaRobot.PassValueByLocator(childLNameElement, childlastname[i - 1], "Entered LastName For Child" + i + "");

			// fill Title
			String childTitleElement = "(//select[@id='ctl00_contentMain_ddl_titleChd'])";
			String[] childtitle = ctitle.split(",");
			QaRobot.selectDropdownValue(childTitleElement, childtitle[0], "Selected Title For Child");

			// FIll Day
			String childdayElement = "(//select[@id='ctl00_contentMain_txt_birthDateChd_ddlDay'])";
			String[] childday = childdate.split(",");
			QaRobot.selectTextByLocator(childdayElement, childday[0], "Selected Day For Child");

			// Fill Month
			String childmonthElement = "(//select[@id='ctl00_contentMain_txt_birthDateChd_ddlMonth'])";
			String[] childmm = childmonth.split(",");
			QaRobot.selectDropdownValue(childmonthElement, childmm[0], "Selected Month For Child");

			// Fill Year

			String childyearElement = "(//select[@id='ctl00_contentMain_txt_birthDateChd_ddlYear'])";
			String[] childy = childyear.split(",");
			QaRobot.selectTextByLocator(childyearElement, childy[0], "Selected Year For Child");

			// Meal for majestic holidays

			if (companycode.equalsIgnoreCase("mh")) {

				// select adult meal
				String childmealElement = "(//select[@id='ctl00_contentMain_ddlSightMealOptionChd'])";
				String[] childmeal1 = childmeal.split(",");
				QaRobot.selectTextByLocator(childmealElement, childmeal1[0], "Selected Meal For Child");

			}

			// // fill nationality
			//
			// String childnationalityElement =
			// "(//select[@id='ctl00_contentMain_ddl_nationalityChd'])";
			// String[] childnat = childnationality.split(",");
			// selectTextByLocator(childnationalityElement, childnat[0],
			// "Selected Nationality For Child");

			// // fill Country of Residence
			//
			// String childCountryResidence =
			// "(//select[@id='ctl00_contentMain_ddl_CountryofResidenceChd'])";
			// String[] childcount = childCountryOfResidence.split(",");
			// selectTextByLocator(childCountryResidence, childcount[0],
			// "Selected Country of Residence For Child");
			//
			// // fill Address Line1
			//
			// String childAddress =
			// "(//input[@id='ctl00_contentMain_txtAddressChd'])";
			// String[] childAdd = childAddressLine.split(",");
			// PassValueByLocator(childAddress, childAdd[0], "Entered Address
			// Line1 For Child");

		}
		for (int i = 1; i < a; i++) {

			// fill Title
			String childTitleElement1 = "(//select[@id='ctl00_contentMain_ddl_titleChd_" + i + "'])";
			String[] childtitle1 = ctitle.split(",");
			QaRobot.selectDropdownValue(childTitleElement1, childtitle1[i], "Selected Title For Child" + i + "");

			// FIll Day
			String childdayElement1 = "(//select[@id='ctl00_contentMain_txt_birthDateChd_ddlDay_" + i + "'])";
			String[] childday1 = childdate.split(",");
			QaRobot.selectTextByLocator(childdayElement1, childday1[i], "Selected Day For Child" + i + "");

			// Fill Month
			String childmonthElement1 = "(//select[@id='ctl00_contentMain_txt_birthDateChd_ddlMonth_" + i + "'])";
			String[] childmm1 = childmonth.split(",");
			QaRobot.selectDropdownValue(childmonthElement1, childmm1[i], "Selected Month For Child" + i + "");

			// Fill Year
			String childyearElement1 = "(//select[@id='ctl00_contentMain_txt_birthDateChd_ddlYear_" + i + "'])";
			String[] childy1 = childyear.split(",");
			QaRobot.selectTextByLocator(childyearElement1, childy1[i], "Selected Year For Child" + i + "");

			// Meal for majestic holidays

			if (companycode.equalsIgnoreCase("mh")) {

				// select adult meal
				String childmealElement1 = "(//select[@id='ctl00_contentMain_ddlSightMealOptionChd_" + i + "'])";
				String[] childmeal11 = childmeal.split(",");
				QaRobot.selectTextByLocator(childmealElement1, childmeal11[i], "Selected Meal For Child");

			}

			//
			// // fill nationality
			//
			// String childnationalityElement =
			// "(//select[@id='ctl00_contentMain_ddl_nationalityChd_" + i +
			// "'])";
			// String[] childnat = childnationality.split(",");
			// selectTextByLocator(childnationalityElement, childnat[i],
			// "Selected Nationality For Child");

			// // fill Country of Residence
			//
			// String childCountryResidence =
			// "(//select[@id='ctl00_contentMain_ddl_CountryofResidenceChd_" + i
			// + "'])";
			// String[] childcount = childCountryOfResidence.split(",");
			// selectTextByLocator(childCountryResidence, childcount[i],
			// "Selected Country of Residence For Child");
			//
			// // fill Address Line1
			//
			// String childAddress =
			// "(//input[@id='ctl00_contentMain_txtAddressChd_" + i + "'])";
			// String[] childAdd = childAddressLine.split(",");
			// PassValueByLocator(childAddress, childAdd[i], "Entered Address
			// Line1 For Child");

		}
	}

	public static void infantCheckout(String Triptype, String infant, String ititle, String infantfname,
			String infantlname, String infantdate, String infantmonth, String infantyear, String infantidno,
			String infantTravelling, String infantpassprot, String infantpassportcomp, String infantedate,
			String infantemonth, String infanteyear, String infantnationality) throws Exception {

		int a = Integer.parseInt(infant);
		for (int i = 1; i <= a; i++) {

			// Fill First name
			String infantNameElement = "//input[@id='txt_firstNameInf" + i + "']";
			String[] infantfirstname = infantfname.split(",");
			QaRobot.PassValueByLocator(infantNameElement, infantfirstname[i - 1],
					"Entered " + infantfirstname[i - 1] + " as firstName of infant");

			// Fill Last name
			String infantLNameElement = "//input[@id='txt_lastnameInf" + i + "']";
			String[] infantlastname = infantlname.split(",");
			QaRobot.PassValueByLocator(infantLNameElement, infantlastname[i - 1],
					"Entered " + infantlastname[i - 1] + " as lastName For infant");

			// fill Title
			String infantTitleElement = "(//select[@id='ctl00_contentMain_ddl_titleInf'])";
			String[] infantTitle = ititle.split(",");
			QaRobot.selectDropdownValue(infantTitleElement, infantTitle[0],
					"Selected " + infantTitle[0] + " as title of infant");

			// FIll Day
			String infantdayElement = "(//select[@id='ctl00_contentMain_txt_birthDateInf_ddlDay'])";
			String[] infantday = infantdate.split(",");
			QaRobot.selectTextByLocator(infantdayElement, infantday[0],
					"Selected " + infantday[0] + " as birth day of infant");

			// Fill Month
			String infantmonthElement = "(//select[@id='ctl00_contentMain_txt_birthDateInf_ddlMonth'])";
			String[] infantmm = infantmonth.split(",");
			QaRobot.selectDropdownValue(infantmonthElement, infantmm[0],
					"Selected " + infantmm[0] + " as birth month of infant");

			// Fill Year
			String infantyearElement = "(//select[@id='ctl00_contentMain_txt_birthDateInf_ddlYear'])";
			String[] infanty = infantyear.split(",");
			QaRobot.selectTextByLocator(infantyearElement, infanty[0],
					"Selected " + infanty[0] + " as birth year of infant");

			// // fill identity number
			// List<WebElement> id_number_infant = driver
			// .findElements(By.xpath("//input[@id='txt_IdentityNoInf" + i +
			// "']"));
			//
			// if (id_number_infant.size() > 0) {
			// String[] idnoi = infantidno.split(",");
			// driver.findElement(By.xpath("//input[@id='txt_IdentityNoInf" + i
			// + "']")).sendKeys(idnoi[i - 1]);
			// } else {
			// System.out.println("No identity number for Infant");
			// }

			// Fill travel with
			String infantTravelElement = "(//select[@id='ctl00_contentMain_ddl_travell_with'])";
			String[] infanttw = infantTravelling.split(",");
			QaRobot.selectTextByLocator(infantTravelElement, infanttw[0],
					"Selected " + infanttw[0] + " as Travelling with Infant");

			if (Triptype.equalsIgnoreCase("International")) {

				// Fill Passport
				String infantpassportElement = "//input[@id='txt_passportInf" + i + "']";
				String[] infantpass = infantpassprot.split(",");
				QaRobot.PassValueByLocator(infantpassportElement, infantpass[i - 1],
						"Entered " + infantpass[i - 1] + " as passport number of infant");

				// fill passport country
				String infantpasscountryElement = "(//select[@id='ctl00_contentMain_ddl_passCountryInf'])";
				String[] infantpc = infantpassportcomp.split(",");
				QaRobot.selectTextByLocator(infantpasscountryElement, infantpc[0],
						"Selected " + infantpc[0] + " as passport country of infant");

				// FIll Expiry Day
				String infantedayElement = "(//select[@id='ctl00_contentMain_txt_ex_dateInf_ddlDay'])";
				String[] infanteday = infantedate.split(",");
				QaRobot.selectTextByLocator(infantedayElement, infanteday[0],
						"Selected " + infanteday[0] + " as passport expiry day of infant");

				// Fill Expiry Month
				String infantemonthElement = "(//select[@id='ctl00_contentMain_txt_ex_dateInf_ddlMonth'])";
				String[] infantemm = infantemonth.split(",");
				QaRobot.selectDropdownValue(infantemonthElement, infantemm[0],
						"Selected " + infantemm[0] + " as passport expiry month of infant");

				// Fill Expiry Year
				String infanteyearElement = "(//select[@id='ctl00_contentMain_txt_ex_dateInf_ddlYear'])";
				String[] infantey = infanteyear.split(",");
				QaRobot.selectTextByLocator(infanteyearElement, infantey[0],
						"Selected " + infantey[0] + " as passport expiry year of infant");

				// fill nationality
				String infantnationalityElement = "(//select[@id='ctl00_contentMain_ddl_nationalityInf'])";
				String[] infantnat = infantnationality.split(",");
				QaRobot.selectTextByLocator(infantnationalityElement, infantnat[0],
						"Selected " + infantnat[0] + " as nationality of infant");

			}

		}
		for (int i = 1; i < a; i++) {

			// fill Title
			String infantTitleElement1 = "(//select[@id='ctl00_contentMain_ddl_titleInf_" + i + "'])";
			String[] infantTitle1 = ititle.split(",");
			QaRobot.selectDropdownValue(infantTitleElement1, infantTitle1[i],
					"Selected " + infantTitle1[i] + " as title of infant");

			// FIll Day
			String infantdayElement1 = "(//select[@id='ctl00_contentMain_txt_birthDateInf_ddlDay_" + i + "'])";
			String[] infantday1 = infantdate.split(",");
			QaRobot.selectTextByLocator(infantdayElement1, infantday1[i],
					"Selected " + infantday1[i] + " as birth day of infant");

			// Fill Month
			String infantmonthElement1 = "(//select[@id='ctl00_contentMain_txt_birthDateInf_ddlMonth_" + i + "'])";
			String[] infantmm1 = infantmonth.split(",");
			QaRobot.selectDropdownValue(infantmonthElement1, infantmm1[i],
					"Selected " + infantmm1[i] + " as birth month of infant");

			// Fill Year
			String infantyearElement1 = "(//select[@id='ctl00_contentMain_txt_birthDateInf_ddlYear_" + i + "'])";
			String[] infanty1 = infantyear.split(",");
			QaRobot.selectTextByLocator(infantyearElement1, infanty1[i],
					"Selected " + infanty1[i] + " as birth year of infant");

			// Fill travel with
			String infantTravelElement1 = "(//select[@id='ctl00_contentMain_ddl_travell_with_" + i + "'])";
			String[] infanttw1 = infantTravelling.split(",");
			QaRobot.selectTextByLocator(infantTravelElement1, infanttw1[i],
					"Selected " + infanttw1[i] + " Travelling with Infant");

			if (Triptype.equalsIgnoreCase("International")) {

				// fill passport country
				String infantpasscountryElement1 = "(//select[@id='ctl00_contentMain_ddl_passCountryInf_" + i + "'])";
				String[] infantpc1 = infantpassportcomp.split(",");
				QaRobot.selectTextByLocator(infantpasscountryElement1, infantpc1[i],
						"Selected " + infantpc1[i] + " as passport country of Infant");

				// FIll Expiry Day
				String infantedayElement1 = "(//select[@id='ctl00_contentMain_txt_ex_dateInf_ddlDay_" + i + "'])";
				String[] infanteday1 = infantedate.split(",");
				QaRobot.selectTextByLocator(infantedayElement1, infanteday1[i],
						"Selected " + infanteday1[i] + " as passport expiry day of Infant");

				// Fill Expiry Month
				String infantemonthElement1 = "(//select[@id='ctl00_contentMain_txt_ex_dateInf_ddlMonth_" + i + "'])";
				String[] infantemm1 = infantemonth.split(",");
				QaRobot.selectDropdownValue(infantemonthElement1, infantemm1[i],
						"Selected " + infantemm1[i] + " as passport expiry month of Infant");

				// Fill Expiry Year
				String infanteyearElement1 = "(//select[@id='ctl00_contentMain_txt_ex_dateInf_ddlYear_" + i + "'])";
				String[] infantey1 = infanteyear.split(",");
				QaRobot.selectTextByLocator(infanteyearElement1, infantey1[i],
						"Selected " + infantey1[i] + " as passport expiry year of infant");

				// fill nationality
				String infantnationalityElement1 = "(//select[@id='ctl00_contentMain_ddl_nationalityInf_" + i + "'])";
				String[] infantnat1 = infantnationality.split(",");
				QaRobot.selectTextByLocator(infantnationalityElement1, infantnat1[i],
						"Selected " + infantnat1[i] + " as nationality of infant");

			}

		}
	}

	@SuppressWarnings("deprecation")
	public static String getLogText(String logFloder, String Uid) throws Exception {
		Iterator<File> fileiter = FileUtils.iterateFiles(new File(logFloder), new String[] { "Xml" }, true);
		while (fileiter.hasNext()) {
			File currFile = fileiter.next();
			if (currFile.getAbsolutePath().toLowerCase().contains(Uid.toLowerCase())) {
				Thread.sleep(4000);
				return FileUtils.readFileToString(currFile);
			}
		}
		throw new Exception("No file found at path " + logFloder + " with uid " + Uid);

	}

	public static List<File> getLogText1(String logFloder, String Uid) throws Exception {

		ArrayList<File> files = new ArrayList<File>();
		Iterator<File> fileiter = FileUtils.iterateFiles(new File(logFloder), new String[] { "log" }, true);
		while (fileiter.hasNext()) {
			File currFile = fileiter.next();
			if (currFile.getAbsolutePath().toLowerCase().contains(Uid.toLowerCase())) {
				files.add(currFile);
			}
		}
		return files;

	}

	// ******************************************Package************************************************************

	public static void SelectDoubleRoom(String Dbl_adult, String Dbl_child, String Dbl_childCategory,
			String Dbl_ExtraBed) throws Exception {

		QaRobot.selectTextFromDropdown("dbl_adult", Dbl_adult, "Selected Adult for Double Room");

		QaRobot.selectTextFromDropdown("dbl_child", Dbl_child, "Selected Child for Double Room");

		int a = Integer.parseInt(Dbl_child);
		for (int i = 1; i <= a; i++) {

			// fill Child Category
			String childCategory1 = "(//select[@id='optDblChild" + i + "'])";
			dblchildCat = Dbl_childCategory.split(",");
			QaRobot.selectTextByLocator(childCategory1, dblchildCat[i - 1],
					"Selected Child Category For Double Room" + i + "");
		}

		QaRobot.selectTextFromDropdown("dbl_extrabed", Dbl_ExtraBed, "Selected ExtraBed for Double Room");
	}

	public static void SelectTwinRoom(String twn_adult, String twn_child, String twn_childCategory, String twn_ExtraBed)
			throws Exception {

		QaRobot.selectTextFromDropdown("twn_adult", twn_adult, "Selected Adult for Twin Room");
		QaRobot.selectTextFromDropdown("twn_child", twn_child, "Selected Child for Twin Room");

		int a = Integer.parseInt(twn_child);
		for (int i = 1; i <= a; i++) {

			// fill Child Category
			String childCategory1 = "(//select[@id='optTwinRoomChild" + i + "'])";
			twnchildCat = twn_childCategory.split(",");
			QaRobot.selectTextByLocator(childCategory1, twnchildCat[i - 1],
					"Selected Child Category For Twin Room" + i + "");
		}

		QaRobot.selectTextFromDropdown("twn_extrabed", twn_ExtraBed, "Selected ExtraBed for Twin Room");
	}

	public static void SelectTripleRoom(String tpl_adult, String tpl_child, String tpl_childCategory) throws Exception {

		QaRobot.selectTextFromDropdown("tpl_adult", tpl_adult, "Selected Adult for Triple Room");
		QaRobot.selectTextFromDropdown("tpl_child", tpl_child, "Selected Child for Triple Room");

		int a = Integer.parseInt(tpl_child);
		for (int i = 1; i <= a; i++) {

			// fill Child Category
			String childCategory1 = "(//select[@id='optTplChild" + i + "'])";
			tplchildCat = tpl_childCategory.split(",");
			QaRobot.selectTextByLocator(childCategory1, tplchildCat[i - 1],
					"Selected Child Category For Triple Room" + i + "");
		}

	}

	public static void SelectSingleRoom(String sin_adult, String sin_child, String sin_childCategory) throws Exception {

		QaRobot.selectTextFromDropdown("sin_adult", sin_adult, "Selected Adult for Single Room");
		QaRobot.selectTextFromDropdown("sin_child", sin_child, "Selected Child for Single Room");

		int a = Integer.parseInt(sin_child);
		for (int i = 1; i <= a; i++) {

			// fill Child Category
			String childCategory1 = "(//select[@id='optSglChild" + i + "'])";
			sinchildCat = sin_childCategory.split(",");
			QaRobot.selectTextByLocator(childCategory1, sinchildCat[i - 1],
					"Selected Child Category For Single Room" + i + "");
		}

	}

	public static void SelectQuadRoom(String qud_adult, String qud_child, String qud_childCategory) throws Exception {

		QaRobot.selectTextFromDropdown("qud_adult", qud_adult, "Selected Adult for Quad Room");
		QaRobot.selectTextFromDropdown("qud_child", qud_child, "Selected Child for Quad Room");

		int a = Integer.parseInt(qud_child);
		for (int i = 1; i <= a; i++) {

			// fill Child Category
			String childCategory1 = "(//select[@id='optQuadChild" + i + "'])";
			qudchildCat = qud_childCategory.split(",");
			QaRobot.selectTextByLocator(childCategory1, qudchildCat[i - 1],
					"Selected Child Category For Quad Room" + i + "");
		}

	}

	public static void CheckoutDoubleRoom(String dbl_adult, String dbl_child, String dbl_title, String dbl_fname,
			String dbl_lname, String dbl_ctitle, String dbl_cfname, String dbl_clname, String dbl_cage,
			String Dbl_ExtraBed, String dbl_etitle, String dbl_efname, String dbl_elname, String dbl_ititle,
			String dbl_ifname, String dbl_ilname, String dbl_infant_age, String dbl_infant) throws Exception {

		int a = Integer.parseInt(dbl_adult);
		int c = Integer.parseInt(dbl_child);
		int e = Integer.parseInt(Dbl_ExtraBed);
		int in = Integer.parseInt(dbl_infant);
		int NoofChild = c - in;
		int StartLoopforInfant = NoofChild + 1;

		for (int i = 1; i <= a; i++) {
			// Fill Title
			String DTitle = "(//select[@id='Title_dbl_adt_" + i + "'])";
			String[] DT = dbl_title.split(",");
			QaRobot.selectDropdownValue(DTitle, DT[i - 1], "Selected Title of Adult For Double Room" + i + "");

			// Fill First name
			String DName = "//input[@id='fname_dbl_adt_" + i + "']";
			String[] DN = dbl_fname.split(",");
			QaRobot.PassValueByLocator(DName, DN[i - 1], "Selected FirstName of Adult For Double Room" + i + "");

			// Fill Last name
			String DLName = "//input[@id='lname_dbl_adt_" + i + "']";
			String[] Dlname = dbl_lname.split(",");
			QaRobot.PassValueByLocator(DLName, Dlname[i - 1], "Entered LastName of Adult for Double Room" + i + "");
		}

		// for child

		for (int i = 0; i < NoofChild; i++) {

			// Fill Title
			String DTitle = "(//select[@id='Title_dbl_chd_" + (i + 1) + "'])";
			String[] DT = dbl_ctitle.split(",");
			QaRobot.selectDropdownValue(DTitle, DT[i], "Selected Title of Child For Double Room" + (i + 1) + "");

			// Fill First name
			String DName = "//input[@id='fname_dbl_chd_" + (i + 1) + "']";
			String[] DN = dbl_cfname.split(",");
			QaRobot.PassValueByLocator(DName, DN[i], "Selected FirstName of Child For Double Room" + (i + 1) + "");

			// Fill Last name
			String DLName = "//input[@id='lname_dbl_chd_" + (i + 1) + "']";
			String[] Dlname = dbl_clname.split(",");
			QaRobot.PassValueByLocator(DLName, Dlname[i], "Entered LastName of Child for Double Room" + (i + 1) + "");

			if (dblchildCat[i].equalsIgnoreCase("Child without bed")) {
				// Fill Age
				String Dage = "//input[@id='Age_dbl_chd_" + (i + 1) + "']";
				String[] DA = dbl_cage.split(",");
				driver.findElement(By.xpath(Dage)).click();
				QaRobot.PassValueByLocator(Dage, DA[i],
						"Entered Age of Child without bed for Double Room" + (i + 1) + "");

			}
		}

		// for Extra bed

		for (int i = 1; i <= e; i++) {
			// Fill Title
			String ETitle = "(//select[@id='Title_dbl_Extra_" + i + "'])";
			String[] ET = dbl_etitle.split(",");
			QaRobot.selectDropdownValue(ETitle, ET[i - 1], "Selected Title of Extra bed For Double Room" + i + "");

			// Fill First name
			String EName = "//input[@id='fname_dbl_Extra_" + i + "']";
			String[] EN = dbl_efname.split(",");
			QaRobot.PassValueByLocator(EName, EN[i - 1], "Selected FirstName of Extra bed For Double Room" + i + "");

			// Fill Last name
			String ELName = "//input[@id='lname_dbl_Extra_" + i + "']";
			String[] Elname = dbl_elname.split(",");
			QaRobot.PassValueByLocator(ELName, Elname[i - 1], "Entered LastName of Extra bed for Double Room" + i + "");
		}

		// for Infant
		for (int i = StartLoopforInfant; i <= c; i++) {

			int Stringvalue = 0;
			// Fill Title
			String ITitle = "(//select[@id='Title_dbl_inf_" + i + "'])";
			String[] IT = dbl_ititle.split(",");
			QaRobot.selectDropdownValue(ITitle, IT[Stringvalue], "Selected Title of Infant For Double Room" + i + "");

			// Fill First name
			String IName = "//input[@id='fname_dbl_inf_" + i + "']";
			String[] IN = dbl_ifname.split(",");
			QaRobot.PassValueByLocator(IName, IN[Stringvalue], "Selected FirstName of Infant For Double Room" + i + "");

			// Fill Last name
			String ILName = "//input[@id='lname_dbl_inf_" + i + "']";
			String[] Ilname = dbl_ilname.split(",");
			QaRobot.PassValueByLocator(ILName, Ilname[Stringvalue],
					"Entered LastName of Infant for Double Room" + i + "");

			// Fill Infant Age
			String IAge = "//input[@id='Age_dbl_inf_" + i + "']";
			String[] IA = dbl_infant_age.split(",");
			driver.findElement(By.xpath(IAge)).click();
			QaRobot.PassValueByLocator(IAge, IA[Stringvalue], "Entered Age of Infant for Double Room" + i + "");
			Stringvalue++;
		}
	}

	public static void CheckoutTwinRoom(String Twn_adult, String Twn_child, String Twn_title, String Twn_fname,
			String Twn_lname, String Twn_ctitle, String Twn_cfname, String Twn_clname, String Twn_cage,
			String Twn_ExtraBed, String Twn_etitle, String Twn_efname, String Twn_elname, String Twn_ititle,
			String Twn_ifname, String Twn_ilname, String Twn_infant_age, String Twn_infant) throws Exception {

		int a = Integer.parseInt(Twn_adult);
		int c = Integer.parseInt(Twn_child);
		int e = Integer.parseInt(Twn_ExtraBed);
		int in = Integer.parseInt(Twn_infant);
		int NoofChild = c - in;
		int StartLoopforInfant = NoofChild + 1;

		for (int i = 1; i <= a; i++) {
			// Fill Title
			String DTitle = "(//select[@id='Title_twin_adt_" + i + "'])";
			String[] DT = Twn_title.split(",");
			QaRobot.selectDropdownValue(DTitle, DT[i - 1], "Selected Title of Adult For Twin Room" + i + "");

			// Fill First name
			String DName = "//input[@id='fname_twin_adt_" + i + "']";
			String[] DN = Twn_fname.split(",");
			QaRobot.PassValueByLocator(DName, DN[i - 1], "Selected FirstName of Adult For Twin Room" + i + "");

			// Fill Last name
			String DLName = "//input[@id='lname_twin_adt_" + i + "']";
			String[] Dlname = Twn_lname.split(",");
			QaRobot.PassValueByLocator(DLName, Dlname[i - 1], "Entered LastName of Adult for Twin Room" + i + "");
		}

		// for child

		for (int i = 0; i < NoofChild; i++) {
			// Fill Title
			String DTitle = "(//select[@id='Title_twin_chd_" + (i + 1) + "'])";
			String[] DT = Twn_ctitle.split(",");
			QaRobot.selectDropdownValue(DTitle, DT[i], "Selected Title of Child For Twin Room" + (i + 1) + "");

			// Fill First name
			String DName = "//input[@id='fname_twin_chd_" + (i + 1) + "']";
			String[] DN = Twn_cfname.split(",");
			QaRobot.PassValueByLocator(DName, DN[i], "Selected FirstName of Child For Twin Room" + (i + 1) + "");

			// Fill Last name
			String DLName = "//input[@id='lname_twin_chd_" + (i + 1) + "']";
			String[] Dlname = Twn_clname.split(",");
			QaRobot.PassValueByLocator(DLName, Dlname[i], "Entered LastName of Child for Twin Room" + (i + 1) + "");

			if (twnchildCat[i].equalsIgnoreCase("Child without bed")) {
				// Fill Age
				String Tage = "//input[@id='Age_twin_chd_" + (i + 1) + "']";
				String[] TA = Twn_cage.split(",");
				driver.findElement(By.xpath(Tage)).click();
				QaRobot.PassValueByLocator(Tage, TA[i],
						"Entered Age of Child without bed for Twin Room" + (i + 1) + "");
			}
		}

		// for Extra bed

		for (int i = 1; i <= e; i++) {
			// Fill Title
			String ETitle = "(//select[@id='Title_twin_Extra_" + i + "'])";
			String[] ET = Twn_etitle.split(",");
			QaRobot.selectDropdownValue(ETitle, ET[i - 1], "Selected Title of Extra bed For Twin Room" + i + "");

			// Fill First name
			String EName = "//input[@id='fname_twin_Extra_" + i + "']";
			String[] EN = Twn_efname.split(",");
			QaRobot.PassValueByLocator(EName, EN[i - 1], "Selected FirstName of Extra bed For Twin Room" + i + "");

			// Fill Last name
			String ELName = "//input[@id='lname_twin_Extra_" + i + "']";
			String[] Elname = Twn_elname.split(",");
			QaRobot.PassValueByLocator(ELName, Elname[i - 1], "Entered LastName of Extra bed for Twin Room" + i + "");
		}

		// for infant
		for (int i = StartLoopforInfant; i <= c; i++) {

			int Stringvalue = 0;

			// Fill Title
			String ITitle = "(//select[@id='Title_twin_inf_" + i + "'])";
			String[] IT = Twn_ititle.split(",");
			QaRobot.selectDropdownValue(ITitle, IT[Stringvalue], "Selected Title of Infant For Twin Room" + i + "");

			// Fill First name
			String IName = "//input[@id='fname_twin_inf_" + i + "']";
			String[] IN = Twn_ifname.split(",");
			QaRobot.PassValueByLocator(IName, IN[Stringvalue], "Selected FirstName of Infant For Twin Room" + i + "");

			// Fill Last name
			String ILName = "//input[@id='lname_twin_inf_" + i + "']";
			String[] Ilname = Twn_ilname.split(",");
			QaRobot.PassValueByLocator(ILName, Ilname[Stringvalue],
					"Entered LastName of Infant for Twin Room" + i + "");

			// // Fill Infant Age
			String IAge = "//input[@id='Age_twin_inf_" + i + "']";
			String[] IA = Twn_infant_age.split(",");
			driver.findElement(By.xpath(IAge)).click();
			QaRobot.PassValueByLocator(IAge, IA[Stringvalue], "Entered Age of Infant for Twin Room" + i + "");
			// System.out.println(IA[Stringvalue]);

			Stringvalue++;
		}

	}

	public static void CheckoutTripleRoom(String Tpl_adult, String Tpl_child, String Tpl_title, String Tpl_fname,
			String Tpl_lname, String Tpl_ctitle, String Tpl_cfname, String Tpl_clname, String Tpl_cage,
			String Tpl_ititle, String Tpl_ifname, String Tpl_ilname, String Tpl_infant_age, String Tpl_infant)
			throws Exception {

		int a = Integer.parseInt(Tpl_adult);
		int c = Integer.parseInt(Tpl_child);
		int in = Integer.parseInt(Tpl_infant);
		int NoofChild = c - in;
		int StartLoopforInfant = NoofChild + 1;

		for (int i = 1; i <= a; i++) {
			// Fill Title
			String DTitle = "(//select[@id='Title_tpl_adt_" + i + "'])";
			String[] DT = Tpl_title.split(",");
			QaRobot.selectDropdownValue(DTitle, DT[i - 1], "Selected Title of Adult For Triple Room" + i + "");

			// Fill First name
			String DName = "//input[@id='fname_tpl_adt_" + i + "']";
			String[] DN = Tpl_fname.split(",");
			QaRobot.PassValueByLocator(DName, DN[i - 1], "Selected FirstName of Adult For Triple Room" + i + "");

			// Fill Last name
			String DLName = "//input[@id='lname_tpl_adt_" + i + "']";
			String[] Dlname = Tpl_lname.split(",");
			QaRobot.PassValueByLocator(DLName, Dlname[i - 1], "Entered LastName of Adult for Triple Room" + i + "");
		}

		// for child

		for (int i = 0; i < NoofChild; i++) {
			// Fill Title
			String DTitle = "(//select[@id='Title_tpl_chd_" + (i + 1) + "'])";
			String[] DT = Tpl_ctitle.split(",");
			QaRobot.selectDropdownValue(DTitle, DT[i], "Selected Title of Child For Triple Room" + (i + 1) + "");

			// Fill First name
			String DName = "//input[@id='fname_tpl_chd_" + (i + 1) + "']";
			String[] DN = Tpl_cfname.split(",");
			QaRobot.PassValueByLocator(DName, DN[i], "Selected FirstName of Child For Triple Room" + (i + 1) + "");

			// Fill Last name
			String DLName = "//input[@id='lname_tpl_chd_" + (i + 1) + "']";
			String[] Dlname = Tpl_clname.split(",");
			QaRobot.PassValueByLocator(DLName, Dlname[i], "Entered LastName of Child for Triple Room" + (i + 1) + "");

			if (tplchildCat[i].equalsIgnoreCase("Child without bed")) {
				// Fill Age
				String Tage = "//input[@id='Age_tpl_chd_" + (i + 1) + "']";
				String[] TA = Tpl_cage.split(",");
				driver.findElement(By.xpath(Tage)).click();
				QaRobot.PassValueByLocator(Tage, TA[i],
						"Entered Age of Child without bed for Triple Room" + (i + 1) + "");
			}
		}

		for (int i = StartLoopforInfant; i <= c; i++) {

			int Stringvalue = 0;

			// Fill Title
			String ITitle = "(//select[@id='Title_tpl_inf_" + i + "'])";
			String[] IT = Tpl_ititle.split(",");
			QaRobot.selectDropdownValue(ITitle, IT[Stringvalue], "Selected Title of Infant For Triple Room" + i + "");

			// Fill First name
			String IName = "//input[@id='fname_tpl_inf_" + i + "']";
			String[] IN = Tpl_ifname.split(",");
			QaRobot.PassValueByLocator(IName, IN[Stringvalue], "Selected FirstName of Infant For Triple Room" + i + "");

			// Fill Last name
			String ILName = "//input[@id='lname_tpl_inf_" + i + "']";
			String[] Ilname = Tpl_ilname.split(",");
			QaRobot.PassValueByLocator(ILName, Ilname[Stringvalue],
					"Entered LastName of Infant for Triple Room" + i + "");

			// Fill Infant Age
			String IAge = "//input[@id='Age_tpl_inf_" + i + "']";
			String[] IA = Tpl_infant_age.split(",");
			driver.findElement(By.xpath(IAge)).click();
			QaRobot.PassValueByLocator(IAge, IA[Stringvalue], "Entered Age of Infant for Triple Room" + i + "");

			Stringvalue++;

		}

	}

	public static void CheckoutSingleRoom(String Sin_adult, String Sin_child, String Sin_title, String Sin_fname,
			String Sin_lname, String Sin_ctitle, String Sin_cfname, String Sin_clname, String Sin_cage,
			String Sin_ititle, String Sin_ifname, String Sin_ilname, String Sin_infant_age, String Sin_infant)
			throws Exception {

		int a = Integer.parseInt(Sin_adult);
		int c = Integer.parseInt(Sin_child);
		int in = Integer.parseInt(Sin_infant);
		int NoofChild = c - in;
		int StartLoopforInfant = NoofChild + 1;

		for (int i = 1; i <= a; i++) {
			// Fill Title
			String DTitle = "(//select[@id='Title_sgl_adt_" + i + "'])";
			String[] DT = Sin_title.split(",");
			QaRobot.selectDropdownValue(DTitle, DT[i - 1], "Selected Title of Adult For Single Room" + i + "");

			// Fill First name
			String DName = "//input[@id='fname_sgl_adt_" + i + "']";
			String[] DN = Sin_fname.split(",");
			QaRobot.PassValueByLocator(DName, DN[i - 1], "Selected FirstName of Adult For Single Room" + i + "");

			// Fill Last name
			String DLName = "//input[@id='lname_sgl_adt_" + i + "']";
			String[] Dlname = Sin_lname.split(",");
			QaRobot.PassValueByLocator(DLName, Dlname[i - 1], "Entered LastName of Adult for Single Room" + i + "");
		}

		// for child

		for (int i = 0; i < NoofChild; i++) {
			// Fill Title
			String DTitle = "(//select[@id='Title_sgl_chd_" + (i + 1) + "'])";
			String[] DT = Sin_ctitle.split(",");
			QaRobot.selectDropdownValue(DTitle, DT[i], "Selected Title of Child For Single Room" + (i + 1) + "");

			// Fill First name
			String DName = "//input[@id='fname_sgl_chd_" + (i + 1) + "']";
			String[] DN = Sin_cfname.split(",");
			QaRobot.PassValueByLocator(DName, DN[i], "Selected FirstName of Child For Single Room" + (i + 1) + "");

			// Fill Last name
			String DLName = "//input[@id='lname_sgl_chd_" + (i + 1) + "']";
			String[] Dlname = Sin_clname.split(",");
			QaRobot.PassValueByLocator(DLName, Dlname[i], "Entered LastName of Child for Single Room" + (i + 1) + "");

			if (sinchildCat[i].equalsIgnoreCase("Child without bed")) {
				// Fill Age
				String Tage = "//input[@id='Age_sgl_chd_" + (i + 1) + "']";
				String[] TA = Sin_cage.split(",");
				driver.findElement(By.xpath(Tage)).click();
				QaRobot.PassValueByLocator(Tage, TA[i],
						"Entered Age of Child without bed for Single Room" + (i + 1) + "");
			}
		}

		for (int i = StartLoopforInfant; i <= c; i++) {

			int Stringvalue = 0;

			// Fill Title
			String ITitle = "(//select[@id='Title_sgl_inf_" + i + "'])";
			String[] IT = Sin_ititle.split(",");
			QaRobot.selectDropdownValue(ITitle, IT[Stringvalue], "Selected Title of Infant For Single Room" + i + "");

			// Fill First name
			String IName = "//input[@id='fname_sgl_inf_" + i + "']";
			String[] IN = Sin_ifname.split(",");
			QaRobot.PassValueByLocator(IName, IN[Stringvalue], "Selected FirstName of Infant For Single Room" + i + "");

			// Fill Last name
			String ILName = "//input[@id='lname_sgl_inf_" + i + "']";
			String[] Ilname = Sin_ilname.split(",");
			QaRobot.PassValueByLocator(ILName, Ilname[Stringvalue],
					"Entered LastName of Infant for Single Room" + i + "");

			// Fill Infant Age
			String IAge = "//input[@id='Age_sgl_inf_" + i + "']";
			String[] IA = Sin_infant_age.split(",");
			driver.findElement(By.xpath(IAge)).click();
			QaRobot.PassValueByLocator(IAge, IA[Stringvalue], "Entered Age of Infant for Single Room" + i + "");

			Stringvalue++;
		}

	}

	public static void CheckoutQuadRoom(String Qud_adult, String Qud_child, String Qud_title, String Qud_fname,
			String Qud_lname, String Qud_ctitle, String Qud_cfname, String Qud_clname, String Qud_cage,
			String Qud_ititle, String Qud_ifname, String Qud_ilname, String Qud_infant_age, String Qud_infant)
			throws Exception {

		int a = Integer.parseInt(Qud_adult);
		int c = Integer.parseInt(Qud_child);
		int in = Integer.parseInt(Qud_infant);
		int NoofChild = c - in;
		int StartLoopforInfant = NoofChild + 1;

		for (int i = 1; i <= a; i++) {
			// Fill Title
			String DTitle = "(//select[@id='Title_quad_adt_" + i + "'])";
			String[] DT = Qud_title.split(",");
			QaRobot.selectDropdownValue(DTitle, DT[i - 1], "Selected Title of Adult For Quad Room" + i + "");

			// Fill First name
			String DName = "//input[@id='fname_quad_adt_" + i + "']";
			String[] DN = Qud_fname.split(",");
			QaRobot.PassValueByLocator(DName, DN[i - 1], "Selected FirstName of Adult For Quad Room" + i + "");

			// Fill Last name
			String DLName = "//input[@id='lname_quad_adt_" + i + "']";
			String[] Dlname = Qud_lname.split(",");
			QaRobot.PassValueByLocator(DLName, Dlname[i - 1], "Entered LastName of Adult for Quad Room" + i + "");
		}

		// for child

		for (int i = 0; i < NoofChild; i++) {
			// Fill Title
			String DTitle = "(//select[@id='Title_quad_chd_" + (i + 1) + "'])";
			String[] DT = Qud_ctitle.split(",");
			QaRobot.selectDropdownValue(DTitle, DT[i], "Selected Title of Child For Quad Room" + (i + 1) + "");

			// Fill First name
			String DName = "//input[@id='fname_quad_chd_" + (i + 1) + "']";
			String[] DN = Qud_cfname.split(",");
			QaRobot.PassValueByLocator(DName, DN[i], "Selected FirstName of Child For Quad Room" + (i + 1) + "");

			// Fill Last name
			String DLName = "//input[@id='lname_quad_chd_" + (i + 1) + "']";
			String[] Dlname = Qud_clname.split(",");
			QaRobot.PassValueByLocator(DLName, Dlname[i], "Entered LastName of Child for Quad Room" + (i + 1) + "");

			if (qudchildCat[i].equalsIgnoreCase("Child without bed")) {
				// Fill Age
				String Tage = "//input[@id='Age_quad_chd_" + (i + 1) + "']";
				String[] TA = Qud_cage.split(",");
				driver.findElement(By.xpath(Tage)).click();
				QaRobot.PassValueByLocator(Tage, TA[i],
						"Entered Age of Child without bed for Quad Room" + (i + 1) + "");
			}
		}

		for (int i = StartLoopforInfant; i <= c; i++) {

			int Stringvalue = 0;

			// Fill Title
			String ITitle = "(//select[@id='Title_quad_inf_" + i + "'])";
			String[] IT = Qud_ititle.split(",");
			QaRobot.selectDropdownValue(ITitle, IT[Stringvalue], "Selected Title of Infant For Quad Room" + i + "");

			// Fill First name
			String IName = "//input[@id='fname_quad_inf_" + i + "']";
			String[] IN = Qud_ifname.split(",");
			QaRobot.PassValueByLocator(IName, IN[Stringvalue], "Selected FirstName of Infant For Quad Room" + i + "");

			// Fill Last name
			String ILName = "//input[@id='lname_quad_inf_" + i + "']";
			String[] Ilname = Qud_ilname.split(",");
			QaRobot.PassValueByLocator(ILName, Ilname[Stringvalue],
					"Entered LastName of Infant for Quad Room" + i + "");

			// Fill Infant Age
			String IAge = "//input[@id='Age_quad_inf_" + i + "']";
			String[] IA = Qud_infant_age.split(",");
			driver.findElement(By.xpath(IAge)).click();
			QaRobot.PassValueByLocator(IAge, IA[Stringvalue], "Entered Age of Infant for Quad Room" + i + "");

			Stringvalue++;
		}

	}

	public static void package_card(String cardmode, String type, String cardno, String cardname, String cardmonth,
			String cardyear, String cardcvv) throws Exception {
		// condition for credit and online

		if (cardmode.equalsIgnoreCase("Credit Card")) {

			QaRobot.ClickOnElement("P_credit", "Clicked on credit card");
			if (type.equalsIgnoreCase("Master Card")) {

				QaRobot.ClickOnElement("P_credit_master", "clicked card type master card");
				QaRobot.PassValue("P_cardno", cardno, "Entered Card Number");
				QaRobot.PassValue("P_cardname", cardname, "Entered Card Holder Name");
				QaRobot.selectValueFromDropdown("P_cardmonth", cardmonth, "selected card Month");
				QaRobot.selectValueFromDropdown("P_cardyear", cardyear, "selected card Year");
				QaRobot.PassValue("P_cvv", cardcvv, "Entered card CVV Number");
			}

			// else if (type.equalsIgnoreCase("visa")) {
			//
			// selectTextFromDropdown("credit", type, "select card type master
			// card");
			// PassValue("card_number", cardno, "Entered Card Number");
			// PassValue("card_name", cardname, "Entered Card Holder Name");
			// selectValueFromDropdown("card_month", cardmonth, "selected card
			// Month");
			// selectValueFromDropdown("card_year", cardyear, "selected card
			// Year");
			// PassValue("card_cvv", cardcvv, "Entered card CVV Number");
			//
			// }
		} else if (cardmode.equalsIgnoreCase("Debit Card")) {

			QaRobot.ClickOnElement("P_debit", "Clicked on debit card");
			if (type.equalsIgnoreCase("Master Card")) {

				QaRobot.ClickOnElement("P_debit_master", "clicked card type master card");
				QaRobot.PassValue("P_cardno", cardno, "Entered Card Number");
				QaRobot.PassValue("P_cardname", cardname, "Entered Card Holder Name");
				QaRobot.selectValueFromDropdown("P_cardmonth", cardmonth, "selected card Month");
				QaRobot.selectValueFromDropdown("P_cardyear", cardyear, "selected card Year");
				QaRobot.PassValue("P_cvv", cardcvv, "Entered card CVV Number");

			} else if (type.equalsIgnoreCase("VISA")) {

				QaRobot.selectTextFromDropdown("P_debit_visa", type, "select card type master card");
				QaRobot.PassValue("P_cardno", cardno, "Entered Card Number");
				QaRobot.PassValue("P_cardname", cardname, "Entered Card Holder Name");
				QaRobot.selectValueFromDropdown("P_cardmonth", cardmonth, "selected card Month");
				QaRobot.selectValueFromDropdown("P_cardyear", cardyear, "selected card Year");
				QaRobot.PassValue("P_cvv", cardcvv, "Entered card CVV Number");

			}

		}
	}

	public static void package_billing(String baddress, String bcity, String bcityauto, String bstate, String bcountry)
			throws Exception {

		// Billing Address
		QaRobot.PassValue("P_bil_add", baddress, "Entered Billing Address");

		// billing city
		listofautosuggestion(By.xpath("//div[@id='divHTCity']/p"), bcity, bcityauto,
				By.xpath("//input[@id='clientCity']"));

		// Select billing state
		QaRobot.PassValue("P_bil_state", bstate, "Entered billing state");

		// Select billing country
		QaRobot.selectTextFromDropdown("P_bil_country", bcountry, "Slected billing Country");

	}

	public static void ResultnotFound(String text) throws Exception {
		// If not getting result

		test.log(Status.INFO, text);

		Thread.sleep(1000);

		// take screenshot for result page

		String resultnotfound = Logger.takeScreenshot(driver, "resultnotfound");
		test.log(Status.INFO, "Screenshot for Resultnotfound",
				MediaEntityBuilder.createScreenCaptureFromPath(resultnotfound).build());

		// ClickOnElement("Go_Home", "clicked on Home Page");

	}

	// Adult information for New Checkout Page

	public static void adultNewCheckout(String adult, String title, String adultfname, String adultlname,
			String adultmonth, String adultyear, String adultdate, String adultidno, String adultmailid,
			String adultisd, String adultphone, String adultpassprot, String adultpassportcomp, String adultemonth,
			String adulteyear, String adultedate, String adultnationality) throws Exception {

		int a = Integer.parseInt(adult);
		for (int i = 1; i <= a; i++) {

			// fill Title
			Thread.sleep(500);
			String adultTitleElement = "(//select[@id='ddlTitleAdt" + i + "'])";
			String[] adulttitle = title.split(",");
			QaRobot.selectDropdownValue(adultTitleElement, adulttitle[i - 1], "Selected Title For Adult");

			// Fill First name
			String adultNameElement = "//input[@id='txt_firstNameAdt" + i + "']";
			String[] adultfirstname = adultfname.split(",");
			QaRobot.PassValueByLocator(adultNameElement, adultfirstname[i - 1], "Entered Name For Adult" + i + "");

			// Fill Last name

			String adultLNameElement = "//input[@id='txt_lastnameAdt" + i + "']";
			String[] adultlastname = adultlname.split(",");
			QaRobot.PassValueByLocator(adultLNameElement, adultlastname[i - 1], "Entered Last Name For Adult" + i + "");

			// FIll DOB

			driver.findElement(By.xpath("//input[@id='txt_dobAdt" + i + "']")).click();

			Thread.sleep(1000);

			// Fill Year

			String adultyearElement = "(//select[@class='datepick-month-year'])[2]";
			String[] adulty = adultyear.split(",");
			QaRobot.selectTextByLocator(adultyearElement, adulty[i - 1], "Selected Year For Adult");

			// Fill Month
			String adultmonthElement = "(//select[@class='datepick-month-year'])[1]";
			String[] adultmm = adultmonth.split(",");
			QaRobot.selectTextByLocator(adultmonthElement, adultmm[i - 1], "Selected Month For Adult");

			// FIll Day

			String[] adultday = adultdate.split(",");
			driver.findElement(By.xpath("//a[text()='" + adultday[i - 1] + "']")).click();

			// // fill identity number
			// List<WebElement> id_number_Adult = driver
			// .findElements(By.xpath("//input[@id='txt_IdentityNoAdt" + i +
			// "']"));
			//
			// if (id_number_Adult.size() > 0) {
			// String[] idno = adultidno.split(",");
			// // PassValueByLocator(id_number_Adult,idno[i-1],"Selected
			// // Identity no For Adult"+i+"");
			// driver.findElement(By.xpath("//input[@id='txt_IdentityNoAdt" + i
			// + "']")).sendKeys(idno[i - 1]);
			// } else {
			// System.out.print("No identity number for adult");
			// }
			Thread.sleep(500);
			driver.findElement(By.xpath("(//span[@class='pr-1 black_color ng-binding'])[" + i + "]")).click();
			Thread.sleep(500);

			// Fill Passport
			String adultpassportElement = "//input[@id='txt_passportAdt" + i + "']";
			String[] adultpass = adultpassprot.split(",");
			QaRobot.PassValueByLocator(adultpassportElement, adultpass[i - 1],
					"Entered Passport Number For Adult" + i + "");

			// fill Passport issuing country
			String adultpasscountryElement = "(//select[@id='ddl_passCountryAdt" + i + "'])";
			String[] adultpc = adultpassportcomp.split(",");
			QaRobot.selectTextByLocator(adultpasscountryElement, adultpc[i - 1], "Selected Passport Country For Adult");

			// clicked on Expiry Dob
			Thread.sleep(500);
			driver.findElement(By.xpath("//input[@id='txt_ex_dateAdt" + i + "']")).click();
			Thread.sleep(500);

			// Fill Year

			String adulteyearElement = "(//select[@class='datepick-month-year'])[2]";
			String[] adultey = adulteyear.split(",");
			QaRobot.selectTextByLocator(adulteyearElement, adultey[i - 1], "Selected Expiry Year For Adult");

			// Fill Month
			String adultemonthElement = "(//select[@class='datepick-month-year'])[1]";
			String[] adultemm = adultemonth.split(",");
			QaRobot.selectTextByLocator(adultemonthElement, adultemm[i - 1], "Selected Expiry Month For Adult");

			// FIll Day

			String[] adulteday = adultedate.split(",");
			driver.findElement(By.xpath("//a[text()='" + adulteday[i - 1] + "']")).click();

			// fill nationality

			String adultnationalityElement = "(//select[@id='ddl_nationalityAdt" + i + "'])";
			String[] adultnat = adultnationality.split(",");
			QaRobot.selectTextByLocator(adultnationalityElement, adultnat[i - 1], "Selected Nationality For Adult");

		}

		// Adult Mailid

		QaRobot.PassValue("fnew_adult_maild", adultmailid, "Entered MailID");

		// adult isd
		QaRobot.PassValue("fnew_adt_isd", adultisd, "Entered ISD Number");

		// adult phone
		QaRobot.PassValue("fnew_adt_ph", adultphone, "Entered Phone Number");

	}

	public static void childNewCheckout(String child, String ctitle, String childfname, String childlname,
			String childmonth, String childyear, String childdate, String childidno, String childpassprot,
			String childpassportcomp, String childemonth, String childeyear, String childedate, String childnationality)
			throws Exception {

		int a = Integer.parseInt(child);
		for (int i = 1; i <= a; i++) {

			// fill Title
			String childTitleElement = "(//select[@id='ddlTitleChd" + i + "'])";
			String[] childtitle = ctitle.split(",");
			QaRobot.selectDropdownValue(childTitleElement, childtitle[i - 1], "Selected Title For Child");

			// Fill First name
			String childNameElement = "//input[@id='txt_firstNameChd" + i + "']";
			String[] childfirstname = childfname.split(",");
			QaRobot.PassValueByLocator(childNameElement, childfirstname[i - 1], "Entered Name For Child");

			// Fill Last name

			String childLNameElement = "//input[@id='txt_lastnameChd" + i + "']";
			String[] childlastname = childlname.split(",");
			QaRobot.PassValueByLocator(childLNameElement, childlastname[i - 1], "Entered Last Name For Child");

			// FIll DOB

			driver.findElement(By.xpath("//input[@id='txt_dobChd" + i + "']")).click();

			Thread.sleep(1000);

			// Fill Year

			String childyearElement = "(//select[@class='datepick-month-year'])[2]";
			String[] childy = childyear.split(",");
			QaRobot.selectTextByLocator(childyearElement, childy[i - 1], "Selected Year For Child");

			// Fill Month
			String childmonthElement = "(//select[@class='datepick-month-year'])[1]";
			String[] childmm = childmonth.split(",");
			QaRobot.selectTextByLocator(childmonthElement, childmm[i - 1], "Selected Month For Child");

			// FIll Day

			String[] childday = childdate.split(",");
			driver.findElement(By.xpath("//a[text()='" + childday[i - 1] + "']")).click();

			// // fill identity number
			// List<WebElement> id_number_Adult = driver
			// .findElements(By.xpath("//input[@id='txt_IdentityNoAdt" + i +
			// "']"));
			//
			// if (id_number_Adult.size() > 0) {
			// String[] idno = adultidno.split(",");
			// // PassValueByLocator(id_number_Adult,idno[i-1],"Selected
			// // Identity no For Adult"+i+"");
			// driver.findElement(By.xpath("//input[@id='txt_IdentityNoAdt" + i
			// + "']")).sendKeys(idno[i - 1]);
			// } else {
			// System.out.print("No identity number for adult");
			// }
			Thread.sleep(500);
			driver.findElement(By.xpath("(//span[@class='pr-1 black_color'])[" + i + "]")).click();
			Thread.sleep(500);

			// Fill Passport
			String childpassportElement = "//input[@id='txt_passportChd" + i + "']";
			String[] childpass = childpassprot.split(",");
			QaRobot.PassValueByLocator(childpassportElement, childpass[i - 1],
					"Entered Passport Number For Child" + i + "");

			// fill Passport issuing country
			Thread.sleep(500);
			String childpasscountryElement = "(//select[@id='ddl_passCountryChd" + i + "'])";
			String[] childpc = childpassportcomp.split(",");
			QaRobot.selectTextByLocator(childpasscountryElement, childpc[i - 1], "Selected Passport Country For Child");

			// clicked on Expiry Dob
			Thread.sleep(500);
			driver.findElement(By.xpath("//input[@id='txt_ex_dateChd" + i + "']")).click();
			Thread.sleep(500);

			// Fill Year

			String childeyearElement = "(//select[@class='datepick-month-year'])[2]";
			String[] childey = childeyear.split(",");
			QaRobot.selectTextByLocator(childeyearElement, childey[i - 1], "Selected Expiry Year For Child");

			// Fill Month
			String childemonthElement = "(//select[@class='datepick-month-year'])[1]";
			String[] childemm = childemonth.split(",");
			QaRobot.selectTextByLocator(childemonthElement, childemm[i - 1], "Selected Expiry Month For Child");

			// FIll Day

			String[] childeday = childedate.split(",");
			driver.findElement(By.xpath("//a[text()='" + childeday[i - 1] + "']")).click();

			// fill nationality

			String childnationalityElement = "(//select[@id='ddl_nationalityChd" + i + "'])";
			String[] childnat = childnationality.split(",");
			QaRobot.selectTextByLocator(childnationalityElement, childnat[i - 1], "Selected Nationality For Child");

		}
	}

	public static void infantNewCheckout(String child, String infant, String ititle, String infantfname,
			String infantlname, String infantmonth, String infantyear, String infantdate, String infantidno,
			String infantTravelling, String infantpassprot, String infantpassportcomp, String infantemonth,
			String infanteyear, String infantedate, String infantnationality) throws Exception {

		int c = Integer.parseInt(child);
		int a = Integer.parseInt(infant);
		for (int i = 1; i <= a; i++) {

			// fill Title
			String infantTitleElement = "(//select[@id='ddlTitleInf" + i + "'])";
			String[] infanttitle = ititle.split(",");
			QaRobot.selectDropdownValue(infantTitleElement, infanttitle[i - 1], "Selected Title For infant");

			// Fill First name
			String infantNameElement = "//input[@id='txt_firstNameInf" + i + "']";
			String[] infantfirstname = infantfname.split(",");
			QaRobot.PassValueByLocator(infantNameElement, infantfirstname[i - 1], "Entered Name For infant");

			// Fill Last name

			String infantLNameElement = "//input[@id='txt_lastnameInf" + i + "']";
			String[] infantlastname = infantlname.split(",");
			QaRobot.PassValueByLocator(infantLNameElement, infantlastname[i - 1], "Entered Last Name For infant");

			// FIll DOB

			driver.findElement(By.xpath("//input[@id='txt_dobInf" + i + "']")).click();

			Thread.sleep(1000);

			// Fill Year

			String infantyearElement = "(//select[@class='datepick-month-year'])[2]";
			String[] infanty = infantyear.split(",");
			QaRobot.selectTextByLocator(infantyearElement, infanty[i - 1], "Selected Year For infant");

			// Fill Month
			String infantmonthElement = "(//select[@class='datepick-month-year'])[1]";
			String[] infantmm = infantmonth.split(",");
			QaRobot.selectTextByLocator(infantmonthElement, infantmm[i - 1], "Selected Month For infant");

			// FIll Day

			String[] infantday = infantdate.split(",");
			driver.findElement(By.xpath("//a[text()='" + infantday[i - 1] + "']")).click();

			// Fill travel with
			String infantTravelElement1 = "//select[@id='ddl_travell_with" + i + "']";
			String[] infanttw1 = infantTravelling.split(",");
			QaRobot.selectTextByLocator(infantTravelElement1, infanttw1[i - 1],
					"Selected Travelling with Infant" + i + "");

			// // fill identity number
			// List<WebElement> id_number_Adult = driver
			// .findElements(By.xpath("//input[@id='txt_IdentityNoAdt" + i +
			// "']"));
			//
			// if (id_number_Adult.size() > 0) {
			// String[] idno = adultidno.split(",");
			// // PassValueByLocator(id_number_Adult,idno[i-1],"Selected
			// // Identity no For Adult"+i+"");
			// driver.findElement(By.xpath("//input[@id='txt_IdentityNoAdt" + i
			// + "']")).sendKeys(idno[i - 1]);
			// } else {
			// System.out.print("No identity number for adult");
			// }
			Thread.sleep(500);

			if (c > 0) {
				driver.findElement(By.xpath("(//span[@class='pr-1 black_color'])[" + (c + i) + "]")).click();
			} else {
				driver.findElement(By.xpath("(//span[@class='pr-1 black_color'])[" + i + "]")).click();
			}

			Thread.sleep(500);

			// Fill Passport
			String infantpassportElement = "//input[@id='txt_passportInf" + i + "']";
			String[] infantpass = infantpassprot.split(",");
			QaRobot.PassValueByLocator(infantpassportElement, infantpass[i - 1],
					"Entered Passport Number For infant" + i + "");

			// fill Passport issuing country
			Thread.sleep(500);
			String infantpasscountryElement = "(//select[@id='ddl_passCountryInf" + i + "'])";
			String[] infantpc = infantpassportcomp.split(",");
			QaRobot.selectTextByLocator(infantpasscountryElement, infantpc[i - 1],
					"Selected Passport Country For infant");

			// clicked on Expiry Dob
			Thread.sleep(500);
			driver.findElement(By.xpath("//input[@id='txt_ex_dateInf" + i + "']")).click();
			Thread.sleep(500);

			// Fill Year

			String infanteyearElement = "(//select[@class='datepick-month-year'])[2]";
			String[] infantey = infanteyear.split(",");
			QaRobot.selectTextByLocator(infanteyearElement, infantey[i - 1], "Selected Expiry Year For infant");

			// Fill Month
			String infantemonthElement = "(//select[@class='datepick-month-year'])[1]";
			String[] infantemm = infantemonth.split(",");
			QaRobot.selectTextByLocator(infantemonthElement, infantemm[i - 1], "Selected Expiry Month For infant");

			// FIll Day

			String[] infanteday = infantedate.split(",");
			driver.findElement(By.xpath("//a[text()='" + infanteday[i - 1] + "']")).click();

			// fill nationality

			String infantnationalityElement = "(//select[@id='ddl_nationalityInf" + i + "'])";
			String[] infantnat = infantnationality.split(",");
			QaRobot.selectTextByLocator(infantnationalityElement, infantnat[i - 1], "Selected Nationality For infant");

		}
	}

	public static void NewChkout_Card(String cardmode, String type, String cardno, String cardname, String cardmonth,
			String cardyear, String cardcvv) throws Exception {
		// condition for credit and online

		if (cardmode.equalsIgnoreCase("Credit Card")) {

			QaRobot.ClickOnElement("newchk_credit_card", "Clicked on credit card");
			if (type.equalsIgnoreCase("Master Card")) {

				QaRobot.ClickOnElement("newchk_creditmaster", "select master card type ");
				QaRobot.PassValue("newchk_ccard_number", cardno, "Entered Card Number");
				QaRobot.PassValue("newchk_ccard_name", cardname, "Entered Card Holder Name");
				QaRobot.selectTextFromDropdown("newchk_ccard_month", cardmonth, "selected card Month");
				QaRobot.selectTextFromDropdown("newchk_ccard_year", cardyear, "selected card Year");
				QaRobot.PassValue("newchk_ccard_cvv", cardcvv, "Entered card CVV Number");

			} else if (type.equalsIgnoreCase("visa")) {

				QaRobot.ClickOnElement("newchk_creditvisa", "select visa card type ");
				QaRobot.PassValue("card_number", cardno, "Entered Card Number");
				QaRobot.PassValue("card_name", cardname, "Entered Card Holder Name");
				QaRobot.selectTextFromDropdown("card_month", cardmonth, "selected card Month");
				QaRobot.selectTextFromDropdown("card_year", cardyear, "selected card Year");
				QaRobot.PassValue("card_cvv", cardcvv, "Entered card CVV Number");

			}
		} else if (cardmode.equalsIgnoreCase("Debit Card")) {

			QaRobot.ClickOnElement("newchk_debit_card", "Clicked on debit card");
			if (type.equalsIgnoreCase("Master Card")) {

				QaRobot.ClickOnElement("newchk_debitmaster", "select master card type ");
				QaRobot.PassValue("newchk_dcard_number", cardno, "Entered Card Number");
				QaRobot.PassValue("newchk_dcard_name", cardname, "Entered Card Holder Name");
				QaRobot.selectTextFromDropdown("newchk_dcard_month", cardmonth, "selected card Month");
				QaRobot.selectTextFromDropdown("newchk_dcard_year", cardyear, "selected card Year");
				QaRobot.PassValue("newchk_dcard_cvv", cardcvv, "Entered card CVV Number");

			} else if (type.equalsIgnoreCase("visa")) {

				QaRobot.ClickOnElement("newchk_debitvisa", "select visa card type ");
				QaRobot.PassValue("newchk_dcard_number", cardno, "Entered Card Number");
				QaRobot.PassValue("newchk_dcard_name", cardname, "Entered Card Holder Name");
				QaRobot.selectTextFromDropdown("newchk_dcard_month", cardmonth, "selected card Month");
				QaRobot.selectTextFromDropdown("newchk_dcard_year", cardyear, "selected card Year");
				QaRobot.PassValue("newchk_dcard_cvv", cardcvv, "Entered card CVV Number");

			}

		}
	}

	public static void Newchekout_Billing(String cardmode, String btitle, String bfname, String blname, String bemailid,
			String baddress, String bcity, String bcityauto, String bstate, String bzipcode, String bcountry)
			throws Exception {

		if (cardmode.equalsIgnoreCase("Debit Card")) {
			Thread.sleep(500);
			// Select billing title
			// selectTextFromDropdown("new_chk_billing_title_debit", btitle,
			// "Entered Billing Title");

			// Billing fName
			// PassValue("new_chk_billing_fname_debit", bfname, "Entered Billing
			// Name");

			// Billing lName
			// PassValue("new_chk_billing_lname_debit", blname, "Entered Billing
			// LastName");

			// Billing Address
			// PassValue("new_chk_billing_email_debit", bemailid, "Entered
			// Billing Emailid");

			// Billing Address
			// PassValue("new_chk_billing_address_debit", baddress, "Entered
			// Billing Address");

			// billing city
			// listofautosuggestion(By.xpath("//div[@id='divCityDC']/p"), bcity,
			// bcityauto,
			// By.xpath("(//input[@id='txtBillingCity'])[2]"));

			// Select billing state
			QaRobot.selectTextFromDropdown("new_chk_billing_state_debit", bstate, "Entered billing state");

			// Billing zipcode
			// PassValue("new_chk_billing_zipcode_debit", bzipcode, "Entered
			// Billing zipcode");

			// Select billing country
			QaRobot.selectTextFromDropdown("new_chk_billing_country_debit", bcountry, "Slected billing Country");
		}

		else if (cardmode.equalsIgnoreCase("Credit Card")) {

			// Select billing title
			// selectTextFromDropdown("new_chk_billing_title_credit", btitle,
			// "Entered Billing Title");

			// Billing fName
			// PassValue("new_chk_billing_fname_credit", bfname, "Entered
			// Billing Name");

			// Billing lName
			// PassValue("new_chk_billing_lname_credit", blname, "Entered
			// Billing LastName");

			// Billing Address
			// PassValue("new_chk_billing_email_credit", bemailid, "Entered
			// Billing Emailid");

			// Billing Address
			// PassValue("new_chk_billing_address_credit", baddress, "Entered
			// Billing Address");

			// billing city
			// listofautosuggestion(By.xpath("//div[@id='divCityDC']/p"), bcity,
			// bcityauto,
			// By.xpath("(//input[@id='txtBillingCity'])[1]"));

			// Select billing state
			QaRobot.selectTextFromDropdown("new_chk_billing_state_credit", bstate, "Entered billing state");

			// Billing zipcode
			// PassValue("new_chk_billing_zipcode_credit", bzipcode, "Entered
			// Billing zipcode");

			// Select billing country
			QaRobot.selectTextFromDropdown("new_chk_billing_country_credit", bcountry, "Slected billing Country");

		}

	}

}
