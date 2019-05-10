/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.tc.cat.the.system;

import java.io.IOException;
import java.util.List;

/**
 * Führt Externe Anwendungen oder Kommandos aus die auf dem Betriebsystem laufen. Kann mit oder auch ohne Argumente genutzt werden.
 * @author Christina Trostmann
 * @since 1.8
 * @version 1.0
 */
public class RunApplication {
    /**
     * Execute a program with arguments.
     * @param Command Performs a command with several arguments requires a string Arraya as a parameter.
     * @throws IOException 
     */
    public static void exec(String[] Command) throws IOException
    {
        new ProcessBuilder(Command).start();
    }
    /**
     * Execute a program with arguments.
     * @param Command Performs a command with several arguments requires a ruse of the type string as a parameter.
     * @throws IOException If the program or command could not be started.
     */
    public static void exec(List<String> Command) throws IOException
    {
        new ProcessBuilder(Command).start();
    }
    /**
     * Execute a program with not arguments.
     * @param Command The program/command to be carried out
     * @throws IOException If the program or command could not be started.
     */
    public static void exec(String Command) throws IOException
    {
        new ProcessBuilder(Command).start();
    }
}
