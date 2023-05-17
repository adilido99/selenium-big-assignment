import org.junit.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;


class LoginPage extends PageBase {

    
    /* page header locator */
    protected By headerMessageLocator = By.xpath(" //div[contains(@class,'page-title-wrapper')]//h1//span  ");

    /* login field locators  */
    private By emailLocator = By.xpath(" //form[contains(@id,'login-form')]//fieldset[1]//div[2]//div//input ");
    private By passwordLocator = By.xpath(" //form[contains(@id,'login-form')]//fieldset[1]//div[3]//div//input ");
    
    /* submit locator */
    private By submitButtonLocator = By.xpath(" //form[contains(@id,'login-form')]//fieldset[1]//div[4]//div[1]//button ");
    

    public LoginPage(WebDriver driver) {
        super(driver);
        
    }

    
     public MainPage login(String email, String password )
     {
                
        this.waitAndReturnElement(emailLocator).sendKeys(email);

        this.waitAndReturnElement(passwordLocator).sendKeys(password);

        this.waitAndReturnElement(submitButtonLocator).click();
        
        return new MainPage(this.driver);

    }
}
