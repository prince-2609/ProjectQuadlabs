package jOLO_SBT;

import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import com.aventstack.extentreports.Status;
import utilities.QaBrowser;
import utilities.QaExtentReport;
import utilities.QaRobot;

public class SBT_JOLO_CheckoutPage {

	public static void checkoutForFlight(String CreatorName, String Server, String SearchType, String ProductType,
			String QuoteTitle, String QuoteRemark, String Checkoutpagestep, String FOP, String CardType,
			String CreditCardNumber, String CardHolderName, String CardExpiryDate) throws Exception {
		if (SearchType.equalsIgnoreCase("Individual")) {
			QaExtentReport.extentScreenshot("Checkout Page");
			QaRobot.scrollPage(400);
			if (ProductType.equalsIgnoreCase("Flight")) {
				QaRobot.selectIndexFromDropdown("AirResonCodeC", 1);
				Thread.sleep(10000);
				QaRobot.ClickOnElement("BillToBranchC");
			} else if (ProductType.equalsIgnoreCase("Flight+Hotel")) {
				if (Server.equalsIgnoreCase("Staging")) {
					QaRobot.selectIndexFromDropdown("AirResonCodeC", 1);
				}
				QaRobot.ClickOnElement("BillToBranchC");
			} else if (ProductType.equalsIgnoreCase("Flight+Car")) {
				if (Server.equalsIgnoreCase("Staging")) {
					QaRobot.selectIndexFromDropdown("HotelResonCodeC", 1);
				}
				QaRobot.ClickOnElement("BillToBranchC");
			} else if (ProductType.equalsIgnoreCase("Flight+Hotel+Car")
					|| ProductType.equalsIgnoreCase("Flight+Car+Hotel")) {
				if (Server.equalsIgnoreCase("Staging")) {
					QaRobot.selectIndexFromDropdown("AirResonCodeC", 1);
					QaRobot.selectIndexFromDropdown("HotelResonCodeC", 1);
				}
				QaRobot.ClickOnElement("BillToBranchC");
			}
			QaRobot.ClickOnElement("TermsAndConditionC");
			bookForFlight(CreatorName, ProductType, QuoteTitle, QuoteRemark, Checkoutpagestep, FOP, CardType,
					CreditCardNumber, CardHolderName, CardExpiryDate);
		} else if (SearchType.equalsIgnoreCase("Dependent")) {

		}
	}

	public static void checkoutForHotel(String CreatorName, String Server, String SearchType, String ProductType,
			String QuoteTitle, String QuoteRemark, String Checkoutpagestep, String FOP, String CardType,
			String CreditCardNumber, String CardHolderName, String CardExpiryDate) throws Exception {
		if (SearchType.equalsIgnoreCase("Individual")) {
			QaExtentReport.extentScreenshot("Checkout Page");
			QaRobot.scrollPage(400);
			if (ProductType.equalsIgnoreCase("Hotel")) {
//				QaRobot.selectIndexFromDropdown("AirResonCodeC", 1);
				QaRobot.ClickOnElement("BillToBranchC");
			} else if (ProductType.equalsIgnoreCase("Hotel+Flight")) {
				if (Server.equalsIgnoreCase("Staging")) {
					QaRobot.selectIndexFromDropdown("AirResonCodeC", 1);
				}
				QaRobot.ClickOnElement("BillToBranchC");
			} else if (ProductType.equalsIgnoreCase("Hotel+Car")) {
				QaRobot.selectTextByLocator("//select[@id='ctl00_contentMain_ddl_titleAdt_H']", "Mr");
				if (Server.equalsIgnoreCase("Staging")) {
					QaRobot.selectIndexFromDropdown("HotelResonCodeC", 1);
				}
				QaRobot.ClickOnElement("BillToBranchC");
			} else if (ProductType.equalsIgnoreCase("Hotel+Flight+Car")
					|| ProductType.equalsIgnoreCase("Hotel+Car+Flight")) {
				if (Server.equalsIgnoreCase("Staging")) {
					QaRobot.selectIndexFromDropdown("AirResonCodeC", 1);
					QaRobot.selectIndexFromDropdown("HotelResonCodeC", 1);
				}
				QaRobot.ClickOnElement("BillToBranchC");
			}
			QaRobot.ClickOnElement("TermsAndConditionC");
			bookForHotel(CreatorName, ProductType, QuoteTitle, QuoteRemark, Checkoutpagestep, FOP, CardType,
					CreditCardNumber, CardHolderName, CardExpiryDate);
		} else if (SearchType.equalsIgnoreCase("Dependent")) {

		}
	}

	public static void checkoutForCar(String CreatorName, String Server, String SearchType, String ProductType,
			String QuoteTitle, String QuoteRemark, String Checkoutpagestep, String FOP, String CardType,
			String CreditCardNumber, String CardHolderName, String CardExpiryDate) throws Exception {
		if (SearchType.equalsIgnoreCase("Individual")) {
			QaExtentReport.extentScreenshot("Checkout Page");
			QaRobot.scrollPage(400);
			if (ProductType.equalsIgnoreCase("Car")) {
				QaRobot.ClickOnElement("BillToBranchC");
			} else if (ProductType.equalsIgnoreCase("Car+Flight")) {
				if (Server.equalsIgnoreCase("Staging")) {
					QaRobot.selectIndexFromDropdown("AirResonCodeC", 1);
				}
				QaRobot.ClickOnElement("BillToBranchC");
			} else if (ProductType.equalsIgnoreCase("Car+Hotel")) {
				if (Server.equalsIgnoreCase("Staging")) {
					QaRobot.selectIndexFromDropdown("HotelResonCodeC", 1);
				}
				QaRobot.ClickOnElement("BillToBranchC");
			} else if (ProductType.equalsIgnoreCase("Car+Flight+Hotel")
					|| ProductType.equalsIgnoreCase("Car+Hotel+Flight")) {
				if (Server.equalsIgnoreCase("Staging")) {
					QaRobot.selectIndexFromDropdown("AirResonCodeC", 1);
					QaRobot.selectIndexFromDropdown("HotelResonCodeC", 1);
				}
				QaRobot.ClickOnElement("BillToBranchC");
			}
			QaRobot.ClickOnElement("TermsAndConditionC");
			bookForCar(CreatorName, ProductType, QuoteTitle, QuoteRemark, Checkoutpagestep, FOP, CardType,
					CreditCardNumber, CardHolderName, CardExpiryDate);
		} else if (SearchType.equalsIgnoreCase("Dependent")) {

		}
	}

