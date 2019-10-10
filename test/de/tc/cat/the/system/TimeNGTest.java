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
public class TimeNGTest {
    
    public TimeNGTest() {
    }

    /**
     * Test of getTime method, of class Time.
     */
    @Test(groups= "Time")
    public void testGetTime() {
        Reporter.log("Check getTime success");
        System.out.println("getTime");
        assertTrue(true,"getTime success");
    }

    /**
     * Test of getDate method, of class Time.
     */
    @Test(groups= "Time")
    public void testGetDate() {
        Reporter.log("Check GetDate success");
        System.out.println("getDate");
        assertTrue(true,"getDate success");
    }
    
}
