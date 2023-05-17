import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import java.net.MalformedURLException;

import org.openqa.selenium.support.ui.*;

import org.junit.*;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;

public class SeleniumTest {
	
	private WebDriver driver;
	
	// private By bodyLocator = By.tagName("body");
	// private By usernameFieldLocator = By.name("username");
	// private By passwordFieldLocator = By.name("password");

	// private By loginButtonLocator = By.className("radius");
    // private By logoutButtonLocator = By.className("secondary");

    // private By alertMessageLocator = By.id("flash");
	
	
    @Before
    public void setup() throws MalformedURLException
    {
		ChromeOptions options = new ChromeOptions();

        /* Disables the Web Notification and the Push APIs. */
        options.addArguments("--disable-notifications");

		this.driver = new RemoteWebDriver(new URL("http://selenium:4444/wd/hub"), options);
		this.driver.manage().window().maximize();
    }


    // @Test
    // public void testLoadMainPageAndRegistration()
    // {
    //     /* load the main page */
    //     MainPage mainPage = new MainPage(this.driver);
        
        
    //     /* navigate to registration page and check that we are at the right page */
    //     RegistrationPage registrationPageResult = mainPage.openRegistrationPage();
        
    //     /* Check if we are at the right page */
    //     Assert.assertTrue(registrationPageResult.getHeaderMessage(registrationPageResult.headerMessageLocator).contains("Create New Customer Account"));
    

    //     /* user registration and navigate to profile page */

    //     ProfilePage profilePageResult = registrationPageResult.register("adil" , "benamor","adil2153@gmail.com" , "Adilido230799" );

    //     /* check if we are at the profile page after registration */
    //     Assert.assertTrue(profilePageResult.getHeaderMessage(profilePageResult.headerMessageLocator).contains("My Account"));

    // }

    // @Test
    // public void testLoadMainPageAndLogin()
    // {
    //     /* load the main page */
    //     MainPage mainPage = new MainPage(this.driver);
        
        
    //     /* navigate to login page and check that we are at the right page */
    //     LoginPage loginPageResult = mainPage.openLoginPage();
        

    //     /* Check if we are at the right page */
    //     Assert.assertTrue(loginPageResult.getHeaderMessage(loginPageResult.headerMessageLocator).contains("Customer Login"));
    

    //     /* user login and navigate to profile page */
    //     MainPage mainPageResult = loginPageResult.login( "adil2153@gmail.com" , "Adilido230799" );


    //     /* check if we are at the page after login */
    //     Assert.assertTrue(mainPageResult.getHeaderMessage(mainPageResult.headerMessageLocator).contains("Welcome, adil benamor!"));

    //     /* logout from main page */
    //     MainPage newMainPageResult = mainPageResult.logout();
    //     //System.out.println(newMainPageResult.getHeaderMessage(newMainPageResult.headerMessageLocator));
    //     Assert.assertTrue(mainPageResult.getHeaderMessage(mainPageResult.headerMessageLocator).contains("Default welcome msg!"));


    //     // SearchResultPage searchResultPage =  mainPageResult.search("bag");
    //     // System.out.println(searchResultPage.getBodyText());


    // }


    // @Test
    // public void testMultipleLoadPages()
    // {
    //      String[] pageUrls={
    //         "https://magento.softwaretestingboard.com/",
    //         "https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/",
    //         "https://magento.softwaretestingboard.com/customer/account/create/"}; 

    //     for(String url : pageUrls) 
    //     {  
    //         StaticPage res = new StaticPage(this.driver , url);
    //         Assert.assertEquals(url , res.getTestUrl());
    //     }  
    // }

    // @Test
    // public void testSearchWithRandomData()
    // {
    //     /* generate random data */
    //         String[] randomData = new String[5];
    //         Faker faker = new Faker();
    //         for(int i=0;i<5;i++)
    //         {
    //             randomData[i] = faker.commerce().productName().split(" ")[2];
    //             System.out.println(randomData[i]);
    //         }

    //     /* load main page */
    //     MainPage mainPage = new MainPage(this.driver);

    //     for(String data : randomData) 
    //     {  
    //         /* fill the search bar with our generated data */
    //          mainPage.search(data);

    //          /* navigate back to main page */
    //          this.driver.navigate().back();
    //     }  
    // }

    @Test
    public void hoverTest()
    {
        /* load main page */
        MainPage mainPage = new MainPage(this.driver);

        SalePage resultPage = mainPage.mouseHover();
        /* checking that we are at the right page by checking the page title */
        Assert.assertEquals(resultPage.getPageTitle() , "Sale");

    }

    @After
    public void close() {
        if (this.driver != null) {
            this.driver.quit();
        }
    }
}
