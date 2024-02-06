package ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConfigConfirmationPageObjects {

    private WebDriver driver;

    public ConfigConfirmationPageObjects(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getPageHead() {
        return driver.findElement(By.xpath("//h1[text()='Your dream boat is ready to set sail']"));
    }

    public WebElement getPrintConfigurationLink() {
        return driver.findElement(By.xpath("//a[text()='Print configuration']"));
    }

    public WebElement getReturnToModelOverviewLink() {
        return driver.findElement(By.xpath("//a[text()='Return to model overview']"));
    }
}