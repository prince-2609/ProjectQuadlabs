package product.Flight.suite.Oneway;

import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import com.aventstack.extentreports.Status;

import Base.TestBase;
import utilities.QaBrowser;
import utilities.QaExtentReport;
import utilities.QaRobot;

public class SBTCheckoutPayment {

	public static void CheckoutForFlightDependent(String adult, String child, String infant) throws Exception {

		String ParentWindow = QaBrowser.driver.getWindowHandle();
		// click on associate pax
		QaRobot.ClickOnElement("dept_AssociatePax");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Associate pax</i></b>");
//		QaRobot.ClickOnElement("dept_AssociatePax", "Clicked on Associate pax ");
		// wait
		Thread.sleep(500);
		// switch to the child window
		Set<String> handles = QaBrowser.driver.getWindowHandles();
		for (String childWindow : handles) {
			if (!childWindow.equals(ParentWindow))
				QaBrowser.driver.switchTo().window(childWindow);
		}
		// wait
		Thread.sleep(1000);
		// Select the pax
		selectDependentPax(adult, child, infant);
		// click on add to list button
		QaRobot.ClickOnElement("dept_AddToList");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on add to list button</i></b>");
//		QaRobot.ClickOnElement("dept_AddToList", "Clicked on add to list button");
		// select the priority
		selectDependentPriority(adult, child, infant);
		// click on Associate button
		QaRobot.ClickOnElement("dept_AssociateButton");
		QaExtentReport.test.log(Status.INFO, "<b><i>clicked on Associate button</i></b>");
//		QaRobot.ClickOnElement("dept_AssociateButton", "clicked on Associate button");
		// wait
		Thread.sleep(1000);
		QaBrowser.driver.switchTo().window(ParentWindow);

		// select the travelling with for infant

		int inf = Integer.parseInt(infant);
		for (int i = 1; i <= inf; i++) {
			WebElement webelement = QaBrowser.driver
					.findElement(By.xpath("(//select[@id='ctl00_contentMain_ddl_travell_with'])[" + i + "]"));
			Select select = new Select(webelement);
			select.selectByIndex(i);

		}

	}

	public static void CheckoutForHotelDependent(String adult, String child, String infant) throws Exception {

		String ParentWindow = QaBrowser.driver.getWindowHandle();
		// click on associate pax
		QaRobot.ClickOnElement("dept_AssociatePax");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Associate pax </i></b>");
		// wait
		Thread.sleep(500);
		// switch to the child window
		Set<String> handles = QaBrowser.driver.getWindowHandles();
		for (String childWindow : handles) {
			if (!childWindow.equals(ParentWindow))
				QaBrowser.driver.switchTo().window(childWindow);
		}
		// wait
		Thread.sleep(1000);
		// total of adult
		String[] adtcount = adult.split(",");
		int adultsum = 0;
		for (String adt : adtcount) {
			int a = Integer.parseInt(adt);
			adultsum = adultsum + a;
		}
		String adtsum = String.valueOf(adultsum);
		// total of child
		String[] chdcount = child.split(",");
		int childsum = 0;
		for (String chd : chdcount) {
			int a = Integer.parseInt(chd);
			childsum = childsum + a;
		}
		String chdsum = String.valueOf(childsum);

		// Select the pax
		selectDependentPax(adtsum, chdsum, infant);
		// click on add to list button
		QaRobot.ClickOnElement("dept_AddToList");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on add to list button</i></b>");
		// select the priority
		selectDependentPriority(adtsum, chdsum, infant);
		// click on Associate button
		QaRobot.ClickOnElement("dept_AssociateButton");
		QaExtentReport.test.log(Status.INFO, "<b><i>clicked on Associate button</i></b>");
		// wait
		Thread.sleep(1000);
		QaBrowser.driver.switchTo().window(ParentWindow);
		// select the travelling with for infant

		int inf = Integer.parseInt(infant);
		for (int i = 1; i <= inf; i++) {
			WebElement webelement = QaBrowser.driver
					.findElement(By.xpath("(//select[@id='ctl00_contentMain_ddl_travell_with'])[" + i + "]"));
			Select select = new Select(webelement);
			select.selectByIndex(i);
		}
	}

