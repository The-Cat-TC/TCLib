package de.tc.cat.the.test.exception;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Exception {


    @Test
    public void Test() {
        assertEquals("a","a");
    }

    @Test
    public void b() {
        assertEquals("C", "C");
    }
}