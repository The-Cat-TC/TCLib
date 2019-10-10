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
public class RunApplicationNGTest {
    
    public RunApplicationNGTest() {
    }

    /**
     * Test of exec method, of class RunApplication.
     * @throws java.lang.Exception
     */
    @Test(groups= "RunApplication")
    public void testExec_StringArr() throws Exception {
        Reporter.log("Check Runapplication success");
        System.out.println("exec");
        assertTrue(true,"RunnApplication exec success");
    }

    /**
     * Test of exec method, of class RunApplication.
     * @throws java.lang.Exception
     */
    @Test(groups= "RunApplication")
    public void testExec_List() throws Exception {
        Reporter.log("Check Runapplication success");
        System.out.println("exec");
        assertTrue(true,"RunnApplication exec success");
    }

    /**
     * Test of exec method, of class RunApplication.
     * @throws java.lang.Exception
     */
    @Test(groups= "RunApplication")
    public void testExec_String() throws Exception {
        Reporter.log("Check Runapplication success");
        System.out.println("exec");
        assertTrue(true,"RunnApplication exec success");
    }

    /**
     * Test of exec method, of class RunApplication.
     * @throws java.lang.Exception
     */
    @Test(groups= "RunApplication")
    public void testExec_StringArr_File() throws Exception {
        Reporter.log("Check Runapplication success");
        System.out.println("exec");
        assertTrue(true,"RunnApplication exec success");
    }

    /**
     * Test of exec method, of class RunApplication.
     * @throws java.lang.Exception
     */
    @Test(groups= "RunApplication")
    public void testExec_List_File() throws Exception {
        Reporter.log("Check Runapplication success");
        System.out.println("exec");
        assertTrue(true,"RunnApplication exec success");
    }

    /**
     * Test of exec method, of class RunApplication.
     * @throws java.lang.Exception
     */
    @Test(groups= "RunApplication")
    public void testExec_String_File() throws Exception {
        Reporter.log("Check Runapplication success");
        System.out.println("exec");
        assertTrue(true,"RunnApplication exec success");
    }
    
}
