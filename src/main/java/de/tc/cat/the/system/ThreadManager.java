package de.tc.cat.the.system;

import de.tc.cat.the.exception.ThreadNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * The <code> ThreadManager </code> is a class that enables the grouping and management of several threads.
 */
public class ThreadManager {
    private final List<Thread> thread = new ArrayList<Thread>();

    /**
     * Adds a thread to the class.
     * @param th Specifies the thread to be added.
     */
    public void addThread(Thread th) {
        thread.add(th);
    }

    /**
     * Removes a thread from the class.
     * @param th Specifies the thread to be removed.
     * @return Returns true if the thread was removed successfully.
     */
    public boolean removeThread(Thread th) {
        return thread.remove(th);
    }

    /**
     * Manage the Therads in the class.
     * @param th Specifies the thread to be administered.
     * @return Returns the selected thread.
     * @throws ThreadNotFoundException Raised when the thread does not exist.
     */
    public Thread threadManager(Thread th) throws ThreadNotFoundException {
        for (Thread thread1 : thread) {
            if (thread1 == th) {
                return thread1;
            } else {
                continue;
            }
        }
        throw new ThreadNotFoundException(th);
    }

    /**
     * Returns an array of threads in the thread class.
     * @return An array of threads.
     */
    public Thread[] getThreads() {
        if (thread.isEmpty()) {
            throw new NullPointerException("No threads found.");
        }
        return thread.toArray(new Thread[thread.size()]);
    }


}
