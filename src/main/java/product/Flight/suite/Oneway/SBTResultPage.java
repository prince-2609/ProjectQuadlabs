package product.Flight.suite.Oneway;

import static org.testng.Assert.fail;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;
import com.aventstack.extentreports.Status;
import Base.TestBase;
import utilities.Logger;
import utilities.QaBrowser;
import utilities.QaExtentReport;
import utilities.QaRobot;

public class SBTResultPage {

	// Trip Request
	public static void tripRequest(String index, String resultPrice, String policytype) throws Exception {
		// click on trip request
		QaBrowser.driver.findElement(By.xpath("(//span[contains(text(),'Trip Request')])[" + index + "]")).click();
		// click on send quote
		Thread.sleep(3000);
		QaRobot.ClickOnElement("send_quote");
//		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on send quote link</i></b>");

		// check In policy and out policy text
		if (policytype.equalsIgnoreCase("Out Of Policy")) {
			QaBrowser.driver.switchTo().alert().accept();
		}
		// wait for close button visibility on quotation page
//		QaRobot.explicitwaitvisible(50, By.xpath("//button[@id='btncancel']"));

		// get the total price of booking
//		String gettext = QaBrowser.driver.findElement(By.xpath("//span[@id='TotalForOnmailF']")).getText();
//		String[] getPrice = gettext.split(" ");
//		String total = getPrice[3];
//		QaExtentReport.test.log(Status.INFO, "Total price on Quotation window : " + total);

		// compare result page and quotation page price
//		QaRobot.CompareFareValue(resultPrice, total, " quotation page");
		// screenshot of quotation page
//		String screenShotPath = Logger.takeScreenshot(QaBrowser.driver, "D:\\Screenshot\\quotation.png");
//		QaExtentReport.test.log(Status.INFO, "Quotation page " + screenShotPath + "");
		// click on send quote button
		QaRobot.ClickOnElement("send_quoteonpage");
//		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on send button for quotation</i></b>");
		// check In policy and out policy text
		if (policytype.equalsIgnoreCase("Out Of Policy")) {
			QaBrowser.driver.switchTo().alert().accept();
		}
		// wait for visibility of close button on notification div
//		QaRobot.explicitwaitvisible(500,By.xpath("(//button[@class=\"btn btn-default\"])[4]"));
		// get message after sending quotation on mail
		String message = QaBrowser.driver.findElement(By.xpath("//div[@class='modal-body']/p")).getText();

		QaExtentReport.test.log(Status.INFO, "Message after sending quotation : " + message);
		// click on close button
		QaRobot.ClickOnElement("quote_close");
//		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on close</i></b>");

	}

