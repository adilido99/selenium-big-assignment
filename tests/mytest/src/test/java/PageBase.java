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


class PageBase {
    protected WebDriver driver;
    protected WebDriverWait wait;
    
    
    public PageBase(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
    }
    
    protected WebElement waitAndReturnElement(By locator) {
        
        /* explicit wait */
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return this.driver.findElement(locator);
    } 

    protected WebElement waitAndReturnElement2(By locator) {
        
        /* explicit wait */
        this.wait.until(ExpectedConditions.textToBePresentInElementValue(locator , "Welcome, mourad maarouf!"));
        return this.driver.findElement(locator);
    } 
    
    public String getBodyText() {
        WebElement bodyElement = this.waitAndReturnElement(By.tagName("body"));
        return bodyElement.getText();
    }

    public String getHeaderMessage(By locator)
    {
        WebElement bodyElement = this.waitAndReturnElement(locator);
        return bodyElement.getText();
    }

    public String getPageTitle()
    {
        return this.driver.getTitle();
    }  
}
