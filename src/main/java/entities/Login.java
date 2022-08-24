package entities;


import TestScript.RoundTrip.Flight;
import utilities.QaRobot;

public class Login extends Flight
{
	
	public static void B2Clogin(String username, String password) throws Exception
	{
		
		QaRobot.getWebElement("clicksignin").click();
		QaRobot.getWebElement("username").sendKeys(username);
		QaRobot.getWebElement("password").sendKeys(password);
		QaRobot.getWebElement("signin").click();
		QaRobot.getWebElement("homepage").click();
	}
	
	public static void SbtLogin(String username, String password) throws Exception
	{
		//QaRobot.getWebElement("sbt_compcode").sendKeys(companycode);
		QaRobot.getWebElement("sbt_Login").sendKeys(username);
		QaRobot.getWebElement("sbt_Pasword").sendKeys(password);
		QaRobot.getWebElement("sbt_submit").click();
	}
	public static void V12SbtLogin(String companyCode,String username, String password) throws Exception
	{
		QaRobot.getWebElement("sbt_compcode").sendKeys(companyCode);
		QaRobot.getWebElement("sbt_Login").sendKeys(username);
		QaRobot.getWebElement("sbt_Pasword").sendKeys(password);
		QaRobot.getWebElement("sbt_submit").click();
	}
}
