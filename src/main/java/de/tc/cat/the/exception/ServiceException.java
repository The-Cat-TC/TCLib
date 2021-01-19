package de.tc.cat.the.exception;

/**
 * Throws a {@code service exception }.
 * @author Christian Trostmann
 * @version 3.0
 * @since 14
 */
public class ServiceException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = -3360506467137030347L;

	/**
	 * Throws the {@code ServiceException } and transfers a message to it.
	 * @param msg Returns the message that is in the exception.
	 */
	public ServiceException(String msg) {
        super(msg);
    }
}
