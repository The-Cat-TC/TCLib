package de.tc.cat.the.system;

import de.tc.cat.the.exception.ThreadNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class ThreadManager {
    private final List<Thread> thread = new ArrayList<Thread>();

    /**
     * @param th
     */
    public void addThread(Thread th) {
        thread.add(th);
    }

    /**
     * @param th
     * @return
     */
    public boolean removeThread(Thread th) {
        return thread.remove(th);
    }

    /**
     * @param th
     * @return
     * @throws ThreadNotFoundException
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
     * @return
     */
    public Thread[] getThreads() {
        if (thread.isEmpty()) {
            throw new NullPointerException("No threads found.");
        }
        return thread.toArray(new Thread[thread.size()]);
    }


}
