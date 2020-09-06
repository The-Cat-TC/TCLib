/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.tc.cat.the.system;

import java.io.IOException;

/**
 * Provides all the methods required by the device class to handle an event.
 *
 * @author Christian Trostmann
 * @version 1.0
 * @since 1.8
 */
public interface DeviceListener {
    /**
     * Dispatched when a device is activated.
     *
     * @param e Specifies the name of the device.
     */
    void onEnable(String e) throws IOException;

    /**
     * Dispatched when a device is disabled.
     *
     * @param e Specifies the name of the device.
     */
    void onDisable(String e) throws IOException;
}
