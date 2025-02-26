package jOLO_SBT;

import utilities.QaBrowser;
import utilities.QaExtentReport;
import utilities.QaRobot;

public class SBT_JOLO_PaymentPage {

	public static void individualForCar() throws Exception {
		QaBrowser.driver.switchTo().alert().accept();
		Thread.sleep(5000);
		QaRobot.ClickOnElement("OKF");
		QaRobot.PassValue("ReceiptNoF", "9863647");
		QaRobot.ClickOnElement("ProceedF");
	}

	public static void cardPayment(String ProductType, String FOP, String CardType, String CreditCardNumber,
			String CardHolderName, String CardExpiryDate) throws Exception {
		if (ProductType.equalsIgnoreCase("Car+Hotel+Flight")) {
			QaRobot.selectTextFromDropdown("PaymentMethodC1", FOP);
		}
		QaRobot.ClickOnElement("OKC");
		QaRobot.selectTextFromDropdown("PaymentMethodC", CardType);
		if (CardType.equalsIgnoreCase("MasterCard")) {
			cardDetailsForCar(CreditCardNumber, CardHolderName, CardExpiryDate);
		} else if (CardType.equalsIgnoreCase("Visa")) {
			cardDetailsForCar(CreditCardNumber, CardHolderName, CardExpiryDate);
		}
//		QaRobot.selectTextFromDropdown("PaymentMethodC2", FOP);
//		QaRobot.ClickOnElement("OKC1");
//		if (CardType.equalsIgnoreCase("MasterCard")) {
//			cardDetailsForCar(CreditCardNumber, CardHolderName, CardExpiryDate);
//		} else if (CardType.equalsIgnoreCase("Visa")) {
//			cardDetailsForCar(CreditCardNumber, CardHolderName, CardExpiryDate);
//		}
		QaExtentReport.extentScreenshot("Payment Page");
		Thread.sleep(2000);
		QaRobot.ClickOnElement("ProceedF");
	}

	public static void cardDetailsForCar(String CreditCardNumber, String CardHolderName, String CardExpiryDate)
			throws Exception {
//		QaRobot.PassValue("CreditCardNumberC", CreditCardNumber);
//		QaRobot.PassValue("CreditHolderNameC", CardHolderName);
//		String cardDate[] = CardExpiryDate.split(",");
//		String month = cardDate[0];
//		String year = cardDate[1];
//		String cardMonth = "//select[@id='ctl00_contentMain_dobExp_ddlMonth']";
//		QaRobot.selectTextByLocator(cardMonth, month);
//		String cardYear = "//select[@id='ctl00_contentMain_dobExp_ddlYear']";
//		QaRobot.selectTextByLocator(cardYear, year);
//		QaExtentReport.extentScreenshot("Card Payment");
//		QaRobot.ClickOnElement("CreditPayNowC");
	}
}