	// Add to cart
	public static void addToCart(String index, String remarks, String resultPrice, String policytype) throws Exception {
		// click on add cart button
		QaBrowser.driver.findElement(By.xpath("(//span[contains(text(),'Add To Cart')])[" + index + "]")).click();

		// check In policy and out policy text
		if (policytype.equalsIgnoreCase("Out Of Policy")) {
			QaBrowser.driver.switchTo().alert().accept();
		}

		// wait for close button visibility
//		QaRobot.explicitwaitvisible(50, By.xpath("(//button[@class='btn btn-default'])[4]"));

		// check notification text after add to cart
		String message = QaBrowser.driver.findElement(By.xpath("//div[@class='modal-body']/p")).getText();

//		QaExtentReport.test.log(Status.INFO, "Notification after Add To Cart : " + message);
		// close the notification
		QaRobot.ClickOnElement("addToCart_close");
//		QaExtentReport.test.log(Status.INFO, "<b><i>Close Notification Div after getting message</i></b>");
		// click on Your Itineary button
		WebElement WebElement = QaBrowser.driver.findElement(By.xpath("//div[@class='cmn-box itinerary-mdf']/a"));
		JavascriptExecutor js = (JavascriptExecutor) QaBrowser.driver;
		js.executeScript("arguments[0].click();", WebElement);
		Thread.sleep(4000);
		QaExtentReport.extentScreenshot("Your Itinerary Page");
		Thread.sleep(2000);
		// wait visibility of send for approval button
//		QaRobot.explicitwaitvisible(100, By.xpath("(//a[@class='btn btn_blue_lg proceedcart btnTripRequest'])[1]"));
		// take the screenshot of add to cart page
//		String addToCart = Logger.takeScreenshot(QaBrowser.driver, "D:\\Screenshot\\addTocart.png");
//		QaExtentReport.test.log(Status.INFO, "Add To Cart  " + addToCart + "");
		// get the enquriy id
//		String enquiryId = QaBrowser.driver.findElement(By.xpath("//div[@class='contant']/span")).getText();
//		System.out.println("Enquiry id is " + enquiryId);
//		QaExtentReport.test.log(Status.INFO, "Enquiry ID is  " + enquiryId);
//		// get the add to cart fare
//		String addToCartFare = QaBrowser.driver.findElement(By.xpath("//span[@class='itine_total '] ")).getText();
//		System.out.println(addToCartFare);
//		QaExtentReport.extentScreenshot("Your Itinerary Page");
		// compare fare for add to cart and result page
//		QaRobot.CompareFareValue(resultPrice,addToCartFare,"Add to cart page");
		// Click on send for approval button
//		QaRobot.ClickOnElement("sendforApproval");
////		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on send for approval button</i></b>");
//		WebElement element = QaBrowser.driver.findElement(By.xpath("//select[@id='corcostcentre']"));
//		Select sel = new Select(element);
//		sel.selectByIndex(1);
//		Thread.sleep(2000);
//		// Pass tha remarks
//		QaRobot.PassValue("sendforApproval_remarks", remarks);
//		QaExtentReport.test.log(Status.INFO, "<b><i>Passed the remarks : </i></b>" + remarks);
//
////		WebElement element1 = QaBrowser.driver.findElement(By.xpath("//select[@id='corpReasonF']"));
////		Select sel1 = new Select(element1);
////		sel1.selectByIndex(1);
////		Thread.sleep(2000);
//		// clicked on send button
//		QaRobot.ClickOnElement("sendforApproval_send");
////		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on send button</i></b>");
//		// verify the details and accept alert
//		QaBrowser.driver.switchTo().alert().accept();
//		Thread.sleep(20000);
//
//		// wait till successful alert is present
////		QaRobot.explicitwaitalert(500);
//		// take screen shot
//		// String sendingApproval = Logger.takeScreenshot(QaBrowser.driver,
//		// "D:\\Screenshot\\sendingApproval.png");
//		// QaExtentReport.test.log(Status.INFO, "Add To Cart "+sendingApproval+"");
//		// get the text of alert and accept also
//		String alerttext = QaBrowser.driver.switchTo().alert().getText();
//		QaExtentReport.test.log(Status.INFO, "Alert message after sending approval : " + alerttext);
//		QaBrowser.driver.switchTo().alert().accept();
		// proceed booking after add to cart
		// QaRobot.ClickOnElement("proccedTocheckout", "Clicked on proceed to checkout
		// button");
	}

	public static void addToCartRT(String index, String remarks, String resultPrice, String policytype)
			throws Exception {
		// click on add cart button
		QaBrowser.driver.findElement(By.xpath("(//a[@id='Addcart'])")).click();

		// check In policy and out policy text
//		if (policytype.equalsIgnoreCase("Out Of Policy")) {
//			QaBrowser.driver.switchTo().alert().accept();
//		}

		// wait for close button visibility
//		QaRobot.explicitwaitvisible(50, By.xpath("(//button[@class='btn btn-default'])[4]"));

		// check notification text after add to cart
		String message = QaBrowser.driver.findElement(By.xpath("//div[@class='modal-body']/p")).getText();

//		QaExtentReport.test.log(Status.INFO, "Notification after Add To Cart : " + message);
		// close the notification
		QaRobot.ClickOnElement("addToCart_close");
//		QaExtentReport.test.log(Status.INFO, "<b><i>Close Notification Div after getting message</i></b>");

		// click on Your Itineary button
		WebElement WebElement = QaBrowser.driver.findElement(By.xpath("//span[@id='ODYourItinearyVal']"));
		JavascriptExecutor js = (JavascriptExecutor) QaBrowser.driver;
		js.executeScript("arguments[0].click();", WebElement);
		Thread.sleep(4000);
		QaExtentReport.extentScreenshot("Your Itinerary Page");
		Thread.sleep(2000);

		// wait visibility of send for approval button
//		QaRobot.explicitwaitvisible(100, By.xpath("(//a[@class='btn btn_blue_lg proceedcart btnTripRequest'])[1]"));
		// take the screenshot of add to cart page
//		String addToCart = Logger.takeScreenshot(QaBrowser.driver, "D:\\Screenshot\\addTocart.png");
//		QaExtentReport.test.log(Status.INFO, "Add To Cart  " + addToCart + "");
		// get the enquriy id
//		String enquiryId = QaBrowser.driver.findElement(By.xpath("//div[@class='contant']/span")).getText();
//		System.out.println("Enquiry id is " + enquiryId);
//		QaExtentReport.test.log(Status.INFO, "Enquiry ID is  " + enquiryId);
		// get the add to cart fare
//		String addToCartFare = QaBrowser.driver.findElement(By.xpath("//span[@class='itine_total '] ")).getText();
//		System.out.println(addToCartFare);
	}