	public static void bookForFlight(String CreatorName, String ProductType, String QuoteTitle, String QuoteRemark,
			String Checkoutpagestep, String FOP, String CardType, String CreditCardNumber, String CardHolderName,
			String CardExpiryDate) throws Exception {
		if (Checkoutpagestep.equalsIgnoreCase("Quote")) {
			QaRobot.ClickOnElement("QuoteF");
			Thread.sleep(4000);

			String ParentWindow6 = QaBrowser.driver.getWindowHandle();
			Set<String> handles6 = QaBrowser.driver.getWindowHandles();
			for (String childWindow6 : handles6) {
				if (!childWindow6.equals(ParentWindow6))
					QaBrowser.driver.switchTo().window(childWindow6);
			}

			QaRobot.switchframe("//iframe[@id='iframeQuoteAIR']");

			QaRobot.PassValue("QuotationTitle", QuoteTitle);
			QaExtentReport.extentScreenshot("Quotation");

			QaRobot.PassValue("RemarkTitle", QuoteRemark);
			QaExtentReport.test.log(Status.INFO, "<b><i>Pass Remark Title</i></b>");

			WebElement SendQuote = QaBrowser.driver.findElement(By.xpath("//a[@id='lnksendAIREnqFromCorp']"));
			JavascriptExecutor js1 = (JavascriptExecutor) QaBrowser.driver;
			js1.executeScript("arguments[0].click()", SendQuote);
			Thread.sleep(7000);

			String alertMessage = QaBrowser.driver.switchTo().alert().getText();
			System.out.println(alertMessage);
			String getTxt1[] = alertMessage.split(" ");
			String number = getTxt1[8];
			System.out.println(number);
			QaExtentReport.test.log(Status.INFO, "<b><i>Enquiry id is </i></b>" + number);
			QaBrowser.driver.switchTo().alert().accept();

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

			QaRobot.ClickOnElement("EnquiryQueue");
			Thread.sleep(3000);

			QaRobot.PassValue("EnterEnquiryId", number);

			QaRobot.ClickOnElement("SearchEnquiryId");
			Thread.sleep(3000);
			QaExtentReport.extentScreenshot("Search Enquiry Id");

			QaRobot.ClickOnElement("EnquiryView");
			Thread.sleep(5000);

			String ParentWindow7 = QaBrowser.driver.getWindowHandle();
			Set<String> handles7 = QaBrowser.driver.getWindowHandles();
			for (String childWindow7 : handles7) {
				if (!childWindow7.equals(ParentWindow7))
					QaBrowser.driver.switchTo().window(childWindow7);
			}

			QaExtentReport.extentScreenshot("Quotation View");

			QaBrowser.driver.close();
			Thread.sleep(5000);

			QaBrowser.driver.switchTo().window(ParentWindow7);

			QaRobot.switchframe("//frame[@name='login']");
			QaRobot.switchframe("//frame[@name='main']");
			QaRobot.switchframe("//frame[@id='frm2']");

			QaRobot.ClickOnElement("ApproveButton");
			Thread.sleep(15000);

			String ParentWindow8 = QaBrowser.driver.getWindowHandle();
			Set<String> handles8 = QaBrowser.driver.getWindowHandles();
			for (String childWindow8 : handles8) {
				if (!childWindow8.equals(ParentWindow8))
					QaBrowser.driver.switchTo().window(childWindow8);
			}
			Thread.sleep(3000);

			QaRobot.ClickOnElement("SelectItinerary");

			QaExtentReport.extentScreenshot("Itinerary View");

			JavascriptExecutor mo1 = (JavascriptExecutor) QaBrowser.driver;
			mo1.executeScript("window.scrollBy(0,500)", "");

			QaRobot.ClickOnElement("FinalApproveButton");

			QaRobot.PassValue("TextArea", "Ok");
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on Text Area</i></b>");

			QaRobot.ClickOnElement("OKButton");
			Thread.sleep(13000);
			QaBrowser.driver.switchTo().window(ParentWindow8);
			QaRobot.switchframe("//frame[@name='login']");
			QaRobot.switchframe("//frame[@name='main']");
			QaRobot.switchframe("//frame[@id='frm2']");

			QaRobot.ClickOnElement("FinalBookButton");
			Thread.sleep(13000);

			QaRobot.PassValue("DestinationPhoeF", "9863647257");

//			WebElement element = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_CorporateFDReasonDDL']"));
//			Select s = new Select(element);
//			s.selectByIndex(1);

			WebElement ele1 = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_CostCenterDDL']"));
			Select s11 = new Select(ele1);
			s11.selectByIndex(1);

			WebElement ele2 = QaBrowser.driver
					.findElement(By.xpath("//select[@id='ctl00_contentMain_CorporateDivisionDDL']"));
			Select s22 = new Select(ele2);
			s22.selectByIndex(1);

//			WebElement ele3 = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_dynamicdatacapture84']"));
//			Select s33 = new Select(ele3);
//			s33.selectByIndex(1);

			WebElement ele44 = QaBrowser.driver
					.findElement(By.xpath("//select[@id='ctl00_contentMain_dynamicdatacapture127']"));
			Select s44 = new Select(ele44);
			s44.selectByIndex(1);

			WebElement ele5 = QaBrowser.driver
					.findElement(By.xpath("//select[@id='ctl00_contentMain_dynamicdatacapture128']"));
			Select s55 = new Select(ele5);
			s55.selectByIndex(1);

			WebElement ele6 = QaBrowser.driver
					.findElement(By.xpath("//select[@id='ctl00_contentMain_dynamicdatacapture126']"));
			Select s66 = new Select(ele6);
			s66.selectByIndex(1);

			QaRobot.PassValue("BookerName", "Test");

			QaRobot.PassValue("TripApprover", "Test");

			QaRobot.PassValue("SuppplierCode", "Test");

			QaRobot.PassValue("OrderedBy", "Test");

			QaRobot.PassValue("TravellerEmail", "Test");

			QaRobot.PassValue("ArrangerEmail", "Test");

			QaExtentReport.extentScreenshot("Checkout page");

			QaRobot.ClickOnElement("TermsAndConditionF");

			QaRobot.ClickOnElement("FulfilmentF");
			Thread.sleep(3000);

//			DnataPaymentPage.individualForFlight();

//			DnataConfirmPage.confirmpageFlight(TravellerType,adult,child,infant,ModifySearch,ChangeTravellers,adultM,childM,infantM);
		} else if (Checkoutpagestep.equalsIgnoreCase("Fulfilment")) {
			QaRobot.ClickOnElement("FulfilmentJ");
			Thread.sleep(5000);
			QaRobot.alertAccept();
			SBT_JOLO_PaymentPage.cardPayment(ProductType, FOP, CardType, CreditCardNumber, CardHolderName,
					CardExpiryDate);
			SBT_JOLO_ConfirmationPage.confirmpageCar(CreatorName);
		}
	}

