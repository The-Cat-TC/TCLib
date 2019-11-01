/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.tc.cat.the.system;

import java.text.DateFormat;
import java.util.GregorianCalendar;

/**
 * Represents a simplified time to retrieve date and clock time by European format.
 *
 * @version 1.0
 * @since  1.8
 * @author Christian Trostmann
 */
public class Time {
    private static final GregorianCalendar now = new GregorianCalendar(); 
    private static final DateFormat time = DateFormat.getTimeInstance(DateFormat.MEDIUM);
    private static final DateFormat date = DateFormat.getDateInstance(DateFormat.MEDIUM);
    
    /**
     * Requers time.
     *
     * @return Returns time as a string.
     */
    public static String getTime()
    {
        return time.format(now.getTime());
    }
    /**
     * Simplifies retrieving the date.
     *
     * @return Returns the date as a string.
     */
    public static String getDate()
    {
        return date.format(now.getTime());
    }
}
