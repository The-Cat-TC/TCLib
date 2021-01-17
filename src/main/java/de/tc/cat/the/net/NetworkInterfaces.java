package de.tc.cat.the.net;

import de.tc.cat.the.exception.DeviceException;
import de.tc.cat.the.interfaces.OnDisableListener;
import de.tc.cat.the.system.Category;
import de.tc.cat.the.system.Device;
import de.tc.cat.the.system.Seperator;
import de.tc.cat.the.system.Status;
import de.tc.cat.the.util.FileRead;
import de.tc.cat.the.util.FileWrite;

import java.io.File;
import java.io.IOException;

/**
 * The <code> NetworkInterfaces </code> class represents a network interface.
 * It inherits from the class {@link de.tc.cat.the.system.Device} and also makes its functions available.
 * The <code> NetworkInterfaces </code> class creates a temporary file that is written to and read from.
 * Two functions of the class {@link de.tc.cat.the.system.Device} are supported but are not of use,
 * that is setCategory and setStatus.
 * Both functions have a fixed value.
 *
 * @author Christian Trostmann
 * @version 1.0
 * @see de.tc.cat.the.system.Device
 * @since 15
 */
public class NetworkInterfaces extends Device {
    private final String sep = Seperator.fileseperator();
    private final String path = System.getProperty("user.home" + sep + ".TC");
    private int i = 0;
    private File f = new File(path + "interface." + i);

    /**
     * Create a new network interface
     * @param name Specifies the name of the network interface.
     * @param description Specifies the description of the network interfaces.
     * @throws DeviceException Is triggered if there is a problem with the DEvice Class.
     * @throws IOException Is triggered when there is an IO error.
     */
    public NetworkInterfaces(String name, String description) throws DeviceException, IOException {
        super(name, Status.Aktiviert, Category.Interfaces, description);
        listener();
    }

    /**
     * Writes data to the network interface.
     *
     * @param input the data to be written.
     * @throws IOException is triggered when there are missing in the class.
     * @see de.tc.cat.the.util.FileWrite
     */
    public void write(String input) throws IOException {
        listener();
        FileWrite fw = new FileWrite();
        while (f.exists()) {
            i++;
            f = new File(path + "interface." + i);
        }
        fw.write(input, f);
        i = 0;
    }

    /**
     * Retrieves the data that has been written and delete the file after.
     *
     * @return returns the most recently written data as a string.
     * @throws IOException is triggered when there are missing in the class.
     * @see de.tc.cat.the.util.FileRead
     */
    public String read() throws IOException {
        listener();
        FileRead fr = new FileRead();
        String output = fr.read(f);
        f.deleteOnExit();
        return output;
    }

    private void listener() throws IOException {
        setCategory(Category.Interfaces);
        this.addDisableListener(new OnDisableListener() {
            @Override
            public void onDisable(String e) {
                try {
                    setStatus(Status.Aktiviert);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
    }
}
