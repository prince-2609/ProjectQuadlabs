package TestScript.RoundTrip;

import java.io.IOException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import Base.TestBase;
import utilities.QaExcelRead;
import utilities.Logger;

public class Flightcheck extends TestBase implements ITestListener {

	
	QaExcelRead reader;
	

	public void onTestStart(ITestResult result) {

	}

	public void onTestSuccess(ITestResult result) {

		try {

			if (result.getStatus() == ITestResult.SUCCESS) {

				String screenShotPath = Logger.takeScreenshot(driver, "Pass");
				test.log(Status.INFO, "Successful Booking Snapshot Below :",
						MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
				System.out.println("********* Passed *********");

			}
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public void onTestFailure(ITestResult result) {

		try {

			if (result.getStatus() == ITestResult.FAILURE) {
				
				Logger.fail(driver);
				//QaLogger.testLog(result);
				test.log(Status.FAIL, result.getThrowable());
			}

		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void onTestSkipped(ITestResult result) {

		try {

			if (result.getStatus() == ITestResult.SKIP) {

				String screenShotPath = Logger.takeScreenshot(driver, "SKIP");
				test.log(Status.SKIP, result.getThrowable());
				test.log(Status.INFO, "Skipped Booking Snapshot Below :",
						MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
				System.out.println("********* Skipped *********");
			}

		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}
	
	public void onStart(ITestContext context) {
		
		try
		{
			
			init();
				
		}
		
		catch (IOException e)
		{
			
			e.printStackTrace();
		}
	}

	public void onFinish(ITestContext context) {

		// driver.quit();
	}

}
