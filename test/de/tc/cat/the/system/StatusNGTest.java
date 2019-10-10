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
public class StatusNGTest {
    
    public StatusNGTest() {
    }

    /**
     * Test of values method, of class Status.
     */
    @Test(groups= "Status")
    public void testValues() {
        Reporter.log("Check Status Values success");
        System.out.println("values");
        assertTrue(true,"Values success");
    }

    /**
     * Test of valueOf method, of class Status.
     */
    @Test(groups= "Status")
    public void testValueOf() {
        Reporter.log("Check Status Valuesof success");
        System.out.println("valueOf");
        assertTrue(true,"valueof success");
    }
    
}
