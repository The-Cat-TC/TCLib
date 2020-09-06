package de.tc.cat.the.exception;

/**
 * Is triggered if a service was not found.
 *
 * @author Christian Trostmann
 * @version 1.0
 * @see java.io.Serializable
 * @see java.lang.Exception
 * @see java.lang.Throwable
 * @since 14
 */
public class ServiceNotFoundException extends Exception {

    /**
     * Creates a new instance of <code>ServiceNotFoundException</code> with detail
     * message.
     *
     * @param msg The name of the service that was not found.
     */
    public ServiceNotFoundException(String msg) {
        super("The service " + msg + " does not exist.");
    }
}