	public static void fopCreditDebit(String ProductType, String card, String cardType, String cvv) throws Exception {
		if (card.equalsIgnoreCase("Credit Card") || card.equalsIgnoreCase("Debit Card")) {
			QaRobot.selectTextFromDropdown("ow_selectcard", card, "Selected card");
			QaRobot.ClickOnElement("click_OK");
//			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked Ok button</i></b>");
			if (ProductType.equalsIgnoreCase("Flight")||ProductType.equalsIgnoreCase("Flight+MoreProducts")) {
				if (cardType.equalsIgnoreCase("Master Card")) {
					QaRobot.selectTextFromDropdown("ow_selectcardtype", cardType, "Selected master card");
					QaRobot.ClickOnElement("ow_Card");
					QaRobot.PassValue("ow_cardsecuritycode", cvv);
					QaRobot.PassValue("OW_Address", "JMD");
					TestBase.listofautosuggestion(By.xpath("//div[@id='divHTCity']/p"), "Delhi", "Delhi",
							By.xpath("//input[@id='ctl00_contentMain_payeeCity']"));
					QaRobot.PassValue("OW_State", "Delhi");
				} else if (cardType.equalsIgnoreCase("Visa")) {
					QaRobot.selectTextFromDropdown("ow_selectcardtype", cardType, "Selected visa card");
					QaRobot.ClickOnElement("ow_Card");
//					QaRobot.PassValue("card_authcode", cvv);
//					QaExtentReport.test.log(Status.INFO, "<b><i>auth code</i></b>");
				}
			} else if (ProductType.equalsIgnoreCase("Flight+Hotel")) {
//				if (DashboardType.equalsIgnoreCase("Old")) {
//					
//					if (cardType.equalsIgnoreCase("Master Card")) {
//						QaRobot.selectTextFromDropdown("ow_selectcardtype", cardType, "Selected master card");
//						QaRobot.ClickOnElement("ow_Card");
//						QaRobot.PassValue("ow_cardsecuritycode", cvv);
//						QaRobot.PassValue("OW_Address", "JMD");
//						TestBase.listofautosuggestion(By.xpath("//div[@id='divHTCity']/p"), "Delhi", "Delhi",
//								By.xpath("//input[@id='ctl00_contentMain_payeeCity']"));
//						QaRobot.PassValue("OW_State", "Delhi");
//					} else if (cardType.equalsIgnoreCase("Visa")) {
//						QaRobot.selectTextFromDropdown("ow_selectcardtype", cardType, "Selected visa card");
//						QaRobot.ClickOnElement("ow_Card");
////						QaExtentReport.extentScreenshot("Payment Page");
//						Thread.sleep(2000);
////						QaRobot.PassValue("card_authcode", cvv);
////						QaExtentReport.test.log(Status.INFO, "<b><i>auth code</i></b>");
//						QaRobot.ClickOnElement("ow_paymentprocced");
//						Thread.sleep(3000);
////						QaExtentReport.extentScreenshot("Payment Page");
////						Thread.sleep(3000);
////						QaRobot.selectTextFromDropdown("ow_selectcardtype1", "Credit Card", "");
//						Thread.sleep(3000);
//						QaRobot.selectTextFromDropdown("ow_selectcardtype", cardType, "Selected visa card");
//						QaRobot.ClickOnElement("ow_Card");
//					}
//				}else {
//			}
					if (cardType.equalsIgnoreCase("Master Card")) {
					QaRobot.selectTextFromDropdown("ow_selectcardtype", cardType, "Selected master card");
					QaRobot.ClickOnElement("ow_Card");
					QaRobot.PassValue("ow_cardsecuritycode", cvv);
					QaRobot.PassValue("OW_Address", "JMD");
					TestBase.listofautosuggestion(By.xpath("//div[@id='divHTCity']/p"), "Delhi", "Delhi",
							By.xpath("//input[@id='ctl00_contentMain_payeeCity']"));
					QaRobot.PassValue("OW_State", "Delhi");
				} else if (cardType.equalsIgnoreCase("Visa")) {
					QaRobot.selectTextFromDropdown("ow_selectcardtype", cardType, "Selected visa card");
					QaRobot.ClickOnElement("ow_Card");
//					QaExtentReport.extentScreenshot("Payment Page");
					Thread.sleep(2000);
//					QaRobot.PassValue("card_authcode", cvv);
//					QaExtentReport.test.log(Status.INFO, "<b><i>auth code</i></b>");
					QaRobot.ClickOnElement("ow_paymentprocced");
					Thread.sleep(3000);
//					QaExtentReport.extentScreenshot("Payment Page");
//					Thread.sleep(3000);
					QaRobot.selectTextFromDropdown("ow_selectcardtype1", "Credit Card", "");
					Thread.sleep(3000);
					
					QaRobot.selectTextFromDropdown("ow_selectcardtype", cardType, "Selected visa card");
					QaRobot.ClickOnElement("ow_Card");
				}
				}
				
			}
		}
//	}

	public static void fopCash(String card, String receiptno) throws Exception {

		QaRobot.selectTextFromDropdown("ow_selectcard", card, "Selected card: " + card);
		QaRobot.ClickOnElement("click_OK");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Ok button</i></b>");
		QaRobot.PassValue("ow_receiptno", receiptno);
		QaExtentReport.test.log(Status.INFO, "<b><i>receipt number is: </i></b>" + receiptno);
	}

	public static void fopBillToComapnay(String card) throws Exception {

		QaRobot.selectTextFromDropdown("ow_selectcard", card, "Selected card: " + card);

	}

	public static void holdAndQuote() throws Exception {

		// click on book and quote
		QaRobot.ClickOnElement("bookandquote");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on book and quote button</i></b>");
		// wait
		Thread.sleep(1000);
		// booking id
		String bookingID = QaBrowser.driver.findElement(By.xpath("//span[@class='nc_bookid_no']")).getText();
		System.out.println("Booking id : " + bookingID);
		QaExtentReport.test.log(Status.INFO, "<b><i>Booking id </i></b>" + bookingID);
		// booking status
		String status = QaBrowser.driver.findElement(By.xpath("//span[@class='nc_status_color']")).getText();
		System.out.println("Booking status is : " + status);
		QaExtentReport.test.log(Status.INFO, "<b><i>Booking status is </i></b>" + status);
		// booking price
		String price = QaBrowser.driver.findElement(By.xpath("(//div[@class='nc_fcelllast'])[3]")).getText();
		System.out.println("Booking price : " + price);
		QaExtentReport.test.log(Status.INFO, "<b><i>Booking price is </i></b>" + price);
	}

