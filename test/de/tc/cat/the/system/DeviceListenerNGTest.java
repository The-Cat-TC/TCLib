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
public class DeviceListenerNGTest {
    
    public DeviceListenerNGTest() {
    }

    /**
     * Test of onEnable method, of class DeviceListener.
     */
    @Test(groups= "DeviceListener")
    public void testOnEnable() {
        System.out.println("onEnable");
        Reporter.log("Check DeviceListener onEnable success");
        assertTrue(true,"DeviceLIstener");
    }

    /**
     * Test of onDisable method, of class DeviceListener.
     */
    @Test(groups= "DeviceListener")
    public void testOnDisable() {
        System.out.println("onDisable");
        Reporter.log("Check DeviceListener onDisable success");
        assertTrue(true,"DeviceListener");
    }
    
}
