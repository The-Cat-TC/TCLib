/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.tc.cat.the.system;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author the-c
 */
public class DeviceTest {
    
    public DeviceTest() {
    }

    /**
     * Test of getName method, of class Device.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Device instance = new de.tc.cat.the.system.Device("Test", Status.Aktiviert);
        String expResult = "Test";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getStatus method, of class Device.
     */
    @Test
    public void testGetStatus() {
        System.out.println("getStatus");
        Device instance = new de.tc.cat.the.system.Device("Test", Status.Aktiviert);
        String expResult = "Aktiviert";
        String result = instance.getStatus();
        assertEquals(expResult, result);
    }

    /**
     * Test of isAktiv method, of class Device.
     */
    @Test
    public void testIsAktiv() {
        System.out.println("isAktiv");
        Device instance = new de.tc.cat.the.system.Device("Test", Status.Aktiviert);
        boolean expResult = true;
        boolean result = instance.isAktiv();
        assertEquals(expResult, result);
    }

    /**
     * Test of setStatus method, of class Device.
     */
    @Test
    public void testSetStatus() {
        System.out.println("setStatus");
        Status dstatus = Status.Deaktiviert;
        Device instance = new de.tc.cat.the.system.Device("Test", Status.Aktiviert);
        instance.setStatus(dstatus);
        String expResult = "Deaktiviert";
        String result = instance.getStatus();
        assertEquals(expResult, result);
    }
    
}
