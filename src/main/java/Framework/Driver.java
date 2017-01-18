/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package Framework;

import Framework.Pages.SkiUtahHomePage;
import Framework.Pages.ResortComparisonPage;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.NoSuchElementException;
/**
 *
 * @author Dan
 */
public final class Driver {
    
    private static WebDriver driver;
    
    public static SkiUtahHomePage homePage;
    
    public static ResortComparisonPage resortComparisonPage;
           
    //initializes new chromedriver
    public static void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
    }
    
    //method to pass webdriver variable to page objects
    public static WebDriver getDriver()
    {
        return driver;
    }
    
    //navigate to main page and initialize homepage page object
    public static void navigateToHomePage()
    {
        
        driver.get("http://www.skiutah.com");
        
        driver.manage().window().maximize();
        
        homePage = new SkiUtahHomePage();
    }
    
    public static Boolean currentPageIsHomePage()
    {
        if (getCurrentPageTitle().equals("Ski Utah - Ski Utah"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public static void navigateToResortComparisonPage()
    {
        if (!currentPageIsHomePage())
        {
            navigateToHomePage();
        }
        
        String selectedMenuItem = "RESORTS & SNOW ";
        String selectedSubMenuItem = "Resort Comparison";
        homePage.setSelectedMenuItem(selectedMenuItem);
        homePage.setSelectedSubMenuItem(selectedSubMenuItem);
        
        homePage.navigateToSelectedSubMenuItem();
        
        resortComparisonPage = new ResortComparisonPage();
    }
    
    public static void tearDown()
    {
        driver.quit();
    }
    
    //accessible from any page, simply returns current page title
    public static String getCurrentPageTitle()
    {
        return driver.getTitle();
    }
    
    //try-catch-wrapped wait method
    public static void implicitWait(long length)
    {
        
        try {
            Thread.sleep(length);
        } catch (InterruptedException ex) {
            Logger.getLogger(Driver.class.getName()).log(Level.SEVERE, null, ex);
        }

        /*
        WebDriverWait wait = new WebDriverWait(driver, length);
        try {
            wait.wait();
        } catch (InterruptedException ex) {
            Logger.getLogger(Driver.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
    }
    
    public static void explicitWaitUntilNotVisible(String cssSelector)
    {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(cssSelector)));
    }
    
    /*
    public static Boolean elementIsVisible(WebElement element)
    {
        try
        {
            return (element.isDisplayed());
        }
        catch (NoSuchElementException e)
        {
            return false;
        }        
    }
*/
    
    //code to allow a more advanced click, accessible from any page object method
    //temporarily using a double click instead of a hover as advertised as hover seems to be broken
    public static void hoverThenClick(WebElement element)
    {
        Actions action = new Actions(driver);
        
        action.click(element).click(element).build().perform();
    }
    
    //temporary to allow passing of NavigateToResortComparisonPage. No other way to open the context menu besides clicking as hover seems to be broken
    public static void hoverThenClickSubElement(WebElement element, WebElement element2)
    {
        //implicitWait(500);
        
        Actions action = new Actions(driver);
        
        action.click(element).moveToElement(element2).click(element2).build().perform();
    }
    
}
