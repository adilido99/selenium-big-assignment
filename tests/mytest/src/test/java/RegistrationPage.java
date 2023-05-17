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


class RegistrationPage extends PageBase {

    /* page header locator */
    protected By headerMessageLocator = By.xpath(" //div[contains(@class,'page-title-wrapper')]//h1//span ");

    /* Registration field locators  */
    private By firstNameLocator = By.xpath(" //form[contains(@id,'form-validate')]//fieldset[1]//div[1]//div//input ");
    private By lastNameLocator = By.xpath(" //form[contains(@id,'form-validate')]//fieldset[1]//div[2]//div//input ");
    private By emailLocator = By.xpath(" //form[contains(@id,'form-validate')]//fieldset[2]//div[1]//div//input ");
    private By passwordLocator = By.xpath(" //form[contains(@id,'form-validate')]//fieldset[2]//div[2]//div//input ");
    private By passwordConfirmationLocator = By.xpath(" //form[contains(@id,'form-validate')]//fieldset[2]//div[3]//div//input ");
    private By checkbox1 = By.xpath(" //form[contains(@id,'form-validate')]//fieldset[1]//div[3]//input ");
    
    /* submit button locator */
    private By submitButtonLocator = By.xpath(" //form[contains(@id,'form-validate')]//div[contains(@class,'actions-toolbar')]//div[1]//button ");
    

    public RegistrationPage(WebDriver driver) {
        super(driver);
        
    }
    
    public ProfilePage register(String firstname, String lastname, String email , String password)
    {
             /* filling the form*/
            this.waitAndReturnElement(firstNameLocator).sendKeys(firstname);    
            this.waitAndReturnElement(lastNameLocator).sendKeys(lastname);
            this.waitAndReturnElement(checkbox1).click();

            this.waitAndReturnElement(emailLocator).sendKeys(email);
            this.waitAndReturnElement(passwordLocator).sendKeys(password);
            this.waitAndReturnElement(passwordConfirmationLocator).sendKeys(password);

            /* submit the form */
            this.waitAndReturnElement(submitButtonLocator).click();

             /* navigate to Profile page */
             return new ProfilePage(this.driver);
    }
}
