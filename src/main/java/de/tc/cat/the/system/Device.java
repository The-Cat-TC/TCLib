/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.tc.cat.the.system;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Device class.</p>
 *
 * @author Christian Trostmann
 * @version 1.7
 * @since 1.8
 */
public class Device {
    private String name;
    private String status;
    private String category;
    private final List<DeviceListener> onSystemListener = new ArrayList<>();

    /**
     * Creates a device using the device class.
     *
     * @param dname     Specifies the name of the device.
     * @param dstatus   Sets the status of the device.
     * @param dcategory Indicates the category of the device.
     */
    public Device(String dname, Status dstatus, Category dcategory) {
        name = dname;
        status = dstatus.name();
        category = dcategory.name();
        if ("Aktiviert".equals(status)) {
            onEnableEvent();
        } else if ("Deaktiviert".equals(status)) {
            onDisableEvent();
        }
    }
    
    /**
     * Gets the name of the device.
     *
     * @return Returns the name of the device as a string.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Gets the status of the device.
     *
     * @return Returns the status of the device as a string.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Reads out the category of the device.
     *
     * @return Returns the category of the device.
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets the category of the device.
     *
     * @param dcategroy Indicates the category of the device.
     */
    public void setCategory(Category dcategroy) {
        category = dcategroy.name();
    }

    /**
     * Sets the status of the device.
     *
     * @param dstatus The status that the device should have. Enabled or disabled.
     */
    public void setStatus(Status dstatus)
    {
        status = dstatus.name();
        if ("Aktiviert".equals(status)) {
            onEnableEvent();
        } else if ("Deaktiviert".equals(status)) {
            onDisableEvent();
        }
    }

    /**
     * Check if the device is activated.
     *
     * @return Returns True As Boolean if the device is enabled.
     */
    public boolean isAktiv() {
        return "Aktiviert".equals(status);
    }

    /**
     * Sets the name of the device
     *
     * @param dname The name that the device should have.
     */
    public void setName(String dname) {
        name = dname;
    }

    /**
     * Adds an EventListener class to the Device class.
     *
     * @param listener Defines the listener from the type DeviceListener.
     */
    public void addSystemListener(DeviceListener listener) {
        onSystemListener.add(listener);
    }
    
    /**
     * Removes the Device class from an EventListener.
     *
     * @param listener Defines the listener from the type DeviceListener.
     */
    public void removeSystemListener(DeviceListener listener)
    {
        onSystemListener.remove(listener);
    }


    private void onEnableEvent()
    {
        onSystemListener.forEach(DeviceListener -> DeviceListener.onEnable(this.name));
    }
    
    private void onDisableEvent()
    {
        onSystemListener.forEach(DeviceListener -> DeviceListener.onDisable(this.name));
    }
}
