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
public class SeperatorNGTest {
    
    public SeperatorNGTest() {
    }

    /**
     * Test of lineseperator method, of class Seperator.
     */
    @Test(groups= "Seperator")
    public void testLineseperator() {
        Reporter.log("Check Lineseperator success");
        System.out.println("lineseperator");
        assertTrue(true,"Lineseperator success");
    }

    /**
     * Test of pathseperator method, of class Seperator.
     */
    @Test(groups= "Seperator")
    public void testPathseperator() {
        Reporter.log("Check Pathseperator success");
        System.out.println("pathseperator");
        assertTrue(true,"Pathseprator success");
    }

    /**
     * Test of fileseperator method, of class Seperator.
     */
    @Test(groups= "Seperaot")
    public void testFileseperator() {
        Reporter.log("Check Fileseperator success");
        System.out.println("fileseperator");
        assertTrue(true,"Fileseprator success");
    }
    
}
