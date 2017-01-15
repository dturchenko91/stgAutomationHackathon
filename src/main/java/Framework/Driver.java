/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package Framework;

import Framework.Pages.SkiUtahHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
/**
 *
 * @author Dan
 */
public final class Driver {
    
    private static WebDriver driver;
    
    public static SkiUtahHomePage homePage;
           
    
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
        
        homePage = new SkiUtahHomePage();
    }
    
    public static void tearDown()
    {
        driver.quit();
    }
    
}
