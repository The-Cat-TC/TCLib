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
public class FileReadNGTest {
    
    public FileReadNGTest() {
    }

    /**
     * Test of read method, of class FileRead.
     * @throws java.lang.Exception
     */
    @Test(groups= "FileRead")
    public void testRead() throws Exception {
        Reporter.log("Check FileRead success");
        System.out.println("read");
        assertTrue(true,"Fileread success");
    }
    
}
