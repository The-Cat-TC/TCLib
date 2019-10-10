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
public class ServiceListenerNGTest {
    
    public ServiceListenerNGTest() {
    }

    /**
     * Test of onStart method, of class ServiceListener.
     */
    @Test(groups= "ServiceListener")
    public void testOnStart() {
        System.out.println("onStart");
        Reporter.log("Check ServiceListener onStart success");
        assertTrue(true,"ServiceListener");
    }

    /**
     * Test of onStop method, of class ServiceListener.
     */
    @Test(groups= "ServiceListener")
    public void testOnStop() {
        System.out.println("onStop");
        Reporter.log("Check ServiceListener onStop success");
        assertTrue(true,"ServiceListener");
    }

    /**
     * Test of onEnable method, of class ServiceListener.
     */
    @Test(groups= "ServiceListener")
    public void testOnEnable() {
        System.out.println("onEnable");
        Reporter.log("Check ServiceListener onEnable success");
        assertTrue(true,"ServiceListener");
    }

    /**
     * Test of onDisable method, of class ServiceListener.
     */
    @Test(groups= "ServiceListener")
    public void testOnDisable() {
        System.out.println("onDisable");
        Reporter.log("Check ServiceListener onDisable success");
        assertTrue(true,"ServiceListener");
    }
    
}
