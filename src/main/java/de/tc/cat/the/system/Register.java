package de.tc.cat.the.system;

import de.tc.cat.the.util.Configuration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Registers classes of type device and service to have them at a central location.
 * In addition, they provide methods and functions for reading out services and devices.
 *
 * @author Christian Trostmann
 * @version 1.0
 * @since 14
 */
public class Register {
    private final List<Service> listService = new ArrayList<>();
    private final List<Device> listDevice = new ArrayList<>();
    private final Configuration conf = new Configuration();
    private final String sep = Seperator.fileseperator();
    private final File homePath = new File(System.getProperty("user.home") + sep + ".TC" + sep);
    private final String servicePath = homePath + sep + "services" + sep;
    private final String devicesPath = homePath + sep + "devices" + sep;
    File services = new File(servicePath);
    File devices = new File(devicesPath);

    /**
     * <p>Constructor for Register.</p>
     *
     * @throws java.io.IOException if any.
     */
    public Register() throws IOException {
        if (!services.exists()) {
            services.mkdirs();
        }

        if (!devices.exists()) {
            devices.mkdirs();
        }

        for (File f : services.listFiles()) {
            String name = conf.loadSetting(f, "Name");
            String description = conf.loadSetting(f, "Description");
            String status = conf.loadSetting(f, "Status");
            String option = conf.loadSetting(f, "Option");

            Service s = new Service(name, Status.valueOf(status), Option.valueOf(option), description);
            addService(s);
        }

        for (File f : devices.listFiles()) {
            String name = conf.loadSetting(f, "Name");
            String status = conf.loadSetting(f, "Status");
            String category = conf.loadSetting(f, "Category");

            Device d = new Device(name, Status.valueOf(status), Category.valueOf(category));
            addDevice(d);
        }

    }

    private boolean isServiceExists(String name) {
        boolean service = false;
        for (Service s : listService) {
            if (s.getName().equals(name)) {
                service = true;
                break;
            } else {
                service = false;
            }
        }
        return service;
    }

    private boolean isDeviceExists(String name) {
        boolean device = false;
        for (Device d : listDevice) {
            if (d.getName().equals(name)) {
                device = true;
                break;
            } else {
                device = false;
            }
        }
        return device;
    }

    /**
     * Checks whether a service or a device is available.
     *
     * @param service Specifies the service to be checked.
     * @return Returns true if the service exists.
     */
    public boolean isExists(Service service) {
        return isServiceExists(service.getName());
    }

    /**
     * Checks whether a service or a device is available.
     *
     * @param device Specifies the device to be checked.
     * @return Returns true if the device exists.
     */
    public boolean isExists(Device device) {
        return isDeviceExists(device.getName());
    }

    /**
     * Deletes a service from the registry.
     *
     * @param service Specifies the service to be deleted.
     * @return Returns true if the service was successfully removed from the registry.
     */
    public boolean removeService(Service service) {
        if (isServiceExists(service.getName())) {
            listService.remove(service.getName());
            new File(servicePath + service.getName() + ".tcconfig").deleteOnExit();
            return true;
        } else {
            return false;
        }

    }

    /**
     * Deletes a device from the registry.
     *
     * @param device Specifies the device to be deleted.
     * @return Returns true if the device was successfully removed from the registry.
     */
    public boolean removeDevice(Device device) {
        if (isDeviceExists(device.getName())) {
            listDevice.remove(device.getName());
            new File(devicesPath + device.getName() + ".tcconfig").deleteOnExit();
            return true;
        } else {
            return false;
        }
    }

    /**
     * Adds a service to the register.
     *
     * @param service The service to add
     * @return Returns true if the service was successfully registered.
     * @throws java.io.IOException if any.
     */
    public boolean addService(Service service) throws IOException {
        if (isServiceExists(service.getName())) {
            return false;
        } else {
            listService.add(service);
            String name = service.getName();
            String status = service.getStatus();
            String option = service.getOption();
            String description = service.getDescription();

            File f = new File(servicePath + sep + name + ".tcconfig");

            conf.saveSetting(f, "Name", name, name, false);
            conf.saveSetting(f, "Status", status, null, false);
            conf.saveSetting(f, "Description", description, null, false);
            conf.saveSetting(f, "Option", option, null, true);
            return true;
        }
    }

