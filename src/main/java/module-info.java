/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * The TCLib module is the basic structure,
 * here are all functions and classes that are used by all the
 * dependencies of the projects from The Cat.
 */
module de.tc.cat.the.TCLib {
    requires sqlite.jdbc;
    requires java.base;
    requires java.se;
    requires jdk.javadoc;
    requires jdk.jlink;
    requires jdk.jdeps;
    requires jdk.jartool;
    requires jdom2;
    requires JCDP;
    requires org.fusesource.jansi;

    exports de.tc.cat.the.extension;
    exports de.tc.cat.the.sql;
    exports de.tc.cat.the.system;
    exports de.tc.cat.the.util;
    exports de.tc.cat.the.exception;
    exports de.tc.cat.the.interfaces;
    exports de.tc.cat.the.net;
}
