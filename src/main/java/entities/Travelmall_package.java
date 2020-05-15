package entities;

import org.openqa.selenium.By;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import Base.TestBase;
import TestScript.Travelmall.Travelmallpackage;
import utilities.QaLogger;
import utilities.QaRobot;

public class Travelmall_package extends Travelmallpackage  {
	
	public static void pack_search(String dest, String dest_name, String Pbooking, String Enquiry_name,
			String Enquiry_Lname, String Enquiry_contact, String Enquiry_emailid, String month, String date,
			String dbl_type, String Dbl_adult, String Dbl_child, String Dbl_childCategory, String Dbl_ExtraBed,
			String Twn_type, String twn_adult, String twn_child, String twn_childCategory, String twn_ExtraBed,
			String tpl_type, String tpl_adult, String tpl_child, String tpl_childCategory, String sin_type,
			String sin_adult, String sin_child, String sin_childCategory, String qud_type, String qud_adult,
			String qud_child, String qud_childCategory, String dbl_title, String dbl_fname, String dbl_lname,
			String dbl_ph, String dbl_emailid, String dbl_ctitle, String dbl_cfname, String dbl_clname, String dbl_cage,
			String dbl_etitle, String dbl_efname, String dbl_elname, String dbl_ititle, String dbl_ifname,
			String dbl_ilname, String dbl_infant_age, String dbl_infant, String Twn_title, String Twn_fname,
			String Twn_lname, String Twn_ctitle, String Twn_cfname, String Twn_clname, String Twn_cage,
			String Twn_etitle, String Twn_efname, String Twn_elname, String Twn_ititle, String Twn_ifname,
			String Twn_ilname, String Twn_infant_age, String Twn_infant, String Tpl_title, String Tpl_fname,
			String Tpl_lname, String Tpl_ctitle, String Tpl_cfname, String Tpl_clname, String Tpl_cage,
			String Tpl_ititle, String Tpl_ifname, String Tpl_ilname, String Tpl_infant_age, String Tpl_infant,
			String Sin_title, String Sin_fname, String Sin_lname, String Sin_ctitle, String Sin_cfname,
			String Sin_clname, String Sin_cage, String Sin_ititle, String Sin_ifname, String Sin_ilname,
			String Sin_infant_age, String Sin_infant, String Qud_title, String Qud_fname, String Qud_lname,
			String Qud_ctitle, String Qud_cfname, String Qud_clname, String Qud_cage, String Qud_ititle,
			String Qud_ifname, String Qud_ilname, String Qud_infant_age, String Qud_infant, String cardmode,
			String type, String cardno, String cardname, String cardmonth, String cardyear, String cardcvv,
			String baddress, String bcity, String bcityauto, String bstate, String bcountry, String Ph_EmailType,String PayMode)
			throws Exception {

		 String Pbook = "xpath:(//span[text()='Book Now'])[" + Pbooking + "]";
		 String PMonth ="xpath://*[@id='datepickerBook']/div/div[1]/ul/li[@id='" + month + "']";
		String Pdate = "xpath://td[@data-month='"+month+"' and @data-day='"+date+"' ]";
		int zeroadult = Integer.parseInt(Dbl_adult);

		Thread.sleep(500);

		// select where you go for holiday
		TestBase.listofautosuggestion(By.xpath("//a[@id='ui-id-2']"), dest, dest_name,
				By.xpath("//input[@id='txtWhere']"));

		Thread.sleep(500);

		// take screenshot for search page

		String searchpage1 = QaLogger.takeScreenshot(driver, "Search Page1");
		System.out.println("Screenshot path     " + searchpage1);
		test.log(Status.INFO, "Screenshot for Search Page",
				MediaEntityBuilder.createScreenCaptureFromPath(searchpage1).build());

		// click on search button

		QaRobot.ClickOnElement("travelmall_packsearch", "Clicked on Search");

		QaRobot.explicitwaitinvisible(30, By.xpath("//div[@class='ui-progressbar-overlay']"));
		

		// click on book button

		QaRobot.getLocator(Pbook).click();

		Thread.sleep(200);

		// Enter Package Enquiry Name , Contact , EmailId

		QaRobot.ClickOnElement("P_enquriy", "Clicked on Enquiry");

		// explicitwaitvisible(20, By.xpath("//input[@id='txtEnContact']"));

		QaRobot.PassValue("pkg_ename", Enquiry_name, "Entered FirstName for Enquiry");

		QaRobot.PassValue("pkg_elname", Enquiry_Lname, "Entered LastName for Enquiry");

		Thread.sleep(1000);

		QaRobot.PassValue("pkg_econtact", Enquiry_contact, "Entered Contact for Enquiry");

		QaRobot.PassValue("pkg_eemail", Enquiry_emailid, "Entered EmailId for Enquiry");

		// take screenshot for Checkout Enquiry page

		String Enquirypage = QaLogger.takeScreenshot(driver, "Enquirypage");
		test.log(Status.INFO, "Screenshot for Enquiry Page",
				MediaEntityBuilder.createScreenCaptureFromPath(Enquirypage).build());

		// submit package Enquiry

		QaRobot.ClickOnElement("pkg_esubmit", "Clicked on Submit");

		QaRobot.explicitwaitvisible(20, By.xpath("//a[@class='fancybox-item fancybox-close']"));

		QaRobot.ClickOnElement("pkg_eclose", "Clicked on Close Button");

		Thread.sleep(1000);

		QaRobot.ClickOnElement("p_continue", "Clicked on Contiune Button");

		Thread.sleep(1000);

		// select month and date for package .

		 QaRobot.getLocator(PMonth).click();
		 
		 Thread.sleep(1000);

		 QaRobot.getLocator(Pdate).click();

		// Book Page

		if (dbl_type.equalsIgnoreCase("Double")) {
			SelectDoubleRoom(Dbl_adult, Dbl_child, Dbl_childCategory, Dbl_ExtraBed);
		}
		if (Twn_type.equalsIgnoreCase("Twin")) {
			SelectTwinRoom(twn_adult, twn_child, twn_childCategory, twn_ExtraBed);
		}
		if (tpl_type.equalsIgnoreCase("Triple")) {
			SelectTripleRoom(tpl_adult, tpl_child, tpl_childCategory);
		}
		if (sin_type.equalsIgnoreCase("Single")) {
			SelectSingleRoom(sin_adult, sin_child, sin_childCategory);
		}
		if (qud_type.equalsIgnoreCase("Quad")) {
			SelectQuadRoom(qud_adult, qud_child, qud_childCategory);
		}

		// take screenshot for Checkout informationa pax page

		String checkoutinfopage = QaLogger.takeScreenshot(driver, "Checkoutinfopage");
		test.log(Status.INFO, "Screenshot for Checkout informationa pax page",
				MediaEntityBuilder.createScreenCaptureFromPath(checkoutinfopage).build());

		QaRobot.ClickOnElement("P_pay", "Clicked on Proceed to pay");

		// take screenshot for supplement page

		String supplimentpage = QaLogger.takeScreenshot(driver, "supplimentpage");
		test.log(Status.INFO, "Screenshot for Supplimentpage page",
				MediaEntityBuilder.createScreenCaptureFromPath(supplimentpage).build());

		QaRobot.ClickOnElement("p_sbook", "Clicked on Book");

		// Checkout page

		if (dbl_type.equalsIgnoreCase("Double") && zeroadult > 0) {

			CheckoutDoubleRoom(Dbl_adult, Dbl_child, dbl_title, dbl_fname, dbl_lname, dbl_ctitle, dbl_cfname,
					dbl_clname, dbl_cage, Dbl_ExtraBed, dbl_etitle, dbl_efname, dbl_elname, dbl_ititle, dbl_ifname,
					dbl_ilname, dbl_infant_age, dbl_infant);
		}
		if (Twn_type.equalsIgnoreCase("Twin")) {

			CheckoutTwinRoom(twn_adult, twn_child, Twn_title, Twn_fname, Twn_lname, Twn_ctitle, Twn_cfname, Twn_clname,
					Twn_cage, twn_ExtraBed, Twn_etitle, Twn_efname, Twn_elname, Twn_ititle, Twn_ifname, Twn_ilname,
					Twn_infant_age, Twn_infant);
		}
		if (tpl_type.equalsIgnoreCase("Triple")) {

			CheckoutTripleRoom(tpl_adult, tpl_child, Tpl_title, Tpl_fname, Tpl_lname, Tpl_ctitle, Tpl_cfname,
					Tpl_clname, Tpl_cage, Tpl_ititle, Tpl_ifname, Tpl_ilname, Tpl_infant_age, Tpl_infant);
		}
		if (sin_type.equalsIgnoreCase("Single")) {

			CheckoutSingleRoom(sin_adult, sin_child, Sin_title, Sin_fname, Sin_lname, Sin_ctitle, Sin_cfname,
					Sin_clname, Sin_cage, Sin_ititle, Sin_ifname, Sin_ilname, Sin_infant_age, Sin_infant);
		}
		if (qud_type.equalsIgnoreCase("Quad")) {

			CheckoutQuadRoom(qud_adult, qud_child, Qud_title, Qud_fname, Qud_lname, Qud_ctitle, Qud_cfname, Qud_clname,
					Qud_cage, Qud_ititle, Qud_ifname, Qud_ilname, Qud_infant_age, Qud_infant);
		}

		// Enter Phone number and Email address for all pax that are first adult
		// in package

		// adult phone
		
		driver.findElement(By.id("Phone_" + Ph_EmailType + "_adt_1")).sendKeys(dbl_ph);

		// email id
		
		driver.findElement(By.id("Email_" + Ph_EmailType + "_adt_1")).sendKeys(dbl_emailid);


		// take screenshot for checkout page
		String checkoutpage = QaLogger.takeScreenshot(driver, "Checkoutpage");
		test.log(Status.INFO, "Screenshot for Checkoutpage",
				MediaEntityBuilder.createScreenCaptureFromPath(checkoutpage).build());
		
		//select Payment Amount Mode
		
		if(PayMode.equalsIgnoreCase("FullPayment"))
		{
			QaRobot.ClickOnElement("P_pay_full", "Selected Full payment mode");
		}
		
		package_card(cardmode, type, cardno, cardname, cardmonth, cardyear, cardcvv);
		package_billing(baddress, bcity, bcityauto, bstate, bcountry);
		
		
		// Getting checkout page costing

		String checkoutTotal = QaRobot.getWebElement("P_checkoutcost").getText();

		System.out.println("Checkout Total Cost is " + checkoutTotal);
		
		String checkoutBasefare = QaRobot.getWebElement("P_chkbasefare").getText();

		System.out.println("Checkout Base Fare is " + checkoutBasefare);
		
		String checkoutTax = QaRobot.getWebElement("P_chktax").getText();

		System.out.println("Checkout Tax Fare is " + checkoutTax);
		
		String checkoutsuppcost = QaRobot.getWebElement("P_chktotalsupp").getText();

		System.out.println("Checkout Suppliment Fare is " + checkoutsuppcost);
		
		String checkoutdiscount = QaRobot.getWebElement("P_chkdiscount").getText();

		System.out.println("Checkout Online Discount Fare is " + checkoutdiscount);
		
		String checkoutonlinefee = QaRobot.getWebElement("P_chkonlinefee").getText();

		System.out.println("Checkout Online Fee is " + checkoutonlinefee);
		
		String checkoutrevefee = QaRobot.getWebElement("P_chkreservationfee").getText();

		System.out.println("Checkout Reservation Fee is " + checkoutrevefee);
		
		String checkoutearly = QaRobot.getWebElement("P_chkearlybird").getText();

		System.out.println("Checkout Early Bird is " + checkoutearly);
		
		String checkoutfullpay = QaRobot.getWebElement("P_chkfullpay").getText();

		System.out.println("Checkout Full Payment Discount is " + checkoutfullpay);
		
		
		// check terms and condition
		QaRobot.ClickOnElement("P_termcond", "Clicked On Terms condition");

		// click confirm button
		QaRobot.ClickOnElement("P_confirm", "Clicked on confirm Button");

		String bookingid = QaRobot.getWebElement("P_bookingref").getText();
		test.log(Status.INFO, "Booking number is " + bookingid);
		System.out.println("Booking Id is " + bookingid);
		
		// Getting confirm page costing

		String confirmTotal = QaRobot.getWebElement("P_paymentCost").getText();

		System.out.println("Confirm Total Cost is " + confirmTotal);
		
		String confirmBasefare = QaRobot.getWebElement("P_paybasefare").getText();

		System.out.println("Confirm Base Fare is " + confirmBasefare);
		
		String confirmTax = QaRobot.getWebElement("P_paytax").getText();

		System.out.println("Confirm Tax Fare is " + confirmTax);
		
		String confirmsuppcost = QaRobot.getWebElement("P_paytotalsupp").getText();

		System.out.println("Confirm Suppliment Fare is " + confirmsuppcost);
		
		String confirmdiscount = QaRobot.getWebElement("P_paydiscount").getText();

		System.out.println("Confirm Online Discount Fare is " + confirmdiscount);
		
		String confirmonlinefee = QaRobot.getWebElement("P_payonlinefee").getText();

		System.out.println("Confirm Online Fee is " + confirmonlinefee);
		
		String confirmrevefee = QaRobot.getWebElement("P_payreservationfee").getText();

		System.out.println("Confirm Reservation Fee is " + confirmrevefee);
		
		String confirmearly = QaRobot.getWebElement("P_payearlybird").getText();

		System.out.println("Confirm Early Bird is " + confirmearly);
		
		String confirmfullpay = QaRobot.getWebElement("P_payfull").getText();

		System.out.println("Confirm Full Payment Discount is " + confirmfullpay);
		
		// compare value of checkout page and confirm page

		CompareFareValue(checkoutTotal, confirmTotal, " Confirm page " + confirmTotal);
		CompareFareValue(checkoutBasefare, confirmBasefare, " Confirm page " + confirmBasefare);
		CompareFareValue(checkoutTax, confirmTax, " Confirm page " + confirmTax);
		CompareFareValue(checkoutsuppcost, confirmsuppcost, " Confirm page " + confirmsuppcost);
		CompareFareValue(checkoutdiscount, confirmdiscount, " Confirm page " + confirmdiscount);
		CompareFareValue(checkoutonlinefee, confirmonlinefee, " Confirm page " + confirmonlinefee);
		CompareFareValue(checkoutrevefee, confirmrevefee, " Confirm page " + confirmrevefee);
		CompareFareValue(checkoutearly, confirmearly, " Confirm page " + confirmearly);
		CompareFareValue(checkoutfullpay, confirmfullpay, " Confirm page " + confirmfullpay);

		// take screenshot for confirm page

		String confirmpage = QaLogger.takeScreenshot(driver, "confirmpage");
		test.log(Status.INFO, "Screenshot for Confirm Page",
				MediaEntityBuilder.createScreenCaptureFromPath(confirmpage).build());
		// test.info(MarkupHelper.createCodeBlock(getLogText("\\\\erp-staging\\Cache\\Booking\\local",
		// uid[1]),
		// CodeLanguage.XML));

		QaRobot.ClickOnElement("travelmall_gohome", "clicked on Home Page");

	}
}

// Extra bed and child with bed not showing for Triple, Single and quad
// Always take infant at last in excel

