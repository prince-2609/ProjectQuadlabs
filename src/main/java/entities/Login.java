package entities;


import TestScript.RoundTrip.Flight;
import utilities.QaRobot;

public class Login extends Flight
{
	
	public static void login(String username, String password) throws Exception
	{
		
		QaRobot.getWebElement("clicksignin").click();
		QaRobot.getWebElement("username").sendKeys(username);
		QaRobot.getWebElement("password").sendKeys(password);
		QaRobot.getWebElement("signin").click();
		QaRobot.getWebElement("homepage").click();
	}
}
