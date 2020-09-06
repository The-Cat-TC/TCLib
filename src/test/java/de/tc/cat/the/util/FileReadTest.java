package de.tc.cat.the.util;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;
import static org.testng.Reporter.log;

public class FileReadTest {
    FileRead fr = new FileRead();

    @BeforeMethod
    public void init() {
        FileWrite fw = new FileWrite();
        fw.write("Test", new File("Test.txt"));
    }

    @Test(groups = "FileRead")
    public void read() {
        try {
            log("Check the FileRead class the read method.");
            String s = fr.read(new File("Test.txt")).trim();
            assertEquals(s, "Test", "Text not found");
        } catch (IOException e) {
            fail("IOException by FileRead.read", e);
        }
    }

    @AfterMethod
    public void postinit() {
        File f = new File("Test.txt");
        f.delete();
    }
}
