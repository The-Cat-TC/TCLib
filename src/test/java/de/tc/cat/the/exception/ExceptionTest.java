package de.tc.cat.the.exception;

import org.testng.annotations.Test;

import static org.testng.Assert.ThrowingRunnable;
import static org.testng.Assert.assertThrows;
import static org.testng.Reporter.log;

public class ExceptionTest {
    @Test(groups = "Exception")
    public void FileTypeException() {
        log("Check the FileTypeException.");
        assertThrows(FileTypeException.class, new ThrowingRunnable() {
            @Override
            public void run() throws Throwable {
                throw new FileTypeException();
            }
        });
    }

    @Test(groups = "Exception")
    public void ServiceNotFoundException() {
        log("Check the ServiceNotFoundException");
        assertThrows(ServiceNotFoundException.class, new ThrowingRunnable() {
            @Override
            public void run() throws Throwable {
                throw new ServiceNotFoundException("Test");
            }
        });
    }

    @Test(groups = "Exception")
    public void DeviceNotFoundException() {
        log("Check the DeviceNotFoundException");
        assertThrows(DeviceNotFoundException.class, new ThrowingRunnable() {
            @Override
            public void run() throws Throwable {
                throw new DeviceNotFoundException("Test");
            }
        });
    }
}
