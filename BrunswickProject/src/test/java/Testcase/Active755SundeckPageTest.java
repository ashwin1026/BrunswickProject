package Testcase;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import ObjectRepo.Activ755SundeckConfigPageObjects;
import ObjectRepo.Activ755SundeckPageObjects;
import ObjectRepo.ConfigPresetPageObjects;
import helper.CommonUtils;

import org.testng.annotations.AfterMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.ITestResult;

public class Active755SundeckPageTest {

	@Test
    public void navigateToConfiguration() throws InterruptedException {
        CommonUtils.test = CommonUtils.extent.createTest("Navigate to Activ 755 Sundeck Configuration");
        Activ755SundeckPageObjects pageObject = new Activ755SundeckPageObjects(CommonUtils.driver);
        ConfigPresetPageObjects configPagePresetObject = new ConfigPresetPageObjects(CommonUtils.driver);
        
        pageObject.getConfigureLink().click();
        CommonUtils.wait.until(ExpectedConditions.visibilityOf(configPagePresetObject.getHeadingLabel()));
        CommonUtils.test.log(Status.INFO, "Navigated to Activ 755 Sundeck Config Preset Page");
        
        WebElement mostPopularPresetLink = configPagePresetObject.getMostPopularPresetLink();
        mostPopularPresetLink.click();
        
        Activ755SundeckConfigPageObjects configPageObject = new Activ755SundeckConfigPageObjects(CommonUtils.driver);
        
        // Get 'Engine' link and wait for the element to be visible
        WebElement engineLink = configPageObject.getEngineLink();
        CommonUtils.wait.until(ExpectedConditions.visibilityOf(engineLink));
        
        // Log info message to report
        CommonUtils.test.log(Status.INFO, "Navigated to Activ 755 Sundeck Configuration Page");
        Thread.sleep(5000);
       
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
