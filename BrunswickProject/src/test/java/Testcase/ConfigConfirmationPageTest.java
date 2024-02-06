package Testcase;

import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import ObjectRepo.ConfigConfirmationPageObjects;
import helper.CommonUtils;

public class ConfigConfirmationPageTest {

	@Test
	public void configConfirmation() {
		CommonUtils.test = CommonUtils.extent.createTest("Configuration Confirmation");
		ConfigConfirmationPageObjects pageObjects = new ConfigConfirmationPageObjects(CommonUtils.driver);

		WebElement heading = pageObjects.getPageHead();
		CommonUtils.test.info("Page Heading: " + heading);
		CommonUtils.test.log(Status.INFO, "Configuration Confirm page verified");
	}

	@AfterMethod
	public void afterMethod(ITestResult iTestResult) {
		if (iTestResult.getStatus() == ITestResult.FAILURE) {
			CommonUtils.test.addScreenCaptureFromPath(CommonUtils.takeScreenshot(CommonUtils.driver));
			CommonUtils.test.log(Status.FAIL, iTestResult.getThrowable());
		} else if (iTestResult.getStatus() == ITestResult.SKIP) {
			CommonUtils.test.log(Status.SKIP, "Test Skipped " + iTestResult.getThrowable());
		} else {
			CommonUtils.test.log(Status.PASS, "Test Passed");
		}
	}
}
