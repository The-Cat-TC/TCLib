/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.tc.cat.the.system;

import de.tc.cat.the.exception.DeviceException;
import de.tc.cat.the.interfaces.OnDisableListener;
import de.tc.cat.the.interfaces.OnEnableListener;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * The {@codeDevice} class is used to create
 * a virtual device that is saved as a config file.
 * These can be used in other Java programs.
 * The created devices can also be used across programs.
 *
 * @author Christian Trostmann
 * @version 1.8
 * @since 1.8
 */
public class Device {
    private static String sep = Seperator.fileseperator();
    private static String home = System.getProperty("user.home") + sep + ".TC" + sep + "devices";
    private String name;
    private String category;
    private String status;
    private String description;
    private File device;
    private static File home2;
    private static Properties prop = new Properties();
    private final List<OnDisableListener> onDisableListenerList = new ArrayList<OnDisableListener>();
    private final List<OnEnableListener> onEnableListenerList = new ArrayList<OnEnableListener>();

    /**
     * Creates the device and transfers the start values ​​to it.
     * @param name Specifies the name of the device.
     * @param status Indicates the status of the device (activated or deactivated).
     * @param category Specifies the category of the device.
     * @param description Specifies the description of the device.
     * @throws DeviceException Is triggered when an error occurs in the device class.
     * @throws IOException Is triggered if there is an IO error.
     */
    public Device(String name, Status status, Category category, String description) throws DeviceException, IOException {
        this.name = name;
        this.status = status.name();
        this.category = category.name();
        this.description = description;
        init();
        event();
    }

    /**
     * Creates the device and transfers the start values ​​to it.
     * @param name Specifies the name of the device.
     * @param status Indicates the status of the device (activated or deactivated).
     * @param category Specifies the category of the device.
     * @throws DeviceException Is triggered when an error occurs in the device class.
     * @throws IOException Is triggered if there is an IO error.
     */
    public Device(String name, Status status, Category category) throws DeviceException, IOException {
        this.name = name;
        this.status = status.name();
        this.category = category.name();
        this.description = "";
        init();
        event();
    }

    /**
     * Lists all registers in which the device files are checked.
     * @return Returns all found devices as an array.
     * @throws DeviceException Is triggered when an error occurs in the device class.
     * @throws IOException Is triggered if there is an IO error.
     */
    public static Device[] getDevices() throws DeviceException, IOException {
        List<Device> DeviceList = new ArrayList<Device>();
        for (File file : home2.listFiles()) {
            prop.loadFromXML(new FileInputStream(file));
            Device d = new Device(prop.getProperty("name"),
                    Status.valueOf(prop.getProperty("status")),
                    Category.valueOf(prop.getProperty("category")),
                    prop.getProperty("description"));
            DeviceList.add(d);
        }
        return DeviceList.toArray(Device[]::new);
    }

    /**
     * Gets the current description of the device.
     *
     * @return Returns the description as a string.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Changes the description of the device.
     *
     * @param description Specifies the new description of the device.
     * @throws IOException Is triggered if there is an IO error.
     */
    public void setDescription(String description) throws IOException {
        this.description = description;
        create();
        load();
    }

    /**
     * Gets the current state of the category.
     *
     * @return Returns the current state of the category as a string.
     */
    public String getCategory() {
        return category;
    }

    /**
     * Changes the category of the device.
     *
     * @param category Specifies the device's new category.
     * @throws IOException Is triggered if there is an IO error.
     */
    public void setCategory(Category category) throws IOException {
        this.category = category.name();
        create();
        event();
        load();
    }

    /**
     * Gets the current state of the status.
     *
     * @return Returns the current state of the status as a string.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Changes the status of the device.
     *
     * @param status Specifies the status of the device.
     * @throws IOException Is triggered if there is an IO error.
     */
    public void setStatus(Status status) throws IOException {
        this.status = status.name();
        create();
        event();
        load();
    }

