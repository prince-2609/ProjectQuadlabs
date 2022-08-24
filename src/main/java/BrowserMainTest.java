import java.net.MalformedURLException;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;

public class BrowserMainTest {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		launchEdge();
	}

	private static void launchChrome() throws MalformedURLException {
		
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\lib\\chromedriver.exe");
		//DesiredCapabilities dc = DesiredCapabilities.chrome();
		//dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		//WebDriver driver = new ChromeDriver(dc);
		
	}
	
	private static void launchEdge() {
		System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"\\lib\\msedgedriver.exe");
		System.setProperty("webdriver.edge.verboseLogging", "true");
		EdgeDriverService service = EdgeDriverService.createDefaultService();

		EdgeDriver driver = new EdgeDriver(service);
		

	}
}
