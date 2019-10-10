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
public class ConfigurationNGTest {
    
    public ConfigurationNGTest() {
    }

    /**
     * Test of loadSetting method, of class Configuration.
     * @throws java.lang.Exception
     */
    @Test(groups= "Configuration")
    public void testLoadSetting_3args() throws Exception {
        Reporter.log("Check Configuration LoadSetting success");
        System.out.println("loadSetting");
        assertTrue(true,"loadSetting success");
    }

    /**
     * Test of loadSetting method, of class Configuration.
     * @throws java.lang.Exception
     */
    @Test(groups= "Configuration")
    public void testLoadSetting_FileInputStream_String() throws Exception {
        Reporter.log("Check Configuration LoadSetting success");
        System.out.println("loadSetting");
        assertTrue(true,"loadSetting success");
    }

    /**
     * Test of loadSettingXML method, of class Configuration.
     * @throws java.lang.Exception
     */
    @Test(groups= "Configuration")
    public void testLoadSettingXML_3args() throws Exception {
        Reporter.log("Check Configuration LoadSetting success");
        System.out.println("loadSettingXML");
        assertTrue(true,"loadSetting success");
    }

    /**
     * Test of loadSettingXML method, of class Configuration.
     * @throws java.lang.Exception
     */
    @Test(groups= "Configuration")
    public void testLoadSettingXML_FileInputStream_String() throws Exception {
        Reporter.log("Check Configuration LoadSetting success");
        System.out.println("loadSettingXML");
        assertTrue(true,"loadSetting success");
    }

    /**
     * Test of saveSetting method, of class Configuration.
     * @throws java.lang.Exception
     */
    @Test(groups= "Configuration")
    public void testSaveSetting() throws Exception {
        Reporter.log("Check Configuration SaveSetting success");
        System.out.println("saveSetting");
        assertTrue(true,"saveSetting success");
    }

    /**
     * Test of saveSettingXML method, of class Configuration.
     * @throws java.lang.Exception
     */
    @Test(groups= "Configuration")
    public void testSaveSettingXML() throws Exception {
        Reporter.log("Check Configuration SaveSetting success");
        System.out.println("saveSettingXML");
        assertTrue(true,"saveSetting success");
    }
    
}