    /**
     * Gets the current name of the device.
     *
     * @return Returns the name of the device as a string.
     */
    public String getName() {
        return name;
    }

    /**
     * Changes the name of the device.
     *
     * @param name Specifies the new name of the device.
     * @throws IOException Is triggered if there is an IO error.
     */
    public void setName(String name) throws IOException {
        this.name = name;
        delete();
        device = new File(home + sep + this.name + ".tcd");
        device.createNewFile();
        create();
        load();
    }

    /**
     * Deletes the device and the associated device file.
     */
    public void delete() {
        device.deleteOnExit();
    }

    /**
     * Checks whether the device is activated or deactivated.
     *
     * @return Returns true if the device is activated.
     */
    public boolean isActiv() {
        return status.equals(Status.Aktiviert.name());
    }

    /**
     * Adds the device to the {@link de.tc.cat.the.interfaces.OnEnableListener}.
     *
     * @param listener Specifies the {@link de.tc.cat.the.interfaces.OnEnableListener} interface.
     */
    public void addEnableListener(OnEnableListener listener) {
        onEnableListenerList.add(listener);
    }

    /**
     * Adds the device to the {@link de.tc.cat.the.interfaces.OnDisableListener}.
     *
     * @param listener Specifies the {@link de.tc.cat.the.interfaces.OnDisableListener} interface.
     */
    public void addDisableListener(OnDisableListener listener) {
        onDisableListenerList.add(listener);
    }

    /**
     * Removes the {@link de.tc.cat.the.interfaces.OnEnableListener} from the list.
     *
     * @param listener Specifies the {@link de.tc.cat.the.interfaces.OnEnableListener} interface.
     */
    public void removeEnableListener(OnEnableListener listener) {
        onEnableListenerList.remove(listener);
    }

    /**
     * Removes the {@link de.tc.cat.the.interfaces.OnDisableListener} from the list.
     *
     * @param listener Specifies the {@link de.tc.cat.the.interfaces.OnDisableListener} interface.
     */
    public void removeDisableListener(OnDisableListener listener) {
        onDisableListenerList.remove(listener);
    }

    /*
    This is the private block.
    This block controls the entire class functions.
    Changes in this area can render the class unusable.
     */
    private void event() {
        if (isActiv()) {
            onEnableEvent();
        } else {
            onDisableEvent();
        }
    }

    private boolean checkStatus() {
        if (status.equals(Status.Aktiviert.name())) {
            return true;
        } else if (status.equals(Status.Deaktiviert.name())) {
            return true;
        } else {
            return false;
        }
    }

    @SuppressWarnings("static-access")
	private void init() throws DeviceException, IOException {
        if (!checkStatus()) {
            throw new DeviceException("The status " + this.status + " is not a valid status.");
        }
        File home1 = new File(home);
        File device = new File(home + sep + this.name + ".tcd");
        this.device = device;
        this.home2 = home1;
        if (!home1.exists()) {
            home1.mkdirs();
        }
        if (device.exists()) {
            load();
        } else {
            device.createNewFile();
            create();
        }
    }

    private void create() throws IOException {
        prop.setProperty("name", this.name);
        prop.setProperty("status", this.status);
        prop.setProperty("category", this.category);
        prop.setProperty("description", this.description);
        prop.storeToXML(new ObjectOutputStream(new FileOutputStream(device)), "");
    }

    private void load() throws IOException {
        prop.loadFromXML(new FileInputStream(device));
        this.name = prop.getProperty("name");
        this.status = prop.getProperty("status");
        this.category = prop.getProperty("category");
        this.description = prop.getProperty("description");
    }

    private void onEnableEvent() {
        onEnableListenerList.forEach(onEnableListenerListener -> {
            onEnableListenerListener.onEnable(this.name);
        });
    }

    private void onDisableEvent() {
        onDisableListenerList.forEach(onDisableListenerList -> {
            onDisableListenerList.onDisable(this.name);
        });
    }
}
