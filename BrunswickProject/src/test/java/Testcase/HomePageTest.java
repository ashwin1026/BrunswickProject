package Testcase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import ObjectRepo.HomePageObjects;
import ObjectRepo.ModelsPageObjects;
import helper.CommonUtils;

public class HomePageTest {
	
	private FluentWait<WebDriver> fluentWait;
	
	@SuppressWarnings("deprecation")
	@BeforeSuite
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		CommonUtils.setDriver(new ChromeDriver());
		CommonUtils.setWebDriverWait(CommonUtils.driver);
		CommonUtils.htmlReporter = new ExtentSparkReporter("ExtentReportResults.html");
		CommonUtils.extent = new ExtentReports();
		CommonUtils.extent.attachReporter(CommonUtils.htmlReporter);
		CommonUtils.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		CommonUtils.driver.get("https://www.quicksilver-boats.com/int/en");
		CommonUtils.driver.manage().window().maximize();
		
		fluentWait = CommonUtils.getFluentWait();
	}

	@Test
	public void navigateToHome() {
		CommonUtils.test = CommonUtils.extent.createTest("navigateToHome");
		
		HomePageObjects homePage = new HomePageObjects(CommonUtils.driver);
		homePage.getContinueButton().click();
		homePage.getAcceptCookiesButton().click();
		
		CommonUtils.test.log(Status.INFO, "Home page displayed");
		
	}
	
	@Test
    public void navigateToModels() {

		CommonUtils.test = CommonUtils.extent.createTest("navigateToModels");
        HomePageObjects homePage = new HomePageObjects(CommonUtils.driver);
        homePage.getModelsLink().click();
        ModelsPageObjects modelsPage = new ModelsPageObjects(CommonUtils.driver);
        fluentWait.until(ExpectedConditions.visibilityOf(modelsPage.getExploreModelLink()));
        CommonUtils.test.log(Status.INFO, "Models page displayed");
    }
	
	@AfterMethod
	public void afterMethod(ITestResult iTestResult) {
		if(iTestResult.getStatus()==ITestResult.FAILURE) {
			CommonUtils.test.addScreenCaptureFromPath(CommonUtils.takeScreenshot(CommonUtils.driver));
			CommonUtils.test.log(Status.FAIL, iTestResult.getThrowable());
		}else if(iTestResult.getStatus()==ITestResult.SKIP) {
			CommonUtils.test.log(Status.SKIP, "Test Skipped " + iTestResult.getThrowable());
		}else{
			CommonUtils.test.log(Status.PASS, "Test Passed");
		}
	}
	
	@AfterSuite
	    public void cleanup() {
	        CommonUtils.driver.quit();
	        CommonUtils.extent.flush();
	    }
}
