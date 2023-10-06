package testFlightHotel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Base.TestBase;
import product.Flight.suite.Oneway.SearchDashboard;
import utilities.QaBrowser;
import utilities.QaDataProvider;
import utilities.QaExtentReport;
import utilities.QaRobot;

@Listeners(listenerClass.Listener.class)
public class BusinessHotelTrip {
	public static String resultPagePrice;

	@DataProvider
	public Object[][] getexceldata1() throws Exception {
		return QaDataProvider.getTestdata("SBT_Hotel", "Sheet11");
	}

	@Test(dataProvider = "getexceldata1")
	public static void Sbt_Hotel_Search(String TestCaseId, String TestScenario, String ccode, String URL,
			String EmployeName, String TravelerType, String UserName, String Password, String CoporateName,
			String FareBranding, String DashboardType, String CorporateTraveller, String SearchType, String Trip,
			String CityCode, String CityTitle, String ChooseRadius, String CheckInDate, String CheckOutDate,
			String Rooms, String Adult, String Child, String ChildAge, String SearchRuleStatus, String BookNowIndex,
			String PolicyIndex, String TripRequestIndex, String ModifySearch, String TravellerTypeM,
			String ChangeTripLocation, String CityCodeM, String CityTitleM, String ChangeRadius, String ChooseRadiusM,
			String ChangeTripDate, String CheckInDateM, String CheckOutDateM, String ChangeRooms, String RoomsM,
			String AdultM, String ChildM, String ChildAgeM, String Applyfilter, String ChangeStarRating,
			String StarRatingM, String ChangePropertyType, String SelectProperty, String Resultpagestep,
			String ProductType, String TripType, String OriginCityCode, String OriginLocation,
			String DestinationCityCode, String DestinationLocation, String DepartureDate, String ReturnDate,
			String adult, String child, String infant, String Class, String ShowDirectFlight, String PickUpCode,
			String PickUpCity, String PickUpDate, String DropOffDate, String DriversAge,
			String DropOffToDifferentLocation, String DropOffCode, String DropOffCity, String SelectItineraryAs,
			String QuoteTitle, String QuoteRemark, String Checkoutpagestep, String FOP, String CardType,
			String CreditCardNumber, String CardHolderName, String CardExpiryDate, String CreatedBy) throws Exception {
		QaExtentReport.test = QaExtentReport.report.createTest(TestCaseId + "-" + TestScenario);
		TestBase.Companycode(ccode, URL);
		QaRobot.impliwait(30);
//		Login.SbtLogin(uname, pwd);
		QaRobot.getWebElement("sbt_Login1").sendKeys(UserName);
		QaRobot.getWebElement("sbt_Pasword1").sendKeys(Password);
		QaExtentReport.extentScreenshot("Sigh In Page");
		QaRobot.getWebElement("sbt_submit").click();
		QaExtentReport.test.log(Status.INFO, "<b><i>Employee Name is  </i></b>" + EmployeName);
		QaExtentReport.test.log(Status.INFO, "<b><i>Travel Arranger Name is  </i></b>" + TravelerType);
		if (ccode.equalsIgnoreCase("sbt")) {
			if (CoporateName.equalsIgnoreCase("Poonam_Corp")) {
				QaRobot.ClickOnElement("ChooseCorporate1");
				QaExtentReport.test.log(Status.INFO, "<b><i> Coporate Name is  </i></b>" + CoporateName);
				QaExtentReport.extentScreenshot("Choose Corporate");
			} else if (CoporateName.equalsIgnoreCase("Amazon")) {
				QaRobot.ClickOnElement("ChooseCorporate2");
				QaExtentReport.test.log(Status.INFO, "<b><i> Coporate Name is  </i></b>" + CoporateName);
				QaExtentReport.extentScreenshot("Choose Corporate");
			}
		} else if (ccode.equalsIgnoreCase("preprod117")) {
			if (CoporateName.equalsIgnoreCase("Demo Corporate")) {
				QaRobot.ClickOnElement("ChooseCorporate1");
				QaExtentReport.test.log(Status.INFO, "<b><i> Coporate Name is  </i></b>" + CoporateName);
				QaExtentReport.extentScreenshot("Choose Corporate");
			} else if (CoporateName.equalsIgnoreCase("Lux_Test_corp")) {
				QaRobot.ClickOnElement("ChooseCorporate2");
				QaExtentReport.test.log(Status.INFO, "<b><i> Coporate Name is  </i></b>" + CoporateName);
				QaExtentReport.extentScreenshot("Choose Corporate");
			} else if (CoporateName.equalsIgnoreCase("Amazon")) {
				QaRobot.ClickOnElement("ChooseCorporate2");
				QaExtentReport.test.log(Status.INFO, "<b><i> Coporate Name is  </i></b>" + CoporateName);
				QaExtentReport.extentScreenshot("Choose Corporate");
			}
		}
		Thread.sleep(3000);
//		QaRobot.ClickOnElement("NotificationClose");
//		Thread.sleep(2000);
		QaRobot.ClickOnElement("search_hotel");
		Thread.sleep(2000);
		if (DashboardType.equalsIgnoreCase("Old")) {
			if (TravelerType.equalsIgnoreCase("Administrator") || TravelerType.equalsIgnoreCase("Travel Arranger")) {
				SearchDashboard.selectEmployeeWithID(CorporateTraveller);
			}
			if (SearchType.equalsIgnoreCase("Individual")) {
				QaRobot.ClickOnElement("trip_Busniess");
			} else if (SearchType.equalsIgnoreCase("Dependent")) {
				QaRobot.ClickOnElement("trip_Family");
			}
			TestBase.listofautosuggestion(By.xpath("//div[@id='divHotelName']/p"), CityCode, CityTitle,
					By.xpath("//input[@id='txtHHLCity']"));
			Thread.sleep(1000);
			QaExtentReport.test.log(Status.INFO, "<b><i>Destination city </i></b>" + CityTitle);
			Thread.sleep(1000);
			QaBrowser.driver.findElement(By.xpath("(//span[@class='pikcalndr datepick-trigger'])[9]/img")).click();
			Thread.sleep(2000);
			// click on next month
			// QaRobot.ClickOnElement("nextmonth_calender", "Clicked on Next Month Button");
//			QaRobot.ClickOnElement("nextmonth_calender");
			// select the checkin date
			String DateSelection[] = CheckInDate.split("-");
			String year = DateSelection[2];
			String month = DateSelection[1];
			String expDate = DateSelection[0];
			String DateSelection1[] = CheckOutDate.split("-");
			String year1 = DateSelection1[2];
			String month1 = DateSelection1[1];
			String expDate1 = DateSelection1[0];
			selectDateInCalendarHotelOld(expDate, month, year, expDate1, month1, year1);
			if (SearchType.equalsIgnoreCase("Individual")) {
			} else {
				String[] adultcount = Adult.split(",");
				String[] childcount = Child.split(",");
				Assert.assertFalse(Integer.parseInt(Rooms) > 5, "Invalid Number of Rooms provided" + " - " + Rooms);
				WebElement RoomsH = QaBrowser.driver.findElement(By.xpath("//select[@id='ddlRoom']"));
				Select selectRooms = new Select(RoomsH);
				selectRooms.selectByVisibleText(Rooms);
				for (int i = 1; i <= Integer.parseInt(Rooms); i++) {
					WebElement adultelement = QaBrowser.driver
							.findElement(By.xpath("//select[@id='ddlHHLAdultR" + i + "']"));
					Select selectadult = new Select(adultelement);
					selectadult.selectByVisibleText(adultcount[i - 1]);
					Thread.sleep(2000);

					WebElement childelement = QaBrowser.driver
							.findElement(By.xpath("//select[@id='ddlHHLChildR" + i + "']"));
					Select selectchild = new Select(childelement);
					selectchild.selectByValue(childcount[i - 1]);
					Thread.sleep(2000);
				}
				String[] ageofchild = ChildAge.split(",");
				for (String chd : childcount) {
					int chdcount = Integer.parseInt(chd);
					for (int i = 1; i <= chdcount; i++) {
						String ac = ageofchild[i - 1];
						Assert.assertFalse(Integer.parseInt(ac) > 11, "Invalid Child Age Selection" + " : " + ac);
						WebElement childrenage = QaBrowser.driver
								.findElement(By.xpath("//select[@id='ddlHHLChild" + i + "R" + chdcount + "']"));
						Select selectage = new Select(childrenage);
						selectage.selectByValue(ageofchild[i - 1]);
						Thread.sleep(2000);
					}
				}
			}
			// click on addtional search
			// QaRobot.ClickOnElement("ow_addsearch", "additional search options");
			// select currency
			// QaRobot.selectTextFromDropdown("ow_currency", currency,
			// "search currency : " + currency);
			// check the policy checkbox
			if (SearchType.equalsIgnoreCase("Individual")) {
				SearchDashboard.hotelPolicyCheck();
			}
			// sceernshot of search interface
			// String searchpage = Logger.takeScreenshot(QaBrowser.driver,
			// "D:\\Screenshot\\searchPage.png");
			// QaExtentReport.test.log(Status.INFO, "Search Page "+searchpage+"");
			QaExtentReport.extentScreenshot("Search Page");
			// click on search hotel button
			QaRobot.ClickOnElement("search_button");
		} else if (DashboardType.equalsIgnoreCase("New")) {
			QaRobot.ClickOnElement("NBookAs");
			Thread.sleep(2000);
			if (TravelerType.equalsIgnoreCase("Administrator") || TravelerType.equalsIgnoreCase("Travel Arranger")) {
				SearchDashboard.selectEmployeeWithID(CorporateTraveller);
			}
			if (SearchType.equalsIgnoreCase("Individual")) {
				QaRobot.ClickOnElement("trip_Busniess");
			} else if (SearchType.equalsIgnoreCase("Dependent")) {
				QaRobot.ClickOnElement("trip_Family");
			}
			TestBase.listofautosuggestion(By.xpath("//div[@id='divHotelName']/p"), CityCode, CityTitle,
					By.xpath("//input[@id='txtHHLCity']"));
			QaExtentReport.test.log(Status.INFO, "<b><i>City Name : </i></b>" + CityCode + "-" + CityTitle);
			Thread.sleep(2000);
			WebElement Radius = QaBrowser.driver.findElement(By.xpath("//select[@id='ddlRadius']"));
			Select selectRadius = new Select(Radius);
			selectRadius.selectByVisibleText(ChooseRadius);
			Thread.sleep(3000);
			QaBrowser.driver
					.findElement(By.xpath("//div[@id='tab2']/div/div[2]/div[2]/div[1]/label/span[2]/span[1]/img"))
					.click();
			Thread.sleep(2000);
			String DateSelection[] = CheckInDate.split("-");
			String year = DateSelection[2];
			String month = DateSelection[1];
			String expDate = DateSelection[0];
			String DateSelection1[] = CheckOutDate.split("-");
			String year1 = DateSelection1[2];
			String month1 = DateSelection1[1];
			String expDate1 = DateSelection1[0];
			selectDateInCalendarHotel(expDate, month, year, expDate1, month1, year1);
			if (SearchType.equalsIgnoreCase("Individual")) {
			} else {
				String[] adultcount = Adult.split(",");
				String[] childcount = Child.split(",");
				Assert.assertFalse(Integer.parseInt(Rooms) > 5, "Invalid Number of Rooms provided" + " - " + Rooms);
				WebElement RoomsH = QaBrowser.driver.findElement(By.xpath("//select[@id='ddlRoom']"));
				Select selectRooms = new Select(RoomsH);
				selectRooms.selectByVisibleText(Rooms);
				for (int i = 1; i <= Integer.parseInt(Rooms); i++) {
					WebElement adultelement = QaBrowser.driver
							.findElement(By.xpath("//select[@id='ddlHHLAdultR" + i + "']"));
					Select selectadult = new Select(adultelement);
					selectadult.selectByVisibleText(adultcount[i - 1]);
					Thread.sleep(2000);

					WebElement childelement = QaBrowser.driver
							.findElement(By.xpath("//select[@id='ddlHHLChildR" + i + "']"));
					Select selectchild = new Select(childelement);
					selectchild.selectByValue(childcount[i - 1]);
					Thread.sleep(2000);
				}
				String[] ageofchild = ChildAge.split(",");
				for (String chd : childcount) {
					int chdcount = Integer.parseInt(chd);
					for (int i = 1; i <= chdcount; i++) {
						String ac = ageofchild[i - 1];
						Assert.assertFalse(Integer.parseInt(ac) > 11, "Invalid Child Age Selection" + " : " + ac);
						WebElement childrenage = QaBrowser.driver
								.findElement(By.xpath("//select[@id='ddlHHLChild" + i + "R" + chdcount + "']"));
						Select selectage = new Select(childrenage);
						selectage.selectByValue(ageofchild[i - 1]);
						Thread.sleep(2000);
					}
				}
			}
//			QaRobot.ClickOnElement("HotelPolicyCheckJ");
			try {
				QaExtentReport.extentScreenshot("Search Page");
				QaRobot.ClickOnElement("FinalSearchHJ");
			} catch (Exception e) {
				throw (e);
			}
		}
		if (SearchRuleStatus.equalsIgnoreCase("Applied")) {
//			QaRobot.switchToWindow();
//			SoftAssert softAssert = new SoftAssert();
//			int pAS1 = Integer.parseInt(RSqty);
//			if (pAS1 == 1) {
//				for (int k = 1; k <= pAS1; k++) {
//					String[] tN1 = RulesAppliedOnSearchPage.split(",");
//					String b1 = tN1[k - 1];
//					if (QaBrowser.driver.getPageSource().contains(b1)) {
//						Thread.sleep(3000);
//						QaBrowser.driver.findElement(By.xpath("(//*[contains(text(),'" + b1 + "')])[1]")).isDisplayed();
//						Thread.sleep(3000);
//						QaExtentReport.extentScreenshot(b1 + "-" + "Rule is Working on Search Page");
//					} else {
//						softAssert.assertTrue(false, b1 + "-" + "Rule is not Working on Search Page");
////						Assert.assertTrue(false, b1 + " " + "Rule is not Working");
//					}
//				}
//			} else {
//				for (int k = 1; k <= pAS1; k++) {
//					String[] tN1 = RulesAppliedOnSearchPage.split(",");
//					String b1 = tN1[k - 1];
//					if (QaBrowser.driver.getPageSource().contains(b1)) {
////						Thread.sleep(3000);
//						QaBrowser.driver.findElement(By.xpath("(//*[contains(text(),'" + b1 + "')])[1]")).isDisplayed();
//						Thread.sleep(2000);
//						QaExtentReport.extentScreenshot(b1 + "-" + "Rule is Working on Search Page");
////						Thread.sleep(3000);
////						QaRobot.ClickOnElement("NextPicture");
//					} else {
//						softAssert.assertTrue(false, b1 + "-" + "Rule is not Working on Search Page");
////						Assert.assertTrue(false, b1 + " " + "Rule is not Working");
//					}
//				}
//			}
//			softAssert.assertAll();

//			List<WebElement> listOfRights1 = QaBrowser.driver.findElements(By.xpath("//div[@id='IMdivimage']/div/div/div/div/marquee/p"));
//			for (WebElement autoRights1 : listOfRights1) {
//				String abc = autoRights1.getText();
//				System.out.println(abc);
//				String[] tN1 = RulesNotAppliedOnSearchPage.split(",");
//				if(autoRights1.getText().equalsIgnoreCase(tN1[0])||autoRights1.getText().equalsIgnoreCase(tN1[1])||autoRights1.getText().equalsIgnoreCase(tN1[2])||autoRights1.getText().equalsIgnoreCase(tN1[3])||autoRights1.getText().equalsIgnoreCase(tN1[4])||autoRights1.getText().equalsIgnoreCase(tN1[5])) {
//					Assert.assertTrue(false,abc + "Rule is Extra Working");
//				}
//			}
			QaRobot.ClickOnElement("OkContinue");
		}
		Thread.sleep(40000);

//		QaRobot.explicitwaitinvisible(300, By.xpath("div[@class='loadbar ld_hotel']"));

		// No result found
//		if (QaBrowser.driver.findElement(By.xpath("//div[@id='NoResultmsg']/div/h1")).isDisplayed()) {
//			// fail the test case and screenshot
////			String resultnotfound = Logger.takeScreenshot(QaBrowser.driver, "D:\\Screenshot\\resultnotfound.png");
////			QaExtentReport.test.log(Status.FAIL, "Results are not found");
//		} else {

		// explicit wait till loader invisible
//			QaRobot.explicitwaitinvisible(200, By.xpath("//i[@class='htl-rslt-loader-img']"));

		// click on Prefered check ALL
//			QaRobot.ClickOnElement("PreferedChkAll");
//			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Prefered check</i></b>");

		// screenshot of result page
		// String resultpage = Logger.takeScreenshot(QaBrowser.driver,
		// "D:\\Screenshot\\resultpage.png");
		// QaExtentReport.test.log(Status.INFO, "Result page " + resultpage + "");
//			QaExtentReport.extentScreenshot("Result Page");

		// get price on result page
//			String resultPrice = QaBrowser.driver.findElement(By.xpath("(//p[@class='price_bonus_count'])[" + tripindex + "]")).getText();
//			System.out.println("Result page price is " + resultPrice);
//			QaExtentReport.test.log(Status.INFO, "<b><i>Result page price is </i></b>" + resultPrice);
//			String[] p = resultPrice.split(" ");
//			resultPagePrice = p[1];

		// get text of element that start start from 1
//			String policytype = QaBrowser.driver
//					.findElement(By.xpath("//div[@id='hotel_price_con" + PolicyIndex + "']/div/div/span")).getText();
//			System.out.println(policytype);
//			// click on select room button with indexing (starting from 11)
//			int bookingIndex = Integer.parseInt(BookNowIndex);
//			QaBrowser.driver.findElement(By.xpath("//p[@id='htlrm0" + (bookingIndex + 10) + "']")).click();

		// wait for loader

//			QaRobot.explicitwaitinvisible(60, By.xpath("(//div[@id='page_preloader'])[1]"));

		// get current url

		String url = QaBrowser.driver.getCurrentUrl();
		String[] uid = url.split("=");
		QaExtentReport.test.log(Status.INFO, "<b><i>Session id is </i></b>" + uid[1]);

		String DateSelection[] = CheckInDateM.split("-");
		String year = DateSelection[2];
		String month = DateSelection[1];
		String expDate = DateSelection[0];

		String DateSelection1[] = CheckOutDateM.split("-");
		String year1 = DateSelection1[2];
		String month1 = DateSelection1[1];
		String expDate1 = DateSelection1[0];

		if (ModifySearch.equalsIgnoreCase("Yes")) {
			QaRobot.ClickOnElement("TModifySearchH");
//			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Modify Search</i></b>");

			if (ChangeTripLocation.equalsIgnoreCase("Yes")) {
				TestBase.listofautosuggestion5(By.xpath("//div[@id='ModifydivHTCity']/p"), CityCodeM, CityTitleM,
						By.xpath("//input[@id='txtHotelSearch']"));
				QaExtentReport.test.log(Status.INFO,
						"<b><i>Modified City Name : </i></b>" + CityCodeM + "-" + CityTitleM);
				Thread.sleep(2000);
			}

			if (ChangeTripDate.equalsIgnoreCase("Yes")) {
				QaBrowser.driver.findElement(By.xpath("(//img[@alt='Popup'])[1]")).click();
				Thread.sleep(2000);

				selectDateInCalendarHotel(expDate, month, year, expDate1, month1, year1);
			}

			if (ChangeRooms.equalsIgnoreCase("Yes")) {
				int room = Integer.parseInt(RoomsM);
				String[] adultcount = AdultM.split(",");
				String[] childcount = ChildM.split(",");

				if (room > 5) {
//					throw new B2cExceptionClass("Invalid Number of Rooms provided " + " : " + room);
				} else {
					WebElement roomelement = QaBrowser.driver.findElement(By.xpath("//select[@id='HtlRooms']"));
					Select selectroom = new Select(roomelement);
					selectroom.selectByValue(RoomsM);
					Thread.sleep(2000);

					for (int i = 1; i <= room; i++) {
						WebElement adultelement = QaBrowser.driver
								.findElement(By.xpath("//select[@id='htlsltadult" + i + "']"));
						Select selectadult = new Select(adultelement);
						selectadult.selectByValue(adultcount[i - 1]);
						Thread.sleep(2000);

						WebElement childelement = QaBrowser.driver
								.findElement(By.xpath("//select[@id='HtlChildSlt" + i + "']"));
						Select selectchild = new Select(childelement);
						selectchild.selectByValue(childcount[i - 1]);
						Thread.sleep(2000);
					}

					String[] ageofchild = ChildAgeM.split(",");
					for (String chd : childcount) {
						int chdcount = Integer.parseInt(chd);
						for (int i = 1; i <= chdcount; i++) {
							String ac = ageofchild[i - 1];
							int ac1 = Integer.parseInt(ac);

							if (ac1 > 17) {
								QaExtentReport.test.log(Status.FAIL,
										"<b><i>Invalid Child Age Selection</i></b>" + " : " + ac1);
//								throw new B2cExceptionClass("Invalid Child Age Selection" + " : " + ac1);
							} else {
								WebElement childrenage = QaBrowser.driver
										.findElement(By.xpath("//select[@id='htl" + chdcount + "child" + i + "age']"));
								Select selectage = new Select(childrenage);
								selectage.selectByValue(ageofchild[i - 1]);
								Thread.sleep(2000);
							}
						}
					}
				}
			}

			if (ChangeRadius.equalsIgnoreCase("Yes")) {
				WebElement Radius = QaBrowser.driver.findElement(By.xpath("//select[@id='ddlRadius']"));
				Select selectRadius = new Select(Radius);
				selectRadius.selectByVisibleText(ChooseRadiusM);
				Thread.sleep(2000);
			}

			QaRobot.ClickOnElement("TModifiedSearchMH");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Modified Search</i></b>");
		}
		Thread.sleep(10000);
		QaRobot.scrollPage(400);
		QaRobot.ClickOnElement("HotelSelectC");
		Thread.sleep(3000);
//			QaRobot.ClickOnElement("CancellationPolicy");
//			Thread.sleep(3000);
//			QaExtentReport.extentScreenshot("CancellationPolicy");
//			String ParentWindow4 = QaBrowser.driver.getWindowHandle();
//			Set<String> handles4 = QaBrowser.driver.getWindowHandles();
//			for (String childWindow4 : handles4) {
//				if (!childWindow4.equals(ParentWindow4))
//					QaBrowser.driver.switchTo().window(childWindow4);
//			}
//			QaRobot.ClickOnElement("CPClose");
//			Thread.sleep(2000);
//			QaBrowser.driver.switchTo().window(ParentWindow4);
//			QaRobot.ClickOnElement("FareBreakup");
//			Thread.sleep(2000);
//			QaRobot.ClickOnElement("CustomerCostH");
//			Thread.sleep(3000);
//			QaExtentReport.extentScreenshot("CustomerCost");
//			QaRobot.ClickOnElement("CompanyCostH");
//			Thread.sleep(3000);
//			QaExtentReport.extentScreenshot("CompanyCost");
//			String ParentWindow5 = QaBrowser.driver.getWindowHandle();
//			Set<String> handles5 = QaBrowser.driver.getWindowHandles();
//			for (String childWindow5 : handles5) {
//				if (!childWindow5.equals(ParentWindow5))
//					QaBrowser.driver.switchTo().window(childWindow5);
//			}
//			QaRobot.ClickOnElement("FareBreakupClose");
//			Thread.sleep(2000);
//			QaBrowser.driver.switchTo().window(ParentWindow5);
		if (Resultpagestep.equalsIgnoreCase("Add to Cart")) {
			if (DashboardType.equalsIgnoreCase("Old")) {
//					if (Server.equalsIgnoreCase("Staging") || Server.equalsIgnoreCase("Xchange")) {
//						String getT = QaBrowser.driver.findElement(By.xpath("(//span[contains(@id,'Policy3')])[3]"))
//								.getText();
//						QaExtentReport.extentScreenshot("Flight Results");
//						QaRobot.ClickOnElement("AddToCartHotelCX");
//						if (getT.equalsIgnoreCase("Out Of Policy")) {
//							QaRobot.alertAccept();
//						}
//					} else if (Server.equalsIgnoreCase("tpstg")) {
//						String getT = QaBrowser.driver.findElement(By.xpath("(//span[contains(@id,'Policy4')])[3]"))
//								.getText();
//						QaExtentReport.extentScreenshot("Flight Results");
//						QaRobot.ClickOnElement("AddToCartHotelCX");
//						if (getT.equalsIgnoreCase("Out Of Policy")) {
//							QaRobot.alertAccept();
//						}
//					}
			} else if (DashboardType.equalsIgnoreCase("New")) {
				if (ccode.equalsIgnoreCase("Live")) {
					String getT = QaBrowser.driver.findElement(By.xpath("(//span[contains(@id,'Policy3')])[3]"))
							.getText();
					QaExtentReport.extentScreenshot("Hotel Results");
					QaRobot.ClickOnElement("AddToCartHotelCX");
					if (getT.equalsIgnoreCase("Out Of Policy")) {
						QaRobot.alertAccept();
					}
				} else {
					String getT = QaBrowser.driver.findElement(By.xpath("(//span[contains(@id,'Policy1')])[3]"))
							.getText();
					QaExtentReport.extentScreenshot("Hotel Results");
					QaRobot.ClickOnElement("AddToCartHotelCX");
					if (getT.equalsIgnoreCase("Out Of Policy")) {
						QaRobot.alertAccept();
					}
				}
				QaRobot.switchToWindow();
				QaRobot.ClickOnElement("HotelNotificationCloseC");
				QaRobot.scrollPage(-400);
				QaRobot.ClickOnElement("YourItineraryFJ");
				Thread.sleep(5000);
				QaExtentReport.extentScreenshot("Your Itinerary");
				QaRobot.switchToWindow();
				if (ProductType.equalsIgnoreCase("Hotel")) {
					if (ccode.equalsIgnoreCase("Live")) {
						QaRobot.ClickOnElement("ProceedToCheckoutC");
					} else {
						QaRobot.ClickOnElement("ProceedToCheckoutCN");
					}

				} else if (ProductType.equalsIgnoreCase("Hotel+Flight")) {
//						addFlight(Server, Trip, ProductType, TripType, OriginCityCode, OriginLocation, DestinationCityCode,
//								DestinationLocation, DepartureDate, ReturnDate);
					QaRobot.switchToWindow();
					QaRobot.ClickOnElement("ProceedToCheckoutC");
				} else if (ProductType.equalsIgnoreCase("Hotel+Car")) {
//						addCar(Server, ProductType, PickUpCode, PickUpCity, PickUpDate, DropOffDate, DriversAge);
					QaRobot.switchToWindow();
					if (SelectItineraryAs.equalsIgnoreCase("SendForApproval")) {
						String getT1 = QaBrowser.driver.findElement(By.xpath(
								"//div[@id='tdContent']/div[1]/div[3]/div/div/div[3]/div[1]/div/div/div[1]/ul/li[1]/div/span"))
								.getText();
						System.out.println(getT1);
						String getTxt1[] = getT1.split(" ");
						String Enquiryid = getTxt1[2];
						System.out.println(Enquiryid);
						QaExtentReport.test.log(Status.INFO, "<b><i>Enquiry id is </i></b>" + Enquiryid);
						QaRobot.ClickOnElement("SendForApprovalF");
						QaRobot.switchToWindow();
						QaRobot.PassValue("TextAreaF", "Test");
						QaRobot.ClickOnElement("SendF");
						QaRobot.alertAccept();
						Thread.sleep(3000);
						QaRobot.alertAccept();
						Thread.sleep(3000);
						QaRobot.mouseHover("//a[@id='HeaderTop_aBookingMenu']",
								"//span[@id='HeaderTop_lblEnquiryQueue']");
						Thread.sleep(3000);
						QaRobot.ClickOnElement("Additionalsearch");
						QaRobot.PassValue("EnterEnquiryId", Enquiryid);
						QaRobot.ClickOnElement("Search");
						QaRobot.ClickOnElement("Book");
						QaRobot.ClickOnElement("ProceedToCheckoutC");
					} else if (SelectItineraryAs.equalsIgnoreCase("ProceedToCheckout")) {
						QaRobot.ClickOnElement("ProceedToCheckoutC");
					}
				} else if (ProductType.equalsIgnoreCase("Hotel+Flight+Car")) {
//						addFlight(Server, Trip, ProductType, TripType, OriginCityCode, OriginLocation, DestinationCityCode,
//								DestinationLocation, DepartureDate, ReturnDate);
//						addCar(Server, ProductType, PickUpCode, PickUpCity, PickUpDate, DropOffDate, DriversAge);
					QaRobot.switchToWindow();
					if (SelectItineraryAs.equalsIgnoreCase("SendForApproval")) {
						String getT1 = QaBrowser.driver.findElement(By.xpath(
								"//div[@id='tdContent']/div[1]/div[3]/div/div/div[3]/div[1]/div/div/div[1]/ul/li[1]/div/span"))
								.getText();
						System.out.println(getT1);
						String getTxt1[] = getT1.split(" ");
						String Enquiryid = getTxt1[2];
						System.out.println(Enquiryid);
						QaExtentReport.test.log(Status.INFO, "<b><i>Enquiry id is </i></b>" + Enquiryid);
						QaRobot.ClickOnElement("SendForApprovalF");
						QaRobot.switchToWindow();
						QaRobot.PassValue("TextAreaF", "Test");
						QaRobot.ClickOnElement("SendF");
						QaRobot.alertAccept();
						Thread.sleep(3000);
						QaRobot.alertAccept();
						Thread.sleep(3000);
						QaRobot.mouseHover("//a[@id='HeaderTop_aBookingMenu']",
								"//span[@id='HeaderTop_lblEnquiryQueue']");
						Thread.sleep(3000);
						QaRobot.ClickOnElement("Additionalsearch");
						QaRobot.PassValue("EnterEnquiryId", Enquiryid);
						QaRobot.ClickOnElement("Search");
						QaRobot.ClickOnElement("Book");
						QaRobot.ClickOnElement("ProceedToCheckoutC");
					} else if (SelectItineraryAs.equalsIgnoreCase("ProceedToCheckout")) {
						QaRobot.ClickOnElement("ProceedToCheckoutC");
					}
				} else if (ProductType.equalsIgnoreCase("Hotel+Car+Flight")) {
//						addCar(Server, ProductType, PickUpCode, PickUpCity, PickUpDate, DropOffDate, DriversAge);
//						addFlight(Server, Trip, ProductType, TripType, OriginCityCode, OriginLocation, DestinationCityCode,
//								DestinationLocation, DepartureDate, ReturnDate);
					QaRobot.switchToWindow();
					if (SelectItineraryAs.equalsIgnoreCase("SendForApproval")) {
						String getT1 = QaBrowser.driver.findElement(By.xpath(
								"//div[@id='tdContent']/div[1]/div[3]/div/div/div[3]/div[1]/div/div/div[1]/ul/li[1]/div/span"))
								.getText();
						System.out.println(getT1);
						String getTxt1[] = getT1.split(" ");
						String Enquiryid = getTxt1[2];
						System.out.println(Enquiryid);
						QaExtentReport.test.log(Status.INFO, "<b><i>Enquiry id is </i></b>" + Enquiryid);
						QaRobot.ClickOnElement("SendForApprovalF");
						QaRobot.switchToWindow();
						QaRobot.PassValue("TextAreaF", "Test");
						QaRobot.ClickOnElement("SendF");
						QaRobot.alertAccept();
						Thread.sleep(3000);
						QaRobot.alertAccept();
						Thread.sleep(3000);
						QaRobot.mouseHover("//a[@id='HeaderTop_aBookingMenu']",
								"//span[@id='HeaderTop_lblEnquiryQueue']");
						Thread.sleep(3000);
						QaRobot.ClickOnElement("Additionalsearch");
						QaRobot.PassValue("EnterEnquiryId", Enquiryid);
						QaRobot.ClickOnElement("Search");
						QaRobot.ClickOnElement("Book");
						QaRobot.ClickOnElement("ProceedToCheckoutC");
					} else if (SelectItineraryAs.equalsIgnoreCase("ProceedToCheckout")) {
						QaRobot.ClickOnElement("ProceedToCheckoutC");
					}
				}
				if (SearchType.equalsIgnoreCase("Individual")) {
//					checkoutForHotelNew(ccode, SearchType, ProductType, QuoteTitle, QuoteRemark, Checkoutpagestep, FOP,
//							CardType, CreditCardNumber, CardHolderName, CardExpiryDate, CreatedBy);
				} else if (SearchType.equalsIgnoreCase("Dependent")) {
//						SBT_JOLO_CheckoutPage.checkoutForCar(CreatorName, TravellerType, ProductType, QuoteTitle, QuoteRemark,
//								Checkoutpagestep, FOP, CardType, CreditCardNumber, CardHolderName, CardExpiryDate);
				}
			}
		}

//			if (Resultpagestep.equalsIgnoreCase("Trip Request")) {
//				SBTResultPage.hotelTripRequest(TripRequestIndex, policytype, resultPagePrice);
//			}
//			if (Resultpagestep.equalsIgnoreCase("Hotel Book")) {
//				QaBrowser.driver.findElement(By.xpath("//div[@id='nrm_box_1']/div[2]/label[1]/div[5]/p[1]/a")).click();
////				QaBrowser.driver.findElement(By.xpath("(//a[text()='BOOK'])[1]")).click();
//				if (policytype.equalsIgnoreCase("Out Of Policy")) {
//					QaBrowser.driver.switchTo().alert().accept();
//				}
//				// explicit wait till terms and condition check box visible
////				QaRobot.explicitwaitvisible(180, By.xpath("//input[@id='ctl00_contentMain_chkTerms']"));
//				String chkoutPrice = QaBrowser.driver
//						.findElement(By.xpath("//span[@id='ctl00_contentMain_totcashPrice_HHL']")).getText();
//				System.out.println("Price on checkout page is " + chkoutPrice);
//				QaExtentReport.test.log(Status.INFO, "<b><i>Price on checkout page is  </i></b>" + chkoutPrice);
//				WebElement element = QaBrowser.driver
//						.findElement(By.xpath("//select[@id='ctl00_contentMain_CorporateFDReasonDDLHHL']"));
//				Select sel = new Select(element);
//				sel.selectByIndex(1);
//
//				if (Checkoutpagestep.equalsIgnoreCase("Quote")) {
////					QaExtentReport.extentScreenshot("Checkout Page");
////					SBTCheckoutPayment.checkoutHotelQuote(hotelReasonCode, hotelRemarks);
//				} else if (Checkoutpagestep.equalsIgnoreCase("Fullfillment")) {
//					QaRobot.ClickOnElement("ow_chkterms");
////					QaExtentReport.test.log(Status.INFO, "<b><i>check the terms and condition</i></b>");
//					QaExtentReport.extentScreenshot("Checkout Page");
//					QaRobot.ClickOnElement("ow_chkbook");
////					QaExtentReport.test.log(Status.INFO,
////							"<b><i>book button to proceed the booking from checkout page</i></b>");
//					if (QaBrowser.driver.findElement(By.xpath("//p[@id='ContractDetails']")).isDisplayed()) {
//						String details = QaBrowser.driver.findElement(By.xpath("//p[@id='ContractDetails']")).getText();
//						System.out.println(details);
//						QaExtentReport.test.log(Status.FAIL,
//								"Unable to proceed booking due to getting no availabilty in hotel " + details);
//						fail("Unable to proceed booking due to getting no availabilty in hotel");
//					}
//					// accept alert to proceed from checkout page
//					// QaBrowser.driver.switchTo().alert().accept();
//					// wait till payment page display
////					QaRobot.explicitwaitvisible(300, By.xpath("//div[@class='value_package_details']"));
//
//					// screenshot of Payment page
////					String paymentpage = Logger.takeScreenshot(QaBrowser.driver, "D:\\Screenshot\\paymentpage.png");
////					QaExtentReport.test.log(Status.INFO, "Payment Page " + paymentpage + "");
//					// get price on Payment page
//					String paymentPrice = QaBrowser.driver
//							.findElement(By.xpath("//span[@id='ctl00_contentMain_lblTAmt']")).getText();
//					System.out.println("Price on Payment page is " + paymentPrice);
//					QaExtentReport.test.log(Status.INFO, "<b><i>Price on Payment page is  </i></b>" + paymentPrice);
//					if (fop.equalsIgnoreCase("Cash")) {
//						QaRobot.selectTextFromDropdown("ow_selectcard1", card, "Selected card: " + card);
//						QaRobot.ClickOnElement("click_OK");
//						QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Ok button</i></b>");
//						QaRobot.PassValue("ow_receiptno", receiptno);
//						QaExtentReport.test.log(Status.INFO, "<b><i>receipt number is: </i></b>" + receiptno);
////						SBTCheckoutPayment.fopCash(fop, receiptno);
//					} else if (fop.equalsIgnoreCase("Bill To Company")) {
//						QaRobot.selectTextFromDropdown("ow_selectcard1", card, "Selected card: " + card);
////						SBTCheckoutPayment.fopBillToComapnay(fop);
//					} else {
//						QaRobot.ClickOnElement("click_OK");
//						if (cardType.equalsIgnoreCase("Master Card")) {
//							QaRobot.selectTextFromDropdown("ow_selectcardtype", cardType, "Selected master card");
//							QaRobot.ClickOnElement("ow_paymentprocced");
//							QaRobot.selectTextFromDropdown("ow_selectcard1", card, "Selected card: " + card);
//							QaRobot.ClickOnElement("click_OK");
//						} else if (cardType.equalsIgnoreCase("visa")) {
//							QaRobot.selectTextFromDropdown("ow_selectcardtype", cardType, "Selected visa card");
//							QaRobot.ClickOnElement("ow_paymentprocced");
//							QaRobot.selectTextFromDropdown("ow_selectcard1", card, "Selected card: " + card);
//							QaRobot.ClickOnElement("click_OK");
//						}
//		}

//					if (fop.equalsIgnoreCase("Cash")) 
//					{
//						SBTCheckoutPayment.fopCash(fop, receiptno);
//					}
//					else if (fop.equalsIgnoreCase("Bill To Company")) 
//					{
//						SBTCheckoutPayment.fopBillToComapnay(fop);
//					} 
//					else0 
//					{
//						SBTCheckoutPayment.fopCreditDebit(card, cardType, cvv);
//					}

//		QaExtentReport.extentScreenshot("Payment Page");
//		QaRobot.ClickOnElement("ow_paymentprocced");
////					QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on procced button</i></b>");
//		Thread.sleep(1000);
//		// screenshot of Confirmation page
////					String confirmpage = Logger.takeScreenshot(QaBrowser.driver, "D:\\Screenshot\\confirmpage.png");
////					QaExtentReport.test.log(Status.INFO, "Confirmation page " + confirmpage + "");
//
//		// booking status
//		String bookingStatus = QaBrowser.driver.findElement(By.xpath("//span[@class='nc_status_color']")).getText();
//		System.out.println("Booking Status is " + bookingStatus);
//		QaExtentReport.test.log(Status.INFO, "<b><i>Booking Status is </i></b>" + bookingStatus);
//		// Confirmation code
//		String confirmationCode = QaBrowser.driver.findElement(By.xpath("//p[@class='nc_status_p']")).getText();
//		System.out.println("Confirmation code is " + confirmationCode);
//		QaExtentReport.test.log(Status.INFO, "<b><i>Confirmation code is </i></b>" + confirmationCode);
//		// Confirm page price
//		String confirmePrice = QaBrowser.driver.findElement(By.xpath("(//div[@class='nc_fcelllast'])[3]")).getText();
//		System.out.println("Confirm Page Price is " + confirmePrice);
//		QaExtentReport.test.log(Status.INFO, "<b><i>Confirm Page Price is </i></b>" + confirmePrice);
//		// Booking id
//		String bookingID = QaBrowser.driver.findElement(By.xpath("//span[@class='nc_bookid_no']")).getText();
//		String a[] = bookingID.split(" ");
//		String number = a[2];
//		System.out.println("Booking ID is " + bookingID);
//		QaExtentReport.test.log(Status.INFO, "<b><i>Booking ID is </i></b>" + bookingID);
//		QaExtentReport.extentScreenshot("Confirm Page");
//
//		QaRobot.mouseHover("//a[@id='ctl00_HeaderTop_aBookingMenu']", "//span[@id='ctl00_HeaderTop_lblBookingQueue']");
//		QaExtentReport.extentScreenshot("CorporateDashboard Page");
//		Thread.sleep(3000);
//		QaRobot.PassValue("RefNo", number);
//		QaExtentReport.test.log(Status.INFO, "<b><i>Write Ref No</i></b>");
//		QaRobot.ClickOnElement("SearchRefNo");
//		QaRobot.ClickOnElement("RefBooking");
//		QaExtentReport.extentScreenshot("Booking Card");
//		String Creater = QaBrowser.driver.findElement(By.xpath("//span[@id='lblCreatedBy']")).getText();
//		System.out.println("Created By " + Creater);
//		QaExtentReport.test.log(Status.INFO, "<b><i>Created By </i></b>" + Creater);
//		if (CreatedBy.equalsIgnoreCase(Creater)) {
//			QaExtentReport.test.log(Status.INFO, "<b><i>Creater is Correct  </i></b>" + CreatedBy);
//		} else {
//			QaExtentReport.test.log(Status.FAIL, "<b><i>Creater is Different  </i></b>" + CreatedBy);
//		}
//				}
		// Click on home page
		// QaBrowser.driver.findElement(By.xpath("//img[@id='ctl00_HeaderTop_imgCompanyWise']")).click();
//			}
	}

//	}

