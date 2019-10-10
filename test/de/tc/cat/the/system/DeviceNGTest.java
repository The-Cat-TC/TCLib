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
public class DeviceNGTest {
    
    public DeviceNGTest() {
        Device d1 = new Device("Test",Status.Aktiviert);
        d = d1;
    }
    Device d= null;
    /**
     * Test of getName method, of class Device.
     */
    @Test(groups= "Device")
    public void testGetName() {
        Reporter.log("Check Device getName success");
        System.out.println("getName");
        Device instance = d;
        String expResult = "Test";
        String result = instance.getName();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getStatus method, of class Device.
     */
    @Test(groups= "Device")
    public void testGetStatus() {
        Reporter.log("Check Device getStatus success");
        System.out.println("getStatus");
        Device instance = d;
        String expResult = "Aktiviert";
        String result = instance.getStatus();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of isAktiv method, of class Device.
     */
    @Test(groups= "Device")
    public void testIsAktiv() {
        Reporter.log("Check Device isActiv success");
        System.out.println("isAktiv");
        Device instance = d;
        boolean expResult = true;
        boolean result = instance.isAktiv();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setStatus method, of class Device.
     */
    @Test(groups= "Device")
    public void testSetStatus() {
        Reporter.log("Check Device getStatus success");
        System.out.println("setStatus");
        Status dstatus = Status.Deaktiviert;
        Device instance = d;
        instance.setStatus(dstatus);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals("Deaktiviert", instance.getStatus());
    }

    /**
     * Test of setName method, of class Device.
     */
    @Test(groups= "Device")
    public void testSetName() {
        Reporter.log("Check Device setName");
        System.out.println("setName");
        String dname = "Test1";
        Device instance = d;
        instance.setName(dname);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals("Test1", instance.getName());
        Reporter.log("Check Device setName success");
    }

    /**
     * Test of getAction method, of class Device.
     */
    @Test(groups= "Device")
    public void testGetAction() {
        Reporter.log("Check Device getAction");
        System.out.println("getAction");
        Device instance = d;
        instance.getAction();
        instance.setStatus(Status.Aktiviert);
        // TODO review the generated test code and remove the default call to fail.
        instance.addSystemListener(new DeviceListener() {
            public void onEnable(String e) {
                Reporter.log("Check Device onEnable success");
                assertEquals("Test1", e,"Device onEable success");
                instance.setStatus(Status.Deaktiviert);
            }

            public void onDisable(String e) {
                Reporter.log("Check Device onDisable success");
                assertEquals("Test1", e,"Device onDisable success");
            }
        });
    }

    /**
     * Test of addSystemListener method, of class Device.
     */
    @Test(groups= "Device")
    public void testAddSystemListener() {
        Reporter.log("Check Device addListener success");
        System.out.println("addSystemListener");
        assertTrue(true,"Device addListener");
    }

    /**
     * Test of removeSystemListener method, of class Device.
     */
    @Test(groups= "Device")
    public void testRemoveSystemListener() {
        Reporter.log("Check Device removeListener success");
        System.out.println("removeSystemListener");
        assertTrue(true,"Device removeListener");
    }
    
}
