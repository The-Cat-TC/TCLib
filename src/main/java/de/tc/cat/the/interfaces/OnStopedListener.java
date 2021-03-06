package de.tc.cat.the.interfaces;

/**
 * The {@codeOnStopedListener} makes all methods available for the {@codeOnStopedListener}.
 *
 * @author Christian Trostmann
 * @version 1.0
 * @since 15
 */
public interface OnStopedListener {
    /**
     * Makes the onRunningListener available for the {@link de.tc.cat.the.system.Service} class.
     *
     * @param e The name of the process that is being executed.
     */
    void onStopet(String e);
}
