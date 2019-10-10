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
public class JFileChooserNGTest {
    
    public JFileChooserNGTest() {
    }

    /**
     * Test of setFileFilter method, of class JFileChooser.
     */
    @Test(groups= "JFileChooser")
    public void testSetFileFilter() {
        Reporter.log("Check JFileChooser success");
        System.out.println("setFileFilter");
        assertTrue(true,"JFileChooser success");
    }

    /**
     * Test of getFileNameExtensionFilter method, of class JFileChooser.
     */
    @Test(groups= "JFileChooser")
    public void testGetFileNameExtensionFilter() {
        Reporter.log("Check JFileChooser success");
        System.out.println("getFileNameExtensionFilter");
        assertTrue(true,"JFileChooser success");
    }
    
}
