/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.tc.cat.the.system;

/**
 *
 * @author Christian Trostmann
 * @version  1.0
 * @since  1.8
 */
public class Seperator {
    
    /**
     * Sets the line separator that is used on the operating system on which the program is running.
     * @return Returns the line seperator as a string.
     */
    public static final String lineseperator()
    {
        return System.getProperty("line.separator");
    }
    
    /**
     * Sets the path seperator used on the operating system on which the program is running.
     * @return Returns the path seperator as a string.
     */
    public static final String pathseperator()
    {
        return System.getProperty("path.seperator");
    }
    
    /**
     * Sets the file seperator used on the operating system on which the application is running.
     * @return Returns the file seperator as a string.
     */
    public static final String fileseperator()
    {
        return System.getProperty("file.separator");
    }
}
