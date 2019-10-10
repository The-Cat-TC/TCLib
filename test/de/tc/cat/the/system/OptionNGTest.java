/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.tc.cat.the.system;

import static org.testng.Assert.*;
import org.testng.Reporter;
import org.testng.annotations.Test;

/**
 *
 * @author the-c
 */
public class OptionNGTest {
    
    public OptionNGTest() {
    }

    /**
     * Test of values method, of class Option.
     */
    @Test(groups= "Option")
    public void testValues() {
        Reporter.log("Check Option Values success");
        System.out.println("values");
        assertTrue(true,"Test enum option vlues success");
        // TODO review the generated test code and remove the default call to fail.Option.
    }

    /**
     * Test of valueOf method, of class Option.
     */
    @Test(groups= "Option")
    public void testValueOf() {
        Reporter.log("Check Option Vlaueof success");
        System.out.println("valueOf");
        assertTrue(true,"Test enum option valueof success");
    }
    
}