	public static void checkoutFlightQuote(String airReasonCode) throws Exception {
		// click on quote button

		QaRobot.ClickOnElement("TermCondition");
		QaRobot.ClickOnElement("Quoteflightcheckout");
//		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on quote button</i></b>");
		// wait till send button visibility
		// QaRobot.explicitwaitvisible(250,
		// By.xpath("//a[@id='lnksendAIREnqFromCorp']"));
		Thread.sleep(5000);
		// select the air reason codes
		// QaRobot.selectTextFromDropdown("airReasonCodeInQuote",
		// airReasonCode,"Selected air reason code " +airReasonCode);
		// Pass the remarks
		// QaRobot.PassValue("sendQuoteflightremarkscheckout", remarks, "Passed the
		// remarks as a " +remarks);

		String ParentWindow = QaBrowser.driver.getWindowHandle();
		Set<String> handles = QaBrowser.driver.getWindowHandles();
		for (String childWindow : handles) {
			if (!childWindow.equals(ParentWindow))
				QaBrowser.driver.switchTo().window(childWindow);
		}
		WebElement element = QaBrowser.driver.findElement(By.xpath("//select[@id='corpReasonF']"));
		Select sel = new Select(element);
		sel.selectByIndex(1);
		// click on send button
		WebElement WebElement = QaBrowser.driver
				.findElement(By.xpath("//div[@id='divapprovecontainer']//a[@id='lnksendAIREnqFromCorp']"));
		JavascriptExecutor js = (JavascriptExecutor) QaBrowser.driver;
		js.executeScript("arguments[0].click();", WebElement);

		// QaRobot.ClickOnElement("sendFlightQuoteFromCheckout", "Clicked on send
		// button");
		// wait till alert present
//		QaRobot.explicitwaitalert(100);
		// get the text of alert and accept it
		String quoteMessage = QaBrowser.driver.switchTo().alert().getText();
		System.out.println("Quote message after sending quotation from checkout page " + quoteMessage);
		QaExtentReport.test.log(Status.INFO,
				"Quote message after sending quotation from checkout page " + quoteMessage);
		QaBrowser.driver.switchTo().alert().accept();

	}

	public static void checkoutHotelQuote(String hotelReasonCode, String remarks) throws Exception {
		// click on quote button
		QaRobot.ClickOnElement("Quotehotelcheckout");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on quote button</i></b>");
		// wait till send button visibility
		// QaRobot.explicitwaitvisible(250,
		// By.xpath("//a[@id='lnksendAIREnqFromCorp']"));
		Thread.sleep(3000);
		// select the air reason code
		QaRobot.selectTextFromDropdown("HotelReasonCodeInQuote", hotelReasonCode,
				"Selected hotel reason code " + hotelReasonCode);
		// Pass the remarks
		QaRobot.PassValue("sendQuotehotelremarkscheckout", remarks);
		QaExtentReport.test.log(Status.INFO, "<b><i>Passed the remarks as a </i></b>" + remarks);

		// click on send button
		WebElement WebElement = QaBrowser.driver.findElement(By.xpath("//a[@id='lnksendHHLEnqFromCorp']"));
		JavascriptExecutor js = (JavascriptExecutor) QaBrowser.driver;
		js.executeScript("arguments[0].click();", WebElement);

		// QaRobot.ClickOnElement("sendFlightQuoteFromCheckout", "Clicked on send
		// button");
		// accept the alert
		QaBrowser.driver.switchTo().alert().accept();
		// wait till alert present
//		QaRobot.explicitwaitalert(100);
		// get the text of alert and accept it
		String quoteMessage = QaBrowser.driver.switchTo().alert().getText();
		System.out.println("Quote message after sending quotation from checkout page " + quoteMessage);
		QaExtentReport.test.log(Status.INFO,
				"Quote message after sending quotation from checkout page " + quoteMessage);
		QaBrowser.driver.switchTo().alert().accept();

	}

	public static void selectDependentPax(String adult, String child, String infant) {
		int adt = Integer.parseInt(adult);
		int chd = Integer.parseInt(child);
		int inf = Integer.parseInt(infant);
		// check adult
		for (int i = 1; i < adt; i++) {
			QaBrowser.driver.findElement(By.xpath("//input[@id='rptPaxDetails_ctl01_rptDetails_ctl0" + i + "_chk']"))
					.click();
		}
		// check child
		for (int i = 1; i <= chd; i++) {
			QaBrowser.driver.findElement(By.xpath("//input[@id='rptPaxDetails_ctl02_rptDetails_ctl0" + i + "_chk']"))
					.click();
		}
		// check infant
		for (int i = 1; i <= inf; i++) {
			QaBrowser.driver.findElement(By.xpath("//input[@id='rptPaxDetails_ctl03_rptDetails_ctl0" + i + "_chk']"))
					.click();
		}

	}

	public static void selectDependentPriority(String adult, String child, String infant) {
		int adt = Integer.parseInt(adult);
		int chd = Integer.parseInt(child);
		int inf = Integer.parseInt(infant);
		for (int i = 1; i <= adt; i++) {
			WebElement webelement = QaBrowser.driver.findElement(
					By.xpath("//select[@id='rptSelectionList_ctl01_rptSelection_ctl0" + i + "_ddlPriority']"));
			Select select = new Select(webelement);
			select.selectByIndex(i);

		}
		for (int i = 1; i <= chd; i++) {
			WebElement webelement = QaBrowser.driver.findElement(
					By.xpath("//select[@id='rptSelectionList_ctl02_rptSelection_ctl0" + i + "_ddlPriority']"));
			Select select = new Select(webelement);
			select.selectByIndex(i);

		}
		for (int i = 1; i <= inf; i++) {
			WebElement webelement = QaBrowser.driver.findElement(
					By.xpath("//select[@id='rptSelectionList_ctl03_rptSelection_ctl0" + i + "_ddlPriority']"));
			Select select = new Select(webelement);
			select.selectByIndex(i);

		}

	}

