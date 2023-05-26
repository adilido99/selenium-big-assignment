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


class SubscriptionPage extends PageBase {

    /* page header locator */
    protected By headerMessageLocator = By.xpath( " //ul[contains(@class,'header links')]//li[1]//span " );

    /* subscription header locator */
    protected By subscribeHeaderLocator = By.xpath(" //div[contains(@class,'page messages')]//div[2]//div//div//div ");


    
    public SubscriptionPage(WebDriver driver ) {
        super(driver);
    }    
    



}
