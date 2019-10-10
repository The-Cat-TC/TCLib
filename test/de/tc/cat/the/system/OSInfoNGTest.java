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
public class OSInfoNGTest {
    
    public OSInfoNGTest() {
    }

    /**
     * Test of getOs method, of class OSInfo.
     */
    @Test(groups= "OSInfo")
    public void testGetOs() {
        Reporter.log("Check OSInfo success");
        System.out.println("getOs");
        OS expResult = OS.WINDOWS;
        OS result = OSInfo.getOs();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
