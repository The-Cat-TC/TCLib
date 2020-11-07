package de.tc.cat.the.test.system;

import de.tc.cat.the.exception.DeviceException;
import de.tc.cat.the.system.Category;
import de.tc.cat.the.system.Status;

import java.io.IOException;

import static org.testng.Assert.*;

public class Device {
    private de.tc.cat.the.system.Device d;

    public Device() {
        assertThrows(Exception.class, new ThrowingRunnable() {
            @Override
            public void run() throws Throwable {
                try {
                    d = new de.tc.cat.the.system.Device("Test", Status.Aktiviert, Category.Audio, "Test Description");
                } catch (DeviceException e) {
                    fail("DeviceException on Run", e);
                } catch (IOException e) {
                    fail("IOException on run", e);
                }
            }
        });
    }

    public void getCategory() {
        assertEquals("Audio", d.getCategory());
    }

    public void getName() {
        assertEquals("Test", d.getName());
    }
}
