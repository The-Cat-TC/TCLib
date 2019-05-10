/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.tc.cat.the.util;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * The ResourceBundle Class specifies methods to output Internationalized Files.
 * @author Christian Trostmann
 * @since 1.8
 * @version 1.0
 */
public class ResourcenBundle {
    /**
     * The bundle method provides a Resource File to be given with the Current Language or an Chosen language.
     * @param res The Resource to use.
     * @param key Gives the Key to read out.
     * @return Returns the Key of the Resources file As a String.
     */
    public static String bundle(String res,String key)
    {
            ResourceBundle rb = ResourceBundle.getBundle(res);
            return rb.getString(key);
    }
    
    /**
     * The bundle method provides a Resource File to be given with the Current Language or an Chosen language.
     * @param res The Resource to use.
     * @param local Admit the Current Language to use.
     * @param key Gives the Key to read out.
     * @return Returns the Key of the Resources file As a String.
     */
    public static String bundle(String res,Locale local,String key)
    {
            ResourceBundle rb = ResourceBundle.getBundle(res,local);
            return rb.getString(key);
    }
}
