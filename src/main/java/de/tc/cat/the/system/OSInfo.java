/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.tc.cat.the.system;

/**
 * Reads which operating System grade is used from and is used to use Platform speziefiche Functions or to create an Operating System.
 *
 * @author Christian Trostmann
 * @version 1.1
 * @since 1.8
 */
public class OSInfo {
    /**
     * Retrieves information about the operating system.
     *
     * @return Based on the information, indicates the operating system that is being used.
     */
    public static String OS() {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")) {
            //Betriebssystem ist Windows-basiert
            return "Windows";
        } else if (os.contains("osx")) {
            //Betriebssystem ist Apple OSX
            return "Mac";
        } else if (os.contains("nix") || os.contains("aix") || os.contains("nux")) {
            //Betriebssystem ist Linux/Unix basiert
            return "Linux";
        } else {
            return "Unknow";
        }
    }
}
