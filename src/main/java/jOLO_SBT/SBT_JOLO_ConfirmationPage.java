package jOLO_SBT;

import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import utilities.QaBrowser;
import utilities.QaExtentReport;
import utilities.QaRobot;

public class SBT_JOLO_ConfirmationPage {

	public static void confirmpageCar(String CreatorName)
			throws Exception {
		String getT = QaBrowser.driver
				.findElement(By.xpath("//div[@id='ctl00_tdContent']/section/div[2]/div/div/div[1]/h2/span")).getText();
		String getTxt1[] = getT.split("-");
		String number = getTxt1[1];
		System.out.println(number);
		QaExtentReport.test.log(Status.INFO, "<b><i>Booking id is </i></b>" + number);
		String getT1 = QaBrowser.driver
				.findElement(By.xpath("//div[@id='ctl00_contentMain_flt_details']/div/div[1]/div[2]/p/span[1]")).getText();
		String getTxt2[] = getT1.split("&");
		String number1 = getTxt2[0];
		System.out.println(number1);
		Assert.assertEquals(number1, "Confirmed", "Booking Status");
		QaExtentReport.test.log(Status.INFO, "<b><i>Booking Status is </i></b>" + number1);
		WebElement getT2 = QaBrowser.driver
				.findElement(By.xpath("//div[@id='ctl00_contentMain_flt_details']/div/div[1]/div[2]/p/span[2]"));
		String getTxt4 = getT2.getText();
		String getTxt5[] = getTxt4.split(" ");
		String number2 = getTxt5[1];
		System.out.println(number2);
		QaExtentReport.test.log(Status.INFO, "<b><i>PNR Number is </i></b>" + number2);
		QaExtentReport.extentScreenshot("Confirm Page");
		QaRobot.mouseHover("//a[@id='ctl00_HeaderTop_aBookingMenu']",
				"//span[@id='ctl00_HeaderTop_lblBookingQueue']");
		QaExtentReport.extentScreenshot("CorporateDashboard Page");
		Thread.sleep(3000);
		QaRobot.PassValue("RefNo", number);
		QaRobot.ClickOnElement("SearchRefNo");
		QaRobot.ClickOnElement("RefBooking");
		QaExtentReport.extentScreenshot("Booking Card");
		String Creater = QaBrowser.driver.findElement(By.xpath("//span[@id='lblCreatedBy']")).getText();
		QaExtentReport.test.log(Status.INFO, "<b><i>Created By </i></b>" + Creater);
		Assert.assertTrue(CreatorName.equalsIgnoreCase(Creater), "Creater name is not Present");
		
//		if (CreatorName.equalsIgnoreCase(Creater)) {
//			QaExtentReport.test.log(Status.INFO, "<b><i>Creater is Correct  </i></b>" + CreatorName);
//		} else {
//			QaExtentReport.test.log(Status.FAIL, "<b><i>Creater is Different  </i></b>" + CreatorName);
//		}
	}