	@AfterTest
	public static void After_Test() {
		QaExtentReport.test.getExtent().flush();
	}

	public static void checkoutForHotelNew(String ccode, String SearchType, String ProductType, String QuoteTitle,
			String QuoteRemark, String Checkoutpagestep, String FOP, String CardType, String CreditCardNumber,
			String CardHolderName, String CardExpiryDate, String CreatedBy) throws Exception {
		if (SearchType.equalsIgnoreCase("Individual")) {
			QaExtentReport.extentScreenshot("Checkout Page");
			QaRobot.scrollPage(400);
			if (ProductType.equalsIgnoreCase("Hotel")) {
				QaRobot.selectIndexFromDropdown("ResonCodeCN", 1);
				QaRobot.ClickOnElement("BillToBranchC");
			} else if (ProductType.equalsIgnoreCase("Hotel+Flight")) {
				if (ccode.equalsIgnoreCase("Staging")) {
					QaRobot.selectIndexFromDropdown("AirResonCodeC", 1);
				}
				QaRobot.ClickOnElement("BillToBranchC");
			} else if (ProductType.equalsIgnoreCase("Hotel+Car")) {
				QaRobot.selectTextByLocator("//select[@id='ctl00_contentMain_ddl_titleAdt_H']", "Mr");
				if (ccode.equalsIgnoreCase("Staging")) {
					QaRobot.selectIndexFromDropdown("HotelResonCodeC", 1);
				}
				QaRobot.ClickOnElement("BillToBranchC");
			} else if (ProductType.equalsIgnoreCase("Hotel+Flight+Car")
					|| ProductType.equalsIgnoreCase("Hotel+Car+Flight")) {
				if (ccode.equalsIgnoreCase("Staging")) {
					QaRobot.selectIndexFromDropdown("AirResonCodeC", 1);
					QaRobot.selectIndexFromDropdown("HotelResonCodeC", 1);
				}
				QaRobot.ClickOnElement("BillToBranchC");
			}
			QaRobot.ClickOnElement("TermsAndConditionC");
			bookForHotelNew(ProductType, QuoteTitle, QuoteRemark, Checkoutpagestep, FOP, CardType, CreditCardNumber,
					CardHolderName, CardExpiryDate, CreatedBy);
		} else if (SearchType.equalsIgnoreCase("Dependent")) {

		}
	}

