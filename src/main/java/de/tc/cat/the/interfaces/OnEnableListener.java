package de.tc.cat.the.interfaces;

/**
 * The {@codeOnEnableListener} makes all methods available for the {@codeOnEnableListener}.
 *
 * @author Christian Trostmann
 * @version 1.0
 * @since 15
 */
public interface OnEnableListener {
    /**
     * Makes the onEnableListener available for the {@link de.tc.cat.the.system.Service}
     * and {@link de.tc.cat.the.system.Device} class.
     *
     * @param e The name of the process that is being executed.
     */
    void onEnable(String e);
}
