package ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Activ755SundeckConfigPageObjects {
    private WebDriver driver;
    
    public Activ755SundeckConfigPageObjects(WebDriver driver) {
        this.driver = driver;
    }
    
    public WebElement getAllModelsLink() {
        return driver.findElement(By.xpath("//span[text()='All models']"));   
    }
    
    public WebElement getResetConfigurationLink() {
        return driver.findElement(By.xpath("//span[text()='Reset configuration']"));   
    }
    
    public WebElement getEngineLink() {
        return driver.findElement(By.xpath("//h1[text()='Activ 755 Sundeck']/../../../../following-sibling::div[3]//div[text()='Engine']"));   
    }
    
    public WebElement getPacksLink() {
        return driver.findElement(By.xpath("//div[text()='Packs']"));   
    }
    
    public WebElement getOptionsLink() {
        return driver.findElement(By.xpath("//div[text()='Options']"));   
    }
    
    public WebElement getViewConfigurationLink() {
        return driver.findElement(By.xpath("//h1[text()='Activ 755 Sundeck']/../../../../following-sibling::div[3]//span[text()='View configuration']"));   
    }
    
    public WebElement getMercury175V6EngineOption() {
        return driver.findElement(By.xpath("//div[@data-testid='engine-radio-card'][1]//input"));   
    }
    
    public WebElement getCloseIcon() {
        return driver.findElement(By.xpath("//h2[text()='Engine']/following-sibling::button"));   
    }
    
    public WebElement getEngineNameLabel() {
        return driver.findElement(By.xpath("//h5[text()='Engine']/../following-sibling::div//span[1]"));   
    }
    
    public WebElement getReceiveConfigurationButton() {
        return driver.findElement(By.xpath("//button[text()='Receive configuration']"));   
    }
    
    public WebElement getSalutationDropdown() {
        return driver.findElement(By.xpath("//select[@name='title']"));   
    }
    
    public WebElement getFirstNameInput() {
        return driver.findElement(By.xpath("//input[@name='firstName']"));   
    }
    
    public WebElement getLastNameInput() {
        return driver.findElement(By.xpath("//input[@name='lastName']"));   
    }
    
    public WebElement getEmailInput() {
        return driver.findElement(By.xpath("//input[@name='email']"));   
    }
    
    public WebElement getCountryDropdown() {
        return driver.findElement(By.xpath("//select[@name='country']"));   
    }
    
    public WebElement getCityInput() {
        return driver.findElement(By.xpath("//input[@name='city']"));   
    }
    
    public WebElement getPhoneInput() {
        return driver.findElement(By.xpath("//input[@name='phone']"));   
    }
    
    public WebElement getPromotionInfoCheckBox() {
        return driver.findElement(By.xpath("//input[@name='optInMarketing']"));   
    }
    
    public WebElement getTermsCheckBox() {
        return driver.findElement(By.xpath("//input[@name='agreeTermsConditions']"));   
    }
    
    public WebElement getSendConfigurationButton() {
        return driver.findElement(By.xpath("//button[text()='Send configuration']"));   
    }
}