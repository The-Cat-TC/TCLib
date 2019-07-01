package de.tc.cat.the.extension;

import javax.swing.filechooser.FileNameExtensionFilter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Christian Trostmann
 * @since 1.8
 * @version 1.4
 */
   public class FileTypeExtension{
    /**
     * The extension the Cat text document (.SSD).
     */
    public static FileNameExtensionFilter TheCatTextdokument = new FileNameExtensionFilter("The Cat Textdokument","ssd");
    
    /**
     * The extension the cat Configurtaions file (.TCCONFIG).
     */
    public static  FileNameExtensionFilter TheCatConfigurationsfile = new FileNameExtensionFilter("The Cat Configurations file","tcconfig");
    
    /**
     * The extension the cat color file (.TCCOLOR).
     */
    public static  FileNameExtensionFilter TheCatColorFile = new FileNameExtensionFilter("The Cat Color File","tccolor");
    
    /**
     * The extension the cat uml file (.TCUML).
     */
    
    public static FileNameExtensionFilter TheCatUMLFile = new FileNameExtensionFilter("The Cat UML File", "tcuml");
    
    /**
     * The extension windows initialization File(.INI).
     */
    public static  FileNameExtensionFilter WindowsInitializationFile = new FileNameExtensionFilter("Windows Initialization File","ini");
    
    /**
     * The extension Setup Infomation File (.INF).
     */
    public static  FileNameExtensionFilter SetupInformationFile = new FileNameExtensionFilter("Setup Information File","inf");
    
    /**
     * The extension Bash Shell Script (.sh).
     */
    public static  FileNameExtensionFilter BashShellScript = new FileNameExtensionFilter("Bash Shell Script","sh");
    
    /**
     * The extension Windows Command File(.cmd).
     */
    public static  FileNameExtensionFilter WindowsCommandFile = new FileNameExtensionFilter("Windows Command File", "cmd" , "bat");
    
    /**
     * The extension htm file(.html).
     */
    public static  FileNameExtensionFilter HTMLFile = new FileNameExtensionFilter("HTML File", "htm", "html");
    
    /**
     * The extension SHTM File(.shtml).
     */
    public static  FileNameExtensionFilter SHTMLFile = new FileNameExtensionFilter("SHTML File", "shtm", "shtml");
    
    /**
     * The extension C Source File(.c).
     */
    public static  FileNameExtensionFilter csource = new FileNameExtensionFilter("C Source", "c");
    
    /**
     * The extension C Header File(.h).
     */
    public static  FileNameExtensionFilter c_Header = new FileNameExtensionFilter("C Header", "h");
    
    /**
     * The extension C++ Source File(.cpp).
     */
    public static  FileNameExtensionFilter cppSource = new FileNameExtensionFilter("C++ Source", "cpp");
    
    /**
     * The extension C++ Header File(.hpp).
     */
    public static  FileNameExtensionFilter cppHeader = new FileNameExtensionFilter("C++ Header", "hpp");
    
    /**
     * The extension Visual Basic Source File(.vb).
     */
    public static  FileNameExtensionFilter VisualBasicSource = new FileNameExtensionFilter("Visaul Basic Source", "vb");
    
    /**
     * The extension Windows Host Script File(.vbs).
     */
    public static  FileNameExtensionFilter vbsFile = new FileNameExtensionFilter("Windows Host Script", "vbs");
    
    /**
     * The extension Java Source File(.java).
     */
    public static  FileNameExtensionFilter Java_Source = new FileNameExtensionFilter("Java Source", "java");
    
    /**
     * The extension Textdocument(.txt).
     */
    public static FileNameExtensionFilter Textfile = new FileNameExtensionFilter("Textdokument", "txt");
 
    /**
     * The extension PlantUML File(.puml).
     */
    public static FileNameExtensionFilter PlantUMLFile = new FileNameExtensionFilter("PlantUML File", "puml");
}
