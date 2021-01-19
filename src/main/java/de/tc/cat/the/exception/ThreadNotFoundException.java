package de.tc.cat.the.exception;

/**
 * Throws a {@code ThreadNotFoundException }.
 * @author Christian Trostmann
 * @version 1.1
 * @since 15
 */
public class ThreadNotFoundException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 7022936701114437762L;

	/**
     * Triggers the {@code Thread NotFoundException } and transfers a message to it.
     * @param th The thread that raised the exception.
     */
    public ThreadNotFoundException(Thread th) {
        super("The thread: " + th.getName() + " was not found.");
    }
}
