package ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ModelsPageObjects {
    private WebDriver driver;

    public ModelsPageObjects(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getSundeckLink() {
        return driver.findElement(By.xpath("//img[@alt='Sundeck']"));
    }

    public WebElement getSundeck755Link() {
        return driver.findElement(By.xpath("//a[contains(text(), 'Activ 755 Sundeck')]"));
    }
    
    public WebElement getActiv755SundeckLabel() {
        return driver.findElement(By.xpath("//h2[contains(text(), 'Activ 755 Sundeck')]"));
    }
    
    public WebElement getExploreModelLink() {
        return driver.findElement(By.xpath("//a[text()='Explore model']"));
    }

    public WebElement getConfigureLink() {
        return driver.findElement(By.xpath("//a[text()='Configure']"));
    }
}