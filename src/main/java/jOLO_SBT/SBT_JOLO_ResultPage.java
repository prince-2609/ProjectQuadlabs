package jOLO_SBT;

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
import com.aventstack.extentreports.Status;
import Base.TestBase;
import utilities.QaBrowser;
import utilities.QaExtentReport;
import utilities.QaRobot;

public class SBT_JOLO_ResultPage {

	public static void ResultPageForFlight(String CreatorName, String Server, String TravellerType, String Trip,
			String TripType, String adult, String child, String infant, String ModifySearch, String ChangeTrip,
			String TripTypeM, String OriginCityCodeM, String OriginLocationM, String DestinationCityCodeM,
			String DestinationLocationM, String ChangeTripDate, String DepartureDateM, String ReturnDateM,
			String ChangeTravellers, String adultM, String childM, String infantM, String ChangeClass, String ClassM,
			String ShowDirectFlightM, String Applyfilter, String ChooseFareType, String FareType, String ChooseAirLine,
			String OneWayAirLine, String RoundTripAirLine, String OneWayFareType, String RoundTripFareType,
			String Resultpagestep, String ProductType, String CityCode, String CityTitle, String CheckInDate,
			String CheckOutDate, String PickUpCode, String PickUpCity, String PickUpDate, String DropOffDate,
			String PickUpTime, String DropOffTime, String DriversAge, String DropOffToDifferentLocation,
			String DropOffCode, String DropOffCity, String SelectItineraryAs, String QuoteTitle, String QuoteRemark,
			String Checkoutpagestep, String FOP, String CardType, String CreditCardNumber, String CardHolderName,
			String CardExpiryDate) throws Exception {
		Thread.sleep(33000);
		String url = QaBrowser.driver.getCurrentUrl();
		String[] uid = url.split("=");
		QaExtentReport.test.log(Status.INFO, "<b><i>Session id is </i></b>" + uid[1]);
		String DateSelection[] = DepartureDateM.split("-");
		String year = DateSelection[2];
		String month = DateSelection[1];
		String expDate = DateSelection[0];
		String DateSelection1[] = ReturnDateM.split("-");
		String year1 = DateSelection1[2];
		String month1 = DateSelection1[1];
		String expDate1 = DateSelection1[0];
		if (ModifySearch.equalsIgnoreCase("Yes")) {
			QaRobot.ClickOnElement("ModifySearchJ");
			Thread.sleep(3000);
			if (ChangeTrip.equalsIgnoreCase("Yes")) {
				if (TripTypeM.equalsIgnoreCase("OneWay")) {
					QaRobot.ClickOnElement("OneWayMJ");
					Assert.assertFalse(OriginCityCodeM == DestinationCityCodeM,
							"Modified Origin And Destination City Code Can't Be Same");
					Assert.assertFalse(OriginLocationM == DestinationLocationM,
							"Modified Origin And Destination City Location Can't Be Same");
					TestBase.listofautosuggestion4(By.xpath("//div[@id='divDepartureCity0']/p"), OriginCityCodeM,
							OriginLocationM, By.xpath("//input[@id='MtxtDepartureCity0']"));
					QaExtentReport.test.log(Status.INFO,
							"<b><i>Modified Departure city : </i></b>" + OriginCityCodeM + " - " + OriginLocationM);
					Thread.sleep(2000);
					TestBase.listofautosuggestion4(By.xpath("//div[@id='divDestinationCity0']/p"), DestinationCityCodeM,
							DestinationLocationM, By.xpath("//input[@id='MtxtDestinationCity0']"));
					QaExtentReport.test.log(Status.INFO, "<b><i>Modified Arrival city : </i></b>" + DestinationCityCodeM
							+ " - " + DestinationLocationM);
					Thread.sleep(2000);
				} else if (TripTypeM.equalsIgnoreCase("RoundTrip")) {
					QaRobot.ClickOnElement("RoundTripMJ");
					Assert.assertFalse(OriginCityCodeM == DestinationCityCodeM,
							"Modified Origin And Destination City Code Can't Be Same");
					Assert.assertFalse(OriginLocationM == DestinationLocationM,
							"Modified Origin And Destination City Location Can't Be Same");
					TestBase.listofautosuggestion4(By.xpath("//div[@id='divDepartureCity0']/p"), OriginCityCodeM,
							OriginLocationM, By.xpath("//input[@id='MtxtDepartureCity0']"));
					QaExtentReport.test.log(Status.INFO,
							"<b><i>Modified Departure city : </i></b>" + OriginCityCodeM + " - " + OriginLocationM);
					Thread.sleep(2000);
					TestBase.listofautosuggestion4(By.xpath("//div[@id='divDestinationCity0']/p"), DestinationCityCodeM,
							DestinationLocationM, By.xpath("//input[@id='MtxtDestinationCity0']"));
					QaExtentReport.test.log(Status.INFO, "<b><i>Modified Arrival city : </i></b>" + DestinationCityCodeM
							+ " - " + DestinationLocationM);
					Thread.sleep(2000);
				}
			}
			if (ChangeTripDate.equalsIgnoreCase("Yes")) {
				if (TripTypeM.equalsIgnoreCase("OneWay")) {
					QaRobot.ClickOnElement("OneWayMJ");
					Thread.sleep(3000);
					QaBrowser.driver.findElement(By.xpath(
							"//div[@id='Return']/div/div/div[1]/div[1]/div[2]/div/div[1]/div[1]/div/div/label/i"))
							.click();
					Thread.sleep(2000);
					selectDateInCalendarOneWay(expDate, month, year);
				} else if (TripTypeM.equalsIgnoreCase("RoundTrip")) {
					QaRobot.ClickOnElement("RoundTripMJ");
					Thread.sleep(3000);
					QaBrowser.driver.findElement(By.xpath(
							"//div[@id='Return']/div/div/div[1]/div[1]/div[2]/div/div[1]/div[1]/div/div/label/i"))
							.click();
					Thread.sleep(2000);
					selectDateInCalendarRoundTrip(expDate, month, year, expDate1, month1, year1);
				}
			}
//			if (TravellerType.equalsIgnoreCase("Individual")) {
//			} else {
//				if (ChangeTravellers.equalsIgnoreCase("Yes")) {
//					QaRobot.ClickOnElement("ChangeTravellersF");
//					QaRobot.selectValueFromDropdown("dnataAdultMF", adultM,
//							"<b><i>Select Modified adult for booking</i></b>" + " - " + adultM);
//					Thread.sleep(2000);
//					QaRobot.selectValueFromDropdown("dnataChildMF", childM,
//							"<b><i>Select Modified child for booking</i></b>" + " - " + childM);
//					Thread.sleep(2000);
//					QaRobot.selectValueFromDropdown("dnataInfantMF", infantM,
//							"<b><i>Select Modified infant for booking</i></b>" + " - " + infantM);
//					Thread.sleep(2000);
//					QaRobot.ClickOnElement("ChangeTravellersF");
//				}
//			}
//			if (ChangeAirline.equalsIgnoreCase("Yes")) {
//				QaRobot.ClickOnElement("PreferredAirlineMF");
//				Thread.sleep(2000);
//				int pAS = Integer.parseInt(PANumberM);
//				for (int i = 1; i <= pAS; i++) {
//					String[] tN = PreferredAirlineSelectM.split(",");
//					String b = tN[i - 1];
//					TestBase.listofautosuggestion1(By.xpath("//ul[@class='dropdown-menu-form  dropdown-menu']/li"), b,
//							By.xpath(
//									"//div[@id='Return']/div/div/div[1]/div[1]/div[2]/div/div[4]/div[3]/div/div/div/div[1]/input"));
//				}
//				QaRobot.ClickOnElement("PreferredAirlineMF");
//			}
//			if (ChangeClass.equalsIgnoreCase("Yes")) {
//				QaRobot.ClickOnElement("ChangeTravellersF");
//				QaRobot.selectTextByLocator("//select[@id='ddlClass']", ClassM,
//						"<b><i>Select Modified Class for booking</i></b>");
//				Thread.sleep(2000);
//				QaRobot.ClickOnElement("ChangeTravellersF");
//			}
			if (ShowDirectFlightM.equalsIgnoreCase("Yes")) {
				QaRobot.ClickOnElement("ShowDirectFlightMJ");
			}
			QaRobot.ClickOnElement("ModifySearchMJ");
			QaExtentReport.extentScreenshot("Modified Search");
			Thread.sleep(10000);
		}
		if (Applyfilter.equalsIgnoreCase("Yes")) {
			if (ChooseFareType.equalsIgnoreCase("Yes")) {
				if (FareType.equalsIgnoreCase("All")) {
					JavascriptExecutor mo = (JavascriptExecutor) QaBrowser.driver;
					mo.executeScript("window.scrollBy(0,500)", "");
					QaRobot.ClickOnElement("RefundableJ");
					Thread.sleep(3000);
					QaRobot.ClickOnElement("NonRefundableJ");
					Thread.sleep(3000);
				} else if (FareType.equalsIgnoreCase("Refundable")) {
					QaRobot.ClickOnElement("RefundableJ");
					Thread.sleep(3000);
				} else if (FareType.equalsIgnoreCase("Non-Refundable")) {
					QaRobot.ClickOnElement("NonRefundableJ");
					Thread.sleep(3000);
				}
			}
			if (ChooseAirLine.equalsIgnoreCase("Yes")) {
				List<WebElement> listOfAirLine = QaBrowser.driver
						.findElements(By.xpath("//div[@id='tdContainerTblAirlines']/ul/li/label/span"));
				for (WebElement autoAirline : listOfAirLine) {
					if (autoAirline.getText().equalsIgnoreCase(OneWayAirLine)) {
						autoAirline.click();
						break;
					}
				}
			}
			QaExtentReport.extentScreenshot("Apply filter");
		}
//		QaExtentReport.extentScreenshot("Result Page");
		QaRobot.scrollPage(-600);
//		QaRobot.ClickOnElement("FlightItinery");
//		Thread.sleep(5000);
//		QaExtentReport.extentScreenshot("FlightItinerary");
//		Thread.sleep(10000);
		if (Server.equalsIgnoreCase("Staging") || Server.equalsIgnoreCase("Xchange")
				|| Trip.equalsIgnoreCase("International")) {
//			QaRobot.ClickOnElement("SelectFlightJ");
		}

//		QaRobot.ClickOnElement("ShowDetails");
//		Thread.sleep(7000);
//		QaExtentReport.extentScreenshot("Show Details");
//		QaRobot.ClickOnElement("FareDetails");
//		Thread.sleep(4000);
//		String ParentWindow3 = QaBrowser.driver.getWindowHandle();
//		Set<String> handles3 = QaBrowser.driver.getWindowHandles();
//		for (String childWindow3 : handles3) {
//			if (!childWindow3.equals(ParentWindow3))
//				QaBrowser.driver.switchTo().window(childWindow3);
//		}
//		QaRobot.ClickOnElement("FareRulesF");
//		Thread.sleep(5000);
//		QaExtentReport.extentScreenshot("Fare Rules");
//		QaRobot.ClickOnElement("FareBreakupF");
//		Thread.sleep(5000);
//		QaRobot.ClickOnElement("CustomerCostF");
//		Thread.sleep(1000);
//		QaExtentReport.extentScreenshot("Customer Cost");
//		QaRobot.ClickOnElement("CompanyCostF");
//		Thread.sleep(3000);
//		QaExtentReport.extentScreenshot("Company Cost");
//		QaRobot.ClickOnElement("BaggegeInformationF");
//		Thread.sleep(5000);
//		QaExtentReport.extentScreenshot("Baggege Information");
//		QaRobot.ClickOnElement("FareCloseF");
		if (Resultpagestep.equalsIgnoreCase("Add to Cart")) {
			String getT = QaBrowser.driver.findElement(By.xpath("(//span[contains(@id,'PT')])[1]")).getText();
			QaExtentReport.extentScreenshot("Flight Results");
			if (TripType.equalsIgnoreCase("OneWay")) {
				if (OneWayAirLine.equalsIgnoreCase("Jetstar Airways")) {
					if (OneWayFareType.equalsIgnoreCase("Economy")) {
						QaRobot.ClickOnElement("AddToCartJ1");
					} else if (OneWayFareType.equalsIgnoreCase("Economy Starter Plus Public")) {
						QaRobot.ClickOnElement("AddToCartJ2");
					} else if (OneWayFareType.equalsIgnoreCase("Economy Starter Max")) {
						QaRobot.ClickOnElement("AddToCartJ3");
					}
				} else if (OneWayAirLine.equalsIgnoreCase("Virgin Australia")) {
					if (OneWayFareType.equalsIgnoreCase("CHOICE")) {
						QaRobot.ClickOnElement("AddToCartJ1");
					} else if (OneWayFareType.equalsIgnoreCase("FLEX")) {
						QaRobot.ClickOnElement("AddToCartJ2");
					} else if (OneWayFareType.equalsIgnoreCase("BUSINESS")) {
						QaRobot.ClickOnElement("AddToCartJ3");
					}
				} else if (OneWayAirLine.equalsIgnoreCase("Qantas Airways")) {
					if (OneWayFareType.equalsIgnoreCase("RED EDEAL")) {
						QaRobot.ClickOnElement("AddToCartJ1");
					} else if (OneWayFareType.equalsIgnoreCase("ECONOMY FLEX")) {
						QaRobot.ClickOnElement("AddToCartJ2");
					} else if (OneWayFareType.equalsIgnoreCase("FLEXIBLE BUSINESS")) {
						QaRobot.ClickOnElement("AddToCartJ3");
					}
				}
				Thread.sleep(3000);
				QaRobot.switchToWindow();
				QaRobot.ClickOnElement("NotificationCloseJ");
				QaRobot.scrollPage(-400);
			} else if (TripType.equalsIgnoreCase("RoundTrip")) {
				if (Trip.equalsIgnoreCase("Domestic")) {
					if (OneWayAirLine.equalsIgnoreCase("Jetstar Airways")) {
						if (OneWayFareType.equalsIgnoreCase("Economy")) {
							QaRobot.ClickOnElement("AddToCartJ1");
						} else if (OneWayFareType.equalsIgnoreCase("Economy Starter Plus Public")) {
							QaRobot.ClickOnElement("AddToCartJ2");
						} else if (OneWayFareType.equalsIgnoreCase("Economy Starter Max")) {
							QaRobot.ClickOnElement("AddToCartJ3");
						}
					} else if (OneWayAirLine.equalsIgnoreCase("Virgin Australia")) {
						if (OneWayFareType.equalsIgnoreCase("CHOICE")) {
							QaRobot.ClickOnElement("AddToCartJ1");
						} else if (OneWayFareType.equalsIgnoreCase("FLEX")) {
							QaRobot.ClickOnElement("AddToCartJ2");
						} else if (OneWayFareType.equalsIgnoreCase("BUSINESS")) {
							QaRobot.ClickOnElement("AddToCartJ3");
						}
					} else if (OneWayAirLine.equalsIgnoreCase("Qantas Airways")) {
						if (OneWayFareType.equalsIgnoreCase("RED EDEAL")) {
							QaRobot.ClickOnElement("AddToCartJ1");
						} else if (OneWayFareType.equalsIgnoreCase("ECONOMY FLEX")) {
							QaRobot.ClickOnElement("AddToCartJ2");
						} else if (OneWayFareType.equalsIgnoreCase("FLEXIBLE BUSINESS")) {
							QaRobot.ClickOnElement("AddToCartJ3");
						} else if (OneWayFareType.equalsIgnoreCase("BUSINESS SAVER")) {
							QaRobot.ClickOnElement("AddToCartJ4");
						}
					} else {
						Assert.assertEquals(false, "Please select correct Airline and Fare type."+OneWayFareType);
						System.out.println("Please select correct Airline and Fare type.");
					}
					Thread.sleep(3000);
					QaRobot.switchToWindow();
					QaRobot.ClickOnElement("NotificationCloseJ");
					QaRobot.ClickOnElement("ResultRJ");
					Thread.sleep(5000);
					List<WebElement> listOfAirLine = QaBrowser.driver
							.findElements(By.xpath("//div[@id='tdContainerTblAirlines']/ul/li/label/span"));
					for (WebElement autoAirline : listOfAirLine) {
						if (autoAirline.getText().equalsIgnoreCase(RoundTripAirLine)) {
							autoAirline.click();
							break;
						}
					}
					QaRobot.scrollPage(-1000);
					Thread.sleep(5000);
					if (RoundTripAirLine.equalsIgnoreCase("Jetstar Airways")) {
						if (RoundTripFareType.equalsIgnoreCase("Economy")) {
							QaRobot.ClickOnElement("AddToCartJ1");
						} else if (RoundTripFareType.equalsIgnoreCase("Economy Starter Plus Public")) {
							QaRobot.ClickOnElement("AddToCartJ2");
						} else if (RoundTripFareType.equalsIgnoreCase("Economy Starter Max")) {
							QaRobot.ClickOnElement("AddToCartJ3");
						}
					} else if (RoundTripAirLine.equalsIgnoreCase("Virgin Australia")) {
						if (RoundTripFareType.equalsIgnoreCase("CHOICE")) {
							QaRobot.ClickOnElement("AddToCartJ1");
						} else if (RoundTripFareType.equalsIgnoreCase("FLEX")) {
							QaRobot.ClickOnElement("AddToCartJ2");
						} else if (RoundTripFareType.equalsIgnoreCase("BUSINESS")) {
							QaRobot.ClickOnElement("AddToCartJ3");
						}
					} else if (RoundTripAirLine.equalsIgnoreCase("Qantas Airways")) {
						if (RoundTripFareType.equalsIgnoreCase("RED EDEAL")) {
							QaRobot.ClickOnElement("AddToCartJ1");
						} else if (RoundTripFareType.equalsIgnoreCase("ECONOMY FLEX")) {
							QaRobot.ClickOnElement("AddToCartJ2");
						} else if (RoundTripFareType.equalsIgnoreCase("FLEXIBLE BUSINESS")) {
							QaRobot.ClickOnElement("AddToCartJ3");
						} else if (RoundTripFareType.equalsIgnoreCase("BUSINESS SAVER")) {
							QaRobot.ClickOnElement("AddToCartJ4");
						}
					} else {
						Assert.assertEquals(false, "Please select correct Airline and Fare type."+RoundTripFareType);
						System.out.println("Please select correct Airline and Fare type.");
					}
					Thread.sleep(3000);
					QaRobot.switchToWindow();
					QaRobot.ClickOnElement("NotificationCloseJ");
				} else if (Trip.equalsIgnoreCase("International")) {
					QaRobot.ClickOnElement("AddToCartJ1");
					if (getT.equalsIgnoreCase("Out policy")) {
						QaRobot.alertAccept();
					}
					QaRobot.switchToWindow();
					QaRobot.ClickOnElement("NotificationCloseJ");
				}
			}
			QaRobot.ClickOnElement("YourItineraryFJ");
			Thread.sleep(5000);
			QaExtentReport.extentScreenshot("Your Itinerary");
			QaRobot.switchToWindow();
			if (ProductType.equalsIgnoreCase("Flight")) {
				QaRobot.ClickOnElement("ProceedToCheckoutC");
			} else if (ProductType.equalsIgnoreCase("Flight+Hotel")) {
				addHotel(Server, ProductType, CityCode, CityTitle, CheckInDate, CheckOutDate);
				QaRobot.switchToWindow();
				QaRobot.ClickOnElement("ProceedToCheckoutC");
			} else if (ProductType.equalsIgnoreCase("Flight+Car")) {
				addCar(Server, ProductType, PickUpCode, PickUpCity, CheckInDate, CheckOutDate, DriversAge);
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
					QaRobot.mouseHover("//a[@id='HeaderTop_aBookingMenu']", "//span[@id='HeaderTop_lblEnquiryQueue']");
					Thread.sleep(5000);
					QaRobot.ClickOnElement("Additionalsearch");
					QaRobot.PassValue("EnterEnquiryId", Enquiryid);
					QaRobot.ClickOnElement("Search");
					QaRobot.ClickOnElement("Book");
					QaRobot.ClickOnElement("ProceedToCheckoutC");
				} else if (SelectItineraryAs.equalsIgnoreCase("ProceedToCheckout")) {
					QaRobot.ClickOnElement("ProceedToCheckoutC");
				}
			} else if (ProductType.equalsIgnoreCase("Flight+Hotel+Car")) {
				addHotel(Server, ProductType, CityCode, CityTitle, CheckInDate, CheckOutDate);
//				QaRobot.switchToWindow();
				addCar(Server, ProductType, PickUpCode, PickUpCity, CheckInDate, CheckOutDate, DriversAge);
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
					QaRobot.mouseHover("//a[@id='HeaderTop_aBookingMenu']", "//span[@id='HeaderTop_lblEnquiryQueue']");
					Thread.sleep(5000);
					QaRobot.ClickOnElement("Additionalsearch");
					QaRobot.PassValue("EnterEnquiryId", Enquiryid);
					QaRobot.ClickOnElement("Search");
					QaRobot.ClickOnElement("Book");
					QaRobot.ClickOnElement("ProceedToCheckoutC");
				} else if (SelectItineraryAs.equalsIgnoreCase("ProceedToCheckout")) {
					QaRobot.ClickOnElement("ProceedToCheckoutC");
				}
			} else if (ProductType.equalsIgnoreCase("Flight+Car+Hotel")) {
				addCar(Server, ProductType, PickUpCode, PickUpCity, CheckInDate, CheckOutDate, DriversAge);
//				QaRobot.switchToWindow();
				addHotel(Server, ProductType, CityCode, CityTitle, CheckInDate, CheckOutDate);
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
					QaRobot.mouseHover("//a[@id='HeaderTop_aBookingMenu']", "//span[@id='HeaderTop_lblEnquiryQueue']");
					Thread.sleep(5000);
					QaRobot.ClickOnElement("Additionalsearch");
					QaRobot.PassValue("EnterEnquiryId", Enquiryid);
					QaRobot.ClickOnElement("Search");
					QaRobot.ClickOnElement("Book");
					QaRobot.ClickOnElement("ProceedToCheckoutC");
				} else if (SelectItineraryAs.equalsIgnoreCase("ProceedToCheckout")) {
					QaRobot.ClickOnElement("ProceedToCheckoutC");
				}
			}
			if (TravellerType.equalsIgnoreCase("Individual")) {
				SBT_JOLO_CheckoutPage.checkoutForFlight(CreatorName, Server, TravellerType, ProductType, QuoteTitle,
						QuoteRemark, Checkoutpagestep, FOP, CardType, CreditCardNumber, CardHolderName, CardExpiryDate);
			} else if (TravellerType.equalsIgnoreCase("Dependent")) {
//				SBT_JOLO_CheckoutPage.checkoutForCar(CreatorName, TravellerType, ProductType, QuoteTitle, QuoteRemark,
//						Checkoutpagestep, FOP, CardType, CreditCardNumber, CardHolderName, CardExpiryDate);
			}
		}
	}

	public static void ResultPageForHotel(String CreatorName, String Server, String TravellerType, String Trip,
			String Rooms, String Adult, String Child, String ModifySearch, String TravellerTypeM,
			String ChangeTripLocation, String CityCodeM, String CityTitleM, String ChangeTripDate, String CheckInDateM,
			String CheckOutDateM, String ChangeRooms, String RoomsM, String AdultM, String ChildM, String ChildAgeM,
			String Applyfilter, String ChangeStarRating, String StarRatingM, String ChangePropertyType,
			String SelectProperty, String Resultpagestep, String ProductType, String TripType, String OriginCityCode,
			String OriginLocation, String DestinationCityCode, String DestinationLocation, String DepartureDate,
			String ReturnDate, String adult, String child, String infant, String Class, String ShowDirectFlight,
			String PickUpCode, String PickUpCity, String PickUpDate, String DropOffDate, String DriversAge,
			String DropOffToDifferentLocation, String DropOffCode, String DropOffCity, String SelectItineraryAs,
			String QuoteTitle, String QuoteRemark, String Checkoutpagestep, String FOP, String CardType,
			String CreditCardNumber, String CardHolderName, String CardExpiryDate) throws Exception {
		Thread.sleep(25000);
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
			QaRobot.ClickOnElement("ModifySearchMH");
			Thread.sleep(5000);
			if (ChangeTripLocation.equalsIgnoreCase("Yes")) {
				TestBase.listofautosuggestion5(By.xpath("//div[@id='ModifydivHTCity']/p"), CityCodeM, CityTitleM,
						By.xpath("//input[@id='txtHotelSearch']"));
				QaExtentReport.test.log(Status.INFO,
						"<b><i>Modified City Name : </i></b>" + CityCodeM + "-" + CityTitleM);
				Thread.sleep(2000);
			}
			if (ChangeTripDate.equalsIgnoreCase("Yes")) {
				QaBrowser.driver
						.findElement(By
								.xpath("//div[@id='usercontroldiv']/form/div/div[3]/div[1]/label/span[2]/span[1]/img"))
						.click();
				Thread.sleep(2000);
				selectDateInCalendarHotel(expDate, month, year, expDate1, month1, year1);
			}
			if (ChangeRooms.equalsIgnoreCase("Yes")) {
				String[] adultcount = AdultM.split(",");
				String[] childcount = ChildM.split(",");
				Assert.assertFalse(Integer.parseInt(RoomsM) > 5, "Invalid Number of Rooms provided" + " - " + RoomsM);
				WebElement roomelement = QaBrowser.driver.findElement(By.xpath("//select[@id='HtlRooms']"));
				Select selectroom = new Select(roomelement);
				selectroom.selectByValue(RoomsM);
				Thread.sleep(2000);
				if (TravellerType.equalsIgnoreCase("Individual")) {
				} else {
					for (int i = 1; i <= Integer.parseInt(RoomsM); i++) {
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
							Assert.assertFalse(Integer.parseInt(ac) > 11, "Invalid Child Age Selection" + " : " + ac);
							WebElement childrenage = QaBrowser.driver
									.findElement(By.xpath("//select[@id='htl" + chdcount + "child" + i + "age']"));
							Select selectage = new Select(childrenage);
							selectage.selectByValue(ageofchild[i - 1]);
							Thread.sleep(2000);
						}
					}
				}
			}
			if (ChangeStarRating.equalsIgnoreCase("Yes")) {
				WebElement StarRating = QaBrowser.driver.findElement(By.xpath("//select[@id='ddlstarRating']"));
				Select selectage = new Select(StarRating);
				selectage.selectByVisibleText(StarRatingM);
				Thread.sleep(2000);
			}
			QaRobot.ClickOnElement("ModifiedSearchMH");
			QaExtentReport.extentScreenshot("Modified Search");
			Thread.sleep(10000);
		}
		if (Applyfilter.equalsIgnoreCase("Yes")) {
			if (ChangePropertyType.equalsIgnoreCase("Yes")) {
				QaRobot.scrollPage(500);
				if (SelectProperty.equalsIgnoreCase("Hotel")) {
					QaRobot.ClickOnElement("ApartmentJ");
					Thread.sleep(3000);
				} else if (SelectProperty.equalsIgnoreCase("Apartment")) {
					QaRobot.ClickOnElement("HotelFJ");
					Thread.sleep(3000);
				}
			}
			QaExtentReport.extentScreenshot("Apply filter");
		}
		QaRobot.scrollPage(400);
		QaRobot.ClickOnElement("HotelSelectC");
		Thread.sleep(3000);
