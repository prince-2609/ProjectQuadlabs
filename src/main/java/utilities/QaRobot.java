package utilities;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import Base.TestBase;
/**
 * Selenium Utility
 * @author Anjali.Jain
 *
 */
public class QaRobot {

	/**
	 * 
	 * @param locator
	 * @return WebElement
	 * @throws Exception
	 */
	// *** This Function returns the Locators in the Web Application *****
	public static WebElement getLocator(String locator) throws Exception {
		String locatorType = locator.split(":")[0];
		String locatorValue = locator.split(":")[1];
	
		if (locatorType.toLowerCase().equals("xpath"))
			return TestBase.driver.findElement(By.xpath(locatorValue));
		else if (locatorType.toLowerCase().equals("id"))
			return TestBase.driver.findElement(By.id(locatorValue));
		else if (locatorType.toLowerCase().equals("class"))
			return TestBase.driver.findElement(By.className(locatorValue));
		else if (locatorType.toLowerCase().equals("tag"))
			return TestBase.driver.findElement(By.tagName(locatorValue));
		else if (locatorType.toLowerCase().equals("link"))
			return TestBase.driver.findElement(By.linkText(locatorValue));
		else if (locatorType.toLowerCase().equals("css"))
			return TestBase.driver.findElement(By.cssSelector(locatorValue));
		else if (locatorType.toLowerCase().equals("name"))
			return TestBase.driver.findElement(By.name(locatorValue));
		else
			throw new Exception("Unknown Locator Type" + locatorType);
	}

	public static WebElement getWebElement(String locator) throws Exception {
		return getLocator(TestBase.obj.getProperty(locator));
	}

	// click on element
	public static void ClickOnElement(String locator2, String text) throws Exception {
	
		WebElement element = getWebElement(locator2);
	
		element.click();
	
		TestBase.test.log(Status.INFO, text);
	
	}

	//send the value on textbox
	public static void PassValue(String Locator, String value, String text) throws Exception {
	
		getWebElement(Locator).sendKeys(value);
		TestBase.test.log(Status.INFO, text);
	
	}

	public static void PassValueByLocator(String Locator, String value, String text) throws Exception {
	
		TestBase.driver.findElement(By.xpath(Locator)).sendKeys(value);
		TestBase.test.log(Status.INFO, text);
	}

	/**
	 *  wait till alert is present
	 * @param time
	 */
	public static void explicitwaitalert(int time) {
		TestBase.wait = new WebDriverWait(TestBase.driver, time);
		TestBase.wait.until(ExpectedConditions.alertIsPresent());
	
	}

	/**
	 *  implicit wait
	 * @param time
	 */
	public static void impliwait(int time) {
		TestBase.driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	/**
	 *  Explicit Wait element to be clickable
	 * @param time
	 * @param e
	 */
	public static void explicitwaitclickable(int time, By e) {
		TestBase.wait = new WebDriverWait(TestBase.driver, time);
		TestBase.wait.until(ExpectedConditions.elementToBeClickable(e));
	}

	/**
	 *  Explicit Wait invisibility of element
	 * @param time
	 * @param e
	 */
	public static void explicitwaitinvisible(int time, By e) {
		TestBase.wait = new WebDriverWait(TestBase.driver, time);
		TestBase.wait.until(ExpectedConditions.invisibilityOfElementLocated(e));
	
	}

	/**
	 * Visibility of element
	 * @param time
	 * @param e
	 */
	public static void explicitwaitvisible(int time, By e) {
		TestBase.wait = new WebDriverWait(TestBase.driver, time);
		TestBase.wait.until(ExpectedConditions.visibilityOfElementLocated(e));
	
	}

	/**
	 *  select value from drop down by value
	 * @param locator1
	 * @param value
	 * @param text
	 * @throws Exception
	 */
	public static void selectValueFromDropdown(String locator1, String value, String text) throws Exception {
	
		WebElement element = getWebElement(locator1);
		Select s = new Select(element);
		s.selectByValue(value);
		TestBase.test.log(Status.INFO, text);
	
	}

	public static void selectValueByLocator(String locator1, String value, String text) throws Exception {
	
		WebElement element = TestBase.driver.findElement(By.xpath(locator1));
		Select s = new Select(element);
		s.selectByValue(value);
		TestBase.test.log(Status.INFO, text);
	
	}

	// select locator
	public static void selectTextByLocator(String locator1, String value, String text) throws Exception {
	
		WebElement element = TestBase.driver.findElement(By.xpath(locator1));
		Select s = new Select(element);
		s.selectByVisibleText(value);
		TestBase.test.log(Status.INFO, text);
	
	}

	/**
	 *  select value from drop down by text
	 * @param locator1
	 * @param value
	 * @param text
	 * @throws Exception
	 */
	public static void selectTextFromDropdown(String locator1, String value, String text) throws Exception {
	
		WebElement element = getWebElement(locator1);
		Select s = new Select(element);
		s.selectByVisibleText(value);
		TestBase.test.log(Status.INFO, text);
	
	}

	// select locator
	public static void selectDropdownValue(String locator1, String value, String text) throws Exception {
	
		WebElement element = TestBase.driver.findElement(By.xpath(locator1));
		Select dropdown = new Select(element);
	
		// Get all options
		List<WebElement> dd = dropdown.getOptions();
	
		// Get the length
		System.out.println(dd.size());
	
		// Loop to print one by one
		for (int j = 0; j < dd.size(); j++) {
			// System.out.println(dd.get(j).getText());
	
			if (dd.get(j).getText().equalsIgnoreCase(value)) {
	
				dropdown.selectByIndex(j);
	
				TestBase.test.log(Status.INFO, text);
			}
		}
	
	}

	// select locator
	public static void selectDropdownValuebyLocator(String locator1, String value, String text) throws Exception {
	
		WebElement element = getWebElement(locator1);
		Select dropdown = new Select(element);
	
		// Get all options
		List<WebElement> dd = dropdown.getOptions();
	
		// Get the length
		System.out.println(dd.size());
	
		// Loop to print one by one
		for (int j = 0; j < dd.size(); j++) {
			// System.out.println(dd.get(j).getText());
	
			if (dd.get(j).getText().equalsIgnoreCase(value)) {
	
				dropdown.selectByIndex(j);
	
				TestBase.test.log(Status.INFO, text);
			}
		}
	
	}

}
