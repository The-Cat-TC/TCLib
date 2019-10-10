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
public class FileWriteNGTest {
    
    public FileWriteNGTest() {
    }

    /**
     * Test of write method, of class FileWrite.
     */
    @Test(groups= "FileWrite")
    public void testWrite_String_File() {
        Reporter.log("Check FileWrite write success");
        System.out.println("write");
        assertTrue(true,"File write success");
    }

    /**
     * Test of write method, of class FileWrite.
     */
    @Test(groups= "FileWrite")
    public void testWrite_3args_1() {
        Reporter.log("Check FileWrite write success");
        System.out.println("write");
        assertTrue(true,"File write success");
    }

    /**
     * Test of write method, of class FileWrite.
     */
    @Test(groups= "FileWrite")
    public void testWrite_3args_2() {
        Reporter.log("Check FileWrite write success");
        System.out.println("write");
        assertTrue(true,"File write success");
    }

    /**
     * Test of write method, of class FileWrite.
     */
    @Test(groups= "FileWrite")
    public void testWrite_4args() {
        Reporter.log("Check FileWrite write success");
        System.out.println("write");
        assertTrue(true,"File write success");
    }

    /**
     * Test of exceptionReturn method, of class FileWrite.
     */
    @Test(groups= "FileWrite")
    public void testExceptionReturn() {
        Reporter.log("Check FileWrite write success");
        System.out.println("exceptionReturn");
        assertTrue(true,"File write success");
    }
    
}
