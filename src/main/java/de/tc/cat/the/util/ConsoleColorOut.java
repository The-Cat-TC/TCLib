/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.tc.cat.the.util;

import com.diogonunes.jcdp.color.ColoredPrinter;
import com.diogonunes.jcdp.color.api.Ansi;

/**
 * The ConsoleColorOut class provides methods to enable a colored console output.
 *
 * @author Christian Trostmann
 * @version 1.1
 * @since 13
 */
public class ConsoleColorOut {
    
    private static ColoredPrinter console(int loglvl,boolean timestamp, Ansi.FColor foreground,Ansi.BColor background)
    {
        return new ColoredPrinter.Builder(loglvl, timestamp).foreground(foreground).background(background).build();
    }
    
    /**
     * Returns a console output in error.
     *
     * @param msg Specifies the console text.
     */
    public static void printError(String msg)
    {
        console(3, false, Ansi.FColor.RED, Ansi.BColor.BLACK).print(msg);
    }
    
    /**
     * Returns a console output in error with line break.
     *
     * @param msg Specifies the console text.
     */
    public static void printlnError(String msg)
    {
        console(3, false, Ansi.FColor.RED, Ansi.BColor.BLACK).println(msg);
    }
    
    /**
     * Returns a console output in warning.
     *
     * @param msg Specifies the console text.
     */
    public static void printWarning(String msg)
    {
        console(2, false, Ansi.FColor.YELLOW, Ansi.BColor.BLACK).print(msg);
    }
    
    /**
     * Returns a console output in warning with line break.
     *
     * @param msg Specifies the console text.
     */
    public static void printlnWarning(String msg)
    {
        console(2, false, Ansi.FColor.YELLOW, Ansi.BColor.BLACK).println(msg);
    }
    
    /**
     * Returns a console output in info.
     *
     * @param msg Specifies the console text.
     */
    public static void printInfo(String msg)
    {
        console(1, false, Ansi.FColor.WHITE, Ansi.BColor.BLACK).print(msg);
    }
    
    /**
     * Returns a console output in info with line break.
     *
     * @param msg Specifies the console text.
     */
    public static void printlnInfo(String msg)
    {
        console(1, false, Ansi.FColor.WHITE, Ansi.BColor.BLACK).println(msg);
    }
    
    /**
     * Returns a custom console output.
     *
     * @param loglvl Specifies the log level.
     * @param tstamp Enables or disables the timestamp.
     * @param fore Specifies the foreground color.
     * @param back Specifies the background color.
     * @param msg Specifies the console text.
     */
    public static void printCustom(int loglvl,boolean tstamp,Ansi.FColor fore,Ansi.BColor back,String msg)
    {
        console(loglvl, tstamp, fore,back).print(msg);
    }
    
    /**
     * Returns a custom console output with line wrapping.
     *
     * @param loglvl Specifies the log level.
     * @param tstamp Enables or disables the timestamp.
     * @param fore Specifies the foreground color.
     * @param back Specifies the background color.
     * @param msg Specifies the console text.
     */
    public static void printlnCustom(int loglvl, boolean tstamp, Ansi.FColor fore, Ansi.BColor back, String msg) {
        console(loglvl, tstamp, fore, back).println(msg);
    }

    /**
     * Returns a console output in debug.
     *
     * @param msg Specifies the console text.
     */
    public static void printDebug(String msg) {
        console(4, false, Ansi.FColor.MAGENTA, Ansi.BColor.BLACK).print(msg);
    }

    /**
     * Returns a console output in debug with line break.
     *
     * @param msg Specifies the console text.
     */
    public static void printlnDebug(String msg) {
        console(4, false, Ansi.FColor.MAGENTA, Ansi.BColor.BLACK).println(msg);
    }

    /**
     * Returns a console output in unknow.
     *
     * @param msg Specifies the console text.
     */
    public static void printUnknow(String msg) {
        console(5, false, Ansi.FColor.YELLOW, Ansi.BColor.BLACK).print(msg);
    }

    /**
     * Returns a console output in unknow with line break.
     *
     * @param msg Specifies the console text.
     */
    public static void printlnUnknow(String msg) {
        console(5, false, Ansi.FColor.YELLOW, Ansi.BColor.BLACK).println(msg);
    }
}
