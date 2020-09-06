package de.tc.cat.the.exception;

import org.testng.annotations.Test;

import static org.testng.Assert.ThrowingRunnable;
import static org.testng.Assert.assertThrows;

public class FileTypeExceptionTest {
    @Test(groups = "Exception")
    public void exception() {
        assertThrows(FileTypeException.class, new ThrowingRunnable() {
            @Override
            public void run() throws Throwable {
                throw new FileTypeException();
            }
        });
    }
}