	public static void confirmpageFlightwithBookingQueue(String TravellerType, String adult, String child,
			String infant, String ModifySearch, String ChangeTravellers, String adultM, String childM, String infantM)
			throws Exception {
		String getT = QaBrowser.driver
				.findElement(By.xpath("//div[@id='ctl00_tdContent']/section/div[2]/div/div/div[1]/h2")).getText();
		String getTxt1[] = getT.split(":");
		String number = getTxt1[1];
		QaExtentReport.test.log(Status.INFO, "<b><i>Booking id is </i></b>" + number);

		String getTxt3[] = number.split("");
		String number1 = getTxt3[2] + getTxt3[3] + getTxt3[4] + getTxt3[5] + getTxt3[6] + getTxt3[7];

		WebElement getT1 = QaBrowser.driver
				.findElement(By.xpath("//div[@id='ctl00_contentMain_flt_details']/div/div[1]/div[3]/p/span[1]"));
		String getTxt2 = getT1.getText();
		Assert.assertEquals(getTxt2, "Confirmed", "Booking Status");
		QaExtentReport.test.log(Status.INFO, "<b><i>Booking Status is </i></b>" + getTxt2);

		WebElement getT2 = QaBrowser.driver
				.findElement(By.xpath("//div[@id='ctl00_contentMain_flt_details']/div/div[1]/div[3]/p/span[2]"));
		String getTxt4 = getT2.getText();
		String getTxt5[] = getTxt4.split(";");
		String number2 = getTxt5[0];
		QaExtentReport.test.log(Status.INFO, "<b><i>Confirming Status PNR Number is </i></b>" + number2);
		Thread.sleep(25000);
		QaExtentReport.extentScreenshot("Confirm Page");

		QaBrowser.driver.switchTo().defaultContent();

		QaRobot.switchframe("//frame[@name='login']");
		QaRobot.switchframe("//frame[@name='leftbar']");

		QaRobot.ClickOnElement("Bookings");

		QaRobot.ClickOnElement("BookingQueues");

		QaBrowser.driver.switchTo().parentFrame();

		QaRobot.switchframe("//frame[@name='main']");

		QaRobot.switchframe("//frame[@id='toolHeader']");

		QaRobot.ClickOnElement("CorporateQueue");

		QaBrowser.driver.switchTo().parentFrame();

		QaRobot.switchframe("//frame[@id='frm2']");

		QaRobot.ClickOnElement("BookingandRepriceQueue");
		Thread.sleep(3000);

		QaRobot.ClickOnElement("StatusAll");
		Thread.sleep(3000);

		QaRobot.ClickOnElement("AdditionalSearchOption");

		QaRobot.PassValue("BookingSearch", number1);
		Thread.sleep(30000);

		QaRobot.ClickOnElement("SearchBooking");
		QaExtentReport.extentScreenshot("BookAndQuote Page");

		QaRobot.ClickOnElement("BookandQuoteApprove");
		Thread.sleep(5000);

		String ParentWindow8 = QaBrowser.driver.getWindowHandle();
		Set<String> handles8 = QaBrowser.driver.getWindowHandles();
		for (String childWindow8 : handles8) {
			if (!childWindow8.equals(ParentWindow8))
				QaBrowser.driver.switchTo().window(childWindow8);
		}
		Thread.sleep(2000);
		QaRobot.PassValue("TextArea", "Ok");

		QaRobot.ClickOnElement("BookandQuoteFinalApprove");
		Thread.sleep(5000);

		QaBrowser.driver.switchTo().alert().accept();
		Thread.sleep(10000);

		QaBrowser.driver.switchTo().window(ParentWindow8);

		QaRobot.switchframe("//frame[@name='login']");
		QaRobot.switchframe("//frame[@name='main']");
		QaRobot.switchframe("//frame[@id='frm2']");

		QaRobot.ClickOnElement("BookandQuoteBook");
		Thread.sleep(15000);

		JavascriptExecutor mo = (JavascriptExecutor) QaBrowser.driver;
		mo.executeScript("window.scrollBy(0,400)", "");

		QaRobot.ClickOnElement("BAQFlightItinerary");
		Thread.sleep(3000);
		QaExtentReport.extentScreenshot("BookAndQuote Flight Itinerary");

		QaRobot.ClickOnElement("BAQFareBreakup");
		Thread.sleep(3000);
		QaExtentReport.extentScreenshot("BookAndQuote Flight Breakup");

		QaRobot.ClickOnElement("BAQFareRules");
		Thread.sleep(3000);
		QaExtentReport.extentScreenshot("BookAndQuote Flight Rules");

		QaRobot.ClickOnElement("BAQSelectItinerary");

		QaRobot.ClickOnElement("BAQSelectandProceed");
		Thread.sleep(8000);

		QaExtentReport.extentScreenshot("Checkout Page");

		JavascriptExecutor mo1 = (JavascriptExecutor) QaBrowser.driver;
		mo1.executeScript("window.scrollBy(0,300)", "");

		WebElement MoreDetails = QaBrowser.driver.findElement(By.xpath(
				"/html/body/form/div[3]/div[2]/div/section/div/div[2]/div[3]/div[1]/div[4]/div[1]/div[7]/div[3]/div[9]/ul/li[1]/a"));
		JavascriptExecutor js3 = (JavascriptExecutor) QaBrowser.driver;
		js3.executeScript("arguments[0].click()", MoreDetails);
		Thread.sleep(5000);
		QaExtentReport.extentScreenshot("MoreDetails");

		WebElement MoreDetailsClose = QaBrowser.driver.findElement(By.xpath("/html/body/div/div/div/a"));
		JavascriptExecutor js4 = (JavascriptExecutor) QaBrowser.driver;
		js4.executeScript("arguments[0].click()", MoreDetailsClose);
		Thread.sleep(5000);

		WebElement FareBreakup = QaBrowser.driver.findElement(By.xpath(
				"/html/body/form/div[3]/div[2]/div/section/div/div[2]/div[3]/div[1]/div[4]/div[1]/div[7]/div[3]/div[9]/ul/li[2]/a"));
		JavascriptExecutor js2 = (JavascriptExecutor) QaBrowser.driver;
		js2.executeScript("arguments[0].click()", FareBreakup);
		Thread.sleep(2000);

		WebElement CustomerCost = QaBrowser.driver.findElement(By.xpath("//ul[@id='DivINSfareBreakup']/li[1]/a"));
		JavascriptExecutor js5 = (JavascriptExecutor) QaBrowser.driver;
		js5.executeScript("arguments[0].click()", CustomerCost);
		Thread.sleep(3000);
		QaExtentReport.extentScreenshot("CustomerCost");

		WebElement CompanyCost = QaBrowser.driver.findElement(By.xpath("//ul[@id='DivINSfareBreakup']/li[2]/a"));
		JavascriptExecutor js6 = (JavascriptExecutor) QaBrowser.driver;
		js6.executeScript("arguments[0].click()", CompanyCost);
		Thread.sleep(3000);
		QaExtentReport.extentScreenshot("CompanyCost");

		WebElement FareBreakupClose = QaBrowser.driver
				.findElement(By.xpath("//div[@id='DivfarebrekupIN']/div/div/div[1]/button"));
		JavascriptExecutor js7 = (JavascriptExecutor) QaBrowser.driver;
		js7.executeScript("arguments[0].click()", FareBreakupClose);
		Thread.sleep(5000);

		QaRobot.ClickOnElement("TermsAndConditionF");

		QaRobot.ClickOnElement("FulfilmentF");
		Thread.sleep(12000);

//		DnataPaymentPage.individualForFlight();

//		confirmpageFlight(TravellerType, adult, child, infant, ModifySearch, ChangeTravellers, adultM, childM, infantM);
	}
}