    /**
     * Adds a device to the register.
     *
     * @param device The device to add
     * @return Returns true if the device was successfully registered.
     * @throws java.io.IOException if any.
     */
    public boolean addDevice(Device device) throws IOException {
        if (isDeviceExists(device.getName())) {
            return false;
        } else {
            listDevice.add(device);
            String name = device.getName();
            String status = device.getStatus();
            String category = device.getCategory();
            File f = new File(devicesPath + sep + name + ".tcconfig");

            conf.saveSetting(f, "Name", name, name, false);
            conf.saveSetting(f, "Category", category, null, false);
            conf.saveSetting(f, "Status", status, null, true);
            return true;
        }
    }

    /**
     * Outputs all registered services.
     *
     * @return Outputs an array of services.
     */
    public Service[] getServices() {
        return listService.toArray(new Service[listService.size()]);
    }

    /**
     * Outputs all registered devices.
     *
     * @return Outputs an array of devices.
     */
    public Device[] getDevices() {
        return listDevice.toArray(new Device[listDevice.size()]);
    }

    /**
     * Changes the status of the service to Enabled or disabled.
     *
     * @param service Specifies the service to be changed.
     * @param status  Specifies the states to which the service can take turns on or off.
     * @throws java.io.IOException if any.
     */
    public void setConfiguration(Service service, Status status) throws IOException {
        Configuration conf = new Configuration(new Properties());
        File f = new File(servicePath + sep + service.getName() + ".tcconfig");
        conf.saveSetting(f, "Status", status.name(), "", true);
    }

    /**
     * Changes the status of the service to Enabled or disabled.
     *
     * @param service Specifies the services to be changed.
     * @param status  Specifies the states to which the service can take turns on or off.
     * @throws java.io.IOException if any.
     */
    public void setConfiguration(Service[] service, Status status) throws IOException {
        Configuration conf = new Configuration(new Properties());
        for (Service s : service) {
            File f = new File(servicePath + sep + s.getName() + ".tcconfig");
            conf.saveSetting(f, "Status", status.name(), "", true);
        }
    }

    /**
     * Changes the option for the service to stop or run.
     *
     * @param service Specifies the service to be changed.
     * @param option  Specifies the states to which the service can take run or
     * @throws java.io.IOException if any.
     */
    public void setConfiguration(Service service, Option option) throws IOException {
        Configuration conf = new Configuration(new Properties());
        File f = new File(servicePath + sep + service.getName() + ".tcconfig");
        conf.saveSetting(f, "Option", option.name(), "", true);
    }

    /**
     * Changes the option for the service to stop or run.
     *
     * @param service Specifies the services to be changed.
     * @param option  Specifies the states to which the service can take run or
     * @throws java.io.IOException if any.
     */
    public void setConfiguration(Service[] service, Option option) throws IOException {
        Configuration conf = new Configuration(new Properties());
        for (Service s : service) {
            File f = new File(servicePath + sep + s.getName() + ".tcconfig");
            conf.saveSetting(f, "Option", option.name(), "", true);
        }
    }

    /**
     * Changes the status of the device to Enabled or disabled.
     *
     * @param device Specifies the device to be changed.
     * @param status Specifies the states to which the device can take turns on or off.
     * @throws java.io.IOException if any.
     */
    public void setConfiguration(Device device, Status status) throws IOException {
        Configuration conf = new Configuration(new Properties());
        File f = new File(devicesPath + sep + device.getName() + ".tcconfig");
        conf.saveSetting(f, "Status", status.name(), "", true);
    }

    /**
     * Changes the status of the device to Enabled or disabled.
     *
     * @param device Specifies the devices to be changed.
     * @param status Specifies the states to which the device can take turns on or off.
     * @throws java.io.IOException if any.
     */
    public void setConfiguration(Device[] device, Status status) throws IOException {
        Configuration conf = new Configuration(new Properties());
        for (Device s : device) {
            File f = new File(devicesPath + sep + s.getName() + ".tcconfig");
            conf.saveSetting(f, "Status", status.name(), "", true);
        }
    }
}