//		QaRobot.ClickOnElement("CancellationPolicy");
//		Thread.sleep(3000);
//		QaExtentReport.extentScreenshot("CancellationPolicy");
//		String ParentWindow4 = QaBrowser.driver.getWindowHandle();
//		Set<String> handles4 = QaBrowser.driver.getWindowHandles();
//		for (String childWindow4 : handles4) {
//			if (!childWindow4.equals(ParentWindow4))
//				QaBrowser.driver.switchTo().window(childWindow4);
//		}
//		QaRobot.ClickOnElement("CPClose");
//		Thread.sleep(2000);
//		QaBrowser.driver.switchTo().window(ParentWindow4);
//		QaRobot.ClickOnElement("FareBreakup");
//		Thread.sleep(2000);
//		QaRobot.ClickOnElement("CustomerCostH");
//		Thread.sleep(3000);
//		QaExtentReport.extentScreenshot("CustomerCost");
//		QaRobot.ClickOnElement("CompanyCostH");
//		Thread.sleep(3000);
//		QaExtentReport.extentScreenshot("CompanyCost");
//		String ParentWindow5 = QaBrowser.driver.getWindowHandle();
//		Set<String> handles5 = QaBrowser.driver.getWindowHandles();
//		for (String childWindow5 : handles5) {
//			if (!childWindow5.equals(ParentWindow5))
//				QaBrowser.driver.switchTo().window(childWindow5);
//		}
//		QaRobot.ClickOnElement("FareBreakupClose");
//		Thread.sleep(2000);
//		QaBrowser.driver.switchTo().window(ParentWindow5);
		if (Resultpagestep.equalsIgnoreCase("Add to Cart")) {
			if (Server.equalsIgnoreCase("Staging") || Server.equalsIgnoreCase("Xchange")) {
				String getT = QaBrowser.driver.findElement(By.xpath("(//span[contains(@id,'Policy3')])[3]")).getText();
				QaExtentReport.extentScreenshot("Flight Results");
				QaRobot.ClickOnElement("AddToCartHotelCX");
				if (getT.equalsIgnoreCase("Out Of Policy")) {
					QaRobot.alertAccept();
				}
			} else if (Server.equalsIgnoreCase("tpstg")) {
				String getT = QaBrowser.driver.findElement(By.xpath("(//span[contains(@id,'Policy4')])[3]")).getText();
				QaExtentReport.extentScreenshot("Flight Results");
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
				QaRobot.ClickOnElement("ProceedToCheckoutC");
			} else if (ProductType.equalsIgnoreCase("Hotel+Flight")) {
				addFlight(Server, Trip, ProductType, TripType, OriginCityCode, OriginLocation, DestinationCityCode,
						DestinationLocation, DepartureDate, ReturnDate);
				QaRobot.switchToWindow();
				QaRobot.ClickOnElement("ProceedToCheckoutC");
			} else if (ProductType.equalsIgnoreCase("Hotel+Car")) {
				addCar(Server, ProductType, PickUpCode, PickUpCity, PickUpDate, DropOffDate, DriversAge);
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
					QaRobot.mouseHover("//a[@id='HeaderTop_aBookingMenu']", "//span[@id='HeaderTop_lblEnquiryQueue']");
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
				addFlight(Server, Trip, ProductType, TripType, OriginCityCode, OriginLocation, DestinationCityCode,
						DestinationLocation, DepartureDate, ReturnDate);
				addCar(Server, ProductType, PickUpCode, PickUpCity, PickUpDate, DropOffDate, DriversAge);
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
					QaRobot.mouseHover("//a[@id='HeaderTop_aBookingMenu']", "//span[@id='HeaderTop_lblEnquiryQueue']");
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
				addCar(Server, ProductType, PickUpCode, PickUpCity, PickUpDate, DropOffDate, DriversAge);
				addFlight(Server, Trip, ProductType, TripType, OriginCityCode, OriginLocation, DestinationCityCode,
						DestinationLocation, DepartureDate, ReturnDate);
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
					QaRobot.mouseHover("//a[@id='HeaderTop_aBookingMenu']", "//span[@id='HeaderTop_lblEnquiryQueue']");
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
			if (TravellerType.equalsIgnoreCase("Individual")) {
				SBT_JOLO_CheckoutPage.checkoutForHotel(CreatorName, Server, TravellerType, ProductType, QuoteTitle,
						QuoteRemark, Checkoutpagestep, FOP, CardType, CreditCardNumber, CardHolderName, CardExpiryDate);
			} else if (TravellerType.equalsIgnoreCase("Dependent")) {
//				SBT_JOLO_CheckoutPage.checkoutForCar(CreatorName, TravellerType, ProductType, QuoteTitle, QuoteRemark,
//						Checkoutpagestep, FOP, CardType, CreditCardNumber, CardHolderName, CardExpiryDate);
			}
		}

//			QaRobot.ClickOnElement("AddToCartH");
//			Thread.sleep(5000);
//			String ParentWindow = QaBrowser.driver.getWindowHandle();
//			Set<String> handles = QaBrowser.driver.getWindowHandles();
//			for (String childWindow : handles) {
//				if (!childWindow.equals(ParentWindow))
//					QaBrowser.driver.switchTo().window(childWindow);
//			}
//			QaRobot.ClickOnElement("NotificationCloseF");
//			QaBrowser.driver.switchTo().window(ParentWindow);
//			Thread.sleep(3000);
//			QaRobot.switchframe("//frame[@name='login']");
//			QaRobot.switchframe("//frame[@name='main']");
//			Thread.sleep(2000);
//			QaRobot.ClickOnElement("ViewCart");
//			Thread.sleep(5000);
//			QaExtentReport.extentScreenshot("View Cart");
//			String ParentWindow6 = QaBrowser.driver.getWindowHandle();
//			Set<String> handles6 = QaBrowser.driver.getWindowHandles();
//			for (String childWindow6 : handles6) {
//				if (!childWindow6.equals(ParentWindow6))
//					QaBrowser.driver.switchTo().window(childWindow6);
//			}
//			QaRobot.PassValue("QuotationTitle", QuoteTitle);
//			QaExtentReport.extentScreenshot("Quotation");
//			QaRobot.PassValue("RemarkTitle", QuoteRemark);
//			QaRobot.ClickOnElement("SendQuoteH");
//			Thread.sleep(10000);
//			String ParentWindow2 = QaBrowser.driver.getWindowHandle();
//			Set<String> handles2 = QaBrowser.driver.getWindowHandles();
//			for (String childWindow2 : handles2) {
//				if (!childWindow2.equals(ParentWindow2))
//					QaBrowser.driver.switchTo().window(childWindow2);
//			}
//			String getT = QaBrowser.driver.findElement(By.xpath("//div[@id='FlightQuotationModal']/div/div/div[2]/p"))
//					.getText();
//			System.out.println(getT);
//			String getTxt1[] = getT.split(" ");
//			String number = getTxt1[11];
//			System.out.println(number);
//			QaExtentReport.test.log(Status.INFO, "<b><i>Enquiry id is </i></b>" + number);
//			QaRobot.ClickOnElement("NotificationCloseF");
//			QaBrowser.driver.switchTo().window(ParentWindow2);
//			QaBrowser.driver.switchTo().parentFrame();
//			QaRobot.ClickOnElement("Bookings");
//			QaRobot.ClickOnElement("BookingQueues");
//			QaBrowser.driver.switchTo().parentFrame();
//			QaRobot.switchframe("//frame[@name='main']");
//			QaRobot.switchframe("//frame[@id='toolHeader']");
//			QaRobot.ClickOnElement("CorporateQueue");
//
//			QaBrowser.driver.switchTo().parentFrame();
//			QaRobot.switchframe("//frame[@id='frm2']");
//
//			QaRobot.ClickOnElement("EnquiryQueue");
//			Thread.sleep(3000);
//
//			QaRobot.PassValue("EnterEnquiryId", number);
////				QaExtentReport.test.log(Status.INFO,"<b><i>Enter Enquiry Id</i></b>");
//
//			QaRobot.ClickOnElement("SearchEnquiryId");
////				QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Search Enquiry Id </i></b>");
//			Thread.sleep(3000);
//			QaExtentReport.extentScreenshot("Search Enquiry Id");
//
//			QaRobot.ClickOnElement("EnquiryView");
////				QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Enquiry View Button</i></b>");
//			Thread.sleep(13000);
//
//			String ParentWindow7 = QaBrowser.driver.getWindowHandle();
//			Set<String> handles7 = QaBrowser.driver.getWindowHandles();
//			for (String childWindow7 : handles7) {
//				if (!childWindow7.equals(ParentWindow7))
//					QaBrowser.driver.switchTo().window(childWindow7);
//			}
//
//			QaExtentReport.extentScreenshot("Quotation View");
//
//			QaBrowser.driver.close();
//			Thread.sleep(10000);
//
//			QaBrowser.driver.switchTo().window(ParentWindow7);
//
//			QaRobot.switchframe("//frame[@name='login']");
//			QaRobot.switchframe("//frame[@name='main']");
//			QaRobot.switchframe("//frame[@id='frm2']");
//
//			QaRobot.ClickOnElement("ApproveButton");
////				QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Approve Button</i></b>");
//			Thread.sleep(13000);
//
//			String ParentWindow8 = QaBrowser.driver.getWindowHandle();
//			Set<String> handles8 = QaBrowser.driver.getWindowHandles();
//			for (String childWindow8 : handles8) {
//				if (!childWindow8.equals(ParentWindow8))
//					QaBrowser.driver.switchTo().window(childWindow8);
//			}
//			Thread.sleep(3000);
//
//			if (TravellerType.equalsIgnoreCase("Individual")) {
//				QaRobot.ClickOnElement("SelectItineraryH");
////					QaExtentReport.test.log(Status.INFO,"<b><i>Select Itinerary</i></b>");
//			} else if (TravellerType.equalsIgnoreCase("Dependent")) {
//				QaRobot.ClickOnElement("SelectItineraryDH1");
////					QaExtentReport.test.log(Status.INFO,"<b><i>Select Itinerary</i></b>");
//
//				QaRobot.ClickOnElement("SelectItineraryDH2");
////					QaExtentReport.test.log(Status.INFO,"<b><i>Select Itinerary</i></b>");
//			}
//
//			QaExtentReport.extentScreenshot("Itinerary View");
//
//			JavascriptExecutor mo1 = (JavascriptExecutor) QaBrowser.driver;
//			mo1.executeScript("window.scrollBy(0,500)", "");
//
//			QaRobot.ClickOnElement("FinalApproveButton");
////				QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Final Approve Button</i></b>");
//
//			QaRobot.PassValue("TextArea", "Ok");
////				QaExtentReport.test.log(Status.INFO,"<b><i>Click on Text Area</i></b>");
//
//			QaRobot.ClickOnElement("OKButton");
////				QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on OK Button</i></b>");
//			Thread.sleep(13000);
//			QaBrowser.driver.switchTo().window(ParentWindow8);
//			QaRobot.switchframe("//frame[@name='login']");
//			QaRobot.switchframe("//frame[@name='main']");
//			QaRobot.switchframe("//frame[@id='frm2']");
//
//			QaRobot.ClickOnElement("FinalBookButton");
////				QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Final Book Button</i></b>");
//			Thread.sleep(30000);
//
//			DnataCheckoutPage.individualforHotel(TravellerType, Adult, Child, ModifySearch, ChangeRooms, AdultM, ChildM,
//					Resultpagestep, QuoteTitle, QuoteRemark, Checkoutpagestep);
//		}
//
//		else if (Resultpagestep.equalsIgnoreCase("Book")) {
//			QaRobot.switchframe("//frame[@name='login']");
//			QaRobot.switchframe("//frame[@name='main']");
//
//			QaRobot.ClickOnElement("BookH");
////				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Book</i></b>");
//			Thread.sleep(10000);
//
//			DnataCheckoutPage.individualforHotel(TravellerType, Adult, Child, ModifySearch, ChangeRooms, AdultM, ChildM,
//					Resultpagestep, QuoteTitle, QuoteRemark, Checkoutpagestep);
//		}
	}

	public static void ResultPageForCar(String CreatorName, String Server, String SearchType, String Trip,
			String ModifySearch, String TravellerTypeM, String ChangePickUpTrip, String PickUpCodeM, String PickUpCityM,
			String ChangePickUpDate, String PickUpDateM, String ChangeDropOffDate, String DropOffDateM,
			String ChangePickUpTime, String PickUpTimeM, String ChangeDropOffTime, String DropOffTimeM,
			String ChangeDriverAge, String DriversAgeM, String ChangeTravellers, String AdultM, String ChildM,
			String InfantM, String ChooseCarTypeM, String CarTypeM, String DropOffToDifferentLocationM,
			String DropOffCodeM, String DropOffCityM, String Applyfilter, String CarType, String Carqty,
			String CancelCarResult, String Classqty, String CancelClassResult, String ClassType,
			String CancleTransmission, String AirCondition, String Resultpagestep, String ProductType, String TripType,
			String OriginCityCode, String OriginLocation, String DestinationCityCode, String DestinationLocation,
			String DepartureDate, String ReturnDate, String CityCode, String CityTitle, String CheckInDate,
			String CheckOutDate, String SelectItineraryAs, String QuoteTitle, String QuoteRemark,
			String Checkoutpagestep, String FOP, String CardType, String CreditCardNumber, String CardHolderName,
			String CardExpiryDate) throws Exception {
		Thread.sleep(10000);
		if (QaBrowser.driver.findElement(By.xpath("//div[@id='tblResults']/div/div/div[2]/div/div[2]/div/div/div/p"))
				.isDisplayed()) {
			QaExtentReport.extentScreenshot("Could not find desired results");
			Assert.assertTrue(false, "Sorry, could not find desired results. Please try again.");
		} else {
			String url = QaBrowser.driver.getCurrentUrl();
			String[] uid = url.split("=");
			QaExtentReport.test.log(Status.INFO, "<b><i>Session id is </i></b>" + uid[1]);
			String DateSelection[] = PickUpDateM.split("-");
			String year = DateSelection[2];
			String month = DateSelection[1];
			String expDate = DateSelection[0];

			String DateSelection1[] = DropOffDateM.split("-");
			String year1 = DateSelection1[2];
			String month1 = DateSelection1[1];
			String expDate1 = DateSelection1[0];

			if (ModifySearch.equalsIgnoreCase("Yes")) {
				QaRobot.ClickOnElement("ModifySearchc");
				Thread.sleep(3000);
				if (ChangePickUpTrip.equalsIgnoreCase("Yes")) {
					TestBase.listofautosuggestion4(By.xpath("//div[@id='divDepartureCity0']/p"), PickUpCodeM,
							PickUpCityM, By.xpath("//input[@id='MtxtDepartureCity0']"));
					QaExtentReport.test.log(Status.INFO,
							"<b><i>Modified PickUp city : </i></b>" + PickUpCodeM + " - " + PickUpCityM);
					Thread.sleep(2000);
				}
				if (DropOffToDifferentLocationM.equalsIgnoreCase("Yes")) {
					QaRobot.ClickOnElement("DropOffDifferentLocationM");
					TestBase.listofautosuggestion4(By.xpath("//div[@id='divDestinationCity0']/p"), DropOffCodeM,
							DropOffCityM, By.xpath("//input[@id='MtxtDestinationCity0']"));
					QaExtentReport.test.log(Status.INFO,
							"<b><i>Modified DropOff city : </i></b>" + DropOffCodeM + " - " + DropOffCityM);
					Thread.sleep(2000);
				}
				if (ChangePickUpDate.equalsIgnoreCase("Yes")) {
					QaBrowser.driver.findElement(By.xpath("//div[@id='Return']/div/div/div[1]/div[1]/div[3]/div/div/i"))
							.click();
					Thread.sleep(2000);
					selectDateInCalendarOneWay(expDate, month, year);
				}
				if (ChangePickUpTime.equalsIgnoreCase("Yes")) {
					QaRobot.selectTextFromDropdown("PickUpTimeM", PickUpTimeM);
				}
				if (ChangeDropOffDate.equalsIgnoreCase("Yes")) {
					QaBrowser.driver.findElement(By.xpath("//div[@id='Return']/div/div/div[1]/div[1]/div[5]/div/div/i"))
							.click();
					Thread.sleep(2000);
					selectDateInCalendarOneWay(expDate1, month1, year1);
				}
				if (ChangeDropOffTime.equalsIgnoreCase("Yes")) {
					QaRobot.selectTextFromDropdown("DropOffTimeM", DropOffTimeM);
				}
				if (ChangeDriverAge.equalsIgnoreCase("Yes")) {
					QaRobot.selectTextFromDropdown("DriverAgeM", DriversAgeM);
				}
				if (ChooseCarTypeM.equalsIgnoreCase("Yes")) {
					QaRobot.selectTextFromDropdown("CarTypeM", CarTypeM);
				}
				if (TravellerTypeM.equalsIgnoreCase("Individual")) {
				} else {
					if (ChangeTravellers.equalsIgnoreCase("Yes")) {
						QaRobot.ClickOnElement("TravellersM");
						QaRobot.selectValueFromDropdown("CAdultM", AdultM,
								"<b><i>Select Modified adult for booking</i></b>" + " - " + AdultM);
						Thread.sleep(2000);
						QaRobot.selectValueFromDropdown("CChildM", ChildM,
								"<b><i>Select Modified child for booking</i></b>" + " - " + ChildM);
						Thread.sleep(2000);
						QaRobot.selectValueFromDropdown("CInfantM", InfantM,
								"<b><i>Select Modified infant for booking</i></b>" + " - " + InfantM);
						Thread.sleep(2000);
						QaRobot.ClickOnElement("TravellersM");
					}
				}
				QaRobot.ClickOnElement("ModifySearchMC");
				QaExtentReport.extentScreenshot("Modified Search");
			}
			Thread.sleep(10000);
			if (Applyfilter.equalsIgnoreCase("Yes")) {
				if (CarType.equalsIgnoreCase("Yes")) {
					int pAS1 = Integer.parseInt(Carqty);
					for (int k = 1; k <= pAS1; k++) {
						String[] tN = CancelCarResult.split(",");
						String b = tN[k - 1];
						List<WebElement> listOfRules = QaBrowser.driver
								.findElements(By.xpath("//ul[@id='carTypeFilter']/li/label/span"));
						for (WebElement autoRule : listOfRules) {
							if (autoRule.getText().equalsIgnoreCase(b)) {
								autoRule.click();
								break;
							}
						}
					}
				}
				if (ClassType.equalsIgnoreCase("Yes")) {
					int pAS1 = Integer.parseInt(Classqty);
					for (int k = 1; k <= pAS1; k++) {
						String[] tN = CancelClassResult.split(",");
						String b = tN[k - 1];
						List<WebElement> listOfRules = QaBrowser.driver.findElements(
								By.xpath("//div[@id='divFilters']/div[2]/div[3]/div[2]/div/ul/li/label/span"));
						for (WebElement autoRule : listOfRules) {
							if (autoRule.getText().equalsIgnoreCase(b)) {
								autoRule.click();
								break;
							}
						}
					}
				}
				if (CancleTransmission.equalsIgnoreCase("Yes")) {
					QaRobot.ClickOnElement("CancleAutomatic");
				}
				if (AirCondition.equalsIgnoreCase("No")) {
					QaRobot.ClickOnElement("AirCondition");
				}
				QaExtentReport.extentScreenshot("Apply filter");
				Thread.sleep(5000);
			}
			QaExtentReport.extentScreenshot("Result Page");

//		JavascriptExecutor mo = (JavascriptExecutor) QaBrowser.driver;
//		mo.executeScript("window.scrollBy(0,400)", "");

//			QaRobot.ClickOnElement("MoreDetailsC");
//			Thread.sleep(5000);
//			QaRobot.switchToWindow();
//			QaRobot.ClickOnElement("CarDetailsC");
//			QaExtentReport.extentScreenshot("Car Details");
//			Thread.sleep(3000);
//			QaRobot.ClickOnElement("FareDetailsC");
//			QaExtentReport.extentScreenshot("Fare Details");
//			Thread.sleep(3000);
//			QaRobot.ClickOnElement("MoreDetalisCloseC");
			QaRobot.ClickOnElement("SelectCar");
			if (Resultpagestep.equalsIgnoreCase("Add to Cart")) {
				QaRobot.ClickOnElement("AddToCartC");
				Thread.sleep(5000);
				String ParentWindow = QaBrowser.driver.getWindowHandle();
				Set<String> handles = QaBrowser.driver.getWindowHandles();
				for (String childWindow : handles) {
					if (!childWindow.equals(ParentWindow))
						QaBrowser.driver.switchTo().window(childWindow);
				}
				QaRobot.ClickOnElement("NotificationCloseC");
				QaRobot.ClickOnElement("YourItineraryC");
				Thread.sleep(5000);
				QaExtentReport.extentScreenshot("Your Itinerary");
				String ParentWindow5 = QaBrowser.driver.getWindowHandle();
				Set<String> handles5 = QaBrowser.driver.getWindowHandles();
				for (String childWindow5 : handles5) {
					if (!childWindow5.equals(ParentWindow5))
						QaBrowser.driver.switchTo().window(childWindow5);
				}
				if (ProductType.equalsIgnoreCase("Car")) {
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
						Thread.sleep(20000);
						QaRobot.alertAccept();
						Thread.sleep(150000);
						QaRobot.mouseHover("//a[@id='HeaderTop_aBookingMenu']",
								"//span[@id='HeaderTop_lblEnquiryQueue']");
						Thread.sleep(5000);
						QaRobot.ClickOnElement("Additionalsearch");
						QaRobot.PassValue("EnterEnquiryId", Enquiryid);
						QaRobot.ClickOnElement("Search");
						QaRobot.ClickOnElement("Book");
						QaRobot.ClickOnElement("ProceedToCheckoutC");
					} else if (SelectItineraryAs.equalsIgnoreCase("ProceedToCheckout")) {
						QaRobot.ClickOnElement("ProceedToCheckoutC");
					}
				} else if (ProductType.equalsIgnoreCase("Car+Flight")) {
					addFlight(Server, Trip, ProductType, TripType, OriginCityCode, OriginLocation, DestinationCityCode,
							DestinationLocation, DepartureDate, ReturnDate);
					QaRobot.switchToWindow();
					if (Server.equalsIgnoreCase("Staging")) {
						QaRobot.ClickOnElement("ProceedToCheckoutC1");
					} else if (Server.equalsIgnoreCase("Xchange") || Server.equalsIgnoreCase("tpstg")) {
						QaRobot.ClickOnElement("ProceedToCheckoutC");
					}
				} else if (ProductType.equalsIgnoreCase("Car+Hotel")) {
					addHotel(Server, ProductType, CityCode, CityTitle, CheckInDate, CheckOutDate);
					QaRobot.switchToWindow();
					QaRobot.ClickOnElement("ProceedToCheckoutC");
				} else if (ProductType.equalsIgnoreCase("Car+Flight+Hotel")) {
					addFlight(Server, Trip, ProductType, TripType, OriginCityCode, OriginLocation, DestinationCityCode,
							DestinationLocation, DepartureDate, ReturnDate);
					addHotel(Server, ProductType, CityCode, CityTitle, CheckInDate, CheckOutDate);
					QaRobot.switchToWindow();
					QaRobot.ClickOnElement("ProceedToCheckoutC");
				} else if (ProductType.equalsIgnoreCase("Car+Hotel+Flight")) {
					addHotel(Server, ProductType, CityCode, CityTitle, CheckInDate, CheckOutDate);
					addFlight(Server, Trip, ProductType, TripType, OriginCityCode, OriginLocation, DestinationCityCode,
							DestinationLocation, DepartureDate, ReturnDate);
					QaRobot.switchToWindow();
					if (Server.equalsIgnoreCase("Staging")) {
						QaRobot.ClickOnElement("ProceedToCheckoutC1");
					} else if (Server.equalsIgnoreCase("Xchange") || Server.equalsIgnoreCase("tpstg")) {
						QaRobot.ClickOnElement("ProceedToCheckoutC");
					}
				}
				SBT_JOLO_CheckoutPage.checkoutForCar(CreatorName, Server, SearchType, ProductType, QuoteTitle,
						QuoteRemark, Checkoutpagestep, FOP, CardType, CreditCardNumber, CardHolderName, CardExpiryDate);

//			QaRobot.ClickOnElement("SendForApprovalC");
//			String ParentWindow1 = QaBrowser.driver.getWindowHandle();
//			Set<String> handles1 = QaBrowser.driver.getWindowHandles();
//			for (String childWindow1 : handles1) {
//				if (!childWindow1.equals(ParentWindow1))
//					QaBrowser.driver.switchTo().window(childWindow1);
//			}
//			QaRobot.PassValue("QuotationTitle", QuoteTitle);
//			QaExtentReport.extentScreenshot("Quotation");
//			QaRobot.PassValue("RemarkTitle", QuoteRemark);
//			QaRobot.ClickOnElement("SendQuote");
//			Thread.sleep(5000);
//			String ParentWindow2 = QaBrowser.driver.getWindowHandle();
//			Set<String> handles2 = QaBrowser.driver.getWindowHandles();
//			for (String childWindow2 : handles2) {
//				if (!childWindow2.equals(ParentWindow2))
//					QaBrowser.driver.switchTo().window(childWindow2);
//			}
//			String getT = QaBrowser.driver.findElement(By.xpath("//div[@id='FlightQuotationModal']/div/div/div[2]/p"))
//					.getText();
//			System.out.println(getT);
//			String getTxt1[] = getT.split(" ");
//			String number = getTxt1[11];
//			System.out.println(number);
//			QaExtentReport.test.log(Status.INFO, "<b><i>Enquiry id is </i></b>" + number);
//
//			QaRobot.ClickOnElement("NotificationCloseF");
////			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Quote Close</i></b>");
//			QaBrowser.driver.switchTo().window(ParentWindow2);
//
//			QaBrowser.driver.switchTo().parentFrame();
//
//			QaRobot.switchframe("//frame[@name='login']");
//			QaRobot.switchframe("//frame[@name='leftbar']");
//
//			QaRobot.ClickOnElement("Bookings");
////			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Bookings</i></b>");
//
//			QaRobot.ClickOnElement("BookingQueues");
////			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Booking Queues</i></b>");
//
//			QaBrowser.driver.switchTo().parentFrame();
//
//			QaRobot.switchframe("//frame[@name='main']");
//			QaRobot.switchframe("//frame[@id='toolHeader']");
//
//			QaRobot.ClickOnElement("CorporateQueue");
//
//			QaBrowser.driver.switchTo().parentFrame();
//
//			QaRobot.switchframe("//frame[@id='frm2']");
//
//			QaRobot.ClickOnElement("EnquiryQueue");
//			Thread.sleep(3000);
//
//			QaRobot.PassValue("EnterEnquiryId", number);
////			QaExtentReport.test.log(Status.INFO,"<b><i>Enter Enquiry Id</i></b>");
//
//			QaRobot.ClickOnElement("SearchEnquiryId");
////			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Search Enquiry Id </i></b>");
//			Thread.sleep(3000);
//			QaExtentReport.extentScreenshot("Search Enquiry Id");
//
//			QaRobot.ClickOnElement("EnquiryView");
////			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Enquiry View Button</i></b>");
//			Thread.sleep(5000);
//
//			String ParentWindow7 = QaBrowser.driver.getWindowHandle();
//			Set<String> handles7 = QaBrowser.driver.getWindowHandles();
//			for (String childWindow7 : handles7) {
//				if (!childWindow7.equals(ParentWindow7))
//					QaBrowser.driver.switchTo().window(childWindow7);
//			}
//
//			QaExtentReport.extentScreenshot("Quotation View");
//
//			QaBrowser.driver.close();
//			Thread.sleep(7000);
//
//			QaBrowser.driver.switchTo().window(ParentWindow7);
//
//			QaRobot.switchframe("//frame[@name='login']");
//			QaRobot.switchframe("//frame[@name='main']");
//			QaRobot.switchframe("//frame[@id='frm2']");
//
//			QaRobot.ClickOnElement("ApproveButton");
////			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Approve Button</i></b>");
//			Thread.sleep(13000);
//
//			String ParentWindow8 = QaBrowser.driver.getWindowHandle();
//			Set<String> handles8 = QaBrowser.driver.getWindowHandles();
//			for (String childWindow8 : handles8) {
//				if (!childWindow8.equals(ParentWindow8))
//					QaBrowser.driver.switchTo().window(childWindow8);
//			}
//			Thread.sleep(3000);
//			QaRobot.ClickOnElement("SelectItinerary");
////			QaExtentReport.test.log(Status.INFO,"<b><i>Select Itinerary</i></b>");
//
//			QaExtentReport.extentScreenshot("Itinerary View");
//
//			JavascriptExecutor mo1 = (JavascriptExecutor) QaBrowser.driver;
//			mo1.executeScript("window.scrollBy(0,500)", "");
//
//			QaRobot.ClickOnElement("FinalApproveButton");
////			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Final Approve Button</i></b>");
//
//			QaRobot.PassValue("TextArea", "Ok");
////			QaExtentReport.test.log(Status.INFO,"<b><i>Click on Text Area</i></b>");
//
//			QaRobot.ClickOnElement("OKButton");
////			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on OK Button</i></b>");
//			Thread.sleep(13000);
//			QaBrowser.driver.switchTo().window(ParentWindow8);
//			QaRobot.switchframe("//frame[@name='login']");
//			QaRobot.switchframe("//frame[@name='main']");
//			QaRobot.switchframe("//frame[@id='frm2']");
//
//			QaRobot.ClickOnElement("FinalBookButton");
////			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Final Book Button</i></b>");
//			Thread.sleep(5000);
//
//			String ParentWindow9 = QaBrowser.driver.getWindowHandle();
//			Set<String> handles9 = QaBrowser.driver.getWindowHandles();
//			for (String childWindow9 : handles9) {
//				if (!childWindow9.equals(ParentWindow9))
//					QaBrowser.driver.switchTo().window(childWindow9);
//			}
//
//			QaRobot.ClickOnElement("EnquiryProcced");
//			Thread.sleep(30000);
//			QaBrowser.driver.switchTo().window(ParentWindow9);
//			QaRobot.switchframe("//frame[@name='login']");
//			QaRobot.switchframe("//frame[@name='main']");
//			QaRobot.switchframe("//frame[@id='frm2']");
//
//			if (ModifySearch.equalsIgnoreCase("No")) {
//				if (TripType.equalsIgnoreCase("OneWay")) {
//					if (QaBrowser.driver.findElement(By.xpath(
//							"//div[contains(text(),'The fare that you have selected is no longer available. Please choose from below options to continue')]"))
//							.isDisplayed()) {
//						List<WebElement> listOfAirline = QaBrowser.driver.findElements(By.xpath(
//								"/html/body/div[1]/div[1]/div/section/div[2]/div[2]/div/div[1]/div/div[3]/div[10]/div[2]/div/ul/li/label/span"));
//
//						for (WebElement autoAirline : listOfAirline) {
//							if (autoAirline.getText().equalsIgnoreCase(AirLine)) {
//								autoAirline.click();
//								break;
//							}
//						}
//
//						JavascriptExecutor mo2 = (JavascriptExecutor) QaBrowser.driver;
//						mo2.executeScript("window.scrollBy(0,-300)", "");
//
//						QaRobot.ClickOnElement("BookNowF");
////						QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Book Now</i></b>");
//						Thread.sleep(8000);
//					}
//				}
//			}
////			else if(ModifySearch.equalsIgnoreCase("Yes"))
////			{
////				if(TripTypeM.equalsIgnoreCase("OneWay"))
////				{
////					if(QaBrowser.driver.findElement(By.xpath("//div[contains(text(),'                            The fare that you have selected "
////							+ "is no longer available. Please choose from below options to continue')]")).isDisplayed()) 
////					{
////						List<WebElement> listOfAirline = QaBrowser.driver.findElements(By.xpath("/html/body/div[1]/div[1]/div/section/div[2]/div[2]/div/div[1]/div/div[3]/div[10]/div[2]/div/ul/li/label/span"));
////						
////						for (WebElement autoAirline : listOfAirline) 
////						  {
////							if (autoAirline.getText().equalsIgnoreCase(AirLine)) 
////							{
////								autoAirline.click();
////								break;
////							} 
////						  }
////						
////						JavascriptExecutor mo2 = (JavascriptExecutor) QaBrowser.driver;
////						mo2.executeScript("window.scrollBy(0,-300)", "");
////						
////						QaRobot.ClickOnElement("BookNowF");
////						QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Book Now</i></b>");
////						Thread.sleep(8000);
////					}
////				}
////			}
//
//			if (TravellerType.equalsIgnoreCase("Individual")) {
//				DnataCheckoutPage.individualforFlight(TravellerType, TripType, adult, child, infant, ModifySearch,
//						ChangeTravellers, adultM, childM, infantM, Resultpagestep, QuoteTitle, QuoteRemark,
//						Checkoutpagestep);
//			} else if (TravellerType.equalsIgnoreCase("Dependent")) {
//				DnataCheckoutPage.CheckoutForFlightDependent(TravellerType, TripType, adult, child, infant,
//						ModifySearch, ChangeTravellers, adultM, childM, infantM, Resultpagestep, QuoteTitle,
//						QuoteRemark, Checkoutpagestep);
//			}
			}
		}
	}

	public static void addFlight(String Server, String Trip, String ProductType, String TripType, String OriginCityCode,
			String OriginLocation, String DestinationCityCode, String DestinationLocation, String DepartureDate,
			String ReturnDate) throws Exception {
		QaRobot.ClickOnElement("AddFlightC");
		QaRobot.switchframe("//iframe[@id='AddCartPopupFrame']");
		if (TripType.equalsIgnoreCase("OneWay")) {
			QaRobot.ClickOnElement("OneWayC");
		} else if (TripType.equalsIgnoreCase("RoundTrip")) {
			QaRobot.ClickOnElement("RoundTripC");
		}
		TestBase.listofautosuggestion4(By.xpath("//div[@id='divDepartureCity']/p"), OriginCityCode, OriginLocation,
				By.xpath("//input[@id='txtDepartureCity']"));
		Thread.sleep(2000);
		QaExtentReport.test.log(Status.INFO,
				"<b><i>Departure city : </i></b>" + OriginCityCode + " - " + OriginLocation);
		Thread.sleep(2000);
		TestBase.listofautosuggestion4(By.xpath("//div[@id='divDestinationCity']/p"), DestinationCityCode,
				DestinationLocation, By.xpath("//input[@id='txtDestinationCity']"));
		Thread.sleep(2000);
		QaBrowser.driver.findElement(By.xpath("//div[@id='divDestinationCity']/p")).click();
		QaExtentReport.test.log(Status.INFO,
				"<b><i>Arrival city : </i></b>" + DestinationCityCode + " - " + DestinationLocation);
		Thread.sleep(2000);
//		QaBrowser.driver.findElement(By.xpath("//div[@id='flight_way1']/div[2]/div[1]/div/div[1]/label/span[2]/a/img"))
//				.click();
//		Thread.sleep(2000);
//		String DateSelection[] = DepartureDate.split("-");
//		String year = DateSelection[2];
//		String month = DateSelection[1];
//		String expDate = DateSelection[0];
//		String DateSelection1[] = ReturnDate.split("-");
//		String year1 = DateSelection1[2];
//		String month1 = DateSelection1[1];
//		String expDate1 = DateSelection1[0];
//		if (TripType.equalsIgnoreCase("OneWay")) {
//			selectDateInCalendarOneWay(expDate, month, year);
//		} else if (TripType.equalsIgnoreCase("RoundTrip")) {
//			selectDateInCalendarRoundTrip(expDate, month, year, expDate1, month1, year1);
//		}
		QaRobot.ClickOnElement("FlightCheckC");
		QaExtentReport.extentScreenshot("Add Flight");
		QaRobot.ClickOnElement("SearchFlightC");
		Thread.sleep(5000);
		List<WebElement> listOfRights1 = QaBrowser.driver
				.findElements(By.xpath("//div[@id='tdContainerTblAirlines']/ul/li/label/span"));
		for (WebElement autoRights1 : listOfRights1) {
			if (autoRights1.getText().equalsIgnoreCase("Jetstar Airways")) {
				autoRights1.click();
				break;
			}
		}
		QaRobot.scrollPage(-1000);
		if ((Server.equalsIgnoreCase("Staging") || Server.equalsIgnoreCase("Xchange")
				|| Trip.equalsIgnoreCase("International"))) {
//			QaRobot.ClickOnElement("FlightSelectC");
		}
		String getT = QaBrowser.driver.findElement(By.xpath("//span[contains(@id,'PT_')]")).getText();
		QaExtentReport.extentScreenshot("Flight Results");
		if (TripType.equalsIgnoreCase("OneWay")) {
			QaRobot.ClickOnElement("AddToCartFlightC");
			if (getT.equalsIgnoreCase("Out policy")) {
				QaRobot.alertAccept();
			}
			QaRobot.switchToWindow();
			QaRobot.ClickOnElement("FlightNotificationCloseC");
		} else if (TripType.equalsIgnoreCase("RoundTrip")) {
			if (Trip.equalsIgnoreCase("Domestic")) {
				QaRobot.ClickOnElement("AddToCartFlightC");
//				if (getT.equalsIgnoreCase("Out policy")) {
					QaRobot.alertAccept();
//				}
				Thread.sleep(3000);
				QaRobot.switchToWindow();
				QaRobot.ClickOnElement("FlightNotificationCloseC");
				QaRobot.ClickOnElement("ResultRJ");
				QaRobot.ClickOnElement("AddToCartFlightC");
//				if (getT.equalsIgnoreCase("Out policy")) {
					QaRobot.alertAccept();
//				}
				Thread.sleep(3000);
				QaRobot.switchToWindow();
				QaRobot.ClickOnElement("FlightNotificationCloseC");
			} else if (Trip.equalsIgnoreCase("International")) {
				QaRobot.ClickOnElement("AddToCartFlightC");
//				if (getT.equalsIgnoreCase("Out policy")) {
					QaRobot.alertAccept();
//				}
				QaRobot.switchToWindow();
				QaRobot.ClickOnElement("FlightNotificationCloseC");
			}
		}
		QaRobot.ClickOnElement("YourItineraryC");
		Thread.sleep(5000);
	}

	public static void addHotel(String Server, String ProductType, String CityCode, String CityTitle,
			String CheckInDate, String CheckOutDate) throws Exception {
		QaRobot.ClickOnElement("AddHotelC");
		QaRobot.switchframe("//iframe[@id='AddCartPopupFrame']");
		if(ProductType.equalsIgnoreCase("Car+Flight+Hotel") || ProductType.equalsIgnoreCase("Car+Hotel") || ProductType.equalsIgnoreCase("Car+Hotel+Flight")) {
			TestBase.listofautosuggestion4(By.xpath("//div[@id='divHTCity']/p"), CityCode, CityTitle,
					By.xpath("//input[@id='txtHotelSearch']"));
			QaExtentReport.test.log(Status.INFO, "<b><i>City Name : </i></b>" + CityCode + "-" + CityTitle);
			Thread.sleep(3000);
		}
//		if (ProductType.equalsIgnoreCase("Car+Flight+Hotel") || ProductType.equalsIgnoreCase("Flight+Hotel")
//				|| ProductType.equalsIgnoreCase("Flight+Hotel+Car")
//				|| ProductType.equalsIgnoreCase("Flight+Car+Hotel")) {
//			QaBrowser.driver.findElement(By.xpath("//div[@id='divHTCity']/p")).click();
//		}
//			QaBrowser.driver
//					.findElement(By.xpath("//form[@id='HotelSearchCntrl']/div/div[3]/div[1]/label/span[2]/a/img"))
//					.click();
//			Thread.sleep(2000);
//			String DateSelection[] = CheckInDate.split("-");
//			String year = DateSelection[2];
//			String month = DateSelection[1];
//			String expDate = DateSelection[0];
//			String DateSelection1[] = CheckOutDate.split("-");
//			String year1 = DateSelection1[2];
//			String month1 = DateSelection1[1];
//			String expDate1 = DateSelection1[0];
//			selectDateInCalendarHotel(expDate, month, year, expDate1, month1, year1);
		Thread.sleep(2000);
		QaRobot.ClickOnElement("CheckPolicyHotelC");
		QaExtentReport.extentScreenshot("Add Hotel");
		QaRobot.ClickOnElement("SearchHotelC");
		QaRobot.scrollPage(300);
		QaRobot.ClickOnElement("HotelSelectC");
		if (Server.equalsIgnoreCase("Staging")) {
			String getT = QaBrowser.driver.findElement(By.xpath("(//span[contains(@id,'Policy63902')])[3]")).getText();
			QaExtentReport.extentScreenshot("Hotel Results");
			QaRobot.ClickOnElement("AddToCartHotelC");
			if (getT.equalsIgnoreCase("Out policy")) {
				QaRobot.alertAccept();
			}
		} else if (Server.equalsIgnoreCase("Xchange") || Server.equalsIgnoreCase("tpstg")) {
			if (Server.equalsIgnoreCase("Xchange")) {
				String getT1 = QaBrowser.driver.findElement(By.xpath("(//span[contains(@id,'Policy324503')])[3]")).getText();
				QaExtentReport.extentScreenshot("Hotel Results");
				QaRobot.ClickOnElement("AddToCartHotelCX");
				if (getT1.equalsIgnoreCase("Out Of Policy")) {
					QaRobot.alertAccept();
				}
			} else if (Server.equalsIgnoreCase("tpstg")) {
				String getT1 = QaBrowser.driver.findElement(By.xpath("(//span[contains(@id,'Policy4')])[3]")).getText();
				QaExtentReport.extentScreenshot("Hotel Results");
				QaRobot.ClickOnElement("AddToCartHotelCX");
				if (getT1.equalsIgnoreCase("Out Of Policy")) {
					QaRobot.alertAccept();
				}
			}
		}
		QaRobot.switchToWindow();
		QaRobot.ClickOnElement("HotelNotificationCloseC");
		QaRobot.scrollPage(-300);
		QaRobot.ClickOnElement("YourItineraryC");
		Thread.sleep(5000);
		QaExtentReport.extentScreenshot("Your Itinerary");
	}

	public static void addCar(String Server, String ProductType, String PickUpCode, String PickUpCity,
			String PickUpDate, String DropOffDate, String DriversAge) throws Exception {
		QaRobot.ClickOnElement("AddCarC");
		QaRobot.switchframe("//iframe[@id='AddCartPopupFrame']");
//		TestBase.listofautosuggestion4(By.xpath("//div[@id='divCarPickUpName']/p"), PickUpCode, PickUpCity,
//				By.xpath("//input[@id='txtPickUpCity']"));
//		QaExtentReport.test.log(Status.INFO, "<b><i>City Name : </i></b>" + PickUpCode + "-" + PickUpCity);
//		Thread.sleep(3000);
//		if(ProductType.equalsIgnoreCase("Car+Flight+Hotel")||ProductType.equalsIgnoreCase("Flight+Hotel")) {
//			QaBrowser.driver.findElement(By.xpath("//div[@id='divHTCity']/p")).click();
//		}
//			QaBrowser.driver
//					.findElement(By.xpath("//form[@id='HotelSearchCntrl']/div/div[3]/div[1]/label/span[2]/a/img"))
//					.click();
//			Thread.sleep(2000);
//			String DateSelection[] = PickUpDate.split("-");
//			String year = DateSelection[2];
//			String month = DateSelection[1];
//			String expDate = DateSelection[0];
//			String DateSelection1[] = DropOffDate.split("-");
//			String year1 = DateSelection1[2];
//			String month1 = DateSelection1[1];
//			String expDate1 = DateSelection1[0];
//			selectDateInCalendarHotel(expDate, month, year, expDate1, month1, year1);
		Thread.sleep(2000);
//		QaRobot.selectTextFromDropdown("DriverAge1", DriversAge);
		QaRobot.ClickOnElement("CheckPolicyCarC");
		QaExtentReport.extentScreenshot("Add Car");
		QaRobot.ClickOnElement("SearchCarC");
		Thread.sleep(4000);
		QaRobot.scrollPage(300);
		QaExtentReport.extentScreenshot("Apply filter");
		QaRobot.ClickOnElement("SelectCar");
		if (Server.equalsIgnoreCase("Staging")) {
			String getT = QaBrowser.driver.findElement(By.xpath("(//span[contains(@id,'Policy63902')])[3]")).getText();
			QaExtentReport.extentScreenshot("Hotel Results");
			QaRobot.ClickOnElement("AddToCartHotelC");
			if (getT.equalsIgnoreCase("Out policy")) {
				QaRobot.alertAccept();
			}
		} else if (Server.equalsIgnoreCase("Xchange") || Server.equalsIgnoreCase("tpstg")) {
			String getT1 = QaBrowser.driver.findElement(By.xpath("(//span[contains(@id,'PT')])[3]")).getText();
			QaExtentReport.extentScreenshot("Car Results");
			QaRobot.ClickOnElement("AddToCartC");
			if (ProductType.equalsIgnoreCase("Flight+Car") || ProductType.equalsIgnoreCase("Flight+Hotel+Car")
					|| ProductType.equalsIgnoreCase("Flight+Car+Hotel") || ProductType.equalsIgnoreCase("Hotel+Car")
					|| ProductType.equalsIgnoreCase("Hotel+Flight+Car")
					|| ProductType.equalsIgnoreCase("Hotel+Car+Flight")) {
			} else {
				if (getT1.equalsIgnoreCase("Out policy")) {
					QaRobot.alertAccept();
				}
			}
		}
		QaRobot.switchToWindow();
		QaRobot.ClickOnElement("NotificationCloseC");
		QaRobot.scrollPage(-300);
		QaRobot.ClickOnElement("YourItineraryC");
		Thread.sleep(5000);
		QaExtentReport.extentScreenshot("Your Itinerary");
	}

	public static void selectDateInCalendarOneWay(String Day, String Month, String Year) throws Exception {
		Date date = new Date();
		DateFormat d = new SimpleDateFormat("dd-MM-yyyy");
		String NewDate = d.format(date);
		Date date1 = d.parse(NewDate);

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
		QaExtentReport.test.log(Status.INFO, "<b><i>Select Date  </i></b>" + Day + "-" + Month + "-" + Year);
		Assert.assertFalse(Integer.parseInt(Day) > 31, "Invalid date provided " + Day + "-" + Month + "-" + Year);
		Assert.assertFalse(Month.equals("Feb") && Integer.parseInt(Day) > 28,
				"Invalid date provided " + Day + "-" + Month + "-" + Year);
		Thread.sleep(3000);
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
	}

	public static void selectDateInCalendarRoundTrip(String Day, String Month, String Year, String Day1, String Month1,
			String Year1) throws Exception {
		Date date = new Date();
		DateFormat d = new SimpleDateFormat("dd-MM-yyyy");
		String NewDate = d.format(date);
		Date date1 = d.parse(NewDate);

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
		QaBrowser.driver
				.findElement(
						By.xpath("//div[@id='Return']/div/div/div[1]/div[1]/div[2]/div/div[2]/div[1]/div/div/label/i"))
				.click();
		Thread.sleep(2000);
		String monthYear1 = QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[1]/div")).getText();
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

	public static void selectDateInCalendarHotel(String Day, String Month, String Year, String Day1, String Month1,
			String Year1) throws Exception {
		Date date = new Date();
		DateFormat d = new SimpleDateFormat("dd-MM-yyyy");
		String NewDate = d.format(date);
		Date date1 = d.parse(NewDate);
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
