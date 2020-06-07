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
import com.aventstack.extentreports.reporter.BasicFileReporter;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentKlovReporter;
import com.aventstack.extentreports.reporter.ExtentLoggerReporter;

public class Logger {

	public static ExtentReports extent = new ExtentReports();
	public static ExtentKlovReporter klovReport = new ExtentKlovReporter("klovProjectName");
	public static ExtentTest test;

	public static BasicFileReporter reporter = new ExtentLoggerReporter("basicreport.html"); 
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
		// intialize with a project name, build name
		ExtentKlovReporter klov = new ExtentKlovReporter("project", "build");
		// address, host/port of MongoDB
		klov.initMongoDbConnection("localhost", 27017);
		// Klov server address
		klov.initKlovServerConnection("http://localhost");

		extent.setSystemInfo("Application Name", "Yahoo Test");
		extent.setSystemInfo("User Name", "Ankur Jain");
		extent.setSystemInfo("Envirnoment", "Production");

		extent.attachReporter(reporter, klov);
		
		ExtentTest test = extent.createTest("Test"); // level = 0
		ExtentTest node = test.createNode("Node");  // level = 1
		node.pass("details");

		// short-hand
		extent.createTest("MyFirstTest").createNode("MyFirstChildTest").pass("details");

		// description
		ExtentTest node1 = test.createNode("MyFirstChildTest", "Node Description");
		
		node1.pass("Yahoo");
		
		test.getExtent().flush();
		//htmlReporter.config().enableTimeline(true);
		// htmlReporter.config().setAutoCreateRelativePathMedia(true);
		//report.attachReporter(klovReport, htmlReporter);
	}

	public static void setProjectName(String projectName) {
		klovReport.setProjectName(projectName);
	}

	public static void setProjectName() {
		setProjectName(QaEnvironment.getProperty("klov.project.name"));
	}

	public static void setReportName(String reportName) {
		klovReport.setReportName(reportName);
	}
	
	public static void setReportName() {
		setReportName(QaEnvironment.getProperty("klov.report.name"));
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