	public static void bookForHotel(String CreatorName, String ProductType, String QuoteTitle, String QuoteRemark,
			String Checkoutpagestep, String FOP, String CardType, String CreditCardNumber, String CardHolderName,
			String CardExpiryDate) throws Exception {
		if (Checkoutpagestep.equalsIgnoreCase("Quote")) {
			QaRobot.ClickOnElement("QuoteF");
			Thread.sleep(4000);

			String ParentWindow6 = QaBrowser.driver.getWindowHandle();
			Set<String> handles6 = QaBrowser.driver.getWindowHandles();
			for (String childWindow6 : handles6) {
				if (!childWindow6.equals(ParentWindow6))
					QaBrowser.driver.switchTo().window(childWindow6);
			}

			QaRobot.switchframe("//iframe[@id='iframeQuoteAIR']");

			QaRobot.PassValue("QuotationTitle", QuoteTitle);
			QaExtentReport.extentScreenshot("Quotation");

			QaRobot.PassValue("RemarkTitle", QuoteRemark);
			QaExtentReport.test.log(Status.INFO, "<b><i>Pass Remark Title</i></b>");

			WebElement SendQuote = QaBrowser.driver.findElement(By.xpath("//a[@id='lnksendAIREnqFromCorp']"));
			JavascriptExecutor js1 = (JavascriptExecutor) QaBrowser.driver;
			js1.executeScript("arguments[0].click()", SendQuote);
			Thread.sleep(7000);

			String alertMessage = QaBrowser.driver.switchTo().alert().getText();
			System.out.println(alertMessage);
			String getTxt1[] = alertMessage.split(" ");
			String number = getTxt1[8];
			System.out.println(number);
			QaExtentReport.test.log(Status.INFO, "<b><i>Enquiry id is </i></b>" + number);
			QaBrowser.driver.switchTo().alert().accept();

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

			QaRobot.ClickOnElement("EnquiryQueue");
			Thread.sleep(3000);

			QaRobot.PassValue("EnterEnquiryId", number);

			QaRobot.ClickOnElement("SearchEnquiryId");
			Thread.sleep(3000);
			QaExtentReport.extentScreenshot("Search Enquiry Id");

			QaRobot.ClickOnElement("EnquiryView");
			Thread.sleep(5000);

			String ParentWindow7 = QaBrowser.driver.getWindowHandle();
			Set<String> handles7 = QaBrowser.driver.getWindowHandles();
			for (String childWindow7 : handles7) {
				if (!childWindow7.equals(ParentWindow7))
					QaBrowser.driver.switchTo().window(childWindow7);
			}

			QaExtentReport.extentScreenshot("Quotation View");

			QaBrowser.driver.close();
			Thread.sleep(5000);

			QaBrowser.driver.switchTo().window(ParentWindow7);

			QaRobot.switchframe("//frame[@name='login']");
			QaRobot.switchframe("//frame[@name='main']");
			QaRobot.switchframe("//frame[@id='frm2']");

			QaRobot.ClickOnElement("ApproveButton");
			Thread.sleep(15000);

			String ParentWindow8 = QaBrowser.driver.getWindowHandle();
			Set<String> handles8 = QaBrowser.driver.getWindowHandles();
			for (String childWindow8 : handles8) {
				if (!childWindow8.equals(ParentWindow8))
					QaBrowser.driver.switchTo().window(childWindow8);
			}
			Thread.sleep(3000);

			QaRobot.ClickOnElement("SelectItinerary");

			QaExtentReport.extentScreenshot("Itinerary View");

			JavascriptExecutor mo1 = (JavascriptExecutor) QaBrowser.driver;
			mo1.executeScript("window.scrollBy(0,500)", "");

			QaRobot.ClickOnElement("FinalApproveButton");

			QaRobot.PassValue("TextArea", "Ok");
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on Text Area</i></b>");

			QaRobot.ClickOnElement("OKButton");
			Thread.sleep(13000);
			QaBrowser.driver.switchTo().window(ParentWindow8);
			QaRobot.switchframe("//frame[@name='login']");
			QaRobot.switchframe("//frame[@name='main']");
			QaRobot.switchframe("//frame[@id='frm2']");

			QaRobot.ClickOnElement("FinalBookButton");
			Thread.sleep(13000);

			QaRobot.PassValue("DestinationPhoeF", "9863647257");

//			WebElement element = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_CorporateFDReasonDDL']"));
//			Select s = new Select(element);
//			s.selectByIndex(1);

			WebElement ele1 = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_CostCenterDDL']"));
			Select s11 = new Select(ele1);
			s11.selectByIndex(1);

			WebElement ele2 = QaBrowser.driver
					.findElement(By.xpath("//select[@id='ctl00_contentMain_CorporateDivisionDDL']"));
			Select s22 = new Select(ele2);
			s22.selectByIndex(1);

//			WebElement ele3 = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_dynamicdatacapture84']"));
//			Select s33 = new Select(ele3);
//			s33.selectByIndex(1);

			WebElement ele44 = QaBrowser.driver
					.findElement(By.xpath("//select[@id='ctl00_contentMain_dynamicdatacapture127']"));
			Select s44 = new Select(ele44);
			s44.selectByIndex(1);

			WebElement ele5 = QaBrowser.driver
					.findElement(By.xpath("//select[@id='ctl00_contentMain_dynamicdatacapture128']"));
			Select s55 = new Select(ele5);
			s55.selectByIndex(1);

			WebElement ele6 = QaBrowser.driver
					.findElement(By.xpath("//select[@id='ctl00_contentMain_dynamicdatacapture126']"));
			Select s66 = new Select(ele6);
			s66.selectByIndex(1);

			QaRobot.PassValue("BookerName", "Test");

			QaRobot.PassValue("TripApprover", "Test");

			QaRobot.PassValue("SuppplierCode", "Test");

			QaRobot.PassValue("OrderedBy", "Test");

			QaRobot.PassValue("TravellerEmail", "Test");

			QaRobot.PassValue("ArrangerEmail", "Test");

			QaExtentReport.extentScreenshot("Checkout page");

			QaRobot.ClickOnElement("TermsAndConditionF");

			QaRobot.ClickOnElement("FulfilmentF");
			Thread.sleep(3000);

//			DnataPaymentPage.individualForFlight();

//			DnataConfirmPage.confirmpageFlight(TravellerType,adult,child,infant,ModifySearch,ChangeTravellers,adultM,childM,infantM);
		} else if (Checkoutpagestep.equalsIgnoreCase("Fulfilment")) {
			QaRobot.ClickOnElement("FulfilmentJ");
			Thread.sleep(3000);
			if (ProductType.equalsIgnoreCase("Hotel") || ProductType.equalsIgnoreCase("Hotel+Car")) {
			} else {
				QaRobot.alertAccept();
			}
			SBT_JOLO_PaymentPage.cardPayment(ProductType, FOP, CardType, CreditCardNumber, CardHolderName,
					CardExpiryDate);
			SBT_JOLO_ConfirmationPage.confirmpageCar(CreatorName);
		}
	}

