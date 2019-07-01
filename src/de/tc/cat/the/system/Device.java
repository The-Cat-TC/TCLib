/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.tc.cat.the.system;

/**
 *
 * @author Christian Trostmann
 * @version 1.0
 * @since 1.8
 */
public class Device {
    private String name;
    private String status;
    
    /**
     * Creates a new device.
     * @param dname Specifies the name of the device.
     * @param dstatus Sets the status of the device.
     */
    public Device (String dname, Status dstatus)
    {
        name = dname;
        status = dstatus.name();
    }
    
    /**
     * Gets the name of the device.
     * @return Returns the name of the device as a string.
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Gets the status of the device.
     * @return Returns the status of the device as a string.
     */
    public String getStatus()
    {
        return status;
    }
    
    /**
     * Check if the device is activated.
     * @return Returns True As Boolean if the device is enabled.
     */
    public boolean isAktiv()
    {
        return "Aktiviert".equals(status);
    }
    
    /**
     * Sets the status of the device.
     * @param dstatus The status that the device should have. Enabled or disabled.
     */
    public void setStatus(Status dstatus)
    {
        status = dstatus.name();
    }
    
    /**
     * Sets the name of the device
     * @param dname The name that the device should have.
     */
    public void setName(String dname)
    {
        name = dname;
    }
    
    
}
