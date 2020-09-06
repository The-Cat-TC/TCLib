package de.tc.cat.the.util;

import de.tc.cat.the.extension.FileTypeExtension;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.File;

import static org.testng.Assert.assertEquals;
import static org.testng.Reporter.log;

public class FileWriteTest {
    FileWrite fw = new FileWrite();

    @Test(groups = "FileWrite")
    public void writeFile() {
        log("Check the FileWrite class the write method with a text and a File name.");
        assertEquals(fw.write("Test", new File("Test1.txt")), true);
    }

    @Test(groups = "FileWrite")
    public void writeFileWithPattern() {
        log("Check the FileWrite class the write method with a text and a path and a extension.");
        assertEquals(fw.write("Test", "Test2", "txt"), true);
    }

    @Test(groups = "FileWrite")
    public void writeFileWithExtensionFilter() {
        log("Check the FileWrite class the write method with a text and a path and with a FileNameExtension.");
        assertEquals(fw.write("Test", "Test3", FileTypeExtension.Textfile), true);
    }

    @AfterClass
    public void preinit() {
        File f = new File("Test1.txt");
        assertEquals(f.exists(), true);
        f.delete();
        f = new File("Test2.txt");
        assertEquals(f.exists(), true);
        f.delete();
        f = new File("Test3.txt");
        assertEquals(f.exists(), true);
        f.delete();
    }
}
