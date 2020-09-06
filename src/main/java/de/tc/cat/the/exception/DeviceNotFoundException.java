package de.tc.cat.the.exception;

/**
 * Is triggered if a device was not found.
 *
 * @author Christian Trostmann
 * @version 1.0
 * @see java.io.Serializable
 * @see java.lang.Exception
 * @see java.lang.Throwable
 * @since 14
 */
public class DeviceNotFoundException extends Exception {

    /**
     * Creates a new instance of <code>DeviceNotFoundException</code> with detail
     * message.
     *
     * @param msg The name of the device that was not found.
     */
    public DeviceNotFoundException(String msg) {
        super("The device " + msg + " does not exist.");
    }
}
