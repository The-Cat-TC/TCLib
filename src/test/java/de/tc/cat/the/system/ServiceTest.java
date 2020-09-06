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
public class ServiceTest {

    public ServiceTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    Service s = new Service("Test", Status.Aktiviert, Option.Run, "This a Test.");

    @Test(groups = "Service")
    public void getName() {

        log("Test for getName method by Service");
        assertEquals("Test", s.getName());
    }

    @Test(groups = "Service")
    public void getOption() {
        log("Test for getOption method by Service");
        assertEquals("Run", s.getOption());
    }

    @Test(groups = "Service")
    public void getStatus() {
        log("Test for getStatus method by Service");
        assertEquals("Aktiviert", s.getStatus());
    }

    @Test(groups = "Service")
    public void isAktiv() {
        log("Test for isAktiv method by Service");
        assertEquals(true, s.isAktiv());
    }

    @Test(groups = "Service")
    public void isRuning() {
        log("Test for isRunning method by Service");
        assertEquals(true, s.isRunning());
    }

    @Test(groups = "Service")
    public void setOption() {
        log("Test for setOption by Service.<br>");
        log("Current Option is Run.<br>");
        assertEquals("Run", s.getOption());
        log("Set Option to Stop.<br>");
        s.setOption(Option.Stop);
        log("Current Option is Stop.<br>");
        assertEquals("Stop", s.getOption());
    }

    @Test(groups = "Service")
    public void setStatus() {
        log("Test for setStatus by Service.<br>");
        log("Current Status is Aktiviert.<br>");
        assertEquals("Aktiviert", s.getStatus());
        log("Set Status to Deaktiviert.<br>");
        s.setStatus(Status.Deaktiviert);
        log("Current Status is Deaktiviert.<br>");
        assertEquals("Deaktiviert", s.getStatus());
    }

    @Test(groups = "Service")
    public void addServiceListener() {
        log("This test is for the Eventhandling for the Service Class.<br>");
        log("Current Option is " + s.getOption() + ".<br>");
        log("Current Status is " + s.getStatus() + ".<br>");
        s.addSystemListener(new ServiceListener() {
            public void onStart(String e) {
                onStartEvent(e);
            }

            public void onStop(String e) {
                onStopEvent(e);
            }

            public void onEnable(String e) {
                onEnableEvent(e);
            }

            public void onDisable(String e) {
                onDisableEvent(e);
            }
        });
        log("The event test is successful if<br>"
                + "onStart<br>onStop<br>onEnable<br>onDisable<br>"
                + "dive in the log.");
    }
    
    @Parameters({"e"})
    @Test(groups="Service")
    public void onStartEvent(String e)
    {
        log("Test the onStart Event by Service.<br>");
        assertEquals(s.getName(), e);
    }
    
    @Parameters({"e"})
    @Test(groups="Service")
    public void onStopEvent(String e)
    {
        log("Test the onStop Event by Service.<br>");
        assertEquals(s.getName(), e);
    }
    
    @Parameters({"e"})
    @Test(groups="Service")
    public void onEnableEvent(String e)
    {
        log("Test the onEnable Event by Service.<br>");
        assertEquals(s.getName(), e);
    }
    
    @Parameters({"e"})
    @Test(groups="Service")
    public void onDisableEvent(String e)
    {
        log("Test the onDisable Event by Service.<br>");
        assertEquals(s.getName(), e);
    }

}