	// Personal booking

	public static void PersonalAdultCheckout(String adult, String adttitle, String adultfname, String adultlname,
			String adultdate, String adultmonth, String adultyear, String adultgender, String adultpassprot,
			String adultnationality, String adultedate, String adultemonth, String adulteyear, String adultpassportcomp)
			throws Exception {
		int adt = Integer.parseInt(adult);
		for (int i = 2; i <= adt; i++) {
			// select title
			String adultTitleElement = "(//select[@id='ctl00_contentMain_ddlTitle'])[" + i + "]";
			String[] adulttitle = adttitle.split(",");
			QaRobot.selectValueByLocator(adultTitleElement, adulttitle[i - 1],
					"Selected " + adulttitle[i - 1] + " as title of adult");

			// Fill First name
			String adultNameElement = "//input[@id='txt_firstNameAdt" + i + "']";
			String[] adultfirstname = adultfname.split(",");
			QaRobot.PassValueByLocator(adultNameElement, adultfirstname[i - 1], "Entered Name For adult");

			// Fill Last name

			String adultLNameElement = "//input[@id='txt_lastnameAdt" + i + "']";
			String[] adultlastname = adultlname.split(",");
			QaRobot.PassValueByLocator(adultLNameElement, adultlastname[i - 1], "Entered Last Name For adult");

			// Fill Year

			String adultyearElement = "(//select[@id='ctl00_contentMain_txt_birthDateAdt_ddlYear'])[" + i + "]";
			String[] adulty = adultyear.split(",");
			QaRobot.selectTextByLocator(adultyearElement, adulty[i - 1], "Selected Year For adult");

			// Fill Month
			String adultmonthElement = "(//select[@id='ctl00_contentMain_txt_birthDateAdt_ddlMonth'])[" + i + "]";
			String[] adultmm = adultmonth.split(",");
			QaRobot.selectTextByLocator(adultmonthElement, adultmm[i - 1], "Selected Month For adult");

			// FIll Day

			String[] adultday = adultdate.split(",");
			String adultdayElement = "(//select[@id='ctl00_contentMain_txt_birthDateAdt_ddlDay'])[" + i + "]";
			QaRobot.selectValueByLocator(adultdayElement, adultday[i - 1],
					"Selected " + adultday[i - 1] + " as day of adult");

			// select gender
			String adultgenderElement = "(//select[@id='ctl00_contentMain_ddl_genderAdt'])[" + i + "]";
			String[] adultgen = adultgender.split(",");
			QaRobot.selectTextByLocator(adultgenderElement, adultgen[i - 1], "Selected gender For adult");

			// Fill Passport
			String adultpassportElement = "//input[@id='txt_passportAdt" + i + "']";
			String[] adultpass = adultpassprot.split(",");
			QaRobot.PassValueByLocator(adultpassportElement, adultpass[i - 1],
					"Entered Passport Number For adult" + i + "");

			// fill nationality

			String adultnationalityElement = "(//select[@id='ctl00_contentMain_ddl_nationalityAdt'])[" + i + "]";
			String[] adultnat = adultnationality.split(",");
			QaRobot.selectTextByLocator(adultnationalityElement, adultnat[i - 1], "Selected Nationality For adult");

			// FIll passport Day

			String[] adulteday = adultedate.split(",");
			String adultedayElement = "(//select[@id='ctl00_contentMain_txt_ex_dateAdt_ddlDay'])[" + i + "]";
			QaRobot.selectValueByLocator(adultedayElement, adulteday[i - 1],
					"Selected " + adulteday[i - 1] + " as day of adult");
			// Fill Month
			String adultemonthElement = "(//select[@id='ctl00_contentMain_txt_ex_dateAdt_ddlMonth'])[" + i + "]";
			String[] adultemm = adultemonth.split(",");
			QaRobot.selectTextByLocator(adultemonthElement, adultemm[i - 1], "Selected Expiry Month For adult");
			// Fill Year

			String adulteyearElement = "(//select[@id='ctl00_contentMain_txt_ex_dateAdt_ddlYear'])[" + i + "]";
			String[] adultey = adulteyear.split(",");
			QaRobot.selectTextByLocator(adulteyearElement, adultey[i - 1], "Selected Expiry Year For adult");

			// fill Passport issuing country
			Thread.sleep(500);
			String adultpasscountryElement = "(//select[@id='ctl00_contentMain_ddl_passCountryAdt'])[" + i + "]";
			String[] adultpc = adultpassportcomp.split(",");
			QaRobot.selectTextByLocator(adultpasscountryElement, adultpc[i - 1], "Selected Passport Country For adult");

		}
	}

