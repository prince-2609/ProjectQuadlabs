package product.Flight.suite.Oneway;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;
import utilities.QaBrowser;
import utilities.QaExtentReport;
import utilities.QaRobot;

public class SearchDashboard {

	/**
	 * Select traveler for booking
	 * 
	 * @param emailid
	 * @throws Exception
	 */
	public static void selectEmployee(String traveler) throws Exception {

		QaRobot.ClickOnElement("ow_Searchemp");
		QaExtentReport.test.log(Status.INFO, "<b><i>Corporate employee: </i></b>" + traveler);

		// get list of all travelers

		List<WebElement> corpUsers = QaBrowser.driver
				.findElements(By.xpath("//table[@id='gridCorporateTravel']/tbody/tr"));
		// List<WebElement> corpUsers =
		// QaBrowser.driver.findElements(By.xpath("//table[@id='gridCorporateTravel']/tbody/tr/td[2]"));

		// Skip first title index start loop from 1
		for (int index = 1; index < corpUsers.size(); index++) {

			WebElement user = corpUsers.get(index);

			String corpuser = user.findElement(By.xpath(".//td/span[2]")).getText();

			if (corpuser.equalsIgnoreCase(traveler)) {

				user.findElement(By.xpath(".//td/span[1]")).click();
				break;

			} else {
				QaExtentReport.test.log(Status.INFO,
						"Corporate traveler does not match with " + traveler + " traveler");
			}

		}
	}

	public static void selectEmployeeWithID(String travelerID) throws Exception {
		QaRobot.ClickOnElement("ow_Searchemp");
		Thread.sleep(3000);
		QaExtentReport.extentScreenshot("Employees");
		QaExtentReport.test.log(Status.INFO, "<b><i>Employee Email : </i></b>" + travelerID);
		QaBrowser.driver.findElement(By.xpath("//input[@id='txtEmailAddress']")).sendKeys(travelerID);
		QaBrowser.driver.findElement(By.xpath("//input[@id='btnSearchUser']")).click();
		Thread.sleep(3000);
		// get list of all travelers
		List<WebElement> corpUsers = QaBrowser.driver
				.findElements(By.xpath("//table[@id='gridCorporateTravel']/tbody/tr/td[2]"));
		int index = 0;
		for (WebElement cropUser : corpUsers) {
			String TextofCropUser = cropUser.getText();
			index = index + 1;
			if (TextofCropUser.equalsIgnoreCase(travelerID)) {
				QaBrowser.driver.findElement(By
						.xpath("(//span[@style='padding-left: 8px; padding-right: 8px; float: left;'])[" + index + "]"))
						.click();
				break;
			} else {
//				QaExtentReport.test.log(Status.INFO,"Corporate traveler ID does not match with " + travelerID );
				System.out.println("Not match");
			}
		}
	}

	public static void selectRoomPax(String roomcount, String adult, String child, String ageofchildren) {
		int room = Integer.parseInt(roomcount);
		String[] adultcount = adult.split(",");
		String[] childcount = child.split(",");
		// select adult and child
		for (int i = 1; i <= room; i++) {
			WebElement adultelement = QaBrowser.driver.findElement(By.xpath("//select[@id='ddlHHLAdultR" + i + "']"));
			Select selectadult = new Select(adultelement);
			selectadult.selectByValue(adultcount[i - 1]);

			WebElement childelement = QaBrowser.driver.findElement(By.xpath("//select[@id='ddlHHLChildR" + i + "']"));
			Select selectchild = new Select(childelement);
			selectchild.selectByValue(childcount[i - 1]);

		}
		// select the child age if have
		String[] ageofchild = ageofchildren.split(",");
		for (String chd : childcount) {
			int chdcount = Integer.parseInt(chd);
			for (int i = 1; i <= chdcount; i++) {
				WebElement childrenage = QaBrowser.driver
						.findElement(By.xpath("//select[@id='ddlHHLChild" + i + "R" + chdcount + "']"));
				Select selectage = new Select(childrenage);
				selectage.selectByValue(ageofchild[i - 1]);
			}

		}
	}

//	/**
//	 * Select employee trip type for booking
//	 * 
//	 * @param emailid
//	 * @throws Exception
//	 */
//	public static void selectEmpTripType(String tripType) throws Exception {
//		if (tripType.equalsIgnoreCase("business")) {
//			QaRobot.clickElement("trip_Busniess", "business trip");
//
//		}
//		if (tripType.equalsIgnoreCase("family")) {
//			QaRobot.clickElement("trip_family", "book for family");
//
//		} else {
//			QaRobot.clickElement("trip_personal", "personal");
//		}
//
//	}

	// Travel policy checkbox for flight
	public static void FlightpolicyCheck() throws Exception {
		QaRobot.ClickOnElement("ow_checkpolicy");
	}

	// Travel policy checkbox for Hotel
	public static void hotelPolicyCheck() throws Exception {
		QaRobot.ClickOnElement("ow_hotelpolicy");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked travel policy check</i></b>");
	}

	// method for clicking search button
	public static void clickSearchFlightButton() throws Exception {
		QaRobot.ClickOnElement("ow_searchflight");
		QaExtentReport.test.log(Status.INFO, "<b><i>search flight button</i></b>");
	}

	// selection for muliple pax form search dashboard
	public static void selectTravellers(String adult, String child, String infant) throws Exception {

		QaRobot.ClickOnElement("ow_travellers");
		QaExtentReport.test.log(Status.INFO, "<b><i>travellers</i></b>");
		QaRobot.selectTextFromDropdown("ow_adult", adult, "adult for booking");
		QaRobot.selectTextFromDropdown("ow_child", child, "child for booking");
		QaRobot.selectTextFromDropdown("ow_infant", infant, "infant for booking");
	}

}
