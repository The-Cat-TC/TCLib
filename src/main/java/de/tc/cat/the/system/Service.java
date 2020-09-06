/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.tc.cat.the.system;

import de.tc.cat.the.exception.ServiceNotFoundException;
import de.tc.cat.the.util.Configuration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Creates a virtual service.
 *
 * @author Christian Trostmann
 * @version 1.8
 * @since 1.8
 */
@SuppressWarnings("ALL")
public class Service {

    private static Configuration conf = new Configuration();
    private final List<ServiceListener> onSystemListener = new ArrayList<>();
    private static String sep = Seperator.fileseperator();
    private static String home = System.getProperty("user.home") + sep + ".TC" + sep + "services";
    private static String sname;


    /**
     * Creates a service using the service class.
     *
     * @param name        Specifies the name of the service.
     * @param status      Indicates the status of the service, whether it is enabled or disabled.
     * @param option      Specifies the option of the service whether it is running or stopped.
     * @param description Specifies the description of the service.
     */
    public Service(String name, Status status, Option option, String description) throws IOException {
        File f = new File(home);

        if (!f.exists()) {
            f.mkdirs();
        }


        File file = new File(home + sep + name + ".tcs");
        sname = name;
        if (!file.exists()) {
            conf.saveSetting(file, "Name", name, "", false);
            conf.saveSetting(file, "Status", status.name(), "", false);
            conf.saveSetting(file, "Option", option.name(), "", false);
            conf.saveSetting(file, "Description", description, "", true);
        }


        if ("Aktiviert".equals(status)) {
            onEnableEvent();
        } else if ("Deaktiviert".equals(status)) {
            onDisableEvent();
        }

        if ("Aktiviert".equals(status)) {
            onEnableEvent();
        } else if ("Deaktiviert".equals(status)) {
            onDisableEvent();
        }
    }

    /**
     * Creates a service using the service class.
     *
     * @param name   Specifies the name of the service.
     * @param status Indicates the status of the service, whether it is enabled or disabled.
     * @param option Specifies the option of the service whether it is running or stopped.
     */
    public Service(String name, Status status, Option option) throws IOException {
        File f = new File(home);

        if (!f.exists()) {
            f.mkdirs();
        }

        File file = new File(home + sep + name + ".tcs");
        sname = name;
        if (!file.exists()) {
            conf.saveSetting(file, "Name", name, "", false);
            conf.saveSetting(file, "Status", status.name(), "", false);
            conf.saveSetting(file, "Option", option.name(), "", false);
            conf.saveSetting(file, "Description", "", "", true);
        }


        if ("Aktiviert".equals(status)) {
            onEnableEvent();
        } else if ("Deaktiviert".equals(status)) {
            onDisableEvent();
        }

        if ("Aktiviert".equals(status)) {
            onEnableEvent();
        } else if ("Deaktiviert".equals(status)) {
            onDisableEvent();
        }
    }

    /**
     * Outputs all services that were created with the service class.
     *
     * @return Returns an array from the registered services.
     */
    public static Service[] getServices() throws IOException {
        List<Service> sList = new ArrayList<>();
        File f = new File(home + sep);
        for (File v : f.listFiles()) {
            if (v.getName().endsWith(".tcs") && v.isFile() && !v.isDirectory()) {
                String name = conf.loadSetting(new File(home + sep + sname + ".tcs"), "Name");
                String status = conf.loadSetting(new File(home + sep + sname + ".tcs"), "Status");
                String option = conf.loadSetting(new File(home + sep + sname + ".tcs"), "Option");
                String description = conf.loadSetting(new File(home + sep + sname + ".tcs"), "Description");
                sList.add(new Service(name, Status.valueOf(status), Option.valueOf(option), description));
            } else {
                continue;
            }
        }
        if (sList.isEmpty()) {
            return null;
        } else {
            return sList.toArray(new Service[sList.size()]);
        }
    }

    /**
     * Deletes all registries services.
     */
    public static void removeSevices() {
        File v = new File(home);
        for (File f : v.listFiles()) {
            f.deleteOnExit();
        }
    }

    /**
     * Issues the option that the service has.
     *
     * @return Return the option of service as a string.
     */
    public String getOption() throws IOException {
        return conf.loadSetting(new File(home + sep + sname + ".tcs"), "Option");
    }

