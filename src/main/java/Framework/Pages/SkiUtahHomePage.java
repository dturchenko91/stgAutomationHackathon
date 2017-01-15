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


public class SkiUtahHomePage {
    
    //get webdriver from Driver class
    private WebDriver driver = Driver.getDriver();
    
    public SkiUtahHomePage()
    {
        
    }
    
    public String getPageTitle()
    {
        return driver.getTitle();
    }
    
}
