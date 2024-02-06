package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObjects {
    
    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement acceptCookiesButton;
    
	@FindBy(xpath = "//a[contains(text(),'Continue to website')]")
    private WebElement continueButton;
    
    @FindBy(xpath = "//a[text()='Home']")
    private WebElement homeLink;
    
    @FindBy(xpath = "//a[contains(text(),'Our Models')]")
    private WebElement modelsLink;
    
    @FindBy(xpath = "//a[text()='Dealer network']")
    private WebElement dealerNetworkLink;
    
    @FindBy(xpath = "//a[text()='About']")
    private WebElement aboutLink;
    
    @FindBy(xpath = "//a[text()='Service']")
    private WebElement serviceLink;
    
    @FindBy(xpath = "//a[text()='Brochure']")
    private WebElement brochureLink;
    
    public HomePageObjects(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    
    public WebElement getAcceptCookiesButton() {
        return acceptCookiesButton;
    }
    
    public WebElement getContinueButton() {
        return continueButton;
    }
    
    public WebElement getHomeLink() {
        return homeLink;
    }
    
    public WebElement getModelsLink() {
        return modelsLink;
    }
    
    public WebElement getDealerNetworkLink() {
        return dealerNetworkLink;
    }
    
    public WebElement getAboutLink() {
        return aboutLink;
    }
    
    public WebElement getServiceLink() {
        return serviceLink;
    }
    
    public WebElement getBrochureLink() {
        return brochureLink;
    }
}