	public static void PersonalChildCheckout(String child, String chdtitle, String childfname, String childlname,
			String childYear, String childMonth, String childDate, String childGender, String childPassport,
			String childNationality, String childEdate, String childEmonth, String childEyear, String childPassportComp)
			throws Exception {

		int chd = Integer.parseInt(child);
		for (int i = 1; i <= chd; i++) {
			// select title
			String childTitleElement = "(//select[@id='ctl00_contentMain_ddl_titleChd'])[" + i + "]";
			String[] childtitle = chdtitle.split(",");
			QaRobot.selectValueByLocator(childTitleElement, childtitle[i - 1],
					"Selected " + childtitle[i - 1] + " as title of Child");

			// Fill First name
			String childNameElement = "//input[@id='txt_firstNameChd" + i + "']";
			String[] childfirstname = childfname.split(",");
			QaRobot.PassValueByLocator(childNameElement, childfirstname[i - 1], "Entered Name For Child");

			// Fill Last name

			String childLNameElement = "//input[@id='txt_lastnameChd" + i + "']";
			String[] childlastname = childlname.split(",");
			QaRobot.PassValueByLocator(childLNameElement, childlastname[i - 1], "Entered Last Name For Child");

			// Fill Year

			String childyearElement = "(//select[@id='ctl00_contentMain_txt_birthDateChd_ddlYear'])[" + i + "]";
			String[] childy = childYear.split(",");
			QaRobot.selectTextByLocator(childyearElement, childy[i - 1], "Selected Year For Child");

			// Fill Month
			String childmonthElement = "(//select[@id='ctl00_contentMain_txt_birthDateChd_ddlMonth'])[" + i + "]";
			String[] childmm = childMonth.split(",");
			QaRobot.selectTextByLocator(childmonthElement, childmm[i - 1], "Selected Month For Child");

			// FIll Day
			String childdayElement = "(//select[@id='ctl00_contentMain_txt_birthDateChd_ddlDay'])[" + i + "]";
			String[] childday = childDate.split(",");
			QaRobot.selectValueByLocator(childdayElement, childday[i - 1],
					"Selected " + childday[i - 1] + " as day of Child");

			// select gender
			String childgenderElement = "(//select[@id='ctl00_contentMain_ddl_genderChd'])[" + i + "]";
			String[] childgen = childGender.split(",");
			QaRobot.selectTextByLocator(childgenderElement, childgen[i - 1], "Selected gender For Child");

			// Fill Passport
			String childpassportElement = "//input[@id='txt_passportChd" + i + "']";
			String[] childpass = childPassport.split(",");
			QaRobot.PassValueByLocator(childpassportElement, childpass[i - 1],
					"Entered Passport Number For Child" + i + "");

			// fill nationality

			String childnationalityElement = "(//select[@id='ctl00_contentMain_ddl_nationalityChd'])[" + i + "]";
			String[] childnat = childNationality.split(",");
			QaRobot.selectTextByLocator(childnationalityElement, childnat[i - 1], "Selected Nationality For Child");

			// FIll passport Day

			String[] childeday = childEdate.split(",");
			String childedayElement = "(//select[@id='ctl00_contentMain_txt_ex_dateChd_ddlDay'])[" + i + "]";
			QaRobot.selectValueByLocator(childedayElement, childeday[i - 1],
					"Selected " + childeday[i - 1] + " as day of Child");
			// Fill Month
			String childemonthElement = "(//select[@id='ctl00_contentMain_txt_ex_dateChd_ddlMonth'])[" + i + "]";
			String[] childemm = childEmonth.split(",");
			QaRobot.selectTextByLocator(childemonthElement, childemm[i - 1], "Selected Expiry Month For Child");
			// Fill Year

			String childeyearElement = "(//select[@id='ctl00_contentMain_txt_ex_dateChd_ddlYear'])[" + i + "]";
			String[] childey = childEyear.split(",");
			QaRobot.selectTextByLocator(childeyearElement, childey[i - 1], "Selected Expiry Year For Child");

			// fill Passport issuing country
			Thread.sleep(500);
			String childpasscountryElement = "(//select[@id='ctl00_contentMain_ddl_passCountryChd'])[" + i + "]";
			String[] childpc = childPassportComp.split(",");
			QaRobot.selectTextByLocator(childpasscountryElement, childpc[i - 1], "Selected Passport Country For Child");

		}
	}

