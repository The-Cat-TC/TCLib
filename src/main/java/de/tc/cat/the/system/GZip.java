/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.tc.cat.the.system;

import de.tc.cat.the.exception.FileTypeException;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * A class for packing and gzip archives.
 *
 * @version 1.0
 * @since 1.8
 * @author Christian Trostmann
 */
public class GZip {

    /**
     * Pakes multiple files in one folder to a gzip archive.
     *
     * @param args Gives an array of files to pack to.
     * @throws java.io.FileNotFoundException if any.
     * @throws java.io.IOException if any.
     */
    public void packen(File[] args) throws FileNotFoundException, IOException {
        @SuppressWarnings("UnusedAssignment")
        int read = 0;
        byte[] data = new byte[1024];
        // Jeden �bergebenen Dateinamen bearbeiten
        for (File arg : args) {
            // Original-Datei mit Stream verbinden
            File f = new File(arg.getAbsolutePath());
            GZIPOutputStream out;
            // Ausgabedatei erstellen
            try (FileInputStream in = new FileInputStream(f)) {
                // Ausgabedatei erstellen
                out = new GZIPOutputStream(new FileOutputStream(f.getName() + ".gz"));
                // Alle Daten der Original-Datei in die Ausgabedatei schreiben
                while ((read = in.read(data, 0, 1024)) != -1) {

                    out.write(data, 0, read);
                }
            }
            out.close();

            f.delete();   // Original-Datei l�schen
        }
    }

    /**
     * Paket a file in one folder to a gzip archiv.
     *
     * @param args Give a files to pack.
     * @throws java.io.FileNotFoundException if any.
     * @throws java.io.IOException           if any.
     */
    public static void packen(File args) throws FileNotFoundException, IOException {
        @SuppressWarnings("UnusedAssignment")
        var read = 0;
        var data = new byte[1024];
        // Original-Datei mit Stream verbinden
        var f = new File(args.getAbsolutePath());
        GZIPOutputStream out;
        // Ausgabedatei erstellen
        try (var in = new FileInputStream(f)) {
            // Ausgabedatei erstellen
            out = new GZIPOutputStream(new FileOutputStream(f.getName() + ".gz"));
            // Alle Daten der Original-Datei in die Ausgabedatei schreiben
            while ((read = in.read(data, 0, 1024)) != -1) {
                out.write(data, 0, read);
            }
        }
        out.close();
        f.delete();
// Original-Datei entfernen
    }

    /**
     * Paket a file in one folder to a gzip archiv.
     *
     * @param args Give a files to pack.
     * @param name Gives the name of the gzip archive to be created. Here to
     * note that the name and path must be entered.
     * @throws java.io.IOException if any.
     */
    public static void packen(File args, String name) throws IOException {
        @SuppressWarnings("UnusedAssignment")
        var read = 0;
        var data = new byte[1024];
        // Original-Datei mit Stream verbinden
        var f = new File(args.getAbsolutePath());
        GZIPOutputStream out;
        // Ausgabedatei erstellen
        try (var in = new FileInputStream(f)) {
            // Ausgabedatei erstellen
            out = new GZIPOutputStream(new FileOutputStream(name + ".gz"));
            // Alle Daten der Original-Datei in die Ausgabedatei schreiben
            while ((read = in.read(data, 0, 1024)) != -1) {
                out.write(data, 0, read);
            }
        }
        out.close();
        // Original-Datei entfernen
        f.delete();
    }

    /**
     * unpack a gzip file.
     *
     * @param f The file to unpack.
     * @throws java.io.FileNotFoundException if any.
     * @throws java.io.IOException if any.
     * @throws de.tc.cat.the.exception.FileTypeException if any.
     */
    public static void entpacken(File f) throws FileNotFoundException, IOException, FileTypeException {
        @SuppressWarnings("UnusedAssignment")
        var read = 0;
        var data = new byte[1024];
        if (!f.getName().endsWith(".gz")) {
            throw new FileTypeException();
        }

        GZIPInputStream gzis = new GZIPInputStream(new FileInputStream(f));

        try (FileOutputStream fos = new FileOutputStream(f.getName().substring(0, f.getName().lastIndexOf(".") - 1))) {
            while ((read = gzis.read(data, 0, 1024)) != -1) {
                fos.write(data, 0, read);
            }
        }
        f.delete();
    }

    /**
     * unpack a array list to gzip files.
     *
     * @param args the list of files.
     * @throws java.io.FileNotFoundException if any.
     * @throws java.io.IOException if any.
     * @throws de.tc.cat.the.exception.FileTypeException if any.
     */
    public static void entpacken(File[] args) throws FileNotFoundException, IOException, FileTypeException {
        @SuppressWarnings("UnusedAssignment")
        var read = 0;
        var data = new byte[1024];
        for (var f : args) {
            if (!f.getName().endsWith(".gz")) {
                throw new FileTypeException();
            }

            GZIPInputStream gzis = new GZIPInputStream(new FileInputStream(f));

            try (FileOutputStream fos = new FileOutputStream(f.getName().substring(0, f.getName().lastIndexOf(".") - 1))) {
                while ((read = gzis.read(data, 0, 1024)) != -1) {
                    fos.write(data, 0, read);
                }
            }
            f.delete();
        }
    }
}
