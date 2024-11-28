package SBT_Corporate;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Base.TestBase;
import utilities.QaBrowser;
import utilities.QaDataProvider;
import utilities.QaExtentReport;
import utilities.QaRobot;

@Listeners(listenerClass.Listener.class)
public class ManageTraveller_CreateNewTraveller {

	@DataProvider
	public Object[][] getexceldata() throws Exception {
		return QaDataProvider.getTestdata("SBT_ManageTraveller_CreateNewTraveller", "Sheet1");
	}

	@Test(dataProvider = "getexceldata")
	public static void travellerProfiling(String TestCaseId, String TestScenario, String ccode, String URL,
			String Username, String Password, String TravellerName, String Gender, String TUserName, String TEmail,
			String SelectBranchName, String Language, String Country, String MobileCountry, String MobileNo,
			String TravellerType, String TotalRights, String RightNames, String PassportNo, String TravellerDOB,
			String PPlaceOfIssue, String PValidFrom, String PExpireFrom, String VisaNumber, String CountryOfVisa,
			String VValidFrom, String VExpireFrom, String DependentName, String DGender, String DepDOB,
			String DRelation, String DPassportNo, String DpassportExpiryDate, String DNationality,
			String DPassIssuingCountry) throws Exception {
		QaExtentReport.test = QaExtentReport.report.createTest(TestCaseId + "-" + TestScenario);
		TestBase.Companycode(ccode, URL);
		QaRobot.impliwait(30);
		QaRobot.PassValue("User_name", Username);
		QaRobot.PassValue("Password", Password);
		QaRobot.ClickOnElement("ESubmit");
		Thread.sleep(10000);
		QaExtentReport.extentScreenshot("Dashboard");
		QaRobot.ClickOnElement("NotificationClose");
		Thread.sleep(3000);
		QaRobot.mouseHover("//span[@id='HeaderTop_lblSettingMenu']", "//a[@id='HeaderTop_aUserManagement']");
		QaExtentReport.extentScreenshot("Corporate Dashboard Page");
		QaRobot.ClickOnElement("MTCreateNewTraveller");
		Thread.sleep(3000);
		String HolderName[] = TravellerName.split(" ");
		String FNTitle = HolderName[0];
		String FN = HolderName[1];
		String LN = HolderName[2];
		QaRobot.selectTextByLocator("//select[@id='ddltitle']", FNTitle);
		QaRobot.PassValue("TravellerFN", FN);
		QaRobot.PassValue("TravellerLN", LN);
		if (Gender.equalsIgnoreCase("Male")) {
			QaRobot.ClickOnElement("GMAle");
		} else if (Gender.equalsIgnoreCase("Female")) {
			QaRobot.ClickOnElement("GFemale");
		}
		QaRobot.PassValue("TUserName", TUserName);
		QaRobot.PassValue("TEmailId", TEmail);
		QaRobot.selectTextByLocator("//select[@id='cbobranch']", SelectBranchName);
		QaRobot.selectTextByLocator("//select[@id='cboLang']", Language);
		QaRobot.selectTextByLocator("//select[@id='drpDownCountryOfResidence']", Country);
		QaRobot.ClickOnElement("TBuSameAsCorporate");
		QaRobot.selectTextByLocator("//select[@id='ddlMobileCountryCode']", MobileCountry);
		QaRobot.PassValue("MobileNo", MobileNo);
		QaRobot.selectTextByLocator("//select[@id='dd_Designation']", "QA");
		QaRobot.selectTextByLocator("//select[@id='ddlempgradecat']", "Excellent");
		if (TravellerType.equalsIgnoreCase("Administrator")) {
			QaRobot.ClickOnElement("Administrator");
		} else if (TravellerType.equalsIgnoreCase("Travel Arranger")) {
			QaRobot.ClickOnElement("TravelArranger");
		} else if (TravellerType.equalsIgnoreCase("Travel Co-ordinator")) {
			QaRobot.ClickOnElement("TravelCoOrdinator");
		} else if (TravellerType.equalsIgnoreCase("Employee")) {
			QaRobot.ClickOnElement("Employee");
		}
		int pAS = Integer.parseInt(TotalRights);
		for (int i = 1; i <= pAS; i++) {
			String[] tN = RightNames.split(",");
			String b = tN[i - 1];
			List<WebElement> listOfRights = QaBrowser.driver.findElements(
					By.xpath("//div[@id='divEmployeeRights']/div/label/span/label"));
			for (WebElement autoRights : listOfRights) {
				if (autoRights.getText().equalsIgnoreCase(b)) {
					autoRights.click();
					break;
				}
			}
		}
		QaRobot.ClickOnElement("VIP");
		QaRobot.ClickOnElement("CIP");
		QaRobot.ClickOnElement("Acknowledgment1");
		QaRobot.ClickOnElement("Acknowledgment2");
//		QaRobot.ClickOnElement("TravellerSave");
//		QaRobot.ClickOnElement("SearchOption");
//		Thread.sleep(5000);
//		QaRobot.PassValue("SUserFN", FN);
//		QaRobot.ClickOnElement("SUserSearch");
//		QaRobot.ClickOnElement("SelectTraveller");
//		QaRobot.ClickOnElement("PassportDetails");
//		QaRobot.ClickOnElement("AddPassport");
//		QaRobot.PassValue("PassportNo", PassportNo);
//		QaRobot.ClickOnElement("TravellerDOB");
//		String DateSelection[] = TravellerDOB.split("-");
//		String year = DateSelection[2];
//		String month = DateSelection[1];
//		String expDate = DateSelection[0];
//		QaRobot.selectDateInCalendar(expDate, month, year);
//		String City[] = PPlaceOfIssue.split(",");
//		String City1 = City[0];
//		String City2 = City[1];
//		TestBase.listofautosuggestion(By.xpath("//div[@id='divCityPassport']/p"), City1, City2,
//				By.xpath("//input[@id='txtSearchCity']"));
//		QaRobot.ClickOnElement("PValidFrom");
//		String DateSelection1[] = PValidFrom.split("-");
//		String year1 = DateSelection1[2];
//		String month1 = DateSelection1[1];
//		String expDate1 = DateSelection1[0];
//		QaRobot.selectDateInCalendar(expDate1, month1, year1);
//		QaRobot.ClickOnElement("PExpireFrom");
//		String DateSelection2[] = PExpireFrom.split("-");
//		String year2 = DateSelection2[2];
//		String month2 = DateSelection2[1];
//		String expDate2 = DateSelection2[0];
//		QaRobot.selectDateInCalendar(expDate2, month2, year2);
//		QaRobot.ClickOnElement("PassportPrimary");
//		QaRobot.ClickOnElement("AddPassport");
//		QaRobot.ClickOnElement("VisaDetails");
//		QaRobot.ClickOnElement("AddVisa");
//		QaRobot.PassValue("VisaNumber", VisaNumber);
//		QaRobot.selectTextByLocator("//select[@id='ddlVisa_CountryCode']", CountryOfVisa);
//		QaRobot.ClickOnElement("VValidFrom");
//		String DateSelection3[] = VValidFrom.split("-");
//		String year3 = DateSelection3[2];
//		String month3 = DateSelection3[1];
//		String expDate3 = DateSelection3[0];
//		QaRobot.selectDateInCalendar(expDate3, month3, year3);
//		QaRobot.ClickOnElement("VExpireFrom");
//		String DateSelection4[] = VExpireFrom.split("-");
//		String year4 = DateSelection4[2];
//		String month4 = DateSelection4[1];
//		String expDate4 = DateSelection4[0];
//		QaRobot.selectDateInCalendar(expDate4, month4, year4);
//		QaRobot.ClickOnElement("AddVisa");
//		QaRobot.ClickOnElement("DependentDetails");
//		QaRobot.ClickOnElement("AddDependent");
//		String HolderName1[] = DependentName.split(" ");
//		String FNTitle1 = HolderName1[0];
//		String FN1 = HolderName1[1];
//		String LN1 = HolderName1[2];
//		QaRobot.selectTextByLocator("//select[@id='ddlDependantTitle']", FNTitle1);
//		QaRobot.PassValue("DFN", FN1);
//		QaRobot.PassValue("DLN", LN1);
//		if (DGender.equalsIgnoreCase("Male")) {
//			QaRobot.ClickOnElement("DMale");
//		} else if (DGender.equalsIgnoreCase("Female")) {
//			QaRobot.ClickOnElement("DFemale");
//		}
//		QaRobot.ClickOnElement("DDOB");
//		String DateSelection5[] = DepDOB.split("-");
//		String year5 = DateSelection5[2];
//		String month5 = DateSelection5[1];
//		String expDate5 = DateSelection5[0];
//		QaRobot.selectDateInCalendar(expDate5, month5, year5);
//		QaRobot.selectTextByLocator("//select[@id='ddlDependantRelation']", DRelation);
//		QaRobot.PassValue("DPassportNo", DPassportNo);
//		QaRobot.ClickOnElement("DPassportExpiryDate");
//		String DateSelection6[] = DpassportExpiryDate.split("-");
//		String year6 = DateSelection6[2];
//		String month6 = DateSelection6[1];
//		String expDate6 = DateSelection6[0];
//		QaRobot.selectDateInCalendar(expDate6, month6, year6);
//		QaRobot.selectTextByLocator("//select[@id='ddlPassnationality']", DNationality);
//		QaRobot.selectTextByLocator("//select[@id='ddlpassisscountry']", DPassIssuingCountry);
//		QaRobot.ClickOnElement("DAcknowledgment1");
//		QaRobot.ClickOnElement("DAcknowledgment2");
//		QaRobot.ClickOnElement("DSave");

	}

	@AfterTest
	public void After_Test() {
//		QaExtentReport.test.getExtent().flush();
	}
}