	public static void PersonalInfantCheckout(String infant, String inftitle, String infantfname, String infantlname,
			String infantyear, String infantmonth, String infantdate, String infantgender, String infantTravelingWith,
			String infantpassprot, String infantnationality, String infantedate, String infantemonth,
			String infanteyear, String infantpassportcomp) throws Exception {
		int inf = Integer.parseInt(infant);
		for (int i = 1; i <= inf; i++) {
			// select title
			String infantTitleElement = "(//select[@id='ctl00_contentMain_ddl_titleInf'])[" + i + "]";
			String[] infanttitle = inftitle.split(",");
			QaRobot.selectValueByLocator(infantTitleElement, infanttitle[i - 1],
					"Selected " + infanttitle[i - 1] + " as title of infant");

			// Fill First name
			String infantNameElement = "//input[@id='txt_firstNameInf" + i + "']";
			String[] infantfirstname = infantfname.split(",");
			QaRobot.PassValueByLocator(infantNameElement, infantfirstname[i - 1], "Entered Name For infant");

			// Fill Last name

			String infantLNameElement = "//input[@id='txt_lastnameInf" + i + "']";
			String[] infantlastname = infantlname.split(",");
			QaRobot.PassValueByLocator(infantLNameElement, infantlastname[i - 1], "Entered Last Name For infant");

			// Fill Year

			String infantyearElement = "(//select[@id='ctl00_contentMain_txt_birthDateInf_ddlYear'])[" + i + "]";
			String[] infanty = infantyear.split(",");
			QaRobot.selectTextByLocator(infantyearElement, infanty[i - 1], "Selected Year For infant");

			// Fill Month
			String infantmonthElement = "(//select[@id='ctl00_contentMain_txt_birthDateInf_ddlMonth'])[" + i + "]";
			String[] infantmm = infantmonth.split(",");
			QaRobot.selectTextByLocator(infantmonthElement, infantmm[i - 1], "Selected Month For infant");

			// FIll Day

			String[] infantday = infantdate.split(",");
			String infantdayElement = "(//select[@id='ctl00_contentMain_txt_birthDateInf_ddlDay'])[" + i + "]";
			QaRobot.selectValueByLocator(infantdayElement, infantday[i - 1],
					"Selected " + infantday[i - 1] + " as day of infant");

			// select gender
			String infantgenderElement = "(//select[@id='ctl00_contentMain_ddl_genderInf'])[" + i + "]";
			String[] infantgen = infantgender.split(",");
			QaRobot.selectTextByLocator(infantgenderElement, infantgen[i - 1], "Selected gender For infant");

			// select travelling with

			String infanttravellingElement = "(//select[@id='ctl00_contentMain_ddl_travell_with'])[" + i + "]";
			String[] infanttravel = infantTravelingWith.split(",");
			QaRobot.selectTextByLocator(infanttravellingElement, infanttravel[i - 1],
					"Selected Travelling with For infant");

			// Fill Passport
			String infantpassportElement = "//input[@id='txt_passportInf" + i + "']";
			String[] infantpass = infantpassprot.split(",");
			QaRobot.PassValueByLocator(infantpassportElement, infantpass[i - 1],
					"Entered Passport Number For infant" + i + "");

			// fill nationality

			String infantnationalityElement = "(//select[@id='ctl00_contentMain_ddl_nationalityInf'])[" + i + "]";
			String[] infantnat = infantnationality.split(",");
			QaRobot.selectTextByLocator(infantnationalityElement, infantnat[i - 1], "Selected Nationality For infant");

			// FIll passport Day

			String[] infanteday = infantedate.split(",");
			String infantedayElement = "(//select[@id='ctl00_contentMain_txt_ex_dateInf_ddlDay'])[" + i + "]";
			QaRobot.selectValueByLocator(infantedayElement, infanteday[i - 1],
					"Selected " + infanteday[i - 1] + " as day of infant");
			// Fill Month
			String infantemonthElement = "(//select[@id='ctl00_contentMain_txt_ex_dateInf_ddlMonth'])[" + i + "]";
			String[] infantemm = infantemonth.split(",");
			QaRobot.selectTextByLocator(infantemonthElement, infantemm[i - 1], "Selected Expiry Month For infant");
			// Fill Year

			String infanteyearElement = "(//select[@id='ctl00_contentMain_txt_ex_dateInf_ddlYear'])[" + i + "]";
			String[] infantey = infanteyear.split(",");
			QaRobot.selectTextByLocator(infanteyearElement, infantey[i - 1], "Selected Expiry Year For infant");

			// fill Passport issuing country
			Thread.sleep(500);
			String infantpasscountryElement = "(//select[@id='ctl00_contentMain_ddl_passCountryInf'])[" + i + "]";
			String[] infantpc = infantpassportcomp.split(",");
			QaRobot.selectTextByLocator(infantpasscountryElement, infantpc[i - 1],
					"Selected Passport Country For infant");

		}
	}

