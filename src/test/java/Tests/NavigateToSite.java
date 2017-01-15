/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

import Framework.Driver;
import Framework.Pages.SkiUtahHomePage;
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
public class NavigateToSite {
    
    public NavigateToSite() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testPageTitleExists() 
    {
        String titleText = Driver.homePage.getPageTitle();
        Assert.assertEquals("Ski Utah - Ski Utah", titleText);
    }
    
}
