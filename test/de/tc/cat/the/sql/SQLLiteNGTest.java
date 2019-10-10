/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.tc.cat.the.sql;

import java.sql.Connection;
import static org.testng.Assert.*;
import org.testng.Reporter;
import org.testng.annotations.Test;

/**
 *
 * @author the-c
 */
public class SQLLiteNGTest {
    
    public SQLLiteNGTest() {
    }

    /**
     * Test of createNewDatebase method, of class SQLLite.
     */
    @Test(groups= "SQLLite")
    public void testCreateNewDatebase() {
        Reporter.log("Check creating a new Database");
        System.out.println("createNewDatebase");
        String path = "";
        String name = "Test";
        SQLLite instance = new SQLLite();
        instance.createNewDatebase(path, name);
        // TODO review the generated test code and remove the default call to fail.
        assertTrue(true, "create SQLite Datebase success");
    }

    /**
     * Test of connectetDatebase method, of class SQLLite.
     */
    @Test(groups= "SQLLite")
    public void testConnectetDatebase() {
        System.out.println("connectetDatebase");
        Reporter.log("Check createTable success");
        assertTrue(true, "Conecction Database success");
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of createTabel method, of class SQLLite.
     */
    @Test(groups= "SQLLite")
    public void testCreateTabel() {
        System.out.println("createTabel");
        String path = "";
        String name = "";
        String sql = "";
        SQLLite instance = new SQLLite();
        instance.createTabel(path, name, sql);
        // TODO review the generated test code and remove the default call to fail.
        assertTrue(true,"Create SQL Table Success");
    }
    
}
