/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.tc.cat.the.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * The class is used to store and load Properties in Java, so let yourself be created and loaded with this Klasser Properties.
 * This is intended to make it easier to deal with properties.
 *
 * @author Christian Trostmann
 * @since 1.8
 * @version 1.0
 */
public class Configuration extends Properties{
    private static Properties conf;
    /**
     * Creates a new Properties configuration.
     *
     * @param config Specifies the properties required an Object from Properties.
     */
    public Configuration (Properties config)
    {
        conf = config;
    }
    
    /**
     * <p>Constructor for Configuration.</p>
     */
    public Configuration()
    {
        conf = this;
    }
    
    /**
     * Loads a Properties file.
     *
     * @param file Specifies a FileInputStream object that loads the confidence file.
     * @param Key Specifies the configuration name as a string.
     * @param Value Specifies the Configuarions worth as a string.
     * @return Returns the Configuarions worth as a string.
     * @throws java.io.IOException if any.
     */
    public String loadSetting(FileInputStream file,String Key,String Value) throws IOException
    {
        conf.load(file);
        return conf.getProperty(Key,Value);
    }
    
    /**
     * Loads a Properties file.
     *
     * @param file Specifies a FileInputStream object that loads the confidence file.
     * @param Key Specifies the configuration name as a string.
     * @return Returns the Configuarions worth as a string.
     * @throws java.io.IOException if any.
     */
    public String loadSetting(FileInputStream file,String Key) throws IOException
    {
        conf.load(file);
        return conf.getProperty(Key);
    }
    
    /**
     * Loads a Properties file.
     *
     * @param file Specifies a File object that loads the confidence file.
     * @param Key Specifies the configuration name as a string.
     * @param Value Specifies the Configuarions worth as a string.
     * @return Returns the Configuarions worth as a string.
     * @throws java.io.IOException if any.
     */
    public String loadSetting(File file,String Key,String Value) throws IOException
    {
        conf.load(new FileInputStream(file));
        return conf.getProperty(Key,Value);
    }
    
    /**
     * Loads a Properties file.
     *
     * @param file Specifies a File object that loads the confidence file.
     * @param Key Specifies the configuration name as a string.
     * @return Returns the Configuarions worth as a string.
     * @throws java.io.IOException if any.
     */
    public String loadSetting(File file,String Key) throws IOException
    {
        conf.load(new FileInputStream(file));
        return conf.getProperty(Key);
    }
    
    /**
     * Loads a Properties file as XML.
     *
     * @param file Specifies a FileInputStream object that loads the confidence file.
     * @param Key Specifies the configuration name as a string.
     * @param Value Specifies the Configuarions worth as a string.
     * @return Returns the Configuarions worth as a string.
     * @throws java.io.IOException if any.
     */
    public String loadSettingXML(FileInputStream file,String Key,String Value) throws IOException
    {
        conf.loadFromXML(file);
        return conf.getProperty(Key,Value);
    }
    
    /**
     * Loads a Properties file as XML.
     *
     * @param file Specifies a FileInputStream object that loads the confidence file.
     * @param Key Specifies the configuration name as a string.
     * @return Returns the Configuarions worth as a string.
     * @throws java.io.IOException if any.
     */
    public String loadSettingXML(FileInputStream file,String Key) throws IOException
    {
        conf.loadFromXML(file);
        return conf.getProperty(Key);
    }
    
    /**
     * Loads a Properties file as XML.
     *
     * @param file Specifies a File object that loads the confidence file.
     * @param Key Specifies the configuration name as a string.
     * @param Value Specifies the Configuarions worth as a string.
     * @return Returns the Configuarions worth as a string.
     * @throws java.io.IOException if any.
     */
    public String loadSettingXML(File file,String Key,String Value) throws IOException
    {
        conf.loadFromXML(new FileInputStream(file));
        return conf.getProperty(Key,Value);
    }
    
    /**
     * Loads a Properties file as XML.
     *
     * @param file Specifies a File object that loads the confidence file.
     * @param Key Specifies the configuration name as a string.
     * @return Returns the Configuarions worth as a string.
     * @throws java.io.IOException if any.
     */
    public String loadSettingXML(File file,String Key) throws IOException
    {
        conf.loadFromXML(new FileInputStream(file));
        return conf.getProperty(Key);
    }
    
    /**
     * Sets a configurations file to those that specify contains keys and values.
     *
     * @param file Defines the input file as FileOutputStream to which is written.
     * @param Key Specifies the configuration name as a string.
     * @param Value Specifies the Configuarions worth as a string.
     * @param Coment Specifies a Comment for the Configurations file.
     * @param save Indicates whether the file is saved or not. True or false.
     * @throws java.io.IOException if any.
     */
    public void saveSetting(FileOutputStream file, String Key, String Value, String Coment,boolean save) throws IOException
    {
        conf.setProperty(Key, Value);
        if (save == true)
        {
            conf.store(file, Value);
        }
    }
    
    /**
     * Sets a configurations file to those that specify contains keys and values and speares them as XML.
     *
     * @param file Defines the input file as FileOutputStream to which is written.
     * @param Key Specifies the configuration name as a string.
     * @param Value Specifies the Configuarions worth as a string.
     * @param comment Specifies a Comment for the Configurations file.
     * @param save Indicates whether the file is saved or not. True or false.
     * @throws java.io.IOException if any.
     */
    public void saveSettingXML(FileOutputStream file,String Key,String Value,String comment,boolean save) throws IOException
    {
        conf.setProperty(Key, Value);
        if (save == true)
        {
            conf.storeToXML(file, Value);
        }
    }
    
    /**
     * Sets a configurations file to those that specify contains keys and values.
     *
     * @param file Defines the input file as File to which is written.
     * @param Key Specifies the configuration name as a string.
     * @param Value Specifies the Configuarions worth as a string.
     * @param Coment Specifies a Comment for the Configurations file.
     * @param save Indicates whether the file is saved or not. True or false.
     * @throws java.io.IOException if any.
     */
    public void saveSetting(File file, String Key, String Value, String Coment,boolean save) throws IOException
    {
        conf.setProperty(Key, Value);
        if (save == true)
        {
            conf.store(new FileOutputStream(file), Value);
        }
    }
    
    /**
     * Sets a configurations file to those that specify contains keys and values and speares them as XML.
     *
     * @param file Defines the input file as File to which is written.
     * @param Key Specifies the configuration name as a string.
     * @param Value Specifies the Configuarions worth as a string.
     * @param comment Specifies a Comment for the Configurations file.
     * @param save Indicates whether the file is saved or not. True or false.
     * @throws java.io.IOException if any.
     */
    public void saveSettingXML(File file,String Key,String Value,String comment,boolean save) throws IOException
    {
        conf.setProperty(Key, Value);
        if (save == true)
        {
            conf.storeToXML(new FileOutputStream(file), Value);
        }
    }
    
    /**
     * Save the configuration with all vlaues.
     *
     * @param file Defines the input file as File to which is written.
     * @throws java.io.FileNotFoundException
     * @throws java.io.IOException
     */
    public void saveSetting(File file) throws FileNotFoundException, IOException
    {
        this.store(new FileOutputStream(file), "");
    }
    
    /**
     * Save the configuration with all vlaues.
     *
     * @param file Defines the input file as File to which is written.
     * @throws java.io.IOException
     */
    public void saveSetting(FileOutputStream file) throws IOException
    {
        this.store(file, "");
    }
}