	public static void GuestAdultCheckout(String adult, String adttitle, String adultfname, String adultlname,
			String adultdate, String adultmonth, String adultyear, String adultgender, String adultpassprot,
			String adultnationality, String adultedate, String adultemonth, String adulteyear, String adultpassportcomp,
			String isd, String phoneNumber) throws Exception {
		int adt = Integer.parseInt(adult);
		for (int i = 1; i <= adt; i++) {
			// select title
			String adultTitleElement = "(//select[@id='ctl00_contentMain_ddlTitle'])[" + i + "]";
			String[] adulttitle = adttitle.split(",");
			QaRobot.selectValueByLocator(adultTitleElement, adulttitle[i - 1],
					"Selected " + adulttitle[i - 1] + " as title of adult");

			// Fill First name
			String adultNameElement = "//input[@id='txt_firstNameAdt" + i + "']";
			String[] adultfirstname = adultfname.split(",");
			QaRobot.PassValueByLocator(adultNameElement, adultfirstname[i - 1], "Entered Name For adult");

			// Fill Last name

			String adultLNameElement = "//input[@id='txt_lastnameAdt" + i + "']";
			String[] adultlastname = adultlname.split(",");
			QaRobot.PassValueByLocator(adultLNameElement, adultlastname[i - 1], "Entered Last Name For adult");

			// Fill Year

			String adultyearElement = "(//select[@id='ctl00_contentMain_txt_birthDateAdt_ddlYear'])[" + i + "]";
			String[] adulty = adultyear.split(",");
			QaRobot.selectTextByLocator(adultyearElement, adulty[i - 1], "Selected Year For adult");

			// Fill Month
			String adultmonthElement = "(//select[@id='ctl00_contentMain_txt_birthDateAdt_ddlMonth'])[" + i + "]";
			String[] adultmm = adultmonth.split(",");
			QaRobot.selectTextByLocator(adultmonthElement, adultmm[i - 1], "Selected Month For adult");

			// FIll Day

			String[] adultday = adultdate.split(",");
			String adultdayElement = "(//select[@id='ctl00_contentMain_txt_birthDateAdt_ddlDay'])[" + i + "]";
			QaRobot.selectValueByLocator(adultdayElement, adultday[i - 1],
					"Selected " + adultday[i - 1] + " as day of adult");

			// select gender
			String adultgenderElement = "(//select[@id='ctl00_contentMain_ddl_genderAdt'])[" + i + "]";
			String[] adultgen = adultgender.split(",");
			QaRobot.selectTextByLocator(adultgenderElement, adultgen[i - 1], "Selected gender For adult");

			// Fill Passport
			String adultpassportElement = "//input[@id='txt_passportAdt" + i + "']";
			String[] adultpass = adultpassprot.split(",");
			QaRobot.PassValueByLocator(adultpassportElement, adultpass[i - 1],
					"Entered Passport Number For adult" + i + "");

			// fill nationality

			String adultnationalityElement = "(//select[@id='ctl00_contentMain_ddl_nationalityAdt'])[" + i + "]";
			String[] adultnat = adultnationality.split(",");
			QaRobot.selectTextByLocator(adultnationalityElement, adultnat[i - 1], "Selected Nationality For adult");

			// FIll passport Day

			String[] adulteday = adultedate.split(",");
			String adultedayElement = "(//select[@id='ctl00_contentMain_txt_ex_dateAdt_ddlDay'])[" + i + "]";
			QaRobot.selectValueByLocator(adultedayElement, adulteday[i - 1],
					"Selected " + adulteday[i - 1] + " as day of adult");
			// Fill Month
			String adultemonthElement = "(//select[@id='ctl00_contentMain_txt_ex_dateAdt_ddlMonth'])[" + i + "]";
			String[] adultemm = adultemonth.split(",");
			QaRobot.selectTextByLocator(adultemonthElement, adultemm[i - 1], "Selected Expiry Month For adult");
			// Fill Year

			String adulteyearElement = "(//select[@id='ctl00_contentMain_txt_ex_dateAdt_ddlYear'])[" + i + "]";
			String[] adultey = adulteyear.split(",");
			QaRobot.selectTextByLocator(adulteyearElement, adultey[i - 1], "Selected Expiry Year For adult");

			// fill Passport issuing country
			Thread.sleep(500);
			String adultpasscountryElement = "(//select[@id='ctl00_contentMain_ddl_passCountryAdt'])[" + i + "]";
			String[] adultpc = adultpassportcomp.split(",");
			QaRobot.selectTextByLocator(adultpasscountryElement, adultpc[i - 1], "Selected Passport Country For adult");

		}
		// fill Phone number and isd
		String adultisdElement = "//input[@id='ctl00_contentMain_txt_isdAdt']";
		QaRobot.PassValueByLocator(adultisdElement, isd, "Entered isd Number For adult");

		String adultphonenumberElement = "//input[@id='ctl00_contentMain_txt_pax_phoneAdt']";
		QaRobot.PassValueByLocator(adultphonenumberElement, phoneNumber, "Entered phone Number For adult");
	}

	// Hotel Personal
	public static void PersonalHotelAdultCheckout(String adult, String adttitle, String adultfname, String adultlname,
			String adultdate, String adultmonth, String adultyear, String adultgender) throws Exception {
		String[] adt = adult.split(",");
		int adtsum = 0;
		for (int j = 0; j < adt.length; j++) {
			adtsum = Integer.parseInt(adt[j]) + adtsum;
		}
		for (int i = 2; i <= adtsum; i++)

		{ // select title
			String adultTitleElement = "(//select[@id='ctl00_contentMain_ddl_titleAdt_H'])[" + i + "]";
			String[] adulttitle = adttitle.split(",");
			QaRobot.selectValueByLocator(adultTitleElement, adulttitle[i - 2],
					"Selected " + adulttitle[i - 2] + " as title of adult");

			// Fill First name
			String adultNameElement = "(//input[contains(@id,'txt_firstNameAdt_H')])[" + i + "]";
			String[] adultfirstname = adultfname.split(",");
			QaRobot.PassValueByLocator(adultNameElement, adultfirstname[i - 2], "Entered Name For adult");

			// Fill Last name

			String adultLNameElement = "(//input[contains(@id,'txt_lastnameAdt_H')])[" + i + "]";
			String[] adultlastname = adultlname.split(",");
			QaRobot.PassValueByLocator(adultLNameElement, adultlastname[i - 2], "Entered Last Name For adult");

			// Fill Day

			String adultdayElement = "(//select[@id='ctl00_contentMain_txt_DobAdt_H1_ddlDay'])[" + i + "]";
			String[] adultday = adultdate.split(",");
			QaRobot.selectTextByLocator(adultdayElement, adultday[i - 2], "Selected Day For adult");

			// Fill Month
			String adultmonthElement = "(//select[@id='ctl00_contentMain_txt_DobAdt_H1_ddlMonth'])[" + i + "]";
			String[] adultmm = adultmonth.split(",");
			QaRobot.selectTextByLocator(adultmonthElement, adultmm[i - 2], "Selected Month For adult");

			// FIll year

			String[] adulty = adultyear.split(",");
			String adultyearElement = "(//select[@id='ctl00_contentMain_txt_DobAdt_H1_ddlYear'])[" + i + "]";
			QaRobot.selectValueByLocator(adultyearElement, adulty[i - 2],
					"Selected " + adulty[i - 2] + " as year of adult");

			// select gender
			String adultgenderElement = "(//select[@id='ctl00_contentMain_ddl_genderAdt_H'])[" + i + "]";
			String[] adultgen = adultgender.split(",");
			QaRobot.selectTextByLocator(adultgenderElement, adultgen[i - 2], "Selected gender For adult");

		}
	}

