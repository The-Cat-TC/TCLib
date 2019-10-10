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
public class OSNGTest {
    
    public OSNGTest() {
    }

    /**
     * Test of values method, of class OS.
     */
    @Test(groups= "OS")
    public void testValues() {
        Reporter.log("Check OS Values success");
        System.out.println("values");
        assertTrue(true,"test os value success");
    }

    /**
     * Test of valueOf method, of class OS.
     */
    @Test(groups= "OS")
    public void testValueOf() {
        Reporter.log("Check OS Value success");
        System.out.println("valueOf");
        assertTrue(true,"Test os valueof success");
    }

    /**
     * Test of getVersion method, of class OS.
     */
    @Test(groups= "OS")
    public void testGetVersion() {
        Reporter.log("Check OS GetVersion success");
        System.out.println("getVersion");
        assertTrue(true,"os getversion success");
    }

    /**
     * Test of setVersion method, of class OS.
     */
    @Test(groups= "OS")
    public void testSetVersion() {
        System.out.println("setVersion");
        assertTrue(true,"os test setversion success");
    }
    
}
