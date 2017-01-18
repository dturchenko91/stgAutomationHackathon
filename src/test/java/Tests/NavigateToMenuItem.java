/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

import Framework.Driver;
import Framework.Pages.SkiUtahHomePage;
import Framework.Pages.HomePageMenuItem;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dan
 */
public class NavigateToMenuItem {
    
    public NavigateToMenuItem() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        Driver.setUp();
        Driver.navigateToHomePage();
        
    }
    
    @AfterClass
    public static void tearDownClass() {
        
        Driver.tearDown();
    }
    
    @Before
    public void setUp() {
        if (!Driver.getCurrentPageTitle().equals("Ski Utah - Ski Utah"));
            Driver.navigateToHomePage();
    }
    
    @After
    public void tearDown() {
    }
    
    //automation challenge 2
    @Test
    public void navigateToPlanPage()
    {
        String selectedMenuItem = "PLAN YOUR TRIP ";
        Assert.assertTrue("Nav Menu Element " + selectedMenuItem + " not found.", Driver.homePage.setSelectedMenuItem(selectedMenuItem));
        Driver.homePage.navigateToSelectedMenuItem();
        Assert.assertEquals("Ski Utah Trip Planner - Ski Utah", Driver.getCurrentPageTitle());
        
        
    }
    
    //automation challenge 3
    //this uses some exploits to pass as i'm having trouble writing a mouseover function. instead i must make do with a
    //slightly hacky solution to reach the resorts comparison page by clicking on the top nav element instead of simply hovering over it
    @Test
    public void navigateToResortComparisonPage()
    {
        String selectedMenuItem = "RESORTS & SNOW ";
        String selectedSubMenuItem = "Resort Comparison";
        Assert.assertTrue("Nav Menu Element " + selectedMenuItem + " not found.", Driver.homePage.setSelectedMenuItem(selectedMenuItem));
        Assert.assertTrue("Nav Menu SubElement " + selectedSubMenuItem + " not found", Driver.homePage.setSelectedSubMenuItem(selectedSubMenuItem));
        
        Driver.homePage.navigateToSelectedSubMenuItem();
        Assert.assertEquals("Resort Comparison - Ski Utah", Driver.getCurrentPageTitle());
    }
    
    @Test
    public void getDistanceFromAirport()
    {
        Driver.navigateToResortComparisonPage();
        
        //todo:
        
        String dropDownOptionText = "Miles to Closest Major Airport";
        Assert.assertTrue("Drop Down option " + dropDownOptionText + " not found.", Driver.resortComparisonPage.selectDropDownOption(dropDownOptionText));
                
        //read each individual resort's name and mileage, output to console
        Driver.resortComparisonPage.readComparisonToConsole();
    }
}
