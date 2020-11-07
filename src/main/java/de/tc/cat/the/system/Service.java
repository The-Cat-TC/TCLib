/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.tc.cat.the.system;

import de.tc.cat.the.exception.ServiceException;
import de.tc.cat.the.interfaces.OnDisableListener;
import de.tc.cat.the.interfaces.OnEnableListener;
import de.tc.cat.the.interfaces.OnRunningListener;
import de.tc.cat.the.interfaces.OnStopedListener;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * The <code>Service</code> class is used to create
 * a virtual service that is saved as a config file.
 * These can be used in other Java programs.
 * The created services can also be used across programs.
 *
 * @author Christian Trostmann
 * @version 1.9
 * @since 1.8
 */
public class Service {

    private static String name;
    private static String option;
    private static String status;
    private static String description;
    private static String sep = Seperator.fileseperator();
    private static String home = System.getProperty("user.home") + sep + ".TC" + sep + "services";
    private static File service;
    private static File home2;
    private static Properties prop = new Properties();
    private final List<OnDisableListener> onDisableListenerList = new ArrayList<OnDisableListener>();
    private final List<OnEnableListener> onEnableListenerList = new ArrayList<OnEnableListener>();
    private final List<OnRunningListener> onRunningListenerList = new ArrayList<OnRunningListener>();
    private final List<OnStopedListener> onStopedList = new ArrayList<OnStopedListener>();

    /**
     * Creates the service and transfers the start values ​​to it.
     *
     * @param name        Specifies the name of the service.
     * @param status      Indicates the status of the service (activated or deactivated).
     * @param option      Specifies the option of the service (run or stop).
     * @param description Specifies the description of the service.
     * @throws ServiceException Is triggered when an error occurs in the service class.
     * @throws IOException      Is triggered if there is an IO error.
     */
    public Service(String name, Status status, Option option, String description) throws ServiceException, IOException {
        this.name = name;
        this.status = status.name();
        this.option = option.name();
        this.description = description;
        init();
        event();
    }

    /**
     * Creates the service and transfers the start values ​​to it.
     *
     * @param name   Specifies the name of the service.
     * @param status Indicates the status of the service (activated or deactivated).
     * @param option Specifies the option of the service (run or stop).
     * @throws ServiceException Is triggered when an error occurs in the service class.
     * @throws IOException      Is triggered if there is an IO error.
     */
    public Service(String name, Status status, Option option) throws ServiceException, IOException {
        this.name = name;
        this.status = status.name();
        this.option = option.name();
        this.description = "";
        init();
        event();
    }

    /**
     * Lists all registers in which the service files are checked.
     *
     * @return Returns all found services as an array.
     * @throws ServiceException Is triggered when an error occurs in the service class.
     * @throws IOException      Is triggered if there is an IO error.
     */
    public static Service[] getServices() throws ServiceException, IOException {
        List<Service> serviceList = new ArrayList<Service>();
        for (File file : home2.listFiles()) {
            prop.loadFromXML(new FileInputStream(file));
            Service s = new Service(prop.getProperty("name"),
                    Status.valueOf(prop.getProperty("status")),
                    Option.valueOf(prop.getProperty("option")),
                    prop.getProperty("description"));
            serviceList.add(s);
        }
        return serviceList.toArray(Service[]::new);
    }

    /**
     * Gets the current description of the service.
     *
     * @return Returns the description as a string.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Changes the description of the service.
     *
     * @param description Specifies the new description of the service.
     * @throws IOException Is triggered if there is an IO error.
     */
    public void setDescription(String description) throws IOException {
        Service.description = description;
        create();
        load();
    }

    /**
     * Gets the current state of the option.
     *
     * @return Returns the current state of the option as a string.
     */
    public String getOption() {
        return option;
    }

