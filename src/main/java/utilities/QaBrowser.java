package utilities;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class QaBrowser {

	// static WebDriver driver;
	public WebDriver driver;
	public String browser;
	public String url;
	public String nodeUrl;

	public QaBrowser(String browser, String url, String nodeUrl) {
		this.browser = browser;
		this.url = url;
		this.nodeUrl = nodeUrl;
	}
	
	public WebDriver launchBrowser() throws MalformedURLException {
		quitBrowser();
		if (this.browser.equalsIgnoreCase("firefox")) {

			return luanchFirefox();

		} else if (this.browser.equalsIgnoreCase("chrome")) {

			return launchChrome();
		}
		driver.get(this.url);
		driver.manage().window().maximize();
		return null;
	}

	public void closeBrowser() {
		driver.close();
	}

	public void quitBrowser() {
		if (driver != null) {
			driver.quit();
		}
	}

	private WebDriver launchChrome() throws MalformedURLException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\lib\\chromedriver.exe");
		DesiredCapabilities dc = DesiredCapabilities.chrome();
		dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		driver = remoteWebDriver(dc);
		return driver;
	}

	private WebDriver luanchFirefox() {
		System.setProperty("webdriver.firefox.marionette", System.getProperty("user.dir") + "\\lib\\geckodriver.exe");
		DesiredCapabilities dc = DesiredCapabilities.firefox();
		dc.setCapability("marionette", true);
		FirefoxProfile profile = new FirefoxProfile();
		profile.setAcceptUntrustedCertificates(true);
		profile.setAssumeUntrustedCertificateIssuer(false);
		driver = new FirefoxDriver(profile);
		return driver;
	}

	private WebDriver remoteWebDriver(DesiredCapabilities dc) throws MalformedURLException {
		driver = new RemoteWebDriver(new URL(this.nodeUrl), dc);
		return driver;
	}

}
