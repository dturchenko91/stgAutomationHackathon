/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Framework.Pages;

import Framework.Driver;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 *
 * @author Dan
 */
public class HomePageMenuItem {
    
    private WebDriver driver = Driver.getDriver();
    
    private WebElement element;
    
    private List<HomePageMenuHoverItem> subMenu;
    
    private HomePageMenuHoverItem selectedSubMenuItem;
    
    
    public HomePageMenuItem(WebElement element)
    {
        this.element = element;
        
        subMenu = getSubMenu();
    }
    
    //some menu elements have a hover menu. A regular click() does not work, special code is required to first hover over, then click the element
    public void ClickElement()
    {
        Driver.hoverThenClick(element);
    }
    
    public void ClickSelectedSubElement()
    {
        Driver.hoverThenClickSubElement(element, selectedSubMenuItem.returnElement());
    }
    
    public String returnText()
    {
        return element.getAttribute("innerText");
    }
    
    //the intended functionality is to get a complete list of all sublink elements,
    //but hover over each nav menu element and add only the visible sublink elements
    //to that nav element's list of sublink elements
    //unfortunately, i cannot get the hover action to stay over the nav element long enough for the 
    //sublink elements to be "visible"
    //therefore I had no choice but to let each nav menu element have all sublink elements of all nav menu elements in its list of sublink elements
    private List<HomePageMenuHoverItem> getSubMenu()
    {   
        hoverElement();
        
        List<WebElement> elements = driver.findElements(By.cssSelector("a.SuperfishMegaMenu-subLink"));
        
        List<HomePageMenuHoverItem> contextMenu = new ArrayList<HomePageMenuHoverItem>();
        
        for (int i = 0; i < elements.size(); i ++)
        {
            //if (elements.get(i).isDisplayed())
                contextMenu.add(new HomePageMenuHoverItem(elements.get(i)));
        }
        
        return contextMenu;
    }
    
    private void hoverElement()
    {
        Actions action = new Actions(driver);
        
        action.moveToElement(element).build().perform();
    }
    
    public Boolean setSelectedSubMenuElement(String selected)
    {
        hoverElement();
        
        for (int i = 0; i < subMenu.size(); i ++)
        {
            //debug string
            String currentElement = element.getText();
            
            //debug string
            String currentSubElement = subMenu.get(i).returnText();
            if (subMenu.get(i).returnText().equals(selected))
            {
                selectedSubMenuItem = subMenu.get(i);
                return true;
            }
        }
        return false;
    }
    
    
}