    /**
     * Changes the option of the service.
     *
     * @param option Specifies the service's new option.
     * @throws IOException Is triggered if there is an IO error.
     */
    public void setOption(Option option) throws IOException {
        Service.option = option.name();
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
     * Changes the status of the service.
     *
     * @param status Specifies the status of the service.
     * @throws IOException Is triggered if there is an IO error.
     */
    public void setStatus(Status status) throws IOException {
        Service.status = status.name();
        create();
        event();
        load();
    }

    /**
     * Gets the current name of the service.
     *
     * @return Returns the name of the service as a string.
     */
    public String getName() {
        return name;
    }

    /**
     * Changes the name of the service.
     *
     * @param name Specifies the new name of the service.
     * @throws IOException Is triggered if there is an IO error.
     */
    public void setName(String name) throws IOException {
        Service.name = name;
        delete();
        service = new File(home + sep + this.name + ".tcs");
        service.createNewFile();
        create();
        load();
    }

    /**
     * Deletes the service and the associated service file.
     */
    public void delete() {
        service.deleteOnExit();
    }

    /**
     * Checks whether the service is activated or deactivated.
     *
     * @return Returns true if the service is activated.
     */
    public boolean isActiv() {
        return status.equals(Status.Aktiviert.name());
    }

    /**
     * Checks whether the service is running or stopped.
     *
     * @return Returns true if the service is running.
     */
    public boolean isRunning() {
        return option.equals(Option.Run.name());
    }

    /**
     * Adds the service to the {@link de.tc.cat.the.interfaces.OnEnableListener}.
     *
     * @param listener Specifies the {@link de.tc.cat.the.interfaces.OnEnableListener} interface.
     */
    public void addEnableListener(OnEnableListener listener) {
        onEnableListenerList.add(listener);
    }

    /**
     * Adds the service to the {@link de.tc.cat.the.interfaces.OnDisableListener}.
     *
     * @param listener Specifies the {@link de.tc.cat.the.interfaces.OnDisableListener} interface.
     */
    public void addDisableListener(OnDisableListener listener) {
        onDisableListenerList.add(listener);
    }

    /**
     * Adds the service to the {@link de.tc.cat.the.interfaces.OnRunningListener}.
     *
     * @param listener Specifies the {@link de.tc.cat.the.interfaces.OnRunningListener} interface.
     */
    public void addRunningListener(OnRunningListener listener) {
        onRunningListenerList.add(listener);
    }

    /**
     * Adds the service to the {@link de.tc.cat.the.interfaces.OnStopedListener}.
     *
     * @param listener Specifies the {@link de.tc.cat.the.interfaces.OnStopedListener} interface.
     */
    public void addStopedListener(OnStopedListener listener) {
        onStopedList.add(listener);
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

    /**
     * Removes the {@link de.tc.cat.the.interfaces.OnRunningListener} from the list.
     *
     * @param listener Specifies the {@link de.tc.cat.the.interfaces.OnRunningListener} interface.
     */
    public void removeRunningListener(OnRunningListener listener) {
        onRunningListenerList.remove(listener);
    }

    /**
     * Removes the {@link de.tc.cat.the.interfaces.OnStopedListener} from the list.
     *
     * @param listener Specifies the {@link de.tc.cat.the.interfaces.OnStopedListener} interface.
     */
    public void removeStopedListener(OnStopedListener listener) {
        onStopedList.remove(listener);
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

        if (isRunning()) {
            onRunningEvent();
        } else {
            onStopedEvent();
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

    private boolean checkOption() {
        if (option.equals(Option.Run.name())) {
            return true;
        } else if (option.equals(Option.Stop.name())) {
            return true;
        } else {
            return false;
        }
    }

    private void init() throws ServiceException, IOException {
        if (!checkOption()) {
            throw new ServiceException("The option " + this.option + " is not a valid option.");
        }
        if (!checkStatus()) {
            throw new ServiceException("The status " + this.status + " is not a valid status.");
        }
        File home1 = new File(home);
        File service = new File(home + sep + this.name + ".tcs");
        this.service = service;
        this.home2 = home1;
        if (!home1.exists()) {
            home1.mkdirs();
        }
        if (service.exists()) {
            load();
        } else {
            service.createNewFile();
            create();
        }
    }

    private void create() throws IOException {
        prop.setProperty("name", this.name);
        prop.setProperty("status", this.status);
        prop.setProperty("option", this.option);
        prop.setProperty("description", this.description);
        prop.storeToXML(new ObjectOutputStream(new FileOutputStream(service)), "");
    }

    private void load() throws IOException {
        prop.loadFromXML(new FileInputStream(service));
        this.name = prop.getProperty("name");
        this.status = prop.getProperty("status");
        this.option = prop.getProperty("option");
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

    private void onRunningEvent() {
        onRunningListenerList.forEach(onRunningListenerList -> {
            onRunningListenerList.onRunning(this.name);
        });
    }

    private void onStopedEvent() {
        onStopedList.forEach(onStopedListenerList -> {
            onStopedListenerList.onStopet(this.name);
        });
    }
}