	// hotel Trip Request
	public static void hotelTripRequest(String index, String policytype, String resultPagePrice) throws Exception {

		// click on trip request and index start from 1
		QaBrowser.driver.findElement(By.xpath("//span[@id='1H6390" + index + "']")).click();

		// check In policy and out policy text
		if (policytype.equalsIgnoreCase("Out Of Policy")) {

			QaBrowser.driver.switchTo().alert().accept();
		}

		// click on send quote
		QaRobot.ClickOnElement("send_quote");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on send quote link</i></b>");
		String ParentWindow = QaBrowser.driver.getWindowHandle();
		Set<String> handles = QaBrowser.driver.getWindowHandles();
		for (String childWindow : handles) {
			if (!childWindow.equals(ParentWindow))
				QaBrowser.driver.switchTo().window(childWindow);
		}
		// wait for close button visibility on quotation page
//			QaRobot.explicitwaitvisible(50, By.xpath("//button[@id='btncancel']"));

		// get the total price of booking
//			String gettext=QaBrowser.driver.findElement(By.xpath("//span[@id='TotalForOnmailF']")).getText();
//			String[] getPrice=gettext.split(" ");
//			String total=getPrice[3];
//			QaExtentReport.test.log(Status.INFO, "Total price on Quotation window : " +total);

		// compare result page and quotation page price
//			QaRobot.CompareFareValue(resultPagePrice, total, " quotation page");
		// screenshot of quotation page
		// String screenShotPath = Logger.takeScreenshot(QaBrowser.driver,
		// "D:\\Screenshot\\quotation.png");
		// QaExtentReport.test.log(Status.INFO, "Quotation page "+screenShotPath+"");
		// click on send quote button
		Thread.sleep(2000);
		QaRobot.ClickOnElement("sendHotelQuote");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on send button for quotation</i></b>");

		QaBrowser.driver.switchTo().window(ParentWindow);
		// wait for visibility of close button on notification div
//			QaRobot.explicitwaitvisible(500,By.xpath("//button[@class='btn btn-default']"));
		// get message after sending quotation on mail
//			String message=QaBrowser.driver.findElement(By.xpath("//div[@class='modal-body']/p")).getText();
//			
//			QaExtentReport.test.log(Status.INFO, "Message after sending quotation : " + message);

		// click on close button
		Thread.sleep(10000);

		QaRobot.ClickOnElement("closeHotelquote");
//		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on close</i></b>");
	}

