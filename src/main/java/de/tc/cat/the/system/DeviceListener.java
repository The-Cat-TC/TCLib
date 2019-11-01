/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.tc.cat.the.system;

/**
 * Provides all the methods required by the device class to handle an event.
 *
 * @author Christian Trostmann
 * @since 1.8
 * @version 1.0
 */
public interface DeviceListener {
    /**
     * Dispatched when a device is activated.
     *
     * @param e Specifies the name of the device.
     */
    void onEnable(String e);
    /**
     * Dispatched when a device is disabled.
     *
     * @param e Specifies the name of the device.
     */
    void onDisable (String e);
}
