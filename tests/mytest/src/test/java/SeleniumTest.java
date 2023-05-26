import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import java.net.MalformedURLException;

import org.openqa.selenium.support.ui.*;

import org.junit.*;

import com.github.javafaker.Faker;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SeleniumTest {
	
	private WebDriver driver;
	
    @Before
    public void setup() throws MalformedURLException
    {
		ChromeOptions options = new ChromeOptions();

        /* Open the Web in incognito mode */
        options.addArguments("incognito");

		this.driver = new RemoteWebDriver(new URL("http://selenium:4444/wd/hub"), options);
		this.driver.manage().window().maximize();
    }


    @Test
    public void testA_LoadMainPageAndRegister()
    {
        /* load the main page */
        MainPage mainPage = new MainPage(this.driver);
        
        
        /* navigate to registration page and check that we are at the right page */
        RegistrationPage registrationPageResult = mainPage.openRegistrationPage();
        
        /* Check if we are at the right page */
        Assert.assertTrue(registrationPageResult.getHeaderMessage(registrationPageResult.headerMessageLocator).contains("Create New Customer Account"));
    

        /* user registration and navigate to profile page */
        ProfilePage profilePageResult = registrationPageResult.register("mourad" , "maarouf","mourad.mrf123@gmail.com" , "Testing123456" );

        /* check if we are at the profile page after registration */
        Assert.assertTrue(profilePageResult.getHeaderMessage(profilePageResult.headerMessageLocator).contains("My Account"));

    }

    @Test
    public void testB_LoadMainPageAndLogin()
    {
        /* load the main page */
        MainPage mainPage = new MainPage(this.driver);
        
        
        /* navigate to login page and check that we are at the right page */
        LoginPage loginPageResult = mainPage.openLoginPage();
        

        /* Check if we are at the right page */
        Assert.assertTrue(loginPageResult.getHeaderMessage(loginPageResult.headerMessageLocator).contains("Customer Login"));
    

        /* user login and navigate to profile page */
        MainPage mainPageResult = loginPageResult.login( "mourad.mrf123@gmail.com" , "Testing123456" );


        /* check if we are at the page after login */
        Assert.assertTrue(mainPageResult.getBodyText().contains("Welcome, mourad maarouf!"));

        /* logout and redirect to main page */
        MainPage newMainPageResult = mainPageResult.logout();
        Assert.assertTrue(mainPageResult.getHeaderMessage(mainPageResult.headerMessageLocator).contains("Default welcome msg!"));

    }


    @Test
    public void testC_LoadMultiplePages()
    {
         String[] pageUrls={
            "https://magento.softwaretestingboard.com/",
            "https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/",
            "https://magento.softwaretestingboard.com/customer/account/create/"}; 

        for(String url : pageUrls) 
        {  
            StaticPage res = new StaticPage(this.driver , url);
            Assert.assertEquals(url , res.getTestUrl());
        }  
    }

    @Test
    public void testD_SearchWithRandomData()
    {
        /* generate random data */
            String[] randomData = new String[5];
            Faker faker = new Faker();

            /** create our random data array */
            for(int i=0;i<5;i++)
            {
                randomData[i] = faker.commerce().productName().split(" ")[2];
                //System.out.println(randomData[i]);
            }

        /* load main page */
        MainPage mainPage = new MainPage(this.driver);
        SearchResultPage searchResultPage = null;

        for(String data : randomData) 
        {  
            /* fill the search bar with our generated data */
             searchResultPage =  mainPage.search(data);

             /* add assert for checking the page */
            Assert.assertTrue( searchResultPage.getHeaderMessage(searchResultPage.headerMessageLocator).contains( "Search results for: '"+ data +"'"));

             /* navigate back to main page */
             this.driver.navigate().back() ;
             Assert.assertEquals("https://magento.softwaretestingboard.com/" , this.driver.getCurrentUrl() );
        }  
    }

    @Test
    public void testE_LoginAndSubscribe()
    {
        /* load main page */
         MainPage mainPage = new MainPage(this.driver);

        /* navigate to login page and check that we are at the right page */
         LoginPage loginPageResult = mainPage.openLoginPage();
        

         /* Check if we are at the right page */
         Assert.assertTrue(loginPageResult.getHeaderMessage(loginPageResult.headerMessageLocator).contains("Customer Login"));
    

         /* user login and navigate to profile page */
         MainPage mainPageResult = loginPageResult.login( "mourad.mrf123@gmail.com" , "Testing123456" );

         /* sign for the newsletter  */
         SubscriptionPage res = mainPage.subscribe("mour213@gmail.com");
         Assert.assertTrue(res.getHeaderMessage(res.subscribeHeaderLocator).contains("Thank you for your subscription."));
    }

    @Test
    public void testF_Hover()
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
