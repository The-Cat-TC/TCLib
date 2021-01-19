package de.tc.cat.the.interfaces;

/**
 * The {@codeOnRunningListener} makes all methods available for the {@codeOnRunningListener}.
 *
 * @author Christian Trostmann
 * @version 1.0
 * @since 15
 */
public interface OnRunningListener {
    /**
     * Makes the onRunningListener available for the {@link de.tc.cat.the.system.Service} class.
     *
     * @param e The name of the process that is being executed.
     */
    void onRunning(String e);
}
