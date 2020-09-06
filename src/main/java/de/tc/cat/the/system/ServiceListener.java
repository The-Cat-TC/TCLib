/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.tc.cat.the.system;

/**
 * Provides all the methods required by the service class to handle an event.
 *
 * @author Christian Trostmann
 * @since 1.8
 * @version 1.0
 */
public interface ServiceListener {
    /**
     * Dispatched when a service is started.
     *
     * @param e Specifies the name of the service.
     */
    void onStart(String e);
    /**
     * Dispatched when a service is stopped.
     *
     * @param e Specifies the name of the service.
     */
    void onStop (String e);
    /**
     * Dispatched when a service is activated.
     *
     * @param e Specifies the name of the service.
     */
    void onEnable (String e);
    /**
     * Dispatched when a service is disabled.
     *
     * @param e Specifies the name of the service.
     */
    void onDisable (String e);
}