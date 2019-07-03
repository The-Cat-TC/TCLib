/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.tc.cat.the.system;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

/**
 * A class for packing and gzip archives.
 * @version 1.0
 * @since  1.8
 * @author Christian Trostmann
 */
public class GZip {
    /**
     * Pakes multiple files in one folder to a gzip archive.
     * @param args Gives an array of files to pack to.
     * @param name Gives the name of the gzip archive to be created. Here to note that the name and path must be entered.
     */
    public void packen(File[] args, String name)
    {
        @SuppressWarnings("UnusedAssignment")
        int read = 0;
      byte[] data = new byte[1024];
        // Jeden übergebenen Dateinamen bearbeiten
        for (File arg : args) {
            try {
                // Original-Datei mit Stream verbinden
                File f = new File(arg.getAbsolutePath());
                GZIPOutputStream out;
                // Ausgabedatei erstellen
                try (FileInputStream in = new FileInputStream(f)) {
                    // Ausgabedatei erstellen
                    out = new GZIPOutputStream(new FileOutputStream(name + ".gz"));
                    // Alle Daten der Original-Datei in die Ausgabedatei schreiben
                    while((read = in.read(data, 0, 1024)) != -1) {
                        out.write(data, 0, read);
                    }
                }
                out.close();
                f.delete();   // Original-Datei löschen
            }catch(IOException e) {
            }
        }
    }
}