	// Hotel Add to cart
	public static void hotelAddToCart(String index, String remarks, String policytype, String resultPagePrice)
			throws Exception {
		// click on add cart button that index start with 1
		QaBrowser.driver.findElement(By.xpath("//span[@id='C1H6390" + index + "']")).click();
		// check In policy and out policy text
		if (policytype.equalsIgnoreCase("Out Of Policy")) {

			QaBrowser.driver.switchTo().alert().accept();
		}
		// wait for close button visibility
//			QaRobot.explicitwaitvisible(80, By.xpath("//button[@class='btn btn-default']"));
		// check notification text after add to cart
		String message = QaBrowser.driver.findElement(By.xpath("//div[@class='modal-body']/p")).getText();

		QaExtentReport.test.log(Status.INFO, "Notification after Add To Cart : " + message);
		// close the notification
		QaRobot.ClickOnElement("closeHotelquote");
		QaExtentReport.test.log(Status.INFO, "<b><i>Close Notification Div after getting message</i></b>");
		WebElement WebElement = QaBrowser.driver
				.findElement(By.xpath("//div[@class='cmn-box itinerary-mdf hotel-mob-control']/a"));
		JavascriptExecutor js = (JavascriptExecutor) QaBrowser.driver;
		js.executeScript("arguments[0].click();", WebElement);
//			Thread.sleep(1000);
//			//click on Your Itineary button
//			QaRobot.ClickOnElement("hoteladdTocart_Itineary", "Click on Your Itineary button");
		// wait visibility of send for approval button
//			QaRobot.explicitwaitvisible(100, By.xpath("(//a[@class='btn btn_blue_lg proceedcart btnTripRequest'])[1]"));
		// take the screenshot of add to cart page
//		String addToCart = Logger.takeScreenshot(QaBrowser.driver, "D:\\Screenshot\\addTocart.png");
//		QaExtentReport.test.log(Status.INFO, "Add To Cart  " + addToCart + "");
		// get the enquriy id
		String enquiryId = QaBrowser.driver.findElement(By.xpath("//div[@class='contant']/span")).getText();
		System.out.println("Enquiry id is " + enquiryId);
		QaExtentReport.test.log(Status.INFO, "Enquiry ID is  " + enquiryId);
		// get the add to cart fare
		String addToCartFare = QaBrowser.driver.findElement(By.xpath("//span[@class='itine_total '] ")).getText();
		System.out.println(addToCartFare);
		// compare fare for add to cart and result page
//			QaRobot.CompareFareValue(resultPagePrice,addToCartFare,"Add to cart page");
		// Click on send for approval button
		QaRobot.ClickOnElement("sendforApproval");
//		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on send for approval button</i></b>");
		// Pass the remarks
		QaRobot.PassValue("sendforApproval_remarks", remarks);
		QaExtentReport.test.log(Status.INFO, "<b><i>Passed the remarks : </i></b>" + remarks);
		// select reason of booking
		WebElement element = QaBrowser.driver.findElement(By.xpath("//select[@id='corpReasonH']"));
		Select sel = new Select(element);
		sel.selectByIndex(1);

		// clicked on send button
		QaRobot.ClickOnElement("sendHotelapproval");
//		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on send button</i></b>");
		// verify the details and accept alert
		QaBrowser.driver.switchTo().alert().accept();
		Thread.sleep(20000);
		// wait till successful alert is present
//			QaRobot.explicitwaitalert(500);
//			// take screen shot
//			String sendingApproval = Logger.takeScreenshot(QaBrowser.driver, "D:\\Screenshot\\sendingApproval.png");
//			QaExtentReport.test.log(Status.INFO, "Add To Cart  "+sendingApproval+"");
		// get the text of alert and accept also
		String alerttext = QaBrowser.driver.switchTo().alert().getText();
		QaExtentReport.test.log(Status.INFO, "Alert message after sending approval : " + alerttext);
		QaBrowser.driver.switchTo().alert().accept();
		// proceed booking after add to cart
//			QaRobot.ClickOnElement("proccedTocheckout");
//			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on proceed to checkout button</i></b>");
	}

//************************************************Add to cart (Flight + Hotel) *****************************
//Hotel Add to cart
	public static void AddToCartFlightWithHotel(String index, String remarks, String policytype, String resultPagePrice,
			String origin, String forigin) throws Exception {
		// click on add cart button that index start with 1
		QaBrowser.driver.findElement(By.xpath("//span[@id='C1H6390" + index + "']")).click();
		// check In policy and out policy text
		if (policytype.equalsIgnoreCase("Out Of Policy")) {

			QaBrowser.driver.switchTo().alert().accept();
		}
		// wait for close button visibility
//		QaRobot.explicitwaitvisible(80, By.xpath("//button[@class='btn btn-default']"));
		// check notification text after add to cart
		String message = QaBrowser.driver.findElement(By.xpath("//div[@class='modal-body']/p")).getText();

		QaExtentReport.test.log(Status.INFO, "Notification after Add To Cart : " + message);
		// close the notification
		QaRobot.ClickOnElement("closeHotelquote");
		QaExtentReport.test.log(Status.INFO, "<b><i>Close Notification Div after getting message</i></b>");
		WebElement WebElement = QaBrowser.driver
				.findElement(By.xpath("//div[@class='cmn-box itinerary-mdf hotel-mob-control']/a"));
		JavascriptExecutor js = (JavascriptExecutor) QaBrowser.driver;
		js.executeScript("arguments[0].click();", WebElement);
//			Thread.sleep(1000);
//			//click on Your Itineary button
//			QaRobot.ClickOnElement("hoteladdTocart_Itineary", "Click on Your Itineary button");
		// wait visibility of send for approval button
//		QaRobot.explicitwaitvisible(100, By.xpath("(//a[@class='btn btn_blue_lg proceedcart btnTripRequest'])[1]"));
		// take the screenshot of add to cart page
		String addToCart = Logger.takeScreenshot(QaBrowser.driver, "D:\\Screenshot\\addTocart.png");
		QaExtentReport.test.log(Status.INFO, "Add To Cart  " + addToCart + "");
		// get the enquriy id
		String enquiryId = QaBrowser.driver.findElement(By.xpath("//div[@class='contant']/span")).getText();
		System.out.println("Enquiry id is " + enquiryId);
		QaExtentReport.test.log(Status.INFO, "Enquiry ID is  " + enquiryId);
		// get the add to cart fare
		String addToCartFare = QaBrowser.driver.findElement(By.xpath("//span[@class='itine_total '] ")).getText();
		// compare fare for add to cart and result page
		QaRobot.CompareFareValue(resultPagePrice, addToCartFare, "Add to cart page");

		// Add the Hotel
		QaRobot.ClickOnElement("addHotelInAddToCart");
		QaExtentReport.test.log(Status.INFO, "<b><i>Add Hotel with Flight</i></b>");
		// Wait till search button visibility
//		QaRobot.explicitwaitvisible(250, By.xpath("//input[@id='btnSearchHotel']"));
		// Select the hotel destination
		TestBase.listofautosuggestion(By.xpath("//div[@id='divHTCity']/p"), origin, forigin,
				By.xpath("//input[@id='txtHotelSearch']"));
		// check Hotel policy
		SearchDashboard.hotelPolicyCheck();
		// click on search button
		QaRobot.ClickOnElement("searchInAddToCart");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on search button for Hotel results</i></b>");

//		QaRobot.explicitwaitinvisible(250, By.xpath("div[@class='loadbar ld_hotel']"));
		// explicit wait till loader invisible
//		QaRobot.explicitwaitinvisible(600, By.xpath("//i[@class='htl-rslt-loader-img']"));
////
		// Click on send for approval button
		QaRobot.ClickOnElement("sendforApproval");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on send for approval button</i></b>");
		// Pass the remarks
		QaRobot.PassValue("sendforApproval_remarks", remarks);
		QaExtentReport.test.log(Status.INFO, "<b><i>Passed the remarks : </i></b>" + remarks);
		// select reason of booking
		WebElement element = QaBrowser.driver.findElement(By.xpath("//select[@id='corpReasonH']"));
		Select sel = new Select(element);
		sel.selectByIndex(1);

		// clicked on send button
		QaRobot.ClickOnElement("sendHotelapproval");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on send button</i></b>");
		// verify the details and accept alert
		QaBrowser.driver.switchTo().alert().accept();
		// wait till successful alert is present
//		QaRobot.explicitwaitalert(500);
		// take screen shot
//			String sendingApproval = Logger.takeScreenshot(QaBrowser.driver, "D:\\Screenshot\\sendingApproval.png");
//			QaExtentReport.test.log(Status.INFO, "Add To Cart  "+sendingApproval+"");
		// get the text of alert and accept also
		String alerttext = QaBrowser.driver.switchTo().alert().getText();
		QaExtentReport.test.log(Status.INFO, "Alert message after sending approval : " + alerttext);
		QaBrowser.driver.switchTo().alert().accept();
		// proceed booking after add to cart
		QaRobot.ClickOnElement("proccedTocheckout");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on proceed to checkout button</i></b>");
	}

	public static void searchHotelWithName(String hotelName) throws Exception {

		// pass the hotel name
		QaRobot.PassValue("searchHotelWithName", hotelName);
		QaExtentReport.test.log(Status.INFO, "<b><i>Passed the hotel Name</i></b>");
		// get the text of div
		String inputMessage = QaBrowser.driver.findElement(By.xpath("//div[@id='divHTCity']")).getText();
		if (inputMessage.equalsIgnoreCase("No Match Found")) {
			fail("Unable to proceed booking due to getting no hotel found");
		} else {
			QaBrowser.driver.findElement(By.xpath("(//div[@id='divHTCity']/p)[1]")).click();
		}
	}

	public static void searchHotelWithStarCategory(String star) throws Exception {
		// clear all star rating
		QaRobot.ClickOnElement("clearAllStar");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clear all star category</i></b>");
		int starcat = Integer.parseInt(star);
		// select the star category
		QaBrowser.driver.findElement(By.xpath("//input[@id='label_id" + (starcat) + "']")).click();

	}
}
