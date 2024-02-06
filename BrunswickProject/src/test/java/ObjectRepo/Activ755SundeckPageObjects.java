package ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Activ755SundeckPageObjects {
    private WebDriver driver;

    public Activ755SundeckPageObjects(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getExploreModelLink() {
        return driver.findElement(By.xpath("//h2[text()='Activ 755 Sundeck']/following-sibling::div/a[text()='Explore model']"));
    }
    
    public WebElement getHeadingLabel() {
        return driver.findElement(By.xpath("//h1[contains(text(),'Activ 755 Sundeck')]"));
    }

    public WebElement getAboutLink() {
        return driver.findElement(By.xpath("//a[contains(text(),'About')]"));
    }

    public WebElement getGalleryLink() {
        return driver.findElement(By.xpath("//a[contains(text(),'Gallery')]"));
    }

    public WebElement getSpecificationsLink() {
        return driver.findElement(By.xpath("//a[contains(text(),'Specifications')]"));
    }

    public WebElement getFeaturesLink() {
        return driver.findElement(By.xpath("//a[contains(text(),'Features')]"));
    }

    public WebElement getFindDealerLink() {
        return driver.findElement(By.xpath("//a[contains(text(),'Find a dealer')]"));
    }

    public WebElement getConfigureLink() {
        return driver.findElement(By.xpath("//nav[@class='float-nav']//a[contains(text(),'Configure')]"));
    }
}