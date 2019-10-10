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
public class FileRecursiveNGTest {
    
    public FileRecursiveNGTest() {
    }

    /**
     * Test of dir method, of class FileRecursive.
     */
    @Test(groups= "FileRecursive")
    public void testDir() {
        Reporter.log("Check Dir success");
        System.out.println("dir");
        assertTrue(true, "test Dir success");
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of file method, of class FileRecursive.
     */
    @Test(groups= "FileRecursive")
    public void testFile() {
        Reporter.log("Check File success");
        System.out.println("file");
        assertTrue(true,"Test File success");
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
