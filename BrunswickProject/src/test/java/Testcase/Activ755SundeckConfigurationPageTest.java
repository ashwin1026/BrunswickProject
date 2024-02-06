package Testcase;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import ObjectRepo.Activ755SundeckConfigPageObjects;
import helper.CommonUtils;
import helper.JSONFileReader;

public class Activ755SundeckConfigurationPageTest {

	@Test
    public void configureActiv755Sundeck() throws InterruptedException {
        CommonUtils.test = CommonUtils.extent.createTest("Configure Activ 755 Sundeck");

        Activ755SundeckConfigPageObjects configPageObject = new Activ755SundeckConfigPageObjects(CommonUtils.driver);
        JSONFileReader jsonReader = new JSONFileReader("C:\\Users\\ashwi\\eclipse-workspace\\BrunswickProject\\src\\test\\java\\TestData\\testData.json");
        System.out.println("JSON FILE : " + jsonReader );
        
        configPageObject.getEngineLink().click();
        Thread.sleep(2000);
        configPageObject.getMercury175V6EngineOption().click();
        
        CommonUtils.test.log(Status.INFO, "Clicked on 'Mercury 175 V6 Engine Option'");

        configPageObject.getCloseIcon().click();

        CommonUtils.test.log(Status.INFO, "Clicked on close icon");
        
        configPageObject.getViewConfigurationLink().click();
        CommonUtils.test.log(Status.INFO, "Clicked on view configuration link");

        
        String expectedText = "Mercury 175 V6";
        
        String actualText = configPageObject.getEngineNameLabel().getText();
        Assert.assertEquals(actualText, expectedText);
        CommonUtils.test.log(Status.INFO, "Verified engine name label text as 'Mercury 175 V6'");
        
        
        
        // Get receive configuration button and click
        WebElement receiveConfigButton = configPageObject.getReceiveConfigurationButton();
        receiveConfigButton.click();
        CommonUtils.test.log(Status.INFO, "Clicked Receive Configuration button");
        
        // Get salutation dropdown and select value
        CommonUtils.wait.until(ExpectedConditions.visibilityOf(configPageObject.getSalutationDropdown()));
        Select salutationSelect = new Select(configPageObject.getSalutationDropdown());
        salutationSelect.selectByVisibleText(jsonReader.getSalutation());
        CommonUtils.test.log(Status.INFO, "Selected salutation: " + jsonReader.getSalutation());
        
        // Get first name input and enter value
        WebElement firstNameInput = configPageObject.getFirstNameInput();
        firstNameInput.sendKeys(jsonReader.getFirstName());
        CommonUtils.test.log(Status.INFO, "Entered first name: " + jsonReader.getFirstName());
        
        // Get last name input and enter value
        WebElement lastNameInput = configPageObject.getLastNameInput();
        lastNameInput.sendKeys(jsonReader.getLastName());
        CommonUtils.test.log(Status.INFO, "Entered last name: " + jsonReader.getLastName());
        
        // Get email input and enter value
        WebElement emailInput = configPageObject.getEmailInput();
        emailInput.sendKeys(jsonReader.getEmail());
        CommonUtils.test.log(Status.INFO, "Entered email: " + jsonReader.getEmail());
        
        // Get country dropdown and select value
        WebElement countryDropdown = configPageObject.getCountryDropdown();
        Select countrySelect = new Select(countryDropdown);
        countrySelect.selectByVisibleText(jsonReader.getCountry());
        CommonUtils.test.log(Status.INFO, "Selected country: " + jsonReader.getCountry());
        
        // Get city input and enter value
        WebElement cityInput = configPageObject.getCityInput();
        cityInput.sendKeys(jsonReader.getCity());
        CommonUtils.test.log(Status.INFO, "Entered city: " + jsonReader.getCity());
        
        // Get phone input and enter value
        WebElement phoneInput = configPageObject.getPhoneInput();
        phoneInput.sendKeys(jsonReader.getPhone());
        CommonUtils.test.log(Status.INFO, "Entered phone: " + jsonReader.getPhone());
        
        phoneInput.sendKeys(Keys.TAB);
        // Get promotion info checkbox and click
        WebElement promotionInfoCheckbox = configPageObject.getPromotionInfoCheckBox();
        promotionInfoCheckbox.click();
        
        CommonUtils.test.log(Status.INFO, "Clicked Promotion Info checkbox");

        // Get terms checkbox and click
        WebElement termsCheckbox = configPageObject.getTermsCheckBox();
        termsCheckbox.click();
        CommonUtils.test.log(Status.INFO, "Clicked Terms checkbox");
        
        // Get send configuration button and click
        WebElement sendConfigButton = configPageObject.getSendConfigurationButton();
        sendConfigButton.click();
        CommonUtils.test.log(Status.INFO, "Clicked Send Configuration button");
        
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
