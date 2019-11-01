/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.tc.cat.the.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * The FileWrite class provides Functions to write Strings in Files.
 *
 * @author christian Trostmann
 * @since 1.8
 * @version 1.0
 */
public class FileWrite {

    private static String exception = null;

    /**
     * The write Function writes a String into a File.
     *
     * @param text The Text to be written into the File.
     * @param f The File in which the Text is to be written.
     * @return Gives a Boolean worth back. True when the DAtei was written
     * successfully false if an Error arose in writing.
     */
    public boolean write(String text, File f) {
        PrintWriter pWriter = null;
        try {
            var fw = new FileWriter(f.getAbsoluteFile());
            if (fw == null) {
                return false;
            }
            pWriter = new PrintWriter(new BufferedWriter(fw));
            pWriter.println(text);
        } catch (IOException ioe) {
            exception = ioe.getLocalizedMessage();
            return false;

        } finally {
            if (pWriter != null) {
                pWriter.flush();
                pWriter.close();
            }
        }
        return true;
    }

    /**
     * The write Function writes a String into a File.
     *
     * @param text The Text to be written into the File.
     * @param path The File path
     * @param filefilter The FileExtension filter with the String[] for the File
     * Extension.
     * @return Gives a Boolean worth back. True when the DAtei was written
     * successfully false if an Error arose in writing.
     */
    public boolean write(String text, String path, FileNameExtensionFilter filefilter) {
        PrintWriter pWriter = null;
        try {
            var f = new File(path + "." + filefilter.getExtensions()[0]);
            var fw = new FileWriter(f);
            if (fw == null) {
                return false;
            }
            pWriter = new PrintWriter(new BufferedWriter(fw));
            pWriter.println(text);
        } catch (IOException ioe) {
            exception = ioe.getLocalizedMessage();
            return false;

        } finally {
            if (pWriter != null) {
                pWriter.flush();
                pWriter.close();
            }
        }
        return true;
    }

    /**
     * The write Function writes a String into a File.
     *
     * @param text The Text to be written into the File.
     * @param path The File path
     * @param extension The File extension with creat a file.
     * @return Gives a Boolean worth back. True when the DAtei was written
     * successfully false if an Error arose in writing.
     */
    public boolean write(String text, String path, String extension) {
        PrintWriter pWriter = null;
        File f = null;
        try {
            if (extension.isEmpty())
            {
                return false;
            }
            if (extension.contains(".")) {
                f = new File(path + extension);
            } else {
                f = new File(path + "." + extension);
            }
            
            if (f == null)
            {
                return false;
            }
            var fw = new FileWriter(f);
            if (fw == null) {
                return false;
            }
            pWriter = new PrintWriter(new BufferedWriter(fw));
            pWriter.println(text);
        } catch (IOException ioe) {
            exception = ioe.getLocalizedMessage();
            return false;

        } finally {
            if (pWriter != null) {
                pWriter.flush();
                pWriter.close();
            }
        }
        return true;
    }

    /**
     * The write Function writes a String into a File.
     *
     * @param text The Text to be written into the File.
     * @param path The File path
     * @param i The inex of the Extension.
     * @param filefilter The FileExtension filter with the String[] for the File
     * Extension.
     * @return Gives a Boolean worth back. True when the DAtei was written
     * successfully false if an Error arose in writing.
     */
    public boolean write(String text, String path, Integer i, FileNameExtensionFilter filefilter) {
        PrintWriter pWriter = null;
        try {
            var f = new File(path + filefilter.getExtensions()[i]);
            var fw = new FileWriter(f);
            if (fw == null) {
                return false;
            }
            pWriter = new PrintWriter(new BufferedWriter(fw));
            pWriter.println(text);
        } catch (IOException ioe) {
            exception = ioe.getLocalizedMessage();
            return false;

        } finally {
            if (pWriter != null) {
                pWriter.flush();
                pWriter.close();
            }
        }
        return true;
    }

    /**
     * Gives an Exception back so far in the write Function an Exception has
     * been thrown.
     *
     * @return Gives the Exception out of which has been thrown out.
     */
    public String exceptionReturn() {
        if (exception.isEmpty()) {
            return "Not Exception found.";
        } else {
            return exception;
        }
    }

}
