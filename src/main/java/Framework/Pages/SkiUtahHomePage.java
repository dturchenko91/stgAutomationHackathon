/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Framework.Pages;

import Framework.Driver;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
/**
 *
 * @author Dan
 */


public class SkiUtahHomePage {
    
    //get webdriver from Driver class
    private static WebDriver driver = Driver.getDriver();
    
    private static List<HomePageMenuItem> menu = getMenu();
    
    private static HomePageMenuItem selectedMenuItem;
    
    public String getPageTitle()
    {
        return driver.getTitle();
    }
    
    //create list of menu objects from list of webElements
    private static List<HomePageMenuItem> getMenu()
    {
        List<WebElement> menuElements = driver.findElements(By.cssSelector("a.SuperfishMegaMenu-topLink"));
        
        List<HomePageMenuItem> menu = new ArrayList<HomePageMenuItem>();
        
        for (int i = 0; i < menuElements.size(); i ++)
        {
            menu.add(new HomePageMenuItem(menuElements.get(i)));
        }
               
        return menu;
    }
    
    //Sets selectedMenuItem to specified menu item for easier access
    public static void setSelectedMenuItem(String menuItemText)
    {
        for (int i = 0; i < menu.size(); i ++)
        {
            if (menu.get(i).returnText().equals(menuItemText))
            {
                selectedMenuItem = menu.get(i);
                return;
            }            
        }
        System.out.println("No menu items found matching " + menuItemText);
    }   
    
    //navigates to selected menu item and allows a half second wait for the page to load
    public static void navigateToSelectedMenuItem()
    {
        selectedMenuItem.ClickElement();
        
        Driver.implicitWait(500);
    }
    
}
