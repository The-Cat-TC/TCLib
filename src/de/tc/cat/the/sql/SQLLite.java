/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.tc.cat.the.sql;

import java.sql.*;
/**
 *This class is used to create and connect an SQLite database.
 * @version  1.0
 * @since  1.8
 * @author Christian Trostmann
 * @see <a href="https://bitbucket.org/xerial/sqlite-jdbc/downloads/">JDBC Driver for SQLite Download</a>
 */
public class SQLLite {
    /**
     * This feature creates an SQLite database.
     * @param path The path where the database should be stored.
     * @param name The name is what the database file should be called.
     */
    public void createNewDatebase(String path, String name)
    {
        String url = "jdbc:sqlite:" + path + name + ".db";
        
        try (Connection conn = DriverManager.getConnection(url))
        {
            if (conn !=null)
            {
            }
        }
        catch (SQLException e)
        {
            System.err.print(e.getMessage() + "\n");
        }
    }
    
    /**
     * 
     * @param path The path where the database should be stored.
     * @param name The name is what the database file should be called.
     * @return Returns a connection.
     */
    public Connection connectetDatebase(String path, String name)
    {
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:" + path + name + ".db";
            conn = DriverManager.getConnection(url);
        }
        catch (SQLException e)
        {
            System.err.print(e.getMessage() + "\n");
        }
        return conn;
    }
    
    /**
     * Create a table in an SQLite database.
     * @param path The path where the database should be stored.
     * @param name The name is what the database file should be called.
     * @param sql Here comes the SQL code purely to run.
     */
    public void createTabel(String path, String name, String sql)
    {
        String url = "jdbc:sqlite:" + path + name + ".db";
        try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement())
        {
            stmt.execute(sql);
        }
        catch ( SQLException e)
        {
            System.err.print(e.getMessage() + "\n");
        }
    }
}
