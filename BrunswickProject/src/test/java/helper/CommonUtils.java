package helper;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class CommonUtils {

	public static WebDriver driver = null;
	public static WebDriverWait wait;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static ExtentSparkReporter htmlReporter;
	
	public static FluentWait<WebDriver> getFluentWait() {
		 FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				 .withTimeout(Duration.ofSeconds(30))
				 .pollingEvery(Duration.ofSeconds(3))
				 .ignoring(NoSuchElementException.class);
		return fluentWait;
	
	}
	
	public static WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(WebDriver driver) {
		CommonUtils.driver = driver;
	}
	public static void setWebDriverWait(WebDriver driver) {
		wait = new WebDriverWait(CommonUtils.driver, Duration.ofSeconds(30));
		
	}
	public static String takeScreenshot(WebDriver driver) {
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
        	FileUtils.copyFile(screenshot, new File("screenshot.png"));
            //test.addScreenCaptureFromPath("screenshot.png");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        	 
		return "screenshot.png";
	}
}