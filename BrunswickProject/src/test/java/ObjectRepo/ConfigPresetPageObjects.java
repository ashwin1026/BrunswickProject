package ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConfigPresetPageObjects {
    private WebDriver driver;

    public ConfigPresetPageObjects(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getHeadingLabel() {
        return driver.findElement(By.xpath("//h2[text()='Choose a preset']"));
    }

    public WebElement getMostPopularPresetLink() {
        return driver.findElement(By.xpath("//h3[text()='Most popular']"));
    }
}