	public static void PersonalHotelChildCheckout(String child, String chdtitle, String childfname, String childlname,
			String childdate, String childmonth, String childyear, String childgender) throws Exception {
		String[] chd = child.split(",");
		int chdsum = 0;
		for (int j = 0; j < chd.length; j++) {
			chdsum = Integer.parseInt(chd[j]) + chdsum;
		}
		for (int i = 1; i <= chdsum; i++)

		{ // select title
			String childTitleElement = "(//select[@id='ctl00_contentMain_ddl_titleChd_H'])[" + i + "]";
			String[] childtitle = chdtitle.split(",");
			QaRobot.selectValueByLocator(childTitleElement, childtitle[i - 1],
					"Selected " + childtitle[i - 1] + " as title of child");

			// Fill First name
			String childNameElement = "(//input[contains(@id,'txt_firstnameChd_H')])[" + i + "]";
			String[] childfirstname = childfname.split(",");
			QaRobot.PassValueByLocator(childNameElement, childfirstname[i - 1], "Entered Name For child");

			// Fill Last name

			String childLNameElement = "(//input[contains(@id,'txt_lastnameChd_H')])[" + i + "]";
			String[] childlastname = childlname.split(",");
			QaRobot.PassValueByLocator(childLNameElement, childlastname[i - 1], "Entered Last Name For child");

			// Fill Day

			String childdayElement = "(//select[@id='ctl00_contentMain_txt_DobChd_H_ddlDay'])[" + i + "]";
			String[] childday = childdate.split(",");
			QaRobot.selectTextByLocator(childdayElement, childday[i - 1], "Selected Day For child");

			// Fill Month
			String childmonthElement = "(//select[@id='ctl00_contentMain_txt_DobChd_H_ddlMonth'])[" + i + "]";
			String[] childmm = childmonth.split(",");
			QaRobot.selectTextByLocator(childmonthElement, childmm[i - 1], "Selected Month For child");

			// FIll year

			String[] childy = childyear.split(",");
			String childyearElement = "(//select[@id='ctl00_contentMain_txt_DobChd_H_ddlYear'])[" + i + "]";
			QaRobot.selectValueByLocator(childyearElement, childy[i - 1],
					"Selected " + childy[i - 1] + " as year of child");

			// select gender
			String childgenderElement = "(//select[@id='ctl00_contentMain_ddl_genderChd_H'])[" + i + "]";
			String[] childgen = childgender.split(",");
			QaRobot.selectTextByLocator(childgenderElement, childgen[i - 1], "Selected gender For child");

		}
	}

	// Hotel Personal
	public static void GuestHotelAdultCheckout(String adult, String adttitle, String adultfname, String adultlname,
			String adultdate, String adultmonth, String adultyear, String adultgender, String isd, String phoneNumber)
			throws Exception {
		String[] adt = adult.split(",");
		int adtsum = 0;
		for (int j = 0; j < adt.length; j++) {
			adtsum = Integer.parseInt(adt[j]) + adtsum;
		}
		for (int i = 1; i <= adtsum; i++)

		{ // select title
			String adultTitleElement = "(//select[@id='ctl00_contentMain_ddl_titleAdt_H'])[" + i + "]";
			String[] adulttitle = adttitle.split(",");
			QaRobot.selectValueByLocator(adultTitleElement, adulttitle[i - 1],
					"Selected " + adulttitle[i - 1] + " as title of adult");

			// Fill First name
			String adultNameElement = "(//input[contains(@id,'txt_firstNameAdt_H')])[" + i + "]";
			String[] adultfirstname = adultfname.split(",");
			QaRobot.PassValueByLocator(adultNameElement, adultfirstname[i - 1], "Entered Name For adult");

			// Fill Last name

			String adultLNameElement = "(//input[contains(@id,'txt_lastnameAdt_H')])[" + i + "]";
			String[] adultlastname = adultlname.split(",");
			QaRobot.PassValueByLocator(adultLNameElement, adultlastname[i - 1], "Entered Last Name For adult");

			// Fill Day

			String adultdayElement = "(//select[@id='ctl00_contentMain_txt_DobAdt_H1_ddlDay'])[" + i + "]";
			String[] adultday = adultdate.split(",");
			QaRobot.selectTextByLocator(adultdayElement, adultday[i - 1], "Selected Day For adult");

			// Fill Month
			String adultmonthElement = "(//select[@id='ctl00_contentMain_txt_DobAdt_H1_ddlMonth'])[" + i + "]";
			String[] adultmm = adultmonth.split(",");
			QaRobot.selectTextByLocator(adultmonthElement, adultmm[i - 1], "Selected Month For adult");

			// FIll year

			String[] adulty = adultyear.split(",");
			String adultyearElement = "(//select[@id='ctl00_contentMain_txt_DobAdt_H1_ddlYear'])[" + i + "]";
			QaRobot.selectValueByLocator(adultyearElement, adulty[i - 1],
					"Selected " + adulty[i - 1] + " as year of adult");

			// select gender
			String adultgenderElement = "(//select[@id='ctl00_contentMain_ddl_genderAdt_H'])[" + i + "]";
			String[] adultgen = adultgender.split(",");
			QaRobot.selectTextByLocator(adultgenderElement, adultgen[i - 1], "Selected gender For adult");

		}
		// fill Phone number and isd
		String adultisdElement = "//input[@id='ctl00_contentMain_txt_isdAdt_H']";
		QaRobot.PassValueByLocator(adultisdElement, isd, "Entered isd Number For adult");

		String adultphonenumberElement = "//input[@id='ctl00_contentMain_txt_phoneAdt_H']";
		QaRobot.PassValueByLocator(adultphonenumberElement, phoneNumber, "Entered phone Number For adult");

	}

}
