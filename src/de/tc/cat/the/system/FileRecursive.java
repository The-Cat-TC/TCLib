/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.tc.cat.the.system;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Christian Trostmann
 * @since 1.8
 * @version 1.0
 */
public class FileRecursive {
    private static final ArrayList<String> listdir = new ArrayList<>();
    private static final ArrayList<String> listfile = new ArrayList<>();
    public FileRecursive(File f)
    {
        listDir(f);
    }
    private static void listDir(File dir) {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    listdir.add(file.getAbsolutePath());
                    listDir(file); // ruft sich selbst mit dem 
                    // Unterverzeichnis als Parameter auf
                } else {
                    listfile.add(file.getAbsolutePath());
                }
            }
        }
    }
    
    /**
     * Lists folders and subfolders from a directory
     * @return Returns the found folders.
     */
    @SuppressWarnings("ReturnOfCollectionOrArrayField")
    public ArrayList<String> dir()
    {
        return listdir;
    }
    /**
     * List files in the directory and subdirectory.
     * @return Returns the found files.
     */
    @SuppressWarnings("ReturnOfCollectionOrArrayField")
    public ArrayList<String> file()
    { 
        return listfile;
    }
}
