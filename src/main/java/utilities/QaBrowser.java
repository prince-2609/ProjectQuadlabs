package utilities;

import java.net.MalformedURLException;

import org.apache.poi.ss.formula.eval.NotImplementedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.beust.jcommander.Parameters;


public class QaBrowser extends QaRobot {

	public static WebDriver driver;
	public String browser = QaEnvironment.getProperty("browser","chrome");
	public String url = QaEnvironment.getProperty("sut.url");

	public WebDriver launchBrowser() throws Exception {
		if (this.url == null || this.url.isBlank() || this.url.isEmpty()) {
			throw new Exception("url is null");
		}
		quitBrowser();
		if (this.browser.equalsIgnoreCase("gecko")) {
			luanchFirefox();

		} else if (this.browser.equalsIgnoreCase("chrome")) {
			launchChrome();
		}
		driver.navigate().to(this.url);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		return driver;
	}

	public WebDriver launchBrowser(String url) throws Exception {
		this.url = url;
		return launchBrowser();
	}

	public void closeBrowser() {
		driver.close();
	}

	public void quitBrowser() {
		if (driver != null) {
			driver.quit();
		}
	}

//	@SuppressWarnings("deprecation")
	private void launchChrome() throws MalformedURLException {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\lib\\chromedriverMay24.exe");
//		DesiredCapabilities dc = DesiredCapabilities.chrome();
//		dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*"); 
		driver = (WebDriver) new ChromeDriver(opt);
	}
	
	private WebDriver luanchFirefox() {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\lib\\geckodriver1.exe");
//		DesiredCapabilities dc = DesiredCapabilities.firefox();
//		dc.setCapability("marionette", true);
//		FirefoxProfile profile = new FirefoxProfile();
//		profile.setAcceptUntrustedCertificates(true);
//		profile.setAssumeUntrustedCertificateIssuer(false);
		driver = (WebDriver) new FirefoxDriver();
		return driver;
	}

	@SuppressWarnings("unused")
	private WebDriver remoteWebDriver(DesiredCapabilities dc) throws MalformedURLException {
		throw new NotImplementedException("Remote web driver");
		// driver = new RemoteWebDriver(new URL(this.nodeUrl), dc);
		// return driver;
	}

}
