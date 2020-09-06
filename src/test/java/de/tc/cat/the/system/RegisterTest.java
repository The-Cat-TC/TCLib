package de.tc.cat.the.system;

import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class RegisterTest {

    private final Register reg = new Register();
    private final Service s1 = new Service("A", Status.Aktiviert, Option.Run, "This is a Test 1.");
    private final Service s2 = new Service("B", Status.Aktiviert, Option.Run, "This is a Test 2.");
    private final Device d1 = new Device("C", Status.Aktiviert, Category.Printer);
    private final Device d2 = new Device("D", Status.Aktiviert, Category.Network);
    private final Service[] services = new Service[]{s1, s2};
    private final Device[] devices = new Device[]{d1, d2};


    public RegisterTest() throws IOException {
    }


    @Test(groups = "Register")
    public void addDevice() {
        try {
            assertEquals(reg.addDevice(d1), true);
            assertEquals(reg.addDevice(d2), true);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test(groups = "Register")
    public void addService() {
        try {
            assertEquals(reg.addService(s1), true);
            assertEquals(reg.addService(s2), true);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test(groups = "Register")
    public void isExists() {
        assertTrue(reg.isExists(d1));
        assertTrue(reg.isExists(s1));
        assertTrue(reg.isExists(d2));
        assertTrue(reg.isExists(s2));
    }

    @Test(groups = "Register")
    public void getDevices() {
        assertEquals(reg.getDevices().length, 2);
    }

    @Test(groups = "Register")
    public void getServices() {
        assertEquals(reg.getServices().length, 2);
    }


    @Test(groups = "Register")
    public void removeDevice() {
        assertEquals(reg.removeDevice(d1), true);
        assertEquals(reg.removeDevice(d2), true);
    }

    @Test(groups = "Register")
    public void removeService() {
        assertEquals(reg.removeService(s1), true);
        assertEquals(reg.removeService(s2), true);
    }
}