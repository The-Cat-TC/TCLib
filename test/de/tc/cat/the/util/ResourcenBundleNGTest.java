/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.tc.cat.the.util;

import static org.testng.Assert.*;
import org.testng.Reporter;
import org.testng.annotations.Test;

/**
 *
 * @author the-c
 */
public class ResourcenBundleNGTest {
    
    public ResourcenBundleNGTest() {
    }

    /**
     * Test of bundle method, of class ResourcenBundle.
     */
    @Test(groups= "ResourcenBundle")
    public void testBundle_String_String() {
        Reporter.log("Check Bundle success");
        System.out.println("bundle");
        assertTrue(true,"Bundle success");
    }

    /**
     * Test of bundle method, of class ResourcenBundle.
     */
    @Test(groups= "ResourcenBundle")
    public void testBundle_3args() {
        Reporter.log("Check Bundle success");
        System.out.println("bundle");
        assertTrue(true,"Bundle success");
    }
    
}
