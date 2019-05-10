/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.tc.cat.the.system;

import java.io.IOException;
import java.util.Locale;

/**
 * Reads which operating System grade is used from and is used to use Platform speziefiche Functions or to create an Operating System.
 * @author Christian Trostmann
 * @since 1.8
 * @version 1.0
 */
@SuppressWarnings("StaticNonFinalUsedInInitialization")
public class OSInfo {


    private static OS os = OS.OTHER;
    static {
        try {
            String osName = System.getProperty("os.name");
            if (osName == null) {
                throw new IOException("os.name not found");
            }
            osName = osName.toLowerCase(Locale.ENGLISH);
            if (osName.contains("windows")) {
                os = OS.WINDOWS;
            } else if (osName.contains("linux")
                    || osName.contains("mpe/ix")
                    || osName.contains("freebsd")
                    || osName.contains("irix")
                    || osName.contains("digital unix")
                    || osName.contains("unix")) {
                os = OS.UNIX;
            } else if (osName.contains("mac os")) {
                os = OS.MAC;
            } else if (osName.contains("sun os")
                    || osName.contains("sunos")
                    || osName.contains("solaris")) {
                os = OS.POSIX_UNIX;
            } else if (osName.contains("hp-ux") 
                    || osName.contains("aix")) {
                os = OS.POSIX_UNIX;
            } else {
                os = OS.OTHER;
            }

        } catch (IOException ex) {
            os = OS.OTHER;
        } finally {
            os.setVersion(System.getProperty("os.version"));
        }
    }
    
    /**
     * Issues the Current Operating System on which the Java Application is running.
     * @return Returns the Current Operating System as a String.
     */
    public static OS getOs() {
        return os;
    }
}