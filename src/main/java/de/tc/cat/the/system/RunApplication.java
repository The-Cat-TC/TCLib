/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.tc.cat.the.system;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Performs external applications that have been defined.
 *
 * @author Christina Trostmann
 * @since 1.8
 * @version 1.9
 */
public class RunApplication {

    /**
     * Execute a program with arguments.
     *
     * @param Command Performs a command with several arguments requires a
     * string Arraya as a parameter.
     * @throws java.io.IOException if any.
     */
    public static void exec(String[] Command) throws IOException {
        new ProcessBuilder(Command).start();
    }

    /**
     * Execute a program with arguments.
     *
     * @param Command Performs a command with several arguments requires a ruse
     * of the type string as a parameter.
     * @throws java.io.IOException if any.
     */
    public static void exec(List<String> Command) throws IOException {
        new ProcessBuilder(Command).start();
    }

    /**
     * Execute a program with not arguments.
     *
     * @param Command The program/command to be carried out
     * @throws java.io.IOException if any.
     */
    public static void exec(String Command) throws IOException {
        new ProcessBuilder(Command).start();
    }
    
    /**
     * Execute a program with arguments.
     *
     * @param Command Performs a command with several arguments requires a
     * string Arraya as a parameter.
     * @param dir Specifies the workdirectory.
     * @throws java.io.IOException if any.
     */
    public static void exec(String[] Command, File dir) throws IOException {
        var pb = new ProcessBuilder(Command);
        pb.directory(dir);
        pb.start();
    }

    /**
     * Execute a program with arguments.
     *
     * @param Command Performs a command with several arguments requires a ruse
     * of the type string as a parameter.
     * @param dir Specifies the workdirectory.
     * @throws java.io.IOException if any.
     */
    public static void exec(List<String> Command, File dir) throws IOException {
        var pb = new ProcessBuilder(Command);
        pb.directory(dir);
        pb.start();
    }

    /**
     * Execute a program with not arguments.
     *
     * @param Command The program/command to be carried out
     * @param dir Specifies the workdirectory.
     * @throws java.io.IOException if any.
     */
    public static void exec(String Command, File dir) throws IOException {
        var pb = new ProcessBuilder(Command);
        pb.directory(dir);
        pb.start();
    }
}
