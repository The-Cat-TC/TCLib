package de.tc.cat.the.exception;

/**
 * <code> DeviceException </code> is an exception that is executed by the device class or derived classes.
 * @since 14
 * @version 3.0
 * @author Christian Trostmann
 */
public class DeviceException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = -2137851641817519346L;

	/**
	 * Throws the DeviceException and sends a message.
	 * @param msg Contains the exception text.
	 */
	public DeviceException(String msg) {
        super(msg);
    }
}
