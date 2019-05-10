/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.tc.cat.the.system;

/**
 * Help Class to determine the Current Operating System and your Version.
 * @author Christian Trostmann
 * @since 1.8
 * @version 1.0
 */
public enum OS {
    /**
     * The Enum Windows
     */
    WINDOWS,
    /**
     * The Enum Linux
     */
    UNIX,
    /**
     * The Enum Unknown
     */
    POSIX_UNIX,
    /**
     * The Enum Mac
     */
    MAC,
    /**
     * The Enum Other
     */
    OTHER,;
    private String version;

    /**
     * Is used to read out the Operating System version that is Installed.
     * @return Returns the Version as a String.
     */
    public String getVersion() {
        return version;
    }
    
    /**
     * Sat the Operating System Version
     * @param version Specifies the Version as a String.
     */
    public void setVersion(String version) {
        this.version = version;
    }
    
}