	public static void bookForHotelNew(String ProductType, String QuoteTitle, String QuoteRemark,
			String Checkoutpagestep, String FOP, String CardType, String CreditCardNumber, String CardHolderName,
			String CardExpiryDate, String CreatedBy) throws Exception {
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
//			SBT_JOLO_PaymentPage.cardPayment(ProductType, FOP, CardType, CreditCardNumber, CardHolderName,
//					CardExpiryDate);
//			confirmpageCarNew(CreatedBy);
		}
	}

	public static void confirmpageCarNew(String CreatorName) throws Exception {
		String getT = QaBrowser.driver
				.findElement(By.xpath("//div[@id='ctl00_tdContent']/section/div[2]/div/div/div[1]/h2/span")).getText();
		String getTxt1[] = getT.split("-");
		String number = getTxt1[1];
		System.out.println(number);
		QaExtentReport.test.log(Status.INFO, "<b><i>Booking id is </i></b>" + number);
		String getT11 = QaBrowser.driver.findElement(By.xpath("//div[@id='nc_status']/p")).getText();
		System.out.println(getT11);
		String getTxt2[] = getT11.split(" ");
		String number1 = getTxt2[0];
		System.out.println(number1);
		Assert.assertEquals(number1, "Confirmed", "Booking Status");
		QaExtentReport.test.log(Status.INFO, "<b><i>Booking Status is </i></b>" + number1);
//		
//		WebElement getT2 = QaBrowser.driver
//				.findElement(By.xpath("//div[@id='ctl00_contentMain_flt_details']/div/div[1]/div[2]/p/span[2]"));
//		String getTxt4 = getT2.getText();
//		String getTxt5[] = getTxt4.split(" ");
		String number2 = getTxt2[2];
		System.out.println(number2);
		QaExtentReport.test.log(Status.INFO, "<b><i>Res Number is </i></b>" + number2);
		QaExtentReport.extentScreenshot("Confirm Page");
		QaRobot.mouseHover("//a[@id='ctl00_HeaderTop_aBookingMenu']", "//span[@id='ctl00_HeaderTop_lblBookingQueue']");
		QaExtentReport.extentScreenshot("CorporateDashboard Page");
		Thread.sleep(3000);
		QaRobot.PassValue("RefNo", number);
		QaRobot.ClickOnElement("SearchRefNo");
		QaRobot.ClickOnElement("RefBooking");
		QaExtentReport.extentScreenshot("Booking Card");
		String Creater = QaBrowser.driver.findElement(By.xpath("//span[@id='lblCreatedBy']")).getText();
		QaExtentReport.test.log(Status.INFO, "<b><i>Created By </i></b>" + Creater);
		Assert.assertTrue(CreatorName.equalsIgnoreCase(Creater), "Creater name is not Present");
	}

	public static void selectDateInCalendarHotel(String Day, String Month, String Year, String Day1, String Month1,
			String Year1) throws Exception {
		Date date = new Date();
		DateFormat d = new SimpleDateFormat("dd-MM-yyyy");
		String NewDate = d.format(date);
		Date date1 = d.parse(NewDate);
//		System.out.println(date1);

		String currentMonthNumber = "00";
		if (Month.equalsIgnoreCase("Jan")) {
			currentMonthNumber = "01";
		} else if (Month.equalsIgnoreCase("Feb")) {
			currentMonthNumber = "02";
		} else if (Month.equalsIgnoreCase("Mar")) {
			currentMonthNumber = "03";
		} else if (Month.equalsIgnoreCase("Apr")) {
			currentMonthNumber = "04";
		} else if (Month.equalsIgnoreCase("May")) {
			currentMonthNumber = "05";
		} else if (Month.equalsIgnoreCase("Jun")) {
			currentMonthNumber = "06";
		} else if (Month.equalsIgnoreCase("Jul")) {
			currentMonthNumber = "07";
		} else if (Month.equalsIgnoreCase("Aug")) {
			currentMonthNumber = "08";
		} else if (Month.equalsIgnoreCase("Sep")) {
			currentMonthNumber = "09";
		} else if (Month.equalsIgnoreCase("Oct")) {
			currentMonthNumber = "10";
		} else if (Month.equalsIgnoreCase("Nov")) {
			currentMonthNumber = "11";
		} else if (Month.equalsIgnoreCase("Dec")) {
			currentMonthNumber = "12";
		}

		Date date2 = d.parse(Day + "-" + Integer.parseInt(currentMonthNumber) + "-" + Year);
//		System.out.println(date2);

		String currentMonthNumber1 = "00";
		if (Month1.equalsIgnoreCase("Jan")) {
			currentMonthNumber1 = "01";
		} else if (Month1.equalsIgnoreCase("Feb")) {
			currentMonthNumber1 = "02";
		} else if (Month1.equalsIgnoreCase("Mar")) {
			currentMonthNumber1 = "03";
		} else if (Month1.equalsIgnoreCase("Apr")) {
			currentMonthNumber1 = "04";
		} else if (Month1.equalsIgnoreCase("May")) {
			currentMonthNumber1 = "05";
		} else if (Month1.equalsIgnoreCase("Jun")) {
			currentMonthNumber1 = "06";
		} else if (Month1.equalsIgnoreCase("Jul")) {
			currentMonthNumber1 = "07";
		} else if (Month1.equalsIgnoreCase("Aug")) {
			currentMonthNumber1 = "08";
		} else if (Month1.equalsIgnoreCase("Sep")) {
			currentMonthNumber1 = "09";
		} else if (Month1.equalsIgnoreCase("Oct")) {
			currentMonthNumber1 = "10";
		} else if (Month1.equalsIgnoreCase("Nov")) {
			currentMonthNumber1 = "11";
		} else if (Month1.equalsIgnoreCase("Dec")) {
			currentMonthNumber1 = "12";
		}

		Date date3 = d.parse(Day1 + "-" + Integer.parseInt(currentMonthNumber1) + "-" + Year1);
//		System.out.println(date3);

		QaExtentReport.test.log(Status.INFO, "<b><i>Select Departure Date  </i></b>" + Day + "-" + Month + "-" + Year);
		QaExtentReport.test.log(Status.INFO, "<b><i>Select Return Date  </i></b>" + Day1 + "-" + Month1 + "-" + Year1);

		Assert.assertFalse(Integer.parseInt(Day) > 31, "Invalid date provided " + Day + "-" + Month + "-" + Year);
		Assert.assertFalse(Month.equals("Feb") && Integer.parseInt(Day) > 28,
				"Invalid date provided " + Day + "-" + Month + "-" + Year);
		Assert.assertFalse(Integer.parseInt(Day1) > 31, "Invalid date provided " + Day1 + "-" + Month1 + "-" + Year1);
		Assert.assertFalse(Month.equals("Feb") && Integer.parseInt(Day1) > 28,
				"Invalid date provided " + Day1 + "-" + Month1 + "-" + Year1);

		String monthYear = QaBrowser.driver.findElement(By.xpath("/html/body/div[6]/div/div[2]/div[1]/div")).getText();
		String month = monthYear.split(" ")[0];
		String year = monthYear.split(" ")[1];

		Assert.assertFalse(date2.before(date1), "Invalid date provided " + Day + "-" + Month + "-" + Year);
		while (!(month.equals(Month) && year.equals(Year))) {
			QaBrowser.driver.findElement(By.xpath("/html/body/div[6]/div/div[1]/a[3]")).click();
			monthYear = QaBrowser.driver.findElement(By.xpath("/html/body/div[6]/div/div[2]/div[1]/div")).getText();
			month = monthYear.split(" ")[0];
			year = monthYear.split(" ")[1];
		}

		List<WebElement> allDates = QaBrowser.driver
				.findElements(By.xpath("/html/body/div[6]/div/div[2]/div[1]/table/tbody/tr/td"));
		for (WebElement ele : allDates) {
			String dt = ele.getText();
			if (dt.equalsIgnoreCase(Day)) {
				ele.click();
				break;
			}
		}
		Thread.sleep(2000);
		String monthYear1 = QaBrowser.driver.findElement(By.xpath("/html/body/div[6]/div/div[2]/div[1]/div")).getText();
		Thread.sleep(2000);
		String month1 = monthYear1.split(" ")[0];
		String year1 = monthYear1.split(" ")[1];

		Assert.assertFalse(date3.before(date2), "Invalid date provided " + Day1 + "-" + Month1 + "-" + Year1);
		while (!(month1.equals(Month1) && year1.equals(Year1))) {
			QaBrowser.driver.findElement(By.xpath("/html/body/div[6]/div/div[1]/a[3]")).click();
			monthYear1 = QaBrowser.driver.findElement(By.xpath("/html/body/div[6]/div/div[2]/div[1]/div")).getText();
			month1 = monthYear1.split(" ")[0];
			year1 = monthYear1.split(" ")[1];
		}

		List<WebElement> allDates1 = QaBrowser.driver
				.findElements(By.xpath("/html/body/div[6]/div/div[2]/div[1]/table/tbody/tr/td"));
		for (WebElement ele1 : allDates1) {
			String dt1 = ele1.getText();
			if (dt1.equalsIgnoreCase(Day1)) {
				ele1.click();
				break;
			}
		}
	}

	public static void selectDateInCalendarHotelOld(String Day, String Month, String Year, String Day1, String Month1,
			String Year1) throws Exception {
		Date date = new Date();
		DateFormat d = new SimpleDateFormat("dd-MM-yyyy");
		String NewDate = d.format(date);
		Date date1 = d.parse(NewDate);
//		System.out.println(date1);

		String currentMonthNumber = "00";
		if (Month.equalsIgnoreCase("Jan")) {
			currentMonthNumber = "01";
		} else if (Month.equalsIgnoreCase("Feb")) {
			currentMonthNumber = "02";
		} else if (Month.equalsIgnoreCase("Mar")) {
			currentMonthNumber = "03";
		} else if (Month.equalsIgnoreCase("Apr")) {
			currentMonthNumber = "04";
		} else if (Month.equalsIgnoreCase("May")) {
			currentMonthNumber = "05";
		} else if (Month.equalsIgnoreCase("Jun")) {
			currentMonthNumber = "06";
		} else if (Month.equalsIgnoreCase("Jul")) {
			currentMonthNumber = "07";
		} else if (Month.equalsIgnoreCase("Aug")) {
			currentMonthNumber = "08";
		} else if (Month.equalsIgnoreCase("Sep")) {
			currentMonthNumber = "09";
		} else if (Month.equalsIgnoreCase("Oct")) {
			currentMonthNumber = "10";
		} else if (Month.equalsIgnoreCase("Nov")) {
			currentMonthNumber = "11";
		} else if (Month.equalsIgnoreCase("Dec")) {
			currentMonthNumber = "12";
		}

		Date date2 = d.parse(Day + "-" + Integer.parseInt(currentMonthNumber) + "-" + Year);
//		System.out.println(date2);

		String currentMonthNumber1 = "00";
		if (Month1.equalsIgnoreCase("Jan")) {
			currentMonthNumber1 = "01";
		} else if (Month1.equalsIgnoreCase("Feb")) {
			currentMonthNumber1 = "02";
		} else if (Month1.equalsIgnoreCase("Mar")) {
			currentMonthNumber1 = "03";
		} else if (Month1.equalsIgnoreCase("Apr")) {
			currentMonthNumber1 = "04";
		} else if (Month1.equalsIgnoreCase("May")) {
			currentMonthNumber1 = "05";
		} else if (Month1.equalsIgnoreCase("Jun")) {
			currentMonthNumber1 = "06";
		} else if (Month1.equalsIgnoreCase("Jul")) {
			currentMonthNumber1 = "07";
		} else if (Month1.equalsIgnoreCase("Aug")) {
			currentMonthNumber1 = "08";
		} else if (Month1.equalsIgnoreCase("Sep")) {
			currentMonthNumber1 = "09";
		} else if (Month1.equalsIgnoreCase("Oct")) {
			currentMonthNumber1 = "10";
		} else if (Month1.equalsIgnoreCase("Nov")) {
			currentMonthNumber1 = "11";
		} else if (Month1.equalsIgnoreCase("Dec")) {
			currentMonthNumber1 = "12";
		}

		Date date3 = d.parse(Day1 + "-" + Integer.parseInt(currentMonthNumber1) + "-" + Year1);
//		System.out.println(date3);

		QaExtentReport.test.log(Status.INFO, "<b><i>Select Departure Date  </i></b>" + Day + "-" + Month + "-" + Year);
		QaExtentReport.test.log(Status.INFO, "<b><i>Select Return Date  </i></b>" + Day1 + "-" + Month1 + "-" + Year1);

		Assert.assertFalse(Integer.parseInt(Day) > 31, "Invalid date provided " + Day + "-" + Month + "-" + Year);
		Assert.assertFalse(Month.equals("Feb") && Integer.parseInt(Day) > 28,
				"Invalid date provided " + Day + "-" + Month + "-" + Year);
		Assert.assertFalse(Integer.parseInt(Day1) > 31, "Invalid date provided " + Day1 + "-" + Month1 + "-" + Year1);
		Assert.assertFalse(Month.equals("Feb") && Integer.parseInt(Day1) > 28,
				"Invalid date provided " + Day1 + "-" + Month1 + "-" + Year1);

		String monthYear = QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[1]/div")).getText();
		String month = monthYear.split(" ")[0];
		String year = monthYear.split(" ")[1];

		Assert.assertFalse(date2.before(date1), "Invalid date provided " + Day + "-" + Month + "-" + Year);
		while (!(month.equals(Month) && year.equals(Year))) {
			QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/a[3]")).click();
			monthYear = QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[1]/div")).getText();
			month = monthYear.split(" ")[0];
			year = monthYear.split(" ")[1];
		}

		List<WebElement> allDates = QaBrowser.driver
				.findElements(By.xpath("/html/body/div[3]/div/div[2]/div[1]/table/tbody/tr/td"));
		for (WebElement ele : allDates) {
			String dt = ele.getText();
			if (dt.equalsIgnoreCase(Day)) {
				ele.click();
				break;
			}
		}
		Thread.sleep(2000);
		String monthYear1 = QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[1]/div")).getText();
		Thread.sleep(2000);
		String month1 = monthYear1.split(" ")[0];
		String year1 = monthYear1.split(" ")[1];

		Assert.assertFalse(date3.before(date2), "Invalid date provided " + Day1 + "-" + Month1 + "-" + Year1);
		while (!(month1.equals(Month1) && year1.equals(Year1))) {
			QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/a[3]")).click();
			monthYear1 = QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[1]/div")).getText();
			month1 = monthYear1.split(" ")[0];
			year1 = monthYear1.split(" ")[1];
		}

		List<WebElement> allDates1 = QaBrowser.driver
				.findElements(By.xpath("/html/body/div[3]/div/div[2]/div[1]/table/tbody/tr/td"));
		for (WebElement ele1 : allDates1) {
			String dt1 = ele1.getText();
			if (dt1.equalsIgnoreCase(Day1)) {
				ele1.click();
				break;
			}
		}
	}
}
