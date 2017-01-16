/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Framework.Pages;

import Framework.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *
 * @author Dan
 */
public class HomePageMenuItem {
    
    
    private WebElement element;
    
    
    public HomePageMenuItem(WebElement element)
    {
        this.element = element;
    }
    
    //some menu elements have a hover menu. A regular click() does not work, special code is required to first hover over, then click the element
    public void ClickElement()
    {
        Driver.hoverThenClick(element);
    }
    
    public String returnText()
    {
        return element.getText();
    }
    
    
    
}
