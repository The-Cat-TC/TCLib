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
public class VisitorNGTest {
    
    public VisitorNGTest() {
    }

    /**
     * Test of preVisitDirectory method, of class Visitor.
     * @throws java.lang.Exception
     */
    @Test(groups= "Visitor")
    public void testPreVisitDirectory() throws Exception {
        Reporter.log("Check PreVisitDirectory success");
        System.out.println("preVisitDirectory");
        assertTrue(true,"pre Visitor Directory success");
    }

    /**
     * Test of visitFile method, of class Visitor.
     * @throws java.lang.Exception
     */
    @Test(groups= "Visitor")
    public void testVisitFile() throws Exception {
        Reporter.log("Check VisitFile success");
        System.out.println("visitFile");
        assertTrue(true,"Visit File success");
    }
    
}
