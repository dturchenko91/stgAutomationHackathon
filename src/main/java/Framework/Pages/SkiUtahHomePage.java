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
    private WebDriver driver = Driver.getDriver();
    
    private List<HomePageMenuItem> menu;
    
    private HomePageMenuItem selectedMenuItem;
    
    public String getPageTitle()
    {
        return driver.getTitle();
    }
    
    public SkiUtahHomePage()
    {
        menu = getMenu();
    }
    
    //create list of menu objects from list of webElements
    private List<HomePageMenuItem> getMenu()
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
    //Returns true if matching menu item is found
    //Returns false if not found so test fails
    public Boolean setSelectedMenuItem(String menuItemText)
    {
        for (int i = 0; i < menu.size(); i ++)
        {
            //debug string
            String current = menu.get(i).returnText();
            if (menu.get(i).returnText().equals(menuItemText))
            {
                selectedMenuItem = menu.get(i);
                return true;
            }            
        }
        return false;
    }   
    
    //sets selectedMenuItem's selected submenu item
    //returns true if successful
    //returns false if not
    public Boolean setSelectedSubMenuItem(String selected)
    {
        //first make sure the main nav menu item is selected. If null, an exception is caught and false is returned
        try
        {
            if (selectedMenuItem.equals(null))
            {
                return false;
            }
        }
        catch(NullPointerException e)
        {
            return false;
        }
        
        return selectedMenuItem.setSelectedSubMenuElement(selected);
        
    }
    
    //navigates to selected menu item and allows a half second wait for the page to load
    public void navigateToSelectedMenuItem()
    {
        selectedMenuItem.ClickElement();
        
        Driver.implicitWait(1000);
    }
    
    public void navigateToSelectedSubMenuItem()
    {
        selectedMenuItem.ClickSelectedSubElement();
        
        Driver.implicitWait(1000);
    }
    
}