    /**
     * Changes the option for the service to stop or run.
     *
     * @param soption Specifies the states to which the service can take run or
     *                stop.
     */
    public void setOption(Option soption) throws IOException {
        String option = conf.loadSetting(new File(home + sep + sname + ".tcs"), "Option");
        conf.saveSetting(new File(home + sep + sname + ".tcs"), "Option", soption.name(), "", true);
        if (option.equals("Run") || isAktiv() == true) {
            onStartEvent();
        } else if (option.equals("Stop") || isAktiv() == true) {
            onStopEvent();
        }

    }

    /**
     * Get the status.
     *
     * @return Returns the status as a string.
     */
    public String getStatus() throws IOException {
        return conf.loadSetting(new File(home + sep + sname + ".tcs"), "Status");
    }

    /**
     * Changes the status of the service to Enabled or disabled.
     *
     * @param sstatus Specifies the states to which the service can take turns on or off.
     */
    public void setStatus(Status sstatus) throws IOException {
        String status = conf.loadSetting(new File(home + sep + sname + ".tcs"), "Status");
        conf.saveSetting(new File(home + sep + sname + ".tcs"), "Status", sstatus.name(), "", true);
        if ("Aktiviert".equals(status)) {
            onEnableEvent();
        } else if ("Deaktiviert".equals(status)) {
            onDisableEvent();
        }

    }

    /**
     * Get the name.
     *
     * @return Returns the name as a string.
     */
    public String getName() throws IOException {
        return conf.loadSetting(new File(home + sep + sname + ".tcs"), "Name");
    }

    /**
     * Change the name of the service.
     *
     * @param name the new name of the service.
     */
    public void setName(String name) throws IOException {
        String oldname = sname;
        conf.saveSetting(new File(home + sep + sname + ".tcs"), "Name", name, "", true);
        File f = new File(home + sep + oldname + ".tcs");
        f.renameTo(new File(home + sep + name + ".tcs"));
        f.deleteOnExit();
    }

    /**
     * Gets the description of the service.
     *
     * @return Returns the description of the service as a string.
     */
    public String getDescription() throws IOException {
        return conf.loadSetting(new File(home + sep + sname + ".tcs"), "Description");
    }

    /**
     * Changes the description of the service.
     *
     * @param sdescription Specifies the text that is displayed as the description.
     */
    public void setDescription(String sdescription) throws IOException {
        conf.saveSetting(new File(home + sep + sname + ".tcs"), "Description", sdescription, "", true);
    }

    /**
     * Get out if the service is enabled.
     *
     * @return Returns the status as a Boolean.
     */
    public boolean isAktiv() throws IOException {
        return "Aktiviert".equals(conf.loadSetting(new File(home + sep + sname + ".tcs"), "Status"));
    }

    /**
     * Get out if the service is running.
     *
     * @return Returns the status of the service as a Boolean.
     */
    public boolean isRunning() throws IOException {
        return "Run".equals(conf.loadSetting(new File(home + sep + sname + ".tcs"), "Option"));
    }

    /**
     * Adds an EventListener class to the Service class.
     *
     * @param listener Defines the listener from the type ServiceListener.
     */
    public void addSystemListener(ServiceListener listener) {
        onSystemListener.add(listener);
    }

    /**
     * Removes the Service class from an EventListener.
     *
     * @param listener Defines the listener from the type ServiceListener.
     */
    public void removeSystemListener(ServiceListener listener) {
        onSystemListener.remove(listener);
    }

    public boolean isServiceExists(Service service) throws IOException {
        File f = new File(home + sep + service.getName() + ".tcs");
        return f.exists();
    }

    /**
     * Deletes a regestrite service.
     *
     * @param name The name of the service to be deleted.
     * @return Returns true if the service was successfully deleted.
     */
    public synchronized boolean removeService(String name) throws ServiceNotFoundException, IOException {
        File f = new File(home + sep + name + ".tcs");
        f.createNewFile();
        if (!f.exists()) {
            throw new ServiceNotFoundException(name);
        }
        f.deleteOnExit();
        return true;
    }

    /*All Private functions an methos for this class.
    Do not delete or change any methods or functions in this area.*/
    private void onStopEvent() {
        onSystemListener.forEach(ServiceListener -> {
            try {
                ServiceListener.onStop(this.sname);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void onStartEvent() {
        onSystemListener.forEach(ServiceListener -> {
            try {
                ServiceListener.onStart(this.sname);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void onEnableEvent() {
        onSystemListener.forEach(ServiceListener -> {
            try {
                ServiceListener.onEnable(this.sname);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void onDisableEvent() {
        onSystemListener.forEach(ServiceListener -> {
            try {
                ServiceListener.onDisable(this.sname);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
