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
public class HomePageMenuHoverItem {
    
    private WebElement element;
    
    public HomePageMenuHoverItem(WebElement element)
    {
        this.element = element;
    }
    
    public String returnText()
    {
        return element.getAttribute("innerText");
    }
    
    public WebElement returnElement()
    {
        return element;
    }
}
