package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentKlovReporter;

public class Logger {

	public static ExtentReports report = new ExtentReports();
	public static ExtentKlovReporter klovReport = new ExtentKlovReporter();
	public static ExtentTest test;
	public static ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(
			"D:\\Webdriverwork\\projectb2c1\\HtmlReport\\Report.html");

	/**
	 * Take screenshot
	 * 
	 * @param driver
	 * @param fileWithPath
	 * @return
	 * @throws IOException
	 */
	public static String takeScreenshot(WebDriver driver, String fileWithPath) throws IOException {
		// Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		// Call getScreenshotAs method to create image file
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		// Move image file to new destination
		File DestFile = new File(fileWithPath);
		// Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);
		return fileWithPath;
	}

	/**
	 * maintain report on server.
	 */
	public static void initKlovReport() {
		klovReport.loadConfig("D:\\Webdriverwork\\projectb2c1\\lib\\application.properties");
		klovReport.initMongoDbConnection("localhost", 27017);
		klovReport.setProjectName("QlB2C");
		klovReport.setReportName("Release Server");
		klovReport.initKlovServerConnection("http://localhost");
		htmlReporter.config().enableTimeline(true);
		htmlReporter.config().setAutoCreateRelativePathMedia(true);
		report.attachReporter(klovReport, htmlReporter);
	}

	/**
	 * Log the test in report.
	 * 
	 * @param logInfo
	 */
	public static void log(String logInfo) {
		test.log(Status.INFO, logInfo);
	}

	public static void pass(WebDriver driver) throws IOException {
		String screenShotPath = Logger.takeScreenshot(driver, "Pass");
		test.log(Status.PASS, "Successful Booking Snapshot Below :",
				MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		System.out.println("********* Passed *********");
	}

	public static void fail(WebDriver driver) throws IOException {
		String screenShotPath = Logger.takeScreenshot(driver, "Fail");
		test.log(Status.FAIL, "Failed Booking Snapshot Below :",
				MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		System.out.println("********* Failed *********");

	}
}
