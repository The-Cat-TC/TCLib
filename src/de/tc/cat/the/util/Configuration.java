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
    
    public Configuration()
    {
        conf = new Properties();
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
     * Loads a Properties file as XML.
     * @param file Specifies a FileInputStream object that loads the confidence file.
     * @param Key Specifies the configuration name as a string.
     * @param Value Specifies the Configuarions worth as a string.
     * @return Returns the Configuarions worth as a string.
     * @throws IOException 
     */
    public String loadSettingXML(FileInputStream file,String Key,String Value) throws IOException
    {
        conf.loadFromXML(file);
        return conf.getProperty(Key,Value);
    }
    
    /**
     * Loads a Properties file as XML.
     * @param file Specifies a FileInputStream object that loads the confidence file.
     * @param Key Specifies the configuration name as a string.
     * @return Returns the Configuarions worth as a string.
     * @throws IOException 
     */
    public String loadSettingXML(FileInputStream file,String Key) throws IOException
    {
        conf.loadFromXML(file);
        return conf.getProperty(Key);
    }
    
    
    
    /**
     * Sets a configurations file to those that specify contains keys and values.
     * @param file Defines the input file as FileInputStream to which is written.
     * @param Key Specifies the configuration name as a string.
     * @param Value Specifies the Configuarions worth as a string.
     * @param Coment Specifies a Comment for the Configurations file.
     * @param save Indicates whether the file is saved or not. True or false. 
     * @throws IOException 
     */
    public void saveSetting(FileOutputStream file, String Key, String Value, String Coment,boolean save) throws IOException
    {
        conf.setProperty(Key, Value);
        if (save == true)
        {
            conf.store(file, Coment);
        }
    }
    
    /**
     * Sets a configurations file to those that specify contains keys and values and speares them as XML.
     * @param file Defines the input file as FileInputStream to which is written.
     * @param Key Specifies the configuration name as a string.
     * @param Value Specifies the Configuarions worth as a string.
     * @param comment Specifies a Comment for the Configurations file.
     * @param save Indicates whether the file is saved or not. True or false. 
     * @throws IOException 
     */
    public void saveSettingXML(FileOutputStream file,String Key,String Value,String comment,boolean save) throws IOException
    {
        conf.setProperty(Key, Value);
        if (save == true)
        {
            conf.storeToXML(file, comment);
        }
    }
}
