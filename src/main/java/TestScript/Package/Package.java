package TestScript.Package;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Base.TestBase;
import TestScript.RoundTrip.Flightcheck;
import entities.Package_Search;
import utilities.QaDataProvider;
import utilities.QaExcelRead;
import utilities.QaRobot;

public class Package extends Flightcheck {

	TestBase t;
	QaExcelRead reader;

	@DataProvider
	public Object[][] getexceldata() throws Exception {

	
		return QaDataProvider.getTestdata("package","Sheet1");
	}

	@Test(dataProvider = "getexceldata")

	public static void PackageTrip(String ccode,String dest, String dest_name, String Pbooking, String Enquiry_name,
			String Enquiry_Lname, String Enquiry_contact, String Enquiry_emailid, String month, String date,
			String dbl_type, String Dbl_adult, String Dbl_child, String Dbl_childCategory, String Dbl_ExtraBed,
			String Twn_type, String twn_adult, String twn_child, String twn_childCategory, String twn_ExtraBed,
			String tpl_type, String tpl_adult, String tpl_child, String tpl_childCategory, String sin_type,
			String sin_adult, String sin_child, String sin_childCategory, String qud_type, String qud_adult,
			String qud_child, String qud_childCategory, String dbl_title, String dbl_fname, String dbl_lname,
			String dbl_ph, String dbl_emailid, String dbl_ctitle, String dbl_cfname, String dbl_clname,String dbl_cage,
			String dbl_etitle, String dbl_efname, String dbl_elname, String dbl_ititle, String dbl_ifname,
			String dbl_ilname, String dbl_infant_age, String dbl_infant, String Twn_title, String Twn_fname,
			String Twn_lname,  String Twn_ctitle, String Twn_cfname,
			String Twn_clname,String Twn_cage, String Twn_etitle, String Twn_efname, String Twn_elname, String Twn_ititle,
			String Twn_ifname, String Twn_ilname, String Twn_infant_age, String Twn_infant, String Tpl_title,
			String Tpl_fname, String Tpl_lname,  String Tpl_ctitle, String Tpl_cfname,
			String Tpl_clname,String Tpl_cage, String Tpl_ititle, String Tpl_ifname, String Tpl_ilname,String Tpl_infant_age, String Tpl_infant,
			String Sin_title, String Sin_fname, String Sin_lname,  String Sin_ctitle,
			String Sin_cfname, String Sin_clname,String Sin_cage, String Sin_ititle, String Sin_ifname, String Sin_ilname,String Sin_infant_age,
			String Sin_infant, String Qud_title, String Qud_fname, String Qud_lname, 
			String Qud_ctitle, String Qud_cfname, String Qud_clname, String Qud_cage,String Qud_ititle, String Qud_ifname,
			String Qud_ilname,String Qud_infant_age, String Qud_infant,String cardmode, String type, String cardno, String cardname, String cardmonth,
			String cardyear, String cardcvv,String baddress, String bcity, String bcityauto, String bstate, String bcountry,String Ph_EmailType,String PayMode) throws Exception {
		
		
		Companycode(ccode);
		test = report.createTest("Package");

		QaRobot.ClickOnElement("package", "Clicked on Holidays");

		Package_Search.pack_search(dest, dest_name, Pbooking, Enquiry_name, Enquiry_Lname, Enquiry_contact,
				Enquiry_emailid, month, date, dbl_type, Dbl_adult, Dbl_child, Dbl_childCategory, Dbl_ExtraBed, Twn_type,
				twn_adult, twn_child, twn_childCategory, twn_ExtraBed, tpl_type, tpl_adult, tpl_child,
				tpl_childCategory, sin_type, sin_adult, sin_child, sin_childCategory, qud_type, qud_adult, qud_child,
				qud_childCategory, dbl_title, dbl_fname, dbl_lname, dbl_ph, dbl_emailid, dbl_ctitle, dbl_cfname,
				dbl_clname,dbl_cage, dbl_etitle, dbl_efname, dbl_elname, dbl_ititle, dbl_ifname, dbl_ilname, dbl_infant_age,
				dbl_infant, Twn_title, Twn_fname, Twn_lname, Twn_ctitle, Twn_cfname, Twn_clname,Twn_cage,
				Twn_etitle, Twn_efname, Twn_elname, Twn_ititle, Twn_ifname, Twn_ilname, Twn_infant_age, Twn_infant,
				Tpl_title, Tpl_fname, Tpl_lname,  Tpl_ctitle, Tpl_cfname, Tpl_clname, Tpl_cage,Tpl_ititle,
				Tpl_ifname, Tpl_ilname, Tpl_infant_age,Tpl_infant, Sin_title, Sin_fname, Sin_lname,  Sin_ctitle,
				Sin_cfname, Sin_clname, Sin_cage,Sin_ititle, Sin_ifname, Sin_ilname,Sin_infant_age,Sin_infant, Qud_title, Qud_fname, Qud_lname,
				 Qud_ctitle, Qud_cfname, Qud_clname,Qud_cage ,Qud_ititle, Qud_ifname, Qud_ilname,Qud_infant_age,
				Qud_infant, cardmode,  type,  cardno,  cardname,  cardmonth,
				 cardyear,  cardcvv, baddress,  bcity,  bcityauto,  bstate,  bcountry, Ph_EmailType,PayMode);

	}

	@AfterMethod
	public static void afterMetod() {
		test.getExtent().flush();
	}

}
