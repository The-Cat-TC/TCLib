package de.tc.cat.the.interfaces;

/**
 * The <code>OnDisableListener</code> makes all methods available for the <code>OnDisableListener</code>.
 *
 * @author Christian Trostmann
 * @version 1.0
 * @since 15
 */
public interface OnDisableListener {
    /**
     * Makes the onDisableListener available for the {@link de.tc.cat.the.system.Service}
     * and {@link de.tc.cat.the.system.Device} class.
     *
     * @param e The name of the process that is being executed.
     */
    void onDisable(String e);
}
