/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.tc.cat.the.util;

import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *This is a modified form of the JFileChooser class.
 *
 * @see javax.swing.JFileChooser
 * @author Christian Trostmann
 * @version $Id: $Id
 */
@SuppressWarnings("exports")
public class JFileChooser extends javax.swing.JFileChooser{
    /**
	 * 
	 */
	private static final long serialVersionUID = -3310691272864413885L;
	/**
     * This is an advanced feature to the FileFilter from the JFileChooser class.
     *
     * @param filter a {@link javax.swing.filechooser.FileNameExtensionFilter} object.
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
     * @return a {@link javax.swing.filechooser.FileNameExtensionFilter} object.
     */
    public FileNameExtensionFilter getFileNameExtensionFilter()
    {
        return (FileNameExtensionFilter) super.getFileFilter();
    }
    
    
}
