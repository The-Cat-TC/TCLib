/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.tc.cat.the.util;

import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *This is a modified form of the JFileChooser class.
 * @see javax.swing.JFileChooser
 * @author Christian Trostmann
 */
public class JFileChooser extends javax.swing.JFileChooser{
    /**
     * This is an advanced feature to the FileFilter from the JFileChooser class.
     * @param filter 
     */
    public void setFileFilter(FileNameExtensionFilter filter)
    {
        super.setFileFilter(filter);
    }
    /**
     * This is an add-on function to the getFileFilter 
     * function from the jFilchooser class that allows 
     * you to address the FileNameExtensionFilter.
     * 
     * @return 
     */
    public FileNameExtensionFilter getFileNameExtensionFilter()
    {
        return (FileNameExtensionFilter) super.getFileFilter();
    }
    
    
}
