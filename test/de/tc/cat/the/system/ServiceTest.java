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
public class ServiceTest {
    
    public ServiceTest() {
    }

    /**
     * Test of getOption method, of class Service.
     */
    @Test
    public void testGetOption() {
        System.out.println("getOption");
        Service instance = new Service("Test",Status.Aktiviert,Option.Run);
        String expResult = "Run";
        String result = instance.getOption();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getStatus method, of class Service.
     */
    @Test
    public void testGetStatus() {
        System.out.println("getStatus");
        Service instance = new Service("Test",Status.Aktiviert,Option.Run);
        String expResult = "Aktiviert";
        String result = instance.getStatus();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getName method, of class Service.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Service instance = new Service("Test",Status.Aktiviert,Option.Run);
        String expResult = "Test";
        String result = instance.getName();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of isAktiv method, of class Service.
     */
    @Test
    public void testIsAktiv() {
        System.out.println("isAktiv");
        Service instance = new Service("Test",Status.Aktiviert,Option.Run);
        boolean expResult = true;
        boolean result = instance.isAktiv();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of isRunning method, of class Service.
     */
    @Test
    public void testIsRunning() {
        System.out.println("isRunning");
        Service instance = new Service("Test",Status.Aktiviert,Option.Run);
        boolean expResult = true;
        boolean result = instance.isRunning();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setStatus method, of class Service.
     */
    @Test
    public void testSetStatus() {
        System.out.println("setStatus");
        Status sstatus = Status.Deaktiviert;
        Service instance = new Service("Test",Status.Aktiviert,Option.Run);
        instance.setStatus(sstatus);
        String expResult = "Deaktiviert";
        String result = instance.getStatus();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setOption method, of class Service.
     */
    @Test
    public void testSetOption() {
        System.out.println("setOption");
        Option soption = Option.Stop;
        Service instance =  new Service("Test",Status.Aktiviert,Option.Run);
        instance.setOption(soption);
        String expResult = "Stop";
        String result = instance.getOption();
        assertEquals(expResult, result);
        
    }
    
}
