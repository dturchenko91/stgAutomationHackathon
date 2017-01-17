/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package Framework;

import Framework.Pages.SkiUtahHomePage;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
/**
 *
 * @author Dan
 */
public final class Driver {
    
    private static WebDriver driver;
    
    public static SkiUtahHomePage homePage;
           
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
    }
    
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
