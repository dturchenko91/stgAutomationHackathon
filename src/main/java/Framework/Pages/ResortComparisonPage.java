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
public class ResortComparisonPage {
    
    private WebDriver driver = Driver.getDriver();
    
    private WebElement comparisonDropDown = driver.findElement(By.cssSelector("select.js-resort-comparison-select"));
    
    private List<WebElement> comparisonDropDownOptions = driver.findElements(By.cssSelector("option.resort_comparisons-menu_item"));
    
    private List<WebElement> resortNames;
    
    private List<WebElement> comparisonValues;
    
    private String currentComparisonName;
    
    //returns true if selected element is found. returns false if not found
    //clicks comparison drop down and selected drop down option if found
    public Boolean selectDropDownOption(String name)
    {
        currentComparisonName = name;
        
        for (int i = 0; i < comparisonDropDownOptions.size(); i ++)
        {
            
            comparisonDropDown.click();
            WebElement current = comparisonDropDownOptions.get(i);
            
            //temporary debug variable
            String currentText = current.getAttribute("innerText");
            
            if (currentText.contains(name))
            {
                current.click();
                return true;
            }
        }
        return false;
        
    }
    
    public void readComparisonToConsole()
    {
        resortNames = driver.findElements(By.cssSelector("span.ResortComparison-resortName"));
        
        comparisonValues = driver.findElements(By.cssSelector("span.ResortComparison-value"));
                
        System.out.println(currentComparisonName + ": ");
        for (int i = 0; i < resortNames.size(); i ++)
        {
            System.out.println(resortNames.get(i).getAttribute("innerText") + ": " + comparisonValues.get(i).getAttribute("innerText"));
        }
    }
}
