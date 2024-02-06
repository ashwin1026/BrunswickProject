package Testcase;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import ObjectRepo.Activ755SundeckPageObjects;
import ObjectRepo.ModelsPageObjects;
import helper.CommonUtils;

public class ModelsPageTest {

	@Test
	public void navigateToActiv755Sundeck() throws InterruptedException {
		CommonUtils.test = CommonUtils.extent.createTest("Navigate to Activ 755 Sundeck");
		FluentWait<WebDriver> fluentWait = CommonUtils.getFluentWait();

		ModelsPageObjects modelsPage = new ModelsPageObjects(CommonUtils.driver);
		// Click on Sundeck link
		modelsPage.getSundeckLink().click();
		CommonUtils.test.log(Status.INFO, "Clicked on Sundeck link");

		Thread.sleep(2000);

		// Click on Sundeck 755 link
		modelsPage.getSundeck755Link().click();
		CommonUtils.test.log(Status.INFO, "Clicked on Sundeck 755 link");

		fluentWait.until(ExpectedConditions.visibilityOf(modelsPage.getActiv755SundeckLabel()));
		CommonUtils.test.log(Status.INFO, "Navigated to Activ 755 Sundeck Explore Page");
	}

	@Test
	public void navigateToActiv755SundeckExploreModel() throws InterruptedException {
		// Create a new extent test
		CommonUtils.test = CommonUtils.extent.createTest("Navigate to Activ 755 Sundeck Explore Model");
		FluentWait<WebDriver> fluentWait = CommonUtils.getFluentWait();
		
		Activ755SundeckPageObjects activ755Page = new Activ755SundeckPageObjects(CommonUtils.driver);
		activ755Page.getExploreModelLink().click();

		// Get heading label element and wait for it to be visible
		fluentWait.until(ExpectedConditions.visibilityOf(activ755Page.getHeadingLabel()));
		
		// Log message to report
		CommonUtils.test.log(Status.INFO, "Navigated to Activ 755 Sundeck Explore Page");
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
