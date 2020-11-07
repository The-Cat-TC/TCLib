package de.tc.cat.the.exception;

/**
 *
 */
public class ThreadNotFoundException extends Exception {
    /**
     * @param th
     */
    public ThreadNotFoundException(Thread th) {
        super("The thread: " + th.getName() + " was not found.");
    }
}
