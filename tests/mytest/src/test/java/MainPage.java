import org.junit.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;


class MainPage extends PageBase {

    /* page header locator */
    protected By headerMessageLocator = By.xpath( " //ul[contains(@class,'header links')]//li[1]//span " );

    /* subscription header locator */
    protected By subscribeHeaderLocator = By.xpath(" //div[contains(@class,'page messages')]//div[2]//div//div//div ");

    /* sign up and sign in button locator */
    private By signupLocator = By.xpath("//div[contains(@class,'panel header')]//ul//li[3]//a");
    private By signinLocator = By.xpath("//div[contains(@class,'panel header')]//ul//li[2]//a");

    /* search bar locator */
    private By searchBarLocator = By.xpath(" //div[contains(@class,'field search')]//div[1]//input ");

    /* logout locators */
    private By logoutMenuLocator = By.xpath(" //ul[contains(@class,'header links')]//li[2]//span//button " );
    private By logoutButtonLocator = By.xpath(" //ul[contains(@class,'header links')]//li[2]//div//ul//li[3]//a " ); 

    /* hover element locators */
    private By mainMenuLocator = By.xpath(" //nav[contains(@class,'navigation')]//ul//li[contains(@class,'nav-6')]//a " );
    private By subMenuLocator = By.xpath(" //nav[contains(@class,'navigation')]//ul//li[contains(@class,'nav-4')]//ul//li[contains(@class,'nav-4-3')]//a " ); 

    /* subscription locators */
    private By inputSubscribeLocator = By.xpath(" //form[contains(@class,'form subscribe')]//div[1]//div//label//input " );
    private By subscribeButtonLocator = By.xpath("  //form[contains(@class,'form subscribe')]//div[2]//button " );

    
    public MainPage(WebDriver driver ) {
        super(driver);
        this.driver.get("https://magento.softwaretestingboard.com/");
    }    
    
    public RegistrationPage openRegistrationPage()
    {
        this.waitAndReturnElement(signupLocator).click();
        return new RegistrationPage(this.driver);

    }

    public LoginPage openLoginPage()
    {
        this.waitAndReturnElement(signinLocator).click();
        return new LoginPage(this.driver);

    }

    public MainPage logout()
    {   
        this.waitAndReturnElement(logoutMenuLocator).click();
        this.waitAndReturnElement(logoutButtonLocator).click();
        return new MainPage(this.driver);
    }
    
    public SearchResultPage search(String searchQuery) 
    {
        this.waitAndReturnElement(searchBarLocator).sendKeys(searchQuery + "\n");
         return new SearchResultPage(this.driver);
    }

    public SalePage mouseHover()
    {
        WebElement mainMenu = this.waitAndReturnElement(mainMenuLocator);
        Actions actions = new Actions(this.driver);

        actions.moveToElement(mainMenu).perform();
        actions.click(mainMenu).perform();

        return new SalePage(this.driver);
    }

    public SubscriptionPage subscribe(String email)
    {
        this.waitAndReturnElement(inputSubscribeLocator).sendKeys(email);
        this.waitAndReturnElement(subscribeButtonLocator).click();

        return new SubscriptionPage(this.driver);
    }

    public String getHeaderMessageLogin()
    {
        WebElement bodyElement = this.waitAndReturnElement2(headerMessageLocator);
        return bodyElement.getText();
    }

}
