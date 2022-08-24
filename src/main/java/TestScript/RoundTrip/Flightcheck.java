package TestScript.RoundTrip;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;


import Base.TestBase;
import CarporateSBT.preApprovalQueue1;
import utilities.QaExcelRead;
import utilities.QaExtentReport;
import utilities.Logger;
import utilities.QaBrowser;

public class Flightcheck extends TestBase implements ITestListener 
{
	QaExcelRead reader;
	QaBrowser browser;
//	QaExtentReport extentreport;
	
	public static void ScreenshotMethod(String text) throws IOException 
	{
		Date date = new Date();
		DateFormat d = new SimpleDateFormat("MM-dd-yy & HH-mm-ss");
		String NewDate = d.format(date);
		
		TakesScreenshot ts = (TakesScreenshot)QaBrowser.driver;
		File Source = ts.getScreenshotAs(OutputType.FILE);
		File Dest = new File("D:\\Automation\\projectb2c1\\Screenshot\\"+NewDate+text+".jpg");
		FileUtils.copyFile(Source, Dest);
	}
	
	public void onTestStart(ITestResult result) 
	{	
//		test = report.createTest("Pre Approval Queue for Business Trip");
	}

	public void onTestSuccess(ITestResult result) {

		try {

			if (result.getStatus() == ITestResult.SUCCESS) {

				Flightcheck.ScreenshotMethod("Test Case Pass");
//				String screenShotPath = Logger.takeScreenshot(QaBrowser.driver, "D:\\Automation\\projectb2c1\\Screenshot\\Test Case Pass.png");
				QaExtentReport.test.log(Status.PASS, "<b><i>Successful Booking</i></b>");
			}
		} catch (IOException e) {

			e.printStackTrace();
		}
		
//		try {
//
//			if (result.getStatus() == ITestResult.SUCCESS) {
//
//				String screenShotPath = Logger.takeScreenshot(QaBrowser.driver, "D:\\Automation\\projectb2c1\\Screenshot\\Test Case Pass.png");
//				QaExtentReport.test1.log(Status.PASS, "<b><i>Successful Booking</i></b>");
//			}
//		} catch (IOException e) {
//
//			e.printStackTrace();
//		}
//		
//		try {
//
//			if (result.getStatus() == ITestResult.SUCCESS) {
//
//				String screenShotPath = Logger.takeScreenshot(QaBrowser.driver, "D:\\Automation\\projectb2c1\\Screenshot\\Test Case Pass.png");
//				QaExtentReport.test2.log(Status.PASS, "<b><i>Successful Booking</i></b>");
//			}
//		} catch (IOException e) {
//
//			e.printStackTrace();
//		}

	}

	public void onTestFailure(ITestResult result) {
		try {
			if (result.getStatus() == ITestResult.FAILURE) {
				result.getThrowable().printStackTrace();
				//System.out.println(result.getThrowable());
				QaExtentReport.test.log(Status.FAIL, result.getThrowable());
				Flightcheck.ScreenshotMethod("Test Case Pass");
//				String fail = Logger.takeScreenshot(QaBrowser.driver, "D:\\Automation\\projectb2c1\\Screenshot\\Test Case fail.png");
				QaExtentReport.test.log(Status.FAIL, "<b><i>Fail Booking</i></b>");		
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		try {
//			if (result.getStatus() == ITestResult.FAILURE) {
//				result.getThrowable().printStackTrace();
//				//System.out.println(result.getThrowable());
//				QaExtentReport.test1.log(Status.FAIL, result.getThrowable());
//				String fail = Logger.takeScreenshot(QaBrowser.driver, "D:\\Automation\\projectb2c1\\Screenshot\\Test Case fail.png");
//				QaExtentReport.test1.log(Status.FAIL, "<b><i>Fail Booking</i></b>");		
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		try {
//			if (result.getStatus() == ITestResult.FAILURE) {
//				result.getThrowable().printStackTrace();
//				//System.out.println(result.getThrowable());
//				QaExtentReport.test2.log(Status.FAIL, result.getThrowable());
//				String fail = Logger.takeScreenshot(QaBrowser.driver, "D:\\Automation\\projectb2c1\\Screenshot\\Test Case fail.png");
//				QaExtentReport.test2.log(Status.FAIL, "<b><i>Fail Booking</i></b>");		
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}

	public void onTestSkipped(ITestResult result) {
		try {
			if (result.getStatus() == ITestResult.SKIP) {
				Flightcheck.ScreenshotMethod("Test Case Pass");
//				String skip = Logger.takeScreenshot(QaBrowser.driver, "D:\\Automation\\projectb2c1\\Screenshot\\Test Case Skip.png");
				QaExtentReport.test.log(Status.SKIP, result.getThrowable());
				System.out.println("********* Skipped *********");
			}
		} catch (Exception e) {
			e.printStackTrace();;
		}
		
//		try {
//			if (result.getStatus() == ITestResult.SKIP) {
//				String skip = Logger.takeScreenshot(QaBrowser.driver, "D:\\Automation\\projectb2c1\\Screenshot\\Test Case Skip.png");
//				QaExtentReport.test1.log(Status.SKIP, result.getThrowable());
//				System.out.println("********* Skipped *********");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();;
//		}
//		
//		try {
//			if (result.getStatus() == ITestResult.SKIP) {
//				String skip = Logger.takeScreenshot(QaBrowser.driver, "D:\\Automation\\projectb2c1\\Screenshot\\Test Case Skip.png");
//				QaExtentReport.test2.log(Status.SKIP, result.getThrowable());
//				System.out.println("********* Skipped *********");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();;
//		}
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onStart(ITestContext context) {
		try {
			init();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void onFinish(ITestContext context) {

		// driver.quit();
	}

}