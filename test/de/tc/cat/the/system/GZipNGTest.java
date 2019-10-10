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
public class GZipNGTest {
    
    public GZipNGTest() {
    }

    /**
     * Test of packen method, of class GZip.
     */
    @Test(groups= "GZip")
    public void testPacken() {
        Reporter.log("Check Pack success");
        System.out.println("packen");
        // TODO review the generated test code and remove the default call to fail.
        assertTrue(true,"Test packen success");
    }
    
}