	public static void bookForCar(String CreatorName, String ProductType, String QuoteTitle, String QuoteRemark,
			String Checkoutpagestep, String FOP, String CardType, String CreditCardNumber, String CardHolderName,
			String CardExpiryDate) throws Exception {
		if (Checkoutpagestep.equalsIgnoreCase("Quote")) {
			QaRobot.ClickOnElement("QuoteF");
			Thread.sleep(4000);

			String ParentWindow6 = QaBrowser.driver.getWindowHandle();
			Set<String> handles6 = QaBrowser.driver.getWindowHandles();
			for (String childWindow6 : handles6) {
				if (!childWindow6.equals(ParentWindow6))
					QaBrowser.driver.switchTo().window(childWindow6);
			}

			QaRobot.switchframe("//iframe[@id='iframeQuoteAIR']");

			QaRobot.PassValue("QuotationTitle", QuoteTitle);
			QaExtentReport.extentScreenshot("Quotation");

			QaRobot.PassValue("RemarkTitle", QuoteRemark);
			QaExtentReport.test.log(Status.INFO, "<b><i>Pass Remark Title</i></b>");

			WebElement SendQuote = QaBrowser.driver.findElement(By.xpath("//a[@id='lnksendAIREnqFromCorp']"));
			JavascriptExecutor js1 = (JavascriptExecutor) QaBrowser.driver;
			js1.executeScript("arguments[0].click()", SendQuote);
			Thread.sleep(7000);

			String alertMessage = QaBrowser.driver.switchTo().alert().getText();
			System.out.println(alertMessage);
			String getTxt1[] = alertMessage.split(" ");
			String number = getTxt1[8];
			System.out.println(number);
			QaExtentReport.test.log(Status.INFO, "<b><i>Enquiry id is </i></b>" + number);
			QaBrowser.driver.switchTo().alert().accept();

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

			QaRobot.ClickOnElement("EnquiryQueue");
			Thread.sleep(3000);

			QaRobot.PassValue("EnterEnquiryId", number);

			QaRobot.ClickOnElement("SearchEnquiryId");
			Thread.sleep(3000);
			QaExtentReport.extentScreenshot("Search Enquiry Id");

			QaRobot.ClickOnElement("EnquiryView");
			Thread.sleep(5000);

			String ParentWindow7 = QaBrowser.driver.getWindowHandle();
			Set<String> handles7 = QaBrowser.driver.getWindowHandles();
			for (String childWindow7 : handles7) {
				if (!childWindow7.equals(ParentWindow7))
					QaBrowser.driver.switchTo().window(childWindow7);
			}

			QaExtentReport.extentScreenshot("Quotation View");

			QaBrowser.driver.close();
			Thread.sleep(5000);

			QaBrowser.driver.switchTo().window(ParentWindow7);

			QaRobot.switchframe("//frame[@name='login']");
			QaRobot.switchframe("//frame[@name='main']");
			QaRobot.switchframe("//frame[@id='frm2']");

			QaRobot.ClickOnElement("ApproveButton");
			Thread.sleep(15000);

			String ParentWindow8 = QaBrowser.driver.getWindowHandle();
			Set<String> handles8 = QaBrowser.driver.getWindowHandles();
			for (String childWindow8 : handles8) {
				if (!childWindow8.equals(ParentWindow8))
					QaBrowser.driver.switchTo().window(childWindow8);
			}
			Thread.sleep(3000);

			QaRobot.ClickOnElement("SelectItinerary");

			QaExtentReport.extentScreenshot("Itinerary View");

			JavascriptExecutor mo1 = (JavascriptExecutor) QaBrowser.driver;
			mo1.executeScript("window.scrollBy(0,500)", "");

			QaRobot.ClickOnElement("FinalApproveButton");

			QaRobot.PassValue("TextArea", "Ok");
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on Text Area</i></b>");

			QaRobot.ClickOnElement("OKButton");
			Thread.sleep(13000);
			QaBrowser.driver.switchTo().window(ParentWindow8);
			QaRobot.switchframe("//frame[@name='login']");
			QaRobot.switchframe("//frame[@name='main']");
			QaRobot.switchframe("//frame[@id='frm2']");

			QaRobot.ClickOnElement("FinalBookButton");
//			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Final Book Button</i></b>");
			Thread.sleep(13000);

			QaRobot.PassValue("DestinationPhoeF", "9863647257");

//			WebElement element = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_CorporateFDReasonDDL']"));
//			Select s = new Select(element);
//			s.selectByIndex(1);

			WebElement ele1 = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_CostCenterDDL']"));
			Select s11 = new Select(ele1);
			s11.selectByIndex(1);

			WebElement ele2 = QaBrowser.driver
					.findElement(By.xpath("//select[@id='ctl00_contentMain_CorporateDivisionDDL']"));
			Select s22 = new Select(ele2);
			s22.selectByIndex(1);

//			WebElement ele3 = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_dynamicdatacapture84']"));
//			Select s33 = new Select(ele3);
//			s33.selectByIndex(1);

			WebElement ele44 = QaBrowser.driver
					.findElement(By.xpath("//select[@id='ctl00_contentMain_dynamicdatacapture127']"));
			Select s44 = new Select(ele44);
			s44.selectByIndex(1);

			WebElement ele5 = QaBrowser.driver
					.findElement(By.xpath("//select[@id='ctl00_contentMain_dynamicdatacapture128']"));
			Select s55 = new Select(ele5);
			s55.selectByIndex(1);

			WebElement ele6 = QaBrowser.driver
					.findElement(By.xpath("//select[@id='ctl00_contentMain_dynamicdatacapture126']"));
			Select s66 = new Select(ele6);
			s66.selectByIndex(1);

			QaRobot.PassValue("BookerName", "Test");

			QaRobot.PassValue("TripApprover", "Test");

			QaRobot.PassValue("SuppplierCode", "Test");

			QaRobot.PassValue("OrderedBy", "Test");

			QaRobot.PassValue("TravellerEmail", "Test");

			QaRobot.PassValue("ArrangerEmail", "Test");

			QaExtentReport.extentScreenshot("Checkout page");

			QaRobot.ClickOnElement("TermsAndConditionF");

			QaRobot.ClickOnElement("FulfilmentF");
			Thread.sleep(3000);

//			DnataPaymentPage.individualForFlight();
//			DnataConfirmPage.confirmpageFlight(TravellerType,adult,child,infant,ModifySearch,ChangeTravellers,adultM,childM,infantM);
		} else if (Checkoutpagestep.equalsIgnoreCase("Fulfilment")) {
			QaRobot.ClickOnElement("FulfilmentC");
			Thread.sleep(3000);
			if (ProductType.equalsIgnoreCase("Car") || ProductType.equalsIgnoreCase("Car+Hotel")) {
			} else {
				QaRobot.alertAccept();
			}
			SBT_JOLO_PaymentPage.cardPayment(ProductType, FOP, CardType, CreditCardNumber, CardHolderName,
					CardExpiryDate);
			SBT_JOLO_ConfirmationPage.confirmpageCar(CreatorName);
		}
	}

