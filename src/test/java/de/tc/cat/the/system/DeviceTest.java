/*
 * Copyright (C) 2020 the-c
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package de.tc.cat.the.system;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Reporter.log;

/**
 *
 * @author the-c
 */
public class DeviceTest {

    Device d = new Device("Test", Status.Aktiviert, Category.Network);

    @Test(groups = "Device")
    public void getName() {
        log("Test for the getName method by Device.");
        assertEquals("Test", d.getName());
    }

    @Test(groups = "Device")
    public void getStatus() {
        log("Test for the getStatus method by Device.");
        assertEquals("Aktiviert", d.getStatus());
    }

    @Test(groups = "Device")
    public void isAktiv() {
        log("Test for the isAktiv method by Device.");
        assertEquals(true, d.isAktiv());
    }

    @Test(groups = "Device")
    public void setStatus() {
        log("Test for the setStatus method by Device.<br>");
        log("Current Status is Aktiviert");
        assertEquals("Aktiviert", d.getStatus());
        log("Set Status of Deaktiviert.<br>");
        d.setStatus(Status.Deaktiviert);
        assertEquals("Deaktiviert", d.getStatus());
    }

    @Test(groups = "Device")
    public void addDeviceListener() {
        log("This test is for the Eventhandling for the Device Class.<br>");
        log("Current Status is " + d.getStatus() + ".<br>");
        d.addSystemListener(new DeviceListener() {
            public void onEnable(String e) {
                onEnableEvent(e);
            }
            public void onDisable(String e) {
                onDisableEvent(e);
            }
        });
        log("The event test is successful if<br>"
                + "onEnable<br>onDisable<br>"
                + "dive in the log.");
    }

    @Parameters({"e"})
    @Test(groups = "Device")
    public void onEnableEvent(String e) {
        log("Test the onEnable Event by Device.<br>");
        assertEquals(d.getName(), e);
    }

    @Parameters({"e"})
    @Test(groups = "Device")
    public void onDisableEvent(String e) {
        log("Test the onDisable Event by Device.<br>");
        assertEquals(d.getName(), e);
    }
}
