/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.tc.cat.the.util;

import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

/**
 *This is a modified form of the JFileChooser class.
 *
 * @see javax.swing.JFileChooser
 * @author Christian Trostmann
 * @version $Id: $Id
 * @see java.awt.Component
 * @see java.awt.Container
 * @see java.awt.image.ImageObserver
 * @see java.awt.MenuContainer
 * @see java.io.Serializable
 * @see javax.accessibility.Accessible
 * @see javax.swing.JComponent
 * @see javax.swing.JFileChooser
 * @see javax.swing.TransferHandler.HasGetTransferHandler
 * @see javax.swing.filechooser.FileSystemView
 */
@SuppressWarnings("exports")
public class JFileChooser extends javax.swing.JFileChooser{
    FileSystemView fsv = null;
    public JFileChooser (JFileSystemView fileSystemView) {
        fsv = fileSystemView;
        this.setFileSystemView(fsv);
    }
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

    /**
     * Gets the current FileSystemView.
     * @return Returns the current FileSystemView.
     */
    public FileSystemView getFsv() {
        return fsv;
    }

    /**
     * Specifies a FileSystemView.
     * @param fsv gives the FileSystemView to be taken.
     */
    public void setFsv(FileSystemView fsv) {
        this.fsv = fsv;
        this.setFileSystemView(fsv);
    }
}
