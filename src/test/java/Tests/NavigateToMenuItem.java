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
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void navigateToPlanPage()
    {
        Driver.homePage.setSelectedMenuItem("PLAN YOUR TRIP");
        Driver.homePage.navigateToSelectedMenuItem();
        Assert.assertEquals("Ski Utah Trip Planner - Ski Utah", Driver.getCurrentPageTitle());
    }
}