	public static void bookForFlightDependent(String TravellerType, String TripType, String adult, String child,
			String infant, String ModifySearch, String ChangeTravellers, String adultM, String childM, String infantM,
			String QuoteTitle, String QuoteRemark, String Checkoutpagestep) throws Exception {
		if (Checkoutpagestep.equalsIgnoreCase("Quote")) {
			QaRobot.ClickOnElement("QuoteF");
//			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Quote Button</i></b>");
			Thread.sleep(4000);

			String ParentWindow6 = QaBrowser.driver.getWindowHandle();
			Set<String> handles6 = QaBrowser.driver.getWindowHandles();
			for (String childWindow6 : handles6) {
				if (!childWindow6.equals(ParentWindow6))
					QaBrowser.driver.switchTo().window(childWindow6);
			}

			QaRobot.switchframe("//iframe[@id='iframeQuoteAIR']");

			QaRobot.PassValue("QuotationTitle", QuoteTitle);
//			QaExtentReport.test.log(Status.INFO, "<b><i>Pass Quotation Title</i></b>");
			QaExtentReport.extentScreenshot("Quotation");

			QaRobot.PassValue("RemarkTitle", QuoteRemark);
			QaExtentReport.test.log(Status.INFO, "<b><i>Pass Remark Title</i></b>");

			WebElement SendQuote = QaBrowser.driver.findElement(By.xpath("//a[@id='lnksendAIREnqFromCorp']"));
			JavascriptExecutor js1 = (JavascriptExecutor) QaBrowser.driver;
			js1.executeScript("arguments[0].click()", SendQuote);
//			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Send Quote</i></b>");
			Thread.sleep(7000);

			String alertMessage = QaBrowser.driver.switchTo().alert().getText();
			System.out.println(alertMessage);
			String getTxt1[] = alertMessage.split(" ");
			String number = getTxt1[8];
			System.out.println(number);
			QaExtentReport.test.log(Status.INFO, "<b><i>Enquiry id is </i></b>" + number);
			QaBrowser.driver.switchTo().alert().accept();

			QaBrowser.driver.switchTo().defaultContent();

			QaRobot.switchframe("//frame[@name='login']");
			QaRobot.switchframe("//frame[@name='leftbar']");

			QaRobot.ClickOnElement("Bookings");
//			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Bookings</i></b>");

			QaRobot.ClickOnElement("BookingQueues");
//			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Booking Queues</i></b>");

			QaBrowser.driver.switchTo().parentFrame();

			QaRobot.switchframe("//frame[@name='main']");

			QaRobot.switchframe("//frame[@id='toolHeader']");

			QaRobot.ClickOnElement("CorporateQueue");

			QaBrowser.driver.switchTo().parentFrame();

			QaRobot.switchframe("//frame[@id='frm2']");

			QaRobot.ClickOnElement("EnquiryQueue");
			Thread.sleep(3000);

			QaRobot.PassValue("EnterEnquiryId", number);
//			QaExtentReport.test.log(Status.INFO,"<b><i>Enter Enquiry Id</i></b>");

			QaRobot.ClickOnElement("SearchEnquiryId");
//			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Search Enquiry Id </i></b>");
			Thread.sleep(3000);
			QaExtentReport.extentScreenshot("Search Enquiry Id");

			QaRobot.ClickOnElement("EnquiryView");
//			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Enquiry View Button</i></b>");
			Thread.sleep(5000);

			String ParentWindow7 = QaBrowser.driver.getWindowHandle();
			Set<String> handles7 = QaBrowser.driver.getWindowHandles();
			for (String childWindow7 : handles7) {
				if (!childWindow7.equals(ParentWindow7))
					QaBrowser.driver.switchTo().window(childWindow7);
			}

			QaExtentReport.extentScreenshot("Quotation View");

			QaBrowser.driver.close();

			QaBrowser.driver.switchTo().window(ParentWindow7);

			QaRobot.switchframe("//frame[@name='login']");
			QaRobot.switchframe("//frame[@name='main']");
			QaRobot.switchframe("//frame[@id='frm2']");

			QaRobot.ClickOnElement("ApproveButton");
//			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Approve Button</i></b>");
			Thread.sleep(15000);

			String ParentWindow8 = QaBrowser.driver.getWindowHandle();
			Set<String> handles8 = QaBrowser.driver.getWindowHandles();
			for (String childWindow8 : handles8) {
				if (!childWindow8.equals(ParentWindow8))
					QaBrowser.driver.switchTo().window(childWindow8);
			}
			Thread.sleep(2000);
			QaRobot.ClickOnElement("SelectItinerary");
//			QaExtentReport.test.log(Status.INFO,"<b><i>Select Itinerary</i></b>");

			QaExtentReport.extentScreenshot("Itinerary View");

			JavascriptExecutor mo1 = (JavascriptExecutor) QaBrowser.driver;
			mo1.executeScript("window.scrollBy(0,500)", "");

			QaRobot.ClickOnElement("FinalApproveButton");
//			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Final Approve Button</i></b>");

			QaRobot.PassValue("TextArea", "Ok");
//			QaExtentReport.test.log(Status.INFO,"<b><i>Click on Text Area</i></b>");

			QaRobot.ClickOnElement("OKButton");
//			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on OK Button</i></b>");
			Thread.sleep(13000);
			QaBrowser.driver.switchTo().window(ParentWindow8);
			QaRobot.switchframe("//frame[@name='login']");
			QaRobot.switchframe("//frame[@name='main']");
			QaRobot.switchframe("//frame[@id='frm2']");

			QaRobot.ClickOnElement("FinalBookButton");
//			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Final Book Button</i></b>");
			Thread.sleep(5000);

			String ParentWindow9 = QaBrowser.driver.getWindowHandle();
			Set<String> handles9 = QaBrowser.driver.getWindowHandles();
			for (String childWindow9 : handles9) {
				if (!childWindow9.equals(ParentWindow9))
					QaBrowser.driver.switchTo().window(childWindow9);
			}
			QaRobot.ClickOnElement("EnquiryProcced");
			Thread.sleep(30000);
			QaBrowser.driver.switchTo().window(ParentWindow9);
			QaRobot.switchframe("//frame[@name='login']");
			QaRobot.switchframe("//frame[@name='main']");
			QaRobot.switchframe("//frame[@id='frm2']");

//			if(ModifySearch.equalsIgnoreCase("No"))
//			{
			if (TripType.equalsIgnoreCase("OneWay")) {
				if (QaBrowser.driver
						.findElement(By.xpath(
								"//div[contains(text(),'                            The fare that you have selected "
										+ "is no longer available. Please choose from below options to continue')]"))
						.isDisplayed()) {
//					if(TripType.equalsIgnoreCase("OneWay"))
//					{
					List<WebElement> listOfAirline = QaBrowser.driver.findElements(By.xpath(
							"/html/body/div[1]/div[1]/div/section/div[2]/div[2]/div/div[1]/div/div[3]/div[10]/div[2]/div/ul/li/label/span"));

					for (WebElement autoAirline : listOfAirline) {
						if (autoAirline.getText().equalsIgnoreCase("GULF AIR")) {
							autoAirline.click();
							break;
						} else {

						}
					}

					JavascriptExecutor mo2 = (JavascriptExecutor) QaBrowser.driver;
					mo2.executeScript("window.scrollBy(0,-300)", "");

					QaRobot.ClickOnElement("BookNowF");
//						QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Book Now</i></b>");
					Thread.sleep(8000);
				}
			}
//			}
//			else if(ModifySearch.equalsIgnoreCase("Yes"))
//			{
//				if (QaBrowser.driver.findElement(By.xpath("//div[contains(text(),'                            The fare that you have selected "
//						+ "is no longer available. Please choose from below options to continue')]")).isDisplayed()) 
//				{
////				if(TripType.equalsIgnoreCase("OneWay"))
////				{
//					List<WebElement> listOfAirline = QaBrowser.driver.findElements(By.xpath("/html/body/div[1]/div[1]/div/section/div[2]/div[2]/div/div[1]/div/div[3]/div[10]/div[2]/div/ul/li/label/span"));
//					
//					for (WebElement autoAirline : listOfAirline) 
//					  {
//						if (autoAirline.getText().equalsIgnoreCase("GULF AIR")) 
//						{
//							autoAirline.click();
//							break;
//						} 
//						else 
//						{
//							
//						}
//					  }
//					
//					JavascriptExecutor mo2 = (JavascriptExecutor) QaBrowser.driver;
//					mo2.executeScript("window.scrollBy(0,-300)", "");
//					
//					QaRobot.ClickOnElement("BookNowF");
//					QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Book Now</i></b>");
//					Thread.sleep(8000);
//				}
//			}

			QaRobot.PassValue("DestinationPhoeF", "9863647257");

			int inf = Integer.parseInt(infant);
			for (int i = 1; i <= inf; i++) {
				WebElement webelement = QaBrowser.driver
						.findElement(By.xpath("(//select[@id='ctl00_contentMain_ddl_travell_with'])[" + i + "]"));
				Select sel = new Select(webelement);
				sel.selectByIndex(i);
			}

//			WebElement element = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_CorporateFDReasonDDL']"));
//			Select s = new Select(element);
//			s.selectByIndex(1);

			WebElement ele1 = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_CostCenterDDL']"));
			Select s11 = new Select(ele1);
			s11.selectByIndex(1);

			WebElement ele2 = QaBrowser.driver
					.findElement(By.xpath("//select[@id='ctl00_contentMain_CorporateDivisionDDL']"));
			Select s22 = new Select(ele2);
			s22.selectByIndex(1);

//			WebElement ele3 = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_dynamicdatacapture84']"));
//			Select s33 = new Select(ele3);
//			s33.selectByIndex(1);

			WebElement ele44 = QaBrowser.driver
					.findElement(By.xpath("//select[@id='ctl00_contentMain_dynamicdatacapture127']"));
			Select s44 = new Select(ele44);
			s44.selectByIndex(1);

			WebElement ele5 = QaBrowser.driver
					.findElement(By.xpath("//select[@id='ctl00_contentMain_dynamicdatacapture128']"));
			Select s55 = new Select(ele5);
			s55.selectByIndex(1);

			WebElement ele6 = QaBrowser.driver
					.findElement(By.xpath("//select[@id='ctl00_contentMain_dynamicdatacapture126']"));
			Select s66 = new Select(ele6);
			s66.selectByIndex(1);

			QaRobot.PassValue("BookerName", "Test");

			QaRobot.PassValue("TripApprover", "Test");

			QaRobot.PassValue("SuppplierCode", "Test");

			QaRobot.PassValue("OrderedBy", "Test");

			QaRobot.PassValue("TravellerEmail", "Test");

			QaRobot.PassValue("ArrangerEmail", "Test");

			QaExtentReport.extentScreenshot("Checkout page");

			QaRobot.ClickOnElement("TermsAndConditionF");

			QaRobot.ClickOnElement("FulfilmentF");
//			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on FulfilmentF Button</i></b>");
			Thread.sleep(3000);

//			DnataPaymentPage.individualForFlight();

//			DnataConfirmPage.confirmpageFlight(TravellerType,adult,child,infant,ModifySearch,ChangeTravellers,adultM,childM,infantM);
		} else if (Checkoutpagestep.equalsIgnoreCase("BookAndQuote")) {
			QaRobot.PassValue("DestinationPhoeF", "9863647257");

			int inf = Integer.parseInt(infant);
			for (int i = 1; i <= inf; i++) {
				WebElement webelement = QaBrowser.driver
						.findElement(By.xpath("(//select[@id='ctl00_contentMain_ddl_travell_with'])[" + i + "]"));
				Select sel = new Select(webelement);
				sel.selectByIndex(i);
			}
//			WebElement element = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_CorporateFDReasonDDL']"));
//			Select s = new Select(element);
//			s.selectByIndex(1);

			WebElement ele1 = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_CostCenterDDL']"));
			Select s11 = new Select(ele1);
			s11.selectByIndex(1);

			WebElement ele2 = QaBrowser.driver
					.findElement(By.xpath("//select[@id='ctl00_contentMain_CorporateDivisionDDL']"));
			Select s22 = new Select(ele2);
			s22.selectByIndex(1);

//			WebElement ele3 = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_dynamicdatacapture84']"));
//			Select s33 = new Select(ele3);
//			s33.selectByIndex(1);

			WebElement ele44 = QaBrowser.driver
					.findElement(By.xpath("//select[@id='ctl00_contentMain_dynamicdatacapture127']"));
			Select s44 = new Select(ele44);
			s44.selectByIndex(1);

			WebElement ele5 = QaBrowser.driver
					.findElement(By.xpath("//select[@id='ctl00_contentMain_dynamicdatacapture128']"));
			Select s55 = new Select(ele5);
			s55.selectByIndex(1);

			WebElement ele6 = QaBrowser.driver
					.findElement(By.xpath("//select[@id='ctl00_contentMain_dynamicdatacapture126']"));
			Select s66 = new Select(ele6);
			s66.selectByIndex(1);

			QaRobot.PassValue("BookerName", "Test");

			QaRobot.PassValue("TripApprover", "Test");

			QaRobot.PassValue("SuppplierCode", "Test");

			QaRobot.PassValue("OrderedBy", "Test");

			QaRobot.PassValue("TravellerEmail", "Test");

			QaRobot.PassValue("ArrangerEmail", "Test");

			QaExtentReport.extentScreenshot("Checkout page");

			QaRobot.ClickOnElement("TermsAndConditionF");
			QaRobot.ClickOnElement("BookAndQuoteF");
//			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on BookAndQuote Button</i></b>");
			Thread.sleep(8000);

//			DnataConfirmPage.confirmpageFlightwithBookingQueue(TravellerType,adult,child,infant,ModifySearch,ChangeTravellers,adultM,childM,infantM);
		} else if (Checkoutpagestep.equalsIgnoreCase("Fulfilment")) {
			QaRobot.PassValue("DestinationPhoeF", "9863647257");

			int inf = Integer.parseInt(infant);
			for (int i = 1; i <= inf; i++) {
				WebElement webelement = QaBrowser.driver
						.findElement(By.xpath("(//select[@id='ctl00_contentMain_ddl_travell_with'])[" + i + "]"));
				Select sel = new Select(webelement);
				sel.selectByIndex(i);
			}

//			WebElement element = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_CorporateFDReasonDDL']"));
//			Select s = new Select(element);
//			s.selectByIndex(1);

			WebElement ele1 = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_CostCenterDDL']"));
			Select s11 = new Select(ele1);
			s11.selectByIndex(1);

			WebElement ele2 = QaBrowser.driver
					.findElement(By.xpath("//select[@id='ctl00_contentMain_CorporateDivisionDDL']"));
			Select s22 = new Select(ele2);
			s22.selectByIndex(1);

//			WebElement ele3 = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_dynamicdatacapture84']"));
//			Select s33 = new Select(ele3);
//			s33.selectByIndex(1);

			WebElement ele44 = QaBrowser.driver
					.findElement(By.xpath("//select[@id='ctl00_contentMain_dynamicdatacapture127']"));
			Select s44 = new Select(ele44);
			s44.selectByIndex(1);

			WebElement ele5 = QaBrowser.driver
					.findElement(By.xpath("//select[@id='ctl00_contentMain_dynamicdatacapture128']"));
			Select s55 = new Select(ele5);
			s55.selectByIndex(1);

			WebElement ele6 = QaBrowser.driver
					.findElement(By.xpath("//select[@id='ctl00_contentMain_dynamicdatacapture126']"));
			Select s66 = new Select(ele6);
			s66.selectByIndex(1);

			QaRobot.PassValue("BookerName", "Test");

			QaRobot.PassValue("TripApprover", "Test");

			QaRobot.PassValue("SuppplierCode", "Test");

			QaRobot.PassValue("OrderedBy", "Test");

			QaRobot.PassValue("TravellerEmail", "Test");

			QaRobot.PassValue("ArrangerEmail", "Test");

			QaExtentReport.extentScreenshot("Checkout page");

			QaRobot.ClickOnElement("TermsAndConditionF");
			QaRobot.ClickOnElement("FulfilmentF");
//			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on FulfilmentF Button</i></b>");
			Thread.sleep(3000);

//			DnataPaymentPage.individualForFlight();

//			DnataConfirmPage.confirmpageFlight(TravellerType,adult,child,infant,ModifySearch,ChangeTravellers,adultM,childM,infantM);
		}
	}

}
