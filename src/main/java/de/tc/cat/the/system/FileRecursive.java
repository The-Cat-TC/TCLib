/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.tc.cat.the.system;

import java.io.File;
import java.util.ArrayList;

/**
 * <p>FileRecursive class.</p>
 *
 * @author Christian Trostmann
 * @since 1.8
 * @version 1.0
 */
public class FileRecursive {
    private static final ArrayList<String> LISTDIR = new ArrayList<>();
    private static final ArrayList<String> LISTFILE = new ArrayList<>();
    /**
     * <p>Constructor for FileRecursive.</p>
     *
     * @param f a {@link java.io.File} object.
     */
    public FileRecursive(File f)
    {
        listDir(f);
    }
    private static void listDir(File dir) {
        var files = dir.listFiles();
        if (files != null) {
            for (var file : files) {
                if (file.isDirectory()) {
                    LISTDIR.add(file.getAbsolutePath());
                    listDir(file); // ruft sich selbst mit dem 
                    // Unterverzeichnis als Parameter auf
                } else {
                    LISTFILE.add(file.getAbsolutePath());
                }
            }
        }
    }
    
    /**
     * Lists folders and subfolders from a directory
     *
     * @return Returns the found folders.
     */
    @SuppressWarnings("ReturnOfCollectionOrArrayField")
    public ArrayList<String> dir()
    {
        return LISTDIR;
    }
    /**
     * List files in the directory and subdirectory.
     *
     * @return Returns the found files.
     */
    @SuppressWarnings("ReturnOfCollectionOrArrayField")
    public ArrayList<String> file()
    { 
        return LISTFILE;
    }
}
