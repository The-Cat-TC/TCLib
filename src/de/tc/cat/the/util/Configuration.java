/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.tc.cat.the.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * The class is used to store and load Properties in Java, so let yourself be created and loaded with this Klasser Properties. 
 * This is intended to make it easier to deal with properties.
 * @author Christian Trostmann
 * @since 1.8
 * @version 1.0
 */
public class Configuration {
    private static Properties conf;
    /**
     * Creates a new Properties configuration.
     * @param config Specifies the properties required an Object from Properties.
     */
    public Configuration (Properties config)
    {
        conf = config;
    }
    /**
     * Loads a Properties file.
     * @param file Specifies a FileInputStream object that loads the confidence file.
     * @param Key Specifies the configuration name as a string.
     * @param Value Specifies the Configuarions worth as a string.
     * @return Returns the Configuarions worth as a string.
     * @throws IOException 
     */
    public String loadSetting(FileInputStream file,String Key,String Value) throws IOException
    {
        conf.load(file);
        return conf.getProperty(Key,Value);
    }
    
    /**
     * Loads a Properties file.
     * @param file Specifies a FileInputStream object that loads the confidence file.
     * @param Key Specifies the configuration name as a string.
     * @return Returns the Configuarions worth as a string.
     * @throws IOException 
     */
    public String loadSetting(FileInputStream file,String Key) throws IOException
    {
        conf.load(file);
        return conf.getProperty(Key);
    }
    
    /**
     * 
     * @param file 
     * @param Key Specifies the configuration name as a string.
     * @param Value Specifies the Configuarions worth as a string.
     * @param Coment Specifies a Comment for the Configurations file.
     * @throws IOException 
     */
    public void saveSetting(FileOutputStream file, String Key, String Value, String Coment) throws IOException
    {
        conf.setProperty(Key, Value);
        conf.store(file, Coment);
    }
}
