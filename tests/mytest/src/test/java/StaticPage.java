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


class StaticPage extends PageBase {

    /* page header locator */
    protected By headerMessageLocator = By.xpath( " //ul[contains(@class,'header links')]//li[1]//span " );

    
    public StaticPage(WebDriver driver, String url ) 
    {
        super(driver);
        this.driver.get(url);
    }    

    public String getTestUrl(){         
        return this.driver.getCurrentUrl();
    }
}
