/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.tc.cat.the.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *The FileRead class is for reading files.
 * @author Christian Trostmann
 * @since 1.8
 * @version 1.0
 */
public class FileRead {
    /**
     * Reads the contents of a file.
     * @param f The file to be read from.
     * @return Returns the contents of the file as a string.
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public String read(File f) throws FileNotFoundException, IOException
    {
        FileReader fr = new FileReader(f);
            char[] c = new char[1024];
            int i = 0;
            while ((i = fr.read(c)) >=0){
                return String.valueOf(c, 0, 1024);
            }
            return "null point";
    }
}
