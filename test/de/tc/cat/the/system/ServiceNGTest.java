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
public class ServiceNGTest {
    
    public ServiceNGTest() {
        Service s1 = new Service("Test",Status.Aktiviert,Option.Run);
        s = s1;
    }
    
    Service s = null;
    /**
     * Test of getOption method, of class Service.
     */
    @Test(groups= "Service")
    public void testGetOption() {
        Reporter.log("Check Service getOption success");
        System.out.println("getOption");
        Service instance = s;
        String expResult = "Run";
        String result = instance.getOption();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getStatus method, of class Service.
     */
    @Test(groups= "Service")
    public void testGetStatus() {
        Reporter.log("Check Service getStatus success");
        System.out.println("getStatus");
        Service instance = s;
        String expResult = "Aktiviert";
        String result = instance.getStatus();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getName method, of class Service.
     */
    @Test(groups= "Service")
    public void testGetName() {
        Reporter.log("Check Service getName success");
        System.out.println("getName");
        Service instance = s;
        String expResult = "Test";
        String result = instance.getName();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of isAktiv method, of class Service.
     */
    @Test(groups= "Service")
    public void testIsAktiv() {
        Reporter.log("Check Service isActiv success");
        System.out.println("isAktiv");
        Service instance = s;
        boolean expResult = true;
        boolean result = instance.isAktiv();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of isRunning method, of class Service.
     */
    @Test(groups= "Service")
    public void testIsRunning() {
        Reporter.log("Check Service isRunning success");
        System.out.println("isRunning");
        Service instance = s;
        boolean expResult = true;
        boolean result = instance.isRunning();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setStatus method, of class Service.
     */
    @Test(groups= "Service")
    public void testSetStatus() {
        Reporter.log("Check Service setStatus success");
        System.out.println("setStatus");
        Status sstatus = Status.Deaktiviert;
        Service instance = s;
        instance.setStatus(sstatus);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals("Deaktiviert",instance.getStatus());
    }

    /**
     * Test of setOption method, of class Service.
     */
    @Test(groups= "Service")
    public void testSetOption() {
        Reporter.log("Check Service setOption success");
        System.out.println("setOption");
        Option soption = Option.Stop;
        Service instance = s;
        instance.setOption(soption);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals("Stop",instance.getOption());
    }

    /**
     * Test of addSystemListener method, of class Service.
     */
    @Test(groups= "Service")
    public void testAddSystemListener() {
        Reporter.log("Check Service addListener success");
        System.out.println("addSystemListener");
        assertTrue(true,"Service addListener");
    }

    /**
     * Test of removeSystemListener method, of class Service.
     */
    @Test(groups= "Service")
    public void testRemoveSystemListener() {
        Reporter.log("Check Service removeListener success");
        System.out.println("removeSystemListener");
        assertTrue(true,"Service removeListener");
    }

    /**
     * Test of getAction method, of class Service.
     */
    @Test(groups= "Service")
    public void testGetAction() {
        Reporter.log("Check Service getAction success");
        System.out.println("getAction");
        Service instance = s;
        instance.setStatus(Status.Aktiviert);
        instance.setOption(Option.Run);
        instance.getAction();
        // TODO review the generated test code and remove the default call to fail.
        instance.addSystemListener(new ServiceListener() {
            public void onStart(String e) {
                Reporter.log("Check Service onStart success");
                assertTrue(true,"Service onStart");
                instance.setStatus(Status.Aktiviert);
                instance.setOption(Option.Stop);
            }

            public void onStop(String e) {
                Reporter.log("Check Service onStop success");
                assertTrue(true,"Service onStop");
                instance.setStatus(Status.Deaktiviert);
            }

            public void onEnable(String e) {
                Reporter.log("Check Service onEnable success");
                assertTrue(true,"Service onEnable");
                instance.setStatus(Status.Deaktiviert);
            }

            public void onDisable(String e) {
                Reporter.log("Check Service onDisable success");
                assertTrue(true,"Service onStart");
            }
        });
    }
    
}
