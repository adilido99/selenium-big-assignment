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


class SalePage extends PageBase {

    /* page header locator */
    protected By headerMessageLocator = By.xpath(" //div[contains(@class,'page-title-wrapper')]//h1//span ");

    
    public SalePage(WebDriver driver) {
        super(driver);
    } 
 
    
}
