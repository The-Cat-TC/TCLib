/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.tc.cat.the.system;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents a simplified time to retrieve date and clock time by European format.
 *
 * @author Christian Trostmann
 * @version 1.0
 * @since 1.8
 */
public class Time {
    private static final LocalDateTime ldt = LocalDateTime.now();
    private static DateTimeFormatter dft;

    /**
     * Requers time.
     *
     * @return Returns time as a string.
     */
    public static String getTime() {
        dft = DateTimeFormatter.ofPattern("kk:mm:ss");
        return ldt.format(dft);
    }

    /**
     * Simplifies retrieving the date.
     *
     * @return Returns the date as a string.
     */
    public static String getDate() {
        dft = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return ldt.format(dft);
    }
}
